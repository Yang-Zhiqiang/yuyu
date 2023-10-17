package yuyu.app.sinkeiyaku.sknyuukin.skcreditjyouhoutouroku;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditInfoTourokuGamenSyoriKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * クレジットカード情報登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkCreditJyouhouTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private String hubisyousaibtn;

    public String getHubisyousaibtn() {
        return hubisyousaibtn;
    }

    public void setHubisyousaibtn(String pHubisyousaibtn) {
        hubisyousaibtn = pHubisyousaibtn;
    }

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private C_CreditInfoTourokuGamenSyoriKbn creditinfotrkugmsyorikbn;

    public C_CreditInfoTourokuGamenSyoriKbn getCreditinfotrkugmsyorikbn() {
        return creditinfotrkugmsyorikbn;
    }

    public void setCreditinfotrkugmsyorikbn(C_CreditInfoTourokuGamenSyoriKbn pCreditinfotrkugmsyorikbn) {
        creditinfotrkugmsyorikbn = pCreditinfotrkugmsyorikbn;
    }

    @ValidDate
    private BizDate authorikakymd;

    public BizDate getAuthorikakymd() {
        return authorikakymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAuthorikakymd(BizDate pAuthorikakymd) {
        authorikakymd = pAuthorikakymd;
    }

    private C_CardBrandKbn cardbrandkbn;

    public C_CardBrandKbn getCardbrandkbn() {
        return cardbrandkbn;
    }

    public void setCardbrandkbn(C_CardBrandKbn pCardbrandkbn) {
        cardbrandkbn = pCardbrandkbn;
    }

    private String dispcreditkessaiyouno;

    public String getDispcreditkessaiyouno() {
        return dispcreditkessaiyouno;
    }

    public void setDispcreditkessaiyouno(String pDispcreditkessaiyouno) {
        dispcreditkessaiyouno = pDispcreditkessaiyouno;
    }

    private C_CreditTrkjkKbn credittrkjkkbn;

    public C_CreditTrkjkKbn getCredittrkjkkbn() {
        return credittrkjkkbn;
    }

    public void setCredittrkjkkbn(C_CreditTrkjkKbn pCredittrkjkkbn) {
        credittrkjkkbn = pCredittrkjkkbn;
    }

    @Length(length=2)
    @SingleByteStrings
    @Digit
    private String creditkessaiyouno1;

    public String getCreditkessaiyouno1() {
        return creditkessaiyouno1;
    }

    public void setCreditkessaiyouno1(String pCreditkessaiyouno1) {
        creditkessaiyouno1 = pCreditkessaiyouno1;
    }

    @Length(length=2)
    @SingleByteStrings
    @Digit
    private String creditkessaiyouno2;

    public String getCreditkessaiyouno2() {
        return creditkessaiyouno2;
    }

    public void setCreditkessaiyouno2(String pCreditkessaiyouno2) {
        creditkessaiyouno2 = pCreditkessaiyouno2;
    }

    @Length(length=9)
    @SingleByteStrings
    @Digit
    private String creditkessaiyouno3;

    public String getCreditkessaiyouno3() {
        return creditkessaiyouno3;
    }

    public void setCreditkessaiyouno3(String pCreditkessaiyouno3) {
        creditkessaiyouno3 = pCreditkessaiyouno3;
    }

    @Length(length=6)
    @SingleByteStrings
    @Digit
    private String creditkessaiyouno4;

    public String getCreditkessaiyouno4() {
        return creditkessaiyouno4;
    }

    public void setCreditkessaiyouno4(String pCreditkessaiyouno4) {
        creditkessaiyouno4 = pCreditkessaiyouno4;
    }

    @Length(length=6)
    @SingleByteStrings
    @Digit
    private String creditkessaiyouno5;

    public String getCreditkessaiyouno5() {
        return creditkessaiyouno5;
    }

    public void setCreditkessaiyouno5(String pCreditkessaiyouno5) {
        creditkessaiyouno5 = pCreditkessaiyouno5;
    }

    @Length(length=1)
    @SingleByteStrings
    @Digit
    private String creditkessaiyouno6;

    public String getCreditkessaiyouno6() {
        return creditkessaiyouno6;
    }

    public void setCreditkessaiyouno6(String pCreditkessaiyouno6) {
        creditkessaiyouno6 = pCreditkessaiyouno6;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }
}
