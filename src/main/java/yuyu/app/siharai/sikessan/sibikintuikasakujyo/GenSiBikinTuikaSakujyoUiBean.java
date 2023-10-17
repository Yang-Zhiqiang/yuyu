package yuyu.app.siharai.sikessan.sibikintuikasakujyo;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_BknsyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金備金追加削除 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiBikinTuikaSakujyoUiBean extends AbstractUiBean {

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

    private String skno;

    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    private C_BknsyoriKbn bknsyorikbn;

    public C_BknsyoriKbn getBknsyorikbn() {
        return bknsyorikbn;
    }

    public void setBknsyorikbn(C_BknsyoriKbn pBknsyorikbn) {
        bknsyorikbn = pBknsyorikbn;
    }

    private C_BkncdKbn bkncdkbn;

    public C_BkncdKbn getBkncdkbn() {
        return bkncdkbn;
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        bkncdkbn = pBkncdkbn;
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
    private BizDate bknkktymd;

    public BizDate getBknkktymd() {
        return bknkktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBknkktymd(BizDate pBknkktymd) {
        bknkktymd = pBknkktymd;
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

    private C_UmuKbn shrumu;

    public C_UmuKbn getShrumu() {
        return shrumu;
    }

    public void setShrumu(C_UmuKbn pShrumu) {
        shrumu = pShrumu;
    }

    private C_UmuKbn soukiumukbn;

    public C_UmuKbn getSoukiumukbn() {
        return soukiumukbn;
    }

    public void setSoukiumukbn(C_UmuKbn pSoukiumukbn) {
        soukiumukbn = pSoukiumukbn;
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

    private C_Tuukasyu shrtuukasyu;

    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    @ValidDate
    private BizDate syoruiukeymd;

    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }
}
