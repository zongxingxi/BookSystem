package booksystem.bean;

public class UserInfo {
    String StudentId;
    String password;

    public UserInfo() {
    }

    public UserInfo(String studentId, String password) {
        StudentId = studentId;
        this.password = password;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {

        return StudentId;
    }

    public String getPassword() {
        return password;
    }
}
