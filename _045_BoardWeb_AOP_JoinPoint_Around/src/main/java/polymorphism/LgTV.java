package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
@Component의 상속을 받은 어노테이션
@Service
@Repository
@Controller
*/

@Component("tv")
public class LgTV implements TV {
	
	@Autowired
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성...");
	}
	
	public void powerOn() {
		System.out.println("LgTV -- 전원 켠다");
	}
	public void powerOff() {
		System.out.println("LgTV -- 전원 끈다");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
