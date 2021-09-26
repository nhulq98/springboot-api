package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "buildingsControllerOfAdmin")
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;


//    @Autowired
//    private IDistrictService districtService;

    @Autowired
    private IAssignmentBuildingService assignmentBuildingService;

    @Autowired
    private MessageUtils messageUtil;

    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView getAll(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list");
//
//        List<BuildingDTO> result = new ArrayList<>();
//        List<BuildingResponse> buildingResponses = buildingService.findByCondition((BuildingRequest) buildingRequestConverter.convertDTOToCustom(model));
//        for (BuildingResponse responseDTO : buildingResponses) {
//            result.add((BuildingDTO) buildingResponseConverter.convertCustomToDTO(responseDTO));
//        }
//
//        RentTypeService rentTypeService = new RentTypeService();
//        // set result to MODEL
//        mav.addObject(SystemConstant.MODEL, model);
//        mav.addObject(SystemConstant.DISTRICT, districtService.findAll());
//        mav.addObject(SystemConstant.STAFF, assignmentBuildingService.getAllStaffs());
//        mav.addObject(SystemConstant.RENT_TYPE, rentTypeService.getRentTypes());
//        model.setListResult(result);// list building result
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
    public ModelAndView createNew(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");

        //RentTypeService rentTypeService = new RentTypeService();
//
//        mav.addObject(SystemConstant.DISTRICT, districtService.findAll());
//        mav.addObject(SystemConstant.MODEL, model);
//        mav.addObject(SystemConstant.RENT_TYPE, rentTypeService.getRentTypes());

        return mav;
    }

//    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
//        String message = request.getParameter("message");
//        if (message != null && StringUtils.isNotEmpty(message)) {
//            Map<String, String> messageMap = messageUtil.getMessage(message);
//            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
//            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
//        }
//    }
}
