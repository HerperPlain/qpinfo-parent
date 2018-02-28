package com.qpinfo.auth.service.impl;

import com.qpinfo.auth.dao.SysMenuMapper;
import com.qpinfo.auth.pojo.SysMenu;
import com.qpinfo.auth.pojo.SysMenuExample;
import com.qpinfo.auth.service.SysMenuService;
import com.qpinfo.utils.Detect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/2/5 下午9:57
 * @Company 青朴信息技术服务有限公司
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    private Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);
    @Resource
    SysMenuMapper baseDao;

    @Override
    public int insert(SysMenu model) {
        return baseDao.insertSelective(model);
    }

    @Override
    public int save(SysMenu model) {
        Integer id = model.getId();
        logger.info(" start save SysMenu params [{}] ，id is empty 【{}】",model, Detect.notEmpty(id));
        if(Detect.isPositive(id)){
            logger.info(" ==========  id is not empty excute update =========");
            return baseDao.updateByPrimaryKeySelective(model);
        }
        logger.info(" ==========  id is  empty excute insert =========");
        return baseDao.insertSelective(model);
    }

    @Override
    public int delete(SysMenuExample example) {
        return baseDao.deleteByExample(example);
    }

    @Override
    public List<SysMenu> list(SysMenuExample example) {
        return baseDao.selectByExample(example);
    }

    @Override
    public List<SysMenu> queryPage(SysMenuExample example) {
        return baseDao.selectByExample(example);
    }

    @Override
    public SysMenu query(SysMenuExample example) {
        List<SysMenu> data = baseDao.selectByExample(example);
        if(data!=null && data.size()>0){
            return data.get(0);
        }
        return null;
    }
}
