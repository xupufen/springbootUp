package com.example.file.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class Feil_Up {
    /**
     * 实现文件的上传
     */
    @Value("${Updata.url}")
    private String url;

    @PostMapping(value = "/up_data")
    @ResponseBody
    public String up_data(MultipartFile multipartFile) throws IOException {
        /**
         * 上传文件不为空
         */
        if (multipartFile.isEmpty()) {
            return "上传失败！文件不为空";
        }

        /**
         *获取上传的文件名字
         */
        System.out.println(multipartFile.getOriginalFilename());
        /**
         * 上传位置
         */
        multipartFile.transferTo(new File(url + multipartFile.getOriginalFilename()));
        String success = "收到文件" + multipartFile.getOriginalFilename();
        long fileSize = multipartFile.getSize();
        double fileKb = fileSize / 1024.0;
        String size = "文件大小: " + String.format("%.2f", fileKb) + " KB";
        String type = "类型: " + multipartFile.getContentType();

        String[] arr = {success, size, type};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        return "文件上传成功！";
    }
}
