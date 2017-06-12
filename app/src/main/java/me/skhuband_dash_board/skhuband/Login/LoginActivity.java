package me.skhuband_dash_board.skhuband.Login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.skhuband_dash_board.skhuband.R;
import me.skhuband_dash_board.skhuband.Service.Network.RetroInterface;
import me.skhuband_dash_board.skhuband.Service.Network.ServerGenerator;
import me.skhuband_dash_board.skhuband.databinding.ActivityLoginBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private String id;
    private String pwd;
    private int categoryID = 1;

    private String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setActivity(this);
        ButterKnife.bind(this);
    }

    /*
    로그인 버튼 혹은 비밀번호 찾기 버튼을 클릭한 경우
     */
    @OnClick({R.id.btn_login, R.id.btn_findPwd})
    public void onBtnClick(View v){
        switch (v.getId()){
            case R.id.btn_login:
                id = binding.loginId.getText().toString().trim();
                pwd = binding.loginPwd.getText().toString().trim();

                callToken(ServerGenerator.getRequestService());
                break;
            case R.id.btn_findPwd:
                startActivity(new Intent(getApplicationContext(), FindPwdActivity.class));
                break;
        }
    }

    /*
    카테고리 클릭 시 나오는 팝업
     */
    @OnClick(R.id.login_category)
    public void setPopup() {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        final String items[] = {getString(R.string.category1), getString(R.string.category2), getString(R.string.category3), getString(R.string.category4)};

        ab.setTitle("카테고리 선택");
        ab.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        categoryID = whichButton + 1;
                        binding.loginCategory.setText(items[whichButton]);

                        //리스트 선택하면 다이얼로그 실종
                        dialog.dismiss();
                    }
                });
        ab.show();
    }


    /*
    로그인하고 토큰 받아오기
     */
    public void callToken(RetroInterface apiService){
        Call<Void> call = apiService.login(new RetroInterface.UserLogin(id,pwd,categoryID));

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    token = response.headers().get("token");  //성공시, 토큰 받아오기
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    /*
    키보드 숨기는 메소드
     */
    public void hideSoftKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
