package com.detelin.kb;

public class GlobalConstants {
    //Roles
    /*
    Should be able to:
        create articles and edit own articles,
        edit its own profile
     */
    public static final String AUTHOR_ROLE = "ROLE_AUTHOR";
    /*
    Should be able to:
        edit any article,
        merge any articles,
        publish articles,
        create groups,
        assign roles to groups(except root role),
        edit users' status and role
        move users to groups with specific roles
     */
    public static final String EDITOR_ROLE = "ROLE_EDITOR";
    /*
    Should be able to:
        view all only published articles, comment and like them
     */
    public static final String GUEST_ROLE = "ROLE_GUEST";
    /*
    Should be able to:
        full control over users, groups, articles
     */
    public static final String ROOT_ROLE = "ROLE_ROOT";
}
