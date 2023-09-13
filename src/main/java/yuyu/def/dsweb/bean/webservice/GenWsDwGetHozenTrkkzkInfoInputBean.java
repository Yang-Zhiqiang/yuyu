package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）保全登録家族情報取得入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwGetHozenTrkkzkInfoInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwGetHozenTrkkzkInfoInputBean() {
    }

    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
