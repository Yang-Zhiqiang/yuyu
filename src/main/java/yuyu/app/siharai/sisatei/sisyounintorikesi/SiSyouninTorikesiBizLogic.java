package yuyu.app.siharai.sisatei.sisyounintorikesi;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakujyo;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceProcessForward;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.SetWariateHukaInfo;
import yuyu.common.siharai.edittbl.EditRrk;
import yuyu.common.siharai.edittbl.EditRrkTblBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.SiKinouModeSettei;
import yuyu.common.siharai.sicommon.SiSetUiBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.collect.Lists;

/**
 * 承認取消 のビジネスロジックです。
 */
public class SiSyouninTorikesiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiSyouninTorikesiUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private WorkflowDomManager workflowDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    void init() {
    }

    void clear() {
    }

    void pushFromSiTtzkRirekiSyoukai() {
        BizPropertyInitializer.initialize(uiBean);
        JT_SkKihon skKibon = siharaiDomManager.getSkKihon(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSkno(),
            uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono());
        JT_TtdkRireki ttdkRireki = skKibon.getTtdkRirekByTtdkrrkskbtkey(uiBean.getSiTtzkRirekiSyoukaiUiBean()
            .getDispttdkrrkskbtkey());
        uiBean.setSkno(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSkno());
        uiBean.setSyono(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono());
        uiBean.setYouhiKbn(C_YouhiKbn.YOU);
        AS_Kinou kinouNm = baseDomManager.getKinou(TeisuuSiharai.SITTZKRIREKISYOUKAI);
        uiBean.setKinouNm(kinouNm.getKinouNm());
        SiSetUiBean.setTtdkRireki(uiBean,ttdkRireki);
    }

    void pushKetteiBL() {
        BizPropertyInitializer.initialize(uiBean);

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        uiBean.setYouhiKbn(C_YouhiKbn.HUYOU);

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        keiyakuInfoSyutoku.getInfos(keiyakuPrm);
        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();
        if (siKykKihonLst.get(0) == null) {
            throw new BizLogicException(MessageId.EBA0024,MessageUtil.getMessage(MessageId.IJW1001));
        }
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setTaskIds(TeisuuSiharai.NODEID_SYOUNINTORIKESIS);
        bzGetProcessSummaryInBean.setSyoNo(uiBean.getSyono());
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        String skNo = "";
        String nowNodoId = "";
        String nowNodoNm = "";
        String jimuTetuzukiCd = "";
        String kouteiKanriId = "";
        C_ShrKekkaKbn shrKekkaKbn;
        C_SateiYouhiKbn sateiYouhiKbn;

        if (bzGetProcessSummaryOutBeanLst.size() == 0) {
            throw new BizLogicException(MessageId.EJA1003);
        }
        else{
            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst2 = Lists.newArrayList();
            for(int i = 0 ; i < bzGetProcessSummaryOutBeanLst.size() ; i++){
                if(TeisuuSiharai.JIMUTETUZUKICD_SISINDANSYORYOU.equals(bzGetProcessSummaryOutBeanLst.get(i).getJimuTetuzukiCd())){
                    continue;
                }else{
                    bzGetProcessSummaryOutBeanLst2.add((bzGetProcessSummaryOutBeanLst.get(i)));
                }
            }
            if(bzGetProcessSummaryOutBeanLst2.size() == 0){
                throw new BizLogicException(MessageId.EJA1003);
            }else if(bzGetProcessSummaryOutBeanLst2.size() > 1){
                throw new BizLogicException(MessageId.EJA1027);
            }
            else {
                skNo = bzGetProcessSummaryOutBeanLst2.get(0).getSkNo();
                nowNodoId = bzGetProcessSummaryOutBeanLst2.get(0).getNowNodoId();
                nowNodoNm = bzGetProcessSummaryOutBeanLst2.get(0).getNowNodoNm();
                jimuTetuzukiCd = bzGetProcessSummaryOutBeanLst2.get(0).getJimuTetuzukiCd();
                kouteiKanriId = bzGetProcessSummaryOutBeanLst2.get(0).getKouteiKanriId();
            }
            JT_SkKihon skKibon = siharaiDomManager.getSkKihon(skNo,uiBean.getSyono());
            if (skKibon == null) {
                throw new BizAppException(MessageId.EBS0005,"JT_SkKihon","skno",skNo,"syono",uiBean.getSyono());
            }
            if(skKibon.getSaigaihigaitoukbn().equals(C_SaigaiHigaitouKbn.SAIGAIHIGAITOU)) {
                List<JT_SiRireki> siRirekiLst = skKibon.getSiRirekis();
                if(siRirekiLst.size() != 0) {
                    BizDate sysDate = BizDate.getSysDate();
                    if(BizDateUtil.compareYmd(siRirekiLst.get(0).getShrsyoriymd(), sysDate) == BizDateUtil.COMPARE_LESSER) {
                        throw new BizLogicException(MessageId.EJA1038);
                    }
                }
            }
            shrKekkaKbn = skKibon.getShrkekkakbn();
            sateiYouhiKbn = skKibon.getSateiyhkbn();
            String backNodoId = "";
            if(skKibon.getSaigaihigaitoukbn().equals(C_SaigaiHigaitouKbn.SAIGAIHIGAITOU)) {
                backNodoId = TeisuuSiharai.NODEID_SYOUNIN_SATEIYOU;
            }
            else {
                if (TeisuuSiharai.NODEID_SISIHARAI.equals(nowNodoId)) {
                    if (C_ShrKekkaKbn.SHR.eq(shrKekkaKbn)) {
                        if (C_SateiYouhiKbn.YOU.eq(sateiYouhiKbn)) {
                            backNodoId = TeisuuSiharai.NODEID_SYOUNIN_SATEIYOU;
                        }
                        else if (C_SateiYouhiKbn.HUYOU.eq(sateiYouhiKbn)) {
                            backNodoId = TeisuuSiharai.NODEID_SYOUNIN_SATEIHUYOU;
                        }
                    }
                    else if (C_ShrKekkaKbn.HSHR.eq(shrKekkaKbn)) {
                        backNodoId = TeisuuSiharai.NODEID_SATEI1;
                    }
                }
                else if (TeisuuSiharai.NODEID_KAIKETU_SESSYOUYOU.equals(nowNodoId)) {
                    backNodoId = TeisuuSiharai.NODEID_SATEI1;
                }
                else if (TeisuuSiharai.NODEID_KAIKETU_SESSYOUHUYOU.equals(nowNodoId)) {
                    backNodoId = TeisuuSiharai.NODEID_SATEI1;
                }
                else if (TeisuuSiharai.NODEID_SESSYOU1.equals(nowNodoId)) {
                    backNodoId = TeisuuSiharai.NODEID_SATEI1;
                }
                else if (TeisuuSiharai.NODEID_SESSYOU2.equals(nowNodoId)) {
                    backNodoId = TeisuuSiharai.NODEID_SATEI1;
                }
                else {
                    throw new BizLogicException(MessageId.EJA1027);
                }
            }
            DM_Jimutetuzuki jimutetuzuki = workflowDomManager.getJimutetuzuki(jimuTetuzukiCd,
                TeisuuSiharai.SUBSYSTEMID_SIHARAI);
            DM_JimutetuzukiTask jimutetuzukiTask = jimutetuzuki.getJimutetuzukiTaskByWorkflowTskId(backNodoId);
            String backTaskNm = jimutetuzukiTask.getWorkflowTskNm();

            BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
            bzCommonLockProcess.lockProcess(kouteiKanriId, jimuTetuzukiCd);

            uiBean.setSkno(skNo);
            uiBean.setTsknm(nowNodoNm);
            uiBean.setSasimodositsknm(backTaskNm);
            uiBean.setJimutetuzukiCd(jimuTetuzukiCd);
            uiBean.setKouteikanriId(kouteiKanriId);
            uiBean.setNowNodoId(nowNodoId);
            uiBean.setBackNodoId(backNodoId);
            uiBean.setSkKihon(skKibon);
            uiBean.setKouteiLockKey(bzCommonLockProcess.getKouteiLockKey());
            SiSetUiBean.setHihokensya(uiBean, siKykKihonLst.get(0));
        }
    }

    void pushKakuninBL() {
        doContinueLockProcess();
        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {
        doContinueLockProcess();

        Integer shrsyoriSeikyuurirekino = Integer.valueOf("0");

        BizDate sysDate = BizDate.getSysDate();

        List<JT_SiDenpyoData> siDenpyoDataLst = siharaiDomManager.getSiDenpyoDatasBySyonoSyoriYmdSyoricd(uiBean.getSyono(),
            sysDate,TeisuuSiharai.SYORICD_SISINDANSYORYOU);
        if (siDenpyoDataLst.size() != 0) {
            siharaiDomManager.delete(siDenpyoDataLst);
        }

        List<JT_SiFBSoukinData> siFBSoukinDataLst = siharaiDomManager
            .getSiFBSoukinDatasBySyonoSyoriYmdSyoricd(uiBean.getSyono(),sysDate,TeisuuSiharai.SYORICD_SISINDANSYORYOU);
        if (siFBSoukinDataLst.size() != 0) {
            siharaiDomManager.delete(siFBSoukinDataLst);
        }

        List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = siharaiDomManager
            .getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd(uiBean.getSyono(),sysDate,TeisuuSiharai.SYORICD_SISINDANSYORYOU);
        if (siGaikaFBSoukinDataLst.size() != 0) {
            siharaiDomManager.delete(siGaikaFBSoukinDataLst);
        }

        JT_SkKihon skKihon = uiBean.getSkKihon();
        skKihon.setShrkekkakbn(C_ShrKekkaKbn.BLNK);
        skKihon.setGaibuinsatuoutymd(null);
        skKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        skKihon.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        List<JT_SiRireki> siRirekiLst = skKihon.getSiRirekis();
        if (siRirekiLst.size() != 0) {
            shrsyoriSeikyuurirekino = siRirekiLst.get(0).getSeikyuurirekino();
            siRirekiLst.clear();
        }

        if (!Integer.valueOf("0").equals(shrsyoriSeikyuurirekino)) {
            JT_SiDshrTuki siDshrTuki = siharaiDomManager.getSiDshrTukiBySyonoSknoRirekino(uiBean.getSyono(),
                uiBean.getSkno(), shrsyoriSeikyuurirekino);
            if (siDshrTuki != null) {
                siharaiDomManager.delete(siDshrTuki);
            }
        }

        if (!Integer.valueOf("0").equals(shrsyoriSeikyuurirekino)) {
            BzSikinIdouRirekiTblSakujyo bzSikinIdouRirekiTblSakujyo = SWAKInjector.getInstance(BzSikinIdouRirekiTblSakujyo.class);
            bzSikinIdouRirekiTblSakujyo.trksHkkData(uiBean.getSyono(), uiBean.getSkno(), shrsyoriSeikyuurirekino);
        }

        int seikyuurirekiNo = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(uiBean.getSkno(),uiBean.getSyono());
        EditRrkTblBean editRrkTbBean = SWAKInjector.getInstance(EditRrkTblBean.class);
        editRrkTbBean.setSeiNo(uiBean.getSkno());
        editRrkTbBean.setSyoNo(uiBean.getSyono());
        editRrkTbBean.setSyoriYmd(sysDate);
        editRrkTbBean.setJimKakuteiUmuKbn(C_JimukakuteiKbn.KAKUTEI);
        editRrkTbBean.setSeiRrkNo(seikyuurirekiNo);
        EditRrk editRrk = SWAKInjector.getInstance(EditRrk.class);
        JT_TtdkRireki ttdkRireki = skKihon.createTtdkRireki();
        BeanUtil.copyProperties(ttdkRireki, editRrk.makeTtdkRrk(uiBean, editRrkTbBean).getTtdkRireki());
        BizPropertyInitializer.initialize(ttdkRireki);

        siharaiDomManager.update(skKihon);

        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);
        bzOutputProcessRecord.exec(uiBean.getKouteikanriId(), uiBean.getJimutetuzukiCd(),uiBean.getSyanaicomment(), kinou.getKinouNm(), C_SyorikekkaKbn.BLNK);
        BzForceProcessForward bzForceProcessForward = SWAKInjector.getInstance(BzForceProcessForward.class);
        bzForceProcessForward.exec(uiBean.getKouteikanriId(), uiBean.getJimutetuzukiCd(), uiBean.getBackNodoId(),
            uiBean.getKouteiLockKey());

        SetWariateHukaInfo setWariateHukaInfo = SWAKInjector.getInstance(SetWariateHukaInfo.class);
        setWariateHukaInfo.exec(uiBean.getKouteikanriId(),
            TeisuuSiharai.SUBSYSTEMID_SIHARAI,
            TeisuuSiharai.JIMUTETUZUKICD_SISIBOU,
            uiBean.getNowNodoId(),
            uiBean.getBackNodoId());

        doUnlockProcess();

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void doUnlockProcess() {
        if (SiSyouninTorikesiConstants.PAGENO_INPUTCONTENTS  == uiBean.getPageNo()
            || SiSyouninTorikesiConstants.PAGENO_CONFIRM  == uiBean.getPageNo()) {
            BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
            bzCommonLockProcess.unlockProcess();
        }
    }

    void doContinueLockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }
}
