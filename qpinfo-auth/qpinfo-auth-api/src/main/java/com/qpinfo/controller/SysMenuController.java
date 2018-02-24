package com.qpinfo.controller;

import com.qpinfo.auth.pojo.SysMenu;
import com.qpinfo.auth.pojo.SysMenuExample;
import com.qpinfo.auth.service.SysMenuService;
import com.qpinfo.enums.ResponseEnum;
import com.qpinfo.exception.BizException;
import com.qpinfo.utils.Assertion;
import com.qpinfo.utils.DataConvertUtil;
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
 * @date 2018/2/5 下午7:58
 * @company 默云网络科技有限公司
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

    @RequestMapping(value = "/queryById",produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.POST)
    public Response queryById(@RequestBody Request dto){
        logger.info("queryById params={}",dto);
        Assertion.isTrue(dto !=null,"参数不能为空");
        Assertion.notEmpty(dto.getId(),"查询ID参数不能为空");
        int id = 0;
        try {
            id= Integer.parseInt(dto.getId());
        }catch (Exception e ){
            throw new BizException("查询参数异常");
        }
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andIdEqualTo(id);
        SysMenu model = baseService.query(example);
        return new Response(ResponseEnum.SUCCESS).data(model);
    }
    @RequestMapping(value = "/save",produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.POST)
    public Response save(@RequestBody SysMenu dto){
        logger.info("queryById params={}",dto);
        Assertion.isTrue(dto !=null,"参数不能为空");
        int rlt = baseService.save(dto);
        logger.info("execute save method success ，effect 【{}】 columns",rlt);
        if (rlt==1){
            return new Response(ResponseEnum.SUCCESS);
        }
        return new Response(ResponseEnum.ERROR_PARAMS);
    }

    @RequestMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method =RequestMethod.POST)
    public Response delete(@RequestBody Request dto){
        logger.info("request delete params={}",dto);
        Assertion.isTrue(dto !=null,"参数不能为空");
        Assertion.notEmpty(dto.getId(),"查询ID参数不能为空");
        String id  = dto.getId();
        String[] ids = id.split(",");
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andIdIn(DataConvertUtil.convert(ids));
        return new Response(ResponseEnum.SUCCESS);
    }
}
