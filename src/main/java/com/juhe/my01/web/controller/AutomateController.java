package com.juhe.my01.web.controller;

import com.juhe.my01.utils.CsvUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * ClassName: AutomateController
 * Description:
 * date: 2020/9/11 21:00
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/auto")
public class AutomateController {

    private String filepath = System.getProperty("user.dir")+"\\src\\main\\resources\\file\\";

    private File targetFile = new File(filepath);

    @RequestMapping("/index")
    public ModelAndView AutoIndex(Map map){
        map.put("list",new ArrayList<String>());
        return new ModelAndView("auto/index",map);
    }

    @PostMapping("/upload")
    public ModelAndView AutoFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, Map map){
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String filrdir = filepath + file.getOriginalFilename();
        try (FileOutputStream out = new FileOutputStream(filrdir)){
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        CsvUtil csvUtil = new CsvUtil();
        List list = csvUtil.ActiveAuto(filrdir);

        map.put("list",list);
        return new ModelAndView("auto/index",map);
    }

    @RequestMapping("/thread")
    public ModelAndView AutoThread(){
        return new ModelAndView("auto/thread");
    }


}
