package com.watimer.study.mail.reflect;

import org.junit.Test;
import sun.rmi.runtime.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/1/31
 */
public class ReflectClass {

    private final static String TAG = "peter.log.ReflectClass";



    @Test
    // 创建对象
    public void reflectNewInstance(){
        try {
            Class<?> classPhone = Class.forName("com.watimer.study.mail.reflect.Phone");
            Object objectPhone = classPhone.newInstance();
            Phone phone = (Phone) objectPhone;
            phone.setName("IPhone 11");
            phone.setColor("苹果绿");
            phone.setPrice(999);

            System.out.println("reflectNewInstance phone = " + phone.toString());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // 反射私有属性
    @Test
    public void reflectPrivateField(){
        try {
            Class<?> classPhone = Class.forName("com.watimer.study.mail.reflect.Phone");
            Object objectPhone = classPhone.newInstance();
            Field fieldTag = classPhone.getDeclaredField("TAG");

            fieldTag.setAccessible(true);

            String tag = (String) fieldTag.get(objectPhone);

            System.out.println("reflectPrivateField tag = " + tag);
        } catch (Exception ex) {

        }
    }

    // 反射私有方法
    @Test
    public void reflectPrivateMethod(){
        try {
            Class<?> classPhone = Class.forName("com.watimer.study.mail.reflect.Phone");
            Method objectMethod = classPhone.getDeclaredMethod("declaredMethod",int.class);
            objectMethod.setAccessible(true);
            Object objectPhone = classPhone.newInstance();
            String string = (String) objectMethod.invoke(objectPhone,2);
            System.out.println("reflectPrivateMethod string = " + string);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
