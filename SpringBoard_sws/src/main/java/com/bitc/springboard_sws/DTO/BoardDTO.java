package com.bitc.springboard_sws.DTO;

import lombok.Data;

@Data
public class BoardDTO {
    private int boardIdx;
    private String title;
    private String content;
    private String createId;
    private String createDt;
    private String updateId;
    private String updateDt;
    private int hitCnt;
}
