package com.example.get_post_put_delete2.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/project")/*URL Path*/
public class PersonController {

    private static final PersonService PRODUCT_SERVICE = new PersonService();

    @GetMapping("/getProduct/{id}")/*傳入參數id*/
    public ResponseEntity getPerson(@PathVariable String id) {
        Get_Api_Response rsp = new Get_Api_Response();      //needs a formatted response
        Person person = PRODUCT_SERVICE.getPerson(id);

        if (person != null) {
            rsp.SUCCESS();
            rsp.setProduct(person);
        } else {
            rsp.FAIL();
        }

        return ResponseEntity.ok(rsp);
    }

    @PostMapping("/addProduct")
    public ResponseEntity addPerson(@RequestBody Person person) {
        Common_Response rsp = new Common_Response();
        if (PRODUCT_SERVICE.addProduct(person)) {
            rsp.SUCCESS();
        } else {
            rsp.BAD_PARAM();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable String id, @RequestBody Person updatedProduct) {
        productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok().build();
    }/*更新資料後，回傳200表示更新完成*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }/*刪除資料後，回傳200表示刪除完成*/
}
