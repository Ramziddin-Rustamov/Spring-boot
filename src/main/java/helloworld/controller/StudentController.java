package helloworld.controller;

import helloworld.dto.StudentDTO;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/student")
@RestController
public class StudentController {
   private List<StudentDTO> studentLsit= new LinkedList<>();

   public StudentController(){
       StudentDTO dto = new StudentDTO();
       dto.setId(UUID.randomUUID().toString());
       dto.setName("Alish");
       dto.setAge(12);
       dto.setSurname("Surname");
       studentLsit.add(dto);

       StudentDTO dto1 = new StudentDTO();
       dto1.setId(UUID.randomUUID().toString());
       dto1.setName("Valish");
       dto1.setAge(12);
       dto1.setSurname("Surname");
       studentLsit.add(dto1);

       StudentDTO dto2 = new StudentDTO();
       dto2.setId(UUID.randomUUID().toString());
       dto2.setName("Alish");
       dto2.setAge(12);
       dto2.setSurname("Azizov");
       studentLsit.add(dto2);

   }

   @RequestMapping(value="/all",method= RequestMethod.GET)
   public List<StudentDTO> listOfStudent(){
       return studentLsit;
   }

   @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public StudentDTO getById(@PathVariable("id") String id){
       for(StudentDTO dto : studentLsit){
           if(dto.getId().equals(id)){
               return dto;
           }
       }
       return null;
   }

   @RequestMapping(value="/create", method=RequestMethod.POST)
   public StudentDTO create(@Valid @RequestBody StudentDTO dto){
       dto.setId(UUID.randomUUID().toString());
       studentLsit.add(dto);
       return dto;
   }

   @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
   public boolean update(@PathVariable("id") String id, @RequestBody StudentDTO dto){
       for(StudentDTO dt : studentLsit){
           if(dt.getId().equals(id)){
               dt.setName(dto.getName());
               dt.setSurname(dto.getSurname());
               dt.setAge(dto.getAge());
               return true;
           }
       }
       return false;
   }
@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
   public boolean delete(@PathVariable("id") String id){
       return studentLsit.removeIf(student ->student.getId().equals(id));
   }

}
