package yuyu.app.hozen.khhubikanri.khhubitouroku;

import static yuyu.app.hozen.khhubikanri.khhubitouroku.GenKhHubiTourokuConstants.*;
import static yuyu.app.hozen.khhubikanri.khhubitouroku.KhHubiTourokuConstants.*;

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
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SasimodosisakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.entity.IT_KhHubi;
import yuyu.def.db.entity.IT_KhHubiDetail;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhHubiDetailWk;
import yuyu.def.db.entity.IW_KhHubiWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KhHubiDetail;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 契約保全不備登録 のビジネスロジックです。
 */
public class KhHubiTourokuBizLogic {

    @Inject
    private KhHubiTourokuUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private OutputReport outputReport;

    @Inject
    private CommonDispImage commonDispImage;

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

        BizPropertyInitializer.initialize(uiBean);

        String kouteiKanriId = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        String jimuTetuzukiCd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();

        setKinou(jimuTetuzukiCd);

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(kouteiKanriId, jimuTetuzukiCd);

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            kouteiKanriId,
            jimuTetuzukiCd,
            uiBean.getBzWorkflowInfo().getTaskId(),
            bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {

            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {

            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

        String syono = gyoumuKouteiInfo.getSyono();

        uiBean.setSyono(syono);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setKouteiKanriId(kouteiKanriId);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);
        uiBean.setSksreadymd(bzGetProcessSummaryOutBean.getJimuStartYmd());

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);

        setProgressHistory.exec(uiBean);

        setHubInfo(kouteiKanriId);

        setTensousaki();

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        if (kykKihon != null) {

            uiBean.setKykKihon(kykKihon);
        }
        else {

            throw new BizLogicException(MessageId.EBA0090);
        }

        checkGengkTtdk(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

        addConversationMessage();
    }

    void unlockProcessBL() {

        BzCommonLockProcess commonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        commonLockProcess.unlockProcess();
    }

    void continueLockProcessBL() {

        BzCommonLockProcess commonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        commonLockProcess.continueLockProcess();
    }

