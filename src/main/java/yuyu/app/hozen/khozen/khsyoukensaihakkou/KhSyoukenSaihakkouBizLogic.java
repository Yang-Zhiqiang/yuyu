package yuyu.app.hozen.khozen.khsyoukensaihakkou;

import static yuyu.app.hozen.khozen.khsyoukensaihakkou.KhSyoukenSaihakkouConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

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
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckProcessKekka;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.EditHokenSyoukenParam;
import yuyu.common.hozen.khcommon.EditKoujyoSyoumeiParam;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.EditSkYouTtdkKanryouTbl;
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
import yuyu.common.hozen.khcommon.KhTyokusouHantei;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.SetSyokenhakkouymd;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.khcommon.TrkkzkTyokusouhtBean;
import yuyu.common.hozen.khcommon.TyokusouTaisyouBean;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.koutei.KhProcessForward;
import yuyu.common.hozen.koutei.KhRuleBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
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
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeisyuKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_SinsakuseiKbn;
import yuyu.def.classification.C_SkSyoukenSksKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_TyokusouhtkekKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IW_KhSyoukenSaihakkouWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KoujyoSym;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

/**
 * 証券再発行 のビジネスロジックです。
 */
public class KhSyoukenSaihakkouBizLogic {


    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhSyoukenSaihakkouUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private OutputReport outputReport;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private HozenPreReportRenkeiBean hozenPreReportRenkeiBean;

    void init() {
    }

    void clear() {
    }


    void pushSyoukaiBL() {

        BizPropertyInitializer.initialize(uiBean);

        checkKykSonzai();

        checkYuukouJyoutai();

        checkYuuyokkngai();

        HanteiSyoriKengen hanteiSyoriKengen = SWAKInjector.getInstance(HanteiSyoriKengen.class);
        hanteiSyoriKengen.exec();

        hanteiTetuduki();

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SYOUKENSAIHAKKOU);

        setUiBean();

