package com.detelin.kb.domain.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private String id;
    private String title;
    private String author;
    private String description;
    private String longText;
    private String workaround;
    private LocalDate createdDate;
}
