package com.graduation.ppbs.mapper;

import com.graduation.ppbs.dao.File;
import com.graduation.ppbs.dao.Msg;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface MsgMapper {

    @Select("SELECT * FROM MSG")
    @Results({
            @Result(property = "msgid", column = "msgid"),
            @Result(property = "auditid", column = "auditid"),
            @Result(property = "date", column = "date"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "msgtype", column = "msgtype")})
    List<Msg> queryAllMsg();

    @Insert("INSERT INTO MSG(AUDITID, MSG, MSGTYPE) VALUES (#{auditid}, #{msg}, #{msgtype})")
    @Results({
            @Result(property = "msgid", column = "msgid"),
            @Result(property = "auditid", column = "auditid"),
            @Result(property = "date", column = "date"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "msgtype", column = "msgtype")})
    void addMsg(Integer auditid, String msg, Integer msgtype);

    @Select("select msg.msgid as msgid,msg.msg as msg,(CASE msg.msgtype WHEN 0 THEN '退回' ELSE " +
            "'通过' END) as state,msg.date as date from msg left join audit on " +
            "msg.auditid=audit.auditid left join user on audit.committerid=user.userid where " +
            "audittype=1 and userid=#{userid} and msg.use=1 order by msg.date desc")
    @Results({
            @Result(property = "msgid", column = "msgid"),
            @Result(property = "state", column = "state"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "date", column = "date")})
    public List<Map<String, Object>> queryMsg1(Integer userid);

    @Select("select msg.msgid as msgid,msg.msg as msg,(CASE msg.msgtype WHEN 0 THEN '退回' ELSE " +
            "'通过' END) as state,msg.date as date from msg left join audit on " +
            "msg.auditid=audit.auditid left join user on audit.committerid=user.userid where " +
            "audittype=2 and userid=#{userid} and msg.use=1 order by msg.date desc")
    @Results({
            @Result(property = "msgid", column = "msgid"),
            @Result(property = "state", column = "state"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "date", column = "date")})
    public List<Map<String, Object>> queryMsg2(Integer userid);

    @Update("UPDATE MSG SET MSG.USE=0 WHERE MSGID=#{msgid}")
    void UpdateMsgUse(Integer msgid);

    @Insert("INSERT INTO MSG(AUDITID, MSG, isev) VALUES (#{auditid}, #{msg}, #{orderid})")
    @Results({
            @Result(property = "msgid", column = "msgid"),
            @Result(property = "auditid", column = "auditid"),
            @Result(property = "date", column = "date"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "msgtype", column = "msgtype")})
    void addMsg2(Integer auditid, String msg, Integer orderid);
}
