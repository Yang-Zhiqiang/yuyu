package yuyu.def.biz.bean.param;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＷｅｂサービスレスポンスパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsBzWebserviceResParamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsBzWebserviceResParamBean() {
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
