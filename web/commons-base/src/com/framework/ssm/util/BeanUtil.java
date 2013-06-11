package com.framework.ssm.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

/**
 * 扩展Apache Commons BeanUtils, 提供一些反射方面缺失功能的封装.
 */
@SuppressWarnings("unchecked")
public class BeanUtil extends BeanUtils {
    
    private static Logger log = LoggerFactory.getLogger(BeanUtil.class);
    
    /**
     * 
     * <ul>
     * <li>author jinyifeng5969@163.com</li>
     * <li>createDate: Aug 19, 2010 2:10:46 PM</li>
     * <li>comment:</li>
     * <p>
     * 根据对象强制取给定方法的返回值（适用无参数有返回值的方法）
     * </p>
     * </ul>
     * 
     * @param obj
     * @param methodName
     * @return
     */
    public static Object forceGetValueByMethodName(Object obj, String methodName) {
        Assert.notNull(obj);
        Assert.hasText(methodName);
        Class c = obj.getClass();
        try {
            Method m = c.getDeclaredMethod(methodName);
            return m.invoke(obj);
        } catch (NoSuchMethodException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
    
    /**
     * 循环向上转型,获取对象的DeclaredField.
     * 
     * @throws NoSuchFieldException 如果没有该Field时抛出.
     */
    public static Field getDeclaredField(Object object, String propertyName) throws NoSuchFieldException {
        Assert.notNull(object);
        Assert.hasText(propertyName);
        return getDeclaredField(object.getClass(), propertyName);
    }
    
    /**
     * 循环向上转型,获取对象的DeclaredField.
     * 
     * @throws NoSuchFieldException 如果没有该Field时抛出.
     */
    public static Field getDeclaredField(Class clazz, String propertyName) throws NoSuchFieldException {
        Assert.notNull(clazz);
        Assert.hasText(propertyName);
        for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {
                log.error(e.getMessage(), e);
            }
        }
        throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + propertyName);
    }
    
    /**
     * 暴力获取对象变量值,忽略private,protected修饰符的限制.
     * 
     * @throws NoSuchFieldException 如果没有该Field时抛出.
     */
    public static Object forceGetProperty(Object object, String propertyName) throws NoSuchFieldException {
        Assert.notNull(object);
        Assert.hasText(propertyName);
        Field field = getDeclaredField(object, propertyName);
        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        Object result = null;
        try {
            result = field.get(object);
        } catch (IllegalAccessException e) {
            log.info("error wont' happen");
        }
        field.setAccessible(accessible);
        return result;
    }
    
    /**
     * 暴力设置对象变量值,忽略private,protected修饰符的限制.
     * 
     * @throws NoSuchFieldException 如果没有该Field时抛出.
     */
    public static void forceSetProperty(Object object, String propertyName, Object newValue)
            throws NoSuchFieldException {
        Assert.notNull(object);
        Assert.hasText(propertyName);
        Field field = getDeclaredField(object, propertyName);
        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        try {
            field.set(object, newValue);
        } catch (IllegalAccessException e) {
            log.info("Error won't happen");
        }
        field.setAccessible(accessible);
    }
    
