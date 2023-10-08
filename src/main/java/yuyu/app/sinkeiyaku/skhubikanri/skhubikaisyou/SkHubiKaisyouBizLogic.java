package yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou;

import static yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.GenSkHubiKaisyouConstants.*;
import static yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.SkHubiKaisyouConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou.SkHubiKaisyouConstants.E_SyoriKeiyu;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiKaisyou;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.moschk.SetHutuuSibouS;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.GetSkTtdkTyuui;
import yuyu.common.sinkeiyaku.skcommon.HanteiDoujiMos;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_KaisyoutaisyouKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkHubiDetail;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 新契約不備解消 のビジネスロジックです。
 */
public class SkHubiKaisyouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkHubiKaisyouUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private GetSkTtdkTyuui getSkTtdkTyuui;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
    }

    void clear() {
    }

    String pushNestedEndBL() {

        String forward = null;

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            forward = FORWARDNAME_INIT;
        }
        else {
            forward = FORWARDNAME_BACKTOWORKLIST;
        }

        return forward;
    }

    String pushKinouNmLinkBL() {

        String forward = null;

        if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS ||uiBean.getPageNo() == PAGENO_CONFIRM) {
            unlockProcess();
        }

        if ((uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM ||
            uiBean.getPageNo() == PAGENO_RESULT) && E_SyoriKeiyu.ITIRAN.equals(uiBean.getSyorikeiyukbn())) {
            forward = FORWARDNAME_NESTEDEND;

            return forward;
        }

        forward = pushNestedEndBL();

        return forward;
    }

    @Transactional
    void iwfOpenBL() {

        BizPropertyInitializer.initialize(uiBean);

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        uiBean.setMosno(bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getMosNo());

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        C_SeirituKbn seirituKbn = syoriCTL.getSeiritukbn();
        if (!C_SeirituKbn.NONE.eq(seirituKbn)) {
            throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
        }

        uiBean.setSyoriCTL(syoriCTL);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoKaisyouymdHasinymd(uiBean.getMosno());
        if (skHubiLst.isEmpty()) {
            throw new BizLogicException(MessageId.EBF0114);
        }

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.isEmpty()) {
            throw new BizLogicException(MessageId.EHA1030);
        }
        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(
            uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        uiBean.setHubisikibetukey(skHubiLst.get(0).getHubisikibetukey());
        uiBean.setSyorikeiyukbn(E_SyoriKeiyu.WORKLIST);

        doJyunbi();

    }

    @Transactional
    String pushKakuteiInputBL() {

        BizPropertyInitializer.initialize(uiBean);
        String forward = null;

        kinouMode.setKinouMode(C_SkkinouModeIdKbn.HUBIKAISYOU.getValue());
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        boolean kengenFlag = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouMode.getKinouMode());

        if (!kengenFlag) {
            throw new BizLogicException(MessageId.EHA1073,  C_SkkinouModeIdKbn.getContentByValue(kinouMode.getKinouMode()));
        }

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0030, MOSNO);
        }
        C_SeirituKbn seirituKbn = syoriCTL.getSeiritukbn();
        if (!C_SeirituKbn.NONE.eq(seirituKbn)) {
            throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
        }

        uiBean.setSyoriCTL(syoriCTL);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));

        List<HT_SkHubi> skHubiLst = sinkeiyakuDomManager.getSkHubisByMosnoKaisyouymdHasinymd(uiBean.getMosno());
        if (skHubiLst.isEmpty()) {
            throw new BizLogicException(MessageId.EBF0114);
        }

        if (skHubiLst.size() == 1) {

            doKouteiLockStart(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU);

            uiBean.setHubisikibetukey(skHubiLst.get(0).getHubisikibetukey());
            uiBean.setSyorikeiyukbn(E_SyoriKeiyu.KEYINPUT);

            doJyunbi();

            forward = FORWARDNAME_INPUTCONTENTS;

        }
        else {

            List<ItiranInfoDataSourceBean> itiranInfoDataSourceBeanLst = Lists.newArrayList();
            String nyuuryokuLink = MessageUtil.getMessage(DDID_ITIRANINFO_NYUURYOKULINK.getErrorResourceKey());

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            for (HT_SkHubi skHubi : skHubiLst) {

                ItiranInfoDataSourceBean itiranInfoDataSourceBean = new ItiranInfoDataSourceBean();

                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());
                bzGetProcessSummaryInBean.setKouteiKanriId(skHubi.getHubisikibetukey());

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                itiranInfoDataSourceBean.setHubiSikibetuKey(skHubi.getHubisikibetukey());
                itiranInfoDataSourceBean.setJimutetuzukinm(skHubi.getJimutetuzukinm());
                itiranInfoDataSourceBean.setJimustartymd(
                    BizDate.valueOf(bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmdTime()));
                itiranInfoDataSourceBean.setNyuuryokuLink(nyuuryokuLink);

                itiranInfoDataSourceBeanLst.add(itiranInfoDataSourceBean);
            }

            uiBean.setItiranInfo(itiranInfoDataSourceBeanLst);
            uiBean.setCurrenttsknm(kinou.getKinouNm());

            forward =  FORWARDNAME_SELECTDATA;
        }

        return forward;
    }

    void pushInputBL() {

        ItiranInfoDataSourceBean itiranInfoDataSourceBean = uiBean.getItiranInfoDataSource().getSelectedBean();

        doKouteiLockStart(itiranInfoDataSourceBean.getJimuttzkCd());

        uiBean.setHubisikibetukey(itiranInfoDataSourceBean.getHubiSikibetuKey());
        uiBean.setSyorikeiyukbn(E_SyoriKeiyu.ITIRAN);

        doJyunbi();

    }

    void pushKakuninBL() {

        continueLockProcess();

        HT_SyoriCTL syoriCTL = null;
        syoriCTL = uiBean.getSyoriCTL();

        uiBean.setKetteikbn(syoriCTL.getKetteikbn());
        uiBean.setKnkysateijyoukbn(syoriCTL.getKnkysateijyoukbn());
        uiBean.setImusateijyoukbn(syoriCTL.getImusateijyoukbn());
        uiBean.setMostenkenjoukbn(syoriCTL.getMostenkenjoukbn());

        int kaisyouTaisyouKensuu = 0;

        List<HubiListDataSourceBean> hubiListDataSourceBeanLst = uiBean.getHubiListDataSource().getAllData();

        for(HubiListDataSourceBean hubiListDataSourceBean : hubiListDataSourceBeanLst){

            if (hubiListDataSourceBean.getDispkaisyoutaisyou()) {
                hubiListDataSourceBean.setDispkaisyouymd(BizDate.getSysDate());
                kaisyouTaisyouKensuu++;
            }
        }

        if (kaisyouTaisyouKensuu == 0) {

            throw new BizLogicException(MessageId.EBF0115);
        }

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

        if (C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(uiBean.getMostenkenkekkakbn()) ||
            C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(uiBean.getMostenkenkekkakbn()) ||
            C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn()) ) {

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() > 0) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

                if (bzGetProcessSummaryOutBean.getNowTantId() != null
                    && bzGetProcessSummaryOutBean.getNowTantId().length() > 0) {

                    HM_KetteiSya ketteiSya =
                        sinkeiyakuDomManager.getKetteiSya(bzGetProcessSummaryOutBean.getNowTantId());

                    String ketteisyanm = "";

                    if (ketteiSya != null) {

                        ketteisyanm = ketteiSya.getKetsyacd() + ketteiSya.getKetsyanm();
                    }

                    throw new BizLogicException(MessageId.EHA1068, ketteisyanm);
                }
            }

            if (BizUtil.isBlank(uiBean.getMostenkentnsketsyacd())) {

                throw new BizLogicException(MessageId.EHA0309);
            }

            if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(uiBean.getKnksateisateikekka()) ||
                C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(uiBean.getKnksateisateikekka()) ||
                C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(uiBean.getKnksateisateikekka())) {

                throw new BizLogicException(MessageId.EHA1016);
            }

            if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(uiBean.getImusateisateikekka()) ||
                C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(uiBean.getImusateisateikekka())) {

                throw new BizLogicException(MessageId.EHA1016);
            }

            if (!ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(uiBean.getMostenkentnsketsyacd())) {

                if (C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())) {

                    doCheckKinouModeKengen(checkKinouModeKengen, uiBean.getMostenkentnsketsyacd(), KINOUID_SKMOUSIKOMITENKEN,
                        C_SkkinouModeIdKbn.MOSTENKEN_1JI.getValue(), MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_1JI.getContent());

                    doCheckTaskKengen(checkTaskKengen, uiBean.getMostenkentnsketsyacd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
                        ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI, MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_1JI.getContent());

                    if (bzGetProcessSummaryOutBeanLst.size() > 0) {
                        doCheckWariateHukaInfo(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
                            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                            ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
                            ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI,
                            uiBean.getMostenkentnsketsyacd());
                    }

                }
                else if (C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())) {

                    doCheckKinouModeKengen(checkKinouModeKengen, uiBean.getMostenkentnsketsyacd(), KINOUID_SKMOUSIKOMITENKEN,
                        C_SkkinouModeIdKbn.MOSTENKEN_2JI.getValue(), MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_2JI.getContent());

                    doCheckTaskKengen(checkTaskKengen, uiBean.getMostenkentnsketsyacd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
                        ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI, MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_2JI.getContent());

                    if (bzGetProcessSummaryOutBeanLst.size() > 0) {
                        doCheckWariateHukaInfo(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
                            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                            ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
                            ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI,
                            uiBean.getMostenkentnsketsyacd());
                    }

                }
                else if (C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) {

                    doCheckKinouModeKengen(checkKinouModeKengen, uiBean.getMostenkentnsketsyacd(), KINOUID_SKMOUSIKOMITENKEN,
                        C_SkkinouModeIdKbn.MOSTENKEN_HUBI.getValue(), MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_HUBI.getContent());

                    doCheckTaskKengen(checkTaskKengen, uiBean.getMostenkentnsketsyacd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
                        ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI, MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_HUBI.getContent());

                    if (bzGetProcessSummaryOutBeanLst.size() > 0) {
                        doCheckWariateHukaInfo(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
                            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                            ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
                            ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI,
                            uiBean.getMostenkentnsketsyacd());
                    }
                }
            }

            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(uiBean.getMostenkentnsketsyacd());
            uiBean.setMostentnsketsyanm(ketteiSya.getKetsyanm());

            if (BizUtil.isBlank(uiBean.getMostenkencommentgamen())) {

                throw new BizLogicException(MessageId.EBC0045, MOSTENKENCOMMENT);
            }
        }
        else if (C_SyorikekkaKbn.BLNK.eq(uiBean.getMostenkenkekkakbn())) {

            if (!BizUtil.isBlank(uiBean.getMostenkentnsketsyacd())) {

                throw new BizLogicException(MessageId.EBC0007, TENNOUSAKI);
            }

            if (!BizUtil.isBlank(uiBean.getMostenkencommentgamen())) {

                throw new BizLogicException(MessageId.EBC0007, MOSTENKENCOMMENT);
            }
        }

        if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(uiBean.getKnksateisateikekka()) ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(uiBean.getKnksateisateikekka()) ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(uiBean.getKnksateisateikekka())) {

            if (C_KnkysateijyouKbn.SATEIMATI_1.eq(uiBean.getKnkysateijyoukbn()) ||
                C_KnkysateijyouKbn.SATEIMATI_2A.eq(uiBean.getKnkysateijyoukbn()) ||
                C_KnkysateijyouKbn.SATEIMATI_2B.eq(uiBean.getKnkysateijyoukbn())) {

                throw new BizLogicException(MessageId.EHA0312);
            }

            if (BizUtil.isBlank(uiBean.getKnktnsketsyacd())) {

                throw new BizLogicException(MessageId.EHA0309);
            }

            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(uiBean.getKnktnsketsyacd());

            if (!ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(uiBean.getKnktnsketsyacd())) {

                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();
                BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(uiBean.getKnksateisateikekka())) {

                    doCheckKinouModeKengen(checkKinouModeKengen, uiBean.getKnktnsketsyacd(), KINOUID_SKKANKYOUSATEI,
                        C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue(), MessageId.EHA0314,
                        C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getContent());

                    doCheckTaskKengen(checkTaskKengen, uiBean.getKnktnsketsyacd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU,
                        ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI, MessageId.EHA0314,
                        C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getContent());

                    if (bzGetProcessSummaryOutBeanLst.size()>0) {
                        doCheckWariateHukaInfo(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
                            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                            ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU,
                            ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI,
                            uiBean.getKnktnsketsyacd());
                    }

                }
                else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(uiBean.getKnksateisateikekka())) {

                    doCheckKinouModeKengen(checkKinouModeKengen, uiBean.getKnktnsketsyacd(), KINOUID_SKKANKYOUSATEI,
                        C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue(), MessageId.EHA0314,
                        C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getContent());

                    doCheckTaskKengen(checkTaskKengen, uiBean.getKnktnsketsyacd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU,
                        ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA, MessageId.EHA0314,
                        C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getContent());

                    if (bzGetProcessSummaryOutBeanLst.size()>0) {
                        doCheckWariateHukaInfo(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
                            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                            ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU,
                            ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA,
                            uiBean.getKnktnsketsyacd());
                    }

                }
                else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(uiBean.getKnksateisateikekka())) {

                    doCheckKinouModeKengen(checkKinouModeKengen, uiBean.getKnktnsketsyacd(), KINOUID_SKKANKYOUSATEI,
                        C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue(), MessageId.EHA0314,
                        C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getContent());

                    doCheckTaskKengen(checkTaskKengen, uiBean.getKnktnsketsyacd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU,
                        ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB, MessageId.EHA0314,
                        C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getContent());

                    if (bzGetProcessSummaryOutBeanLst.size()>0) {
                        doCheckWariateHukaInfo(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
                            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                            ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU,
                            ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB,
                            uiBean.getKnktnsketsyacd());
                    }

                }

                BizCurrency hutsusibouS = getHutsusibouS(syoriCTL);
                if (ketteiSya.getKnksateijygns().compareTo(hutsusibouS) < 0) {

                    throw new BizLogicException(MessageId.EHA1015, hutsusibouS.toFormatString());
                }
            }

            if (C_MostenkenjyouKbn.TENKENMATI_1.eq(uiBean.getMostenkenjoukbn()) ||
                C_MostenkenjyouKbn.TENKENMATI_2.eq(uiBean.getMostenkenjoukbn()) ||
                C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(uiBean.getMostenkenjoukbn())) {

                throw new BizLogicException(MessageId.EHA1019, MOSTENKENTYU);
            }

            if (BizUtil.isBlank(uiBean.getKnksateicommentgamen())) {

                throw new BizLogicException(MessageId.EBC0045, KNKCOMMENT);
            }

            uiBean.setKnktnsketsyanm(ketteiSya.getKetsyanm());
        }
        else if (C_SyorikekkaKbn.BLNK.eq(uiBean.getKnksateisateikekka())) {

            if (!BizUtil.isBlank(uiBean.getKnksateicommentgamen())) {

                throw new BizLogicException(MessageId.EBC0007, KNKCOMMENT);
            }

            if (!BizUtil.isBlank(uiBean.getKnktnsketsyacd())) {

                throw new BizLogicException(MessageId.EBC0007, TENNOUSAKI);
            }
        }

        if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(uiBean.getImusateisateikekka()) ||
            C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(uiBean.getImusateisateikekka())) {

            if (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(uiBean.getImusateijyoukbn()) ||
                C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(uiBean.getImusateijyoukbn())) {

                throw new BizLogicException(MessageId.EHA0312);
            }

            if (BizUtil.isBlank(uiBean.getImutnsketsyacd())) {

                throw new BizLogicException(MessageId.EHA0309);
            }

            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(uiBean.getImutnsketsyacd());

            if (!ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(uiBean.getImutnsketsyacd())) {

                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();
                BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

                if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(uiBean.getImusateisateikekka())) {

                    doCheckKinouModeKengen(checkKinouModeKengen, uiBean.getImutnsketsyacd(), KINOUID_SKIMUSATEI,
                        C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.getValue(), MessageId.EHA0314,
                        C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.getContent());

                    doCheckTaskKengen(checkTaskKengen, uiBean.getImutnsketsyacd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU,
                        ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW, MessageId.EHA0314,
                        C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.getContent());

                    if (bzGetProcessSummaryOutBeanLst.size()>0) {
                        doCheckWariateHukaInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                            ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU,
                            ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW,
                            uiBean.getImutnsketsyacd());
                    }
                }
                else if (C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(uiBean.getImusateisateikekka())) {

                    doCheckKinouModeKengen(checkKinouModeKengen, uiBean.getImutnsketsyacd(), KINOUID_SKIMUSATEI,
                        C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.getValue(), MessageId.EHA0314,
                        C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.getContent());

                    doCheckTaskKengen(checkTaskKengen, uiBean.getImutnsketsyacd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU,
                        ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD, MessageId.EHA0314,
                        C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.getContent());

                    if (bzGetProcessSummaryOutBeanLst.size()>0) {
                        doCheckWariateHukaInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                            ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU,
                            ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD,
                            uiBean.getImutnsketsyacd());
                    }
                }

                BizCurrency hutsusibouS = getHutsusibouS(syoriCTL);
                if (ketteiSya.getImusateijygns().compareTo(hutsusibouS) < 0) {

                    throw new BizLogicException(MessageId.EHA1015, hutsusibouS.toFormatString());
                }

            }

            uiBean.setImutnsketsyanm(ketteiSya.getKetsyanm());

            if (C_MostenkenjyouKbn.TENKENMATI_1.eq(uiBean.getMostenkenjoukbn()) ||
                C_MostenkenjyouKbn.TENKENMATI_2.eq(uiBean.getMostenkenjoukbn()) ||
                C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(uiBean.getMostenkenjoukbn())) {

                throw new BizLogicException(MessageId.EHA1019, MOSTENKENTYU);
            }

            if (BizUtil.isBlank(uiBean.getImusateicommentgamen())) {

                throw new BizLogicException(MessageId.EBC0045, IMUCOMMENT);
            }
        }
        else if (C_SyorikekkaKbn.BLNK.eq(uiBean.getImusateisateikekka())) {

            if (!BizUtil.isBlank(uiBean.getImusateicommentgamen())) {

                throw new BizLogicException(MessageId.EBC0007, IMUCOMMENT);
            }

            if (!BizUtil.isBlank(uiBean.getImutnsketsyacd())) {

                throw new BizLogicException(MessageId.EBC0007, TENNOUSAKI);
            }
        }

        messageManager.removeConversationMessage(INPUTKEYWARNING);
        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QBA0001);
    }

    String pushmodoruBtnByInputContentsBL() {

        unlockProcess();

        messageManager.removeConversationMessage(INPUTKEYWARNING);

        uiBean.setMostenkenkekkakbn(C_SyorikekkaKbn.BLNK);
        uiBean.setMostenkentnsketsyacd(BLANK);
        uiBean.setMostenkencommentgamen(BLANK);
        uiBean.setKnksateisateikekka(C_SyorikekkaKbn.BLNK);
        uiBean.setKnktnsketsyacd(BLANK);
        uiBean.setKnksateicommentgamen(BLANK);
        uiBean.setImusateisateikekka(C_SyorikekkaKbn.BLNK);
        uiBean.setImutnsketsyacd(BLANK);
        uiBean.setImusateicommentgamen(BLANK);

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {

            if (E_SyoriKeiyu.ITIRAN.equals(uiBean.getSyorikeiyukbn())) {

                return FORWARDNAME_SELECTDATA;
            }

            return FORWARDNAME_INIT;
        }

        return FORWARDNAME_BACKTOWORKLIST;
    }

    void pushmodoruBtnByConfirmBL() {

        List<HubiListDataSourceBean> hubiListDataSourceBeanLst = uiBean.getHubiListDataSource().getAllData();
        for(HubiListDataSourceBean hubiListDataSourceBean : hubiListDataSourceBeanLst) {

            if (hubiListDataSourceBean.getDispkaisyoutaisyou()) {
                hubiListDataSourceBean.setDispkaisyouymd(null);
            }
        }

        uiBean.setMostentnsketsyanm(BLANK);
        uiBean.setKnktnsketsyanm(BLANK);
        uiBean.setImutnsketsyanm(BLANK);

        setAitemosnoWarning(uiBean.getMosno(), uiBean.getSyoriCTL().getMosnrkumu());

        setDoujiMosWarning(uiBean.getMosno());

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
    }

    @Transactional
    void pushOKBL() {

        String mosNo = uiBean.getMosno();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();
        String userId = baseUserInfo.getUserId();
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        String hubiSikibetuKey = uiBean.getHubisikibetukey();

        continueLockProcess();

        List<HubiListDataSourceBean> hubDataList = uiBean.getHubiListDataSource().getAllData();

        HT_SkHubi skHubi = syoriCTL.getSkHubiByHubisikibetukey(hubiSikibetuKey);

        List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetailsByHasinymd();

        for (HubiListDataSourceBean hubiListDataSourceBean : hubDataList){
            if ((C_KaisyoutaisyouKbn.TAISYOU).eq(hubiListDataSourceBean.getDispkaisyoutaisyoukbn())) {
                for (HT_SkHubiDetail skHubiDetail : skHubiDetailLst) {

                    if (skHubiDetail.getRenno3keta().equals(hubiListDataSourceBean.getRenno3keta())) {

                        skHubiDetail.setKaisyouymd(sysDate);
                        skHubiDetail.setGyoumuKousinsyaId(userId);
                        skHubiDetail.setGyoumuKousinTime(sysDateTime);
                        break;
                    }
                }
            }
        }

        if (!C_SyorikekkaKbn.BLNK.eq(uiBean.getMostenkenkekkakbn())) {
            HT_MostenkenRireki mostenkenRirekiMax = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno(mosNo);
            Integer renNo = 1;
            if (mostenkenRirekiMax != null) {
                renNo = mostenkenRirekiMax.getRenno() + 1;
            }

            HT_MostenkenRireki mostenkenRireki = syoriCTL.createMostenkenRireki();

            String comment = EditSecurityKm.getEncodeData(mosNo, uiBean.getMostenkencommentgamen());

            mostenkenRireki.setRenno(renNo);
            mostenkenRireki.setSyoriYmd(sysDate);
            mostenkenRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.HUBIKAISYOU);
            mostenkenRireki.setMostenkenkekkakbn(uiBean.getMostenkenkekkakbn());
            mostenkenRireki.setTnsketsyacd(uiBean.getMostenkentnsketsyacd());
            mostenkenRireki.setKetsyacd(userId);
            mostenkenRireki.setPalketsyacd(BLANK);
            mostenkenRireki.setMostenkencomment(comment);
            mostenkenRireki.setGyoumuKousinsyaId(userId);
            mostenkenRireki.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(mostenkenRireki);

            if (C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())) {
                uiBean.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
            }
            else if (C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())) {
                uiBean.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_2);
            }
            else if (C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) {
                uiBean.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_HUBI);
            }

            syoriCTL.setMostenkenrrkumu(C_UmuKbn.ARI);
            syoriCTL.setMostenkenjoukbn(uiBean.getMostenkenjoukbn());
            syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
            syoriCTL.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            syoriCTL.setSateizumiymd(null);
        }

        if (!C_SyorikekkaKbn.BLNK.eq(uiBean.getKnksateisateikekka())) {
            HT_KnksateiRireki knksateiRirekiMax = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno(mosNo);
            Integer renno = 1;
            if (knksateiRirekiMax != null) {
                renno = knksateiRirekiMax.getRenno() + 1;
            }
            HT_KnksateiRireki knksateiRireki = syoriCTL.createKnksateiRireki();

            String comment = EditSecurityKm.getEncodeData(mosNo, uiBean.getKnksateicommentgamen());

            knksateiRireki.setRenno(renno);
            knksateiRireki.setSyoriYmd(sysDate);
            knksateiRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.HUBIKAISYOU);
            knksateiRireki.setKnksateikekkakbn(uiBean.getKnksateisateikekka());
            knksateiRireki.setTnsketsyacd(uiBean.getKnktnsketsyacd());
            knksateiRireki.setKetsyacd(userId);
            knksateiRireki.setPalketsyacd(BLANK);
            knksateiRireki.setKnksateicomment(comment);
            knksateiRireki.setKetkekkacd(C_Ketkekkacd.BLNK);
            knksateiRireki.setKetriyuucd1(C_Ketriyuucd.BLNK);
            knksateiRireki.setKetriyuucd2(C_Ketriyuucd.BLNK);
            knksateiRireki.setKetriyuucd3(C_Ketriyuucd.BLNK);
            knksateiRireki.setKetriyuucd4(C_Ketriyuucd.BLNK);
            knksateiRireki.setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd.BLNK);
            knksateiRireki.setGyoumuKousinsyaId(userId);
            knksateiRireki.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(knksateiRireki);

            if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(uiBean.getKnksateisateikekka())) {
                uiBean.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
            }
            else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(uiBean.getKnksateisateikekka())) {
                uiBean.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2A);
            }
            else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(uiBean.getKnksateisateikekka())) {
                uiBean.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2B);
            }

            syoriCTL.setKnkysateirrkumu(C_UmuKbn.ARI);
            syoriCTL.setKnkysateijyoukbn(uiBean.getKnkysateijyoukbn());
            syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
            syoriCTL.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            syoriCTL.setSateizumiymd(null);

        }

        if (!C_SyorikekkaKbn.BLNK.eq(uiBean.getImusateisateikekka())) {
            HT_ImusateiRireki imusateiRirekiMax = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno(mosNo);
            Integer renno = 1;
            if (imusateiRirekiMax != null) {
                renno = imusateiRirekiMax.getRenno() + 1;
            }
            HT_ImusateiRireki imusateiRireki =syoriCTL.createImusateiRireki();

            String comment = EditSecurityKm.getEncodeData(mosNo, uiBean.getImusateicommentgamen());

            imusateiRireki.setRenno(renno);
            imusateiRireki.setSyoriYmd(sysDate);
            imusateiRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.HUBIKAISYOU);
            imusateiRireki.setImusateikekkakbn(uiBean.getImusateisateikekka());
            imusateiRireki.setTnsketsyacd(uiBean.getImutnsketsyacd());
            imusateiRireki.setKetsyacd(userId);
            imusateiRireki.setPalketsyacd(BLANK);
            imusateiRireki.setImusateicomment(comment);
            imusateiRireki.setKetkekkacd(C_Ketkekkacd.BLNK);
            imusateiRireki.setKetriyuucd1(C_Ketriyuucd.BLNK);
            imusateiRireki.setKetriyuucd2(C_Ketriyuucd.BLNK);
            imusateiRireki.setKetriyuucd3(C_Ketriyuucd.BLNK);
            imusateiRireki.setKetriyuucd4(C_Ketriyuucd.BLNK);
            imusateiRireki.setSyoubyoucd1(BLANK);
            imusateiRireki.setSyoubyoujyoutaikbn1(C_SyoubyoujyoutaiKbn.BLNK);
            imusateiRireki.setKantiym1(null);
            imusateiRireki.setSyoubyoucd2(BLANK);
            imusateiRireki.setSyoubyoujyoutaikbn2(C_SyoubyoujyoutaiKbn.BLNK);
            imusateiRireki.setKantiym2(null);
            imusateiRireki.setSntkinfosakuseiyhkbn(C_SntkinfosakuseiyhKbn.SAKUSEIHUYOU);
            imusateiRireki.setGyoumuKousinsyaId(userId);
            imusateiRireki.setGyoumuKousinTime(sysDateTime);
            BizPropertyInitializer.initialize(imusateiRireki);

            if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(uiBean.getImusateisateikekka())) {
                uiBean.setImusateijyoukbn(C_ImusateijyouKbn.SATEIMATI_KANI_UW);
            }
            else if (C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(uiBean.getImusateisateikekka())) {
                uiBean.setImusateijyoukbn(C_ImusateijyouKbn.SATEIMATI_KANI_MD);
            }

            syoriCTL.setImusateirrkumu(C_UmuKbn.ARI);
            syoriCTL.setImusateijyoukbn(uiBean.getImusateijyoukbn());
            syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
            syoriCTL.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            syoriCTL.setSateizumiymd(null);

        }

        long kennsuu = sinkeiyakuDomManager.getSkHubiDetailCountByMosnoTrkymdHasinymdKaisyouymd(mosNo);
        if (kennsuu == 0) {
            syoriCTL.setHubikaisyoujoutaikbn(C_HubikaisyoujoutaiKbn.HUBIKAISYOUZUMI);
        }
        else {
            syoriCTL.setHubikaisyoujoutaikbn(C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI);
        }

        if (!C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) && !C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
            BT_GyoumuKouteiInfo gyoumuKouteiInfo = null;
            gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

            if (gyoumuKouteiInfo == null) {
                unlockProcess();
                throw new CommonBizAppException(MOSBANGOU + mosNo);
            }

            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
            mosnaiCheckParam.setSysDate(sysDate);
            mosnaiCheckParam.setKosID(userId);
            mosnaiCheckParam.setKosTime(sysDateTime);
            mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);

            mosnaiCheckParam.debug(ADDSETUMEI);
            mosnaiCheck.exec(mosnaiCheckParam);
            bizDomManager.update(gyoumuKouteiInfo);

            if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
                sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
            }
        }

        syoriCTL.setGyoumuKousinsyaId(userId);
        syoriCTL.setGyoumuKousinTime(sysDateTime);

        sinkeiyakuDomManager.update(syoriCTL);

        HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
        if (mosnoKanri != null) {
            sinkeiyakuDomManager.update(mosnoKanri);
        }

        String kouteiLockKey = getKouteiLockKey();
        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(mosNo);
        skProcessForwardInBean.setTskNm(uiBean.getVktifdisptasknm());
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment(uiBean.getCommentarea());

        skProcessForwardInBean.setMostenkenkekkaKbn(uiBean.getMostenkenkekkakbn());
        skProcessForwardInBean.setMostenkentnsketsyaCd(uiBean.getMostenkentnsketsyacd());

        skProcessForwardInBean.setKnksateikekkaKbn(uiBean.getKnksateisateikekka());
        skProcessForwardInBean.setKnktnsketsyaCd(uiBean.getKnktnsketsyacd());

        skProcessForwardInBean.setImusateikekkaKbn(uiBean.getImusateisateikekka());
        skProcessForwardInBean.setImutnsketsyaCd(uiBean.getImutnsketsyacd());

        SkProcessForwardHubiKaisyou skProcessForwardHubiKaisyou = SWAKInjector.getInstance(SkProcessForwardHubiKaisyou.class);
        skProcessForwardHubiKaisyou.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);
        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, uiBean.getSkIdounaiyouBeforeBean());
        if (result) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);
            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {
                    errorMessageCollector.addMessage(errorMsg);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        unlockProcess();

        StringBuffer msgOut = new StringBuffer();

        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));
        List<String> kekkaGmnMsgList = mosnaiCheckParam.getListKekkaGmnMsg();

        for (String msg : kekkaGmnMsgList) {
            msgOut.append(KAIGYOU).append(msg);
        }
        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());

    }

    void printHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void unlockProcess() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.unlockProcess();
    }

    private void setSkeittdktyuuiset() {

        String mosNo = uiBean.getMosno();

        List<HT_SkTtdkTyuui> skTtdkTyuuiLst =
            getSkTtdkTyuui.getTtdkTyuui(mosNo, C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(mosNo);

        List<ToriatukaiTyuuiInfoDataSourceBean> toriatukaiTyuuiJouhouDataSourceBeanLst = Lists.newArrayList();
        if (skTtdkTyuuiLst != null && skTtdkTyuuiLst.size() > 0) {
            for (HT_SkTtdkTyuui skTtdkTyuui: skTtdkTyuuiLst) {
                ToriatukaiTyuuiInfoDataSourceBean toriatukaiTyuuiJouhouDataSourceBean =
                    SWAKInjector.getInstance(ToriatukaiTyuuiInfoDataSourceBean.class);
                toriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrttrkymd(skTtdkTyuui.getTrkymd());
                String skeittdktyuuinaiyou = editSecurityKm.decode(skTtdkTyuui.getSkeittdktyuuinaiyou());
                toriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrtnaiyo(skeittdktyuuinaiyou);
                AM_User user = baseDomManager.getUser(skTtdkTyuui.getGyoumuKousinsyaId());
                if (user != null) {
                    toriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrttantou(user.getUserNm());
                }
                toriatukaiTyuuiJouhouDataSourceBeanLst.add(toriatukaiTyuuiJouhouDataSourceBean);
            }
        }
        uiBean.setToriatukaiTyuuiInfo(toriatukaiTyuuiJouhouDataSourceBeanLst);
    }

    private void setMosTenkenTnsList() {

        UserDefsList userDefsList = SWAKInjector.getInstance(UserDefsList.class);
        LabelValuePair labelValuePair = SWAKInjector.getInstance(LabelValuePair.class);

        labelValuePair.setLabel(null);
        labelValuePair.setValue(null);

        userDefsList.add(labelValuePair);

        List<HM_KetteiSya> ketteiSyaLst = null;
        C_MostenkenRankKbn[] mostenkenRankKbns = {C_MostenkenRankKbn.ITIJI, C_MostenkenRankKbn.NIJI, C_MostenkenRankKbn.HUBI};

        ketteiSyaLst = sinkeiyakuDomManager.getKetteiSyasByKetsyacdMostenkenrankkbns(baseUserInfo.getUserId(), mostenkenRankKbns);
        for (HM_KetteiSya ketteiSya: ketteiSyaLst) {
            labelValuePair = new LabelValuePair();
            labelValuePair.setValue(ketteiSya.getKetsyacd());
            labelValuePair.setLabel(ketteiSya.getKetsyanm());
            userDefsList.add(labelValuePair);
        }
        uiBean.setMostenkentnsketsyacdOptionBeanList(userDefsList);
    }

    private void setSetKnksateitnslist() {

        UserDefsList userDefsList = SWAKInjector.getInstance(UserDefsList.class);
        LabelValuePair labelValuePair = SWAKInjector.getInstance(LabelValuePair.class);

        labelValuePair.setValue(null);
        labelValuePair.setLabel(null);

        userDefsList.add(labelValuePair);

        List<HM_KetteiSya>  kekkeiSyaLst = null;
        C_KnksateirankKbn   knksateirankkbn[] = {C_KnksateirankKbn.ITIJI, C_KnksateirankKbn.NIJIA, C_KnksateirankKbn.NIJIB};

        kekkeiSyaLst = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKnksateirankkbns(baseUserInfo.getUserId(), knksateirankkbn);

        for (HM_KetteiSya ketteiSya : kekkeiSyaLst) {
            labelValuePair = new LabelValuePair();
            labelValuePair.setValue(ketteiSya.getKetsyacd());
            labelValuePair.setLabel(ketteiSya.getKetsyanm());

            userDefsList.add(labelValuePair);
        }
        uiBean.setKnktnsketsyacdOptionBeanList(userDefsList);
    }

    private void setSetimusateitnslist() {

        UserDefsList userDefsList = SWAKInjector.getInstance(UserDefsList.class);
        LabelValuePair labelValuePair = SWAKInjector.getInstance(LabelValuePair.class);

        labelValuePair.setValue(null);
        labelValuePair.setLabel(null);

        userDefsList.add(labelValuePair);

        List<HM_KetteiSya>  kekkeiSyaLst = null;
        C_ImusateirankKbn   imusateirankKbn[] = {C_ImusateirankKbn.KANI_UW, C_ImusateirankKbn.KANI_MD};
        kekkeiSyaLst = sinkeiyakuDomManager.getKetteiSyasByKetsyacdImusateirankkbns(baseUserInfo.getUserId(), imusateirankKbn);

        for (HM_KetteiSya ketteiSya : kekkeiSyaLst) {
            labelValuePair = new LabelValuePair();
            labelValuePair.setValue(ketteiSya.getKetsyacd());
            labelValuePair.setLabel(ketteiSya.getKetsyanm());

            userDefsList.add(labelValuePair);
        }
        uiBean.setImutnsketsyacdOptionBeanList(userDefsList);
    }

    private void setHubiInfo() {

        HT_SkHubi skHubi = uiBean.getSyoriCTL().getSkHubiByHubisikibetukey(uiBean.getHubisikibetukey());
        List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetailsByHasinymd();
        SortHT_SkHubiDetail skHubiDetailSort = SWAKInjector.getInstance(SortHT_SkHubiDetail.class);
        skHubiDetailLst = skHubiDetailSort.OrderHT_SkHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(skHubiDetailLst);

        if (!skHubiDetailLst.isEmpty()) {
            List<HubiListDataSourceBean> hubiListDataSourceBeanLst = new ArrayList<>();

            for (HT_SkHubiDetail skHubiDetail : skHubiDetailLst) {
                HubiListDataSourceBean hubiListDataSourceBean = SWAKInjector.getInstance(HubiListDataSourceBean.class);

                hubiListDataSourceBean.setRenno3keta(skHubiDetail.getRenno3keta());
                hubiListDataSourceBean.setTyoubunflg(skHubiDetail.getTyoubunflg());
                hubiListDataSourceBean.setDispkaisyoutaisyou(false);
                hubiListDataSourceBean.setDisptrkymd(skHubiDetail.getTrkymd());
                hubiListDataSourceBean.setDispskhubikoumoku(getSkeiHubiKoumoku(skHubiDetail));
                hubiListDataSourceBean.setDispskhubinaiyou(getSkeiHubiNaiyou(skHubiDetail));
                hubiListDataSourceBean.setDispskseibisijinaiyou(getSkeiSeibiSijiNaiyou(skHubiDetail));
                hubiListDataSourceBean.setDisphassinymd(skHubiDetail.getHasinymd());
                hubiListDataSourceBean.setDispkaisyouymd(skHubiDetail.getKaisyouymd());
                hubiListDataSourceBean.setDisphassinsakikbn(skHubiDetail.getHassinsakikbn());
                AM_User user = skHubiDetail.getUser();
                if (user != null) {
                    hubiListDataSourceBean.setDispnyuryokutantounm(user.getUserNm());
                } else {
                    hubiListDataSourceBean.setDispnyuryokutantounm("");
                }

                hubiListDataSourceBean.setDispskrenrakujikou(
                    EditSecurityKm.getDecodeData(uiBean.getMosno(), skHubiDetail.getSkrenrakujikou()));

                hubiListDataSourceBeanLst.add(hubiListDataSourceBean);
            }
            uiBean.setHubiList(hubiListDataSourceBeanLst);
            uiBean.setCommentarea(EditSecurityKm.getDecodeData(uiBean.getMosno(), skHubi.getCommentarea()));
        }
    }

    private String getKouteiLockKey() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();
        return kouteiLockKey;
    }

    private void continueLockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }

    private void setAitemosnoWarning(String pMosNo, C_UmuKbn pMosnrkUmu) {
        int resultKbn = getMsgAitemosno.exec(pMosNo, pMosnrkUmu);

        if (resultKbn == GetMsgAitemosno.KEKKAKBN_ARI) {
            messageManager.addConversationMessageId(SkHubiKaisyouConstants.INPUTKEYWARNING,
                BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid()),
                getMsgAitemosno.getS_gmmsg());
        }
    }

    private void setDoujiMosWarning(String pMosNo) {
        HanteiDoujiMos hanteiDoujiMos = SWAKInjector.getInstance(HanteiDoujiMos.class);
        hanteiDoujiMos.hanteiDoujiMos(pMosNo);
        C_UmuKbn doujimosumu = hanteiDoujiMos.getDoujiMosUmu();
        if (C_UmuKbn.ARI.eq(doujimosumu)) {
            messageManager.addConversationMessageId(SkHubiKaisyouConstants.INPUTKEYWARNING,
                MessageId.WHC0102,
                hanteiDoujiMos.getMsgMosnoList());
        }
    }

    private void setKouteiInfo() {
        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);
        uiBean.setCurrenttsknm(uiBean.getVktifdisptasknm());
    }

    private void setSyoruiInfo() {
        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);
    }

    private BizCurrency getHutsusibouS(HT_SyoriCTL pSyoriCTL) {
        mosnaiCheckParam.setDataSyoriControl(pSyoriCTL);
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());
        mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
        mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());

        SetHutuuSibouS setHutuuSibouS = SWAKInjector.getInstance(SetHutuuSibouS.class);
        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);

        return getKiteiCheckYenkansangk.exec(pSyoriCTL.getMosKihon().getMosymd(), setHutuuSibouS.exec(mosnaiCheckParam),
            pSyoriCTL.getMosKihon().getKyktuukasyu());
    }

    private String getSkeiHubiKoumoku(HT_SkHubiDetail pSkHubiDetail) {
        HM_SkHubiKoumoku skHubiKoumoku = pSkHubiDetail.getSkHubiKoumoku();
        String skHubikoumokuCd = skHubiKoumoku.getSkhubikoumokucd() + "　" + skHubiKoumoku.getSkhubikoumoku();
        return skHubikoumokuCd;
    }

    private String getSkeiHubiNaiyou(HT_SkHubiDetail pSkHubiDetail) {
        HM_SkHubiNaiyou skHubiNaiyou = pSkHubiDetail.getSkHubiNaiyou();
        String skHubinaiyouCd = skHubiNaiyou.getSkhubinaiyoucd() + "　" + skHubiNaiyou.getSkhubinaiyousentakumongon();
        return skHubinaiyouCd;
    }

    private String getSkeiSeibiSijiNaiyou(HT_SkHubiDetail pSkHubiDetail) {
        HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou = pSkHubiDetail.getSkSeibiSijiNaiyou();
        String skSeibisijinaiyouCd = skSeibiSijiNaiyou.getSkseibisijinaiyoucd() + "　" +
            skSeibiSijiNaiyou.getSkseibisijinaiyou();
        return skSeibisijinaiyouCd;
    }

    private void doJyunbi() {

        setAitemosnoWarning(uiBean.getMosno(), uiBean.getSyoriCTL().getMosnrkumu());
        setDoujiMosWarning(uiBean.getMosno());

        String kouteiLockKey = getKouteiLockKey();
        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            kouteiLockKey,
            baseUserInfo.getUserId());
        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        setKouteiInfo();
        setSyoruiInfo();
        setSkeittdktyuuiset();
        setHubiInfo();
        setMosTenkenTnsList();
        setSetKnksateitnslist();
        setSetimusateitnslist();

        if (C_SntkhouKbn.NONE.eq(uiBean.getSyoriCTL().getMosKihon().getSntkhoukbn()) ||
            C_SntkhouKbn.SYOKUGYOU.eq(uiBean.getSyoriCTL().getMosKihon().getSntkhoukbn())) {
            uiBean.setImusateiiraihyjctrlflg(IMUSATEIIRAIHYJCTRLFLG_HIHYOUJI);
        }
        else {
            uiBean.setImusateiiraihyjctrlflg(IMUSATEIIRAIHYJCTRLFLG_HYOUJI);
        }
    }

    private void doKouteiLockStart(String pJimuTetuzukiCd) {

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        uiBean.getBzWorkflowInfo().setKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiCd());
        uiBean.getBzWorkflowInfo().setTaskId(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId());

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        if (bzGetProcessSummaryOutBeanLst.isEmpty()) {
            throw new BizLogicException(MessageId.EHA1030);
        }

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

        BzCommonLockProcess bCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bCommonLockProcess.lockProcess(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

    }

    private void doCheckKinouModeKengen(CheckKinouModeKengen pCheckKinouModeKengen, String pUserId, String pKinouId,
        String pKinouModeId, String pMessageId, String pMsghikisuu) {

        if (!pCheckKinouModeKengen.checkKengenByKinouModeIdByUserId(pUserId, pKinouId, pKinouModeId)) {
            throw new BizLogicException(pMessageId, pMsghikisuu);
        }
    }

    private void doCheckTaskKengen(CheckTaskKengen pCheckTaskKengen, String pUserId, String pJimutetuzukicd,
        String pTaskid, String pMessageId, String pMsghikisuu) {

        if (!pCheckTaskKengen.exec(pUserId, pJimutetuzukicd, pTaskid)) {
            throw new BizLogicException(pMessageId, pMsghikisuu);
        }
    }

    private void doCheckWariateHukaInfo(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd,
        String pWrthukatskid,  String pUserId) {

        BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
            pKouteikanriid,
            pSubSystemId,
            pJimutetuzukicd,
            pWrthukatskid,
            pUserId);

        if (wariateHukaInfo != null) {
            throw new BizLogicException(MessageId.EHA1064);
        }
    }
}
