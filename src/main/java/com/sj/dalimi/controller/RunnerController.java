package com.sj.dalimi.controller;

import com.sj.dalimi.dto.GalleryDto;
import com.sj.dalimi.dto.RunnerDto;
import com.sj.dalimi.service.GalleryService;
import com.sj.dalimi.service.RunnerService;
import com.sj.dalimi.service.S3Service;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor //view 페이지가 필요없는  api응답에 어울리는 어노테이션 (autowired 비권장, bean주입)
public class RunnerController {
    private final RunnerService runnerService;
    private final S3Service s3Service;
    private final GalleryService galleryService;

    @GetMapping("/photo")
    public String dispWrite(){
        return "photo.html" ;
    }
    @PostMapping("/photo")
    public String execWrite(GalleryDto galleryDto, MultipartFile file) throws IOException {
        String imgPath = s3Service.upload(file);
        galleryDto.setFilePath(imgPath);
        galleryService.savePost(galleryDto);
        log.info(galleryDto.toString());
        log.info(imgPath);
        return "/photo";
    }

    @GetMapping("/post")
    public String write(){
        return "write.html";
    }

    @PostMapping("/post")
    public String write(RunnerDto runnerDto){
        runnerService.savePost(runnerDto);
        return  "redirect:/";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no")Long no, Model model)  {
        RunnerDto runnerDto = runnerService.getPost(no);
        model.addAttribute("runnerDto", runnerDto);
        return "detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model){
        RunnerDto runnerDto = runnerService.getPost(no);

        model.addAttribute("runnerDto",runnerDto);
        return "update.html";
    }

    @PutMapping("/post/edit/{no}")
    public String update(RunnerDto runnerDto){
        runnerService.savePost(runnerDto);
        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no){
        runnerService.deletePost(no);
        return "redirect:/";
    }


    /*게시글 목록*/
//    @GetMapping("/")
//    public String list(Model model){
//        List<RunnerDto> runnerList = runnerService.getRunnerList();
//        model.addAttribute("runnerList", runnerList);
//        return "list.html";
//    }


    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model){
        List<RunnerDto> runnerDtoList = runnerService.searchPosts(keyword);

        model.addAttribute("runnerList", runnerDtoList);
        return "list.html";
    }

}
