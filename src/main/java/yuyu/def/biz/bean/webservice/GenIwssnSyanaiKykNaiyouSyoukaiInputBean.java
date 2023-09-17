package yuyu.def.biz.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （共通Web）社内用契約内容照会入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenIwssnSyanaiKykNaiyouSyoukaiInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenIwssnSyanaiKykNaiyouSyoukaiInputBean() {
    }

    @SyoukenNo
    private String iwssnSyono;

    public String getIwssnSyono() {
        return iwssnSyono;
    }

    public void setIwssnSyono(String pIwssnSyono) {
        iwssnSyono = pIwssnSyono;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
