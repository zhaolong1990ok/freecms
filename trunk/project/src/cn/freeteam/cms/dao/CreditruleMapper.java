package cn.freeteam.cms.dao;

import cn.freeteam.cms.model.Creditrule;
import cn.freeteam.cms.model.CreditruleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditruleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    int countByExample(CreditruleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    int deleteByExample(CreditruleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    int insert(Creditrule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    int insertSelective(Creditrule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    List<Creditrule> selectByExample(CreditruleExample example);
    List<Creditrule> selectByExampleCache(CreditruleExample example);
    List<Creditrule> selectPageByExample(CreditruleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    Creditrule selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    int updateByExampleSelective(@Param("record") Creditrule record, @Param("example") CreditruleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    int updateByExample(@Param("record") Creditrule record, @Param("example") CreditruleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    int updateByPrimaryKeySelective(Creditrule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_creditrule
     *
     * @mbggenerated Mon Feb 04 19:47:47 CST 2013
     */
    int updateByPrimaryKey(Creditrule record);
}