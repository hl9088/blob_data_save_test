package com.lhl.blob.service;

import com.lhl.blob.bean.BlobBean;

/**
 * Created by lihongli on 2019/1/24
 */
public interface BlobDataService {

    Integer save(BlobBean blobBean);

    BlobBean select(String id);
}
