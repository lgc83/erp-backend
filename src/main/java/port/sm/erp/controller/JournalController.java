package port.sm.erp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //리턴값이 HTML이 아니라 JSON 데이터로 나감
@RequestMapping //컨트롤러 기본 주소로 만들어짐
@RequiredArgsConstructor //final로 선언된 변수에 대해 생성자를 자동으로 만들어줌
@CrossOrigin(origins = "*")//프론트엔드(React, Next.js)에서 API 호출할수 있게 허용
public class JournalController {
}
