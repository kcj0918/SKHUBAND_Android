package me.skhuband_dash_board.skhuband.Service.Network;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JY on 2017-06-07.
 */

public class ServerGenerator {

    static final String BASE_URL="https://gomko.me/skhu/";

    static final int CONNECT_TIMEOUT = 10;
    static final int WRITE_TIMEOUT =10;
    static final int READ_TIMEOUT =10;


    public static OkHttpClient getClient() {

        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS) //연결 타임아웃 시간 설정
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS) //쓰기 타임아웃 시간 설정
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS) //읽기 타임아웃 시간 설정
                .build();
    }

    public static Retrofit getRequestInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
    }

    public static RetroInterface getRequestService() {
        return getRequestInstance().create(RetroInterface.class);//retrofit 구현체에게 인터페이스의 class정보를 보내면, 서비스의 구현체가 반환된다
    }
}
