package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）本人確認処理出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwHonninKakuninOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwHonninKakuninOutputBean() {
    }

    @Column(order = 1, length = 6)
    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    @Column(order = 2, length = 8)
    private String iwsSaisinloginymd;

    public String getIwsSaisinloginymd() {
        return iwsSaisinloginymd;
    }

    public void setIwsSaisinloginymd(String pIwsSaisinloginymd) {
        iwsSaisinloginymd = pIwsSaisinloginymd;
    }

    @Column(order = 3, length = 6)
    private String iwsSaisinlogintime;

    public String getIwsSaisinlogintime() {
        return iwsSaisinlogintime;
    }

    public void setIwsSaisinlogintime(String pIwsSaisinlogintime) {
        iwsSaisinlogintime = pIwsSaisinlogintime;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
