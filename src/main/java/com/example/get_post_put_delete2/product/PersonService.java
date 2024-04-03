package com.example.get_post_put_delete2.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service/*告訴Spring這個class為提供服務和處理程式邏輯*/
public class PersonService {
    private static List<Person> products=new ArrayList<>();

    public PersonService() {/*新增預設資料*/
        products = new ArrayList<>();
        products.add(new Person("1", "benson", 23));
        products.add(new Person("2", "margo", 25));
        products.add(new Person("3", "amy", 30));
        products.add(new Person("4", "jack", 28));
        products.add(new Person("5", "jason", 21));
    }

    public Person getProduct(String id) {
        return products.stream()/*將 products 集合轉換為 Stream，使得更方便操作List*/
                .filter(product -> id.equals(product.getId()))/*使用filter檢查每一個product的id是否等於傳入的參數id(Lambda 表達式)*/
                .findFirst()/*回傳第一個符合的product*/
                .orElse(null);/*如果都沒有符合的product則回傳null*/
    }

    public void addProduct(Person product) {

        products.add(product);/*接收一個json格式的資料並將其新增到products列表中*/
    }

    public void updateProduct(String id, Person updatedProduct) {
        products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .ifPresent(product -> {
                    product.setName(updatedProduct.getName());
                    product.setAge(updatedProduct.getAge());
                });/*根據傳入的參數id，找到product中對應的id資料，並將原本的資料更改為傳入的資料*/
    }


    public void deleteProduct(String id) {

        products.removeIf(product -> product.getId().equals(id));
    }/*如果product的id和傳入的參數id一樣的話，就刪除該筆資料*/

}