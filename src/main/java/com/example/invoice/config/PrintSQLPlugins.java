package com.example.invoice.config;

import com.alibaba.druid.sql.SQLUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Classname PrintSQLPlugins
 * @Description TODO
 * @Date 2022/4/26 15:52
 * @Author by fuxf
 */
@Slf4j
@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = { Statement.class })})
public class PrintSQLPlugins implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        AtomicReference<String> sql = new AtomicReference<>(boundSql.getSql());
        List<ParameterMapping> parameters = boundSql.getParameterMappings();
        parameters.stream().forEach(t->{
            String property = t.getProperty();
            Object value = boundSql.getAdditionalParameter(property);
            String originally = sql.get();
            if(Objects.nonNull(value)) {
                sql.compareAndSet(originally, originally.replaceFirst("\\?", value.toString()));
            }
        });
        log.info("方法:{}",invocation.getMethod().getName());
        log.info("参数:{}",invocation.getArgs());
        log.info("结果:{}",invocation.getTarget());
        log.info("----------------------------【SQL】-------------------------------");

        log.info("\r\n"+SQLUtils.formatMySql(sql.get()));
        long beginTime = System.currentTimeMillis();
        // 放行，执行目标对象的对应方法
        Object proceed = invocation.proceed();
       long endTime = System.currentTimeMillis();
       log.info("----------------------------【SQL执行的时长为：{} s】", BigDecimal.valueOf(endTime - beginTime).divide(BigDecimal.valueOf(1000)).setScale(6, RoundingMode.DOWN).doubleValue());
       return proceed;

    }
}
