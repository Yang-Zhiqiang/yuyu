package yuyu.app.hozen.khozen.khkaigomaebaraitkhenkou;

import static yuyu.app.hozen.khozen.khkaigomaebaraitkhenkou.GenKhKaigomaebaraiTkHenkouConstants.*;
import static yuyu.app.hozen.khozen.khkaigomaebaraitkhenkou.KhKaigomaebaraiTkHenkouConstants.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khkaigomaebaraitkhenkou.KhKaigomaebaraiTkHenkouConstants.E_TableRegKbn;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceTaskStart;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditHokenSyoukenParam;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiSyoriKengen;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
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
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_KhTokusyuKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;

import com.lowagie.text.pdf.PdfReader;

/**
 * 重度介護前払特約変更 のビジネスロジックです。
 */
public class KhKaigomaebaraiTkHenkouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKaigomaebaraiTkHenkouUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private OutputReport outputReport;

    @Inject
    private DBAOutputReport dbaOutputReport;

    @Inject
    private KinouMode kinouMode;

    void init() {
        clear();
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);


        String kouteikanriid = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        String jimutetuzukicd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(kouteikanriid, jimutetuzukicd);

        uiBean.setKouteiLockKey(bzCommonLockProcess.getKouteiLockKey());


        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            kouteikanriid,
            jimutetuzukicd,
            uiBean.getBzWorkflowInfo().getTaskId(),
            uiBean.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteikanriid);

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        IW_KhJyudKigmaebriTkykHnkWk khJyudKigmaebriTkykHnkWk = hozenDomManager.getKhJyudKigmaebriTkykHnkWk(kouteikanriid);

        if (khJyudKigmaebriTkykHnkWk != null) {
            uiBean.setZenkaisyorikekkakbn(khJyudKigmaebriTkykHnkWk.getZenkaisyorikekkakbn());
        }

        doKaishi();


        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC0001,
                uiBean.getZenkaisyorikekkakbn().getContent());
        }

        setUiBean();

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);

        if (khJyudKigmaebriTkykHnkWk != null) {
            uiBean.setJyudkaigomaebaraitkykhnkkbn(khJyudKigmaebriTkykHnkWk.getJyudkaigomaebaraitkykhnkkbn());
            uiBean.setHonninkakninkekkakbn(khJyudKigmaebriTkykHnkWk.getHonninkakninkekkakbn());
            uiBean.setHassoukbn(khJyudKigmaebriTkykHnkWk.getHassoukbn());
        }

    }

    void pushNyuryokuBL () {
        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        doKaishi();

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);
        hanteiSyoriKengen.exec();

        setUiBean();

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIGOMAEBARAITKHENKOU);
    }


    void unlockProcessBL() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }

    void pushSyoukaiBL() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcess();
        }

        SetHituyouSyorui.exec(
            khozenCommonParam,
            uiBean);

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ||
            (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()))) {


            if (C_JyudkaigomaebaraiTkykhnkKbn.BLNK.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {
                throw new BizLogicException(MessageId.EBF1005, DISP_TKHNKKBN);
            }


            IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

            if (kykSonotaTkyk != null) {
                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu()) &&
                    C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {
                    throw new BizLogicException(MessageId.EIF1006, DDISP_JYDKGMHRTKRHYJ);
                }
                else if (C_UmuKbn.NONE.eq(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu()) &&
                    C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {
                    throw new BizLogicException(MessageId.EIA0163, DDISP_JYDKGMHRTKRHYJ);
                }
            }

            boolean warningUmuFlag = false;
            List<String> warningMessageIdList = new ArrayList<String>();
            List<String> warningMessageList = new ArrayList<String>();

            if(C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())){

                uiBean.setTakikeiyakujyudkaigomaebaraitkykhukaumu(C_UmuKbn.NONE);

                BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);
                BizDate sysDate = BizDate.getSysDate();


                bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);
                bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
                bzSakuinTsnSyoukaiYokenBean.setHuho2kykno(uiBean.getSyono());
                bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.HHKN);
                bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.YOU);
                bzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.TAISYOU_HHKN);
                bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
                bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno(uiBean.getSyono());
                bzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(sysDate);
                bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.YOU);
                bzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
                bzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kykno(uiBean.getSyono());
                bzSakuinTsnSyoukaiYokenBean.setTsnkijyunymd(sysDate);
                bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnkijyunymd(null);
                bzSakuinTsnSyoukaiYokenBean.setDairitencd1("");
                bzSakuinTsnSyoukaiYokenBean.setDairitencd2("");
                bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);

                BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
                BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

                if (C_MQSyorikekkaKbn.ERROR.eq(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())) {
                    warningUmuFlag = true;
                    warningMessageIdList.add("WIF1014");
                    warningMessageList.add(MessageUtil.getMessage("WIF1014"));
                }
                else if (C_MQSyorikekkaKbn.SEIJYOU.eq(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())) {
                    if (C_PalSyoukaiJissiumuKbn.NONE.eq(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn())) {
                        warningUmuFlag = true;
                        warningMessageIdList.add("WIF1015");
                        warningMessageList.add(MessageUtil.getMessage("WIF1015"));
                    }
                    else if (C_PalSyoukaiJissiumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn())) {
                        if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(bzSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn())) {
                            warningUmuFlag = true;
                            warningMessageIdList.add("WIF1016");
                            warningMessageList.add(MessageUtil.getMessage("WIF1016"));
                        }
                        else if (C_MQSyoukaiErrorKbn.SYOUKAIOK.eq(bzSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn())) {
                            if (C_UmuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getTsnkaigomehrtkumukbn())) {
                                warningUmuFlag = true;
                                warningMessageIdList.add("WIF1017");
                                warningMessageList.add(MessageUtil.getMessage("WIF1017"));
                                uiBean.setTakikeiyakujyudkaigomaebaraitkykhukaumu(C_UmuKbn.ARI);
                            }
                        }
                    }
                }
            }

            Long khHenreikinYendtMbrCount = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(uiBean.getSyono());
            if (khHenreikinYendtMbrCount > 0) {
                warningUmuFlag = true;
                warningMessageIdList.add(MessageId.WIA1017);
                warningMessageList.add(MessageUtil.getMessage(MessageId.WIA1017));
            }

            if (warningUmuFlag) {
                int messageSize = warningMessageIdList.size();
                for (int count = 0; count < messageSize; count++) {
                    messageManager.addConversationMessageId(
                        KhMessageGroupConstants.GROUP_WARNING2,
                        warningMessageIdList.get(count),
                        warningMessageList.get(count));
                }
            }
        }

    }

    void pushKakuninBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcess();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            checkProcKaishi(MessageId.EIA1002);
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
                if (!C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {
                    checkSyoukaiKakunin();
                }
            }
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn())) {
                checkSyoukaiKakunin();
            }
        }

        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
        checkProcessKekka.exec(
            uiBean.getSyorikekkakbn(),
            uiBean.getSyanaicommentkh(),
            uiBean.getSasimodosisakikbn());

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushsSeikyuusyoSakusei() {
        checkProcKaishi(MessageId.EIA0120);

        if (C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {
            if (C_KhTokusyuKbn.BLNK.eq(uiBean.getKhtokusyukbn())){
                if (C_UmuKbn.ARI.eq(uiBean.getTakikeiyakujyudkaigomaebaraitkykhukaumu())){
                    throw new BizLogicException(MessageId.EIF1072);
                }
            }
        }

        messageManager.addMessageId(MessageId.QIA0004);
    }

    @Transactional
    void pushKakuteiBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcess();
        }

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();


        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            checkProcKaishi(MessageId.EIA1002);

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

                    String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

                    TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
                    tableMaintenanceUtil.backUp(
                        uiBean.getSyono(),
                        sikibetuKey);


                    doUpdateKTKykKihon(sysDate,sysTime);

                    IT_KykKihon kykKihon = uiBean.getKykKihon();
                    IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();

                    khTtdkRireki.setHenkousikibetukey(sikibetuKey);

                    C_UmuKbn jyudkaigomeharaitkhukaumu = C_UmuKbn.NONE;
                    BizDate jyudkaigomeharaitkhukaymd = null;

                    if (C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {
                        jyudkaigomeharaitkhukaumu = C_UmuKbn.ARI;
                        jyudkaigomeharaitkhukaymd = sysDate;
                    }

                    doUpdateKykSonotaTkyk(
                        jyudkaigomeharaitkhukaumu,
                        jyudkaigomeharaitkhukaymd,
                        sysTime);


                    PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);

                    pALKykNaiyouKousin.exec(kykKihon);


                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
                    editTtdkRirekiTblParam.setSyoriYmd(sysDate);
                    editTtdkRirekiTblParam.setSysTime(sysTime);
                    editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                    editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
                    editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
                    editTtdkRirekiTblParam.setYoukyuuNo(pALKykNaiyouKousin.getYoukyuuno());

                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);


                    EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);
                    EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
                    KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);


                    editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR);
                    editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
                    editTtdkKanryouParam.setCalckijyunYMD(sysDate);
                    editTtdkKanryouParam.setJyudkaigomaebaraitkykhnkkbn(uiBean.getJyudkaigomaebaraitkykhnkkbn());

                    if (C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {
                        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKHUKA);
                    }
                    else if (C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {
                        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.JYUDKAIGOMAEBRTKYKKAIYAKU);
                    }

                    editHokenSyoukenParam.setCalckijyunYMD(sysDate);

                    khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
                    khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);
                    khozenTyouhyouCtl.setHassoukbn(uiBean.getHassoukbn());

                    C_SyoruiCdKbn[] syoruiCds = { C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR, C_SyoruiCdKbn.KK_HKNSYKN  };

                    khozenTyouhyouCtl.createTyouhyouTBL(
                        khozenCommonParam,
                        uiBean.getSyono(),
                        syoruiCds,
                        C_YouhiKbn.HUYOU);

                    uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());

                    hozenDomManager.update(uiBean.getKykKihon());
                } else {
                    uiBean.getKykKihon().detach();
                }


                doDeleteKhJydKgmbrTkykHnkWk();
            }else{
                doUpdateKhJydKgmbrTkykHnkWk(sysTime);

                uiBean.getKykKihon().detach();

            }
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                doInsertKhJydKgmbrTkykHnkWk(
                    sysDate,
                    sysTime,
                    uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    E_TableRegKbn.CONFIRM);
            }
            else {
                doUpdateKhJydKgmbrTkykHnkWk(
                    sysTime);
            }

            doJikouteikanri(uiBean.getSyono());

            uiBean.getKykKihon().detach();

        }
        else if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            doJikouteikanri(uiBean.getSyono());
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void printOut() {
        String tyhykey = uiBean.getTyouhyoukey();

        try {
            if(C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())){
                outputReport.outputPDFByJoinKey(tyhykey);
            }else{
                byte[] skysyPDF = dbaOutputReport.getPdfImagesByJoinKeys(new String[]{tyhykey});

                String fpath = SWAK.getApplicationRootPath() +
                    YuyuHozenConfig.getInstance().getJyudKaigomaebaraiTkYakkanFilePath();

                PdfBuilder pdfBuilder = new PdfBuilder();

                PdfReader pdfReader2 = new PdfReader(fpath);

                pdfBuilder.append(new PdfReader(skysyPDF));
                pdfBuilder.append(pdfReader2);

                outputReport.outputJoinedPDFByBinary(pdfBuilder.toByteArray(), tyhykey);
            }
        }
        catch (IOException e) {
            throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
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

    @Transactional
    void pushKakuteiBySksconfirmBL() {
        checkProcKaishi(MessageId.EIA0120);

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

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


        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);
        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        editSeikyuusyoParam.setJyudkaigomaebaraiTkykhnkKbn(uiBean.getJyudkaigomaebaraitkykhnkkbn());

        editSouhuannaiParam.setJyudkaigomaebrtkykhnkkbn(uiBean.getJyudkaigomaebaraitkykhnkkbn());

        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        if (C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {

            C_SyoruiCdKbn[] syoruiCds = { C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU,
                C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS,
                C_SyoruiCdKbn.KK_KAIGOMAETK_KYKGAIYOU,
                C_SyoruiCdKbn.KK_KAIGOMAETK_TYUUIKANKI };

            khozenTyouhyouCtl.createTyouhyouTBL(
                khozenCommonParam,
                uiBean.getSyono(),
                syoruiCds,
                C_YouhiKbn.YOU);
        }
        else if (C_JyudkaigomaebaraiTkykhnkKbn.KAIYAKU.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {

            C_SyoruiCdKbn[] syoruiCds = { C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SOUHU,
                C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS, };

            khozenTyouhyouCtl.createTyouhyouTBL(
                khozenCommonParam,
                uiBean.getSyono(),
                syoruiCds,
                C_YouhiKbn.YOU);
        }

        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());


        doInsertKhJydKgmbrTkykHnkWk(
            sysDate,
            sysTime,
            hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId(),
            E_TableRegKbn.SKSSAKUSEICONFIRM);

        unlockProcessBL();

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);

    }


    String functionNameOnClickBL() {
        BizPropertyInitializer.initialize(uiBean);

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            unlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    String pushSyoukainomiBL() {

        BizPropertyInitializer.initialize(uiBean);

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            unlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    void pushSainyuryokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcess();
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);

    }

    String pushModoruInputContentsBL() {

        BizPropertyInitializer.initialize(uiBean);

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

        BizPropertyInitializer.initialize(uiBean);

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }



    private void doKaishi() {
        checkKykSonzai();

        List<IT_KykSyouhn> kykSyouhnList = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList.size() != 0) {
            IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

            BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

            if ((null != syouhnZokusei) && (!C_UmuKbn.ARI.eq(syouhnZokusei.getJyudkaigomehrtktekiumu()))) {
                throw new BizLogicException(MessageId.EIF1058);
            }
        }

        checkYuukouJyoutai();

        checkHanteiTetuduki();

    }

    private void checkKykSonzai() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());
        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        uiBean.setKykKihon(kykKihon);
    }

    private void checkYuukouJyoutai() {

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = null;

        yuukoujyotaichkKbn = checkYuukouJyoutai.exec(
            khozenCommonParam,
            uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
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
                    messageId, message);
            }
        }
    }

    private void checkHanteiTetuduki() {
        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(
            khozenCommonParam,
            uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }

    }

    private void continueLockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }


    private void checkSyoukaiKakunin() {
        if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {
            throw new BizLogicException(MessageId.EBC0043,DISP_HNNKKNNKKBN);
        }

        if ((C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn())) &&
            (C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn()))) {
            throw new BizLogicException(MessageId.EIA1007);
        }

        if (C_JyudkaigomaebaraiTkykhnkKbn.TKYKHUKA.eq(uiBean.getJyudkaigomaebaraitkykhnkkbn())) {
            if (uiBean.getTakikeiyakujyudkaigomaebaraitkykhukaumu().eq(C_UmuKbn.ARI)) {
                throw new BizLogicException(MessageId.EIF1059);
            }
        }
    }

    private void setUiBean() {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);
        SetKihon.exec(khozenCommonParam, uiBean);
        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(khozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList() != null && uiBean.getWarningMessageIdList().size() > 0) {
            String message = "";
            String messageId = "";

            for (int n = 0; n < uiBean.getWarningMessageIdList().size(); n++) {
                messageId = BizUtil.getGeneralMessageId(uiBean.getWarningMessageIdList().get(n));
                message = uiBean.getWarningMessageList().get(n);

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, messageId, message);

            }
        }

        SetTetudukityuui.exec(khozenCommonParam, uiBean);
        SetKeiyakusya.exec(khozenCommonParam, uiBean);
        SetTuusinsaki.exec(khozenCommonParam, uiBean);
        SetHihokensya.exec(khozenCommonParam, uiBean);

        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyou.exec(khozenCommonParam, uiBean);

        SetSonotaTk.exec(khozenCommonParam, uiBean);
        SetTrkKazoku.exec(khozenCommonParam, uiBean);
        SetKyksyadairi.exec(khozenCommonParam, uiBean);

        SetHituyouSyorui.exec(khozenCommonParam, uiBean);

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);

    }

    private void doUpdateKTKykKihon(BizDate pSysDate, String pSysTime) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();
        kykKihon.setSyhenkouymd(pSysDate);
        kykKihon.setLastsyosaihkymd(pSysDate);
        kykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        kykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        kykKihon.setGyoumuKousinTime(pSysTime);
    }

    private void doUpdateKykSonotaTkyk(C_UmuKbn pJyudkaigoMhrtkhkumu, BizDate pJyudkaigoMhrtkhkymd, String pSysTime) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();


        kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(pJyudkaigoMhrtkhkumu);
        kykSonotaTkyk.setJyudkaigomeharaitkhukaymd(pJyudkaigoMhrtkhkymd);

        kykSonotaTkyk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        kykSonotaTkyk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        kykSonotaTkyk.setGyoumuKousinTime(pSysTime);
    }

    private void doInsertKhJydKgmbrTkykHnkWk(BizDate pSysDate, String pSysDateTimeMilli, String pKouteikanriid, E_TableRegKbn pTableRegKbn) {

        IW_KhJyudKigmaebriTkykHnkWk khJyudKigmaebriTkykHnkWk = new IW_KhJyudKigmaebriTkykHnkWk();

        khJyudKigmaebriTkykHnkWk.setKouteikanriid(pKouteikanriid);
        khJyudKigmaebriTkykHnkWk.setSyono(uiBean.getSyono());
        khJyudKigmaebriTkykHnkWk.setSkssakuseiymd(pSysDate);
        khJyudKigmaebriTkykHnkWk.setJyudkaigomaebaraitkykhnkkbn(uiBean.getJyudkaigomaebaraitkykhnkkbn());

        if (pTableRegKbn.equals(E_TableRegKbn.CONFIRM)) {
            if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())){
                khJyudKigmaebriTkykHnkWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                khJyudKigmaebriTkykHnkWk.setHassoukbn(uiBean.getHassoukbn());
                khJyudKigmaebriTkykHnkWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }else{
                khJyudKigmaebriTkykHnkWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                khJyudKigmaebriTkykHnkWk.setHassoukbn(uiBean.getHassoukbn());
            }
        }

        khJyudKigmaebriTkykHnkWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        khJyudKigmaebriTkykHnkWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khJyudKigmaebriTkykHnkWk.setGyoumuKousinTime(pSysDateTimeMilli);
        BizPropertyInitializer.initialize(khJyudKigmaebriTkykHnkWk);

        hozenDomManager.insert(khJyudKigmaebriTkykHnkWk);
    }

    private void doUpdateKhJydKgmbrTkykHnkWk(String pSysDateTimeMilli) {

        IW_KhJyudKigmaebriTkykHnkWk khJyudKigmaebriTkykHnkWk =
            hozenDomManager.getKhJyudKigmaebriTkykHnkWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if(C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())){
            if(C_SyorikekkaKbn.HUSYOUNIN.eq(uiBean.getSyorikekkakbn()) || C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())){
                khJyudKigmaebriTkykHnkWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
        }else{
            if(C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()) || C_SyorikekkaKbn.HUBI.eq(uiBean.getSyorikekkakbn())){
                khJyudKigmaebriTkykHnkWk.setJyudkaigomaebaraitkykhnkkbn(uiBean.getJyudkaigomaebaraitkykhnkkbn());
                khJyudKigmaebriTkykHnkWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                khJyudKigmaebriTkykHnkWk.setHassoukbn(uiBean.getHassoukbn());
                khJyudKigmaebriTkykHnkWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
            else if(C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()) || C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn())){
                khJyudKigmaebriTkykHnkWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
            else{
                khJyudKigmaebriTkykHnkWk.setJyudkaigomaebaraitkykhnkkbn(uiBean.getJyudkaigomaebaraitkykhnkkbn());
                khJyudKigmaebriTkykHnkWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
                khJyudKigmaebriTkykHnkWk.setHassoukbn(uiBean.getHassoukbn());
            }
        }

        khJyudKigmaebriTkykHnkWk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        khJyudKigmaebriTkykHnkWk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khJyudKigmaebriTkykHnkWk.setGyoumuKousinTime(pSysDateTimeMilli);

        hozenDomManager.update(khJyudKigmaebriTkykHnkWk);
    }

    private void doDeleteKhJydKgmbrTkykHnkWk() {
        IW_KhJyudKigmaebriTkykHnkWk khJyudKigmaebriTkykHnkWk =
            hozenDomManager.getKhJyudKigmaebriTkykHnkWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        hozenDomManager.delete(khJyudKigmaebriTkykHnkWk);
    }

    private void doJikouteikanri(String pSyono) {

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

    private void checkProcKaishi(String pMessageId) {
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

}
