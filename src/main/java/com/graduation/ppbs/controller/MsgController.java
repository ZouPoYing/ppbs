package com.graduation.ppbs.controller;

import com.graduation.ppbs.dao.Msg;
import com.graduation.ppbs.service.AuditService;
import com.graduation.ppbs.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/msg")
@CrossOrigin(originPatterns = "*",allowCredentials ="true")
public class MsgController {

    @Autowired
    private MsgService msgService;

    public List<Msg> queryAllMsg() throws Exception {
        return msgService.queryAllMsg();
    }

    @RequestMapping("/queryMsg1")
    public List<Map<String, Object>> queryMsg1(@RequestBody Map<String, String> params) throws Exception {
        String userid = params.get("userid");
        if (userid.isEmpty()) {
            return null;
        }
        List<Map<String, Object>> list = msgService.queryMsg1(Integer.valueOf(userid));
        SimpleDateFormat sj = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        for (Map<String, Object> map : list) {
            map.put("date", sj.format(map.get("date")));
        }
        return list;
    }

    @RequestMapping("/queryMsg2")
    public List<Map<String, Object>> queryMsg2(@RequestBody Map<String, String> params) throws Exception {
        String userid = params.get("userid");
        if (userid.isEmpty()) {
            return null;
        }
        List<Map<String, Object>> list = msgService.queryMsg2(Integer.valueOf(userid));
        SimpleDateFormat sj = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        for (Map<String, Object> map : list) {
            map.put("date", sj.format(map.get("date")));
        }
        return list;
    }

    @RequestMapping("/UpdateMsgUse")
    public Map<String, Object> UpdateMsgUse(@RequestBody Map<String, String> params) throws Exception {
        String msgid = params.get("msgid");
        Map<String, Object> result = new HashMap<>();
        if (msgid.isEmpty()) {
            result.put("msg", "参数不能为空");
            return null;
        }
        msgService.UpdateMsgUse(Integer.valueOf(msgid));
        result.put("success", true);
        return result;
    }

}
