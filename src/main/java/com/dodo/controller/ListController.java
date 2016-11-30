package com.dodo.controller;

import com.dodo.model.GuestDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListController implements Controller {
    private GuestDao dao;

    public void setDao(GuestDao dao) {
        this.dao = dao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView();

        mav.addObject("alist", dao.selectAll());
        mav.setViewName("/guest/list");

        return mav;
    }
}
