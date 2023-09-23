package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.def.db.entity.BM_HutanpoBui;
import yuyu.def.db.entity.BM_Tuuka;
import yuyu.def.db.entity.IM_KhHituyouSyorui;
import yuyu.def.db.entity.IT_AnsyuCreditCard;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_CreditCard;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_TeikikinKouza;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_UketoriKouza;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KykUkt;

/**
 * 契約保全 契約保全共通 契約保全共通パラメータ
 */
public class KhozenCommonParam {

    private String sikibetuKey = null;

    private String kinouId = null;

    private String kinouNm = null;

    private IT_KykKihon batchKeiyakuKihon = null;

    private IT_BAK_KykKihon batchBakKykKihon = null;

    private IT_AnsyuKihon batchAnsyuKihon = null;

    private IT_BAK_AnsyuKihon batchBakAnsyuKihon = null;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    @Nullable
    private AS_Kinou kinou;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    public KhozenCommonParam() {
        super();
    }

    public String getFunctionId() {

        if (kinouId == null) {
            kinouId = kinou.getKinouId();
        }

        return kinouId;
    }

    public String getKinouNm() {

        if (kinouNm == null) {
            kinouNm = kinou.getKinouNm();
        }

        return kinouNm;
    }

    public String getCategoryId() {
        return kinou.getCategoryId();
    }

    public String getUserID() {
        return baseUserInfo.getUserId();
    }

    public String getUserNm() {
        return baseUserInfo.getUserNm();
    }

    public String getTmSosikiCd() {
        return baseUserInfo.getTmSosikiCd();
    }

    public String getTmSosikiNm() {
        return baseUserInfo.getTmSosikiNm();
    }

    public IT_KykKihon getKeiyakuKihon(String pSyoNo) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        if (kykKihon == null) {
            throw new CommonBizAppException("契約基本TBL  証券番号 = " + pSyoNo);
        }

