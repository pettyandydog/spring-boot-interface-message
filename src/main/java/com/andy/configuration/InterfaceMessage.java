package com.andy.configuration;

/**
 * Created by andy on 2016/12/21.
 */

import java.util.Map;

/**
 * 接口信息
 */
public class InterfaceMessage{
    private String url; //路径
    private String description; //描述
    private String author;//作者
    private Map<String,String> paramterInfo;//参数信息

    public static class Builder{
        private String url;
        private String description;
        private String author;
        private Map<String,String> paramterInfo;

        public Builder setUrl(String url){
            this.url = url;
            return this;
        }
        public Builder setDescription(String description){
            this.description = description;
            return this;
        }
        public Builder setAuthor(String author){
            this.author = author;
            return this;
        }
        public Builder setParamterInfo(Map<String,String> paramterInfo){
            this.paramterInfo = paramterInfo;
            return this;
        }
        public InterfaceMessage build(){
            InterfaceMessage interfaceMessage = new InterfaceMessage();
            interfaceMessage.url = this.url;
            interfaceMessage.description = this.description;
            interfaceMessage.author = this.author;
            interfaceMessage.paramterInfo = this.paramterInfo;
            return interfaceMessage;
        }
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getParamterInfo() {
        return paramterInfo;
    }

    public String getAuthor() {
        return author;
    }

}
