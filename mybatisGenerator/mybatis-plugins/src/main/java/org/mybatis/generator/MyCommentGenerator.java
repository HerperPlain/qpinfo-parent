package org.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 黄朴（Herper.Plain）
 * @Date 2018/2/5 上午10:54
 * @Company 青朴信息技术服务有限公司
 */
public class MyCommentGenerator extends DefaultCommentGenerator {
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remark = introspectedColumn.getRemarks();
        String columnName = introspectedColumn.getActualColumnName();
        List<IntrospectedColumn> primaryKey = introspectedTable.getPrimaryKeyColumns();
        for (IntrospectedColumn pk : primaryKey) {
            if(columnName.equals(pk.getActualColumnName())){
                remark +=" (ID)";
                continue;
            }
            if (StringUtility.stringHasValue(remark)) {
                remark += introspectedColumn.isNullable() ? "" : "";
            }
        }
        String defaultValue = introspectedColumn.getDefaultValue();
        remark += null != defaultValue ? "  (: "+defaultValue+")" : "";
        field.addJavaDocLine("/** "+ remark+" */");
    }
    public void addModelClassComment(TopLevelClass topLevelClass,IntrospectedTable introspectedTable){
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @author 黄朴（Herper.Plain)  ");
        topLevelClass.addJavaDocLine(" * @studio 默云工作室 ");
        topLevelClass.addJavaDocLine(" * @company 青朴信息技术服务有限公司 ");
        topLevelClass.addJavaDocLine(" * "+introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(" * "+new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        topLevelClass.addJavaDocLine(" */");
    }

}
