package com.qpinfo.controller;

import com.qpinfo.auth.pojo.SysRole;
import com.qpinfo.auth.pojo.SysRoleExample;
import com.qpinfo.auth.service.SysRoleService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @date 2018/2/28 下午6:38
 * @studio 默云工作室
 * @company 默云网络科技有限公司
 * @project qpinfo-parent
 * @package com.qpinfo.controller
 */
@RestController
@RequestMapping(value = "/role")
public class SysRoleController {

    private Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    SysRoleService baseService;

    @RequestMapping(value = "/queryPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.GET)
    public PageResponse queryPage(@RequestBody(required = false) Request dto){
        logger.info("request queryPage params={}",dto);
        SysRoleExample example = new SysRoleExample();
        List<SysRole> dataList = baseService.queryPage(example);
        return new PageResponse().code(0).data(dataList).count(dataList.size());
    }
    /**
     * 菜单icon选项
     * @param dto
     * @return
     */
    @RequestMapping(value = "/queryIconList",produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.POST)
    public Response queryMenuList(@RequestBody(required = false) Request dto){
        logger.info("queryMenuList params={}",dto);
        SysRoleExample example = new SysRoleExample();
        List<SysRole> dataList = baseService.list(example);
        example.createCriteria().andStateEqualTo(1);
        return new Response(ResponseEnum.SUCCESS).data(dataList);
    }

    /**
     * 保存 SysRole
     * @param dto
     * @return
     */
    @RequestMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.POST)
    public Response save(@RequestBody SysRole dto){
        logger.info("request save SysRole params={}",dto);
        int rlt = baseService.save(dto);
        logger.info("execute save method success ，effect 【{}】 columns",rlt);
        if (rlt==1){
            return new Response(ResponseEnum.SUCCESS);
        }
        return new Response(ResponseEnum.ERROR_PARAMS);
    }

    /**
     * 查询详情
     * @param dto
     * @return
     */
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
        SysRoleExample example = new SysRoleExample();
        example.createCriteria().andIdEqualTo(id);
        return new Response(ResponseEnum.SUCCESS).data(baseService.query(example));
    }

    /**
     * 删除方法
     * @param dto
     * @return
     */
    @RequestMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE , method = RequestMethod.POST)
    public Response delete(@RequestBody Request dto){
        logger.info("request delete params={}",dto);
        Assertion.isTrue(dto !=null,"参数不能为空");
        Assertion.notEmpty(dto.getId(),"查询ID参数不能为空");
        String id  = dto.getId();
        String[] ids = id.split(",");
        SysRoleExample example = new SysRoleExample();
        example.createCriteria().andIdIn(DataConvertUtil.convert(ids));
        int rlt = baseService.delete(example);
        logger.info("execute delete method success ，total size【{}】,effect 【{}】 columns",ids.length,rlt);
        if (rlt>0){
            return new Response(ResponseEnum.SUCCESS);
        }
        return new Response(ResponseEnum.ERROR_PARAMS);
    }
}
