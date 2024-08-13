package org.boai.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserDto extends PageDto {

    @Schema(description = "帳號")
    String account;
    @Schema(description = "姓名")
    String userName;
    @Schema(description = "信箱")
    String email;
}
