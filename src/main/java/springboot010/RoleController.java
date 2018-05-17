package springboot010;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 添加此注解后，表明该类下的所有方法都将默认返回时字符窜，而不用在每个方法上面添加@RestController注解
 * @author Administrator
 *
 */
@RestController
public class RoleController {

	@GetMapping("/roleController/serverInfo")
	public String serverInfo() {
		return "serverInfo";
	}
	
}
