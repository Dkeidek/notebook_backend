package htwberlin.todolist_backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

   @GetMapping("/todo")
    public String HelloWorld(){
       return "Hello World !!";
   }
}
