package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryComparatorWorkListHyoujijun;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_AnnaijyoutaiKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_HaraikatahnkuktknaiyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IM_Annaijyoutaikahi;
import yuyu.def.db.entity.IM_KhHenkouUktksyorikahi;
import yuyu.def.db.entity.IM_Kykjyoutaikahi;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.entity.IM_Syoumetukahi;
import yuyu.def.db.entity.IM_YykIdouUktksyorikahi;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouUktkBean;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 契約保全 契約保全共通 有効状態チェック
 */
public class CheckYuukouJyoutai {

    private String syono = null;

    private String errorMessage = null;

    private ArrayList<String> warningMessageIDList = new ArrayList<>();

    private ArrayList<String> warningMessageList = new ArrayList<>();

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public CheckYuukouJyoutai() {
        super();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ArrayList<String> getWarningMessageIDList() {
        return warningMessageIDList;
    }

    public ArrayList<String> getWarningMessageList() {
        return warningMessageList;
    }

    public C_YuukoujyotaichkKbn exec(KhozenCommonParam pKhCp, CheckYuukouJyoutaiExecUiBeanParam pUiBean) {

        syono = pUiBean.getSyono();

        List<IT_KykSyouhn> kykSyohnLst = pKhCp.getKeiyakuSyouhin(syono, C_SyutkKbn.SYU);
        if (kykSyohnLst == null || kykSyohnLst.size() != 1) {
            throw new CommonBizAppException("契約商品TBL 証券番号=" + syono);
        }

        C_Kykjyoutai kykJyotai = kykSyohnLst.get(0).getKykjyoutai();
        String kinouId = pKhCp.getFunctionId();

        if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyohnLst.get(0).getYuukousyoumetukbn())) {
            return procYuukou(pKhCp, pUiBean, kinouId, kykJyotai);
        }

