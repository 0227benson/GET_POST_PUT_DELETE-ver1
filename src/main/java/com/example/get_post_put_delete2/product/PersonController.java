package com.example.get_post_put_delete2.product;

import com.example.get_post_put_delete2.Response.Common_Response;
import com.example.get_post_put_delete2.Response.Get_Api_Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/project")/*URL Path*/
public class PersonController {

    private static final PersonService PERSON_SERVICE = new PersonService();

    @GetMapping("/getPerson/{id}")/*傳入參數id*/
    public ResponseEntity getPerson(@PathVariable String id) {
        Get_Api_Response rsp = new Get_Api_Response();      //needs a formatted response
        Person person = PERSON_SERVICE.getPerson(id);

        if (person != null) {
            rsp.SUCCESS();
            rsp.setPerson(person);
        } else {
            rsp.FAIL();
        }

        return ResponseEntity.ok(rsp);
    }

    @PostMapping("/addPerson")
    public ResponseEntity addPerson(@RequestBody Person person) {
        Common_Response rsp = new Common_Response();
        if (PERSON_SERVICE.addPerson(person)) {
            rsp.SUCCESS();
        } else {
            rsp.BAD_PARAM();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/updatePerson/{id}")
    public ResponseEntity updatePerson(@PathVariable String id, @RequestBody Person updatedPerson) {
        PERSON_SERVICE.updatePerson(id, updatedPerson);
        return ResponseEntity.ok().build();
    }/*更新資料後，回傳200表示更新完成*/

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity deletePerson(@PathVariable String id) {
        PERSON_SERVICE.deletePerson(id);
        return ResponseEntity.ok().build();
    }/*刪除資料後，回傳200表示刪除完成*/
}
