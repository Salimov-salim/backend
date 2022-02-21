package com.registry;

import com.registry.dto.ResponseDTO;
import com.registry.entity.Person;
import com.registry.entity.PersonAnnouncement;
import com.registry.repository.PersonRepository;
import com.registry.service.PersonAnnouncementService;
import com.registry.service.PersonEducationService;
import com.registry.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InternalRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternalRegistrationApplication.class, args);
    }



//    @Autowired
//	private PersonEducationService service;

//	@Bean
//	public CommandLineRunner run() {
//		CommandLineRunner clr = new CommandLineRunner(){
//
//			@Override
//			public void run(String... args) throws Exception {
//
//                ResponseDTO rs=service.getById(1);
//                System.out.println(rs.getObj());
////                PersonAnnouncement p=service.getById(1);
////                System.out.println(p.getFullname());
////				List<Person> list= service.getAll();
////                for (Person l :
////                        list) {
////                    System.out.println(l.getFathername());
////                }
////				System.out.println("list size="+list.size());
//			}
//		};
//
//		return clr;
//	}
}
