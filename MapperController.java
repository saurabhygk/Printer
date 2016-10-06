package com.mapper.controller;

import com.mapper.domain.FileRequest;
import com.mapper.domain.FileResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by saurabh.yagnik on 2016/10/05.
 */
@RestController
public class MapperController {

    @RequestMapping(value = "/generate-file")
    @ResponseBody
    public FileResponse generateFileByMapping(@RequestBody FileRequest rq){
        
        return new FileResponse();
    }
}
