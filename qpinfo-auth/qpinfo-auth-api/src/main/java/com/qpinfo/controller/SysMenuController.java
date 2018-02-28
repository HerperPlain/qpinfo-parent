package com.qpinfo.controller;

import com.qpinfo.auth.pojo.SysMenu;
import com.qpinfo.auth.pojo.SysMenuExample;
import com.qpinfo.auth.service.SysMenuService;
import com.qpinfo.enums.ResponseEnum;
import com.qpinfo.exception.BizException;
import com.qpinfo.utils.Assertion;
import com.qpinfo.utils.DataConvertUtil;
import com.qpinfo.utils.Detect;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 管理页面：分页查询
     * @param dto
     * @return
     */
    @RequestMapping(value = "/queryPage",produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.GET)
    public PageResponse queryPage(@RequestBody(required = false) Request dto){
        logger.info("queryPage params={}",dto);
        SysMenuExample example = new SysMenuExample();
        List<SysMenu> dataList = baseService.queryPage(example);
        return new PageResponse().code(0).data(dataList).count(dataList.size());
    }

    /**
     * 菜单管理上级目录加载
     * @param dto
     * @return
     */
    @RequestMapping(value = "/queryMenuList",produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.POST)
    public Response queryMenuList(@RequestBody Request dto){
        logger.info("queryMenuList params={}",dto);
        Assertion.isTrue(dto !=null,"参数不能为空");
        Assertion.notEmpty(dto.getId(),"查询ID参数不能为空");
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andParentIdEqualTo(Integer.parseInt(dto.getId()));
        List<SysMenu> dataList = baseService.list(example);
        return new Response(ResponseEnum.SUCCESS).data(dataList);
    }

    /**
     * 查询详情
     * @param dto
     * @return
     */
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

    /**
     * 菜单保存方法
     * @param dto
     * @return
     */
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

    /**
     * 删除方法
     * @param dto
     * @return
     */
    @RequestMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method =RequestMethod.POST)
    public Response delete(@RequestBody Request dto){
        logger.info("request delete SysMenu params={}",dto);
        Assertion.isTrue(dto !=null,"参数不能为空");
        Assertion.notEmpty(dto.getId(),"查询ID参数不能为空");
        String id  = dto.getId();
        String[] ids = id.split(",");
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andIdIn(DataConvertUtil.convert(ids));
        int rlt = baseService.delete(example);
        logger.info("execute delete method success ，total size【{}】,effect 【{}】 columns",ids.length,rlt);
        if (rlt>0){
            return new Response(ResponseEnum.SUCCESS);
        }
        return new Response(ResponseEnum.ERROR_PARAMS);
    }

    /**
     * 菜单查询
     * @return
     */
    @RequestMapping(value = "/getMenuList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method ={RequestMethod.POST,RequestMethod.GET})
    public Object getMenuList(){
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andStateEqualTo(1).andParentIdEqualTo(0);
        List<SysMenu>  dataList=baseService.list(example);
        return convert(dataList);
    }

    /**
     * layui菜单数据封装及转换
     * @param dataList
     * @return
     */
    private Object convert(List<SysMenu> dataList){
        List<Map<String,Object>> parentMapList = new ArrayList<Map<String,Object>>();
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("title","后台首页");
        dataMap.put("icon","icon-computer");
        dataMap.put("href","page/main.html");
        dataMap.put("spread",false);
        parentMapList.add(dataMap);
        for (SysMenu model :dataList){
            dataMap = new HashMap<String,Object>();
            SysMenuExample example = new SysMenuExample();
            example.createCriteria().andStateEqualTo(1).andParentIdEqualTo(model.getId());
            List<SysMenu>  childList =baseService.list(example);
            if(Detect.notEmpty(childList)){
                List<Map<String,Object>> childMapList = new ArrayList<Map<String,Object>>();
                for (SysMenu childModel : childList){
                    Map<String,Object> childMap = new HashMap<String,Object>();
                    childMap.put("title",childModel.getTitle());
                    childMap.put("icon",childModel.getIcon());
                    childMap.put("href",childModel.getHref());
                    childMap.put("spread",false);
                    childMapList.add(childMap);
                }
                dataMap.put("children",childMapList);
            }
            dataMap.put("title",model.getTitle());
            dataMap.put("icon",model.getIcon());
            dataMap.put("href",model.getHref());
            dataMap.put("spread",false);
            parentMapList.add(dataMap);
        }
        return parentMapList;

    }
}
