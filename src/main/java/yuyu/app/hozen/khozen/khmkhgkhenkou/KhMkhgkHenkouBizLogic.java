package yuyu.app.hozen.khozen.khmkhgkhenkou;

import static yuyu.app.hozen.khozen.khmkhgkhenkou.KhMkhgkHenkouConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khmkhgkhenkou.dba.KhMkhgkHenkouDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceTaskStart;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.HanteiSyoriKengen;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.MkhgkhenkouDBUpdate;
import yuyu.common.hozen.khcommon.MkhgkhenkouDBUpdateBean;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetHituyouSyorui;
import yuyu.common.hozen.setuibean.SetHosyou;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtil;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetSonotaTk;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.common.hozen.setuibean.SetTuusinsaki;
import yuyu.common.sinkeiyaku.skcommon.ConvertChannelcd;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhMkhgkHenkouWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

/**
 * 目標額変更 のビジネスロジックです。
 */
public class KhMkhgkHenkouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhMkhgkHenkouUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private OutputReport outputReport;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KhMkhgkHenkouDao khMkhgkHenkouDao;

    void init() {
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        String kouteikanriId = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        String jimutetuzukiCd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(kouteikanriId, jimutetuzukiCd);

        uiBean.setKouteiLockKey(bzCommonLockProcess.getKouteiLockKey());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            kouteikanriId,
            jimutetuzukiCd,
            uiBean.getBzWorkflowInfo().getTaskId(),
            uiBean.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteikanriId);

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        chkKykExist();

        chkTargettkhkUmu();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        chkYuukouJyoutaiAndHanteiTetuduki(khozenCommonParam);

        chkDSKhMkhgkHenkouuktk();

        setKinouUiBean(khozenCommonParam);

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);

        IW_KhMkhgkHenkouWk khMkhgkHenkouWk = hozenDomManager.getKhMkhgkHenkouWk(kouteikanriId);

        BizDate syoruiUkeYmd = null;

        if (khMkhgkHenkouWk.getSyoruiukeymd() == null) {

            GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);

            syoruiUkeYmd = getSyoruittykymd.exec(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                C_SyoruiCdKbn.KK_MKHGKHNK_SKS);
        }
        else {

            syoruiUkeYmd = khMkhgkHenkouWk.getSyoruiukeymd();
        }

        uiBean.setZenkaisyorikekkakbn(khMkhgkHenkouWk.getZenkaisyorikekkakbn());
        uiBean.setSyoruiukeymd(syoruiUkeYmd);
        uiBean.setTargettkmkhtkbn(khMkhgkHenkouWk.getTargettkmkhtkbn());
        uiBean.setHonninkakninkekkakbn(khMkhgkHenkouWk.getHonninkakninkekkakbn());
        uiBean.setHassoukbn(khMkhgkHenkouWk.getHassoukbn());

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC0001,
                uiBean.getZenkaisyorikekkakbn().getContent());
        }
    }

    void pushNyuryokuBL () {
        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        chkKykExist();

        chkTargettkhkUmu();

        chkTeikishrtkykhukaUmu();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        chkYuukouJyoutaiAndHanteiTetuduki(khozenCommonParam);

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);
        hanteiSyoriKengen.exec();

        setKinouUiBean(khozenCommonParam);

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHMKHGKHENKOU);
        uiBean.setSyoruiukeymd(BizDate.getSysDate());
    }

    void pushSyoukaiBL() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcess();
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        SetHituyouSyorui.exec(
            khozenCommonParam,
            uiBean);

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) ||
            !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            if (uiBean.getSyoruiukeymd() == null) {
                throw new BizLogicException(
                    MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_MKHGKHENKOUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), uiBean.getVhsyusyukykymd()) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(
                    MessageId.EIA0070,
                    MessageUtil.getMessage(DDID_MKHGKHENKOUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(
                    MessageId.EIA0037,
                    MessageUtil.getMessage(DDID_MKHGKHENKOUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            List<IT_KykSyouhn> kykSyouhnList =
                uiBean.getKykKihon().getKykSyouhnsByKouryokuhasseiymdGt(uiBean.getSyoruiukeymd());

            if (kykSyouhnList.size() > 0) {

                throw new BizLogicException(MessageId.EIA0106);
            }

            int syohinHanteiKbn = SyouhinUtil.hantei(khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0).getSyouhncd());

            if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn) {
                BizDate jyuugoNengoYmd = uiBean.getVhsyusyukykymd().addYears(15);

                BizDate daisanHokenKikanKaishi = null;

                if (!jyuugoNengoYmd.isRekijyou()) {
                    daisanHokenKikanKaishi = jyuugoNengoYmd.getRekijyou().addDays(1);
                }
                else {
                    daisanHokenKikanKaishi = jyuugoNengoYmd;
                }

                if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), daisanHokenKikanKaishi) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), daisanHokenKikanKaishi) == BizDateUtil.COMPARE_EQUAL) {
                    throw new BizLogicException(MessageId.EBA0031, "第３保険期間中の");
                }
            }

            if (C_TargetTkMokuhyoutiKbn.BLNK.eq(uiBean.getTargettkmkhtkbn())) {
                throw new BizLogicException(
                    MessageId.EBF1005,
                    MessageUtil.getMessage(DDID_MKHGKINFO_TARGETTKMKHTKBN.getErrorResourceKey()));
            }

            if (C_TargetTkMokuhyoutiKbn.NOTARGET.eq(uiBean.getTargettkmkhtkbn())) {
                uiBean.setNewTargettkmkht(0);
            }
            else {
                uiBean.setNewTargettkmkht(Integer.parseInt(uiBean.getTargettkmkhtkbn().getValue()));
            }

            if (uiBean.getOldTargettkmkht().equals(uiBean.getNewTargettkmkht())) {
                throw new BizLogicException(
                    MessageId.EIA0044,
                    MessageUtil.getMessage(DDID_MKHGKINFO_TARGETTKMKHTKBN.getErrorResourceKey()));
            }

            List<IT_KykSyouhn> kykSyouhnListSyu = khozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU);

            String syouhnCd = kykSyouhnListSyu.get(0).getSyouhncd();

            Integer syouhnSdno = kykSyouhnListSyu.get(0).getSyouhnsdno();

            IT_KykDairiten kykDairiten = uiBean.getKykKihon().getKykDairitenByDrtenrenno(1);

            ConvertChannelcd convertChannelCd = SWAKInjector.getInstance(ConvertChannelcd.class);

            C_Channelcd kiteiChkChannelCd = convertChannelCd.exec(null, kykDairiten.getOyadrtencd());

            List<BM_ChkTargetTkMokuhyouti> chkTargetTkMokuhyoutiList = bizDomManager.
                getChkTargetTkMokuhyoutisByPk(syouhnCd, syouhnSdno, kiteiChkChannelCd, Integer.valueOf(uiBean.getTargettkmkhtkbn().getValue()));

            if (chkTargetTkMokuhyoutiList.size() == 0) {
                throw new BizLogicException(MessageId.EIF1085);
            }
        }

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);
    }

    void pushsSeikyuusyoSakusei() {
        chkJimuttdkSyorityuu(MessageId.EIA0120);

        messageManager.addMessageId(MessageId.QIA0004);
    }

    String pushSyoukainomiBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            unlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    void pushSainyuryokuBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcess();
        }
    }

    void pushKakuninBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcess();
        }

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) ||
            ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {

                throw new BizLogicException(
                    MessageId.EBC0043,
                    MessageUtil.getMessage(
                        DDID_HONNINKAKUNIN_HONNINKAKNINKEKKAKBN.getErrorResourceKey()));
            }

            if (C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn()) &&
                C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

                throw new BizLogicException(MessageId.EIA1007);
            }
        }

        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
        checkProcessKekka.exec(
            uiBean.getSyorikekkakbn(),
            uiBean.getSyanaicommentkh(),
            uiBean.getSasimodosisakikbn());

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            chkJimuttdkSyorityuu(MessageId.EIA1002);
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushModoruBtnByConfirmBL () {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }
    }

    @Transactional
    void pushKakuteiBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcess();
        }

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            chkJimuttdkSyorityuu(MessageId.EIA1002);

            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

            C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

            if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                throw new BizLogicException(
                    MessageId.EIA0035,
                    checkYuukouJyoutai.getErrorMessage());

            }

            BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);

            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
            bzProcessCreateInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);
            if (C_KouteiSakuseiKekkaKbn.FAILURE.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0008));
            }

            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzProcessCreateOutBean.getKouteiKanriId());

            BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
            bzCommonLockProcess.lockProcess(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            uiBean.setKouteiLockKey(bzCommonLockProcess.getKouteiLockKey());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);

            bzForceTaskStart.exec(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                C_KhkinouModeIdKbn.INPUT.getValue(),
                uiBean.getKouteiLockKey());
        }
        else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
                if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

                    MkhgkhenkouDBUpdate mkhgkhenkouDBUpdate = SWAKInjector.getInstance(MkhgkhenkouDBUpdate.class);
                    MkhgkhenkouDBUpdateBean mkhgkhenkouDBUpdateBean = SWAKInjector.getInstance(MkhgkhenkouDBUpdateBean.class);

                    mkhgkhenkouDBUpdateBean.setKykKihon(uiBean.getKykKihon());
                    mkhgkhenkouDBUpdateBean.setTargetTkKykhenkoymd(uiBean.getSyoruiukeymd());
                    mkhgkhenkouDBUpdateBean.setTargettkMkhtkbn(uiBean.getTargettkmkhtkbn());
                    mkhgkhenkouDBUpdateBean.setKhCommonParam(khozenCommonParam);
                    mkhgkhenkouDBUpdateBean.setHonninKakninKekkaKbn(uiBean.getHonninkakninkekkakbn());
                    mkhgkhenkouDBUpdateBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                    mkhgkhenkouDBUpdateBean.setHassouKbn(uiBean.getHassoukbn());
                    mkhgkhenkouDBUpdateBean.setSyoriYmd(sysDate);

                    mkhgkhenkouDBUpdate.exec(mkhgkhenkouDBUpdateBean);

                    hozenDomManager.update(mkhgkhenkouDBUpdate.getKykKihon());
                }

                doDelKhMkhgkHenkouWk();

                if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

                    uiBean.getKykKihon().detach();
                }
            }
            else{
                doUpdKhMkhgkHenkouWk(sysTime);

                uiBean.getKykKihon().detach();
            }
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                doInsKhMkhgkHenkouWk(
                    sysDate,
                    sysTime,
                    uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    E_TableRegKbn.CONFIRM);
            }
            else {
                doUpdKhMkhgkHenkouWk(sysTime);
            }

            doJikouteikanri();

            uiBean.getKykKihon().detach();

        }
        else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            doJikouteikanri();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void printOut() {
        String tyhykey = uiBean.getTyouhyoukey();
        outputReport.outputPDFByJoinKey(tyhykey);
    }

    void printHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    @Transactional
    void pushKakuteiBySksconfirmBL() {
        chkJimuttdkSyorityuu(MessageId.EIA0120);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();


        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);


        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());
        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
        hozenPreReportRenkeiBean.setSyoriComment("");
        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);
        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        editSeikyuusyoParam.setBfrTargettkmokuhyouti(BizNumber.valueOf(uiBean.getNewTargettkmkht()));

        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);
        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);

        C_SyoruiCdKbn[] syoruiCds = {
            C_SyoruiCdKbn.KK_MKHGKHNK_SOUHU,
            C_SyoruiCdKbn.KK_MKHGKHNK_SKS };

        khozenTyouhyouCtl.createTyouhyouTBL(
            khozenCommonParam,
            uiBean.getSyono(),
            syoruiCds,
            C_YouhiKbn.YOU);

        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());

        doInsKhMkhgkHenkouWk(
            sysDate,
            sysTime,
            hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId(),
            E_TableRegKbn.SKSSAKUSEICONFIRM);

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);

    }

    String functionNameOnClickBL() {

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            unlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    String pushModoruInputContentsBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            unlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    void pushTojiruBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            unlockProcessBL();
        }
    }

    String pushSyokigamenkkBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    void unlockProcessBL() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }


    private void chkKykExist() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());
        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        uiBean.setKykKihon(kykKihon);
    }

    private void chkTargettkhkUmu() {

        IT_KykKihon kykKihon = uiBean.getKykKihon();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        if (C_UmuKbn.NONE.eq(kykSonotaTkyk.getTargettkhkumu())) {
            throw new BizLogicException(MessageId.EIF1013, DISP_TARGETTK);
        }

        Integer oldTargettkmkht = kykSonotaTkyk.getTargettkmokuhyouti();
        String dispBfrTargettkmkht = "";

        if (oldTargettkmkht != 0) {
            dispBfrTargettkmkht = ConvertUtil.toZenNumeric(oldTargettkmkht.toString()) + DISP_PERCENT;
        }
        else {
            dispBfrTargettkmkht = C_TargetTkMokuhyoutiKbn.NOTARGET.getContent();
        }

        uiBean.setDispbfrtargettkmokuhyouti(dispBfrTargettkmkht);
        uiBean.setOldTargettkmkht(oldTargettkmkht);
    }

    private void chkTeikishrtkykhukaUmu() {

        IT_KykKihon kykKihon = uiBean.getKykKihon();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTeikishrtkykhukaumu())) {
            throw new BizLogicException(MessageId.EIA1071, IKhozenCommonConstants.TOKUYAKUNM_SITEITUUKANENKIN_TEIKISHR);
        }
    }

    private void chkYuukouJyoutaiAndHanteiTetuduki(KhozenCommonParam pKhozenCommonParam) {


        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        C_YuukoujyotaichkKbn yuukoujyotaichkKbn;

        yuukoujyotaichkKbn = checkYuukouJyoutai.exec(
            pKhozenCommonParam,
            uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }


        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(
            pKhozenCommonParam,
            uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }


        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            String message = "";
            String messageId = "";
            ArrayList<String> warningMessageIdList = checkYuukouJyoutai.getWarningMessageIDList();
            ArrayList<String> warningMessageList = checkYuukouJyoutai.getWarningMessageList();

            for (int i = 0; i < warningMessageIdList.size(); i++) {
                messageId = BizUtil.getGeneralMessageId(warningMessageIdList.get(i));
                message = warningMessageList.get(i);

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    messageId,
                    message);
            }
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }
    }

    private void chkDSKhMkhgkHenkouuktk() {

        IW_KhMkhgkHenkouWk khMkhgkHenkouWk = hozenDomManager.getKhMkhgkHenkouWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (khMkhgkHenkouWk != null) {

            Long kensuu = khMkhgkHenkouDao.getHenkouUktkDwMkhgkHenkouUketukeCountBySyonoKijyunymd(
                uiBean.getSyono(), khMkhgkHenkouWk.getSkssakuseiymd());

            if (kensuu > 0) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING1,
                    MessageId.WIF3012);
            }
        }
    }

    private void setKinouUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);
        SetKihon.exec(pKhozenCommonParam, uiBean);
        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(pKhozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList() != null && uiBean.getWarningMessageIdList().size() > 0) {
            String message = "";
            String messageId = "";

            for (int n = 0; n < uiBean.getWarningMessageIdList().size(); n++) {
                messageId = BizUtil.getGeneralMessageId(uiBean.getWarningMessageIdList().get(n));
                message = uiBean.getWarningMessageList().get(n);

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, messageId, message);

            }
        }

        SetTetudukityuui.exec(pKhozenCommonParam, uiBean);
        SetKeiyakusya.exec(pKhozenCommonParam, uiBean);
        SetTuusinsaki.exec(pKhozenCommonParam, uiBean);
        SetHihokensya.exec(pKhozenCommonParam, uiBean);

        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyou.exec(pKhozenCommonParam, uiBean);

        SetSonotaTk.exec(pKhozenCommonParam, uiBean);
        SetTrkKazoku.exec(pKhozenCommonParam, uiBean);
        SetKyksyadairi.exec(pKhozenCommonParam, uiBean);
    }

    private void chkJimuttdkSyorityuu(String pMessageId) {
        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
        C_UmuKbn kouteiUmu = checkProcessKaishi.exec(
            uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmu)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();
            throw new BizLogicException(pMessageId,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }
    }

    private void doInsKhMkhgkHenkouWk(
        BizDate pSysDate, String pSysTime, String pKouteikanriId, E_TableRegKbn pTableRegKbn) {

        IW_KhMkhgkHenkouWk khMkhgkHenkouWk = new IW_KhMkhgkHenkouWk();

        khMkhgkHenkouWk.setKouteikanriid(pKouteikanriId);
        khMkhgkHenkouWk.setSyono(uiBean.getSyono());
        khMkhgkHenkouWk.setSkssakuseiymd(pSysDate);
        khMkhgkHenkouWk.setTargettkmkhtkbn(uiBean.getTargettkmkhtkbn());

        if (pTableRegKbn.equals(E_TableRegKbn.CONFIRM)) {
            khMkhgkHenkouWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())){
                khMkhgkHenkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                khMkhgkHenkouWk.setHassoukbn(uiBean.getHassoukbn());
                khMkhgkHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }else{
                khMkhgkHenkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                khMkhgkHenkouWk.setHassoukbn(uiBean.getHassoukbn());
            }
        }

        khMkhgkHenkouWk.setGyoumuKousinKinou(kinou.getKinouId());
        khMkhgkHenkouWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        khMkhgkHenkouWk.setGyoumuKousinTime(pSysTime);
        BizPropertyInitializer.initialize(khMkhgkHenkouWk);

        hozenDomManager.insert(khMkhgkHenkouWk);
    }

    private void doUpdKhMkhgkHenkouWk(String pSysTime) {

        IW_KhMkhgkHenkouWk khMkhgkHenkouWk =
            hozenDomManager.getKhMkhgkHenkouWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())){
            if(C_SyorikekkaKbn.HUSYOUNIN.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())){
                khMkhgkHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
        }else{
            if(C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())){

                khMkhgkHenkouWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
                khMkhgkHenkouWk.setTargettkmkhtkbn(uiBean.getTargettkmkhtkbn());
                khMkhgkHenkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                khMkhgkHenkouWk.setHassoukbn(uiBean.getHassoukbn());
                khMkhgkHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
            else if(C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn())){
                khMkhgkHenkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
            else{
                khMkhgkHenkouWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
                khMkhgkHenkouWk.setTargettkmkhtkbn(uiBean.getTargettkmkhtkbn());
                khMkhgkHenkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                khMkhgkHenkouWk.setHassoukbn(uiBean.getHassoukbn());
            }
        }

        khMkhgkHenkouWk.setGyoumuKousinKinou(kinou.getKinouId());
        khMkhgkHenkouWk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        khMkhgkHenkouWk.setGyoumuKousinTime(pSysTime);

        hozenDomManager.update(khMkhgkHenkouWk);
    }

    private void doDelKhMkhgkHenkouWk() {
        IW_KhMkhgkHenkouWk khMkhgkHenkouWk =
            hozenDomManager.getKhMkhgkHenkouWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        hozenDomManager.delete(khMkhgkHenkouWk);
    }

    private void doJikouteikanri() {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khProcessForward.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getKouteiLockKey(),
            uiBean.getSyanaicommentkh(),
            khRuleBean);

        unlockProcessBL();
    }

    private void continueLockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }

}
