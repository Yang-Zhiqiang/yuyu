package yuyu.def.biz.bean.param;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）社内用WebサービスレスポンスパラメータBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenIwssnBzWebserviceResParamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenIwssnBzWebserviceResParamBean() {
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
