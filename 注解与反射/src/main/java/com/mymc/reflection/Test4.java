package com.mymc.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test4 {
    public void  test1(Map<String,Integer> map, List<Integer> list){
        System.out.println("test1");
    }
    public  Map<String,Integer> test2(){
        System.out.println("test2");
        return null;
    }
    public static void main(String[] args) throws Exception {
        //获得参数类型
        Method method = Test4.class.getMethod("test1", Map.class, List.class);
        //获得参数类型即Map和List
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#"+genericParameterType);
            if (genericParameterType instanceof ParameterizedType){
                //获得Map和List中的泛型类型
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("    "+actualTypeArgument);
                }
            }
        }

        //获得返回值类型
        method =Test4.class.getMethod("test2",null);
        Type genericReturnType = method.getGenericReturnType();
        System.out.println("#"+genericReturnType);
        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("    "+actualTypeArgument);
            }
        }
    }
}
