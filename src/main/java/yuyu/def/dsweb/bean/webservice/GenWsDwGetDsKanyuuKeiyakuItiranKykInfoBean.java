package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;
import yuyu.infr.validation.constraints.SyoukenNo;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ加入契約一覧取得契約情報BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwGetDsKanyuuKeiyakuItiranKykInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwGetDsKanyuuKeiyakuItiranKykInfoBean() {
    }

    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
    }

    private String iwsDssyouhnbunruikbn;

    public String getIwsDssyouhnbunruikbn() {
        return iwsDssyouhnbunruikbn;
    }

    public void setIwsDssyouhnbunruikbn(String pIwsDssyouhnbunruikbn) {
        iwsDssyouhnbunruikbn = pIwsDssyouhnbunruikbn;
    }

    private String iwsKykssmongon;

    public String getIwsKykssmongon() {
        return iwsKykssmongon;
    }

    public void setIwsKykssmongon(String pIwsKykssmongon) {
        iwsKykssmongon = pIwsKykssmongon;
    }

    private String iwsSyohnkiticd;

    public String getIwsSyohnkiticd() {
        return iwsSyohnkiticd;
    }

    public void setIwsSyohnkiticd(String pIwsSyohnkiticd) {
        iwsSyohnkiticd = pIwsSyohnkiticd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
