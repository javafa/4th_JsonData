package com.veryworks.android.jsondata.model;

/**
 * Created by pc on 10/16/2017.
 */

public class User {
    // 위에 세개만 일단은 사용
    int id;
    String login;
    String avatar_url;

    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getAvatar_url() {
        return avatar_url;
    }

    String gravatar_id;
    String url;
    String html_url;
    String followers_url;
    String following_url;
    String gists_url;
    String starred_url;
    String subscriptions_url;
    String organizations_url;
    String repos_url;
    String events_url;
    String received_events_url;
    String type;
    boolean site_admin;
}
