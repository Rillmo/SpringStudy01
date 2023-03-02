package springstudy01.study.form;

import jakarta.validation.constraints.NotEmpty;

public class AnswerForm {
    @NotEmpty(message = "내용을 입력해주세요")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
