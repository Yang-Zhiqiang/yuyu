package yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo;

import static yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo.GenSkKokutisyoConstants.*;
import static yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo.SkKokutisyoConstants.*;

import java.util.ArrayList;
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
import yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai.SkNyuuryokuSaiSyoukaiRenkeiInfo;
import yuyu.app.sinkeiyaku.skmousikomi.skkokutisyo.SkKokutisyoConstants.E_SyoriKbn;
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
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKokutisyoNyuuryoku;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.GetMsgDoujikaiyakusyono;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SaiDataSyutoku;
import yuyu.common.sinkeiyaku.skcommon.SaiDataTouroku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.common.sinkeiyaku.skcommon.TsRrkInfoTouroku;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KzkkijiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_KokutisyoVrf;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 告知書入力 のビジネスロジックです。
 */
public class SkKokutisyoBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkKokutisyoUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private GetMsgDoujikaiyakusyono getDoujikaiyakusyono;

    @Inject
    private TsRrkInfoTouroku tsRrkInfoTouroku;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private ObjStorageManager objStorageManager;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
    }

    void clear() {
    }

    void iwfOpenBL() {
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();


        if (ISkCommonKoumoku.NODEID_KOKUTISYONYUURYOKU_1JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            uiBean.setSyoriKbn(E_SyoriKbn.NEWFIRST);
            kinouMode.setKinouMode(C_SkkinouModeIdKbn.KOKUTISYO_1JI.getValue());
        }
        else if (ISkCommonKoumoku.NODEID_KOKUTISYONYUURYOKU_2JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            uiBean.setSyoriKbn(E_SyoriKbn.NEWSECOND);
            kinouMode.setKinouMode(C_SkkinouModeIdKbn.KOKUTISYO_2JI.getValue());
        }
        else if (ISkCommonKoumoku.NODEID_KOKUTISYONYUURYOKU_3JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            uiBean.setSyoriKbn(E_SyoriKbn.NEWTHIRD);
            kinouMode.setKinouMode(C_SkkinouModeIdKbn.KOKUTISYO_3JI.getValue());
        }
        else {
            throw new BizLogicException(MessageId.EDF1001);
        }


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        uiBean.setMosno(bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getMosNo());

        doInputKey();

    }

    void pushAddFirstBL() {
        uiBean.setSyoriKbn(E_SyoriKbn.NEWFIRST);
        kinouMode.setKinouMode(C_SkkinouModeIdKbn.KOKUTISYO_1JI.getValue());
        doInputKey();
    }

    void pushAddSecondBL() {
        uiBean.setSyoriKbn(E_SyoriKbn.NEWSECOND);
        kinouMode.setKinouMode(C_SkkinouModeIdKbn.KOKUTISYO_2JI.getValue());
        doInputKey();
    }

    void pushAddThirdBL() {
        uiBean.setSyoriKbn(E_SyoriKbn.NEWTHIRD);
        kinouMode.setKinouMode(C_SkkinouModeIdKbn.KOKUTISYO_3JI.getValue());
        doInputKey();
    }

    void pushUpdBL() {
        uiBean.setSyoriKbn(E_SyoriKbn.MODIFY);
        kinouMode.setKinouMode(C_SkkinouModeIdKbn.KOKUTISYO_UPD.getValue());
        doInputKey();
    }

    void pushDelBL() {
        uiBean.setSyoriKbn(E_SyoriKbn.DELETE);
        kinouMode.setKinouMode(C_SkkinouModeIdKbn.KOKUTISYO_DEL.getValue());
        doInputKey();

        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QAC0010);
    }

    void pushKakuninBL() {
        continueLockProcess();


        if (BizUtil.isBlank(uiBean.getHbcmnt())) {
            if (uiBean.getKktymd() == null) {
                throw new BizLogicException(MessageId.EBC0045, DISP_KKTYMD);
            }

            if (uiBean.getSintyou() == null) {
                throw new BizLogicException(MessageId.EBC0045, DISP_SINTYOU);
            }

            if (uiBean.getTaijyuu() == null) {
                throw new BizLogicException(MessageId.EBC0045, DISP_TAIJYUU);
            }
        }


        if ((uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD)) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QAC0008);
        }
        else {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QHA0002);
        }

    }

    @Transactional
    void pushKakuteiBL() {

        HT_SyoriCTL syoriCtl = uiBean.getSyoriCTL();

        continueLockProcess();


        if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST) {
            if (BizUtil.isBlank(uiBean.getHbcmnt())) {
                insertKokutisyoVrf(syoriCtl);
                updateSyoriCTL(syoriCtl);
            }
            else {
                insertKokutisyo(syoriCtl);
                updateSyoriCTL(syoriCtl);
            }
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND) {
            if (BizUtil.isBlank(uiBean.getHbcmnt())) {
                insertKokutisyo(syoriCtl);

                SaiDataTouroku saiDataTouroku = SWAKInjector.getInstance(SaiDataTouroku.class);
                int NyuryokuSaiUmu = SaiDataTouroku.NRKSAINASI;

                NyuryokuSaiUmu = saiDataTouroku.registerSaiDataKokutisyo(
                    uiBean, baseUserInfo.getUserId(), BizDate.getSysDateTimeMilli());

                if (NyuryokuSaiUmu == SaiDataTouroku.NRKSAIARI) {
                    uiBean.setNyuryokuSaiUmu(C_UmuKbn.ARI);
                }

                updateSyoriCTL(syoriCtl);
            }
            else {
                insertKokutisyo(syoriCtl);
                updateSyoriCTL(syoriCtl);
            }
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD) {
            updateKokutisyo(syoriCtl);
            updateSyoriCTL(syoriCtl);
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.MODIFY) {
            tsRrkInfoTouroku.rgstrKokutisyo(
                uiBean,
                BizDate.getSysDateTimeMilli(),
                kinou.getKinouId(),
                C_SkkinouModeIdKbn.KOKUTISYO_UPD.getValue(),
                baseUserInfo.getUserId());

            updateKokutisyo(syoriCtl);
            updateSyoriCTL(syoriCtl);
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.DELETE) {
            deleteKokutisyo(syoriCtl);
            deleteKokutisyoVrf(syoriCtl);
            deleteNrkDif(syoriCtl);
            updateSyoriCTL(syoriCtl);
        }


        BT_GyoumuKouteiInfo gyoumuKouteiInfo =
            bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

        if (gyoumuKouteiInfo == null) {
            throw new CommonBizAppException(DISP_MOSNO + syoriCtl.getMosno());
        }


        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());
        mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
        mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());

        mosnaiCheckParam.debug(DISP_EXTRADESCIPTION);

        mosnaiCheck.exec(mosnaiCheckParam);

        if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
            sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
        }

        sinkeiyakuDomManager.update(syoriCtl);
        bizDomManager.update(gyoumuKouteiInfo);

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);


        ArrayList<String> hubiMsgs = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(uiBean.getMosno());

        uiBean.setHubimsgData(hubiMsgs.toArray(new String[hubiMsgs.size()]));

        skHubiMsgRenkeiInfo.setMosno(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgs);

        uiBean.setUniqueId(objStorageManager.save(skHubiMsgRenkeiInfo));


        StringBuffer gamenMsgStrBuffer = new StringBuffer();
        gamenMsgStrBuffer.append(MessageUtil.getMessage(MessageId.IAC0009 ));

        List<String> gamenMsgLst = mosnaiCheckParam.getListKekkaGmnMsg();

        for (String msg : gamenMsgLst) {
            gamenMsgStrBuffer.append(KAIGYOU);
            gamenMsgStrBuffer.append(msg);
        }

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), gamenMsgStrBuffer.toString());


        String kouteiLockKey = getKouteiLockKey();

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo(uiBean.getMosno());
        skProcessForwardInBean.setTskNm(uiBean.getVktifdisptasknm());
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);

        SkProcessForwardKokutisyoNyuuryoku skProcessForwardKokutisyoNyuuryoku =
            SWAKInjector.getInstance(SkProcessForwardKokutisyoNyuuryoku.class);

        skProcessForwardKokutisyoNyuuryoku.exec(skProcessForwardInBean);


        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCtl, kouteiLockKey, null);


        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        boolean idouHanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(mosnaiCheckParam.getDataSyoriControl(),
            uiBean.getSkIdounaiyouBeforeBean());

        if (idouHanteiKekka) {

            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean =
                skToujituIdounaiyouEdit.skIdounaiyouMQEdit(mosnaiCheckParam.getDataSyoriControl());

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                List<String> errorMsgLst = skIdounaiyouKekkaBean.getErrorMsgLst();
                for (String messageId : errorMsgLst) {
                    errorMessageCollector.addMessage(messageId);
                }
                errorMessageCollector.throwBizLogicException();
            }
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        unlockProcess();
    }

    String pushModoruBtnByInputcontentsBL() {
        unlockProcess();

        String sennyiSaki = BLANK;

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            sennyiSaki = FORWARDNAME_INIT;
        }
        else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            sennyiSaki = FORWARDNAME_BACKTOWORKLIST;
        }

        return sennyiSaki;
    }

    String pushmodoruBtnByConfirmBL() {
        String sennyiSaki = BLANK;


        if ((uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.MODIFY)) {

            continueLockProcess();
            sennyiSaki = FORWARDNAME_INPUTCONTENTS;
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.DELETE) {
            unlockProcess();
            sennyiSaki = FORWARDNAME_INIT;
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        return sennyiSaki;
    }

    String pushKinouNmLinkBL() {
        unlockProcess();

        String sennyiSaki = BLANK;

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            sennyiSaki = FORWARDNAME_INIT;
        }
        else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            sennyiSaki = FORWARDNAME_BACKTOWORKLIST;
        }

        return sennyiSaki;
    }

    String pushSyokiGamenhebtnBL() {
        String sennyiSaki = BLANK;

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            sennyiSaki = FORWARDNAME_INIT;
        }
        else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            sennyiSaki = FORWARDNAME_BACKTOWORKLIST;
        }

        return sennyiSaki;
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


    private void doInputKey() {
        BizPropertyInitializer.initialize(uiBean);

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        if (syoriCtl == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCtl);
        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        String taskId = null;
        if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST) {
            taskId = ISkCommonKoumoku.NODEID_KOKUTISYONYUURYOKU_1JI;
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND) {
            taskId = ISkCommonKoumoku.NODEID_KOKUTISYONYUURYOKU_2JI;
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD) {
            taskId = ISkCommonKoumoku.NODEID_KOKUTISYONYUURYOKU_3JI;
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.MODIFY) {
            taskId = ISkCommonKoumoku.NODEID_KOKUTISYONYUURYOKU_UPD;
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.DELETE) {
            taskId = ISkCommonKoumoku.NODEID_KOKUTISYONYUURYOKU_DEL;
        }

        uiBean.getBzWorkflowInfo().setKouteiKanriId(
            bzGetProcessSummaryOutBean.get(0).getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(
            bzGetProcessSummaryOutBean.get(0).getJimuTetuzukiCd());
        uiBean.getBzWorkflowInfo().setTaskId(taskId);


        if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND) {

            BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId(),
                baseUserInfo.getUserId());

            if (wariateHukaInfo != null) {
                throw new BizLogicException(MessageId.EHA0350);
            }
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD) {

            BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId(),
                baseUserInfo.getUserId());

            if (wariateHukaInfo != null) {
                throw new BizLogicException(MessageId.EHA1001);
            }
        }


        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        boolean kengenFlag = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouMode.getKinouMode());

        if (!kengenFlag) {
            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.getContentByValue(kinouMode.getKinouMode()));
        }

        if (uiBean.getSyoriKbn() == E_SyoriKbn.DELETE) {
            if (!BizUtil.isBlank(syoriCtl.getDaimosno())) {

                HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu(syoriCtl.getDaimosno());

                if (jigyouIkkatu == null) {
                    throw new CommonBizAppException(DISP_DAIHYOUMOSNO + syoriCtl.getDaimosno());
                }
                else if (C_UmuKbn.ARI.eq(jigyouIkkatu.getKktnrkumu())) {
                    throw new BizLogicException(MessageId.EHA0130);
                }
            }
        }
        else {
            if (!BizUtil.isBlank(syoriCtl.getDaimosno())) {
                throw new BizLogicException(MessageId.EHA0144);
            }
        }

        if ((uiBean.getSyoriKbn() != E_SyoriKbn.MODIFY) &&
            (uiBean.getSyoriKbn() != E_SyoriKbn.DELETE)) {

            if (!C_UmuKbn.ARI.eq(syoriCtl.getMosnrkumu())) {
                throw new BizLogicException(MessageId.EHA0027);
            }
        }

        if (!C_SeirituKbn.NONE.eq(syoriCtl.getSeiritukbn())) {
            throw new BizLogicException(MessageId.EBA0031, syoriCtl.getSeiritukbn().getContent());
        }

        if ((!C_KetteiKbn.NONE.eq(syoriCtl.getKetteikbn())) &&
            (!C_KetteiKbn.KETTEI_MATI.eq(syoriCtl.getKetteikbn()))) {

            throw new BizLogicException(MessageId.EBA0031, syoriCtl.getKetteikbn().getContent());
        }

        if ((uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND)) {

            HT_Kokutisyo kokutisyo = syoriCtl.getKokutisyo();

            if (kokutisyo != null) {
                throw new BizLogicException(MessageId.EHA0110);
            }
        }
        else if ((uiBean.getSyoriKbn() == E_SyoriKbn.MODIFY) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.DELETE)) {

            HT_Kokutisyo kokutisyo = syoriCtl.getKokutisyo();

            if (kokutisyo == null) {
                throw new BizLogicException(MessageId.EHA0111);
            }
        }

        if ((uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD)) {

            if (!C_UmuKbn.NONE.eq(syoriCtl.getKktnrkumu())) {
                throw new BizLogicException(MessageId.EHA0110);
            }
        }
        else if ((uiBean.getSyoriKbn() == E_SyoriKbn.MODIFY) ||
            (uiBean.getSyoriKbn() == E_SyoriKbn.DELETE)) {

            if ((C_UmuKbn.NONE.eq(syoriCtl.getKktnrkumu())) &&
                (C_UmuKbn.NONE.eq(syoriCtl.getKktnrkhbumu()))) {

                throw new BizLogicException(MessageId.EHA0111);
            }
        }

        boolean errFlag = false;

        if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST) {
            if (!C_VrfjkKbn.TSHN_MIJISSI.eq(syoriCtl.getKktnrkvrfjkkbn())) {
                errFlag = true;
            }
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND) {
            if (!C_VrfjkKbn.NIJINRKMATI.eq(syoriCtl.getKktnrkvrfjkkbn())) {
                errFlag = true;
            }
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD) {
            if (!C_VrfjkKbn.SANJINRKMATI.eq(syoriCtl.getKktnrkvrfjkkbn())) {
                errFlag = true;
            }
        }

        if (errFlag) {
            throw new BizLogicException(MessageId.EHA0349, syoriCtl.getKktnrkvrfjkkbn().getContent());
        }

        HT_MosKihon mosKihon = syoriCtl.getMosKihon();

        if (mosKihon == null) {
            throw new CommonBizAppException(DISP_MOSNO + uiBean.getMosno());
        }


        if ((uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST) &&
            (!C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn()))) {
            throw new BizLogicException(MessageId.EHA1011);
        }

        uiBean.setSyoriCTL(syoriCtl);

        setGamenKoumoku(syoriCtl, mosKihon);


        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getKouteiKanriId());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(
            uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);


        if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST ||
            uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND ||
            uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD ) {

            BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

            C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId(),
                getKouteiLockKey(),
                baseUserInfo.getUserId());

            if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
                throw new BizLogicException(MessageId.EBA0111);
            }
            else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
                throw new BizLogicException(MessageId.EBA0112);
            }
        }

        setAitemosnoWarning(syoriCtl.getMosnrkumu(), mosKihon.getAitemosno());
        setDoujikaiyakusyonoWarning(syoriCtl.getMosnrkumu(), mosKihon.getDoujikaiyakusyono());
    }

    private void setGamenKoumoku(HT_SyoriCTL pSyoriCtl, HT_MosKihon pMosKihon) {


        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);


        uiBean.setMosno(pSyoriCtl.getMosno());
        uiBean.setHhknnmkj(pMosKihon.getHhknnmkj());


        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);


        HT_Kokutisyo kokutisyo = pSyoriCtl.getKokutisyo();

        if (kokutisyo == null) {
            uiBean.setKktymd(null);
            uiBean.setSintyou(null);
            uiBean.setTaijyuu(null);
            uiBean.setKituenkbn(C_KituenKbn.BLNK);
            uiBean.setKituenhon(null);
            uiBean.setKijikbn(C_KijiKbn.NONE);
            uiBean.setKzkkijikbn(C_KzkkijiKbn.BLNK);
            uiBean.setHbcmntgamen(BLANK);
        }
        else {
            String hiraBun = EditSecurityKm.getDecodeData(pSyoriCtl.getMosno(), kokutisyo.getHbcmnt());

            if (kokutisyo.getSintyou().intValue() != 0) {
                uiBean.setSintyou(kokutisyo.getSintyou());
            }

            if (kokutisyo.getTaijyuu().intValue() != 0) {
                uiBean.setTaijyuu(kokutisyo.getTaijyuu());
            }

            if (kokutisyo.getKituenhon().intValue() != 0) {
                uiBean.setKituenhon(kokutisyo.getKituenhon());
            }

            uiBean.setKktymd(kokutisyo.getKktymd());
            uiBean.setKituenkbn(kokutisyo.getKituenkbn());
            uiBean.setKijikbn(kokutisyo.getKijikbn());
            uiBean.setKzkkijikbn(kokutisyo.getKzkkijikbn());
            uiBean.setHbcmntgamen(hiraBun);
        }


        if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD) {

            SaiDataSyutoku saiDataSyutoku = SWAKInjector.getInstance(SaiDataSyutoku.class);
            int syutokuDataUmu =  saiDataSyutoku.findSaiData(uiBean.getMosno(), ISkCommonKoumoku.VRFKINOUKBN_KOKUTISYO);

            if (syutokuDataUmu == SaiDataSyutoku.SYUTOKUDATA_NASI) {
                throw new CommonBizAppException(DISP_MOSNO + uiBean.getMosno());
            }

            uiBean.setNyuryokuSaiUmu(C_UmuKbn.ARI);

            SkNyuuryokuSaiSyoukaiRenkeiInfo skNyuuryokuSaiSyoukaiRenkeiInfo =
                SWAKInjector.getInstance(SkNyuuryokuSaiSyoukaiRenkeiInfo.class);

            List<String> nrksouikmLst = saiDataSyutoku.getNrksouikmList();
            List<String>  itijinrkLst = saiDataSyutoku.getItijinrkList();
            List<String> nijinrkLst = saiDataSyutoku.getNijinrkList();

            skNyuuryokuSaiSyoukaiRenkeiInfo.setNrksouikm(nrksouikmLst.toArray(new String[nrksouikmLst.size()]));
            skNyuuryokuSaiSyoukaiRenkeiInfo.setItijinrk(itijinrkLst.toArray(new String[itijinrkLst.size()]));
            skNyuuryokuSaiSyoukaiRenkeiInfo.setNijinrk(nijinrkLst.toArray(new String[nijinrkLst.size()]));

            uiBean.setUniqueId(objStorageManager.save(skNyuuryokuSaiSyoukaiRenkeiInfo));
        }
        else {
            uiBean.setNyuryokuSaiUmu(C_UmuKbn.NONE);
        }
    }


    private String getKouteiLockKey() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        return bzCommonLockProcess.getKouteiLockKey();
    }


    private void continueLockProcess() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }

    private void setAitemosnoWarning(C_UmuKbn pMosnrkUmu, String pAiteMosno) {

        int kekkaKbn = getMsgAitemosno.exec(pMosnrkUmu, pAiteMosno);

        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkaKbn) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid()),
                getMsgAitemosno.getS_gmmsg());
        }
    }

    private void setDoujikaiyakusyonoWarning(C_UmuKbn pMosnrkUmu, String pDoujikaiyakuSyono) {

        int kekkaKbn = getDoujikaiyakusyono.exec(pMosnrkUmu, pDoujikaiyakuSyono);

        if (GetMsgDoujikaiyakusyono.KEKKAKBN_ARI == kekkaKbn) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                BizUtil.getGeneralMessageId(getDoujikaiyakusyono.getS_gmmsgid()),
                getDoujikaiyakusyono.getS_gmmsg());
        }
    }

    private void insertKokutisyoVrf(HT_SyoriCTL pSyoriCTL) {

        HT_KokutisyoVrf kokutisyoVrf = pSyoriCTL.createKokutisyoVrf();

        String encode = EditSecurityKm.getEncodeData(pSyoriCTL.getMosno(), uiBean.getHbcmntgamen());


        kokutisyoVrf.setKktymd(uiBean.getKktymd());
        kokutisyoVrf.setSintyou(uiBean.getSintyou());
        kokutisyoVrf.setTaijyuu(uiBean.getTaijyuu());
        kokutisyoVrf.setKituenkbn(uiBean.getKituenkbn());
        kokutisyoVrf.setKituenhon(uiBean.getKituenhon());
        kokutisyoVrf.setKijikbn(uiBean.getKijikbn());
        kokutisyoVrf.setKzkkijikbn(uiBean.getKzkkijikbn());
        kokutisyoVrf.setHbcmnt(encode);
        kokutisyoVrf.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        kokutisyoVrf.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(kokutisyoVrf);
    }


    private void updateSyoriCTL(HT_SyoriCTL pSyoriCTL) {


        if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND) {
            if (BizUtil.isBlank(uiBean.getHbcmnt())) {
                if (C_UmuKbn.ARI.eq(uiBean.getNyuryokuSaiUmu())) {
                    pSyoriCTL.setKktnrkumu(C_UmuKbn.NONE);
                }
                else {
                    pSyoriCTL.setKktnrkumu(C_UmuKbn.ARI);
                }
            }
            else {
                pSyoriCTL.setKktnrkumu(C_UmuKbn.NONE);
            }
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD) {
            if (BizUtil.isBlank(uiBean.getHbcmnt())) {
                pSyoriCTL.setKktnrkumu(C_UmuKbn.ARI);
            }
            else {
                pSyoriCTL.setKktnrkumu(C_UmuKbn.NONE);
            }
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.MODIFY) {
            if (BizUtil.isBlank(uiBean.getHbcmnt())) {
                pSyoriCTL.setKktnrkumu(C_UmuKbn.ARI);
            }
            else {
                pSyoriCTL.setKktnrkumu(C_UmuKbn.NONE);
            }
        }
        else {
            pSyoriCTL.setKktnrkumu(C_UmuKbn.NONE);
        }


        if (!BizUtil.isBlank(uiBean.getHbcmnt())) {
            pSyoriCTL.setKktnrkhbumu(C_UmuKbn.ARI);
        }
        else {
            pSyoriCTL.setKktnrkhbumu(C_UmuKbn.NONE);
        }


        if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWFIRST) {
            if (BizUtil.isBlank(uiBean.getHbcmnt())) {
                pSyoriCTL.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
            }
            else {
                pSyoriCTL.setKktnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
            }
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWSECOND) {
            if (BizUtil.isBlank(uiBean.getHbcmnt())) {
                if (C_UmuKbn.ARI.eq(uiBean.getNyuryokuSaiUmu())) {
                    pSyoriCTL.setKktnrkvrfjkkbn(C_VrfjkKbn.SANJINRKMATI);
                }
                else {
                    pSyoriCTL.setKktnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
                }
            }
            else {
                pSyoriCTL.setKktnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
            }
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.NEWTHIRD ) {
            pSyoriCTL.setKktnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
        }
        else if (uiBean.getSyoriKbn() == E_SyoriKbn.DELETE) {
            pSyoriCTL.setKktnrkvrfjkkbn(C_VrfjkKbn.TSHN_MIJISSI);
        }

        pSyoriCTL.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        pSyoriCTL.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
    }

    private void insertKokutisyo(HT_SyoriCTL pSyoriCTL) {

        HT_Kokutisyo kokutisyo = pSyoriCTL.createKokutisyo();

        String encode = EditSecurityKm.getEncodeData(pSyoriCTL.getMosno(), uiBean.getHbcmntgamen());

        kokutisyo.setKktymd(uiBean.getKktymd());
        kokutisyo.setSintyou(uiBean.getSintyou());
        kokutisyo.setTaijyuu(uiBean.getTaijyuu());
        kokutisyo.setKituenkbn(uiBean.getKituenkbn());
        kokutisyo.setKituenhon(uiBean.getKituenhon());
        kokutisyo.setKijikbn(uiBean.getKijikbn());
        kokutisyo.setKzkkijikbn(uiBean.getKzkkijikbn());
        kokutisyo.setHbcmnt(encode);
        kokutisyo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        kokutisyo.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(kokutisyo);
    }


    private void updateKokutisyo(HT_SyoriCTL pSyoriCTL) {

        HT_Kokutisyo kokutisyo = pSyoriCTL.getKokutisyo();

        String encode = null;

        encode = EditSecurityKm.getEncodeData(pSyoriCTL.getMosno(), uiBean.getHbcmntgamen());

        kokutisyo.setKktymd(uiBean.getKktymd());
        kokutisyo.setSintyou(uiBean.getSintyou());
        kokutisyo.setTaijyuu(uiBean.getTaijyuu());
        kokutisyo.setKituenkbn(uiBean.getKituenkbn());
        kokutisyo.setKituenhon(uiBean.getKituenhon());
        kokutisyo.setKijikbn(uiBean.getKijikbn());
        kokutisyo.setKzkkijikbn(uiBean.getKzkkijikbn());
        kokutisyo.setHbcmnt(encode);
        kokutisyo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        kokutisyo.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(kokutisyo);
    }

    private void deleteKokutisyo(HT_SyoriCTL pSyoriCTL) {
        pSyoriCTL.setKokutisyo(null);
    }

    private void deleteKokutisyoVrf(HT_SyoriCTL pSyoriCTL) {
        pSyoriCTL.getKokutisyoVrfs().clear();
    }

    private void deleteNrkDif(HT_SyoriCTL pSyoriCTL) {
        List<HT_NrkDif> nrkDifLst = pSyoriCTL.getNrkDifs();

        nrkDifLst.removeAll(pSyoriCTL.getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_KOKUTISYO));
    }
}
