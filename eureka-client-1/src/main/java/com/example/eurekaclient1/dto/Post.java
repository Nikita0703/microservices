package com.example.eurekaclient1.dto;

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

    private boolean checked;

}
