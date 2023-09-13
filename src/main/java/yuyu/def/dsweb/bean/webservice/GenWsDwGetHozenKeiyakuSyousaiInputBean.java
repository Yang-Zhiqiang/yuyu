package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;
import yuyu.infr.validation.constraints.SyoukenNo;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）保全契約詳細取得入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwGetHozenKeiyakuSyousaiInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwGetHozenKeiyakuSyousaiInputBean() {
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
