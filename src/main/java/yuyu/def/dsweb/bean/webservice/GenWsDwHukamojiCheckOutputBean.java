package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）不可文字チェック出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwHukamojiCheckOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwHukamojiCheckOutputBean() {
    }

    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    private String iwsCheckkekka;

    public String getIwsCheckkekka() {
        return iwsCheckkekka;
    }

    public void setIwsCheckkekka(String pIwsCheckkekka) {
        iwsCheckkekka = pIwsCheckkekka;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
