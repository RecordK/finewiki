package net.javaguides.springboot;

import net.javaguides.springboot.model.BoardVo;
import net.javaguides.springboot.model.MemberVo;
import net.javaguides.springboot.repository.BoardVoRepository;
import net.javaguides.springboot.repository.MemberVoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private MemberVoRepository mR;

	@Autowired
	private BoardVoRepository bR;

	@Override
	public void run(String... args) throws Exception {
		MemberVo vo = new MemberVo();
		vo.setMem_id("새싹남");
		vo.setPw("1234");
		vo.setName("김기록");
		vo.setNick("티1라노");
		vo.setEmail("kakao");
		vo.setBirth("940729");
		mR.save(vo);

//		BoardVo vo1 = new BoardVo();
//		vo1.setBoard_no(1);
//		vo1.setHit(1234);
//		vo1.setTitle("네이버가 짱이다");
//		vo1.setMem_nick("티라노");
//		vo1.setContent("크아아ㅏ앙");
//		vo1.setRegdate("220112");
//
//		bR.save(vo1);

//		MemberVo vo1=new MemberVo();
//		vo1.setMem_id("새싹남");
//		vo1.setPw("1234");
//		vo1.setNick("ㅎㅎㅎ");
//		vo1.setName("김승헌");
//		vo1.setEmail("naver");
//		vo1.setBirth("940809");
//		mR.save(vo1);
	}
}
