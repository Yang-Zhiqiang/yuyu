package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）ＤＳ解約受付入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwDsKaiyakuUktkInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwDsKaiyakuUktkInputBean() {
    }

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

    @SingleByteStrings
    @Length(length=3)
    private String iwsShrtuukasyu;

    public String getIwsShrtuukasyu() {
        return iwsShrtuukasyu;
    }

    public void setIwsShrtuukasyu(String pIwsShrtuukasyu) {
        iwsShrtuukasyu = pIwsShrtuukasyu;
    }

    @SingleByteStrings
    @Digit
    private String iwsVersion;

    public String getIwsVersion() {
        return iwsVersion;
    }

    public void setIwsVersion(String pIwsVersion) {
        iwsVersion = pIwsVersion;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
