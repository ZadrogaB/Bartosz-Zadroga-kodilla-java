package com.kodilla.testing.forum.statistics;

public class StatisticsGenerator {
    Statistics statistics;

    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averageNumberOfPostsOnUser;
    private double averageNumberOfCommentsOnUser;
    private double averageNumberOfCommentsOnPost;

    public StatisticsGenerator(Statistics statistics) {
        this.statistics = statistics;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsOnUser() {
        return averageNumberOfPostsOnUser;
    }

    public double getAverageNumberOfCommentsOnUser() {
        return averageNumberOfCommentsOnUser;
    }

    public double getAverageNumberOfCommentsOnPost() {
        return averageNumberOfCommentsOnPost;
    }

    public void calculateAdvStatistics(Statistics statistics){
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();

        if(numberOfUsers!=0) {
            averageNumberOfPostsOnUser =  Double.valueOf(numberOfPosts) / Double.valueOf(numberOfUsers);
            averageNumberOfCommentsOnUser = Double.valueOf(numberOfComments) / Double.valueOf(numberOfUsers);
        } else {
            averageNumberOfPostsOnUser = 0;
            averageNumberOfCommentsOnUser = 0;
        }
        if(numberOfPosts!=0) {
            averageNumberOfCommentsOnPost = Double.valueOf(numberOfComments) / Double.valueOf(numberOfPosts);
        } else {
            averageNumberOfCommentsOnPost = 0;
        }
    }

    public void showStatistics(){
        System.out.println("Number of users: " + numberOfUsers +
                "\nNumber of posts: " + numberOfPosts +
                "\nNumber of comments: " + numberOfComments +
                "\nNumber of posts on user: " + averageNumberOfPostsOnUser +
                "\nNumber of comments on user: " + averageNumberOfCommentsOnUser +
                "\nNumber of comments on posts: " + averageNumberOfCommentsOnPost);
    }
}
