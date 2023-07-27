package zerobase.weather.Controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.Service.DairyService;

import java.time.LocalDate;

@RestController
public class DairyController {
  private final DairyService dairyService;

  public DairyController(DairyService dairyService) {
    this.dairyService = dairyService;
  }

  @PostMapping("/create/diary")
  void createDairy (
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
      @RequestBody String text){

    dairyService.createDiary(date, text);
  }
}
