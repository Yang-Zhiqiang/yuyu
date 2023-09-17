package yuyu.def.base.configuration;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * 特殊機能定義BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenTokusyuKinou implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenTokusyuKinou() {
    }

    private String actionClassName;

    public String getActionClassName() {
        return actionClassName;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setActionClassName(String pActionClassName) {
        actionClassName = pActionClassName;
    }

    private String initMethod;

    public String getInitMethod() {
        return initMethod;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInitMethod(String pInitMethod) {
        initMethod = pInitMethod;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
