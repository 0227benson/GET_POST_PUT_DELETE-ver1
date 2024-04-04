package com.example.get_post_put_delete2.Response;

import com.example.get_post_put_delete2.product.Person;

public class Get_Api_Response extends Common_Response{
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
