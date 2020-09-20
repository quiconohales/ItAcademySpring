package springBootInitialDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.example.demo.GetMapping;
//import com.example.demo.RequestParam;

import springBootInitialDemo.dto.UserResponseDto;
import springBootInitialDemo.service.IUserService;

@RestController
@RequestMapping("/v1")
public class InitialController {

    private final IUserService userService;

    @Autowired
    public InitialController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/test")
    public String helloGradle() {
        return "Hello Gradle!";
    }
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World! Fase 2 1er Exercici ";
    }
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name," ","Fase 2 2on Exercici" );
    }
    

    //@PutMapping(value ="", consumes = {"application/json"})
    @GetMapping("/user/{uuid}")
    public ResponseEntity<UserResponseDto> updatePrescription(
            @PathVariable(name="uuid") String user) throws Exception {


        UserResponseDto userResponseDto = userService.getUser("pp");

        System.out.println(userResponseDto.getName());
        System.out.println(userResponseDto.getSurname());
        System.out.println(userResponseDto.getGender());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);

    }


}
