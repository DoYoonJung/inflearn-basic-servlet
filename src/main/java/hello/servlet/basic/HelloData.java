package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

//jason으로 http api 적용을 위한 페이지

@Getter @Setter
public class HelloData {

    private String username;
    private int age;

}
