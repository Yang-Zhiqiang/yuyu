package yuyu.app.hozen.khhubikanri.khhubikaisyou;

import static yuyu.app.hozen.khhubikanri.khhubikaisyou.GenKhHubiKaisyouConstants.*;
import static yuyu.app.hozen.khhubikanri.khhubikaisyou.KhHubiKaisyouConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khhubikanri.khhubikaisyou.KhHubiKaisyouConstants.E_SyoriKeiyu;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceProcessForward;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_KaisyoutaisyouKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SasimodosisakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.entity.IT_KhHubiDetail;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IW_KhHubiKaisyouDetailWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KhHubiDetail;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Ordering;

/**
 * 契約保全不備解消 のビジネスロジックです。
 */
public class KhHubiKaisyouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhHubiKaisyouUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KinouMode kinouMode;

    void init() {
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();
    }

    void pushUnlockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.unlockProcess();
    }

    void continueLockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }

    String pushKakuteBL() {

        BizPropertyInitializer.initialize(uiBean);

        String forward = null;
        String syono = uiBean.getSyono();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        if (kykKihon == null) {

            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);

        inputKeySyoriKengen();

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        summaryInBean.setSyoNo(uiBean.getSyono());

        summaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        summaryInBean.setSubSystemId(kinou.getSubSystemId());

        summaryInBean.setTaskIds(new String[] { IKhozenCommonConstants.TASKID_HUBIKAITOUMATI,
            IKhozenCommonConstants.TASKID_HUBIKAISYOU });

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        List<BzGetProcessSummaryOutBean> outBeanList = bzGetProcessSummary.exec(summaryInBean);

        int kensuu = 0;

        kensuu = outBeanList.size();

        if (kensuu == 0) {
            throw new BizLogicException(MessageId.EBF0114);
        }

        String[] hubiSikibetuKeys = new String[kensuu];

        for (int index = 0; index < kensuu; index++) {

            hubiSikibetuKeys[index] = outBeanList.get(index).getKouteiKanriId();
        }

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyonoHubisikibetukeys(syono, hubiSikibetuKeys);

        if (khHubiLst.size() == 0) {

            throw new BizLogicException(MessageId.EBF0114);
        }

        String userId = baseUserInfo.getUserId();
        CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

        if (kensuu == 1) {

            BzGetProcessSummaryOutBean outBean = outBeanList.get(0);

            if (!checkTaskKengen.exec(userId, outBean.getJimuTetuzukiCd(), outBean.getNowNodoId())) {
                throw new BizLogicException(MessageId.EBS0003);
            }

            setProcess(outBean);

            forward = FORWARDNAME_INPUTCONTENTS;

        }
        else if (kensuu > 1) {
            String nyuuryokuLink = MessageUtil.getMessage(
                KhHubiKaisyouConstants.DDID_SELECTDATALIST_NYUURYOKULINK.getErrorResourceKey());
            List<SelectDataListDataSourceBean> selDataBeanList = new ArrayList<>();

            BzGetProcessSummaryOutBean outBeanSave = null;

            for (int i = 0; i < kensuu; i++) {
                for (IT_KhHubi khHubi : khHubiLst) {
                    String hubisikibetukey = khHubi.getHubisikibetukey();
                    if (outBeanList.get(i).getKouteiKanriId().equals(hubisikibetukey)) {

                        if (!checkTaskKengen.exec(userId,
                            outBeanList.get(i).getJimuTetuzukiCd(),
                            outBeanList.get(i).getNowNodoId())) {
                            continue;
                        }
                        SelectDataListDataSourceBean selDataBean = new SelectDataListDataSourceBean();
                        selDataBean.setHubiSikibetuKey(outBeanList.get(i).getKouteiKanriId());
                        selDataBean.setDispJimutetuzukicd(outBeanList.get(i).getJimuTetuzukiCd());
                        selDataBean.setDispjimutetuzukinm(outBeanList.get(i).getJimuTetuzukiNm());
                        selDataBean.setDispjimustartymd(outBeanList.get(i).getJimuStartYmd());
                        selDataBean.setNyuuryokuLink(nyuuryokuLink);
                        selDataBean.setTaskId(outBeanList.get(i).getNowNodoId());
                        selDataBeanList.add(selDataBean);
                        outBeanSave = outBeanList.get(i);
                    }
                }
            }
            if (0 == selDataBeanList.size()) {
                throw new BizLogicException(MessageId.EBS0003);
            } else if (1 == selDataBeanList.size()) {
                setProcess(outBeanSave);
                forward = FORWARDNAME_INPUTCONTENTS;
            } else {

                SelectDataListDataSourceBeanSortComparator selectDataListDataSourceBeanSortComparator =
                    SWAKInjector.getInstance(SelectDataListDataSourceBeanSortComparator.class);

                Ordering<SelectDataListDataSourceBean> ordering = Ordering.from(selectDataListDataSourceBeanSortComparator);

                selDataBeanList = ordering.sortedCopy(selDataBeanList);

                uiBean.setSelectDataList(selDataBeanList);
                uiBean.setSyoriKeiyuKbn(E_SyoriKeiyu.ITIRAN);
                forward = FORWARDNAME_SELECTDATA;
            }
        }

        return forward;

    }

    String pushNestedEndBL() {
        String forward = null;
        if (C_KhkinouModeIdKbn.DEFAULT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            forward = FORWARDNAME_INPUTKEY;
        }
        else {
            forward = FORWARDNAME_BACKTOWORKLIST;
        }
        return forward;

    }

    String pushKinouNmLink() {
        String forward = null;

        if (PAGENO_INPUTCONTENTS == uiBean.getPageNo() || PAGENO_CONFIRM == uiBean.getPageNo()) {
            pushUnlockProcessBL();
        }
        if ((PAGENO_INPUTCONTENTS == uiBean.getPageNo() || PAGENO_CONFIRM == uiBean.getPageNo()
            || PAGENO_RESULT == uiBean.getPageNo()) && (E_SyoriKeiyu.ITIRAN == uiBean.getSyoriKeiyuKbn())) {

            forward = FORWARDNAME_NESTEDEND;
            return forward;

        }

        if (C_KhkinouModeIdKbn.DEFAULT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            forward = FORWARDNAME_INIT;
        }
        else {
            forward = FORWARDNAME_BACKTOWORKLIST;
        }
        return forward;

    }

    void pushInputBL() {

        BizPropertyInitializer.initialize(uiBean);

        String syono = null;

        SelectDataListDataSourceBean selectDataListDataSourceBean = SWAKInjector
            .getInstance(SelectDataListDataSourceBean.class);
        String kouteiKanriId = "";

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            selectDataListDataSourceBean = uiBean.getSelectDataListDataSource().getSelectedBean();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            kouteiKanriId = selectDataListDataSourceBean.getHubiSikibetuKey();
        }
        else {

            kouteiKanriId = uiBean.getBzWorkflowInfo().getKouteiKanriId();
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());
        syono = uiBean.getSyono();

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
            uiBean.setKykKihon(kykKihon);
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            uiBean.getBzWorkflowInfo().setKouteiKanriId(selectDataListDataSourceBean.getHubiSikibetuKey());
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(selectDataListDataSourceBean.getDispJimutetuzukicd());
            uiBean.getBzWorkflowInfo().setTaskId(selectDataListDataSourceBean.getTaskId());
        }

        String hubiSikibetuKey = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        SetKoutei();

        SetSyorui();

        setProgress();

        startKouteiKanri();

        setHubiInfo(hubiSikibetuKey);

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);
    }

    void printHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void pushKakuninBL() {

        continueLockProcessBL();

        int kaisyouTaisyouKensuu = 0;

        C_SyorikekkaKbn syorikekkaKbn = uiBean.getSyorikekkakbn();

        List<MikaisyouhubiListDataSourceBean> hubDataList = uiBean.getMikaisyouhubiListDataSource().getAllData();

        if (!C_SyorikekkaKbn.HORYUU.eq(syorikekkaKbn)) {
            for (MikaisyouhubiListDataSourceBean hubBean : hubDataList) {

                if (hubBean.getDispkaisyoutaisyou()) {
                    hubBean.setDispkaisyouymd(BizDate.getSysDate());
                    kaisyouTaisyouKensuu++;
                }
            }
        }

        String syanaicomment = uiBean.getSyanaicommentkh();

        if ((C_SyorikekkaKbn.KANRYOU.eq(syorikekkaKbn) || C_SyorikekkaKbn.HUBI.eq(syorikekkaKbn)) &&
            hubDataList.size() > kaisyouTaisyouKensuu) {

            throw new BizLogicException(MessageId.EIF1043);
        }

        if (C_SyorikekkaKbn.KAITOUMATI.eq(syorikekkaKbn) && hubDataList.size() <= kaisyouTaisyouKensuu) {

            throw new BizLogicException(MessageId.EIF1012);
        }

        if (C_SyorikekkaKbn.HUBI.eq(syorikekkaKbn) && BizUtil.isBlank(syanaicomment)) {

            throw new BizLogicException(MessageId.EIA1003, uiBean.getSyorikekkakbn().getContent());
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushmodoruBtnByConfirmBL() {

        List<MikaisyouhubiListDataSourceBean> mikaisyouhubiListDataSourceBeanLst = uiBean
            .getMikaisyouhubiListDataSource().getAllData();
        for (MikaisyouhubiListDataSourceBean mikaisyouhubiListDataSourceBean : mikaisyouhubiListDataSourceBeanLst) {

            if (mikaisyouhubiListDataSourceBean.getDispkaisyoutaisyou()) {
                mikaisyouhubiListDataSourceBean.setDispkaisyouymd(null);
            }
        }
    }

    @Transactional
    void pushKakuteiBL() {

        continueLockProcessBL();

        SortIT_KhHubiDetail sortIT_KhHubiDetail = SWAKInjector.getInstance(SortIT_KhHubiDetail.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String userId = khozenCommonParam.getUserID();
        String kinouId = khozenCommonParam.getFunctionId();
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        List<MikaisyouhubiListDataSourceBean> hubDataList = uiBean.getMikaisyouhubiListDataSource().getAllData();

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.KAITOUMATI.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())) {

            IT_KhHubi khHubi = uiBean.getKhHubi();

            for (MikaisyouhubiListDataSourceBean hubBean : hubDataList) {

                if ((C_KaisyoutaisyouKbn.TAISYOU).eq(hubBean.getDispkaisyoutaisyoukbn())) {

                    IT_KhHubiDetail khHubiDetail = khHubi.getKhHubiDetailByRenno3keta(hubBean.getRenno3ketay());

                    khHubiDetail.setKaisyouymd(sysDate);
                    khHubiDetail.setGyoumuKousinsyaId(userId);
                    khHubiDetail.setGyoumuKousinTime(sysDateTime);

                }
            }

            hozenDomManager.update(khHubi);

            hozenDomManager.delete(hozenDomManager.getKhHubiMikaisyouListsByJimutetuzukicdSyono(uiBean
                .getBzWorkflowInfo().getJimuTetuzukiCd(), uiBean.getSyono()));

            if (C_SyorikekkaKbn.KAITOUMATI.eq(uiBean.getSyorikekkakbn())) {

                List<IT_KhHubiDetail> allHubiDetail =
                    sortIT_KhHubiDetail.OrderIT_KhHubiDetailByPkDesc(khHubi.getKhHubiDetails());

                C_UmuKbn syaUmuKbn = C_UmuKbn.NONE;
                String syaTourokuNm = null;
                String syaSyouninNm = null;
                BizDate syaHassinYmd = null;
                C_UmuKbn kokUmuKbn = C_UmuKbn.NONE;
                String kokTourokuNm = null;
                String kokSyouninNm = null;
                BizDate kokHassinYmd = null;

                boolean syaExists = false;
                boolean kokExists = false;

                for (IT_KhHubiDetail tmp : allHubiDetail) {
                    if (tmp.getKaisyouymd() != null) {
                        continue;
                    }
                    if (C_HassinsakiKbn.SYA.eq(tmp.getHassinsakikbn())) {
                        syaExists = true;

                        if (syaHassinYmd == null) {
                            syaHassinYmd = tmp.getHasinymd();
                        }
                        if (BizUtil.isBlank(syaTourokuNm)) {
                            AM_User userTouroku = baseDomManager.getUser(tmp.getHubitourokuktntid());

                            if (userTouroku == null) {

                                syaTourokuNm = "";
                            }
                            else {

                                syaTourokuNm = userTouroku.getUserNm();
                            }
                        }
                        if (BizUtil.isBlank(syaSyouninNm)) {
                            AM_User userSyounin = baseDomManager.getUser(tmp.getHubisyouninktntid());

                            if (userSyounin == null) {

                                syaSyouninNm = "";
                            }
                            else {

                                syaSyouninNm = userSyounin.getUserNm();
                            }
                        }
                        if (C_UmuKbn.ARI.eq(tmp.getGenponhnkykumu())) {
                            syaUmuKbn = C_UmuKbn.ARI;
                        }

                    } else if (C_HassinsakiKbn.KOK.eq(tmp.getHassinsakikbn())) {
                        kokExists = true;

                        if (kokHassinYmd == null) {
                            kokHassinYmd = tmp.getHasinymd();
                        }
                        if (BizUtil.isBlank(kokTourokuNm)) {
                            AM_User userTouroku = baseDomManager.getUser(tmp.getHubitourokuktntid());

                            if (userTouroku == null) {

                                kokTourokuNm = "";
                            }
                            else {

                                kokTourokuNm = userTouroku.getUserNm();
                            }
                        }
                        if (BizUtil.isBlank(kokSyouninNm)) {
                            AM_User userSyounin = baseDomManager.getUser(tmp.getHubisyouninktntid());

                            if (userSyounin == null) {

                                kokSyouninNm = "";
                            }
                            else {

                                kokSyouninNm = userSyounin.getUserNm();
                            }
                        }
                        if (C_UmuKbn.ARI.eq(tmp.getGenponhnkykumu())) {
                            kokUmuKbn = C_UmuKbn.ARI;
                        }

                    }
                    if (syaHassinYmd != null && !BizUtil.isBlank(syaTourokuNm) && !BizUtil.isBlank(syaSyouninNm) && C_UmuKbn.ARI.eq(syaUmuKbn) &&
                        kokHassinYmd != null && !BizUtil.isBlank(kokTourokuNm) && !BizUtil.isBlank(kokSyouninNm) && C_UmuKbn.ARI.eq(kokUmuKbn)) {
                        break;
                    }
                }

                if (syaExists) {
                    IT_KhHubiMikaisyouList syaKhHubiMikaisyouList = new IT_KhHubiMikaisyouList();

                    syaKhHubiMikaisyouList.setJimutetuzukicd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
                    syaKhHubiMikaisyouList.setSyono(uiBean.getSyono());
                    syaKhHubiMikaisyouList.setHassinsakikbn(C_HassinsakiKbn.SYA);
                    syaKhHubiMikaisyouList.setKyknmkj(khozenCommonParam.getKeiyakusya(uiBean.getSyono()).getKyknmkj());
                    syaKhHubiMikaisyouList.setSksreadymd(khHubi.getSksreadymd());
                    syaKhHubiMikaisyouList.setGenponhnkykumu(syaUmuKbn);
                    syaKhHubiMikaisyouList.setHubitourokuktntnm(syaTourokuNm);
                    syaKhHubiMikaisyouList.setHubisyouninktntnm(syaSyouninNm);
                    syaKhHubiMikaisyouList.setHassinkaisuu(khHubi.getHassinsakikaisuu1());
                    syaKhHubiMikaisyouList.setFsthubbihasinymd(khHubi.getHassinsakifsthubihasinymd1());
                    syaKhHubiMikaisyouList.setLasthubbihasinymd(syaHassinYmd);
                    syaKhHubiMikaisyouList.setGyoumuKousinKinou(kinouId);
                    syaKhHubiMikaisyouList.setGyoumuKousinsyaId(userId);
                    syaKhHubiMikaisyouList.setGyoumuKousinTime(sysDateTime);

                    BizPropertyInitializer.initialize(syaKhHubiMikaisyouList);

                    hozenDomManager.insert(syaKhHubiMikaisyouList);
                }


                if (kokExists) {
                    IT_KhHubiMikaisyouList kokKhHubiMikaisyouList = new IT_KhHubiMikaisyouList();

                    kokKhHubiMikaisyouList.setJimutetuzukicd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
                    kokKhHubiMikaisyouList.setSyono(uiBean.getSyono());
                    kokKhHubiMikaisyouList.setHassinsakikbn(C_HassinsakiKbn.KOK);
                    kokKhHubiMikaisyouList.setKyknmkj(khozenCommonParam.getKeiyakusya(uiBean.getSyono()).getKyknmkj());
                    kokKhHubiMikaisyouList.setSksreadymd(khHubi.getSksreadymd());
                    kokKhHubiMikaisyouList.setGenponhnkykumu(kokUmuKbn);
                    kokKhHubiMikaisyouList.setHubitourokuktntnm(kokTourokuNm);
                    kokKhHubiMikaisyouList.setHubisyouninktntnm(kokSyouninNm);
                    kokKhHubiMikaisyouList.setHassinkaisuu(khHubi.getHassinsakikaisuu2());
                    kokKhHubiMikaisyouList.setFsthubbihasinymd(khHubi.getHassinsakifsthubihasinymd2());
                    kokKhHubiMikaisyouList.setLasthubbihasinymd(kokHassinYmd);
                    kokKhHubiMikaisyouList.setGyoumuKousinKinou(kinouId);
                    kokKhHubiMikaisyouList.setGyoumuKousinsyaId(userId);
                    kokKhHubiMikaisyouList.setGyoumuKousinTime(sysDateTime);

                    BizPropertyInitializer.initialize(kokKhHubiMikaisyouList);

                    hozenDomManager.insert(kokKhHubiMikaisyouList);
                }
            }

            hozenDomManager.delete(hozenDomManager.getKhHubiKaisyouDetailWksByKouteikanriid(uiBean.getBzWorkflowInfo()
                .getKouteiKanriId()));
        }
        else {

            hozenDomManager.delete(hozenDomManager.getKhHubiKaisyouDetailWksByKouteikanriid(uiBean.getBzWorkflowInfo()
                .getKouteiKanriId()));

            for (MikaisyouhubiListDataSourceBean hubBean : hubDataList) {

                IW_KhHubiKaisyouDetailWk hubDetailWk = new IW_KhHubiKaisyouDetailWk();

                C_UmuKbn hubUmKbn;

                if (C_KaisyoutaisyouKbn.TAISYOU.eq(hubBean.getDispkaisyoutaisyoukbn())) {

                    hubUmKbn = C_UmuKbn.ARI;
                }
                else {

                    hubUmKbn = C_UmuKbn.NONE;
                }

                hubDetailWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                hubDetailWk.setRenno3keta(hubBean.getRenno3ketay());
                hubDetailWk.setHubikaisyouumukbn(hubUmKbn);
                hubDetailWk.setGyoumuKousinKinou(kinouId);
                hubDetailWk.setGyoumuKousinsyaId(userId);
                hubDetailWk.setGyoumuKousinTime(sysDateTime);

                BizPropertyInitializer.initialize(hubDetailWk);

                hozenDomManager.insert(hubDetailWk);
            }
        }

        hozenDomManager.update(uiBean.getKykKihon());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        if(!C_KhkinouModeIdKbn.HUBIKAISYOU.getValue().equals(kinouMode.getKinouMode()) &&
            !IKhozenCommonConstants.TASKID_HUBIKAISYOU.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            BzForceProcessForward bzForceProcessForward = SWAKInjector.getInstance(BzForceProcessForward.class);

            bzForceProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                IKhozenCommonConstants.TASKID_HUBIKAISYOU,
                bzCommonLockProcess.getKouteiLockKey());
        }

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);
        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(C_SasimodosisakiKbn.BLNK);
        khRuleBean.setSaiwariateUserId("");

        String comment = uiBean.getSyanaicommentkh();

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);
        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
            .getJimuTetuzukiCd(), bzCommonLockProcess.getKouteiLockKey(), comment, khRuleBean);

        messageManager.addMessageId(MessageId.IAC0009);
    }


    private void inputKeySyoriKengen() {

        String kinouMod = kinouMode.getKinouMode();

        if (kinouMod == null || C_KhkinouModeIdKbn.DEFAULT.getValue().equals(kinouMod)) {

            Boolean keyInputFlg = baseUserInfo.hasAuthenticatedFunctionMode(C_KhkinouModeIdKbn.INPUTKEY.getValue());

            if (keyInputFlg) {

                kinouMode.setKinouMode(C_KhkinouModeIdKbn.INPUTKEY.getValue());
            }
            else {

                throw new BizAppException(MessageId.EBS0003);
            }
        }
    }

    private void startKouteiKanri() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        summaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(summaryInBean);

        if (IKhozenCommonConstants.TASKID_HUBIKAITOUMATI.equals(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId()) ||
            IKhozenCommonConstants.TASKID_HUBIKAISYOU.equals(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId())) {

            BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

            C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId(),
                bzCommonLockProcess.getKouteiLockKey());
            if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
                throw new BizLogicException(MessageId.EBA0111);
            }
            if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
                throw new BizLogicException(MessageId.EBA0112);
            }
        }
        else {

            throw new BizLogicException(MessageId.EBF0114);
        }
    }

    private void SetKoutei() {

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);
    }

    private void SetSyorui() {

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean);
    }

    private void setProgress() {

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);

        setProgressHistory.exec(uiBean);
    }

    private void setHubiInfo(String pKouteiKanriId) {

        String hubiSikibetuKey = pKouteiKanriId;

        IT_KhHubi khHubi = hozenDomManager.getKhHubi(hubiSikibetuKey);
        uiBean.setKhHubi(khHubi);

        SortIT_KhHubiDetail sortIT_KhHubiDetail = SWAKInjector.getInstance(SortIT_KhHubiDetail.class);
        List<IT_KhHubiDetail> khHubiDetailLst = sortIT_KhHubiDetail
            .OrderIT_KhHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(khHubi.getKhHubiDetailsByHasinymdKaisyouymdNotNull());

        List<KaisyouzumihubiListDataSourceBean> KaisyouzumiBeanLst = new ArrayList<>();

        for (IT_KhHubiDetail khHubiDetail : khHubiDetailLst) {

            KaisyouzumihubiListDataSourceBean KaisyouzumiBean = SWAKInjector.getInstance(
                KaisyouzumihubiListDataSourceBean.class);

            String inputNmKszumi = "";

            AM_User userTouroku = baseDomManager.getUser(khHubiDetail.getHubitourokuktntid());

            if (userTouroku != null) {

                inputNmKszumi = userTouroku.getUserNm();
            }

            String syouninNmKszumi = "";

            AM_User userSyounin = baseDomManager.getUser(khHubiDetail.getHubisyouninktntid());

            if (userSyounin != null) {

                syouninNmKszumi = userSyounin.getUserNm();
            }

            KaisyouzumiBean.setRenno3keta(khHubiDetail.getRenno3keta());
            KaisyouzumiBean.setDispkaisyoutaisyoukbn(C_KaisyoutaisyouKbn.TAISYOU);
            KaisyouzumiBean.setDisptrkymd(khHubiDetail.getTrkymd());
            KaisyouzumiBean.setDisphubinaiyoumsg(khHubiDetail.getHubinaiyoumsg());
            KaisyouzumiBean.setDispgenponhnkykumu(khHubiDetail.getGenponhnkykumu());
            KaisyouzumiBean.setDisphassinymd(khHubiDetail.getHasinymd());
            KaisyouzumiBean.setDisphassinsakikbn(khHubiDetail.getHassinsakikbn());
            KaisyouzumiBean.setDispnyuryokutantounm(inputNmKszumi);
            KaisyouzumiBean.setDispsyounintantounm(syouninNmKszumi);
            KaisyouzumiBean.setDispkaisyouymd(khHubiDetail.getKaisyouymd());

            KaisyouzumiBeanLst.add(KaisyouzumiBean);
        }

        uiBean.setKaisyouzumihubiList(KaisyouzumiBeanLst);

        khHubiDetailLst = new ArrayList<>();

        khHubiDetailLst = sortIT_KhHubiDetail.OrderIT_KhHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(
            khHubi.getKhHubiDetailsByHasinymdKaisyouymdNull());

        List<MikaisyouhubiListDataSourceBean> mikaisyouBeanLst = new ArrayList<>();

        for (IT_KhHubiDetail khHubiDetail : khHubiDetailLst) {

            MikaisyouhubiListDataSourceBean mikaisyouBean = SWAKInjector
                .getInstance(MikaisyouhubiListDataSourceBean.class);

            String inputNm = "";

            AM_User userTouroku = baseDomManager.getUser(khHubiDetail.getHubitourokuktntid());

            if (userTouroku != null) {

                inputNm = userTouroku.getUserNm();
            }

            String syouninNm = "";

            AM_User userSyounin = baseDomManager.getUser(khHubiDetail.getHubisyouninktntid());

            if (userSyounin != null) {

                syouninNm = userSyounin.getUserNm();
            }

            IW_KhHubiKaisyouDetailWk khHubiKaisyouDetailWk = hozenDomManager.getKhHubiKaisyouDetailWk(uiBean
                .getBzWorkflowInfo().getKouteiKanriId(), khHubiDetail.getRenno3keta());

            C_KaisyoutaisyouKbn dispkaisyoutaisyoukbn = null;
            boolean dispkaisyoutaisyou = false;

            if (khHubiKaisyouDetailWk != null) {

                C_UmuKbn checkUmu = khHubiKaisyouDetailWk.getHubikaisyouumukbn();

                if (C_UmuKbn.ARI.eq(checkUmu)) {

                    dispkaisyoutaisyoukbn = C_KaisyoutaisyouKbn.TAISYOU;
                    dispkaisyoutaisyou = true;
                }
                else {

                    dispkaisyoutaisyoukbn = C_KaisyoutaisyouKbn.TAISYOUGAI;
                    dispkaisyoutaisyou = false;
                }
            }
            else {

                dispkaisyoutaisyoukbn = C_KaisyoutaisyouKbn.TAISYOUGAI;
                dispkaisyoutaisyou = false;
            }

            mikaisyouBean.setRenno3keta(khHubiDetail.getRenno3keta());
            mikaisyouBean.setDispkaisyoutaisyoukbn(dispkaisyoutaisyoukbn);
            mikaisyouBean.setDispkaisyoutaisyou(dispkaisyoutaisyou);
            mikaisyouBean.setDisptrkymd(khHubiDetail.getTrkymd());
            mikaisyouBean.setDisphubinaiyoumsg(khHubiDetail.getHubinaiyoumsg());
            mikaisyouBean.setDispgenponhnkykumu(khHubiDetail.getGenponhnkykumu());
            mikaisyouBean.setDisphassinymd(khHubiDetail.getHasinymd());
            mikaisyouBean.setDisphassinsakikbn(khHubiDetail.getHassinsakikbn());
            mikaisyouBean.setDispnyuryokutantounm(inputNm);
            mikaisyouBean.setDispsyounintantounm(syouninNm);
            mikaisyouBean.setDispkaisyouymd(null);

            mikaisyouBeanLst.add(mikaisyouBean);
        }

        uiBean.setMikaisyouhubiList(mikaisyouBeanLst);

        uiBean.setRenrakuarea(uiBean.getKhHubi().getRenrakuarea());
    }

    private void setProcess(BzGetProcessSummaryOutBean outBean) {


        uiBean.getBzWorkflowInfo().setKouteiKanriId(outBean.getKouteiKanriId());

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(outBean.getJimuTetuzukiCd());

        uiBean.setSyoriKeiyuKbn(E_SyoriKeiyu.KEYINPUT);

        uiBean.getBzWorkflowInfo().setTaskId(outBean.getNowNodoId());

        SetKoutei();

        SetSyorui();

        setProgress();

        startKouteiKanri();

        setHubiInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);
    }
}
