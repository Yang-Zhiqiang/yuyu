package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;

/**
 * （ＤＳＷｅｂ）ログイン認証出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwLoginOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwLoginOutputBean() {
    }

    @Column(order = 1, length = 6)
    private String iwsDsmsgcd;

    public String getIwsDsmsgcd() {
        return iwsDsmsgcd;
    }

    public void setIwsDsmsgcd(String pIwsDsmsgcd) {
        iwsDsmsgcd = pIwsDsmsgcd;
    }

    @Column(order = 2, length = 10)
    @SingleByteStrings
    @Digit
    @Length(length=10)
    private String iwsDskokno;

    public String getIwsDskokno() {
        return iwsDskokno;
    }

    public void setIwsDskokno(String pIwsDskokno) {
        iwsDskokno = pIwsDskokno;
    }

    @Column(order = 3, length = 1)
    private String iwsPasswordjtkbn;

    public String getIwsPasswordjtkbn() {
        return iwsPasswordjtkbn;
    }

    public void setIwsPasswordjtkbn(String pIwsPasswordjtkbn) {
        iwsPasswordjtkbn = pIwsPasswordjtkbn;
    }

    @Column(order = 4, length = 8)
    private String iwsSaisinloginymd;

    public String getIwsSaisinloginymd() {
        return iwsSaisinloginymd;
    }

    public void setIwsSaisinloginymd(String pIwsSaisinloginymd) {
        iwsSaisinloginymd = pIwsSaisinloginymd;
    }

    @Column(order = 5, length = 6)
    private String iwsSaisinlogintime;

    public String getIwsSaisinlogintime() {
        return iwsSaisinlogintime;
    }

    public void setIwsSaisinlogintime(String pIwsSaisinlogintime) {
        iwsSaisinlogintime = pIwsSaisinlogintime;
    }

    @Column(order = 6, length = 8)
    private String iwsFuho2serverymd;

    public String getIwsFuho2serverymd() {
        return iwsFuho2serverymd;
    }

    public void setIwsFuho2serverymd(String pIwsFuho2serverymd) {
        iwsFuho2serverymd = pIwsFuho2serverymd;
    }

    @Column(order = 7, length = 2)
    private String iwsPassworderrorkaisuu;

    public String getIwsPassworderrorkaisuu() {
        return iwsPassworderrorkaisuu;
    }

    public void setIwsPassworderrorkaisuu(String pIwsPassworderrorkaisuu) {
        iwsPassworderrorkaisuu = pIwsPassworderrorkaisuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
