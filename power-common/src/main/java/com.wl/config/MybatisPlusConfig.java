package com.wl.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author 王老板
 * @Description
 * @Date Create in 2017/12/29 10:34
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.wl.dao")
public class MybatisPlusConfig {

    /**
     * SQL执行效率插件【生产环境可以关闭】
     */
   /* @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }*/

    /**
     * sql执行分析插件 【生产环境可以关闭】
     * @return
     */
    /*@Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public SqlExplainInterceptor sqlExplainInterceptor() {
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        sqlExplainInterceptor.setStopProceed(true);
        return sqlExplainInterceptor;
    }*/

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLocalPage(true);
        return paginationInterceptor;
    }

    /**
     * 乐观锁插件
     *
     * @return
     */
    /*@Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }*/
}

