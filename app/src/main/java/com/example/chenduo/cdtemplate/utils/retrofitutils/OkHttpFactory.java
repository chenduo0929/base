
package com.example.chenduo.cdtemplate.utils.retrofitutils;

import com.example.chenduo.cdtemplate.MyApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by chenduo on 16-11-25.
 */

enum OkHttpFactory {

    INSTANCE;

    private final OkHttpClient okHttpClient;

    private static final int TIMEOUT = 30;

    OkHttpFactory() {
        // 打印请求Log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 缓存目录
        Cache cache = new Cache(MyApplication.getInstance().getCacheDir(), 10 * 1024 * 1024);

        okHttpClient = new OkHttpClient.Builder()
                // 打印请求log
                // .addInterceptor(interceptor)

                // 添加UA
                .addInterceptor(new UserAgentInterceptor("test"))

                // 必须是设置Cache目录
                .cache(cache)

                // 走缓存，两个都要设置
                // .addInterceptor(new OnOffLineCachedInterceptor())
                // .addNetworkInterceptor(new OnOffLineCachedInterceptor())

                // 失败重连
                .retryOnConnectionFailure(true)

                // time out
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)

                .build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public final class UserAgentInterceptor implements Interceptor {
        private static final String USER_AGENT_HEADER_NAME = "User-Agent";
        private final String userAgentHeaderValue;

        public UserAgentInterceptor(String userAgentHeaderValue) {
            this.userAgentHeaderValue = userAgentHeaderValue;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request originalRequest = chain.request();

            final Request requestWithUserAgent = originalRequest.newBuilder()

                    // 移除先前默认的UA
                    .removeHeader(USER_AGENT_HEADER_NAME)

                    // 设置UA
                    .addHeader(USER_AGENT_HEADER_NAME, userAgentHeaderValue)

                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }
}
