package com.example.get_post_put_delete2.product;

public class Person {
    private String id;
    private String name;
    private int age;/*定義屬性名稱和資料型態*/


    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /*設定getter and setter，
    getter負責將private的資料傳出到外部，也就是外部的物件可以透過getter得到private屬性的資料
    setter正好相反，負責接收外部的資料，並將處理過後的資料傳遞給private變數*/
    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {

        this.age = age;
    }

    @Override
    public String toString() {/*使用toString方法方便調試和提高程式碼可讀性*/
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public boolean isValid() {
        boolean valid = true;

        if (this.id.isEmpty() || this.name.isEmpty() || this.age == 0) {
            valid = false;
        }

        return valid;
    }
}