    /**
     * 暴力调用对象函数,忽略private,protected修饰符的限制.
     * 
     * @throws NoSuchMethodException 如果没有该Method时抛出.
     */
    public static Object invokePrivateMethod(Object object, String methodName, Object... params)
            throws NoSuchMethodException {
        Assert.notNull(object);
        Assert.hasText(methodName);
        Class[] types = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            types[i] = params[i].getClass();
        }
        Class clazz = object.getClass();
        Method method = null;
        for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                method = superClass.getDeclaredMethod(methodName, types);
                break;
            } catch (NoSuchMethodException e) {
                // 方法不在当前类定义,继续向上转型
            }
        }
        if (method == null) {
            throw new NoSuchMethodException("No Such Method:" + clazz.getSimpleName() + methodName);
        }
        boolean accessible = method.isAccessible();
        method.setAccessible(true);
        Object result = null;
        try {
            result = method.invoke(object, params);
        } catch (Exception e) {
            ReflectionUtils.handleReflectionException(e);
        }
        method.setAccessible(accessible);
        return result;
    }
    
    /**
     * 按Filed的类型取得Field列表.
     */
    public static List<Field> getFieldsByType(Object object, Class type) {
        List<Field> list = new ArrayList<Field>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().isAssignableFrom(type)) {
                list.add(field);
            }
        }
        return list;
    }
    
    /**
     * 按FiledName获得Field的类型.
     */
    public static Class getPropertyType(Class type, String name) throws NoSuchFieldException {
        return getDeclaredField(type, name).getType();
    }
    
    /**
     * 获得field的getter函数名称.
     */
    public static String getGetterName(Class type, String fieldName) {
        Assert.notNull(type, "Type required");
        Assert.hasText(fieldName, "FieldName required");
        if (type.getName().equals("boolean")) {
            return "is" + StringUtils.capitalize(fieldName);
        } else {
            return "get" + StringUtils.capitalize(fieldName);
        }
    }
    
    /**
     * 获得field的getter函数,如果找不到该方法,返回null.
     */
    public static Method getGetterMethod(Class type, String fieldName) {
        try {
            return type.getMethod(getGetterName(type, fieldName));
        } catch (NoSuchMethodException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
    
    /**
     * 通用toString方法
     * 
     * @param bean Object
     * @return String
     */
    public static String beanToString(Object bean) {
        StringBuffer sb = new StringBuffer(0);
        if (null == bean) {
            return sb.toString();
        }
        
        Class c = bean.getClass();
        Field[] fields = c.getDeclaredFields();
        sb.append(c.getSimpleName() + '[');
        try {
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                sb.append(f.getName());
                sb.append('=');
                Object field = f.get(bean);
                if (field instanceof Object[]) {
                    Object[] obj = (Object[]) field;
                    sb.append(arrayToString(obj));
                } else {
                    String str = f.getName().toLowerCase();
                    if ("password".equals(str) || "pwd".equals(str) || "newpswd".equals(str) || "oldpswd".equals(str)) {
                        sb.append("******");
                    } else {
                        sb.append(field);
                    }
                }
                sb.append(',');
            }
            if (sb.charAt(sb.length() - 1) <= ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
        }
        sb.append(']');
        return sb.toString();
        
    }
    
    /**
     * 对象数组toString
     * 
     * @param objs Object[] 对象数组
     * @return String 对象数组的字符串表达
     */
    public static String arrayToString(Object[] objs) {
        if (!ArrayUtils.isEmpty(objs)) {
            StringBuffer sb = new StringBuffer(0);
            sb.append("{");
            for (Object obj : objs) {
                sb.append(obj).append(',');
            }
            if (sb.charAt(sb.length() - 1) <= ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("}");
            return sb.toString();
        }
        return "{null}";
    }
    
    /**
     * 对象数组toString 如果对象为空 返回"";
     * 
     * @param objs Object[] 对象数组
     * @return String 对象数组的字符串表达
     */
    public static String arrayToString(String[] objs) {
        if (null != objs) {
            StringBuffer sb = new StringBuffer(0);
            for (String str : objs) {
                sb.append(str).append(',');
            }
            if (sb.charAt(sb.length() - 1) <= ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return "";
    }
    
    /**
     * arrayToString
     * 
     * @param objs 传入的数组元素
     * @param separator 数组元素的分割符号
     * @return String 生成的String
     */
    public static String arrayToString(String[] objs, char separator) {
        if (null != objs) {
            StringBuffer sb = new StringBuffer(0);
            for (String str : objs) {
                sb.append(str).append(separator);
            }
            if (sb.charAt(sb.length() - 1) <= separator) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
        return "";
    }
    
    /**
     * arrayToString
     * 
     * @param objs int[]
     * @return String
     */
    public static String arrayToString(int[] objs) {
        if (null != objs) {
            StringBuffer sb = new StringBuffer(0);
            sb.append("{");
            for (int i : objs) {
                sb.append(i).append(',');
            }
            if (sb.charAt(sb.length() - 1) <= ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("}");
            return sb.toString();
        }
        return "{null}";
    }
    
    public static Map describe(Object bean) {
        Map map = new HashMap<String, Object>();
        try {
            map = BeanUtils.describe(bean);
        } catch (IllegalAccessException e) {
            log.warn(bean.toString(), e);
        } catch (InvocationTargetException e) {
            log.warn(bean.toString(), e);
        } catch (NoSuchMethodException e) {
            log.warn(bean.toString(), e);
        }
        return map;
    }
}