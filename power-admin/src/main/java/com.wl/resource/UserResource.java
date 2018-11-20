package com.wl.resource;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wl.core.UserService;
import com.wl.domain.User;
import com.wl.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  接口控制器
 * </p>
 *
 * @author 江苏博沣
 * @since 2018-08-08
 */

@Controller
public class UserResource {
    @Autowired
    private UserService userService;
    /**
     * 分页列表
     *
     */
    @RequestMapping("/a")
    public String a() {
        return "index";
    }
    /**
     * 分页列表
     *
     */
    @RequestMapping("/page")
    @ResponseBody
    public Result pageUser(Page<User> page, User user) {
        EntityWrapper<User> ew = new EntityWrapper<User>(user);
        page = userService.selectPage(page,ew);
        return Result.success(page);
    }

    /**
     * 新增
     *
     * @param user User实例
     */
    @PostMapping("/insert")
    public Result insertUser(@RequestBody User user) {
        userService.insert(user);
        return Result.success();
    }

    /**
     * 根据id获取
     *
     * @param id User.id
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Result getUser(@PathVariable Serializable id) {
        User user = userService.selectById(id);
        return Result.success(user);
    }

    /**
     * 修改
     *
     * @param id User.id
     * @param user User实例
     */
    @PutMapping("/{id}/update")
    public Result updateUser(@PathVariable Serializable id, @RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }

    /**
     * 批量删除
     *
     * @param ids User id列表
     */
    @DeleteMapping("/delete/batch")
    public Result deletedBatchUsers(@RequestBody List<Serializable> ids){
        if(ids == null || ids.size() == 0){
            return Result.fail("请至少选择一项进行删除！");
        }

        userService.deleteBatchIds(ids);
        return Result.success();
    }
}

