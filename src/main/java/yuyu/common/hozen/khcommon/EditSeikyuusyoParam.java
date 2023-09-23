package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KykhnkKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_KyktrksKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NstkhKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_TargetTkHenkouKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UriagetyuusiKbn;

/**
 * 契約保全 契約保全共通 請求書作成用パラメータ
 */
public class EditSeikyuusyoParam {

    private C_KyksyaSibouUmuKbn kyksyaSibouUmuKbn = C_KyksyaSibouUmuKbn.BLNK;

    private C_UmuKbn shrUmu                       = C_UmuKbn.NONE;

    private BizDate hhknseiYMD                    = null;

    private C_UmuKbn hhknseiYmdHenkouUmu          = C_UmuKbn.NONE;

    private C_Hhknsei hhknSei                     = C_Hhknsei.BLNK;

    private C_UmuKbn hhknseiHenkouUmu             = C_UmuKbn.NONE;

    private BizCurrency hrKp                      = BizCurrency.valueOf(0);

    private C_Hrkkaisuu henkouGohrKkaisuu         = C_Hrkkaisuu.BLNK;

    private C_KykhnkKbn[] kykhnkKbn               = null;

    private String[] syouhnNms                    = null;

    private C_KihonssyuruiKbn[] kihonSsyuruiKbns  = null;

    private BizCurrency[] kihonSs                 = null;

    private BizCurrency kaiyakuHrkin              = BizCurrency.valueOf(0);

    private C_UmuKbn syukykGengakuUmu             = C_UmuKbn.NONE;

    private BizCurrency ganNyukyhNg               = BizCurrency.valueOf(0);

    private C_KyktrksKbn kyktrksKbn               = null;

    private String ganMukoutstkSyouhnNm1          = "";

    private String ganMukoutstkSyouhnNm2          = "";

    private C_UmuKbn sanDaisiphsytkumukbn         = C_UmuKbn.NONE;

    private C_UmuKbn sanDaisippmentkumukbn        = C_UmuKbn.NONE;

    private C_UriagetyuusiKbn uriagetyuusiKbn     = C_UriagetyuusiKbn.HUYOU;

    private C_Hrkkeiro henkougoHrkkeiro           = C_Hrkkeiro.BLNK;

    private C_TargetTkHenkouKbn targetTkHenkouKbn = C_TargetTkHenkouKbn.BLNK;

    private BizNumber afterTargetTkmokuhyouTi = BizNumber.valueOf(0);

    private C_GengkhouKbn gengkhouKbn = C_GengkhouKbn.BLNK;

    private BizCurrency afterKihonS = BizCurrency.valueOf(0);

    private BizCurrency afterP = BizCurrency.valueOf(0);

    private C_NstkhKbn nstkhKbn = C_NstkhKbn.BLNK;

    private C_Nstknsyu afterTokuyakuNenkinsyuKbn = C_Nstknsyu.BLNK;

    private int afterNkshrtKyknkKkn = 0;

    private C_Kaiyakujiyuu kaiyakuJiyuu = C_Kaiyakujiyuu.BLNK;

    private C_Meigihnkjiyuu meigiHnkJiyuu = C_Meigihnkjiyuu.BLNK;

    private C_UmuKbn henkankinUmuKbn = C_UmuKbn.NONE;

    private C_Tuukasyu rsTuukaSyu = C_Tuukasyu.BLNK;

    private C_JyudkaigomaebaraiTkykhnkKbn jyudkaigomaebaraiTkykhnkKbn = C_JyudkaigomaebaraiTkykhnkKbn.BLNK;

    private C_UmuKbn kihonshenkouumu = C_UmuKbn.NONE;

    private C_Tmttknitenkbn   tmttknitenkbn   = C_Tmttknitenkbn.BLNK;

    private BizDate           tmttknitenymd   = null;

    private C_Khhrshrjiyuu   khhrshrjiyuu     = C_Khhrshrjiyuu.BLNK;

    private C_Khskssakuseijiyuu khskssakuseijiyuu  = C_Khskssakuseijiyuu.BLNK;

    private BizCurrency henkougokjnkngk = BizCurrency.valueOf(0);

    private C_UmuKbn yuuyokknTyoukaUmu = C_UmuKbn.NONE;

