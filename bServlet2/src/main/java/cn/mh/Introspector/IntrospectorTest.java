package cn.mh.Introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 内省测试
 *
 * @author mahao
 * @date 2019年4月14日 下午11:29:14
 */
public class IntrospectorTest {
	
	public static void main(String[] args) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User u = new User();
		//获取类的信息
		BeanInfo beanInfo = Introspector.getBeanInfo(u.getClass());
		//获取属性的描述
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : descriptors) {
			System.out.println(pd);
			if(!"class".equals(pd.getName())){
				// 获取写的方法
				Method m = pd.getWriteMethod();
				m.invoke(u, "admin");
			}
		}
		System.out.println(u.toString());
		demo2();
	}
	
	public static void demo2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User u = new User();
		Class<? extends User> clazz = u.getClass();
		String name = clazz.getName();
		System.out.println(name);
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field.getName());
		} 
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println(method.getName());
			if("setName".equals(method.getName())) {
				method.invoke(u, "名字");
			}
		}
		System.out.println(u);
	}
}
