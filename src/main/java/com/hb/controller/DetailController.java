package com.hb.controller;

import com.dodo.model.GuestVo;
import com.hb.model.GuestDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailController implements Controller {
    private GuestDao dao;
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public void setDao(GuestDao dao) {
        this.dao = dao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println(httpServletRequest.getServletPath());
        String url = "guest/" + path;

//        if (httpServletRequest.getServletPath().equals("/detail.hb")) {
//            url += "detail";
//        } else if (httpServletRequest.getServletPath().equals("/edit.hb")) {
//            url += "editform";
//        }
        String param = httpServletRequest.getParameter("idx");
        int sabun = Integer.parseInt(param);
        GuestVo bean = dao.selectOne(sabun);

        ModelAndView mav = new ModelAndView();
        mav.addObject("dto", bean);
        mav.setViewName(url);

        return mav;
    }
}
