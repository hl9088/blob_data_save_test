package com.lhl.blob.bean;

import java.io.Serializable;

/**
 * Created by lihongli on 2019/1/24
 */
public class BlobBean implements Serializable {
    private String id;
    private byte[] content;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
