package com.lhl.blob.controller;

import com.lhl.blob.bean.BlobBean;
import com.lhl.blob.service.BlobDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by lihongli on 2019/1/24
 */
@RestController
public class BlobDataController {

    @Autowired
    private BlobDataService blobDataService;

    /**
     * 保存数据 测试保存一个文件文件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveTxtFile", method = RequestMethod.POST)
    public String saveTxtFileBlob(MultipartHttpServletRequest request) {
        MultipartFile file = request.getFile("file");
        try {
            byte[] content = file.getBytes();
            BlobBean blobBean = new BlobBean();
            blobBean.setId(UUID.randomUUID().toString());
            blobBean.setContent(content);
            blobDataService.save(blobBean);
            return "success" + blobBean.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 测试读取是否正常 下载上面上传的txt文件
     *
     * @param response
     */
    @RequestMapping(value = "/downTxtFile/{id}", method = RequestMethod.GET)
    public void getTxtFileBlob(@PathVariable("id") String id, HttpServletResponse response) {
        // 这个id对应了一个上传的文本文件数据
        BlobBean blobBean = blobDataService.select(id);
        try {
            response.reset();
            response.setContentType("text/plain"); // 定义输出类型
            response.setHeader("Content-disposition", "attachment;filename=" + new String("测试文本文件".getBytes("GBK"), "ISO-8859-1") + ".txt"); // 设定输出文件头
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(blobBean.getContent());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 保存数据 测试保存超长字符串
     *
     * @return
     */
    @RequestMapping(value = "/saveString", method = RequestMethod.POST)
    public String saveStringBlob() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10000; i++) {
                stringBuilder.append("测");
            }
            byte[] bytes = stringBuilder.toString().getBytes("UTF-8");
            BlobBean blobBean = new BlobBean();
            blobBean.setId(UUID.randomUUID().toString());
            blobBean.setContent(bytes);
            blobBean.setText(stringBuilder.toString().replace('测', 'T'));
            blobDataService.save(blobBean);
            return "success" + blobBean.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 测试读取是否正常 读取超长字符串
     */
    @RequestMapping(value = "/showString/{id}", method = RequestMethod.GET)
    public String getBlob(@PathVariable("id") String id) throws Exception {
        BlobBean blobBean = blobDataService.select(id);
        byte[] content = blobBean.getContent();
        String text = blobBean.getText();
        return new String(content, "UTF-8") + text;
    }
}