    private C_MousideninKbn mousideninKbn = C_MousideninKbn.BLNK;

    private C_KahiKbn trkkzksakujyokahi1 = C_KahiKbn.HUKA;

    private C_KahiKbn trkkzksakujyokahi2 = C_KahiKbn.HUKA;

    private BizCurrency henkougoteikisiharaikingk = BizCurrency.valueOf(0);

    public EditSeikyuusyoParam() {
        super();
    }

    public C_KyksyaSibouUmuKbn getKyksbumu() {
        return kyksyaSibouUmuKbn;
    }

    public void setKyksbumu(C_KyksyaSibouUmuKbn pKyksyaSibouUmuKbn) {
        kyksyaSibouUmuKbn = pKyksyaSibouUmuKbn;
    }

    public C_UmuKbn getShrumu() {
        return shrUmu;
    }

    public void setShrumu(C_UmuKbn pShrumu) {
        shrUmu = pShrumu;
    }

    public BizDate getHhknseiymd() {
        return hhknseiYMD;
    }

    public void setHhknseiymd(BizDate pHhknseiYMD) {
        hhknseiYMD = pHhknseiYMD;
    }

    public C_UmuKbn getHhknseiymdhenkouumu() {
        return hhknseiYmdHenkouUmu;
    }

    public void setHhknseiymdhenkouumu(C_UmuKbn pHhknseiymdhenkouumu) {
        hhknseiYmdHenkouUmu = pHhknseiymdhenkouumu;
    }

    public C_Hhknsei getHhknsei() {
        return hhknSei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknSei = pHhknsei;
    }

    public C_UmuKbn getHhknseihenkouumu() {
        return hhknseiHenkouUmu;
    }

    public void setHhknseihenkouumu(C_UmuKbn pHhknseihenkouumu) {
        hhknseiHenkouUmu = pHhknseihenkouumu;
    }

    public BizCurrency getHrkp() {
        return hrKp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrKp = pHrkp;
    }

    public C_Hrkkaisuu getHenkougohrkkaisuu(){
        return henkouGohrKkaisuu;
    }

    public void setHenkougohrkkaisuu(C_Hrkkaisuu hrkkaisuu){
        henkouGohrKkaisuu = hrkkaisuu;
    }

    public C_KykhnkKbn[] getKykhnkkbn() {
        return kykhnkKbn;
    }

    public void setKykhnkkbn(C_KykhnkKbn[] pKykhnkkbns) {
        kykhnkKbn = pKykhnkkbns;
    }

    public String[] getSyouhnnm() {
        return syouhnNms;
    }

    public void setSyouhnnm(String[] pSyouhnnms) {
        syouhnNms = pSyouhnnms;
    }

    public C_KihonssyuruiKbn[] getKihonssyuruikbn() {
        return kihonSsyuruiKbns;
    }

    public void setKihonssyuruikbn(C_KihonssyuruiKbn[] pKihonssyuruikbns) {
        kihonSsyuruiKbns = pKihonssyuruikbns;
    }

    public BizCurrency[] getKihonS() {
        return kihonSs;
    }

    public void setKihonS(BizCurrency[] pKihonSs) {
        kihonSs = pKihonSs;
    }

    public BizCurrency getKaiyakuhrkin() {
        return kaiyakuHrkin;
    }

    public void setKaiyakuhrkin(BizCurrency pKaiyakuhrkin) {
        kaiyakuHrkin = pKaiyakuhrkin;
    }

    public C_UmuKbn getSyukykgengakuumu(){
        return syukykGengakuUmu;
    }

    public void setSyukykgengakuumu(C_UmuKbn pSyukykgengakuumu){
        syukykGengakuUmu = pSyukykgengakuumu;
    }

    public BizCurrency getGannyukyhng(){
        return ganNyukyhNg;
    }

    public void setGannyukyhng(BizCurrency pGannyukyhng){
        ganNyukyhNg = pGannyukyhng;
    }

    public C_KyktrksKbn getKyktrkskbn() {
        return kyktrksKbn;
    }

    public void setKyktrkskbn(C_KyktrksKbn pKyktrkskbn) {
        kyktrksKbn = pKyktrkskbn;
    }

    public String getGanmukoutstksyouhnnm1() {
        return ganMukoutstkSyouhnNm1;
    }

