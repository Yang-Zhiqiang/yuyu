package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_HasuukasanUmuKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払金額計算Bean
 */
public class SiSiharaiKingakuKeisanBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoNo;

    private C_SeikyuuSyubetu seikyuuSyubetu;

    private BizDate calcKijyunYmd;

    private BizDate knsnKijyunYmd;

    private BizNumber kawaseRate;

    private BizNumber siHknknUktBnWari;

    private C_HasuukasanUmuKbn hasuuKasanHyouji;

    private C_InputShrhousiteiKbn inputShrhouSiteiKbn;

    private BizDate syoruiUkeYmd;

    private BizDate hubiKanryouYmd;

    private Integer rikoukiTyuutuudanNissuu;

    private C_SinsaGendoKknKbn sinsaGendoKknKbn;

    private C_SUketoriHouhouKbn sUketoriHouhouKbn;

    private C_SiharaiTuukaKbn siharaiTuukaKbn;

    private C_Nstknsyu nkShrTkykNksyuKbn;

    private Integer nkShrTkykNksyuKkn;

    private C_Bnshrkaisuu bnShrKaisuu;

    private BizCurrency nkKknJyutouGk;

    private C_NkHaitoukinuketorihouKbn nkHaitoukinuketorihouKbn;

    private JT_SiKykKihon siKykKihon;

    private C_SiHonninKakninKekkaKbn siHonninKakninKbn;

    private C_KahiKbn keisanKahiKbn;

    private String yobidasimotoKinouId;

    private C_SikinouModeIdKbn sikinouModeIdKbn;

    private C_SiinKbn siinkbn;

    private C_SaisateiKbn  saisateikbn;

    private String uktmnmeigibangou;

    private String kykmnmeigibangou;

    private String bankCd;

    private C_UmuKbn kaiyakusjkkktyouseirirituUmKbn;

    private BizNumber kaiyakusjkkktyouseiriritu;

    private C_SeikyuusyaKbn seikyuusyaKbn;

    private BizNumber gaikaknsnKwsrate;

    private BizDate syoriYmd;

    public SiSiharaiKingakuKeisanBean() {
        syoNo = "";
        seikyuuSyubetu = C_SeikyuuSyubetu.BLNK;
        calcKijyunYmd = null;
        knsnKijyunYmd = null;
        kawaseRate = BizNumber.optional();
        siHknknUktBnWari = BizNumber.valueOf(100.00);
        hasuuKasanHyouji = C_HasuukasanUmuKbn.HASUUKASANNASI;
        inputShrhouSiteiKbn = C_InputShrhousiteiKbn.BLNK;
        syoruiUkeYmd = null;
        hubiKanryouYmd = null;
        rikoukiTyuutuudanNissuu = 0;
        sinsaGendoKknKbn = C_SinsaGendoKknKbn.BLNK;
        sUketoriHouhouKbn = C_SUketoriHouhouKbn.BLNK;
        siharaiTuukaKbn = C_SiharaiTuukaKbn.BLNK;
        nkShrTkykNksyuKbn = C_Nstknsyu.BLNK;
        nkShrTkykNksyuKkn = 0;
        bnShrKaisuu = C_Bnshrkaisuu.BLNK;
        nkKknJyutouGk = BizCurrency.valueOf(0);
        nkHaitoukinuketorihouKbn = C_NkHaitoukinuketorihouKbn.NONE;
        siKykKihon = new JT_SiKykKihon();
        siHonninKakninKbn = C_SiHonninKakninKekkaKbn.KOUZA;
        keisanKahiKbn = C_KahiKbn.KA;
        yobidasimotoKinouId = "";
        sikinouModeIdKbn = C_SikinouModeIdKbn.DEFAULT;
        siinkbn = C_SiinKbn.BLNK;
        saisateikbn = C_SaisateiKbn.BLNK;
        uktmnmeigibangou = "";
        kykmnmeigibangou = "";
        bankCd = "";
        kaiyakusjkkktyouseirirituUmKbn = C_UmuKbn.NONE;
        kaiyakusjkkktyouseiriritu = BizNumber.valueOf(0);
        seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        gaikaknsnKwsrate = BizNumber.optional();
        syoriYmd = BizDate.getSysDate();
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public C_SeikyuuSyubetu getSeikyuuSyubetu() {
        return seikyuuSyubetu;
    }

    public void setSeikyuuSyubetu(C_SeikyuuSyubetu pSeikyuuSyubetu) {
        seikyuuSyubetu = pSeikyuuSyubetu;
    }

    public BizDate getCalcKijyunYmd() {
        return calcKijyunYmd;
    }

    public void setCalcKijyunYmd(BizDate pCalcKijyunYmd) {
        calcKijyunYmd = pCalcKijyunYmd;
    }

    public BizDate getKnsnKijyunYmd() {
        return knsnKijyunYmd;
    }

    public void setKnsnKijyunYmd(BizDate pKnsnKijyunYmd) {
        knsnKijyunYmd = pKnsnKijyunYmd;
    }

    public BizNumber getKawaseRate() {
        return kawaseRate;
    }

    public void setKawaseRate(BizNumber pKawaseRate) {
        kawaseRate = pKawaseRate;
    }

    public BizNumber getUktBnWari() {
        return siHknknUktBnWari;
    }

    public void setUktBnWari(BizNumber pSiHknknUktBnWari) {
        siHknknUktBnWari = pSiHknknUktBnWari;
    }

    public C_HasuukasanUmuKbn getHasuuKasanHyouji() {
        return hasuuKasanHyouji;
    }

    public void setHasuuKasanHyouji(C_HasuukasanUmuKbn pHasuuKasanHyouji) {
        hasuuKasanHyouji = pHasuuKasanHyouji;
    }

    public C_InputShrhousiteiKbn getInputShrhouSiteiKbn() {
        return inputShrhouSiteiKbn;
    }

    public void setInputShrhouSiteiKbn(C_InputShrhousiteiKbn pInputShrhouSiteiKbn) {
        inputShrhouSiteiKbn = pInputShrhouSiteiKbn;
    }

    public BizDate getSyoruiUkeYmd() {
        return syoruiUkeYmd;
    }

    public void setSyoruiUkeYmd(BizDate pSyoruiUkeYmd) {
        syoruiUkeYmd = pSyoruiUkeYmd;
    }

    public BizDate getHubiKanryouYmd() {
        return hubiKanryouYmd;
    }

    public void setHubiKanryouYmd(BizDate pHubiKanryouYmd) {
        hubiKanryouYmd = pHubiKanryouYmd;
    }

    public Integer getRikoukiTyuutuudanNissuu() {
        return rikoukiTyuutuudanNissuu;
    }

    public void setRikoukiTyuutuudanNissuu(Integer pRikoukiTyuutuudanNissuu) {
        rikoukiTyuutuudanNissuu = pRikoukiTyuutuudanNissuu;
    }

    public C_SinsaGendoKknKbn getSinsaGendoKknKbn() {
        return sinsaGendoKknKbn;
    }

    public void setSinsaGendoKknKbn(C_SinsaGendoKknKbn pSinsaGendoKknKbn) {
        sinsaGendoKknKbn = pSinsaGendoKknKbn;
    }

    public C_SUketoriHouhouKbn getSUketoriHouhouKbn() {
        return sUketoriHouhouKbn;
    }

    public void setSUketoriHouhouKbn(C_SUketoriHouhouKbn pSUketoriHouhouKbn) {
        sUketoriHouhouKbn = pSUketoriHouhouKbn;
    }

    public C_SiharaiTuukaKbn getSiharaiTuukaKbn() {
        return siharaiTuukaKbn;
    }

    public void setSiharaiTuukaKbn(C_SiharaiTuukaKbn pSiharaiTuukaKbn) {
        siharaiTuukaKbn = pSiharaiTuukaKbn;
    }

    public C_Nstknsyu getNkShrTkykNksyuKbn() {
        return nkShrTkykNksyuKbn;
    }

    public void setNkShrTkykNksyuKbn(C_Nstknsyu pNkShrTkykNksyuKbn) {
        nkShrTkykNksyuKbn = pNkShrTkykNksyuKbn;
    }

    public Integer getNkShrTkykNksyuKkn() {
        return nkShrTkykNksyuKkn;
    }

    public void setNkShrTkykNksyuKkn(Integer pNkShrTkykNksyuKkn) {
        nkShrTkykNksyuKkn = pNkShrTkykNksyuKkn;
    }

    public C_Bnshrkaisuu getBnShrKaisuu() {
        return bnShrKaisuu;
    }

    public void setBnShrKaisuu(C_Bnshrkaisuu pBnShrKaisuu) {
        bnShrKaisuu = pBnShrKaisuu;
    }

    public BizCurrency getNkKknJyutouGk() {
        return nkKknJyutouGk;
    }

    public void setNkKknJyutouGk(BizCurrency pNkKknJyutouGk) {
        nkKknJyutouGk = pNkKknJyutouGk;
    }

    public C_NkHaitoukinuketorihouKbn getNkHaitoukinuketorihouKbn() {
        return nkHaitoukinuketorihouKbn;
    }

    public void setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn pNkHaitoukinuketorihouKbn) {
        nkHaitoukinuketorihouKbn = pNkHaitoukinuketorihouKbn;
    }

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pSiKykKihon) {
        siKykKihon = pSiKykKihon;
    }

    public C_SiHonninKakninKekkaKbn getSiHonninKakninKbn() {
        return siHonninKakninKbn;
    }

    public void setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn pSiHonninKakninKbn) {
        siHonninKakninKbn = pSiHonninKakninKbn;
    }

    public C_KahiKbn getKeisanKahiKbn() {
        return keisanKahiKbn;
    }

    public void setKeisanKahiKbn(C_KahiKbn pKeisanKahiKbn) {
        keisanKahiKbn = pKeisanKahiKbn;
    }

    public String getYobidasimotoKinouId() {
        return yobidasimotoKinouId;
    }

    public void setYobidasimotoKinouId(String pYobidasimotoKinouId) {
        yobidasimotoKinouId = pYobidasimotoKinouId;
    }

    public C_SikinouModeIdKbn getSikinouModeIdKbn() {
        return sikinouModeIdKbn;
    }

    public void setSikinouModeIdKbn(C_SikinouModeIdKbn pSikinouModeIdKbn) {
        sikinouModeIdKbn = pSikinouModeIdKbn;
    }

    public C_SiinKbn getSiinKbn() {
        return siinkbn;
    }

    public void setSiinKbn(C_SiinKbn pSiinKbn) {
        siinkbn = pSiinKbn;
    }

    public C_SaisateiKbn getSaisateiKbn() {
        return saisateikbn;
    }

    public void setSaisateiKbn(C_SaisateiKbn pSaisateiKbn) {
        saisateikbn = pSaisateiKbn;
    }

    public String getUktMnmeigiBangou() {
        return uktmnmeigibangou;
    }

    public void setUktMnmeigiBangou(String pUktMnmeigiBangou) {
        uktmnmeigibangou = pUktMnmeigiBangou;
    }

    public String getKykMnmeigiBangou() {
        return kykmnmeigibangou;
    }

    public void setKykMnmeigiBango(String pKykMnmeigiBangou) {
        kykmnmeigibangou = pKykMnmeigiBangou;
    }

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String pBankCd) {
        bankCd = pBankCd;
    }

    public C_UmuKbn getKaiyakusjkkktyouseirirituUmKbn() {
        return kaiyakusjkkktyouseirirituUmKbn;
    }

    public C_UmuKbn setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn pKaiyakusjkkktyouseirirituUmKbn) {
        return kaiyakusjkkktyouseirirituUmKbn = pKaiyakusjkkktyouseirirituUmKbn;
    }

    public BizNumber getKaiyakusjkkktyouseiriritu() {
        return kaiyakusjkkktyouseiriritu;
    }

    public void setKaiyakusjkkktyouseiriritu(BizNumber pKaiyakusjkkktyouseiriritu) {
        kaiyakusjkkktyouseiriritu = pKaiyakusjkkktyouseiriritu;
    }

    public C_SeikyuusyaKbn getSeikyuusyaKbn() {
        return seikyuusyaKbn;
    }

    public void setSeikyuusyaKbn(C_SeikyuusyaKbn pSeikyuusyaKbn) {
        seikyuusyaKbn = pSeikyuusyaKbn;
    }

    public BizNumber getGaikaknsnKwsrate() {
        return gaikaknsnKwsrate;
    }

    public void setGaikaknsnKwsrate(BizNumber pGaikaknsnKwsrate) {
        this.gaikaknsnKwsrate = pGaikaknsnKwsrate;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        this.syoriYmd = pSyoriYmd;
    }

}
