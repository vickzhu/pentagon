package com.gandalf.lottery.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.stereotype.Repository;

import com.gandalf.framework.ibatis.GandalfSqlMapClientDaoSupport;
import com.gandalf.framework.ibatis.PaginationQueryList;
import com.gandalf.lottery.dao.OpUserDAO;
import com.gandalf.lottery.dao.entity.OpUser;
import com.gandalf.lottery.dao.entity.OpUserExample;

@Repository
public class OpUserDAOImpl extends GandalfSqlMapClientDaoSupport implements OpUserDAO {

    @Resource(name = "opUserIncrementer")
    private DataFieldMaxValueIncrementer keyIncrementer;

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public OpUserDAOImpl() {
        super();
    }

    public void insert(OpUser record) {
        if (record.getUserId() == null) {
            record.setUserId(keyIncrementer.nextLongValue());
        }
        getSqlMapClientTemplate().insert("op_user.abatorgenerated_insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public int updateByPrimaryKey(OpUser record) {
        int rows = getSqlMapClientTemplate().update("op_user.abatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public int updateByPrimaryKeySelective(OpUser record) {
        int rows = getSqlMapClientTemplate().update("op_user.abatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public List selectByExample(OpUserExample example) {
        List list = getSqlMapClientTemplate().queryForList("op_user.abatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public OpUser selectByPrimaryKey(Long userId) {
        OpUser key = new OpUser();
        key.setUserId(userId);
        OpUser record = (OpUser) getSqlMapClientTemplate().queryForObject("op_user.abatorgenerated_selectByPrimaryKey",
                                                                          key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public int deleteByExample(OpUserExample example) {
        int rows = getSqlMapClientTemplate().delete("op_user.abatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public int deleteByPrimaryKey(Long userId) {
        OpUser key = new OpUser();
        key.setUserId(userId);
        int rows = getSqlMapClientTemplate().delete("op_user.abatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public int countByExample(OpUserExample example) {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("op_user.abatorgenerated_countByExample",
                                                                           example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public int updateByExampleSelective(OpUser record, OpUserExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("op_user.abatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    public int updateByExample(OpUser record, OpUserExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("op_user.abatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS. This class corresponds to the database table op_user
     * 
     * @abatorgenerated
     */
    private static class UpdateByExampleParms extends OpUserExample {

        private Object record;

        public UpdateByExampleParms(Object record, OpUserExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.gandalf.lottery.dao.OpUserDAO#selectByPagination(com.gandalf.framework.ibatis.BaseQuery,
     * com.gandalf.lottery.dao.entity.OpUserExample)
     */
    @Override
    public PaginationQueryList<OpUser> selectByPagination(OpUserExample example) {
        return getSqlMapClientTemplate().queryForPagination("op_user.abatorgenerated_countByExample",
                                                            "op_user.selectByPagination", example);
    }
}
