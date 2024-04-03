package com.example.get_post_put_delete2.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/project")/*URL Path*/
public class ProductController {

    private  final ProductService productService;

    @Autowired/*自動注入另一個Bean*/
    public ProductController(ProductService productService) {/*將ProductService自動注入到ProductController*/

        this.productService = productService;
    }

    @GetMapping("/{id}")/*傳入參數id*/
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Product product = productService.getProduct(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }/*根據傳入的參數id來獲取對應的產品資訊，如果有找到就回傳狀態碼200，如果沒找到就回傳404*/
    }

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }/*當成功添加後，回傳狀態碼201表示成功創建資源。*/

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok().build();
    }/*更新資料後，回傳200表示更新完成*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }/*刪除資料後，回傳200表示刪除完成*/
}
