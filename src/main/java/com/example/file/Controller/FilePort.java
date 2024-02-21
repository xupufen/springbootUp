package com.example.file.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilePort {
    /**
     * 文件上传的接口
     * 82端口
     * 访问即返回网页FileUpdata
     * 进行上传
     */
    @GetMapping(value = "")
    public String FileUp(){
        return "FileUpdata";
    }
}
