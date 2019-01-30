package com.lhl.blob.mapper;

import com.lhl.blob.bean.BlobBean;

/**
 * Created by lihongli on 2019/1/24
 */
public interface BlobDataMapper {

    Integer save(BlobBean blobBean);

    BlobBean select(String id);
}
