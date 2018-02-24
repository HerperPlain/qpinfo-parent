package com.qpinfo.controller;

import com.qpinfo.auth.pojo.SysMenu;
import com.qpinfo.auth.pojo.SysMenuExample;
import com.qpinfo.auth.service.SysMenuService;
import com.qpinfo.enums.ResponseEnum;
import com.qpinfo.vo.PageResponse;
import com.qpinfo.vo.Request;
import com.qpinfo.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/2/5 下午7:58
 * @Company 青朴信息技术服务有限公司
 */
@RestController
@RequestMapping(value = "/menu")
public class SysMenuController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(SysMenuController.class);

    @Autowired
    SysMenuService baseService;

    @RequestMapping(value = "/queryPage",produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.GET)
    public PageResponse queryPage(@RequestBody(required = false) Request dto){
        logger.info("queryPage params={}",dto);
        SysMenuExample example = new SysMenuExample();
        List<SysMenu> dataList = baseService.queryPage(example);
        return new PageResponse().code(0).data(dataList).count(dataList.size());
    }
}
