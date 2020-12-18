package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> forumUsersList = new ArrayList<>();
    public Forum() {
        forumUsersList.add(new ForumUser(1, "aaa", 'M',LocalDate.of(1989, 02,22) , 27));
        forumUsersList.add(new ForumUser(2, "bbb", 'M',LocalDate.of(1990, 03,21) , 0));
        forumUsersList.add(new ForumUser(3, "ccc", 'M',LocalDate.of(1991, 01,20) , 85));
        forumUsersList.add(new ForumUser(4, "ddd", 'M',LocalDate.of(1992, 04,19) , 96));
        forumUsersList.add(new ForumUser(5, "eee", 'M',LocalDate.of(2002, 05,18) , 54));
        forumUsersList.add(new ForumUser(6, "fff", 'F',LocalDate.of(1994, 06,17) , 158));
        forumUsersList.add(new ForumUser(7, "ggg", 'F',LocalDate.of(1995, 07,16) , 3251));
        forumUsersList.add(new ForumUser(8, "hhh", 'F',LocalDate.of(1996, 10,15) , 0));
        forumUsersList.add(new ForumUser(9, "iii", 'F',LocalDate.of(1997, 12,14) , 1));
    }

    public List<ForumUser> getForumUsersList() {
        return forumUsersList;
    }
}