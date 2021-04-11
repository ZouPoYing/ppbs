package com.graduation.ppbs.mapper;

import com.graduation.ppbs.dao.File;
import com.graduation.ppbs.dao.Msg;
import org.apache.ibatis.annotations.*;

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

    @Select("select msg.msg as msg,audit.state as state,msg.date as date from msg left join audit on " +
            "msg.auditid=audit.auditid left join user on audit.committerid=user.userid where " +
            "audittype=1 and userid=#{userid} order by msg.date desc")
    @Results({
            @Result(property = "state", column = "state"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "date", column = "date")})
    public List<Map<String, Object>> queryMsg1(Integer userid);

    @Select("select msg.msg as msg,audit.state as state,msg.date as date from msg left join audit on " +
            "msg.auditid=audit.auditid left join user on audit.committerid=user.userid where " +
            "audittype=2 and userid=#{userid} order by msg.date desc")
    @Results({
            @Result(property = "state", column = "state"),
            @Result(property = "msg", column = "msg"),
            @Result(property = "date", column = "date")})
    public List<Map<String, Object>> queryMsg2(Integer userid);

}
