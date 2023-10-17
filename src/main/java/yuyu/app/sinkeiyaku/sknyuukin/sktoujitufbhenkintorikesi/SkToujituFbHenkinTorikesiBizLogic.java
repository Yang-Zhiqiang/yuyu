package yuyu.app.sinkeiyaku.sknyuukin.sktoujitufbhenkintorikesi;

import static yuyu.app.sinkeiyaku.sknyuukin.sktoujitufbhenkintorikesi.SkToujituFbHenkinTorikesiConstants.*;

import java.util.ArrayList;
import java.util.HashSet;
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
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMoschkExec;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_Henkin;

import com.google.common.collect.Lists;

/**
 * 当日ＦＢ返金取消 のビジネスロジックです
 */
public class SkToujituFbHenkinTorikesiBizLogic {

    @Inject
    private SkToujituFbHenkinTorikesiUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private SortHT_Henkin sortHT_Henkin;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
    }

    void clear() {
    }

    void pushKakuteByInputkeyBL() {

        BizPropertyInitializer.initialize(uiBean);

        String mosNo = uiBean.getMosno();


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setSyoriCTL(syoriCTL);


        List<HT_Henkin> henkinLst = new ArrayList<HT_Henkin>(
            syoriCTL.getHenkinsByHnknsyoriymdHnknhoukbns(
                BizDate.getSysDate(), C_HnknhouKbn.KOUZASITEI, C_HnknhouKbn.PHURIKZ));

        henkinLst = sortHT_Henkin.OrderHT_HenkinByHnkninputrennoAsc(henkinLst);

        if (henkinLst.isEmpty()) {
            throw new BizLogicException(MessageId.EHA0405);
        }


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBean.size() > 0) {
            bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBean.get(0).getKouteiKanriId(),
                ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        }

        List<HenkinJyouhouListDataSourceBean> henkinJyouhouLst = Lists.newArrayList();

        String sentakuLink = MessageUtil.getMessage(
            SkToujituFbHenkinTorikesiConstants.DDID_HENKINJYOUHOULIST_SENTAKULINK.getErrorResourceKey());
        BizCurrency hnkngk = BizCurrency.valueOf(0);
        HT_Henkin zenkaiHenkin = null;

        for (HT_Henkin henkin : henkinLst) {
            if (zenkaiHenkin == null || zenkaiHenkin.getHnkninputrenno().equals(henkin.getHnkninputrenno())) {
                if (BizUtil.isZero(hnkngk)) {
                    hnkngk = henkin.getHnkngk();
                }
                else {
                    hnkngk = hnkngk.add(henkin.getHnkngk());
                }
            }
            else {
                addHenkinList(henkinJyouhouLst, zenkaiHenkin, hnkngk, sentakuLink);
                hnkngk = henkin.getHnkngk();
            }

            zenkaiHenkin = henkin;
        }

        addHenkinList(henkinJyouhouLst, zenkaiHenkin, hnkngk, sentakuLink);


        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        String hhknNmkj;

        if (mosKihon == null) {
            hhknNmkj = "";
        }
        else {
            hhknNmkj = mosKihon.getHhknnmkj();

            int kekkaKbn = getMsgAitemosno.exec(syoriCTL.getMosnrkumu(), mosKihon.getAitemosno());
            if (GetMsgAitemosno.KEKKAKBN_ARI == kekkaKbn) {

                String messageId = BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid());
                uiBean.setGmMsgId(messageId);
                String gmmsg = getMsgAitemosno.getS_gmmsg();
                uiBean.setGmMsg(gmmsg);

                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, messageId, gmmsg);
            }
        }

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));

        uiBean.setHhknnmkj(hhknNmkj);
        uiBean.setHenkinJyouhouList(henkinJyouhouLst);
    }

    void pushSentakuBL() {

        HenkinJyouhouListDataSourceBean henkinJyouhouListDSBean = uiBean.getHenkinJyouhouListDataSource().getSelectedBean();

        BizCurrency hnknkngk = henkinJyouhouListDSBean.getDisphnkngk();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        C_Tuukasyu hnkntuukasyu = henkanTuuka.henkanTuukaTypeToKbn(hnknkngk.getType());

        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
        getRsgakukei.getHenkinsumiRsgaku(uiBean.getSyoriCTL());
        BizCurrency rsGakukei = getRsgakukei.getRsgakukei();
        C_Tuukasyu jsiTuuKasyu = getRsgakukei.getTuukasyu();

        C_Tuukasyu hrktuukasyu = uiBean.getSyoriCTL().getMosKihon().getHrktuukasyu();

        if (!hrktuukasyu.eq(hnkntuukasyu)) {
            throw new BizLogicException(MessageId.EHA1010, ERRMSG_MOSINFO);
        }

        if (!BizUtil.isZero(rsGakukei)) {
            if (!jsiTuuKasyu.eq(hnkntuukasyu)) {
                throw new BizLogicException(MessageId.EHA1010, ERRMSG_HNKNNYKJH);
            }
        }

        String sentakuMark = MessageUtil.getMessage(MessageId.IBC0006);
        henkinJyouhouListDSBean.setDummykmk(sentakuMark);

        uiBean.setHnknInputRenNo(henkinJyouhouListDSBean.getHnknInputRenNo());

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);

        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
            MessageId.QHA0016,
            MessageUtil.getMessage(MessageId.QHA0016));
    }

    @Transactional
    void pushKakuteiByConfirmBL() {

        String mosNo = uiBean.getMosno();
        String hnknInputRenno = uiBean.getHnknInputRenNo();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();
        String sysTime = BizDate.getSysDateTimeMilli();


        List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByHnkninputrenno(hnknInputRenno);

        if (henkinLst.size() == 0) {
            throw new CommonBizAppException(ERRMSG_MOSNO + mosNo);
        }


        if (henkinLst.get(0).getZenhnknrenno() != 0) {

            List<HT_Henkin> updateHenkinLst = syoriCTL.getHenkinsByHnknsyoriymdHnkntuukasyuZenhenrennoNe(
                BizDate.getSysDate(), uiBean.getSyoriCTL().getMosKihon().getHrktuukasyu(), 0);

            HashSet<Integer> zenhnknrennoList = new HashSet<>();
            for (HT_Henkin henkin : updateHenkinLst) {

                zenhnknrennoList.add(henkin.getZenhnknrenno());
            }

            List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukinsByZenhnknrennos(zenhnknrennoList.toArray(new Integer[]{}));

            updateHenkinLst = syoriCTL.getHenkinsByZenhnknrennos(zenhnknrennoList.toArray(new Integer[]{}));

            for (HT_Nyuukin nyuukin : nyuukinLst) {

                nyuukin.setZenhnknkbn(C_ZenhnknKbn.BLNK);
                nyuukin.setZenhnknrenno(0);
                nyuukin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                nyuukin.setGyoumuKousinTime(sysTime);
            }

            for (HT_Henkin henkin : updateHenkinLst) {

                henkin.setZenhnknrenno(0);
                henkin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                henkin.setGyoumuKousinTime(sysTime);
            }
        }


        for (HT_Henkin henkin : henkinLst) {
            C_Tuukasyu hnknTuukasyu = henkin.getHnkntuukasyu();

            if (C_Tuukasyu.JPY.eq(hnknTuukasyu)) {
                HT_SkFBSoukinData skFBSoukinData = sinkeiyakuDomManager.getSkFBSoukinData(henkin.getFbsoukindatasikibetukey());


                List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno(
                    skFBSoukinData.getDenrenno());

                if (skDenpyoDataLst.size() == 0) {
                    throw new CommonBizAppException(ERRMSG_MOSNO + mosNo);
                }
                sinkeiyakuDomManager.delete(skDenpyoDataLst);

                sinkeiyakuDomManager.delete(skFBSoukinData);
            }
            else {
                HT_SkGaikaFBSoukinData skGaikaFBSoukinData =
                    sinkeiyakuDomManager.getSkGaikaFBSoukinData(henkin.getFbsoukindatasikibetukey());


                List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno(
                    skGaikaFBSoukinData.getDenrenno());

                if (skDenpyoDataLst.size() == 0) {
                    throw new CommonBizAppException(ERRMSG_MOSNO + mosNo);
                }
                sinkeiyakuDomManager.delete(skDenpyoDataLst);

                sinkeiyakuDomManager.delete(skGaikaFBSoukinData);
            }


            List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno(henkin.getDenrenno());

            if (skDenpyoDataLst.size() == 0) {
                throw new CommonBizAppException(ERRMSG_MOSNO + mosNo);
            }

            sinkeiyakuDomManager.delete(skDenpyoDataLst);


            henkin.setHnkninputrenno("");
            henkin.setHnknsyoriymd(null);
            henkin.setHenkinsyoritime("");
            henkin.setHnknhoukbn(C_HnknhouKbn.BLNK);
            henkin.setHnknymd(null);
            henkin.setBankcd("");
            henkin.setSitencd("");
            henkin.setYokinkbn(C_YokinKbn.BLNK);
            henkin.setKouzano("");
            henkin.setKzmeiginmkn("");
            henkin.setDenrenno("");
            henkin.setEdano(0);
            henkin.setFbsoukindatasikibetukey("");
            henkin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            henkin.setGyoumuKousinTime(sysTime);
        }


        syoriCTL.setNyknnrkumu(C_UmuKbn.ARI);


        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        if (C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn()) || C_SeirituKbn.ITIPMATI.eq(syoriCTL.getSeiritukbn())) {

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(mosNo);

            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
                bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getKouteiKanriId());

            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
            mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setSysDate(BizDate.getSysDate());
            mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
            mosnaiCheckParam.setKosTime(sysTime);

            MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
            mosnaiCheck.exec(mosnaiCheckParam);

            bizDomManager.update(gyoumuKouteiInfo);

            HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
            if (mosnoKanri != null) {
                sinkeiyakuDomManager.update(mosnoKanri);
            }

            if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
                sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
            }
        }
        else {
            syoriCTL.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            syoriCTL.setGyoumuKousinTime(sysTime);
        }

        sinkeiyakuDomManager.update(syoriCTL);

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList.size() != 0) {

            SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
            skProcessForwardInBean.setMosNo(mosNo);
            skProcessForwardInBean.setTskNm(kinou.getKinouNm());
            skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
            skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
            skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.YOU);

            SkProcessForwardMoschkExec skProcessForwardMoschkExec = SWAKInjector.getInstance(SkProcessForwardMoschkExec.class);
            skProcessForwardMoschkExec.exec(skProcessForwardInBean);
        }
        else {
            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setSyoNo(syoriCTL.getSyono());
            bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanList.size() != 0) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

                bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
                    bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
                    null,
                    kinou.getKinouNm(),
                    C_SyorikekkaKbn.KANRYOU);
            }
        }

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);


        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, uiBean.getSkIdounaiyouBeforeBean());

        if (hanteiKekka) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                for (String errorMsgId : skIdounaiyouKekkaBean.getErrorMsgLst()) {
                    errorMessageCollector.addMessage(errorMsgId);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        uiBean.setGmMsg(null);
        uiBean.setGmMsgId(null);

        StringBuffer msgOut = new StringBuffer();
        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));

        List<String> msgList = mosnaiCheckParam.getListKekkaGmnMsg();
        if (msgList != null) {
            for (String msg : msgList) {
                msgOut.append(MessageUtil.getMessage(MessageId.IAW0006));
                msgOut.append(msg);
            }
        }
        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());
    }

    void pushModoruByConfirmBL() {


        List<HenkinJyouhouListDataSourceBean> henkinJyouhouLst = uiBean.getHenkinJyouhouListDataSource().getAllData();
        for (HenkinJyouhouListDataSourceBean henkinJyouhouListDataSourceBean : henkinJyouhouLst) {
            henkinJyouhouListDataSourceBean.setDummykmk("");
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        if (!BizUtil.isBlank(uiBean.getGmMsg())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                uiBean.getGmMsgId(), uiBean.getGmMsg());
        }
    }

    void continueLockProcess() {

        bzCommonLockProcess.continueLockProcess();
    }

    void unlockProcess() {

        bzCommonLockProcess.unlockProcess();
    }


    private void addHenkinList(List<HenkinJyouhouListDataSourceBean> pHenkinJyouhouLst, HT_Henkin pHenkin,
        BizCurrency pHnkngk, String pSentakuLink) {

        String bankName = "";
        String sitenName = "";

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pHenkin.getBankcd(), pHenkin.getSitencd(), null);

        if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {
            bankName = bzGetBankDataBean.getBankNmKj();
            sitenName = bzGetBankDataBean.getSitenNmKj();
        }

        HenkinJyouhouListDataSourceBean henkinJyouhouListDataSourceBean =
            SWAKInjector.getInstance(HenkinJyouhouListDataSourceBean.class);

        henkinJyouhouListDataSourceBean.setHnknInputRenNo(pHenkin.getHnkninputrenno());
        henkinJyouhouListDataSourceBean.setDisphnkngk(pHnkngk);
        henkinJyouhouListDataSourceBean.setDisphnknymd(pHenkin.getHnknymd());
        henkinJyouhouListDataSourceBean.setDisphnknhoukbn(pHenkin.getHnknhoukbn());
        henkinJyouhouListDataSourceBean.setDispsrgohnknumu(pHenkin.getSrgohnknumu());
        henkinJyouhouListDataSourceBean.setDispbankcd(pHenkin.getBankcd());
        henkinJyouhouListDataSourceBean.setDispbanknmkj(bankName);
        henkinJyouhouListDataSourceBean.setDispsitencd(pHenkin.getSitencd());
        henkinJyouhouListDataSourceBean.setDispsitennmkj(sitenName);
        henkinJyouhouListDataSourceBean.setDispyokinkbn(pHenkin.getYokinkbn());
        henkinJyouhouListDataSourceBean.setDispkouzano(pHenkin.getKouzano());
        henkinJyouhouListDataSourceBean.setDispkzmeiginmkn(pHenkin.getKzmeiginmkn());
        henkinJyouhouListDataSourceBean.setSentakulink(pSentakuLink);

        pHenkinJyouhouLst.add(henkinJyouhouListDataSourceBean);
    }
}
