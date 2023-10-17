package yuyu.app.hozen.khozen.khyendthnkuktknini;

import static yuyu.app.hozen.khozen.khyendthnkuktknini.GenKhYendtHnkUktkNiniConstants.*;
import static yuyu.app.hozen.khozen.khyendthnkuktknini.KhYendtHnkUktkNiniConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khyendthnkuktknini.KhYendtHnkUktkNiniConstants.E_TableRegKbn;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
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
import yuyu.common.hozen.haitou.CheckDShrYendtHnkuketuke;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSouhuannaiParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiSyoriKengen;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknYendtHnk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
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
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkYendtHnk;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhYendtHnkUktkNiniWk;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

import com.google.common.base.Joiner;

/**
 * 円建変更受付（任意請求） のビジネスロジックです。
 */
public class KhYendtHnkUktkNiniBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhYendtHnkUktkNiniUiBean uiBean;

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

    void init() {
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {

        initUiBean();

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();

        String kouteikanriId = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        String jimutetuzukiCd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(kouteikanriId, jimutetuzukiCd);

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            kouteikanriId,
            jimutetuzukiCd,
            uiBean.getBzWorkflowInfo().getTaskId(),
            bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {

            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {

            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteikanriId);

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());

        chkKykExist();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        chkYuukouJyoutai(khozenCommonParam);

        chkTetuduki(khozenCommonParam);


        IT_KykSyouhn syuKykSyouhn = uiBean.getKykKihon().getKykSyouhns().get(0);

        String yendtHnkmaeSyouhncd = syuKykSyouhn.getSyouhncd();

        int syohinHanteiKbn = SyouhinUtil.hantei(yendtHnkmaeSyouhncd);

        IW_KhYendtHnkUktkNiniWk khYendtHnkUktkNiniWk = hozenDomManager.getKhYendtHnkUktkNiniWk(kouteikanriId);

        BizDate syoruiUkeYmd = null;

        if (khYendtHnkUktkNiniWk.getSyoruiukeymd() == null) {

            GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);

            syoruiUkeYmd = getSyoruittykymd.exec(
                kouteikanriId,
                C_SyoruiCdKbn.KK_YENDTHNK_SKS);
        }
        else {

            syoruiUkeYmd = khYendtHnkUktkNiniWk.getSyoruiukeymd();
        }

        uiBean.setZenkaisyorikekkakbn(khYendtHnkUktkNiniWk.getZenkaisyorikekkakbn());

        uiBean.setSyoruiukeymd(syoruiUkeYmd);

        uiBean.setSksSakuseiYmd(khYendtHnkUktkNiniWk.getSkssakuseiymd());

        uiBean.setHonninkakninkekkakbn(khYendtHnkUktkNiniWk.getHonninkakninkekkakbn());

        uiBean.setHassoukbn(khYendtHnkUktkNiniWk.getHassoukbn());

        uiBean.setYendthnkmaeSyouhncd(yendtHnkmaeSyouhncd);

        uiBean.setSyouhinHanteiKbn(syohinHanteiKbn);

        if (syuKykSyouhn.getYendthnkymd() != null) {

            uiBean.setYendtHnkUmu(C_UmuKbn.ARI);
        }
        else {

            uiBean.setYendtHnkUmu(C_UmuKbn.NONE);
        }

        setGamenCommon(khozenCommonParam);


        C_UmuKbn targettkhkumu = uiBean.getKykKihon().getKykSonotaTkyk().getTargettkhkumu();

        C_TargetTkKbn targettkkbn = uiBean.getKykKihon().getKykSonotaTkyk().getTargettkkbn();

        Integer targettkmokuhyouti = uiBean.getKykKihon().getKykSonotaTkyk().getTargettkmokuhyouti();

        if (C_UmuKbn.ARI.eq(targettkhkumu)&&(targettkmokuhyouti > 0)) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC1002,
                targettkkbn.getContent());
        }

        if (C_UmuKbn.ARI.eq(uiBean.getYendtHnkUmu())) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC0001,
                MessageUtil.getMessage(MessageId.IIW1013));
        }

        ChkYendthnkuktkKanoukkn chkYendthnkuktkKanoukkn = new ChkYendthnkuktkKanoukkn();

        C_KahiKbn uktkKanou = chkYendthnkuktkKanoukkn.exec(
            uiBean.getSyoruiukeymd(),
            uiBean.getKykKihon(),
            KHYENDTHNKUKTKKANOUKKNCHKKBN_SYORUIUKEKANOUCHK);

        if (C_KahiKbn.HUKA.eq(uktkKanou)) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING2,
                MessageId.WIF1034,
                DateFormatUtil.dateKANJI(chkYendthnkuktkKanoukkn.getSyoruiUketukeKanouYmd()));
        }

        uiBean.setSyoruiukeKahiFlg(uktkKanou);

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING3,
                MessageId.WIC0001,
                khYendtHnkUktkNiniWk.getZenkaisyorikekkakbn().getContent(C_SyorikekkaKbn.PATTERN_KHOZEN));
        }

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);
    }

    void pushNyuryokuBL() {

        initUiBean();

        BizDate sysDate = BizDate.getSysDate();

        uiBean.setSyono(uiBean.getVkihnsyono());

        chkKykExist();

        IT_KykSyouhn syuKykSyouhn = uiBean.getKykKihon().getKykSyouhns().get(0);

        if (syuKykSyouhn.getYendthnkymd() != null) {

            throw new BizLogicException(MessageId.EIA0035, MessageUtil.getMessage(MessageId.IIW1013));
        }

        if (C_MousideIkouKbn.NONE.eq(syuKykSyouhn.getSyouhnZokusei().getMousideikoukbn())) {

            throw new BizLogicException(MessageId.EIA1052, MessageUtil.getMessage(MessageId.IIW1012));
        }

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        chkYuukouJyoutai(khozenCommonParam);

        chkTetuduki(khozenCommonParam);

        String yendtHnkmaeSyouhncd = syuKykSyouhn.getSyouhncd();

        int syohinHanteiKbn = SyouhinUtil.hantei(yendtHnkmaeSyouhncd);

        ChkYendthnkuktkKanoukkn chkYendthnkuktkKanoukkn = new ChkYendthnkuktkKanoukkn();

        C_KahiKbn uktkKanou = chkYendthnkuktkKanoukkn.exec(
            sysDate,
            uiBean.getKykKihon(),
            KHYENDTHNKUKTKKANOUKKNCHKKBN_SKSSAKUSEIKANOUCHK);

        if (C_KahiKbn.HUKA.eq(uktkKanou)) {

            throw new BizLogicException(MessageId.EIA1053,
                DateFormatUtil.dateKANJI(chkYendthnkuktkKanoukkn.getSksSakuseiKanouYmd()));
        }


        C_UmuKbn targettkhkumu = uiBean.getKykKihon().getKykSonotaTkyk().getTargettkhkumu();

        C_TargetTkKbn targettkkbn = uiBean.getKykKihon().getKykSonotaTkyk().getTargettkkbn();

        Integer targettkmokuhyouti = uiBean.getKykKihon().getKykSonotaTkyk().getTargettkmokuhyouti();

        if (C_UmuKbn.ARI.eq(targettkhkumu)&&(targettkmokuhyouti > 0)) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING1,
                MessageId.WIC1002,
                targettkkbn.getContent());
        }

        uktkKanou = chkYendthnkuktkKanoukkn.exec(
            sysDate,
            uiBean.getKykKihon(),
            KHYENDTHNKUKTKKANOUKKNCHKKBN_SYORUIUKEKANOUCHK);

        if (C_KahiKbn.HUKA.eq(uktkKanou)) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_WARNING2,
                MessageId.WIF1034,
                DateFormatUtil.dateKANJI(chkYendthnkuktkKanoukkn.getSyoruiUketukeKanouYmd()));
        }

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);

        hanteiSyoriKengen.exec();

        uiBean.setSyoruiukeymd(sysDate);

        uiBean.setYendthnkmaeSyouhncd(yendtHnkmaeSyouhncd);

        uiBean.setSyouhinHanteiKbn(syohinHanteiKbn);

        uiBean.setSyoruiukeKahiFlg(uktkKanou);

        setGamenCommon(khozenCommonParam);

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKUKTKNINI);

    }

    void pushSyoukaiBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }

        BizDate sysDate = BizDate.getSysDate();

        if (C_UmuKbn.NONE.eq(uiBean.getYendtHnkUmu()) &&
            ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) ||
                !C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()))) {


            if (uiBean.getSyoruiukeymd() == null) {

                throw new BizLogicException(
                    MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_YENDTHNKINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getSyoruiukeymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {

                throw new BizLogicException(
                    MessageId.EIA0037,
                    MessageUtil.getMessage(DDID_YENDTHNKINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            List<IT_KykSyouhn> kykSyouhnList =
                uiBean.getKykKihon().getKykSyouhnsByKouryokuhasseiymdGt(uiBean.getSyoruiukeymd());

            if (kykSyouhnList.size() > 0) {

                throw new BizLogicException(MessageId.EIA0106);
            }

            if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == uiBean.getSyouhinHanteiKbn()) {

            }
            else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn()) {

                BizDate syoruiukeymdYkn = uiBean.getSyoruiukeymd().getNextYear().getRekijyou();

                HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector
                    .getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector
                    .getInstance(HanteiTmttknJyoutaiBean.class);

                hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());

                hanteiTmttknJyoutaiBean.setHanteiKijyunymd(syoruiukeymdYkn);

                hanteiTmttknJyoutaiBean.setKykymd(uiBean.getVhsyusyukykymd());

                boolean hanteiKekka = hanteiKhSisuurendoTmttknJyoutai
                    .execKijunymdgoTmttknHantei(hanteiTmttknJyoutaiBean);

                if (hanteiKekka) {

                    throw new BizLogicException(MessageId.EIF1076);
                }

            }


            messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);

            ChkYendthnkuktkKanoukkn chkYendthnkuktkKanoukkn = new ChkYendthnkuktkKanoukkn();

            C_KahiKbn uktkKanou = chkYendthnkuktkKanoukkn.exec(
                uiBean.getSyoruiukeymd(),
                uiBean.getKykKihon(),
                KHYENDTHNKUKTKKANOUKKNCHKKBN_SYORUIUKEKANOUCHK);

            if(C_KahiKbn.HUKA.eq((uktkKanou))){

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING2,
                    MessageId.WIF1034,
                    DateFormatUtil.dateKANJI(chkYendthnkuktkKanoukkn.getSyoruiUketukeKanouYmd()));
            }

            uiBean.setSyoruiukeKahiFlg(uktkKanou);


            CheckDShrYendtHnkuketuke checkDShrYendtHnkuketuke = SWAKInjector
                .getInstance(CheckDShrYendtHnkuketuke.class);

            C_ErrorKbn errorKbn = checkDShrYendtHnkuketuke.checkDShr(
                uiBean.getSyono(),
                uiBean.getSyoruiukeymd(),
                sysDate);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("配当支払チェックが実行できませんでした。");
            }

            C_UmuKbn dHuseigouUmu = checkDShrYendtHnkuketuke.getDHuseigouUmu();
            C_UmuKbn dHaneiYmdUmu = checkDShrYendtHnkuketuke.getDHaneiYmdUmu();
            C_UmuKbn dShrYmdUmu = checkDShrYendtHnkuketuke.getDShrYmdUmu();

            if (C_UmuKbn.ARI.eq(dHuseigouUmu)) {

                throw new BizLogicException(MessageId.EBS1012);
            }

            if (C_UmuKbn.ARI.eq(dHaneiYmdUmu)) {

                throw new BizLogicException(
                    MessageId.EBA1049,
                    MessageUtil.getMessage(DDID_YENDTHNKINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }

            if (C_UmuKbn.ARI.eq(dShrYmdUmu)) {

                throw new BizLogicException(MessageId.EIF1115);
            }

            uiBean.setMihaneiDUmu(checkDShrYendtHnkuketuke.getMihaneiDUmu());

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

                if (C_UmuKbn.ARI.eq(uiBean.getMihaneiDUmu())) {

                    throw new BizLogicException(MessageId.EBA1048);
                }
            }


            if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn()) {

                HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector
                    .getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector
                    .getInstance(HanteiTmttknJyoutaiBean.class);

                hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());

                hanteiTmttknJyoutaiBean.setHanteiKijyunymd(uiBean.getSyoruiukeymd());

                hanteiTmttknJyoutaiBean.setKykymd(uiBean.getVhsyusyukykymd());

                boolean hanteiKekka = hanteiKhSisuurendoTmttknJyoutai
                    .execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                if (!hanteiKekka) {

                    throw new BizLogicException(MessageId.EBA1052);
                }

                hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());

                hanteiTmttknJyoutaiBean.setHanteiKijyunymd(uiBean.getSyoruiukeymd());

                hanteiTmttknJyoutaiBean.setKykymd(uiBean.getVhsyusyukykymd());

                hanteiKekka = hanteiKhSisuurendoTmttknJyoutai.execKijunymdgoTmttknHantei(hanteiTmttknJyoutaiBean);

                if (hanteiKekka) {

                    throw new BizLogicException(
                        MessageId.EIA1051,
                        MessageUtil.getMessage(DDID_YENDTHNKINFO_SYORUIUKEYMD.getErrorResourceKey()));
                }
            }
        }

        SetYendthnkTkhukainfo setYendthnkTkhukainfo = new SetYendthnkTkhukainfo();

        String yendthnkTkhukainfo = setYendthnkTkhukainfo.exec(uiBean.getKykKihon().getKykSonotaTkyk(), uiBean);

        uiBean.setYendthnktkhukainfo(yendthnkTkhukainfo);


        IT_KykSyouhn syuKykSyouhn = uiBean.getKykKihon().getKykSyouhns().get(0);

        if (C_UmuKbn.NONE.eq(uiBean.getYendtHnkUmu())) {


            BizDate yendtHnkYmd = uiBean.getSyoruiukeymd().addDays(1);

            String yendthnkSyouhncd = null;
            Integer syouhnsdNoMax = 0;
            String yendtgoryouritusdno = null;
            BizNumber yendthnkyoteirirituui = BizNumber.ZERO;

            if (C_KahiKbn.KA.eq(uiBean.getSyoruiukeKahiFlg())) {
                yendthnkSyouhncd = syuKykSyouhn.getSyouhnZokusei().getYendthnksyouhncd();

                syouhnsdNoMax = bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(
                    yendthnkSyouhncd, yendtHnkYmd);

                BM_SyouhnZokusei syouhnZokuseiInfo = bizDomManager.getSyouhnZokusei(yendthnkSyouhncd, syouhnsdNoMax);

                yendtgoryouritusdno = syouhnZokuseiInfo.getRyouritusdno();

                yendthnkyoteirirituui = BizNumber.ZERO;
            }


            BizCurrency yendthnkKaiyakuhrYen = null;

            BizCurrency yendthnkKaiyakuhrGaika = null;

            BizDateYM jkipjytym = null;

            C_Hrkkaisuu hrkkaisuu = null;

            C_Kykjyoutai kykjyoutai = null;

            BizNumber yendthnkjiKwsrate = null;

            BizNumber sjkkktyouseiritu = BizNumber.ZERO;

            BizCurrency kaiyakukjgk = BizCurrency.valueOf(0);

            BizNumber kaiyakukjritu = BizNumber.ZERO;

            BizCurrency tmttkngk = BizCurrency.valueOf(0);

            if (C_KahiKbn.KA.eq(uiBean.getSyoruiukeKahiFlg())) {

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(uiBean.getSyono());

                jkipjytym = ansyuKihon.getJkipjytym();

                hrkkaisuu = uiBean.getKykKihon().getHrkkaisuu();

                kykjyoutai = syuKykSyouhn.getKykjyoutai();

                C_Tuukasyu kyktuukasyu = syuKykSyouhn.getKyktuukasyu();

                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                C_ErrorKbn errorKbn = getKawaseRate.exec(
                    uiBean.getSyoruiukeymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    kyktuukasyu,
                    C_Tuukasyu.JPY,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.SYUKKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.YOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new CommonBizAppException("為替レート取得が実行できませんでした。");
                }

                yendthnkjiKwsrate = getKawaseRate.getKawaserate();

                BizDate yendthnkjiKwsrateKjYmd = getKawaseRate.getKwsrateKjYmd();

                if (BizDateUtil.compareYmd(yendthnkjiKwsrateKjYmd, uiBean.getSyoruiukeymd()) == BizDateUtil.COMPARE_LESSER) {

                    uiBean.setKawaseRateMinasiKbn(KAWASERATEMINASIKBN_MINASIRATE);
                }
                else {

                    uiBean.setKawaseRateMinasiKbn(KAWASERATEMINASIKBN_SEIJYOURATE);
                }

                KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                BizDateYM kaiyakuhrKeisankijyunYm = keisanWKijunYM.exec(
                    uiBean.getVhsyusyukykymd(),
                    uiBean.getSyoruiukeymd(),
                    jkipjytym,
                    hrkkaisuu,
                    kykjyoutai,
                    uiBean.getYendthnkmaeSyouhncd(),
                    null);

                KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);

                errorKbn = keisanWExt.exec(uiBean.getSyono(), uiBean.getSyoruiukeymd());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new CommonBizAppException("解約返戻金計算拡張情報作成が実行できませんでした。");
                }

                KeisanWExtBean keisanWExtBean = keisanWExt.getKeisanWExtBean();

                KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

                errorKbn = keisanW.exec(
                    uiBean.getSyoruiukeymd(),
                    kaiyakuhrKeisankijyunYm,
                    keisanWExtBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new CommonBizAppException("解約返戻金計算が実行できませんでした。");
                }

                BizCurrency kaiyakuHr = keisanW.getW();
                sjkkktyouseiritu = keisanW.getSjkkktyouseiritu().multiply(100);
                kaiyakukjgk = keisanW.getKaiyakukjgk();
                kaiyakukjritu = keisanW.getKaiyakukjritu();
                tmttkngk = keisanW.getV();

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                yendthnkKaiyakuhrGaika = kaiyakuHr;

                yendthnkKaiyakuhrYen = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    kaiyakuHr,
                    yendthnkjiKwsrate,
                    C_HasuusyoriKbn.AGE);
            }


            BizCurrency yendthnkKaiyakuhrui = null;

            BizCurrency yendthnkkjnkngk = null;

            BizCurrency yendthnkKihons = null;

            BizNumber yendthnkTumitateRiritu = null;

            BizCurrency yendthnkPtumitatekin = BizCurrency.optional();

            BizCurrency yendthnksbhokenknGk = BizCurrency.optional();

            if (C_KahiKbn.KA.eq(uiBean.getSyoruiukeKahiFlg())) {

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == uiBean.getSyouhinHanteiKbn()) {


                    yendthnkTumitateRiritu = BizNumber.ZERO;

                }
                else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == uiBean.getSyouhinHanteiKbn()) {

                    BizNumber yoteirrthendohosyurrt = syuKykSyouhn.getYoteirrthendohosyurrt();

                    GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

                    GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

                    getYoteirirituBean.setSyouhncd(yendthnkSyouhncd);
                    getYoteirirituBean.setKijyunymd(null);
                    getYoteirirituBean.setSknnkaisiymd(yendtHnkYmd);
                    getYoteirirituBean.setKykymd(yendtHnkYmd);
                    getYoteirirituBean.setHknkkn(uiBean.getVhsyusyuhknkkn());
                    getYoteirirituBean.setHknkknsmnkbn(uiBean.getVhsyusyuhknkknsmnkbn());
                    getYoteirirituBean.setHhknnen(uiBean.getVhsyusyuhhknnen());
                    getYoteirirituBean.setSitihsyuriritu(yoteirrthendohosyurrt);

                    C_ErrorKbn kekkaKbn = getYoteiriritu.exec(getYoteirirituBean);

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                        throw new CommonBizAppException("予定利率取得が実行できませんでした。");
                    }

                    yendthnkTumitateRiritu = getYoteiriritu.getTumitateriritu();
                    yendthnkyoteirirituui = getYoteiriritu.getYoteiriritu();
                    yendthnkKihons = yendthnkKaiyakuhrYen;
                    yendthnkkjnkngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    yendthnkPtumitatekin = yendthnkKaiyakuhrYen;
                    yendthnksbhokenknGk = yendthnkKaiyakuhrYen;
                    yendthnkKaiyakuhrui = yendthnkKaiyakuhrYen;

                }
                else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn()) {

                    BizNumber yoteirrthendohosyurrt = syuKykSyouhn.getYoteirrthendohosyurrt();

                    GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

                    GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

                    getYoteirirituBean.setSyouhncd(yendthnkSyouhncd);
                    getYoteirirituBean.setKijyunymd(null);
                    getYoteirirituBean.setSknnkaisiymd(yendtHnkYmd);
                    getYoteirirituBean.setKykymd(yendtHnkYmd);
                    getYoteirirituBean.setHknkkn(uiBean.getVhsyusyuhknkkn());
                    getYoteirirituBean.setHknkknsmnkbn(uiBean.getVhsyusyuhknkknsmnkbn());
                    getYoteirirituBean.setHhknnen(uiBean.getVhsyusyuhhknnen());
                    getYoteirirituBean.setSitihsyuriritu(yoteirrthendohosyurrt);

                    C_ErrorKbn kekkaKbn = getYoteiriritu.exec(getYoteirirituBean);

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                        throw new CommonBizAppException("予定利率取得が実行できませんでした。");
                    }

                    yendthnkTumitateRiritu = getYoteiriritu.getTumitateriritu();
                    yendthnkyoteirirituui = getYoteiriritu.getYoteiriritu();

                    yendthnkKihons = yendthnkKaiyakuhrYen;

                    yendthnkkjnkngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                    yendthnkKaiyakuhrui = yendthnkKaiyakuhrYen;

                }

                uiBean.setYendthnkkjnkngk(yendthnkKaiyakuhrYen);
                uiBean.setYendthnkptumitatekin(yendthnkPtumitatekin);
                uiBean.setYendthnksbhokenkngk(yendthnksbhokenknGk);
                uiBean.setYendthnkkaiyakuhrgk(yendthnkKaiyakuhrui);
            }
            else {

                uiBean.setYendthnkkjnkngk(BizCurrency.optional());
                uiBean.setYendthnkptumitatekin(BizCurrency.optional());
                uiBean.setYendthnksbhokenkngk(BizCurrency.optional());
                uiBean.setYendthnkkaiyakuhrgk(BizCurrency.optional());
            }


            if (C_KahiKbn.KA.eq(uiBean.getSyoruiukeKahiFlg())) {

                if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == uiBean.getSyouhinHanteiKbn()) {

                    KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                    BizDateYM yendthnkYm = keisanWKijunYM.exec(
                        uiBean.getVhsyusyukykymd(),
                        yendtHnkYmd,
                        jkipjytym,
                        hrkkaisuu,
                        kykjyoutai,
                        yendthnkSyouhncd,
                        null);

                    BizDateYM nenkinstartYm = keisanWKijunYM.exec(
                        uiBean.getVhsyusyukykymd(),
                        uiBean.getVhsyusyunkshrstartymd(),
                        jkipjytym,
                        hrkkaisuu,
                        kykjyoutai,
                        yendthnkSyouhncd,
                        yendtHnkYmd);

                    KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk =
                        SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

                    C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(
                        uiBean.getVhsyusyunkshrstartymd(),
                        nenkinstartYm,
                        yendtHnkYmd,
                        yendthnkYm,
                        uiBean.getVhsyusyukykymd(),
                        uiBean.getVhsyusyuhknkkn(),
                        uiBean.getYendthnkkjnkngk(),
                        yendthnkTumitateRiritu);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        throw new CommonBizAppException("円建変更後積立金計算が実行できませんでした。");

                    }

                    uiBean.setNkgnsgk(keisanSisuuRendouNkTmttknYendtHnk.getTumitategk());

                }
            }
            else {

                uiBean.setNkgnsgk(BizCurrency.optional());
            }


            uiBean.setYendthnkymd(yendtHnkYmd);

            uiBean.setMkhgktttKaiyakuhr(yendthnkKaiyakuhrYen);

            uiBean.setYendthnkKaiyakuhr(yendthnkKaiyakuhrui);

            uiBean.setYendthnkhr(yendthnkkjnkngk);

            uiBean.setYendthnkKaiyakuhrGaika(yendthnkKaiyakuhrGaika);

            uiBean.setYendthnkKaiyakuhrYen(yendthnkKaiyakuhrYen);

            uiBean.setKawaseRate(yendthnkjiKwsrate);

            uiBean.setYendthnkSyouhncd(yendthnkSyouhncd);

            uiBean.setYendthnkSyouhnsdno(syouhnsdNoMax);

            uiBean.setYendthnkKihons(yendthnkKihons);

            uiBean.setYendthnkRyouritusdno(yendtgoryouritusdno);

            uiBean.setYendthnkTumitateRiritu(yendthnkTumitateRiritu);

            uiBean.setYendthnkYoteiRiritu(yendthnkyoteirirituui);

            uiBean.setSjkkktyouseiyouriritu(sjkkktyouseiritu);

            uiBean.setKaiyakukjgk(kaiyakukjgk);

            uiBean.setKaiyakukoujyoritu(kaiyakukjritu);

            uiBean.setPtmttkngk(tmttkngk);

            uiBean.setKaiyakukoujyoritutekiumu(syuKykSyouhn.getSyouhnZokusei().getKaiyakukoujyoritutekiumu());

        }
        else {

            uiBean.setYendthnkymd(syuKykSyouhn.getYendthnkymd());

            uiBean.setYendthnkkjnkngk(BizCurrency.optional());

            uiBean.setNkgnsgk(BizCurrency.optional());

        }

        if (C_UmuKbn.NONE.eq(uiBean.getYendtHnkUmu())) {

            Integer syoruiUkeKyoyou = YuyuHozenConfig.getInstance().getSyoruiUkeKyoyou();

            BizDate syoruiUkeKyoyouDate = uiBean.getSyoruiukeymd().addDays(syoruiUkeKyoyou);

            if (BizDateUtil.compareYmd(syoruiUkeKyoyouDate, sysDate) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(syoruiUkeKyoyouDate, sysDate) == BizDateUtil.COMPARE_EQUAL) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING4,
                    MessageId.WIF1004,
                    MessageUtil.getMessage(DDID_YENDTHNKINFO_SYORUIUKEYMD.getErrorResourceKey()),
                    syoruiUkeKyoyou.toString() + "日");
            }


            if (KAWASERATEMINASIKBN_MINASIRATE == uiBean.getKawaseRateMinasiKbn()) {

                messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_WARNING4,
                    MessageId.WIA1003);
            }

        }

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);
    }

    void pushsSeikyuusyoSakusei() {

        chkKouteiKaisiSeikyuusyo();

        messageManager.addMessageId(MessageId.QIA0004);
    }

    String pushSyoukainomiBL() {

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            return FORWARDNAME_INIT;

        }

        unlockProcessBL();

        return FORWARDNAME_BACKTOWORKLIST;

    }

    void pushSainyuryokuBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING4);
    }

    void pushKakuninBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) ||
            ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            if (C_KahiKbn.HUKA.eq(uiBean.getSyoruiukeKahiFlg())) {

                throw new BizLogicException(MessageId.EIA1050, MessageUtil.getMessage(MessageId.IIW1014));
            }

            if (C_UmuKbn.ARI.eq(uiBean.getYendtHnkUmu()) &&
                ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                    C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()))) {

                throw new BizLogicException(MessageId.EIF1111);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getMihaneiDUmu()) &&
                ((C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
                    C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) &&
                    !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn()))) {

                throw new BizLogicException(MessageId.EIA1040);
            }

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

            chkKouteiKaisiKakutei();
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushModoruBtnByConfirmBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }
    }

    @Transactional
    void pushKakuteiBL() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

            continueLockProcess();
        }
        else {

            chkKouteiKaisiKakutei();

            chkYuukouJyoutai(khozenCommonParam);

            createBizProcess();

        }

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            String sikibetuKey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

            tableMaintenanceUtil.backUp(
                uiBean.getSyono(),
                sikibetuKey);


            IT_KykKihon kykKihon = uiBean.getKykKihon();

            doUpdateKTKykKihon(kykKihon, khozenCommonParam, sysDate, sysTime);

            IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();

            khTtdkRireki.setHenkousikibetukey(sikibetuKey);

            createTttdkrirekiInfo(kykKihon, khozenCommonParam, sysDate, sysTime);

            doInsKhHenkouUktkInfo(khozenCommonParam, sysDate, sysTime);

            hozenDomManager.update(kykKihon);
        }

        if (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
            C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            IW_KhYendtHnkUktkNiniWk khYendtHnkUktkNiniWk =
                hozenDomManager.getKhYendtHnkUktkNiniWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

            hozenDomManager.delete(khYendtHnkUktkNiniWk);

        }

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            (C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) &&
                !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn()))) {

            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {

                doInsKhYendtHnkUktkNiniWk(
                    khozenCommonParam,
                    sysDate,
                    sysTime,
                    uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    E_TableRegKbn.CONFIRM);
            }
            else {

                doUpdKhYendtHnkUktkNiniWk(khozenCommonParam, sysDate, sysTime);
            }
        }

        doJikouteikanri();

        if (!C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode()) ||
            C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()) ||
            !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

            uiBean.getKykKihon().detach();
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

    String pushModoruInputContentsBL() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {

            unlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    void pushTojiruBL() {

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {

            unlockProcessBL();
        }
    }

    @Transactional
    void pushKakuteiBySksconfirmBL() {

        chkKouteiKaisiSeikyuusyo();

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector
            .getInstance(KhHituyousyoruiHanteiInBean.class);

        HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();

        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);

        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        hozenPreReportRenkeiBean.setSyoNo(uiBean.getSyono());

        hozenPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());

        hozenPreReportRenkeiBean.setSyoriComment("");

        hozenPreReportRenkeiBean.setTaskNm(null);

        hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);

        hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);

        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);

        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);

        C_SyoruiCdKbn[] syoruiCds = {
            C_SyoruiCdKbn.KK_YENDTHNK_SOUHU,
            C_SyoruiCdKbn.KK_YENDTHNK_SKS };

        khozenTyouhyouCtl.createTyouhyouTBL(
            khozenCommonParam,
            uiBean.getSyono(),
            syoruiCds,
            C_YouhiKbn.YOU);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());

        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());

        doInsKhYendtHnkUktkNiniWk(
            khozenCommonParam,
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

    String pushSyokigamenkkBL() {

        if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) ) {

            return FORWARDNAME_INIT;

        }

        return FORWARDNAME_BACKTOWORKLIST;
    }

    void continueLockProcess() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();
    }

    void unlockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }


    private void chkKykExist() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon != null) {

            uiBean.setKykKihon(kykKihon);
        }
        else {

            throw new BizLogicException(MessageId.EBA0090);
        }
    }

    private void chkYuukouJyoutai(KhozenCommonParam pKhozenCommonParam) {


        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(
            pKhozenCommonParam,
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
                    KhMessageGroupConstants.GROUP_YUUKOUCHECKWARNING,
                    messageId,
                    message);
            }

            uiBean.getHnskariyuuList().add(C_HnskariyuuKbn.JIMU_ARI);
        }
    }

    private void chkTetuduki(KhozenCommonParam pKhozenCommonParam) {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(
            pKhozenCommonParam,
            uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {

            messageManager.addConversationMessageId(
                KhMessageGroupConstants.GROUP_HANTEITETUDUKIWARNING,
                hanteiTetuduki.getMessageID(),
                hanteiTetuduki.getMessageParam());
        }
    }

    private void chkKouteiKaisiSeikyuusyo() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmu = checkProcessKaishi.exec(
            uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmu)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }
    }

    private void chkKouteiKaisiKakutei() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn kouteiUmu = checkProcessKaishi.exec(
            uiBean.getSyono(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(kouteiUmu)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA1002,
                DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
        }
    }

    private void createBizProcess() {

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

        BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);

        bzForceTaskStart.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            C_KhkinouModeIdKbn.INPUT.getValue(),
            bzCommonLockProcess.getKouteiLockKey());
    }

    private void setGamenCommon(KhozenCommonParam pKhozenCommonParam) {

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

        SetHituyouSyorui.exec(pKhozenCommonParam, uiBean);

    }

    private void initUiBean() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono("");

        uiBean.setSyoruiukeymd(null);

        uiBean.setYendthnkkjnkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        uiBean.setNkgnsgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        uiBean.setZenkaisyorikekkakbn(C_SyorikekkaKbn.BLNK);

        uiBean.setHonninkakninkekkakbn(C_HonninKakninKekkaKbn.BLNK);

        uiBean.setHassoukbn(C_HassouKbn.BLNK);

        uiBean.setSksSakuseiYmd(null);

        uiBean.setSyouhinHanteiKbn(SyouhinUtil.SYOHIN_BLNK);

        uiBean.setYendtHnkUmu(C_UmuKbn.NONE);

        uiBean.setSyoruiukeKahiFlg(C_KahiKbn.KA);

        uiBean.setMihaneiDUmu(C_UmuKbn.NONE);

        uiBean.setKawaseRateMinasiKbn(KAWASERATEMINASIKBN_SEIJYOURATE);

        uiBean.setYendthnkymd(null);

        uiBean.setMkhgktttKaiyakuhr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        uiBean.setYendthnkKaiyakuhr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        uiBean.setYendthnkhr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        uiBean.setYendthnkKaiyakuhrYen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        uiBean.setKawaseRate(BizNumber.valueOf(0));

        uiBean.setYendthnkSyouhncd("");

        uiBean.setYendthnkSyouhnsdno(0);

        uiBean.setYendthnkKihons(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        uiBean.setYendthnkRyouritusdno("0");

        uiBean.setYendthnkTumitateRiritu(BizNumber.valueOf(0));

        uiBean.setYendthnkmaeSyouhncd("");

        uiBean.setYendthnkYoteiRiritu(BizNumber.valueOf(0));

        uiBean.setSjkkktyouseiyouriritu(BizNumber.valueOf(0));

        uiBean.setKaiyakukjgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        uiBean.setKaiyakukoujyoritu(BizNumber.valueOf(0));

        uiBean.setPtmttkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        uiBean.setKaiyakukoujyoritutekiumu(C_UmuKbn.NONE);
    }

    private void doUpdateKTKykKihon(IT_KykKihon pKykKihon, KhozenCommonParam pKhozenCommonParam, BizDate pSysDate,
        String pSysTime) {

        pKykKihon.setSyhenkouymd(pSysDate);

        pKykKihon.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

        pKykKihon.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

        pKykKihon.setGyoumuKousinTime(pSysTime);
    }

    private void createTttdkrirekiInfo(IT_KykKihon pKykKihon, KhozenCommonParam pKhozenCommonParam,
        BizDate pSysDate, String pSysTime) {

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        editTtdkRirekiTblParam.setCommonParam(pKhozenCommonParam);

        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());

        editTtdkRirekiTblParam.setSyoriYmd(pSysDate);

        editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.NONE);

        editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());

        editTtdkRirekiTblParam.setSysTime(pSysTime);

        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);

        editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
    }

    private void doInsKhHenkouUktkInfo(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate, String pSysTime) {

        String hozenHenkouUktkrenNo = SaibanBiz.getHozenHenkouUktkrenNo(uiBean.getSyono());


        IT_KhHenkouUktk khHenkouUktk = new IT_KhHenkouUktk(uiBean.getSyono(), Integer.valueOf(hozenHenkouUktkrenNo));

        khHenkouUktk.setUktkymd(pSysDate);

        khHenkouUktk.setTourokuroute(C_TourokuRouteKbn.ONLINE);

        khHenkouUktk.setUktksyorikbn(C_UktkSyoriKbn.NINISEIKYUU);

        khHenkouUktk.setKouryokuhasseiymd(uiBean.getYendthnkymd());

        khHenkouUktk.setSyoriyoteiymd(pSysDate);

        khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);

        khHenkouUktk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

        khHenkouUktk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

        khHenkouUktk.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(khHenkouUktk);


        IT_KhHenkouUktkYendtHnk khHenkouUktkYendtHnk = khHenkouUktk.createKhHenkouUktkYendtHnk();

        khHenkouUktkYendtHnk.setYendthnkymd(uiBean.getYendthnkymd());

        khHenkouUktkYendtHnk.setMkhgktttymd(null);

        khHenkouUktkYendtHnk.setMkhgktttkaiyakuhr(BizCurrency.valueOf(0));

        khHenkouUktkYendtHnk.setNewkaiyakuhr(uiBean.getYendthnkKaiyakuhr());

        khHenkouUktkYendtHnk.setYendthnkhr(uiBean.getYendthnkhr());

        khHenkouUktkYendtHnk.setNyuuryokuhassoukbn(uiBean.getHassoukbn());

        if (uiBean.getHnskariyuuList().size() == 0) {

            khHenkouUktkYendtHnk.setHnskariyuu1(C_HnskariyuuKbn.BLNK);

            khHenkouUktkYendtHnk.setHnskariyuu2(C_HnskariyuuKbn.BLNK);
        }
        else if (uiBean.getHnskariyuuList().size() == 1) {

            khHenkouUktkYendtHnk.setHnskariyuu1(uiBean.getHnskariyuuList().get(0));

            khHenkouUktkYendtHnk.setHnskariyuu2(C_HnskariyuuKbn.BLNK);
        }
        else {

            khHenkouUktkYendtHnk.setHnskariyuu1(uiBean.getHnskariyuuList().get(0));

            khHenkouUktkYendtHnk.setHnskariyuu2(uiBean.getHnskariyuuList().get(1));
        }

        khHenkouUktkYendtHnk.setYendthnkkaiyakuhrgaika(uiBean.getYendthnkKaiyakuhrGaika());

        khHenkouUktkYendtHnk.setYendthnkkaiyakuhryen(uiBean.getYendthnkKaiyakuhrYen());

        khHenkouUktkYendtHnk.setYendthnkjikwsrate(uiBean.getKawaseRate());

        khHenkouUktkYendtHnk.setNewsyouhncd(uiBean.getYendthnkSyouhncd());

        khHenkouUktkYendtHnk.setNewsyouhnsdno(uiBean.getYendthnkSyouhnsdno());

        khHenkouUktkYendtHnk.setYendthnkkihons(uiBean.getYendthnkKihons());

        khHenkouUktkYendtHnk.setNewhokenryou(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        khHenkouUktkYendtHnk.setNewkyktuukasyu(C_Tuukasyu.JPY);

        khHenkouUktkYendtHnk.setNewryouritusdno(uiBean.getYendthnkRyouritusdno());

        khHenkouUktkYendtHnk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

        khHenkouUktkYendtHnk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

        khHenkouUktkYendtHnk.setGyoumuKousinTime(pSysTime);

        khHenkouUktkYendtHnk.setSyoruiukeymd(uiBean.getSyoruiukeymd());

        khHenkouUktkYendtHnk.setNewtumitateriritu(uiBean.getYendthnkTumitateRiritu());

        khHenkouUktkYendtHnk.setNewyoteiriritu(uiBean.getYendthnkYoteiRiritu());

        khHenkouUktkYendtHnk.setMkhgk(BizCurrency.valueOf(0));

        khHenkouUktkYendtHnk.setYendthnkkjnkg(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        khHenkouUktkYendtHnk.setTargettkmokuhyouti(0);

        khHenkouUktkYendtHnk.setYendthnkbfrsibousyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        khHenkouUktkYendtHnk.setYendthnkjiptumitatekin(uiBean.getPtmttkngk());

        khHenkouUktkYendtHnk.setYendthnkjisjkkktyouseiritu(uiBean.getSjkkktyouseiyouriritu());

        khHenkouUktkYendtHnk.setYendthnkjikaiyakukjgk(uiBean.getKaiyakukjgk());

        khHenkouUktkYendtHnk.setYendthnkjikaiyakukoujyoritu(uiBean.getKaiyakukoujyoritu());

        khHenkouUktkYendtHnk.setKaiyakukoujyoritutekiumu(uiBean.getKaiyakukoujyoritutekiumu());

        BizPropertyInitializer.initialize(khHenkouUktkYendtHnk);

        hozenDomManager.insert(khHenkouUktk);
    }

    private void doInsKhYendtHnkUktkNiniWk(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate, String pSysTime,
        String pKouteikanriid, E_TableRegKbn pTableRegKbn) {

        IW_KhYendtHnkUktkNiniWk khYendtHnkUktkNiniWk = new IW_KhYendtHnkUktkNiniWk();

        khYendtHnkUktkNiniWk.setKouteikanriid(pKouteikanriid);

        khYendtHnkUktkNiniWk.setSyono(uiBean.getSyono());

        khYendtHnkUktkNiniWk.setSkssakuseiymd(pSysDate);

        if (pTableRegKbn.equals(E_TableRegKbn.CONFIRM)) {

            khYendtHnkUktkNiniWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());

            khYendtHnkUktkNiniWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());

            khYendtHnkUktkNiniWk.setHassoukbn(uiBean.getHassoukbn());

            if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

                khYendtHnkUktkNiniWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
            }
        }

        khYendtHnkUktkNiniWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

        khYendtHnkUktkNiniWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

        khYendtHnkUktkNiniWk.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(khYendtHnkUktkNiniWk);

        hozenDomManager.insert(khYendtHnkUktkNiniWk);
    }

    private void doUpdKhYendtHnkUktkNiniWk(KhozenCommonParam pKhozenCommonParam, BizDate pSysDate, String pSysTime) {

        IW_KhYendtHnkUktkNiniWk khYendtHnkUktkNiniWk =
            hozenDomManager.getKhYendtHnkUktkNiniWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        khYendtHnkUktkNiniWk.setSyoruiukeymd(uiBean.getSyoruiukeymd());

        khYendtHnkUktkNiniWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());

        khYendtHnkUktkNiniWk.setHassoukbn(uiBean.getHassoukbn());

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

            khYendtHnkUktkNiniWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        khYendtHnkUktkNiniWk.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

        khYendtHnkUktkNiniWk.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

        khYendtHnkUktkNiniWk.setGyoumuKousinTime(pSysTime);

        hozenDomManager.update(khYendtHnkUktkNiniWk);
    }

    private void doJikouteikanri() {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        khProcessForward.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            bzCommonLockProcess.getKouteiLockKey(),
            uiBean.getSyanaicommentkh(),
            khRuleBean);

        unlockProcessBL();
    }


    class ChkYendthnkuktkKanoukkn {

        private BizDate sksSakuseiKanouYmd;

        private BizDate syoruiUketukeKanouYmd;

        public C_KahiKbn exec(BizDate pHanteiKijyunYmd, IT_KykKihon pKykKihon, int pCheckNaiyou) {

            sksSakuseiKanouYmd = null;

            syoruiUketukeKanouYmd = null;

            BizDate kykymd = pKykKihon.getKykSyouhns().get(0).getKykymd();

            int syohinHanteiKbn = SyouhinUtil.hantei(pKykKihon.getKykSyouhns().get(0).getSyouhncd());

            if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn) {

                HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);

                HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

                hanteiHokenKikanBean.setKykYmd(kykymd);

                hanteiHokenKikanBean.setCalcKijyunYmd(pHanteiKijyunYmd);

                hanteiHokenKikanBean.setSyouhnZokusei(pKykKihon.getKykSyouhns().get(0).getSyouhnZokusei());

                hanteiHokenKikanBean.setDai1hknkkn(pKykKihon.getKykSyouhns().get(0).getDai1hknkkn());

                hanteiHokenKikan.exec(hanteiHokenKikanBean);

                BizDate dai2HknkknStartYmd = hanteiHokenKikan.getDai2HknkknStartYmd();

                syoruiUketukeKanouYmd = dai2HknkknStartYmd.getRekijyou();

                sksSakuseiKanouYmd = dai2HknkknStartYmd.addMonths(-1).getBusinessDay(CHolidayAdjustingMode.NEXT);

            }
            else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn ||
                SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn ||
                SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                BizDate kykymdItinengoOutouymd = setOutoubi.exec(
                    C_TykzentykgoKbn.TYKGO,
                    kykymd,
                    C_Hrkkaisuu.NEN,
                    kykymd);

                syoruiUketukeKanouYmd = kykymdItinengoOutouymd.getRekijyou();

                sksSakuseiKanouYmd = kykymdItinengoOutouymd.addMonths(-1).getBusinessDay(CHolidayAdjustingMode.NEXT);
            }

            if ((KHYENDTHNKUKTKKANOUKKNCHKKBN_SKSSAKUSEIKANOUCHK == pCheckNaiyou &&
                BizDateUtil.compareYmd(pHanteiKijyunYmd, sksSakuseiKanouYmd) == BizDateUtil.COMPARE_LESSER) ||
                (KHYENDTHNKUKTKKANOUKKNCHKKBN_SYORUIUKEKANOUCHK == pCheckNaiyou &&
                BizDateUtil.compareYmd(pHanteiKijyunYmd, syoruiUketukeKanouYmd) == BizDateUtil.COMPARE_LESSER)) {

                return C_KahiKbn.HUKA;
            }

            return C_KahiKbn.KA;
        }

        public BizDate getSksSakuseiKanouYmd() {
            return sksSakuseiKanouYmd;
        }

        public BizDate getSyoruiUketukeKanouYmd() {
            return syoruiUketukeKanouYmd;
        }
    }

    class SetYendthnkTkhukainfo {

        public String exec(IT_KykSonotaTkyk pKykSonotaTkyk, KhYendtHnkUktkNiniUiBean pUiBean) {

            String yendthnkTkhukainfo = BLANK;

            ArrayList<String> yendthnkTkhukainfoList = new ArrayList<String>();

            if (pKykSonotaTkyk != null) {

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getStdrsktkyhkumu())) {

                    yendthnkTkhukainfoList.add(IKhozenCommonConstants.TOKUYAKUNM_SITEIDAIRISEIKYUU);
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getKykdrtkykhukaumu())) {

                    yendthnkTkhukainfoList.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENKYKDRTKYK);
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                    if (!C_YennykntksyuruiKbn.BLNK.eq(pKykSonotaTkyk.getYennyknsyuruikbn())) {

                        yendthnkTkhukainfoList.add(pKykSonotaTkyk.getYennyknsyuruikbn().getContent());
                    }
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getGaikanykntkhkumu())) {

                    yendthnkTkhukainfoList.add(IKhozenCommonConstants.TOKUYAKUNM_GAIKANYUUKIN);
                }

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 != pUiBean.getSyouhinHanteiKbn() &&
                    C_UmuKbn.ARI.eq(pKykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                    yendthnkTkhukainfoList.add(IKhozenCommonConstants.TOKUYAKUNM_JYUUDOKAIGOMAEBARAI);
                }

                if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

                    yendthnkTkhukainfoList.add(IKhozenCommonConstants.TOKUYAKUNM_ZEISEITEKIKAKU);
                }
            }

            if (yendthnkTkhukainfoList.size() == 0) {

                yendthnkTkhukainfo = BLANK;
            }
            else {

                yendthnkTkhukainfo = Joiner.on("<br/>").join(
                    yendthnkTkhukainfoList.toArray(new String[yendthnkTkhukainfoList.size()]));
            }

            return yendthnkTkhukainfo;

        }
    }
}
