package com.bitc.board1.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class BoardDTO {
    private int boardIdx;

//    public int getBoardIdx() {
//        return boardIdx;
//    }
//
//    public void setBoardIdx(int boardIdx) {
//        this.boardIdx = boardIdx;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getCreateId() {
//        return createId;
//    }
//
//    public void setCreateId(String createId) {
//        this.createId = createId;
//    }
//
//    public String getCreateDt() {
//        return createDt;
//    }
//
//    public void setCreateDt(String createDt) {
//        this.createDt = createDt;
//    }
//
//    public String getUpdateId() {
//        return updateId;
//    }
//
//    public void setUpdateId(String updateId) {
//        this.updateId = updateId;
//    }
//
//    public String getUpdateDt() {
//        return updateDt;
//    }
//
//    public void setUpdateDt(String updateDt) {
//        this.updateDt = updateDt;
//    }
//
//    public int getHitCnt() {
//        return hitCnt;
//    }
//
//    public void setHitCnt(int hitCnt) {
//        this.hitCnt = hitCnt;
//    }

    private String title;
    private String content;
    private String createId;
    private String createDt;
    private String updateId;
    private String updateDt;
    private int hitCnt;

    private List<BoardFileDTO> fileList;
}
