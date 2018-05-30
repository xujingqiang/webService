package com.mr;

import com.mr.model.User;
import javafx.stage.Modality;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2018/5/30.
 */
@Path("hello")//访问的路径
public class HelloService {


    @GET
    @Path("hello")
    public void test1(){
        System.out.println("滴滴滴");
    }

    /**
     * 通过get方法接受参数
     * @param id
     */
    @GET
    @Path("hello/{id}")
    public void test2(@PathParam("id") Integer id){
        System.out.println("接受到的参数="+id);
    }

    /**
     * 通过id查询数据
     * @param id
     */
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("get/{id}")
    public User test3(@PathParam("id") Integer id){
        User user = new User(id,"猪猪猪");
        return user;
    }

    @POST
    @Path("/hello")
    public void test4(){
        System.out.println("post");
    }

    /**
     * Post传递参数
     * @param id
     */
    @POST
    @Path("/hello/{id}")
    public void test5(@PathParam("id") Integer id){
        System.out.println("post="+ id);
    }

    /**
     * Post传递参数
     * @param name
     */
    @POST
    @Path("/name")
    public void test6(@QueryParam("name") String name){
        System.out.println("post..."+ name);
    }

    /**
     * Post传递参数
     * @param name
     */
    @POST
    @Path("/name")
    @Consumes(MediaType.APPLICATION_JSON) // 用于传递进来参数为json类型
    public void test7(String name){
        System.out.println("post..."+ name);
    }

    @POST//表示是post访问
    @Path("/helloUser")
    @Consumes(MediaType.APPLICATION_JSON)//传入参数的类型为json
    @Produces(MediaType.APPLICATION_JSON)//返回参数的类型为json
    public User test8(User user){
        System.out.println(user);
        System.out.println("hello POST ....");
        return user;
    }
}
