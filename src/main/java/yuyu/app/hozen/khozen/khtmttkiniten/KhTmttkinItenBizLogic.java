package yuyu.app.hozen.khozen.khtmttkiniten;

import static yuyu.app.hozen.khozen.khtmttkiniten.GenKhTmttkinItenConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khtmttkiniten.dba.KhTmttkinItenDao;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.SaibanBiz;
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
import yuyu.common.hozen.khcommon.CheckTmttkinIten;
import yuyu.common.hozen.khcommon.CheckTmttkinItenBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
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
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
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
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IW_KhTmttknitenWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

/**
 * 積立金移転 のビジネスロジックです。
 */
public class KhTmttkinItenBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhTmttkinItenUiBean uiBean;

    @Inject
    private KhTmttkinItenDao khTmttkinItenDao;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    void init() {
        clear();
    }

    void clear() {
    }

    String pushFunctionNameOnClickBL() {
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            unlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    void pushTojiruBtnOnClickBL() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.DEFAULT.getValue().equals(kinouMode.getKinouMode())) {
            unlockProcessBL();
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

    String pushSyoukaiNomi() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ) {
            unlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    void pushSainyuuryokubtnOnClickBL() {
        if(!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())){
            continueLockProcessBL();
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);
    }

    void pushSeikyusyoSakuseiBL() {
        checkProcessKaishi();

        BizDate syoruiUktkKigenYmd = uiBean.getTmttknitenymd().addDays(-YuyuHozenConfig.getInstance().getTmttknItenUkeKigenNissuu());
        if (!syoruiUktkKigenYmd.isBusinessDay()) {
            syoruiUktkKigenYmd = syoruiUktkKigenYmd.addBusinessDays(1);
        }
        uiBean.setSyoruiUktkKigenYmd(syoruiUktkKigenYmd);

        if(C_Tmttknitenkbn.ITEN_TORIKESI.eq(uiBean.getTmttknitenkbn()) &&
            BizDateUtil.compareYmd(BizDate.getSysDate(), uiBean.getSyoruiUktkKigenYmd()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EIF1083);
        }

        if (C_Tmttknitenkbn.ITEN.eq(uiBean.getTmttknitenkbn()) &&
            C_UmuKbn.ARI.eq(uiBean.getTgitgiKykOutoubiKbn())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4, MessageId.WIF1023);
        }

        messageManager.addMessageId(MessageId.QIA0004);
    }

    void pushNyuuryokuBL() {
        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        checkKykSonzai();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        checkHanteiTetuduki(khozenCommonParam);

        CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);
        CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);
        checkTmttkinItenBean.setKykKihon(uiBean.getKykKihon());
        checkTmttkinIten.exec(CheckTmttkinIten.KINOUBUNRUI_ONLINE,
            CheckTmttkinIten.GAMENBUNRUI_INPUTKEY,
            checkTmttkinItenBean);
        BizDate kykYmd = checkTmttkinIten.getKykymd();

        setUiBean(khozenCommonParam);

        BizDate tmttknItenYmd = null;
        C_UmuKbn tgitgiKykOutoubiKbn = C_UmuKbn.NONE;

        IT_KhHenkouUktk khHenkouUktk = khTmttkinItenDao.getHenkouUktkBySyonoUktksyorikbnUktkjyoutaikbn(uiBean.getSyono(),
            C_UktkSyoriKbn.TMTTKNITEN,
            C_UktkJyoutaiKbn.MISYORI);

        if (khHenkouUktk != null) {
            tmttknItenYmd = khHenkouUktk.getKouryokuhasseiymd();
        }
        else {
            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
            BizDate outoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
                kykYmd,
                C_Hrkkaisuu.NEN,
                BizDate.getSysDate());

            BizDate syoruiUktkKigenymd = outoubi.addDays(-YuyuHozenConfig.getInstance().getTmttknItenUkeKigenNissuu());

            if (!syoruiUktkKigenymd.isBusinessDay()) {
                syoruiUktkKigenymd = syoruiUktkKigenymd.addBusinessDays(1);
            }

            if (BizDateUtil.compareYmd(BizDate.getSysDate(), syoruiUktkKigenymd) == BizDateUtil.COMPARE_GREATER) {
                BizDate outoubi2 = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
                    kykYmd,
                    C_Hrkkaisuu.NEN,
                    outoubi);

                tmttknItenYmd = outoubi2;
                tgitgiKykOutoubiKbn = C_UmuKbn.ARI;
            }
            else {
                tmttknItenYmd = outoubi;
            }
        }

        uiBean.setTmttknitenymd(tmttknItenYmd);
        uiBean.setSyoruiukeymd(BizDate.getSysDate());
        uiBean.setTgitgiKykOutoubiKbn(tgitgiKykOutoubiKbn);

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHTMTTKINITEN);

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);
        hanteiSyoriKengen.exec();
    }

    String pushModoruNaiyouNyuryoku() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            unlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    void pushSyoukaiBL() {
        if(!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())){
            continueLockProcessBL();
        }

        if((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) ||
            !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())){

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

            if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
                if (C_Tmttknitenkbn.BLNK.eq(uiBean.getTmttknitenkbn())) {
                    throw new BizLogicException(MessageId.EBF1005,
                        MessageUtil.getMessage(DDID_KHTMTTKINITENNAIYOUINFO_TMTTKNITENKBN.getErrorResourceKey()));
                }

                if (uiBean.getSyoruiukeymd() == null) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(DDID_KHTMTTKINITENNYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
                }
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EIA0037,
                    MessageUtil.getMessage(DDID_KHTMTTKINITENNYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);
            CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);
            checkTmttkinItenBean.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            checkTmttkinItenBean.setTmttknitenkbn(uiBean.getTmttknitenkbn());
            checkTmttkinItenBean.setTmttknitenymd(uiBean.getTmttknitenymd());
            checkTmttkinItenBean.setKykKihon(uiBean.getKykKihon());
            checkTmttkinIten.exec(CheckTmttkinIten.KINOUBUNRUI_ONLINE,
                CheckTmttkinIten.GAMENBUNRUI_INPUTCONTENTS,
                checkTmttkinItenBean);

            IT_KhHenkouUktk khHenkouUktk = khTmttkinItenDao.getHenkouUktkBySyonoUktksyorikbnUktkjyoutaikbn(uiBean.getSyono(),
                C_UktkSyoriKbn.TMTTKNITEN,
                C_UktkJyoutaiKbn.MISYORI);

            if (C_Tmttknitenkbn.ITEN.eq(uiBean.getTmttknitenkbn()) &&
                khHenkouUktk != null) {
                throw new BizLogicException(MessageId.EIF1081);
            }

            if (C_Tmttknitenkbn.ITEN_TORIKESI.eq(uiBean.getTmttknitenkbn()) &&
                khHenkouUktk == null) {
                throw new BizLogicException(MessageId.EIF1082);
            }

            SetHituyouSyorui.exec(khozenCommonParam, uiBean);

            if (BizDateUtil.compareYmd(BizDate.getSysDate(),
                uiBean.getSyoruiukeymd().addDays(YuyuHozenConfig.getInstance().getSyoruiUkeKyoyou())) !=
                BizDateUtil.COMPARE_LESSER) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2,
                    MessageId.WIF1004,
                    MessageUtil.getMessage(DDID_KHTMTTKINITENNYUURYOKUINFO_SYORUIUKEYMD.getErrorResourceKey()),
                    YuyuHozenConfig.getInstance().getSyoruiUkeKyoyou() + "日");
            }

        }

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);
        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));
        setKhKbnPatternUtil.exec(uiBean);
    }

    void pushKakuninBL() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn()) ||
            ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {
            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_HONNININFO_HONNINKAKNINKEKKAKBN.getErrorResourceKey()));
            }

            if (C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn()) &&
                C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {
                throw new BizLogicException(MessageId.EIA1007);
            }

            CheckTmttkinIten checkTmttkinIten = SWAKInjector.getInstance(CheckTmttkinIten.class);
            CheckTmttkinItenBean checkTmttkinItenBean = SWAKInjector.getInstance(CheckTmttkinItenBean.class);
            checkTmttkinItenBean.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            checkTmttkinItenBean.setTmttknitenkbn(uiBean.getTmttknitenkbn());
            checkTmttkinItenBean.setTmttknitenymd(uiBean.getTmttknitenymd());
            checkTmttkinItenBean.setKykKihon(uiBean.getKykKihon());
            checkTmttkinIten.exec(CheckTmttkinIten.KINOUBUNRUI_ONLINE,
                CheckTmttkinIten.GAMENBUNRUI_REFERENCE,
                checkTmttkinItenBean);

            if (BizDateUtil.compareYmd(uiBean.getTmttknitenymd(), BizDate.getSysDate()) != BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EIA1025,
                    "処理日",
                    MessageUtil.getMessage(DDID_KHTMTTKINITENNAIYOUINFO_TMTTKNITENYMD.getErrorResourceKey()));
            }
        }

        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);
        checkProcessKekka.exec(uiBean.getSyorikekkakbn(), uiBean.getSyanaicommentkh(), uiBean.getSasimodosisakikbn());

        checkProcessKaishi2();

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushModoruByConfirmBL() {
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }
    }

    @Transactional
    void pushKukakuteiBL() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            continueLockProcessBL();
        }

        checkProcessKaishi2();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        doJikouteikanri(khozenCommonParam);

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn())) {

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
            tableMaintenanceUtil.backUp(uiBean.getSyono(), khozenCommonParam.getSikibetuKey(uiBean.getSyono()));

            doUpdateTables(khozenCommonParam, gyoumuKousinTime);

            makeTtdkRireki(khozenCommonParam, gyoumuKousinTime);

            makeTyouhyou(khozenCommonParam);

            hozenDomManager.update(uiBean.getKykKihon());
        }
        else {
            uiBean.getKykKihon().detach();
        }

        updateWorkTable(khozenCommonParam, gyoumuKousinTime);

        doJikouteikanri2();

        messageManager.addMessageId(MessageId.IAC0009);
    }

    String pushSyokiGamenheKekka() {
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }


    void pushModoruBySksConfirmBL() {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
    }

    @Transactional
    void pushKakuteiByskConfirmBL() {
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        checkProcessKaishi();

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

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

        makeTyouhyouSeiKyuSyo(khozenCommonParam, hozenPreReportRenkeiBean);

        insertWorkTableSeikyuSyo(khozenCommonParam, gyoumuKousinTime);

        uiBean.getKykKihon().detach();

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);

        messageManager.addMessageId(MessageId.IIA0017);
    }

    @Transactional
    void iwfOpenBL() {
        BizPropertyInitializer.initialize(uiBean);

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);
        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        checkKykSonzai();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        checkYuukouJyoutai(khozenCommonParam);

        checkHanteiTetuduki(khozenCommonParam);

        IW_KhTmttknitenWk khTmttknitenWk =
            hozenDomManager.getKhTmttknitenWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (khTmttknitenWk == null) {
            throw new BizAppException(MessageId.EBS0004,
                IW_KhTmttknitenWk.TABLE_NAME,
                IW_KhTmttknitenWk.KOUTEIKANRIID,
                uiBean.getBzWorkflowInfo().getKouteiKanriId());
        }

        uiBean.setTmttknitenkbn(khTmttknitenWk.getTmttknitenkbn());
        uiBean.setTmttknitenymd(khTmttknitenWk.getTmttknitenymd());
        uiBean.setSyoruiukeymd(khTmttknitenWk.getSyoruiukeymd());
        uiBean.setZenkaiSyoriKekkaKbn(khTmttknitenWk.getZenkaisyorikekkakbn());
        uiBean.setHonninkakninkekkakbn(khTmttknitenWk.getHonninkakninkekkakbn());
        uiBean.setHassoukbn(khTmttknitenWk.getHassoukbn());

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        setUiBean(khozenCommonParam);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaiSyoriKekkaKbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIC0001,
                uiBean.getZenkaiSyoriKekkaKbn().getContent());
        }

        if(uiBean.getSyoruiukeymd()==null){
            GetSyoruittykymd wkGetSyoruittykymd =SWAKInjector.getInstance(GetSyoruittykymd.class);
            uiBean.setSyoruiukeymd(wkGetSyoruittykymd.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(), C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS));
        }
    }

    void printOut() {
        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);
        outputReport.outputPDFByJoinKey(uiBean.getTyouhyouKey());
    }

    void unlockProcessBL() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.unlockProcess();
    }

    private void continueLockProcessBL() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }

    private void checkKykSonzai() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setKykKihon(kykKihon);
    }

    private void checkProcessKaishi() {
        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn umuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(umuKbn)) {
            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }
    }

    private void checkProcessKaishi2() {
        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn umuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(umuKbn)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }
        }
    }

    private void checkYuukouJyoutai(KhozenCommonParam pKhozenCommonParam) {
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, checkYuukouJyoutai
                    .getWarningMessageIDList().get(i), checkYuukouJyoutai.getWarningMessageList().get(i));
            }
        }
    }

    private void checkHanteiTetuduki(KhozenCommonParam pKhozenCommonParam) {
        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(pKhozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    private void setUiBean(KhozenCommonParam pKhozenCommonParam) {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(pKhozenCommonParam, uiBean);

        SetKihon.exec(pKhozenCommonParam, uiBean);

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

    private void doJikouteikanri(KhozenCommonParam pKhozenCommonParam) {

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
            C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(pKhozenCommonParam, uiBean);

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
            bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);

            bzForceTaskStart.exec(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                C_KhkinouModeIdKbn.INPUT.getValue(),
                bzCommonLockProcess.getKouteiLockKey());
        }
    }

    private void doUpdateTables(KhozenCommonParam pKhozenCommonParam, String pGyoumuKousinTime) {
        IT_KykKihon kykKihon = uiBean.getKykKihon();
        kykKihon.setSyhenkouymd(BizDate.getSysDate());
        kykKihon.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        kykKihon.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        kykKihon.setGyoumuKousinTime(pGyoumuKousinTime);

        if (C_Tmttknitenkbn.ITEN.eq(uiBean.getTmttknitenkbn())) {
            String hozenHenkouUktkrenNo = SaibanBiz.getHozenHenkouUktkrenNo(uiBean.getSyono());
            IT_KhHenkouUktk khHenkouUktk = new IT_KhHenkouUktk(uiBean.getSyono(), Integer.valueOf(hozenHenkouUktkrenNo));
            khHenkouUktk.setUktkymd(BizDate.getSysDate());
            khHenkouUktk.setTourokuroute(C_TourokuRouteKbn.ONLINE);
            khHenkouUktk.setUktksyorikbn(C_UktkSyoriKbn.TMTTKNITEN);
            khHenkouUktk.setKouryokuhasseiymd(uiBean.getTmttknitenymd());
            khHenkouUktk.setSyoriyoteiymd(uiBean.getTmttknitenymd().addBusinessDays(-1));
            khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);
            khHenkouUktk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            khHenkouUktk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            khHenkouUktk.setGyoumuKousinTime(pGyoumuKousinTime);

            BizPropertyInitializer.initialize(khHenkouUktk);
            hozenDomManager.insert(khHenkouUktk);
        }
        else {
            IT_KhHenkouUktk khHenkouUktk = khTmttkinItenDao.getHenkouUktkBySyonoUktksyorikbnUktkjyoutaikbn(uiBean.getSyono(),
                C_UktkSyoriKbn.TMTTKNITEN,
                C_UktkJyoutaiKbn.MISYORI);

            khHenkouUktk.setUktkymd(BizDate.getSysDate());
            khHenkouUktk.setTourokuroute(C_TourokuRouteKbn.ONLINE);
            khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.TORIKESI);
            khHenkouUktk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            khHenkouUktk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            khHenkouUktk.setGyoumuKousinTime(pGyoumuKousinTime);

            hozenDomManager.update(khHenkouUktk);
        }
    }

    private void makeTtdkRireki(KhozenCommonParam pKhozenCommonParam, String pGyoumuKousinTime) {
        IT_KhTtdkRireki khTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();
        khTtdkRireki.setHenkousikibetukey(pKhozenCommonParam.getSikibetuKey(uiBean.getSyono()));

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(BizDate.getSysDate());
        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.NONE);
        if (C_Tmttknitenkbn.ITEN.eq(uiBean.getTmttknitenkbn())) {
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.ITEN);
        }else{
            editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.ITENTORIKESI);
        }
        editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
        editTtdkRirekiTblParam.setSysTime(pGyoumuKousinTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);
        editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void makeTyouhyou(KhozenCommonParam pKhozenCommonParam) {
        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);

        if (C_Tmttknitenkbn.ITEN.eq(uiBean.getTmttknitenkbn())) {
            editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TMTTKNITEN);
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR);
            editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
            editTtdkKanryouParam.setTmttknitenkbn(uiBean.getTmttknitenkbn());
            editTtdkKanryouParam.setTmttknitenYmd(uiBean.getTmttknitenymd());
        }
        else if (C_Tmttknitenkbn.ITEN_TORIKESI.eq(uiBean.getTmttknitenkbn())) {
            editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TMTTKNITENTORIKESI);
            editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR);
            editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
            editTtdkKanryouParam.setTmttknitenkbn(uiBean.getTmttknitenkbn());
        }

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
        khozenTyouhyouCtl.setHassoukbn(uiBean.getHassoukbn());

        C_SyoruiCdKbn[] syoruiCds = { C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR };
        khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam,
            uiBean.getSyono(),
            syoruiCds,
            C_YouhiKbn.HUYOU);

        uiBean.setTyouhyouKey(khozenTyouhyouCtl.getTyouhyouKey());
    }

    private void updateWorkTable(KhozenCommonParam pKhozenCommonParam, String pGyoumuKousinTime) {
        IW_KhTmttknitenWk khTmttknitenWk =
            hozenDomManager.getKhTmttknitenWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {
                hozenDomManager.delete(khTmttknitenWk);
            }
            else {
                if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
                    khTmttknitenWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
                }
                khTmttknitenWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
                khTmttknitenWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
                khTmttknitenWk.setGyoumuKousinTime(pGyoumuKousinTime);

                hozenDomManager.update(khTmttknitenWk);
            }
        }
        else if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {
            khTmttknitenWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            khTmttknitenWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            khTmttknitenWk.setHassoukbn(uiBean.getHassoukbn());
            if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {
                khTmttknitenWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
            khTmttknitenWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            khTmttknitenWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            khTmttknitenWk.setGyoumuKousinTime(pGyoumuKousinTime);

            hozenDomManager.update(khTmttknitenWk);
        }
        else if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
            khTmttknitenWk = new IW_KhTmttknitenWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

            khTmttknitenWk.setSyono(uiBean.getSyono());
            khTmttknitenWk.setSkssakuseiymd(BizDate.getSysDate());
            khTmttknitenWk.setTmttknitenkbn(uiBean.getTmttknitenkbn());
            khTmttknitenWk.setUktkkigenymd(uiBean.getSyoruiUktkKigenYmd());
            khTmttknitenWk.setTmttknitenymd(uiBean.getTmttknitenymd());
            khTmttknitenWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());
            khTmttknitenWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            khTmttknitenWk.setHassoukbn(uiBean.getHassoukbn());
            khTmttknitenWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            khTmttknitenWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            khTmttknitenWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            khTmttknitenWk.setGyoumuKousinTime(pGyoumuKousinTime);

            BizPropertyInitializer.initialize(khTmttknitenWk);
            hozenDomManager.insert(khTmttknitenWk);
        }
    }

    private void doJikouteikanri2() {
        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);
        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        khProcessForward.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            bzCommonLockProcess.getKouteiLockKey(),
            uiBean.getSyanaicommentkh(),
            khRuleBean);

        bzCommonLockProcess.unlockProcess();
    }

    private void makeTyouhyouSeiKyuSyo(KhozenCommonParam pKhozenCommonParam,
        HozenPreReportRenkeiBean pHozenPreReportRenkeiBean) {
        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);

        BizDate sysDate = BizDate.getSysDate();

        if (C_Tmttknitenkbn.ITEN.eq(uiBean.getTmttknitenkbn())) {
            BizDate tmttknItenUktkStartYmd = uiBean.getTmttknitenymd()
                .addMonths(-YuyuHozenConfig.getInstance().getTmttknItenUkeKaisiTukisuu()).getRekijyou();
            editSouhuannaiParam.setTmttknitenkbn(uiBean.getTmttknitenkbn());
            editSouhuannaiParam.setTmttknitenuktkstartymd(tmttknItenUktkStartYmd);
            editSouhuannaiParam.setSyoruiuktkkigenymd(uiBean.getSyoruiUktkKigenYmd());

            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

            BizDate kykymd = pKhozenCommonParam.getKeiyakuSyouhin(uiBean.getSyono(), C_SyutkKbn.SYU).get(0).getKykymd();

            BizDate kykoutobi = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO,
                kykymd,
                C_Hrkkaisuu.NEN,
                sysDate);

            if (BizDateUtil.compareYmd(sysDate, kykoutobi.addMonths(-3).getRekijyou()) == BizDateUtil.COMPARE_LESSER) {
                editSouhuannaiParam.setTmttknitenuktkkahikbn(C_KahiKbn.KA);
            }
        }
        else {
            editSouhuannaiParam.setTmttknitenkbn(uiBean.getTmttknitenkbn());
            editSouhuannaiParam.setSyoruiuktkkigenymd(uiBean.getSyoruiUktkKigenYmd());
        }

        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);
        if (C_Tmttknitenkbn.ITEN.eq(uiBean.getTmttknitenkbn())) {
            editSeikyuusyoParam.setTmttknitenkbn(uiBean.getTmttknitenkbn());
            editSeikyuusyoParam.setTmttknitenymd(uiBean.getTmttknitenymd());
        }
        else {
            editSeikyuusyoParam.setTmttknitenkbn(uiBean.getTmttknitenkbn());
        }

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        C_SyoruiCdKbn[] syoruiCds = {C_SyoruiCdKbn.KK_TUMITATEKINITEN_SOUHU, C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS};

        khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam,
            uiBean.getSyono(),
            syoruiCds,
            C_YouhiKbn.YOU);

        uiBean.setTyouhyoUmuKbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setTyouhyouKey(khozenTyouhyouCtl.getTyouhyouKey());
        uiBean.getBzWorkflowInfo().setKouteiKanriId(pHozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());

    }

    private void insertWorkTableSeikyuSyo(KhozenCommonParam pKhozenCommonParam, String pGyoumuKousinTime) {
        IW_KhTmttknitenWk khTmttknitenWk = new IW_KhTmttknitenWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        khTmttknitenWk.setSyono(uiBean.getSyono());
        khTmttknitenWk.setSkssakuseiymd(BizDate.getSysDate());
        khTmttknitenWk.setTmttknitenkbn(uiBean.getTmttknitenkbn());
        khTmttknitenWk.setUktkkigenymd(uiBean.getSyoruiUktkKigenYmd());
        khTmttknitenWk.setTmttknitenymd(uiBean.getTmttknitenymd());
        khTmttknitenWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        khTmttknitenWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        khTmttknitenWk.setGyoumuKousinTime(pGyoumuKousinTime);

        BizPropertyInitializer.initialize(khTmttknitenWk);
        hozenDomManager.insert(khTmttknitenWk);
    }

}
