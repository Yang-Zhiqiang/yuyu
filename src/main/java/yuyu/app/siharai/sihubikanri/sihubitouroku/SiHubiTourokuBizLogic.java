package yuyu.app.siharai.sihubikanri.sihubitouroku;

import static yuyu.app.siharai.sihubikanri.sihubitouroku.GenSiHubiTourokuConstants.*;
import static yuyu.app.siharai.sihubikanri.sihubitouroku.SiHubiTourokuConstants.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzCommonLockProcessBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryComparatorWorkListHyoujijun;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessOutBean;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.koutei.GetSyoriOyakouteiInfo;
import yuyu.common.biz.koutei.GetSyoriOyakouteiInfoOutBean;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.siharai.koutei.SiProcessForward;
import yuyu.common.siharai.koutei.SiRuleBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.prereport.SiharaiPreReportRenkeiBean;
import yuyu.common.siharai.sicommon.SiKinouModeSettei;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.siharai.siedittyouhyou.EditHubiTeiseisyo;
import yuyu.common.siharai.siedittyouhyou.EditHubiTeiseisyoBean;
import yuyu.common.siharai.siedittyouhyou.EditHubiTeiseisyoItiranBean;
import yuyu.common.siharai.siedittyouhyou.EditHubiteiseisyosouhuannai;
import yuyu.common.siharai.siedittyouhyou.EditHubiteiseisyosouhuannaiBean;
import yuyu.common.siharai.siedittyouhyou.HubiTeiseisyoBean;
import yuyu.common.siharai.siedittyouhyou.SeikyuusyaInfoBean;
import yuyu.common.siharai.siedittyouhyou.SiTyouhyouHensyuuCommonBean;
import yuyu.common.siharai.siedittyouhyou.ToiawaseInfoBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdBean;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JW_HubiDetailWk;
import yuyu.def.db.entity.JW_HubiWk;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SiHubiDetail;
import yuyu.def.siharai.sorter.SortJW_HubiDetailWk;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 保険金給付金不備登録 のビジネスロジックです。
 */
