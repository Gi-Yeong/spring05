package com.hb.controller;

import com.dodo.model.GuestVo;
import com.hb.model.GuestDao;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController extends AbstractCommandController {
    private GuestDao dao;

    public void setDao(GuestDao dao) {
        this.dao = dao;
    }

    @Override
    protected ModelAndView handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object command, BindException e) throws Exception {
        GuestVo bean = (GuestVo) command;
        dao.insertOne(bean);

        return new ModelAndView("redirect:list.hb");
    }
}
