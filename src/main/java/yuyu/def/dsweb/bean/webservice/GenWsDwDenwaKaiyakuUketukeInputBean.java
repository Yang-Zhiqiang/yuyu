package yuyu.def.dsweb.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （ＤＳＷｅｂ）電話解約受付入力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsDwDenwaKaiyakuUketukeInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsDwDenwaKaiyakuUketukeInputBean() {
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

    private String iwsTokuteitrhkansyono;

    public String getIwsTokuteitrhkansyono() {
        return iwsTokuteitrhkansyono;
    }

    public void setIwsTokuteitrhkansyono(String pIwsTokuteitrhkansyono) {
        iwsTokuteitrhkansyono = pIwsTokuteitrhkansyono;
    }

    @SingleByteStrings
    @Digit
    @Length(length=1)
    private String iwsTtdkis;

    public String getIwsTtdkis() {
        return iwsTtdkis;
    }

    public void setIwsTtdkis(String pIwsTtdkis) {
        iwsTtdkis = pIwsTtdkis;
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

    @SingleByteStrings
    @Digit
    @Length(length=14)
    private String iwsTyakusintime;

    public String getIwsTyakusintime() {
        return iwsTyakusintime;
    }

    public void setIwsTyakusintime(String pIwsTyakusintime) {
        iwsTyakusintime = pIwsTyakusintime;
    }

    @SingleByteStrings
    @Digit
    @Length(length=18)
    private String iwsCallid;

    public String getIwsCallid() {
        return iwsCallid;
    }

    public void setIwsCallid(String pIwsCallid) {
        iwsCallid = pIwsCallid;
    }

    @SingleByteStrings
    @Digit
    @Length(length=1)
    private String iwsSyorikekka;

    public String getIwsSyorikekka() {
        return iwsSyorikekka;
    }

    public void setIwsSyorikekka(String pIwsSyorikekka) {
        iwsSyorikekka = pIwsSyorikekka;
    }

    @SingleByteStrings
    @Digit
    @Length(length=3)
    private String iwsStdnkasyo;

    public String getIwsStdnkasyo() {
        return iwsStdnkasyo;
    }

    public void setIwsStdnkasyo(String pIwsStdnkasyo) {
        iwsStdnkasyo = pIwsStdnkasyo;
    }

    @SingleByteStrings
    @Digit
    @Length(length=2)
    private String iwsStdnriyuu;

    public String getIwsStdnriyuu() {
        return iwsStdnriyuu;
    }

    public void setIwsStdnriyuu(String pIwsStdnriyuu) {
        iwsStdnriyuu = pIwsStdnriyuu;
    }

    @SingleByteStrings
    @Digit
    @MaxLength(max=10)
    private String iwsTuuwatime;

    public String getIwsTuuwatime() {
        return iwsTuuwatime;
    }

    public void setIwsTuuwatime(String pIwsTuuwatime) {
        iwsTuuwatime = pIwsTuuwatime;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