public class SiHubiTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiHubiTourokuUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SiharaiPreReportRenkeiBean siharaiPreReportRenkeiBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BzLockProcess bzLockProcess;

    @Inject
    private BzUnlockProcess bzUnlockProcess;

    @Inject
    private BzCommonLockProcessBean bzCommonLockProcessBean;

    void init() {
    }

    void clear() {
    }

    String pushTourokuBL() {

        String forwardName = getForwardNameInput(false,C_UmuKbn.NONE);
        return forwardName;

    }

    String pushHbtrbtnOnClickBL(){

        String forwardName = getForwardNameInput(true,C_UmuKbn.NONE);
        return forwardName;

    }

    @Transactional
    String pushFromSiharaiWorkListBL(){

        BizPropertyInitializer.initialize(uiBean);

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        GetSyoriOyakouteiInfo getSyoriOyakouteiInfo = SWAKInjector.getInstance(GetSyoriOyakouteiInfo.class);
        GetSyoriOyakouteiInfoOutBean outBean = getSyoriOyakouteiInfo.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(outBean.getSyoriOyaKouteikanriId());
        uiBean.getBzWorkflowInfo().setOyaKouteiJimuTetuzukiCd(outBean.getSyoriOyaKouteiJimutetuzukiCd());

        BzCommonLockProcess lockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        lockProcess.lockProcess(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());
        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(), uiBean.getBzWorkflowInfo().getTaskId(),
            lockProcess.getKouteiLockKey());
        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        keiyakuInfoSyutoku();

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        summaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        summaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        summaryInBean.setSubSystemId(kinou.getSubSystemId());
        List<BzGetProcessSummaryOutBean> outBeanList = bzGetProcessSummary.exec(summaryInBean);

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(gyoumuKouteiInfo.getSkno(), gyoumuKouteiInfo.getSyono());
        if (skKihon == null) {
            throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1031));
        }

        uiBean.setSkKihon(skKihon);
        uiBean.setHubiSikibetuKey(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
        uiBean.setJimuTetuzukiCd(outBeanList.get(0).getJimuTetuzukiCd());
        uiBean.setVktifdispjimutetuzukinm(outBeanList.get(0).getJimuTetuzukiNm());
        uiBean.setSkno(outBeanList.get(0).getSkNo());
        uiBean.setItiranKeiyuUmuKbn(C_UmuKbn.NONE);

        naiyougamenInfoGetset(outBeanList);

        return FORWARDNAME_INPUTCONTENTS;
    }

    String pushInputBL() {

        String forwardName = getForwardNameInput(false,C_UmuKbn.ARI);
        return forwardName;

    }

    String pushModoruByInputContentsBL(){

        if (uiBean.isTagamenKidouHanteiFlg()) {
            return FORWARDNAME_INIT;
        }else{
            pushUnlockProcessBL();
        }

        if (uiBean.getItiranKeiyuUmuKbn().eq(C_UmuKbn.ARI)){
            for (MihasinhubiListDataSourceBean listBean : uiBean.getMihasinhubiListDataSource().getAllData()) {
                listBean.setDisptrkymd(null);
                listBean.setDispsyoruicd(C_SyoruiCdKbn.BLNK);
                listBean.setDisphubisyoruinm("");
                listBean.setHubinaiyoucd("");
                listBean.setDisphubinaiyoumsg("");
                listBean.setDispgenponhnkykumuchkbox(false);
                listBean.setDisphassinymd(null);
                listBean.setDisphassinsakikbn(C_HassinsakiKbn.BLNK);
                listBean.setDispHubiTourokuTantouId("");
                listBean.setDispnyuryokutantounm("");
                listBean.setDispHubiSyouninnTantouId("");
                listBean.setDispsyounintantounm("");
                listBean.setSakujyoLink("");
            }
            uiBean.setSisyacd("");
            uiBean.setRenrakusakinmkj("");
            uiBean.setTsinyno("");
            uiBean.setTsinadr1kj("");
            uiBean.setTsinadr2kj("");
            uiBean.setTsinadr3kj("");
            uiBean.setRenrakuarea("");
            uiBean.setToiawasesosikinmkj("");
            uiBean.setToiawasetelno("");
            uiBean.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
            uiBean.setTennousakisousasyacdOptionBeanList(new UserDefsList());
            uiBean.setSyanaicomment("");

            return FORWARDNAME_SELECTDATA;
        }
        if (uiBean.isKidougmKbnWorkListSeigyo()) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;

    }

    String pushKakuninBL(){

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        if(uiBean.isTagamenKidouHanteiFlg()){
            bzCommonLockProcessBean.setKouteiLockKey(uiBean.getKouteilockkey());
            bzCommonLockProcessBean.setLockTsyuKouteiKanriId(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
            bzCommonLockProcessBean.setLockTsyuJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());
        }

        bzCommonLockProcess.continueLockProcess();

        chkInput(false);

        messageManager.addMessageId(MessageId.QBA0001);

        return FORWARDNAME_CONFIRM;
    }

    @Transactional
    String pushKarisakuseiBL(){

        chkInput(true);

        uiBean.setKarisakuseiTyouhyouJoinKey(hubiTyouhyouSakusei(true, BizDate.getSysDate()));

        setMihasinhubi(uiBean);

        return FORWARDNAME_INPUTCONTENTS;
    }

    String pushModoruBtnByConfirmBL(){

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        setMihasinhubi(uiBean);
        messageManager.removeConversationMessage(NPUTCONTENTS_WARNINF);

        return FORWARDNAME_INPUTCONTENTS;
    }

    @Transactional
    String pushKakuteiBL(){

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        String wkKouteiLockKey = "";
        if(uiBean.isTagamenKidouHanteiFlg()){
            wkKouteiLockKey = uiBean.getKouteilockkey();
        }else{
            wkKouteiLockKey = bzCommonLockProcess.getKouteiLockKey();
        }

        BizDate sysDate = BizDate.getSysDate();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        if (C_SikinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
                JT_SiHubi siHubi = new JT_SiHubi();
                if (siharaiDomManager.getSiHubi(uiBean.getHubiSikibetuKey()) == null) {
                    siHubi.setHubisikibetukey(uiBean.getHubiSikibetuKey());
                    siHubi.setSyono(uiBean.getSyono());
                    siHubi.setJimutetuzukinm(uiBean.getVktifdispjimutetuzukinm());
                    siHubi.setRenrakusakinmkj(uiBean.getRenrakusakinmkj());
                    siHubi.setRenrakuyno(uiBean.getTsinyno());
                    siHubi.setRenrakusakiadr1kj(uiBean.getTsinadr1kj());
                    siHubi.setRenrakusakiadr2kj(uiBean.getTsinadr2kj());
                    siHubi.setRenrakusakiadr3kj(uiBean.getTsinadr3kj());
                    siHubi.setRenrakuarea(uiBean.getRenrakuarea());
                    if (C_UmuKbn.ARI.eq(uiBean.getHasinsakiKokakuUmuKbn())) {
                        siHubi.setHassinsakifsthubihasinymd1(sysDate);
                        siHubi.setHassinsakikaisuu1(1);
                    }
                    if (C_UmuKbn.ARI.eq(uiBean.getHasinsakiSisyaUmuKbn())) {
                        siHubi.setHassinsakifsthubihasinymd2(sysDate);
                        siHubi.setHassinsakikaisuu2(1);
                    }
                    if (C_UmuKbn.ARI.eq(uiBean.getHasinsakiHonsyajimubumonUmuKbn())) {
                        siHubi.setHasinsakibetuhubihasinymd3(sysDate);
                        siHubi.setHasinsakibetuhasinkaisuu3(1);
                    }
                    siHubi.setSisyacd(uiBean.getSisyacd());
                    siHubi.setSisyanm(uiBean.getSisyanm());
                    siHubi.setToiawasesosikinmkj(uiBean.getToiawasesosikinmkj());
                    siHubi.setToiawasetelno(uiBean.getToiawasetelno());
                    siHubi.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    siHubi.setGyoumuKousinTime(sysDateTimeMilli);
                    BizPropertyInitializer.initialize(siHubi);
                    siharaiDomManager.insert(siHubi);
                }
                else {
                    siHubi = siharaiDomManager.getSiHubi(uiBean.getHubiSikibetuKey());
                    siHubi.setSyono(uiBean.getSyono());
                    siHubi.setJimutetuzukinm(uiBean.getVktifdispjimutetuzukinm());
                    siHubi.setRenrakusakinmkj(uiBean.getRenrakusakinmkj());
                    siHubi.setRenrakuyno(uiBean.getTsinyno());
                    siHubi.setRenrakusakiadr1kj(uiBean.getTsinadr1kj());
                    siHubi.setRenrakusakiadr2kj(uiBean.getTsinadr2kj());
                    siHubi.setRenrakusakiadr3kj(uiBean.getTsinadr3kj());
                    siHubi.setRenrakuarea(uiBean.getRenrakuarea());
                    if (C_UmuKbn.ARI.eq(uiBean.getHasinsakiKokakuUmuKbn())) {
                        if (siHubi.getHassinsakifsthubihasinymd1() == null) {
                            siHubi.setHassinsakifsthubihasinymd1(sysDate);
                        }
                        siHubi.setHassinsakikaisuu1(siHubi.getHassinsakikaisuu1() + 1);
                    }
                    if (C_UmuKbn.ARI.eq(uiBean.getHasinsakiSisyaUmuKbn())) {
                        if (siHubi.getHassinsakifsthubihasinymd2() == null) {
                            siHubi.setHassinsakifsthubihasinymd2(sysDate);
                        }
                        siHubi.setHassinsakikaisuu2(siHubi.getHassinsakikaisuu2() + 1);
                    }
                    if (C_UmuKbn.ARI.eq(uiBean.getHasinsakiHonsyajimubumonUmuKbn())) {
                        if (siHubi.getHasinsakibetuhubihasinymd3() == null) {
                            siHubi.setHasinsakibetuhubihasinymd3(sysDate);
                        }
                        siHubi.setHasinsakibetuhasinkaisuu3(siHubi.getHasinsakibetuhasinkaisuu3() + 1);
                    }
                    siHubi.setSisyacd(uiBean.getSisyacd());
                    siHubi.setSisyanm(uiBean.getSisyanm());
                    siHubi.setToiawasesosikinmkj(uiBean.getToiawasesosikinmkj());
                    siHubi.setToiawasetelno(uiBean.getToiawasetelno());
                    siHubi.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    siHubi.setGyoumuKousinTime(sysDateTimeMilli);
                    siharaiDomManager.update(siHubi);
                }

                if (uiBean.getMihasinhubiListDataSource().getAllData().size() > 0) {
                    Integer maxRenno = siharaiDomManager.getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd(
                        uiBean.getHubiSikibetuKey());
                    if (maxRenno == null) {
                        maxRenno = 0;
                    }
                    for (MihasinhubiListDataSourceBean DataBean : uiBean.getMihasinhubiListDataSource().getAllData()) {
                        maxRenno++;
                        JT_SiHubiDetail siHubiDetail = siHubi.createSiHubiDetail();
                        siHubiDetail.setRenno3keta(maxRenno);
                        siHubiDetail.setHubisyoruicd(DataBean.getDispsyoruicd());
                        siHubiDetail.setHubisyoruinm(DataBean.getDisphubisyoruinm());
                        siHubiDetail.setHubinaiyoucd(DataBean.getHubinaiyoucd());
                        siHubiDetail.setHubinaiyoumsg(DataBean.getDisphubinaiyoumsg());
                        if (DataBean.getDispgenponhnkykumuchkbox()) {
                            siHubiDetail.setGenponhnkykumu(C_UmuKbn.ARI);
                        }
                        else {
                            siHubiDetail.setGenponhnkykumu(C_UmuKbn.NONE);
                        }
                        siHubiDetail.setTrkymd(DataBean.getDisptrkymd());
                        siHubiDetail.setHasinymd(DataBean.getDisphassinymd());
                        siHubiDetail.setKaisyouymd(DataBean.getDispkaisyouymd());
                        siHubiDetail.setHassinsakikbn(DataBean.getDisphassinsakikbn());
                        siHubiDetail.setHubitourokuktntid(DataBean.getDispHubiTourokuTantouId());
                        siHubiDetail.setHubisyouninktntid(DataBean.getDispHubiSyouninnTantouId());
                        siHubiDetail.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        siHubiDetail.setGyoumuKousinTime(sysDateTimeMilli);
                        BizPropertyInitializer.initialize(siHubiDetail);
                    }
                    siharaiDomManager.update(siHubi);
                }

                JT_SkKihon skKihon = uiBean.getSkKihon();
                skKihon.setHubijyoukyoukbn(C_HubiJyoukyouKbn.HUBI);
                skKihon.setKossyoricd(kinou.getKinouId());
                skKihon.setKossyorisscd(kinouMode.getKinouMode());
                skKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                skKihon.setGyoumuKousinTime(sysDateTimeMilli);
                siharaiDomManager.update(skKihon);

                JW_HubiWk hubiWk = siharaiDomManager.getHubiWk(uiBean.getHubiSikibetuKey());
                if (hubiWk != null) {
                    hubiWk.getHubiDetailWks().removeAll(hubiWk.getHubiDetailWks());
                    siharaiDomManager.delete(hubiWk);
                }
            }
            else if (C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())
                || C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())
                || C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn())) {
                hubiWkHubiDetailWksUpdate(sysDateTimeMilli);
            }
        }
        else if (C_SikinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())) {
            hubiWkHubiDetailWksUpdate(sysDateTimeMilli);
        }

        if (C_SikinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())
            && C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {

            Map<String, String> kouteikanriIdMp = siharaiPreReportRenkeiBean.getSakuseizumiKouteikanriIdMp();
            kouteikanriIdMp.put(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getKouteiKanriId());
            siharaiPreReportRenkeiBean.setSakuseizumiKouteikanriIdMp(kouteikanriIdMp);

            String tyouhyouJoinKey = hubiTyouhyouSakusei(false, sysDate);

            uiBean.setTyouhyouJoinKey(tyouhyouJoinKey);
        }

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn()) ||
            uiBean.isTagamenKidouHanteiFlg()) {
            BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
            bzProcessCreateInBean.setSkNo(uiBean.getSkno());
            bzProcessCreateInBean.setJimuyouCd(uiBean.getJimuyoucd());
            bzProcessCreateInBean.setJmycdMisetteiKbn(uiBean.getJmycdMisetteiKbn());
            bzProcessCreateInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU);
            bzProcessCreateInBean.setOyaKouteiKanriId(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
            bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());
            BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

            if (!C_KouteiSakuseiKekkaKbn.SUCCESS.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                throw new BizLogicException(MessageId.EBS0008);
            }

            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzProcessCreateOutBean.getKouteiKanriId());

            BzLockProcessOutBean bzLockProcessOutBean = SWAKInjector.getInstance(BzLockProcessOutBean.class);
            bzLockProcessOutBean = bzLockProcess.exec(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU,wkKouteiLockKey);

            if (!C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBean.getKouteiLockKekkaKbn())) {
                throw new BizLogicException(MessageId.EBA0110);
            }

            BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
            bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(), TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU,
                kinouMode.getKinouMode(),wkKouteiLockKey);
        }

        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        siRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        siProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(), TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU,
            wkKouteiLockKey, uiBean.getSyanaicomment(), siRuleBean,uiBean.getTennousakisousasyacd());

        if (!uiBean.isTagamenKidouHanteiFlg()){
            bzUnlockProcess.exec(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
                TeisuuSiharai.JIMUTETUZUKICD_SISIBOU,wkKouteiLockKey);
        }

        messageManager.addMessageId(MessageId.IAC0009);

        return FORWARDNAME_RESULT;
    }

    String pushFunctionNameBL(){

        String forwardName = "";

        if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM) {
            if(!uiBean.isTagamenKidouHanteiFlg()){
                pushUnlockProcessBL();
            }
        }

        if ((uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM ||
            uiBean.getPageNo() == PAGENO_RESULT) && C_UmuKbn.ARI.eq(uiBean.getItiranKeiyuUmuKbn())) {
            forwardName = FORWARDNAME_NESTEDEND;
            return forwardName;
        }

        forwardName = pushNestedEndBL();

        return forwardName;
    }

    String pushNestedEndBL() {

        if (uiBean.isTagamenKidouHanteiFlg()) {
            return FORWARDNAME_INIT;
        }
        if (uiBean.isKidougmKbnWorkListSeigyo()) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    String pushSyokigamenheBL(){

        String forwardName = "";

        if (C_UmuKbn.ARI.eq(uiBean.getItiranKeiyuUmuKbn())) {
            forwardName = FORWARDNAME_NESTEDEND;
            return forwardName;
        }
        forwardName = pushNestedEndBL();

        return forwardName;
    }

    void pushTojiruBL(){

        if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM) {
            if(!uiBean.isTagamenKidouHanteiFlg()){
                pushUnlockProcessBL();
            }
        }
    }

    void printHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void printOut() {

        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);
        String tyhykey = uiBean.getTyouhyouJoinKey();
        outputReport.outputPDFByJoinKey(tyhykey);
    }

    void pushUnlockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.unlockProcess();
    }

    private void listClean() {

        List<MihasinhubiListDataSourceBean> mihasinhubiList = uiBean.getMihasinhubiListDataSource().getAllData();
        Iterables.removeIf(mihasinhubiList, new MihasinhubiListDataSourceBeanPredicate());
        uiBean.setMihasinhubiList(mihasinhubiList);
    }

    private class MihasinhubiListDataSourceBeanPredicate implements Predicate<MihasinhubiListDataSourceBean>{

        public MihasinhubiListDataSourceBeanPredicate() {
        }

        @Override
        public boolean apply(MihasinhubiListDataSourceBean bean) {

            return C_Delflag.SAKUJYO.eq(bean.getSakujyoflg());
        }
    }

    public class SelectDataListComparator implements Comparator<SelectDataListDataSourceBean> {

        public SelectDataListComparator() {
        }

        @Override
        public int compare(SelectDataListDataSourceBean pSelectDataListDataSourceBean1, SelectDataListDataSourceBean pSelectDataListDataSourceBean2) {

            String jimutetuzukinm1 = pSelectDataListDataSourceBean1.getJimutetuzukinm();
            String jimutetuzukinm2 = pSelectDataListDataSourceBean2.getJimutetuzukinm();

            BizDate jimustartymd1 = pSelectDataListDataSourceBean1.getJimustartymd();
            BizDate jimustartymd2 = pSelectDataListDataSourceBean2.getJimustartymd();

            if (BizUtil.isBlank(jimutetuzukinm1)) {
                if (!BizUtil.isBlank(jimutetuzukinm2)) {
                    return -1;
                }

                return jimustartymd1.compareTo(jimustartymd2);
            }

            if (BizUtil.isBlank(jimutetuzukinm2)) {
                return 1;
            }

            if (!jimutetuzukinm1.equals(jimutetuzukinm2)) {
                return jimutetuzukinm1.compareTo(jimutetuzukinm2);
            }
            return jimustartymd1.compareTo(jimustartymd2);
        }
    }

    private List<MihasinhubiListDataSourceBean> setMihasinhubiNewList() {

        listClean();

        List<MihasinhubiListDataSourceBean> mihasinhubiList = uiBean.getMihasinhubiListDataSource().getAllData();
        List<MihasinhubiListDataSourceBean> mihasinhubiNewList = Lists.newArrayList();

        for (MihasinhubiListDataSourceBean mihasinhubiListDSBean : mihasinhubiList) {
            if (!BizUtil.isBlank(mihasinhubiListDSBean.getDisphubisyoruinm())
                || !BizUtil.isBlank(mihasinhubiListDSBean.getDisphubinaiyoumsg())
                || mihasinhubiListDSBean.getDispgenponhnkykumuchkbox()
                || !C_HassinsakiKbn.BLNK.eq(mihasinhubiListDSBean.getDisphassinsakikbn())) {
                mihasinhubiNewList.add(mihasinhubiListDSBean);
            }
        }

        return mihasinhubiNewList;
    }

    private void hubiWkHubiDetailWksUpdate(String sysDateTimeMilli) {

        JW_HubiWk hubiWk = siharaiDomManager.getHubiWk(uiBean.getHubiSikibetuKey());
        if (hubiWk == null) {
            hubiWk = new JW_HubiWk();
            hubiWk.setKouteikanriid(uiBean.getHubiSikibetuKey());
            hubiWk.setSyono(uiBean.getSyono());
            hubiWk.setRenrakusakinmkj(uiBean.getRenrakusakinmkj());
            hubiWk.setRenrakuyno(uiBean.getTsinyno());
            hubiWk.setRenrakusakiadr1kj(uiBean.getTsinadr1kj());
            hubiWk.setRenrakusakiadr2kj(uiBean.getTsinadr2kj());
            hubiWk.setRenrakusakiadr3kj(uiBean.getTsinadr3kj());
            hubiWk.setRenrakuarea(uiBean.getRenrakuarea());
            hubiWk.setSisyacd(uiBean.getSisyacd());
            hubiWk.setSisyanm(uiBean.getSisyanm());
            hubiWk.setToiawasesosikinmkj(uiBean.getToiawasesosikinmkj());
            hubiWk.setToiawasetelno(uiBean.getToiawasetelno());
            hubiWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            hubiWk.setGyoumuKousinTime(sysDateTimeMilli);
            BizPropertyInitializer.initialize(hubiWk);

            hubiDetailWksInsert(sysDateTimeMilli, hubiWk);

            siharaiDomManager.insert(hubiWk);
        }
        else {
            hubiWk.setSyono(uiBean.getSyono());
            hubiWk.setRenrakusakinmkj(uiBean.getRenrakusakinmkj());
            hubiWk.setRenrakuyno(uiBean.getTsinyno());
            hubiWk.setRenrakusakiadr1kj(uiBean.getTsinadr1kj());
            hubiWk.setRenrakusakiadr2kj(uiBean.getTsinadr2kj());
            hubiWk.setRenrakusakiadr3kj(uiBean.getTsinadr3kj());
            hubiWk.setRenrakuarea(uiBean.getRenrakuarea());
            hubiWk.setSisyacd(uiBean.getSisyacd());
            hubiWk.setSisyanm(uiBean.getSisyanm());
            hubiWk.setToiawasesosikinmkj(uiBean.getToiawasesosikinmkj());
            hubiWk.setToiawasetelno(uiBean.getToiawasetelno());
            hubiWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            hubiWk.setGyoumuKousinTime(sysDateTimeMilli);

            hubiWk.getHubiDetailWks().removeAll(hubiWk.getHubiDetailWks());
            siharaiDomManager.flush();

            hubiDetailWksInsert(sysDateTimeMilli, hubiWk);

            siharaiDomManager.update(hubiWk);
        }
    }

    private void hubiDetailWksInsert(String sysDateTimeMilli, JW_HubiWk hubiWk) {

        Integer maxRenno = 0;
        for (MihasinhubiListDataSourceBean mihasinhubiListDSBean : uiBean.getMihasinhubiListDataSource().getAllData()) {
            maxRenno++;
            JW_HubiDetailWk hubiDetailWk = hubiWk.createHubiDetailWk();
            hubiDetailWk.setRenno3keta(maxRenno);
            hubiDetailWk.setHubisyoruicd(mihasinhubiListDSBean.getDispsyoruicd());
            hubiDetailWk.setHubisyoruinm(mihasinhubiListDSBean.getDisphubisyoruinm());
            hubiDetailWk.setHubinaiyoucd(mihasinhubiListDSBean.getHubinaiyoucd());
            hubiDetailWk.setHubinaiyoumsg(mihasinhubiListDSBean.getDisphubinaiyoumsg());
            hubiDetailWk.setTrkymd(mihasinhubiListDSBean.getDisptrkymd());
            if (mihasinhubiListDSBean.getDispgenponhnkykumuchkbox()) {
                hubiDetailWk.setGenponhnkykumu(C_UmuKbn.ARI);
            }
            else {
                hubiDetailWk.setGenponhnkykumu(C_UmuKbn.NONE);
            }
            hubiDetailWk.setHassinsakikbn(mihasinhubiListDSBean.getDisphassinsakikbn());
            hubiDetailWk.setHubitourokuktntid(mihasinhubiListDSBean.getDispHubiTourokuTantouId());
            hubiDetailWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            hubiDetailWk.setGyoumuKousinTime(sysDateTimeMilli);
            BizPropertyInitializer.initialize(hubiDetailWk);
        }
    }

    public void karisakuseiPrintOut() {
        String wkKarisakuseiTyouhyouJoinKey = uiBean.getKarisakuseiTyouhyouJoinKey();
        uiBean.setKarisakuseiTyouhyouJoinKey(null);
        OutputReport wkOutputReport = SWAKInjector.getInstance(OutputReport.class);
        wkOutputReport.outputPDFWithDelByJoinKey(wkKarisakuseiTyouhyouJoinKey);

    }

    private void keiyakuInfoSyutoku() {

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
        keiyakuInfoSyutoku.getInfos(keiyakuPrm);
        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();
        if (siKykKihonLst.get(0) == null) {
            throw new BizLogicException(MessageId.EAC0046,
                MessageUtil.getMessage(DDID_BASEINFO_SYONO.getErrorResourceKey()));
        }
        uiBean.setHhknnmkj(siKykKihonLst.get(0).getHhknnmkj());
    }

    private void naiyougamenInfoGetset(List<BzGetProcessSummaryOutBean> outBeanList) {

        Integer seikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(outBeanList.get(0).getSkNo(),
            outBeanList.get(0).getSyoNo());
        JT_Sk sk = uiBean.getSkKihon().getSkBySeikyuurirekino(seikyuurirekino);

        JT_SiHubi siHubi = new JT_SiHubi();
        JT_SiHubi siHubis = siharaiDomManager.getSiHubi(uiBean.getHubiSikibetuKey());
        if (siHubis != null) {
            siHubi = siHubis;
            uiBean.setFstTourokuFlg(false);
        }
        else {
            uiBean.setFstTourokuFlg(true);
        }

        JW_HubiWk hubiWk = new JW_HubiWk();
        JW_HubiWk hubiWks = siharaiDomManager.getHubiWk(uiBean.getHubiSikibetuKey());
        if (hubiWks != null) {
            uiBean.setFstTourokuFlg(false);
            hubiWk = hubiWks;
            siHubi.setSyono(hubiWk.getSyono());
            siHubi.setRenrakusakinmkj(hubiWk.getRenrakusakinmkj());
            siHubi.setRenrakuyno(hubiWk.getRenrakuyno());
            siHubi.setRenrakusakiadr1kj(hubiWk.getRenrakusakiadr1kj());
            siHubi.setRenrakusakiadr2kj(hubiWk.getRenrakusakiadr2kj());
            siHubi.setRenrakusakiadr3kj(hubiWk.getRenrakusakiadr3kj());
            siHubi.setRenrakusakitelno(hubiWk.getRenrakusakitelno());
            siHubi.setRenrakuarea(hubiWk.getRenrakuarea());
            siHubi.setSisyacd(hubiWk.getSisyacd());
            siHubi.setSisyanm(hubiWk.getSisyanm());
            siHubi.setToiawasesosikinmkj(hubiWk.getToiawasesosikinmkj());
            siHubi.setToiawasetelno(hubiWk.getToiawasetelno());
        }

        List<JT_SiHubiDetail> siHubiDetailList = Lists.newArrayList();
        SortJT_SiHubiDetail siHubiDetailSort = SWAKInjector.getInstance(SortJT_SiHubiDetail.class);
        siHubiDetailList = siHubi.getSiHubiDetailsByHasinymd();
        siHubiDetailList = siHubiDetailSort.OrderJT_SiHubiDetailByHasinymdRenno3ketaAsc(siHubiDetailList);

        List<JW_HubiDetailWk> hubiDetailWkList = Lists.newArrayList();
        SortJW_HubiDetailWk hubiDetailWkSort = SWAKInjector.getInstance(SortJW_HubiDetailWk.class);
        hubiDetailWkList = hubiWk.getHubiDetailWks();
        hubiDetailWkList = hubiDetailWkSort.OrderJW_HubiDetailWkByPkAsc(hubiDetailWkList);

        List<UsersByKinouIdKinouModeIdUserIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserId(kinou.getKinouId(), kinouMode.getKinouMode(),
            baseUserInfo.getUserId());

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
        uiBean.setBzGetSosikiMadogutiInfoKekkaBean(bzGetSosikiMadogutiInfo.exec(baseUserInfo.getTmSosikiCd()));

        uiBean.setSyono(outBeanList.get(0).getSyoNo());
        uiBean.setSkno(outBeanList.get(0).getSkNo());

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);

        List<HasinzumihubiListDataSourceBean> hasinzumiList = Lists.newArrayList();
        int hasinzumiListCount = 1;
        for (JT_SiHubiDetail siHubiDetail : siHubiDetailList) {
            if (hasinzumiListCount > MAX_ROW_COUNT) {
                break;
            }
            HasinzumihubiListDataSourceBean dataSourceBean = SWAKInjector.getInstance(
                HasinzumihubiListDataSourceBean.class);
            dataSourceBean.setTrkymd(siHubiDetail.getTrkymd());
            dataSourceBean.setSyoruiCd(siHubiDetail.getHubisyoruicd());
            dataSourceBean.setHubisyoruinm(siHubiDetail.getHubisyoruinm());
            dataSourceBean.setHubiNaiyouCd(siHubiDetail.getHubinaiyoucd());
            dataSourceBean.setHubinaiyoumsg(siHubiDetail.getHubinaiyoumsg());
            if (C_UmuKbn.ARI.eq(siHubiDetail.getGenponhnkykumu())) {
                dataSourceBean.setGenponhnkykumuchkbox(true);
            }
            else {
                dataSourceBean.setGenponhnkykumuchkbox(false);
            }
            dataSourceBean.setHasinymd(siHubiDetail.getHasinymd());
            dataSourceBean.setHassinsakikbn(siHubiDetail.getHassinsakikbn());
            dataSourceBean.setHubiTourokuTantouId(siHubiDetail.getHubitourokuktntid());
            AM_User tourokuUser = baseDomManager.getUser(siHubiDetail.getHubitourokuktntid());
            if (tourokuUser != null) {
                dataSourceBean.setNyuuryokutantounm(tourokuUser.getUserNm());
            }
            dataSourceBean.setHubiSyouninnTantouId(siHubiDetail.getHubisyouninktntid());
            AM_User syouninUser = baseDomManager.getUser(siHubiDetail.getHubisyouninktntid());
            if (syouninUser != null) {
                dataSourceBean.setSyounintantounm(syouninUser.getUserNm());
            }
            dataSourceBean.setKaisyouymd(siHubiDetail.getKaisyouymd());

            hasinzumiList.add(dataSourceBean);
            hasinzumiListCount++;
        }
        uiBean.setHasinzumihubiList(hasinzumiList);

        BizDate sysDate = BizDate.getSysDate();

        List<MihasinhubiListDataSourceBean> mihasinList = Lists.newArrayList();
        if (uiBean.isFstTourokuFlg()) {
            for (int i = 0; i < MAX_ROW_COUNT; i++) {
                MihasinhubiListDataSourceBean dataSourceBean = SWAKInjector.getInstance(
                    MihasinhubiListDataSourceBean.class);
                dataSourceBean.setDisptrkymd(sysDate);
                dataSourceBean.setDispgenponhnkykumuchkbox(false);
                dataSourceBean.setSakujyoLink(MessageUtil.getMessage(
                    DDID_MIHASINHUBILIST_SAKUJYOLINK.getErrorResourceKey()));
                if(i == 0){
                    dataSourceBean.setSakujyoflg(C_Delflag.BLNK);
                    dataSourceBean.setSakujyoflg2(C_Delflag.BLNK);
                }
                else {
                    dataSourceBean.setSakujyoflg(C_Delflag.SAKUJYO);
                    dataSourceBean.setSakujyoflg2(C_Delflag.SAKUJYO);
                }
                mihasinList.add(dataSourceBean);
            }
        }
        else {
            int mihasinListCount = 1;
            for (JW_HubiDetailWk hubiDetailWk : hubiDetailWkList) {
                if (mihasinListCount > MAX_ROW_COUNT) {
                    break;
                }
                MihasinhubiListDataSourceBean dataSourceBean = SWAKInjector.getInstance(
                    MihasinhubiListDataSourceBean.class);
                dataSourceBean.setDisptrkymd(hubiDetailWk.getTrkymd());
                dataSourceBean.setDispsyoruicd(hubiDetailWk.getHubisyoruicd());
                dataSourceBean.setDisphubisyoruinm(hubiDetailWk.getHubisyoruinm());
                dataSourceBean.setHubinaiyoucd(hubiDetailWk.getHubinaiyoucd());
                dataSourceBean.setDisphubinaiyoumsg(hubiDetailWk.getHubinaiyoumsg());
                if (C_UmuKbn.ARI.eq(hubiDetailWk.getGenponhnkykumu())) {
                    dataSourceBean.setDispgenponhnkykumuchkbox(true);
                }
                else {
                    dataSourceBean.setDispgenponhnkykumuchkbox(false);
                }
                dataSourceBean.setDisphassinsakikbn(hubiDetailWk.getHassinsakikbn());
                dataSourceBean.setDispHubiTourokuTantouId(hubiDetailWk.getHubitourokuktntid());
                dataSourceBean.setDispHubiTourokuTantouId2(hubiDetailWk.getHubitourokuktntid());
                if(!BizUtil.isBlank(hubiDetailWk.getHubitourokuktntid())){
                    AM_User tourokuUser = baseDomManager.getUser(hubiDetailWk.getHubitourokuktntid());
                    if (tourokuUser != null) {
                        dataSourceBean.setDispnyuryokutantounm(tourokuUser.getUserNm());
                        dataSourceBean.setDispnyuryokutantounm2(tourokuUser.getUserNm());
                    }
                }
                dataSourceBean.setSakujyoLink(MessageUtil.getMessage(
                    DDID_MIHASINHUBILIST_SAKUJYOLINK.getErrorResourceKey()));
                dataSourceBean.setSakujyoflg(C_Delflag.BLNK);
                dataSourceBean.setSakujyoflg2(C_Delflag.BLNK);

                mihasinList.add(dataSourceBean);
                mihasinListCount++;
            }
            for (int i = mihasinList.size(); i < MAX_ROW_COUNT; i++) {
                MihasinhubiListDataSourceBean dataSourceBean = SWAKInjector.getInstance(
                    MihasinhubiListDataSourceBean.class);
                dataSourceBean.setDisptrkymd(sysDate);
                dataSourceBean.setDispgenponhnkykumuchkbox(false);
                dataSourceBean.setSakujyoLink(MessageUtil.getMessage(
                    DDID_MIHASINHUBILIST_SAKUJYOLINK.getErrorResourceKey()));
                if(i == 0){
                    dataSourceBean.setSakujyoflg(C_Delflag.BLNK);
                    dataSourceBean.setSakujyoflg2(C_Delflag.BLNK);
                }
                else {
                    dataSourceBean.setSakujyoflg(C_Delflag.SAKUJYO);
                    dataSourceBean.setSakujyoflg2(C_Delflag.SAKUJYO);
                }
                mihasinList.add(dataSourceBean);
            }
        }
        uiBean.setMihasinhubiList(mihasinList);

        if (C_SikinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())) {
            if (uiBean.isFstTourokuFlg()) {
                YuyuSiharaiConfig wkYuyuSiharaiConfig = YuyuSiharaiConfig.getInstance();
                uiBean.setRenrakusakinmkj(sk.getSeikyuusyanmkj());
                uiBean.setTsinyno(sk.getTsinyno());
                uiBean.setTsinadr1kj(sk.getTsinadr1kj());
                uiBean.setTsinadr2kj(sk.getTsinadr2kj());
                uiBean.setTsinadr3kj(sk.getTsinadr3kj());
                uiBean.setToiawasesosikinmkj(uiBean.getBzGetSosikiMadogutiInfoKekkaBean().getKanjisosikinm());
                uiBean.setToiawasetelno(wkYuyuSiharaiConfig.getHubiToiawaseyouTelno());
            }
            else {
                uiBean.setSisyacd(siHubi.getSisyacd());
                uiBean.setRenrakusakinmkj(siHubi.getRenrakusakinmkj());
                uiBean.setTsinyno(siHubi.getRenrakuyno());
                uiBean.setTsinadr1kj(siHubi.getRenrakusakiadr1kj());
                uiBean.setTsinadr2kj(siHubi.getRenrakusakiadr2kj());
                uiBean.setTsinadr3kj(siHubi.getRenrakusakiadr3kj());
                uiBean.setRenrakuarea(siHubi.getRenrakuarea());
                uiBean.setToiawasesosikinmkj(siHubi.getToiawasesosikinmkj());
                uiBean.setToiawasetelno(siHubi.getToiawasetelno());
            }
            uiBean.setPatternSyorikekkaKbn(C_SyorikekkaKbn.PATTERN_SIHUBITOUROKU);
        }
        if (C_SikinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            uiBean.setSisyacd(siHubi.getSisyacd());
            uiBean.setRenrakusakinmkj(siHubi.getRenrakusakinmkj());
            uiBean.setTsinyno(siHubi.getRenrakuyno());
            uiBean.setTsinadr1kj(siHubi.getRenrakusakiadr1kj());
            uiBean.setTsinadr2kj(siHubi.getRenrakusakiadr2kj());
            uiBean.setTsinadr3kj(siHubi.getRenrakusakiadr3kj());
            uiBean.setRenrakuarea(siHubi.getRenrakuarea());
            uiBean.setToiawasesosikinmkj(siHubi.getToiawasesosikinmkj());
            uiBean.setToiawasetelno(siHubi.getToiawasetelno());
            uiBean.setPatternSyorikekkaKbn(C_SyorikekkaKbn.PATTERN_SIHUBISYOUNIN);
        }
        UserDefsList userLst = new UserDefsList();
        LabelValuePair labelValuePair = new LabelValuePair();
        labelValuePair.setLabel("");
        labelValuePair.setValue("");
        userLst.add(labelValuePair);
        if(userList != null){
            for (int i = 0; i < userList.size(); i++) {
                LabelValuePair lvaluePair = new LabelValuePair();
                lvaluePair.setLabel(userList.get(i).getSosikiNm()
                    .concat(FULL_SPACE.concat(userList.get(i).getUserNm())));
                lvaluePair.setValue(userList.get(i).getUserId());
                userLst.add(lvaluePair);
            }
        }
        uiBean.setTennousakisousasyacdOptionBeanList(userLst);
        uiBean.setSyoriYmd(BizDate.getSysDate());
    }

    private String hubiTyouhyouSakusei(boolean karisakusei, BizDate sysDate) {

        ReportServicesBean reportServicesBeanSouhuannaiKok = null;

        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(
            SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(sysDate);
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_HUBITEISEI_SOUHU);
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj(uiBean.getRenrakusakinmkj());
        seikyuusyaInfoBean.setTsinyno(uiBean.getTsinyno());
        seikyuusyaInfoBean.setTsinadr1kj(uiBean.getTsinadr1kj());
        seikyuusyaInfoBean.setTsinadr2kj(uiBean.getTsinadr2kj());
        seikyuusyaInfoBean.setTsinadr3kj(uiBean.getTsinadr3kj());
        YuyuBizConfig wkYuyuBizConfig = YuyuBizConfig.getInstance();
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        toiawaseInfoBean.setSosikiNm(uiBean.getToiawasesosikinmkj());
        toiawaseInfoBean.setTsinyno(uiBean.getBzGetSosikiMadogutiInfoKekkaBean().getPostalCd());
        toiawaseInfoBean.setTsinadr1kj(uiBean.getBzGetSosikiMadogutiInfoKekkaBean().getKanjisosikiadr1());
        toiawaseInfoBean.setTsinadr2kj(uiBean.getBzGetSosikiMadogutiInfoKekkaBean().getKanjisosikiadr2());
        toiawaseInfoBean.setTsinadr3kj(uiBean.getBzGetSosikiMadogutiInfoKekkaBean().getKanjisosikiadr3());
        toiawaseInfoBean.setTsintelno(uiBean.getToiawasetelno());
        toiawaseInfoBean.setTelUktkKanouTime(wkYuyuBizConfig.getUketimetantousitu1());
        toiawaseInfoBean.setTelUktkkanouTimeHigou(wkYuyuBizConfig.getUketimetantousitu2());

        EditHubiteiseisyosouhuannaiBean souhuannaiBean = SWAKInjector.getInstance(
            EditHubiteiseisyosouhuannaiBean.class);
        EditHubiteiseisyosouhuannai souhuannai = SWAKInjector.getInstance(EditHubiteiseisyosouhuannai.class);
        souhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        souhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
        souhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
        souhuannaiBean.setSyono(uiBean.getSyono());
        souhuannaiBean.setHhknnmkj(uiBean.getHhknnmkj());
        souhuannaiBean.setRenrakuarea(uiBean.getRenrakuarea());
        reportServicesBeanSouhuannaiKok = souhuannai.exec(souhuannaiBean);

        HubiTeiseisyoBean hubiTeiseisyoBean = SWAKInjector.getInstance(HubiTeiseisyoBean.class);
        List<EditHubiTeiseisyoItiranBean> hubiTeiseisyoItiranLst = Lists.newArrayList();
        for (MihasinhubiListDataSourceBean dataSourceBean : uiBean.getMihasinhubiListDataSource().getAllData()) {
            EditHubiTeiseisyoItiranBean itiranBean = SWAKInjector.getInstance(EditHubiTeiseisyoItiranBean.class);
            itiranBean.setHubinaiyoumsg(dataSourceBean.getDisphubinaiyoumsg());
            itiranBean.setHassinsakiKbn(dataSourceBean.getDisphassinsakikbn());
            if (dataSourceBean.getDispgenponhnkykumuchkbox()) {
                itiranBean.setGenponhnkykumu(C_UmuKbn.ARI);
            }
            else {
                itiranBean.setGenponhnkykumu(C_UmuKbn.NONE);
            }
            hubiTeiseisyoItiranLst.add(itiranBean);
        }
        SiTyouhyouHensyuuCommonBean commonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        commonBean.setSyoriYmd(sysDate);
        if (C_SeikyuuSyubetu.SB.eq(uiBean.getSkKihon().getSeikyuusyubetu())) {
            if(karisakusei){
                commonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HUBITEISEI2);
            }else{
                commonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HUBITEISEI);
            }
        }
        hubiTeiseisyoBean.setSiTyouhyouHensyuuCommonBean(commonBean);
        hubiTeiseisyoBean.setSyono(uiBean.getSyono());
        hubiTeiseisyoBean.setSeikyuusyanmKj(uiBean.getRenrakusakinmkj());
        hubiTeiseisyoBean.setHubiTeiseisyoItiranLst(hubiTeiseisyoItiranLst);
        hubiTeiseisyoBean.setKarisakusei(karisakusei);
        hubiTeiseisyoBean.setToritsugisyakjncd(baseUserInfo.getUserId());
        hubiTeiseisyoBean.setToritsugisyakjnmei(baseUserInfo.getUserNm());
        hubiTeiseisyoBean.setToritsugisyaSosikinm(baseUserInfo.getTmSosikiNm());
        EditHubiTeiseisyo editHubiTeiseisyo = SWAKInjector.getInstance(EditHubiTeiseisyo.class);
        EditHubiTeiseisyoBean editHubiTeiseisyoBean = editHubiTeiseisyo.exec(hubiTeiseisyoBean);
        ReportServicesBean reportServicesBeanKok = editHubiTeiseisyoBean.getReportServicesBeanKok();
        ReportServicesBean reportServicesBeanHonsya = editHubiTeiseisyoBean.getReportServicesBeanHonsya();
        ReportServicesBean reportServicesBeanSisya = editHubiTeiseisyoBean.getReportServicesBeanSisya();

        List<ReportServicesBean> reportServicesBeanlist = Lists.newArrayList();
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        if (reportServicesBeanKok != null || reportServicesBeanSisya != null) {
            reportServicesBeanlist.add(reportServicesBeanSouhuannaiKok);
        }
        if (reportServicesBeanKok != null) {
            reportServicesBeanlist.add(reportServicesBeanKok);
        }
        if (reportServicesBeanSisya != null) {
            reportServicesBeanlist.add(reportServicesBeanSisya);
        }
        if (reportServicesBeanHonsya != null) {
            reportServicesBeanlist.add(reportServicesBeanHonsya);
        }
        ReportServicesBean[] pBeans = reportServicesBeanlist.toArray(new ReportServicesBean[]{});
        String tyouhyouJoinKey = createReport.execNoCommit(pBeans);

        return tyouhyouJoinKey;
    }

    private void chkInput(boolean karisakusei){

        if(!karisakusei && (C_SyorikekkaKbn.BLNK.eq(uiBean.getSyorikekkakbn()))){
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KEKKAINPUT_SYORIKEKKAKBN.getErrorResourceKey()));
        }

        BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);
        BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(
            uiBean.getTsinadr1kj(), uiBean.getTsinadr2kj(), uiBean.getTsinadr3kj());
        C_JyougenketasuutyoukaKbn jyougenKetasuuTyoukaKbn = bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn();
        if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(jyougenKetasuuTyoukaKbn)) {
            ResourceBundle resourceBundle = ResourceUtil.getApplicationResources();
            String strResult = resourceBundle.getString("tsinadr1kj");
            throw new BizLogicException(MessageId.EBA1003,
                MessageUtil.getMessage(strResult),
                String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu()));
        }

        C_UmuKbn hasinsakiKokakuUmuKbn = C_UmuKbn.NONE;
        C_UmuKbn hasinsakiSisyaUmuKbn = C_UmuKbn.NONE;
        C_UmuKbn hasinsakiHonsyajimubumonUmuKbn = C_UmuKbn.NONE;
        int hasinsakiKokakuCount = 0;
        int hasinsakiSisyaCount = 0;
        int hasinsakiHonsyajimubumonCount = 0;
        List<MihasinhubiListDataSourceBean> mihasinhubiNewList = setMihasinhubiNewList();

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) || karisakusei) {
            for (MihasinhubiListDataSourceBean mihasinhubi : mihasinhubiNewList) {
                if (BizUtil.isBlank(mihasinhubi.getDisphubinaiyoumsg())) {
                    throw new BizLogicException(MessageId.EBF0119);
                }
                if (C_HassinsakiKbn.KOK.eq(mihasinhubi.getDisphassinsakikbn())) {
                    hasinsakiKokakuUmuKbn = C_UmuKbn.ARI;
                    hasinsakiKokakuCount++;
                }
                else if (C_HassinsakiKbn.SISYA.eq(mihasinhubi.getDisphassinsakikbn())) {
                    hasinsakiSisyaUmuKbn = C_UmuKbn.ARI;
                    hasinsakiSisyaCount++;
                }
                else if (C_HassinsakiKbn.SYA.eq(mihasinhubi.getDisphassinsakikbn())) {
                    hasinsakiHonsyajimubumonUmuKbn = C_UmuKbn.ARI;
                    hasinsakiHonsyajimubumonCount++;
                }
            }
            if (C_UmuKbn.ARI.eq(hasinsakiKokakuUmuKbn)) {
                if (BizUtil.isBlank(uiBean.getRenrakusakinmkj())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_RENRAKUSAKINM_RENRAKUSAKINMKJ.getErrorResourceKey()));
                }
                if (BizUtil.isBlank(uiBean.getTsinyno())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_RENRAKUSAKIINFO_TSINYNO.getErrorResourceKey()));
                }
                if (BizUtil.isBlank(uiBean.getTsinadr1kj())) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_RENRAKUSAKIINFO_TSINADR1KJ.getErrorResourceKey()));
                }
            }
            if (C_UmuKbn.ARI.eq(hasinsakiSisyaUmuKbn) && BizUtil.isBlank(uiBean.getSisyacd())) {
                throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(MessageId.IJW1035));
            }

            if (BizUtil.isBlank(uiBean.getToiawasesosikinmkj())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_TOIAWASEINFO_TOIAWASESOSIKINMKJ.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getToiawasetelno())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_TOIAWASEINFO_TOIAWASETELNO.getErrorResourceKey()));
            }

            if (mihasinhubiNewList.size() == 0) {
                throw new BizLogicException(MessageId.EBF0119);
            }
        }

        String sosiki = "";
        if (!BizUtil.isBlank(uiBean.getSisyacd())) {
            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(uiBean.getSisyacd() + SISYACD_SITA_FOUR);

            sosiki = bzGetSosikiDataBean.getKanjisosikinm20();
            if (C_SosikimasterUmuKbn.NONE.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                throw new BizLogicException(MessageId.EJA1022);
            }
        }
        if (hasinsakiKokakuCount > DOUITU_MAX_ROW_COUNT  || hasinsakiSisyaCount > DOUITU_MAX_ROW_COUNT
            || hasinsakiHonsyajimubumonCount > DOUITU_MAX_ROW_COUNT) {
            throw new BizLogicException(MessageId.EIF1036, STR_DOUITU_MAX_ROW_COUNT);
        }

        if(!karisakusei){
            if (C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn()) && BizUtil.isBlank(uiBean.getTennousakisousasyacd())) {
                throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(MessageId.IJW1033));
            }

            if (!BizUtil.isBlank(uiBean.getTennousakisousasyacd()) && !C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())) {
                throw new BizLogicException(MessageId.EBC0012, MessageUtil.getMessage(MessageId.IJW1033));
            }

            uiBean.setHasinsakiKokakuUmuKbn(hasinsakiKokakuUmuKbn);
            uiBean.setHasinsakiSisyaUmuKbn(hasinsakiSisyaUmuKbn);
            uiBean.setHasinsakiHonsyajimubumonUmuKbn(hasinsakiHonsyajimubumonUmuKbn);

            uiBean.setSisyanm(sosiki);

            List<MihasinhubiListDataSourceBean> mihasinhubiNewList2 = new ArrayList<>();
            for (int index = 0; index < mihasinhubiNewList.size(); index++) {

                MihasinhubiListDataSourceBean mihasinhubiListDSBean = mihasinhubiNewList.get(index);

                String wkdsyoruinm = mihasinhubiListDSBean.getDisphubisyoruinm();
                String wkdhubinaiyoumsg = mihasinhubiListDSBean.getDisphubinaiyoumsg();

                if(!BizUtil.isBlank(wkdsyoruinm) || !BizUtil.isBlank(wkdhubinaiyoumsg)){

                    MihasinhubiListDataSourceBean mihasinhubiListDSBeanNew = new MihasinhubiListDataSourceBean();
                    mihasinhubiListDSBeanNew.setDisptrkymd(mihasinhubiListDSBean.getDisptrkymd());
                    mihasinhubiListDSBeanNew.setDispsyoruicd(mihasinhubiListDSBean.getDispsyoruicd());
                    mihasinhubiListDSBeanNew.setDisphubisyoruinm(wkdsyoruinm);
                    mihasinhubiListDSBeanNew.setDispgenponhnkykumuchkbox(mihasinhubiListDSBean.getDispgenponhnkykumuchkbox());

                    mihasinhubiListDSBeanNew.setDisphassinsakikbn(mihasinhubiListDSBean.getDisphassinsakikbn());
                    mihasinhubiListDSBeanNew.setDispkaisyouymd(mihasinhubiListDSBean.getDispkaisyouymd());
                    mihasinhubiListDSBeanNew.setSakujyoLink(mihasinhubiListDSBean.getSakujyoLink());
                    mihasinhubiListDSBeanNew.setSakujyoflg(mihasinhubiListDSBean.getSakujyoflg());
                    mihasinhubiListDSBeanNew.setDisphubinaiyoumsg(wkdhubinaiyoumsg);
                    mihasinhubiListDSBeanNew.setHubinaiyoucd(mihasinhubiListDSBean.getHubinaiyoucd());
                    mihasinhubiListDSBeanNew.setSakujyoflg2(mihasinhubiListDSBean.getSakujyoflg2());


                    mihasinhubiListDSBeanNew.setDispHubiTourokuTantouId2(mihasinhubiListDSBean.getDispHubiTourokuTantouId());
                    mihasinhubiListDSBeanNew.setDispnyuryokutantounm2(mihasinhubiListDSBean.getDispnyuryokutantounm());

                    if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())){
                        if (C_SikinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())) {
                            mihasinhubiListDSBeanNew.setDispHubiTourokuTantouId(baseUserInfo.getUserId());
                            mihasinhubiListDSBeanNew.setDispnyuryokutantounm(baseUserInfo.getUserNm());
                        }
                        if (C_SikinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                            if(BizUtil.isBlank(mihasinhubiListDSBean.getDispHubiTourokuTantouId())){
                                mihasinhubiListDSBeanNew.setDispHubiTourokuTantouId(baseUserInfo.getUserId());
                                mihasinhubiListDSBeanNew.setDispnyuryokutantounm(baseUserInfo.getUserNm());
                            }else{
                                mihasinhubiListDSBeanNew.setDispHubiTourokuTantouId(mihasinhubiListDSBean.getDispHubiTourokuTantouId());
                                mihasinhubiListDSBeanNew.setDispnyuryokutantounm(mihasinhubiListDSBean.getDispnyuryokutantounm());
                            }
                            mihasinhubiListDSBeanNew.setDispHubiSyouninnTantouId(baseUserInfo.getUserId());
                            mihasinhubiListDSBeanNew.setDispsyounintantounm(baseUserInfo.getUserNm());
                            mihasinhubiListDSBeanNew.setDisphassinymd(BizDate.getSysDate());
                        }
                    }
                    if(C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn())){
                        mihasinhubiListDSBeanNew.setDispHubiTourokuTantouId("");
                        mihasinhubiListDSBeanNew.setDispnyuryokutantounm("");
                    }
                    if(C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn()) ||
                        C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())){
                        mihasinhubiListDSBeanNew.setDispHubiTourokuTantouId(mihasinhubiListDSBean.getDispHubiTourokuTantouId());
                        mihasinhubiListDSBeanNew.setDispnyuryokutantounm(mihasinhubiListDSBean.getDispnyuryokutantounm());
                    }
                    mihasinhubiNewList2.add(mihasinhubiListDSBeanNew);
                }
            }
            uiBean.getMihasinhubiListDataSource().setDatas(null);
            uiBean.setMihasinhubiList(mihasinhubiNewList2);
        }
    }

    private String getForwardNameInput(Boolean pTagamenKidouHanteiFlg,C_UmuKbn pItiranKeiyuUmuKbn){

        BizPropertyInitializer.initialize(uiBean);

        if(pTagamenKidouHanteiFlg){
            uiBean.setTagamenKidouHanteiFlg(true);
        }else{
            uiBean.setTagamenKidouHanteiFlg(false);
        }

        if(pItiranKeiyuUmuKbn.eq(C_UmuKbn.ARI)){
            uiBean.setItiranKeiyuUmuKbn(C_UmuKbn.ARI);
        }else{
            uiBean.setItiranKeiyuUmuKbn(C_UmuKbn.NONE);
        }

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();
        if (C_SikinouModeIdKbn.DEFAULT.getValue().equals(kinouMode.getKinouMode())) {
            throw new BizLogicException(MessageId.EBS0003);
        }

        keiyakuInfoSyutoku();

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryComparatorWorkListHyoujijun korkListHyoujijun = SWAKInjector.getInstance(
            BzGetProcessSummaryComparatorWorkListHyoujijun.class);

        if(pItiranKeiyuUmuKbn.eq(C_UmuKbn.ARI)){
            summaryInBean.setKouteiKanriId(uiBean.getSelectDataListDataSource().getSelectedBean().getHubiSikibetuKey());
            summaryInBean.setSkNos(new String[]{uiBean.getSelectDataListDataSource().getSelectedBean().getSkno()});
        }else{
            if(uiBean.isTagamenKidouHanteiFlg()){
                summaryInBean.setSkNos(new String[]{uiBean.getSkno()});
            }
        }
        summaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
        summaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        summaryInBean.setSyoNo(uiBean.getSyono());
        summaryInBean.setSubSystemId(kinou.getSubSystemId());
        summaryInBean.setBzGetProcessSummaryComparator(korkListHyoujijun);
        List<BzGetProcessSummaryOutBean> outBeanList = bzGetProcessSummary.exec(summaryInBean);

        if (outBeanList.size() == 0) {
            throw new BizLogicException(MessageId.EBF0118);
        }

        for (int cnt = 0 ; cnt < outBeanList.size(); cnt++) {
            BzGetProcessSummaryInBean inBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            inBean.setSyoNo(uiBean.getSyono());
            inBean.setSubSystemId(kinou.getSubSystemId());
            inBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            inBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU);
            List<BzGetProcessSummaryOutBean> outBeanListHubi = bzGetProcessSummary.exec(inBean);
            if (outBeanListHubi.size() > 0) {
                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1032));
            }
        }

        if (outBeanList.size() == 1) {
            JT_SkKihon skKihon = siharaiDomManager.getSkKihon(outBeanList.get(0).getSkNo(),
                outBeanList.get(0).getSyoNo());
            if (skKihon == null) {
                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1031));
            }
            uiBean.setSkKihon(skKihon);

            if (!C_SikinouModeIdKbn.SATEI1.getValue().equals(outBeanList.get(0).getNowNodoId())
                && !C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.getValue().equals(outBeanList.get(0).getNowNodoId())
                && !C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.getValue().equals(outBeanList.get(0).getNowNodoId())
                && !C_SikinouModeIdKbn.HUBIKANRITYUU.getValue().equals(outBeanList.get(0).getNowNodoId())
                && !C_SikinouModeIdKbn.KAKUNINIRAITYUU.getValue().equals(outBeanList.get(0).getNowNodoId())) {
                throw new BizLogicException(MessageId.EJA1021);
            }

            uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(outBeanList.get(0).getKouteiKanriId());
            uiBean.getBzWorkflowInfo().setOyaKouteiJimuTetuzukiCd(outBeanList.get(0).getJimuTetuzukiCd());
            uiBean.setHubiSikibetuKey(outBeanList.get(0).getKouteiKanriId());
            uiBean.setJimuTetuzukiCd(outBeanList.get(0).getJimuTetuzukiCd());
            uiBean.setVktifdispjimutetuzukinm(outBeanList.get(0).getJimuTetuzukiNm());
            uiBean.setSkno(outBeanList.get(0).getSkNo());
            uiBean.setJimuyoucd(outBeanList.get(0).getJimuyoucd());
            uiBean.setJmycdMisetteiKbn(outBeanList.get(0).getJmycdMisetteiKbn());

            if(!uiBean.isTagamenKidouHanteiFlg()){
                BzCommonLockProcess lockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
                lockProcess.lockProcess(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
                    uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());
            }

            naiyougamenInfoGetset(outBeanList);

            return FORWARDNAME_INPUTCONTENTS;
        }

        List<SelectDataListDataSourceBean> selectDataList = Lists.newArrayList();
        int selectDataListCount = 1;
        for (BzGetProcessSummaryOutBean summaryOutBean : outBeanList) {
            if (selectDataListCount > SELECTDATA_MAX_ROW_COUNT) {
                break;
            }
            SelectDataListDataSourceBean selectData = SWAKInjector.getInstance(SelectDataListDataSourceBean.class);
            selectData.setJimutetuzukicd(summaryOutBean.getJimuTetuzukiCd());
            selectData.setJimutetuzukinm(summaryOutBean.getJimuTetuzukiNm());
            selectData.setJimustartymd(summaryOutBean.getJimuStartYmd());
            selectData.setHubiSikibetuKey(summaryOutBean.getKouteiKanriId());
            selectData.setSkno(summaryOutBean.getSkNo());
            selectData.setNyuuryokuLink(MessageUtil.getMessage(DDID_SELECTDATALIST_NYUURYOKULINK.getErrorResourceKey()));
            selectDataList.add(selectData);
            selectDataListCount ++;
        }

        Ordering<SelectDataListDataSourceBean> ordering = Ordering.from(new SelectDataListComparator());
        selectDataList = ordering.sortedCopy(selectDataList);

        uiBean.setSelectDataList(selectDataList);

        return FORWARDNAME_SELECTDATA;
    }

    private void setMihasinhubi(SiHubiTourokuUiBean uiBean){

        BizDate sysDate = BizDate.getSysDate();
        List<MihasinhubiListDataSourceBean> mihasinList = uiBean.getMihasinhubiListDataSource().getAllData();

        for (int cnt = 0 ; cnt < mihasinList.size(); cnt++) {
            if (C_SikinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())) {
                mihasinList.get(cnt).setDispHubiTourokuTantouId("");
                mihasinList.get(cnt).setDispnyuryokutantounm("");
            }
            if (C_SikinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                mihasinList.get(cnt).setDisphassinymd(null);
                mihasinList.get(cnt).setDispHubiSyouninnTantouId("");
                mihasinList.get(cnt).setDispsyounintantounm("");
                mihasinList.get(cnt).setDispHubiTourokuTantouId(mihasinList.get(cnt).getDispHubiTourokuTantouId2());
                mihasinList.get(cnt).setDispnyuryokutantounm(mihasinList.get(cnt).getDispnyuryokutantounm2());
            }
        }
        for (int i = mihasinList.size(); i < MAX_ROW_COUNT; i++) {
            MihasinhubiListDataSourceBean dataSourceBean = SWAKInjector.getInstance(
                MihasinhubiListDataSourceBean.class);
            dataSourceBean.setDisptrkymd(sysDate);
            dataSourceBean.setDispgenponhnkykumuchkbox(false);
            if (C_SikinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())) {
                dataSourceBean.setDispHubiTourokuTantouId("");
                dataSourceBean.setDispnyuryokutantounm("");
            }
            dataSourceBean.setSakujyoLink(MessageUtil.getMessage(
                DDID_MIHASINHUBILIST_SAKUJYOLINK.getErrorResourceKey()));
            if (C_SikinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                dataSourceBean.setDisphassinymd(null);
                dataSourceBean.setDispHubiSyouninnTantouId("");
                dataSourceBean.setDispsyounintantounm("");
            }
            if(i == 0){
                dataSourceBean.setSakujyoflg(C_Delflag.BLNK);
                dataSourceBean.setSakujyoflg2(C_Delflag.BLNK);
            }
            else {
                dataSourceBean.setSakujyoflg(C_Delflag.SAKUJYO);
                dataSourceBean.setSakujyoflg2(C_Delflag.SAKUJYO);
            }
            mihasinList.add(dataSourceBean);
        }
        uiBean.setMihasinhubiList(mihasinList);
    }
}
