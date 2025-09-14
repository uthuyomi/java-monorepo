package com.example.demo;

import java.util.List;

// 記事本体
public class BlogDTOs {
    private Long id;
    private String slug;
    private Rendered title;
    private Rendered content;
    private String date;
    private Long author;
    private List<Long> categories;
    private List<Long> tags;
    private Long featured_media;

    public static class Rendered {
        private String rendered;
        public String getRendered() { return rendered; }
        public void setRendered(String rendered) { this.rendered = rendered; }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public Rendered getTitle() { return title; }
    public void setTitle(Rendered title) { this.title = title; }

    public Rendered getContent() { return content; }
    public void setContent(Rendered content) { this.content = content; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Long getAuthor() { return author; }
    public void setAuthor(Long author) { this.author = author; }

    public List<Long> getCategories() { return categories; }
    public void setCategories(List<Long> categories) { this.categories = categories; }

    public List<Long> getTags() { return tags; }
    public void setTags(List<Long> tags) { this.tags = tags; }

    public Long getFeatured_media() { return featured_media; }
    public void setFeatured_media(Long featured_media) { this.featured_media = featured_media; }
}

// 著者
class AuthorDto {
    private Long id;
    private String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

// カテゴリ
class BlogCategoryDto {
    private Long id;
    private String name;
    private String slug;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
}

// タグ
class TagDto {
    private Long id;
    private String name;
    private String slug;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
}

// アイキャッチ画像
class MediaDto {
    private Long id;
    private String source_url;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSource_url() { return source_url; }
    public void setSource_url(String source_url) { this.source_url = source_url; }
}

// 記事詳細まとめ
class PostDetailDto {
    private BlogDTOs post;
    private AuthorDto author;
    private List<String> categoryNames;
    private List<String> tagNames;
    private String featuredImage;
    private BlogDTOs prevPost;
    private BlogDTOs nextPost;

    public PostDetailDto(BlogDTOs post, AuthorDto author, List<String> categoryNames,
                         List<String> tagNames, String featuredImage,
                         BlogDTOs prevPost, BlogDTOs nextPost) {
        this.post = post;
        this.author = author;
        this.categoryNames = categoryNames;
        this.tagNames = tagNames;
        this.featuredImage = featuredImage;
        this.prevPost = prevPost;
        this.nextPost = nextPost;
    }

    public BlogDTOs getPost() { return post; }
    public void setPost(BlogDTOs post) { this.post = post; }

    public AuthorDto getAuthor() { return author; }
    public void setAuthor(AuthorDto author) { this.author = author; }

    public List<String> getCategoryNames() { return categoryNames; }
    public void setCategoryNames(List<String> categoryNames) { this.categoryNames = categoryNames; }

    public List<String> getTagNames() { return tagNames; }
    public void setTagNames(List<String> tagNames) { this.tagNames = tagNames; }

    public String getFeaturedImage() { return featuredImage; }
    public void setFeaturedImage(String featuredImage) { this.featuredImage = featuredImage; }

    public BlogDTOs getPrevPost() { return prevPost; }
    public void setPrevPost(BlogDTOs prevPost) { this.prevPost = prevPost; }

    public BlogDTOs getNextPost() { return nextPost; }
    public void setNextPost(BlogDTOs nextPost) { this.nextPost = nextPost; }
}
