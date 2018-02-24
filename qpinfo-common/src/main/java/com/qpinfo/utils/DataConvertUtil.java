package com.qpinfo.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @date 2018/2/24 下午3:55
 * @studio 默云工作室
 * @company 默云网络科技有限公司
 * @project qpinfo-parent
 * @package com.qpinfo.utils
 */
public class DataConvertUtil {

    public static List<Integer> convert(String[] ids){
        List<Integer> dataList = new ArrayList<>();
        for (String id : ids ){
            dataList.add(Integer.parseInt(id));
        }
        return dataList;
    }
}
