package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）ＤＳ特定取引用暗証番号認証出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean() {
    }

    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
