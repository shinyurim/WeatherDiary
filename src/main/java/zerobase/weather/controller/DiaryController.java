package zerobase.weather.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @ApiOperation(value = "일기 텍스트와 날씨를 이용해서 DB에 일기 저장", notes = "추가 설명")
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestBody String text){ // ISO.DATE를 이용해서 yyyy-MM-dd형식으로 받음
        diaryService.createDiary(date, text);

    }

    @ApiOperation("선택한 날짜의 모든 일기 데이터를 가져옵니다.")
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam  @DateTimeFormat(iso = ISO.DATE) LocalDate date){ // 해당 날짜의 일기를 List형태로 반환, 조회할 날짜 받기
        return diaryService.readDiary(date);
    }

    @ApiOperation("선택한 기간중의 모든 일기 데이터를 가져옵니다.")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "조회할 기간의 첫번째 날", example = "2020-02-02") LocalDate startDate, // 조회할 기간의 시작일
                            @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "조회할 기간의 마지막 날", example = "2020-02-02")LocalDate endDate){ // 조회할 기간의 종료일
        return diaryService.readDiaries(startDate,endDate);
    }

    @ApiOperation("선택한 날짜의 일기 텍스트를 수정합니다.")
    @PutMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date, @RequestBody String text){ // 수정할 날짜 받기, 수정할 새 일기 받기
        diaryService.updateDiary(date, text);
    }

    @ApiOperation("선택한 날짜의 모든 일기를 삭제합니다.")
    @DeleteMapping("/delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date){ // 삭제할 날짜 받아주기
        diaryService.deleteDiary(date);
    }
}
