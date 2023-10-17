package yuyu.app.sinkeiyaku.sksonota.skseikyuusyosakusei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.EditPdfHenkinirai;
import yuyu.common.sinkeiyaku.skcommon.EditPdfTrksseikyu;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SksakuseisyoruiKbn;
import yuyu.def.classification.C_TrksskssouhuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.report.OutputReport;

/**
 * 新契約請求書作成 のビジネスロジックです。
 */
public class SkSeikyuusyoSakuseiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkSeikyuusyoSakuseiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private EditPdfHenkinirai editPdfHenkinirai;

    @Inject
    private EditPdfTrksseikyu editPdfTrksseikyu;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private OutputReport outputReport;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    void init() {
    }

    void clear() {
    }

    void pushKakuninBL() {

        BizPropertyInitializer.initialize(uiBean);

        String mosno = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno);
        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        C_UmuKbn mosnrkumu = syoriCTL.getMosnrkumu();
        if (C_UmuKbn.NONE.eq(mosnrkumu)) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        boolean tratkiagErrFlg = false;
        int renno = 1;

        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(renno);
        if (mosDairiten != null) {

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

            if (bzGetAgInfoBeanLst.size() == 0) {
                tratkiagErrFlg = true;
            }
        }
        else {
            tratkiagErrFlg = true;
        }

        if (tratkiagErrFlg) {
            throw new BizLogicException(MessageId.EHA0434);
        }

        if (C_SksakuseisyoruiKbn.SK_TRKSSEIKYU.eq(uiBean.getSksakuseisyoruikbn())) {
            HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou =
                sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(mosDairiten.getOyadrtencd());
            if (skDairitenKobetuJyouhou != null) {
                if (C_TrksskssouhuKbn.DAIRITENSONAETUKEARI.eq(skDairitenKobetuJyouhou.getTrksskssouhukbn())) {
                    throw new BizLogicException(MessageId.EHA1061);
                }
            }
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosno);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.size() > 0) {
            BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

            bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
                ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        }

        int kekkakbn = getMsgAitemosno.exec(mosno, mosnrkumu);
        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkakbn) {

            String messageId = BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid());
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, messageId,
                getMsgAitemosno.getS_gmmsg());
        }

        messageManager.addMessageId(MessageId.QHA0017);
    }

    @Transactional
    void pushKakuteiBL() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        if (syoriCTL == null) {
            throw new CommonBizAppException("申込番号=" + uiBean.getMosno());
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException("申込番号=" + uiBean.getMosno());
        }

        String categoryID = kinou.getCategoryId();
        String kinouID = kinou.getKinouId();
        BizDate sysDate = BizDate.getSysDate();
        String userID = baseUserInfo.getUserId();
        String sysTime = BizDate.getSysDateTimeMilli();

        mosnaiCheckParam.setCategoryID(categoryID);
        mosnaiCheckParam.setKinouID(kinouID);
        mosnaiCheckParam.setSysDate(sysDate);
        mosnaiCheckParam.setKosID(userID);
        mosnaiCheckParam.setKosTime(sysTime);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        String tyhykey = null;

        if (C_SksakuseisyoruiKbn.SK_HENKINIRAISYO.eq(uiBean.getSksakuseisyoruikbn())) {
            tyhykey = editPdfHenkinirai.exec(mosnaiCheckParam, uiBean.getKzsyuruikbn(),null);
        }

        if (C_SksakuseisyoruiKbn.SK_TRKSSEIKYU.eq(uiBean.getSksakuseisyoruikbn())) {
            tyhykey = editPdfTrksseikyu.exec(mosnaiCheckParam, uiBean.getKzsyuruikbn());
        }

        messageManager.addMessageId(MessageId.IAC0009);

        uiBean.setTyhykey(tyhykey);

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);
    }

    void printOut() {

        String tyhykey = uiBean.getTyhykey();

        outputReport.outputPDFByJoinKey(tyhykey);
    }

    void doContinueLockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();
    }

    void doUnlockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }
}