        return kykKihon;
    }

    public IT_KykKihon getKeiyakuKihonInfo(String pSyoNo) {

        return hozenDomManager.getKykKihon(pSyoNo);

    }

    public IT_KykSya getKeiyakusya(String pSyoNo) {

        IT_KykSya kykSya = getKeiyakuKihon(pSyoNo).getKykSya();

        if (kykSya == null) {
            throw new CommonBizAppException("契約者TBL  証券番号 = " + pSyoNo);
        }

        return kykSya;
    }

    public IT_HhknSya getHihokensya(String pSyoNo) {

        IT_HhknSya hhknSya = getKeiyakuKihon(pSyoNo).getHhknSya();

        if (hhknSya == null) {
            throw new CommonBizAppException("被保険者TBL  証券番号 = " + pSyoNo);
        }

        return hhknSya;
    }

    public IT_KykUkt getNenkinUketorinin(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT);

        if (kykUktLst != null && kykUktLst.size() > 0) {
            return kykUktLst.get(0);
        }

        return null;
    }

    public IT_KykUkt getSibouHenkankinUketorinin(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBHENKANUKT);

        if (kykUktLst != null && kykUktLst.size() > 0) {
            return kykUktLst.get(0);
        }

        return null;
    }

    public List<IT_KykUkt> getSibouUketorinin(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        if (kykUktLst != null && kykUktLst.size() > 0) {
            SortIT_KykUkt sortItKykUkt = SWAKInjector.getInstance(SortIT_KykUkt.class);
            kykUktLst = sortItKykUkt.OrderIT_KykUktByPkAsc(kykUktLst);

            return kykUktLst;
        }

        return null;
    }

    public IT_KykUkt getKeizokuNenkinUketorinin(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KEIZKNKUKT);

        if (kykUktLst != null && kykUktLst.size() > 0) {
            return kykUktLst.get(0);
        }

        return null;
    }

    public IT_KykUkt getSiteiDairiSeikyuunin(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);

        if (kykUktLst != null && kykUktLst.size() > 0) {
            return kykUktLst.get(0);
        }

        return null;
    }

    public IT_KykUkt getTeikiSiharaikinUketorinin(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {

            return null;
        }

        List<IT_KykUkt> kykUkts = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.TKSHKUKT);

        if (kykUkts != null && kykUkts.size() > 0) {

            return kykUkts.get(0);
        }

        return null;
    }

    public List<IT_KykSyouhn> getKeiyakuSyouhin(String pSyoNo, C_SyutkKbn pSyutkkbn) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(pSyutkkbn);

        if (kykSyouhnLst != null && kykSyouhnLst.size() > 0) {

            return kykSyouhnLst;
        }

        return null;
    }

    public IT_SyouhnTokujou getSyouhinTokujyou(
        String pSyoNo, C_SyutkKbn pSyutkkbn, String pSyouhnCd, int pSyouhnSdno, int pKykSyouhnRenno) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        IT_SyouhnTokujou syouhnTokujou = kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
            pSyutkkbn, pSyouhnCd, pSyouhnSdno, pKykSyouhnRenno);

        if (syouhnTokujou != null) {
            return syouhnTokujou;
        }

        return null;
    }

    public BM_HutanpoBui getHutanpoBui(String pHtnpBuiCd) {

        BM_HutanpoBui rtCMHutanpoBui = bizDomManager.getHutanpoBui(pHtnpBuiCd);

        if (rtCMHutanpoBui != null) {
            return rtCMHutanpoBui;
        }

        return null;
    }

    public BM_Tuuka getTuuka(C_Tuukasyu pTuukaSyu) {

        BM_Tuuka tuuka = bizDomManager.getTuuka(pTuukaSyu);

        if (tuuka != null) {
            return tuuka;
        }

        return null;
    }

    public IT_KykSonotaTkyk getSonotaTokuyaku(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        if (kykSonotaTkyk != null) {
            return kykSonotaTkyk;
        }

        return null;
    }

    public IT_Kouza getKouza(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        IT_Kouza kouza = kykKihon.getKouza();

        if (kouza != null) {
            return kouza;
        }

        return null;
    }

    public BM_Ginkou getGinkou(String pBankcd, String pSitencd) {

        BM_Ginkou ginkou = bizDomManager.getGinkou(pBankcd, pSitencd);

        if (ginkou != null) {
            return ginkou;
        }

        return null;
    }

    public IT_CreditCard getCreditCard(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        IT_CreditCard creditCard = kykKihon.getCreditCard();

        if (creditCard != null) {
            return creditCard;
        }

        return null;
    }

    public List<IM_KhHituyouSyorui> getHituyouSyorui(KhozenCommonParamGetHituyouSyoruiUiBeanParam pUiBean) {

        String functionId = getFunctionId();
        String hanteiKbn1 = "";

        if (IKhozenCommonConstants.KINOUID_MEIGIHENKOU.equals(functionId)) {

            hanteiKbn1 = ((KhozenCommonParamKhMeigiHenkouUiBeanParam)pUiBean).getMeigihnkjiyuu().getValue();
        }
        else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(functionId)) {

            hanteiKbn1 = ((KhozenCommonParamKhKaiyakuUiBeanParam)pUiBean).getKaiyakujiyuu().getValue();
        }
        else if (IKhozenCommonConstants.KINOUID_KHYENDTHNKHRSHR.equals(functionId)) {
            hanteiKbn1 = ((KhozenCommonParamKhYendtHnkHrShrUiBeanParam)pUiBean).getKhhrshrjiyuu().getValue();
        }
        else if (IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(functionId)) {
            hanteiKbn1 = ((KhozenCommonParamKhHaraikataHenkouUiBeanParam)pUiBean).getNewhrkkeiro().getValue();
        }
        else {

            hanteiKbn1 = "0";
        }

        String hanteikbn2 = "0";

        String hanteikbn3 = "0";

        List<IM_KhHituyouSyorui> khHituyouSyoruiLst = hozenDomManager.
            getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(functionId,
                Integer.parseInt(hanteiKbn1), Integer.parseInt(hanteikbn2), Integer.parseInt(hanteikbn3));

        if (khHituyouSyoruiLst != null && khHituyouSyoruiLst.size() != 0) {
            return khHituyouSyoruiLst;
        }

        return null;
    }

    public IT_KhTtdkTyuui getKkTetudukiTyuui(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        if (khTtdkTyuui != null) {
            return khTtdkTyuui;
        }

        return null;
    }

    public IT_AnsyuKihon getAnsyuuKihon(String pSyoNo) {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);

        if (ansyuKihon == null) {
            throw new CommonBizAppException("案内収納基本  証券番号 = " + pSyoNo);
        }

        return ansyuKihon;
    }

    public IT_AnsyuKihon getAnsyuuKihonInfo(String pSyoNo) {

        return hozenDomManager.getAnsyuKihon(pSyoNo);

    }

    public IT_Tokusin getTokusin(String pSyoNo) {

        IT_AnsyuKihon ansyuKihon = getAnsyuuKihonInfo(pSyoNo);

        if (ansyuKihon == null) {
            return null;
        }

        IT_Tokusin tokuSin = ansyuKihon.getTokusin();

        if (tokuSin == null) {
            return null;
        }

        return tokuSin;
    }

    public String getSikibetuKey(String pSyoNo) {

        if (this.sikibetuKey == null) {
            sikibetuKey = SaibanBiz.getHenkouSikibetukey(pSyoNo);
        }

        return this.sikibetuKey;
    }

    public IT_AnsyuCreditCard getAnsyuCreditcard(String pSyoNo) {

        IT_AnsyuKihon ansyuKihon = getAnsyuuKihonInfo(pSyoNo);

        if (ansyuKihon == null) {
            return null;
        }

        IT_AnsyuCreditCard ansyuCreditCard = ansyuKihon.getAnsyuCreditCard();

        if (ansyuCreditCard == null) {
            return null;
        }

        return ansyuCreditCard;
    }

    public List<IT_FatcaInfo> getFatcaInfo(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        List<IT_FatcaInfo> fatcaInfoLst = kykKihon.getFatcaInfos();

        if (fatcaInfoLst != null && fatcaInfoLst.size() > 0) {
            return fatcaInfoLst;
        }

        return null;
    }

    public void setSikibetuKey(String pSikibetuKey) {

        this.sikibetuKey = pSikibetuKey;
    }

    public void setFunctionId(String pKinouId) {

        this.kinouId = pKinouId;
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekiSk(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

        if (nyknJissekiRirekiLst == null || nyknJissekiRirekiLst.size() == 0) {
            return null;
        }

        return nyknJissekiRirekiLst;
    }

    public IT_TeikikinKouza getTeikikinKouza(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if (kykKihon == null) {
            return null;
        }

        IT_TeikikinKouza teikikinKouza = kykKihon.getTeikikinKouza();

        if (teikikinKouza != null) {
            return teikikinKouza;
        }

        return null;
    }

    public IT_UketoriKouza getTeikiShrUketoriKouza(String pSyoNo) {

        IT_KykUkt kykUkt = getTeikiSiharaikinUketorinin(pSyoNo);

        if (kykUkt == null) {

            return null;
        }

        IT_UketoriKouza uketoriKouza = kykUkt.getUketoriKouza();

        if (uketoriKouza != null) {
            return uketoriKouza;
        }

        return null;
    }

    public IT_DattaiUktk getDattaiUktk(String pSyoNo) {

        IT_AnsyuKihon ansyuKihon = getAnsyuuKihonInfo(pSyoNo);

        if (ansyuKihon == null) {
            return null;
        }

        IT_DattaiUktk dattaiUktk = ansyuKihon.getDattaiUktk();
        if (dattaiUktk == null) {
            return null;
        }

        return dattaiUktk;
    }

    public List<IT_Kariukekin> getKariukekinsBySyono(String pSyoNo) {

        List<IT_Kariukekin> kariukekinList = hozenDomManager.getKariukekinsBySyono(pSyoNo);

        return kariukekinList;
    }

    public IT_KykKihon getBatchKeiyakuKihon() {
        return batchKeiyakuKihon;
    }

    public void setBatchKeiyakuKihon(IT_KykKihon pBatchKeiyakuKihon) {
        batchKeiyakuKihon = pBatchKeiyakuKihon;
    }

    public IT_BAK_KykKihon getBatchBakKykKihon() {
        return batchBakKykKihon;
    }

    public void setBatchBakKykKihon(IT_BAK_KykKihon pBatchBakKykKihon) {
        batchBakKykKihon = pBatchBakKykKihon;
    }

    public IT_AnsyuKihon getBatchAnsyuKihon() {
        return batchAnsyuKihon;
    }

    public void setBatchAnsyuKihon(IT_AnsyuKihon pBatchAnsyuKihon) {
        batchAnsyuKihon = pBatchAnsyuKihon;
    }

    public IT_BAK_AnsyuKihon getBatchBakAnsyuKihon() {
        return batchBakAnsyuKihon;
    }

    public void setBatchBakAnsyuKihon(IT_BAK_AnsyuKihon pBatchBakAnsyuKihon) {
        batchBakAnsyuKihon = pBatchBakAnsyuKihon;
    }

    public IT_KykUkt getKyksyaDairinin(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if(kykKihon == null){

            return null;
        }

        List<IT_KykUkt> kykUktList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN);

        if(kykUktList != null && kykUktList.size() > 0){

            return kykUktList.get(0);
        }

        return null;
    }

    public List<IT_TrkKzk> getTrkKzk(String pSyoNo) {

        IT_KykKihon kykKihon = getKeiyakuKihonInfo(pSyoNo);

        if(kykKihon == null){

            return null;
        }

        List<IT_TrkKzk> trkKzkList = kykKihon.getTrkKzks();

        if(trkKzkList != null && trkKzkList.size() > 0){

            return trkKzkList;
        }

        return null;
    }
}
