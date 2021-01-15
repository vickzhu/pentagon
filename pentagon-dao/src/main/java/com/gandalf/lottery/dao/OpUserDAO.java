package com.gandalf.lottery.dao;

import java.util.List;

import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.entity.OpUser;
import com.gandalf.lottery.dao.entity.OpUserExample;

public interface OpUserDAO {

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    void insert(OpUser record);

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    int updateByPrimaryKey(OpUser record);

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    int updateByPrimaryKeySelective(OpUser record);

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    List selectByExample(OpUserExample example);

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    OpUser selectByPrimaryKey(Long userId);

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    int deleteByExample(OpUserExample example);

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    int countByExample(OpUserExample example);

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    int updateByExampleSelective(OpUser record, OpUserExample example);

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    int updateByExample(OpUser record, OpUserExample example);

    PaginationQueryList<OpUser> selectByPagination(OpUserExample example);
}
