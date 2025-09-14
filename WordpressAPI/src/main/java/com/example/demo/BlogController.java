package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class BlogController {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/posts/{slug}")
    public ResponseEntity<PostDetailDto> getPost(@PathVariable String slug) {
        String baseUrl = "https://webyayasu.sakura.ne.jp/uthuyomizyuku/wp-json/wp/v2";

        // 記事データ
        BlogDTOs[] posts = restTemplate.getForObject(baseUrl + "/posts?slug=" + slug + "&_embed", BlogDTOs[].class);
        if (posts == null || posts.length == 0) return ResponseEntity.notFound().build();
        BlogDTOs post = posts[0];

        // 著者
        AuthorDto author = restTemplate.getForObject(baseUrl + "/users/" + post.getAuthor(), AuthorDto.class);

        // カテゴリ名
        List<String> categoryNames = post.getCategories().stream()
            .map(catId -> restTemplate.getForObject(baseUrl + "/categories/" + catId, BlogCategoryDto.class).getName())
            .toList();

        // タグ名
        List<String> tagNames = post.getTags().stream()
            .map(tagId -> restTemplate.getForObject(baseUrl + "/tags/" + tagId, TagDto.class).getName())
            .toList();

        // アイキャッチ
        String featuredImage = null;
        if (post.getFeatured_media() != null) {
            MediaDto media = restTemplate.getForObject(baseUrl + "/media/" + post.getFeatured_media(), MediaDto.class);
            featuredImage = media != null ? media.getSource_url() : null;
        }

        // 前後記事
        BlogDTOs prevPost = null, nextPost = null;
        BlogDTOs[] allPosts = restTemplate.getForObject(
            baseUrl + "/posts?categories=" + post.getCategories().get(0) + "&orderby=id&order=asc&per_page=100",
            BlogDTOs[].class
        );
        if (allPosts != null) {
            for (int i = 0; i < allPosts.length; i++) {
                if (allPosts[i].getId().equals(post.getId())) {
                    if (i > 0) prevPost = allPosts[i - 1];
                    if (i < allPosts.length - 1) nextPost = allPosts[i + 1];
                }
            }
        }

        // 結果まとめて返す
        return ResponseEntity.ok(new PostDetailDto(post, author, categoryNames, tagNames, featuredImage, prevPost, nextPost));
    }
    
    @GetMapping("/posts")
    public ResponseEntity<List<Map<String, String>>> getAllPosts() {
        String baseUrl = "https://webyayasu.sakura.ne.jp/uthuyomizyuku/wp-json/wp/v2";
        BlogDTOs[] posts = restTemplate.getForObject(baseUrl + "/posts?per_page=100", BlogDTOs[].class);
        if (posts == null) return ResponseEntity.notFound().build();

        // slug だけ返す（Next.js で使いやすい形）
        List<Map<String, String>> result = Arrays.stream(posts)
            .map(p -> Map.of("slug", p.getSlug()))
            .toList();

        return ResponseEntity.ok(result);
    }
}
