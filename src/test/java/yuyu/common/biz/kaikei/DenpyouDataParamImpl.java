package yuyu.common.biz.kaikei;

import javax.persistence.Column;
import javax.persistence.Transient;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;

import org.hibernate.annotations.Type;

import yuyu.common.biz.bzcommon.DenpyouDataParam;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.mapping.GenBT_DenpyoData;

/**
 * 経理伝票データ作成共通処理クラス。<br />
 */
public class DenpyouDataParamImpl implements DenpyouDataParam {

    private String denrenno;

    @Override
    public String getDenrenno() {
        return denrenno;
    }

    @Override
    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private Integer edano;

    @Override
    public Integer getEdano() {
        return edano;
    }

    @Override
    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    private C_DensysKbn densyskbn;

    @Override
    public C_DensysKbn getDensyskbn() {
        return densyskbn;
    }

    @Override
    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        densyskbn = pDensyskbn;
    }

    private String syono;

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String huridenatesakicd;

    @Override
    @Column(name = GenBT_DenpyoData.HURIDENATESAKICD)
    public String getHuridenatesakicd() {
        return huridenatesakicd;
    }

    @Override
    public void setHuridenatesakicd(String pHuridenatesakicd) {
        huridenatesakicd = pHuridenatesakicd;
    }

    private C_TantouCdKbn tantocd;

    @Override
    @Type(type = "UserType_C_TantouCdKbn")
    @Column(name = GenBT_DenpyoData.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    @Override
    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private BizDate denymd;

    @Override
    @Type(type = "BizDateType")
    @Column(name = GenBT_DenpyoData.DENYMD)
    public BizDate getDenymd() {
        return denymd;
    }

    @Override
    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }

    private C_TaisyakuKbn taisyakukbn;

    @Override
    @Type(type = "UserType_C_TaisyakuKbn")
    @Column(name = GenBT_DenpyoData.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    @Override
    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Override
    @Type(type = "UserType_C_Kanjyoukmkcd")
    @Column(name = GenBT_DenpyoData.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    @Override
    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    private String suitoubumoncd;

    @Override
    @Column(name = GenBT_DenpyoData.SUITOUBUMONCD)
    public String getSuitoubumoncd() {
        return suitoubumoncd;
    }

    @Override
    public void setSuitoubumoncd(String pSuitoubumoncd) {
        suitoubumoncd = pSuitoubumoncd;
    }

    private C_Tuukasyu tuukasyu;

    @Override
    @Type(type = "UserType_C_Tuukasyu")
    @Column(name = GenBT_DenpyoData.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    @Override
    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private BizCurrency dengaikagk;

    @Override
    @Type(type = "BizCurrencyType")
    @Transient
    public BizCurrency getDengaikagk() {
        return dengaikagk;
    }

    @Override
    public void setDengaikagk(BizCurrency pDengaikagk) {
        dengaikagk = pDengaikagk;
    }

    private BizNumber denkawaserate;

    @Override
    @Type(type = "BizNumberType")
    @Column(name = GenBT_DenpyoData.DENKAWASERATE)
    public BizNumber getDenkawaserate() {
        return denkawaserate;
    }

    @Override
    public void setDenkawaserate(BizNumber pDenkawaserate) {
        denkawaserate = pDenkawaserate;
    }

    private BizCurrency denyenkagk;

    @Override
    @Type(type = "BizCurrencyType")
    @Transient
    public BizCurrency getDenyenkagk() {
        return denyenkagk;
    }

    @Override
    public void setDenyenkagk(BizCurrency pDenyenkagk) {
        denyenkagk = pDenyenkagk;
    }

    private C_HuridensksKbn huridenskskbn;

    @Override
    @Type(type = "UserType_C_HuridensksKbn")
    @Column(name = GenBT_DenpyoData.HURIDENSKSKBN)
    public C_HuridensksKbn getHuridenskskbn() {
        return huridenskskbn;
    }

    @Override
    public void setHuridenskskbn(C_HuridensksKbn pHuridenskskbn) {
        huridenskskbn = pHuridenskskbn;
    }

    private C_DenhnknhouKbn denhnknhoukbn;

    @Override
    @Type(type = "UserType_C_DenhnknhouKbn")
    @Column(name = GenBT_DenpyoData.DENHNKNHOUKBN)
    public C_DenhnknhouKbn getDenhnknhoukbn() {
        return denhnknhoukbn;
    }

    @Override
    public void setDenhnknhoukbn(C_DenhnknhouKbn pDenhnknhoukbn) {
        denhnknhoukbn = pDenhnknhoukbn;
    }

    private C_DenshrhouKbn denshrhoukbn;

    @Override
    @Type(type = "UserType_C_DenshrhouKbn")
    @Column(name = GenBT_DenpyoData.DENSHRHOUKBN)
    public C_DenshrhouKbn getDenshrhoukbn() {
        return denshrhoukbn;
    }

    @Override
    public void setDenshrhoukbn(C_DenshrhouKbn pDenshrhoukbn) {
        denshrhoukbn = pDenshrhoukbn;
    }

    private BizDate syoriYmd;

    @Override
    @Type(type = "BizDateType")
    @Column(name = GenBT_DenpyoData.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Override
    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String syoricd;

    @Override
    @Column(name = GenBT_DenpyoData.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    @Override
    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private String syorisosikicd;

    @Override
    @Column(name = GenBT_DenpyoData.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    @Override
    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private C_Segcd seg1cd;

    @Override
    @Type(type = "UserType_C_Segcd")
    @Column(name = GenBT_DenpyoData.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    @Override
    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private C_Segcd seg2cd;

    @Override
    @Type(type = "UserType_C_Segcd")
    @Column(name = GenBT_DenpyoData.SEG2CD)
    public C_Segcd getSeg2cd() {
        return seg2cd;
    }

    @Override
    public void setSeg2cd(C_Segcd pSeg2cd) {
        seg2cd = pSeg2cd;
    }

    private Boolean kakokawaserateshiteiflg;

    @Override
    @Type(type = "BooleanType")
    @Column(name = GenBT_DenpyoData.KAKOKAWASERATESHITEIFLG)
    public Boolean getKakokawaserateshiteiflg() {
        return kakokawaserateshiteiflg;
    }

    @Override
    public void setKakokawaserateshiteiflg(Boolean pKakokawaserateshiteiflg) {
        kakokawaserateshiteiflg = pKakokawaserateshiteiflg;
    }

    private BizDate kakokawaserateshiteiymd;

    @Override
    @Type(type = "BizDateType")
    @Column(name = GenBT_DenpyoData.KAKOKAWASERATESHITEIYMD)
    @ValidDate
    public BizDate getKakokawaserateshiteiymd() {
        return kakokawaserateshiteiymd;
    }

    @Override
    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKakokawaserateshiteiymd(BizDate pKakokawaserateshiteiymd) {
        kakokawaserateshiteiymd = pKakokawaserateshiteiymd;
    }

    private String gyoumuKousinsyaId;

    @Override
    @Column(name = GenBT_DenpyoData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    @Override
    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Override
    @Column(name = GenBT_DenpyoData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    @Override
    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_Tuukasyu kyktuukasyu;

    @Override
    @Column(name = GenBT_DenpyoData.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    @Override
    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizCurrency keiyakutuukagk;

    @Override
    @Column(name = GenBT_DenpyoData.KEIYAKUTUUKAGK)
    public BizCurrency getKeiyakutuukagk() {
        return keiyakutuukagk;
    }

    @Override
    public void setKeiyakutuukagk(BizCurrency pKeiyakutuukagk) {
        keiyakutuukagk = pKeiyakutuukagk;
    }

    private String dengyoumucd;

    @Override
    public String getDengyoumucd() {
        return dengyoumucd;
    }

    @Override
    public void setDengyoumucd(String pDengyoumucd) {
        dengyoumucd = pDengyoumucd;
    }

    private String syusyouhncd;

    @Override
    public String getSyusyouhncd() {
        return syusyouhncd;
    }

    @Override
    public void setSyusyouhncd(String pSyusyouhncd) {
        syusyouhncd = pSyusyouhncd;
    }

    private Integer syouhnsdno;

    @Override
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    @Override
    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private C_KawasetekiyoKbn kawasetekiyokbn;

    @Override
    public C_KawasetekiyoKbn getKawasetekiyokbn() {
        return kawasetekiyokbn;
    }

    @Override
    public void setKawasetekiyokbn(C_KawasetekiyoKbn pKawasetekiyokbn) {
        kawasetekiyokbn = pKawasetekiyokbn;
    }

    private String denkarikanjyono;

    @Override
    public String getDenkarikanjyono() {
        return denkarikanjyono;
    }

    @Override
    public void setDenkarikanjyono(String pDenkarikanjyono) {
        denkarikanjyono = pDenkarikanjyono;
    }

    private Boolean taisyakutyouseiflg;

    @Override
    public Boolean getTaisyakutyouseiflg() {
        return taisyakutyouseiflg;
    }

    @Override
    public void setTaisyakutyouseiflg(Boolean pTaisyakutyouseiflg) {
        taisyakutyouseiflg = pTaisyakutyouseiflg;
    }

    private C_DenSyorisyousaiKbn densyorisyousaikbn;

    @Override
    public C_DenSyorisyousaiKbn getDensyorisyousaikbn() {
        return densyorisyousaikbn;
    }

    @Override
    public void setDensyorisyousaikbn(C_DenSyorisyousaiKbn pDensyorisyousaikbn) {
        densyorisyousaikbn = pDensyorisyousaikbn;
    }
}
