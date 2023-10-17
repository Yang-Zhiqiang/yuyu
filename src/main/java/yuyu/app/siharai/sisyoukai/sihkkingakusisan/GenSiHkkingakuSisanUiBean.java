package yuyu.app.siharai.sisyoukai.sihkkingakusisan;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HasuukasanUmuKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金額試算 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiHkkingakuSisanUiBean extends AbstractUiBean {

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

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String kyknmkn;

    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String kyknmkj;

    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    @ValidDate
    private BizDate kykseiymd;

    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private C_Kyksei kyksei;

    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String tsinyno;

    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr1kj;

    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr2kj;

    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr3kj;

    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String hhknnmkn;

    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknnmkj;

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    @ValidDate
    private BizDate hhknseiymd;

    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private C_Hhknsei hhknsei;

    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    @Range(min="0", max="99")
    private Integer sbuktnin;

    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private C_UktKbn dispsbuktkbn1;

    public C_UktKbn getDispsbuktkbn1() {
        return dispsbuktkbn1;
    }

    public void setDispsbuktkbn1(C_UktKbn pDispsbuktkbn1) {
        dispsbuktkbn1 = pDispsbuktkbn1;
    }

    private String dispsbuktnmkn1;

    public String getDispsbuktnmkn1() {
        return dispsbuktnmkn1;
    }

    public void setDispsbuktnmkn1(String pDispsbuktnmkn1) {
        dispsbuktnmkn1 = pDispsbuktnmkn1;
    }

    private String dispsbuktnmkj1;

    public String getDispsbuktnmkj1() {
        return dispsbuktnmkj1;
    }

    public void setDispsbuktnmkj1(String pDispsbuktnmkj1) {
        dispsbuktnmkj1 = pDispsbuktnmkj1;
    }

    private BizDate dispsbuktseiymd1;

    public BizDate getDispsbuktseiymd1() {
        return dispsbuktseiymd1;
    }

    public void setDispsbuktseiymd1(BizDate pDispsbuktseiymd1) {
        dispsbuktseiymd1 = pDispsbuktseiymd1;
    }

    private String dispmskmjskjuktnen1;

    public String getDispmskmjskjuktnen1() {
        return dispmskmjskjuktnen1;
    }

    public void setDispmskmjskjuktnen1(String pDispmskmjskjuktnen1) {
        dispmskmjskjuktnen1 = pDispmskmjskjuktnen1;
    }

    private BizNumber dispsbuktbnwari1;

    public BizNumber getDispsbuktbnwari1() {
        return dispsbuktbnwari1;
    }

    public void setDispsbuktbnwari1(BizNumber pDispsbuktbnwari1) {
        dispsbuktbnwari1 = pDispsbuktbnwari1;
    }

    private C_UktKbn dispsbuktkbn2;

    public C_UktKbn getDispsbuktkbn2() {
        return dispsbuktkbn2;
    }

    public void setDispsbuktkbn2(C_UktKbn pDispsbuktkbn2) {
        dispsbuktkbn2 = pDispsbuktkbn2;
    }

    private String dispsbuktnmkn2;

    public String getDispsbuktnmkn2() {
        return dispsbuktnmkn2;
    }

    public void setDispsbuktnmkn2(String pDispsbuktnmkn2) {
        dispsbuktnmkn2 = pDispsbuktnmkn2;
    }

    private String dispsbuktnmkj2;

    public String getDispsbuktnmkj2() {
        return dispsbuktnmkj2;
    }

    public void setDispsbuktnmkj2(String pDispsbuktnmkj2) {
        dispsbuktnmkj2 = pDispsbuktnmkj2;
    }

    private BizDate dispsbuktseiymd2;

    public BizDate getDispsbuktseiymd2() {
        return dispsbuktseiymd2;
    }

    public void setDispsbuktseiymd2(BizDate pDispsbuktseiymd2) {
        dispsbuktseiymd2 = pDispsbuktseiymd2;
    }

    private String dispmskmjskjuktnen2;

    public String getDispmskmjskjuktnen2() {
        return dispmskmjskjuktnen2;
    }

    public void setDispmskmjskjuktnen2(String pDispmskmjskjuktnen2) {
        dispmskmjskjuktnen2 = pDispmskmjskjuktnen2;
    }

    private BizNumber dispsbuktbnwari2;

    public BizNumber getDispsbuktbnwari2() {
        return dispsbuktbnwari2;
    }

    public void setDispsbuktbnwari2(BizNumber pDispsbuktbnwari2) {
        dispsbuktbnwari2 = pDispsbuktbnwari2;
    }

    private C_UktKbn dispsbuktkbn3;

    public C_UktKbn getDispsbuktkbn3() {
        return dispsbuktkbn3;
    }

    public void setDispsbuktkbn3(C_UktKbn pDispsbuktkbn3) {
        dispsbuktkbn3 = pDispsbuktkbn3;
    }

    private String dispsbuktnmkn3;

    public String getDispsbuktnmkn3() {
        return dispsbuktnmkn3;
    }

    public void setDispsbuktnmkn3(String pDispsbuktnmkn3) {
        dispsbuktnmkn3 = pDispsbuktnmkn3;
    }

    private String dispsbuktnmkj3;

    public String getDispsbuktnmkj3() {
        return dispsbuktnmkj3;
    }

    public void setDispsbuktnmkj3(String pDispsbuktnmkj3) {
        dispsbuktnmkj3 = pDispsbuktnmkj3;
    }

    private BizDate dispsbuktseiymd3;

    public BizDate getDispsbuktseiymd3() {
        return dispsbuktseiymd3;
    }

    public void setDispsbuktseiymd3(BizDate pDispsbuktseiymd3) {
        dispsbuktseiymd3 = pDispsbuktseiymd3;
    }

    private String dispmskmjskjuktnen3;

    public String getDispmskmjskjuktnen3() {
        return dispmskmjskjuktnen3;
    }

    public void setDispmskmjskjuktnen3(String pDispmskmjskjuktnen3) {
        dispmskmjskjuktnen3 = pDispmskmjskjuktnen3;
    }

    private BizNumber dispsbuktbnwari3;

    public BizNumber getDispsbuktbnwari3() {
        return dispsbuktbnwari3;
    }

    public void setDispsbuktbnwari3(BizNumber pDispsbuktbnwari3) {
        dispsbuktbnwari3 = pDispsbuktbnwari3;
    }

    private C_UktKbn dispsbuktkbn4;

    public C_UktKbn getDispsbuktkbn4() {
        return dispsbuktkbn4;
    }

    public void setDispsbuktkbn4(C_UktKbn pDispsbuktkbn4) {
        dispsbuktkbn4 = pDispsbuktkbn4;
    }

    private String dispsbuktnmkn4;

    public String getDispsbuktnmkn4() {
        return dispsbuktnmkn4;
    }

    public void setDispsbuktnmkn4(String pDispsbuktnmkn4) {
        dispsbuktnmkn4 = pDispsbuktnmkn4;
    }

    private String dispsbuktnmkj4;

    public String getDispsbuktnmkj4() {
        return dispsbuktnmkj4;
    }

    public void setDispsbuktnmkj4(String pDispsbuktnmkj4) {
        dispsbuktnmkj4 = pDispsbuktnmkj4;
    }

    private BizDate dispsbuktseiymd4;

    public BizDate getDispsbuktseiymd4() {
        return dispsbuktseiymd4;
    }

    public void setDispsbuktseiymd4(BizDate pDispsbuktseiymd4) {
        dispsbuktseiymd4 = pDispsbuktseiymd4;
    }

    private String dispmskmjskjuktnen4;

    public String getDispmskmjskjuktnen4() {
        return dispmskmjskjuktnen4;
    }

    public void setDispmskmjskjuktnen4(String pDispmskmjskjuktnen4) {
        dispmskmjskjuktnen4 = pDispmskmjskjuktnen4;
    }

    private BizNumber dispsbuktbnwari4;

    public BizNumber getDispsbuktbnwari4() {
        return dispsbuktbnwari4;
    }

    public void setDispsbuktbnwari4(BizNumber pDispsbuktbnwari4) {
        dispsbuktbnwari4 = pDispsbuktbnwari4;
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private C_GeninKbn geninkbn;

    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
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

    @ValidDate
    private BizDate knsnkijyunymd;

    public BizDate getKnsnkijyunymd() {
        return knsnkijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKnsnkijyunymd(BizDate pKnsnkijyunymd) {
        knsnkijyunymd = pKnsnkijyunymd;
    }

    private BizNumber kawaserate;

    public BizNumber getKawaserate() {
        return kawaserate;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKawaserate(BizNumber pKawaserate) {
        kawaserate = pKawaserate;
    }

    @RangeBizCalcable(min="0.01", max="100.00")
    private BizNumber sihknknuktbnwari;

    public BizNumber getSihknknuktbnwari() {
        return sihknknuktbnwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSihknknuktbnwari(BizNumber pSihknknuktbnwari) {
        sihknknuktbnwari = pSihknknuktbnwari;
    }

    private C_HasuukasanUmuKbn hasuukasanhyouji;

    public C_HasuukasanUmuKbn getHasuukasanhyouji() {
        return hasuukasanhyouji;
    }

    public void setHasuukasanhyouji(C_HasuukasanUmuKbn pHasuukasanhyouji) {
        hasuukasanhyouji = pHasuukasanhyouji;
    }

    private C_ZeitratkiKbn zeitratkikbn;

    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }

    private BizCurrency itijibrp;

    public BizCurrency getItijibrp() {
        return itijibrp;
    }

    public void setItijibrp(BizCurrency pItijibrp) {
        itijibrp = pItijibrp;
    }

    private BizCurrency kihrkmp;

    public BizCurrency getKihrkmp() {
        return kihrkmp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkmp(BizCurrency pKihrkmp) {
        kihrkmp = pKihrkmp;
    }

    @ValidDate
    private BizDate ryosyuymd;

    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private C_Tuukasyu vhrkiyentkykwsratetuukasyu;

    public C_Tuukasyu getVhrkiyentkykwsratetuukasyu() {
        return vhrkiyentkykwsratetuukasyu;
    }

    public void setVhrkiyentkykwsratetuukasyu(C_Tuukasyu pVhrkiyentkykwsratetuukasyu) {
        vhrkiyentkykwsratetuukasyu = pVhrkiyentkykwsratetuukasyu;
    }

    private BizNumber yenkansantkykwsrate;

    public BizNumber getYenkansantkykwsrate() {
        return yenkansantkykwsrate;
    }

    public void setYenkansantkykwsrate(BizNumber pYenkansantkykwsrate) {
        yenkansantkykwsrate = pYenkansantkykwsrate;
    }

    private BizCurrency vhrkiyenkansannyknkingk;

    public BizCurrency getVhrkiyenkansannyknkingk() {
        return vhrkiyenkansannyknkingk;
    }

    public void setVhrkiyenkansannyknkingk(BizCurrency pVhrkiyenkansannyknkingk) {
        vhrkiyenkansannyknkingk = pVhrkiyenkansannyknkingk;
    }

    private String hokenkinsyurui;

    public String getHokenkinsyurui() {
        return hokenkinsyurui;
    }

    public void setHokenkinsyurui(String pHokenkinsyurui) {
        hokenkinsyurui = pHokenkinsyurui;
    }

    private C_SUketoriHouhouKbn dispsuketorihouhoukbn;

    public C_SUketoriHouhouKbn getDispsuketorihouhoukbn() {
        return dispsuketorihouhoukbn;
    }

    public void setDispsuketorihouhoukbn(C_SUketoriHouhouKbn pDispsuketorihouhoukbn) {
        dispsuketorihouhoukbn = pDispsuketorihouhoukbn;
    }

    private BizDate dispcalckijyunymd;

    public BizDate getDispcalckijyunymd() {
        return dispcalckijyunymd;
    }

    public void setDispcalckijyunymd(BizDate pDispcalckijyunymd) {
        dispcalckijyunymd = pDispcalckijyunymd;
    }

    private BizDate dispknsnkijyunymd;

    public BizDate getDispknsnkijyunymd() {
        return dispknsnkijyunymd;
    }

    public void setDispknsnkijyunymd(BizDate pDispknsnkijyunymd) {
        dispknsnkijyunymd = pDispknsnkijyunymd;
    }

    private String disptuukasyu;

    public String getDisptuukasyu() {
        return disptuukasyu;
    }

    public void setDisptuukasyu(String pDisptuukasyu) {
        disptuukasyu = pDisptuukasyu;
    }

    private BizNumber dispkawaserate;

    public BizNumber getDispkawaserate() {
        return dispkawaserate;
    }

    public void setDispkawaserate(BizNumber pDispkawaserate) {
        dispkawaserate = pDispkawaserate;
    }

    private BizDate gaikaknsnkwsratekjymd;

    public BizDate getGaikaknsnkwsratekjymd() {
        return gaikaknsnkwsratekjymd;
    }

    public void setGaikaknsnkwsratekjymd(BizDate pGaikaknsnkwsratekjymd) {
        gaikaknsnkwsratekjymd = pGaikaknsnkwsratekjymd;
    }

    private String disptuukasyu2;

    public String getDisptuukasyu2() {
        return disptuukasyu2;
    }

    public void setDisptuukasyu2(String pDisptuukasyu2) {
        disptuukasyu2 = pDisptuukasyu2;
    }

    private BizNumber gaikaknsnkwsrate;

    public BizNumber getGaikaknsnkwsrate() {
        return gaikaknsnkwsrate;
    }

    public void setGaikaknsnkwsrate(BizNumber pGaikaknsnkwsrate) {
        gaikaknsnkwsrate = pGaikaknsnkwsrate;
    }

    @RangeBizCalcable(min="0.01", max="100.00")
    private BizNumber dispsihknknuktbnwari;

    public BizNumber getDispsihknknuktbnwari() {
        return dispsihknknuktbnwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsihknknuktbnwari(BizNumber pDispsihknknuktbnwari) {
        dispsihknknuktbnwari = pDispsihknknuktbnwari;
    }

    private C_HasuukasanUmuKbn disphasuukasanhyouji;

    public C_HasuukasanUmuKbn getDisphasuukasanhyouji() {
        return disphasuukasanhyouji;
    }

    public void setDisphasuukasanhyouji(C_HasuukasanUmuKbn pDisphasuukasanhyouji) {
        disphasuukasanhyouji = pDisphasuukasanhyouji;
    }

    private BizCurrency hokenkngk;

    public BizCurrency getHokenkngk() {
        return hokenkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHokenkngk(BizCurrency pHokenkngk) {
        hokenkngk = pHokenkngk;
    }

    private BizCurrency yenhokenkngk;

    public BizCurrency getYenhokenkngk() {
        return yenhokenkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhokenkngk(BizCurrency pYenhokenkngk) {
        yenhokenkngk = pYenhokenkngk;
    }

    private BizCurrency ptumitatekin;

    public BizCurrency getPtumitatekin() {
        return ptumitatekin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPtumitatekin(BizCurrency pPtumitatekin) {
        ptumitatekin = pPtumitatekin;
    }

    private BizCurrency jpyptumitatekin;

    public BizCurrency getJpyptumitatekin() {
        return jpyptumitatekin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJpyptumitatekin(BizCurrency pJpyptumitatekin) {
        jpyptumitatekin = pJpyptumitatekin;
    }

    private BizCurrency haitoukin;

    public BizCurrency getHaitoukin() {
        return haitoukin;
    }

    public void setHaitoukin(BizCurrency pHaitoukin) {
        haitoukin = pHaitoukin;
    }

    private BizCurrency yenkahaitoukin;

    public BizCurrency getYenkahaitoukin() {
        return yenkahaitoukin;
    }

    public void setYenkahaitoukin(BizCurrency pYenkahaitoukin) {
        yenkahaitoukin = pYenkahaitoukin;
    }

    private BizCurrency sonotahaitoukin;

    public BizCurrency getSonotahaitoukin() {
        return sonotahaitoukin;
    }

    public void setSonotahaitoukin(BizCurrency pSonotahaitoukin) {
        sonotahaitoukin = pSonotahaitoukin;
    }

    private BizCurrency yenkasonotahaitoukin;

    public BizCurrency getYenkasonotahaitoukin() {
        return yenkasonotahaitoukin;
    }

    public void setYenkasonotahaitoukin(BizCurrency pYenkasonotahaitoukin) {
        yenkasonotahaitoukin = pYenkasonotahaitoukin;
    }

    private String mikeikapgaitoukkn;

    public String getMikeikapgaitoukkn() {
        return mikeikapgaitoukkn;
    }

    public void setMikeikapgaitoukkn(String pMikeikapgaitoukkn) {
        mikeikapgaitoukkn = pMikeikapgaitoukkn;
    }

    private BizCurrency mikeikap;

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
    }

    private BizCurrency yenkamikeikap;

    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    public void setYenkamikeikap(BizCurrency pYenkamikeikap) {
        yenkamikeikap = pYenkamikeikap;
    }

    private String misyuupgaitoukkn;

    public String getMisyuupgaitoukkn() {
        return misyuupgaitoukkn;
    }

    public void setMisyuupgaitoukkn(String pMisyuupgaitoukkn) {
        misyuupgaitoukkn = pMisyuupgaitoukkn;
    }

    private BizCurrency misyuup;

    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
    }

    private BizCurrency yenkamisyuup;

    public BizCurrency getYenkamisyuup() {
        return yenkamisyuup;
    }

    public void setYenkamisyuup(BizCurrency pYenkamisyuup) {
        yenkamisyuup = pYenkamisyuup;
    }

    private BizCurrency zennouseisankgk;

    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        zennouseisankgk = pZennouseisankgk;
    }

    private BizCurrency yenkazennouseisankgk;

    public BizCurrency getYenkazennouseisankgk() {
        return yenkazennouseisankgk;
    }

    public void setYenkazennouseisankgk(BizCurrency pYenkazennouseisankgk) {
        yenkazennouseisankgk = pYenkazennouseisankgk;
    }

    private BizCurrency azukarikingk;

    public BizCurrency getAzukarikingk() {
        return azukarikingk;
    }

    public void setAzukarikingk(BizCurrency pAzukarikingk) {
        azukarikingk = pAzukarikingk;
    }

    private BizCurrency yenkaazukarikingk;

    public BizCurrency getYenkaazukarikingk() {
        return yenkaazukarikingk;
    }

    public void setYenkaazukarikingk(BizCurrency pYenkaazukarikingk) {
        yenkaazukarikingk = pYenkaazukarikingk;
    }

    private BizCurrency krkgk;

    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
    }

    private BizCurrency yenkakrkgk;

    public BizCurrency getYenkakrkgk() {
        return yenkakrkgk;
    }

    public void setYenkakrkgk(BizCurrency pYenkakrkgk) {
        yenkakrkgk = pYenkakrkgk;
    }

    private BizCurrency dispgoukeigk;

    public BizCurrency getDispgoukeigk() {
        return dispgoukeigk;
    }

    public void setDispgoukeigk(BizCurrency pDispgoukeigk) {
        dispgoukeigk = pDispgoukeigk;
    }

    private BizCurrency dispyenkagoukeigk;

    public BizCurrency getDispyenkagoukeigk() {
        return dispyenkagoukeigk;
    }

    public void setDispyenkagoukeigk(BizCurrency pDispyenkagoukeigk) {
        dispyenkagoukeigk = pDispyenkagoukeigk;
    }

    private C_ZeitratkiKbn dispzeitratkikbn;

    public C_ZeitratkiKbn getDispzeitratkikbn() {
        return dispzeitratkikbn;
    }

    public void setDispzeitratkikbn(C_ZeitratkiKbn pDispzeitratkikbn) {
        dispzeitratkikbn = pDispzeitratkikbn;
    }

    private BizCurrency synykngk;

    public BizCurrency getSynykngk() {
        return synykngk;
    }

    public void setSynykngk(BizCurrency pSynykngk) {
        synykngk = pSynykngk;
    }

    private BizCurrency gaikashrsynykngk;

    public BizCurrency getGaikashrsynykngk() {
        return gaikashrsynykngk;
    }

    public void setGaikashrsynykngk(BizCurrency pGaikashrsynykngk) {
        gaikashrsynykngk = pGaikashrsynykngk;
    }

    private BizCurrency kztkgk;

    public BizCurrency getKztkgk() {
        return kztkgk;
    }

    public void setKztkgk(BizCurrency pKztkgk) {
        kztkgk = pKztkgk;
    }

    private BizCurrency sikinidougaku;

    public BizCurrency getSikinidougaku() {
        return sikinidougaku;
    }

    public void setSikinidougaku(BizCurrency pSikinidougaku) {
        sikinidougaku = pSikinidougaku;
    }

    private String reportKey;

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }
}
