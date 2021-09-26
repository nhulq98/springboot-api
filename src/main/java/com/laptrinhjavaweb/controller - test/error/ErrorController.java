package com.laptrinhjavaweb.controller.error;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.BuildingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {
    @RequestMapping(value = "/my-error-page", method = RequestMethod.GET)
    public ModelAndView createNew(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("error/page");
        return mav;
    }
}
