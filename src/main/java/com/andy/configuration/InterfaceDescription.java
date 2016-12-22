package com.andy.configuration;

import com.andy.annotation.MethodDescription;
import com.andy.annotation.ParamterDescription;
import org.reflections.Reflections;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * 接口描述
 *
 * Created by andy on 2016/12/21.
 */
public class InterfaceDescription {

    private static class Instance{
        private static final Reflections INSTANCE = new Reflections("");
    }

    /**
     * 获取接口信息
     * @return
     */
    public static List<InterfaceMessage> getInterfaceDescription(){
        Reflections reflections = InterfaceDescription.Instance.INSTANCE;
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Controller.class);
        annotated.addAll(reflections.getTypesAnnotatedWith(RestController.class));
        List<InterfaceMessage> interfaces = new ArrayList<InterfaceMessage>();
        for (Class<?> controller : annotated) {
            Method[] methods = controller.getMethods();
            String pref = getClassUrl(controller);
            for(Method method : methods) {
                String suff = getMethodUrl(method);
                String description  = getMethodDescrption(method);
                Map<String,String> paramterInfo = getParamterInfo(method);
                String author = getMethodAuthor(method);
                if(suff != null && suff.length()>0 && !"".equals(suff)){
                    interfaces.add(new InterfaceMessage.Builder().setUrl(pref+suff)
                            .setDescription(description)
                            .setAuthor(author)
                            .setParamterInfo(paramterInfo).build());
                }
            }
        }
        return interfaces;
    }

    /**
     * 获取方法路径
     * @param method
     * @return
     */
    private static String getMethodUrl(Method method){

        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
        return requestMapping != null ? requestMapping.value()[0]: "";
    }

    /**
     * 获取类路径
     * @param clazz
     * @return
     */
    private static String getClassUrl(Class clazz){
        RequestMapping requestMapping = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
        return requestMapping != null?requestMapping.value()[0]:"";
    }

    /**
     * 获取参数信息
     * @param method
     * @return
     */
    private static Map<String,String> getParamterInfo(Method method){
        Parameter[] parameters = method.getParameters();
        Map<String,String> resultMap = new HashMap<String, String>();
        for(Parameter parameter : parameters){
            ParamterDescription paramterDescription = parameter.getAnnotation(ParamterDescription.class);
            if(paramterDescription != null){
                resultMap.put("".equals(paramterDescription.name())?parameter.getName():paramterDescription.name(),paramterDescription.description());
            }
        }
        return resultMap;
    }

    /**
     * 获取方法信息
     * @param method
     * @return
     */
    private static String getMethodDescrption(Method method){
        MethodDescription methodDescription = method.getAnnotation(MethodDescription.class);
        return methodDescription != null?methodDescription.description():"";
    }

    /**
     * 获取方法信息
     * @param method
     * @return
     */
    private static String getMethodAuthor(Method method){
        MethodDescription methodDescription = method.getAnnotation(MethodDescription.class);
        return methodDescription != null?methodDescription.author():"";
    }

}
