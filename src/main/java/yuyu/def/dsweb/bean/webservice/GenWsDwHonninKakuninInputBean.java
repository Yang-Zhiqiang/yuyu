package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）本人確認処理入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwHonninKakuninInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwHonninKakuninInputBean() {
    }

    @Column(order = 1, length = 20)
    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
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

    @Column(order = 3, length = 18)
    @MultiByte
    @InvalidCharacter
    @HostInvalidCharacter
    private String iwsNmkn;

    public String getIwsNmkn() {
        return iwsNmkn;
    }

    public void setIwsNmkn(String pIwsNmkn) {
        iwsNmkn = pIwsNmkn;
    }

    @Column(order = 4, length = 8)
    private String iwsSeiymd;

    public String getIwsSeiymd() {
        return iwsSeiymd;
    }

    public void setIwsSeiymd(String pIwsSeiymd) {
        iwsSeiymd = pIwsSeiymd;
    }

    @Column(order = 5, length = 4)
    @SingleByteStrings
    @Digit
    @Length(length=4)
    private String iwsTelnosimo4;

    public String getIwsTelnosimo4() {
        return iwsTelnosimo4;
    }

    public void setIwsTelnosimo4(String pIwsTelnosimo4) {
        iwsTelnosimo4 = pIwsTelnosimo4;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
