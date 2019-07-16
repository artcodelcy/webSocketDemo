package com.websocket.controller;

import com.websocket.webSocket.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/checkcenter")
public class CheckCenterController {
    /**
     * 页面请求
     * @param cid
     * @return
     */
    @GetMapping(value = "/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("cid",cid);
        return mav;
    }
    /**
     * 数据推送
     * @param cid
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/socket/push/{cid}")
    public String pushToWeb(@PathVariable String cid,String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
