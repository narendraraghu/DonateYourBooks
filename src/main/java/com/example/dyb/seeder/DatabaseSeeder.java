package com.example.dyb.seeder;

import com.example.dyb.model.Books;
import com.example.dyb.model.User;
import com.example.dyb.repository.BooksRepository;
import com.example.dyb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private BooksRepository booksRepository;

    private UserRepository userRepository;

    @Autowired
    public DatabaseSeeder(BooksRepository booksRepository,UserRepository userRepository)  {
        this.booksRepository = booksRepository;
        this.userRepository = userRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        booksRepository.save( new Books(5433,"Core and Advance Java","R. Nageswara Rao", 800));
        booksRepository.save(new Books(234,"Programming with Java","R. E. Balagurusamy", 350));
        booksRepository.save( new Books(425,"Data Structures and Algorithms in Java","Robert Lafore", 542));
        booksRepository.save(new Books(542,"C++","Test1Author", 810));
        booksRepository.save(new Books(874,"C","Test2Author", 2000));
        booksRepository.save(new Books(236,"ML and Advance ML","Test4Author", 800));

//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        java.util.Date dob = df.parse("12-08-1989");
        User user1 = new User();
        user1.setFirstName("Devglan");
        user1.setLastName("Devglan");
        user1.setSalary(12345);
        user1.setAge(23);
        user1.setUsername("devglan");
        user1.setPassword("devglan");
        userRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("John");
        user2.setLastName("Doe");
        user2.setSalary(4567);
        user2.setAge(34);
        user2.setUsername("john");
        user2.setPassword("john");
        userRepository.save(user2);
  }
}



