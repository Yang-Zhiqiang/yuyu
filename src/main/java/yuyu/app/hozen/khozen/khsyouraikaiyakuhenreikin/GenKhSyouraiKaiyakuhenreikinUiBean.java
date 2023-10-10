package yuyu.app.hozen.khozen.khsyouraikaiyakuhenreikin;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SelHokensyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 将来解約返戻金照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhSyouraiKaiyakuhenreikinUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @SyoukenNo
    private String srchsyono;

    public String getSrchsyono() {
        return srchsyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsyono(String pSrchsyono) {
        srchsyono = pSrchsyono;
    }

    @ValidDate
    private BizDate srchsknnkaisiymd;

    public BizDate getSrchsknnkaisiymd() {
        return srchsknnkaisiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsknnkaisiymd(BizDate pSrchsknnkaisiymd) {
        srchsknnkaisiymd = pSrchsknnkaisiymd;
    }

    @ValidDate
    private BizDate srchkykymd;

    public BizDate getSrchkykymd() {
        return srchkykymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchkykymd(BizDate pSrchkykymd) {
        srchkykymd = pSrchkykymd;
    }

    @Range(min="0", max="99")
    private Integer srchkanyuujinen;

    public Integer getSrchkanyuujinen() {
        return srchkanyuujinen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchkanyuujinen(Integer pSrchkanyuujinen) {
        srchkanyuujinen = pSrchkanyuujinen;
    }

    private C_Seibetu srchsei;

    public C_Seibetu getSrchsei() {
        return srchsei;
    }

    public void setSrchsei(C_Seibetu pSrchsei) {
        srchsei = pSrchsei;
    }

    private C_SelHokensyuruiKbn srchhknsyrui;

    public C_SelHokensyuruiKbn getSrchhknsyrui() {
        return srchhknsyrui;
    }

    public void setSrchhknsyrui(C_SelHokensyuruiKbn pSrchhknsyrui) {
        srchhknsyrui = pSrchhknsyrui;
    }

    private C_Tuukasyu srchsiteituuka;

    public C_Tuukasyu getSrchsiteituuka() {
        return srchsiteituuka;
    }

    public void setSrchsiteituuka(C_Tuukasyu pSrchsiteituuka) {
        srchsiteituuka = pSrchsiteituuka;
    }

    @Range(min="0", max="99")
    private Integer srchhknkkn;

    public Integer getSrchhknkkn() {
        return srchhknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchhknkkn(Integer pSrchhknkkn) {
        srchhknkkn = pSrchhknkkn;
    }

    @Range(min="0", max="99")
    private Integer srchhrkkkn;

    public Integer getSrchhrkkkn() {
        return srchhrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchhrkkkn(Integer pSrchhrkkkn) {
        srchhrkkkn = pSrchhrkkkn;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency srchkihons;

    public BizCurrency getSrchkihons() {
        return srchkihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchkihons(BizCurrency pSrchkihons) {
        srchkihons = pSrchkihons;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency srchp;

    public BizCurrency getSrchp() {
        return srchp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchp(BizCurrency pSrchp) {
        srchp = pSrchp;
    }

    @RangeBizCalcable(min="0", max="100")
    private BizNumber srchsisuurendourate;

    public BizNumber getSrchsisuurendourate() {
        return srchsisuurendourate;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsisuurendourate(BizNumber pSrchsisuurendourate) {
        srchsisuurendourate = pSrchsisuurendourate;
    }

    @ValidDate
    private BizDate srchyendthnkymd;

    public BizDate getSrchyendthnkymd() {
        return srchyendthnkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchyendthnkymd(BizDate pSrchyendthnkymd) {
        srchyendthnkymd = pSrchyendthnkymd;
    }

    @ValidDate
    private BizDate srchtmttknitenymd;

    public BizDate getSrchtmttknitenymd() {
        return srchtmttknitenymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchtmttknitenymd(BizDate pSrchtmttknitenymd) {
        srchtmttknitenymd = pSrchtmttknitenymd;
    }

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

    private BizDate sknnkaisiymd;

    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDate kykymd;

    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    @NaturalNumber
    private Integer hhknnen;

    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_Hhknsei hhknsei;

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String syouhnnm;

    public String getSyouhnnm() {
        return syouhnnm;
    }

    @Trim("right")
    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

    private C_Tuukasyu siteituuka;

    public C_Tuukasyu getSiteituuka() {
        return siteituuka;
    }

    public void setSiteituuka(C_Tuukasyu pSiteituuka) {
        siteituuka = pSiteituuka;
    }

    @Range(min="0", max="99")
    private Integer hknkkn;

    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    @Range(min="0", max="99")
    private Integer hrkkkn;

    public Integer getHrkkkn() {
        return hrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    @CurrencyLenght(length=13)
    private BizCurrency kihons;

    public BizCurrency getKihons() {
        return kihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
    }

    private BizCurrency hokenryou;

    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
    }

    private BizNumber sisuurendourate;

    public BizNumber getSisuurendourate() {
        return sisuurendourate;
    }

    public void setSisuurendourate(BizNumber pSisuurendourate) {
        sisuurendourate = pSisuurendourate;
    }

    private BizDate yendthnkymd;

    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    private BizDate tmttknitenymd;

    public BizDate getTmttknitenymd() {
        return tmttknitenymd;
    }

    public void setTmttknitenymd(BizDate pTmttknitenymd) {
        tmttknitenymd = pTmttknitenymd;
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
    }
}
