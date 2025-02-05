package com.pfisoc.journalApp.service;

import com.pfisoc.journalApp.entity.User;
import com.pfisoc.journalApp.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;
    @Test
    public void testFindByUserName()
    {
        User user = userRepo.findByUserName("kiran");
        assertNotNull(user.getJournalEntries().isEmpty());
    }
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public  void test(int a,int b,int expected)
    {
        assertEquals(expected,a+b);
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user)
    {
        assertTrue(userService.saveNewUser(user));
    }



}
