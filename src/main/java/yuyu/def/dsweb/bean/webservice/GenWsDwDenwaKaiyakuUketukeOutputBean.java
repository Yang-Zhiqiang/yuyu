package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.SyoukenNo;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ＤＳＷｅｂ）電話解約受付出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwDenwaKaiyakuUketukeOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwDenwaKaiyakuUketukeOutputBean() {
    }

    private String iwsNextsyoricd;

    public String getIwsNextsyoricd() {
        return iwsNextsyoricd;
    }

    public void setIwsNextsyoricd(String pIwsNextsyoricd) {
        iwsNextsyoricd = pIwsNextsyoricd;
    }

    @SingleByteStrings
    @Digit
    @Length(length=2)
    private String iwsGyoumucd;

    public String getIwsGyoumucd() {
        return iwsGyoumucd;
    }

    public void setIwsGyoumucd(String pIwsGyoumucd) {
        iwsGyoumucd = pIwsGyoumucd;
    }

    @SingleByteStrings
    @Digit
    @Length(length=3)
    private String iwsSyorinaiyou;

    public String getIwsSyorinaiyou() {
        return iwsSyorinaiyou;
    }

    public void setIwsSyorinaiyou(String pIwsSyorinaiyou) {
        iwsSyorinaiyou = pIwsSyorinaiyou;
    }

    @SingleByteStrings
    @Digit
    @MaxLength(max=10)
    private String iwsTtdkskbt;

    public String getIwsTtdkskbt() {
        return iwsTtdkskbt;
    }

    public void setIwsTtdkskbt(String pIwsTtdkskbt) {
        iwsTtdkskbt = pIwsTtdkskbt;
    }

    @SyoukenNo
    private String iwsSyono;

    public String getIwsSyono() {
        return iwsSyono;
    }

    public void setIwsSyono(String pIwsSyono) {
        iwsSyono = pIwsSyono;
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

    private String iwsShrgkkei;

    public String getIwsShrgkkei() {
        return iwsShrgkkei;
    }

    public void setIwsShrgkkei(String pIwsShrgkkei) {
        iwsShrgkkei = pIwsShrgkkei;
    }

    private String iwsTuukasyu;

    public String getIwsTuukasyu() {
        return iwsTuukasyu;
    }

    public void setIwsTuukasyu(String pIwsTuukasyu) {
        iwsTuukasyu = pIwsTuukasyu;
    }

    private String iwsBankcd;

    public String getIwsBankcd() {
        return iwsBankcd;
    }

    public void setIwsBankcd(String pIwsBankcd) {
        iwsBankcd = pIwsBankcd;
    }

    private String iwsBanknmkn;

    public String getIwsBanknmkn() {
        return iwsBanknmkn;
    }

    public void setIwsBanknmkn(String pIwsBanknmkn) {
        iwsBanknmkn = pIwsBanknmkn;
    }

    private String iwsKzmeiginmkn;

    public String getIwsKzmeiginmkn() {
        return iwsKzmeiginmkn;
    }

    public void setIwsKzmeiginmkn(String pIwsKzmeiginmkn) {
        iwsKzmeiginmkn = pIwsKzmeiginmkn;
    }

    @SingleByteStrings
    @Digit
    @MaxLength(max=30)
    private String iwsKouzaVersion;

    public String getIwsKouzaVersion() {
        return iwsKouzaVersion;
    }

    public void setIwsKouzaVersion(String pIwsKouzaVersion) {
        iwsKouzaVersion = pIwsKouzaVersion;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
