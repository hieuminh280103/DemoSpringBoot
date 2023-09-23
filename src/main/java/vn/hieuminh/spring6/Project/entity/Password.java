package vn.hieuminh.spring6.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Password {
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;
}
