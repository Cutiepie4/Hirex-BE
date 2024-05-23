package com.ptit.Hirex.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewRequest {

    private Long id;

    @NotBlank(message = "Tiêu đề  không được để trống")
    private String title;

    @NotBlank(message = "Hãy nêu điều bạn thích ở công ty này")
    private String whatYouLike;

    @NotBlank(message = "Hãy đề xuất để công ty cải thiện thêm")
    private String feedback;

    @Min(value=1, message="Số sao phải thuộc khoảng [1, 5]")
    @Max(value=5, message="Số sao phải thuộc khoảng [1, 5]")
    private int overallRate;

    @Min(value=1, message="Số sao phải thuộc khoảng [1, 5]")
    @Max(value=5, message="Số sao phải thuộc khoảng [1, 5]")
    private int salaryRate;

    @Min(value=1, message="Số sao phải thuộc khoảng [1, 5]")
    @Max(value=5, message="Số sao phải thuộc khoảng [1, 5]")
    private int trainingRate;

    @Min(value=1, message="Số sao phải thuộc khoảng [1, 5]")
    @Max(value=5, message="Số sao phải thuộc khoảng [1, 5]")
    private int managementRate;

    @Min(value=1, message="Số sao phải thuộc khoảng [1, 5]")
    @Max(value=5, message="Số sao phải thuộc khoảng [1, 5]")
    private int cultureRate;

    @Min(value=1, message="Số sao phải thuộc khoảng [1, 5]")
    @Max(value=5, message="Số sao phải thuộc khoảng [1, 5]")
    private int officeRate;

    @NotNull(message = "Thiếu mất trường company. Thử lại sau")
    private Long companyId;

    @NotNull(message = "Hãy cho biết bạn có đề xuất công ty này không")
    private boolean recommend;

}
