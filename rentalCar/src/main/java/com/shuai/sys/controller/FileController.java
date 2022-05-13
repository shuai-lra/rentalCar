package com.shuai.sys.controller;

import com.shuai.bus.utils.DataGridView;
import com.shuai.sys.constant.SysConstant;
import com.shuai.sys.utils.AppFileUtils;
import com.shuai.sys.utils.RandomUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping("downloadShowFile")
    public ResponseEntity<Object> downloadShowFile(String path, HttpServletResponse response){
        return AppFileUtils.downloadFile(response,path,"");
    }

    @RequestMapping("uploadFile")
    @ResponseBody
    public DataGridView uploadFile(MultipartFile multipartFile) throws IOException {
        String path = AppFileUtils.PATH;
        String dirName = RandomUtils.getCurrentDateForString();
        File file = new File(path, dirName);
        if (!file.exists()){
            file.mkdir();
        }
        String oldName = multipartFile.getOriginalFilename();
        String newName = RandomUtils.createFileNameUseTime(oldName, SysConstant.FILE_UPLOAD_TEMP);
        File dest = new File(file,newName);
        multipartFile.transferTo(dest);
        HashMap<String, Object> map = new HashMap<>();
        map.put("src",dirName+"/"+newName);
        return new DataGridView(map);
    }
}
