package cn.mh.p6;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Commons_beanUtilsTest {

	public static void main(String[] args) {
		User user = new User();
		Map<String, Object> map = new HashMap<>();

		map.put("name", "mahao");
		map.put("pwd", "密码");
		map.put("age", 18);

		try {
			BeanUtils.populate(user, map);
			System.out.println(user);
			User user2 = new User();
			BeanUtil.populate_B(user2, map);
			System.out.println(user2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
