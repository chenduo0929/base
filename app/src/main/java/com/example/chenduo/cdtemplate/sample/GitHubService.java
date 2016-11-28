
package com.example.chenduo.cdtemplate.sample;

import com.example.chenduo.cdtemplate.bean.GithubUserInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GitHubService {
    String end_point = "https://api.github.com/";

    @GET("users/{user}")
    Observable<GithubUserInfo> getUserInfo(@Path("user") String user);
}
