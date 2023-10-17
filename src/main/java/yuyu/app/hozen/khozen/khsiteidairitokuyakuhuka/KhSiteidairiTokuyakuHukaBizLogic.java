package yuyu.app.hozen.khozen.khsiteidairitokuyakuhuka;

import static yuyu.app.hozen.khozen.khsiteidairitokuyakuhuka.KhSiteidairiTokuyakuHukaConstants.*;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceTaskStart;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CheckHansyaSentakuInfo;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.EditHokenSyoukenParam;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiSyoriKengen;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetNkukt;
import yuyu.common.hozen.setuibean.SetSbHkukt;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.workflow.workflowutility.GetProcessHistoryResultBean;
import yuyu.common.workflow.workflowutility.ProcessHistoryBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HnsychkTaisyousyaKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IW_KhSiteidairiTokuyakuWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;

import com.lowagie.text.pdf.PdfReader;

/**
 * 被保険者代理特約中途付加 のビジネスロジックです。
 */
public class KhSiteidairiTokuyakuHukaBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private KhSiteidairiTokuyakuHukaUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

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

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private OutputReport outputReport;

    @Inject
    private DBAOutputReport dbaOutputReport;

    void init() {
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        uiBean.setKouteiLockKey(getKouteiLockKey());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        bzTaskStart.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            uiBean.getKouteiLockKey());

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo()
            .getKouteiKanriId());

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        IW_KhSiteidairiTokuyakuWk khSiteidairiTokuyakuWk = hozenDomManager.getKhSiteidairiTokuyakuWk(uiBean
            .getBzWorkflowInfo().getKouteiKanriId());

        uiBean.setZenkaiSyoriKekka(khSiteidairiTokuyakuWk.getZenkaisyorikekkakbn());

        chkKykExist();

        chkStdrsktkyhkUmu();

        chkStdrsktkyhk();

        chkJyoutai(KhSiteidairiTokuyakuHukaConstants.WORKLIST_GROUP_MESSAGE);

        chkTtdkTyuui(KhSiteidairiTokuyakuHukaConstants.WORKLIST_GROUP_MESSAGE);

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())
            && C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            messageManager.addConversationMessageId(
                KhSiteidairiTokuyakuHukaConstants.WORKLIST_GROUP_MESSAGE,
                MessageId.WIC0001,
                uiBean.getZenkaiSyoriKekka().getContent());
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        SetKihon.exec(khozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);

        setBetukyk.exec(khozenCommonParam, uiBean);

        addConversationMessageId(
            uiBean.getWarningMessageIdList(),
            uiBean.getWarningMessageList(),
            KhSiteidairiTokuyakuHukaConstants.WORKLIST_GROUP_MESSAGE);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean);

        SetTetudukityuui.exec(khozenCommonParam, uiBean);

        SetKeiyakusya.exec(khozenCommonParam, uiBean);

        SetTuusinsaki.exec(khozenCommonParam, uiBean);

        SetHihokensya.exec(khozenCommonParam, uiBean);

        SetNkukt.exec(khozenCommonParam, uiBean);

        SetSbHkukt.exec(khozenCommonParam, uiBean);

        SetTrkKazoku.exec(khozenCommonParam, uiBean);

        SetKyksyadairi.exec(khozenCommonParam, uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);

        setProgressHistory.exec(uiBean);

        uiBean.setKhstdrsktkyhnkkbn(C_StdrsktkyhnkKbn.HUKA);

        uiBean.setStdruktkbn(khSiteidairiTokuyakuWk.getStdruktkbn());

        uiBean.setStdrsknmkn(khSiteidairiTokuyakuWk.getStdrsknmkn());

        uiBean.setStdrsknmkj(khSiteidairiTokuyakuWk.getStdrsknmkj());

        uiBean.setStdrsknmkjhukakbn(khSiteidairiTokuyakuWk.getStdrsknmkjhukakbn());

        uiBean.setStdrskseiymd(khSiteidairiTokuyakuWk.getStdrskseiymd());

        uiBean.setHonninkakninkekkakbn(khSiteidairiTokuyakuWk.getHonninkakninkekkakbn());

        uiBean.setHassoukbn(khSiteidairiTokuyakuWk.getHassoukbn());
    }

    String functionNameOnClickBL() {

        String rtnUrl = null;

        if (uiBean.getPageNo() == KhSiteidairiTokuyakuHukaConstants.PAGENO_INPUTCONTENTS
            || uiBean.getPageNo() == KhSiteidairiTokuyakuHukaConstants.PAGENO_REFERENCE) {

            if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
                && !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

                unlockProcess();

                rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_BACKTOWORKLIST;
            }
            else {
                rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_INIT;
            }
        }
        else if (uiBean.getPageNo() == KhSiteidairiTokuyakuHukaConstants.PAGENO_CONFIRM) {

            if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

                unlockProcess();

                rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_BACKTOWORKLIST;
            }
            else {
                rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_INIT;
            }
        }
        else if (uiBean.getPageNo() == KhSiteidairiTokuyakuHukaConstants.PAGENO_RESULT) {

            if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

                rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_BACKTOWORKLIST;
            }
            else {
                rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_INIT;
            }
        }
        else {
            rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_INIT;
        }

        return rtnUrl;
    }

    void closeBL() {

        if (uiBean.getPageNo() == KhSiteidairiTokuyakuHukaConstants.PAGENO_INPUTCONTENTS
            || uiBean.getPageNo() == KhSiteidairiTokuyakuHukaConstants.PAGENO_REFERENCE) {

            if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
                && !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

                unlockProcess();
            }
        }
        else if (uiBean.getPageNo() == KhSiteidairiTokuyakuHukaConstants.PAGENO_CONFIRM) {

            if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

                unlockProcess();
            }
        }
    }

    void pushNyuuryokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        chkKykExist();

        chkStdrsktkyhkUmu();

        chkStdrsktkyhk();

        chkJyoutai(KhSiteidairiTokuyakuHukaConstants.GROUP_MESSAGE);

        chkTtdkTyuui(KhSiteidairiTokuyakuHukaConstants.GROUP_MESSAGE);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (BizDateUtil.compareYmd(BizDate.getSysDate(),
            khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0).getKykymd())
            == BizDateUtil.COMPARE_LESSER) {

            throw new BizLogicException(MessageId.EIA0070, SYORIBI);
        }

        IT_KykUkt iT_KykUkt = khozenCommonParam.getNenkinUketorinin(uiBean.getSyono());

        IT_KykSya iT_KykSya = khozenCommonParam.getKeiyakusya(uiBean.getSyono());

        if (iT_KykUkt != null) {
            if ((C_Tdk.HONNIN.eq(iT_KykSya.getKkkyktdk()) && !C_UktKbn.KYK.eq(iT_KykUkt.getUktkbn()))
                || (!C_Tdk.HONNIN.eq(iT_KykSya.getKkkyktdk()) && !C_UktKbn.HHKN.eq(iT_KykUkt.getUktkbn()))) {

                throw new BizLogicException(MessageId.EIF1088);
            }
        }

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);

        hanteiSyoriKengen.exec();

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        SetKihon.exec(khozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);

        setBetukyk.exec(khozenCommonParam, uiBean);

        addConversationMessageId(
            uiBean.getWarningMessageIdList(),
            uiBean.getWarningMessageList(),
            KhSiteidairiTokuyakuHukaConstants.GROUP_MESSAGE);

        SetTetudukityuui.exec(khozenCommonParam, uiBean);

        SetKeiyakusya.exec(khozenCommonParam, uiBean);

        SetTuusinsaki.exec(khozenCommonParam, uiBean);

        SetHihokensya.exec(khozenCommonParam, uiBean);

        SetNkukt.exec(khozenCommonParam, uiBean);

        SetSbHkukt.exec(khozenCommonParam, uiBean);

        SetTrkKazoku.exec(khozenCommonParam, uiBean);

        SetKyksyadairi.exec(khozenCommonParam, uiBean);

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_STDRSKYTKYKTYTHK);
    }

    void pushSyoukaiBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            && !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        SetHituyouSyorui.exec(khozenCommonParam, uiBean);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        setKhKbnPatternUtil.exec(uiBean);

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        uiBean.setRstCheckYuuyokkngai(checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate()));

        if(!uiBean.getRstCheckYuuyokkngai()){
            messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE,MessageId.WIA0011);
        }

        Long khHenreikinYendtMbrCount = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(uiBean.getSyono());
        if (khHenreikinYendtMbrCount > 0) {
            messageManager.addConversationMessageId(INPUTCONTENTS_GROUP_MESSAGE, MessageId.WIA1017);
        }
    }

    String modoruBtnByInputBL() {

        String rtnUrl = null;

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            && !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            unlockProcess();

            rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_BACKTOWORKLIST;
        }
        else {
            rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_INIT;
        }

        return rtnUrl;
    }

    void printHyoujiOutBL() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOutBL() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void pushSeikyuusyoSakuseiBL() {

        chkJimutetuzuki();

        if(!uiBean.getRstCheckYuuyokkngai()){

            throw new BizLogicException(MessageId.EIA1032,SYORIBI);
        }

        messageManager.addMessageId(MessageId.QIA0004);
    }

    String pushSyoukainomiBL() {

        String rtnUrl = null;

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            && !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            unlockProcess();

            rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_BACKTOWORKLIST;
        }
        else {
            rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_INIT;
        }

        return rtnUrl;
    }

    void pushSainyuuryokuBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            && !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }

        messageManager.removeConversationMessage(INPUTCONTENTS_GROUP_MESSAGE);
    }

    void pushKakuninBL() {

        BizDate sysDate = BizDate.getSysDate();

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }
        else {
            chkProcessKaishi();
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

                if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) {

                    boolean checkRet = CheckKana.isKyokaMoji(uiBean.getStdrsknmkn());

                    if (!checkRet) {

                        throw new BizLogicException(MessageId.EBC0046, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKN);
                    }

                    checkRet = CheckKana.isKyoyouKetaHankaku(uiBean.getStdrsknmkn(),
                        KhSiteidairiTokuyakuHukaConstants.KYOYOUKETASUU);

                    if (!checkRet) {

                        throw new BizLogicException(MessageId.EBC0004, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKN,
                            String.valueOf(KhSiteidairiTokuyakuHukaConstants.KYOYOUKETASUU));
                    }

                    boolean result = CheckMeigininNmKanji.isCheckOK(uiBean.getStdrsknmkj(), C_Kojinhjn.KOJIN);

                    if (!result) {
                        throw new BizLogicException(MessageId.EBC0046, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKJ);
                    }

                    if (C_UktKbn.BLNK.eq(uiBean.getStdruktkbn())) {

                        throw new BizLogicException(MessageId.EBC0043, KhSiteidairiTokuyakuHukaConstants.STDRUKTKBN);
                    }
                    else if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getStdruktkbn())) {

                        if (BizUtil.isBlank(uiBean.getStdrsknmkn())) {

                            throw new BizLogicException(MessageId.EBC0043, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKN);
                        }

                        if (BizUtil.isBlank(uiBean.getStdrsknmkj())) {

                            throw new BizLogicException(MessageId.EBC0043, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKJ);
                        }

                        if (uiBean.getStdrskseiymd() == null) {

                            throw new BizLogicException(MessageId.EBC0043, KhSiteidairiTokuyakuHukaConstants.HHKNDAIRISEIYMD);
                        }
                    }
                    else {

                        if (!BizUtil.isBlank(uiBean.getStdrsknmkn())) {

                            throw new BizLogicException(MessageId.EBC0007, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKN);
                        }

                        if (!BizUtil.isBlank(uiBean.getStdrsknmkj())) {

                            throw new BizLogicException(MessageId.EBC0007, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKJ);
                        }

                        if (!C_KjkhukaKbn.BLNK.eq(uiBean.getStdrsknmkjhukakbn())) {

                            throw new BizLogicException(MessageId.EBC0007,
                                KhSiteidairiTokuyakuHukaConstants.STDRSKKJHUKAKBN);
                        }

                        if (uiBean.getStdrskseiymd() != null) {

                            throw new BizLogicException(MessageId.EBC0007,
                                KhSiteidairiTokuyakuHukaConstants.HHKNDAIRISEIYMD);
                        }

                        if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getStdruktkbn())) {
                            if (C_UmuKbn.NONE.eq(uiBean.getVtrkkzktrkkzkumukbn1())) {

                                throw new BizLogicException(MessageId.EIA1068, KhSiteidairiTokuyakuHukaConstants.TRKKZKINFO1);
                            }
                        }

                        if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getStdruktkbn())) {
                            if (C_UmuKbn.NONE.eq(uiBean.getVtrkkzktrkkzkumukbn2())) {

                                throw new BizLogicException(MessageId.EIA1068, KhSiteidairiTokuyakuHukaConstants.TRKKZKINFO2);
                            }
                        }
                    }

                    if (uiBean.getStdrskseiymd() != null &&
                        BizDateUtil.compareYmd(uiBean.getStdrskseiymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {

                        throw new BizLogicException(MessageId.EIA0037, KhSiteidairiTokuyakuHukaConstants.HHKNDAIRISEIYMD);
                    }

                    if (C_UktKbn.KYK.eq(uiBean.getStdruktkbn()) && C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {

                        throw new BizLogicException(MessageId.EBC1001);
                    }
                    else if (C_UktKbn.SBUK.eq(uiBean.getStdruktkbn())) {

                        if (uiBean.getVshktsbuktnin() >= 2) {

                            throw new BizLogicException(MessageId.EBC1004);
                        }

                        if (C_UktKbn.SOUZOKUNIN.eq(uiBean.getVshktdispsbuktkbn1())) {

                            throw new BizLogicException(MessageId.EBC1006);
                        }

                        if (C_UktKbn.KYK.eq(uiBean.getVshktdispsbuktkbn1())) {

                            throw new BizLogicException(MessageId.EIA1019, C_UktKbn.getContentByValue(
                                C_UktKbn.PATTERN_KHSBUK, C_UktKbn.KYK.getValue()));
                        }

                        if (C_UktKbn.HHKN.eq(uiBean.getVshktdispsbuktkbn1())) {

                            throw new BizLogicException(MessageId.EIA1019, C_UktKbn.getContentByValue(
                                C_UktKbn.PATTERN_KHSBUK, C_UktKbn.HHKN.getValue()));
                        }
                    }

                    if(!uiBean.getRstCheckYuuyokkngai()){

                        throw new BizLogicException(MessageId.EIA1032,SYORIBI);
                    }

                    checkHanteiKhSisuurendoTmttknJyoutai();

                    checkHhknDairininInfoHnsy();

                    if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {

                        throw new BizLogicException(MessageId.EBC0043,
                            KhSiteidairiTokuyakuHukaConstants.HONNINKAKNINKEKKAKBN);
                    }

                    if (C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn())
                        && C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

                        throw new BizLogicException(MessageId.EIA1007);
                    }
                }
            }

            CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);

            checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh(),
                uiBean.getSasimodosisakikbn());
        }

        else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {

                boolean checkRet = CheckKana.isKyokaMoji(uiBean.getStdrsknmkn());

                if (!checkRet) {

                    throw new BizLogicException(MessageId.EBC0046, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKN);
                }

                checkRet = CheckKana.isKyoyouKetaHankaku(uiBean.getStdrsknmkn(),
                    KhSiteidairiTokuyakuHukaConstants.KYOYOUKETASUU);

                if (!checkRet) {

                    throw new BizLogicException(MessageId.EBC0004, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKN,
                        String.valueOf(KhSiteidairiTokuyakuHukaConstants.KYOYOUKETASUU));
                }

                boolean result = CheckMeigininNmKanji.isCheckOK(uiBean.getStdrsknmkj(), C_Kojinhjn.KOJIN);

                if (!result) {
                    throw new BizLogicException(MessageId.EBC0046, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKJ);
                }

                if (C_UktKbn.BLNK.eq(uiBean.getStdruktkbn())) {

                    throw new BizLogicException(MessageId.EBC0043, KhSiteidairiTokuyakuHukaConstants.STDRUKTKBN);
                }
                else if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getStdruktkbn())) {

                    if (BizUtil.isBlank(uiBean.getStdrsknmkn())) {

                        throw new BizLogicException(MessageId.EBC0043, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKN);
                    }

                    if (BizUtil.isBlank(uiBean.getStdrsknmkj())) {

                        throw new BizLogicException(MessageId.EBC0043, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKJ);
                    }

                    if (uiBean.getStdrskseiymd() == null) {

                        throw new BizLogicException(MessageId.EBC0043, KhSiteidairiTokuyakuHukaConstants.HHKNDAIRISEIYMD);
                    }
                }
                else {

                    if (!BizUtil.isBlank(uiBean.getStdrsknmkn())) {

                        throw new BizLogicException(MessageId.EBC0007, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKN);
                    }

                    if (!BizUtil.isBlank(uiBean.getStdrsknmkj())) {

                        throw new BizLogicException(MessageId.EBC0007, KhSiteidairiTokuyakuHukaConstants.STDRSKNMKJ);
                    }

                    if (!C_KjkhukaKbn.BLNK.eq(uiBean.getStdrsknmkjhukakbn())) {

                        throw new BizLogicException(MessageId.EBC0007,
                            KhSiteidairiTokuyakuHukaConstants.STDRSKKJHUKAKBN);
                    }

                    if (uiBean.getStdrskseiymd() != null) {

                        throw new BizLogicException(MessageId.EBC0007,
                            KhSiteidairiTokuyakuHukaConstants.HHKNDAIRISEIYMD);
                    }

                    if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getStdruktkbn())) {
                        if (C_UmuKbn.NONE.eq(uiBean.getVtrkkzktrkkzkumukbn1())) {

                            throw new BizLogicException(MessageId.EIA1068, KhSiteidairiTokuyakuHukaConstants.TRKKZKINFO1);
                        }
                    }

                    if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getStdruktkbn())) {
                        if (C_UmuKbn.NONE.eq(uiBean.getVtrkkzktrkkzkumukbn2())) {

                            throw new BizLogicException(MessageId.EIA1068, KhSiteidairiTokuyakuHukaConstants.TRKKZKINFO2);
                        }
                    }
                }

                if (uiBean.getStdrskseiymd() != null &&
                    BizDateUtil.compareYmd(uiBean.getStdrskseiymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {

                    throw new BizLogicException(MessageId.EIA0037, KhSiteidairiTokuyakuHukaConstants.HHKNDAIRISEIYMD);
                }

                if (C_UktKbn.KYK.eq(uiBean.getStdruktkbn()) && C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {

                    throw new BizLogicException(MessageId.EBC1001);
                }
                else if (C_UktKbn.SBUK.eq(uiBean.getStdruktkbn())) {

                    if (uiBean.getVshktsbuktnin() >= 2) {

                        throw new BizLogicException(MessageId.EBC1004);
                    }

                    if (C_UktKbn.SOUZOKUNIN.eq(uiBean.getVshktdispsbuktkbn1())) {

                        throw new BizLogicException(MessageId.EBC1006);
                    }

                    if (C_UktKbn.KYK.eq(uiBean.getVshktdispsbuktkbn1())) {

                        throw new BizLogicException(MessageId.EIA1019, C_UktKbn.getContentByValue(
                            C_UktKbn.PATTERN_KHSBUK, C_UktKbn.KYK.getValue()));
                    }

                    if (C_UktKbn.HHKN.eq(uiBean.getVshktdispsbuktkbn1())) {

                        throw new BizLogicException(MessageId.EIA1019, C_UktKbn.getContentByValue(
                            C_UktKbn.PATTERN_KHSBUK, C_UktKbn.HHKN.getValue()));
                    }
                }

                if(!uiBean.getRstCheckYuuyokkngai()){

                    throw new BizLogicException(MessageId.EIA1032,SYORIBI);
                }

                checkHanteiKhSisuurendoTmttknJyoutai();

                checkHhknDairininInfoHnsy();

                if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {

                    throw new BizLogicException(MessageId.EBC0043,
                        KhSiteidairiTokuyakuHukaConstants.HONNINKAKNINKEKKAKBN);
                }

                if (C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn())
                    && C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

                    throw new BizLogicException(MessageId.EIA1007);
                }
            }

            CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);

            checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh(),
                uiBean.getSasimodosisakikbn());
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiByKakuninBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }
        else {
            chkProcessKaishi();

            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

            C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

            if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
            }

            BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);

            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);

            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
            bzProcessCreateInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzProcessCreateOutBean.getKouteiKanriId());

            lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            uiBean.setKouteiLockKey(getKouteiLockKey());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);

            bzForceTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                C_KhkinouModeIdKbn.INPUT.getValue(),
                uiBean.getKouteiLockKey());
        }

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        String kinouID = kinou.getKinouId();

        String userID = baseUserInfo.getUserId();

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
                !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) {

                TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

                String key = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

                tableMaintenanceUtil.backUp(uiBean.getSyono(), key);

                uiBean.getKykKihon().setSyhenkouymd(sysDate);

                uiBean.getKykKihon().setLastsyosaihkymd(sysDate);

                uiBean.getKykKihon().setGyoumuKousinKinou(kinouID);

                uiBean.getKykKihon().setGyoumuKousinsyaId(userID);

                uiBean.getKykKihon().setGyoumuKousinTime(sysDateTimeMilli);

                IT_KhTtdkRireki khTtdkRirekis = uiBean.getKykKihon().createKhTtdkRireki();

                khTtdkRirekis.setHenkousikibetukey(key);

                BizPropertyInitializer.initialize(khTtdkRirekis);

                IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

                kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);

                kykSonotaTkyk.setStdrsktkyhkymd(sysDate);

                kykSonotaTkyk.setGyoumuKousinKinou(kinouID);

                kykSonotaTkyk.setGyoumuKousinsyaId(userID);

                kykSonotaTkyk.setGyoumuKousinTime(sysDateTimeMilli);

                IT_KykUkt kykUkt = uiBean.getKykKihon().createKykUkt();

                kykUkt.setSyono(uiBean.getSyono());

                kykUkt.setUktsyukbn(C_UktsyuKbn.STDRSK);

                kykUkt.setUktsyurenno(1);

                kykUkt.setUktkbn(uiBean.getStdruktkbn());

                kykUkt.setUktnmkn(uiBean.getStdrsknmkn());

                kykUkt.setUktnmkj(uiBean.getStdrsknmkj());

                kykUkt.setUktnmkjkhukakbn(uiBean.getStdrsknmkjhukakbn());

                kykUkt.setUktseiymd(uiBean.getStdrskseiymd());

                kykUkt.setUktbnwari(BizNumber.valueOf(100));

                kykUkt.setGyoumuKousinKinou(kinouID);

                kykUkt.setGyoumuKousinsyaId(userID);

                kykUkt.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(kykUkt);

                PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);

                pALKykNaiyouKousin.exec(uiBean.getKykKihon());

                String youkyuuno = pALKykNaiyouKousin.getYoukyuuno();

                EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

                EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);

                editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());

                editTtdkRirekiTblParam.setSyoriYmd(sysDate);

                editTtdkRirekiTblParam.setSysTime(sysDateTimeMilli);

                editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());

                editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

                editTtdkRirekiTblParam.setYoukyuuNo(youkyuuno);

                editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());

                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);

                EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);

                KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

                editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.STDRHUKA);

                editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_STDRHNK_TTDKKR);

                editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);

                editTtdkKanryouParam.setStdruktkbn(uiBean.getStdruktkbn());

                if (C_UktKbn.KYK.eq(uiBean.getStdruktkbn())) {

                    editTtdkKanryouParam.setStdrsknmkj(uiBean.getVkykskyknmkj());

                    editTtdkKanryouParam.setStdrsknmkn(uiBean.getVkykskyknmkn());

                    editTtdkKanryouParam.setStdrskKjkhuka(uiBean.getVkykskyknmkjkhukakbn());
                }
                else if (C_UktKbn.SBUK.eq(uiBean.getStdruktkbn())) {

                    if (C_UktKbn.KYK.eq(uiBean.getVshktdispsbuktkbn1())) {

                        editTtdkKanryouParam.setStdrsknmkj(uiBean.getVkykskyknmkj());

                        editTtdkKanryouParam.setStdrsknmkn(uiBean.getVkykskyknmkn());

                        editTtdkKanryouParam.setStdrskKjkhuka(uiBean.getVkykskyknmkjkhukakbn());
                    }
                    else if (C_UktKbn.HHKN.eq(uiBean.getVshktdispsbuktkbn1())) {

                        editTtdkKanryouParam.setStdrsknmkj(uiBean.getVhhkshhknnmkj());

                        editTtdkKanryouParam.setStdrsknmkn(uiBean.getVhhkshhknnmkn());

                        editTtdkKanryouParam.setStdrskKjkhuka(uiBean.getVhhkshhknnmkjkhukakbn());
                    }
                    else {

                        editTtdkKanryouParam.setStdrsknmkj(uiBean.getVshktdispsbuktnmkj1());

                        editTtdkKanryouParam.setStdrsknmkn(uiBean.getVshktdispsbuktnmkn1());

                        editTtdkKanryouParam.setStdrskKjkhuka(uiBean.getVshktdispsbuktnmkjhukakbn1());
                    }
                }
                else if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getStdruktkbn())) {

                    editTtdkKanryouParam.setStdrsknmkj(uiBean.getVtrkkzktrkkzknmkj1());

                    editTtdkKanryouParam.setStdrsknmkn(uiBean.getVtrkkzktrkkzknmkn1());

                    editTtdkKanryouParam.setStdrskKjkhuka(uiBean.getVtrkkzktrkkzknmkjkhukakbn1());
                }
                else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getStdruktkbn())) {

                    editTtdkKanryouParam.setStdrsknmkj(uiBean.getVtrkkzktrkkzknmkj2());

                    editTtdkKanryouParam.setStdrsknmkn(uiBean.getVtrkkzktrkkzknmkn2());

                    editTtdkKanryouParam.setStdrskKjkhuka(uiBean.getVtrkkzktrkkzknmkjkhukakbn2());
                }
                else {

                    editTtdkKanryouParam.setStdrsknmkj(uiBean.getStdrsknmkj());

                    editTtdkKanryouParam.setStdrsknmkn(uiBean.getStdrsknmkn());

                    editTtdkKanryouParam.setStdrskKjkhuka(uiBean.getStdrsknmkjhukakbn());
                }

                editHokenSyoukenParam.setCalckijyunYMD(sysDate);

                editHokenSyoukenParam.setStdrsktkyhnkKbn(uiBean.getKhstdrsktkyhnkkbn());

                List<IT_KhHenkouUktk> khHenkouUktkLst = hozenDomManager.getKhHenkouUktksBySyono(uiBean.getSyono());

                C_HassouKbn hassouKbn = uiBean.getHassoukbn();

                if (khHenkouUktkLst.size() > 0) {
                    BizDate uktkYmd = khHenkouUktkLst.get(0).getUktkymd();

                    GetProcessHistoryResultBean resultBean = WorkFlowUtility.getProcessHistory(
                        uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
                    List<ProcessHistoryBean> processHistoryBeanLst = resultBean.getProcessHistoryBeanList();

                    if (WorkFlowResultConstants.RESULT_WARN.equals(resultBean.getSyorikekkaStatus()) ||
                        WorkFlowResultConstants.RESULT_NG.equals(resultBean.getSyorikekkaStatus()) ||
                        WorkFlowResultConstants.RESULT_LOCK.equals(resultBean.getSyorikekkaStatus()) ||
                        WorkFlowResultConstants.RESULT_TORIKESIZUMI.equals(resultBean.getSyorikekkaStatus())) {
                        logger.error("ワークフロー呼出Utility#工程履歴取得");
                        logger.error("エラーコード：" + resultBean.getSyousaiMessageCd());
                        logger.error("エラーメッセージ：" + resultBean.getSyousaiMessage());

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EAS0037));
                    }
                    else if (WorkFlowResultConstants.RESULT_OK.equals(resultBean.getSyorikekkaStatus())) {
                        for (ProcessHistoryBean processHistoryBean : processHistoryBeanLst) {
                            String taskNm = processHistoryBean.getTaskNm();

                            if (IKhozenCommonConstants.NODEID_INPUT.equals(taskNm)) {
                                BizDate processYmd = BizDate.valueOf(processHistoryBean.getProcessYmdTime().substring(
                                    0, 8));
                                if (BizDateUtil.compareYmd(processYmd, uktkYmd) == BizDateUtil.COMPARE_EQUAL ||
                                    BizDateUtil.compareYmd(processYmd, uktkYmd) == BizDateUtil.COMPARE_LESSER) {
                                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                                    break;
                                }
                            }
                        }
                    }
                }

                khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);

                khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);

                khozenTyouhyouCtl.setHassoukbn(hassouKbn);

                khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam,
                    uiBean.getSyono(),
                    new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_STDRHNK_TTDKKR, C_SyoruiCdKbn.KK_HKNSYKN },
                    C_YouhiKbn.HUYOU);

                uiBean.setTyouhyouKey(khozenTyouhyouCtl.getTyouhyouKey());

                hozenDomManager.update(uiBean.getKykKihon());
            }

            KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

            KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

            khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
            khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
            khRuleBean.setSaiwariateUserId("");

            khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getKouteiLockKey(),
                uiBean.getSyanaicommentkh(),
                khRuleBean);

            unlockProcess();

            IW_KhSiteidairiTokuyakuWk khSiteidairiTokuyakuWk = hozenDomManager.getKhSiteidairiTokuyakuWk(
                uiBean.getBzWorkflowInfo().getKouteiKanriId());

            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
                hozenDomManager.delete(khSiteidairiTokuyakuWk);
            }
            else {
                khSiteidairiTokuyakuWk.setGyoumuKousinKinou(kinouID);

                khSiteidairiTokuyakuWk.setGyoumuKousinsyaId(userID);

                khSiteidairiTokuyakuWk.setGyoumuKousinTime(sysDateTimeMilli);

                if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

                    khSiteidairiTokuyakuWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
                }
            }
        }
        else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
            || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
                (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                    C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn()) ||
                    C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn()))) {

                IW_KhSiteidairiTokuyakuWk khSiteidairiTokuyakuWk = new IW_KhSiteidairiTokuyakuWk();

                khSiteidairiTokuyakuWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());

                khSiteidairiTokuyakuWk.setSyono(uiBean.getSyono());

                khSiteidairiTokuyakuWk.setStdruktkbn(uiBean.getStdruktkbn());

                khSiteidairiTokuyakuWk.setStdrsknmkn(uiBean.getStdrsknmkn());

                khSiteidairiTokuyakuWk.setStdrsknmkj(uiBean.getStdrsknmkj());

                khSiteidairiTokuyakuWk.setStdrsknmkjhukakbn(uiBean.getStdrsknmkjhukakbn());

                khSiteidairiTokuyakuWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());

                khSiteidairiTokuyakuWk.setHassoukbn(uiBean.getHassoukbn());

                khSiteidairiTokuyakuWk.setGyoumuKousinKinou(kinouID);

                khSiteidairiTokuyakuWk.setGyoumuKousinsyaId(userID);

                khSiteidairiTokuyakuWk.setGyoumuKousinTime(sysDateTimeMilli);

                khSiteidairiTokuyakuWk.setStdrskseiymd(uiBean.getStdrskseiymd());

                if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

                    khSiteidairiTokuyakuWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
                }

                BizPropertyInitializer.initialize(khSiteidairiTokuyakuWk);

                hozenDomManager.insert(khSiteidairiTokuyakuWk);
            }
            else if ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) || C_KhkinouModeIdKbn.TENKEN
                .getValue().equals(kinouMode.getKinouMode()))) {
                IW_KhSiteidairiTokuyakuWk khSiteidairiTokuyakuWk = hozenDomManager.getKhSiteidairiTokuyakuWk(
                    uiBean.getBzWorkflowInfo().getKouteiKanriId());

                if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                    C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn()) ||
                    C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())) {

                    khSiteidairiTokuyakuWk.setSyono(uiBean.getSyono());

                    khSiteidairiTokuyakuWk.setStdruktkbn(uiBean.getStdruktkbn());

                    khSiteidairiTokuyakuWk.setStdrsknmkn(uiBean.getStdrsknmkn());

                    khSiteidairiTokuyakuWk.setStdrsknmkj(uiBean.getStdrsknmkj());

                    khSiteidairiTokuyakuWk.setStdrsknmkjhukakbn(uiBean.getStdrsknmkjhukakbn());

                    khSiteidairiTokuyakuWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());

                    khSiteidairiTokuyakuWk.setHassoukbn(uiBean.getHassoukbn());

                    khSiteidairiTokuyakuWk.setGyoumuKousinKinou(kinouID);

                    khSiteidairiTokuyakuWk.setGyoumuKousinsyaId(userID);

                    khSiteidairiTokuyakuWk.setGyoumuKousinTime(sysDateTimeMilli);

                    khSiteidairiTokuyakuWk.setStdrskseiymd(uiBean.getStdrskseiymd());

                    if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

                        khSiteidairiTokuyakuWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
                    }
                }
                else {
                    khSiteidairiTokuyakuWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());

                    khSiteidairiTokuyakuWk.setGyoumuKousinKinou(kinouID);

                    khSiteidairiTokuyakuWk.setGyoumuKousinsyaId(userID);

                    khSiteidairiTokuyakuWk.setGyoumuKousinTime(sysDateTimeMilli);
                }
                hozenDomManager.update(khSiteidairiTokuyakuWk);
            }

            KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

            KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

            khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
            khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
            khRuleBean.setSaiwariateUserId("");

            khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getKouteiLockKey(),
                uiBean.getSyanaicommentkh(),
                khRuleBean);

            unlockProcess();
        }

        if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
            !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) ||
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekka())) {
            uiBean.getKykKihon().detach();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void modoruBtnByKakuninBL () {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
    }

    String syokigamenBykekkaBL() {

        String rtnUrl = null;

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_BACKTOWORKLIST;
        }
        else {

            rtnUrl = KhSiteidairiTokuyakuHukaConstants.FORWARDNAME_INIT;
        }

        return rtnUrl;
    }

    @Transactional
    void pushKakuteiBySksconfirmBL() {

        chkJimutetuzuki();

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector
            .getInstance(KhHituyousyoruiHanteiInBean.class);

        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());

        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());

        hozenPreReportRenkeiBean.setSyoriComment("");

        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);

        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);

        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam,
            uiBean.getSyono(),
            new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_STDRHNK_SOUHU, C_SyoruiCdKbn.KK_STDRHNK_SKS },
            C_YouhiKbn.YOU);

        uiBean.setTyouhyouKey(khozenTyouhyouCtl.getTyouhyouKey());

        IW_KhSiteidairiTokuyakuWk khSiteidairiTokuyakuWk = new IW_KhSiteidairiTokuyakuWk();

        khSiteidairiTokuyakuWk.setKouteikanriid(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());

        khSiteidairiTokuyakuWk.setSyono(uiBean.getSyono());

        khSiteidairiTokuyakuWk.setSkssakuseiymd(BizDate.getSysDate());

        khSiteidairiTokuyakuWk.setGyoumuKousinKinou(kinou.getKinouId());

        khSiteidairiTokuyakuWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());

        khSiteidairiTokuyakuWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(khSiteidairiTokuyakuWk);

        hozenDomManager.insert(khSiteidairiTokuyakuWk);

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    void printOut() {

        String tyhykey = uiBean.getTyouhyouKey();

        try {
            byte[] pdfByte = dbaOutputReport.getPdfImagesByJoinKeys(new String[] { tyhykey });

            String fpath = SWAK.getApplicationRootPath() +
                YuyuHozenConfig.getInstance().getSiteidairiTkYakkanFilePath();

            PdfBuilder pdfBuilder = new PdfBuilder();

            pdfBuilder.append(new PdfReader(pdfByte));
            pdfBuilder.append(new PdfReader(fpath));

            outputReport.outputJoinedPDFByBinary(pdfBuilder.toByteArray(), tyhykey);
        } catch (IOException e) {
            throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
        }
    }

    void unlockProcess() {

        bzCommonLockProcess.unlockProcess();
    }

    private void lockProcess(String pKouteiKanriId, String pJimuTetuzukiCd) {

        bzCommonLockProcess.lockProcess(pKouteiKanriId, pJimuTetuzukiCd);
    }

    private void continueLockProcess() {

        bzCommonLockProcess.continueLockProcess();
    }

    private String getKouteiLockKey() {

        return bzCommonLockProcess.getKouteiLockKey();
    }

    private void chkKykExist() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);
    }

    private void chkStdrsktkyhkUmu() {

        List<IT_KykSyouhn> kykSyouhnList = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnList.get(0).getSyouhnZokusei();

        if (!C_UmuKbn.ARI.eq(syouhnZokusei.getStdrsktkumu())) {

            throw new BizLogicException(MessageId.EIF1010);
        }
    }

    private void chkStdrsktkyhk() {

        IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {

            throw new BizLogicException(MessageId.EIF1009);
        }
    }

    private void chkJyoutai(int pGroupId) {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {

            for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {

                messageManager.addConversationMessageId(
                    pGroupId,
                    checkYuukouJyoutai.getWarningMessageIDList().get(i),
                    checkYuukouJyoutai.getWarningMessageList().get(i));
            }
        }
    }

    private void chkTtdkTyuui(int pGroupId) {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {

            messageManager.addConversationMessageId(pGroupId,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }
    }

    private void chkJimutetuzuki() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn cUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(cUmuKbn)) {

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(
                    checkProcessKaishi.getBzGetProcessSummaryOutBean().getKouteiStartYmd()));
        }
    }

    private void chkProcessKaishi() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn cUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo()
            .getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(cUmuKbn)) {

            throw new BizLogicException(MessageId.EIA1002,
                DefaultDateFormatter.formatYMDZeroFill(
                    checkProcessKaishi.getBzGetProcessSummaryOutBean().getKouteiStartYmd()));
        }
    }

    private void checkHanteiKhSisuurendoTmttknJyoutai() {

        String syouhncd = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getSyouhncd();

        int syouhnhanteiKbn = SyouhinUtil.henkouKubetuHantei(syouhncd);

        if (syouhnhanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE ||
            syouhnhanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE) {

            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
            hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(BizDate.getSysDate());
            hanteiTmttknJyoutaiBean.setKykymd(uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getKykymd());

            HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

            boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

            if (!result) {
                throw new BizLogicException(MessageId.EBA1052);
            }
        }
    }

    private void checkHhknDairininInfoHnsy() {

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);
        boolean warningFlg = true;

        C_ErrorKbn tyotkhknHyjSetKekkbn = setTyotikuseihokenhyouji.exec(uiBean.getKykKihon());
        C_UmuKbn houteiTyotkhknHyj = setTyotikuseihokenhyouji.getHouteityotkhknhyj();
        C_UmuKbn tyotkhknHyj = setTyotikuseihokenhyouji.getTyotkhknhyj();

        if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getStdruktkbn())) {
            warningFlg = checkHansyaSentakuInfo.exec(
                C_HnsychkTaisyousyaKbn.STDRSK,
                uiBean.getStdrsknmkn(),
                uiBean.getStdrsknmkj(),
                uiBean.getStdrsknmkjhukakbn(),
                uiBean.getStdrskseiymd(),
                uiBean.getKykKihon().getKykSya().getTsinyno(),
                tyotkhknHyjSetKekkbn,
                houteiTyotkhknHyj,
                tyotkhknHyj);
        }
        else if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getStdruktkbn())) {
            warningFlg = checkHansyaSentakuInfo.exec(
                C_HnsychkTaisyousyaKbn.STDRSK,
                uiBean.getVtrkkzktrkkzknmkn1(),
                uiBean.getVtrkkzktrkkzknmkj1(),
                uiBean.getVtrkkzktrkkzknmkjkhukakbn1(),
                uiBean.getVtrkkzktrkkzkseiymd1(),
                uiBean.getVtrkkzktrkkzkyno1(),
                tyotkhknHyjSetKekkbn,
                houteiTyotkhknHyj,
                tyotkhknHyj);
        }
        else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getStdruktkbn())) {
            warningFlg = checkHansyaSentakuInfo.exec(
                C_HnsychkTaisyousyaKbn.STDRSK,
                uiBean.getVtrkkzktrkkzknmkn2(),
                uiBean.getVtrkkzktrkkzknmkj2(),
                uiBean.getVtrkkzktrkkzknmkjkhukakbn2(),
                uiBean.getVtrkkzktrkkzkseiymd2(),
                uiBean.getVtrkkzktrkkzkyno2(),
                tyotkhknHyjSetKekkbn,
                houteiTyotkhknHyj,
                tyotkhknHyj);
        }

        if (!warningFlg) {

            String waringMessage = "";
            String waringMessageId = "";

            for (int n = 0; n < checkHansyaSentakuInfo.getWarningMsgList().size(); n++) {

                waringMessageId = BizUtil.getGeneralMessageId(checkHansyaSentakuInfo.getWarningMsgIdList().get(n));
                waringMessage = checkHansyaSentakuInfo.getWarningMsgList().get(n);

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING4,
                    waringMessageId,
                    waringMessage);
            }
        }
    }

    private void addConversationMessageId(List<String> pWwarningMessageIdList, List<String> pWarningMessageList,
        int pGroupId) {

        if (pWwarningMessageIdList != null) {

            for (int n = 0; n < pWwarningMessageIdList.size(); n++) {

                messageManager.addConversationMessageId(
                    pGroupId,
                    pWwarningMessageIdList.get(n),
                    pWarningMessageList.get(n));
            }
        }
    }

}
