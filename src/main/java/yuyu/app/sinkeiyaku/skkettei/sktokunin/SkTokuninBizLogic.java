package yuyu.app.sinkeiyaku.skkettei.sktokunin;

import static yuyu.app.sinkeiyaku.skkettei.sktokunin.SkTokuninConstants.*;

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

import yuyu.app.sinkeiyaku.skkettei.sktokunin.SkTokuninConstants.E_SyoriKbn;
import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardTokunin;
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
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KzmeigitknKbn;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_NenreiuptknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteiriritutknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.collect.Lists;

/**
 * 特認処理 のビジネスロジックです。
 */
public class SkTokuninBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkTokuninUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager domManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private ObjStorageManager objStorageManager;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private BizDomManager bizDomManager;

    void init() {
    }

    void clear() {
    }

    void pushUpdBL() {

        BizPropertyInitializer.initialize(uiBean);

        String mosno = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = domManager.getSyoriCTL(mosno);

        if(syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        if (!C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {
            throw new BizLogicException(MessageId.EBA0031,syoriCTL.getSeiritukbn().getContent());
        }

        if (!(C_KetteiKbn.NONE.eq(syoriCTL.getKetteikbn())) && !(C_KetteiKbn.KETTEI_MATI.eq(syoriCTL.getKetteikbn()))){
            throw new BizLogicException(MessageId.EBA0031,syoriCTL.getKetteikbn().getContent());
        }

        if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu())){
            throw new BizLogicException(MessageId.EHA0027);
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException("申込番号 = "+ mosno);
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosno);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getKouteiKanriId());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        List<String> gmwarningIdLst = Lists.newArrayList();
        List<String> gmwarningLst = Lists.newArrayList();

        GetMsgAitemosno getMsgAitemosno = SWAKInjector.getInstance(GetMsgAitemosno.class);

        int kekkakbn = getMsgAitemosno.exec(syoriCTL.getMosnrkumu(), mosKihon.getAitemosno());

        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkakbn) {
            gmwarningIdLst.add(BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid()));
            gmwarningLst.add(getMsgAitemosno.getS_gmmsg());
        }
        uiBean.setGmwarningIdLst(gmwarningIdLst);
        uiBean.setGmwarningLst(gmwarningLst);

        uiBean.setHhknnmkj(mosKihon.getHhknnmkj());

        uiBean.setSyoriCTL(syoriCTL);

        HT_Tokunin tokunin = syoriCTL.getTokunin();
        if (tokunin != null){
            uiBean.setSpgndtknkbn(tokunin.getSpgndtknkbn());
            uiBean.setNenkkntknkbn(tokunin.getNenkkntknkbn());
            uiBean.setTsngndtknkbn(tokunin.getTsngndtknkbn());
            uiBean.setSentakuinfotknkbn(tokunin.getSentakuinfotknkbn());
            uiBean.setSignalkaihikbn(tokunin.getSignalkaihikbn());
            uiBean.setYoteiriritutknkbn(tokunin.getYoteiriritutknkbn());
            uiBean.setNenreiuptknkbn(tokunin.getNenreiuptknkbn());
            uiBean.setKzmeigitknkbn(tokunin.getKzmeigitknkbn());
            uiBean.setIkkatuyouptknkbn(tokunin.getIkkatuyouptknkbn());
            uiBean.setSonotatknkbn(tokunin.getSonotatknkbn());
            uiBean.setKakoymdkyytknkbn(tokunin.getKakoymdkyytknkbn());
            uiBean.setSaiteiptknkbn(tokunin.getSaiteiptknkbn());
            uiBean.setTokuninumukbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setSpgndtknkbn(C_SpgndtknKbn.NONE);
            uiBean.setNenkkntknkbn(C_NenkkntknKbn.NONE);
            uiBean.setTsngndtknkbn(C_TsngndtknKbn.NONE);
            uiBean.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
            uiBean.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
            uiBean.setYoteiriritutknkbn(C_YoteiriritutknKbn.NONE);
            uiBean.setNenreiuptknkbn(C_NenreiuptknKbn.NONE);
            uiBean.setKzmeigitknkbn(C_KzmeigitknKbn.NONE);
            uiBean.setIkkatuyouptknkbn(C_IkkatuyouptknKbn.NONE);
            uiBean.setSonotatknkbn(C_SonotaTokuninKbn.NONE);
            uiBean.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
            uiBean.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
            uiBean.setTokuninumukbn(C_UmuKbn.NONE);
        }

        addConversationMessage();

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));

    }

    void pushKakuninBL() {

        String mosno = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        if (syoriCTL == null) {
            throw new CommonBizAppException("申込番号=" + mosno);
        }

        boolean isTokuninAri = isTokuninAri();

        C_UmuKbn tokuninUmu = uiBean.getTokuninumukbn();

        if (isTokuninAri == false && C_UmuKbn.NONE.eq(tokuninUmu)){
            throw new BizLogicException(MessageId.EHA0088);
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (C_UmuKbn.NONE.eq(mosKihon.getIkkatuyoupumukbn())
            && !C_IkkatuyouptknKbn.NONE.eq(uiBean.getIkkatuyouptknkbn())) {
            throw new BizLogicException(MessageId.EHF1018);
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);
        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
            MessageId.QAC0008,
            MessageUtil.getMessage(MessageId.QAC0008));
    }

    void pushmodoruBtnByConfirmBL() {
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
        addConversationMessage();
    }

    @Transactional
    void pushKakuteiBL() {

        String userId = baseUserInfo.getUserId();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        String mosno = uiBean.getMosno();
        E_SyoriKbn syoriKbn = null;
        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();
        if (syoriCTL == null) {
            throw new CommonBizAppException("処理コントロールTBL該当データ無し 申込番号=" + mosno);
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException("申込基本TBL該当データ無し 申込番号=" + mosno);
        }

        boolean isTokuninAri = isTokuninAri();
        C_UmuKbn tokuninUmu = uiBean.getTokuninumukbn();

        if (isTokuninAri){
            if (C_UmuKbn.ARI.eq(tokuninUmu)){
                syoriKbn = E_SyoriKbn.UPD;
            }
            else {
                syoriKbn = E_SyoriKbn.NEW;
            }
        }
        else {
            syoriKbn = E_SyoriKbn.DEL;
        }

        HT_Tokunin tokunin;

        if (syoriKbn == E_SyoriKbn.DEL) {

            syoriCTL.setTokunin(null);
        }
        else if (syoriKbn == E_SyoriKbn.UPD) {

            tokunin = syoriCTL.getTokunin();
            makeInitRecordFromuiBeanforTokunin(tokunin);
            tokunin.setGyoumuKousinsyaId(userId);
            tokunin.setGyoumuKousinTime(sysDateTime);
        }
        else {

            tokunin = syoriCTL.createTokunin();
            makeInitRecordFromuiBeanforTokunin(tokunin);
            tokunin.setMosno(mosno);
            tokunin.setGyoumuKousinsyaId(userId);
            tokunin.setGyoumuKousinTime(sysDateTime);
            BizPropertyInitializer.initialize(tokunin);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = null;
        gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

        if (gyoumuKouteiInfo == null) {
            throw new CommonBizAppException("申込番号 = " + mosno);
        }

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());
        mosnaiCheckParam.setKosID(userId);
        mosnaiCheckParam.setKosTime(sysDateTime);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.debug("<<<<申込内容チェック実行前>>>>");

        mosnaiCheck.exec(mosnaiCheckParam);

        if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
            domManager.insert(mosnaiCheckParam.getListSkDenpyoData());
        }

        domManager.update(syoriCTL);

        bizDomManager.update(gyoumuKouteiInfo);

        HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
        if (mosnoKanri != null) {
            domManager.update(mosnoKanri);
        }
        List<String > hubiMsgList = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosno);
        uiBean.setHubimsgData(hubiMsgList.toArray(new String[0]));

        skHubiMsgRenkeiInfo.setMosno(mosno);
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgList);

        uiBean.setUniqueId(objStorageManager.save(skHubiMsgRenkeiInfo));

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        skProcessForwardInBean.setMosNo(mosno);
        skProcessForwardInBean.setTskNm("特認処理");
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("");

        SkProcessForwardTokunin skProcessForwardTokunin = SWAKInjector.getInstance(SkProcessForwardTokunin.class);
        skProcessForwardTokunin.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
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

        StringBuffer msgOut = new StringBuffer();
        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));
        List<String> msgList = mosnaiCheckParam.getListKekkaGmnMsg();
        for (String msg : msgList) {
            msgOut.append(KAIGYOU).append(msg);
        }
        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());

    }

    void doContinueLockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();
    }

    void doUnlockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }


    private void makeInitRecordFromuiBeanforTokunin(HT_Tokunin pTokunin) {

        pTokunin.setSpgndtknkbn(uiBean.getSpgndtknkbn());
        pTokunin.setNenkkntknkbn(uiBean.getNenkkntknkbn());
        pTokunin.setTsngndtknkbn(uiBean.getTsngndtknkbn());
        pTokunin.setSentakuinfotknkbn(uiBean.getSentakuinfotknkbn());
        pTokunin.setKakoymdkyytknkbn(uiBean.getKakoymdkyytknkbn());
        pTokunin.setSaiteiptknkbn(uiBean.getSaiteiptknkbn());
        pTokunin.setSignalkaihikbn(uiBean.getSignalkaihikbn());
        pTokunin.setYoteiriritutknkbn(uiBean.getYoteiriritutknkbn());
        pTokunin.setNenreiuptknkbn(uiBean.getNenreiuptknkbn());
        pTokunin.setKzmeigitknkbn(uiBean.getKzmeigitknkbn());
        pTokunin.setIkkatuyouptknkbn(uiBean.getIkkatuyouptknkbn());
        pTokunin.setSonotatknkbn(uiBean.getSonotatknkbn());
    }

    private  boolean isTokuninAri() {
        int kubunSum;
        kubunSum =
            Integer.valueOf(uiBean.getSpgndtknkbn().getValue()) +
            Integer.valueOf(uiBean.getNenkkntknkbn().getValue()) +
            Integer.valueOf(uiBean.getTsngndtknkbn().getValue()) +
            Integer.valueOf(uiBean.getSentakuinfotknkbn().getValue()) +
            Integer.valueOf(uiBean.getKakoymdkyytknkbn().getValue()) +
            Integer.valueOf(uiBean.getSaiteiptknkbn().getValue()) +
            Integer.valueOf(uiBean.getSignalkaihikbn().getValue()) +
            Integer.valueOf(uiBean.getYoteiriritutknkbn().getValue()) +
            Integer.valueOf(uiBean.getNenreiuptknkbn().getValue()) +
            Integer.valueOf(uiBean.getSonotatknkbn().getValue()) +
            Integer.valueOf(uiBean.getKzmeigitknkbn().getValue()) +
            Integer.valueOf(uiBean.getIkkatuyouptknkbn().getValue());

        return kubunSum != 0;
    }

    private void addConversationMessage() {

        List<String> gmwarningIdLst = uiBean.getGmwarningIdLst();
        if (gmwarningIdLst != null && gmwarningIdLst.size() > 0) {
            List<String> gmwarningLst = uiBean.getGmwarningLst();
            int index = 0;
            for (String gmwarningId : gmwarningIdLst) {
                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, gmwarningId,
                    gmwarningLst.get(index));
                index++;
            }
        }
    }
}
