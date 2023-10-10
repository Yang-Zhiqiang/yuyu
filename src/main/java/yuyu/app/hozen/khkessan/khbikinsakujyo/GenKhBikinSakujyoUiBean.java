package yuyu.app.hozen.khkessan.khbikinsakujyo;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_BknsyoriKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全備金削除 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhBikinSakujyoUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_BkncdKbn bkncdkbn;

    public C_BkncdKbn getBkncdkbn() {
        return bkncdkbn;
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        bkncdkbn = pBkncdkbn;
    }

    @ValidDate
    private BizDate bknkktymd;

    public BizDate getBknkktymd() {
        return bknkktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBknkktymd(BizDate pBknkktymd) {
        bknkktymd = pBknkktymd;
    }

    private C_BknsyoriKbn bknsyorikbn;

    public C_BknsyoriKbn getBknsyorikbn() {
        return bknsyorikbn;
    }

    public void setBknsyorikbn(C_BknsyoriKbn pBknsyorikbn) {
        bknsyorikbn = pBknsyorikbn;
    }

    @ValidDate
    private BizDate kessankijyunymd;

    public BizDate getKessankijyunymd() {
        return kessankijyunymd;
    }

    @Trim("both")
    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        kessankijyunymd = pKessankijyunymd;
    }

    private C_BknrigiKbn bknrigikbn;

    public C_BknrigiKbn getBknrigikbn() {
        return bknrigikbn;
    }

    public void setBknrigikbn(C_BknrigiKbn pBknrigikbn) {
        bknrigikbn = pBknrigikbn;
    }

    @CurrencyLenght(length=13)
    private BizCurrency bkngk;

    public BizCurrency getBkngk() {
        return bkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBkngk(BizCurrency pBkngk) {
        bkngk = pBkngk;
    }

    @ValidDate
    private BizDate calckijyunymd;

    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    private C_Segcd kbnkeirisegcd;

    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }

    @MaxLength(max=4)
    @SingleByteStrings
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    @ValidDate
    private BizDate shrsyoriymd;

    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    @ValidDate
    private BizDate tyakkinymd;

    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }
}
