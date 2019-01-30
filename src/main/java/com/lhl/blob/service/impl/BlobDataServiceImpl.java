package com.lhl.blob.service.impl;

import com.lhl.blob.bean.BlobBean;
import com.lhl.blob.mapper.BlobDataMapper;
import com.lhl.blob.service.BlobDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lihongli on 2019/1/24
 */
@Service
public class BlobDataServiceImpl implements BlobDataService {

    @Autowired
    private BlobDataMapper blobDataMapper;

    @Override
    public Integer save(BlobBean blobBean) {
        return blobDataMapper.save(blobBean);
    }

    @Override
    public BlobBean select(String id) {
        return blobDataMapper.select(id);
    }
}
