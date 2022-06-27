package edu.miu.waa_lab5_v1.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ActivityLogDto {
    private int id;
    private Date date;
    private String operation;
    private int duration;
}