        return procSyoumetu(pKhCp, pUiBean, kinouId, kykSyohnLst.get(0));
    }

    private C_YuukoujyotaichkKbn procYuukou(KhozenCommonParam pKcp, CheckYuukouJyoutaiExecUiBeanParam pUiBean,
        String pKinouId, C_Kykjyoutai pKykjyoutai) {

        ArrayList<String> msgIdLst = new ArrayList<>();
        ArrayList<String> msgLst = new ArrayList<>();
        boolean warningFlag = false;

        IM_Kykjyoutaikahi kykjyoutaikahi = hozenDomManager.getKykjyoutaikahi(pKinouId, pKykjyoutai);
        if (kykjyoutaikahi != null) {

            C_YuukoujyotaikahiKbn yuukoujyotaikahiKbn =  kykjyoutaikahi.getYuukoujyotaikahikbn();

            String kykjyoutai = pKykjyoutai.getContent();

            if (C_YuukoujyotaikahiKbn.HUKA.eq(yuukoujyotaikahiKbn)) {
                errorMessage = kykjyoutai;
                return C_YuukoujyotaichkKbn.HUKA;
            }

            if (C_YuukoujyotaikahiKbn.SYORITYUUIARI.eq(yuukoujyotaikahiKbn)) {
                warningFlag = true;
                msgIdLst.add(BizUtil.getGeneralMessageId(MessageId.KIC0001));
                msgLst.add(MessageUtil.getMessage(MessageId.KIC0001, kykjyoutai));
            }
        }

        return procAnnaiJyotai(pUiBean, pKinouId, warningFlag, msgIdLst, msgLst);
    }

    private C_YuukoujyotaichkKbn procSyoumetu(KhozenCommonParam pKcp, CheckYuukouJyoutaiExecUiBeanParam pUiBean,
        String pKinouId, IT_KykSyouhn pKykSyouhn) {

        C_Syoumetujiyuu syoumetujiyuu = pKykSyouhn.getSyoumetujiyuu();
        IM_Syoumetukahi syoumetukahi = hozenDomManager.getSyoumetukahi(pKinouId, syoumetujiyuu);

        ArrayList<String> msgIdLst = new ArrayList<>();
        ArrayList<String> msgLst   = new ArrayList<>();
        boolean warningFlag = false;

        if (syoumetukahi != null) {

            C_YuukoujyotaikahiKbn yuukoujyotaikahiKbn = syoumetukahi.getYuukoujyotaikahikbn();
            String syoumetuJiyuu = syoumetujiyuu.getContent();
            String syoumetuYmd = DateFormatUtil.viewYMD(pKykSyouhn.getSyoumetuymd());
            String msg = syoumetuJiyuu + "（消滅日：" + syoumetuYmd + "）";

            if (C_YuukoujyotaikahiKbn.HUKA.eq(yuukoujyotaikahiKbn)) {
                errorMessage = msg;
                return C_YuukoujyotaichkKbn.HUKA;
            }

            if (C_YuukoujyotaikahiKbn.SYORITYUUIARI.eq(yuukoujyotaikahiKbn)) {
                warningFlag = true;
                msgIdLst.add(BizUtil.getGeneralMessageId(MessageId.KIC0001));
                msgLst.add(MessageUtil.getMessage(MessageId.KIC0001, msg));
            }
        }

        return procAnnaiJyotai(pUiBean, pKinouId, warningFlag, msgIdLst, msgLst);
    }

    private C_YuukoujyotaichkKbn procAnnaiJyotai(CheckYuukouJyoutaiExecUiBeanParam pUiBean,
        String pKinouId, Boolean pWarningFlag, ArrayList<String> pMsgIdLst, ArrayList<String> pMsgLst) {

        C_AnnaijyoutaiKbn annaijyoutaiKbn = C_AnnaijyoutaiKbn.BLNK;
        boolean warningFlag = pWarningFlag;
        IT_DattaiUktk dattaiUktk = null;

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);
        if (ansyuKihon != null) {
            dattaiUktk = hozenDomManager.getAnsyuKihon(syono).getDattaiUktk();
        }

        if (dattaiUktk != null) {

            if (pKinouId.equals(IKhozenCommonConstants.KINOUID_AUTHORISEL)
                || pKinouId.equals(IKhozenCommonConstants.KINOUID_YUUKOUSEL)) {

                List<IT_YykIdouUktk> yykIdouUktkList =
                    hozenDomManager.getKykKihon(syono).getYykIdouUktksByYykidousyorikbn(C_YykidousyoriKbn.UKE);

                if (yykIdouUktkList.size() == 0) {
                    annaijyoutaiKbn = C_AnnaijyoutaiKbn.DATTAI;
                }
            }
            else {
                annaijyoutaiKbn = C_AnnaijyoutaiKbn.DATTAI;
            }

            if (C_AnnaijyoutaiKbn.DATTAI.eq(annaijyoutaiKbn) ) {
                IM_Annaijyoutaikahi annaijyoutaikahi = hozenDomManager.getAnnaijyoutaikahi(pKinouId, C_AnnaijyoutaiKbn.DATTAI);

                if (annaijyoutaikahi != null) {
                    C_YuukoujyotaikahiKbn yuukoujyotaikahiKbn = annaijyoutaikahi.getYuukoujyotaikahikbn();
                    String kykjyoutai = C_AnnaijyoutaiKbn.DATTAI.getContent();

                    if (C_YuukoujyotaikahiKbn.HUKA.eq(yuukoujyotaikahiKbn)) {
                        errorMessage = kykjyoutai;
                        return C_YuukoujyotaichkKbn.HUKA;
                    }

                    if (C_YuukoujyotaikahiKbn.SYORITYUUIARI.eq(yuukoujyotaikahiKbn)) {
                        warningFlag = true;
                        pMsgIdLst.add(BizUtil.getGeneralMessageId(MessageId.KIC0001));
                        pMsgLst.add(MessageUtil.getMessage(MessageId.KIC0001, kykjyoutai));
                    }
                }
            }
        }

        return procKhHenkouUktk(pUiBean, pKinouId, warningFlag, pMsgIdLst, pMsgLst);
    }

    private C_YuukoujyotaichkKbn procSyoriJyotai(CheckYuukouJyoutaiExecUiBeanParam pUiBean, String pKinouId,
        Boolean pWarningFlag, ArrayList<String> pMsgIdlist, ArrayList<String> pMsglist) {

        boolean warningFlag = pWarningFlag;

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummaryComparatorWorkListHyoujijun bzGetProcessSummaryComparatorWorkListHyoujijun =
            SWAKInjector.getInstance(BzGetProcessSummaryComparatorWorkListHyoujijun.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        List<JT_SkKihon> skKihonList =
            siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(syono,C_SeikyuuSyubetu.SBKRUKTK,C_UmuKbn.NONE);

        if (skKihonList.size() != 0){

            skKihonList = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetu(syono, C_SeikyuuSyubetu.SB);

            if(skKihonList.size() == 0){

                if (pKinouId.equals(IKhozenCommonConstants.KINOUID_KAIYAKU) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_GENGAKU) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KAIGOMAEBARAITKHENKOU) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHMKHGKHENKOU) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU)||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHBATCHMKHGKHENKOU)||
                    pKinouId.equals(C_DsKinouidKbn.DSKAIYAKUUKETUKE.getValue()) ||
                    pKinouId.equals(C_DsKinouidKbn.DSTUMITATEKINITENUKETUKE.getValue()) ||
                    pKinouId.equals(C_DsKinouidKbn.MKHGKHENKOUUKETUKE.getValue()) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHTMTTKINITEN) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNKUKTK) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHYENDTHNKUKTKNINI) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNKSEL) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHSINNINTOUHYOUSKS) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_DSHR) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN)||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KOUJYOSYOUMEISKS)||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_ZENNOUJYUUTOUMANRYOU)||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KZHURIANNAISEL)||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KZHURIKAISIANNAISKS)||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KIJITUTOURAIANNAISKS)||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_DATTAI)||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_MINYUU)||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_IKKATUANNAISAIKAI) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHSAIKOKUTUUTISKS) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHCREDITMISYUUINFOSEL) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHURIAGESEIKYUUSEL) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_RINJIURIAGESKUKTK) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KAWASERATETUUTIDATASKS) ||
                    pKinouId.equals(IKhozenCommonConstants.KINOUID_KHDIRECTMAILDATASEL)
                    ) {

                    errorMessage = "死亡仮受付中の";

                    return C_YuukoujyotaichkKbn.HUKA;
                }
                else {
                    warningFlag = true;
                    pMsgIdlist.add(BizUtil.getGeneralMessageId(MessageId.KIC0001));
                    pMsglist.add(MessageUtil.getMessage(MessageId.KIC0001, "死亡仮受付中の"));
                }
            }
        }
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setSyoNo(syono);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(bzGetProcessSummaryComparatorWorkListHyoujijun);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        for (BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean : bzGetProcessSummaryOutBeanLst) {

            String jimuTetudukiCd = bzGetProcessSummaryOutBean.getJimuTetuzukiCd();
            String jimuTetudukiNm = bzGetProcessSummaryOutBean.getJimuTetuzukiNm();
            String nowNodoId = bzGetProcessSummaryOutBean.getNowNodoId();
            String nowNodoNm = bzGetProcessSummaryOutBean.getNowNodoNm();

            IM_Syorijtkahi syorijtkahi = hozenDomManager.getSyorijtkahi(pKinouId, jimuTetudukiCd, nowNodoId);

            if (syorijtkahi != null ) {

                C_YuukoujyotaikahiKbn syoriKahiKbn = syorijtkahi.getYuukoujyotaikahikbn();
                String msg = null;

                if (!IKhozenCommonConstants.NODEID_SEIKYUUSYOSAKUSEI.equals(nowNodoId) &&
                    !IKhozenCommonConstants.NODEID_SYORUITOUTYAKU.equals(nowNodoId)) {

                    msg = jimuTetudukiNm + "　" + "手続中";
                }
                else {

                    msg = jimuTetudukiNm + "　" + nowNodoNm;
                }

                if (C_YuukoujyotaikahiKbn.HUKA.eq(syoriKahiKbn)) {
                    errorMessage = msg;
                    return C_YuukoujyotaichkKbn.HUKA;
                }
                if (C_YuukoujyotaikahiKbn.SYORITYUUIARI.eq(syoriKahiKbn)) {
                    warningFlag = true;
                    pMsgIdlist.add(BizUtil.getGeneralMessageId(MessageId.KIC0001));
                    pMsglist.add(MessageUtil.getMessage(MessageId.KIC0001, msg));
                }
            }
        }

        return procYykidou(pUiBean, pKinouId, warningFlag, pMsgIdlist, pMsglist);
    }

    private C_YuukoujyotaichkKbn procYykidou(CheckYuukouJyoutaiExecUiBeanParam pUiBean, String pKinouId,
        Boolean pWarningFlag, ArrayList<String> pMsgIdLst, ArrayList<String> pMsgLst) {

        String syoNo = pUiBean.getSyono();
        boolean warningFlag = pWarningFlag;

        List<IT_YykIdouUktk> yykIdouUktkLst = new ArrayList<>();
        List<IT_YykIdouNaiyoHrhnk> yykIdouNaiyoHrhnkLst = new ArrayList<>();
        List<AS_Kinou> kinouLst = new ArrayList<>();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

        if (kykKihon != null) {

            List<IT_YykIdouUktk> yykIdouUktkLstTemp = kykKihon.getYykIdouUktksByYykidousyorikbn(C_YykidousyoriKbn.UKE);

            for (IT_YykIdouUktk yykIdouUktk : yykIdouUktkLstTemp) {
                IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk =
                    kykKihon.getYykIdouNaiyoHrhnkByHenkousikibetukey(yykIdouUktk.getHenkousikibetukey());

                AS_Kinou kinouById = baseDomManager.getKinou(yykIdouUktk.getKinouId());

                if (yykIdouNaiyoHrhnk != null && kinouById != null) {

                    yykIdouNaiyoHrhnkLst.add(yykIdouNaiyoHrhnk);
                    kinouLst.add(kinouById);
                    yykIdouUktkLst.add(yykIdouUktk);
                }
            }
        }

        for (int index = 0; index < yykIdouUktkLst.size(); index++) {

            String yykKinouId = yykIdouUktkLst.get(index).getKinouId();

            IM_YykIdouUktksyorikahi yykIdouSyorikahi =
                hozenDomManager.getYykIdouUktksyorikahi(pKinouId, yykKinouId);

            if (yykIdouSyorikahi != null) {

                C_YuukoujyotaikahiKbn yuukoukahiKbn = yykIdouSyorikahi.getYuukoujyotaikahikbn();

                if (C_YuukoujyotaikahiKbn.HUKA.eq(yuukoukahiKbn)) {
                    errorMessage  = "予約異動受付中";
                    return C_YuukoujyotaichkKbn.HUKA;
                }
                else if (C_YuukoujyotaikahiKbn.SYORITYUUIARI.eq(yuukoukahiKbn)) {

                    warningFlag = true;

                    C_HaraikatahnkuktknaiyouKbn hrkHnkNaiyouKbn =
                        yykIdouNaiyoHrhnkLst.get(index).getHaraikatahnkuktknaiyoukbn();
                    String hnkNaiyou = hrkHnkNaiyouKbn.getContent();

                    String messageId = "";

                    if (pKinouId.equals(IKhozenCommonConstants.KINOUID_KEIYAKUSYOUKAI)) {
                        messageId = MessageId.WIC0033;
                    }
                    else if (pKinouId.equals(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU)) {
                        messageId = MessageId.WIC0031;
                    }
                    else {
                        messageId = MessageId.WIC0032;
                    }

                    String kinouNm = kinouLst.get(index).getKinouNm();
                    BizDate kouryokuHsYmd = yykIdouNaiyoHrhnkLst.get(index).getKouryokuhasseiymd();

                    String editKouryokuHsYmd = DateFormatUtil.dateKANJISeireki(kouryokuHsYmd);

                    pMsgIdLst.add(BizUtil.getGeneralMessageId(messageId));
                    pMsgLst.add(MessageUtil.getMessage(messageId, kinouNm, hnkNaiyou, editKouryokuHsYmd));
                }
            }
        }

        return procKekkaHensyuu(pUiBean, warningFlag, pMsgIdLst, pMsgLst);
    }

    private C_YuukoujyotaichkKbn procKhHenkouUktk(CheckYuukouJyoutaiExecUiBeanParam pUiBean, String pKinouId,
        Boolean pWarningFlag, ArrayList<String> pMsgIdLst, ArrayList<String> pMsgLst) {

        boolean warningFlag = pWarningFlag;
        ArrayList<String> msgIdLst = pMsgIdLst;
        ArrayList<String> msgLst = pMsgLst;

        C_UktkJyoutaiKbn[] uktkJyoutaiKbns = new C_UktkJyoutaiKbn[2];

        uktkJyoutaiKbns[0] = C_UktkJyoutaiKbn.MISYORI;
        uktkJyoutaiKbns[1] = C_UktkJyoutaiKbn.ERROR;

        List<KhHenkouUktkBean> khHenkouUktkBeanLst = hozenDomManager.getKhHenkouUktkBySyonoUktkjyoutaiKbn(syono,
            uktkJyoutaiKbns);

        for (KhHenkouUktkBean khHenkouUktkBean : khHenkouUktkBeanLst) {

            C_UktkSyoriKbn uktkSyoriKbn = khHenkouUktkBean.getUktkSyoriKbn();

            C_TourokuRouteKbn tourokuroute = khHenkouUktkBean.getTourokuroute();

            IM_KhHenkouUktksyorikahi khHenkouUktksyorikahi = hozenDomManager.getKhHenkouUktksyorikahi(pKinouId,
                uktkSyoriKbn);

            if (khHenkouUktksyorikahi != null) {

                C_YuukoujyotaikahiKbn yuukoujyotaikahiKbn = khHenkouUktksyorikahi.getYuukoujyotaikahikbn();
                String uktkSyori = uktkSyoriKbn.getContent();

                if (C_YuukoujyotaikahiKbn.HUKA.eq(yuukoujyotaikahiKbn)) {
                    errorMessage = tourokuroute.getContent(C_TourokuRouteKbn.PATTERN_YUUKOUJYOTAI)
                        + uktkSyori + "　" + "受付中";
                    return C_YuukoujyotaichkKbn.HUKA;
                }

                if (C_YuukoujyotaikahiKbn.SYORITYUUIARI.eq(yuukoujyotaikahiKbn)) {
                    warningFlag = true;
                    msgIdLst.add(BizUtil.getGeneralMessageId(MessageId.KIC0001));
                    msgLst.add(MessageUtil.getMessage(MessageId.KIC0001, tourokuroute.getContent
                        (C_TourokuRouteKbn.PATTERN_YUUKOUJYOTAI) + uktkSyori + "　" + "受付中"));
                }
            }
        }

        return procSyoriJyotai(pUiBean, pKinouId, warningFlag, msgIdLst, msgLst);
    }

    private C_YuukoujyotaichkKbn procKekkaHensyuu(CheckYuukouJyoutaiExecUiBeanParam pUiBean, Boolean pWarningFlag,
        ArrayList<String> pMsgIdLst, ArrayList<String> pMsgLst) {

        if (pWarningFlag) {

            warningMessageIDList = pMsgIdLst;

            warningMessageList = pMsgLst;

            return C_YuukoujyotaichkKbn.TYUUITRATKIKA;
        }

        return C_YuukoujyotaichkKbn.KA;
    }

    public void detachAllEntities(String syoNo) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
        if (kykKihon != null) {
            kykKihon.noCheckDetach();
        }

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        if (ansyuKihon != null) {
            ansyuKihon.noCheckDetach();
        }

        List<JT_SkKihon> skKihonList =
            siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(syoNo,C_SeikyuuSyubetu.SBKRUKTK,C_UmuKbn.NONE);
        for (JT_SkKihon skKihon : skKihonList) {
            skKihon.noCheckDetach();
        }

    }
}
