package yuyu.app.sinkeiyaku.sksonota.skseirituhoryuu;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckDataSansyou;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardSeirituHoryuu;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KengenSyoriKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SansyoukngnumuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 成立保留処理 のビジネスロジックです。
 */
public class SkSeirituHoryuuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkSeirituHoryuuUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
    }

    void clear() {
    }

    void pushUpdBL() {

        BizPropertyInitializer.initialize(uiBean);

        String sMosno = uiBean.getMosno();
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        GetMsgAitemosno getMsgAitemosno = SWAKInjector.getInstance(GetMsgAitemosno.class);
        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);



        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(sMosno);

        if (syoriCTL == null) {

            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setSyoriCTL(syoriCTL);

        C_SansyoukngnumuKbn retChkKngn = CheckDataSansyou.execCheck(sMosno, C_KengenSyoriKbn.SYORI);

        if (C_SansyoukngnumuKbn.NONE.eq(retChkKngn)) {
            throw new BizLogicException(MessageId.EHA0124);
        }

        C_SeirituKbn seirituKbn = syoriCTL.getSeiritukbn();

        if (!(C_SeirituKbn.ITIPMATI.eq(seirituKbn) || C_SeirituKbn.NONE.eq(seirituKbn))) {
            throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
        }

        String[] mosKihons = selHihokenNmFromTMousikomiKihon(sMosno);
        String hhknNmKj = mosKihons[0];

        int kekkakbn = getMsgAitemosno.exec(syoriCTL.getMosnrkumu(), mosKihons[1]);

        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkakbn) {
            uiBean.setGmMsg(getMsgAitemosno.getS_gmmsg());
            uiBean.setGmMsgid(getMsgAitemosno.getS_gmmsgid());
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid()), getMsgAitemosno.getS_gmmsg());
        }

        uiBean.setHhknnmkj(hhknNmKj);
        uiBean.setJimusrhkbn(syoriCTL.getJimusrhkbn());
        uiBean.setInitjimusrhkbn(syoriCTL.getJimusrhkbn());

        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        bzGetProcessSummaryInBean.setMosNo(sMosno);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId());

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
    }

    void pushKakuninBL() {

        if (uiBean.getInitjimusrhkbn().eq(uiBean.getJimusrhkbn())) {
            throw new BizLogicException(MessageId.EHA0158);
        }
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);
        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
            MessageId.QAC0008,
            MessageUtil.getMessage(MessageId.QAC0008));
    }

    @Transactional
    void pushKakuteiBL() {
        String userId = baseUserInfo.getUserId();
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();
        String sMosno = uiBean.getMosno();
        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);


        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        syoriCTL.setJimusrhkbn(uiBean.getJimusrhkbn());


        BT_GyoumuKouteiInfo btGyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo()
            .getOyaKouteiKanriId());

        if (btGyoumuKouteiInfo == null) {

            throw new CommonBizAppException(SkSeirituHoryuuConstants.DDID_KEYINFO_MOSNO + sMosno);
        }

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setSysDate(sysDate);
        mosnaiCheckParam.setKosID(userId);
        mosnaiCheckParam.setKosTime(gyoumuKousinTime);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(btGyoumuKouteiInfo);

        mosnaiCheckParam.debug("<<<<申込内容チェック実行前>>>>");

        mosnaiCheck.exec(mosnaiCheckParam);

        syoriCTL.setGyoumuKousinTime(gyoumuKousinTime);
        syoriCTL.setGyoumuKousinsyaId(userId);

        if (mosKihon != null) {
            mosKihon.setGyoumuKousinTime(gyoumuKousinTime);
            mosKihon.setGyoumuKousinsyaId(userId);
        }

        if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
            sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
        }

        sinkeiyakuDomManager.update(syoriCTL);

        bizDomManager.update(btGyoumuKouteiInfo);

        HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
        if (mosnoKanri != null) {
            sinkeiyakuDomManager.update(mosnoKanri);
        }

        List<String> hubiMsgList = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(sMosno);

        skHubiMsgRenkeiInfo.setMosno(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgList);

        ObjStorageManager objStorageManager = SWAKInjector.getInstance(ObjStorageManager.class);
        uiBean.setUniqueId(objStorageManager.save(skHubiMsgRenkeiInfo));

        uiBean.setHubimsgData(hubiMsgList.toArray(new String[0]));

        StringBuffer msgOut = new StringBuffer();
        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));
        List<String> msgList = mosnaiCheckParam.getListKekkaGmnMsg();
        for (String msg : msgList) {
            msgOut.append(SkSeirituHoryuuConstants.KAIGYOU).append(msg);
        }

        String sKouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        skProcessForwardInBean.setMosNo(uiBean.getMosno());
        skProcessForwardInBean.setTskNm("成立保留処理");
        skProcessForwardInBean.setKouteiLockkey(sKouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("");

        SkProcessForwardSeirituHoryuu skProcessForwardSeirituHoryuu =
            SWAKInjector.getInstance(SkProcessForwardSeirituHoryuu.class);
        skProcessForwardSeirituHoryuu.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, sKouteiLockKey, null);

        Boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, uiBean.getSkIdounaiyouBeforeBean());

        if (result) {

            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

            if (!C_ErrorKbn.OK.eq(skIdounaiyouKekkaBean.getErrorKbn())) {

                for (String errorMsgId : skIdounaiyouKekkaBean.getErrorMsgLst()) {

                    errorMessageCollector.addMessage(errorMsgId);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());
    }

    void setGmwarningId() {
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
        if (!BizUtil.isBlank(uiBean.getGmMsgid())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                BizUtil.getGeneralMessageId(uiBean.getGmMsgid()), uiBean.getGmMsg());
        }

    }

    void continueLockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();
    }

    void pushUnlockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }


    private String[] selHihokenNmFromTMousikomiKihon(String pMosno) {

        HT_MosKihon mosKihon = uiBean.getSyoriCTL().getMosKihon();
        if (mosKihon != null) {
            return new String[] { mosKihon.getHhknnmkj(), mosKihon.getAitemosno() };
        }
        return new String[] { "", "" };
    }
}
