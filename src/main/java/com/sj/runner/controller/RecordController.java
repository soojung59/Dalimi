package com.sj.runner.controller;

import com.sj.runner.dto.BookmarkDto;
import com.sj.runner.dto.GalleryDto;
import com.sj.runner.dto.MemberDto;
import com.sj.runner.dto.RecordDto;
import com.sj.runner.service.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor //view 페이지가 필요없는  api응답에 어울리는 어노테이션 (autowired 비권장, bean주입)
public class RecordController {
    private final RecordService recordService;
    private final S3Service s3Service;
    private final GalleryService galleryService;
    private final MemberService memberService;
    private final BookmarkService bookmarkService;

    @GetMapping("/photo")
    public String dispWrite(Model model){
        List<GalleryDto> galleryDtoList = galleryService.getList();

        model.addAttribute("galleryList", galleryDtoList);

        return "record/photo" ;
    }
    @PostMapping("/write")
    public String execWrite(RecordDto recordDto,GalleryDto galleryDto, MultipartFile file) throws IOException {
        //파일 이름 중복없이 다시 설정할 것!
        String imgPath = s3Service.upload(LocalDate.now()+galleryDto.getTitle(),file);
        galleryDto.setFilePath(imgPath);
        galleryService.savePost(galleryDto);

        recordService.savePost(recordDto);
        return "redirect:/";
    }


    @GetMapping("/post")
    public String write(Principal principal,Model model){
        MemberDto memberDto = memberService.getInfo(principal.getName());
        model.addAttribute("memberDto", memberDto);
        return "record/write.html";
    }

    @PostMapping("/post")
    public String write(RecordDto recordDto, Model model){
        recordService.savePost(recordDto);
        return  "redirect:/";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no")Long no, MemberDto memberDto, Model model , Principal principal)  {
        RecordDto recordDto = recordService.getPost(no);
        if(principal != null){
            memberDto = memberService.getInfo(principal.getName());
        }
//        if(bookmarkService.checkBookmark(no,memberDto.getId()) == true){
//            model.addAttribute("book", bookmarkDto);
//        }
        model.addAttribute("recordDto", recordDto);
        model.addAttribute("memberDto", memberDto);
        return "record/detail.html";
    }
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model){
        RecordDto recordDto = recordService.getPost(no);

        model.addAttribute("runnerDto", recordDto);
        return "record/update.html";
    }

    @PutMapping("/post/edit/{no}")
    public String update(RecordDto recordDto){
        recordService.savePost(recordDto);
        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no){
        recordService.deletePost(no);
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
        List<RecordDto> recordDtoList = recordService.searchPosts(keyword);

        model.addAttribute("runnerList", recordDtoList);
        return "record/list.html";
    }

}
