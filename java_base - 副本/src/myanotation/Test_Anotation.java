package myanotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test_Anotation {
    public static void main(String[] args) throws Exception{
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("lucy");

        Filter f3 = new Filter();
        f3.setEmail("bysu@qq.com");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);
        System.out.println(sql1);

    }

    public static String query(Filter f) throws Exception{
        //1.获取到class
        Class c = f.getClass();
        //2.获取table的名字
        boolean exists = c.isAnnotationPresent(Table.class);
        if (!exists){
            return null;
        }
        Table t = (Table)c.getAnnotation(Table.class);
        String value = t.value();

        //3.遍历所有字段
        Field[] fArray = c.getDeclaredFields();
        for (Field field : fArray){
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists){
                return null;
            }
            //4.1拿到字段名
            Column col = field.getAnnotation(Column.class);
            System.out.println(col.value());
            //4.2拿到字段值
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
            Method getMethod = c.getMethod(getMethodName);
            Object fieldValue = getMethod.invoke(f);
            System.out.println("field_name:" + fieldValue);
        }
        return value;
    }
}
