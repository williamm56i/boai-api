package org.boai.controller.dto;

import com.google.common.base.CaseFormat;
import io.micrometer.common.util.StringUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PageDto {
    @Schema(description = "第幾頁")
    int PageNum;
    @Schema(description = "單頁筆數")
    int pageSize;
    @Schema(description = "排序欄位")
    String sortBy;
    @Schema(description = "反序")
    boolean desc = false;

    public String getOrderString() {
        if (StringUtils.isNotEmpty(sortBy)) {
            String order = desc ? " desc" : " asc";
            return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, sortBy) + order;
        }
        return "";
    }
}
