package com.example.eurekaclient2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;

    private String title;

    private String description;

    private boolean cheked;

}

