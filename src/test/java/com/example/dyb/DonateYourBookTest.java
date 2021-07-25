package com.example.dyb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DonateYourBook.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class DonateYourBookTest {
    @Test
    public void contextLoads() {
    }

}