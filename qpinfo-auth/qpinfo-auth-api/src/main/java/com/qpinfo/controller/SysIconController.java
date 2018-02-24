package com.qpinfo.controller;

import com.qpinfo.auth.pojo.SysIcon;
import com.qpinfo.auth.pojo.SysIconExample;
import com.qpinfo.auth.service.SysIconService;
import com.qpinfo.enums.ResponseEnum;
import com.qpinfo.exception.BizException;
import com.qpinfo.utils.Assertion;
import com.qpinfo.vo.PageResponse;
import com.qpinfo.vo.Request;
import com.qpinfo.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/2/20 下午2:21
 * @Company 青朴信息技术服务有限公司
 */
@RestController
@RequestMapping(value = "/icon")
public class SysIconController  extends BaseController{

    private Logger logger = LoggerFactory.getLogger(SysIconController.class);
    @Autowired
    SysIconService baseService;

    @RequestMapping(value = "/queryPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.GET)
    public PageResponse queryPage(@RequestBody(required = false) Request dto){
        logger.info("request queryPage params={}",dto);
        SysIconExample example = new SysIconExample();
        List<SysIcon> dataList = baseService.queryPage(example);
        return new PageResponse().code(0).data(dataList).count(dataList.size());
    }


    @RequestMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.POST)
    public Response save(@RequestBody SysIcon dto){
        logger.info("request save params={}",dto);
        int rlt = baseService.save(dto);
        logger.info("execute save method success ，effect 【{}】 columns",rlt);
        if (rlt==1){
            return new Response(ResponseEnum.SUCCESS);
        }
        return new Response(ResponseEnum.ERROR_PARAMS);
    }

    @RequestMapping(value = "/queryById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method =RequestMethod.POST)
    public Response queryById(@RequestBody Request dto){
        logger.info("request queryById params={}",dto);
        Assertion.isTrue(dto !=null,"参数不能为空");
        Assertion.notEmpty(dto.getId(),"查询ID参数不能为空");
        int id = 0;
        try {
          id= Integer.parseInt(dto.getId());
        }catch (Exception e ){
            throw new BizException("查询参数异常");
        }
        SysIconExample example = new SysIconExample();
        example.createCriteria().andIdEqualTo(id);
        return new Response(ResponseEnum.SUCCESS).data(baseService.query(example));
    }
    @RequestMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method =RequestMethod.POST)
    public Response delete(@RequestBody Request dto){
        logger.info("request queryById params={}",dto);
        Assertion.isTrue(dto !=null,"参数不能为空");
        Assertion.notEmpty(dto.getId(),"查询ID参数不能为空");
        String id  = dto.getId();
        String[] ids = id.split(",");
        SysIconExample example = new SysIconExample();
        example.createCriteria().andIdIn(convert(ids));
        return new Response(ResponseEnum.SUCCESS);
    }

    public List<Integer> convert(String[] ids){
        List<Integer> dataList = new ArrayList<>();
        for (String id : ids ){
            dataList.add(Integer.parseInt(id));
        }
        return dataList;
    }
}