        checkHenreikinMbr();
    }
    String functionNameOnClickBL() {

        if (C_KhkinouModeIdKbn.INPUT.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))
            || C_KhkinouModeIdKbn.TENKEN.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))
            || C_KhkinouModeIdKbn.SYOUNIN.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {
            pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    void pushKakuninBtn() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {
            bzCommonLockProcess.continueLockProcess();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {
            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
            C_UmuKbn cUmuKbn = checkProcessKaishi.exec(uiBean.getSyono()
                , uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(cUmuKbn)) {
                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    checkProcessKaishi.getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }

        }

        if ((C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())
            && C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())
            && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn()))
            ||
            ((C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
                || C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())
                || C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()))
                && C_SyorikekkaKbn.KANRYOU.eq(uiBean.getSyorikekkakbn()))) {

            if (C_SyoukensaihkKbn.BLNK.eq(uiBean.getSyoukensaihkkbn())) {

                throw new BizLogicException(MessageId.EBF1005, "再発行区分");
            }


            BizDate sysDate = BizDate.getSysDate();

            if (!C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn()) &&
                BizDateUtil.compareYmd(sysDate, uiBean.getVhsyusyukykymd()) == BizDateUtil.COMPARE_LESSER) {

                throw new BizLogicException(MessageId.EIA0070, SYORIBI);
            }

            if (!C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn())) {

                String syouhncd = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getSyouhncd();

                int syouhnhanteiKbn = SyouhinUtil.henkouKubetuHantei(syouhncd);

                if (syouhnhanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE ||
                    syouhnhanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_YENHENKOUMAE) {

                    HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
                    hanteiTmttknJyoutaiBean.setSyono(uiBean.getSyono());
                    hanteiTmttknJyoutaiBean.setHanteiKijyunymd(sysDate);
                    hanteiTmttknJyoutaiBean.setKykymd(uiBean.getVhsyusyukykymd());

                    HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                        SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                    boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                    if (!result) {
                        throw new BizLogicException(MessageId.EBA1052);
                    }
                }
            }

            if (C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn())) {

                BizDateYM bosyuuym = uiBean.getKykKihon().getBosyuuym();
                BizDateYM bosyuuymOneYearAfter = bosyuuym.addYears(1);
                bosyuuymOneYearAfter = bosyuuymOneYearAfter.getRekijyou();

                BizDateYM sysDateYM = sysDate.getBizDateYM();

                if (bosyuuymOneYearAfter.compareTo(sysDateYM) <= 0) {

                    throw new BizLogicException(MessageId.EIF1046);
                }

            }

            if (C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn())) {
                List<IT_KhTtdkRireki> khTtdkRirekiList = uiBean.getKykKihon().getKhTtdkRirekis();

                for (IT_KhTtdkRireki khTtdkRireki : khTtdkRirekiList) {
                    if (!IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_KANAKANJITEISEI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_ONLINENYUUKIN.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_NYUUKIN.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_KARIUKETEISEI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_KZSEIBI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_ONLINEDATTAI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_DATTAI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_TOKUSIN.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_KOUJYOSYOUMEISKS.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_SINKOKUYOKOKUUTISKS.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_MINYUU.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_IKKATUANNAISAIKAI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_MSYPTORIKOMI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_KHTETUDUKITYUUI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_KHKZKTRKKYKDRTKYKHNK.equals(khTtdkRireki.getGyoumuKousinKinou()) &&
                        !IKhozenCommonConstants.KINOUID_KHYUUKOUSEIKEKKAHANEI.equals(khTtdkRireki.getGyoumuKousinKinou())) {
                        throw new BizLogicException(MessageId.EIF1045);
                    }
                }
            }

            List<IT_HokenSyouken> itHokenSyoukenList = uiBean.getKykKihon().getHokenSyoukens();

            for (IT_HokenSyouken itHokenSyouken : itHokenSyoukenList) {

                if (sysDate.compareTo(itHokenSyouken.getTyouhyouymd()) == 0) {

                    throw new BizLogicException(MessageId.EIF1047);
                }
            }

            if (!C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn())) {

                if (C_InsizeiShryouhiKbn.HUYOU.eq(uiBean.getInsizeishryouhikbn())) {

                    throw new BizLogicException(MessageId.EIA1009, "再発行区分", "印紙税支払不要");
                }
            }

            if (C_HonninKakninKekkaKbn.BLNK.eq(uiBean.getHonninkakninkekkakbn())) {

                throw new BizLogicException(MessageId.EBC0043, "本人確認結果区分");
            }

            if (C_KktyuitaKbn.DNGNMEMOARI.eq(uiBean.getVtdktkktyuitakbn())) {

                if (C_HassouKbn.TYOKUSOU.eq(uiBean.getHassoukbn())) {

                    throw new BizLogicException(MessageId.EIA1007);
                }
            }
        }
        CheckProcessKekka checkProcessKekka = SWAKInjector.getInstance(CheckProcessKekka.class);

        checkProcessKekka.exec(uiBean.getSyorikekkakbn()
            , uiBean.getSyanaicommentkh()
            , uiBean.getSasimodosisakikbn());

        messageManager.addMessageId(MessageId.QBA0001);
    }


    void pushSeikyuushouBL() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

        C_UmuKbn cUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(cUmuKbn)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120, DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean
                .getKouteiStartYmd()));
        }

        BizDate sysDate = BizDate.getSysDate();

        if (BizDateUtil.compareYmd(sysDate, uiBean.getVhsyusyukykymd()) == BizDateUtil.COMPARE_LESSER) {

            throw new BizLogicException(MessageId.EIA0070, SYORIBI);
        }
        messageManager.addMessageId(MessageId.QIA0004);
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
    void pushKakuteiBtn() {

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
        C_UmuKbn cUmuKbn = checkProcessKaishi.exec(uiBean.getSyono(), uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

        if (C_UmuKbn.ARI.eq(cUmuKbn)) {

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = checkProcessKaishi.getBzGetProcessSummaryOutBean();

            throw new BizLogicException(MessageId.EIA0120, DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean
                .getKouteiStartYmd()));
        }

        KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean =
            SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);

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

        EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);

        EditSouhuannaiParam editSouhuannaiParam = SWAKInjector.getInstance(EditSouhuannaiParam.class);

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
        khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);
        khozenTyouhyouCtl.setEditSouhuannaiParam(editSouhuannaiParam);
        C_SyoruiCdKbn[] syoruicds = {C_SyoruiCdKbn.KK_SYOSAIHK_SOUHU, C_SyoruiCdKbn.KK_SYOSAIHK_SKS };
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, uiBean.getSyono(), syoruicds, C_YouhiKbn.YOU);

        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());
        uiBean.getBzWorkflowInfo().setKouteiKanriId(hozenPreReportRenkeiBean.getSakuseizumiKouteikanriId());

        insIWKhSyoukenSaihakkouWkSks();

        uiBean.getBzWorkflowInfo().setTaskId(kinouMode.getKinouMode());

        uiBean.getKykKihon().detach();

        messageManager.addMessageId(MessageId.IIA0017);
    }

    void printOut() {
        outputReport.outputPDFByJoinKey(uiBean.getTyouhyoukey());
    }

    @Transactional
    void pushKakutei(){

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        if (!C_KhkinouModeIdKbn.INPUTKEY.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {

            bzCommonLockProcess.continueLockProcess();
        }

        if (C_KhkinouModeIdKbn.INPUTKEY.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {

            CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);

            C_UmuKbn cUmuKbn = checkProcessKaishi.exec(uiBean.getSyono()
                , uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            if (C_UmuKbn.ARI.eq(cUmuKbn)) {

                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    checkProcessKaishi.getBzGetProcessSummaryOutBean();

                throw new BizLogicException(MessageId.EIA1002,
                    DefaultDateFormatter.formatYMDZeroFill(bzGetProcessSummaryOutBean.getKouteiStartYmd()));
            }

            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

            C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

            if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());

            }

            BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);

            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
            bzProcessCreateInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);

            BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

            if (C_KouteiSakuseiKekkaKbn.FAILURE.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0008));
            }

            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzProcessCreateOutBean.getKouteiKanriId());

            bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId()
                , uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);

            bzForceTaskStart.exec(uiBean.getBzWorkflowInfo().getKouteiKanriId()
                , uiBean.getBzWorkflowInfo().getJimuTetuzukiCd()
                , C_KhkinouModeIdKbn.INPUT.getValue()
                , bzCommonLockProcess.getKouteiLockKey());
        }

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();

        if (C_KhkinouModeIdKbn.SYOUNIN.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))
            && C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())
            && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {

            bzCommonLockProcess.continueLockProcess();
            uiBean.getBzWorkflowInfo().setTaskId(kinouMode.getKinouMode());

            EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

            tableMaintenanceUtil.backUp(uiBean.getSyono()
                , khozenCommonParam.getSikibetuKey(uiBean.getSyono()));

            IT_KykKihon kykKihon = uiBean.getKykKihon();

            SetSyokenhakkouymd setSyokenhakkouymd = SWAKInjector.getInstance(SetSyokenhakkouymd.class);

            BizDate syokenhakkouymd = setSyokenhakkouymd.exec(sysDate);

            if (C_SyoukensaihkKbn.SYOUKENSAIHAKKOU.eq(uiBean.getSyoukensaihkkbn())) {

                kykKihon.setSyhenkouymd(sysDate);
                kykKihon.setLastsyosaihkymd(sysDate);
                kykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                kykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                kykKihon.setGyoumuKousinTime(sysTime);
            }

            if (C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn())) {


                kykKihon.setSyhenkouymd(sysDate);
                kykKihon.setSksyoukenskskbn(C_SkSyoukenSksKbn.SAISAKUSEI);
                kykKihon.setSinkyksyokensakuseiymd(sysDate);
                kykKihon.setSyoyousinkyksyohakkouymd(syokenhakkouymd);
                kykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                kykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                kykKihon.setGyoumuKousinTime(sysTime);

                editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.SKSYOUKENSAIHAKKOU);
            }

            IT_KhTtdkRireki itKhTtdkRireki = uiBean.getKykKihon().createKhTtdkRireki();

            itKhTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(uiBean.getSyono()));

            editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
            editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
            editTtdkRirekiTblParam.setSyoriYmd(sysDate);
            editTtdkRirekiTblParam.setSysTime(sysTime);
            editTtdkRirekiTblParam.setHonninkakkekka(uiBean.getHonninkakninkekkakbn());
            editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
            editTtdkRirekiTblParam.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());

            EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

            editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

            hozenDomManager.update(kykKihon);

            createTyouhyou(syokenhakkouymd, khozenCommonParam);

        }

        if (C_KhkinouModeIdKbn.SYOUNIN.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))){
            if (C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())) {

                IW_KhSyoukenSaihakkouWk iwKhSyoukenSaihakkouWk =
                    hozenDomManager.getKhSyoukenSaihakkouWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

                hozenDomManager.delete(iwKhSyoukenSaihakkouWk);
            }
            else {
                updateIWKhSyoukenSaihakkouWk();
            }
        }
        if (C_KhkinouModeIdKbn.INPUTKEY.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))
            || C_KhkinouModeIdKbn.INPUT.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))
            || C_KhkinouModeIdKbn.TENKEN.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {

            if (C_KhkinouModeIdKbn.INPUTKEY.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {

                insIWKhSyoukenSaihakkouWk();
            }
            else {

                updateIWKhSyoukenSaihakkouWk();
            }
        }

        doJikouteikanri();

        messageManager.addMessageId(MessageId.IAC0009);

        if (!C_KhkinouModeIdKbn.SYOUNIN.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))
            || !C_SyorikekkaKbn.SYOUNIN.eq(uiBean.getSyorikekkakbn())
            || C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())) {
            uiBean.getKykKihon().detach();
        }
    }

    void pushUnlockProcessBL() {

        bzCommonLockProcess.unlockProcess();
    }

    void pushModoruBtnByConfirm() {
        bzCommonLockProcess.continueLockProcess();
    }

    private void checkKykSonzai() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());
        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        uiBean.setKykKihon(kykKihon);
    }

    private void checkYuukouJyoutai() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn cYuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(cYuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }

        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(cYuukoujyotaichkKbn)) {

            String warningMessage = "";
            String warningMessageID = "";
            List<String> warningMessageList = checkYuukouJyoutai.getWarningMessageList();
            List<String> warningMessageIDList = checkYuukouJyoutai.getWarningMessageIDList();

            for (int count = 0; count < warningMessageIDList.size(); count++) {

                warningMessage = warningMessageList.get(count);
                warningMessageID = warningMessageIDList.get(count);

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1
                    , warningMessageID
                    , warningMessage);
            }
        }
    }

    private void checkYuuyokkngai() {

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        if (!checkYuuyokkngai.exec(uiBean.getSyono(), BizDate.getSysDate())) {
            throw new BizLogicException(MessageId.EIA0085);
        }
    }


    private void hanteiTetuduki() {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        C_SyorikahiKbn cSyorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(cSyorikahiKbn)) {

            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(cSyorikahiKbn)) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1
                , hanteiTetuduki.getMessageID()
                , hanteiTetuduki.getMessageParam());
        }
    }


    private void setUiBean() {

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        SetKihon.exec(khozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(khozenCommonParam, uiBean);

        if (uiBean.getWarningMessageIdList().size() > 0) {

            for (int i = 0; i < uiBean.getWarningMessageIdList().size(); i++) {

                String warningMessageId = uiBean.getWarningMessageIdList().get(i);
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    BizUtil.getGeneralMessageId(warningMessageId),
                    uiBean.getWarningMessageList().get(i));

            }
        }

        SetTetudukityuui.exec(khozenCommonParam, uiBean);

        SetKeiyakusya.exec(khozenCommonParam, uiBean);

        SetTuusinsaki.exec(khozenCommonParam, uiBean);

        SetHihokensya.exec(khozenCommonParam, uiBean);

        SetHosyou setHosyou = SWAKInjector.getInstance(SetHosyou.class);
        setHosyou.exec(khozenCommonParam, uiBean);

        SetSonotaTk.exec(khozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(khozenCommonParam, uiBean);

        SetTrkKazoku.exec(khozenCommonParam, uiBean);

        SetKyksyadairi.exec(khozenCommonParam, uiBean);

        SetHituyouSyorui.exec(khozenCommonParam, uiBean);

        SetKhKbnPatternUtil setKhKbnPatternUtil = SWAKInjector.getInstance(SetKhKbnPatternUtil.class);

        uiBean.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        setKhKbnPatternUtil.exec(uiBean);
    }

    private void checkHenreikinMbr() {

        Long khHenreikinKensuu = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(uiBean.getSyono());

        if (khHenreikinKensuu > 0) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA1017);
        }
    }

    private void createTyouhyou(BizDate sinSyosaiSkYmd, KhozenCommonParam pKhozenCommonParam) {

        EditTtdkKanryouParam editTtdkKanryouParam = SWAKInjector.getInstance(EditTtdkKanryouParam.class);

        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.SYOSAIHK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);

        editHokenSyoukenParam.setSyoukenSaihk(uiBean.getSyoukensaihkkbn());
        editHokenSyoukenParam.setInsizeiShryouhi(uiBean.getInsizeishryouhikbn());
        if (C_SyoukensaihkKbn.SYOUKENSAIHAKKOU.eq(uiBean.getSyoukensaihkkbn())) {
            editHokenSyoukenParam.setCalckijyunYMD(BizDate.getSysDate());
        }
        else if (C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn())) {
            editHokenSyoukenParam.setCalckijyunYMD(uiBean.getKykKihon().getKykSyouhns().get(0).getKykymd());
        }

        KhTyokusouHantei khTyokusouHantei = SWAKInjector.getInstance(KhTyokusouHantei.class);
        C_TuutisakuseitaisyouKbn tuutisakuseitaisyouKbn = C_TuutisakuseitaisyouKbn.BLNK;
        List<TyokusouTaisyouBean> tyokusouTaisyouBeanList = new ArrayList<>();

        editHokenSyoukenParam.setTrkkzk1thkk(C_TyokusouhtkekKbn.BLNK);

        editHokenSyoukenParam.setTrkkzk2thkk(C_TyokusouhtkekKbn.BLNK);

        if (C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn()) &&
            (BizDateUtil.compareYmd(uiBean.getKykKihon().getMosymd(), BizDate.valueOf("20201001")) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(uiBean.getKykKihon().getMosymd(), BizDate.valueOf("20201001")) == BizDateUtil.COMPARE_EQUAL)) {

            List<IT_TrkKzk> trkKzkList = uiBean.getKykKihon().getTrkKzks();

            for (IT_TrkKzk trkKzk : trkKzkList) {

                TrkkzkTyokusouhtBean trkkzkTyokusouhtBean = SWAKInjector.getInstance(TrkkzkTyokusouhtBean.class);
                trkkzkTyokusouhtBean.setKijyunymd(uiBean.getVhsyusyukykymd());
                trkkzkTyokusouhtBean.setKykseiymd(uiBean.getVkykskykseiymd());
                trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(trkKzk.getTrkkzktsindousiteikbn());

                C_TyokusouhtkekKbn tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

                if (C_TyokusouhtkekKbn.TYOKUSOUTSY.eq(tyokusouhtkekKbn)) {

                    if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {

                        tuutisakuseitaisyouKbn = C_TuutisakuseitaisyouKbn.TRKKZK1;
                        editHokenSyoukenParam.setTrkkzk1thkk(C_TyokusouhtkekKbn.TYOKUSOUTSY);
                    }

                    if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {

                        tuutisakuseitaisyouKbn = C_TuutisakuseitaisyouKbn.TRKKZK2;
                        editHokenSyoukenParam.setTrkkzk2thkk(C_TyokusouhtkekKbn.TYOKUSOUTSY);
                    }

                    TyokusouTaisyouBean tyokusouTaisyouBean = SWAKInjector.getInstance(TyokusouTaisyouBean.class);
                    tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(tuutisakuseitaisyouKbn);
                    tyokusouTaisyouBean.setNmkj(trkKzk.getTrkkzknmkj());
                    tyokusouTaisyouBean.setSeiYmd(trkKzk.getTrkkzkseiymd());
                    tyokusouTaisyouBean.setYno(trkKzk.getTrkkzkyno());
                    tyokusouTaisyouBean.setAdr1kj(trkKzk.getTrkkzkadr1kj());
                    tyokusouTaisyouBean.setAdr2kj(trkKzk.getTrkkzkadr2kj());
                    tyokusouTaisyouBean.setAdr3kj(trkKzk.getTrkkzkadr3kj());
                    tyokusouTaisyouBean.setTelno(trkKzk.getTrkkzktelno());

                    tyokusouTaisyouBeanList.add(tyokusouTaisyouBean);
                }
                else {

                    if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {

                        editHokenSyoukenParam.setTrkkzk1thkk(C_TyokusouhtkekKbn.TYOKUSOUTSYGAI);
                    }

                    if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {

                        editHokenSyoukenParam.setTrkkzk2thkk(C_TyokusouhtkekKbn.TYOKUSOUTSYGAI);
                    }
                }
            }
        }

        List<C_SyoruiCdKbn> syoruiCdKbnList = new ArrayList<>();
        if (C_SyoukensaihkKbn.SYOUKENSAIHAKKOU.eq(uiBean.getSyoukensaihkkbn())) {

            syoruiCdKbnList.add(C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR);
            syoruiCdKbnList.add(C_SyoruiCdKbn.KK_HKNSYKN);
        }
        else {

            syoruiCdKbnList.add(C_SyoruiCdKbn.KK_HKNSYKN);
        }

        EditKoujyoSyoumeiParam editKoujyoSyoumeiParam = SWAKInjector.getInstance(EditKoujyoSyoumeiParam.class);

        C_Hrkkaisuu hrkkaisuu = uiBean.getKykKihon().getHrkkaisuu();

        String syouhncd = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getSyouhncd();

        BizDate kykymd = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0).getKykymd();

        C_UmuKbn zeiseitkkktkykhukaumu = uiBean.getKykKihon().getKykSonotaTkyk().getZeiseitkkktkykhukaumu();

        Boolean koujyoSymflg = true;

        int syouhnhanteiKbn = SyouhinUtil.hantei(syouhncd);

        if (syouhnhanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (C_UmuKbn.ARI.eq(zeiseitkkktkykhukaumu) ||
                (C_Hrkkaisuu.TUKI.eq(hrkkaisuu) && kykymd.compareTo(BizDate.valueOf(kykymd.getYear(), 8, 31)) <= 0)) {

                koujyoSymflg = false;
            }
        }
        else if (syouhnhanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            if (C_Hrkkaisuu.TUKI.eq(uiBean.getKykKihon().getHrkkaisuu()) &&
                (C_UmuKbn.ARI.eq(uiBean.getKykKihon().getKykSonotaTkyk().getYennykntkhkumu()) ||
                    (!C_UmuKbn.ARI.eq(uiBean.getKykKihon().getKykSonotaTkyk().getYennykntkhkumu()) &&
                        kykymd.compareTo(BizDate.valueOf(kykymd.getYear(), 8, 31)) <= 0))) {

                koujyoSymflg = false;
            }
        }

        if (C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn()) &&
            koujyoSymflg == true) {

            String koujyoNendo = uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(
                C_SyutkKbn.SYU).get(0).getKykymd().getBizDateY().toString();

            IT_KoujyoSym koujyoSym = new SortIT_KoujyoSym().OrderIT_KoujyoSymByPkDesc(
                uiBean.getKykKihon().getKoujyoSymsByNendoRenno(koujyoNendo, 1)).get(0);

            editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
            editKoujyoSyoumeiParam.setKoujyoNendo(koujyoNendo);
            editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
            editKoujyoSyoumeiParam.setKoujyoSakuseiSyoriKbn(C_KoujyosyoumeisakuseisyoriKbn.HOKENSYOUKEN);
            editKoujyoSyoumeiParam.setSyoumeiYmd(sinSyosaiSkYmd);
            editKoujyoSyoumeiParam.setHrkkaisuu(uiBean.getKykKihon().getHrkkaisuu());
            editKoujyoSyoumeiParam.setTekiyouSeidoKbn(koujyoSym.getTekiyouseidokbn());
            editKoujyoSyoumeiParam.setSyoumeiStartYm(koujyoSym.getSyoumeistartym());
            editKoujyoSyoumeiParam.setSyoumeiEndYm(koujyoSym.getSyoumeiendym());
            editKoujyoSyoumeiParam.setNewIppanJissekiP(koujyoSym.getNewippanjissekip());
            editKoujyoSyoumeiParam.setNewIppanNenkanP(koujyoSym.getNewippannenkanp());
            editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(koujyoSym.getNewippanjissekihaitoukin());
            editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(koujyoSym.getNewippannenkanhaitoukin());
            editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(koujyoSym.getNewippanjissekisyoumeigk());
            editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(koujyoSym.getNewippannenkansyoumeigk());
            editKoujyoSyoumeiParam.setNewIryouJissekiP(koujyoSym.getNewiryoujissekip());
            editKoujyoSyoumeiParam.setNewIryouNenkanP(koujyoSym.getNewiryounenkanp());
            editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(koujyoSym.getNewiryoujissekihaitoukin());
            editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(koujyoSym.getNewiryounenkanhaitoukin());
            editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(koujyoSym.getNewiryoujissekisyoumeigk());
            editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(koujyoSym.getNewiryounenkansyoumeigk());
            editKoujyoSyoumeiParam.setNewNenkinJissekiP(koujyoSym.getNewnkjissekip());
            editKoujyoSyoumeiParam.setNewNenkinNenkanP(koujyoSym.getNewnknenkanp());
            editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(koujyoSym.getNewnkjissekihaitoukin());
            editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(koujyoSym.getNewnknenkanhaitoukin());
            editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(koujyoSym.getNewnkjissekisyoumeigk());
            editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(koujyoSym.getNewnknenkansyoumeigk());
            syoruiCdKbnList.add(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS);
        }

        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
        khozenTyouhyouCtl.setEditHokenSyoukenParam(editHokenSyoukenParam);
        khozenTyouhyouCtl.setHassoukbn(uiBean.getHassoukbn());

        if (C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(uiBean.getSyoukensaihkkbn()) &&
            koujyoSymflg == true) {

            khozenTyouhyouCtl.setEditKoujyoSyoumeiParam(editKoujyoSyoumeiParam);
            khozenTyouhyouCtl.setSyoriYmd(BizDate.getSysDate());
        }

        khozenTyouhyouCtl.createTyouhyouTBL(pKhozenCommonParam, uiBean.getSyono(),
            syoruiCdKbnList.toArray(new C_SyoruiCdKbn[0]), C_YouhiKbn.HUYOU);
        uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        uiBean.setTyouhyoukey(khozenTyouhyouCtl.getTyouhyouKey());

        if (tyokusouTaisyouBeanList.size() > 0 ) {

            BizDate sysDate = BizDate.getSysDate();

            IT_KykUkt kykUkt_kykdrn = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.KYKDRN, 1);

            IT_KykUkt kykUkt_hhkdrn = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

            IT_HokenSyouken hokenSyouken = uiBean.getKykKihon().getHokenSyoukenByTyouhyouymd(sysDate);

            C_HassouKbn hassouKbn = hokenSyouken.getHassoukbn();

            if (YAKKANDOUFU.equals(hokenSyouken.getSagyoukbn())) {

                hassouKbn = C_HassouKbn.TYOKUSOU;
            }

            EditSkYouTtdkKanryouTbl editSkYouTtdkKanryouTbl = SWAKInjector.getInstance(EditSkYouTtdkKanryouTbl.class);

            editSkYouTtdkKanryouTbl.exec(pKhozenCommonParam,
                uiBean.getKykKihon(),
                uiBean.getKykKihon().getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU),
                uiBean.getKykKihon().getKykSya(),
                uiBean.getKykKihon().getKykSonotaTkyk(),
                kykUkt_kykdrn,
                kykUkt_hhkdrn,
                sysDate,
                hassouKbn,
                tyokusouTaisyouBeanList);
        }
    }

    private void doJikouteikanri() {

        KhRuleBean khRuleBean = SWAKInjector.getInstance(KhRuleBean.class);

        khRuleBean.setSyoriKekkaKbn(uiBean.getSyorikekkakbn());
        khRuleBean.setSasimodosisakiKbn(uiBean.getSasimodosisakikbn());
        khRuleBean.setSaiwariateUserId("");

        String commnet = uiBean.getSyanaicommentkh();

        KhProcessForward khProcessForward = SWAKInjector.getInstance(KhProcessForward.class);

        khProcessForward.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            bzCommonLockProcess.getKouteiLockKey(),
            commnet,
            khRuleBean);

        bzCommonLockProcess.unlockProcess();
    }

    @Transactional
    void iwfOpenBL() {

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getKouteiKanriId(), uiBean.getBzWorkflowInfo()
            .getJimuTetuzukiCd());

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
            uiBean.getBzWorkflowInfo().getKouteiKanriId());

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());
        uiBean.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        checkKykSonzai();

        checkYuukouJyoutai();

        checkYuuyokkngai();

        hanteiTetuduki();

        setUiBean();

        IW_KhSyoukenSaihakkouWk iwKhSyoukenSaihakkouWk =
            hozenDomManager.getKhSyoukenSaihakkouWk(uiBean.getKouteikanriid());

        if (iwKhSyoukenSaihakkouWk == null) {

            throw new CommonBizAppException(IW_KhSyoukenSaihakkouWk.TABLE_NAME.concat("  取得エラー"));
        }

        uiBean.setSyoukensaihkkbn(iwKhSyoukenSaihakkouWk.getSyoukensaihkkbn());
        uiBean.setInsizeishryouhikbn(iwKhSyoukenSaihakkouWk.getInsizeishryouhikbn());
        uiBean.setHonninkakninkekkakbn(iwKhSyoukenSaihakkouWk.getHonninkakninkekkakbn());
        uiBean.setHassoukbn(iwKhSyoukenSaihakkouWk.getHassoukbn());
        uiBean.setZenkaisyorikekkakbn(iwKhSyoukenSaihakkouWk.getZenkaisyorikekkakbn());

        if (C_SyorikekkaKbn.TORIKESI.eq(uiBean.getZenkaisyorikekkakbn())
            && C_KhkinouModeIdKbn.SYOUNIN.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIC0001, uiBean
                .getZenkaisyorikekkakbn().getContent());
        }

        checkHenreikinMbr();

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean);

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        setProgressHistory.exec(uiBean);
    }

    private void insIWKhSyoukenSaihakkouWk() {

        IW_KhSyoukenSaihakkouWk iwKhSyoukenSaihakkouWk = new IW_KhSyoukenSaihakkouWk();

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

            iwKhSyoukenSaihakkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        iwKhSyoukenSaihakkouWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        iwKhSyoukenSaihakkouWk.setSyono(uiBean.getSyono());
        iwKhSyoukenSaihakkouWk.setSyoukensaihkkbn(uiBean.getSyoukensaihkkbn());
        iwKhSyoukenSaihakkouWk.setInsizeishryouhikbn(uiBean.getInsizeishryouhikbn());
        iwKhSyoukenSaihakkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
        iwKhSyoukenSaihakkouWk.setHassoukbn(uiBean.getHassoukbn());

        KhozenCommonParam KhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        iwKhSyoukenSaihakkouWk.setGyoumuKousinKinou(KhozenCommonParam.getFunctionId());
        iwKhSyoukenSaihakkouWk.setGyoumuKousinsyaId(KhozenCommonParam.getUserID());
        iwKhSyoukenSaihakkouWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(iwKhSyoukenSaihakkouWk);

        hozenDomManager.insert(iwKhSyoukenSaihakkouWk);
    }

    private void insIWKhSyoukenSaihakkouWkSks() {

        IW_KhSyoukenSaihakkouWk iwKhSyoukenSaihakkouWk = new IW_KhSyoukenSaihakkouWk();

        iwKhSyoukenSaihakkouWk.setKouteikanriid(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        iwKhSyoukenSaihakkouWk.setSyono(uiBean.getSyono());
        iwKhSyoukenSaihakkouWk.setSkssakuseiymd(BizDate.getSysDate());
        KhozenCommonParam KhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        iwKhSyoukenSaihakkouWk.setGyoumuKousinKinou(KhozenCommonParam.getFunctionId());
        iwKhSyoukenSaihakkouWk.setGyoumuKousinsyaId(KhozenCommonParam.getUserID());
        iwKhSyoukenSaihakkouWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(iwKhSyoukenSaihakkouWk);

        hozenDomManager.insert(iwKhSyoukenSaihakkouWk);
    }

    private void updateIWKhSyoukenSaihakkouWk() {

        IW_KhSyoukenSaihakkouWk iwKhSyoukenSaihakkouWk =
            hozenDomManager.getKhSyoukenSaihakkouWk(uiBean.getBzWorkflowInfo().getKouteiKanriId());

        if (!C_SyorikekkaKbn.HORYUU.eq(uiBean.getSyorikekkakbn())) {

            iwKhSyoukenSaihakkouWk.setZenkaisyorikekkakbn(uiBean.getSyorikekkakbn());
        }

        KhozenCommonParam KhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        iwKhSyoukenSaihakkouWk.setGyoumuKousinKinou(KhozenCommonParam.getFunctionId());
        iwKhSyoukenSaihakkouWk.setGyoumuKousinsyaId(KhozenCommonParam.getUserID());
        iwKhSyoukenSaihakkouWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        if (!C_KhkinouModeIdKbn.SYOUNIN.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))
            && !C_SyorikekkaKbn.TORIKESI.eq(uiBean.getSyorikekkakbn())
            && !C_SyorikekkaKbn.SASIMODOSI.eq(uiBean.getSyorikekkakbn())) {

            iwKhSyoukenSaihakkouWk.setSyoukensaihkkbn(uiBean.getSyoukensaihkkbn());
            iwKhSyoukenSaihakkouWk.setInsizeishryouhikbn(uiBean.getInsizeishryouhikbn());
            iwKhSyoukenSaihakkouWk.setHonninkakninkekkakbn(uiBean.getHonninkakninkekkakbn());
            iwKhSyoukenSaihakkouWk.setHassoukbn(uiBean.getHassoukbn());

        }

        hozenDomManager.update(iwKhSyoukenSaihakkouWk);
    }
}
