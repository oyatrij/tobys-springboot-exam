package tobyspringboot.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tobyspringboot.exam.user.dao.UserDao;
import tobyspringboot.exam.user.domain.User;

import java.sql.SQLException;

@SpringBootApplication
public class ExamApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ExamApplication.class, args);
		UserDao dao = new UserDao();

		User user = new User();
		user.setId("gotDex");
		user.setName("이재민");
		user.setPassword("married");

		try {
			dao.add(user);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		System.out.println(user.getId() + " 등록성공!");

		User user2 = null;
		try {
			user2 = dao.get(user.getId());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + " 조회성공!");
	}
}
