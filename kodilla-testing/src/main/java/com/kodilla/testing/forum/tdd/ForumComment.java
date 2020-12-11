package com.kodilla.testing.forum.tdd;

public class ForumComment {
    private ForumPost forumPost;
    private String commentBody;
    private String author;

    public ForumComment(ForumPost forumPost, String commentBody, String author) {
        this.forumPost = forumPost;
        this.commentBody = commentBody;
        this.author = author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumComment that = (ForumComment) o;

        if (forumPost != null ? !forumPost.equals(that.forumPost) : that.forumPost != null) return false;
        if (commentBody != null ? !commentBody.equals(that.commentBody) : that.commentBody != null) return false;
        return author != null ? author.equals(that.author) : that.author == null;
    }

    @Override
    public int hashCode() {
        int result = forumPost != null ? forumPost.hashCode() : 0;
        result = 31 * result + (commentBody != null ? commentBody.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