    public void setGanmukoutstksyouhnnm1(String pGanmukoutstksyouhnnm1) {
        ganMukoutstkSyouhnNm1 = pGanmukoutstksyouhnnm1;
    }

    public String getGanmukoutstksyouhnnm2() {
        return ganMukoutstkSyouhnNm2;
    }

    public void setGanmukoutstksyouhnnm2(String pGanmukoutstksyouhnnm2) {
        ganMukoutstkSyouhnNm2 = pGanmukoutstksyouhnnm2;
    }

    public C_UriagetyuusiKbn getUriagetyuusikbn() {
        return uriagetyuusiKbn;
    }

    public void setUriagetyuusikbn(C_UriagetyuusiKbn pUriagetyuusikbn) {
        uriagetyuusiKbn = pUriagetyuusikbn;
    }

    public C_Hrkkeiro getHenkougohrkkeiro(){
        return henkougoHrkkeiro;
    }

    public void setHenkougohrkkeiro(C_Hrkkeiro pHenkougohrkkeiro){
        henkougoHrkkeiro = pHenkougohrkkeiro;
    }

    public C_UmuKbn get3daisiphsytkumukbn() {
        return sanDaisiphsytkumukbn;
    }

    public void set3daisiphsytkumukbn(C_UmuKbn pSanDaisiphsytkumukbn) {
        sanDaisiphsytkumukbn = pSanDaisiphsytkumukbn;
    }

    public C_UmuKbn get3daisippmentkumukbn() {
        return sanDaisippmentkumukbn;
    }

    public void set3daisippmentkumukbn(C_UmuKbn pSanDaisippmentkumukbn) {
        sanDaisippmentkumukbn = pSanDaisippmentkumukbn;
    }

    public C_TargetTkHenkouKbn getTargetTkHenkouKbn() {
        return targetTkHenkouKbn;
    }

    public void setTargetTkHenkouKbn(C_TargetTkHenkouKbn pTargetTkHenkouKbn) {
        targetTkHenkouKbn = pTargetTkHenkouKbn;
    }

    public BizNumber getBfrTargettkmokuhyouti() {
        return afterTargetTkmokuhyouTi;
    }

    public void setBfrTargettkmokuhyouti(BizNumber pAfterTargetTkmokuhyouTi) {
        afterTargetTkmokuhyouTi = pAfterTargetTkmokuhyouTi;
    }

    public C_GengkhouKbn getGengkhouKbn() {
        return gengkhouKbn;
    }

    public void setGengkhouKbn(C_GengkhouKbn pGengkhouKbn) {
        gengkhouKbn = pGengkhouKbn;
    }

    public BizCurrency getBfrKihonS() {
        return afterKihonS;
    }

    public void setBfrKihonS(BizCurrency pAfterKihonS) {
        afterKihonS = pAfterKihonS;
    }

    public BizCurrency getBfrP() {
        return afterP;
    }

    public void setBfrP(BizCurrency pAfterP) {
        afterP = pAfterP;
    }

    public C_NstkhKbn getNkshrtkykhnkkbn() {
        return nstkhKbn;
    }

    public void setNkshrtkykhnkkbn(C_NstkhKbn pNstkhKbn) {
        nstkhKbn = pNstkhKbn;
    }

    public C_Nstknsyu getBfrTokuyakuNenkinsyuKbn() {
        return afterTokuyakuNenkinsyuKbn;
    }

    public void setBfrTokuyakuNenkinsyuKbn(C_Nstknsyu pAfterTokuyakuNenkinsyuKbn) {
        afterTokuyakuNenkinsyuKbn = pAfterTokuyakuNenkinsyuKbn;
    }

    public int getBfrNkshrtkyknksyukkn() {
        return afterNkshrtKyknkKkn;
    }

    public void setBfrNkshrtkyknksyukkn(int pAfterNkshrtKyknkKkn) {
        afterNkshrtKyknkKkn = pAfterNkshrtKyknkKkn;
    }

    public C_Kaiyakujiyuu getKaiyakujiyuu() {
        return kaiyakuJiyuu;
    }

