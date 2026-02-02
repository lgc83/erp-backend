package port.sm.erp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import port.sm.erp.dto.JournalResponse;
import port.sm.erp.dto.JournalSearchRequest;
import port.sm.erp.service.JournalService;


@RestController //리턴값이 HTML이 아니라 JSON 데이터로 나감
@RequestMapping //컨트롤러 기본 주소로 만들어짐
@RequiredArgsConstructor //final로 선언된 변수에 대해 생성자를 자동으로 만들어줌
@CrossOrigin(origins = "*")//프론트엔드(React, Next.js)에서 API 호출할수 있게 허용
public class JournalController {

    private final JournalService journalService;
    //요청 받고 서비스에 넘기고 결과를 그대로 리턴

    @GetMapping
    public Page<JournalResponse> list (
            JournalSearchRequest req,
@PageableDefault(size = 20, sort = "journalDate", direction = Sort.Direction.DESC
    ) Pageable pageable
    ) {
    return journalService.list(req, pageable);
    }
}