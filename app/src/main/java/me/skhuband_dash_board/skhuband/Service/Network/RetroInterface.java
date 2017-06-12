package me.skhuband_dash_board.skhuband.Service.Network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by JY on 2017-06-07.
 */

public interface RetroInterface {

    /*
    로그인하기
     */
    @POST("/auth")
    Call<Void> login(@Body UserLogin userRequest);

    class UserLogin {
        String id;
        String pwd;
        int categoryID;

        public UserLogin(String id, String pwd, int categoryID) {
            this.id = id;
            this.pwd = pwd;
            this.categoryID = categoryID;
        }
    }

    /*
    전체 동문회 데이터 가져오기
    (로그인 된 경우, 처음에 로그인 하지 않은 경우)
     */
    @GET("/api/v1/user/cate gory/{categoryId}")
    Call<JsonObject> getAllAlumniLogined
            (@Path("categoryID") String categoryID);

    @GET("/api/v1/user/category/{categoryId}/lastTime/{date}")
    Call<JsonObject> getAllAlumniNotLogined
            (@Path("categoryID") String categoryID,
             @Path("date") String date);


    /*
    유저 공개여부 가져오기
     */
    @GET("/api/v1/userdis/lastTime/{lastDate}")
    Call<JsonObject> getUserPublic
          (@Path("lastDate") String lastDate);
}
