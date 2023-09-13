package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）パスワード変更出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwPasswordHenkouOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwPasswordHenkouOutputBean() {
    }

    @Column(order = 1, length = 6)
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
