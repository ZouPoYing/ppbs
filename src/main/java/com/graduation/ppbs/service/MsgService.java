package com.graduation.ppbs.service;

import com.graduation.ppbs.dao.Msg;
import com.graduation.ppbs.mapper.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MsgService {

    @Autowired(required = false)
    private MsgMapper msgMapper;

    public List<Msg> queryAllMsg() throws Exception {
        return msgMapper.queryAllMsg();
    }

    public void addMsg(Integer auditid, String msg, Integer msgtype) throws Exception {
        msgMapper.addMsg(auditid,msg,msgtype);
    }

    public List<Map<String, Object>> queryMsg1(Integer userid) throws Exception {
        return msgMapper.queryMsg1(userid);
    }

    public List<Map<String, Object>> queryMsg2(Integer userid) throws Exception {
        return msgMapper.queryMsg2(userid);
    }
}
