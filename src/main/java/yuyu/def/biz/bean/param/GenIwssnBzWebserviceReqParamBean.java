package yuyu.def.biz.bean.param;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;

/**
 * （共通）社内用WebサービスリクエストパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenIwssnBzWebserviceReqParamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenIwssnBzWebserviceReqParamBean() {
    }

    @AlphaDigit
    private String iwssnOperatorId;

    public String getIwssnOperatorId() {
        return iwssnOperatorId;
    }

    public void setIwssnOperatorId(String pIwssnOperatorId) {
        iwssnOperatorId = pIwssnOperatorId;
    }

    private String iwssnCoopClass;

    public String getIwssnCoopClass() {
        return iwssnCoopClass;
    }

    public void setIwssnCoopClass(String pIwssnCoopClass) {
        iwssnCoopClass = pIwssnCoopClass;
    }

    private String iwssnOrgCode;

    public String getIwssnOrgCode() {
        return iwssnOrgCode;
    }

    public void setIwssnOrgCode(String pIwssnOrgCode) {
        iwssnOrgCode = pIwssnOrgCode;
    }

    private String iwssnMethodName;

    public String getIwssnMethodName() {
        return iwssnMethodName;
    }

    public void setIwssnMethodName(String pIwssnMethodName) {
        iwssnMethodName = pIwssnMethodName;
    }

    @NotNull
    private String iwssnGyoumuData;

    public String getIwssnGyoumuData() {
        return iwssnGyoumuData;
    }

    public void setIwssnGyoumuData(String pIwssnGyoumuData) {
        iwssnGyoumuData = pIwssnGyoumuData;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
