package model;


public class NhanVien {
    private String userName;
    private String password;
    private int age = 18;
    private String address = "Việt Nam";
    private String phone = "";

    public NhanVien() {
    }

    public NhanVien(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public NhanVien(String userName, String password, String phone) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

    public NhanVien(String userName, String password, int age, String address, String phone) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}