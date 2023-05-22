package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CallProcedureService {

    @Autowired
    private JdbcOperations jdbcTemplate;

    public Object callProcedure(final String callStr, final Object[] inValues,
                                final int[] outTypes) {

        return jdbcTemplate.execute(callStr, (CallableStatement cs)->{
                int i = 0;
                if (inValues != null) {
                    //入参设置
                    for (int index = 0; index < inValues.length; index++) {
                        i++;
                        Object inValue = inValues[index];
                        if (inValue instanceof StringBuffer
                                || inValue instanceof StringWriter) {
                            cs.setString(i, inValue.toString());
                        } else if ((inValue instanceof java.util.Date)
                                && !(inValue instanceof java.sql.Date
                                || inValue instanceof java.sql.Time || inValue instanceof java.sql.Timestamp)) {
                            cs.setTimestamp(i, new java.sql.Timestamp(
                                    ((java.util.Date) inValue)
                                            .getTime()));
                        } else if (inValue instanceof Calendar) {
                            Calendar cal = (Calendar) inValue;
                            cs.setTimestamp(i, new java.sql.Timestamp(
                                    cal.getTime().getTime()));
                        } else {
                            // Fall back to generic setObject call
                            // without SQL type specified.
                            cs.setObject(i, inValue);
                        }
                    }
                }
                //出参设置
                if (outTypes != null) {
                    for (int index = 0; index < outTypes.length; index++) {
                        i++;
                        cs.registerOutParameter(i, outTypes[index]);
                    }
                }

                boolean retVal = cs.execute();
                int updateCount = cs.getUpdateCount();

                if (retVal || updateCount != -1) {
                    // Map returnedResults = new HashMap();
                    // returnedResults.putAll(extractReturnedResultSets(cs,
                    // declaredParameters, updateCount));
                }
                if (outTypes == null || outTypes.length <= 0) {
                    return null;
                } else if (outTypes.length == 1) {
                    return cs.getObject(i);
                } else {
                    List results = new ArrayList();
                    // 依次返回结果
                    for (int index = 0; index < outTypes.length; index++) {
                        results.add(cs.getObject(inValues.length
                                + index + 1));

                    }
                    return results;
                }

            }
        );
    }

    //执行带参带返回值的存储过程
    public Object getTotalCountProc1(int deptno,String ename){
        //定义一个变量来接收结果
        int totalCount=0;
        String sql="{call getEmpCount(?,?,?)}";
        //建立连接
        return jdbcTemplate.execute(sql,(CallableStatement proc)->{//声明CallableStatement对象
            //设置占位符
            //Object [] params={deptno,ename};
            //只设置输入参数即可
            proc.setInt(1, deptno);
            proc.setString(2, ename);
            //proc.setInt(3, totalCount);
            //将数据库对象数据类型注册为java中的类型，将输出参数转换
            proc.registerOutParameter(3, Types.INTEGER);
            //执行
            boolean retVal = proc.execute();
            int updateCount = proc.getUpdateCount();
            return proc.getObject(3);
        });
    }
}
