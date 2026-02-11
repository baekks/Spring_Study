package com.example.demo.controller;

import com.example.demo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller                 // 이 클래스가 "주문 받는 사람"임을 스프링에게 알려줍니다. (컨트롤러 빈 등록)
@RequiredArgsConstructor    // "필요한 부품(서비스 등)"을 알아서 챙겨주는 편리한 생성자를 만들어줍니다.
public class HomeController {

    @GetMapping("/")        // 사용자가 브라우저 주소창에 '/' (루트 경로)를 입력했을 때 호출되는 엔드포인트입니다.
    public String home(Model model) {
        // Model model: 컨트롤러에서 가공한 데이터를 HTML(View)로 넘겨주는 '배달통' 역할을 합니다.
        model.addAttribute("name", "백시연");      // model.addAttribute("key", value); 이렇게 담으면 index.html 파일에서 ${name}이라는 코드로 이 값을 꺼낼 쓸 수 있다.

        return "index";     // return "index": 'src/main/resources/templates/index.html' 파일을 찾아 렌더링하라는 뜻입니다.
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        Person p1 = new Person("Baek", 32);
        model.addAttribute("person", p1);

        return "hello";
    }

    @GetMapping("/list")
    public String lis(Model model) {
        List<Person> plist = new ArrayList<>();
        Person p1 = new Person("Baek", 32);
        plist.add(p1);
        Person p2 = new Person("Park", 42);
        plist.add(p2);
        Person p3 = new Person("Lee", 29);
        plist.add(p3);
        model.addAttribute("plist", plist);

        return "list";
    }
}