    public void setKaiyakujiyuu(C_Kaiyakujiyuu pKaiyakuJiyuu) {
        kaiyakuJiyuu = pKaiyakuJiyuu;
    }

    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return meigiHnkJiyuu;
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu pMeigiHnkJiyuu) {
        meigiHnkJiyuu = pMeigiHnkJiyuu;
    }

    public C_UmuKbn getHenkankumukbn() {
        return henkankinUmuKbn;
    }

    public void setHenkankumukbn(C_UmuKbn pHenkankinUmuKbn) {
        henkankinUmuKbn = pHenkankinUmuKbn;
    }

    public C_Tuukasyu getRstuukasyu() {
        return rsTuukaSyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRsTuukaSyu) {
        rsTuukaSyu = pRsTuukaSyu;
    }

    public C_JyudkaigomaebaraiTkykhnkKbn getJyudkaigomaebaraiTkykhnkKbn() {
        return jyudkaigomaebaraiTkykhnkKbn;
    }

    public void setJyudkaigomaebaraiTkykhnkKbn(C_JyudkaigomaebaraiTkykhnkKbn pJyudkaigomaebaraiTkykhnkKbn) {
        jyudkaigomaebaraiTkykhnkKbn  = pJyudkaigomaebaraiTkykhnkKbn;
    }

    public C_UmuKbn getKihonshenkouumu() {
        return kihonshenkouumu;
    }

    public void setKihonshenkouumu(C_UmuKbn pKihonshenkouumu) {
        kihonshenkouumu  = pKihonshenkouumu;
    }

    public C_Tmttknitenkbn getTmttknitenkbn() {
        return tmttknitenkbn;
    }

    public void setTmttknitenkbn(C_Tmttknitenkbn pTmttknitenkbn) {
        tmttknitenkbn = pTmttknitenkbn;
    }

    public BizDate getTmttknitenymd() {
        return tmttknitenymd;
    }

    public void setTmttknitenymd(BizDate pTmttknitenymd) {
        tmttknitenymd = pTmttknitenymd;
    }

    public C_Khhrshrjiyuu getKhhrshrjiyuu() {
        return khhrshrjiyuu;
    }

    public void setKhhrshrjiyuu(C_Khhrshrjiyuu pKhhrshrjiyuu) {
        khhrshrjiyuu = pKhhrshrjiyuu;
    }

    public C_Khskssakuseijiyuu getKhskssakuseijiyuu() {
        return khskssakuseijiyuu;
    }

    public void setKhskssakuseijiyuu(C_Khskssakuseijiyuu pKhskssakuseijiyuu) {
        khskssakuseijiyuu = pKhskssakuseijiyuu;
    }

    public BizCurrency getHenkougokjnkngk(){
        return henkougokjnkngk;
    }

    public void setHenkougokjnkngk(BizCurrency pHenkougokjnkngk){
        henkougokjnkngk = pHenkougokjnkngk;
    }

    public C_UmuKbn getYuuyokkntyoukaumu() {
        return yuuyokknTyoukaUmu;
    }

    public void setYuuyokkntyoukaumu(C_UmuKbn pYuuyokknTyoukaUmu) {
        yuuyokknTyoukaUmu  = pYuuyokknTyoukaUmu;
    }

    public C_MousideninKbn getMousideninkbn() {
        return mousideninKbn;
    }

    public void setMousideninkbn(C_MousideninKbn pMousideninkbn) {
        mousideninKbn  = pMousideninkbn;
    }

    public C_KahiKbn getTrkkzksakujyokahi1() {
        return trkkzksakujyokahi1;
    }

    public void setTrkkzksakujyokahi1(C_KahiKbn pTrkkzksakujyokahi1) {
        this.trkkzksakujyokahi1 = pTrkkzksakujyokahi1;
    }

    public C_KahiKbn getTrkkzksakujyokahi2() {
        return trkkzksakujyokahi2;
    }

    public void setTrkkzksakujyokahi2(C_KahiKbn pTrkkzksakujyokahi2) {
        this.trkkzksakujyokahi2 = pTrkkzksakujyokahi2;
    }

    public BizCurrency getHenkougoteikisiharaikingk() {
        return henkougoteikisiharaikingk;
    }

    public void setHenkougoteikisiharaikingk(BizCurrency pHenkougoteikisiharaikingk) {
        this.henkougoteikisiharaikingk = pHenkougoteikisiharaikingk;
    }
}
