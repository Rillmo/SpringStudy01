package springstudy01.study.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserCreateForm {
    @NotEmpty(message = "ID를 입력해주세요")
    @Size(min = 3, max = 25)
    private String username;

    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password1;

    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password2;

    @Email
    @NotEmpty(message = "이메일을 입력해주세요")
    private String email;

    @NotEmpty(message = "닉네임을 입력해주세요")
    @Size(max=25)
    private String nickname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
