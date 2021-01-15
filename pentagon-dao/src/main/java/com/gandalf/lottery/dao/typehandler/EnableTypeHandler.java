/*
 * Copyright 2010-2014 onsean.com All right reserved. This software is the confidential and proprietary information of
 * onsean.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with onsean.com.
 */
package com.gandalf.lottery.dao.typehandler;

import java.sql.SQLException;
import java.sql.Types;

import com.gandalf.lottery.common.constant.EnableEnum;
import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * 是否可用
 * 
 * @author zhuxiaobing 2014-8-18 下午06:10:36
 */
public class EnableTypeHandler implements TypeHandlerCallback {

    /*
     * (non-Javadoc)
     * @see com.ibatis.sqlmap.client.extensions.TypeHandlerCallback#setParameter(com.ibatis.sqlmap.client.extensions.
     * ParameterSetter, java.lang.Object)
     */
    public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
        /*
         * 在sqlMap中配parameterMap的属性typeHandler和sqlMapConfig中配全局typeHandler时才会触发
         */
        if (null == parameter) {
            setter.setNull(Types.INTEGER); // 若没有传值则null,表字段不允许则异常
        } else {
            setter.setInt(((EnableEnum) parameter).getEnable());
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.ibatis.sqlmap.client.extensions.TypeHandlerCallback#getResult(com.ibatis.sqlmap.client.extensions.ResultGetter
     * )
     */
    public Object getResult(ResultGetter getter) throws SQLException {
        /*
         * 仅在sqlMap中配置resultMap的属性typeHandler和在sqlMapConfig中配全局typeHandler才会触发
         */
        Object result = null;
        // if (!getter.wasNull() && null != getter.getObject()) {
        // 上面有问题,修复如下.wasNull是判断前一个字段是否为null
        if (null != getter.getObject()) {
            result = EnableEnum.getEnable(getter.getInt());
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * @see com.ibatis.sqlmap.client.extensions.TypeHandlerCallback#valueOf(java.lang.String)
     */
    public Object valueOf(String s) {
        return EnableEnum.getEnable(Integer.valueOf(s));
    }

}