    String pushTourokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        String syoukenNo = uiBean.getSyono();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoukenNo);

        if (kykKihon != null) {

            uiBean.setKykKihon(kykKihon);
        }
        else {
            throw new BizLogicException(MessageId.EBA0090);
        }

        List<IT_KhHubi> khHubiLst = hozenDomManager.getKhHubisBySyono(syoukenNo);

        if (khHubiLst.isEmpty()) {

            throw new BizLogicException(MessageId.EIF1016);
        }

        inputKeySyoriKengen();

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        BzGetProcessSummary summary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        summaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        summaryInBean.setSyoNo(syoukenNo);
        summaryInBean.setSubSystemId(kinou.getSubSystemId());
        summaryInBean.setTaskIds(new String[] { IKhozenCommonConstants.TASKID_HUBIKAITOUMATI });

        List<BzGetProcessSummaryOutBean> outBeanList = summary.exec(summaryInBean);

        String userId = baseUserInfo.getUserId();
        CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

        if (outBeanList.isEmpty()) {
            throw new BizLogicException(MessageId.EIF1016);
        }
        else if (outBeanList.size() == 1) {
            BzGetProcessSummaryOutBean outBean = outBeanList.get(0);

            if (!checkTaskKengen.exec(userId, outBean.getJimuTetuzukiCd(), outBean.getNowNodoId())) {
                throw new BizLogicException(MessageId.EBS0003);
            }

            checkGengkTtdk(outBean.getJimuTetuzukiCd());

            return setProcess(outBean);
        }
        else {
            String nyuuryokuLink = MessageUtil.getMessage(DDID_SELECTDATALIST_NYUURYOKULINK.getErrorResourceKey());
            List<SelectDataListDataSourceBean> selectDataLst = new ArrayList<>();

            BzGetProcessSummaryOutBean outBeanSave = null;

            for (BzGetProcessSummaryOutBean outBean : outBeanList) {

                if (!checkTaskKengen.exec(userId,
                    outBean.getJimuTetuzukiCd(),
                    outBean.getNowNodoId())) {
                    continue;
                }

                SelectDataListDataSourceBean selectDataBean = new SelectDataListDataSourceBean();

                selectDataBean.setJimuttzkCd(outBean.getJimuTetuzukiCd());
                selectDataBean.setDispjimutetuzukinm(outBean.getJimuTetuzukiNm());
                selectDataBean.setDispjimustartymd(outBean.getJimuStartYmd());
                selectDataBean.setHubiSikibetuKey(outBean.getKouteiKanriId());
                selectDataBean.setNowNodoId(outBean.getNowNodoId());
                selectDataBean.setNyuuryokuLink(nyuuryokuLink);

                selectDataLst.add(selectDataBean);
                outBeanSave = outBean;
            }
            if (0 == selectDataLst.size()) {
                throw new BizLogicException(MessageId.EBS0003);
            } else if (1 == selectDataLst.size()) {
                return setProcess(outBeanSave);
            }

            Ordering<SelectDataListDataSourceBean> ordering = Ordering.from(new SelectDataListComparator());
            selectDataLst = ordering.sortedCopy(selectDataLst);
            uiBean.setSelectDataList(selectDataLst);

            return FORWARDNAME_SELECTDATA;
        }
    }

    void pushInputBL() {

        SelectDataListDataSourceBean selectDataListDSBean = uiBean.getSelectDataListDataSource().getSelectedBean();
        String hubiSikibetuKey = selectDataListDSBean.getHubiSikibetuKey();
        String jimuttzkCd = selectDataListDSBean.getJimuttzkCd();
        String nowNodeId = selectDataListDSBean.getNowNodoId();

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        summaryInBean.setKouteiKanriId(hubiSikibetuKey);
        summaryInBean.setTaskIds(new String[] { IKhozenCommonConstants.TASKID_HUBIKAITOUMATI });

        BzGetProcessSummary summary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        List<BzGetProcessSummaryOutBean> outBeanList = summary.exec(summaryInBean);

        if (outBeanList.isEmpty()) {
            throw new BizLogicException(MessageId.EIF1016);
        }

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(hubiSikibetuKey, jimuttzkCd);

        uiBean.getBzWorkflowInfo().setKouteiKanriId(hubiSikibetuKey);
        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(jimuttzkCd);
        uiBean.getBzWorkflowInfo().setTaskId(nowNodeId);

        checkGengkTtdk(jimuttzkCd);

        SetKouteiInfo kouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        kouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran itiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        itiran.exec(uiBean);

        SetProgressHistory history = SWAKInjector.getInstance(SetProgressHistory.class);

        history.exec(uiBean);

        setKinou(jimuttzkCd);

        setHubInfo(hubiSikibetuKey);

        uiBean.setSksreadymd(selectDataListDSBean.getDispjimustartymd());
        uiBean.setItirankeiyuumukbn(C_UmuKbn.ARI);

        addConversationMessage();
    }

    void pushKakuninBL() {

        continueLockProcessBL();
        if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.BLNK.eq(uiBean.getSyorikekkakbn())) {
                throw new BizLogicException(MessageId.EBC0043, "処理結果");
            }
        }

        int maxCount = 0;
        String userNm = baseUserInfo.getUserNm();
        String userId = baseUserInfo.getUserId();
        BizDate sysDate = BizDate.getSysDate();

        uiBean.setKokHassinsakiUmuKbn(C_UmuKbn.NONE);
        uiBean.setHassinsakiUmuKbn(C_UmuKbn.NONE);

        List<HubiList2DataSourceBean> hubiList2DSLst = uiBean.getHubiList2DataSource().getAllData();
        List<HubiList2DataSourceBean> hubiList2DSNewLst = new ArrayList<>();

        for (int index = 0; index < hubiList2DSLst.size(); index++) {

            HubiList2DataSourceBean hubiList2DSBean = hubiList2DSLst.get(index);
            String disphubinaiyoumsg = hubiList2DSBean.getDisphubinaiyoumsg();
            String dispsyoruinm = hubiList2DSBean.getDisphubisyoruinm();

            if (!BizUtil.isBlank(dispsyoruinm)
                || !BizUtil.isBlank(disphubinaiyoumsg)) {

                HubiList2DataSourceBean hubiList2DSBeanNew = new HubiList2DataSourceBean();
                hubiList2DSBeanNew.setDispsyoruicd(hubiList2DSBean.getDispsyoruicd());
                hubiList2DSBeanNew.setDisphubinaiyoucd(hubiList2DSBean.getDisphubinaiyoucd());
                hubiList2DSBeanNew.setDisphubinaiyoumsg(hubiList2DSBean.getDisphubinaiyoumsg());
                hubiList2DSBeanNew.setDisphubisyoruinm(hubiList2DSBean.getDisphubisyoruinm());
                hubiList2DSBeanNew.setDisptrkymd(hubiList2DSBean.getDisptrkymd());
                hubiList2DSBeanNew.setDisphassinsakikbn(hubiList2DSBean.getDisphassinsakikbn());
                hubiList2DSBeanNew.setDispgenponhnkykumuchkbox(hubiList2DSBean.getDispgenponhnkykumuchkbox());
                if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBeanNew.setDisphassinymd(null);
                }
                else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBeanNew.setDisphassinymd(sysDate);
                }
                else if (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                    if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
                        hubiList2DSBeanNew.setDisphassinymd(sysDate);
                    } else {
                        hubiList2DSBeanNew.setDisphassinymd(null);
                    }
                }
                if (!BizUtil.isBlank(hubiList2DSBean.getNyuryokutantouid())) {
                    hubiList2DSBeanNew.setNyuryokutantouid(hubiList2DSBean.getNyuryokutantouid());
                } else {
                    if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                        hubiList2DSBeanNew.setNyuryokutantouid(userId);
                    }
                    else if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
                        hubiList2DSBeanNew.setNyuryokutantouid(userId);
                    } else {
                        hubiList2DSBeanNew.setNyuryokutantouid("");
                    }
                }
                if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBeanNew.setSyounintantouid("");
                }
                else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBeanNew.setSyounintantouid(userId);
                }
                else if (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                    if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
                        hubiList2DSBeanNew.setSyounintantouid(userId);
                    } else {
                        hubiList2DSBeanNew.setSyounintantouid("");
                    }
                }
                if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBeanNew.setDispsyounintantounm("");
                }
                else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBeanNew.setDispsyounintantounm(userNm);
                }
                else if (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                    if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
                        hubiList2DSBeanNew.setDispsyounintantounm(userNm);
                    } else {
                        hubiList2DSBeanNew.setDispsyounintantounm("");
                    }
                }
                if (!BizUtil.isBlank(hubiList2DSBean.getDispnyuryokutantounm())) {
                    hubiList2DSBeanNew.setDispnyuryokutantounm(hubiList2DSBean.getDispnyuryokutantounm());
                } else {
                    if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                        hubiList2DSBeanNew.setDispnyuryokutantounm(userNm);
                    }
                    else if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
                        hubiList2DSBeanNew.setDispnyuryokutantounm(userNm);
                    } else {
                        hubiList2DSBeanNew.setDispnyuryokutantounm("");
                    }
                }
                hubiList2DSBeanNew.setInputRenno3keta("00" + index);
                hubiList2DSNewLst.add(hubiList2DSBeanNew);

                maxCount++;
            }
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            || C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {

            if (maxCount == 0) {

                throw new BizLogicException(MessageId.EBF0119);
            }

            int kokNum = 0;
            int honsyaNum = 0;

            for (int index = 0; index < maxCount; index++) {

                HubiList2DataSourceBean hubiList2DSBean = hubiList2DSNewLst.get(index);

                if (C_HassinsakiKbn.KOK.eq(hubiList2DSBean.getDisphassinsakikbn())) {

                    kokNum++;
                    uiBean.setKokHassinsakiUmuKbn(C_UmuKbn.ARI);
                }

                if (C_HassinsakiKbn.SYA.eq(hubiList2DSBean.getDisphassinsakikbn())) {

                    honsyaNum++;
                    uiBean.setHassinsakiUmuKbn(C_UmuKbn.ARI);
                }
            }

            if (kokNum > MAX_HASSINSAKI_NUMINT
                || honsyaNum > MAX_HASSINSAKI_NUMINT) {

                throw new BizLogicException(MessageId.EIF1036, MAX_HASSINSAKI_NUMSTR);
            }

            if (kokNum > 0) {

                if (BizUtil.isBlank(uiBean.getRenrakusakinmkj())) {

                    throw new BizLogicException(MessageId.EBC0043, DISP_RENRAKU + DISP_RENRAKUSIMEIKJ);
                }

                if (BizUtil.isBlank(uiBean.getRenrakuyno())) {

                    throw new BizLogicException(MessageId.EBC0043, DISP_RENRAKU + DISP_RENRAKUYNO);
                }

                if (BizUtil.isBlank(uiBean.getRenrakusakiadr1kj())) {

                    throw new BizLogicException(MessageId.EBC0043, DISP_RENRAKU + DISP_RENRAKUADR1KJ);
                }

                if (BizUtil.isBlank(uiBean.getRenrakusakitelno())) {

                    throw new BizLogicException(MessageId.EBC0043, DISP_RENRAKU + DISP_RENRAKUTELNO);
                }

                if (uiBean.getHubianswerkjt() == null) {

                    throw new BizLogicException(MessageId.EBC0043, DISP_HUBIANSWERKJT);
                }
            }
        }

        if (C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())
            && BizUtil.isBlank(uiBean.getTennousakisousasyacd())) {

            throw new BizLogicException(MessageId.EBF1005, DISP_TENNOUSA);
        }

        if ((C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn())
            || C_SyorikekkaKbn.HUBITYUUSI.eq(uiBean.getSyorikekkakbn()))
            && BizUtil.isBlank(uiBean.getSyanaicommentkh())) {

            throw new BizLogicException(MessageId.EIA1003, uiBean.getSyorikekkakbn().getContent());
        }

        if (!C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())) {

            uiBean.setTennousakisousasyacd("");
        }

        uiBean.getHubiList2DataSource().setDatas(null);

        uiBean.setHubiList2(hubiList2DSNewLst);

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        continueLockProcessBL();

        BizDate sysDate = BizDate.getSysDate();
        String kosTime = BizDate.getSysDateTimeMilli();

        if (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {

                if (C_UmuKbn.ARI.eq(uiBean.getFsttourokuflg())) {

                    editKhHubiTbl(sysDate, kosTime);

                    updateKhHubiDetailTbl(sysDate, kosTime);

                    editKhHubiMikaisyoTbl(sysDate, kosTime);

                    deleteKhHubiWk();
                }
                else {

                    updateKhHubiTbl(kosTime);

                    updateKhHubiDetailTbl(sysDate, kosTime);

                    updateKhHubiMikaisyoTbl(sysDate, kosTime);

                    deleteKhHubiWk();
                }
            }
            else if (C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())
                || C_SyorikekkaKbn.TENSOU.eq(uiBean.getSyorikekkakbn())
                || C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn())) {

                updateKhHubiWk(kosTime);
            }
            else if (C_SyorikekkaKbn.HUBITYUUSI.eq(uiBean.getSyorikekkakbn())) {

                deleteKhHubiWk();
            }
        }
        else if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())) {

            updateKhHubiWk(kosTime);
        }
        else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            updateKhHubiTbl(kosTime);

            updateKhHubiDetailTbl(sysDate, kosTime);

            updateKhHubiMikaisyoTbl(sysDate, kosTime);
        }

        hozenDomManager.update(uiBean.getKykKihon());

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            || (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())
                && C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            tyohyoMaesyori(C_UmuKbn.NONE);
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
            bzCommonLockProcess.unlockProcess();
        }

        if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            doJikouteikanri(uiBean.getSyono());
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    private void editKhHubiTbl(BizDate pSysDate, String pKosTime) {

        IT_KhHubi khHubi = new IT_KhHubi();

        khHubi.setHubisikibetukey(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        khHubi.setSyono(uiBean.getSyono());
        khHubi.setJimuttdknm(uiBean.getVktifdispjimutetuzukinm());
        khHubi.setRenrakusakinmkj(uiBean.getRenrakusakinmkj());
        khHubi.setRenrakuyno(uiBean.getRenrakuyno());
        khHubi.setRenrakusakiadr1kj(uiBean.getRenrakusakiadr1kj());
        khHubi.setRenrakusakiadr2kj(uiBean.getRenrakusakiadr2kj());
        khHubi.setRenrakusakiadr3kj(uiBean.getRenrakusakiadr3kj());
        khHubi.setRenrakusakitelno(uiBean.getRenrakusakitelno());
        khHubi.setRenrakuarea(uiBean.getRenrakuarea());
        khHubi.setHubianswerkjt(uiBean.getHubianswerkjt());
        khHubi.setSksreadymd(uiBean.getSksreadymd());
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khHubi.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khHubi.setGyoumuKousinTime(pKosTime);

        if (C_UmuKbn.ARI.equals(uiBean.getHassinsakiUmuKbn())) {

            khHubi.setHassinsakifsthubihasinymd1(pSysDate);

            khHubi.setHassinsakikaisuu1(1);
        }
        else {

            khHubi.setHassinsakikaisuu1(0);
        }

        if (C_UmuKbn.ARI.equals(uiBean.getKokHassinsakiUmuKbn ())) {

            khHubi.setHassinsakifsthubihasinymd2(pSysDate);

            khHubi.setHassinsakikaisuu2(1);
        }
        else {

            khHubi.setHassinsakikaisuu2(0);
        }

        BizPropertyInitializer.initialize(khHubi);

        hozenDomManager.insert(khHubi);
    }

    private void editKhHubiMikaisyoTbl(BizDate pSysDate, String pKosTime) {

        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();

        C_UmuKbn genponhnkyk = C_UmuKbn.NONE;

        C_UmuKbn kokGenponhnkyk = C_UmuKbn.NONE;

        String hubitourokuktntnm = "";
        String hubisyouninktntnm = "";
        String kokHubitourokuktntnm = "";
        String kokHubisyouninktntnm = "";

        for (int index = 0; index < hubiList2DSBeanLst.size(); index++) {

            HubiList2DataSourceBean hubiList2DSBean = hubiList2DSBeanLst.get(index);

            if (C_HassinsakiKbn.SYA.eq(hubiList2DSBean.getDisphassinsakikbn())) {

                hubitourokuktntnm = hubiList2DSBean.getDispnyuryokutantounm();

                hubisyouninktntnm = hubiList2DSBean.getDispsyounintantounm();

                if (C_UmuKbn.ARI.eq(hubiList2DSBean.getDispgenponhnkykumu())) {

                    genponhnkyk = C_UmuKbn.ARI;
                }
            }
            else if (C_HassinsakiKbn.KOK.eq(hubiList2DSBean.getDisphassinsakikbn())) {

                kokHubitourokuktntnm = hubiList2DSBean.getDispnyuryokutantounm();

                kokHubisyouninktntnm = hubiList2DSBean.getDispsyounintantounm();

                if (C_UmuKbn.ARI.eq(hubiList2DSBean.getDispgenponhnkykumu())) {

                    kokGenponhnkyk = C_UmuKbn.ARI;
                }
            }
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSya kykSya = khozenCommonParam.getKeiyakusya(uiBean.getSyono());

        String kyknmkj = kykSya.getKyknmkj();

        if (C_UmuKbn.ARI.eq(uiBean.getHassinsakiUmuKbn())) {

            IT_KhHubiMikaisyouList khHubiMikaisyouList = new IT_KhHubiMikaisyouList();

            khHubiMikaisyouList.setJimutetuzukicd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
            khHubiMikaisyouList.setSyono(uiBean.getSyono());
            khHubiMikaisyouList.setHassinsakikbn(C_HassinsakiKbn.SYA);
            khHubiMikaisyouList.setKyknmkj(kyknmkj);
            khHubiMikaisyouList.setSksreadymd(uiBean.getSksreadymd());
            khHubiMikaisyouList.setGenponhnkykumu(genponhnkyk);
            khHubiMikaisyouList.setHubitourokuktntnm(hubitourokuktntnm);
            khHubiMikaisyouList.setHubisyouninktntnm(hubisyouninktntnm);
            khHubiMikaisyouList.setHassinkaisuu(1);
            khHubiMikaisyouList.setFsthubbihasinymd(pSysDate);
            khHubiMikaisyouList.setLasthubbihasinymd(pSysDate);
            khHubiMikaisyouList.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            khHubiMikaisyouList.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            khHubiMikaisyouList.setGyoumuKousinTime(pKosTime);

            BizPropertyInitializer.initialize(khHubiMikaisyouList);

            hozenDomManager.insert(khHubiMikaisyouList);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKokHassinsakiUmuKbn())) {

            IT_KhHubiMikaisyouList khHubiMikaisyouList = new IT_KhHubiMikaisyouList();

            khHubiMikaisyouList.setJimutetuzukicd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
            khHubiMikaisyouList.setSyono(uiBean.getSyono());
            khHubiMikaisyouList.setHassinsakikbn(C_HassinsakiKbn.KOK);
            khHubiMikaisyouList.setKyknmkj(kyknmkj);
            khHubiMikaisyouList.setSksreadymd(uiBean.getSksreadymd());
            khHubiMikaisyouList.setGenponhnkykumu(kokGenponhnkyk);
            khHubiMikaisyouList.setHubitourokuktntnm(kokHubitourokuktntnm);
            khHubiMikaisyouList.setHubisyouninktntnm(kokHubisyouninktntnm);
            khHubiMikaisyouList.setHassinkaisuu(1);
            khHubiMikaisyouList.setFsthubbihasinymd(pSysDate);
            khHubiMikaisyouList.setLasthubbihasinymd(pSysDate);
            khHubiMikaisyouList.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            khHubiMikaisyouList.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            khHubiMikaisyouList.setGyoumuKousinTime(pKosTime);

            BizPropertyInitializer.initialize(khHubiMikaisyouList);

            hozenDomManager.insert(khHubiMikaisyouList);
        }
    }

    private void deleteKhHubiWk() {

        IW_KhHubiWk khHubiWk = hozenDomManager.getKhHubiWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        hozenDomManager.delete(khHubiWk);

    }

    private void updateKhHubiWk(String pKosTime) {

        IW_KhHubiWk khHubiWk = hozenDomManager.getKhHubiWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (khHubiWk == null) {

            khHubiWk = new IW_KhHubiWk();

            khHubiWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
            khHubiWk.setSyono(uiBean.getSyono());
            khHubiWk.setRenrakusakinmkj(uiBean.getRenrakusakinmkj());
            khHubiWk.setRenrakuyno(uiBean.getRenrakuyno());
            khHubiWk.setRenrakusakiadr1kj(uiBean.getRenrakusakiadr1kj());
            khHubiWk.setRenrakusakiadr2kj(uiBean.getRenrakusakiadr2kj());
            khHubiWk.setRenrakusakiadr3kj(uiBean.getRenrakusakiadr3kj());
            khHubiWk.setRenrakusakitelno(uiBean.getRenrakusakitelno());
            khHubiWk.setRenrakuarea(uiBean.getRenrakuarea());
            khHubiWk.setHubianswerkjt(uiBean.getHubianswerkjt());
            khHubiWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            khHubiWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            khHubiWk.setGyoumuKousinTime(pKosTime);

            BizPropertyInitializer.initialize(khHubiWk);

            hozenDomManager.insert(khHubiWk);

            List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();
            int khHubiDetailMaxSeqNo = 1;

            for (int index = 0; index < hubiList2DSBeanLst.size(); index++) {

                HubiList2DataSourceBean hubiList2DSBean = hubiList2DSBeanLst.get(index);

                IW_KhHubiDetailWk khHubiDetailWk = khHubiWk.createKhHubiDetailWk();

                khHubiDetailWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                khHubiDetailWk.setRenno3keta(khHubiDetailMaxSeqNo);
                khHubiDetailWk.setHubisyoruicd(hubiList2DSBean.getDispsyoruicd());
                khHubiDetailWk.setHubisyoruinm(hubiList2DSBean.getDisphubisyoruinm());
                khHubiDetailWk.setHubinaiyoucd(hubiList2DSBean.getDisphubinaiyoucd());
                khHubiDetailWk.setHubinaiyoumsg(hubiList2DSBean.getDisphubinaiyoumsg());
                khHubiDetailWk.setGenponhnkykumu(hubiList2DSBean.getDispgenponhnkykumu());
                khHubiDetailWk.setTrkymd(hubiList2DSBean.getDisptrkymd());
                khHubiDetailWk.setHassinsakikbn(hubiList2DSBean.getDisphassinsakikbn());
                khHubiDetailWk.setHubitourokuktntid(hubiList2DSBean.getNyuryokutantouid());
                khHubiDetailWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khHubiDetailWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khHubiDetailWk.setGyoumuKousinTime(pKosTime);

                BizPropertyInitializer.initialize(khHubiDetailWk);

                khHubiDetailMaxSeqNo++;
            }

            hozenDomManager.update(khHubiWk);
        }
        else {

            khHubiWk.setRenrakusakinmkj(uiBean.getRenrakusakinmkj());
            khHubiWk.setRenrakuyno(uiBean.getRenrakuyno());
            khHubiWk.setRenrakusakiadr1kj(uiBean.getRenrakusakiadr1kj());
            khHubiWk.setRenrakusakiadr2kj(uiBean.getRenrakusakiadr2kj());
            khHubiWk.setRenrakusakiadr3kj(uiBean.getRenrakusakiadr3kj());
            khHubiWk.setRenrakusakitelno(uiBean.getRenrakusakitelno());
            khHubiWk.setRenrakuarea(uiBean.getRenrakuarea());
            khHubiWk.setHubianswerkjt(uiBean.getHubianswerkjt());
            khHubiWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            khHubiWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            khHubiWk.setGyoumuKousinTime(pKosTime);

            hozenDomManager.update(khHubiWk);

            List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();
            int khHubiDetailMaxSeqNo = 1;

            List<IW_KhHubiDetailWk> khHubiDetailWkLst = khHubiWk.getKhHubiDetailWks();

            khHubiDetailWkLst.removeAll(khHubiDetailWkLst);

            hozenDomManager.flush();

            for (int index = 0; index < hubiList2DSBeanLst.size(); index++) {

                HubiList2DataSourceBean hubiList2DSBean = hubiList2DSBeanLst.get(index);

                IW_KhHubiDetailWk khHubiDetailWk = khHubiWk.createKhHubiDetailWk();

                khHubiDetailWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                khHubiDetailWk.setRenno3keta(khHubiDetailMaxSeqNo);
                khHubiDetailWk.setHubisyoruicd(hubiList2DSBean.getDispsyoruicd());
                khHubiDetailWk.setHubisyoruinm(hubiList2DSBean.getDisphubisyoruinm());
                khHubiDetailWk.setHubinaiyoucd(hubiList2DSBean.getDisphubinaiyoucd());
                khHubiDetailWk.setHubinaiyoumsg(hubiList2DSBean.getDisphubinaiyoumsg());
                khHubiDetailWk.setGenponhnkykumu(hubiList2DSBean.getDispgenponhnkykumu());
                khHubiDetailWk.setTrkymd(hubiList2DSBean.getDisptrkymd());
                khHubiDetailWk.setHassinsakikbn(hubiList2DSBean.getDisphassinsakikbn());
                khHubiDetailWk.setHubitourokuktntid(hubiList2DSBean.getNyuryokutantouid());
                khHubiDetailWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khHubiDetailWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khHubiDetailWk.setGyoumuKousinTime(pKosTime);

                khHubiDetailMaxSeqNo++;
            }

            hozenDomManager.update(khHubiWk);
        }
    }

    private void updateKhHubiTbl(String pKosTime) {

        IT_KhHubi khHubi = hozenDomManager.getKhHubi(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        Integer hassinsakikaisuu1 = khHubi.getHassinsakikaisuu1();

        Integer hassinsakikaisuu2 = khHubi.getHassinsakikaisuu2();

        BizDate fstHubiYmd1 = khHubi.getHassinsakifsthubihasinymd1();
        BizDate fstHubiYmd2 = khHubi.getHassinsakifsthubihasinymd2();
        BizDate sysdate = BizDate.getSysDate();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khHubi.setRenrakusakinmkj(uiBean.getRenrakusakinmkj());
        khHubi.setRenrakuyno(uiBean.getRenrakuyno());
        khHubi.setRenrakusakiadr1kj(uiBean.getRenrakusakiadr1kj());
        khHubi.setRenrakusakiadr2kj(uiBean.getRenrakusakiadr2kj());
        khHubi.setRenrakusakiadr3kj(uiBean.getRenrakusakiadr3kj());
        khHubi.setRenrakusakitelno(uiBean.getRenrakusakitelno());
        khHubi.setRenrakuarea(uiBean.getRenrakuarea());
        khHubi.setHubianswerkjt(uiBean.getHubianswerkjt());
        khHubi.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khHubi.setGyoumuKousinTime(pKosTime);

        if (C_UmuKbn.ARI.eq(uiBean.getHassinsakiUmuKbn())) {

            khHubi.setHassinsakikaisuu1(hassinsakikaisuu1 + 1);

            if (fstHubiYmd1 == null) {
                khHubi.setHassinsakifsthubihasinymd1(sysdate);
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKokHassinsakiUmuKbn())) {

            khHubi.setHassinsakikaisuu2(hassinsakikaisuu2 + 1);

            if (fstHubiYmd2 == null) {
                khHubi.setHassinsakifsthubihasinymd2(sysdate);
            }
        }

        hozenDomManager.update(khHubi);
    }

    private void updateKhHubiDetailTbl(BizDate pSysDate, String pKosTime) {

        IT_KhHubi khHubi = hozenDomManager.getKhHubi(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        Integer khHubiDetailMaxSeqNo = hozenDomManager.getKhHubiDetailMaxRenno3ketaByHubisikibetukey(uiBean
            .getBzWorkflowInfo().getKouteiKanriId());

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (khHubiDetailMaxSeqNo != null) {

            khHubiDetailMaxSeqNo++;
        }
        else {

            khHubiDetailMaxSeqNo = 1;
        }

        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();

        for (int index = 0; index < hubiList2DSBeanLst.size(); index++) {

            HubiList2DataSourceBean hubiList2DSBean = hubiList2DSBeanLst.get(index);

            IT_KhHubiDetail khHubiDetail = khHubi.createKhHubiDetail();

            String hubisyouninktntid = null;

            if (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

                hubisyouninktntid = hubiList2DSBean.getSyounintantouid();
            }
            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

                hubisyouninktntid = hubiList2DSBean.getNyuryokutantouid();
            }

            khHubiDetail.setRenno3keta(khHubiDetailMaxSeqNo);
            khHubiDetail.setHubisyoruicd(hubiList2DSBean.getDispsyoruicd());
            khHubiDetail.setHubisyoruinm(hubiList2DSBean.getDisphubisyoruinm());
            khHubiDetail.setHubinaiyoucd(hubiList2DSBean.getDisphubinaiyoucd());
            khHubiDetail.setHubinaiyoumsg(hubiList2DSBean.getDisphubinaiyoumsg());
            khHubiDetail.setGenponhnkykumu(hubiList2DSBean.getDispgenponhnkykumu());
            khHubiDetail.setTrkymd(hubiList2DSBean.getDisptrkymd());
            khHubiDetail.setHasinymd(hubiList2DSBean.getDisphassinymd());
            khHubiDetail.setKaisyouymd(null);
            khHubiDetail.setHassinsakikbn(hubiList2DSBean.getDisphassinsakikbn());
            khHubiDetail.setHasinkyokakbn(null);
            khHubiDetail.setHubitourokuktntid(hubiList2DSBean.getNyuryokutantouid());
            khHubiDetail.setHubisyouninktntid(hubisyouninktntid);
            khHubiDetail.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            khHubiDetail.setGyoumuKousinTime(pKosTime);

            BizPropertyInitializer.initialize(khHubiDetail);

            khHubiDetailMaxSeqNo++;
        }

        hozenDomManager.update(khHubi);
    }

    private void updateKhHubiMikaisyoTbl(BizDate pSysDate, String pKosTime) {

        IT_KhHubi khHubi = hozenDomManager.getKhHubi(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        BizDate hassinsakifsthubihasinymd1 = khHubi.getHassinsakifsthubihasinymd1();
        BizDate hassinsakifsthubihasinymd2 = khHubi.getHassinsakifsthubihasinymd2();
        Integer hassinsakikaisuu1 = khHubi.getHassinsakikaisuu1();
        Integer hassinsakikaisuu2 = khHubi.getHassinsakikaisuu2();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykSya kykSya = khozenCommonParam.getKeiyakusya(uiBean.getSyono());

        String kyknmkj = kykSya.getKyknmkj();

        if (C_UmuKbn.ARI.eq(uiBean.getHassinsakiUmuKbn())) {

            IT_KhHubiMikaisyouList khHubiMikaisyouList = hozenDomManager.getKhHubiMikaisyouList(
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getSyono(),
                C_HassinsakiKbn.SYA);

            List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();

            C_UmuKbn genponhnkyk = C_UmuKbn.NONE;

            String hubitourokuktntnm = "";
            String hubisyouninktntnm = "";

            for (int index = 0; index < hubiList2DSBeanLst.size(); index++) {

                HubiList2DataSourceBean hubiList2DSBean = hubiList2DSBeanLst.get(index);

                if (C_HassinsakiKbn.SYA.eq(hubiList2DSBean.getDisphassinsakikbn())) {

                    hubitourokuktntnm = hubiList2DSBean.getDispnyuryokutantounm();
                    hubisyouninktntnm = hubiList2DSBean.getDispsyounintantounm();

                    if (C_UmuKbn.ARI.eq(hubiList2DSBean.getDispgenponhnkykumu())) {

                        genponhnkyk = C_UmuKbn.ARI;
                        break;
                    }
                }
            }

            if (C_UmuKbn.NONE.eq(genponhnkyk)) {

                List<IT_KhHubiDetail> khHubiDetailLst = khHubi.getKhHubiDetails();

                List<IT_KhHubiDetail> sortKhHubiDetailLst = new ArrayList<>(khHubiDetailLst);

                SortIT_KhHubiDetail sortITKhHubiDetail = SWAKInjector.getInstance(SortIT_KhHubiDetail.class);
                sortITKhHubiDetail.OrderIT_KhHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(sortKhHubiDetailLst);

                for (IT_KhHubiDetail tmp : sortKhHubiDetailLst) {
                    if (tmp.getKaisyouymd() != null || C_HassinsakiKbn.KOK.eq(tmp.getHassinsakikbn())) {
                        continue;
                    }
                    if (C_UmuKbn.ARI.eq(tmp.getGenponhnkykumu())) {
                        genponhnkyk = C_UmuKbn.ARI;
                        break;
                    }
                }
            }

            if (khHubiMikaisyouList == null) {

                khHubiMikaisyouList = new IT_KhHubiMikaisyouList();

                khHubiMikaisyouList.setJimutetuzukicd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
                khHubiMikaisyouList.setSyono(uiBean.getSyono());
                khHubiMikaisyouList.setHassinsakikbn(C_HassinsakiKbn.SYA);
                khHubiMikaisyouList.setKyknmkj(kyknmkj);
                khHubiMikaisyouList.setSksreadymd(uiBean.getSksreadymd());
                khHubiMikaisyouList.setGenponhnkykumu(genponhnkyk);
                khHubiMikaisyouList.setHubitourokuktntnm(hubitourokuktntnm);
                khHubiMikaisyouList.setHubisyouninktntnm(hubisyouninktntnm);
                khHubiMikaisyouList.setHassinkaisuu(hassinsakikaisuu1);
                khHubiMikaisyouList.setFsthubbihasinymd(hassinsakifsthubihasinymd1);
                khHubiMikaisyouList.setLasthubbihasinymd(pSysDate);
                khHubiMikaisyouList.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khHubiMikaisyouList.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khHubiMikaisyouList.setGyoumuKousinTime(pKosTime);

                BizPropertyInitializer.initialize(khHubiMikaisyouList);

                hozenDomManager.insert(khHubiMikaisyouList);
            }
            else {

                khHubiMikaisyouList.setGenponhnkykumu(genponhnkyk);
                khHubiMikaisyouList.setHubitourokuktntnm(hubitourokuktntnm);
                khHubiMikaisyouList.setHubisyouninktntnm(hubisyouninktntnm);
                khHubiMikaisyouList.setHassinkaisuu(hassinsakikaisuu1);
                khHubiMikaisyouList.setLasthubbihasinymd(pSysDate);
                khHubiMikaisyouList.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khHubiMikaisyouList.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khHubiMikaisyouList.setGyoumuKousinTime(pKosTime);

                hozenDomManager.update(khHubiMikaisyouList);
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKokHassinsakiUmuKbn())) {

            IT_KhHubiMikaisyouList khHubiMikaisyouList = hozenDomManager.getKhHubiMikaisyouList(
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getSyono(),
                C_HassinsakiKbn.KOK);

            List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();

            C_UmuKbn kokGenponhnkyk = C_UmuKbn.NONE;

            String kokHubitourokuktntnm = "";
            String kokHubisyouninktntnm = "";

            for (int index = 0; index < hubiList2DSBeanLst.size(); index++) {

                HubiList2DataSourceBean hubiList2DSBean = hubiList2DSBeanLst.get(index);

                if (C_HassinsakiKbn.KOK.eq(hubiList2DSBean.getDisphassinsakikbn())) {

                    kokHubitourokuktntnm = hubiList2DSBean.getDispnyuryokutantounm();
                    kokHubisyouninktntnm = hubiList2DSBean.getDispsyounintantounm();

                    if (C_UmuKbn.ARI.eq(hubiList2DSBean.getDispgenponhnkykumu())) {

                        kokGenponhnkyk = C_UmuKbn.ARI;

                        break;
                    }
                }
            }

            if (C_UmuKbn.NONE.eq(kokGenponhnkyk)) {

                List<IT_KhHubiDetail> khHubiDetailLst = khHubi.getKhHubiDetails();

                List<IT_KhHubiDetail> sortKhHubiDetailLst = new ArrayList<>(khHubiDetailLst);

                SortIT_KhHubiDetail sortITKhHubiDetail = SWAKInjector.getInstance(SortIT_KhHubiDetail.class);
                sortITKhHubiDetail.OrderIT_KhHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(sortKhHubiDetailLst);

                for (IT_KhHubiDetail tmp : sortKhHubiDetailLst) {
                    if (tmp.getKaisyouymd() != null || C_HassinsakiKbn.SYA.eq(tmp.getHassinsakikbn())) {
                        continue;
                    }
                    if (C_UmuKbn.ARI.eq(tmp.getGenponhnkykumu())) {
                        kokGenponhnkyk = C_UmuKbn.ARI;
                        break;
                    }
                }
            }

            if (khHubiMikaisyouList == null) {

                khHubiMikaisyouList = new IT_KhHubiMikaisyouList();

                khHubiMikaisyouList.setJimutetuzukicd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
                khHubiMikaisyouList.setSyono(uiBean.getSyono());
                khHubiMikaisyouList.setHassinsakikbn(C_HassinsakiKbn.KOK);
                khHubiMikaisyouList.setKyknmkj(kyknmkj);
                khHubiMikaisyouList.setSksreadymd(uiBean.getSksreadymd());
                khHubiMikaisyouList.setGenponhnkykumu(kokGenponhnkyk);
                khHubiMikaisyouList.setHubitourokuktntnm(kokHubitourokuktntnm);
                khHubiMikaisyouList.setHubisyouninktntnm(kokHubisyouninktntnm);
                khHubiMikaisyouList.setHassinkaisuu(hassinsakikaisuu2);
                khHubiMikaisyouList.setFsthubbihasinymd(hassinsakifsthubihasinymd2);
                khHubiMikaisyouList.setLasthubbihasinymd(pSysDate);
                khHubiMikaisyouList.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khHubiMikaisyouList.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khHubiMikaisyouList.setGyoumuKousinTime(pKosTime);

                BizPropertyInitializer.initialize(khHubiMikaisyouList);

                hozenDomManager.insert(khHubiMikaisyouList);
            }
            else {

                khHubiMikaisyouList.setGenponhnkykumu(kokGenponhnkyk);
                khHubiMikaisyouList.setHubitourokuktntnm(kokHubitourokuktntnm);
                khHubiMikaisyouList.setHubisyouninktntnm(kokHubisyouninktntnm);
                khHubiMikaisyouList.setHassinkaisuu(hassinsakikaisuu2);
                khHubiMikaisyouList.setLasthubbihasinymd(pSysDate);
                khHubiMikaisyouList.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khHubiMikaisyouList.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khHubiMikaisyouList.setGyoumuKousinTime(pKosTime);

                hozenDomManager.update(khHubiMikaisyouList);
            }
        }
    }

    private void tyohyoMaesyori(C_UmuKbn pUmuKbn) {

        if (C_UmuKbn.NONE.eq(pUmuKbn)) {

            KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean =
                SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);

            khHituyousyoruiHanteiInBean.setKouteikanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
            khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
            khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
            khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);
            khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
            khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);
            khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

            HozenPreReportRenkeiBean preReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

            preReportRenkeiBean.setSyoNo(uiBean.getSyono());
            preReportRenkeiBean.setSakuseizumiKouteikanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
            preReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
            preReportRenkeiBean.setSyoriComment(uiBean.getSyanaicommentkh());
            preReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);
        }

        BzKokyakuAtesakiBean kokyakuAtesakiBean = SWAKInjector.getInstance(BzKokyakuAtesakiBean.class);

        String[] address = ViewReport.editAdrDisp(
            24,
            uiBean.getRenrakusakiadr1kj(),
            uiBean.getRenrakusakiadr2kj(),
            uiBean.getRenrakusakiadr3kj()
            );
        String irshadr1k,irshadr2k,irshadr3k;
        irshadr1k = address[0];
        irshadr2k = address[1];
        irshadr3k = address[2];

        kokyakuAtesakiBean.setIrTyouhyousakuseiymd(String.valueOf(BizDate.getSysDate()));
        kokyakuAtesakiBean.setIrShsyno(uiBean.getRenrakuyno());
        kokyakuAtesakiBean.setIrShadr1kj(irshadr1k);
        kokyakuAtesakiBean.setIrShadr2kj(irshadr2k);
        kokyakuAtesakiBean.setIrShadr3kj(irshadr3k);
        kokyakuAtesakiBean.setIrShsnmkj(uiBean.getRenrakusakinmkj());

        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        EditPdfHubiTyouhyou editPdfHubiTyouhyou = SWAKInjector.getInstance(EditPdfHubiTyouhyou.class);

        String tyouhyoukey = editPdfHubiTyouhyou.exec(
            khozenCommonParam,
            uiBean.getSyoruicd(),
            uiBean.getSyono(),
            C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()),
            pUmuKbn,
            uiBean.getRenrakuarea(),
            uiBean.getHubianswerkjt(),
            hubiList2DSBeanLst,
            kokyakuAtesakiBean);

        uiBean.setTyouhyoukey(tyouhyoukey);
    }

    @Transactional
    void pushKarisakuseiBL() {

        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();

        if (hubiList2DSBeanLst.size() == 0) {
            throw new BizLogicException(MessageId.EBF0119);
        }

        int kokakuNum = 0;
        int honsyaNum = 0;

        for (HubiList2DataSourceBean hubiList2DsBean : hubiList2DSBeanLst) {
            if (C_HassinsakiKbn.KOK.eq(hubiList2DsBean.getDisphassinsakikbn())
                && C_Delflag.BLNK.eq(hubiList2DsBean.getSakujyoflg())) {
                kokakuNum = kokakuNum + 1;
            }
            else if (C_HassinsakiKbn.SYA.eq(hubiList2DsBean.getDisphassinsakikbn())
                && C_Delflag.BLNK.eq(hubiList2DsBean.getSakujyoflg())) {
                honsyaNum = honsyaNum + 1;
            }
        }

        if (kokakuNum > MAX_HASSINSAKI_NUMINT || honsyaNum > MAX_HASSINSAKI_NUMINT) {
            throw new BizLogicException(MessageId.EIF1036, MAX_HASSINSAKI_NUMSTR);
        }

        tyohyoMaesyori(C_UmuKbn.ARI);
    }

    void pushModoruBtnByConfirmBL() {

        addConversationMessage();

        List<HubiList2DataSourceBean> hubiList2DSLst = uiBean.getHubiList2DataSource().getAllData();
        List<HubiList2DataSourceBean> hubiList2DSNewLst = new ArrayList<>();
        for (int index = 0; index < hubiList2DSLst.size(); index++) {
            HubiList2DataSourceBean hubiList2DSBean = hubiList2DSLst.get(index);
            HubiList2DataSourceBean hubiList2DSBeanNew = new HubiList2DataSourceBean();
            hubiList2DSBeanNew.setDisptrkymd(hubiList2DSBean.getDisptrkymd());
            hubiList2DSBeanNew.setDispsyoruicd(hubiList2DSBean.getDispsyoruicd());
            hubiList2DSBeanNew.setDisphubisyoruinm(hubiList2DSBean.getDisphubisyoruinm());
            hubiList2DSBeanNew.setDisphubinaiyoucd(hubiList2DSBean.getDisphubinaiyoucd());
            hubiList2DSBeanNew.setDisphubinaiyoumsg(hubiList2DSBean.getDisphubinaiyoumsg());
            hubiList2DSBeanNew.setDispgenponhnkykumu(hubiList2DSBean.getDispgenponhnkykumu());
            hubiList2DSBeanNew.setDisphassinsakikbn(hubiList2DSBean.getDisphassinsakikbn());
            if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())
                || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                hubiList2DSBeanNew.setNyuryokutantouid("");
            }
            else if (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                hubiList2DSBeanNew.setNyuryokutantouid(hubiList2DSBean.getNyuryokutantouid());
            }
            if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())
                || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                hubiList2DSBeanNew.setDispnyuryokutantounm("");
            }
            else if (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                hubiList2DSBeanNew.setDispnyuryokutantounm(hubiList2DSBean.getDispnyuryokutantounm());
            }
            hubiList2DSBeanNew.setDisphassinymd(null);
            hubiList2DSBeanNew.setDispsyounintantounm("");
            hubiList2DSBeanNew.setSyounintantouid("");

            hubiList2DSBeanNew.setSakujyoflg(C_Delflag.BLNK);
            hubiList2DSBeanNew.setSakujyoflg2(C_Delflag.BLNK);

            hubiList2DSNewLst.add(hubiList2DSBeanNew);
        }
        uiBean.getHubiList2DataSource().setDatas(null);

        uiBean.setHubiList2(hubiList2DSNewLst);
    }

    void printOut() {

        String tyhykey = uiBean.getTyouhyoukey();
        uiBean.setTyouhyoukey("");
        outputReport.outputPDFByJoinKey(tyhykey);
    }

    void printOutKarisakusei() {

        String tyhykey = uiBean.getTyouhyoukey();
        uiBean.setTyouhyoukey("");
        outputReport.outputPDFWithDelByJoinKey(tyhykey);
    }

    void createList() {

        uiBean.setSyoriYmd(BizDate.getSysDate());
        List<HubiList2DataSourceBean> beforeHubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();
        int beforeListSize = beforeHubiList2DSBeanLst.size();
        String sakujyoLink = MessageUtil.getMessage(DDID_HUBILIST2_SAKUJYOLINK.getErrorResourceKey());

        List<HubiList2DataSourceBean> hubiList2DSBeanLst = Lists.newArrayList();

        BizDate sysDate = BizDate.getSysDate();

        for (int i = 0; i < MAX_ROW_COUNT; i++) {
            HubiList2DataSourceBean hubiList2DSBean = null;
            if (i < beforeListSize) {
                hubiList2DSBean = beforeHubiList2DSBeanLst.get(i);
                hubiList2DSBean.setJimutetuzukicd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
                hubiList2DSBean.setSakujyoLink(sakujyoLink);
                hubiList2DSBeanLst.add(hubiList2DSBean);
            }
            else {
                hubiList2DSBean = new HubiList2DataSourceBean();

                hubiList2DSBean.setDispsyoruicd(C_SyoruiCdKbn.BLNK);
                hubiList2DSBean.setDisphubinaiyoucd("");
                hubiList2DSBean.setDisptrkymd(sysDate);
                hubiList2DSBean.setDisphubisyoruinm("");
                hubiList2DSBean.setDisphubinaiyoumsg("");
                hubiList2DSBean.setDispgenponhnkykumu(C_UmuKbn.NONE);
                hubiList2DSBean.setDisphassinsakikbn(C_HassinsakiKbn.BLNK);
                hubiList2DSBean.setJimutetuzukicd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
                hubiList2DSBean.setDisphassinymd(null);
                hubiList2DSBean.setDispnyuryokutantounm("");
                hubiList2DSBean.setDispsyounintantounm("");
                hubiList2DSBean.setNyuryokutantouid("");
                hubiList2DSBean.setSyounintantouid("");
                hubiList2DSBean.setSakujyoLink(sakujyoLink);

                if (i == 0) {
                    hubiList2DSBean.setSakujyoflg(C_Delflag.BLNK);
                    hubiList2DSBean.setSakujyoflg2(C_Delflag.BLNK);
                }
                else {
                    hubiList2DSBean.setSakujyoflg(C_Delflag.SAKUJYO);
                    hubiList2DSBean.setSakujyoflg2(C_Delflag.SAKUJYO);
                }
                hubiList2DSBeanLst.add(hubiList2DSBean);
            }
        }
        uiBean.setHubiList2(hubiList2DSBeanLst);
    }

    void listClean() {
        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();
        Iterables.removeIf(hubiList2DSBeanLst, new HubiList2DataSourceBeanPredicate());
        uiBean.setHubiList2(hubiList2DSBeanLst);
    }

    void printHyoujiOut() {
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }


    private void doJikouteikanri(String pSyono) {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(C_SasimodosisakiKbn.BLNK);
        khRuleBean.setSaiwariateUserId(uiBean.getTennousakisousasyacd());

        String syanaicomment = uiBean.getSyanaicommentkh();

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        khProcessForward.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            bzCommonLockProcess.getKouteiLockKey(),
            syanaicomment,
            khRuleBean);

        bzCommonLockProcess.unlockProcess();
    }

    private void setHubInfo(String pHubiSikibetuKey) {

        IT_KhHubi khHubi = hozenDomManager.getKhHubi(pHubiSikibetuKey);

        List<HashinzumiHubiListDataSourceBean> hashinzumiHubiListDataLst = new ArrayList<>();

        List<HubiList2DataSourceBean> hubiList2DataLst = new ArrayList<>();

        String sakujyoLink = MessageUtil.getMessage(
            KhHubiTourokuConstants.DDID_HUBILIST2_SAKUJYOLINK.getErrorResourceKey());

        if (khHubi == null) {

            uiBean.setFsttourokuflg(C_UmuKbn.ARI);
        }
        else {

            uiBean.setFsttourokuflg(C_UmuKbn.NONE);

            List<IT_KhHubiDetail> khHubiDetailLst = khHubi.getKhHubiDetails();

            List<IT_KhHubiDetail> sortKhHubiDetailLst = new ArrayList<>(khHubiDetailLst);

            SortIT_KhHubiDetail sortITKhHubiDetail = SWAKInjector.getInstance(SortIT_KhHubiDetail.class);
            sortITKhHubiDetail.OrderIT_KhHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(sortKhHubiDetailLst);

            int i = 0;

            for (IT_KhHubiDetail khHubiDetail : sortKhHubiDetailLst) {

                HashinzumiHubiListDataSourceBean hashinzumiHubiListDSBean = new HashinzumiHubiListDataSourceBean();

                String nyuuryokutantounm = "";
                String syounintantounm = "";

                AM_User userTouroku = baseDomManager.getUser(khHubiDetail.getHubitourokuktntid());

                if (userTouroku == null) {

                    nyuuryokutantounm = "";
                }
                else {

                    nyuuryokutantounm = userTouroku.getUserNm();
                }

                AM_User userSyounin = baseDomManager.getUser(khHubiDetail.getHubisyouninktntid());

                if (userSyounin == null) {

                    syounintantounm = "";
                }
                else {

                    syounintantounm = userSyounin.getUserNm();
                }

                hashinzumiHubiListDSBean.setTrkymd(khHubiDetail.getTrkymd());
                hashinzumiHubiListDSBean.setHubisyoruicd(khHubiDetail.getHubisyoruicd());
                hashinzumiHubiListDSBean.setHubisyoruinm(khHubiDetail.getHubisyoruinm());
                hashinzumiHubiListDSBean.setHubinaiyoucd(khHubiDetail.getHubinaiyoucd());
                hashinzumiHubiListDSBean.setHubinaiyoumsg(khHubiDetail.getHubinaiyoumsg());
                hashinzumiHubiListDSBean.setDispgenponhnkykumu(khHubiDetail.getGenponhnkykumu());
                hashinzumiHubiListDSBean.setHasinymd(khHubiDetail.getHasinymd());
                hashinzumiHubiListDSBean.setHassinsakikbn(khHubiDetail.getHassinsakikbn());
                hashinzumiHubiListDSBean.setNyuryokutantouid(khHubiDetail.getHubitourokuktntid());
                hashinzumiHubiListDSBean.setSyounintantouid(khHubiDetail.getHubisyouninktntid());
                hashinzumiHubiListDSBean.setNyuuryokutantounm(nyuuryokutantounm);
                hashinzumiHubiListDSBean.setSyounintantounm(syounintantounm);
                hashinzumiHubiListDSBean.setKaisyouymd(khHubiDetail.getKaisyouymd());

                hashinzumiHubiListDataLst.add(hashinzumiHubiListDSBean);

                i++;

                if (i == MAX_ROW_COUNT) {
                    break;
                }
            }

            uiBean.setHashinzumiHubiList(hashinzumiHubiListDataLst);
        }

        IW_KhHubiWk khHubiWk = hozenDomManager.getKhHubiWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (khHubiWk != null) {

            uiBean.setRenrakusakinmkj(khHubiWk.getRenrakusakinmkj());
            uiBean.setRenrakuyno(khHubiWk.getRenrakuyno());
            uiBean.setRenrakusakiadr1kj(khHubiWk.getRenrakusakiadr1kj());
            uiBean.setRenrakusakiadr2kj(khHubiWk.getRenrakusakiadr2kj());
            uiBean.setRenrakusakiadr3kj(khHubiWk.getRenrakusakiadr3kj());
            uiBean.setRenrakusakitelno(khHubiWk.getRenrakusakitelno());
            uiBean.setRenrakuarea(khHubiWk.getRenrakuarea());
            uiBean.setHubianswerkjt(khHubiWk.getHubianswerkjt());

            List<IW_KhHubiDetailWk> khHubiDetailWkLst = khHubiWk.getKhHubiDetailWks();

            for (IW_KhHubiDetailWk khHubiDetailWk : khHubiDetailWkLst) {

                HubiList2DataSourceBean hubiList2DSBean = new HubiList2DataSourceBean();

                String nyuuryokutantounm = "";

                AM_User userTouroku = baseDomManager.getUser(khHubiDetailWk.getHubitourokuktntid());

                if (userTouroku == null) {

                    nyuuryokutantounm = "";
                }
                else {

                    nyuuryokutantounm = userTouroku.getUserNm();
                }

                hubiList2DSBean.setDisptrkymd(khHubiDetailWk.getTrkymd());
                hubiList2DSBean.setDispsyoruicd(khHubiDetailWk.getHubisyoruicd());
                hubiList2DSBean.setDisphubisyoruinm(khHubiDetailWk.getHubisyoruinm());
                hubiList2DSBean.setDisphubinaiyoucd(khHubiDetailWk.getHubinaiyoucd());
                hubiList2DSBean.setDisphubinaiyoumsg(khHubiDetailWk.getHubinaiyoumsg());
                hubiList2DSBean.setDispgenponhnkykumu(khHubiDetailWk.getGenponhnkykumu());
                hubiList2DSBean.setDisphassinsakikbn(khHubiDetailWk.getHassinsakikbn());
                if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())
                    || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBean.setNyuryokutantouid("");
                }
                else if (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBean.setNyuryokutantouid(khHubiDetailWk.getHubitourokuktntid());
                }
                if (C_KhkinouModeIdKbn.HUBITOUROKU.getValue().equals(kinouMode.getKinouMode())
                    || C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBean.setDispnyuryokutantounm("");
                }
                else if (C_KhkinouModeIdKbn.HUBISYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                    hubiList2DSBean.setDispnyuryokutantounm(nyuuryokutantounm);
                }
                hubiList2DSBean.setSakujyoLink(sakujyoLink);
                hubiList2DSBean.setDisphassinymd(null);
                hubiList2DSBean.setDispsyounintantounm("");
                hubiList2DSBean.setSyounintantouid("");
                hubiList2DSBean.setSakujyoflg(C_Delflag.BLNK);
                hubiList2DSBean.setSakujyoflg2(C_Delflag.BLNK);

                hubiList2DataLst.add(hubiList2DSBean);
            }

            uiBean.setHubiList2(hubiList2DataLst);
        }
        else {
            setRnrkSk(uiBean.getSyono());

            uiBean.setHubiList2(hubiList2DataLst);
        }
    }

    private void setRnrkSk(String pSyono) {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        IT_KykSya kykSya = khozenCommonParam.getKeiyakusya(pSyono);

        uiBean.setRenrakusakinmkj(kykSya.getKyknmkj());
        uiBean.setRenrakuyno(kykSya.getTsinyno());
        uiBean.setRenrakusakiadr1kj(kykSya.getTsinadr1kj());
        uiBean.setRenrakusakiadr2kj(kykSya.getTsinadr2kj());
        uiBean.setRenrakusakiadr3kj(kykSya.getTsinadr3kj());
        uiBean.setRenrakusakitelno(kykSya.getTsintelno());
    }

    private void setKinou(String pJimuttzkCd) {

        C_SyoruiCdKbn syoruicd = C_SyoruiCdKbn.BLNK;

        if (IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_ADRHNK_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_MEIGIHNK_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_STDRSKYTKYKTYTHK.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_STDRHNK_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SEINEGAPPISEITS.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_SEINENGAPPISEI_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_GENGAKU_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_KAIYAKU_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SYOUKENSAIHAKKOU.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_SYOSAIHK_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_KYKTORIKESI_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_CLGOFF_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_KAIJYO_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_MUKOU_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_SBKAIJYO_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_SBMENSEKI_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIGOMAEBARAITKHENKOU.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_KAIGOMAETKHNK_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHMKHGKHENKOU.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_MKHGKHNK_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_SBMUKOU_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_SBMUKOUNOSHR_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_SBMENSEKINOSHR_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_YENDTHNKHNRKN_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHTMTTKINITEN.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_TUMITATEKINITEN_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHDSHR.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_DSHR_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.AS_HRHN_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKUKTKNINI.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_YENDTHNK_NINI_HB;
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHKZKTRKKYKDRHNK.equals(pJimuttzkCd)) {

            syoruicd = C_SyoruiCdKbn.KK_KZKTRK_KYKDRTKYKHNK_HB;
        }

        uiBean.setSyoruicd(syoruicd);
    }

    private void inputKeySyoriKengen() {

        String kinouMod = kinouMode.getKinouMode();

        if (BizUtil.isBlank(kinouMod)
            || C_KhkinouModeIdKbn.DEFAULT.getValue().equals(kinouMod)) {

            boolean inputkeyKengenFlg = baseUserInfo.hasAuthenticatedFunctionMode(C_KhkinouModeIdKbn.INPUTKEY
                .getValue());

            if (inputkeyKengenFlg) {

                kinouMode.setKinouMode(C_KhkinouModeIdKbn.INPUTKEY.getValue());
            }
            else {

                throw new BizAppException(MessageId.EBS0003);
            }
        }
    }

    private void setTensousaki() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String kouteiKanriId = uiBean.getBzWorkflowInfo().getKouteiKanriId();
        String jimuTetuzukiCd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setKouteiKanriId(kouteiKanriId);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> userList =
            bizDomManager. getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId(
                khozenCommonParam.getFunctionId(),
                kinouMode.getKinouMode(),
                baseUserInfo.getUserId(),
                jimuTetuzukiCd,
                bzGetProcessSummaryOutBean.getNowNodoId());

        UserDefsList userDefsList = new UserDefsList();

        LabelValuePair labelValuePairCls = SWAKInjector.getInstance(LabelValuePair.class);
        labelValuePairCls.setLabel("");
        labelValuePairCls.setValue("");

        userDefsList.add(labelValuePairCls);

        for (UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean bean : userList) {
            LabelValuePair labelValuePair = SWAKInjector.getInstance(LabelValuePair.class);
            labelValuePair.setLabel(bean.getUserNm());
            labelValuePair.setValue(bean.getUserId());
            userDefsList.add(labelValuePair);
        }

        List<BT_WariateHukaInfo> wariateHukaInfoLst = bizDomManager.getWariateHukaInfosByPKWithoutUserId(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            kinou.getSubSystemId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId());

        for (int i = 0; i <= wariateHukaInfoLst.size() - 1; i++) {

            for (int j = 0; j < userDefsList.size() - 1; j++) {

                if (userDefsList.get(j).getValue().equals(wariateHukaInfoLst.get(i).getUserId())) {

                    userDefsList.remove(j);
                }
            }
        }

        uiBean.setTennousakisousasyacdOptionBeanList(userDefsList);
    }

    private void addConversationMessage() {

        List<String> gmwarningIdLst = uiBean.getGmwarningIdLst();
        if (gmwarningIdLst != null && gmwarningIdLst.size() > 0) {
            List<String> gmwarningLst = uiBean.getGmwarningLst();
            int index = 0;
            for (String gmwarningId : gmwarningIdLst) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    BizUtil.getGeneralMessageId(gmwarningId),
                    gmwarningLst.get(index));
                index++;
            }
        }
    }

    private class HubiList2DataSourceBeanPredicate implements Predicate<HubiList2DataSourceBean> {

        public HubiList2DataSourceBeanPredicate() {
        }

        @Override
        public boolean apply(HubiList2DataSourceBean bean) {
            return C_Delflag.SAKUJYO.eq(bean.getSakujyoflg());
        }
    }

    private String setProcess(BzGetProcessSummaryOutBean outBean) {
        uiBean.getBzWorkflowInfo().setKouteiKanriId(outBean.getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(outBean.getJimuTetuzukiCd());
        uiBean.getBzWorkflowInfo().setTaskId(outBean.getNowNodoId());
        uiBean.setSksreadymd(outBean.getJimuStartYmd());
        uiBean.setItirankeiyuumukbn(C_UmuKbn.NONE);

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(outBean.getKouteiKanriId(), outBean.getJimuTetuzukiCd());

        SetKouteiInfo kouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        kouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran itiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        itiran.exec(uiBean);

        SetProgressHistory history = SWAKInjector.getInstance(SetProgressHistory.class);

        history.exec(uiBean);

        setKinou(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        setHubInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        addConversationMessage();

        return FORWARDNAME_INPUTCONTENTS;
    }

    private void checkGengkTtdk(String pJimuTetuzukiCd) {
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = null;
        BizDate kykYmd = null;
        BizDate kykYmd1NenAft = null;

        if (IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU.equals(pJimuTetuzukiCd)) {
            kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

            if (kykSonotaTkyk != null) {
                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {
                    kykSyouhn = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0);
                    kykYmd = kykSyouhn.getKykymd();

                    if ("0229".equals(kykYmd.getBizDateMD().toString())) {
                        kykYmd1NenAft = kykYmd.getNextDay().addYears(1).getRekijyou();
                    }
                    else {
                        kykYmd1NenAft = kykYmd.addYears(1).getRekijyou();
                    }

                    if (BizDateUtil.compareYmd(kykYmd1NenAft, BizDate.getSysDate()) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(kykYmd1NenAft, BizDate.getSysDate()) == BizDateUtil.COMPARE_EQUAL) {

                        List<String> gmwarningIdLst = Lists.newArrayList();
                        gmwarningIdLst.add(MessageId.WIF1024);
                        uiBean.setGmwarningIdLst(gmwarningIdLst);

                        List<String> gmwarningLst = Lists.newArrayList();
                        gmwarningLst.add(MessageUtil.getMessage(MessageId.WIF1024));
                        uiBean.setGmwarningLst(gmwarningLst);

                    }
                }
            }
        }
    }

    void removeConversationMessage() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING1);
    }
}