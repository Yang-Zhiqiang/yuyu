package yuyu.def.biz.bean.param;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）社内用Webサービスレスポンスパラメーimport javax.validation.constraints.NotNull;

import jp.co.slcs.swak.util.bean.BeanUtil;
いよう注意して下さい。
 */
public class IwssnBzWebserviceResParamBean {

    private static final long serialVersionUID = 1L;

    public IwssnBzWebserviceResParamBean() {
    }

    @NotNull
    private String iwssnGyoumuData;

    public String getGyoumuData() {
        return iwssnGyoumuData;
    }

    public void setGyoumuData(String pIwssnGyoumuData) {
        iwssnGyoumuData = pIwssnGyoumuData;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
