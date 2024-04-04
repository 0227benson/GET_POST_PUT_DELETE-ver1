package com.example.get_post_put_delete2.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private static List<Person> people=new ArrayList<>();

    public PersonService() {/*新增預設資料*/
        people = new ArrayList<>();
        people.add(new Person("1", "benson", 23));
        people.add(new Person("2", "margo", 25));
        people.add(new Person("3", "amy", 30));
        people.add(new Person("4", "jack", 28));
        people.add(new Person("5", "jason", 21));
    }

    public Person getPerson(String id) {
        return people.stream()/*將 products 集合轉換為 Stream，使得更方便操作List*/
                .filter(person -> id.equals(person.getId()))/*使用filter檢查每一個product的id是否等於傳入的參數id(Lambda 表達式)*/
                .findFirst()/*回傳第一個符合的product*/
                .orElse(null);/*如果都沒有符合的product則回傳null*/
    }

    public void addPerson(Person person) {
        boolean status = false;
        if (person.isValid()) {
            status = true;
            people.add(person);/*接收一個json格式的資料並將其新增到products列表中*/
        return status;

    }

    public void updatePerson(String id, Person updatedPerson) {
        people.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .ifPresent(person -> {
                    person.setName(updatedPerson.getName());
                    person.setAge(updatedPerson.getAge());
                });/*根據傳入的參數id，找到product中對應的id資料，並將原本的資料更改為傳入的資料*/
    }


    public void deletePerson(String id) {

        people.removeIf(person -> person.getId().equals(id));
    }/*如果product的id和傳入的參數id一樣的話，就刪除該筆資料*/

}
