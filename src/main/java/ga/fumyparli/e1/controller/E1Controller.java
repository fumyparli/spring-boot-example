package ga.fumyparli.e1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class E1Controller {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "this is data modified????");
        return "hello";
    }

    @GetMapping("hello2")
    public String Hello2(@RequestParam("name2") String name, Model model) {
        model.addAttribute("key_name", name);
        return "hello2";
    }

    @GetMapping("hello-motherFuck")
    @ResponseBody
    public String helloMother(@RequestParam("name") String name) {
        return "안녕하세요!" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }
}
