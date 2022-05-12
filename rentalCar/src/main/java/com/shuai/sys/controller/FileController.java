package com.shuai.sys.controller;

import com.shuai.sys.utils.AppFileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping("downloadShowFile")
    public ResponseEntity<Object> downloadShowFile(String path, HttpServletResponse response){
        return AppFileUtils.downloadFile(response,path,"");
    }
}
