package yuyu.app.siharai.sihubikanri.sihubikaisyou;

import static yuyu.app.siharai.sihubikanri.sihubikaisyou.GenSiHubiKaisyouConstants.*;
import static yuyu.app.siharai.sihubikanri.sihubikaisyou.SiHubiKaisyouConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceProcessForward;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryComparatorWorkListHyoujijun;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
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
import yuyu.common.siharai.sicommon.SiKinouModeSettei;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdBean;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JW_HubiKaisyouDetailWk;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SiHubiDetail;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 保険金給付金不備解消 のビジネスロジックです。
 */
public class SiHubiKaisyouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiHubiKaisyouUiBean uiBean;

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
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageManager;

    void init() {
    }

    void clear() {
    }

    String pushKetteiBL() {

        BizPropertyInitializer.initialize(uiBean);

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();
        if (C_SikinouModeIdKbn.DEFAULT.getValue().equals(kinouMode.getKinouMode())) {
            throw new BizLogicException(MessageId.EBS0003);
        }

        uiBean.setItiranKeiyuUmuKbn(C_UmuKbn.NONE);

        keiyakuInfoSyutoku();

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryComparatorWorkListHyoujijun korkListHyoujijun = SWAKInjector.getInstance(
            BzGetProcessSummaryComparatorWorkListHyoujijun.class);
        summaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        summaryInBean.setSyoNo(uiBean.getSyono());
        summaryInBean.setSubSystemId(kinou.getSubSystemId());
        summaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);
        summaryInBean.setBzGetProcessSummaryComparator(korkListHyoujijun);
        summaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);
        List<BzGetProcessSummaryOutBean> outBeanList = bzGetProcessSummary.exec(summaryInBean);

        if (outBeanList.size() == 0) {
            throw new BizLogicException(MessageId.EBF0118);
        }

        List<BzGetProcessSummaryOutBean> hubiList = Lists.newArrayList();
        List<BzGetProcessSummaryOutBean> syukouteiList = Lists.newArrayList();
        for (BzGetProcessSummaryOutBean summaryOutBean : outBeanList) {
            BzGetProcessSummaryInBean inBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            BzGetProcessSummaryComparatorWorkListHyoujijun korkListHyoujijunHubi = SWAKInjector.getInstance(
                BzGetProcessSummaryComparatorWorkListHyoujijun.class);
            inBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU);
            inBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            inBean.setSyoNo(uiBean.getSyono());
            inBean.setSubSystemId(kinou.getSubSystemId());
            inBean.setSyukouteiSiborikomiUmu(C_UmuKbn.NONE);
            inBean.setBzGetProcessSummaryComparator(korkListHyoujijunHubi);
            inBean.setTaskIds(new String[]{TeisuuSiharai.NODEID_HUBIKAITOUMATI,TeisuuSiharai.NODEID_HUBIKAISYOU});

            List<BzGetProcessSummaryOutBean> outBeanListHubi = bzGetProcessSummary.exec(inBean);
            if (outBeanListHubi.size() > 0) {
                hubiList.add(outBeanListHubi.get(0));
                syukouteiList.add(summaryOutBean);
            }
        }

        if (hubiList.size() == 0) {
            throw new BizLogicException(MessageId.EBF0114);
        }

        if (hubiList.size() == 1) {
            BzCommonLockProcess lockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
            lockProcess.lockProcess(syukouteiList.get(0).getKouteiKanriId(), syukouteiList.get(0).getJimuTetuzukiCd());

            naiyougamenInfoGetset(hubiList, syukouteiList);

            BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
            C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean .getBzWorkflowInfo().getJimuTetuzukiCd(), uiBean.getBzWorkflowInfo().getTaskId(),
                lockProcess.getKouteiLockKey());
            if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
                throw new BizLogicException(MessageId.EBA0111);
            }

            uiBean.setAllPrintFlg(true);

            return FORWARDNAME_INPUTCONTENTS;
        }

        List<SelectDataListDataSourceBean> selectDataList = Lists.newArrayList();
        int selectDataListCount = 1;
        for (BzGetProcessSummaryOutBean summaryOutBean : syukouteiList) {
            if (selectDataListCount > SELECTDATA_MAX_ROW_COUNT) {
                break;
            }
            SelectDataListDataSourceBean selectData = SWAKInjector.getInstance(SelectDataListDataSourceBean.class);
            selectData.setJimutetuzukicd(summaryOutBean.getJimuTetuzukiCd());
            selectData.setJimutetuzukinm(summaryOutBean.getJimuTetuzukiNm());
            selectData.setJimustartymd(summaryOutBean.getJimuStartYmd());
            selectData.setOyaKouteiKanriId(summaryOutBean.getKouteiKanriId());
            selectData.setHubiSikibetuKey(summaryOutBean.getKouteiKanriId());
            selectData.setSkno(summaryOutBean.getSkNo());
            selectData.setNyuuryokuLink(MessageUtil.getMessage(DDID_SELECTDATALIST_NYUURYOKULINK.getErrorResourceKey()));
            selectDataList.add(selectData);
            selectDataListCount ++;
        }
        uiBean.setSelectDataList(selectDataList);

        return FORWARDNAME_SELECTDATA;
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
            uiBean .getBzWorkflowInfo().getJimuTetuzukiCd(), uiBean.getBzWorkflowInfo().getTaskId(),
            lockProcess.getKouteiLockKey());
        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
            uiBean.getBzWorkflowInfo().getKouteiKanriId());

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        keiyakuInfoSyutoku();

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        summaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
        summaryInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());
        summaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        summaryInBean.setSyoNo(gyoumuKouteiInfo.getSyono());
        summaryInBean.setSkNos(new String[]{gyoumuKouteiInfo.getSkno()});
        summaryInBean.setSubSystemId(kinou.getSubSystemId());
        List<BzGetProcessSummaryOutBean> syukouteiList = bzGetProcessSummary.exec(summaryInBean);

        BzGetProcessSummaryInBean inBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        inBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        inBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        inBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        inBean.setSyoNo(gyoumuKouteiInfo.getSyono());
        inBean.setSkNos(new String[]{gyoumuKouteiInfo.getSkno()});
        inBean.setSubSystemId(kinou.getSubSystemId());
        List<BzGetProcessSummaryOutBean> hubiList = bzGetProcessSummary.exec(inBean);

        JT_SiHubi siHubi = siharaiDomManager.getSiHubi(syukouteiList.get(0).getKouteiKanriId());
        if (siHubi == null) {
            throw new BizLogicException(MessageId.EBF0114);
        }

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(gyoumuKouteiInfo.getSkno(), gyoumuKouteiInfo.getSyono());
        if (skKihon == null) {
            throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1031));
        }

        naiyougamenInfoGetset(hubiList, syukouteiList);

        uiBean.setAllPrintFlg(true);

        return FORWARDNAME_INPUTCONTENTS;
    }

    String pushInputBL() {

        uiBean.setItiranKeiyuUmuKbn(C_UmuKbn.ARI);
        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(
            uiBean.getSelectDataListDataSource().getSelectedBean().getOyaKouteiKanriId());
        uiBean.getBzWorkflowInfo().setOyaKouteiJimuTetuzukiCd(
            uiBean.getSelectDataListDataSource().getSelectedBean().getJimutetuzukicd());
        uiBean.setSkno(uiBean.getSelectDataListDataSource().getSelectedBean().getSkno());
        uiBean.setHubiSikibetuKey(uiBean.getSelectDataListDataSource().getSelectedBean().getHubiSikibetuKey());

        BzCommonLockProcess lockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        lockProcess.lockProcess(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());

        List<BzGetProcessSummaryOutBean> syukouteiList = Lists.newArrayList();
        List<BzGetProcessSummaryOutBean> hubiList = Lists.newArrayList();

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        summaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
        List<BzGetProcessSummaryOutBean> outBeanList = bzGetProcessSummary.exec(summaryInBean);
        syukouteiList.add(outBeanList.get(0));

        BzGetProcessSummaryInBean inBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        inBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU);
        inBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        inBean.setSyoNo(uiBean.getSyono());
        inBean.setSkNos(new String[]{uiBean.getSelectDataListDataSource().getSelectedBean().getSkno()});
        List<BzGetProcessSummaryOutBean> outBeanListHubi = bzGetProcessSummary.exec(inBean);
        hubiList.add(outBeanListHubi.get(0));

        naiyougamenInfoGetset(hubiList, syukouteiList);

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean .getBzWorkflowInfo().getJimuTetuzukiCd(), uiBean.getBzWorkflowInfo().getTaskId(),
            lockProcess.getKouteiLockKey());
        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }

        uiBean.setAllPrintFlg(true);

        return FORWARDNAME_INPUTCONTENTS;
    }

    String pushModoruByInputContentsBL(){

        pushUnlockProcessBL();
        if (uiBean.isItiranGamenKeiyuSeigyo()) {
            for (MikaisyouhubiList1DataSourceBean mikaisyou : uiBean.getMikaisyouhubiList1DataSource().getAllData()) {
                mikaisyou.setCommonCheckBox(false);
                mikaisyou.setDispkaisyouymd(null);
            }

            return FORWARDNAME_SELECTDATA;
        }
        if (uiBean.isKidougmKbnWorkListSeigyo()) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    String pushKakuninBL(){

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        int kaisyouCount = 0;
        for (MikaisyouhubiList1DataSourceBean mikaisyou : uiBean.getMikaisyouhubiList1DataSource().getAllData()) {
            if (mikaisyou.getCommonCheckBox() &&
                (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                    C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn()))) {
                mikaisyou.setDispkaisyouymd(BizDate.getSysDate());
                kaisyouCount++;
            }
        }
        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())
            || C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())) {
            if (kaisyouCount == 0) {
                throw new BizLogicException(MessageId.EBF0115);
            }
            if (kaisyouCount != uiBean.getMikaisyouhubiList1DataSource().getAllData().size()) {
                throw new BizLogicException(MessageId.EBA1016);
            }
        }

        if (C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn()) && BizUtil.isBlank(uiBean.getTennousakisousasyacd())) {
            throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(MessageId.IJW1033));
        }

        if (!BizUtil.isBlank(uiBean.getTennousakisousasyacd()) && !C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())) {
            throw new BizLogicException(MessageId.EBC0012, MessageUtil.getMessage(MessageId.IJW1033));
        }

        messageManager.addMessageId(MessageId.QBA0001);


        return FORWARDNAME_CONFIRM;
    }

    String pushModoruBtnByConfirmBL(){

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        for (MikaisyouhubiList1DataSourceBean mikaisyou : uiBean.getMikaisyouhubiList1DataSource().getAllData()) {
            mikaisyou.setDispkaisyouymd(null);
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    @Transactional
    String pushKakuteiBL(){

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        BizDate sysDate = BizDate.getSysDate();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())
            || C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())) {
            JT_SiHubi siHubi = siharaiDomManager.getSiHubi(uiBean.getHubiSikibetuKey());
            List<JT_SiHubiDetail> siHubiDetailList = siHubi.getSiHubiDetails();
            for (MikaisyouhubiList1DataSourceBean mikaisyou : uiBean.getMikaisyouhubiList1DataSource().getAllData()) {
                if (mikaisyou.getCommonCheckBox()) {
                    for (JT_SiHubiDetail siHubiDetail : siHubiDetailList) {
                        if (siHubiDetail.getRenno3keta().equals(mikaisyou.getRenno3ketay())) {
                            siHubiDetail.setKaisyouymd(sysDate);
                            siHubiDetail.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            siHubiDetail.setGyoumuKousinTime(sysDateTimeMilli);
                        }
                    }
                }
            }
            siharaiDomManager.update(siHubi);

            List<JW_HubiKaisyouDetailWk> detailWkList = siharaiDomManager.getHubiKaisyouDetailWksByKouteikanriid(
                uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
            siharaiDomManager.delete(detailWkList);
        }

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
            JT_SkKihon skKihon = uiBean.getSkKihon();
            skKihon.setHubijyoukyoukbn(C_HubiJyoukyouKbn.KAISYOU);
            skKihon.setKossyoricd(kinou.getKinouId());
            skKihon.setKossyorisscd(kinouMode.getKinouMode());
            skKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            skKihon.setGyoumuKousinTime(sysDateTimeMilli);
            siharaiDomManager.update(skKihon);
        }

        if (C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())
            || C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())) {
            List<JW_HubiKaisyouDetailWk> detailWkList = siharaiDomManager.getHubiKaisyouDetailWksByKouteikanriid(
                uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
            if (detailWkList.size() == 0) {
                for (MikaisyouhubiList1DataSourceBean mikaisyou : uiBean.getMikaisyouhubiList1DataSource().getAllData()) {
                    JW_HubiKaisyouDetailWk hubiKaisyouDetailWk = new JW_HubiKaisyouDetailWk();
                    hubiKaisyouDetailWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
                    hubiKaisyouDetailWk.setRenno3keta(mikaisyou.getRenno3ketay());
                    if (mikaisyou.getCommonCheckBox()) {
                        hubiKaisyouDetailWk.setHubikaisyouumukbn(C_UmuKbn.ARI);
                    }
                    else {
                        hubiKaisyouDetailWk.setHubikaisyouumukbn(C_UmuKbn.NONE);
                    }
                    hubiKaisyouDetailWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    hubiKaisyouDetailWk.setGyoumuKousinTime(sysDateTimeMilli);
                    BizPropertyInitializer.initialize(hubiKaisyouDetailWk);
                    detailWkList.add(hubiKaisyouDetailWk);
                }
                siharaiDomManager.insert(detailWkList);
            }
            else {
                for (MikaisyouhubiList1DataSourceBean mikaisyou : uiBean.getMikaisyouhubiList1DataSource().getAllData()) {
                    for (JW_HubiKaisyouDetailWk hubiKaisyouDetailWk : detailWkList) {
                        if (hubiKaisyouDetailWk.getRenno3keta().equals(mikaisyou.getRenno3ketay())) {
                            if (mikaisyou.getCommonCheckBox()) {
                                hubiKaisyouDetailWk.setHubikaisyouumukbn(C_UmuKbn.ARI);
                            }
                            else {
                                hubiKaisyouDetailWk.setHubikaisyouumukbn(C_UmuKbn.NONE);
                            }
                            hubiKaisyouDetailWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            hubiKaisyouDetailWk.setGyoumuKousinTime(sysDateTimeMilli);
                        }
                    }
                }
                siharaiDomManager.update(detailWkList);
            }
        }

        if (uiBean.getSiHubi() != null) {
            siharaiDomManager.update(uiBean.getSiHubi());
        }

        if (uiBean.getBzWorkflowInfo().getTaskId().equals(C_SikinouModeIdKbn.HUBIKAITOUMATI.getValue())){
            BzForceProcessForward bzForceProcessForward = SWAKInjector.getInstance(BzForceProcessForward.class);
            bzForceProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU, C_SikinouModeIdKbn.HUBIKAISYOU.getValue(), bzCommonLockProcess.getKouteiLockKey());
        }

        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);
        siRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        siProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
            .getJimuTetuzukiCd(), bzCommonLockProcess.getKouteiLockKey(), uiBean.getSyanaicomment(), siRuleBean,
            uiBean.getTennousakisousasyacd());

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            BzGetProcessSummaryInBean inBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            inBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
            inBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getOyaKouteiJimuTetuzukiCd());
            inBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            inBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);
            inBean.setSubSystemId(kinou.getSubSystemId());
            List<BzGetProcessSummaryOutBean> syukouteiList = bzGetProcessSummary.exec(inBean);
            if(C_SikinouModeIdKbn.HUBIKANRITYUU.getValue().equals(syukouteiList.get(0).getNowNodoId())){
                siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);
                siRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
                siProcessForward.exec(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(), uiBean.getBzWorkflowInfo()
                    .getOyaKouteiJimuTetuzukiCd(), bzCommonLockProcess.getKouteiLockKey(), "",
                    siRuleBean, "");
            }
        }

        pushUnlockProcessBL();

        messageManager.addMessageId(MessageId.IAC0009);

        return FORWARDNAME_RESULT;
    }

    String pushFunctionNameBL(){

        String forwardName = "";

        if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM) {
            pushUnlockProcessBL();
        }

        if ((uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM ||
            uiBean.getPageNo() == PAGENO_RESULT) && C_UmuKbn.ARI.eq(uiBean.getItiranKeiyuUmuKbn())) {
            forwardName = FORWARDNAME_NESTEDEND;
            return forwardName;
        }

        forwardName = pushNestedEndBL();

        return forwardName;
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

    String pushNestedEndBL() {

        if (uiBean.isKidougmKbnWorkListSeigyo()) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    void pushTojiruBL(){

        if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM) {
            pushUnlockProcessBL();
        }
    }

    void printHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImageAll(uiBean.getImageids());
        uiBean.setAllPrintFlg(false);
    }

    void pushUnlockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.unlockProcess();
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
    }

    private void naiyougamenInfoGetset(List<BzGetProcessSummaryOutBean> hubiList,
        List<BzGetProcessSummaryOutBean> syukouteiList) {

        BzGetProcessSummaryOutBean hubiBean = hubiList.get(0);
        BzGetProcessSummaryOutBean syukouteiBean = syukouteiList.get(0);

        uiBean.setSkno(hubiBean.getSkNo());
        uiBean.setHubiSikibetuKey(syukouteiBean.getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setKouteiKanriId(hubiBean.getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(hubiBean.getJimuTetuzukiCd());
        uiBean.getBzWorkflowInfo().setTaskId(hubiBean.getNowNodoId());
        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(syukouteiBean.getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setOyaKouteiJimuTetuzukiCd(syukouteiBean.getJimuTetuzukiCd());

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(uiBean.getSkno(), uiBean.getSyono());
        uiBean.setSkKihon(skKihon);

        JT_SiHubi siHubi = siharaiDomManager.getSiHubi(uiBean.getHubiSikibetuKey());
        uiBean.setSiHubi(siHubi);

        List<JT_SiHubiDetail> siHubiDetailListZumi = siHubi.getSiHubiDetailsByHasinymdNotNullKaisyouymdNotNull();
        SortJT_SiHubiDetail siHubiDetailSort = SWAKInjector.getInstance(SortJT_SiHubiDetail.class);
        siHubiDetailListZumi = siHubiDetailSort.OrderJT_SiHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(siHubiDetailListZumi);

        List<JT_SiHubiDetail> siHubiDetailListMi = siHubi.getSiHubiDetailsByHasinymdNotNullKaisyouymdNull();
        siHubiDetailListMi = siHubiDetailSort.OrderJT_SiHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(siHubiDetailListMi);

        List<JW_HubiKaisyouDetailWk> hubiKaisyouDetailWkList = siharaiDomManager.getHubiKaisyouDetailWksByKouteikanriid(
            uiBean.getHubiSikibetuKey());

        List<UsersByKinouIdKinouModeIdUserIdBean> userList = bizDomManager.getUsersByKinouIdKinouModeIdUserId(kinou.getKinouId(), kinouMode.getKinouMode(),
            baseUserInfo.getUserId());

        uiBean.setSyono(syukouteiBean.getSyoNo());
        uiBean.setSkno(syukouteiBean.getSkNo());

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);

        List<KaisyouzumihubiListDataSourceBean> kaisyouzumiList = Lists.newArrayList();
        for (JT_SiHubiDetail siHubiDetail : siHubiDetailListZumi) {
            KaisyouzumihubiListDataSourceBean dataSourceBean = SWAKInjector.getInstance(
                KaisyouzumihubiListDataSourceBean.class);
            dataSourceBean.setCommonCheckBox(true);
            dataSourceBean.setTrkymd(siHubiDetail.getTrkymd());
            dataSourceBean.setHubinaiyoumsg(siHubiDetail.getHubinaiyoumsg());
            if (C_UmuKbn.ARI.eq(siHubiDetail.getGenponhnkykumu())) {
                dataSourceBean.setGenponhnkykumuchkbox(true);
            }
            else {
                dataSourceBean.setGenponhnkykumuchkbox(false);
            }
            dataSourceBean.setHasinymd(siHubiDetail.getHasinymd());
            dataSourceBean.setHassinsakikbn(siHubiDetail.getHassinsakikbn());
            AM_User tourokuUser = baseDomManager.getUser(siHubiDetail.getHubitourokuktntid());
            if (tourokuUser != null) {
                dataSourceBean.setNyuuryokutantounm(tourokuUser.getUserNm());
            }
            AM_User syouninUser = baseDomManager.getUser(siHubiDetail.getHubisyouninktntid());
            if (syouninUser != null) {
                dataSourceBean.setSyounintantounm(syouninUser.getUserNm());
            }
            dataSourceBean.setKaisyouymd(siHubiDetail.getKaisyouymd());

            kaisyouzumiList.add(dataSourceBean);
        }
        uiBean.setKaisyouzumihubiList(kaisyouzumiList);

        List<MikaisyouhubiList1DataSourceBean> mikaisyouList = Lists.newArrayList();
        for (JT_SiHubiDetail siHubiDetail : siHubiDetailListMi) {
            MikaisyouhubiList1DataSourceBean dataSourceBean = SWAKInjector.getInstance(
                MikaisyouhubiList1DataSourceBean.class);
            for (JW_HubiKaisyouDetailWk hubiKaisyouDetailWk : hubiKaisyouDetailWkList) {
                if (siHubiDetail.getRenno3keta().equals(hubiKaisyouDetailWk.getRenno3keta())
                    && C_UmuKbn.ARI.eq(hubiKaisyouDetailWk.getHubikaisyouumukbn())) {
                    dataSourceBean.setCommonCheckBox(true);
                    break;
                }

                dataSourceBean.setCommonCheckBox(false);
            }
            dataSourceBean.setRenno3keta(siHubiDetail.getRenno3keta());
            dataSourceBean.setTrkymd(siHubiDetail.getTrkymd());
            dataSourceBean.setDisphubinaiyoumsg(siHubiDetail.getHubinaiyoumsg());
            if (C_UmuKbn.ARI.eq(siHubiDetail.getGenponhnkykumu())) {
                dataSourceBean.setDispgenponhnkykumuchkbox(true);
            }
            else {
                dataSourceBean.setDispgenponhnkykumuchkbox(false);
            }
            dataSourceBean.setDisphassinymd(siHubiDetail.getHasinymd());
            dataSourceBean.setDisphassinsakikbn(siHubiDetail.getHassinsakikbn());
            AM_User tourokuUser = baseDomManager.getUser(siHubiDetail.getHubitourokuktntid());
            if (tourokuUser != null) {
                dataSourceBean.setDispnyuryokutantounm(tourokuUser.getUserNm());
            }
            AM_User syouninUser = baseDomManager.getUser(siHubiDetail.getHubisyouninktntid());
            if (syouninUser != null) {
                dataSourceBean.setDispsyounintantounm(syouninUser.getUserNm());
            }

            mikaisyouList.add(dataSourceBean);
        }
        uiBean.setMikaisyouhubiList1(mikaisyouList);

        uiBean.setRenrakuarea(siHubi.getRenrakuarea());

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
    }
}
