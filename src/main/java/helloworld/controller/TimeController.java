package helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/time")

//@Controller
//@ResponseBody
@RestController
public class TimeController {
    @RequestMapping(value="/current",method= RequestMethod.GET)
    public LocalDateTime show(){
        return LocalDateTime.now();
    }

    @RequestMapping(value="/detail/{name}/{surname}/{age}",method=RequestMethod.GET)
    public String getDetail(@PathVariable("name") String name,@PathVariable("surname") String surname,
            @PathVariable("age") Integer age
    ){
        return "Salom " + name + " " + surname + " " + age;
    }
}
