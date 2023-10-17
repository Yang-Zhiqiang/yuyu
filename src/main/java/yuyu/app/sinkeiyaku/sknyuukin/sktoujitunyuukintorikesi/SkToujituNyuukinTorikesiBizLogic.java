package yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi;

import static yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi.SkToujituNyuukinTorikesiConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi.dba.SkToujituNyuukinTorikesiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMoschkExec;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_NyuukinHenkinSyoriKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.collect.Lists;

/**
 * 当日入金取消 のビジネスロジックです。
 */
public class SkToujituNyuukinTorikesiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkToujituNyuukinTorikesiUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkToujituNyuukinTorikesiDao skToujituNyuukinTorikesiDao;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private ObjStorageManager objStorageManager;

    void init() {
    }

    void clear() {
    }

    void pushTorikesiBL() {

        BizPropertyInitializer.initialize(uiBean);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) || C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
            throw new BizLogicException(MessageId.EBA0031, syoriCTL.getSeiritukbn().getContent());
        }

        if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu())) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
        getRsgakukei.getPkakinsumiRsgaku(syoriCTL, syoriCTL.getMosKihon().getHrktuukasyu());
        BizCurrency rsgakukei = getRsgakukei.getRsgakukei();

        if (rsgakukei.compareTo(BizCurrency.valueOf(0, rsgakukei.getType())) <= 0) {
            throw new BizLogicException(MessageId.EHA1079);
        }

        List<HT_Nyuukin> nyuukinLst = skToujituNyuukinTorikesiDao.getNyuukinTorikesiInfo(uiBean.getMosno(),
            BizDate.getSysDate(), C_ZenhnknKbn.BLNK, C_NyuukinHenkinSyoriKbn.NYUUKIN);

        if (nyuukinLst.size() == 0) {
            throw new BizLogicException(MessageId.EHA1079);
        }

        if (C_KykKbn.KEIHI_DOUITU.eq(syoriCTL.getMosKihon().getKykkbn())) {
            uiBean.setKyknmkj(syoriCTL.getMosKihon().getHhknnmkj());
        }
        else if (C_KykKbn.KEIHI_BETU.eq(syoriCTL.getMosKihon().getKykkbn())) {
            uiBean.setKyknmkj(syoriCTL.getMosKihon().getKyknmkj());
        }

        List<NyuukinJyouhouListDataSourceBean> dataSourceBeanLst = Lists.newArrayList();

        String sentakuLink = MessageUtil.getMessage(DDID_NYUUKINJYOUHOULIST_SENTAKULINK.getErrorResourceKey());

        for (HT_Nyuukin nyuukin : nyuukinLst) {
            NyuukinJyouhouListDataSourceBean dataSourceBean =
                SWAKInjector.getInstance(NyuukinJyouhouListDataSourceBean.class);

            dataSourceBean.setRsgaku(nyuukin.getRsgaku());
            dataSourceBean.setTyakkinymd(nyuukin.getTyakkinymd());
            dataSourceBean.setNyknsyubetu(nyuukin.getNyknsyubetu());
            dataSourceBean.setRenno(nyuukin.getRenno());
            dataSourceBean.setDenrenno(nyuukin.getDenrenno());
            dataSourceBean.setSentakulink(sentakuLink);

            dataSourceBeanLst.add(dataSourceBean);
        }

        uiBean.setNyuukinJyouhouList(dataSourceBeanLst);
        uiBean.setSyoriCTL(syoriCTL);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        List<BzGetProcessSummaryOutBean> summaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        bzCommonLockProcess.lockProcess(summaryOutBeanLst.get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);
    }

    void pushSentakuBL() {
        NyuukinJyouhouListDataSourceBean dataSourceBean = uiBean.getNyuukinJyouhouListDataSource().getSelectedBean();

        Integer torikesiRenno = dataSourceBean.getRenno();
        BizCurrency torikesiRsgaku = dataSourceBean.getRsgaku();
        String torikesiDenrenno = dataSourceBean.getDenrenno();

        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
        getRsgakukei.getPkakinsumiRsgaku(uiBean.getSyoriCTL(), uiBean.getSyoriCTL().getMosKihon().getHrktuukasyu());
        BizCurrency rsgakukei = getRsgakukei.getRsgakukei();

        if (rsgakukei.subtract(torikesiRsgaku).compareTo(BizCurrency.valueOf(0, rsgakukei.getType())) < 0) {
            List<HT_Henkin> henkinLst = uiBean.getSyoriCTL().getHenkinsByZenhnknrennos(0);
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(
                uiBean.getSyoriCTL().getMosKihon().getHrktuukasyu());
            BizCurrency hnkngkkukei = BizCurrency.valueOf(0, currencyType);

            if (henkinLst.size() > 0) {
                for (HT_Henkin henkin : henkinLst) {
                    hnkngkkukei = hnkngkkukei.add(henkin.getHnkngk());
                }
            }

            String viewhnkngk = ViewReport.editCommaTuuka(hnkngkkukei, BizUtil.ZERO_FILL);
            throw new BizLogicException(MessageId.EHA1080,viewhnkngk);
        }

        uiBean.setSentakuRenno(torikesiRenno);
        uiBean.setSentakuDenrenno(torikesiDenrenno);

        String sentakuMark = MessageUtil.getMessage(MessageId.IBC0006);
        dataSourceBean.setDummykmk(sentakuMark);

        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
            MessageId.QHA0016,
            MessageUtil.getMessage(MessageId.QHA0016));

    }

    @Transactional
    void pushKakuteiByConfirmBL() {
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        HT_Nyuukin nyuukin = syoriCTL.getNyuukinByRenno(uiBean.getSentakuRenno());

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();

        nyuukinLst.remove(nyuukin);

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno(
            uiBean.getSentakuDenrenno());

        sinkeiyakuDomManager.delete(skDenpyoDataLst);

        List<HT_Nyuukin> torikesiNyuukinLst = syoriCTL.getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn.SUMI);

        if (torikesiNyuukinLst.size() == 0) {
            syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);
        }
        else {
            GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);
            getRsgakukei.getHenkinsumiRsgaku(syoriCTL, syoriCTL.getMosKihon().getHrktuukasyu());
            BizCurrency rsGakukei = getRsgakukei.getRsgakukei();

            if (rsGakukei.compareTo(BizCurrency.valueOf(0, rsGakukei.getType())) == 0) {
                syoriCTL.setNyknnrkumu(C_UmuKbn.NONE);

                Integer maxZenhnknrenno = sinkeiyakuDomManager.getHenkinMaxZenhnknrenno(uiBean.getMosno());

                maxZenhnknrenno = maxZenhnknrenno + 1;

                for (HT_Nyuukin torikesiNyuukin : torikesiNyuukinLst) {
                    torikesiNyuukin.setZenhnknkbn(C_ZenhnknKbn.SUMI);
                    torikesiNyuukin.setZenhnknrenno(maxZenhnknrenno);
                    torikesiNyuukin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    torikesiNyuukin.setGyoumuKousinTime(sysDateTime);
                }

                List<HT_Henkin> henkinLst = syoriCTL.getHenkinsByZenhnknrennos(0);

                if (henkinLst.size() > 0) {
                    for (HT_Henkin henkin : henkinLst) {
                        henkin.setZenhnknrenno(maxZenhnknrenno);
                        henkin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        henkin.setGyoumuKousinTime(sysDateTime);
                    }
                }
            }
        }

        syoriCTL.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        syoriCTL.setGyoumuKousinTime(sysDateTime);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        BzGetProcessSummaryOutBean summaryOutBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(summaryOutBean.getKouteiKanriId());

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setSysDate(sysDate);
        mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
        mosnaiCheckParam.setKosTime(sysDateTime);

        mosnaiCheck.exec(mosnaiCheckParam);

        bizDomManager.update(gyoumuKouteiInfo);

        HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
        if (mosnoKanri != null) {
            sinkeiyakuDomManager.update(mosnoKanri);
        }

        if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
            sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
        }

        sinkeiyakuDomManager.update(syoriCTL);

        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

        bzOutputProcessRecord.exec(summaryOutBean.getKouteiKanriId(), summaryOutBean.getJimuTetuzukiCd(), null,
            kinou.getKinouNm(), C_SyorikekkaKbn.KANRYOU);

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        SkProcessForwardMoschkExec skProcessForwardMoschkExec = SWAKInjector.getInstance(
            SkProcessForwardMoschkExec.class);

        skProcessForwardInBean.setMosNo(uiBean.getMosno());
        skProcessForwardInBean.setTskNm(kinou.getKinouNm());
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,
            uiBean.getSkIdounaiyouBeforeBean());

        if (hanteiKekka) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                for (String errorMsgId : skIdounaiyouKekkaBean.getErrorMsgLst()) {
                    errorMessageCollector.addMessage(errorMsgId);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }

        ArrayList<String> hubiLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setMosno(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setHhknnmkj(syoriCTL.getMosKihon().getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiLst);

        String uniqueId = objStorageManager.save(skHubiMsgRenkeiInfo);
        uiBean.setUniqueId(uniqueId);

        uiBean.setHubiMsgDatas(hubiLst.toArray(new String[hubiLst.size()]));

        StringBuffer sbMsg = new StringBuffer();
        sbMsg.append(MessageUtil.getMessage(MessageId.IAC0009));

        List<String> kekkaGamenMsgLst = mosnaiCheckParam.getListKekkaGmnMsg();

        if (kekkaGamenMsgLst != null && !kekkaGamenMsgLst.isEmpty()) {
            for (String msg : kekkaGamenMsgLst) {
                sbMsg.append(KAIGYOU);
                sbMsg.append(msg);
            }
        }

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), sbMsg.toString());

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
    }

    void pushModoruBtnByConfirm() {
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
    }

    void pushContinueLockProcess() {

        bzCommonLockProcess.continueLockProcess();
    }

    void pushUnlockProcess() {

        bzCommonLockProcess.unlockProcess();
    }
}
