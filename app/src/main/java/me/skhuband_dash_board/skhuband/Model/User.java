package me.skhuband_dash_board.skhuband.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by JY on 2017-06-07.
 */

public class User extends RealmObject {

    @PrimaryKey
    private int id;

    private String login_id;
    private String name;
    private int grade;
    private String phone_number;
    private String company_number;
    private String status;
    private String birth;
    private String email;
    private int user_type;
    private String typeName;
    private String image;
    private int category_id = -1;
    private boolean isPhoneNumber = false;
    private boolean isCompanyNumber = false;
    private boolean isStatus = false;
    private boolean isImage = false;
    private boolean isEmail = false;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCompany_number() {
        return company_number;
    }

    public void setCompany_number(String company_number) {
        this.company_number = company_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public boolean isPhoneNumber() {
        return isPhoneNumber;
    }

    public void setPhoneNumber(boolean phoneNumber) {
        isPhoneNumber = phoneNumber;
    }

    public boolean isCompanyNumber() {
        return isCompanyNumber;
    }

    public void setCompanyNumber(boolean companyNumber) {
        isCompanyNumber = companyNumber;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
    }

    public boolean isEmail() {
        return isEmail;
    }

    public void setEmail(boolean email) {
        isEmail = email;
    }
}
