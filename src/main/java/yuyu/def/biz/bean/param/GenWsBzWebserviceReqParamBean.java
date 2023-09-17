package yuyu.def.biz.bean.param;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＷｅｂサービスリクエストパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsBzWebserviceReqParamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsBzWebserviceReqParamBean() {
    }

    @NotNull
    private String operatorId;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String pOperatorId) {
        operatorId = pOperatorId;
    }

    @NotNull
    private String coopClass;

    public String getCoopClass() {
        return coopClass;
    }

    public void setCoopClass(String pCoopClass) {
        coopClass = pCoopClass;
    }

    @NotNull
    private String orgCode;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String pOrgCode) {
        orgCode = pOrgCode;
    }

    @NotNull
    private String methodName;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String pMethodName) {
        methodName = pMethodName;
    }

    @NotNull
    private String gyoumuData;

    public String getGyoumuData() {
        return gyoumuData;
    }

    public void setGyoumuData(String pGyoumuData) {
        gyoumuData = pGyoumuData;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
