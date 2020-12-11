package com.kodilla.testing.forum.tdd;

public class ForumPost {
    private String postBody;
    private String author;

    public ForumPost(String postBody, String author) {
        this.postBody = postBody;
        this.author = author;
    }

    public String getPostBody() {
        return postBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumPost forumPost = (ForumPost) o;

        if (postBody != null ? !postBody.equals(forumPost.postBody) : forumPost.postBody != null) return false;
        return author != null ? author.equals(forumPost.author) : forumPost.author == null;
    }

    @Override
    public int hashCode() {
        int result = postBody != null ? postBody.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
