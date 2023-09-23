package vn.hieuminh.spring6.Project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.hieuminh.spring6.Project.dao.UserRepository;
import vn.hieuminh.spring6.Project.entity.School;
import vn.hieuminh.spring6.Project.entity.User;
import vn.hieuminh.spring6.Project.service.MyService;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//	@Bean
//	public CommandLineRunner commandLineRunner(MyService myService){
//		return runner->{
//			getAllUser(myService);
//		};
//	}

	public void getAllUser(MyService myService){
		List<User> list = myService.getAllUser();
		System.out.println(list);
	}
//	private void creatUser(UserRepository userRepository) {
//		User user = new User();
//		user.setEnable(true);
//		user.setUsername("admin");
//		user.setPassword("{bcrypt}$2a$12$VXkNSdadJItNTpNgdAac5eMXcuGU9TBFy1PFBf3AQzZtqVeDpNXqW");
//		user.setRole("ROLE_ADMIN");
//
//		userRepository.saveAndFlush(user);
//		System.out.println("done");
//	}

//	private void createSchool(MyService myService) {
//		School school = new School();
//		school.setName("THCS Dinh Cong Trang");
//		school.setAddress("Thanh Luu");
//
//		myService.save(school);
//		System.out.println("done");
//	}


}
