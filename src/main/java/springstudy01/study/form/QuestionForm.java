package springstudy01.study.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class QuestionForm {
    @NotEmpty(message = "제목을 입력해 주세요")
    @Size(max=200)
    private String subject;
    @NotEmpty(message = "내용을 입력해 주세요")
    private String content;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
