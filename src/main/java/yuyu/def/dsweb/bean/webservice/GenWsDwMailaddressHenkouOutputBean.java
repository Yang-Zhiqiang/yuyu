package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）メール変更出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwMailaddressHenkouOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwMailaddressHenkouOutputBean() {
    }

    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    private String iwsDssousinno;

    public String getIwsDssousinno() {
        return iwsDssousinno;
    }

    public void setIwsDssousinno(String pIwsDssousinno) {
        iwsDssousinno = pIwsDssousinno;
    }

    private String iwsHaisinruleid1;

    public String getIwsHaisinruleid1() {
        return iwsHaisinruleid1;
    }

    public void setIwsHaisinruleid1(String pIwsHaisinruleid1) {
        iwsHaisinruleid1 = pIwsHaisinruleid1;
    }

    private String iwsDsmailaddressdbsyorikbn;

    public String getIwsDsmailaddressdbsyorikbn() {
        return iwsDsmailaddressdbsyorikbn;
    }

    public void setIwsDsmailaddressdbsyorikbn(String pIwsDsmailaddressdbsyorikbn) {
        iwsDsmailaddressdbsyorikbn = pIwsDsmailaddressdbsyorikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
