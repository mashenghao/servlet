package cn.mh.p6;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BeanUtil {

	/**
	 * 初步封装User对象，封装值是string类型
	 * 
	 * @param user
	 * @param map
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void populate_A(User user, Map<String, String> map)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		// 通过反射获取属性
		Class clazz = user.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Map<String, String> fieldsMap = new HashMap<>();
		for (Field field : fields) {
			fieldsMap.put(field.getName(), map.get(field.getName()));
		}
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			String key = setName2FieldName(methodName);
			if (!methodName.startsWith("get") && key != null) {
				String val = map.get(key);
				if (val != null) {
					method.invoke(user, val);
				}
			}
		}
	}

	/**
	 * 封装实体对象,支持多种类型
	 * 
	 * @param user
	 * @param map
	 * @throws Exception
	 */
	public static void populate_B(Object user, Map<String, Object> map) throws Exception {
		// 通过反射获取属性
		Class clazz = user.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Map<String, Object> fieldsMap = new HashMap<>();
		for (Field field : fields) {
			fieldsMap.put(field.getName(), map.get(field.getName()));
		}
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			String key = setName2FieldName(methodName);
			if (!methodName.startsWith("get") && key != null) {
				Object val = map.get(key);
				if (val != null) {
					method.invoke(user, val);
				}
			}
		}
	}

	private static String setName2FieldName(String methodName) {
		if (methodName.length() > 3) {
			String _key = methodName.substring(4, methodName.length());
			char firstCh = methodName.charAt(3);
			return firstCh < 97 ? ((char) (firstCh + 32)) + _key : ((char) firstCh) + _key;
		}
		return null;
	}

	public static void main(String[] args) throws Exception, IllegalAccessException {
		User user = new User();
		Map<String, String> map = new HashMap<>();

		map.put("name", "mahao");
		map.put("pwd", "密码"); 
		map.put("sex", "1");
		populate_A(user, map);
		System.out.println(user);
	}

	@Test
	public void test1() {
		char ch = 'A';
		ch += 32;
		System.out.println((int) ch);

		char ch2 = 'a';
		System.out.println((int) ch2);
	}

	@Test
	public void test2() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "mahap");
		map.put("age", 18);
		User user = new User();
		user.setName("对对象.name");
		map.put("user", user);
		Object object = map.get("user");
		System.out.println(object.getClass());
		User user2 = new User();
		populate_B(user, map);
		System.out.println(user);
	}
}
