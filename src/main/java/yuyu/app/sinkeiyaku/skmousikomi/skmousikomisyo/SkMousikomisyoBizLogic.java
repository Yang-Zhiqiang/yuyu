package yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo;

import static yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.GenSkMousikomisyoConstants.*;
import static yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoConstants.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.ObjectUtil;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import net.arnx.jsonic.JSON;

import org.apache.commons.validator.GenericValidator;
import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai.SkNyuuryokuSaiSyoukaiRenkeiInfo;
import yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoConstants.E_CreditCardhnsyuKbn;
import yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoConstants.E_InsUpdKbn;
import yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoConstants.E_SyoriKbn;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzcommon.MousikomiNoCheck;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzcommon.TuikaParamInputBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfoJimusyo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoKinyuuKikan;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBstrkno;
import yuyu.common.biz.bzdairiten.BzGetBsInfoKouin;
import yuyu.common.biz.bznayose.BzTrksIraiKekkaBean;
import yuyu.common.biz.bznayose.BzTrksIraiMq;
import yuyu.common.biz.bznayose.BzTrksIraiYokenBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.exception.IntentionalRollbackException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CheckKzhuriKouza;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuu;
import yuyu.common.hozen.khcommon.SaibanCreditKessaiyouNo;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreate;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomisyoNyuuryoku;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairiten;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumoku;
import yuyu.common.sinkeiyaku.moschk.SetSknnkaisiymd;
import yuyu.common.sinkeiyaku.skcommon.CheckShiharaikinSiteiKouza;
import yuyu.common.sinkeiyaku.skcommon.DrtenTkykTratkiHantei;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhou;
import yuyu.common.sinkeiyaku.skcommon.GetDairitenKobetuJyouhouBean;
import yuyu.common.sinkeiyaku.skcommon.GetHknsyuruinm;
import yuyu.common.sinkeiyaku.skcommon.GetMosGamenctrl;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.common.sinkeiyaku.skcommon.GetSyouhnZokuseiCtrlInBean;
import yuyu.common.sinkeiyaku.skcommon.GetSyouhnZokuseiCtrlOutBean;
import yuyu.common.sinkeiyaku.skcommon.HknsyuruinmBean;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SaiDataSyutoku;
import yuyu.common.sinkeiyaku.skcommon.SaiDataTouroku;
import yuyu.common.sinkeiyaku.skcommon.SetMossykykyoteiymd;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.sinkeiyaku.skcommon.SyoukenNoUtil;
import yuyu.common.sinkeiyaku.skcommon.TsRrkInfoTouroku;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HandketsijiKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_Nstkumu;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_SinkihnkKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SosikiYuuksHantKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkykTratkiKbn;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_BosDairiten;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.entity.HT_BosKouzaJyouhou;
import yuyu.def.db.entity.HT_BosSyouhn;
import yuyu.def.db.entity.HT_BosTrkKzk;
import yuyu.def.db.entity.HT_BosUketoriKouzaJyouhou;
import yuyu.def.db.entity.HT_BosUketorinin;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_HenteiRireki;
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_ImuSonotaTkykJktk;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_ImusateiSyouhnTokujyou;
import yuyu.def.db.entity.HT_ImusateiTokujyou;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_KokutisyoVrf;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_KouzaJyouhouVrf;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosDairitenVrf;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosKihonVrf;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosSyouhnVrf;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_MosTrkKzkVrf;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkLincSyoukaikekka;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.entity.HT_SonotaTkykJktk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_SyouhnTokujyou;
import yuyu.def.db.entity.HT_Tokujyou;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.entity.HT_Tuusan;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhouVrf;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.db.entity.HT_UketorininVrf;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosSyouhn;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 申込書入力 のビジネスロジックです。
 */
public class SkMousikomisyoBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkMousikomisyoUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageMgr;

    @Inject
    private SaiDataSyutoku saiDataSyutoku;

    @Inject
    private SkNyuuryokuSaiSyoukaiRenkeiInfo skNyuuryokuSaiSyoukaiRenkeiInfo;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private TsRrkInfoTouroku tsRrkInfoTouroku;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SaiDataTouroku saiDataTouroku;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private ObjStorageManager objStrMan;

    @Inject
    private KinouMode kinouMode;

    private boolean unlockFlg = true;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam2;

    void init() {
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
        BizPropertyInitializer.initialize(uiBean);
    }

    @Transactional
    void iwfOpenBL() {
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        if (ISkCommonKoumoku.NODEID_MOSNYUURYOKU_1JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            uiBean.setSyoriKbn(E_SyoriKbn.MOUSIKOMISYO_1JI);

            kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOUSIKOMISYO_1JI.toString());
        }
        else if (ISkCommonKoumoku.NODEID_MOSNYUURYOKU_2JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            uiBean.setSyoriKbn(E_SyoriKbn.MOUSIKOMISYO_2JI);

            kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOUSIKOMISYO_2JI.toString());
        }
        else if (ISkCommonKoumoku.NODEID_MOSNYUURYOKU_3JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            uiBean.setSyoriKbn(E_SyoriKbn.MOUSIKOMISYO_3JI);

            kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOUSIKOMISYO_3JI.toString());
        }

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        String kinouModeId = kinouMode.getKinouMode();

        boolean kengenWithBoolean = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouModeId);

        if (!kengenWithBoolean) {

            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0);

        uiBean.setMosno(bzGetProcessSummaryOutBean.getMosNo());
        uiBean.setSkeijimuKbn(bzGetProcessSummaryOutBean.getSkeijimuKbn());
        uiBean.setMosuketukekbn(bzGetProcessSummaryOutBean.getMosUketukeKbn());
        uiBean.setHknsyuruinomosinput(bzGetProcessSummaryOutBean.getHknsyuruiNo().getValue());
        uiBean.setInitHokenSyuruiNo(uiBean.getHknsyuruino());

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn())) {
            uiBean.setJimuyoucd(bzGetProcessSummaryOutBean.getJimuyoucd());
        }

        String mosNo = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        setMousikomiDispUmu();

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn())) {
            if (syoriCTL != null) {
                uiBean.setSyoriCTL(syoriCTL);

                doMosNoCheck(mosNo);

                if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                    checkMousikomiNo();
                }
                uiBean.setInsUpdKbn(E_InsUpdKbn.INSUPDCTRL_UPD);

                checkSinkiSyoriCTL(syoriCTL);

                C_VrfjkKbn vrfJkKbn = syoriCTL.getMosnrkvrfjkkbn();
                if (!C_VrfjkKbn.TSHN_MIJISSI.eq(vrfJkKbn)) {
                    throw new BizLogicException(MessageId.EHA0349, vrfJkKbn.getContent());
                }
            }
            else {
                doMosNoCheck(mosNo);

                if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                    checkMousikomiNo();
                }

                uiBean.setInsUpdKbn(E_InsUpdKbn.INSUPDCTRL_INS);
            }

            lockProcessGetProcessInfoWorkList();

            setSelectLstForInputContents();

            uiBean.setZenkizennouumumosinput(C_BlnktkumuKbn.NONE.toString());

            setSinkiBosInfo(mosNo);
        }
        else if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn())) {
            if (syoriCTL == null) {
                throw new BizLogicException(MessageId.EBA0090);
            }

            uiBean.setSyoriCTL(syoriCTL);
            uiBean.setInsUpdKbn(E_InsUpdKbn.INSUPDCTRL_UPD);

            checkSinkiSyoriCTL(syoriCTL);

            C_VrfjkKbn vrfJkKbn = syoriCTL.getMosnrkvrfjkkbn();
            if (!C_VrfjkKbn.NIJINRKMATI.eq(vrfJkKbn)) {
                throw new BizLogicException(MessageId.EHA0349, vrfJkKbn.getContent());
            }

            BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId(),
                baseUserInfo.getUserId());
            if (wariateHukaInfo != null) {
                throw new BizLogicException(MessageId.EHA0350);
            }

            lockProcessGetProcessInfoWorkList();

            setSelectLstForInputContents();

            HT_MosKihonVrf mosKihonVrf = syoriCTL.getMosKihonVrf();
            uiBean.setKhnchkcmnt(mosKihonVrf.getKhnchkcmnt());
            uiBean.setZenkizennouumumosinput(C_BlnktkumuKbn.NONE.toString());
            setSinkiBosInfo(mosNo);
        }
        else if (E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
            if (syoriCTL == null) {
                throw new BizLogicException(MessageId.EBA0090);
            }

            uiBean.setSyoriCTL(syoriCTL);
            uiBean.setInsUpdKbn(E_InsUpdKbn.INSUPDCTRL_UPD);

            checkSinkiSyoriCTL(syoriCTL);

            C_VrfjkKbn vrfJkKbn = syoriCTL.getMosnrkvrfjkkbn();
            if (!C_VrfjkKbn.SANJINRKMATI.eq(vrfJkKbn)) {
                throw new BizLogicException(MessageId.EHA0349, vrfJkKbn.getContent());
            }

            BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId(),
                baseUserInfo.getUserId());
            if (wariateHukaInfo != null) {
                throw new BizLogicException(MessageId.EHA1001);
            }

            lockProcessGetProcessInfoWorkList();

            setSelectLstForInputContents();

            if (!C_MosUketukeKbn.PAPERLESS.eq(uiBean.getMosuketukekbn())) {
                int saidataUmu = saiDataSyutoku.findSaiData(mosNo, ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);
                if (saidataUmu == SaiDataSyutoku.SYUTOKUDATA_NASI) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                List<String> nrkSouiKmLst = saiDataSyutoku.getNrksouikmList();
                List<String> itijiNrkLst = saiDataSyutoku.getItijinrkList();
                List<String> nijiNrkLst = saiDataSyutoku.getNijinrkList();

                skNyuuryokuSaiSyoukaiRenkeiInfo.setMosno(mosNo);
                skNyuuryokuSaiSyoukaiRenkeiInfo.setAitemosno(uiBean.getAitemosno());
                skNyuuryokuSaiSyoukaiRenkeiInfo.setNrksouikm(nrkSouiKmLst.toArray(new String[nrkSouiKmLst.size()]));
                skNyuuryokuSaiSyoukaiRenkeiInfo.setItijinrk(itijiNrkLst.toArray(new String[itijiNrkLst.size()]));
                skNyuuryokuSaiSyoukaiRenkeiInfo.setNijinrk(nijiNrkLst.toArray(new String[nijiNrkLst.size()]));

                String uniqueId = objStrMan.save(skNyuuryokuSaiSyoukaiRenkeiInfo);

                uiBean.setUniqueId(uniqueId);
                uiBean.setNrksaiumu(SaiDataTouroku.NRKSAIARI);
            }

            uiBean.setDaimosno(syoriCTL.getDaimosno());
            uiBean.setTkhsyouryakuumukbn(syoriCTL.getTkhsyouryakuumukbn());

            HT_MosKihon mosKihon = syoriCTL.getMosKihon();
            if (mosKihon == null) {
                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            setUiBeanFromMosKihon(mosKihon, E_SyoriKbn.MOUSIKOMISYO_3JI);

            List<HT_MosSyouhn> mosSyouhnSyuLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
            if (mosSyouhnSyuLst.size() == 0) {
                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            setUiBeanFromMosSyouhnSyuKeiyaku(mosSyouhnSyuLst.get(0));

            List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

            if (uketorininLst != null) {
                setUiBeanFromUketorinin(uketorininLst);
            }

            List<HT_MosTrkKzk> mosTrkKzkLst = syoriCTL.getMosTrkKzks();

            if (mosTrkKzkLst.size() > 0) {
                setUiBeanFromMosTrkKzk(mosTrkKzkLst);
            }

            List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
            setUiBeanFromMosDairiten(mosDairitenLst, E_SyoriKbn.MOUSIKOMISYO_3JI);

            HT_UketoriKouzaJyouhou uketoriKouzaJyouhou =
                syoriCTL.getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);
            if (uketoriKouzaJyouhou != null) {
                setUiBeanFromUketoriKouzaJyouhou(uketoriKouzaJyouhou);
            }

            setUiBeanFromSyorictl(syoriCTL);

            HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();

            if (kouzaJyouhou != null) {

                setUiBeanFromKouzaJyouhou(kouzaJyouhou);
            }

            chkWarning(null);
            startTask();
        }

        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    @Transactional
    void pushAddFstBL() {
        String mosNo = uiBean.getMosno();

        uiBean.setSyoriKbn(E_SyoriKbn.MOUSIKOMISYO_1JI);

        kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOUSIKOMISYO_1JI.toString());

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        String kinouModeId = kinouMode.getKinouMode();

        boolean kengenWithBoolean = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouModeId);

        if (!kengenWithBoolean) {

            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));
        }

        setMousikomiDispUmu();

        setSelectLstForInputContents();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL != null) {
            uiBean.setSyoriCTL(syoriCTL);
            uiBean.setInsUpdKbn(E_InsUpdKbn.INSUPDCTRL_UPD);

            checkSinkiSyoriCTL(syoriCTL);

            if (C_MosUketukeKbn.PAPERLESS.eq(uiBean.getMosuketukekbn())) {
                throw new BizLogicException(MessageId.EHA1050);
            }

            C_VrfjkKbn vrfJkKbn = syoriCTL.getMosnrkvrfjkkbn();
            if (!C_VrfjkKbn.TSHN_MIJISSI.eq(vrfJkKbn)) {
                throw new BizLogicException(MessageId.EHA0349, vrfJkKbn.getContent());
            }
        }
        else {
            doMosNoCheck(mosNo);

            if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                checkMousikomiNo();
            }

            uiBean.setInsUpdKbn(E_InsUpdKbn.INSUPDCTRL_INS);
        }

        lockProcessGetProcessInfoMenu();

        uiBean.setZenkizennouumumosinput(C_BlnktkumuKbn.NONE.toString());

        setSinkiBosInfo(mosNo);
    }

    @Transactional
    void pushAddSecBL() {
        String mosNo = uiBean.getMosno();

        uiBean.setSyoriKbn(E_SyoriKbn.MOUSIKOMISYO_2JI);

        kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOUSIKOMISYO_2JI.toString());

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        String kinouModeId = kinouMode.getKinouMode();

        boolean kengenWithBoolean = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouModeId);

        if (!kengenWithBoolean) {

            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));
        }

        setMousikomiDispUmu();

        setSelectLstForInputContents();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setSyoriCTL(syoriCTL);
        uiBean.setInsUpdKbn(E_InsUpdKbn.INSUPDCTRL_UPD);

        checkSinkiSyoriCTL(syoriCTL);

        if (C_MosUketukeKbn.PAPERLESS.eq(uiBean.getMosuketukekbn())) {
            throw new BizLogicException(MessageId.EHA1050);
        }

        C_VrfjkKbn vrfJkKbn = syoriCTL.getMosnrkvrfjkkbn();
        if (!C_VrfjkKbn.NIJINRKMATI.eq(vrfJkKbn)) {
            throw new BizLogicException(MessageId.EHA0349, vrfJkKbn.getContent());
        }

        lockProcessGetProcessInfoMenu();

        BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            baseUserInfo.getUserId());

        if (wariateHukaInfo != null) {
            throw new BizLogicException(MessageId.EHA0350);
        }

        HT_MosKihonVrf mosKihonVrf = syoriCTL.getMosKihonVrf();
        uiBean.setKhnchkcmnt(mosKihonVrf.getKhnchkcmnt());

        uiBean.setZenkizennouumumosinput(C_BlnktkumuKbn.NONE.toString());

        setSinkiBosInfo(mosNo);
    }

    @Transactional
    void pushAddThirdBL() {
        String mosNo = uiBean.getMosno();

        uiBean.setSyoriKbn(E_SyoriKbn.MOUSIKOMISYO_3JI);

        kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOUSIKOMISYO_3JI.toString());

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        String kinouModeId = kinouMode.getKinouMode();

        boolean kengenWithBoolean = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouModeId);

        if (!kengenWithBoolean) {

            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));
        }

        setMousikomiDispUmu();

        setSelectLstForInputContents();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        uiBean.setSyoriCTL(syoriCTL);
        uiBean.setInsUpdKbn(E_InsUpdKbn.INSUPDCTRL_UPD);

        checkSinkiSyoriCTL(syoriCTL);

        C_VrfjkKbn vrfJkKbn = syoriCTL.getMosnrkvrfjkkbn();
        if (!C_VrfjkKbn.SANJINRKMATI.eq(vrfJkKbn)) {
            throw new BizLogicException(MessageId.EHA0349, vrfJkKbn.getContent());
        }

        lockProcessGetProcessInfoMenu();

        BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            baseUserInfo.getUserId());

        if (wariateHukaInfo != null) {
            throw new BizLogicException(MessageId.EHA1001);
        }

        if (!C_MosUketukeKbn.PAPERLESS.eq(uiBean.getMosuketukekbn())) {
            int kekka = saiDataSyutoku.findSaiData(mosNo, ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);
            if (kekka == SaiDataSyutoku.SYUTOKUDATA_NASI) {
                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            List<String> nrksouikmLst = saiDataSyutoku.getNrksouikmList();
            List<String> itijinrkList = saiDataSyutoku.getItijinrkList();
            List<String> nijinrkLst = saiDataSyutoku.getNijinrkList();

            skNyuuryokuSaiSyoukaiRenkeiInfo.setMosno(mosNo);
            skNyuuryokuSaiSyoukaiRenkeiInfo.setAitemosno(uiBean.getAitemosno());
            skNyuuryokuSaiSyoukaiRenkeiInfo.setNrksouikm(nrksouikmLst.toArray(new String[nrksouikmLst.size()]));
            skNyuuryokuSaiSyoukaiRenkeiInfo.setItijinrk(itijinrkList.toArray(new String[itijinrkList.size()]));
            skNyuuryokuSaiSyoukaiRenkeiInfo.setNijinrk(nijinrkLst.toArray(new String[nijinrkLst.size()]));

            String uniqueId = objStrMan.save(skNyuuryokuSaiSyoukaiRenkeiInfo);

            uiBean.setUniqueId(uniqueId);
            uiBean.setNrksaiumu(SaiDataTouroku.NRKSAIARI);
        }

        uiBean.setDaimosno(syoriCTL.getDaimosno());
        uiBean.setTkhsyouryakuumukbn(syoriCTL.getTkhsyouryakuumukbn());

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        setUiBeanFromMosKihon(mosKihon, E_SyoriKbn.MOUSIKOMISYO_3JI);

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst.isEmpty()) {
            throw new CommonBizAppException("申込番号=" + mosNo + " 主契約・特約区分=主契約");
        }

        setUiBeanFromMosSyouhnSyuKeiyaku(mosSyouhnLst.get(0));

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

        if (uketorininLst != null) {
            setUiBeanFromUketorinin(uketorininLst);
        }

        List<HT_MosTrkKzk> mosTrkKzkLst = syoriCTL.getMosTrkKzks();

        if (mosTrkKzkLst.size() > 0) {
            setUiBeanFromMosTrkKzk(mosTrkKzkLst);
        }

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
        setUiBeanFromMosDairiten(mosDairitenLst, E_SyoriKbn.MOUSIKOMISYO_3JI);

        HT_UketoriKouzaJyouhou uketoriKouzaJyouhou =
            syoriCTL.getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);

        if (uketoriKouzaJyouhou != null) {
            setUiBeanFromUketoriKouzaJyouhou(uketoriKouzaJyouhou);
        }

        setUiBeanFromSyorictl(syoriCTL);

        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();

        if (kouzaJyouhou != null) {

            setUiBeanFromKouzaJyouhou(kouzaJyouhou);
        }

        chkWarning(null);
        startTask();
    }

    void pushUpdBL() {
        uiBean.setSyoriKbn(E_SyoriKbn.SYORI_UPD);

        kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOUSIKOMISYO_UPD.toString());

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        String kinouModeId = kinouMode.getKinouMode();

        boolean kengenWithBoolean = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouModeId);

        if (!kengenWithBoolean) {

            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));
        }

        pushNotAddBL();
    }

    void pushUpdSyoukaiBL() {
        uiBean.setSyoriKbn(E_SyoriKbn.SYORI_UPD_SYOUKAI);

        kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOUSIKOMISYO_SYOUKAI.toString());

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        String kinouModeId = kinouMode.getKinouMode();

        boolean kengenWithBoolean = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouModeId);

        if (!kengenWithBoolean) {

            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));
        }

        pushNotAddBL();
    }

    void pushInputUpdBL() {
        uiBean.setSyoriKbn(E_SyoriKbn.SYORI_INPUT_UPD);

        kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOUSIKOMISYO_INS_UPD.toString());

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        String kinouModeId = kinouMode.getKinouMode();

        boolean kengenWithBoolean = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouModeId);

        if (!kengenWithBoolean) {

            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));
        }

        pushNotAddBL();
    }

    void pushKakuninBL() {
        doContinueLockProcess();

        uiBean.setTaihisbuktbnwari1(uiBean.getSbuktbnwari1());
        uiBean.setTaihisyudai1hknkkn(uiBean.getSyudai1hknkknmosinput());
        uiBean.setTaihidairitenbuntanwariai1(uiBean.getDairitenbuntanwariai1());

        initUiBean1();
        initUiBean2();
        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();
        check(getSyouhnZokuseiCtrlOutBean);

        //        checkZero();

        List<String> kakuninmessage = Lists.newArrayList();
        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn())
            || E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn())
            || E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
            messageMgr.addMessageId(MessageId.QAC0008);
            kakuninmessage.add(MessageUtil.getMessage(MessageId.QAC0008));
        }
        if (E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn())) {
            messageMgr.addMessageId(MessageId.QHA0004);
            kakuninmessage.add(MessageUtil.getMessage(MessageId.QHA0004));
        }
        if (E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) {
            messageMgr.addMessageId(MessageId.QHA0005);
        }
        if (E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn())) {
            messageMgr.addMessageId(MessageId.QHA0006);
            kakuninmessage.add(MessageUtil.getMessage(MessageId.QHA0006));
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getSyokugyoukktumu()) &&
            uiBean.getKktymd() == null) {
            String message = MessageUtil.getMessage(DDID_HIHOKENSYAINFO_KKTYMD.getErrorResourceKey());
            messageMgr.addMessageId(MessageId.WBF0162,message);
            kakuninmessage.add(MessageUtil.getMessage(MessageId.WBF0162, message));
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getNkuktumu()) &&
            C_UktKbn.BLNK.eq(uiBean.getNenkinuktkbn())) {
            String message = MessageUtil.getMessage(DDID_NENKINUKETORINININFO_NENKINUKTKBN.getErrorResourceKey());
            messageMgr.addMessageId(MessageId.WBF0162,message);
            kakuninmessage.add(MessageUtil.getMessage(MessageId.WBF0162, message));
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getNkhknumu()) &&
            C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getItijibrumu()) &&
            "0".equals(uiBean.getSueokikknmosinput())) {
            String message = MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_SUEOKIKKNMOSINPUT.getErrorResourceKey());
            messageMgr.addMessageId(MessageId.WBF0162,message);
            kakuninmessage.add(MessageUtil.getMessage(MessageId.WBF0162, message));
        }

        if ((E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) &&
            C_MosUketukeKbn.PAPERLESS.eq(uiBean.getMosuketukekbn()) &&
            C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) {

            if (C_KzhuritourokuhouKbn.QR.eq(uiBean.getKzhuritourokuhoukbn())) {
                if (C_KzhuritourokuhouKbn.QR.eq(uiBean.getInitKzhuritourokuhoukbn()) &&
                    C_UmuKbn.NONE.eq(uiBean.getSyoriCTL().getKznrkumu()) &&
                    C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getKouzainfoinputhoryuukbn())) {

                    messageMgr.addMessageId(MessageId.WHA1008);
                    kakuninmessage.add(MessageUtil.getMessage(MessageId.WHA1008));
                }
                if (C_KzhuritourokuhouKbn.SYOMEN.eq(uiBean.getInitKzhuritourokuhoukbn())) {

                    messageMgr.addMessageId(MessageId.WHA1009, uiBean.getKzhuritourokuhoukbn().getContent());
                    kakuninmessage.add(MessageUtil.getMessage(MessageId.WHA1009, uiBean.getKzhuritourokuhoukbn().getContent()));
                }
            }
            if (C_KzhuritourokuhouKbn.SYOMEN.eq(uiBean.getKzhuritourokuhoukbn()) &&
                C_KzhuritourokuhouKbn.QR.eq(uiBean.getInitKzhuritourokuhoukbn())) {

                messageMgr.addMessageId(MessageId.WHA1009, uiBean.getKzhuritourokuhoukbn().getContent());
                kakuninmessage.add(MessageUtil.getMessage(MessageId.WHA1009, uiBean.getKzhuritourokuhoukbn().getContent()));
            }
        }
        if (C_KoureiKzkSetumeiHouKbn.BLNK.eq(uiBean.getKoureikzksetumeihoukbn())) {
            if (!C_KoureiMndnHukusuukaiKbn.BLNK.eq(uiBean.getKoureimndnhukusuukaikbn()) ||
                !C_KoureiTratkisyaIgiDskKbn.BLNK.eq(uiBean.getKoureitratkisyaigidskkbn())) {

                String message = MessageUtil.getMessage(DDID_KOUREISYAINFO_KOUREIKZKSETUMEIHOUKBN.getErrorResourceKey());
                messageMgr.addMessageId(MessageId.WBF0162, message);
                kakuninmessage.add(MessageUtil.getMessage(MessageId.WBF0162, message));
            }

        }

        if (!C_IkkatubaraiKaisuuKbn.BLNK.eq(uiBean.getIkkatubaraikaisuu())) {
            if (!uiBean.getMosikkatup().isZeroOrOptional()) {

                BizDate keiyakuDate = getKeiyakuDate(uiBean.getKyktuukasyu());
                C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
                if (C_Tkhukaumu.HUKA.eq(uiBean.getSyksbyensitihsyutkhkkbn())) {
                    syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
                }
                List<BM_SyouhnZokusei> syouhnZokuseiLst = new ArrayList<BM_SyouhnZokusei>();
                if (C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(uiBean.getHknsyuruino())) {

                    syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(
                        keiyakuDate, C_SyutkKbn.SYU, uiBean.getDaihyouHknSyuruiNo(), 0, 0,
                        uiBean.getKyktuukasyu(), syksbyensitihsyutktekiumu, uiBean.getSknenkinsyu(), uiBean.getSyouhnZokusei().getTeikisiharaikinumu());
                }
                else {
                    syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems2(
                        keiyakuDate, C_SyutkKbn.SYU, uiBean.getDaihyouHknSyuruiNo(), 0,
                        syksbyensitihsyutktekiumu, uiBean.getSknenkinsyu(), uiBean.getSyouhnZokusei().getTeikisiharaikinumu());
                }

                if (syouhnZokuseiLst.size() == 0) {
                    throw new BizLogicException(MessageId.EHA1060, "商品情報", "商品");
                }

                BM_SyouhnZokusei syouhnZokuseiDaihyou = syouhnZokuseiLst.get(0);

                syouhnZokuseiDaihyou.detach();

                SkZennouIkkatuUtil skZennouIkkatuUtil = SWAKInjector.getInstance(SkZennouIkkatuUtil.class);
                uiBean.setHrktuukasyukykp(skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen(
                    syouhnZokuseiDaihyou.getSyouhncd(), syouhnZokuseiDaihyou.getSyouhnsdno(),
                    syouhnZokuseiDaihyou.getRyouritusdno(), false, null, null, uiBean.getIkkatubaraikaisuu(),
                    uiBean.getMosikkatup()));
            }

            if (!uiBean.getMosikkatup2().isZeroOrOptional()) {

                BizDate keiyakuDate = getKeiyakuDate(uiBean.getKyktuukasyu2());
                C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
                if (C_Tkhukaumu.HUKA.eq(uiBean.getSyksbyensitihsyutkhkkbn())) {
                    syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
                }
                List<BM_SyouhnZokusei> syouhnZokuseiLst = new ArrayList<BM_SyouhnZokusei>();
                if (C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(uiBean.getHknsyuruino())
                    || C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(uiBean.getHknsyuruino())) {

                    syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(
                        keiyakuDate, C_SyutkKbn.SYU, uiBean.getDaihyouHknSyuruiNo(), 0, 0,
                        uiBean.getKyktuukasyu2(), syksbyensitihsyutktekiumu, uiBean.getSknenkinsyu(), uiBean.getSyouhnZokusei().getTeikisiharaikinumu());
                }
                else {
                    syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems2(
                        keiyakuDate, C_SyutkKbn.SYU, uiBean.getDaihyouHknSyuruiNo(), 0,
                        syksbyensitihsyutktekiumu, uiBean.getSknenkinsyu(), uiBean.getSyouhnZokusei().getTeikisiharaikinumu());
                }

                if (syouhnZokuseiLst.size() == 0) {
                    throw new BizLogicException(MessageId.EHA1060, "商品情報", "商品");
                }

                BM_SyouhnZokusei syouhnZokuseiAite = syouhnZokuseiLst.get(0);

                syouhnZokuseiAite.detach();

                SkZennouIkkatuUtil skZennouIkkatuUtil = SWAKInjector.getInstance(SkZennouIkkatuUtil.class);
                uiBean.setHrktuukasyukykp2(skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen(
                    syouhnZokuseiAite.getSyouhncd(), syouhnZokuseiAite.getSyouhnsdno(),
                    syouhnZokuseiAite.getRyouritusdno(), false, null, null, uiBean.getIkkatubaraikaisuu(),
                    uiBean.getMosikkatup2()));
            }
        }

        uiBean.setTaihyoumousikomiUmu(false);
        uiBean.setAiteimousikomiUmu(false);
        uiBean.setKakuninmessage(kakuninmessage);
        if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
            if (!uiBean.getHrktuukasyukykp().isZeroOrOptional() || !uiBean.getMossyukykp().isZeroOrOptional()) {
                uiBean.setTaihyoumousikomiUmu(true);
            }

            if (!uiBean.getHrktuukasyukykp2().isZeroOrOptional()) {
                uiBean.setAiteimousikomiUmu(true);
            }
        }

        if (C_KykKbn.KEIHI_BETU.eq(uiBean.getKykkbn())) {
            if (uiBean.getKyknmkjkhukakbn() == null) {
                uiBean.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
            }

            if (!C_KjkhukaKbn.BLNK.eq(uiBean.getKyknmkjkhukakbn()) &&
                BizUtil.isBlank(uiBean.getKyknmkj())) {
                uiBean.setKyknmkj(cutKjkhukaKnNm(uiBean.getKyknmkn()));
            }
        }

        if (uiBean.getHhknnmkjkhukakbn() == null) {
            uiBean.setHhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        }
        if (!C_KjkhukaKbn.BLNK.eq(uiBean.getHhknnmkjkhukakbn()) &&
            BizUtil.isBlank(uiBean.getHhknnmkj())) {
            uiBean.setHhknnmkj(cutKjkhukaKnNm(uiBean.getHhknnmkn()));
        }

        if (uiBean.getSbuktnin() != null &&
            uiBean.getSbuktnin() <= MAX_UKT_SIBOU) {
            List<String> sbUktNmKnLst = Lists.newArrayList();
            sbUktNmKnLst.add(uiBean.getSbuktnmkn1());
            sbUktNmKnLst.add(uiBean.getSbuktnmkn2());
            sbUktNmKnLst.add(uiBean.getSbuktnmkn3());
            sbUktNmKnLst.add(uiBean.getSbuktnmkn4());
            List<String> sbUktNmKjLst = Lists.newArrayList();
            sbUktNmKjLst.add(uiBean.getSbuktnmkj1());
            sbUktNmKjLst.add(uiBean.getSbuktnmkj2());
            sbUktNmKjLst.add(uiBean.getSbuktnmkj3());
            sbUktNmKjLst.add(uiBean.getSbuktnmkj4());
            List<C_KjkhukaKbn> sbUktNmKjhukaKbnLst = Lists.newArrayList();
            sbUktNmKjhukaKbnLst.add(uiBean.getSbuktnmkjhukakbn1());
            sbUktNmKjhukaKbnLst.add(uiBean.getSbuktnmkjhukakbn2());
            sbUktNmKjhukaKbnLst.add(uiBean.getSbuktnmkjhukakbn3());
            sbUktNmKjhukaKbnLst.add(uiBean.getSbuktnmkjhukakbn4());

            for (int index = 0; index < MAX_UKT_SIBOU; index++) {
                if (sbUktNmKjhukaKbnLst.get(index) == null) {
                    sbUktNmKjhukaKbnLst.set(index, C_KjkhukaKbn.BLNK);
                }
                if (!C_KjkhukaKbn.BLNK.eq(sbUktNmKjhukaKbnLst.get(index)) &&
                    BizUtil.isBlank(sbUktNmKjLst.get(index))) {
                    sbUktNmKjLst.set(index, cutKjkhukaKnNm(sbUktNmKnLst.get(index)));
                }
            }

            uiBean.setSbuktnmkjhukakbn1(sbUktNmKjhukaKbnLst.get(0));
            uiBean.setSbuktnmkjhukakbn2(sbUktNmKjhukaKbnLst.get(1));
            uiBean.setSbuktnmkjhukakbn3(sbUktNmKjhukaKbnLst.get(2));
            uiBean.setSbuktnmkjhukakbn4(sbUktNmKjhukaKbnLst.get(3));
            uiBean.setSbuktnmkj1(sbUktNmKjLst.get(0));
            uiBean.setSbuktnmkj2(sbUktNmKjLst.get(1));
            uiBean.setSbuktnmkj3(sbUktNmKjLst.get(2));
            uiBean.setSbuktnmkj4(sbUktNmKjLst.get(3));
        }

        if (uiBean.getTrkkzknmkjkhukakbn1() == null) {
            uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        }
        if (!C_KjkhukaKbn.BLNK.eq(uiBean.getTrkkzknmkjkhukakbn1()) &&
            BizUtil.isBlank(uiBean.getTrkkzknmkj1())) {
            uiBean.setTrkkzknmkj1(cutKjkhukaKnNm(uiBean.getTrkkzknmkn1()));
        }

        if (uiBean.getTrkkzknmkjkhukakbn2() == null) {
            uiBean.setTrkkzknmkjkhukakbn2(C_KjkhukaKbn.BLNK);
        }
        if (!C_KjkhukaKbn.BLNK.eq(uiBean.getTrkkzknmkjkhukakbn2()) &&
            BizUtil.isBlank(uiBean.getTrkkzknmkj2())) {
            uiBean.setTrkkzknmkj2(cutKjkhukaKnNm(uiBean.getTrkkzknmkn2()));
        }

        if (uiBean.getStdrsknmkjhukakbn() == null) {
            uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        }
        if (!C_KjkhukaKbn.BLNK.eq(uiBean.getStdrsknmkjhukakbn()) &&
            BizUtil.isBlank(uiBean.getSiteidruktnmkj())) {
            uiBean.setSiteidruktnmkj(cutKjkhukaKnNm(uiBean.getSiteidruktnmkn()));
        }

        if (!C_Tuukasyu.BLNK.eq(uiBean.getHrktuukasyu()) &&
            !C_Tuukasyu.BLNK.eq(uiBean.getKyktuukasyu())) {
            if (!uiBean.getHrktuukasyu().eq(uiBean.getKyktuukasyu())) {
                if (C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu())) {
                    uiBean.setYennykntkhkkbn(C_Tkhukaumu.HUKA);
                }
                else {
                    uiBean.setGaikanykntkhkkbn(C_Tkhukaumu.HUKA);
                }
            }
            else {
                uiBean.setYennykntkhkkbn(C_Tkhukaumu.NONE);
                uiBean.setGaikanykntkhkkbn(C_Tkhukaumu.NONE);
            }
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getHrktuukasyu());
        BizCurrency mosfstpkei = BizCurrency.valueOf(0, currencyType);
        BizCurrency mosfstpkei2 = BizCurrency.valueOf(0, currencyType);

        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getSyouhnZokusei().getPtratkituukasiteikbn())) {
            mosfstpkei = uiBean.getMossyukykp();
        }
        else {
            mosfstpkei = uiBean.getHrktuukasyukykp();
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getTeikiikkatubaraiumu())) {
            if (!uiBean.getMosikkatup().isZeroOrOptional()) {
                mosfstpkei = uiBean.getMosikkatup();
            }

        }

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getZennouumu())) {
            if (!uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) {
                mosfstpkei = uiBean.getMoszennoupsyokaiari();
            }
        }

        if (uiBean.isAiteimousikomiUmu()) {

            mosfstpkei2 = uiBean.getHrktuukasyukykp2();

            if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getTeikiikkatubaraiumu())) {
                if (!uiBean.getMosikkatup2().isZeroOrOptional()) {
                    mosfstpkei2 = uiBean.getMosikkatup2();
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getZennouumu())) {
                if (!uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {
                    mosfstpkei2 = uiBean.getMoszennoupsyokaiari2();
                }
            }
        }

        uiBean.setMosfstpkei(mosfstpkei);
        uiBean.setMosfstpkei2(mosfstpkei2);

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getKouzahurikaebaraitekiumu()) &&
            C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro()) &&
            C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getKouzainfoinputhoryuukbn())) {

            if (C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu()) &&
                uiBean.getKouhurikouzainfokouzano().length() < YuyuBizConfig.getInstance().getYenkaKouzaKetasuu()) {

                uiBean.setKouhurikouzainfokouzano(Strings.padStart(
                    uiBean.getKouhurikouzainfokouzano(),
                    YuyuBizConfig.getInstance().getYenkaKouzaKetasuu(),
                    '0'));
            }

            if (C_KzkykdouKbn.DOUITU.eq(uiBean.getKouhurikouzainfokzdoukbn())) {

                if (C_KykKbn.KEIHI_DOUITU.eq(uiBean.getKykkbn())) {

                    uiBean.setDispkzmeiginmkn(uiBean.getHhknnmkn());
                    uiBean.setNewkzmeiginmkn("");
                }
                else if (C_KykKbn.KEIHI_BETU.eq(uiBean.getKykkbn())) {

                    uiBean.setDispkzmeiginmkn(uiBean.getKyknmkn());
                    uiBean.setNewkzmeiginmkn("");
                }
            }
            else if (C_KzkykdouKbn.SITEI.eq(uiBean.getKouhurikouzainfokzdoukbn())) {

                uiBean.setDispkzmeiginmkn(uiBean.getKouhurikouzainfokzmeiginmkn());
                uiBean.setNewkzmeiginmkn(uiBean.getKouhurikouzainfokzmeiginmkn());
            }

            uiBean.setKouhurikouzainfokzmeiginmkn(uiBean.getDispkzmeiginmkn());

            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getKouhurikouzainfobankcd(),
                uiBean.getKouhurikouzainfositencd());

            uiBean.setKouhurikouzainfobanknmkj(bzGetBankDataBean.getBankNmKj());
            uiBean.setKouhurikouzainfositennmkj(bzGetBankDataBean.getSitenNmKj());
        }
        else {
            uiBean.setKouhurikouzainfobanknmkj("");
            uiBean.setKouhurikouzainfositennmkj("");
        }

        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.valueOf(uiBean.getMkhgkwarimosinput()));

        if (C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getHknsyuruino())) {
            uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.NONE);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
            uiBean.setTaihikyktuukasyu(uiBean.getKyktuukasyu());
            uiBean.setTaihihrktuukasyu(uiBean.getHrktuukasyu());
            uiBean.setTaihikyktuukasyu2(uiBean.getKyktuukasyu2());
            uiBean.setTaihihrktuukasyu2(uiBean.getHrktuukasyu2());

            if (uiBean.getHrktuukasyukykp().isZeroOrOptional()) {
                uiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
                uiBean.setHrktuukasyu(C_Tuukasyu.BLNK);
                uiBean.setKyktuukasyumosinput(C_Tuukasyu.BLNK.getValue());
                uiBean.setHrktuukasyumosinput(C_Tuukasyu.BLNK.getValue());
            }

            if (uiBean.getHrktuukasyukykp2().isZeroOrOptional()) {
                uiBean.setKyktuukasyu2(C_Tuukasyu.BLNK);
                uiBean.setHrktuukasyu2(C_Tuukasyu.BLNK);
                uiBean.setKyktuukasyu2mosinput(C_Tuukasyu.BLNK.getValue());
                uiBean.setHrktuukasyu2mosinput(C_Tuukasyu.BLNK.getValue());
            }
        }

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn())
            || E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn())
            || E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
            if (C_KzktourokuserviceTourokuKbn.ARI.eq(uiBean.getKzktourokuservicetourokukbn())) {

                uiBean.setKykdrtkykhukakbn(C_Tkhukaumu.HUKA);
                uiBean.setKykdrkbn(C_UktKbn.TOUROKUKAZOKU1);
            }
            else if (C_KzktourokuserviceTourokuKbn.NONE.eq(uiBean.getKzktourokuservicetourokukbn())) {

                uiBean.setKykdrtkykhukakbn(C_Tkhukaumu.NONE);
            }
        }

        if (C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn()) &&
            C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getShkstkzinfkzinfoinputhrykbn())) {

            Integer yenkaKouzaKetasuu = YuyuBizConfig.getInstance().getYenkaKouzaKetasuu();

            Integer gaikaKouzaKetasuu = YuyuBizConfig.getInstance().getGaikaKouzaKetasuu();

            if (C_KouzasyuruiKbn.YENKOUZA.eq(uiBean.getKzsyuruikbn()) &&
                uiBean.getKouzano().length() < yenkaKouzaKetasuu) {
                uiBean.setKouzano(Strings.padStart(uiBean.getKouzano(), yenkaKouzaKetasuu, '0'));
            }
            else if (C_KouzasyuruiKbn.GAIKAKOUZA.eq(uiBean.getKzsyuruikbn()) &&
                uiBean.getKouzano().length() < gaikaKouzaKetasuu) {
                uiBean.setKouzano(Strings.padStart(uiBean.getKouzano(), gaikaKouzaKetasuu, '0'));
            }

            if (C_KzkykdouKbn.DOUITU.eq(uiBean.getKzkykdoukbn())) {
                if (C_KykKbn.KEIHI_DOUITU.eq(uiBean.getKykkbn())) {

                    uiBean.setShkstkzinfkzinfoDispkzmeiginmkn(uiBean.getHhknnmkn());
                    uiBean.setShkstkzinfkzinfoNewkzmeiginmkn("");
                }
                else if (C_KykKbn.KEIHI_BETU.eq(uiBean.getKykkbn())) {

                    uiBean.setShkstkzinfkzinfoDispkzmeiginmkn(uiBean.getKyknmkn());
                    uiBean.setShkstkzinfkzinfoNewkzmeiginmkn("");
                }
            }
            else if (C_KzkykdouKbn.SITEI.eq(uiBean.getKzkykdoukbn())) {

                uiBean.setShkstkzinfkzinfoDispkzmeiginmkn(uiBean.getKzmeiginmkn());
                uiBean.setShkstkzinfkzinfoNewkzmeiginmkn(uiBean.getKzmeiginmkn());
            }
            uiBean.setKzmeiginmkn(uiBean.getShkstkzinfkzinfoDispkzmeiginmkn());

            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd());

            uiBean.setBanknmkj(bzGetBankDataBean.getBankNmKj());
            uiBean.setSitennmkj(bzGetBankDataBean.getSitenNmKj());
        }
        else {
            uiBean.setBanknmkj("");
            uiBean.setSitennmkj("");
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getHokenkngkyakujyouumu())) {
            uiBean.setTaihisdpdkbn(uiBean.getSdpdkbn());

            if (C_Sdpd.BLNK.eq(uiBean.getSdpdkbn())) {

                String syukihons = "";
                String mossyukykp = "";
                if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                    if (!uiBean.getSyukihons().isOptional() && BizCurrency.valueOf(100, uiBean.getSyukihons().getType()).compareTo(uiBean.getSyukihons()) <= 0) {
                        syukihons = uiBean.getSyukihons().toAdsoluteString();
                        syukihons = syukihons.substring(syukihons.length() - 4, syukihons.length());
                    }
                    else {
                        if (uiBean.getSyukihons().isOptional()) {
                            syukihons = "0";
                        }
                        else {
                            syukihons = uiBean.getSyukihons().toAdsoluteString();
                        }
                    }
                    if (!uiBean.getMossyukykp().isOptional() && BizCurrency.valueOf(10, uiBean.getMossyukykp().getType()).compareTo(uiBean.getMossyukykp()) <= 0) {
                        mossyukykp = uiBean.getMossyukykp().toAdsoluteString();
                        mossyukykp = mossyukykp.substring(mossyukykp.length() - 3, mossyukykp.length());
                    }
                    else {
                        if (uiBean.getMossyukykp().isOptional()) {
                            mossyukykp = "0";
                        }
                        else {
                            mossyukykp = uiBean.getMossyukykp().toAdsoluteString();
                        }
                    }
                }
                else {
                    if (!uiBean.getSyukihons().isOptional() && BizCurrency.valueOf(10000, uiBean.getSyukihons().getType()).compareTo(uiBean.getSyukihons()) <= 0) {
                        syukihons = uiBean.getSyukihons().toAdsoluteString();
                        syukihons = syukihons.substring(syukihons.length() - 4, syukihons.length());
                    }
                    else {
                        if (uiBean.getSyukihons().isOptional()) {
                            syukihons = "0";
                        }
                        else {
                            syukihons = uiBean.getSyukihons().toAdsoluteString();
                        }
                    }
                    if (!uiBean.getMossyukykp().isOptional() && BizCurrency.valueOf(1000, uiBean.getMossyukykp().getType()).compareTo(uiBean.getMossyukykp()) <= 0) {
                        mossyukykp = uiBean.getMossyukykp().toAdsoluteString();
                        mossyukykp = mossyukykp.substring(mossyukykp.length() - 3, mossyukykp.length());
                    }
                    else {
                        if (uiBean.getMossyukykp().isOptional()) {
                            mossyukykp = "0";
                        }
                        else {
                            mossyukykp = uiBean.getMossyukykp().toAdsoluteString();
                        }
                    }
                }

                if (Integer.valueOf(syukihons) != 0 && Integer.valueOf(mossyukykp) == 0) {
                    uiBean.setSdpdkbn(C_Sdpd.PD);
                }
                if (Integer.valueOf(syukihons) == 0 && Integer.valueOf(mossyukykp) != 0) {
                    uiBean.setSdpdkbn(C_Sdpd.SD);
                }
            }
        }

        if (C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(uiBean.getHknsyuruino())) {
            BizDate keiyakuDate = getKeiyakuDate(uiBean.getKyktuukasyu());

            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
            int hhknNenrei = setNenrei.exec(keiyakuDate, uiBean.getHhknseiymd());
            uiBean.setSyuhrkkkn(hhknNenrei + Integer.valueOf(uiBean.getSyudai1hknkknmosinput()));

            if (uiBean.getSyuhrkkkn() > 99) {
                uiBean.setSyuhrkkkn(99);
            }
        }
    }

    void pushKakuteiBL() {

        try {
            doContinueLockProcess();
            doUpdateTables();
        } catch (IntentionalRollbackException e) {
            doUnlockProcess();
        } catch (BizLogicException e) {

            if (unlockFlg) {
                doUnlockProcess();
            }

            throw e;
        } catch (CommonBizAppException e) {
            doUnlockProcess();
            throw e;
        }
    }

    @Transactional
    void doUpdateTables() {
        boolean kikenZou = false;
        String userID = baseUserInfo.getUserId();
        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();
        E_SyoriKbn syoriKbn = uiBean.getSyoriKbn();
        String mosNo = uiBean.getMosno();
        StringBuffer resultBtnMessage = new StringBuffer();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        if (syoriCTL != null) {
            syoriCTL = uiBean.getSyoriCTL();

            if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(syoriKbn)
                || E_SyoriKbn.MOUSIKOMISYO_2JI.equals(syoriKbn)
                || E_SyoriKbn.MOUSIKOMISYO_3JI.equals(syoriKbn)) {

                syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
            }
        }
        else {
            syoriCTL = new HT_SyoriCTL();
            syoriCTL.setMosno(mosNo);
            syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
            syoriCTL.setSeiritukbn(C_SeirituKbn.NONE);
            syoriCTL.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            syoriCTL.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SONOTA_MINYUUKIN);

            BizPropertyInitializer.initialize(syoriCTL);
        }

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(syoriKbn)
            || BizUtil.isBlank(syoriCTL.getSyono())) {

            try {
                SyoukenNoUtil syoukenNoUtil = SWAKInjector.getInstance(SyoukenNoUtil.class);
                String syoNo = syoukenNoUtil.getShokenNo(mosNo, null, userID);
                syoriCTL.setSyono(syoNo);
            } catch (CommonBizAppException ex) {

                throw new BizLogicException(MessageId.EHF1013);
            }
        }

        syoriCTL.setGyoumuKousinsyaId(userID);
        syoriCTL.setGyoumuKousinTime(sysTime);

        if (E_SyoriKbn.SYORI_UPD.equals(syoriKbn) ||
            E_SyoriKbn.SYORI_INPUT_UPD.equals(syoriKbn)) {
            C_KetteiKbn ketteiKbn = syoriCTL.getKetteikbn();
            if (C_KetteiKbn.NONE.eq(ketteiKbn)) {
            }
            else {
                if (kikenZou) {
                    syoriCTL.setKetteikbn(C_KetteiKbn.NONE);
                }
            }

            syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
            syoriCTL.setMostenkenrrkumu(C_UmuKbn.ARI);

            HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno(mosNo);
            Integer mostenkenRrkRenno = 0;

            if (mostenkenRireki != null) {
                mostenkenRrkRenno = mostenkenRireki.getRenno();
            }

            mostenkenRireki = syoriCTL.createMostenkenRireki();

            mostenkenRireki.setRenno(mostenkenRrkRenno + 1);
            mostenkenRireki.setSyoriYmd(sysDate);
            mostenkenRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.MOSINPUT_HENTEI_NYUTEI);
            mostenkenRireki.setMostenkenkekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
            mostenkenRireki.setMostenkencomment(
                EditSecurityKm.getEncodeData(mosNo, MessageUtil.getMessage(MessageId.IHC1035)));
            mostenkenRireki.setGyoumuKousinsyaId(userID);
            mostenkenRireki.setGyoumuKousinTime(sysTime);

            BizPropertyInitializer.initialize(mostenkenRireki);
        }

        String functionId = kinou.getKinouId();

        if (E_SyoriKbn.SYORI_UPD.equals(syoriKbn)) {
            tsRrkInfoTouroku.rgstrMousikomisyo(
                uiBean, sysTime, functionId, C_SkkinouModeIdKbn.MOUSIKOMISYO_UPD.getValue(), userID);
        }
        else if (E_SyoriKbn.SYORI_INPUT_UPD.equals(syoriKbn)) {
            tsRrkInfoTouroku.rgstrMousikomisyo(
                uiBean, sysTime, functionId, C_SkkinouModeIdKbn.MOUSIKOMISYO_INS_UPD.getValue(), userID);
        }

        int nrksaiumu = SaiDataTouroku.NRKSAINASI;

        if (!E_SyoriKbn.MOUSIKOMISYO_1JI.equals(syoriKbn)) {
            if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(syoriKbn)) {
                nrksaiumu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, userID, sysTime);
                uiBean.setNrksaiumu(nrksaiumu);

                if (SaiDataTouroku.NRKSAIARI == uiBean.getNrksaiumu()) {
                    uiBean.setAiteimousikomiUmu(false);
                }
            }

            HT_MosKihon mosKihon = syoriCTL.getMosKihon();
            if (mosKihon == null) {
                mosKihon = syoriCTL.createMosKihon();
            }

            setMosKihonFromUiBean(mosKihon, userID, sysTime, false);
            BizPropertyInitializer.initialize(mosKihon);

            List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
            mosSyouhnLst.clear();
            sinkeiyakuDomManager.flush();

            setMosSyouhnFromUiBean(syoriCTL, userID, sysTime, false);

            List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
            uketorininLst.clear();
            sinkeiyakuDomManager.flush();

            setUketorininFromUiBean(syoriCTL, userID, sysTime, false);

            List<HT_MosTrkKzk> mosTrkKzkLst = syoriCTL.getMosTrkKzks();
            mosTrkKzkLst.clear();
            sinkeiyakuDomManager.flush();

            setMosTrkKzkFromUiBean(syoriCTL, userID, sysTime, false);

            List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
            mosDairitenLst.clear();
            sinkeiyakuDomManager.flush();

            setMosDairitenFromUiBean(syoriCTL, userID, sysTime, false);

            List<HT_UketoriKouzaJyouhou> uketoriKouzaJyouhouLst = syoriCTL.getUketoriKouzaJyouhous();
            HT_UketoriKouzaJyouhou uketoriKouzaJyouhoutaihi = null;

            for (int i = 0; i < uketoriKouzaJyouhouLst.size(); i++) {
                if (C_UketorikouzasyubetuKbn.DSSOUKINYOUKOUZA.eq(uketoriKouzaJyouhouLst.get(i).getUktkzsyubetukbn())) {
                    uketoriKouzaJyouhoutaihi = ObjectUtil.deepCopy(uketoriKouzaJyouhouLst.get(i));
                }
            }

            uketoriKouzaJyouhouLst.clear();
            sinkeiyakuDomManager.flush();

            if (C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn())) {
                setUketoriKouzaJyouhouFromUiBean(syoriCTL, userID, sysTime, false);
            }

            if (uketoriKouzaJyouhoutaihi != null) {
                BizPropertyInitializer.initialize(uketoriKouzaJyouhoutaihi);
                syoriCTL.getUketoriKouzaJyouhous().add(uketoriKouzaJyouhoutaihi);
            }


            List<HT_KouzaJyouhou> listKouzaJyouhou = syoriCTL.getKouzaJyouhous();

            HT_KouzaJyouhou beforeKouzaJyouhou = new HT_KouzaJyouhou();

            if (listKouzaJyouhou != null && listKouzaJyouhou.size() != 0) {
                beforeKouzaJyouhou.setBankcd(listKouzaJyouhou.get(0).getBankcd());
                beforeKouzaJyouhou.setSitencd(listKouzaJyouhou.get(0).getSitencd());
                beforeKouzaJyouhou.setYokinkbn(listKouzaJyouhou.get(0).getYokinkbn());
                beforeKouzaJyouhou.setKouzano(listKouzaJyouhou.get(0).getKouzano());
                beforeKouzaJyouhou.setKzkykdoukbn(listKouzaJyouhou.get(0).getKzkykdoukbn());
                beforeKouzaJyouhou.setKzmeiginmkn(listKouzaJyouhou.get(0).getKzmeiginmkn());
                beforeKouzaJyouhou.setKouzakakuniniraikbn(listKouzaJyouhou.get(0).getKouzakakuniniraikbn());
                beforeKouzaJyouhou.setKouzakakuniniraiymd(listKouzaJyouhou.get(0).getKouzakakuniniraiymd());
                beforeKouzaJyouhou.setKouzajyouhounyuuryokuymd(listKouzaJyouhou.get(0).getKouzajyouhounyuuryokuymd());
                listKouzaJyouhou.clear();
                sinkeiyakuDomManager.flush();
            }

            if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) {

                setKouzaJyouhouFromUiBean(syoriCTL, userID, sysDate, sysTime, nrksaiumu, beforeKouzaJyouhou,false);

                if (nrksaiumu == SaiDataTouroku.NRKSAINASI &&
                    C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getKouzainfoinputhoryuukbn())) {
                    syoriCTL.setKznrkumu(C_UmuKbn.ARI);
                }
                else {
                    syoriCTL.setKznrkumu(C_UmuKbn.NONE);
                }
            }
            else {

                syoriCTL.setKznrkumu(C_UmuKbn.NONE);
            }

            if (E_SyoriKbn.SYORI_UPD.equals(syoriKbn)) {
                Integer renban = sinkeiyakuDomManager.getHenteiRirekiMaxRennoByMosno(mosNo);
                if (renban == null) {
                    renban = 0;
                }

                HT_HenteiRireki henteiRireki = syoriCTL.createHenteiRireki();
                henteiRireki.setRenno(renban + 1);
                henteiRireki.setHenteiymd(sysDate);
                henteiRireki.setGyoumuKousinsyaId(userID);
                henteiRireki.setGyoumuKousinTime(sysTime);
                BizPropertyInitializer.initialize(henteiRireki);
            }
        }

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(syoriKbn)) {
            GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();

            HT_MosKihonVrf mosKihonVrf = syoriCTL.createMosKihonVrf();

            HT_MosKihon mosKihon = new HT_MosKihon();
            setMosKihonFromUiBean(mosKihon, userID, sysTime, false);

            BeanUtil.copyProperties(mosKihonVrf, mosKihon);

            mosKihonVrf.setAitemosno(uiBean.getAitemosno());

            if (C_UmuKbn.NONE.eq(getSyouhnZokuseiCtrlOutBean.getGaikatatkiumu())) {
                mosKihonVrf.setKyktuukasyu2(C_Tuukasyu.BLNK);
                mosKihonVrf.setHrktuukasyu2(C_Tuukasyu.BLNK);
            }
            else {
                mosKihonVrf.setKyktuukasyu2(uiBean.getKyktuukasyu2());
                mosKihonVrf.setHrktuukasyu2(uiBean.getHrktuukasyu2());
            }
            mosKihonVrf.setMosheijyunp2(uiBean.getHrktuukasyukykp2());
            mosKihonVrf.setMosikkatup2(uiBean.getMosikkatup2());
            mosKihonVrf.setMoszennoupsyokaiari2(uiBean.getMoszennoupsyokaiari2());
            mosKihonVrf.setKjnnkpzeitekitkhukakbn2(uiBean.getKjnnkpzeitekitkhukakbn2());

            BizPropertyInitializer.initialize(mosKihonVrf);

            HT_MosSyouhnVrf mosSyouhnVrf = syoriCTL.createMosSyouhnVrf();

            mosSyouhnVrf.setSyouhncd(uiBean.getSyouhnZokusei().getSyouhncd());
            mosSyouhnVrf.setSyouhnsdno(0);
            mosSyouhnVrf.setSyutkkbn(C_SyutkKbn.SYU);

            if (!BizUtil.isBlank(uiBean.getNenkinsyumosinput())) {
                mosSyouhnVrf.setSknenkinsyu(C_Sknenkinsyu.valueOf(uiBean.getNenkinsyumosinput()));
            }

            mosSyouhnVrf.setKihons(uiBean.getSyukihons());
            if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn())) {
                mosSyouhnVrf.setHrktuukasyutkp(uiBean.getMossyukykp());
            }
            else {
                mosSyouhnVrf.setHrktuukasyutkp(uiBean.getHrktuukasyukykp());
            }

            if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getNkhknumu()) &&
                C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getItijibrumu())) {

                mosSyouhnVrf.setHknkkn(Integer.parseInt(uiBean.getSueokikknmosinput()));
            }
            else {

                mosSyouhnVrf.setHknkkn(uiBean.getSyuhknkkn());
            }

            mosSyouhnVrf.setHrkkkn(uiBean.getSyuhrkkkn());
            mosSyouhnVrf.setHknkknsmnkbn(uiBean.getSyuhknkknsmnkbn());
            mosSyouhnVrf.setHrkkknsmnkbn(uiBean.getSyuhrkkknsmnkbn());
            if (BizUtil.isBlank(uiBean.getSyudai1hknkknmosinput())) {
                mosSyouhnVrf.setDai1hknkkn(0);
            }
            else {
                mosSyouhnVrf.setDai1hknkkn(Integer.parseInt(uiBean.getSyudai1hknkknmosinput()));
            }
            mosSyouhnVrf.setKihons2(uiBean.getKihons2());
            mosSyouhnVrf.setHrktuukasyutkp2(uiBean.getHrktuukasyukykp2());

            mosSyouhnVrf.setGyoumuKousinsyaId(userID);
            mosSyouhnVrf.setGyoumuKousinTime(sysTime);
            BizPropertyInitializer.initialize(mosSyouhnVrf);

            int uketoriCnt = 0;

            if (C_Tkhukaumu.HUKA.eq(uiBean.getStdrsktkyhkkbn())) {
                uketoriCnt++;

                HT_UketorininVrf uketorininVrf = syoriCTL.createUketorininVrf();
                uketorininVrf.setUktsyukbn(C_UktsyuKbn.STDRSK);
                uketorininVrf.setUktsyurenno(UKTSYURENNO_BEGIN);
                uketorininVrf.setUktkbn(uiBean.getStdruktkbn());
                uketorininVrf.setUktnmkn(uiBean.getSiteidruktnmkn());
                uketorininVrf.setUktnmkj(uiBean.getSiteidruktnmkj());
                uketorininVrf.setUktnmkjkhukakbn(uiBean.getStdrsknmkjhukakbn());
                uketorininVrf.setUkttdk(uiBean.getStdrsktdk());
                uketorininVrf.setUktbnwari(UKTBNWARI_100);
                uketorininVrf.setUktseiymd(uiBean.getStdrskseiymd());
                uketorininVrf.setGyoumuKousinsyaId(userID);
                uketorininVrf.setGyoumuKousinTime(sysTime);
                BizPropertyInitializer.initialize(uketorininVrf);
            }

            List<C_UktKbn> sbuktKbnLst = Lists.newArrayList();
            sbuktKbnLst.add(uiBean.getSbuktkbn1());
            sbuktKbnLst.add(uiBean.getSbuktkbn2());
            sbuktKbnLst.add(uiBean.getSbuktkbn3());
            sbuktKbnLst.add(uiBean.getSbuktkbn4());
            List<String> sbuktnmknLst = Lists.newArrayList();
            sbuktnmknLst.add(uiBean.getSbuktnmkn1());
            sbuktnmknLst.add(uiBean.getSbuktnmkn2());
            sbuktnmknLst.add(uiBean.getSbuktnmkn3());
            sbuktnmknLst.add(uiBean.getSbuktnmkn4());
            List<String> sbuktnmkjLst = Lists.newArrayList();
            sbuktnmkjLst.add(uiBean.getSbuktnmkj1());
            sbuktnmkjLst.add(uiBean.getSbuktnmkj2());
            sbuktnmkjLst.add(uiBean.getSbuktnmkj3());
            sbuktnmkjLst.add(uiBean.getSbuktnmkj4());
            List<C_KjkhukaKbn> sbuktnmkjhukakbnLst = Lists.newArrayList();
            sbuktnmkjhukakbnLst.add(uiBean.getSbuktnmkjhukakbn1());
            sbuktnmkjhukakbnLst.add(uiBean.getSbuktnmkjhukakbn2());
            sbuktnmkjhukakbnLst.add(uiBean.getSbuktnmkjhukakbn3());
            sbuktnmkjhukakbnLst.add(uiBean.getSbuktnmkjhukakbn4());
            List<BizDate> sbuktseiymdLst = Lists.newArrayList();
            sbuktseiymdLst.add(uiBean.getSbuktseiymd1());
            sbuktseiymdLst.add(uiBean.getSbuktseiymd2());
            sbuktseiymdLst.add(uiBean.getSbuktseiymd3());
            sbuktseiymdLst.add(uiBean.getSbuktseiymd4());
            List<C_Tdk> sbukttdkLst = Lists.newArrayList();
            sbukttdkLst.add(uiBean.getSbukttdk1());
            sbukttdkLst.add(uiBean.getSbukttdk2());
            sbukttdkLst.add(uiBean.getSbukttdk3());
            sbukttdkLst.add(uiBean.getSbukttdk4());
            List<BizNumber> sbuktbnwariLst = Lists.newArrayList();
            sbuktbnwariLst.add(uiBean.getSbuktbnwari1());
            sbuktbnwariLst.add(uiBean.getSbuktbnwari2());
            sbuktbnwariLst.add(uiBean.getSbuktbnwari3());
            sbuktbnwariLst.add(uiBean.getSbuktbnwari4());

            uketoriCnt = 1;

            for (int index = 0; index < MAX_UKT_SIBOU; index++) {
                if (!C_UktKbn.BLNK.eq(sbuktKbnLst.get(index))) {
                    HT_UketorininVrf uketorininVrf = syoriCTL.createUketorininVrf();
                    uketorininVrf.setUktsyukbn(C_UktsyuKbn.SBUKT);
                    uketorininVrf.setUktsyurenno(uketoriCnt);
                    uketorininVrf.setUktkbn(sbuktKbnLst.get(index));
                    uketorininVrf.setUktnmkn(sbuktnmknLst.get(index));
                    uketorininVrf.setUktnmkj(sbuktnmkjLst.get(index));
                    uketorininVrf.setUktnmkjkhukakbn(sbuktnmkjhukakbnLst.get(index));
                    uketorininVrf.setUkttdk(sbukttdkLst.get(index));
                    uketorininVrf.setUktbnwari(sbuktbnwariLst.get(index));
                    uketorininVrf.setUktseiymd(sbuktseiymdLst.get(index));
                    uketorininVrf.setGyoumuKousinsyaId(userID);
                    uketorininVrf.setGyoumuKousinTime(sysTime);
                    BizPropertyInitializer.initialize(uketorininVrf);

                    uketoriCnt++;
                }
            }

            if (!C_UktKbn.BLNK.eq(uiBean.getNenkinuktkbn())) {
                uketoriCnt++;

                HT_UketorininVrf uketorininVrf = syoriCTL.createUketorininVrf();
                uketorininVrf.setUktsyukbn(C_UktsyuKbn.NKUKT);
                uketorininVrf.setUktsyurenno(UKTSYURENNO_BEGIN);
                uketorininVrf.setUktkbn(uiBean.getNenkinuktkbn());
                uketorininVrf.setUktbnwari(UKTBNWARI_100);
                uketorininVrf.setGyoumuKousinsyaId(userID);
                uketorininVrf.setGyoumuKousinTime(sysTime);
                BizPropertyInitializer.initialize(uketorininVrf);
            }

            if (!BizUtil.isBlank(uiBean.getTrkkzknmkn1())) {

                HT_MosTrkKzkVrf mosTrkKzkVrf = syoriCTL.createMosTrkKzkVrf();

                mosTrkKzkVrf.setTrkkzkkbn(C_TrkKzkKbn.TRKKZK1);
                mosTrkKzkVrf.setTrkkzknmkn(uiBean.getTrkkzknmkn1());
                mosTrkKzkVrf.setTrkkzknmkj(uiBean.getTrkkzknmkj1());
                mosTrkKzkVrf.setTrkkzknmkjkhukakbn(uiBean.getTrkkzknmkjkhukakbn1());
                mosTrkKzkVrf.setTrkkzkseiymd(uiBean.getTrkkzkseiymd1());
                mosTrkKzkVrf.setTrkkzksei(uiBean.getTrkkzksei1());
                mosTrkKzkVrf.setTrkkzktdk(uiBean.getTrkkzktdk1());
                mosTrkKzkVrf.setTrkkzktsindousiteikbn(uiBean.getTrkkzktsindousiteikbn1());
                mosTrkKzkVrf.setTrkkzkyno(uiBean.getTrkkzkyno1());
                mosTrkKzkVrf.setTrkkzkadr1kj(uiBean.getTrkkzkadr1kj1());
                mosTrkKzkVrf.setTrkkzkadr2kj(uiBean.getTrkkzkadr2kj1());
                mosTrkKzkVrf.setTrkkzkadr3kj(uiBean.getTrkkzkadr3kj1());
                mosTrkKzkVrf.setTrkkzktelno(uiBean.getTrkkzktelno1());
                mosTrkKzkVrf.setGyoumuKousinsyaId(userID);
                mosTrkKzkVrf.setGyoumuKousinTime(sysTime);
                BizPropertyInitializer.initialize(mosTrkKzkVrf);
            }

            List<String> drtenJimCdLst = Lists.newArrayList();
            drtenJimCdLst.add(uiBean.getDrtenjimcd1());
            drtenJimCdLst.add(uiBean.getDrtenjimcd2());
            List<String> bosyuuTrkNoLst = Lists.newArrayList();
            bosyuuTrkNoLst.add(uiBean.getBosyuunintourokuno1());
            bosyuuTrkNoLst.add(uiBean.getBosyuunintourokuno2());
            List<String> drtKinyuukikanCdLst = Lists.newArrayList();
            drtKinyuukikanCdLst.add(uiBean.getDairitenkinyuukikancd1());
            drtKinyuukikanCdLst.add(uiBean.getDairitenkinyuukikancd2());
            List<String> drtKinyuukikanSitenCdLst = Lists.newArrayList();
            drtKinyuukikanSitenCdLst.add(uiBean.getDairitenkinyuukikansitencd1());
            drtKinyuukikanSitenCdLst.add(uiBean.getDairitenkinyuukikansitencd2());
            List<String> drtTratkikouinCdLst = Lists.newArrayList();
            drtTratkikouinCdLst.add(uiBean.getDairitentoriatukaikouincd1());
            drtTratkikouinCdLst.add(uiBean.getDairitentoriatukaikouincd2());
            List<String> inputBosyuuCdLst = Lists.newArrayList();
            inputBosyuuCdLst.add(uiBean.getInputbosyuucd1());
            inputBosyuuCdLst.add(uiBean.getInputbosyuucd2());
            List<String> gyskkjsakiSosikiCdLst = Lists.newArrayList();
            gyskkjsakiSosikiCdLst.add(uiBean.getGyskkjsakisosikicd1());
            gyskkjsakiSosikiCdLst.add(uiBean.getGyskkjsakisosikicd2());
            List<BizNumber> drtBunwariLst = Lists.newArrayList();
            drtBunwariLst.add(uiBean.getDairitenbuntanwariai1());
            drtBunwariLst.add(uiBean.getDairitenbuntanwariai2());

            List<String> oyaDrtCdLst = Lists.newArrayList();
            oyaDrtCdLst.add(uiBean.getOyadairitencd1());
            oyaDrtCdLst.add(uiBean.getOyadairitencd2());
            List<String> toriatukaiDrtCdLst = Lists.newArrayList();
            toriatukaiDrtCdLst.add(uiBean.getToriatukaidairitencd1());
            toriatukaiDrtCdLst.add(uiBean.getToriatukaidairitencd2());
            List<String> bosyuuCdLst = Lists.newArrayList();
            bosyuuCdLst.add(uiBean.getBosyuucd1());
            bosyuuCdLst.add(uiBean.getBosyuucd2());

            int dairitenCnt = 0;

            for (int index = 0; index < MAX_DAIRITEN; index++) {

                CheckTblMosDairiten checkTblMosDairiten = SWAKInjector.getInstance(CheckTblMosDairiten.class);

                C_ErrorKbn errorKbn = checkTblMosDairiten.checkDirInfoPattern(drtKinyuukikanCdLst.get(index),
                    drtKinyuukikanSitenCdLst.get(index), inputBosyuuCdLst.get(index), drtTratkikouinCdLst.get(index),
                    drtenJimCdLst.get(index), bosyuuTrkNoLst.get(index), index + 1);

                if (C_ErrorKbn.OK.eq(errorKbn)) {
                    dairitenCnt++;

                    HT_MosDairitenVrf mosDairitenVrf = syoriCTL.createMosDairitenVrf();
                    mosDairitenVrf.setRenno(dairitenCnt);

                    if (dairitenCnt == 1) {
                        mosDairitenVrf.setBsyujoyadrtencd(uiBean.getInitBsyujoyadrtencd());
                    }
                    else {
                        mosDairitenVrf.setBsyujoyadrtencd("");
                    }

                    mosDairitenVrf.setKinyuucd(drtKinyuukikanCdLst.get(index));
                    mosDairitenVrf.setKinyuusitencd(drtKinyuukikanSitenCdLst.get(index));
                    mosDairitenVrf.setTratkiagcd(toriatukaiDrtCdLst.get(index));
                    mosDairitenVrf.setOyadrtencd(oyaDrtCdLst.get(index));
                    mosDairitenVrf.setJimusyocd(drtenJimCdLst.get(index));
                    mosDairitenVrf.setBosyuutrkno(bosyuuTrkNoLst.get(index));

                    if (dairitenCnt == 1) {
                        mosDairitenVrf.setCifcd(uiBean.getCifcd());
                    }
                    else {
                        mosDairitenVrf.setCifcd("");
                    }

                    mosDairitenVrf.setBosyuucd(bosyuuCdLst.get(index));
                    mosDairitenVrf.setInputbosyuucd(inputBosyuuCdLst.get(index));
                    mosDairitenVrf.setTratkikouinncd(drtTratkikouinCdLst.get(index));
                    mosDairitenVrf.setGyousekikeijyousakisosikicd(gyskkjsakiSosikiCdLst.get(index));
                    mosDairitenVrf.setBunwari(drtBunwariLst.get(index));
                    mosDairitenVrf.setGyoumuKousinsyaId(userID);
                    mosDairitenVrf.setGyoumuKousinTime(sysTime);
                    BizPropertyInitializer.initialize(mosDairitenVrf);
                }
            }

            if (C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn())) {
                HT_UketoriKouzaJyouhouVrf uketoriKouzaJyouhouVrf = syoriCTL.createUketoriKouzaJyouhouVrf();
                uketoriKouzaJyouhouVrf.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);
                uketoriKouzaJyouhouVrf.setKouzainfoinputhoryuukbn(uiBean.getShkstkzinfkzinfoinputhrykbn());
                uketoriKouzaJyouhouVrf.setKzsyuruikbn(uiBean.getKzsyuruikbn());
                uketoriKouzaJyouhouVrf.setBankcd(uiBean.getBankcd());
                uketoriKouzaJyouhouVrf.setSitencd(uiBean.getSitencd());
                uketoriKouzaJyouhouVrf.setYokinkbn(uiBean.getYokinkbn());
                uketoriKouzaJyouhouVrf.setKouzano(uiBean.getKouzano());
                uketoriKouzaJyouhouVrf.setKzkykdoukbn(uiBean.getKzkykdoukbn());
                uketoriKouzaJyouhouVrf.setKzmeiginmkn(uiBean.getShkstkzinfkzinfoNewkzmeiginmkn());
                uketoriKouzaJyouhouVrf.setGyoumuKousinsyaId(userID);
                uketoriKouzaJyouhouVrf.setGyoumuKousinTime(sysTime);
                BizPropertyInitializer.initialize(uketoriKouzaJyouhouVrf);
            }

            if (C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) {

                HT_KouzaJyouhouVrf kouzaJyouhouVrf = syoriCTL.createKouzaJyouhouVrf();
                kouzaJyouhouVrf.setMosno(uiBean.getMosno());
                kouzaJyouhouVrf.setKzmeiginmkn(uiBean.getNewkzmeiginmkn());
                kouzaJyouhouVrf.setKzkykdoukbn(uiBean.getKouhurikouzainfokzdoukbn());
                kouzaJyouhouVrf.setBankcd(uiBean.getKouhurikouzainfobankcd());
                kouzaJyouhouVrf.setSitencd(uiBean.getKouhurikouzainfositencd());
                kouzaJyouhouVrf.setYokinkbn(uiBean.getKouhurikouzainfoyokinkbn());
                kouzaJyouhouVrf.setKouzano(uiBean.getKouhurikouzainfokouzano());
                kouzaJyouhouVrf.setSinkeizkkbn(C_SinkeizkKbn.SHINKI);

                if (C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getKouzainfoinputhoryuukbn())) {
                    kouzaJyouhouVrf.setKouzakakuniniraikbn(uiBean.getKouzakakuniniraikbn());
                }

                kouzaJyouhouVrf.setKzhuritourokuhoukbn(C_KzhuritourokuhouKbn.BLNK);
                kouzaJyouhouVrf.setGyoumuKousinsyaId(userID);
                kouzaJyouhouVrf.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(kouzaJyouhouVrf);
            }
        }

        if (C_KouzaInfoInputHoryuuKbn.HORYUU.eq(uiBean.getKouzainfoinputhoryuukbn())) {
            syoriCTL.setKznrkhbumu(C_UmuKbn.ARI);

        } else {
            syoriCTL.setKznrkhbumu(C_UmuKbn.NONE);
        }

        syoriCTL.setMosuketukekbn(uiBean.getMosuketukekbn());
        syoriCTL.setSkeijimukbn(uiBean.getSkeijimuKbn());
        syoriCTL.setTkhsyouryakuumukbn(uiBean.getTkhsyouryakuumukbn());

        if (C_FatcasnsiKbn.BLNK.eq(uiBean.getFatcasnsikbn()) &&
            C_BikkjnssinfoKbn.BLNK.eq(uiBean.getBikkjnssinfokbn())) {
            syoriCTL.setFatcakakkekkakbn(C_FatcakakkekkaKbn.FATCA_TEIKITYOSAHUYOU);
        }
        else {
            syoriCTL.setFatcakakkekkakbn(C_FatcakakkekkaKbn.BLNK);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getAeoitaisyouumu()) &&
            C_AeoisnsiKbn.BLNK.eq(uiBean.getAeoisnsikbn())) {
            syoriCTL.setAeoikekkakbn(C_AeoiKekkaKbn.HOUKOKUTAISYOUGAI);
        }
        else {
            syoriCTL.setAeoikekkakbn(C_AeoiKekkaKbn.BLNK);
        }

        if (!uiBean.isAiteimousikomiUmu()) {
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);

            if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(syoriKbn)) {
                syoriCTL.setMosnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
            }
            else if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(syoriKbn)) {
                if (nrksaiumu == SaiDataTouroku.NRKSAIARI) {
                    syoriCTL.setMosnrkvrfjkkbn(C_VrfjkKbn.SANJINRKMATI);
                }

                if (nrksaiumu == SaiDataTouroku.NRKSAINASI) {
                    syoriCTL.setMosnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
                    syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
                    syoriCTL.setMosnrkymd(sysDate);

                    mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);

                    if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) {

                        setCreditCardJyouhouFromUiBean(syoriCTL, userID, sysTime, E_CreditCardhnsyuKbn.ADD, false);
                        syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.TOUROKUTYUU);
                    }
                }
            }
            else if (E_SyoriKbn.MOUSIKOMISYO_3JI.equals(syoriKbn)) {
                syoriCTL.setMosnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
                syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
                syoriCTL.setMosnrkymd(sysDate);

                mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);

                if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) {

                    syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.TOUROKUTYUU);

                    if (C_MosUketukeKbn.PAPERLESS.eq(syoriCTL.getMosuketukekbn())) {

                        setCreditCardJyouhouFromUiBean(syoriCTL, userID, sysTime, E_CreditCardhnsyuKbn.ADD_PAPER_LESS, false);
                    }
                    else {

                        setCreditCardJyouhouFromUiBean(syoriCTL, userID, sysTime, E_CreditCardhnsyuKbn.ADD, false);
                    }
                }
            }
            else {
                C_UmuKbn kykKbnHencou = C_UmuKbn.NONE;
                C_UmuKbn hhknHencou = C_UmuKbn.NONE;
                C_UmuKbn kykHencou = C_UmuKbn.NONE;

                C_KykKbn kykKbn = uiBean.getKykkbn();
                C_KykKbn kykKbnInit = uiBean.getInitKykkbn();

                String hhknNmKn = uiBean.getHhknnmkn();
                BizDate hhknSeiYmd = uiBean.getHhknseiymd();
                String hhknYno = uiBean.getHhknyno();
                String hhknNmKnInit = uiBean.getInitHhknnmkn();
                BizDate hhknSeiYmdInit = uiBean.getInitHhknseiymd();
                String hhknYnoInit = uiBean.getInitHhknyno();

                String kykNmKn = uiBean.getKyknmkn();
                BizDate kykSeiYmd = uiBean.getKykseiymd();
                String tsinYno = uiBean.getTsinyno();
                String kykNmKnInit = uiBean.getInitKyknmkn();
                BizDate kykSeiYmdInit = uiBean.getInitKykseiymd();
                String tsinYnoInit = uiBean.getInitTsinyno();

                if (E_SyoriKbn.SYORI_UPD.equals(syoriKbn) ||
                    E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(syoriKbn) ||
                    E_SyoriKbn.SYORI_INPUT_UPD.equals(syoriKbn)) {
                    if (kykKbn.eq(kykKbnInit)) {
                        kykKbnHencou = C_UmuKbn.NONE;
                    }
                    else {
                        kykKbnHencou = C_UmuKbn.ARI;
                    }

                    if (hhknNmKn.equals(hhknNmKnInit) &&
                        BizDateUtil.compareYmd(hhknSeiYmd, hhknSeiYmdInit) == BizDateUtil.COMPARE_EQUAL &&
                        hhknYno.equals(hhknYnoInit)) {
                        hhknHencou = C_UmuKbn.NONE;
                    }
                    else {
                        hhknHencou = C_UmuKbn.ARI;
                    }

                    if (kykNmKn.equals(kykNmKnInit) &&
                        BizDateUtil.compareYmd(kykSeiYmd, kykSeiYmdInit) == BizDateUtil.COMPARE_EQUAL &&
                        tsinYno.equals(tsinYnoInit)) {
                        kykHencou = C_UmuKbn.NONE;
                    }
                    else {
                        kykHencou = C_UmuKbn.ARI;
                    }

                    if (!C_Hrkkeiro.CREDIT.eq(uiBean.getInitHrkkeiro()) &&
                        C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) {

                        setCreditCardJyouhouFromUiBean(syoriCTL, userID, sysTime, E_CreditCardhnsyuKbn.ADD_INPUT_UPD,
                            false);

                        syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.TOUROKUTYUU);
                    }
                    else if (C_Hrkkeiro.CREDIT.eq(uiBean.getInitHrkkeiro()) &&
                        !C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) {

                        syoriCTL.setAuthorikakymd(null);
                        syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.BLNK);

                        List<HT_CreditCardJyouhou> creditCardJyouhou = syoriCTL.getCreditCardJyouhous();
                        creditCardJyouhou.clear();
                        sinkeiyakuDomManager.flush();
                    }
                    if (C_FstphrkkeiroKbn.CREDIT.eq(uiBean.getInitFstphrkkeirokbn()) &&
                        !C_FstphrkkeiroKbn.CREDIT.eq(uiBean.getFstphrkkeirokbn())) {

                        syoriCTL.setAuthorikakymd(null);

                        setCreditCardJyouhouFromUiBean(syoriCTL, userID, sysTime, E_CreditCardhnsyuKbn.UPD_INPUT_UPD,
                            false);
                    }
                }

                if (C_UmuKbn.ARI.eq(kykKbnHencou)) {
                    mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
                    mosnaiCheckParam.setKykKbn_HnkMae(kykKbnInit);
                }
                else if (C_UmuKbn.NONE.eq(kykKbnHencou)) {
                    if (C_UmuKbn.ARI.eq(hhknHencou)) {
                        if (C_UmuKbn.ARI.eq(kykHencou)) {
                            mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
                            mosnaiCheckParam.setKykKbn_HnkMae(kykKbnInit);
                            mosnaiCheckParam.setHhknTeisei(C_UmuKbn.ARI);
                            mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
                        }
                        else if (C_UmuKbn.NONE.eq(kykHencou)) {
                            mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
                            mosnaiCheckParam.setKykKbn_HnkMae(kykKbnInit);
                            mosnaiCheckParam.setHhknTeisei(C_UmuKbn.ARI);
                        }
                    }
                    else if (C_UmuKbn.NONE.eq(hhknHencou)) {
                        if (C_UmuKbn.ARI.eq(kykHencou)) {
                            mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
                            mosnaiCheckParam.setKykKbn_HnkMae(kykKbnInit);
                            mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
                        }
                    }
                }

                if (E_SyoriKbn.SYORI_INPUT_UPD.equals(syoriKbn)) {
                    if (C_UmuKbn.ARI.eq(syoriCTL.getKhnhbkbn())) {
                        syoriCTL.setKhnhbkbn(C_UmuKbn.NONE);
                    }
                }

                syoriCTL.setMosnrkumu(C_UmuKbn.ARI);
            }

            if ((E_SyoriKbn.MOUSIKOMISYO_2JI.equals(syoriKbn) && nrksaiumu == SaiDataTouroku.NRKSAINASI)
                || E_SyoriKbn.MOUSIKOMISYO_3JI.equals(syoriKbn)
                || E_SyoriKbn.SYORI_UPD.equals(syoriKbn)
                || E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(syoriKbn)
                || E_SyoriKbn.SYORI_INPUT_UPD.equals(syoriKbn)) {

                mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);

                if (kikenZou) {
                    mosnaiCheckParam.setKetteiSijiKbn(C_HandketsijiKbn.KIKENZOU_HENKOU_ARI);
                }
                else {
                    mosnaiCheckParam.setKetteiSijiKbn(C_HandketsijiKbn.HUYOU);
                }

                BT_GyoumuKouteiInfo gyoumuKouteiInfo =
                    bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
                if (gyoumuKouteiInfo == null) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
                mosnaiCheckParam.setKinouID(kinou.getKinouId());
                mosnaiCheckParam.setSysDate(sysDate);
                mosnaiCheckParam.setKosID(userID);
                mosnaiCheckParam.setKosTime(sysTime);
                mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
                mosnaiCheckParam.debug("申込書入力");

                mosnaiCheck.exec(mosnaiCheckParam);

                uiBean.setKykymd(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getKykymd());
                uiBean.setSknnkaisiymd(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getSknnkaisiymd());
                uiBean.setBosyuuym(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getBosyuuym());
                uiBean.setSeisekiym(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getSeisekiym());
                uiBean.setHhknnen(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getHhknnen());
                uiBean.setKyknen(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getKyknen());
                uiBean.setNrksaiumu(nrksaiumu);
                uiBean.setDairitenbuntanwariai1(zeroToOptional(mosnaiCheckParam.getDataSyoriControl().getMosDairitens()
                    .get(0).getBunwari()));
                if (mosnaiCheckParam.getDataSyoriControl().getMosDairitens().size() > 1) {
                    uiBean.setDairitenbuntanwariai2(zeroToOptional(
                        mosnaiCheckParam.getDataSyoriControl().getMosDairitens().get(1).getBunwari()));
                }

                if (mosnaiCheckParam.getDataSyoriControl().getMosKihon().getZnnkai() > 0) {
                    uiBean.setZnnkai(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getZnnkai() + 1);
                }
                else {
                    uiBean.setZnnkai(mosnaiCheckParam.getDataSyoriControl().getMosKihon().getZnnkai());
                }

                if(mosnaiCheckParam.getListSkDenpyoData().size() > 0){
                    sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
                }
            }

            if (!E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(syoriKbn)) {
                syoriCTL.setGyoumuKousinsyaId(userID);
                syoriCTL.setGyoumuKousinTime(sysTime);
                BizPropertyInitializer.initialize(syoriCTL);

                if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(syoriKbn) &&
                    !E_InsUpdKbn.INSUPDCTRL_INS.equals(uiBean.getInsUpdKbn())) {
                    sinkeiyakuDomManager.update(syoriCTL);
                }
                else if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(syoriKbn) &&
                    E_InsUpdKbn.INSUPDCTRL_INS.equals(uiBean.getInsUpdKbn())) {
                    sinkeiyakuDomManager.insert(syoriCTL);
                }
                else if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(syoriKbn) && nrksaiumu == SaiDataTouroku.NRKSAIARI) {
                    sinkeiyakuDomManager.update(syoriCTL);
                }
                else if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(syoriKbn) ||
                    E_SyoriKbn.MOUSIKOMISYO_3JI.equals(syoriKbn) ||
                    E_SyoriKbn.SYORI_INPUT_UPD.equals(syoriKbn) ||
                    E_SyoriKbn.SYORI_UPD.equals(syoriKbn)) {
                    sinkeiyakuDomManager.update(syoriCTL);
                    bizDomManager.update(mosnaiCheckParam.getGyoumuKouteiInfo());
                }

                if (!E_SyoriKbn.MOUSIKOMISYO_1JI.equals(syoriKbn)) {
                    HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                    mosKihon.setGyoumuKousinsyaId(userID);
                    mosKihon.setGyoumuKousinTime(sysTime);

                    if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(syoriKbn)) {
                        sinkeiyakuDomManager.update(syoriCTL);

                        if (nrksaiumu == SaiDataTouroku.NRKSAINASI) {
                            bizDomManager.update(mosnaiCheckParam.getGyoumuKouteiInfo());
                        }
                    }
                    else if (E_SyoriKbn.MOUSIKOMISYO_3JI.equals(syoriKbn) ||
                        E_SyoriKbn.SYORI_INPUT_UPD.equals(syoriKbn) ||
                        E_SyoriKbn.SYORI_UPD.equals(syoriKbn)) {
                        sinkeiyakuDomManager.update(syoriCTL);
                        bizDomManager.update(mosnaiCheckParam.getGyoumuKouteiInfo());
                    }
                }
                else {
                    sinkeiyakuDomManager.update(syoriCTL);
                }

                if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                    if ((E_SyoriKbn.MOUSIKOMISYO_2JI.equals(syoriKbn) && nrksaiumu == SaiDataTouroku.NRKSAINASI)
                        || E_SyoriKbn.MOUSIKOMISYO_3JI.equals(syoriKbn)) {

                        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(uiBean.getAitemosno());
                        syoriCTL2.setMosnrkumu(syoriCTL.getMosnrkumu());
                        syoriCTL2.setMosnrkymd(syoriCTL.getMosnrkymd());

                        HT_MosKihon mosKihon = syoriCTL2.createMosKihon();

                        mosKihon.setMosno(uiBean.getAitemosno());

                        sinkeiyakuDomManager.insert(syoriCTL2);

                        sinkeiyakuDomManager.flush();

                        SetMossykykyoteiymd setMossykykyoteiymd = SWAKInjector.getInstance(SetMossykykyoteiymd.class);
                        HT_MosnoKanri mosnoKanri = setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL2,
                            BizDate.getSysDate(), baseUserInfo.getUserId());

                        sinkeiyakuDomManager.update(mosnoKanri);

                        sinkeiyakuDomManager.delete(syoriCTL2);
                    }
                }

                BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
                String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();
                skProcessUpdate(syoriCTL, kouteiLockKey, false);
            }

            setMessage(mosnaiCheckParam, resultBtnMessage);

            setHubiMessage(uiBean.getMosno(), false);

            skProcessForward(uiBean.getMosno(), false);

            setKykNaiyouHanei(syoriCTL, null);
        }

        if (uiBean.isAiteimousikomiUmu()) {

            if ((E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
                uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAINASI) ||
                E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
                GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();
                HT_SyoriCTL syoriCTL2 = setMousikomiZouhaba(syoriCTL, getSyouhnZokuseiCtrlOutBean, userID, sysTime,
                    sysDate, nrksaiumu);

                mosnaiCheckParam2.setDataSyoriControl(syoriCTL2);

                if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) {

                    setCreditCardJyouhouFromUiBean(syoriCTL2, userID, sysTime, E_CreditCardhnsyuKbn.ADD, true);
                    syoriCTL2.setCredittrkjkkbn(C_CreditTrkjkKbn.TOUROKUTYUU);
                }

                if (uiBean.isTaihyoumousikomiUmu()) {
                    mosnaiCheckParam.setDataSyoriControl(syoriCTL);

                    if (C_Hrkkeiro.CREDIT.eq(uiBean.getHrkkeiro())) {

                        setCreditCardJyouhouFromUiBean(syoriCTL, userID, sysTime, E_CreditCardhnsyuKbn.ADD, false);
                        syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.TOUROKUTYUU);
                    }
                    mosnaiCheck(syoriCTL, mosnaiCheckParam, uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
                        kikenZou, sysDate, userID, sysTime);

                    setMessage(mosnaiCheckParam, resultBtnMessage);

                    setHubiMessage(uiBean.getMosno(), false);
                    BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
                    String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();
                    skProcessUpdate(syoriCTL, kouteiLockKey, true);

                    skProcessForward(uiBean.getMosno(), true);

                    SkProcessCreate skProcessCreate = SWAKInjector.getInstance(SkProcessCreate.class);

                    String kouteiKanriId = skProcessCreate.copyKouteiInfos(
                        uiBean.getMosno(), uiBean.getAitemosno(), syoriCTL2.getSyono(), kinouMode);

                    if (BizUtil.isBlank(kouteiKanriId)) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0008));
                    }

                    uiBean.setZouhabakouteikanriid(kouteiKanriId);

                    mosnaiCheck(syoriCTL2, mosnaiCheckParam2, kouteiKanriId,
                        kikenZou, sysDate, userID, sysTime);

                    dbUpdateTableCommit(syoriCTL, syoriCTL2, mosnaiCheckParam.getGyoumuKouteiInfo(),
                        mosnaiCheckParam2.getGyoumuKouteiInfo(), userID, sysTime);

                    setMessage(mosnaiCheckParam2, resultBtnMessage);

                    setHubiMessage(uiBean.getAitemosno(), true);

                    skProcessUpdate(syoriCTL2, null, true);

                    setKykNaiyouHanei(syoriCTL, syoriCTL2);
                }
                else {
                    BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
                    String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

                    SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

                    List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = skProcessUpdate.changeKouteikanriMosNo(syoriCTL2,
                        uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(), kouteiLockKey, null);

                    uiBean.setGyoumuKouteiInfoLst(gyoumuKouteiInfoLst);

                    for (BT_GyoumuKouteiInfo gyoumuKouteiInfo : uiBean.getGyoumuKouteiInfoLst()) {
                        if (ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN.equals(gyoumuKouteiInfo.getJimutetuzukicd())) {
                            uiBean.setKrkekouteikanriid(gyoumuKouteiInfo.getKouteikanriid());
                            break;
                        }
                    }

                    mosnaiCheck(syoriCTL2, mosnaiCheckParam2, uiBean.getKrkekouteikanriid(), kikenZou, sysDate, userID,
                        sysTime);

                    dbUpdateTableCommit(null, syoriCTL2, null, mosnaiCheckParam2.getGyoumuKouteiInfo(), userID, sysTime);

                    setMessage(mosnaiCheckParam2, resultBtnMessage);

                    setHubiMessage(uiBean.getAitemosno(), true);

                    skProcessUpdate(syoriCTL2, null, true);

                    skProcessForward(uiBean.getAitemosno(), true);

                    sinkeiyakuDomManager.delete(syoriCTL);

                    setKykNaiyouHanei(null, syoriCTL2);
                }
            }
        }

        doUnlockProcess();

        uiBean.setKakuninmessage(null);
    }

    void pushModoruBtnByConfirmBL() {

        doContinueLockProcess();

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn())
            || E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn())) {

            HT_BosKihon bosKihon = uiBean.getBosKihon();

            C_UmuKbn bosInfoUmu;
            if (bosKihon != null) {
                bosInfoUmu = C_UmuKbn.ARI;
            }
            else {
                bosInfoUmu = C_UmuKbn.NONE;
            }

            chkWarning(bosInfoUmu);
        }
        else if (E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
            chkWarning(null);
        }

        uiBean.setSbuktbnwari1(uiBean.getTaihisbuktbnwari1());
        uiBean.setSyudai1hknkknmosinput(uiBean.getTaihisyudai1hknkkn());
        uiBean.setDairitenbuntanwariai1(uiBean.getTaihidairitenbuntanwariai1());
        uiBean.setKouhurikouzainfokzmeiginmkn(uiBean.getNewkzmeiginmkn());
        uiBean.setKzmeiginmkn(uiBean.getShkstkzinfkzinfoNewkzmeiginmkn());

        if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
            uiBean.setKyktuukasyu(uiBean.getTaihikyktuukasyu());
            uiBean.setHrktuukasyu(uiBean.getTaihihrktuukasyu());
            uiBean.setKyktuukasyu2(uiBean.getTaihikyktuukasyu2());
            uiBean.setHrktuukasyu2(uiBean.getTaihihrktuukasyu2());
            uiBean.setKyktuukasyumosinput(uiBean.getTaihikyktuukasyu().getValue());
            uiBean.setHrktuukasyumosinput(uiBean.getTaihihrktuukasyu().getValue());
            uiBean.setKyktuukasyu2mosinput(uiBean.getTaihikyktuukasyu2().getValue());
            uiBean.setHrktuukasyu2mosinput(uiBean.getTaihihrktuukasyu2().getValue());
        }

        if (!C_IkkatubaraiKaisuuKbn.BLNK.eq(uiBean.getIkkatubaraikaisuu())) {
            uiBean.setHrktuukasyukykp(BizCurrency.optional());
            uiBean.setHrktuukasyukykp2(BizCurrency.optional());
        }

        uiBean.setMosfstpkei(BizCurrency.optional());
        uiBean.setMosfstpkei2(BizCurrency.optional());
        uiBean.setAiteimousikomiUmu(false);
        uiBean.setTaihyoumousikomiUmu(false);
        uiBean.setTaihikyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setTaihihrktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setTaihikyktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setTaihihrktuukasyu2(C_Tuukasyu.BLNK);

        uiBean.setKakuninmessage(null);

        if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getHokenkngkyakujyouumu())) {
            uiBean.setSdpdkbn(uiBean.getTaihisdpdkbn());
        }
    }

    void removeObj() {
        objStrMan.remove(uiBean.getUniqueId());
        objStrMan.remove(uiBean.getUniqueid2());
    }

    void doUnlockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }

    void printHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    @SuppressWarnings("resource")
    void callAjaxCommonBL() throws IOException {
        HttpServletRequest request = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);

        String ajaxSyoriKbn = request.getParameter(AJAX_POST_PARAM_SYORIKBN);

        List<String> outStrLst = Lists.newArrayList();

        if (AJAX_POST_SYORIKBN_ADDRESSSRCH.equals(ajaxSyoriKbn)) {
            String postalCd = request.getParameter(AJAX_POST_PARAM_POSTALCD);
            if (!BizUtil.isBlank(postalCd)) {
                outStrLst = ajaxAddressSrch(postalCd);
            }
            else {
                outStrLst.add("");
                outStrLst.add("");
                outStrLst.add("");
            }
        }
        else if (AJAX_POST_SYORIKBN_AISYOUMEISET.equals(ajaxSyoriKbn)) {

            String inputHknsyuruiNo = request.getParameter(AJAX_POST_PARAM_HKNSYURUINO);
            if (!BizUtil.isBlank(inputHknsyuruiNo)) {
                Integer hknsyuruiNoSd = Integer.parseInt(request.getParameter(AJAX_POST_PARAM_HKNSYURUINOSD));
                C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.valueOf(request.getParameter(AJAX_POST_PARAM_SKEIJIMUKBN));
                String psyouhncd = request.getParameter(AJAX_POST_PARAM_SYOUHNCD);

                outStrLst = ajaxAisyoumeiSet(inputHknsyuruiNo, hknsyuruiNoSd, skeiJimuKbn, psyouhncd);
            }
            else {
                outStrLst.add("");
            }
        }
        else if (AJAX_POST_SYORIKBN_SYOKUGYOUMEISET.equals(ajaxSyoriKbn)) {
            String syokugyouCd = request.getParameter(AJAX_POST_PARAM_SYOKUGYOUCD);
            outStrLst = ajaxSyokugyoumeiSet(syokugyouCd);
        }
        else if (AJAX_POST_SYORIKBN_CURRENCYCHANGE.equals(ajaxSyoriKbn)) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));
            String tuukahenkankm = request.getParameter(AJAX_POST_PARAM_TUUKAHENKANKM);
            outStrLst = ajaxCurrencyChange(tuukasyu, tuukahenkankm);
        }
        else if (AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_BEI.equals(ajaxSyoriKbn)) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));
            String tuukahenkankm = request.getParameter(AJAX_POST_PARAM_TUUKAHENKANKM);
            outStrLst = ajaxCurrencyChange(tuukasyu, tuukahenkankm);
        }
        else if (AJAX_POST_SYORIKBN_MOSIKKATUP_BEI.equals(ajaxSyoriKbn)) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));
            String tuukahenkankm = request.getParameter(AJAX_POST_PARAM_TUUKAHENKANKM);
            outStrLst = ajaxCurrencyChange(tuukasyu, tuukahenkankm);
        }
        else if (AJAX_POST_SYORIKBN_MOSSYUKYKP_BEI.equals(ajaxSyoriKbn)) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));
            String tuukahenkankm = request.getParameter(AJAX_POST_PARAM_TUUKAHENKANKM);
            outStrLst = ajaxCurrencyChange(tuukasyu, tuukahenkankm);
        }
        else if (AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_BEI.equals(ajaxSyoriKbn)) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));
            String tuukahenkankm = request.getParameter(AJAX_POST_PARAM_TUUKAHENKANKM);
            outStrLst = ajaxCurrencyChange(tuukasyu, tuukahenkankm);
        }
        else if (AJAX_POST_SYORIKBN_CURRENCYCHANGE_GOU.equals(ajaxSyoriKbn)) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));
            String tuukahenkankm = request.getParameter(AJAX_POST_PARAM_TUUKAHENKANKM);
            outStrLst = ajaxCurrencyChange(tuukasyu, tuukahenkankm);
        }
        else if (AJAX_POST_SYORIKBN_HRKTUUKASYUKYKP_GOU.equals(ajaxSyoriKbn)) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));
            String tuukahenkankm = request.getParameter(AJAX_POST_PARAM_TUUKAHENKANKM);
            outStrLst = ajaxCurrencyChange(tuukasyu, tuukahenkankm);

        }
        else if (AJAX_POST_SYORIKBN_MOSIKKATUP_GOU.equals(ajaxSyoriKbn)) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));
            String tuukahenkankm = request.getParameter(AJAX_POST_PARAM_TUUKAHENKANKM);
            outStrLst = ajaxCurrencyChange(tuukasyu, tuukahenkankm);
        }
        else if (AJAX_POST_SYORIKBN_MOSZENNOUPSYOKAIARI_GOU.equals(ajaxSyoriKbn)) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));

            String tuukahenkankm = request.getParameter(AJAX_POST_PARAM_TUUKAHENKANKM);
            outStrLst.addAll(ajaxCurrencyChange(tuukasyu, tuukahenkankm));
        }
        String responseJson = JSON.encode(outStrLst);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(responseJson);
        out.close();
    }

    private void doContinueLockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();
    }

    private List<String> ajaxAddressSrch(String pPostalCd) {
        List<String> outStrLst = Lists.newArrayList();

        BzGetAdrData bzGetAdrData = SWAKInjector.getInstance(BzGetAdrData.class);
        bzGetAdrData.execAdrKanjiByPostalcd(pPostalCd);
        if (C_ErrorKbn.ERROR.eq(bzGetAdrData.getErrorKbn())) {
            throw new BizLogicException(MessageId.EHA0333);
        }

        outStrLst.add(bzGetAdrData.getAdrKanji1());
        outStrLst.add(bzGetAdrData.getAdrKanji2());
        outStrLst.add(bzGetAdrData.getAdrKanji3());

        return outStrLst;
    }

    private List<String> ajaxAisyoumeiSet(String pInputHknsyuruiNo, Integer pHknsyuruiNoSd, C_SkeijimuKbn pSkeiJimuKbn,
        String pSyouhncd) {
        List<String> outStrLst = Lists.newArrayList();

        uiBean.setHknsyuruinomosinput(pInputHknsyuruiNo);
        uiBean.setHknsyuruinosd(pHknsyuruiNoSd);
        uiBean.setSkeijimuKbn(pSkeiJimuKbn);
        uiBean.setSyouhncd(pSyouhncd);

        setAisyoumei();

        uiBean.setAisyoumei(uiBean.getAisyoumeikbn().getContent(C_AisyoumeiKbn.PATTERN_SKMOUSIKOMI));

        outStrLst.add(uiBean.getAisyoumei());

        return outStrLst;
    }

    private List<String> ajaxSyokugyoumeiSet(String pSyokugyouCd) {
        List<String> outStrLst = Lists.newArrayList();
        outStrLst.add(getSyokugyouNm(pSyokugyouCd));
        return outStrLst;
    }

    private List<String> ajaxCurrencyChange(C_Tuukasyu pTuukasyu, String pTuukahenkankm) {
        List<String> outStrLst = Lists.newArrayList();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);
        BizCurrency initKingaku = BizCurrency.optional(currencyType);

        outStrLst.add(initKingaku.toString());
        outStrLst.add(initKingaku.toPattern());
        outStrLst.add(currencyType.getUnitValue());
        outStrLst.add(currencyType.toString());

        if (AJAX_POST_TUUKAHENKANKMNM_SYUKIHONS.equals(pTuukahenkankm)) {
            uiBean.setSyukihons(initKingaku);
        }
        else if (AJAX_POST_PARAM_HRKTUUKASYUKYKP.equals(pTuukahenkankm)) {
            uiBean.setHrktuukasyukykp(initKingaku);
        }
        else if (AJAX_POST_PARAM_MOSIKKATUP.equals(pTuukahenkankm)) {
            uiBean.setMosikkatup(initKingaku);
        }
        else if (AJAX_POST_PARAM_MOSSYUKYKP.equals(pTuukahenkankm)) {
            uiBean.setMossyukykp(initKingaku);
        }
        else if (AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI.equals(pTuukahenkankm)) {
            uiBean.setMoszennoupsyokaiari(initKingaku);
        }
        else if (AJAX_POST_TUUKAHENKANKMNM_KIHONS2.equals(pTuukahenkankm)) {
            uiBean.setKihons2(initKingaku);
        }
        else if (AJAX_POST_PARAM_HRKTUUKASYUKYKPM2.equals(pTuukahenkankm)) {
            uiBean.setHrktuukasyukykp2(initKingaku);
        }
        else if (AJAX_POST_PARAM_MOSIKKATUP2.equals(pTuukahenkankm)) {
            uiBean.setMosikkatup2(initKingaku);
        }
        else if (AJAX_POST_PARAM_MOSZENNOUPSYOKAIARI2.equals(pTuukahenkankm)) {
            uiBean.setMoszennoupsyokaiari2(initKingaku);
        }
        return outStrLst;
    }

    private void lockProcessGetProcessInfoWorkList() {

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean)
            .get(0);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBean.getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);

        setHonninKakninInfoPtn();
    }

    private void lockProcessGetProcessInfoMenu() {
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanList == null || bzGetProcessSummaryOutBeanList.size() == 0) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        uiBean.setSkeijimuKbn(bzGetProcessSummaryOutBean.getSkeijimuKbn());
        uiBean.setMosuketukekbn(bzGetProcessSummaryOutBean.getMosUketukeKbn());
        uiBean.setHknsyuruinomosinput(bzGetProcessSummaryOutBean.getHknsyuruiNo().getValue());
        uiBean.setInitHokenSyuruiNo(uiBean.getHknsyuruino());

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn())) {
            uiBean.setJimuyoucd(bzGetProcessSummaryOutBean.getJimuyoucd());
        }

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBean.getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        bzGetProcessSummaryOutBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0);

        uiBean.getBzWorkflowInfo().setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

        E_SyoriKbn syoriKbn = uiBean.getSyoriKbn();

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(syoriKbn)) {
            uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_MOSNYUURYOKU_1JI);
        }
        else if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(syoriKbn)) {
            uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_MOSNYUURYOKU_2JI);
        }
        else if (E_SyoriKbn.MOUSIKOMISYO_3JI.equals(syoriKbn)) {
            uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_MOSNYUURYOKU_3JI);
        }
        else if (E_SyoriKbn.SYORI_UPD.equals(syoriKbn)) {
            uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_MOSNYUURYOKU_UPD);
        }
        else if (E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(syoriKbn)) {
            uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_MOSNYUURYOKU_UPD_SYOUKAI);
        }
        else if (E_SyoriKbn.SYORI_INPUT_UPD.equals(syoriKbn)) {
            uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_MOSNYUURYOKU_INS_UPD);
        }

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);

        setHonninKakninInfoPtn();
    }

    private void startTask() {
        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            bzCommonLockProcess.getKouteiLockKey(),
            baseUserInfo.getUserId());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }
    }

    private void setUiBeanFromMosKihon(HT_MosKihon pMosKihon, E_SyoriKbn pGamenSyoriKbn) {
        if (!E_SyoriKbn.MOUSIKOMISYO_3JI.equals(pGamenSyoriKbn)) {
            uiBean.setInitKykkbn(pMosKihon.getKykkbn());
            uiBean.setInitHhknnmkn(pMosKihon.getHhknnmkn());
            uiBean.setInitHhknseiymd(pMosKihon.getHhknseiymd());
            uiBean.setInitHhknyno(pMosKihon.getHhknyno());
            uiBean.setInitKyknmkn(pMosKihon.getKyknmkn());
            uiBean.setInitKykseiymd(pMosKihon.getKykseiymd());
            uiBean.setInitTsinyno(pMosKihon.getTsinyno());
            uiBean.setInitHrkkeiro(pMosKihon.getHrkkeiro());
            uiBean.setInitFstphrkkeirokbn(pMosKihon.getFstphrkkeirokbn());
        }

        uiBean.setAitemosno(pMosKihon.getAitemosno());
        uiBean.setDoujikaiyakusyono(pMosKihon.getDoujikaiyakusyono());
        uiBean.setMosymd(pMosKihon.getMosymd());
        uiBean.setKktymd(pMosKihon.getKktymd());
        uiBean.setKykkbn(pMosKihon.getKykkbn());
        uiBean.setHknsyuruinomosinput(pMosKihon.getHknsyuruino().getValue());
        uiBean.setNkgnshosyouritukbn(pMosKihon.getNkgnshosyouritukbn());
        uiBean.setKzktourokuservicetourokukbn(pMosKihon.getKzktourokuservicetourokukbn());
        uiBean.setKykdrtkykhukakbn(pMosKihon.getKykdrtkykhukakbn());
        uiBean.setStdrsktkyhkkbn(pMosKihon.getStdrsktkyhkkbn());
        uiBean.setSdpdkbn(pMosKihon.getSdpdkbn());
        uiBean.setSntkhoukbn(pMosKihon.getSntkhoukbn());
        uiBean.setHaitoukbn(pMosKihon.getHaitoukbn());

        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getGaikatatkiumu())) {
            uiBean.setKyktuukasyumosinput(pMosKihon.getKyktuukasyu().getValue());
            uiBean.setHrktuukasyumosinput(pMosKihon.getHrktuukasyu().getValue());
            uiBean.setKyktuukasyu2mosinput(pMosKihon.getKyktuukasyu2().getValue());
            uiBean.setHrktuukasyu2mosinput(pMosKihon.getHrktuukasyu2().getValue());
        }

        uiBean.setYennykntkhkkbn(pMosKihon.getYennykntkhkkbn());
        uiBean.setGaikanykntkhkkbn(pMosKihon.getGaikanykntkhkkbn());
        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn())) {
            uiBean.setHrktuukasyukykp(zeroToOptional(pMosKihon.getMosheijyunp()));
        }

        uiBean.setIkkatubaraikaisuumosinput(pMosKihon.getIkkatubaraikaisuu().getValue());
        uiBean.setMosikkatup(zeroToOptional(pMosKihon.getMosikkatup()));
        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn())) {
            uiBean.setMossyukykp(zeroToOptional(pMosKihon.getMosheijyunp()));
        }

        uiBean.setZenkizennouumumosinput(pMosKihon.getZenkizennouumu().getValue());
        uiBean.setMoszennoupsyokaiari(zeroToOptional(pMosKihon.getMoszennoupsyokaiari()));
        uiBean.setHrkkaisuumosinput(pMosKihon.getHrkkaisuu().getValue());
        uiBean.setHrkkeiro(pMosKihon.getHrkkeiro());
        uiBean.setFstphrkkeirokbn(pMosKihon.getFstphrkkeirokbn());
        uiBean.setHhknnmkn(pMosKihon.getHhknnmkn());
        uiBean.setHhknnmkj(pMosKihon.getHhknnmkj());
        uiBean.setHhknnmkjkhukakbn(pMosKihon.getHhknnmkjkhukakbn());
        uiBean.setHhknseiymd(pMosKihon.getHhknseiymd());
        uiBean.setHhknsei(pMosKihon.getHhknsei());
        uiBean.setHhknsykgycd(pMosKihon.getHhknsykgycd());
        uiBean.setHhknnensyuukbn(pMosKihon.getHhknnensyuukbn());
        uiBean.setTsindousiteikbn(pMosKihon.getTsindousiteikbn());
        uiBean.setHhknyno(pMosKihon.getHhknyno());
        uiBean.setHhknadr1kj(pMosKihon.getHhknadr1kj());
        uiBean.setHhknadr2kj(pMosKihon.getHhknadr2kj());
        uiBean.setHhknadr3kj(pMosKihon.getHhknadr3kj());
        uiBean.setHhkntelno(pMosKihon.getHhkntelno());
        uiBean.setKyknmkn(pMosKihon.getKyknmkn());
        uiBean.setKyknmkj(pMosKihon.getKyknmkj());
        uiBean.setKyknmkjkhukakbn(pMosKihon.getKyknmkjkhukakbn());
        uiBean.setKykseiymd(pMosKihon.getKykseiymd());
        uiBean.setKyksei(pMosKihon.getKyksei());
        uiBean.setKyktdk(pMosKihon.getKyktdk());
        uiBean.setFatcasnsikbn(pMosKihon.getFatcasnsikbn());
        uiBean.setBikkjnssinfokbn(pMosKihon.getBikkjnssinfokbn());
        uiBean.setBikknzsyno(pMosKihon.getBikknzsyno());
        uiBean.setAeoisnsikbn(pMosKihon.getAeoisnsikbn());
        uiBean.setTsinyno(pMosKihon.getTsinyno());
        uiBean.setTsinadr1kj(pMosKihon.getTsinadr1kj());
        uiBean.setTsinadr2kj(pMosKihon.getTsinadr2kj());
        uiBean.setTsinadr3kj(pMosKihon.getTsinadr3kj());
        uiBean.setTsintelno(pMosKihon.getTsintelno());
        uiBean.setDai2tsintelno(pMosKihon.getDai2tsintelno());
        uiBean.setTargettkmkhtkbn(pMosKihon.getTargettkmkhtkbn());
        uiBean.setMkhgkwarimosinput(pMosKihon.getTargettkmkhtkbn().getValue());
        uiBean.setNstkhkkbn(pMosKihon.getNstkhkkbn());
        uiBean.setNstksbnkkn(zeroToNull(pMosKihon.getNstksbnkkn()));
        uiBean.setSyksbyensitihsyutkhkkbn(pMosKihon.getSyksbyensitihsyutkhkkbn());
        uiBean.setJyudkaigomehrtkhkkbn(pMosKihon.getJyudkaigomehrtkhkkbn());
        uiBean.setSbuktnin(zeroToNull(pMosKihon.getSbuktnin()));
        uiBean.setKykhonninkakninsyoruikbn(pMosKihon.getKykhonninkakninsyoruikbn());
        uiBean.setSkskknhonninkakninsyoruikbn(pMosKihon.getSkskknhonninkakninsyoruikbn());
        uiBean.setUktkid(pMosKihon.getUktkid());
        uiBean.setDrctservicemoskbn(pMosKihon.getDrctservicemoskbn());
        uiBean.setTsryhshrkykumukbn(pMosKihon.getTsryhshrkykumukbn());
        uiBean.setSyosisyatodokeumukbn(pMosKihon.getSyosisyatodokeumukbn());
        uiBean.setKakukisyouryakukbumukbn(pMosKihon.getKakukisyouryakukbumukbn());
        uiBean.setSeiymdmosseitouumukbn(pMosKihon.getSeiymdmosseitouumukbn());
        uiBean.setTrtkhoukokusyotokkijkumu(pMosKihon.getTrtkhoukokusyotokkijkumu());
        uiBean.setHnnkakninhskjikouumukbn(pMosKihon.getHnnkakninhskjikouumukbn());
        uiBean.setHnnkakninhsktkjikouumukbn(pMosKihon.getHnnkakninhsktkjikouumukbn());
        uiBean.setSkskakninhsktkjikouumukbn(pMosKihon.getSkskakninhsktkjikouumukbn());
        uiBean.setKhnchkcmnt(pMosKihon.getKhnchkcmnt());
        uiBean.setMobilebosyuukbn(pMosKihon.getMobilebosyuukbn());
        uiBean.setJimuyoucd(pMosKihon.getJimuyoucd());
        uiBean.setMoscalckijyunymd(pMosKihon.getMoscalckijyunymd());
        uiBean.setTeirituhaibunwarikbn(pMosKihon.getTeirituhaibunwarikbn());
        uiBean.setSisuuhaibunwarikbn(pMosKihon.getSisuuhaibunwarikbn());
        uiBean.setKjnnkpzeitekitkhukakbn(pMosKihon.getKjnnkpzeitekitkhukakbn());
        uiBean.setHrktuukasyukykp2(zeroToOptional(pMosKihon.getMosheijyunp2()));
        uiBean.setMosikkatup2(zeroToOptional(pMosKihon.getMosikkatup2()));
        uiBean.setMoszennoupsyokaiari2(zeroToOptional(pMosKihon.getMoszennoupsyokaiari2()));
        uiBean.setKjnnkpzeitekitkhukakbn2(pMosKihon.getKjnnkpzeitekitkhukakbn2());
        if (pMosKihon.getZnnkai() > 0) {

            uiBean.setZnnkai(pMosKihon.getZnnkai() + 1);
        }
        else {

            uiBean.setZnnkai(pMosKihon.getZnnkai());
        }
        uiBean.setYakkanjyuryouhoukbn(pMosKihon.getYakkanjyuryouhoukbn());
        uiBean.setTeikisiharaitkykhkkbn(pMosKihon.getTeikisiharaitkykhkkbn());
        uiBean.setKoureikzksetumeihoukbn(pMosKihon.getKoureikzksetumeihoukbn());
        uiBean.setKoureimndnhukusuukaikbn(pMosKihon.getKoureimndnhukusuukaikbn());
        uiBean.setKoureitratkisyaigidskkbn(pMosKihon.getKoureitratkisyaigidskkbn());
        uiBean.setYnkhrkmgkannituutikbn(pMosKihon.getYnkhrkmgkannituutikbn());
    }

    private void setUiBeanFromMosSyouhnSyuKeiyaku(HT_MosSyouhn pMosSyouhn) {

        uiBean.setNenkinsyumosinput(pMosSyouhn.getSknenkinsyu().toString());
        uiBean.setSyukihons(zeroToOptional(pMosSyouhn.getKihons()));

        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();
        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn())) {
            uiBean.setHrktuukasyukykp(zeroToOptional(pMosSyouhn.getHrktuukasyutkp()));
        }
        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn())) {
            uiBean.setMossyukykp(zeroToOptional(pMosSyouhn.getHrktuukasyutkp()));
        }

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getNkhknumu()) &&
            C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getItijibrumu())) {

            uiBean.setSueokikknmosinput(pMosSyouhn.getHknkkn().toString());

        }
        else {

            uiBean.setSyuhknkkn(pMosSyouhn.getHknkkn());
        }

        uiBean.setSyuhrkkkn(pMosSyouhn.getHrkkkn());
        uiBean.setSyuhknkknsmnkbn(pMosSyouhn.getHknkknsmnkbn());
        uiBean.setSyuhrkkknsmnkbn(pMosSyouhn.getHrkkknsmnkbn());
        uiBean.setSyudai1hknkknmosinput(String.valueOf(pMosSyouhn.getDai1hknkkn()));
        uiBean.setKihons2(zeroToOptional(pMosSyouhn.getKihons2()));
        uiBean.setHrktuukasyukykp2(zeroToOptional(pMosSyouhn.getHrktuukasyutkp2()));
    }

    //    private void setUiBeanFromMosSyouhnTokuyaku(List<HT_MosSyouhn> pMosSyouhnLst, E_SyoriKbn pGamenSyoriKbn) {
    //
    //        int cnt = 0;
    //
    //        List<String> initTksyouhinCdLst = new ArrayList<>(MAX_TOKUYAKU);
    //        List<C_KataKbn> initTkkataKbnLst = new ArrayList<>(MAX_TOKUYAKU);
    //        List<BizCurrency> initTkkhnsLst = new ArrayList<>(MAX_TOKUYAKU);
    //
    //        List<String> tksyouhinCdLst = new ArrayList<>(MAX_TOKUYAKU);
    //        List<C_KataKbn> tkkataKbnLst = new ArrayList<>(MAX_TOKUYAKU);
    //        List<C_KyhgndkataKbn> tkkyhkataKbnLst = new ArrayList<>(MAX_TOKUYAKU);
    //        List<BizCurrency> tkkhnsLst = new ArrayList<>(MAX_TOKUYAKU);
    //        List<Integer> tkhknkknLst = new ArrayList<>(MAX_TOKUYAKU);
    //        List<C_HknkknsmnKbn> tkhknkknmnKbnLst = new ArrayList<>(MAX_TOKUYAKU);
    //        List<Integer> tkhrkkknLst = new ArrayList<>(MAX_TOKUYAKU);
    //        List<C_HrkkknsmnKbn> tkhrkkknmnKbn = new ArrayList<>(MAX_TOKUYAKU);
    //
    //        for (HT_MosSyouhn mosSyouhn : pMosSyouhnLst) {
    //            String syouhncd = mosSyouhn.getSyouhncd();
    //            C_KataKbn kataKbn = mosSyouhn.getKatakbn();
    //
    //            if (!E_SyoriKbn.MOUSIKOMISYO_SYUUSEI.equals(pGamenSyoriKbn)) {
    //                initTksyouhinCdLst.add(syouhncd);
    //
    //                if (C_KataKbn.HONNIN.eq(kataKbn)) {
    //                    initTkkataKbnLst.add(C_KataKbn.BLNK);
    //                }
    //                else {
    //                    initTkkataKbnLst.add(kataKbn);
    //                }
    //
    //                if (SyouhinUtil.isSensinIryoTk(syouhncd)) {
    //                    initTkkhnsLst.add(BizCurrency.optional());
    //                }
    //                else {
    //                    initTkkhnsLst.add(mosSyouhn.getKihons());
    //                }
    //            }
    //
    //            tksyouhinCdLst.add(syouhncd);
    //
    //            if (SyouhinUtil.isSensinIryoTk(syouhncd)) {
    //                tkkhnsLst.add(BizCurrency.optional());
    //            }
    //            else {
    //                tkkhnsLst.add(mosSyouhn.getKihons());
    //            }
    //
    //            if (C_KataKbn.HONNIN.equals(kataKbn)) {
    //                tkkataKbnLst.add(C_KataKbn.BLNK);
    //            }
    //            else {
    //                tkkataKbnLst.add(kataKbn);
    //            }
    //
    //            tkkyhkataKbnLst.add(mosSyouhn.getKyhkatakbn());
    //            tkhknkknLst.add(mosSyouhn.getHknkkn());
    //            tkhknkknmnKbnLst.add(mosSyouhn.getHknkknsmnkbn());
    //            if (mosSyouhn.getHrkkkn() != null && mosSyouhn.getHrkkkn() == 0) {
    //                tkhrkkknLst.add(null);
    //            }
    //            else {
    //                tkhrkkknLst.add(mosSyouhn.getHrkkkn());
    //            }
    //            tkhrkkknmnKbn.add(mosSyouhn.getHrkkknsmnkbn());
    //
    //            cnt++;
    //            if (cnt > MAX_TOKUYAKU) {
    //                break;
    //            }
    //        }
    //        for (int i = cnt; i < MAX_TOKUYAKU; i++) {
    //            if (!E_SyoriKbn.MOUSIKOMISYO_SYUUSEI.equals(pGamenSyoriKbn)) {
    //                initTksyouhinCdLst.add("");
    //                initTkkataKbnLst.add(C_KataKbn.BLNK);
    //                initTkkhnsLst.add(BizCurrency.optional());
    //            }
    //
    //            tksyouhinCdLst.add(null);
    //            tkkataKbnLst.add(null);
    //            tkkyhkataKbnLst.add(null);
    //            tkkhnsLst.add(BizCurrency.optional());
    //            tkhknkknLst.add(null);
    //            tkhknkknmnKbnLst.add(null);
    //            tkhrkkknLst.add(null);
    //            tkhrkkknmnKbn.add(null);
    //        }
    //
    //        if (!E_SyoriKbn.MOUSIKOMISYO_SYUUSEI.equals(pGamenSyoriKbn)) {
    //            uiBean.setInitToksyouhncdLst(initTksyouhinCdLst);
    //            uiBean.setInitTokuyakukatakbnLst(initTkkataKbnLst);
    //            uiBean.setInitTokuyakukihonsLst(initTkkhnsLst);
    //        }
    //
    //        uiBean.setTksyouhncd1(tksyouhinCdLst.get(0));
    //        uiBean.setTksyouhncd2(tksyouhinCdLst.get(1));
    //        uiBean.setTksyouhncd3(tksyouhinCdLst.get(2));
    //        uiBean.setTksyouhncd4(tksyouhinCdLst.get(3));
    //        uiBean.setTksyouhncd5(tksyouhinCdLst.get(4));
    //        uiBean.setTksyouhncd6(tksyouhinCdLst.get(5));
    //        uiBean.setTksyouhncd7(tksyouhinCdLst.get(6));
    //        uiBean.setTksyouhncd8(tksyouhinCdLst.get(7));
    //        uiBean.setTksyouhncd9(tksyouhinCdLst.get(8));
    //        uiBean.setTksyouhncd10(tksyouhinCdLst.get(9));
    //        uiBean.setTokuyakukatakbn1(tkkataKbnLst.get(0));
    //        uiBean.setTokuyakukatakbn2(tkkataKbnLst.get(1));
    //        uiBean.setTokuyakukatakbn3(tkkataKbnLst.get(2));
    //        uiBean.setTokuyakukatakbn4(tkkataKbnLst.get(3));
    //        uiBean.setTokuyakukatakbn5(tkkataKbnLst.get(4));
    //        uiBean.setTokuyakukatakbn6(tkkataKbnLst.get(5));
    //        uiBean.setTokuyakukatakbn7(tkkataKbnLst.get(6));
    //        uiBean.setTokuyakukatakbn8(tkkataKbnLst.get(7));
    //        uiBean.setTokuyakukatakbn9(tkkataKbnLst.get(8));
    //        uiBean.setTokuyakukatakbn10(tkkataKbnLst.get(9));
    //        uiBean.setTokuyakukyuhutukikatakbn1(tkkyhkataKbnLst.get(0));
    //        uiBean.setTokuyakukyuhutukikatakbn2(tkkyhkataKbnLst.get(1));
    //        uiBean.setTokuyakukyuhutukikatakbn3(tkkyhkataKbnLst.get(2));
    //        uiBean.setTokuyakukyuhutukikatakbn4(tkkyhkataKbnLst.get(3));
    //        uiBean.setTokuyakukyuhutukikatakbn5(tkkyhkataKbnLst.get(4));
    //        uiBean.setTokuyakukyuhutukikatakbn6(tkkyhkataKbnLst.get(5));
    //        uiBean.setTokuyakukyuhutukikatakbn7(tkkyhkataKbnLst.get(6));
    //        uiBean.setTokuyakukyuhutukikatakbn8(tkkyhkataKbnLst.get(7));
    //        uiBean.setTokuyakukyuhutukikatakbn9(tkkyhkataKbnLst.get(8));
    //        uiBean.setTokuyakukyuhutukikatakbn10(tkkyhkataKbnLst.get(9));
    //        uiBean.setTokuyakukihons1(tkkhnsLst.get(0));
    //        uiBean.setTokuyakukihons2(tkkhnsLst.get(1));
    //        uiBean.setTokuyakukihons3(tkkhnsLst.get(2));
    //        uiBean.setTokuyakukihons4(tkkhnsLst.get(3));
    //        uiBean.setTokuyakukihons5(tkkhnsLst.get(4));
    //        uiBean.setTokuyakukihons6(tkkhnsLst.get(5));
    //        uiBean.setTokuyakukihons7(tkkhnsLst.get(6));
    //        uiBean.setTokuyakukihons8(tkkhnsLst.get(7));
    //        uiBean.setTokuyakukihons9(tkkhnsLst.get(8));
    //        uiBean.setTokuyakukihons10(tkkhnsLst.get(9));
    //        uiBean.setTokuyakuhokenkikan1(tkhknkknLst.get(0));
    //        uiBean.setTokuyakuhokenkikan2(tkhknkknLst.get(1));
    //        uiBean.setTokuyakuhokenkikan3(tkhknkknLst.get(2));
    //        uiBean.setTokuyakuhokenkikan4(tkhknkknLst.get(3));
    //        uiBean.setTokuyakuhokenkikan5(tkhknkknLst.get(4));
    //        uiBean.setTokuyakuhokenkikan6(tkhknkknLst.get(5));
    //        uiBean.setTokuyakuhokenkikan7(tkhknkknLst.get(6));
    //        uiBean.setTokuyakuhokenkikan8(tkhknkknLst.get(7));
    //        uiBean.setTokuyakuhokenkikan9(tkhknkknLst.get(8));
    //        uiBean.setTokuyakuhokenkikan10(tkhknkknLst.get(9));
    //        uiBean.setTokuyakuhknkknsmnkbn1(tkhknkknmnKbnLst.get(0));
    //        uiBean.setTokuyakuhknkknsmnkbn2(tkhknkknmnKbnLst.get(1));
    //        uiBean.setTokuyakuhknkknsmnkbn3(tkhknkknmnKbnLst.get(2));
    //        uiBean.setTokuyakuhknkknsmnkbn4(tkhknkknmnKbnLst.get(3));
    //        uiBean.setTokuyakuhknkknsmnkbn5(tkhknkknmnKbnLst.get(4));
    //        uiBean.setTokuyakuhknkknsmnkbn6(tkhknkknmnKbnLst.get(5));
    //        uiBean.setTokuyakuhknkknsmnkbn7(tkhknkknmnKbnLst.get(6));
    //        uiBean.setTokuyakuhknkknsmnkbn8(tkhknkknmnKbnLst.get(7));
    //        uiBean.setTokuyakuhknkknsmnkbn9(tkhknkknmnKbnLst.get(8));
    //        uiBean.setTokuyakuhknkknsmnkbn10(tkhknkknmnKbnLst.get(9));
    //        uiBean.setTokuyakuharaikomikikan1(tkhrkkknLst.get(0));
    //        uiBean.setTokuyakuharaikomikikan2(tkhrkkknLst.get(1));
    //        uiBean.setTokuyakuharaikomikikan3(tkhrkkknLst.get(2));
    //        uiBean.setTokuyakuharaikomikikan4(tkhrkkknLst.get(3));
    //        uiBean.setTokuyakuharaikomikikan5(tkhrkkknLst.get(4));
    //        uiBean.setTokuyakuharaikomikikan6(tkhrkkknLst.get(5));
    //        uiBean.setTokuyakuharaikomikikan7(tkhrkkknLst.get(6));
    //        uiBean.setTokuyakuharaikomikikan8(tkhrkkknLst.get(7));
    //        uiBean.setTokuyakuharaikomikikan9(tkhrkkknLst.get(8));
    //        uiBean.setTokuyakuharaikomikikan10(tkhrkkknLst.get(9));
    //        uiBean.setTokuyakuhrkkknsmnkbn1(tkhrkkknmnKbn.get(0));
    //        uiBean.setTokuyakuhrkkknsmnkbn2(tkhrkkknmnKbn.get(1));
    //        uiBean.setTokuyakuhrkkknsmnkbn3(tkhrkkknmnKbn.get(2));
    //        uiBean.setTokuyakuhrkkknsmnkbn4(tkhrkkknmnKbn.get(3));
    //        uiBean.setTokuyakuhrkkknsmnkbn5(tkhrkkknmnKbn.get(4));
    //        uiBean.setTokuyakuhrkkknsmnkbn6(tkhrkkknmnKbn.get(5));
    //        uiBean.setTokuyakuhrkkknsmnkbn7(tkhrkkknmnKbn.get(6));
    //        uiBean.setTokuyakuhrkkknsmnkbn8(tkhrkkknmnKbn.get(7));
    //        uiBean.setTokuyakuhrkkknsmnkbn9(tkhrkkknmnKbn.get(8));
    //        uiBean.setTokuyakuhrkkknsmnkbn10(tkhrkkknmnKbn.get(9));
    //    }

    private void setUiBeanFromUketorinin(List<HT_Uketorinin> pUketorininLst) {
        int cnt = 0;

        List<C_UktKbn> sbUktKbnLst = Lists.newArrayList();
        List<String> sbUktNmKnLst = Lists.newArrayList();
        List<String> sbUktNmKjLst = Lists.newArrayList();
        List<C_KjkhukaKbn> sbUktNmKjhukaKbnLst = Lists.newArrayList();
        List<BizDate> sbUktSeiymdLst = Lists.newArrayList();
        List<C_Tdk> sbUktTdkLst = Lists.newArrayList();
        List<BizNumber> sbUktBnwariLst = Lists.newArrayList();

        for (HT_Uketorinin uketorinin : pUketorininLst) {
            C_UktsyuKbn uktSyuKbn = uketorinin.getUktsyukbn();

            if (C_UktsyuKbn.NKUKT.eq(uktSyuKbn)) {
                uiBean.setNenkinuktkbn(uketorinin.getUktkbn());
            }
            else if (C_UktsyuKbn.SBUKT.eq(uktSyuKbn)) {
                sbUktKbnLst.add(uketorinin.getUktkbn());
                sbUktNmKnLst.add(uketorinin.getUktnmkn());
                sbUktNmKjLst.add(uketorinin.getUktnmkj());
                sbUktNmKjhukaKbnLst.add(uketorinin.getUktnmkjkhukakbn());
                sbUktSeiymdLst.add(uketorinin.getUktseiymd());
                sbUktTdkLst.add(uketorinin.getUkttdk());
                sbUktBnwariLst.add(uketorinin.getUktbnwari());

                cnt++;
            }
            else if (C_UktsyuKbn.KYKDRN.eq(uktSyuKbn)) {
                uiBean.setKykdrkbn(uketorinin.getUktkbn());
            }
            else if (C_UktsyuKbn.STDRSK.eq(uktSyuKbn)) {
                uiBean.setStdruktkbn(uketorinin.getUktkbn());
                uiBean.setSiteidruktnmkn(uketorinin.getUktnmkn());
                uiBean.setSiteidruktnmkj(uketorinin.getUktnmkj());
                uiBean.setStdrsknmkjhukakbn(uketorinin.getUktnmkjkhukakbn());
                uiBean.setStdrskseiymd(uketorinin.getUktseiymd());
                uiBean.setStdrsktdk(uketorinin.getUkttdk());
            }
        }

        for (int index = cnt; index < MAX_UKT_SIBOU; index++) {
            sbUktKbnLst.add(C_UktKbn.BLNK);
            sbUktNmKnLst.add("");
            sbUktNmKjLst.add("");
            sbUktNmKjhukaKbnLst.add(null);
            sbUktSeiymdLst.add(null);
            sbUktTdkLst.add(null);
            sbUktBnwariLst.add(BizNumber.optional());
        }

        uiBean.setSbuktkbn1(sbUktKbnLst.get(0));
        uiBean.setSbuktkbn2(sbUktKbnLst.get(1));
        uiBean.setSbuktkbn3(sbUktKbnLst.get(2));
        uiBean.setSbuktkbn4(sbUktKbnLst.get(3));
        uiBean.setSbuktnmkn1(sbUktNmKnLst.get(0));
        uiBean.setSbuktnmkn2(sbUktNmKnLst.get(1));
        uiBean.setSbuktnmkn3(sbUktNmKnLst.get(2));
        uiBean.setSbuktnmkn4(sbUktNmKnLst.get(3));
        uiBean.setSbuktnmkj1(sbUktNmKjLst.get(0));
        uiBean.setSbuktnmkj2(sbUktNmKjLst.get(1));
        uiBean.setSbuktnmkj3(sbUktNmKjLst.get(2));
        uiBean.setSbuktnmkj4(sbUktNmKjLst.get(3));
        uiBean.setSbuktnmkjhukakbn1(sbUktNmKjhukaKbnLst.get(0));
        uiBean.setSbuktnmkjhukakbn2(sbUktNmKjhukaKbnLst.get(1));
        uiBean.setSbuktnmkjhukakbn3(sbUktNmKjhukaKbnLst.get(2));
        uiBean.setSbuktnmkjhukakbn4(sbUktNmKjhukaKbnLst.get(3));
        uiBean.setSbuktseiymd1(sbUktSeiymdLst.get(0));
        uiBean.setSbuktseiymd2(sbUktSeiymdLst.get(1));
        uiBean.setSbuktseiymd3(sbUktSeiymdLst.get(2));
        uiBean.setSbuktseiymd4(sbUktSeiymdLst.get(3));
        uiBean.setSbukttdk1(sbUktTdkLst.get(0));
        uiBean.setSbukttdk2(sbUktTdkLst.get(1));
        uiBean.setSbukttdk3(sbUktTdkLst.get(2));
        uiBean.setSbukttdk4(sbUktTdkLst.get(3));
        uiBean.setSbuktbnwari1(zeroToOptional(sbUktBnwariLst.get(0)));
        uiBean.setSbuktbnwari2(zeroToOptional(sbUktBnwariLst.get(1)));
        uiBean.setSbuktbnwari3(zeroToOptional(sbUktBnwariLst.get(2)));
        uiBean.setSbuktbnwari4(zeroToOptional(sbUktBnwariLst.get(3)));
    }

    private void setUiBeanFromMosDairiten(List<HT_MosDairiten> pMosDairitenLst, E_SyoriKbn pGamenSyoriKbn) {
        int cnt = 0;

        List<String> kinyuuCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> kinyuuSitenCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> tratkiagCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> oyaDrtenCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> jimusyoCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> bosyuuTrkNoLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> bosyuuninCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> inputBosyuuCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> tratkiKouinnCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> gyousekiKeijyousakiSosikiCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<BizNumber> bunwariLst = new ArrayList<>(MAX_DAIRITEN);

        for (HT_MosDairiten mosDairiten : pMosDairitenLst) {
            if (mosDairiten.getRenno() == 1) {
                if (!E_SyoriKbn.MOUSIKOMISYO_3JI.equals(pGamenSyoriKbn)) {
                    uiBean.setInitBsyujoyadrtencd(mosDairiten.getBsyujoyadrtencd());
                }

                uiBean.setCifcd(mosDairiten.getCifcd());
            }

            kinyuuCdLst.add(mosDairiten.getKinyuucd());
            kinyuuSitenCdLst.add(mosDairiten.getKinyuusitencd());
            tratkiagCdLst.add(mosDairiten.getTratkiagcd());
            oyaDrtenCdLst.add(mosDairiten.getOyadrtencd());
            jimusyoCdLst.add(mosDairiten.getJimusyocd());
            bosyuuTrkNoLst.add(mosDairiten.getBosyuutrkno());
            bosyuuninCdLst.add(mosDairiten.getBosyuucd());
            inputBosyuuCdLst.add(mosDairiten.getInputbosyuucd());
            tratkiKouinnCdLst.add(mosDairiten.getTratkikouinncd());
            gyousekiKeijyousakiSosikiCdLst.add(mosDairiten.getGyousekikeijyousakisosikicd());
            if (pMosDairitenLst.size() > 1) {
                bunwariLst.add(mosDairiten.getBunwari());
            }
            else {
                bunwariLst.add(BizNumber.optional());
            }
            cnt++;

            if (cnt > MAX_DAIRITEN) {
                break;
            }
        }

        for (int index = cnt; index < MAX_DAIRITEN; index++) {
            kinyuuCdLst.add("");
            kinyuuSitenCdLst.add("");
            tratkiagCdLst.add("");
            oyaDrtenCdLst.add("");
            jimusyoCdLst.add("");
            bosyuuTrkNoLst.add("");
            bosyuuninCdLst.add("");
            inputBosyuuCdLst.add("");
            tratkiKouinnCdLst.add("");
            gyousekiKeijyousakiSosikiCdLst.add("");
            bunwariLst.add(BizNumber.optional());
        }

        uiBean.setDairitenkinyuukikancd1(kinyuuCdLst.get(0));
        uiBean.setDairitenkinyuukikancd2(kinyuuCdLst.get(1));
        uiBean.setDairitenkinyuukikansitencd1(kinyuuSitenCdLst.get(0));
        uiBean.setDairitenkinyuukikansitencd2(kinyuuSitenCdLst.get(1));
        uiBean.setToriatukaidairitencd1(tratkiagCdLst.get(0));
        uiBean.setToriatukaidairitencd2(tratkiagCdLst.get(1));
        uiBean.setOyadairitencd1(oyaDrtenCdLst.get(0));
        uiBean.setOyadairitencd2(oyaDrtenCdLst.get(1));
        uiBean.setDrtenjimcd1(jimusyoCdLst.get(0));
        uiBean.setDrtenjimcd2(jimusyoCdLst.get(1));
        uiBean.setBosyuunintourokuno1(bosyuuTrkNoLst.get(0));
        uiBean.setBosyuunintourokuno2(bosyuuTrkNoLst.get(1));
        uiBean.setBosyuucd1(bosyuuninCdLst.get(0));
        uiBean.setBosyuucd2(bosyuuninCdLst.get(1));
        uiBean.setInputbosyuucd1(inputBosyuuCdLst.get(0));
        uiBean.setInputbosyuucd2(inputBosyuuCdLst.get(1));
        uiBean.setDairitentoriatukaikouincd1(tratkiKouinnCdLst.get(0));
        uiBean.setDairitentoriatukaikouincd2(tratkiKouinnCdLst.get(1));
        uiBean.setGyskkjsakisosikicd1(gyousekiKeijyousakiSosikiCdLst.get(0));
        uiBean.setGyskkjsakisosikicd2(gyousekiKeijyousakiSosikiCdLst.get(1));
        uiBean.setDairitenbuntanwariai1(zeroToOptional(bunwariLst.get(0)));
        uiBean.setDairitenbuntanwariai2(zeroToOptional(bunwariLst.get(1)));
    }

    private void setUiBeanFromUketoriKouzaJyouhou(HT_UketoriKouzaJyouhou pUketoriKouzaJyouhou) {
        uiBean.setShkstkzinfkzinfoinputhrykbn(pUketoriKouzaJyouhou.getKouzainfoinputhoryuukbn());
        uiBean.setKzsyuruikbn(pUketoriKouzaJyouhou.getKzsyuruikbn());
        uiBean.setBankcd(pUketoriKouzaJyouhou.getBankcd());
        uiBean.setSitencd(pUketoriKouzaJyouhou.getSitencd());
        uiBean.setYokinkbn(pUketoriKouzaJyouhou.getYokinkbn());
        uiBean.setKouzano(pUketoriKouzaJyouhou.getKouzano());
        uiBean.setKzkykdoukbn(pUketoriKouzaJyouhou.getKzkykdoukbn());
        uiBean.setKzmeiginmkn(pUketoriKouzaJyouhou.getKzmeiginmkn());
    }

    private void setUiBeanFromMosTrkKzk(List<HT_MosTrkKzk> pMosTrkKzkLst) {

        for (HT_MosTrkKzk mosTrkKzk : pMosTrkKzkLst) {
            C_TrkKzkKbn trkKzkKbn = mosTrkKzk.getTrkkzkkbn();

            if (C_TrkKzkKbn.TRKKZK1.eq(trkKzkKbn)) {

                uiBean.setTrkkzknmkn1(mosTrkKzk.getTrkkzknmkn());
                uiBean.setTrkkzknmkj1(mosTrkKzk.getTrkkzknmkj());
                uiBean.setTrkkzknmkjkhukakbn1(mosTrkKzk.getTrkkzknmkjkhukakbn());
                uiBean.setTrkkzkseiymd1(mosTrkKzk.getTrkkzkseiymd());
                uiBean.setTrkkzksei1(mosTrkKzk.getTrkkzksei());
                uiBean.setTrkkzktdk1(mosTrkKzk.getTrkkzktdk());
                uiBean.setTrkkzktsindousiteikbn1(mosTrkKzk.getTrkkzktsindousiteikbn());
                uiBean.setTrkkzkyno1(mosTrkKzk.getTrkkzkyno());
                uiBean.setTrkkzkadr1kj1(mosTrkKzk.getTrkkzkadr1kj());
                uiBean.setTrkkzkadr2kj1(mosTrkKzk.getTrkkzkadr2kj());
                uiBean.setTrkkzkadr3kj1(mosTrkKzk.getTrkkzkadr3kj());
                uiBean.setTrkkzktelno1(mosTrkKzk.getTrkkzktelno());
            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzkKbn)) {
                uiBean.setTrkkzknmkn2(mosTrkKzk.getTrkkzknmkn());
                uiBean.setTrkkzknmkj2(mosTrkKzk.getTrkkzknmkj());
                uiBean.setTrkkzknmkjkhukakbn2(mosTrkKzk.getTrkkzknmkjkhukakbn());
                uiBean.setTrkkzkseiymd2(mosTrkKzk.getTrkkzkseiymd());
                uiBean.setTrkkzksei2(mosTrkKzk.getTrkkzksei());
                uiBean.setTrkkzktdk2(mosTrkKzk.getTrkkzktdk());
                uiBean.setTrkkzktsindousiteikbn2(mosTrkKzk.getTrkkzktsindousiteikbn());
                uiBean.setTrkkzkyno2(mosTrkKzk.getTrkkzkyno());
                uiBean.setTrkkzkadr1kj2(mosTrkKzk.getTrkkzkadr1kj());
                uiBean.setTrkkzkadr2kj2(mosTrkKzk.getTrkkzkadr2kj());
                uiBean.setTrkkzkadr3kj2(mosTrkKzk.getTrkkzkadr3kj());
                uiBean.setTrkkzktelno2(mosTrkKzk.getTrkkzktelno());
            }
        }
    }

    private void setUiBeanFromBosyuuInfo(HT_BosKihon pBosKihon) {
        uiBean.setAitemosno(pBosKihon.getAitemosno());
        uiBean.setDoujikaiyakusyono(pBosKihon.getDoujikaiyakusyono());
        uiBean.setMosymd(pBosKihon.getMosymd());
        uiBean.setHknsyuruinomosinput(pBosKihon.getHknsyuruino().getValue());

        uiBean.setKykkbn(pBosKihon.getKykkbn());
        uiBean.setYakkanjyuryouhoukbn(pBosKihon.getYakkanjyuryouhoukbn());
        uiBean.setFatcasnsikbn(pBosKihon.getFatcasnsikbn());
        uiBean.setBikkjnssinfokbn(pBosKihon.getBikkjnssinfokbn());
        uiBean.setAeoisnsikbn(pBosKihon.getAeoisnsikbn());
        uiBean.setKyktdk(pBosKihon.getKyktdk());
        uiBean.setKyknmkn(pBosKihon.getKyknmkn());
        uiBean.setKyknmkj(pBosKihon.getKyknmkj());
        uiBean.setKyknmkjkhukakbn(pBosKihon.getKyknmkjkhukakbn());
        uiBean.setKykseiymd(pBosKihon.getKykseiymd());
        uiBean.setKyksei(pBosKihon.getKyksei());

        uiBean.setTsinyno(pBosKihon.getTsinyno());
        uiBean.setTsinadr1kj(pBosKihon.getTsinadr1kj());
        uiBean.setTsinadr2kj(pBosKihon.getTsinadr2kj());
        uiBean.setTsinadr3kj(pBosKihon.getTsinadr3kj());
        uiBean.setTsintelno(pBosKihon.getTsintelno());
        uiBean.setDai2tsintelno(pBosKihon.getDai2tsintelno());

        uiBean.setHhknnmkn(pBosKihon.getHhknnmkn());
        uiBean.setHhknnmkj(pBosKihon.getHhknnmkj());
        uiBean.setHhknnmkjkhukakbn(pBosKihon.getHhknnmkjkhukakbn());
        uiBean.setHhknseiymd(pBosKihon.getHhknseiymd());
        uiBean.setHhknsei(pBosKihon.getHhknsei());
        uiBean.setKktymd(pBosKihon.getKktymd());
        uiBean.setHhknsykgycd(pBosKihon.getHhknsykgycd());
        uiBean.setHhknnensyuukbn(pBosKihon.getHhknnensyuukbn());
        uiBean.setTsindousiteikbn(pBosKihon.getTsindousiteikbn());
        uiBean.setHhknyno(pBosKihon.getHhknyno());
        uiBean.setHhknadr1kj(pBosKihon.getHhknadr1kj());
        uiBean.setHhknadr2kj(pBosKihon.getHhknadr2kj());
        uiBean.setHhknadr3kj(pBosKihon.getHhknadr3kj());
        uiBean.setHhkntelno(pBosKihon.getHhkntelno());

        uiBean.setSbuktnin(zeroToNull(pBosKihon.getSbuktnin()));
        uiBean.setKzktourokuservicetourokukbn(pBosKihon.getKzktourokuservicetourokukbn());
        uiBean.setKykdrtkykhukakbn(pBosKihon.getKykdrtkykhukakbn());
        uiBean.setStdrsktkyhkkbn(pBosKihon.getStdrsktkyhkkbn());

        int cnt = 0;

        List<C_UktKbn> sbUktKbnLst = Lists.newArrayList();
        List<String> sbUktNmKnLst = Lists.newArrayList();
        List<String> sbUktNmKjLst = Lists.newArrayList();
        List<C_KjkhukaKbn> sbUktNmKjhukaKbnLst = Lists.newArrayList();
        List<BizDate> sbUktSeiymdLst = Lists.newArrayList();
        List<C_Tdk> sbUktTdkLst = Lists.newArrayList();
        List<BizNumber> sbUktBnwariLst = Lists.newArrayList();

        List<HT_BosUketorinin> bosUketorininLst = pBosKihon.getBosUketorinins();
        for (HT_BosUketorinin bosUketorinin : bosUketorininLst) {
            C_UktsyuKbn uktSyuKbn = bosUketorinin.getUktsyukbn();
            if (C_UktsyuKbn.NKUKT.eq(uktSyuKbn)) {
                uiBean.setNenkinuktkbn(bosUketorinin.getUktkbn());
            }
            else if (C_UktsyuKbn.SBUKT.eq(uktSyuKbn)) {
                sbUktKbnLst.add(bosUketorinin.getUktkbn());
                sbUktNmKnLst.add(bosUketorinin.getUktnmkn());
                sbUktNmKjLst.add(bosUketorinin.getUktnmkj());
                sbUktNmKjhukaKbnLst.add(bosUketorinin.getUktnmkjkhukakbn());
                sbUktSeiymdLst.add(bosUketorinin.getUktseiymd());
                sbUktTdkLst.add(bosUketorinin.getUkttdk());
                sbUktBnwariLst.add(bosUketorinin.getUktbnwari());

                cnt++;
            }
            else if (C_UktsyuKbn.KYKDRN.eq(uktSyuKbn)) {
                uiBean.setKykdrkbn(bosUketorinin.getUktkbn());
            }
            else if (C_UktsyuKbn.STDRSK.eq(uktSyuKbn)) {
                uiBean.setStdruktkbn(bosUketorinin.getUktkbn());
                uiBean.setSiteidruktnmkn(bosUketorinin.getUktnmkn());
                uiBean.setSiteidruktnmkj(bosUketorinin.getUktnmkj());
                uiBean.setStdrsknmkjhukakbn(bosUketorinin.getUktnmkjkhukakbn());
                uiBean.setStdrskseiymd(bosUketorinin.getUktseiymd());
                uiBean.setStdrsktdk(bosUketorinin.getUkttdk());
            }
        }

        for (int index = cnt; index < MAX_UKT_SIBOU; index++) {
            sbUktKbnLst.add(C_UktKbn.BLNK);
            sbUktNmKnLst.add("");
            sbUktNmKjLst.add("");
            sbUktNmKjhukaKbnLst.add(null);
            sbUktSeiymdLst.add(null);
            sbUktTdkLst.add(null);
            sbUktBnwariLst.add(BizNumber.optional());
        }

        uiBean.setSbuktkbn1(sbUktKbnLst.get(0));
        uiBean.setSbuktkbn2(sbUktKbnLst.get(1));
        uiBean.setSbuktkbn3(sbUktKbnLst.get(2));
        uiBean.setSbuktkbn4(sbUktKbnLst.get(3));
        uiBean.setSbuktnmkn1(sbUktNmKnLst.get(0));
        uiBean.setSbuktnmkn2(sbUktNmKnLst.get(1));
        uiBean.setSbuktnmkn3(sbUktNmKnLst.get(2));
        uiBean.setSbuktnmkn4(sbUktNmKnLst.get(3));
        uiBean.setSbuktnmkj1(sbUktNmKjLst.get(0));
        uiBean.setSbuktnmkj2(sbUktNmKjLst.get(1));
        uiBean.setSbuktnmkj3(sbUktNmKjLst.get(2));
        uiBean.setSbuktnmkj4(sbUktNmKjLst.get(3));
        uiBean.setSbuktnmkjhukakbn1(sbUktNmKjhukaKbnLst.get(0));
        uiBean.setSbuktnmkjhukakbn2(sbUktNmKjhukaKbnLst.get(1));
        uiBean.setSbuktnmkjhukakbn3(sbUktNmKjhukaKbnLst.get(2));
        uiBean.setSbuktnmkjhukakbn4(sbUktNmKjhukaKbnLst.get(3));
        uiBean.setSbuktseiymd1(sbUktSeiymdLst.get(0));
        uiBean.setSbuktseiymd2(sbUktSeiymdLst.get(1));
        uiBean.setSbuktseiymd3(sbUktSeiymdLst.get(2));
        uiBean.setSbuktseiymd4(sbUktSeiymdLst.get(3));
        uiBean.setSbukttdk1(sbUktTdkLst.get(0));
        uiBean.setSbukttdk2(sbUktTdkLst.get(1));
        uiBean.setSbukttdk3(sbUktTdkLst.get(2));
        uiBean.setSbukttdk4(sbUktTdkLst.get(3));
        uiBean.setSbuktbnwari1(zeroToOptional(sbUktBnwariLst.get(0)));
        uiBean.setSbuktbnwari2(zeroToOptional(sbUktBnwariLst.get(1)));
        uiBean.setSbuktbnwari3(zeroToOptional(sbUktBnwariLst.get(2)));
        uiBean.setSbuktbnwari4(zeroToOptional(sbUktBnwariLst.get(3)));

        List<HT_BosTrkKzk> bosTrkKzkLst = pBosKihon.getBosTrkKzks();

        for (HT_BosTrkKzk bosTrkKzk : bosTrkKzkLst) {
            C_TrkKzkKbn trkKzkKbn = bosTrkKzk.getTrkkzkkbn();

            if (C_TrkKzkKbn.TRKKZK1.eq(trkKzkKbn)) {

                uiBean.setTrkkzknmkn1(bosTrkKzk.getTrkkzknmkn());
                uiBean.setTrkkzknmkj1(bosTrkKzk.getTrkkzknmkj());
                uiBean.setTrkkzknmkjkhukakbn1(bosTrkKzk.getTrkkzknmkjkhukakbn());
                uiBean.setTrkkzkseiymd1(bosTrkKzk.getTrkkzkseiymd());
                uiBean.setTrkkzksei1(bosTrkKzk.getTrkkzksei());
                uiBean.setTrkkzktdk1(bosTrkKzk.getTrkkzktdk());
                uiBean.setTrkkzktsindousiteikbn1(bosTrkKzk.getTrkkzktsindousiteikbn());
                uiBean.setTrkkzkyno1(bosTrkKzk.getTrkkzkyno());
                uiBean.setTrkkzkadr1kj1(bosTrkKzk.getTrkkzkadr1kj());
                uiBean.setTrkkzkadr2kj1(bosTrkKzk.getTrkkzkadr2kj());
                uiBean.setTrkkzkadr3kj1(bosTrkKzk.getTrkkzkadr3kj());
                uiBean.setTrkkzktelno1(bosTrkKzk.getTrkkzktelno());
            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzkKbn)) {
                uiBean.setTrkkzknmkn2(bosTrkKzk.getTrkkzknmkn());
                uiBean.setTrkkzknmkj2(bosTrkKzk.getTrkkzknmkj());
                uiBean.setTrkkzknmkjkhukakbn2(bosTrkKzk.getTrkkzknmkjkhukakbn());
                uiBean.setTrkkzkseiymd2(bosTrkKzk.getTrkkzkseiymd());
                uiBean.setTrkkzksei2(bosTrkKzk.getTrkkzksei());
                uiBean.setTrkkzktdk2(bosTrkKzk.getTrkkzktdk());
                uiBean.setTrkkzktsindousiteikbn2(bosTrkKzk.getTrkkzktsindousiteikbn());
                uiBean.setTrkkzkyno2(bosTrkKzk.getTrkkzkyno());
                uiBean.setTrkkzkadr1kj2(bosTrkKzk.getTrkkzkadr1kj());
                uiBean.setTrkkzkadr2kj2(bosTrkKzk.getTrkkzkadr2kj());
                uiBean.setTrkkzkadr3kj2(bosTrkKzk.getTrkkzkadr3kj());
                uiBean.setTrkkzktelno2(bosTrkKzk.getTrkkzktelno());
            }
        }

        HT_BosSyouhn bosSyouhn = pBosKihon.getBosSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        uiBean.setSyudai1hknkknmosinput(bosSyouhn.getDai1hknkkn().toString());
        uiBean.setSdpdkbn(pBosKihon.getSdpdkbn());
        uiBean.setKyktuukasyumosinput(pBosKihon.getKyktuukasyu().toString());
        uiBean.setHrktuukasyumosinput(pBosKihon.getHrktuukasyu().toString());
        uiBean.setSyukihons(zeroToOptional(bosSyouhn.getKihons()));
        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();
        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn())) {
            uiBean.setHrktuukasyukykp(zeroToOptional(bosSyouhn.getHrktuukasyutkp()));
        }
        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn())) {
            uiBean.setMossyukykp(zeroToOptional(bosSyouhn.getHrktuukasyutkp()));
        }

        uiBean.setTeirituhaibunwarikbn(pBosKihon.getTeirituhaibunwarikbn());
        uiBean.setSisuuhaibunwarikbn(pBosKihon.getSisuuhaibunwarikbn());
        uiBean.setSueokikknmosinput(bosSyouhn.getHknkkn().toString());
        uiBean.setNenkinsyumosinput(bosSyouhn.getSknenkinsyu().toString());
        uiBean.setNkgnshosyouritukbn(pBosKihon.getNkgnshosyouritukbn());
        uiBean.setSyuhknkkn(bosSyouhn.getHknkkn());
        uiBean.setSyuhknkknsmnkbn(bosSyouhn.getHknkknsmnkbn());
        uiBean.setSyuhrkkkn(bosSyouhn.getHrkkkn());
        uiBean.setSyuhrkkknsmnkbn(bosSyouhn.getHrkkknsmnkbn());
        uiBean.setHrkkaisuumosinput(pBosKihon.getHrkkaisuu().toString());
        uiBean.setFstphrkkeirokbn(pBosKihon.getFstphrkkeirokbn());
        uiBean.setMosikkatup(pBosKihon.getMosikkatup());
        uiBean.setMoszennoupsyokaiari(pBosKihon.getMoszennoupsyokaiari());
        uiBean.setKjnnkpzeitekitkhukakbn(pBosKihon.getKjnnkpzeitekitkhukakbn());
        uiBean.setZenkizennouumumosinput(pBosKihon.getZenkizennouumu().toString());
        uiBean.setHrkkeiro(pBosKihon.getHrkkeiro());
        uiBean.setIkkatubaraikaisuumosinput(pBosKihon.getIkkatubaraikaisuu().toString());

        if (pBosKihon.getZnnkai() > 0) {

            uiBean.setZnnkai(pBosKihon.getZnnkai() + 1);
        }
        else {

            uiBean.setZnnkai(pBosKihon.getZnnkai());
        }

        uiBean.setNstkhkkbn(pBosKihon.getNstkhkkbn());
        uiBean.setNstksbnkkn(zeroToNull(pBosKihon.getNstksbnkkn()));
        uiBean.setSyksbyensitihsyutkhkkbn(pBosKihon.getSyksbyensitihsyutkhkkbn());
        uiBean.setJyudkaigomehrtkhkkbn(pBosKihon.getJyudkaigomehrtkhkkbn());
        uiBean.setTargettkmkhtkbn(pBosKihon.getTargettkmkhtkbn());
        uiBean.setMkhgkwarimosinput(pBosKihon.getTargettkmkhtkbn().getValue());
        uiBean.setTeikisiharaitkykhkkbn(pBosKihon.getTeikisiharaitkykhkkbn());

        uiBean.setDrctservicemoskbn(pBosKihon.getDrctservicemoskbn());

        uiBean.setYnkhrkmgkannituutikbn(pBosKihon.getYnkhrkmgkannituutikbn());

        List<HT_BosUketoriKouzaJyouhou> bosUketoriKouzaJyouhouLst = pBosKihon.getBosUketoriKouzaJyouhous();
        for (HT_BosUketoriKouzaJyouhou bosUketoriKouzaJyouhou : bosUketoriKouzaJyouhouLst) {
            if (C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN.eq(bosUketoriKouzaJyouhou.getUktkzsyubetukbn())) {
                uiBean.setShkstkzinfkzinfoinputhrykbn(bosUketoriKouzaJyouhou.getKouzainfoinputhoryuukbn());
                uiBean.setKzsyuruikbn(bosUketoriKouzaJyouhou.getKzsyuruikbn());
                uiBean.setBankcd(bosUketoriKouzaJyouhou.getBankcd());
                uiBean.setSitencd(bosUketoriKouzaJyouhou.getSitencd());
                uiBean.setYokinkbn(bosUketoriKouzaJyouhou.getYokinkbn());
                uiBean.setKouzano(bosUketoriKouzaJyouhou.getKouzano());
                uiBean.setKzkykdoukbn(bosUketoriKouzaJyouhou.getKzkykdoukbn());
                uiBean.setKzmeiginmkn(bosUketoriKouzaJyouhou.getKzmeiginmkn());
            }
        }

        HT_BosKouzaJyouhou bosKouzaJyouhou = pBosKihon.getBosKouzaJyouhou();
        if (bosKouzaJyouhou != null) {
            uiBean.setKouhurikouzainfobankcd(bosKouzaJyouhou.getBankcd());
            uiBean.setKouhurikouzainfositencd(bosKouzaJyouhou.getSitencd());
            uiBean.setKouhurikouzainfoyokinkbn(bosKouzaJyouhou.getYokinkbn());
            uiBean.setKouhurikouzainfokouzano(bosKouzaJyouhou.getKouzano());
            uiBean.setKouhurikouzainfokzdoukbn(bosKouzaJyouhou.getKzkykdoukbn());
            uiBean.setKouhurikouzainfokzmeiginmkn(bosKouzaJyouhou.getKzmeiginmkn());
            uiBean.setKouzakakuniniraikbn(bosKouzaJyouhou.getKouzakakuniniraikbn());
        }

        uiBean.setKykhonninkakninsyoruikbn(pBosKihon.getKykhonninkakninsyoruikbn());
        uiBean.setSkskknhonninkakninsyoruikbn(pBosKihon.getSkskknhonninkakninsyoruikbn());

        uiBean.setKoureikzksetumeihoukbn(pBosKihon.getKoureikzksetumeihoukbn());
        uiBean.setKoureimndnhukusuukaikbn(pBosKihon.getKoureimndnhukusuukaikbn());
        uiBean.setKoureitratkisyaigidskkbn(pBosKihon.getKoureitratkisyaigidskkbn());

        uiBean.setUktkid(pBosKihon.getUktkid());

        cnt = 0;

        List<String> jimusyoCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> bosyuuTrkNoLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> kinyuuCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> kinyuuSitenCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> tratkiKouinnCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<String> inputbosyuuCdLst = new ArrayList<>(MAX_DAIRITEN);
        List<BizNumber> bunwariLst = new ArrayList<>(MAX_DAIRITEN);

        List<HT_BosDairiten> bosDairitenLst = pBosKihon.getBosDairitens();
        for (HT_BosDairiten bosDairiten : bosDairitenLst) {
            if (bosDairiten.getRenno() == 1) {
                uiBean.setCifcd(bosDairiten.getCifcd());
            }

            jimusyoCdLst.add(bosDairiten.getJimusyocd());
            bosyuuTrkNoLst.add(bosDairiten.getBosyuutrkno());
            kinyuuCdLst.add(bosDairiten.getKinyuucd());
            kinyuuSitenCdLst.add(bosDairiten.getKinyuusitencd());
            tratkiKouinnCdLst.add(bosDairiten.getTratkikouinncd());
            inputbosyuuCdLst.add(bosDairiten.getInputbosyuucd());
            bunwariLst.add(bosDairiten.getBunwari());

            cnt++;

            if (cnt > MAX_DAIRITEN) {
                break;
            }
        }

        for (int index = cnt; index < MAX_DAIRITEN; index++) {
            jimusyoCdLst.add("");
            bosyuuTrkNoLst.add("");
            kinyuuCdLst.add("");
            kinyuuSitenCdLst.add("");
            tratkiKouinnCdLst.add("");
            inputbosyuuCdLst.add("");
            bunwariLst.add(BizNumber.optional());
        }

        uiBean.setDrtenjimcd1(jimusyoCdLst.get(0));
        uiBean.setDrtenjimcd2(jimusyoCdLst.get(1));
        uiBean.setBosyuunintourokuno1(bosyuuTrkNoLst.get(0));
        uiBean.setBosyuunintourokuno2(bosyuuTrkNoLst.get(1));
        uiBean.setDairitenkinyuukikancd1(kinyuuCdLst.get(0));
        uiBean.setDairitenkinyuukikancd2(kinyuuCdLst.get(1));
        uiBean.setDairitenkinyuukikansitencd1(kinyuuSitenCdLst.get(0));
        uiBean.setDairitenkinyuukikansitencd2(kinyuuSitenCdLst.get(1));
        uiBean.setDairitentoriatukaikouincd1(tratkiKouinnCdLst.get(0));
        uiBean.setDairitentoriatukaikouincd2(tratkiKouinnCdLst.get(1));
        uiBean.setInputbosyuucd1(inputbosyuuCdLst.get(0));
        uiBean.setInputbosyuucd2(inputbosyuuCdLst.get(1));
        uiBean.setDairitenbuntanwariai1(zeroToOptional(bunwariLst.get(0)));
        uiBean.setDairitenbuntanwariai2(zeroToOptional(bunwariLst.get(1)));

        uiBean.setIkokakninsyotokkijkumu(pBosKihon.getIkokakninsyotokkijkumu());
        uiBean.setTrtkhoukokusyotokkijkumu(pBosKihon.getTrtkhoukokusyotokkijkumu());
        uiBean.setHnnkakninhskjikouumukbn(pBosKihon.getHnnkakninhskjikouumukbn());
        uiBean.setHnnkakninhsktkjikouumukbn(pBosKihon.getHnnkakninhsktkjikouumukbn());
        uiBean.setSkskakninhsktkjikouumukbn(pBosKihon.getSkskakninhsktkjikouumukbn());
        uiBean.setMobilebosyuukbn(pBosKihon.getMobilebosyuukbn());
        uiBean.setMoscalckijyunymd(pBosKihon.getMoscalckijyunymd());
    }

    private void pushNotAddBL() {

        setMousikomiDispUmu();

        setSelectLstForInputContents();

        String mosNo = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL != null) {
            uiBean.setSyoriCTL(syoriCTL);
            uiBean.setInsUpdKbn(E_InsUpdKbn.INSUPDCTRL_UPD);

            if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())
                || C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
                throw new BizLogicException(MessageId.EBA0031, syoriCTL.getSeiritukbn().getContent());
            }

            if (E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn())
                || E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) {
                if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu())) {
                    throw new BizLogicException(MessageId.EHA0027);
                }

                if (C_UmuKbn.ARI.eq(syoriCTL.getKhnhbkbn())) {
                    throw new BizLogicException(MessageId.EHA0161);
                }
            }
            else {
                if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu()) && C_UmuKbn.NONE.eq(syoriCTL.getKhnhbkbn())) {
                    throw new BizLogicException(MessageId.EHA0027);
                }
            }

            if (!(C_KetteiKbn.NONE.eq(syoriCTL.getKetteikbn()) || C_KetteiKbn.KETTEI_MATI.eq(syoriCTL.getKetteikbn()))) {
                throw new BizLogicException(MessageId.EBA0031, syoriCTL.getKetteikbn().getContent());
            }
        }
        else {
            throw new BizLogicException(MessageId.EBA0090);
        }

        lockProcessGetProcessInfoMenu();

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);

        uiBean.setDaimosno(syoriCTL.getDaimosno());
        uiBean.setTkhsyouryakuumukbn(syoriCTL.getTkhsyouryakuumukbn());

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        setUiBeanFromMosKihon(mosKihon, null);

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst.isEmpty()) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        List<HT_MosSyouhn> mosSyouhnBySyouhnZokuseiLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        for (HT_MosSyouhn mosSyouhn : mosSyouhnBySyouhnZokuseiLst) {
            BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
            if (syouhnZokusei == null) {
                mosSyouhnBySyouhnZokuseiLst.remove(mosSyouhn);
                break;
            }
        }

        if (mosSyouhnLst.size() != mosSyouhnBySyouhnZokuseiLst.size()) {
            throw new CommonBizAppException("申込番号=" + mosNo + " 主契約・特約区分=主契約");
        }

        mosSyouhnLst = new SortHT_MosSyouhn().OrderHT_MosSyouhnByBM_SyouhnZokuseiSyohnsortnoAsc(mosSyouhnLst);

        setUiBeanFromMosSyouhnSyuKeiyaku(mosSyouhnLst.get(0));

        //        mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        //        mosSyouhnBySyouhnZokuseiLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        //        for (HT_MosSyouhn mosSyouhn : mosSyouhnBySyouhnZokuseiLst) {
        //            BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();
        //            if (syouhnZokusei == null) {
        //                mosSyouhnBySyouhnZokuseiLst.remove(mosSyouhn);
        //                break;
        //            }
        //        }
        //
        //        if (mosSyouhnLst.size() != mosSyouhnBySyouhnZokuseiLst.size()) {
        //            throw new CommonBizAppException("申込番号=" + mosNo + " 主契約・特約区分=特約");
        //        }
        //        mosSyouhnLst = new SortHT_MosSyouhn().OrderHT_MosSyouhnByBM_SyouhnZokuseiSyohnsortnoAsc(mosSyouhnLst);
        //
        //        setUiBeanFromMosSyouhnTokuyaku(mosSyouhnLst, null);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        if (uketorininLst != null) {
            setUiBeanFromUketorinin(uketorininLst);
        }

        List<HT_MosTrkKzk> mosTrkKzkLst = syoriCTL.getMosTrkKzks();

        if (mosTrkKzkLst.size() > 0) {
            setUiBeanFromMosTrkKzk(mosTrkKzkLst);
        }

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
        setUiBeanFromMosDairiten(mosDairitenLst, null);

        HT_UketoriKouzaJyouhou uketoriKouzaJyouhou =
            syoriCTL.getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);
        if (uketoriKouzaJyouhou != null) {
            setUiBeanFromUketoriKouzaJyouhou(uketoriKouzaJyouhou);
        }

        setUiBeanFromSyorictl(syoriCTL);

        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();

        uiBean.setInitKzhuritourokuhoukbn(C_KzhuritourokuhouKbn.BLNK);

        if (kouzaJyouhou != null) {

            setUiBeanFromKouzaJyouhou(kouzaJyouhou);
        }

        List<String> listHubi = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setHubimsgData(listHubi);
        skHubiMsgRenkeiInfo.setMosno(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());

        String uniqueId = objStrMan.save(skHubiMsgRenkeiInfo);

        uiBean.setUniqueId(uniqueId);
        uiBean.setHubimsgData(listHubi.toArray(new String[0]));
    }

    private void setSelectLstForInputContents() {
        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHyoujidate(BizDate
            .getSysDate());

        UserDefsList udList = new UserDefsList();
        udList.add(new LabelValuePair());

        List<GetSyouhnZokuseiCtrlInBean> syouhnzokuseiCtrlGetInBeanLst = Lists.newArrayList();
        GetSyouhnZokuseiCtrlInBean syouhnzokuseiCtrlGetInBean;

        for (HM_SkHokenSyuruiNo skHokenSyuruiNo : skHokenSyuruiNoLst) {
            LabelValuePair pair = new LabelValuePair();
            pair.setLabel(skHokenSyuruiNo.getHknsyuruinmsyanaidisp());
            pair.setValue(skHokenSyuruiNo.getHknsyuruino().getValue());
            udList.add(pair);

            syouhnzokuseiCtrlGetInBean = SWAKInjector.getInstance(GetSyouhnZokuseiCtrlInBean.class);
            syouhnzokuseiCtrlGetInBean.setHknsyuruino(skHokenSyuruiNo.getHknsyuruino());
            syouhnzokuseiCtrlGetInBean.setHknsyuruinosd(skHokenSyuruiNo.getHknsyuruinosd());
            syouhnzokuseiCtrlGetInBean.setInputctrlSyouhnCd(skHokenSyuruiNo.getInputctrlsyouhncd());
            syouhnzokuseiCtrlGetInBean.setInputctrlSyouhnSdNo(skHokenSyuruiNo.getInputctrlsyouhnsdno());
            syouhnzokuseiCtrlGetInBean.setMos2hyoujiumuKbn(uiBean.getMos2hyoujiumuKbn());
            syouhnzokuseiCtrlGetInBeanLst.add(syouhnzokuseiCtrlGetInBean);
        }

        GetMosGamenctrl getMosGamenctrl = SWAKInjector.getInstance(GetMosGamenctrl.class);
        List<GetSyouhnZokuseiCtrlOutBean> syouhnzokuseiCtrlGetOutBeanLst =
            getMosGamenctrl.getGamenctrl(syouhnzokuseiCtrlGetInBeanLst);

        BizDate sysDate = BizDate.getSysDate();

        List<BM_SyouhnZokusei> syouhnZokuseiLst =
            bizDomManager.getSyouhnZokuseisBySyutkkbnHyoujiymd(C_SyutkKbn.SYU, sysDate);

        Map<String, String> map = new HashMap<String, String>();

        for (BM_SyouhnZokusei syouhnzokusei : syouhnZokuseiLst) {
            if (!C_Sisuukbn.BLNK.eq(syouhnzokusei.getSisuukbn())) {
                String key = syouhnzokusei.getHknsyuruino().toString() + syouhnzokusei.getTuukasyu().toString();

                if (!map.containsKey(key)) {
                    BM_SisuuKihon sisuukihon = bizDomManager.getSisuuKihon(syouhnzokusei.getSisuukbn());
                    if (sisuukihon != null) {
                        String sisuunm = sisuukihon.getSisuunm();

                        map.put(key, sisuunm);
                    }
                }
            }
        }

        uiBean.setHknsyuruinomosinputOptionBeanList(udList);
        uiBean.setSyouhnzokuseiCtrlGetOutBeanLst(syouhnzokuseiCtrlGetOutBeanLst);
        uiBean.setSisuunmSyutokuMap(map);
    }

    private void setHknsyuruiNoSd() {
        if (!C_HknsyuruiNo.BLNK.eq(uiBean.getHknsyuruino())) {
            uiBean.setHknsyuruinosd(getGamenCtrlBean().getHknsyuruinosd());
        }
    }

    private void setAisyoumei() {
        if (!C_HknsyuruiNo.BLNK.eq(uiBean.getHknsyuruino()) &&
            uiBean.getHknsyuruinosd() != null &&
            !C_SkeijimuKbn.BLNK.eq(uiBean.getSkeijimuKbn()) &&
            !BizUtil.isBlank(uiBean.getSyouhncd())) {

            GetHknsyuruinm getHknsyuruinm = SWAKInjector.getInstance(GetHknsyuruinm.class);
            HknsyuruinmBean hknsyuruinmBean = getHknsyuruinm.getAisyoumeiMosnrk(
                uiBean.getHknsyuruinomosinput(),
                uiBean.getHknsyuruinosd(),
                uiBean.getSkeijimuKbn(),
                uiBean.getSyouhncd());

            uiBean.setAisyoumeikbn(hknsyuruinmBean.getAisyoumeikbn());
            uiBean.setAisyoumei(hknsyuruinmBean.getAisyoumei());
        }
    }

    private void check(GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean) {
        checkTankoumoku();

        BizDate sysDate = BizDate.getSysDate();

        setHknsyuruiNoSd();
        HM_SkHokenSyuruiNo skHokenSyuruiNo =
            sinkeiyakuDomManager.getSkHokenSyuruiNo(uiBean.getHknsyuruino(), uiBean.getHknsyuruinosd());

        uiBean.setDaihyouHknSyuruiNo(skHokenSyuruiNo.getDaihyouhknsyuruino());

        if (uiBean.getMosymd() != null) {
            if (BizDateUtil.compareYmd(uiBean.getMosymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EBA0026,
                    MessageUtil.getMessage(DDID_BASEINFO_MOSYMD.getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getMosymd(), sysDate.addYears(-1).getRekijyou()) == BizDateUtil.COMPARE_LESSER
                ||
                BizDateUtil.compareYmd(uiBean.getMosymd(), sysDate.addYears(-1).getRekijyou()) == BizDateUtil.COMPARE_EQUAL) {
                throw new BizLogicException(MessageId.EHC1001,
                    MessageUtil.getMessage(DDID_BASEINFO_MOSYMD.getErrorResourceKey()));
            }

            if (BizDateUtil.compareYmd(uiBean.getMosymd(),
                YuyuSinkeiyakuConfig.getInstance().getSystemHonbankadouYmd()) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EBA0028,
                    MessageUtil.getMessage(DDID_BASEINFO_MOSYMD.getErrorResourceKey()));
            }
        }

        if (C_KykKbn.KEIHI_DOUITU.eq(uiBean.getKykkbn())) {
            if (!BizUtil.isBlank(uiBean.getKyknmkn()) ||
                !BizUtil.isBlank(uiBean.getKyknmkj()) ||
                !C_KjkhukaKbn.BLNK.eq(uiBean.getKyknmkjkhukakbn()) ||
                uiBean.getKykseiymd() != null ||
                !C_Tdk.BLNK.eq(uiBean.getKyktdk()) ||
                !C_Kyksei.BLNK.eq(uiBean.getKyksei())) {
                throw new BizLogicException(MessageId.EHA1047);
            }
        }
        else if (C_KykKbn.KEIHI_BETU.eq(uiBean.getKykkbn())) {
            if (BizUtil.isBlank(uiBean.getKyknmkn())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_KEIYAKUSYAINFO2_KYKNMKN.getErrorResourceKey()));
            }
            if (uiBean.getKykseiymd() == null) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_KEIYAKUSYAINFO2_KYKSEIYMD.getErrorResourceKey()));
            }
            if (uiBean.getKykseiymd() != null &&
                BizDateUtil.compareYmd(uiBean.getKykseiymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EBF0124,
                    MessageUtil.getMessage(DDID_KEIYAKUSYAINFO2_KYKSEIYMD.getErrorResourceKey()));
            }
            if (BizDateUtil.compareYmd(uiBean.getKykseiymd(), uiBean.getMosymd()) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EHC1002,
                    MessageUtil.getMessage(DDID_KEIYAKUSYAINFO2_KYKSEIYMD.getErrorResourceKey()));
            }
            if (uiBean.getKyksei() == null || C_Kyksei.BLNK.eq(uiBean.getKyksei())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_KEIYAKUSYAINFO2_KYKSEI.getErrorResourceKey()));
            }
            if (uiBean.getKyktdk() == null || C_Tdk.BLNK.eq(uiBean.getKyktdk())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_KEIYAKUSYAINFO2_KYKTDK.getErrorResourceKey()));
            }
        }

        if (C_FatcasnsiKbn.BLNK.eq(uiBean.getFatcasnsikbn()) &&
            C_BikkjnssinfoKbn.BLNK.eq(uiBean.getBikkjnssinfokbn()) &&
            !BizUtil.isBlank(uiBean.getBikknzsyno())) {
            throw new BizLogicException(MessageId.EBA0108,
                MessageUtil.getMessage(DDID_KEIYAKUSYAINFO_BIKKNZSYNO.getErrorResourceKey()));
        }

        if (!BizUtil.isBlank(uiBean.getTsintelno()) &&
            !BizUtil.isBlank(uiBean.getDai2tsintelno()) &&
            uiBean.getTsintelno().equals(uiBean.getDai2tsintelno())) {
            throw new BizLogicException(MessageId.EBA1001,
                MessageUtil.getMessage(DDID_TUUSINSAKIINFO_TSINTELNO.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_TUUSINSAKIINFO_DAI2TSINTELNO.getErrorResourceKey()));
        }

        int adrKjCnt = uiBean.getTsinadr1kj().length() + uiBean.getTsinadr2kj().length() +
            uiBean.getTsinadr3kj().length();
        int jyuusyoNrkJyougenCnt = YuyuBizConfig.getInstance().getJyuusyoNyuuryokuJyougenCnt();
        if (adrKjCnt > jyuusyoNrkJyougenCnt) {
            throw new BizLogicException(MessageId.EBA1003,
                TUUSINSAKIINFO_TSINADRKJ,
                String.valueOf(adrKjCnt), String.valueOf(jyuusyoNrkJyougenCnt));
        }

        if (BizDateUtil.compareYmd(uiBean.getHhknseiymd(), uiBean.getMosymd()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHC1002,
                MessageUtil.getMessage(DDID_HIHOKENSYAINFO_HHKNSEIYMD.getErrorResourceKey()));
        }

        if (uiBean.getHhknnmkjkhukakbn() == null ||
            C_KjkhukaKbn.BLNK.eq(uiBean.getHhknnmkjkhukakbn())) {
            if (BizUtil.isBlank(uiBean.getHhknnmkj())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_HIHOKENSYAINFO_HHKNNMKJ.getErrorResourceKey()));
            }
        }

        if (uiBean.getTsindousiteikbn() == null) {
            uiBean.setTsindousiteikbn(C_TsindousiteiKbn.BLNK);
        }

        if (C_TsindousiteiKbn.BLNK.eq(uiBean.getTsindousiteikbn())) {
            if (BizUtil.isBlank(uiBean.getHhknyno()) || BizUtil.isBlank(uiBean.getHhknadr1kj())) {
                throw new BizLogicException(MessageId.EHA0351);
            }
        }

        adrKjCnt = uiBean.getHhknadr1kj().length() + uiBean.getHhknadr2kj().length() +
            uiBean.getHhknadr3kj().length();
        if (adrKjCnt > jyuusyoNrkJyougenCnt) {
            throw new BizLogicException(MessageId.EBA1003,
                HIHOKENSYAINFO_HHKNADRKJ,
                String.valueOf(adrKjCnt), String.valueOf(jyuusyoNrkJyougenCnt));
        }

        if (!C_TsindousiteiKbn.BLNK.eq(uiBean.getTsindousiteikbn())) {
            if ((!BizUtil.isBlank(uiBean.getHhknyno())) || (!BizUtil.isBlank(uiBean.getHhknadr1kj()))
                || (!BizUtil.isBlank(uiBean.getHhknadr2kj()))
                || (!BizUtil.isBlank(uiBean.getHhknadr3kj()))) {
                throw new BizLogicException(MessageId.EBF0151);
            }
        }

        uiBean.setHhknsykgynm("");

        if (!BizUtil.isBlank(uiBean.getHhknsykgycd())) {
            BM_Syokugyou syokugyou = bizDomManager.getSyokugyou(uiBean.getHhknsykgycd());
            if (syokugyou != null) {
                uiBean.setHhknsykgynm(syokugyou.getSyokugyounm());
            }
            else {
                throw new BizLogicException(MessageId.EBA0030,
                    MessageUtil.getMessage(DDID_HIHOKENSYAINFO_HHKNSYKGYCD.getErrorResourceKey()));
            }
        }

        if (!C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getItijibrumu())
            && !C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getNkhknumu())) {
            if (uiBean.getHhknnensyuukbn() == null || C_NensyuuKbn.BLNK.eq(uiBean.getHhknnensyuukbn())) {
                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_HIHOKENSYAINFO_HHKNNENSYUUKBN },
                    MessageUtil.getMessage(DDID_HIHOKENSYAINFO_HHKNNENSYUUKBN.getErrorResourceKey()));
            }
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getSbuktumu())) {
            List<C_UktKbn> sbUktKbnLst = Lists.newArrayList();
            sbUktKbnLst.add(uiBean.getSbuktkbn1());
            sbUktKbnLst.add(uiBean.getSbuktkbn2());
            sbUktKbnLst.add(uiBean.getSbuktkbn3());
            sbUktKbnLst.add(uiBean.getSbuktkbn4());
            List<String> sbUktNmKnLst = Lists.newArrayList();
            sbUktNmKnLst.add(uiBean.getSbuktnmkn1());
            sbUktNmKnLst.add(uiBean.getSbuktnmkn2());
            sbUktNmKnLst.add(uiBean.getSbuktnmkn3());
            sbUktNmKnLst.add(uiBean.getSbuktnmkn4());
            List<String> sbUktNmKjLst = Lists.newArrayList();
            sbUktNmKjLst.add(uiBean.getSbuktnmkj1());
            sbUktNmKjLst.add(uiBean.getSbuktnmkj2());
            sbUktNmKjLst.add(uiBean.getSbuktnmkj3());
            sbUktNmKjLst.add(uiBean.getSbuktnmkj4());
            List<C_KjkhukaKbn> sbUktNmKjhukaKbnLst = Lists.newArrayList();
            sbUktNmKjhukaKbnLst.add(uiBean.getSbuktnmkjhukakbn1());
            sbUktNmKjhukaKbnLst.add(uiBean.getSbuktnmkjhukakbn2());
            sbUktNmKjhukaKbnLst.add(uiBean.getSbuktnmkjhukakbn3());
            sbUktNmKjhukaKbnLst.add(uiBean.getSbuktnmkjhukakbn4());
            List<BizDate> sbUktSeiymdLst = Lists.newArrayList();
            sbUktSeiymdLst.add(uiBean.getSbuktseiymd1());
            sbUktSeiymdLst.add(uiBean.getSbuktseiymd2());
            sbUktSeiymdLst.add(uiBean.getSbuktseiymd3());
            sbUktSeiymdLst.add(uiBean.getSbuktseiymd4());
            List<C_Tdk> sbUktTdkLst = Lists.newArrayList();
            sbUktTdkLst.add(uiBean.getSbukttdk1());
            sbUktTdkLst.add(uiBean.getSbukttdk2());
            sbUktTdkLst.add(uiBean.getSbukttdk3());
            sbUktTdkLst.add(uiBean.getSbukttdk4());
            List<BizNumber> sbUktBnwariLst = Lists.newArrayList();
            sbUktBnwariLst.add(uiBean.getSbuktbnwari1());
            sbUktBnwariLst.add(uiBean.getSbuktbnwari2());
            sbUktBnwariLst.add(uiBean.getSbuktbnwari3());
            sbUktBnwariLst.add(uiBean.getSbuktbnwari4());

            if (uiBean.getSbuktnin() == null ||
                uiBean.getSbuktnin() == 0) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_SIBOUUKETORINININFO_SBUKTNIN.getErrorResourceKey()));
            }

            if (uiBean.getSbuktnin() > MAX_UKT_SIBOU) {
                int nrkHyouji = 0;
                for (int index = 0; index < MAX_UKT_SIBOU; index++) {
                    if (C_UktKbn.BLNK.eq(sbUktKbnLst.get(index)) &&
                        BizUtil.isBlank(sbUktNmKnLst.get(index)) &&
                        BizUtil.isBlank(sbUktNmKjLst.get(index)) &&
                        C_KjkhukaKbn.BLNK.eq(sbUktNmKjhukaKbnLst.get(index)) &&
                        sbUktSeiymdLst.get(index) == null &&
                        C_Tdk.BLNK.eq(sbUktTdkLst.get(index)) &&
                        (sbUktBnwariLst.get(index) == null || sbUktBnwariLst.get(index).isOptional())) {
                    }
                    else {
                        nrkHyouji = 1;
                    }
                }

                if (nrkHyouji == 1) {
                    throw new BizLogicException(MessageId.EHA1041);
                }
            }
            else {
                int uktKbnNrkCounter = 0;
                int sbUktKykCounter = 0;
                BizNumber uktBnwariTotal = BizNumber.ZERO;

                for (int index = 0; index < MAX_UKT_SIBOU; index++) {
                    if (!C_UktKbn.BLNK.eq(sbUktKbnLst.get(index))) {
                        uktKbnNrkCounter = uktKbnNrkCounter + 1;
                    }

                    if (C_UktKbn.KYK.eq(sbUktKbnLst.get(index))) {
                        sbUktKykCounter = sbUktKykCounter + 1;

                        if (sbUktKykCounter > 1) {
                            throw new BizLogicException(MessageId.EHA0285,
                                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSIBOUUKT, sbUktKbnLst.get(index)
                                    .getValue()));
                        }
                    }

                    if (C_UktKbn.KYK.eq(sbUktKbnLst.get(index)) &&
                        C_KykKbn.KEIHI_DOUITU.eq(uiBean.getKykkbn())) {
                        throw new BizLogicException(MessageId.EHA1002,
                            C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSIBOUUKT, sbUktKbnLst.get(index).getValue()));
                    }

                    if (C_UktKbn.KYK.eq(sbUktKbnLst.get(index))) {
                        if (BizUtil.isBlank(sbUktNmKnLst.get(index)) &&
                            BizUtil.isBlank(sbUktNmKjLst.get(index)) &&
                            C_KjkhukaKbn.BLNK.eq(sbUktNmKjhukaKbnLst.get(index)) &&
                            sbUktSeiymdLst.get(index) == null &&
                            C_Tdk.BLNK.eq(sbUktTdkLst.get(index))) {
                        }
                        else {
                            throw new BizLogicException(MessageId.EHA0284,
                                C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSIBOUUKT, sbUktKbnLst.get(index).getValue()));
                        }
                    }

                    if (C_UktKbn.TOKUTEIMEIGI.eq(sbUktKbnLst.get(index))) {
                        if (BizUtil.isBlank(sbUktNmKnLst.get(index)) ||
                            (BizUtil.isBlank(sbUktNmKjLst.get(index)) &&
                                C_KjkhukaKbn.BLNK.eq(sbUktNmKjhukaKbnLst.get(index))) ||
                                sbUktSeiymdLst.get(index) == null ||
                                C_Tdk.BLNK.eq(sbUktTdkLst.get(index))) {
                            throw new BizLogicException(MessageId.EHA0049);
                        }
                    }

                    if (C_UktKbn.BLNK.eq(sbUktKbnLst.get(index))) {
                        if (BizUtil.isBlank(sbUktNmKnLst.get(index)) &&
                            BizUtil.isBlank(sbUktNmKjLst.get(index)) &&
                            C_KjkhukaKbn.BLNK.eq(sbUktNmKjhukaKbnLst.get(index)) &&
                            sbUktSeiymdLst.get(index) == null &&
                            C_Tdk.BLNK.eq(sbUktTdkLst.get(index)) &&
                            (sbUktBnwariLst.get(index) == null || sbUktBnwariLst.get(index).isOptional())) {
                        }
                        else {
                            throw new BizLogicException(MessageId.EHA0049);
                        }
                    }

                    if (sbUktBnwariLst.get(index) != null &&
                        !sbUktBnwariLst.get(index).isOptional()) {
                        uktBnwariTotal = uktBnwariTotal.add(sbUktBnwariLst.get(index));
                    }
                }

                if (uiBean.getSbuktnin() != uktKbnNrkCounter) {
                    throw new BizLogicException(MessageId.EBC0045,
                        MessageUtil.getMessage(DDID_SIBOUUKETORINININFO_SBUKTNIN.getErrorResourceKey()).concat("分"));
                }

                if (!uktBnwariTotal.isZeroOrOptional() &&
                    uktBnwariTotal.compareTo(UKTBNWARI_100) != 0) {
                    throw new BizLogicException(MessageId.EHA1003);
                }

                if (uktBnwariTotal.isZeroOrOptional() &&
                    uiBean.getSbuktnin() == 1) {
                    uiBean.setSbuktbnwari1(UKTBNWARI_100);
                }
            }
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getHengakuumu()) &&
            C_NkgnsHosyourituKbn.BLNK.eq(uiBean.getNkgnshosyouritukbn())) {
            throw new BizLogicException(MessageId.EBC0045,
                MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_NKGNSHOSYOURITUKBN.getErrorResourceKey()));
        }

        if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(uiBean.getHknsyuruino()) &&
            pGetSyouhnZokuseiCtrlOutBean.getDai1HknkknSelect().size() != 0) {
            if ("0".equals(uiBean.getSyudai1hknkknmosinput())) {
                SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
                BizDate kijyunBi;

                if (uiBean.getMoscalckijyunymd() != null) {
                    kijyunBi = uiBean.getMoscalckijyunymd();
                }
                else {
                    kijyunBi = uiBean.getMosymd();
                }

                int hhknNenrei = setNenrei.exec(kijyunBi, uiBean.getHhknseiymd());

                setSyouhnInfoKobetu(hhknNenrei);
            }
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getGaikatatkiumu())) {
            if (C_Tuukasyu.BLNK.eq(uiBean.getKyktuukasyu())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_KYKTUUKASYUMOSINPUT.getErrorResourceKey()));
            }

            if (C_Tuukasyu.BLNK.eq(uiBean.getHrktuukasyu())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_HRKTUUKASYUMOSINPUT.getErrorResourceKey()));
            }
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getNkhknumu()) &&
            C_Sknenkinsyu.BLNK.eq(C_Sknenkinsyu.valueOf(uiBean.getNenkinsyumosinput()))) {
            throw new BizLogicException(MessageId.EBC0045,
                new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_NENKINSYUMOSINPUT },
                MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_NENKINSYUMOSINPUT.getErrorResourceKey()));
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getSyksbyensitihsyutktekiumu())) {
            if (C_Tkhukaumu.BLNK.eq(uiBean.getSyksbyensitihsyutkhkkbn())) {
                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_SONOTATOKUYAKUINFO2_SYKSBYENSITIHSYUTKHKKBN },
                    MessageUtil.getMessage(DDID_SONOTATOKUYAKUINFO2_SYKSBYENSITIHSYUTKHKKBN.getErrorResourceKey()));
            }
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getTeikisiharaikinumu()) &&
            C_Tkhukaumu.BLNK.eq(uiBean.getTeikisiharaitkykhkkbn())) {
            throw new BizLogicException(MessageId.EBC0045,
                new Item[] { DDID_UKETORIKOUZAINFO_TEIKISIHARAITKYKHKKBN },
                MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_TEIKISIHARAITKYKHKKBN.getErrorResourceKey()));
        }

        List<BM_SyouhnZokusei> syouhnZokuseiLst = new ArrayList<BM_SyouhnZokusei>();
        Integer nkgnsHosyouRitu;
        C_UmuKbn syksbYenSitihsyutkTekiUmu;
        C_Sknenkinsyu sknenkinsyu;
        C_UmuKbn teikisiharaikinumu;

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getHengakuumu())) {
            nkgnsHosyouRitu = Integer.parseInt(uiBean.getNkgnshosyouritukbn().getValue());
        }
        else {
            nkgnsHosyouRitu = 0;
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getSyksbyensitihsyutktekiumu())) {
            if (C_Tkhukaumu.HUKA.eq(uiBean.getSyksbyensitihsyutkhkkbn())) {
                syksbYenSitihsyutkTekiUmu = C_UmuKbn.ARI;
            }
            else {
                syksbYenSitihsyutkTekiUmu = C_UmuKbn.NONE;
            }
        }
        else {
            syksbYenSitihsyutkTekiUmu = C_UmuKbn.NONE;
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getNkhknumu())) {
            sknenkinsyu = C_Sknenkinsyu.valueOf(uiBean.getNenkinsyumosinput());
        }
        else {
            sknenkinsyu = C_Sknenkinsyu.BLNK;
        }

        if (C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn())) {
            teikisiharaikinumu = C_UmuKbn.ARI;
        }
        else {
            teikisiharaikinumu = C_UmuKbn.NONE;
        }

        if (C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(uiBean.getHknsyuruino())) {

            Integer dai1hknKkn;
            C_Tuukasyu tuukasyuParam;

            if (pGetSyouhnZokuseiCtrlOutBean.getDai1HknkknSelect().size() != 0) {
                dai1hknKkn = Integer.parseInt(uiBean.getSyudai1hknkknmosinput());
            }
            else {
                dai1hknKkn = 0;
            }

            if (!C_Tuukasyu.BLNK.eq(pGetSyouhnZokuseiCtrlOutBean.getTuukasyu())) {
                tuukasyuParam = uiBean.getKyktuukasyu();
            }
            else {
                tuukasyuParam = C_Tuukasyu.BLNK;
            }

            syouhnZokuseiLst =
                bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(sysDate,
                    C_SyutkKbn.SYU, uiBean.getDaihyouHknSyuruiNo(), nkgnsHosyouRitu, dai1hknKkn,
                    tuukasyuParam, syksbYenSitihsyutkTekiUmu, sknenkinsyu, teikisiharaikinumu);
        }
        else {
            syouhnZokuseiLst =
                bizDomManager.getSyouhnZokuseisByHknsyuruinoItems2(sysDate,
                    C_SyutkKbn.SYU, uiBean.getDaihyouHknSyuruiNo(), nkgnsHosyouRitu, syksbYenSitihsyutkTekiUmu,
                    sknenkinsyu, teikisiharaikinumu);
        }

        if (syouhnZokuseiLst.size() == 0) {
            throw new BizLogicException(MessageId.EHA1060, "商品情報", "商品");
        }

        BM_SyouhnZokusei syouhnZokusei = syouhnZokuseiLst.get(0);

        uiBean.setSyouhnZokusei(syouhnZokusei);

        syouhnZokusei.detach();

        uiBean.setSyouhncd(syouhnZokusei.getSyouhncd());

        if (!C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(uiBean.getHknsyuruino()) ) {
            if (pGetSyouhnZokuseiCtrlOutBean.getDai1HknkknSelect().size() != 0
                && BizUtil.isBlank(uiBean.getSyudai1hknkknmosinput())) {
                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_SYUDAI1HKNKKNMOSINPUT },
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_SYUDAI1HKNKKNMOSINPUT.getErrorResourceKey()));
            }
        }

        if (C_UmuKbn.NONE.eq(syouhnZokusei.getSdumu()) &&
            C_Sdpd.SD.eq(uiBean.getSdpdkbn())) {
            throw new BizLogicException(MessageId.EHA1004, C_Sdpd.SD.getContent());
        }

        if (C_UmuKbn.NONE.eq(syouhnZokusei.getPdumu()) &&
            C_Sdpd.PD.eq(uiBean.getSdpdkbn())) {
            throw new BizLogicException(MessageId.EHA1004, C_Sdpd.PD.getContent());
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getHokenkngkyakujyouumu())) {
            if (C_Sdpd.BLNK.eq(uiBean.getSdpdkbn())) {

                String syukihons = "";
                String mossyukykp = "";

                if (!C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                    if (!uiBean.getSyukihons().isOptional() && BizCurrency.valueOf(100, uiBean.getSyukihons().getType()).compareTo(uiBean.getSyukihons()) <= 0) {
                        syukihons = uiBean.getSyukihons().toAdsoluteString();
                        syukihons = syukihons.substring(syukihons.length() - 4, syukihons.length());
                    }
                    else {
                        if (uiBean.getSyukihons().isOptional()) {
                            syukihons = "0";
                        }
                        else {
                            syukihons = uiBean.getSyukihons().toAdsoluteString();
                        }
                    }
                    if (!uiBean.getMossyukykp().isOptional() && BizCurrency.valueOf(10, uiBean.getMossyukykp().getType()).compareTo(uiBean.getMossyukykp()) <= 0) {
                        mossyukykp = uiBean.getMossyukykp().toAdsoluteString();
                        mossyukykp = mossyukykp.substring(mossyukykp.length() - 3, mossyukykp.length());
                    }
                    else {
                        if (uiBean.getMossyukykp().isOptional()) {
                            mossyukykp = "0";
                        }
                        else {
                            mossyukykp = uiBean.getMossyukykp().toAdsoluteString();
                        }
                    }
                }
                else {
                    if (!uiBean.getSyukihons().isOptional() && BizCurrency.valueOf(10000, uiBean.getSyukihons().getType()).compareTo(uiBean.getSyukihons()) <= 0) {
                        syukihons = uiBean.getSyukihons().toAdsoluteString();
                        syukihons = syukihons.substring(syukihons.length() - 4, syukihons.length());
                    }
                    else {
                        if (uiBean.getSyukihons().isOptional()) {
                            syukihons = "0";
                        }
                        else {
                            syukihons = uiBean.getSyukihons().toAdsoluteString();
                        }
                    }
                    if (!uiBean.getMossyukykp().isOptional() && BizCurrency.valueOf(1000, uiBean.getMossyukykp().getType()).compareTo(uiBean.getMossyukykp()) <= 0) {
                        mossyukykp = uiBean.getMossyukykp().toAdsoluteString();
                        mossyukykp = mossyukykp.substring(mossyukykp.length() - 3, mossyukykp.length());
                    }
                    else {
                        if (uiBean.getMossyukykp().isOptional()) {
                            mossyukykp = "0";
                        }
                        else {
                            mossyukykp = uiBean.getMossyukykp().toAdsoluteString();
                        }
                    }
                }

                if ((Integer.valueOf(syukihons) == 0 && Integer.valueOf(mossyukykp) == 0)
                    || (Integer.valueOf(syukihons) != 0 && Integer.valueOf(mossyukykp) != 0)) {
                    throw new BizLogicException(MessageId.EHF1035,
                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_SDPDKBN },
                        MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_SDPDKBN.getErrorResourceKey()));
                }
            }
        }
        else {
            if (C_Sdpd.BLNK.eq(uiBean.getSdpdkbn())) {
                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_SDPDKBN },
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_SDPDKBN.getErrorResourceKey()));
            }
        }

        if (!C_UmuKbn.ARI.eq(syouhnZokusei.getHokenkngkyakujyouumu())) {
            if (!uiBean.getSyukihons().isZeroOrOptional()) {
                throw new BizLogicException(MessageId.EBA0108,
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_SYUKIHONS.getErrorResourceKey()));
            }
        }
        else {
            if (uiBean.getSyukihons().isZeroOrOptional()) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_SYUKIHONS.getErrorResourceKey()));
            }
        }

        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
            if (uiBean.getMossyukykp().isZeroOrOptional()) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSSYUKYKP.getErrorResourceKey()));
            }
        }
        else {
            if (!uiBean.getMossyukykp().isZeroOrOptional()) {
                throw new BizLogicException(MessageId.EBA0108,
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSSYUKYKP.getErrorResourceKey()));
            }
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getHeijyunbaraiumu())) {
            if (!C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(uiBean.getHknsyuruino())
                && !C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(uiBean.getHknsyuruino())) {
                if (uiBean.getSyuhrkkkn() == null) {

                    if (C_UmuKbn.NONE.eq(syouhnZokusei.getNkhknumu())) {

                        throw new BizLogicException(
                            MessageId.EBC0045, new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_SYUHRKKKN },
                            MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_SYUHRKKKN.getErrorResourceKey()));
                    }

                    throw new BizLogicException(MessageId.EBC0045, new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_SYUHRKKKN },
                        DISPHRKKKNTRL);
                }
            }

            if (uiBean.getSyuhknkkn() == null) {

                if (C_UmuKbn.NONE.eq(syouhnZokusei.getNkhknumu())) {

                    throw new BizLogicException(MessageId.EBC0045, new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_SYUHKNKKN },
                        MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_SYUHKNKKN.getErrorResourceKey()));
                }

                throw new BizLogicException(MessageId.EBC0045, new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_SYUHKNKKN },
                    DISPHKNKKNtRL);
            }
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnZokusei.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (uiBean.getSyuhrkkkn() >= DISPSEIGENNEN_19 &&
                C_Sknenkinsyu.KKTI5DAI1BAIGAKU.eq(C_Sknenkinsyu.valueOf(uiBean.getNenkinsyumosinput()))) {

                throw new BizLogicException(MessageId.EHC1111,
                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_NENKINSYUMOSINPUT },
                    C_Sknenkinsyu.KKTI5DAI1BAIGAKU.getContent(),
                    DISPHRKKKNTRL, String.valueOf(uiBean.getSyuhrkkkn()));
            }

            if (uiBean.getSyuhknkkn() >= DISPSEIGENNEN_19 &&
                C_Sknenkinsyu.KKTI5DAI1BAIGAKU.eq(C_Sknenkinsyu.valueOf(uiBean.getNenkinsyumosinput()))) {

                throw new BizLogicException(MessageId.EHC1111,
                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_NENKINSYUMOSINPUT },
                    C_Sknenkinsyu.KKTI5DAI1BAIGAKU.getContent(),
                    DISPHKNKKNtRL, String.valueOf(uiBean.getSyuhknkkn()));
            }

            if (uiBean.getSyuhrkkkn() > uiBean.getSyuhknkkn()) {
                throw new BizLogicException(MessageId.EHC1104);
            }
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getHeijyunbaraiumu())) {
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getZennouumu())) {
                if (C_BlnktkumuKbn.ARI.eq(uiBean.getZenkizennouumu())) {
                    uiBean.setHrkkeiro(C_Hrkkeiro.HURIKAE);
                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikiikkatubaraiumu())) {
                        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU12);
                    }
                    else {
                        uiBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
                    }
                }
            }
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getHeijyunbaraiumu())) {
            if (C_Hrkkaisuu.BLNK.eq(uiBean.getHrkkaisuu())) {

                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_HRKKAISUUMOSINPUT },
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_HRKKAISUUMOSINPUT.getErrorResourceKey()));
            }

            if (C_Hrkkeiro.BLNK.eq(uiBean.getHrkkeiro())) {

                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_HRKKEIRO },
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_HRKKEIRO.getErrorResourceKey()));
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getZennouumu())) {
                if (C_BlnktkumuKbn.BLNK.eq(uiBean.getZenkizennouumu())) {
                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT },
                        MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT.getErrorResourceKey()));
                }

                if (C_BlnktkumuKbn.NONE.eq(uiBean.getZenkizennouumu())) {
                    if (C_UmuKbn.NONE.eq(syouhnZokusei.getItibuzennoutekiumu())) {
                        if (C_UmuKbn.NONE.eq(syouhnZokusei.getTeikiikkatubaraiumu())) {
                            if (C_Hrkkaisuu.TUKI.eq(uiBean.getHrkkaisuu())
                                || C_Hrkkaisuu.HALFY.eq(uiBean.getHrkkaisuu())) {
                                if (C_Hrkkeiro.HURIKAE.eq(uiBean.getHrkkeiro())) {
                                    throw new BizLogicException(MessageId.EHC1100,
                                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_HRKKAISUUMOSINPUT },
                                        uiBean.getHrkkeiro().getContent(), uiBean.getHrkkaisuu().getContent());
                                }
                            }
                        }

                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikiikkatubaraiumu())) {
                            if (C_Hrkkeiro.HURIKAE.eq(uiBean.getHrkkeiro())) {
                                throw new BizLogicException(MessageId.EHC0019,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT },
                                    C_HknsyuruiNo.valueOf(uiBean.getHknsyuruinomosinput()).getContent(), ITIBUZENNOUEN);
                            }
                        }

                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getItibuzennoutekiumu())) {
                            if (uiBean.getZnnkai() == null || uiBean.getZnnkai() == 0) {
                                throw new BizLogicException(MessageId.EBC0045,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_ZNNKAI },
                                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_ZNNKAI.getErrorResourceKey()));
                            }

                            if (uiBean.getZnnkai() < YuyuSinkeiyakuConfig.getInstance().getZnnKaiMin()) {
                                throw new BizLogicException(MessageId.EBC0046,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_ZNNKAI },
                                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_ZNNKAI.getErrorResourceKey()));
                            }
                        }
                    }
                }

                if (C_BlnktkumuKbn.ARI.eq(uiBean.getZenkizennouumu())) {
                    if (C_UmuKbn.NONE.eq(syouhnZokusei.getZenkizennoutekiumu())) {
                        throw new BizLogicException(MessageId.EHC0019,
                            new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT },
                            C_HknsyuruiNo.valueOf(uiBean.getHknsyuruinomosinput()).getContent(), ITIBUZENNOUEN);
                    }
                    uiBean.setZnnkai(0);
                }
            }
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getHeijyunbaraiumu())) {
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getZennouumu())) {
                if (C_BlnktkumuKbn.NONE.eq(uiBean.getZenkizennouumu())) {
                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikiikkatubaraiumu())) {
                        if (C_IkkatubaraiKaisuuKbn.BLNK.eq(uiBean.getIkkatubaraikaisuu())) {
                            if (uiBean.getHrktuukasyukykp().isZeroOrOptional() &&
                                uiBean.getMosikkatup().isZeroOrOptional() &&
                                uiBean.getMoszennoupsyokaiari().isZeroOrOptional() &&
                                uiBean.getHrktuukasyukykp2().isZeroOrOptional() &&
                                uiBean.getMosikkatup2().isZeroOrOptional() &&
                                uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {

                                throw new BizLogicException(MessageId.EBC0043,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFOBEI_HRKTUUKASYUKYKP,
                                    DDID_SYUKEIYAKUHOSYOUINFOGOU_HRKTUUKASYUKYKP2 },
                                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_HRKTUUKASYUKYKP
                                        .getErrorResourceKey()));
                            }

                            if (!uiBean.getMosikkatup().isZeroOrOptional()) {

                                String message = checkSyukeiyakuHosyouInfo2(
                                    DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSIKKATUP,
                                    uiBean.getKyktuukasyu());

                                throw new BizLogicException(MessageId.EHC1117,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_IKKATUBARAIKAISUUMOSINPUT }, message,
                                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_IKKATUBARAIKAISUUMOSINPUT
                                        .getErrorResourceKey()));
                            }

                            if (!uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) {

                                String message = checkSyukeiyakuHosyouInfo2(
                                    DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSZENNOUPSYOKAIARI,
                                    uiBean.getKyktuukasyu());

                                throw new BizLogicException(MessageId.EHC1114,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT },
                                    message, MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT
                                        .getErrorResourceKey()),
                                        C_UmuKbn.ARI.getContent());
                            }

                            if (!uiBean.getMosikkatup2().isZeroOrOptional()) {

                                String message = checkSyukeiyakuHosyouInfo2(
                                    DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSIKKATUP2,
                                    uiBean.getKyktuukasyu2());

                                throw new BizLogicException(MessageId.EHC1117,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_IKKATUBARAIKAISUUMOSINPUT }, message,
                                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_IKKATUBARAIKAISUUMOSINPUT
                                        .getErrorResourceKey()));
                            }

                            if (!uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {

                                String message = checkSyukeiyakuHosyouInfo2(
                                    DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSZENNOUPSYOKAIARI2,
                                    uiBean.getKyktuukasyu2());

                                throw new BizLogicException(MessageId.EHC1114,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT },
                                    message, MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT
                                        .getErrorResourceKey()),
                                        C_UmuKbn.ARI.getContent());
                            }
                        }

                        if (C_IkkatubaraiKaisuuKbn.IKKATU6.eq(uiBean.getIkkatubaraikaisuu()) ||
                            C_IkkatubaraiKaisuuKbn.IKKATU12.eq(uiBean.getIkkatubaraikaisuu())) {

                            if (uiBean.getMosikkatup().isZeroOrOptional() &&
                                uiBean.getMoszennoupsyokaiari().isZeroOrOptional() &&
                                uiBean.getMosikkatup2().isZeroOrOptional() &&
                                uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {

                                throw new BizLogicException(MessageId.EBC0043,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSIKKATUP,
                                    DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSIKKATUP2 },
                                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSIKKATUP
                                        .getErrorResourceKey()));
                            }

                            if (!uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) {
                                String message = checkSyukeiyakuHosyouInfo2(
                                    DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSZENNOUPSYOKAIARI,
                                    uiBean.getKyktuukasyu());

                                throw new BizLogicException(MessageId.EHC1114,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT },
                                    message, MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT
                                        .getErrorResourceKey()),
                                        C_UmuKbn.ARI.getContent());
                            }

                            if (!uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {
                                String message = checkSyukeiyakuHosyouInfo2(
                                    DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSZENNOUPSYOKAIARI2,
                                    uiBean.getKyktuukasyu2());

                                throw new BizLogicException(MessageId.EHC1114,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT },
                                    message, MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_ZENKIZENNOUUMUMOSINPUT
                                        .getErrorResourceKey()),
                                        C_UmuKbn.ARI.getContent());
                            }
                        }
                    }
                }

                if (C_BlnktkumuKbn.ARI.eq(uiBean.getZenkizennouumu())) {
                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikiikkatubaraiumu())) {
                        if (C_IkkatubaraiKaisuuKbn.IKKATU12.eq(uiBean.getIkkatubaraikaisuu())) {
                            if (uiBean.getMosikkatup().isZeroOrOptional() &&
                                uiBean.getMoszennoupsyokaiari().isZeroOrOptional() &&
                                uiBean.getMosikkatup2().isZeroOrOptional() &&
                                uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {

                                String message = MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSIKKATUP
                                    .getErrorResourceKey()) + "、"
                                    + MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSZENNOUPSYOKAIARI
                                        .getErrorResourceKey());

                                throw new BizLogicException(MessageId.EBC0043,
                                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSIKKATUP,
                                    DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSZENNOUPSYOKAIARI,
                                    DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSZENNOUPSYOKAIARI2,
                                    DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSIKKATUP2 }, message);
                            }

                            if (uiBean.getMosikkatup().isZeroOrOptional()) {
                                if (!uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) {

                                    String message = checkSyukeiyakuHosyouInfo2(
                                        DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSIKKATUP,
                                        uiBean.getKyktuukasyu());

                                    throw new BizLogicException(MessageId.EBC0043,
                                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSIKKATUP }, message);
                                }

                            }

                            if (!uiBean.getMosikkatup().isZeroOrOptional()) {
                                if (uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) {

                                    String message = checkSyukeiyakuHosyouInfo2(
                                        DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSZENNOUPSYOKAIARI,
                                        uiBean.getKyktuukasyu());

                                    throw new BizLogicException(MessageId.EBC0043,
                                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSZENNOUPSYOKAIARI }, message);
                                }

                            }

                            if (uiBean.getMosikkatup2().isZeroOrOptional()) {
                                if (!uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {

                                    String message = checkSyukeiyakuHosyouInfo2(
                                        DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSIKKATUP2,
                                        uiBean.getKyktuukasyu2());

                                    throw new BizLogicException(MessageId.EBC0043,
                                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSIKKATUP2 }, message);
                                }
                            }

                            if (!uiBean.getMosikkatup2().isZeroOrOptional()) {
                                if (uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {

                                    String message = checkSyukeiyakuHosyouInfo2(
                                        DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSZENNOUPSYOKAIARI2,
                                        uiBean.getKyktuukasyu2());

                                    throw new BizLogicException(MessageId.EBC0043,
                                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFOGOU_MOSZENNOUPSYOKAIARI2 }, message);
                                }
                            }
                        }
                    }
                    else {
                        if (uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) {
                            throw new BizLogicException(MessageId.EBC0045,
                                new Item[] { DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSZENNOUPSYOKAIARI },
                                MessageUtil.getMessage(
                                    DDID_SYUKEIYAKUHOSYOUINFOBEI_MOSZENNOUPSYOKAIARI.getErrorResourceKey()));
                        }
                    }
                }
            }
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getZeiseitekikakuumu())) {
            if (C_Tkhukaumu.BLNK.eq(uiBean.getKjnnkpzeitekitkhukakbn())) {
                if (!uiBean.getHrktuukasyukykp().isZeroOrOptional() ||
                    !uiBean.getMosikkatup().isZeroOrOptional() ||
                    !uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) {

                    String message = checkSyukeiyakuHosyouInfo2(
                        DDID_SYUKEIYAKUHOSYOUINFOBEI_KJNNKPZEITEKITKHUKAKBN, uiBean.getKyktuukasyu());

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFOBEI_KJNNKPZEITEKITKHUKAKBN }, message);

                }
            }

            if (!C_Tkhukaumu.BLNK.eq(uiBean.getKjnnkpzeitekitkhukakbn())) {
                if (uiBean.getHrktuukasyukykp().isZeroOrOptional() &&
                    uiBean.getMosikkatup().isZeroOrOptional() &&
                    uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) {

                    String message = checkSyukeiyakuHosyouInfo2(
                        DDID_SYUKEIYAKUHOSYOUINFOBEI_KJNNKPZEITEKITKHUKAKBN, uiBean.getKyktuukasyu());

                    throw new BizLogicException(MessageId.EHC1113,
                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFOBEI_KJNNKPZEITEKITKHUKAKBN },
                        "金額項目", message, uiBean.getKjnnkpzeitekitkhukakbn().getContent());
                }
            }

            if (C_Tkhukaumu.BLNK.eq(uiBean.getKjnnkpzeitekitkhukakbn2())) {
                if (!uiBean.getHrktuukasyukykp2().isZeroOrOptional() ||
                    !uiBean.getMosikkatup2().isZeroOrOptional() ||
                    !uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {

                    String message = checkSyukeiyakuHosyouInfo2(
                        DDID_SYUKEIYAKUHOSYOUINFOGOU_KJNNKPZEITEKITKHUKAKBN2, uiBean.getKyktuukasyu2());

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFOGOU_KJNNKPZEITEKITKHUKAKBN2 }, message);

                }
            }

            if (!C_Tkhukaumu.BLNK.eq(uiBean.getKjnnkpzeitekitkhukakbn2())) {
                if (uiBean.getHrktuukasyukykp2().isZeroOrOptional() &&
                    uiBean.getMosikkatup2().isZeroOrOptional() &&
                    uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {

                    String message = checkSyukeiyakuHosyouInfo2(
                        DDID_SYUKEIYAKUHOSYOUINFOGOU_KJNNKPZEITEKITKHUKAKBN2, uiBean.getKyktuukasyu2());

                    throw new BizLogicException(MessageId.EHC1113,
                        new Item[] { DDID_SYUKEIYAKUHOSYOUINFOGOU_KJNNKPZEITEKITKHUKAKBN2 },
                        "金額項目", message, uiBean.getKjnnkpzeitekitkhukakbn2().getContent());
                }
            }
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getGaikatatkiumu())) {
            if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                if (C_UmuKbn.NONE.eq(syouhnZokusei.getTeikiikkatubaraiumu())) {

                    if ((uiBean.getHrktuukasyukykp().isZeroOrOptional()) &&
                        (uiBean.getHrktuukasyukykp2().isZeroOrOptional())) {
                        throw new BizLogicException(MessageId.EBC0045,
                            MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_HRKTUUKASYUKYKP.getErrorResourceKey()));
                    }
                }
            }
            if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                if ((!uiBean.getHrktuukasyukykp().isZeroOrOptional()) ||
                    (!uiBean.getHrktuukasyukykp2().isZeroOrOptional())) {
                    throw new BizLogicException(MessageId.EBA0108,
                        MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_HRKTUUKASYUKYKP.getErrorResourceKey()));
                }
            }
        }
        else {
            if (!uiBean.getHrktuukasyukykp().isZeroOrOptional() ||
                !uiBean.getHrktuukasyukykp2().isZeroOrOptional()) {
                throw new BizLogicException(MessageId.EBA0108,
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFOBEI_HRKTUUKASYUKYKP.getErrorResourceKey()));
            }
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getGaikatatkiumu())) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getSyukihons().getType());

            if (!uiBean.getKyktuukasyu().eq(tuukasyu)) {
                String message1 = "";
                String message2 = "";

                if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                    message1 = SYUKEIYAKUHOSYOUINFO_BEI + "指定";
                    message2 = SYUKEIYAKUHOSYOUINFO_BEI + "保険金額／給付金額";
                }
                else {
                    message1 = "指定";
                    message2 = "保険金額／給付金額";
                }

                throw new BizLogicException(MessageId.EHA1062, message1, message2);
            }

            tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getHrktuukasyukykp().getType());

            if (!uiBean.getHrktuukasyu().eq(tuukasyu)) {
                String message1 = "";
                String message2 = "";
                if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                    message1 = SYUKEIYAKUHOSYOUINFO_BEI + "払込";
                    message2 = SYUKEIYAKUHOSYOUINFO_BEI + "払込金額";
                }
                else {
                    message1 = "払込";
                    message2 = "払込金額";
                }

                throw new BizLogicException(MessageId.EHA1062, message1, message2);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getKihons2().getType());
                if (!uiBean.getKyktuukasyu2().eq(tuukasyu)) {

                    throw new BizLogicException(MessageId.EHA1062,
                        SYUKEIYAKUHOSYOUINFO_GOU + "指定", SYUKEIYAKUHOSYOUINFO_GOU + "保険金額／給付金額");
                }

                tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getHrktuukasyukykp2().getType());
                if (!uiBean.getHrktuukasyu2().eq(tuukasyu)) {
                    throw new BizLogicException(MessageId.EHA1062, SYUKEIYAKUHOSYOUINFO_GOU + "払込",
                        SYUKEIYAKUHOSYOUINFO_GOU + "払込金額");
                }
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikiikkatubaraiumu())) {
                tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getMosikkatup().getType());

                if (!uiBean.getHrktuukasyu().eq(tuukasyu)) {
                    String message1 = "";
                    String message2 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "払込";
                        message2 = SYUKEIYAKUHOSYOUINFO_BEI + "定期一括払保険料";
                    }
                    else {
                        message1 = "払込";
                        message2 = "定期一括払保険料";
                    }

                    throw new BizLogicException(MessageId.EHA1062, message1, message2);
                }

                if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                    tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getMosikkatup2().getType());
                    if (!uiBean.getHrktuukasyu2().eq(tuukasyu)) {
                        throw new BizLogicException(MessageId.EHA1062, SYUKEIYAKUHOSYOUINFO_GOU + "払込",
                            SYUKEIYAKUHOSYOUINFO_GOU + "定期一括払保険料");
                    }
                }
            }

            if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getMossyukykp().getType());
                if (!uiBean.getKyktuukasyu().eq(tuukasyu)) {
                    String message1 = "";
                    String message2 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "指定";
                        message2 = SYUKEIYAKUHOSYOUINFO_BEI + "保険料";
                    }
                    else {
                        message1 = "指定";
                        message2 = "保険料";
                    }
                    throw new BizLogicException(MessageId.EHA1062, message1, message2);
                }
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getZennouumu())) {
                if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                    tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getMoszennoupsyokaiari().getType());

                    if (!uiBean.getHrktuukasyu().eq(tuukasyu)) {
                        String message1 = "";
                        String message2 = "";
                        if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                            message1 = SYUKEIYAKUHOSYOUINFO_BEI + "払込";
                            message2 = SYUKEIYAKUHOSYOUINFO_BEI + "前納保険料";
                        }
                        else {
                            message1 = "払込";
                            message2 = "前納保険料";
                        }

                        throw new BizLogicException(MessageId.EHA1062, message1, message2);
                    }
                }

                if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                    tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getMoszennoupsyokaiari().getType());

                    if (!uiBean.getKyktuukasyu().eq(tuukasyu)) {
                        String message1 = "";
                        String message2 = "";
                        if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                            message1 = SYUKEIYAKUHOSYOUINFO_BEI + "指定";
                            message2 = SYUKEIYAKUHOSYOUINFO_BEI + "前納保険料";
                        }
                        else {
                            message1 = "指定";
                            message2 = "前納保険料";
                        }

                        throw new BizLogicException(MessageId.EHA1062, message1, message2);
                    }
                }

                if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                    tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(uiBean.getMoszennoupsyokaiari2().getType());
                    if (!uiBean.getHrktuukasyu2().eq(tuukasyu)) {
                        throw new BizLogicException(MessageId.EHA1062, SYUKEIYAKUHOSYOUINFO_GOU + "払込",
                            SYUKEIYAKUHOSYOUINFO_GOU + "前納保険料");
                    }
                }
            }
        }

        if (!uiBean.getSyukihons().isZeroOrOptional()) {
            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {

                if (MAX_KYOYOUKINGAKUYEN.compareTo(uiBean.getSyukihons()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "保険金額／給付金額がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "保険金額／給付金額がシステムで取扱可能な金額を超えています。";
                    }
                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.USD.eq(uiBean.getKyktuukasyu())) {
                if (MAX_KYOYOUKINGAKUDOLLAR.compareTo(uiBean.getSyukihons()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "保険金額／給付金額がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "保険金額／給付金額がシステムで取扱可能な金額を超えています。";
                    }

                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.AUD.eq(uiBean.getKyktuukasyu())) {
                if (MAX_KYOYOUKINGAKUAUDOLLAR.compareTo(uiBean.getSyukihons()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "保険金額／給付金額がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "保険金額／給付金額がシステムで取扱可能な金額を超えています。";
                    }

                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
        }

        if (!uiBean.getHrktuukasyukykp().isZeroOrOptional()) {
            if (C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu())) {

                if (MAX_KYOYOUKINGAKUYEN.compareTo(uiBean.getHrktuukasyukykp()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "払込金額がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "払込金額がシステムで取扱可能な金額を超えています。";
                    }
                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.USD.eq(uiBean.getHrktuukasyu())) {
                if (MAX_KYOYOUKINGAKUDOLLAR.compareTo(uiBean.getHrktuukasyukykp()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "払込金額がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "払込金額がシステムで取扱可能な金額を超えています。";
                    }

                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.AUD.eq(uiBean.getHrktuukasyu())) {
                if (MAX_KYOYOUKINGAKUAUDOLLAR.compareTo(uiBean.getHrktuukasyukykp()) <= 0) {
                    String message1 = "";
                    message1 = "払込金額がシステムで取扱可能な金額を超えています。";
                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
        }

        if (!uiBean.getHrktuukasyukykp2().isZeroOrOptional()) {
            if (C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu2())) {
                if (MAX_KYOYOUKINGAKUYEN.compareTo(uiBean.getHrktuukasyukykp2()) <= 0) {

                    throw new BizLogicException(MessageId.EBV0046, SYUKEIYAKUHOSYOUINFO_GOU +
                        "払込金額がシステムで取扱可能な金額を超えています。");
                }
            }
            else {
                if (MAX_KYOYOUKINGAKUDOLLAR.compareTo(uiBean.getHrktuukasyukykp2()) <= 0) {

                    throw new BizLogicException(MessageId.EBV0046, SYUKEIYAKUHOSYOUINFO_GOU +
                        "払込金額がシステムで取扱可能な金額を超えています。");
                }
            }
        }

        if (!uiBean.getMosikkatup().isZeroOrOptional()) {
            if (C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu())) {

                if (MAX_KYOYOUKINGAKUYEN.compareTo(uiBean.getMosikkatup()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "定期一括払保険料がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "定期一括払保険料がシステムで取扱可能な金額を超えています。";
                    }
                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.USD.eq(uiBean.getHrktuukasyu())) {
                if (MAX_KYOYOUKINGAKUDOLLAR.compareTo(uiBean.getMosikkatup()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "定期一括払保険料がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "定期一括払保険料がシステムで取扱可能な金額を超えています。";
                    }

                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.AUD.eq(uiBean.getHrktuukasyu())) {
                if (MAX_KYOYOUKINGAKUAUDOLLAR.compareTo(uiBean.getMosikkatup()) <= 0) {
                    String message1 = "";
                    message1 = "定期一括払保険料がシステムで取扱可能な金額を超えています。";
                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
        }

        if (!uiBean.getMosikkatup2().isZeroOrOptional()) {
            if (C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu2())) {
                if (MAX_KYOYOUKINGAKUYEN.compareTo(uiBean.getMosikkatup2()) <= 0) {

                    throw new BizLogicException(MessageId.EBV0046, SYUKEIYAKUHOSYOUINFO_GOU +
                        "定期一括払保険料がシステムで取扱可能な金額を超えています。");
                }
            }
            else {
                if (MAX_KYOYOUKINGAKUDOLLAR.compareTo(uiBean.getMosikkatup2()) <= 0) {

                    throw new BizLogicException(MessageId.EBV0046, SYUKEIYAKUHOSYOUINFO_GOU +
                        "定期一括払保険料がシステムで取扱可能な金額を超えています。");
                }
            }
        }

        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
            if (C_Tuukasyu.JPY.eq(uiBean.getKyktuukasyu())) {
                if (MAX_KYOYOUKINGAKUYEN.compareTo(uiBean.getMossyukykp()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "保険料がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "保険料がシステムで取扱可能な金額を超えています。";
                    }

                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.USD.eq(uiBean.getKyktuukasyu())) {
                if (MAX_KYOYOUKINGAKUDOLLAR.compareTo(uiBean.getMossyukykp()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "保険料がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "保険料がシステムで取扱可能な金額を超えています。";
                    }

                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.AUD.eq(uiBean.getKyktuukasyu())) {
                if (MAX_KYOYOUKINGAKUAUDOLLAR.compareTo(uiBean.getMossyukykp()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "保険料がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "保険料がシステムで取扱可能な金額を超えています。";
                    }

                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
        }

        if (!uiBean.getMoszennoupsyokaiari().isZeroOrOptional()) {
            C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;
            if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                tuukasyu = uiBean.getKyktuukasyu();
            }
            else {
                tuukasyu = uiBean.getHrktuukasyu();
            }

            if (C_Tuukasyu.JPY.eq(tuukasyu)) {

                if (MAX_KYOYOUKINGAKUYEN.compareTo(uiBean.getMoszennoupsyokaiari()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "前納保険料がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "前納保険料がシステムで取扱可能な金額を超えています。";
                    }
                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.USD.eq(tuukasyu)) {
                if (MAX_KYOYOUKINGAKUDOLLAR.compareTo(uiBean.getMoszennoupsyokaiari()) <= 0) {
                    String message1 = "";
                    if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                        message1 = SYUKEIYAKUHOSYOUINFO_BEI + "前納保険料がシステムで取扱可能な金額を超えています。";
                    }
                    else {
                        message1 = "前納保険料がシステムで取扱可能な金額を超えています。";
                    }

                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
            else if (C_Tuukasyu.AUD.eq(tuukasyu)) {
                if (MAX_KYOYOUKINGAKUAUDOLLAR.compareTo(uiBean.getMoszennoupsyokaiari()) <= 0) {
                    String message1 = "";
                    message1 = "前納保険料がシステムで取扱可能な金額を超えています。";
                    throw new BizLogicException(MessageId.EBV0046, message1);
                }
            }
        }

        if (!uiBean.getMoszennoupsyokaiari2().isZeroOrOptional()) {
            if (C_Tuukasyu.JPY.eq(uiBean.getHrktuukasyu2())) {
                if (MAX_KYOYOUKINGAKUYEN.compareTo(uiBean.getMoszennoupsyokaiari2()) <= 0) {

                    throw new BizLogicException(MessageId.EBV0046, SYUKEIYAKUHOSYOUINFO_GOU +
                        "前納保険料がシステムで取扱可能な金額を超えています。");
                }
            }
            else {
                if (MAX_KYOYOUKINGAKUDOLLAR.compareTo(uiBean.getMoszennoupsyokaiari2()) <= 0) {

                    throw new BizLogicException(MessageId.EBV0046, SYUKEIYAKUHOSYOUINFO_GOU +
                        "前納保険料がシステムで取扱可能な金額を超えています。");
                }
            }
        }

        if (C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn()) &&
            C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getShkstkzinfkzinfoinputhrykbn())) {

            checkShkstkzinfkzinfo();
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getJyudkaigomehrtktekiumu())) {
            if (C_Tkhukaumu.BLNK.eq(uiBean.getJyudkaigomehrtkhkkbn())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_SONOTATOKUYAKUINFO2_JYUDKAIGOMEHRTKHKKBN.getErrorResourceKey()));
            }
        }

        if (C_Nstkumu.ST_ARI.eq(syouhnZokusei.getNstkumu())) {
            if (C_Tkhukaumu.BLNK.eq(uiBean.getNstkhkkbn())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_SONOTATOKUYAKUINFO2_NSTKHKKBN.getErrorResourceKey()));
            }
            else if (C_Tkhukaumu.NONE.eq(uiBean.getNstkhkkbn())) {
                if (uiBean.getNstksbnkkn() != null &&
                    uiBean.getNstksbnkkn() != 0) {
                    throw new BizLogicException(MessageId.EBA0108,
                        MessageUtil.getMessage(DDID_SONOTATOKUYAKUINFO2_NSTKHKKBN.getErrorResourceKey()));
                }
            }
            else if (C_Tkhukaumu.HUKA.eq(uiBean.getNstkhkkbn())) {
                if (uiBean.getNstksbnkkn() == null ||
                    uiBean.getNstksbnkkn() == 0) {
                    throw new BizLogicException(MessageId.EBC0045,
                        MessageUtil.getMessage(DDID_SONOTATOKUYAKUINFO2_NSTKHKKBN.getErrorResourceKey()));
                }
            }
        }

        if (C_UmuKbn.NONE.eq(pGetSyouhnZokuseiCtrlOutBean.getKzktourokuserviceumu())) {
            if (!C_KzktourokuserviceTourokuKbn.BLNK.eq(uiBean.getKzktourokuservicetourokukbn())) {

                throw new BizLogicException(MessageId.EHC0197, skHokenSyuruiNo.getHknsyuruinm(),
                    MessageUtil.getMessage(
                        DDID_KZKOUROKUSERVICEYOUROKUINFO_KZKTOUROKUSERVICETOUROKUKBN.getErrorResourceKey()));
            }
        }
        else {
            BizDate kzktourokuServiceKaisiYmd = YuyuSinkeiyakuConfig.getInstance().getKzktourokuServiceKaisiYmd();
            if (BizDateUtil.compareYmd(sysDate,kzktourokuServiceKaisiYmd) == BizDateUtil.COMPARE_LESSER) {
                if (!C_KzktourokuserviceTourokuKbn.BLNK.eq(uiBean.getKzktourokuservicetourokukbn())) {

                    String newKzktourokuServiceKaisiYmd = new BizDateFormat(
                        "yyyy年MM月dd日", FillStyle.None).format(kzktourokuServiceKaisiYmd);

                    throw new BizLogicException(MessageId.EBA0108,
                        new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO_KZKTOUROKUSERVICETOUROKUKBN },
                        "処理日が"
                            + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, newKzktourokuServiceKaisiYmd)
                            + "より前の場合、"
                            + MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO_KZKTOUROKUSERVICETOUROKUKBN
                                .getErrorResourceKey()));
                }
            }
            else {
                if (BizDateUtil.compareYmd(uiBean.getMosymd(), kzktourokuServiceKaisiYmd) == BizDateUtil.COMPARE_LESSER) {
                    if (!C_KzktourokuserviceTourokuKbn.BLNK.eq(uiBean.getKzktourokuservicetourokukbn())) {

                        throw new BizLogicException(MessageId.EBA0108,
                            new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO_KZKTOUROKUSERVICETOUROKUKBN },
                            MessageUtil.getMessage(
                                DDID_KZKOUROKUSERVICEYOUROKUINFO_KZKTOUROKUSERVICETOUROKUKBN.getErrorResourceKey()));
                    }
                }
                else {
                    if (C_KzktourokuserviceTourokuKbn.BLNK.eq(uiBean.getKzktourokuservicetourokukbn())) {

                        throw new BizLogicException(MessageId.EBC0045,
                            new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO_KZKTOUROKUSERVICETOUROKUKBN },
                            MessageUtil.getMessage(
                                DDID_KZKOUROKUSERVICEYOUROKUINFO_KZKTOUROKUSERVICETOUROKUKBN.getErrorResourceKey()));
                    }
                }
            }
        }

        if (C_KzktourokuserviceTourokuKbn.BLNK.eq(uiBean.getKzktourokuservicetourokukbn()) ||
            C_KzktourokuserviceTourokuKbn.NONE.eq(uiBean.getKzktourokuservicetourokukbn())) {
            if (!BizUtil.isBlank(uiBean.getTrkkzknmkn1()) ||
                !BizUtil.isBlank(uiBean.getTrkkzknmkj1()) ||
                !C_KjkhukaKbn.BLNK.eq(uiBean.getTrkkzknmkjkhukakbn1()) ||
                uiBean.getTrkkzkseiymd1() != null ||
                !C_Seibetu.BLNK.eq(uiBean.getTrkkzksei1()) ||
                !C_Tdk.BLNK.eq(uiBean.getTrkkzktdk1()) ||
                !C_TsindousiteiKbn.BLNK.eq(uiBean.getTrkkzktsindousiteikbn1()) ||
                !BizUtil.isBlank(uiBean.getTrkkzkyno1()) ||
                !BizUtil.isBlank(uiBean.getTrkkzkadr1kj1()) ||
                !BizUtil.isBlank(uiBean.getTrkkzkadr2kj1()) ||
                !BizUtil.isBlank(uiBean.getTrkkzkadr3kj1()) ||
                !BizUtil.isBlank(uiBean.getTrkkzktelno1()) ||
                !BizUtil.isBlank(uiBean.getTrkkzknmkn2()) ||
                !BizUtil.isBlank(uiBean.getTrkkzknmkj2()) ||
                !C_KjkhukaKbn.BLNK.eq(uiBean.getTrkkzknmkjkhukakbn2()) ||
                uiBean.getTrkkzkseiymd2() != null ||
                !C_Seibetu.BLNK.eq(uiBean.getTrkkzksei2()) ||
                !C_Tdk.BLNK.eq(uiBean.getTrkkzktdk2()) ||
                !C_TsindousiteiKbn.BLNK.eq(uiBean.getTrkkzktsindousiteikbn2()) ||
                !BizUtil.isBlank(uiBean.getTrkkzkyno2()) ||
                !BizUtil.isBlank(uiBean.getTrkkzkadr1kj2()) ||
                !BizUtil.isBlank(uiBean.getTrkkzkadr2kj2()) ||
                !BizUtil.isBlank(uiBean.getTrkkzkadr3kj2()) ||
                !BizUtil.isBlank(uiBean.getTrkkzktelno2())) {

                throw new BizLogicException(MessageId.EHA1093, "ご家族登録サービス情報");
            }
        }
        else {
            if (BizUtil.isBlank(uiBean.getTrkkzknmkn1())) {

                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKNMKN1 },
                    MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKNMKN1.getErrorResourceKey()));
            }
            if (C_KjkhukaKbn.BLNK.eq(uiBean.getTrkkzknmkjkhukakbn1()) &&
                BizUtil.isBlank(uiBean.getTrkkzknmkj1())) {

                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKNMKJ1 },
                    MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKNMKJ1.getErrorResourceKey()));
            }
            if (uiBean.getTrkkzkseiymd1() == null) {

                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKSEIYMD1 },
                    MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKSEIYMD1.getErrorResourceKey()));
            }
            if (BizDateUtil.compareYmd(uiBean.getTrkkzkseiymd1(), sysDate) == BizDateUtil.COMPARE_GREATER) {

                throw new BizLogicException(MessageId.EBF0124,
                    new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKSEIYMD1 },
                    MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKSEIYMD1.getErrorResourceKey()));
            }
            if (BizDateUtil.compareYmd(uiBean.getTrkkzkseiymd1(), uiBean.getMosymd()) == BizDateUtil.COMPARE_GREATER) {

                throw new BizLogicException(MessageId.EHC1002,
                    new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKSEIYMD1 },
                    MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKSEIYMD1.getErrorResourceKey()));
            }
            if (C_Seibetu.BLNK.eq(uiBean.getTrkkzksei1())) {

                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKSEI1 },
                    MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKSEI1.getErrorResourceKey()));
            }
            if (C_Tdk.BLNK.eq(uiBean.getTrkkzktdk1())) {

                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKTDK1 },
                    MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKTDK1.getErrorResourceKey()));
            }
            if (C_TsindousiteiKbn.BLNK.eq(uiBean.getTrkkzktsindousiteikbn1())) {
                if (BizUtil.isBlank(uiBean.getTrkkzkyno1()) || BizUtil.isBlank(uiBean.getTrkkzkadr1kj1())) {

                    throw new BizLogicException(MessageId.EHA1094, "登録家族１人目住所情報");
                }
                int trkkzkadrKjCnt = uiBean.getTrkkzkadr1kj1().length() + uiBean.getTrkkzkadr2kj1().length() +
                    uiBean.getTrkkzkadr3kj1().length();
                if (trkkzkadrKjCnt > jyuusyoNrkJyougenCnt) {

                    throw new BizLogicException(MessageId.EBA1003, "登録家族１人目住所（漢字）",
                        String.valueOf(trkkzkadrKjCnt), String.valueOf(jyuusyoNrkJyougenCnt));
                }
            }
            else {
                if (!BizUtil.isBlank(uiBean.getTrkkzkyno1()) ||
                    !BizUtil.isBlank(uiBean.getTrkkzkadr1kj1()) ||
                    !BizUtil.isBlank(uiBean.getTrkkzkadr2kj1()) ||
                    !BizUtil.isBlank(uiBean.getTrkkzkadr3kj1())) {

                    throw new BizLogicException(MessageId.EHA1093, "登録家族１人目住所情報");
                }
            }
            if (BizUtil.isBlank(uiBean.getTrkkzktelno1())) {

                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKTELNO1 },
                    MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKTELNO1.getErrorResourceKey()));
            }
            if (BizUtil.isBlank(uiBean.getTrkkzknmkn2())) {
                if (!BizUtil.isBlank(uiBean.getTrkkzknmkj2()) ||
                    !C_KjkhukaKbn.BLNK.eq(uiBean.getTrkkzknmkjkhukakbn2()) ||
                    uiBean.getTrkkzkseiymd2() != null ||
                    !C_Seibetu.BLNK.eq(uiBean.getTrkkzksei2()) ||
                    !C_Tdk.BLNK.eq(uiBean.getTrkkzktdk2()) ||
                    !C_TsindousiteiKbn.BLNK.eq(uiBean.getTrkkzktsindousiteikbn2()) ||
                    !BizUtil.isBlank(uiBean.getTrkkzkyno2()) ||
                    !BizUtil.isBlank(uiBean.getTrkkzkadr1kj2()) ||
                    !BizUtil.isBlank(uiBean.getTrkkzkadr2kj2()) ||
                    !BizUtil.isBlank(uiBean.getTrkkzkadr3kj2()) ||
                    !BizUtil.isBlank(uiBean.getTrkkzktelno2())) {

                    throw new BizLogicException(MessageId.EHA1093, "登録家族２人目情報");
                }
            }
            else {
                if (C_KjkhukaKbn.BLNK.eq(uiBean.getTrkkzknmkjkhukakbn2()) &&
                    BizUtil.isBlank(uiBean.getTrkkzknmkj2())) {

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKNMKJ2 },
                        MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKNMKJ2.getErrorResourceKey()));
                }
                if (uiBean.getTrkkzkseiymd2() == null) {

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKSEIYMD2 },
                        MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKSEIYMD2.getErrorResourceKey()));
                }
                if (BizDateUtil.compareYmd(uiBean.getTrkkzkseiymd2(), sysDate) == BizDateUtil.COMPARE_GREATER) {

                    throw new BizLogicException(MessageId.EBF0124,
                        new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKSEIYMD2 },
                        MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKSEIYMD2.getErrorResourceKey()));
                }
                if (BizDateUtil.compareYmd(uiBean.getTrkkzkseiymd2(), uiBean.getMosymd()) == BizDateUtil.COMPARE_GREATER) {

                    throw new BizLogicException(MessageId.EHC1002,
                        new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKSEIYMD2 },
                        MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKSEIYMD2.getErrorResourceKey()));
                }
                if (C_Seibetu.BLNK.eq(uiBean.getTrkkzksei2())) {

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKSEI2 },
                        MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKSEI2.getErrorResourceKey()));
                }
                if (C_Tdk.BLNK.eq(uiBean.getTrkkzktdk2())) {

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKTDK2 },
                        MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKTDK2.getErrorResourceKey()));
                }
                if (C_TsindousiteiKbn.BLNK.eq(uiBean.getTrkkzktsindousiteikbn2())) {
                    if (BizUtil.isBlank(uiBean.getTrkkzkyno2()) || BizUtil.isBlank(uiBean.getTrkkzkadr1kj2())) {

                        throw new BizLogicException(MessageId.EHA1094, "登録家族２人目住所情報");
                    }
                    int trkkzkadrKjCnt = uiBean.getTrkkzkadr1kj2().length() + uiBean.getTrkkzkadr2kj2().length() +
                        uiBean.getTrkkzkadr3kj2().length();
                    if (trkkzkadrKjCnt > jyuusyoNrkJyougenCnt) {

                        throw new BizLogicException(MessageId.EBA1003, "登録家族２人目住所（漢字）",
                            String.valueOf(trkkzkadrKjCnt), String.valueOf(jyuusyoNrkJyougenCnt));
                    }
                }
                else {
                    if (!BizUtil.isBlank(uiBean.getTrkkzkyno2()) ||
                        !BizUtil.isBlank(uiBean.getTrkkzkadr1kj2()) ||
                        !BizUtil.isBlank(uiBean.getTrkkzkadr2kj2()) ||
                        !BizUtil.isBlank(uiBean.getTrkkzkadr3kj2())) {

                        throw new BizLogicException(MessageId.EHA1093, "登録家族２人目住所情報");
                    }
                }
                if (BizUtil.isBlank(uiBean.getTrkkzktelno2())) {

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKTELNO2 },
                        MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKTELNO2.getErrorResourceKey()));
                }
            }
        }

        if (E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) {
            if (C_UmuKbn.NONE.eq(pGetSyouhnZokuseiCtrlOutBean.getKykdrtkykumu())) {
                if (!C_Tkhukaumu.BLNK.eq(uiBean.getKykdrtkykhukakbn())) {

                    throw new BizLogicException(MessageId.EHC0197, skHokenSyuruiNo.getHknsyuruinm(),
                        MessageUtil.getMessage(DDID_KYKDAIRISEIKYUNININFO_KYKDRTKYKHUKAKBN.getErrorResourceKey()));
                }
            }
            else {
                BizDate kykdaririTkykHukaYmd = YuyuSinkeiyakuConfig.getInstance().getKykdaririTkykHukaYmd();
                if (BizDateUtil.compareYmd(sysDate,kykdaririTkykHukaYmd) == BizDateUtil.COMPARE_LESSER) {
                    if (!C_Tkhukaumu.BLNK.eq(uiBean.getKykdrtkykhukakbn())) {

                        String newKykdaririTkykHukaYmd = new BizDateFormat(
                            "yyyy年MM月dd日", FillStyle.None).format(kykdaririTkykHukaYmd);

                        throw new BizLogicException(MessageId.EBA0108,
                            new Item[] { DDID_KYKDAIRISEIKYUNININFO_KYKDRTKYKHUKAKBN },
                            "処理日が"
                                + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, newKykdaririTkykHukaYmd)
                                + "より前の場合、"
                                + MessageUtil.getMessage(DDID_KYKDAIRISEIKYUNININFO_KYKDRTKYKHUKAKBN
                                    .getErrorResourceKey()));
                    }
                }
                else {
                    if (BizDateUtil.compareYmd(uiBean.getMosymd(), kykdaririTkykHukaYmd) == BizDateUtil.COMPARE_LESSER) {
                        if (!C_Tkhukaumu.BLNK.eq(uiBean.getKykdrtkykhukakbn())) {

                            throw new BizLogicException(MessageId.EBA0108,
                                new Item[] { DDID_KYKDAIRISEIKYUNININFO_KYKDRTKYKHUKAKBN },
                                MessageUtil.getMessage(DDID_KYKDAIRISEIKYUNININFO_KYKDRTKYKHUKAKBN
                                    .getErrorResourceKey()));
                        }
                    }
                    else {
                        if (C_Tkhukaumu.BLNK.eq(uiBean.getKykdrtkykhukakbn())) {

                            throw new BizLogicException(MessageId.EBC0045,
                                new Item[] { DDID_KYKDAIRISEIKYUNININFO_KYKDRTKYKHUKAKBN },
                                MessageUtil.getMessage(DDID_KYKDAIRISEIKYUNININFO_KYKDRTKYKHUKAKBN
                                    .getErrorResourceKey()));
                        }
                    }
                }
            }
            if (C_Tkhukaumu.BLNK.eq(uiBean.getKykdrtkykhukakbn()) ||
                C_Tkhukaumu.NONE.eq(uiBean.getKykdrtkykhukakbn())) {
                if (!C_UktKbn.BLNK.eq(uiBean.getKykdrkbn())) {

                    throw new BizLogicException(MessageId.EBA0108,
                        new Item[] { DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN },
                        MessageUtil.getMessage(DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN.getErrorResourceKey()));
                }
            }
            else {
                if (C_UktKbn.BLNK.eq(uiBean.getKykdrkbn())) {

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN },
                        MessageUtil.getMessage(DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN.getErrorResourceKey()));
                }
                else if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getKykdrkbn())) {
                    if (C_UmuKbn.NONE.eq(pGetSyouhnZokuseiCtrlOutBean.getKzktourokuserviceumu())) {

                        throw new BizLogicException(MessageId.EHA1053,
                            new Item[] { DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN },
                            "ご家族登録サービスのない",
                            uiBean.getKykdrkbn().getContent(C_UktKbn.PATTERN_SKKYKDR));
                    }
                    if (BizUtil.isBlank(uiBean.getTrkkzknmkn1())) {

                        throw new BizLogicException(MessageId.EHA1095,
                            new Item[] { DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN },
                            MessageUtil.getMessage(DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN.getErrorResourceKey()),
                            uiBean.getKykdrkbn().getContent(C_UktKbn.PATTERN_SKKYKDR));
                    }
                }
                else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getKykdrkbn())) {
                    if (C_UmuKbn.NONE.eq(pGetSyouhnZokuseiCtrlOutBean.getKzktourokuserviceumu())) {

                        throw new BizLogicException(MessageId.EHA1053,
                            new Item[] { DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN },
                            "ご家族登録サービスのない",
                            uiBean.getKykdrkbn().getContent(C_UktKbn.PATTERN_SKKYKDR));
                    }
                    if (BizUtil.isBlank(uiBean.getTrkkzknmkn2())) {

                        throw new BizLogicException(MessageId.EHA1095,
                            new Item[] { DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN },
                            MessageUtil.getMessage(DDID_KYKDAIRISEIKYUNININFO_KYKDRKBN.getErrorResourceKey()),
                            uiBean.getKykdrkbn().getContent(C_UktKbn.PATTERN_SKKYKDR));
                    }
                }
            }
        }

        if (C_UmuKbn.NONE.eq(pGetSyouhnZokuseiCtrlOutBean.getStdrsktkumu())) {
            if (!C_Tkhukaumu.BLNK.eq(uiBean.getStdrsktkyhkkbn())) {
                throw new BizLogicException(MessageId.EHC0197,
                    skHokenSyuruiNo.getHknsyuruinm(),
                    MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRSKTKYHKKBN.getErrorResourceKey()));
            }
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getStdrsktkumu())) {

            if (C_Tkhukaumu.BLNK.eq(uiBean.getStdrsktkyhkkbn())) {

                throw new BizLogicException(
                    MessageId.EBC0045, new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRSKTKYHKKBN },
                    MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRSKTKYHKKBN.getErrorResourceKey()));
            }
        }

        if (!C_Tkhukaumu.HUKA.eq(uiBean.getStdrsktkyhkkbn())) {
            if (!C_UktKbn.BLNK.eq(uiBean.getStdruktkbn()) ||
                !BizUtil.isBlank(uiBean.getSiteidruktnmkn()) ||
                !BizUtil.isBlank(uiBean.getSiteidruktnmkj()) ||
                !C_KjkhukaKbn.BLNK.eq(uiBean.getStdrsknmkjhukakbn()) ||
                uiBean.getStdrskseiymd() != null ||
                !C_Tdk.BLNK.eq(uiBean.getStdrsktdk())) {
                throw new BizLogicException(MessageId.EHA0355);
            }
        }
        else if (C_Tkhukaumu.HUKA.eq(uiBean.getStdrsktkyhkkbn())) {
            if (C_UktKbn.BLNK.eq(uiBean.getStdruktkbn())) {
                throw new BizLogicException(MessageId.EBC0045,
                    new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN },
                    MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN.getErrorResourceKey()));
            }

            BizDate hhkndairiTkykHukaYmd = YuyuSinkeiyakuConfig.getInstance().getHhkndairiTkykHukaYmd();

            if (BizDateUtil.compareYmd(sysDate, hhkndairiTkykHukaYmd) == BizDateUtil.COMPARE_LESSER) {

                String newHhkndairiTkykHukaYmd = new BizDateFormat(
                    "yyyy年MM月dd日", FillStyle.None).format(hhkndairiTkykHukaYmd);

                if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getStdruktkbn()) ||
                    C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getStdruktkbn()) ||
                    C_UktKbn.KYK.eq(uiBean.getStdruktkbn())) {

                    throw new BizLogicException(MessageId.EHA1095,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN },
                        "処理日が"
                            + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, newHhkndairiTkykHukaYmd)
                            + "より前の場合、"
                            + MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN.getErrorResourceKey()),
                            uiBean.getStdruktkbn().getContent(C_UktKbn.PATTERN_SKSTDR));
                }
                if (uiBean.getStdrskseiymd() != null) {

                    throw new BizLogicException(MessageId.EBA0108,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD },
                        "処理日が"
                            + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, newHhkndairiTkykHukaYmd)
                            + "より前の場合、"
                            + MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD.getErrorResourceKey()));
                }
            }
            else {
                if (BizDateUtil.compareYmd(uiBean.getMosymd(),hhkndairiTkykHukaYmd) == BizDateUtil.COMPARE_LESSER) {
                    if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getStdruktkbn()) ||
                        C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getStdruktkbn()) ||
                        C_UktKbn.KYK.eq(uiBean.getStdruktkbn())) {

                        throw new BizLogicException(MessageId.EHA1095,
                            new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN },
                            MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN.getErrorResourceKey()),
                            uiBean.getStdruktkbn().getContent(C_UktKbn.PATTERN_SKSTDR));
                    }
                    if (uiBean.getStdrskseiymd() != null) {

                        throw new BizLogicException(MessageId.EBA0108,
                            new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD },
                            MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD.getErrorResourceKey()));
                    }
                }
            }
            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getStdruktkbn())) {
                if (C_UmuKbn.NONE.eq(pGetSyouhnZokuseiCtrlOutBean.getKzktourokuserviceumu())) {

                    throw new BizLogicException(MessageId.EHA1053,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN },
                        "ご家族登録サービスのない",
                        uiBean.getStdruktkbn().getContent(C_UktKbn.PATTERN_SKSTDR));
                }
                if (BizUtil.isBlank(uiBean.getTrkkzknmkn1())) {

                    throw new BizLogicException(MessageId.EHA1095,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN },
                        MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN.getErrorResourceKey()),
                        uiBean.getStdruktkbn().getContent(C_UktKbn.PATTERN_SKSTDR));
                }
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getStdruktkbn())) {
                if (C_UmuKbn.NONE.eq(pGetSyouhnZokuseiCtrlOutBean.getKzktourokuserviceumu())) {

                    throw new BizLogicException(MessageId.EHA1053,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN },
                        "ご家族登録サービスのない",
                        uiBean.getStdruktkbn().getContent(C_UktKbn.PATTERN_SKSTDR));
                }
                if (BizUtil.isBlank(uiBean.getTrkkzknmkn2())) {

                    throw new BizLogicException(MessageId.EHA1095,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN },
                        MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN.getErrorResourceKey()),
                        uiBean.getStdruktkbn().getContent(C_UktKbn.PATTERN_SKSTDR));
                }
            }
            else if (C_UktKbn.KYK.eq(uiBean.getStdruktkbn())) {
                if (C_KykKbn.KEIHI_DOUITU.eq(uiBean.getKykkbn())) {

                    throw new BizLogicException(MessageId.EHA1096,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN },
                        uiBean.getKykkbn().getContent(),
                        uiBean.getStdruktkbn().getContent(C_UktKbn.PATTERN_SKSTDR));
                }
            }
            else if (C_UktKbn.SBUK.eq(uiBean.getStdruktkbn())) {
                if (C_UmuKbn.NONE.eq(pGetSyouhnZokuseiCtrlOutBean.getSbuktumu())) {
                    throw new BizLogicException(MessageId.EHA1053,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN },
                        "死亡保障のない",
                        C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSTDR, uiBean.getStdruktkbn().getValue()));
                }

                if (uiBean.getSbuktnin() > MAX_UKT_SIBOU) {
                    throw new BizLogicException(MessageId.EHA1028,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRUKTKBN });
                }
            }
            if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getStdruktkbn()) ||
                C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getStdruktkbn()) ||
                C_UktKbn.KYK.eq(uiBean.getStdruktkbn()) ||
                C_UktKbn.SBUK.eq(uiBean.getStdruktkbn())) {
                if (!BizUtil.isBlank(uiBean.getSiteidruktnmkn()) ||
                    !BizUtil.isBlank(uiBean.getSiteidruktnmkj()) ||
                    !C_KjkhukaKbn.BLNK.eq(uiBean.getStdrsknmkjhukakbn()) ||
                    uiBean.getStdrskseiymd() != null ||
                    !C_Tdk.BLNK.eq(uiBean.getStdrsktdk())) {

                    throw new BizLogicException(MessageId.EHA1093, "被保険者代理特約情報");
                }
            }
            else if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getStdruktkbn())) {
                if (BizUtil.isBlank(uiBean.getSiteidruktnmkn())){

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_SITEIDRUKTNMKN },
                        MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_SITEIDRUKTNMKN.getErrorResourceKey()));
                }
                if (C_KjkhukaKbn.BLNK.eq(uiBean.getStdrsknmkjhukakbn()) &&
                    BizUtil.isBlank(uiBean.getSiteidruktnmkj())) {

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_SITEIDRUKTNMKJ },
                        MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_SITEIDRUKTNMKJ.getErrorResourceKey()));
                }
                if (BizDateUtil.compareYmd(uiBean.getMosymd(),hhkndairiTkykHukaYmd) != BizDateUtil.COMPARE_LESSER) {
                    if (uiBean.getStdrskseiymd() == null) {

                        throw new BizLogicException(MessageId.EBC0045,
                            new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD },
                            MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD.getErrorResourceKey()));
                    }
                    if (BizDateUtil.compareYmd(uiBean.getStdrskseiymd(), sysDate) == BizDateUtil.COMPARE_GREATER) {

                        throw new BizLogicException(MessageId.EBF0124,
                            new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD },
                            MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD.getErrorResourceKey()));
                    }
                    if (BizDateUtil.compareYmd(uiBean.getStdrskseiymd(), uiBean.getMosymd()) == BizDateUtil.COMPARE_GREATER) {

                        throw new BizLogicException(MessageId.EHC1002,
                            new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD },
                            MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRSKSEIYMD.getErrorResourceKey()));
                    }
                }
                if (C_Tdk.BLNK.eq(uiBean.getStdrsktdk())) {

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_SITEIDAIRISEIKYUNININFO_STDRSKTDK },
                        MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_STDRSKTDK.getErrorResourceKey()));
                }
            }
        }

        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
            if (!uiBean.getKyktuukasyu().eq(uiBean.getHrktuukasyu())) {
                if (C_BlnktkumuKbn.ARI.eq(uiBean.getZenkizennouumu())) {
                    if (!C_YnkHrkmgkAnniTuutiKbn.BLNK.eq(uiBean.getYnkhrkmgkannituutikbn())) {
                        throw new BizLogicException(MessageId.EBA0108,
                            new Item[] { DDID_PTUUTIINFO_YNKHRKMGKANNITUUTIKBN },
                            MessageUtil.getMessage(DDID_PTUUTIINFO_YNKHRKMGKANNITUUTIKBN.getErrorResourceKey()));
                    }
                }
                else if (C_BlnktkumuKbn.NONE.eq(uiBean.getZenkizennouumu())) {
                    if (C_YnkHrkmgkAnniTuutiKbn.BLNK.eq(uiBean.getYnkhrkmgkannituutikbn())) {
                        throw new BizLogicException(MessageId.EBC0045,
                            new Item[] { DDID_PTUUTIINFO_YNKHRKMGKANNITUUTIKBN },
                            MessageUtil.getMessage(DDID_PTUUTIINFO_YNKHRKMGKANNITUUTIKBN.getErrorResourceKey()));
                    }
                }
            }
            else {
                if (!C_YnkHrkmgkAnniTuutiKbn.BLNK.eq(uiBean.getYnkhrkmgkannituutikbn())) {
                    throw new BizLogicException(MessageId.EBA0108,
                        new Item[] { DDID_PTUUTIINFO_YNKHRKMGKANNITUUTIKBN },
                        MessageUtil.getMessage(DDID_PTUUTIINFO_YNKHRKMGKANNITUUTIKBN.getErrorResourceKey()));
                }
            }
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getKouzahurikaebaraitekiumu()) &&
            C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) {

            checkKouhurikouzainfo();
        }

        List<String> jimusyoCdLst = Lists.newArrayList();
        jimusyoCdLst.add(uiBean.getDrtenjimcd1());
        jimusyoCdLst.add(uiBean.getDrtenjimcd2());
        List<String> bosyuuTrkNoLst = Lists.newArrayList();
        bosyuuTrkNoLst.add(uiBean.getBosyuunintourokuno1());
        bosyuuTrkNoLst.add(uiBean.getBosyuunintourokuno2());
        List<String> kinyuukikanCdLst = Lists.newArrayList();
        kinyuukikanCdLst.add(uiBean.getDairitenkinyuukikancd1());
        kinyuukikanCdLst.add(uiBean.getDairitenkinyuukikancd2());
        List<String> kinyuukikanSitenCdLst = Lists.newArrayList();
        kinyuukikanSitenCdLst.add(uiBean.getDairitenkinyuukikansitencd1());
        kinyuukikanSitenCdLst.add(uiBean.getDairitenkinyuukikansitencd2());
        List<String> kouinCdLst = Lists.newArrayList();
        kouinCdLst.add(uiBean.getDairitentoriatukaikouincd1());
        kouinCdLst.add(uiBean.getDairitentoriatukaikouincd2());
        List<String> kojinCdLst = Lists.newArrayList();
        kojinCdLst.add(uiBean.getInputbosyuucd1());
        kojinCdLst.add(uiBean.getInputbosyuucd2());
        List<String> gyskkjsakiSosikiCdLst = Lists.newArrayList();
        gyskkjsakiSosikiCdLst.add(uiBean.getGyousekikeijyousakisosikicd1());
        gyskkjsakiSosikiCdLst.add(uiBean.getGyousekikeijyousakisosikicd2());
        List<BizNumber> bunwariLst = Lists.newArrayList();
        bunwariLst.add(uiBean.getDairitenbuntanwariai1());
        bunwariLst.add(uiBean.getDairitenbuntanwariai2());

        if (BizUtil.isBlank(jimusyoCdLst.get(0)) && BizUtil.isBlank(kinyuukikanCdLst.get(0))) {
            throw new BizLogicException(MessageId.EHA0054);
        }

        uiBean.setDrtInfo2HyoujiFlg(false);

        for (int index = 0; index < MAX_DAIRITEN; index++) {
            if (!(BizUtil.isBlank(jimusyoCdLst.get(index)) &&
                BizUtil.isBlank(bosyuuTrkNoLst.get(index)) &&
                BizUtil.isBlank(kinyuukikanCdLst.get(index)) &&
                BizUtil.isBlank(kinyuukikanSitenCdLst.get(index)) &&
                BizUtil.isBlank(kouinCdLst.get(index)) &&
                BizUtil.isBlank(kojinCdLst.get(index)) && BizUtil.isBlank(gyskkjsakiSosikiCdLst.get(index)))) {
                if (index == 1) {
                    uiBean.setDrtInfo2HyoujiFlg(true);
                }
            }

            if (index == 1 && !uiBean.getDrtInfo2HyoujiFlg()) {
                bunwariLst.set(index, BizNumber.optional());
                break;
            }

            CheckTblMosDairiten checkTblMosDairiten = SWAKInjector.getInstance(CheckTblMosDairiten.class);

            C_ErrorKbn errorKbn = checkTblMosDairiten.checkDirInfoPattern(kinyuukikanCdLst.get(index),
                kinyuukikanSitenCdLst.get(index), kojinCdLst.get(index), kouinCdLst.get(index),
                jimusyoCdLst.get(index), bosyuuTrkNoLst.get(index), index + 1);

            if (C_ErrorKbn.OK.eq(errorKbn)) {
            }
            else {
                if (index == 0) {
                    throw new BizLogicException(MessageId.EHA1065, "Ａ代理店");
                }
                throw new BizLogicException(MessageId.EHA1065, "Ｂ代理店");
            }
        }

        editDairitenInfo(jimusyoCdLst, bosyuuTrkNoLst, kinyuukikanCdLst, kinyuukikanSitenCdLst,
            kouinCdLst, kojinCdLst, gyskkjsakiSosikiCdLst, bunwariLst);

        if (!BizUtil.isBlank(uiBean.getBosyuucd1()) &&
            !BizUtil.isBlank(uiBean.getBosyuucd2()) &&
            uiBean.getBosyuucd1().equals(uiBean.getBosyuucd2())) {
            throw new BizLogicException(MessageId.EHC0170, uiBean.getBosyuucd1());
        }

        String gyskkjsakiSosikiCd1 = gyskkjsakiSosikiCdLst.get(0);
        String gyskkjsakiSosikiCd2 = gyskkjsakiSosikiCdLst.get(1);

        if (!BizUtil.isBlank(gyskkjsakiSosikiCd1) &&
            !BizUtil.isBlank(gyskkjsakiSosikiCd2) &&
            gyskkjsakiSosikiCd1.equals(gyskkjsakiSosikiCd2)) {
            throw new BizLogicException(MessageId.EHA1048);
        }

        if (!BizUtil.isBlank(gyskkjsakiSosikiCd1)) {
            if ("2".equals(gyskkjsakiSosikiCd1.substring(3, 4)) &&
                ("936".equals(gyskkjsakiSosikiCd1.substring(4, 7)) ||
                    "939".equals(gyskkjsakiSosikiCd1.substring(4, 7)) ||
                    "981".equals(gyskkjsakiSosikiCd1.substring(4, 7)) ||
                    "982".equals(gyskkjsakiSosikiCd1.substring(4, 7)) ||
                    "983".equals(gyskkjsakiSosikiCd1.substring(4, 7)) ||
                    "984".equals(gyskkjsakiSosikiCd1.substring(4, 7)))) {
            }
            else {
                throw new BizLogicException(MessageId.EBA1035,
                    MessageUtil.getMessage(DDID_DAIRITENINFOA_GYSKKJSAKISOSIKICD1.getErrorResourceKey()));
            }

        }

        if (!BizUtil.isBlank(gyskkjsakiSosikiCd2)) {
            if ("2".equals(gyskkjsakiSosikiCd2.substring(3, 4)) &&
                ("936".equals(gyskkjsakiSosikiCd2.substring(4, 7)) ||
                    "939".equals(gyskkjsakiSosikiCd2.substring(4, 7)) ||
                    "981".equals(gyskkjsakiSosikiCd2.substring(4, 7)) ||
                    "982".equals(gyskkjsakiSosikiCd2.substring(4, 7)) ||
                    "983".equals(gyskkjsakiSosikiCd2.substring(4, 7)) ||
                    "984".equals(gyskkjsakiSosikiCd2.substring(4, 7)))) {
            }
            else {
                throw new BizLogicException(MessageId.EBA1035,
                    MessageUtil.getMessage(DDID_DAIRITENINFOB_GYSKKJSAKISOSIKICD2.getErrorResourceKey()));
            }
        }

        if (!BizUtil.isBlank(gyskkjsakiSosikiCd1)) {
            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(gyskkjsakiSosikiCd1, uiBean.getMosymd());
            if (!C_SosikiYuuksHantKbn.OK.eq(bzGetSosikiDataBean.getSosikiyuukshantkbn())) {
                throw new BizLogicException(MessageId.EBA1036,
                    MessageUtil.getMessage(DDID_DAIRITENINFOA_GYSKKJSAKISOSIKICD1.getErrorResourceKey()));
            }

            uiBean.setGyskkjsakisosikinmkj1(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        if (!BizUtil.isBlank(gyskkjsakiSosikiCd2)) {
            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(gyskkjsakiSosikiCd2, uiBean.getMosymd());
            if (!C_SosikiYuuksHantKbn.OK.eq(bzGetSosikiDataBean.getSosikiyuukshantkbn())) {
                throw new BizLogicException(MessageId.EBA1036,
                    MessageUtil.getMessage(DDID_DAIRITENINFOB_GYSKKJSAKISOSIKICD2.getErrorResourceKey()));
            }

            uiBean.setGyskkjsakisosikinmkj2(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        if ((E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) &&
            C_MosUketukeKbn.PAPERLESS.eq(uiBean.getMosuketukekbn()) &&
            C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro())) {

            HT_KouzaJyouhou kouzaJyouhou = uiBean.getSyoriCTL().getKouzaJyouhou();

            if(kouzaJyouhou == null){
                kouzaJyouhou = new HT_KouzaJyouhou();
            }

            boolean result = kouhurikouzainfoHanteiForCheck(kouzaJyouhou);

            if (C_KzhuritourokuhouKbn.QR.eq(uiBean.getKzhuritourokuhoukbn())) {
                if (C_KzhuritourokuhouKbn.QR.eq(uiBean.getInitKzhuritourokuhoukbn()) &&
                    C_UmuKbn.ARI.eq(uiBean.getSyoriCTL().getKznrkumu()) && result) {

                    throw new BizLogicException(MessageId.EHA1098,
                        new Item[] { DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN },
                        uiBean.getKzhuritourokuhoukbn().getContent());
                }
                if (C_KzhuritourokuhouKbn.PPLESS.eq(uiBean.getInitKzhuritourokuhoukbn())) {

                    throw new BizLogicException(MessageId.EHA1099,
                        new Item[] { DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN },
                        uiBean.getKzhuritourokuhoukbn().getContent());
                }
                if (!BizUtil.isBlank(uiBean.getOyadairitencd1())) {
                    if ((C_KzhuritourokuhouKbn.BLNK.eq(uiBean.getInitKzhuritourokuhoukbn()) ||
                        C_KzhuritourokuhouKbn.SYOMEN.eq(uiBean.getInitKzhuritourokuhoukbn())) &&
                        !uiBean.getOyadairitencd1().equals(YuyuBizConfig.getInstance().getSmbcOyadrtencd()) &&
                        !uiBean.getOyadairitencd1().equals(YuyuBizConfig.getInstance().getMizuhoOyadrtencd())) {

                        throw new BizLogicException(MessageId.EHA1099,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN },
                            uiBean.getKzhuritourokuhoukbn().getContent());
                    }
                }
            }
            else if (C_KzhuritourokuhouKbn.PPLESS.eq(uiBean.getKzhuritourokuhoukbn())) {
                if (C_KzhuritourokuhouKbn.PPLESS.eq(uiBean.getInitKzhuritourokuhoukbn()) &&
                    C_UmuKbn.ARI.eq(uiBean.getSyoriCTL().getKznrkumu()) && result) {

                    throw new BizLogicException(MessageId.EHA1098,
                        new Item[] { DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN },
                        uiBean.getKzhuritourokuhoukbn().getContent());
                }
                if (C_KzhuritourokuhouKbn.SYOMEN.eq(uiBean.getInitKzhuritourokuhoukbn()) ||
                    C_KzhuritourokuhouKbn.QR.eq(uiBean.getInitKzhuritourokuhoukbn())) {

                    throw new BizLogicException(MessageId.EHA1099,
                        new Item[] { DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN },
                        uiBean.getKzhuritourokuhoukbn().getContent());
                }
            }
        }

        setAisyoumei();

        if (!BizUtil.isBlank(uiBean.getOyadairitencd1())) {
            GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);
            getSkChannelInfo.exec(null, uiBean.getOyadairitencd1());

            if (!C_SkeijimuKbn.SHOP.eq(getSkChannelInfo.getSkeiJimuKbn()) &&
                !C_FstphrkkeiroKbn.HURIKOMI.eq(uiBean.getFstphrkkeirokbn())) {

                throw new BizLogicException(MessageId.EBC0046,
                    new Item[] { DDID_SYUKEIYAKUHOSYOUINFO_FSTPHRKKEIROKBN },
                    MessageUtil.getMessage(DDID_SYUKEIYAKUHOSYOUINFO_FSTPHRKKEIROKBN.getErrorResourceKey()));
            }

            GetHknsyuruinm getHknsyuruinm = SWAKInjector.getInstance(GetHknsyuruinm.class);
            HknsyuruinmBean hknsyuruinmBean = getHknsyuruinm.setAisyoumeikbn(
                uiBean.getHknsyuruinomosinput(),
                uiBean.getHknsyuruinosd(),
                getSkChannelInfo.getAisyoumeiChannelKbn(),
                uiBean.getSyouhncd()
                );

            if (BizUtil.isBlank(hknsyuruinmBean.getAisyoumei())) {
                throw new BizLogicException(MessageId.EHA1072,
                    MessageUtil.getMessage(uiBean.getHknsyuruino().getContent(C_HknsyuruiNo.PATTERN_SYANAIDISP)));
            }
            uiBean.setAisyoumeikbn(hknsyuruinmBean.getAisyoumeikbn());
            uiBean.setAisyoumei(hknsyuruinmBean.getAisyoumei());
        }

        DrtenTkykTratkiHantei drtenTkykTratkiHantei = SWAKInjector.getInstance(DrtenTkykTratkiHantei.class);
        C_TkykTratkiKbn tkykTratkiKbn = drtenTkykTratkiHantei.targettkTratkiHantei(
            syouhnZokusei.getTargettkhukakanoukbn(),
            uiBean.getSkeijimuKbn(), uiBean.getOyadairitencd1());
        uiBean.setTkyktratkikbn(tkykTratkiKbn);
        if (C_TkykTratkiKbn.TRATKINASI.eq(tkykTratkiKbn) && !"0".equals(uiBean.getMkhgkwarimosinput())) {
            throw new BizLogicException(MessageId.EBA0108,new Item[] { DDID_SONOTATOKUYAKUINFO2_MKHGKWARIMOSINPUT },
                MessageUtil.getMessage(DDID_SONOTATOKUYAKUINFO2_MKHGKWARIMOSINPUT.getErrorResourceKey()));
        }

        if (C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn())) {
            if(!C_TargetTkMokuhyoutiKbn.NOTARGET.getValue().equals(uiBean.getMkhgkwarimosinput())){
                throw new BizLogicException(MessageId.EHA1089, new Item[] { DDID_SONOTATOKUYAKUINFO2_MKHGKWARIMOSINPUT },
                    MessageUtil.getMessage(DDID_SONOTATOKUYAKUINFO2_MKHGKWARIMOSINPUT.getErrorResourceKey()),
                    C_TargetTkMokuhyoutiKbn.NOTARGET.getContent());
            }
        }

        if (!BizUtil.isBlank(uiBean.getOyadairitencd1())) {
            C_TkykTratkiKbn newTkykTratkiKbn = drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(
                uiBean.getSyouhncd(), pGetSyouhnZokuseiCtrlOutBean.getSyksbyensitihsyutktekiumu(),
                uiBean.getSkeijimuKbn(), uiBean.getOyadairitencd1());
            if (C_TkykTratkiKbn.HUKAHISSU.eq(newTkykTratkiKbn)) {
                if (!C_Tkhukaumu.HUKA.eq(uiBean.getSyksbyensitihsyutkhkkbn())) {
                    throw new BizLogicException(MessageId.EHC0220,new Item[] { DDID_SONOTATOKUYAKUINFO2_SYKSBYENSITIHSYUTKHKKBN },
                        MessageUtil.getMessage(DDID_SONOTATOKUYAKUINFO2_SYKSBYENSITIHSYUTKHKKBN.getErrorResourceKey()));
                }
            }
        }

        if (!BizUtil.isBlank(uiBean.getOyadairitencd1())) {

            if (uiBean.getOyadairitencd1().equals(YuyuBizConfig.getInstance().getSmbcOyadrtencd())) {
                BizDate smbcYakkandensiTratkiKaisiYmd = YuyuSinkeiyakuConfig.getInstance().getSmbcYakkandensiTratkiKaisiYmd();

                if (BizDateUtil.compareYmd(uiBean.getMosymd(),smbcYakkandensiTratkiKaisiYmd) != BizDateUtil.COMPARE_LESSER &&
                    C_YakkanJyuryouKbn.BLNK.eq(uiBean.getYakkanjyuryouhoukbn())) {

                    throw new BizLogicException(
                        MessageId.EBC0045, new Item[] { DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN },
                        MessageUtil.getMessage(DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getMosymd(),smbcYakkandensiTratkiKaisiYmd) == BizDateUtil.COMPARE_LESSER &&
                    !C_YakkanJyuryouKbn.BLNK.eq(uiBean.getYakkanjyuryouhoukbn())) {

                    throw new BizLogicException(
                        MessageId.EBA0108, new Item[] { DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN },
                        MessageUtil.getMessage(DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN.getErrorResourceKey()));
                }
            }
            else if (uiBean.getOyadairitencd1().equals(YuyuSinkeiyakuConfig.getInstance().getKansaimiraibank())) {
                BizDate knsimriYakkandensiTratkiKaisiYmd = YuyuSinkeiyakuConfig.getInstance().getKnsimriYakkandensiTratkiKaisiYmd();

                if (BizDateUtil.compareYmd(uiBean.getMosymd(),knsimriYakkandensiTratkiKaisiYmd) != BizDateUtil.COMPARE_LESSER &&
                    C_YakkanJyuryouKbn.BLNK.eq(uiBean.getYakkanjyuryouhoukbn())) {

                    throw new BizLogicException(
                        MessageId.EBC0045, new Item[] { DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN },
                        MessageUtil.getMessage(DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN.getErrorResourceKey()));
                }

                if (BizDateUtil.compareYmd(uiBean.getMosymd(),knsimriYakkandensiTratkiKaisiYmd) == BizDateUtil.COMPARE_LESSER &&
                    !C_YakkanJyuryouKbn.BLNK.eq(uiBean.getYakkanjyuryouhoukbn())) {

                    throw new BizLogicException(
                        MessageId.EBA0108, new Item[] { DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN },
                        MessageUtil.getMessage(DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN.getErrorResourceKey()));
                }
            }
            else {
                BizDate zenchanelYakkandensiTratkiKaisiYmd =
                    YuyuSinkeiyakuConfig.getInstance().getZenchanelYakkandensiTratkiKaisiYmd();
                if (BizDateUtil.compareYmd(uiBean.getMosymd(),
                    zenchanelYakkandensiTratkiKaisiYmd) != BizDateUtil.COMPARE_LESSER
                    && C_YakkanJyuryouKbn.BLNK.eq(uiBean.getYakkanjyuryouhoukbn())) {

                    throw new BizLogicException(MessageId.EBC0045,
                        new Item[] { DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN },
                        MessageUtil.getMessage(DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN.getErrorResourceKey()));
                }
                if (BizDateUtil.compareYmd(uiBean.getMosymd(),
                    zenchanelYakkandensiTratkiKaisiYmd) == BizDateUtil.COMPARE_LESSER
                    && !C_YakkanJyuryouKbn.BLNK.eq(uiBean.getYakkanjyuryouhoukbn())) {

                    throw new BizLogicException(MessageId.EBA0108,
                        new Item[] { DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN },
                        MessageUtil.getMessage(DDID_KEIYAKUSYAINFO_YAKKANJYURYOUHOUKBN.getErrorResourceKey()));
                }
            }
        }

        if (!BizUtil.isBlank(uiBean.getOyadairitencd1())) {
            GetDairitenKobetuJyouhou getDairitenKobetuJyouhou = SWAKInjector
                .getInstance(GetDairitenKobetuJyouhou.class);
            GetDairitenKobetuJyouhouBean drtnKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(
                uiBean.getOyadairitencd1(),uiBean.getMosuketukekbn());

            if (C_ErrorKbn.OK.eq(drtnKobetuJyouhouBean.getErrorKbn()) && !BizUtil.isBlank(uiBean.getCifcd())) {
                if (C_YouhiKbn.YOU.eq(drtnKobetuJyouhouBean.getCifCdCheckYouhi())) {

                    if (uiBean.getCifcd().length() > drtnKobetuJyouhouBean.getCifCdSiteiKetasuu()) {
                        throw new BizLogicException(MessageId.EBC0046,
                            MessageUtil.getMessage(DDID_DAIRITENINFOA_CIFCD.getErrorResourceKey()));
                    }

                    if (C_YouhiblnkKbn.YOU.eq(drtnKobetuJyouhouBean.getCifCdMaezeroumeYouhi())) {
                        uiBean.setCifcd(Strings.padStart(uiBean.getCifcd(),
                            drtnKobetuJyouhouBean.getCifCdSiteiKetasuu(), '0'));
                    }
                }
            }
        }

        if (!BizUtil.isBlank(uiBean.getOyadairitencd1())) {
            if (uiBean.getOyadairitencd1().equals(YuyuBizConfig.getInstance().getSmbcOyadrtencd())) {
                if (BizUtil.isBlank(uiBean.getUktkid())) {
                    throw new BizLogicException(MessageId.EBC0045,
                        MessageUtil.getMessage(DDID_DAIRITENINFOA_UKTKID.getErrorResourceKey()));
                }

                boolean matchRegexpFlg = GenericValidator.matchRegexp(uiBean.getUktkid(), "^[0-9]*$");

                if (!matchRegexpFlg) {
                    throw new BizLogicException(MessageId.EBC0046,
                        MessageUtil.getMessage(DDID_DAIRITENINFOA_UKTKID.getErrorResourceKey()));
                }

                String uktkid = "20".concat(uiBean.getUktkid().substring(0, 6));

                if (!BizDate.valueOf(uktkid).isRekijyou()) {

                    throw new BizLogicException(MessageId.EBC0046,
                        MessageUtil.getMessage(DDID_DAIRITENINFOA_UKTKID.getErrorResourceKey()));
                }
            }
            else {
                if (!BizUtil.isBlank(uiBean.getUktkid())) {
                    throw new BizLogicException(MessageId.EHC0176);
                }
            }
        }

        uiBean.setSisuukbn(syouhnZokusei.getSisuukbn());
        uiBean.setSisuunm("");

        String key = uiBean.getHknsyuruino().toString() + uiBean.getKyktuukasyu().toString();
        String sisuuvalue = uiBean.getSisuunmSyutokuMap().get(key);
        if (uiBean.getSisuunmSyutokuMap().containsKey(key)) {
            uiBean.setSisuunm(sisuuvalue);
        }

        if (C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(uiBean.getHknsyuruino()) ||
            C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(uiBean.getHknsyuruino())) {
            uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI100);
            uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI000);
        } else if (C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(uiBean.getHknsyuruino()) ||
            C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getHknsyuruino())) {
            uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI000);
            uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI100);
        } else {
            uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
            uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
        }

    }

    private void checkTankoumoku() {
        Integer nmKyoyou = YuyuBizConfig.getInstance().getKanaNmKyoyou();

        String hhknnmknNm = MessageUtil.getMessage(DDID_HIHOKENSYAINFO_HHKNNMKN.getErrorResourceKey());
        ctAddMsg(hhknnmknNm, uiBean.getHhknnmkn(), nmKyoyou.intValue());
        String kyknmknNm = MessageUtil.getMessage(DDID_KEIYAKUSYAINFO2_KYKNMKN.getErrorResourceKey());
        ctAddMsg(kyknmknNm, uiBean.getKyknmkn(), nmKyoyou.intValue());
        String sibouuktnmkana1Nm =
            MessageUtil.getMessage(DDID_SIBOUUKETORINININFO1_SBUKTNMKN1.getErrorResourceKey());
        ctAddMsg(sibouuktnmkana1Nm, uiBean.getSbuktnmkn1(), nmKyoyou.intValue());
        String sibouuktnmkana2Nm =
            MessageUtil.getMessage(DDID_SIBOUUKETORINININFO2_SBUKTNMKN2.getErrorResourceKey());
        ctAddMsg(sibouuktnmkana2Nm, uiBean.getSbuktnmkn2(), nmKyoyou.intValue());
        String sibouuktnmkana3Nm =
            MessageUtil.getMessage(DDID_SIBOUUKETORINININFO3_SBUKTNMKN3.getErrorResourceKey());
        ctAddMsg(sibouuktnmkana3Nm, uiBean.getSbuktnmkn3(), nmKyoyou.intValue());
        String sibouuktnmkana4Nm =
            MessageUtil.getMessage(DDID_SIBOUUKETORINININFO4_SBUKTNMKN4.getErrorResourceKey());
        ctAddMsg(sibouuktnmkana4Nm, uiBean.getSbuktnmkn4(), nmKyoyou.intValue());
        String trkkzknmkn1Nm =
            MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKNMKN1.getErrorResourceKey());
        ctAddMsg(trkkzknmkn1Nm, uiBean.getTrkkzknmkn1(), nmKyoyou.intValue());
        String trkkzknmkn2Nm =
            MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKNMKN2.getErrorResourceKey());
        ctAddMsg(trkkzknmkn2Nm, uiBean.getTrkkzknmkn2(), nmKyoyou.intValue());
        String siteidruktnmknNm =
            MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_SITEIDRUKTNMKN.getErrorResourceKey());
        ctAddMsg(siteidruktnmknNm, uiBean.getSiteidruktnmkn(), nmKyoyou.intValue());
        String kyknmKj = MessageUtil.getMessage(DDID_KEIYAKUSYAINFO2_KYKNMKJ.getErrorResourceKey());
        ctAddMsg2(kyknmKj, uiBean.getKyknmkj());
        String hhknnmKj = MessageUtil.getMessage(DDID_HIHOKENSYAINFO_HHKNNMKJ.getErrorResourceKey());
        ctAddMsg2(hhknnmKj, uiBean.getHhknnmkj());
        String sbuktnmKj1 = MessageUtil.getMessage(DDID_SIBOUUKETORINININFO1_SBUKTNMKJ1.getErrorResourceKey());
        ctAddMsg2(sbuktnmKj1, uiBean.getSbuktnmkj1());
        String sbuktnmKj2 = MessageUtil.getMessage(DDID_SIBOUUKETORINININFO2_SBUKTNMKJ2.getErrorResourceKey());
        ctAddMsg2(sbuktnmKj2, uiBean.getSbuktnmkj2());
        String sbuktnmKj3 = MessageUtil.getMessage(DDID_SIBOUUKETORINININFO3_SBUKTNMKJ3.getErrorResourceKey());
        ctAddMsg2(sbuktnmKj3, uiBean.getSbuktnmkj3());
        String sbuktnmKj4 = MessageUtil.getMessage(DDID_SIBOUUKETORINININFO4_SBUKTNMKJ4.getErrorResourceKey());
        ctAddMsg2(sbuktnmKj4, uiBean.getSbuktnmkj4());
        String trkkzknmKj1 = MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO1_TRKKZKNMKJ1.getErrorResourceKey());
        ctAddMsg2(trkkzknmKj1, uiBean.getTrkkzknmkj1());
        String trkkzknmKj2 = MessageUtil.getMessage(DDID_KZKOUROKUSERVICEYOUROKUINFO2_TRKKZKNMKJ2.getErrorResourceKey());
        ctAddMsg2(trkkzknmKj2, uiBean.getTrkkzknmkj2());
        String siteidruktnmKj = MessageUtil.getMessage(DDID_SITEIDAIRISEIKYUNININFO_SITEIDRUKTNMKJ.getErrorResourceKey());
        ctAddMsg2(siteidruktnmKj, uiBean.getSiteidruktnmkj());

        if (errorMessageCollector.exists()) {
            throw new BizLogicException(errorMessageCollector);
        }
    }

    private void ctAddMsg(String pKoumokuNm, String pKoumoku, int pKeta) {
        if (!CheckKana.isKyokaMoji(pKoumoku)) {
            errorMessageCollector.addMessage(MessageId.EBC0046, pKoumokuNm);
        }
        else if (!CheckKana.isKyoyouKetaHankaku(pKoumoku, pKeta)) {
            errorMessageCollector.addMessage(MessageId.EHA0156, pKoumokuNm, String.valueOf(pKeta));
        }
    }

    private void ctAddMsg2(String pKoumokuNm, String pKoumoku) {
        if (!CheckMeigininNmKanji.isCheckOK(pKoumoku, C_Kojinhjn.KOJIN)) {
            errorMessageCollector.addMessage(MessageId.EBC0046, pKoumokuNm);
        }
    }

    private void setMosKihonFromUiBean(HT_MosKihon pMosKihon, String pUserID, String pSysTime, boolean pAitemoFlg) {
        if (pAitemoFlg) {
            pMosKihon.setMosno(uiBean.getAitemosno());
            if (uiBean.isTaihyoumousikomiUmu()) {
                pMosKihon.setAitemosno(uiBean.getMosno());
            }
            else {
                pMosKihon.setAitemosno("");
            }
        }
        else {
            pMosKihon.setMosno(uiBean.getMosno());

            if (uiBean.isAiteimousikomiUmu() || (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
                uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAIARI) || E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn())
                || E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn())) {
                pMosKihon.setAitemosno(uiBean.getAitemosno());
            }
            else {
                pMosKihon.setAitemosno("");
            }
        }

        HT_BosKihon bosKihon = uiBean.getBosKihon();
        if (bosKihon != null) {
            pMosKihon.setSekno(bosKihon.getSekno());
            pMosKihon.setPykkigenymd(bosKihon.getPykkigenymd());
            pMosKihon.setMossakuseiymd(bosKihon.getMossakuseiymd());
            pMosKihon.setMoscalckijyunymd(bosKihon.getMoscalckijyunymd());
            pMosKihon.setDsmailaddress(bosKihon.getDsmailaddress());
        }
        pMosKihon.setMosymd(uiBean.getMosymd());
        pMosKihon.setKktymd(uiBean.getKktymd());
        pMosKihon.setKykkbn(uiBean.getKykkbn());
        pMosKihon.setHknsyuruino(uiBean.getHknsyuruino());
        pMosKihon.setHknsyuruinosd(uiBean.getHknsyuruinosd());
        pMosKihon.setAisyoumeikbn(uiBean.getAisyoumeikbn());
        pMosKihon.setNkgnshosyouritukbn(uiBean.getNkgnshosyouritukbn());
        pMosKihon.setKzktourokuservicetourokukbn(uiBean.getKzktourokuservicetourokukbn());
        pMosKihon.setKykdrtkykhukakbn(uiBean.getKykdrtkykhukakbn());
        pMosKihon.setStdrsktkyhkkbn(uiBean.getStdrsktkyhkkbn());
        pMosKihon.setSdpdkbn(uiBean.getSdpdkbn());
        pMosKihon.setSntkhoukbn(uiBean.getSntkhoukbn());
        pMosKihon.setHaitoukbn(uiBean.getHaitoukbn());

        if (C_HaitouKbn.RISAHAI.eq(uiBean.getHaitoukbn())) {
            pMosKihon.setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn.TUMIHAI);
        }

        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();

        if (pAitemoFlg) {
            pMosKihon.setKyktuukasyu(uiBean.getTaihikyktuukasyu2());
            pMosKihon.setHrktuukasyu(uiBean.getTaihihrktuukasyu2());
        }
        else {
            if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getGaikatatkiumu())) {
                pMosKihon.setKyktuukasyu(uiBean.getKyktuukasyu());
                pMosKihon.setHrktuukasyu(uiBean.getHrktuukasyu());
            }
            else {
                pMosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
                pMosKihon.setHrktuukasyu(C_Tuukasyu.JPY);
            }
        }
        pMosKihon.setYennykntkhkkbn(uiBean.getYennykntkhkkbn());
        pMosKihon.setGaikanykntkhkkbn(uiBean.getGaikanykntkhkkbn());

        if (pAitemoFlg) {
            pMosKihon.setMosheijyunp(uiBean.getHrktuukasyukykp2());
            pMosKihon.setMosikkatup(uiBean.getMosikkatup2());
            pMosKihon.setMoszennoupsyokaiari(uiBean.getMoszennoupsyokaiari2());
            pMosKihon.setMosfstpkei(uiBean.getMosfstpkei2());
            pMosKihon.setKjnnkpzeitekitkhukakbn(uiBean.getKjnnkpzeitekitkhukakbn2());
        }
        else {
            if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getHeijyunbaraiumu())) {
                if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn())) {
                    pMosKihon.setMosheijyunp(uiBean.getMossyukykp());
                }
                else {
                    pMosKihon.setMosheijyunp(uiBean.getHrktuukasyukykp());
                }
            }
            else {
                pMosKihon.setMosheijyunp(null);
            }

            pMosKihon.setMosikkatup(uiBean.getMosikkatup());
            pMosKihon.setMoszennoupsyokaiari(uiBean.getMoszennoupsyokaiari());
            pMosKihon.setMosfstpkei(uiBean.getMosfstpkei());
            pMosKihon.setKjnnkpzeitekitkhukakbn(uiBean.getKjnnkpzeitekitkhukakbn());
        }

        if (!C_IkkatubaraiKaisuuKbn.BLNK.eq(uiBean.getIkkatubaraikaisuu())) {
            pMosKihon.setIkkatubaraikbn(C_IkkatubaraiKbn.TEIKIIKKATU);
            pMosKihon.setIkkatubaraikaisuu(uiBean.getIkkatubaraikaisuu());
        }
        else {
            pMosKihon.setIkkatubaraikbn(C_IkkatubaraiKbn.BLNK);
            pMosKihon.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        }

        if (uiBean.getZnnkai() != null && uiBean.getZnnkai() > 0) {

            pMosKihon.setZnnkai(uiBean.getZnnkai() - 1);
        }
        else {

            pMosKihon.setZnnkai(uiBean.getZnnkai());
        }

        if ((uiBean.getZnnkai() != null && uiBean.getZnnkai() > 0) ||
            C_BlnktkumuKbn.ARI.eq(uiBean.getZenkizennouumu())) {

            pMosKihon.setZennoumousideumu(C_UmuKbn.ARI);
        }
        else {

            pMosKihon.setZennoumousideumu(C_UmuKbn.NONE);
        }

        pMosKihon.setZenkizennouumu(uiBean.getZenkizennouumu());
        pMosKihon.setHrkkaisuu(uiBean.getHrkkaisuu());
        pMosKihon.setHrkkeiro(uiBean.getHrkkeiro());
        pMosKihon.setFstphrkkeirokbn(uiBean.getFstphrkkeirokbn());
        pMosKihon.setHhknnmkn(uiBean.getHhknnmkn());
        pMosKihon.setHhknnmkj(uiBean.getHhknnmkj());
        pMosKihon.setHhknnmkjkhukakbn(uiBean.getHhknnmkjkhukakbn());
        pMosKihon.setHhknseiymd(uiBean.getHhknseiymd());
        pMosKihon.setHhknsei(uiBean.getHhknsei());
        pMosKihon.setHhknsykgycd(uiBean.getHhknsykgycd());
        pMosKihon.setHhknnensyuukbn(uiBean.getHhknnensyuukbn());
        pMosKihon.setTsindousiteikbn(uiBean.getTsindousiteikbn());
        pMosKihon.setHhknyno(uiBean.getHhknyno());
        pMosKihon.setHhknadr1kj(uiBean.getHhknadr1kj());
        pMosKihon.setHhknadr2kj(uiBean.getHhknadr2kj());
        pMosKihon.setHhknadr3kj(uiBean.getHhknadr3kj());
        pMosKihon.setHhkntelno(uiBean.getHhkntelno());
        pMosKihon.setKyknmkn(uiBean.getKyknmkn());
        pMosKihon.setKyknmkj(uiBean.getKyknmkj());
        pMosKihon.setKyknmkjkhukakbn(uiBean.getKyknmkjkhukakbn());
        pMosKihon.setKykseiymd(uiBean.getKykseiymd());
        pMosKihon.setKyksei(uiBean.getKyksei());
        pMosKihon.setKyktdk(uiBean.getKyktdk());
        pMosKihon.setYakkanjyuryouhoukbn(uiBean.getYakkanjyuryouhoukbn());
        pMosKihon.setFatcasnsikbn(uiBean.getFatcasnsikbn());
        pMosKihon.setBikkjnssinfokbn(uiBean.getBikkjnssinfokbn());
        pMosKihon.setBikknzsyno(uiBean.getBikknzsyno());
        pMosKihon.setAeoisnsikbn(uiBean.getAeoisnsikbn());
        pMosKihon.setTsinyno(uiBean.getTsinyno());
        pMosKihon.setTsinadr1kj(uiBean.getTsinadr1kj());
        pMosKihon.setTsinadr2kj(uiBean.getTsinadr2kj());
        pMosKihon.setTsinadr3kj(uiBean.getTsinadr3kj());
        pMosKihon.setTsintelno(uiBean.getTsintelno());
        pMosKihon.setDai2tsintelno(uiBean.getDai2tsintelno());
        if (C_TkykTratkiKbn.BLNK.eq(uiBean.getTkyktratkikbn())) {
            pMosKihon.setTargettkhkkbn(C_Tkhukaumu.BLNK);
        } else {
            if (C_TkykTratkiKbn.TRATKINASI.eq(uiBean.getTkyktratkikbn())) {
                pMosKihon.setTargettkhkkbn(C_Tkhukaumu.NONE);
            } else {
                pMosKihon.setTargettkhkkbn(C_Tkhukaumu.HUKA);
            }
        }

        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getTargettkhkkbn())) {
            pMosKihon.setTargettkkbn(C_TargetTkKbn.valueOf(getSyouhnZokuseiCtrlOutBean.getTargettkhukakanoukbn()
                .getValue()));
        } else {
            pMosKihon.setTargettkkbn(C_TargetTkKbn.BLNK);
        }

        pMosKihon.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.valueOf(uiBean.getMkhgkwarimosinput()));

        pMosKihon.setNstkhkkbn(uiBean.getNstkhkkbn());

        if (C_Tkhukaumu.HUKA.eq(uiBean.getNstkhkkbn())) {
            pMosKihon.setNstksbnsyu(C_Nstknsyu.KAKUTEINENKIN);
        }
        pMosKihon.setNstksbnkkn(uiBean.getNstksbnkkn());
        pMosKihon.setSyksbyensitihsyutkhkkbn(uiBean.getSyksbyensitihsyutkhkkbn());
        pMosKihon.setJyudkaigomehrtkhkkbn(uiBean.getJyudkaigomehrtkhkkbn());
        pMosKihon.setTeikisiharaitkykhkkbn(uiBean.getTeikisiharaitkykhkkbn());
        pMosKihon.setSbuktnin(uiBean.getSbuktnin());
        pMosKihon.setKykhonninkakninsyoruikbn(uiBean.getKykhonninkakninsyoruikbn());
        pMosKihon.setSkskknhonninkakninsyoruikbn(uiBean.getSkskknhonninkakninsyoruikbn());
        pMosKihon.setKoureikzksetumeihoukbn(uiBean.getKoureikzksetumeihoukbn());
        pMosKihon.setKoureimndnhukusuukaikbn(uiBean.getKoureimndnhukusuukaikbn());
        pMosKihon.setKoureitratkisyaigidskkbn(uiBean.getKoureitratkisyaigidskkbn());
        pMosKihon.setUktkid(uiBean.getUktkid());
        pMosKihon.setDrctservicemoskbn(uiBean.getDrctservicemoskbn());
        pMosKihon.setYnkhrkmgkannituutikbn(uiBean.getYnkhrkmgkannituutikbn());
        pMosKihon.setHnsstjmmouumukbn(C_UmuKbn.ARI);

        if (C_KjkhukaKbn.KJKHUKA.eq(uiBean.getHhknnmkjkhukakbn()) ||
            C_KjkhukaKbn.KJKHUKA.eq(uiBean.getKyknmkjkhukakbn()) ||
            C_KjkhukaKbn.KJKHUKA.eq(uiBean.getSbuktnmkjhukakbn1()) ||
            C_KjkhukaKbn.KJKHUKA.eq(uiBean.getSbuktnmkjhukakbn2()) ||
            C_KjkhukaKbn.KJKHUKA.eq(uiBean.getSbuktnmkjhukakbn3()) ||
            C_KjkhukaKbn.KJKHUKA.eq(uiBean.getSbuktnmkjhukakbn4()) ||
            C_KjkhukaKbn.KJKHUKA.eq(uiBean.getTrkkzknmkjkhukakbn1()) ||
            C_KjkhukaKbn.KJKHUKA.eq(uiBean.getTrkkzknmkjkhukakbn2()) ||
            C_KjkhukaKbn.KJKHUKA.eq(uiBean.getStdrsknmkjhukakbn())) {
            pMosKihon.setKjmeigihkhunouumukbn(C_UmuKbn.ARI);
        }
        else {
            pMosKihon.setKjmeigihkhunouumukbn(C_UmuKbn.NONE);
        }

        pMosKihon.setTsryhshrkykumukbn(uiBean.getTsryhshrkykumukbn());
        pMosKihon.setSyosisyatodokeumukbn(uiBean.getSyosisyatodokeumukbn());
        pMosKihon.setKakukisyouryakukbumukbn(uiBean.getKakukisyouryakukbumukbn());
        pMosKihon.setSeiymdmosseitouumukbn(uiBean.getSeiymdmosseitouumukbn());
        pMosKihon.setIkokakninsyotokkijkumu(uiBean.getIkokakninsyotokkijkumu());
        pMosKihon.setTrtkhoukokusyotokkijkumu(uiBean.getTrtkhoukokusyotokkijkumu());
        pMosKihon.setHnnkakninhskjikouumukbn(uiBean.getHnnkakninhskjikouumukbn());
        pMosKihon.setHnnkakninhsktkjikouumukbn(uiBean.getHnnkakninhsktkjikouumukbn());
        pMosKihon.setSkskakninhsktkjikouumukbn(uiBean.getSkskakninhsktkjikouumukbn());
        pMosKihon.setKhnchkcmnt(uiBean.getKhnchkcmnt());
        pMosKihon.setMobilebosyuukbn(uiBean.getMobilebosyuukbn());
        pMosKihon.setJimuyoucd(uiBean.getJimuyoucd());
        pMosKihon.setTeirituhaibunwarikbn(uiBean.getTeirituhaibunwarikbn());
        pMosKihon.setSisuukbn(uiBean.getSisuukbn());
        pMosKihon.setSisuuhaibunwarikbn(uiBean.getSisuuhaibunwarikbn());
        pMosKihon.setTrhkjikakkbn(C_TrhkjiKakKbn.KAKUNINZUMI);

        if (!pAitemoFlg) {
            if (C_UmuKbn.NONE.eq(getSyouhnZokuseiCtrlOutBean.getGaikatatkiumu())) {
                pMosKihon.setKyktuukasyu2(C_Tuukasyu.BLNK);
                pMosKihon.setHrktuukasyu2(C_Tuukasyu.BLNK);
            }
            else {
                if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
                    uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAIARI) {
                    pMosKihon.setKyktuukasyu2(uiBean.getKyktuukasyu2());
                    pMosKihon.setHrktuukasyu2(uiBean.getHrktuukasyu2());
                }
                else {
                    pMosKihon.setKyktuukasyu2(C_Tuukasyu.BLNK);
                    pMosKihon.setHrktuukasyu2(C_Tuukasyu.BLNK);
                }
            }

            if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
                uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAIARI) {
                pMosKihon.setMosheijyunp2(uiBean.getHrktuukasyukykp2());
                pMosKihon.setMosikkatup2(uiBean.getMosikkatup2());
                pMosKihon.setMoszennoupsyokaiari2(uiBean.getMoszennoupsyokaiari2());
                pMosKihon.setKjnnkpzeitekitkhukakbn2(uiBean.getKjnnkpzeitekitkhukakbn2());
            }
            else {
                pMosKihon.setMosheijyunp2(BizCurrency.optional());
                pMosKihon.setMosikkatup2(BizCurrency.optional());
                pMosKihon.setMoszennoupsyokaiari2(BizCurrency.optional());
                pMosKihon.setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu.BLNK);
            }
        }
        else {
            pMosKihon.setKyktuukasyu2(C_Tuukasyu.BLNK);
            pMosKihon.setHrktuukasyu2(C_Tuukasyu.BLNK);
            pMosKihon.setMosheijyunp2(BizCurrency.optional());
            pMosKihon.setMosikkatup2(BizCurrency.optional());
            pMosKihon.setMoszennoupsyokaiari2(BizCurrency.optional());
            pMosKihon.setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu.BLNK);
        }

        pMosKihon.setGyoumuKousinsyaId(pUserID);
        pMosKihon.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(pMosKihon);
    }

    private void editDairitenInfo(List<String> pJimusyoCdLst,
        List<String> pBosyuuTrkNoLst,
        List<String> pKinyuukikanCdLst,
        List<String> pKinyuukikanSitenCdLst,
        List<String> pKouinCdLst,
        List<String> pKojinCdLst,
        List<String> pGyskkjsakiSosikiCdLst,
        List<BizNumber> pBunwariLst) {
        List<String> tratkidrtCdLst = Lists.newArrayList();
        tratkidrtCdLst.add(null);
        tratkidrtCdLst.add(null);
        List<String> tratkidrtNmLst = Lists.newArrayList();
        tratkidrtNmLst.add(null);
        tratkidrtNmLst.add(null);
        List<String> oyadrtCdLst = Lists.newArrayList();
        oyadrtCdLst.add(null);
        oyadrtCdLst.add(null);
        List<String> oyadrtNmLst = Lists.newArrayList();
        oyadrtNmLst.add(null);
        oyadrtNmLst.add(null);
        List<String> bosyuuCdLst = Lists.newArrayList();
        bosyuuCdLst.add(null);
        bosyuuCdLst.add(null);
        List<String> bosyuuNmLst = Lists.newArrayList();
        bosyuuNmLst.add(null);
        bosyuuNmLst.add(null);
        List<String> bosyuudrtCdLst = Lists.newArrayList();
        bosyuudrtCdLst.add(null);
        bosyuudrtCdLst.add(null);
        List<String> gyskkjsakiSosikiNmLst = Lists.newArrayList();
        gyskkjsakiSosikiNmLst.add(null);
        gyskkjsakiSosikiNmLst.add(null);

        for (int index = 0; index < MAX_DAIRITEN; index++) {
            if (index == 1 && !uiBean.getDrtInfo2HyoujiFlg()) {
                break;
            }

            BzGetBsInfoBean bzGetBsInfoBean = null;

            if (!BizUtil.isBlank(pKouinCdLst.get(index))) {
                BzGetBsInfoKouin bzGetBsInfoKouin = SWAKInjector.getInstance(BzGetBsInfoKouin.class);
                bzGetBsInfoBean = bzGetBsInfoKouin.exec(pKinyuukikanCdLst.get(index), pKouinCdLst.get(index));
                if (bzGetBsInfoBean != null) {
                    if (index == 0) {
                        uiBean.setDairitentoriatukaikouincd1(bzGetBsInfoBean.getKouinCd());
                    }
                    else {
                        uiBean.setDairitentoriatukaikouincd2(bzGetBsInfoBean.getKouinCd());
                    }
                }
            }
            else if (!BizUtil.isBlank(pBosyuuTrkNoLst.get(index))) {
                BzGetBsInfoBstrkno bzGetBsInfoBstrkno = SWAKInjector.getInstance(BzGetBsInfoBstrkno.class);
                bzGetBsInfoBean = bzGetBsInfoBstrkno.exec(pBosyuuTrkNoLst.get(index));
            }
            else if (!BizUtil.isBlank(pKojinCdLst.get(index))) {
                BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
                bzGetBsInfoBean = bzGetBsInfo.exec(pKojinCdLst.get(index).substring(0, 6));
            }

            if (bzGetBsInfoBean != null) {
                bosyuuCdLst.set(index, bzGetBsInfoBean.getBosyuuCd());
                bosyuuNmLst.set(index, bzGetBsInfoBean.getKanjiBosyuuninNm());
                bosyuudrtCdLst.set(index, bzGetBsInfoBean.getDairiten1Cd());
            }

            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = null;

            if (!BizUtil.isBlank(bosyuudrtCdLst.get(index))) {
                BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
                bzGetAgInfoBeanLst = bzGetAgInfo.exec(bosyuudrtCdLst.get(index));
            }

            if (bzGetAgInfoBeanLst != null) {
                for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                    if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                        oyadrtCdLst.set(index, bzGetAgInfoBean.getDrtenCd());
                        oyadrtNmLst.set(index, bzGetAgInfoBean.getKanjiDairitenNm());
                    }
                }
            }

            if (!BizUtil.isBlank(pKinyuukikanCdLst.get(index))) {
                BzGetAgInfoKinyuuKikan bzGetAgInfoKinyuuKikan = SWAKInjector.getInstance(BzGetAgInfoKinyuuKikan.class);
                bzGetAgInfoBeanLst = bzGetAgInfoKinyuuKikan.exec(pKinyuukikanCdLst.get(index),
                    pKinyuukikanSitenCdLst.get(index));

                if (bzGetAgInfoBeanLst != null && bzGetAgInfoBeanLst.size() != 0) {
                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                        if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                            tratkidrtCdLst.set(index, bzGetAgInfoBean.getDrtenCd());
                            tratkidrtNmLst.set(index, bzGetAgInfoBean.getKanjiDairitenNm());
                        }
                        else if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                            oyadrtCdLst.set(index, bzGetAgInfoBean.getDrtenCd());
                            oyadrtNmLst.set(index, bzGetAgInfoBean.getKanjiDairitenNm());
                        }
                    }
                }
                else {
                    oyadrtCdLst.set(index, "");
                    oyadrtNmLst.set(index, "");
                }
            }
            else if (!BizUtil.isBlank(pJimusyoCdLst.get(index)) && !BizUtil.isBlank(oyadrtCdLst.get(index))) {
                BzGetAgInfoJimusyo bzGetAgInfoJimusyo = SWAKInjector.getInstance(BzGetAgInfoJimusyo.class);
                bzGetAgInfoBeanLst = bzGetAgInfoJimusyo.exec(oyadrtCdLst.get(index), pJimusyoCdLst.get(index));

                if (bzGetAgInfoBeanLst != null) {
                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                        if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                            tratkidrtCdLst.set(index, bzGetAgInfoBean.getDrtenCd());
                            tratkidrtNmLst.set(index, bzGetAgInfoBean.getKanjiDairitenNm());
                        }
                        else if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                            oyadrtCdLst.set(index, bzGetAgInfoBean.getDrtenCd());
                            oyadrtNmLst.set(index, bzGetAgInfoBean.getKanjiDairitenNm());
                        }
                    }
                }
            }
            else if (index == 1 && BizUtil.isBlank(pJimusyoCdLst.get(index)) &&
                (!BizUtil.isBlank(pBosyuuTrkNoLst.get(index)) || !BizUtil.isBlank(pKojinCdLst.get(index)))) {
                if (bzGetAgInfoBeanLst != null) {
                    for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                        if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                            tratkidrtCdLst.set(index, bzGetAgInfoBean.getDrtenCd());
                            tratkidrtNmLst.set(index, bzGetAgInfoBean.getKanjiDairitenNm());
                        }
                    }
                }
            }
        }

        if (uiBean.getDairitenbuntanwariai1() != null &&
            !uiBean.getDairitenbuntanwariai1().isOptional() &&
            BizNumber.ZERO.compareTo(uiBean.getDairitenbuntanwariai1()) == 0) {
            throw new BizLogicException(MessageId.EHA1056);
        }

        if (uiBean.getDrtInfo2HyoujiFlg()) {
            if (uiBean.getDairitenbuntanwariai1() != null &&
                !uiBean.getDairitenbuntanwariai1().isOptional()) {
                uiBean.setDairitenbuntanwariai2(BUNWARI_100.subtract(uiBean.getDairitenbuntanwariai1()));
            }
            else {
                uiBean.setDairitenbuntanwariai2(BizNumber.optional());
            }
        }
        else {
            if (uiBean.getDairitenbuntanwariai1() == null ||
                uiBean.getDairitenbuntanwariai1().isOptional()) {
                uiBean.setDairitenbuntanwariai1(BUNWARI_100);
            }

            uiBean.setDairitenbuntanwariai2(BizNumber.optional());
        }

        uiBean.setToriatukaidairitencd1(tratkidrtCdLst.get(0));
        uiBean.setToriatukaidairitencd2(tratkidrtCdLst.get(1));
        uiBean.setToriatukaidairitennm1(tratkidrtNmLst.get(0));
        uiBean.setToriatukaidairitennm2(tratkidrtNmLst.get(1));
        uiBean.setOyadairitencd1(oyadrtCdLst.get(0));
        uiBean.setOyadairitencd2(oyadrtCdLst.get(1));
        uiBean.setOyadairitennm1(oyadrtNmLst.get(0));
        uiBean.setOyadairitennm2(oyadrtNmLst.get(1));
        uiBean.setBosyuucd1(bosyuuCdLst.get(0));
        uiBean.setBosyuucd2(bosyuuCdLst.get(1));
        uiBean.setBosyuuninnm1(bosyuuNmLst.get(0));
        uiBean.setBosyuuninnm2(bosyuuNmLst.get(1));
        uiBean.setGyskkjsakisosikinmkj1(gyskkjsakiSosikiNmLst.get(0));
        uiBean.setGyskkjsakisosikinmkj2(gyskkjsakiSosikiNmLst.get(1));
    }

    //    private void checkZero() {
    //
    //        if (BizUtil.isZero(uiBean.getSyukihons())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_SYUKEIYAKUHOSYOUINFO_SYUKIHONS);
    //        }
    //        if (uiBean.getSyuhknkkn() != null && uiBean.getSyuhknkkn() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_SYUKEIYAKUHOSYOUINFO_SYUHKNKKN);
    //        }
    //        if (uiBean.getSyuhrkkkn() != null && uiBean.getSyuhrkkkn() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_SYUKEIYAKUHOSYOUINFO_SYUHRKKKN);
    //        }
    //        if (BizUtil.isZero(uiBean.getMosfstpkei())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_SYUKEIYAKUHOSYOUINFO_MOSFSTPKEI);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons1())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO1_TOKUYAKUKIHONS1);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons2())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO2_TOKUYAKUKIHONS2);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons3())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO3_TOKUYAKUKIHONS3);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons4())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO4_TOKUYAKUKIHONS4);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons5())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO5_TOKUYAKUKIHONS5);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons6())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO6_TOKUYAKUKIHONS6);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons7())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO7_TOKUYAKUKIHONS7);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons8())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO8_TOKUYAKUKIHONS8);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons9())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO9_TOKUYAKUKIHONS9);
    //        }
    //        if (BizUtil.isZero(uiBean.getTokuyakukihons10())) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO10_TOKUYAKUKIHONS10);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan1() != null && uiBean.getTokuyakuhokenkikan1() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO1_TOKUYAKUHOKENKIKAN1);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan2() != null && uiBean.getTokuyakuhokenkikan2() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO2_TOKUYAKUHOKENKIKAN2);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan3() != null && uiBean.getTokuyakuhokenkikan3() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO3_TOKUYAKUHOKENKIKAN3);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan4() != null && uiBean.getTokuyakuhokenkikan4() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO4_TOKUYAKUHOKENKIKAN4);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan5() != null && uiBean.getTokuyakuhokenkikan5() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO5_TOKUYAKUHOKENKIKAN5);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan6() != null && uiBean.getTokuyakuhokenkikan6() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO6_TOKUYAKUHOKENKIKAN6);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan7() != null && uiBean.getTokuyakuhokenkikan7() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO7_TOKUYAKUHOKENKIKAN7);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan8() != null && uiBean.getTokuyakuhokenkikan8() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO8_TOKUYAKUHOKENKIKAN8);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan9() != null && uiBean.getTokuyakuhokenkikan9() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO9_TOKUYAKUHOKENKIKAN9);
    //        }
    //        if (uiBean.getTokuyakuhokenkikan10() != null && uiBean.getTokuyakuhokenkikan10() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_TOKUYAKUHOSYOUINFO10_TOKUYAKUHOKENKIKAN10);
    //        }
    //        if (uiBean.getSbhkkukttyoukanin() != null && uiBean.getSbhkkukttyoukanin() == 0) {
    //            errMessages.addMessage(MessageId.EAV0019, DDID_SIBOUHOKENKINUKETORINININFO6_SBHKKUKTTYOUKANIN);
    //        }
    //
    //        if (errMessages.exists()) {
    //            throw new BizLogicException(errMessages);
    //        }
    //    }

    private GetSyouhnZokuseiCtrlOutBean getGamenCtrlBean() {
        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = SWAKInjector.getInstance(GetSyouhnZokuseiCtrlOutBean.class);
        for (GetSyouhnZokuseiCtrlOutBean ctrlBean : uiBean.getSyouhnzokuseiCtrlGetOutBeanLst()) {
            if (uiBean.getHknsyuruino().eq(ctrlBean.getHknsyuruino())) {
                getSyouhnZokuseiCtrlOutBean = ctrlBean;
                break;
            }
        }

        uiBean.setItibuzennoutekiumu(getSyouhnZokuseiCtrlOutBean.getItibuzennoutekiumu());

        return getSyouhnZokuseiCtrlOutBean;
    }

    private void initUiBean1() {

        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();

        uiBean.setKyktuukasyu(C_Tuukasyu.valueOf(uiBean.getKyktuukasyumosinput()));
        uiBean.setHrktuukasyu(C_Tuukasyu.valueOf(uiBean.getHrktuukasyumosinput()));
        uiBean.setKyktuukasyu2(C_Tuukasyu.valueOf(uiBean.getKyktuukasyu2mosinput()));
        uiBean.setHrktuukasyu2(C_Tuukasyu.valueOf(uiBean.getHrktuukasyu2mosinput()));
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.valueOf(uiBean.getIkkatubaraikaisuumosinput()));
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.valueOf(uiBean.getZenkizennouumumosinput()));
        uiBean.setHrkkaisuu(C_Hrkkaisuu.valueOf(uiBean.getHrkkaisuumosinput()));

        uiBean.clearSyudai1hknkknmosinputOptionBeanList();
        uiBean.setSyudai1hknkknmosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getDai1HknkknSelect());

        if (uiBean.getSyudai1hknkknmosinputOptionBeanList().size() == 0) {
            uiBean.setSyudai1hknkknmosinput("");
        }

        uiBean.clearMkhgkwarimosinputOptionBeanList();
        uiBean.setMkhgkwarimosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getTargettkmkhtSelect());

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getKktumu())) {
            uiBean.setSntkhoukbn(C_SntkhouKbn.KKT);
        }
        else if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getSyokugyoukktumu())) {
            uiBean.setSntkhoukbn(C_SntkhouKbn.SYOKUGYOU);
        }
        else if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getMusenumu())) {
            uiBean.setSntkhoukbn(C_SntkhouKbn.NONE);
        }

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getPyennykntktekiumu())) {
            uiBean.setYennykntkhkkbn(C_Tkhukaumu.NONE);
        }
        else {
            uiBean.setYennykntkhkkbn(C_Tkhukaumu.BLNK);
        }

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getGaikanyuukintktekiumu())) {
            uiBean.setGaikanykntkhkkbn(C_Tkhukaumu.NONE);
        }
        else {
            uiBean.setGaikanykntkhkkbn(C_Tkhukaumu.BLNK);
        }

        uiBean.setTargettkhkkbn(C_Tkhukaumu.BLNK);

        uiBean.setTargettkkbn(C_TargetTkKbn.BLNK);

        uiBean.setHaitoukbn(getSyouhnZokuseiCtrlOutBean.getHaitoukbn());

        uiBean.clearSueokikknmosinputOptionBeanList();
        uiBean.setSueokikknmosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getSueokikknSelect());

        uiBean.clearNenkinsyumosinputOptionBeanList();
        uiBean.setNenkinsyumosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getNenkinsyuSelect());

        uiBean.clearKyktuukasyumosinputOptionBeanList();
        uiBean.setKyktuukasyumosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getKyktuukasyuSelect());

        uiBean.clearHrktuukasyumosinputOptionBeanList();
        uiBean.setHrktuukasyumosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getHrktuukaSelect());

        uiBean.clearKyktuukasyu2mosinputOptionBeanList();
        uiBean.setKyktuukasyu2mosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getKyktuukasyu2Select());

        uiBean.clearHrktuukasyu2mosinputOptionBeanList();
        uiBean.setHrktuukasyu2mosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getHrktuukaSelect());

        uiBean.clearHrkkaisuumosinputOptionBeanList();
        uiBean.setHrkkaisuumosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getHrkkaisuuSelect());

        uiBean.clearIkkatubaraikaisuumosinputOptionBeanList();
        uiBean.setIkkatubaraikaisuumosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getIkkatubaraikaisuuSelect());

        uiBean.clearZenkizennouumumosinputOptionBeanList();
        uiBean.setZenkizennouumumosinputOptionBeanList(getSyouhnZokuseiCtrlOutBean.getZenkizennouSelect());

        uiBean.setMos2hyoujiumuKbn(getSyouhnZokuseiCtrlOutBean.getMos2hyoujiumuKbn());
    }

    private void initUiBean2() {
        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();
        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getSyuusinhknumu())) {
            uiBean.setSyuhknkkn(YuyuSinkeiyakuConfig.getInstance().getHknkknSyuusin());
        }
        else if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getNkhknumu()) &&
            C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getItijibrumu())) {
            uiBean.setSyuhknkkn(0);
        }

        uiBean.setSyuhknkknsmnkbn(getSyouhnZokuseiCtrlOutBean.getHknkknsmnKbn());

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getItijibrumu())) {
            uiBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        }

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getItijibrumu())) {
            uiBean.setSyuhrkkkn(0);
        }

        uiBean.setSyuhrkkknsmnkbn(getSyouhnZokuseiCtrlOutBean.getHrkkknsmnkbn());

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getItijibrumu())) {
            uiBean.setHrkkeiro(C_Hrkkeiro.BLNK);
        }

        if (!C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getHeijyunbaraiumu())) {
            uiBean.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);
        }

        if (uiBean.getKouzainfoinputhoryuu()) {
            uiBean.setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        }
        else {
            uiBean.setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn.BLNK);
        }

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getNkhknumu()) &&
            C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getHeijyunbaraiumu())) {
            uiBean.setNkshrstartnen(uiBean.getSyuhknkkn());
            uiBean.setPhrkkknManryounen(uiBean.getSyuhrkkkn());
        }
        else {
            uiBean.setNkshrstartnen(0);
            uiBean.setPhrkkknManryounen(0);
        }

        if (!(C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getKouzahurikaebaraitekiumu()) &&
            C_Hrkkeiro.KOUHURI.eq(uiBean.getHrkkeiro()) &&
            C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getKouzainfoinputhoryuukbn()))) {
            uiBean.setKouhurikouzainfoyokinkbn(C_YokinKbn.BLNK);
            uiBean.setKouhurikouzainfokzdoukbn(C_KzkykdouKbn.BLNK);
        }

        if (C_UmuKbn.NONE.eq(getSyouhnZokuseiCtrlOutBean.getTeikiikkatubaraiumu())) {
            uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        }

        if (C_UmuKbn.NONE.eq(getSyouhnZokuseiCtrlOutBean.getZennouumu())) {
            uiBean.setZenkizennouumu(C_BlnktkumuKbn.BLNK);
        }

        if (!C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn()) ||
            !C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getShkstkzinfkzinfoinputhrykbn())) {
            uiBean.setYokinkbn(C_YokinKbn.BLNK);
            uiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
        }
    }

    private void doMosNoCheck(String pMosNo) {
        boolean result = MousikomiNoCheck.ifExistMousikomiNo(pMosNo);

        if (!result) {
            throw new BizLogicException(MessageId.EHA0398);
        }
    }

    private void checkSinkiSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        if (!C_SeirituKbn.NONE.eq(pSyoriCTL.getSeiritukbn())) {
            throw new BizLogicException(MessageId.EBA0031, pSyoriCTL.getSeiritukbn().getContent());
        }
        if (C_UmuKbn.ARI.eq(pSyoriCTL.getMosnrkumu())) {
            throw new BizLogicException(MessageId.EHA0090);
        }
        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKhnhbkbn())) {
            throw new BizLogicException(MessageId.EHA0161);
        }
    }

    private void setSinkiBosInfo(String pMosNo) {
        HT_BosKihon bosKihon = sinkeiyakuDomManager.getBosKihon(pMosNo);
        uiBean.setBosKihon(bosKihon);

        C_UmuKbn bosInfoUmu;
        if (bosKihon != null) {
            bosInfoUmu = C_UmuKbn.ARI;
        }
        else {
            bosInfoUmu = C_UmuKbn.NONE;
        }

        if (C_UmuKbn.ARI.eq(bosInfoUmu)) {
            setUiBeanFromBosyuuInfo(bosKihon);
        }

        chkWarning(bosInfoUmu);
        startTask();
    }

    private String cutKjkhukaKnNm(String pInKanaNm) {
        if (pInKanaNm.length() > 15) {
            return pInKanaNm.substring(0, 15);
        }

        return pInKanaNm;
    }

    private void setHonninKakninInfoPtn() {
        if (C_SkeijimuKbn.SMBC.eq(uiBean.getSkeijimuKbn())) {
            uiBean.setPatternKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PATTERN_SMBCMOS);
            uiBean.setPatternSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PATTERN_SMBCMOS);
        }
        else {
            uiBean.setPatternKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PATTERN_MOS);
            uiBean.setPatternSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PATTERN_MOS);
        }
    }

    private String getSyokugyouNm(String pSyokugyouCd) {
        String syokugyouNm = "";
        if (!BizUtil.isBlank(pSyokugyouCd)) {
            BM_Syokugyou syokugyou = bizDomManager.getSyokugyou(pSyokugyouCd);
            if (syokugyou != null) {
                syokugyouNm = syokugyou.getSyokugyounm();
            }
        }

        return syokugyouNm;
    }

    private void chkWarning(C_UmuKbn pBosInfoUmu) {

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn())
            || E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn())) {
            if (C_UmuKbn.ARI.eq(pBosInfoUmu)) {

                HT_BosKihon bosKihon = uiBean.getBosKihon();

                if (C_MosUketukeKbn.PAPERLESS.eq(bosKihon.getMosuketukekbn())
                    && C_MosUketukeKbn.SEIHOWEB.eq(uiBean.getMosuketukekbn())) {
                    String message = "<strong><font color=#FF0000>" + MessageUtil.getMessage(MessageId.WHA1005)
                        + "</font></strong>";
                    messageMgr.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WBC0001,
                        message);
                }
            }
        }

        GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);
        BizDate syoruiTtykYmd = getSyoruittykymd.exec(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO);

        if (syoruiTtykYmd != null) {

            syoruiTtykYmd = getSyoruittykymd.exec(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
                C_SyoruiCdKbn.SK_MOSSYO);

            if (syoruiTtykYmd != null) {
                String message = "<strong><font color=#FF0000>" + MessageUtil.getMessage(MessageId.WHA1005)
                    + "</font></strong>";
                messageMgr.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WBC0001, message);
            }
        }
    }

    private void setSyouhnInfoKobetu(int pHhknNenrei) {

        if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(uiBean.getHknsyuruino())) {
            if (pHhknNenrei < 50) {
                uiBean.setSyudai1hknkknmosinput("10");
            }
            else {
                uiBean.setSyudai1hknkknmosinput("5");
            }
        }
    }

    private BizNumber zeroToOptional(BizNumber pNumber) {
        if (pNumber == null || pNumber.isOptional() || BizNumber.ZERO.compareTo(pNumber) == 0) {
            return BizNumber.optional();
        }
        return pNumber;
    }

    private BizCurrency zeroToOptional(BizCurrency pCurrency) {
        if (pCurrency == null) {
            return BizCurrency.optional();
        }
        else if (pCurrency.isOptional() || BizCurrency.valueOf(0, pCurrency.getType()).equalsValue(pCurrency)) {
            return BizCurrency.optional(pCurrency.getType());
        }
        return pCurrency;
    }

    private Integer zeroToNull(Integer pNumber) {
        if (pNumber == 0) {
            return null;
        }
        return pNumber;
    }

    private void setUiBeanFromSyorictl(HT_SyoriCTL pSyoriCTL) {

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKznrkhbumu())) {

            uiBean.setKouzainfoinputhoryuu(true);
            uiBean.setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        }
        else {

            uiBean.setKouzainfoinputhoryuu(false);
            uiBean.setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn.BLNK);
        }
    }

    private void setUiBeanFromKouzaJyouhou(HT_KouzaJyouhou pKouzaJyouhou) {

        uiBean.setInitKzhuritourokuhoukbn(pKouzaJyouhou.getKzhuritourokuhoukbn());
        uiBean.setKzhuritourokuhoukbn(pKouzaJyouhou.getKzhuritourokuhoukbn());
        uiBean.setKouhurikouzainfobankcd(pKouzaJyouhou.getBankcd());
        uiBean.setKouhurikouzainfositencd(pKouzaJyouhou.getSitencd());
        uiBean.setKouhurikouzainfoyokinkbn(pKouzaJyouhou.getYokinkbn());
        uiBean.setKouhurikouzainfokouzano(pKouzaJyouhou.getKouzano());
        uiBean.setKouhurikouzainfokzdoukbn(pKouzaJyouhou.getKzkykdoukbn());
        uiBean.setKouhurikouzainfokzmeiginmkn(pKouzaJyouhou.getKzmeiginmkn());
        uiBean.setKouzakakuniniraikbn(pKouzaJyouhou.getKouzakakuniniraikbn());
    }

    private void checkShkstkzinfkzinfo() {

        String kyknmkn = "";

        if(C_KzkykdouKbn.DOUITU.eq(uiBean.getKzkykdoukbn())){
            if(C_KykKbn.KEIHI_DOUITU.eq(uiBean.getKykkbn())){
                kyknmkn = uiBean.getHhknnmkn();
            }
            else if (C_KykKbn.KEIHI_BETU.eq(uiBean.getKykkbn())){
                kyknmkn = uiBean.getKyknmkn();
            }
        }

        CheckShiharaikinSiteiKouza checkShiharaikinSiteiKouza = SWAKInjector.getInstance(CheckShiharaikinSiteiKouza.class);
        checkShiharaikinSiteiKouza.exec(
            uiBean.getTeikisiharaitkykhkkbn(),
            uiBean.getKzsyuruikbn(),
            uiBean.getBankcd(),
            uiBean.getSitencd(),
            uiBean.getYokinkbn(),
            uiBean.getKouzano(),
            uiBean.getKzkykdoukbn(),
            kyknmkn,
            uiBean.getKzmeiginmkn(),
            BizDate.getSysDate());

        List<Integer> shkstkzinfkzinfoErrorList = checkShiharaikinSiteiKouza.getErrorCdList();

        boolean existFlg = shkstkzinfkzinfoErrorList.contains(CheckShiharaikinSiteiKouza.KZMEIGINMKN_KYOKAMOJICHK_ERROR);

        Integer kzmeigiKanaNmKyoyou = YuyuBizConfig.getInstance().getKzmeigiKanaNmKyoyou();

        for (Integer errorCode : shkstkzinfkzinfoErrorList) {

            if (errorCode == CheckShiharaikinSiteiKouza.TEIKISIHARAIKINSHRTUUKA_MNRK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EBC0045,
                    new Item[] { DDID_UKETORIKOUZAINFO_KZSYURUIKBN },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_KZSYURUIKBN.getErrorResourceKey()));
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.BANKCD_MNRK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1143,
                    new Item[] { DDID_UKETORIKOUZAINFO_BANKCD },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_BANKCD.getErrorResourceKey()));
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.SITENCD_MNRK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1143,
                    new Item[] { DDID_UKETORIKOUZAINFO_SITENCD },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_SITENCD.getErrorResourceKey()));
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.BANKMASTER_SNZCHK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1144,
                    new Item[] { DDID_UKETORIKOUZAINFO_BANKCD, DDID_UKETORIKOUZAINFO_SITENCD },
                    uiBean.getBankcd(), uiBean.getSitencd());
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.BANKYUUKOU_HANTEICHK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1145,
                    new Item[] { DDID_UKETORIKOUZAINFO_BANKCD, DDID_UKETORIKOUZAINFO_SITENCD },
                    uiBean.getBankcd(), uiBean.getSitencd());
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.BANKYENSOUKIN_CHK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1147, new Item[] { DDID_UKETORIKOUZAINFO_SITENCD });
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.BANKGAIKASOUKIN_CHK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1148,
                    new Item[] { DDID_UKETORIKOUZAINFO_BANKCD, DDID_UKETORIKOUZAINFO_SITENCD });
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.YOKINSYUMOKU_MNRK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1143,
                    new Item[] { DDID_UKETORIKOUZAINFO_YOKINKBN },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_YOKINKBN.getErrorResourceKey()));
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.YOKINSYUMOKU_YUUTYOCHK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1149,
                    new Item[] { DDID_UKETORIKOUZAINFO_YOKINKBN }, uiBean.getBankcd());
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.KOUZANO_MNRK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1143,
                    new Item[] { DDID_UKETORIKOUZAINFO_KOUZANO },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_KOUZANO.getErrorResourceKey()));
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.KOUZANO_KYOKAMOJICHK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1150,
                    new Item[] { DDID_UKETORIKOUZAINFO_KOUZANO },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_KOUZANO.getErrorResourceKey()));
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.KOUZANO_KETASUUCHK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1151,
                    new Item[] { DDID_UKETORIKOUZAINFO_KOUZANO },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_KOUZANO.getErrorResourceKey()),
                    String.valueOf(YuyuBizConfig.getInstance().getYenkaKouzaKetasuu()));
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.KZMEIGINMKN_NRK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1152,
                    new Item[] { DDID_UKETORIKOUZAINFO_KZMEIGINMKN },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_KZMEIGINMKN.getErrorResourceKey()));
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.KZMEIGINMKN_MNRK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1143,
                    new Item[] { DDID_UKETORIKOUZAINFO_KZMEIGINMKN },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_KZMEIGINMKN.getErrorResourceKey()));
            }
            else if (errorCode == CheckShiharaikinSiteiKouza.KZMEIGINMKN_KYOKAMOJICHK_ERROR) {

                errorMessageCollector.addMessage(MessageId.EHC1150,
                    new Item[] { DDID_UKETORIKOUZAINFO_KZMEIGINMKN },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_KZMEIGINMKN.getErrorResourceKey()));
            }
            else if (!existFlg && errorCode == CheckShiharaikinSiteiKouza.KZMEIGINMKN_KETASUUCHK_ERROR &&
                C_KouzasyuruiKbn.YENKOUZA.eq(uiBean.getKzsyuruikbn())) {

                errorMessageCollector.addMessage(MessageId.EHC1153,
                    new Item[] { DDID_UKETORIKOUZAINFO_KZMEIGINMKN },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_KZMEIGINMKN.getErrorResourceKey()),
                    String.valueOf(kzmeigiKanaNmKyoyou));
            }
            else if (!existFlg && errorCode == CheckShiharaikinSiteiKouza.KZMEIGINMKN_KETASUUCHK_ERROR &&
                C_KouzasyuruiKbn.GAIKAKOUZA.eq(uiBean.getKzsyuruikbn())) {

                errorMessageCollector.addMessage(MessageId.EHC1154,
                    new Item[] { DDID_UKETORIKOUZAINFO_KZMEIGINMKN },
                    MessageUtil.getMessage(DDID_UKETORIKOUZAINFO_KZMEIGINMKN.getErrorResourceKey()),
                    String.valueOf(kzmeigiKanaNmKyoyou));
            }
        }

        if (errorMessageCollector.exists()) {
            errorMessageCollector.throwBizLogicException();
        }
    }

    private void checkKouhurikouzainfo() {

        BizDate netkouhuriServiceKaisiYmd = YuyuSinkeiyakuConfig.getInstance().getNetkouhuriServiceKaisiYmd();

        if (BizDateUtil.compareYmd(BizDate.getSysDate(), netkouhuriServiceKaisiYmd) != BizDateUtil.COMPARE_LESSER &&
            (E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn()) ||
                E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
                E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn()))) {

            if (C_MosUketukeKbn.PAPERLESS.eq(uiBean.getMosuketukekbn())) {
                if (C_KzhuritourokuhouKbn.BLNK.eq(uiBean.getKzhuritourokuhoukbn())) {

                    errorMessageCollector.addMessage(MessageId.EBC0045,
                        new Item[] { DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN },
                        MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN.getErrorResourceKey()));
                }
                if (BizDateUtil.compareYmd(uiBean.getMosymd(), netkouhuriServiceKaisiYmd) == BizDateUtil.COMPARE_LESSER &&
                    C_KzhuritourokuhouKbn.QR.eq(uiBean.getKzhuritourokuhoukbn())) {

                    String newNetkouhuriServiceKaisiYmd = new BizDateFormat(
                        "yyyy年MM月dd日", FillStyle.None).format(netkouhuriServiceKaisiYmd);

                    errorMessageCollector.addMessage(MessageId.EHA1095,
                        new Item[] { DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN },
                        "申込日が" + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, newNetkouhuriServiceKaisiYmd)
                        + "より前の場合、" +
                        MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN.getErrorResourceKey()),
                        uiBean.getKzhuritourokuhoukbn().getContent());
                }
            }
            if (!C_MosUketukeKbn.PAPERLESS.eq(uiBean.getMosuketukekbn()) &&
                !C_KzhuritourokuhouKbn.BLNK.eq(uiBean.getKzhuritourokuhoukbn())) {

                errorMessageCollector.addMessage(MessageId.EBA0108,
                    new Item[] { DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN },
                    MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KZHURITOUROKUHOUKBN.getErrorResourceKey()));
            }
        }

        if (C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getKouzainfoinputhoryuukbn())) {
            CheckKzhuriKouza checkKzhuriKouza = SWAKInjector.getInstance(CheckKzhuriKouza.class);

            String kyknmkn = null;

            if (C_KzkykdouKbn.DOUITU.eq(uiBean.getKouhurikouzainfokzdoukbn())) {

                if (C_KykKbn.KEIHI_DOUITU.eq(uiBean.getKykkbn())) {

                    kyknmkn = uiBean.getHhknnmkn();
                }
                else if (C_KykKbn.KEIHI_BETU.eq(uiBean.getKykkbn())) {

                    kyknmkn = uiBean.getKyknmkn();
                }
            }
            else {

                kyknmkn = "";
            }

            C_ErrorKbn errorKbn = checkKzhuriKouza.exec(
                uiBean.getKouhurikouzainfobankcd(),
                uiBean.getKouhurikouzainfositencd(),
                uiBean.getKouhurikouzainfoyokinkbn(),
                uiBean.getKouhurikouzainfokzdoukbn(),
                kyknmkn,
                uiBean.getKouhurikouzainfokzmeiginmkn(),
                uiBean.getKouhurikouzainfokouzano(),
                BizDate.getSysDate());

            List<Integer> kouhurikouzainfobtnErrorList = checkKzhuriKouza.getErrorCdlst();

            if (C_ErrorKbn.ERROR.eq(errorKbn) && kouhurikouzainfobtnErrorList.size() != 0) {

                boolean kzmeiginmkn_kyokamonjichk_error = false;

                for (Integer errorCode : kouhurikouzainfobtnErrorList) {

                    if (errorCode == CheckKzhuriKouza.BANKCD_NRK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1092,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOBANKCD },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOBANKCD.getErrorResourceKey()));
                    }
                    else if (errorCode == CheckKzhuriKouza.SITENCD_NRK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1092,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOSITENCD },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOSITENCD.getErrorResourceKey()));
                    }
                    else if (errorCode == CheckKzhuriKouza.BANKMASTER_SNZCHK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1094,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOBANKCD,
                            DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOSITENCD },
                            uiBean.getKouhurikouzainfobankcd(),
                            uiBean.getKouhurikouzainfositencd());
                    }
                    else if (errorCode == CheckKzhuriKouza.BANKYUUKOU_HANTEICHK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1077,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOBANKCD,
                            DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOSITENCD },
                            uiBean.getKouhurikouzainfobankcd(),
                            uiBean.getKouhurikouzainfositencd());
                    }
                    else if (errorCode == CheckKzhuriKouza.YOFURIKYOUTEI_CHK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1078,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOBANKCD,
                            DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOSITENCD },
                            uiBean.getKouhurikouzainfobankcd(),
                            uiBean.getKouhurikouzainfositencd());
                    }
                    else if (errorCode == CheckKzhuriKouza.BFRYOKIN_MINRYK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1092,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOYOKINKBN },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOYOKINKBN.getErrorResourceKey()));
                    }
                    else if (errorCode == CheckKzhuriKouza.BFRYOKIN_YUUTYOCHK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1098,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOYOKINKBN },
                            uiBean.getKouhurikouzainfobankcd());
                    }

                    else if (errorCode == CheckKzhuriKouza.KOUZANO_MNYRYK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1092,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKOUZANO },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKOUZANO.getErrorResourceKey()));
                    }
                    else if (errorCode == CheckKzhuriKouza.KOUZANO_KYOKAMONJICHK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1096,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKOUZANO },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKOUZANO.getErrorResourceKey()));
                    }
                    else if (errorCode == CheckKzhuriKouza.KOUZANO_KETASUCHK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1105,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKOUZANO },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKOUZANO.getErrorResourceKey()),
                            String.valueOf(YuyuBizConfig.getInstance().getYenkaKouzaKetasuu()));
                    }
                    else if (errorCode == CheckKzhuriKouza.KZMEIGINMK_NNYRYKU_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1093,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKZMEIGINMKN },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKZMEIGINMKN.getErrorResourceKey()));
                    }
                    else if (errorCode == CheckKzhuriKouza.KZMEIGINMKN_MNYRYKU_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1092,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKZMEIGINMKN },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKZMEIGINMKN.getErrorResourceKey()));
                    }
                    else if (errorCode == CheckKzhuriKouza.KZMEIGINMKN_KYOKAMONJICHK_ERROR) {

                        kzmeiginmkn_kyokamonjichk_error = true;

                        errorMessageCollector.addMessage(MessageId.EHC1096,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKZMEIGINMKN },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKZMEIGINMKN.getErrorResourceKey()));
                    }
                    else if (!kzmeiginmkn_kyokamonjichk_error && errorCode == CheckKzhuriKouza.KZMEIGINMKN_KETASUUCHK_ERROR) {

                        errorMessageCollector.addMessage(MessageId.EHC1106,
                            new Item[] { DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKZMEIGINMKN },
                            MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUHURIKOUZAINFOKZMEIGINMKN.getErrorResourceKey()),
                            String.valueOf(YuyuBizConfig.getInstance().getKzmeigiKanaNmKyoyou()));
                    }
                }
            }

            if (C_YouhiblnkKbn.BLNK.eq(uiBean.getKouzakakuniniraikbn())) {

                errorMessageCollector.addMessage(MessageId.EHC1092,
                    new Item[] { DDID_KOUHURIKOUZAINFO_KOUZAKAKUNINIRAIKBN },
                    MessageUtil.getMessage(DDID_KOUHURIKOUZAINFO_KOUZAKAKUNINIRAIKBN.getErrorResourceKey()));
            }

            if (C_YouhiblnkKbn.YOU.eq(uiBean.getKouzakakuniniraikbn()) &&
                IGkCommonKoumoku.BANKCD_YTGINKOU.equals(uiBean.getKouhurikouzainfobankcd())) {

                errorMessageCollector.addMessage(MessageId.EHC1107,
                    new Item[] { DDID_KOUHURIKOUZAINFO_KOUZAKAKUNINIRAIKBN });
            }

            if (E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn()) ||
                E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
                E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) {

                if (C_YouhiblnkKbn.YOU.eq(uiBean.getKouzakakuniniraikbn()) &&
                    C_KzhuritourokuhouKbn.QR.eq(uiBean.getKzhuritourokuhoukbn())) {

                    errorMessageCollector.addMessage(MessageId.EHC1134,
                        new Item[] { DDID_KOUHURIKOUZAINFO_KOUZAKAKUNINIRAIKBN },
                        uiBean.getKzhuritourokuhoukbn().getContent());
                }
            }
        }

        if (errorMessageCollector.exists()) {
            errorMessageCollector.throwBizLogicException();
        }
    }

    private boolean kouhurikouzainfoHantei(HT_KouzaJyouhou pKouzaJyouhou) {

        if (!uiBean.getKouhurikouzainfobankcd().equals(pKouzaJyouhou.getBankcd()) ||
            !uiBean.getKouhurikouzainfositencd().equals(pKouzaJyouhou.getSitencd()) ||
            !uiBean.getKouhurikouzainfoyokinkbn().eq(pKouzaJyouhou.getYokinkbn()) ||
            !uiBean.getKouhurikouzainfokouzano().equals(pKouzaJyouhou.getKouzano()) ||
            !uiBean.getKouhurikouzainfokzdoukbn().eq(pKouzaJyouhou.getKzkykdoukbn()) ||
            !uiBean.getNewkzmeiginmkn().equals(pKouzaJyouhou.getKzmeiginmkn())) {
            return true;
        }

        return false;
    }

    private boolean kouhurikouzainfoHanteiForCheck(HT_KouzaJyouhou pKouzaJyouhou) {

        if (!uiBean.getKouhurikouzainfobankcd().equals(pKouzaJyouhou.getBankcd()) ||
            !uiBean.getKouhurikouzainfositencd().equals(pKouzaJyouhou.getSitencd()) ||
            !uiBean.getKouhurikouzainfoyokinkbn().eq(pKouzaJyouhou.getYokinkbn()) ||
            !uiBean.getKouhurikouzainfokouzano().equals(pKouzaJyouhou.getKouzano()) ||
            !uiBean.getKouhurikouzainfokzdoukbn().eq(pKouzaJyouhou.getKzkykdoukbn()) ||
            !uiBean.getKouhurikouzainfokzmeiginmkn().equals(pKouzaJyouhou.getKzmeiginmkn())) {
            return true;
        }

        return false;
    }

    private boolean kouzakakuniniraikbnHantei(HT_KouzaJyouhou pKouzaJyouhou) {

        if (!uiBean.getKouzakakuniniraikbn().eq(pKouzaJyouhou.getKouzakakuniniraikbn())) {

            return true;
        }

        return false;
    }

    private void setMousikomiDispUmu() {

        C_UmuKbn mos2hyoujiumuKbn = C_UmuKbn.NONE;

        if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {

            HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(uiBean.getMosno());

            if (mosMikakuteiJyouhouKanri != null) {
                if (!BizUtil.isBlank(mosMikakuteiJyouhouKanri.getSetmosno1())) {
                    mos2hyoujiumuKbn = C_UmuKbn.ARI;
                    uiBean.setAitemosno(mosMikakuteiJyouhouKanri.getSetmosno1());
                }
            }
        }

        uiBean.setMos2hyoujiumuKbn(mos2hyoujiumuKbn);
    }

    private String checkSyukeiyakuHosyouInfo2(Item pKoumokuId, C_Tuukasyu pTuukasyu) {

        String message = MessageUtil.getMessage(pKoumokuId.getErrorResourceKey());
        if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
            if (C_Tuukasyu.USD.eq(pTuukasyu)) {
                message = SYUKEIYAKUHOSYOUINFO_BEI + message;
            }
        }
        return message;
    }

    private void checkMousikomiNo() {

        boolean checkFlg = MousikomiNoCheck.ifExistMousikomiNo(uiBean.getAitemosno());

        if (!checkFlg) {
            throw new BizLogicException(MessageId.EHA1078);
        }
    }

    private HT_SyoriCTL setMousikomiZouhaba(HT_SyoriCTL pSyoriCTL,
        GetSyouhnZokuseiCtrlOutBean pGetSyouhnZokuseiCtrlOutBean, String pUserID, String pSysTime, BizDate pSysDate,
        int pNrksaiumu) {

        Integer nkgnshosyouritu = 0;

        C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
        C_Sknenkinsyu sknenkinsyu = C_Sknenkinsyu.BLNK;
        C_UmuKbn teikisiharaikinumu = C_UmuKbn.NONE;

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getHengakuumu())) {
            nkgnshosyouritu = Integer.valueOf(uiBean.getNkgnshosyouritukbn().getValue());
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getSyksbyensitihsyutktekiumu())) {
            if (C_Tkhukaumu.HUKA.eq(uiBean.getSyksbyensitihsyutkhkkbn())) {
                syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
            }
        }

        if (C_UmuKbn.ARI.eq(pGetSyouhnZokuseiCtrlOutBean.getNkhknumu())) {
            sknenkinsyu = C_Sknenkinsyu.valueOf(uiBean.getNenkinsyumosinput());
        }

        if (C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn())) {
            teikisiharaikinumu = C_UmuKbn.ARI;
        }
        List<BM_SyouhnZokusei> syouhnZokuseiLst = new ArrayList<BM_SyouhnZokusei>();

        if (C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(uiBean.getHknsyuruino())
            || C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(uiBean.getHknsyuruino())) {

            Integer dai1hknkkn = 0;
            C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;
            if (pGetSyouhnZokuseiCtrlOutBean.getDai1HknkknSelect().size() != 0) {
                dai1hknkkn = Integer.valueOf(uiBean.getSyudai1hknkknmosinput());
            }

            if (!C_Tuukasyu.BLNK.eq(pGetSyouhnZokuseiCtrlOutBean.getTuukasyu())) {
                tuukasyu = uiBean.getKyktuukasyu2();
            }
            syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(
                BizDate.getSysDate(), C_SyutkKbn.SYU, uiBean.getDaihyouHknSyuruiNo(), nkgnshosyouritu, dai1hknkkn,
                tuukasyu, syksbyensitihsyutktekiumu, sknenkinsyu, teikisiharaikinumu);
        }
        else {
            syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems2(
                BizDate.getSysDate(), C_SyutkKbn.SYU, uiBean.getDaihyouHknSyuruiNo(), nkgnshosyouritu,
                syksbyensitihsyutktekiumu, sknenkinsyu, teikisiharaikinumu);
        }

        if (syouhnZokuseiLst.size() == 0) {
            throw new BizLogicException(MessageId.EHA1060, "商品情報", "商品");
        }

        BM_SyouhnZokusei syouhnZokusei2 = syouhnZokuseiLst.get(0);

        syouhnZokusei2.detach();

        uiBean.setSyouhnZokusei(syouhnZokusei2);

        HT_SyoriCTL newSyoriCTL2 = new HT_SyoriCTL(uiBean.getAitemosno());
        newSyoriCTL2 = BizEntityUtil.copyEntity(pSyoriCTL);

        clearSyoriCTL(newSyoriCTL2);

        newSyoriCTL2.setMosno(uiBean.getAitemosno());
        newSyoriCTL2.setKetteikbn(C_KetteiKbn.NONE);
        newSyoriCTL2.setSeiritukbn(C_SeirituKbn.NONE);
        newSyoriCTL2.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
        newSyoriCTL2.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SONOTA_MINYUUKIN);

        try {
            SyoukenNoUtil syoukenNoUtil = SWAKInjector.getInstance(SyoukenNoUtil.class);
            String syoNo = syoukenNoUtil.getShokenNo(uiBean.getAitemosno(), null, pUserID);
            newSyoriCTL2.setSyono(syoNo);
        } catch (CommonBizAppException ex) {
            throw new BizLogicException(MessageId.EHF1013);
        }

        newSyoriCTL2.setGyoumuKousinsyaId(pUserID);
        newSyoriCTL2.setGyoumuKousinTime(pSysTime);

        if (pSyoriCTL.getMosKihon() != null) {

            HT_MosKihon mosKihon = newSyoriCTL2.createMosKihon();

            setMosKihonFromUiBean(mosKihon, pUserID, pSysTime, true);
        }

        if (pSyoriCTL.getMosSyouhns() != null && pSyoriCTL.getMosSyouhns().size() > 0) {
            setMosSyouhnFromUiBean(newSyoriCTL2, pUserID, pSysTime, true);
        }

        if (pSyoriCTL.getUketorinins() != null && pSyoriCTL.getUketorinins().size() > 0) {
            setUketorininFromUiBean(newSyoriCTL2, pUserID, pSysTime, true);
        }

        if (pSyoriCTL.getMosTrkKzks() != null && pSyoriCTL.getMosTrkKzks().size() > 0) {
            setMosTrkKzkFromUiBean(newSyoriCTL2, pUserID, pSysTime, true);
        }

        if (pSyoriCTL.getMosDairitens() != null && pSyoriCTL.getMosDairitens().size() > 0) {
            setMosDairitenFromUiBean(newSyoriCTL2, pUserID, pSysTime, true);
        }

        if (pSyoriCTL.getKouzaJyouhou() != null) {
            setKouzaJyouhouFromUiBean(newSyoriCTL2, pUserID, pSysDate, pSysTime, pNrksaiumu, pSyoriCTL.getKouzaJyouhou(),true);
        }

        if (pSyoriCTL.getUketoriKouzaJyouhous() != null && pSyoriCTL.getUketoriKouzaJyouhous().size() > 0) {

            List<HT_UketoriKouzaJyouhou> uketoriKouzaJyouhouLst = pSyoriCTL.getUketoriKouzaJyouhous();
            HT_UketoriKouzaJyouhou uketoriKouzaJyouhoutaihi = null;

            for (int i = 0; i < uketoriKouzaJyouhouLst.size(); i++) {
                if (C_UketorikouzasyubetuKbn.DSSOUKINYOUKOUZA.eq(uketoriKouzaJyouhouLst.get(i).getUktkzsyubetukbn())) {
                    uketoriKouzaJyouhoutaihi = ObjectUtil.deepCopy(uketoriKouzaJyouhouLst.get(i));
                }
            }

            uketoriKouzaJyouhouLst.clear();
            sinkeiyakuDomManager.flush();

            if (C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn())) {
                setUketoriKouzaJyouhouFromUiBean(newSyoriCTL2, pUserID, pSysTime, true);
            }

            if (uketoriKouzaJyouhoutaihi != null) {

                uketoriKouzaJyouhoutaihi.setMosno(uiBean.getAitemosno());

                BizPropertyInitializer.initialize(uketoriKouzaJyouhoutaihi);
                newSyoriCTL2.getUketoriKouzaJyouhous().add(uketoriKouzaJyouhoutaihi);
            }
        }

        if (!uiBean.isTaihyoumousikomiUmu()) {

            SetMossykykyoteiymd setMossykykyoteiymd = SWAKInjector.getInstance(SetMossykykyoteiymd.class);
            HT_MosnoKanri mosnoKanri = setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(pSyoriCTL,
                BizDate.getSysDate(), baseUserInfo.getUserId());

            sinkeiyakuDomManager.update(mosnoKanri);
        }

        BizPropertyInitializer.initialize(newSyoriCTL2);

        return newSyoriCTL2;
    }

    private void mosnaiCheck(HT_SyoriCTL pSyoriCTL, MosnaiCheckParam pMosnaiCheckParam, String pKouteikanriId,
        boolean pKikenZou, BizDate pSysDate, String pUserID, String pSysTime) {
        if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn())) {
            if (uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAINASI) {
                pMosnaiCheckParam.getDataSyoriControl().setMosnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
                pMosnaiCheckParam.getDataSyoriControl().setMosnrkumu(C_UmuKbn.ARI);
                pMosnaiCheckParam.getDataSyoriControl().setMosnrkymd(pSysDate);

                pMosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
            }
        }
        else if (E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
            pMosnaiCheckParam.getDataSyoriControl().setMosnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
            pMosnaiCheckParam.getDataSyoriControl().setMosnrkumu(C_UmuKbn.ARI);
            pMosnaiCheckParam.getDataSyoriControl().setMosnrkymd(pSysDate);

            pMosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        }

        pMosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);

        if (pKikenZou) {
            pMosnaiCheckParam.setKetteiSijiKbn(C_HandketsijiKbn.KIKENZOU_HENKOU_ARI);
        }
        else {
            pMosnaiCheckParam.setKetteiSijiKbn(C_HandketsijiKbn.HUYOU);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(pKouteikanriId);

        if (gyoumuKouteiInfo == null) {
            throw new CommonBizAppException("申込番号=" + pSyoriCTL.getMosno());
        }

        pMosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        pMosnaiCheckParam.setKinouID(kinou.getKinouId());
        pMosnaiCheckParam.setSysDate(pSysDate);
        pMosnaiCheckParam.setKosID(pUserID);
        pMosnaiCheckParam.setKosTime(pSysTime);
        pMosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        pMosnaiCheckParam.debug("申込書入力");

        mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
        mosnaiCheck.exec(pMosnaiCheckParam);

        uiBean.setKykymd(pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getKykymd());
        uiBean.setSknnkaisiymd(pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getSknnkaisiymd());
        uiBean.setBosyuuym(pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getBosyuuym());
        uiBean.setSeisekiym(pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getSeisekiym());
        uiBean.setHhknnen(pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getHhknnen());
        uiBean.setKyknen(pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getKyknen());
        uiBean.setNrksaiumu(uiBean.getNrksaiumu());
        uiBean.setDairitenbuntanwariai1(zeroToOptional(
            pMosnaiCheckParam.getDataSyoriControl().getMosDairitens().get(0).getBunwari()));
        if (pMosnaiCheckParam.getDataSyoriControl().getMosDairitens().size() > 1) {
            uiBean.setDairitenbuntanwariai2(zeroToOptional(
                pMosnaiCheckParam.getDataSyoriControl().getMosDairitens().get(1).getBunwari()));
        }

        if (pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getZnnkai() > 0) {
            uiBean.setZnnkai(pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getZnnkai() + 1);
        }
        else {
            uiBean.setZnnkai(pMosnaiCheckParam.getDataSyoriControl().getMosKihon().getZnnkai());
        }

        if(pMosnaiCheckParam.getListSkDenpyoData().size() > 0){
            sinkeiyakuDomManager.insert(pMosnaiCheckParam.getListSkDenpyoData());
        }
    }

    private void setMessage(MosnaiCheckParam pMosnaiCheckParam, StringBuffer pResultBtnMessage) {

        List<String> listKekkaGmnMsg = mosnaiCheckParam.getListKekkaGmnMsg();

        List<Message> messageLst = messageMgr.getMessages();
        if (messageLst.size() == 0) {
            pResultBtnMessage.append(MessageUtil.getMessage(MessageId.IAC0009));
        }

        for (int i = 0; i < listKekkaGmnMsg.size(); i++) {
            pResultBtnMessage.append(KAIGYOU);
            pResultBtnMessage.append(listKekkaGmnMsg.get(i));
        }

        messageMgr.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), pResultBtnMessage.toString());
    }

    private void setHubiMessage(String pMousikomiNo, boolean pUniqueFlg) {
        List<String> hubiMsgLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(pMousikomiNo);

        skHubiMsgRenkeiInfo.setMosno(pMousikomiNo);
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgLst);

        String uniqueId = objStrMan.save(skHubiMsgRenkeiInfo);

        if (pUniqueFlg) {
            uiBean.setHubimsgData2(hubiMsgLst.toArray(new String[0]));
            uiBean.setUniqueid2(uniqueId);
        }
        else {
            uiBean.setHubimsgData(hubiMsgLst.toArray(new String[0]));
            uiBean.setUniqueId(uniqueId);
        }
    }

    private void skProcessUpdate(HT_SyoriCTL pSyoriCTL, String pKkouteiLockKey, boolean pAitemoFlg) {
        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        if (pAitemoFlg) {
            skProcessUpdate.exec(pSyoriCTL, pKkouteiLockKey, null);
        }
        else {
            if (E_SyoriKbn.MOUSIKOMISYO_1JI.equals(uiBean.getSyoriKbn())) {

                TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);

                tuikaParamInputBean.setSkeijimukbn(pSyoriCTL.getSkeijimukbn());
                tuikaParamInputBean.setMosuketukekbn(pSyoriCTL.getMosuketukekbn());
                tuikaParamInputBean.setHknsyuruiNo(pSyoriCTL.getMosKihonVrf().getHknsyuruino());
                tuikaParamInputBean.setDairitencd1(pSyoriCTL.getMosDairitenVrfByRenno(1).getOyadrtencd());
                if (pSyoriCTL.getMosDairitenVrfByRenno(2) != null) {
                    tuikaParamInputBean.setDairitencd2(pSyoriCTL.getMosDairitenVrfByRenno(2).getOyadrtencd());
                }
                tuikaParamInputBean.setKoDairitenTaisyouKbn(null);
                tuikaParamInputBean.setJimuyoucd(pSyoriCTL.getMosKihonVrf().getJimuyoucd());
                tuikaParamInputBean.setJmycdMisetteiKbn(null);
                tuikaParamInputBean.setDoujimosumu(pSyoriCTL.getDoujimosumu());
                tuikaParamInputBean.setMosymd(pSyoriCTL.getMosKihonVrf().getMosymd());
                tuikaParamInputBean.setJimustartymd(null);
                tuikaParamInputBean.setSyono(pSyoriCTL.getSyono());
                tuikaParamInputBean.setNksysyno(null);
                tuikaParamInputBean.setMosno(pSyoriCTL.getMosno());
                tuikaParamInputBean.setKetteiKbn(pSyoriCTL.getKetteikbn());
                tuikaParamInputBean.setSeirituKbn(pSyoriCTL.getSeiritukbn());
                tuikaParamInputBean.setLincjkKbn(pSyoriCTL.getLincjkkbn());

                skProcessUpdate.exec(tuikaParamInputBean, pKkouteiLockKey, null);
            }
            else {
                skProcessUpdate.exec(pSyoriCTL, pKkouteiLockKey, null);
            }
        }
    }

    private void skProcessForward(String pMosNo, boolean pAitemoFlg) {

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        SkProcessForwardMousikomisyoNyuuryoku skProcessForwardMousikomisyoNyuuryoku =
            SWAKInjector.getInstance(SkProcessForwardMousikomisyoNyuuryoku.class);
        if (pAitemoFlg) {
            skProcessForwardInBean.setMosNo(pMosNo);
            skProcessForwardInBean.setTskNm(uiBean.getVktifdisptasknm());
            skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
            skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
            skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);
        }
        else {
            if (!E_SyoriKbn.SYORI_UPD_SYOUKAI.equals(uiBean.getSyoriKbn())) {
                skProcessForwardInBean.setMosNo(pMosNo);
                skProcessForwardInBean.setTskNm(uiBean.getVktifdisptasknm());
                skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
                skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);

                skProcessForwardMousikomisyoNyuuryoku.exec(skProcessForwardInBean);
            }
            else {
                throw new IntentionalRollbackException();
            }
        }
    }

    private void dbUpdateTableCommit(HT_SyoriCTL pSyoriCTL, HT_SyoriCTL pSyoriCTL2,
        BT_GyoumuKouteiInfo pGyoumuKouteiInfo, BT_GyoumuKouteiInfo pGyoumuKouteiInfo2, String pUserID, String pSysTime) {

        if (uiBean.isTaihyoumousikomiUmu()) {
            pSyoriCTL.setGyoumuKousinsyaId(pUserID);
            pSyoriCTL.setGyoumuKousinTime(pSysTime);
        }

        if (uiBean.isAiteimousikomiUmu()) {
            pSyoriCTL2.setGyoumuKousinsyaId(pUserID);
            pSyoriCTL2.setGyoumuKousinTime(pSysTime);
        }


        if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
            uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAIARI) {
            sinkeiyakuDomManager.update(pSyoriCTL);
        }

        if ((E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
            uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAINASI) ||
            E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
            if (uiBean.isTaihyoumousikomiUmu()) {
                sinkeiyakuDomManager.update(pSyoriCTL);
                bizDomManager.update(pGyoumuKouteiInfo);
            }

            if (uiBean.isAiteimousikomiUmu()) {
                sinkeiyakuDomManager.insert(pSyoriCTL2);
                bizDomManager.insert(pGyoumuKouteiInfo2);
            }
        }
    }

    private void setKykNaiyouHanei(HT_SyoriCTL pSyoriCTL, HT_SyoriCTL pSyoriCTL2) {

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        if (E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn()) ||
            E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn())) {

            boolean checkFlg = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(
                pSyoriCTL, uiBean.getSkIdounaiyouBeforeBean());

            if (checkFlg) {
                SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(pSyoriCTL);

                if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                    errorMessageCollector.clear();

                    for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {
                        errorMessageCollector.addMessage(errorMsg);
                    }

                    unlockFlg = false;
                    errorMessageCollector.throwBizLogicException();
                }
            }
        }

        if ((E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
            uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAINASI) ||
            E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {

            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = SWAKInjector.getInstance(SkIdounaiyouKekkaBean.class);

            if (uiBean.isTaihyoumousikomiUmu()) {
                skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(pSyoriCTL);

                if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                    errorMessageCollector.clear();

                    for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {

                        if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {

                            if (MessageId.EBA1020.equals(errorMsg)) {
                                errorMessageCollector.addMessage(MessageId.EHA1075, uiBean.getMosno());
                            }
                            else if (MessageId.EBA1021.equals(errorMsg)) {
                                errorMessageCollector.addMessage(MessageId.EHA1076, uiBean.getMosno());
                            }

                            else if (MessageId.EBA1022.equals(errorMsg)) {
                                errorMessageCollector.addMessage(MessageId.EHA1077, uiBean.getMosno());
                            }

                        }
                        else {
                            errorMessageCollector.addMessage(errorMsg);
                        }
                    }
                    unlockFlg = false;
                    errorMessageCollector.throwBizLogicException();
                }
            }

            if (uiBean.isAiteimousikomiUmu()) {
                SkIdounaiyouKekkaBean skIdounaiyouKekkaBean2 = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(pSyoriCTL2);

                if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean2.getErrorKbn())) {

                    if (!uiBean.isTaihyoumousikomiUmu()) {
                        errorMessageCollector.clear();

                        for (String errorMsg : skIdounaiyouKekkaBean2.getErrorMsgLst()) {
                            if (C_UmuKbn.ARI.eq(uiBean.getMos2hyoujiumuKbn())) {
                                if (MessageId.EBA1020.equals(errorMsg)) {
                                    errorMessageCollector.addMessage(MessageId.EHA1075, uiBean.getAitemosno());
                                }
                                else if (MessageId.EBA1021.equals(errorMsg)) {
                                    errorMessageCollector.addMessage(MessageId.EHA1076, uiBean.getAitemosno());
                                }
                                else if (MessageId.EBA1022.equals(errorMsg)) {
                                    errorMessageCollector.addMessage(MessageId.EHA1077, uiBean.getAitemosno());
                                }
                            }
                            else {
                                errorMessageCollector.addMessage(errorMsg);
                            }
                        }
                    }
                    else {

                        BzTrksIraiKekkaBean bzTrksIraiKekkaBean = SWAKInjector.getInstance(BzTrksIraiKekkaBean.class);
                        BzTrksIraiMq bzTrksIraiMq = SWAKInjector.getInstance(BzTrksIraiMq.class);
                        BzTrksIraiYokenBean bzTrksIraiYokenBean = SWAKInjector.getInstance(BzTrksIraiYokenBean.class);

                        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
                        bzTrksIraiYokenBean.setHuho2kykno(uiBean.getMosno());
                        bzTrksIraiYokenBean.setYoukyuuno(skIdounaiyouKekkaBean.getYoukyuuno());
                        bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn.SYORIOK);

                        bzTrksIraiKekkaBean = bzTrksIraiMq.exec(bzTrksIraiYokenBean);

                        if (C_JdTrksPalTrksZanKbn.ARI.eq(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn())) {
                            errorMessageCollector.addMessage(MessageId.EHA1076, uiBean.getMosno());
                        }
                        else if (C_JdTrksPalTrksZanKbn.KANOUSEIARI.eq(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn())) {
                            errorMessageCollector.addMessage(MessageId.EHA1077, uiBean.getMosno());
                        }

                        for (String errorMsg : skIdounaiyouKekkaBean2.getErrorMsgLst()) {

                            if (MessageId.EBA1020.equals(errorMsg)) {
                                errorMessageCollector.addMessage(MessageId.EHA1075, uiBean.getAitemosno());
                            }
                            else if (MessageId.EBA1021.equals(errorMsg)) {
                                errorMessageCollector.addMessage(MessageId.EHA1076, uiBean.getAitemosno());
                            }
                            else if (MessageId.EBA1022.equals(errorMsg)) {
                                errorMessageCollector.addMessage(MessageId.EHA1077, uiBean.getAitemosno());
                            }
                        }
                    }

                    unlockFlg = false;
                    errorMessageCollector.throwBizLogicException();
                }
            }
        }
    }

    private void setMosSyouhnFromUiBean(HT_SyoriCTL pSyoriCTL, String pUserID, String pSysTime, boolean pAitemoFlg) {

        HT_MosSyouhn mosSyouhn = pSyoriCTL.createMosSyouhn();
        GetSyouhnZokuseiCtrlOutBean getSyouhnZokuseiCtrlOutBean = getGamenCtrlBean();

        if (pAitemoFlg) {
            mosSyouhn.setMosno(uiBean.getAitemosno());
        }
        else {
            mosSyouhn.setMosno(uiBean.getMosno());
        }

        mosSyouhn.setSyouhncd(uiBean.getSyouhnZokusei().getSyouhncd());
        mosSyouhn.setSyouhnsdno(0);
        mosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);

        if (!BizUtil.isBlank(uiBean.getNenkinsyumosinput())) {
            mosSyouhn.setSknenkinsyu(C_Sknenkinsyu.valueOf(uiBean.getNenkinsyumosinput()));
        }

        if (pAitemoFlg) {
            mosSyouhn.setKihons(uiBean.getKihons2());
            mosSyouhn.setHrktuukasyutkp(uiBean.getHrktuukasyukykp2());
        }
        else {
            mosSyouhn.setKihons(uiBean.getSyukihons());
            if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(getSyouhnZokuseiCtrlOutBean.getPtratkituukasiteikbn())) {
                mosSyouhn.setHrktuukasyutkp(uiBean.getMossyukykp());
            }
            else {
                mosSyouhn.setHrktuukasyutkp(uiBean.getHrktuukasyukykp());
            }
        }

        if (C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getNkhknumu()) &&
            C_UmuKbn.ARI.eq(getSyouhnZokuseiCtrlOutBean.getItijibrumu())) {

            mosSyouhn.setHknkkn(Integer.parseInt(uiBean.getSueokikknmosinput()));
        }
        else {

            mosSyouhn.setHknkkn(uiBean.getSyuhknkkn());
        }
        mosSyouhn.setHrkkkn(uiBean.getSyuhrkkkn());
        mosSyouhn.setHknkknsmnkbn(uiBean.getSyuhknkknsmnkbn());
        mosSyouhn.setHrkkknsmnkbn(uiBean.getSyuhrkkknsmnkbn());
        if (BizUtil.isBlank(uiBean.getSyudai1hknkknmosinput())) {
            mosSyouhn.setDai1hknkkn(0);
        }
        else {
            mosSyouhn.setDai1hknkkn(Integer.parseInt(uiBean.getSyudai1hknkknmosinput()));
        }

        if (!pAitemoFlg) {
            if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
                uiBean.getNrksaiumu() == SaiDataTouroku.NRKSAIARI) {
                mosSyouhn.setKihons2(uiBean.getKihons2());
                mosSyouhn.setHrktuukasyutkp2(uiBean.getHrktuukasyukykp2());
            }
        }

        mosSyouhn.setGyoumuKousinsyaId(pUserID);
        mosSyouhn.setGyoumuKousinTime(pSysTime);
        BizPropertyInitializer.initialize(mosSyouhn);
    }

    private void setUketorininFromUiBean(HT_SyoriCTL pSyoriCTL, String pUserID, String pSysTime, boolean pAitemoFlg) {

        int uketoriCnt = 0;
        if (C_Tkhukaumu.HUKA.eq(uiBean.getStdrsktkyhkkbn())) {
            uketoriCnt++;

            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();
            if (pAitemoFlg) {
                uketorinin.setMosno(uiBean.getAitemosno());
            }
            else {
                uketorinin.setMosno(uiBean.getMosno());
            }
            uketorinin.setUktsyukbn(C_UktsyuKbn.STDRSK);
            uketorinin.setUktsyurenno(UKTSYURENNO_BEGIN);
            uketorinin.setUktkbn(uiBean.getStdruktkbn());
            uketorinin.setUktnmkn(uiBean.getSiteidruktnmkn());
            uketorinin.setUktnmkj(uiBean.getSiteidruktnmkj());
            uketorinin.setUktnmkjkhukakbn(uiBean.getStdrsknmkjhukakbn());
            uketorinin.setUkttdk(uiBean.getStdrsktdk());
            uketorinin.setUktbnwari(UKTBNWARI_100);
            uketorinin.setUktseiymd(uiBean.getStdrskseiymd());

            uketorinin.setGyoumuKousinsyaId(pUserID);
            uketorinin.setGyoumuKousinTime(pSysTime);
            BizPropertyInitializer.initialize(uketorinin);
        }

        List<C_UktKbn> sbuktKbnLst = Lists.newArrayList();
        sbuktKbnLst.add(uiBean.getSbuktkbn1());
        sbuktKbnLst.add(uiBean.getSbuktkbn2());
        sbuktKbnLst.add(uiBean.getSbuktkbn3());
        sbuktKbnLst.add(uiBean.getSbuktkbn4());
        List<String> sbuktnmknLst = Lists.newArrayList();
        sbuktnmknLst.add(uiBean.getSbuktnmkn1());
        sbuktnmknLst.add(uiBean.getSbuktnmkn2());
        sbuktnmknLst.add(uiBean.getSbuktnmkn3());
        sbuktnmknLst.add(uiBean.getSbuktnmkn4());
        List<String> sbuktnmkjLst = Lists.newArrayList();
        sbuktnmkjLst.add(uiBean.getSbuktnmkj1());
        sbuktnmkjLst.add(uiBean.getSbuktnmkj2());
        sbuktnmkjLst.add(uiBean.getSbuktnmkj3());
        sbuktnmkjLst.add(uiBean.getSbuktnmkj4());
        List<C_KjkhukaKbn> sbuktnmkjhukakbnLst = Lists.newArrayList();
        sbuktnmkjhukakbnLst.add(uiBean.getSbuktnmkjhukakbn1());
        sbuktnmkjhukakbnLst.add(uiBean.getSbuktnmkjhukakbn2());
        sbuktnmkjhukakbnLst.add(uiBean.getSbuktnmkjhukakbn3());
        sbuktnmkjhukakbnLst.add(uiBean.getSbuktnmkjhukakbn4());
        List<BizDate> sbuktseiymdLst = Lists.newArrayList();
        sbuktseiymdLst.add(uiBean.getSbuktseiymd1());
        sbuktseiymdLst.add(uiBean.getSbuktseiymd2());
        sbuktseiymdLst.add(uiBean.getSbuktseiymd3());
        sbuktseiymdLst.add(uiBean.getSbuktseiymd4());
        List<C_Tdk> sbukttdkLst = Lists.newArrayList();
        sbukttdkLst.add(uiBean.getSbukttdk1());
        sbukttdkLst.add(uiBean.getSbukttdk2());
        sbukttdkLst.add(uiBean.getSbukttdk3());
        sbukttdkLst.add(uiBean.getSbukttdk4());
        List<BizNumber> sbuktbnwariLst = Lists.newArrayList();
        sbuktbnwariLst.add(uiBean.getSbuktbnwari1());
        sbuktbnwariLst.add(uiBean.getSbuktbnwari2());
        sbuktbnwariLst.add(uiBean.getSbuktbnwari3());
        sbuktbnwariLst.add(uiBean.getSbuktbnwari4());

        uketoriCnt = 1;

        for (int index = 0; index < MAX_UKT_SIBOU; index++) {
            if (!C_UktKbn.BLNK.eq(sbuktKbnLst.get(index))) {
                HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();
                if (pAitemoFlg) {
                    uketorinin.setMosno(uiBean.getAitemosno());
                }
                else {
                    uketorinin.setMosno(uiBean.getMosno());
                }
                uketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);
                uketorinin.setUktsyurenno(uketoriCnt);
                uketorinin.setUktkbn(sbuktKbnLst.get(index));
                uketorinin.setUktnmkn(sbuktnmknLst.get(index));
                uketorinin.setUktnmkj(sbuktnmkjLst.get(index));
                uketorinin.setUktnmkjkhukakbn(sbuktnmkjhukakbnLst.get(index));
                uketorinin.setUkttdk(sbukttdkLst.get(index));
                uketorinin.setUktbnwari(sbuktbnwariLst.get(index));
                uketorinin.setUktseiymd(sbuktseiymdLst.get(index));
                uketorinin.setGyoumuKousinsyaId(pUserID);
                uketorinin.setGyoumuKousinTime(pSysTime);
                BizPropertyInitializer.initialize(uketorinin);

                uketoriCnt++;
            }
        }

        if (!C_UktKbn.BLNK.eq(uiBean.getNenkinuktkbn())) {
            uketoriCnt++;

            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();
            if (pAitemoFlg) {
                uketorinin.setMosno(uiBean.getAitemosno());
            }
            else {
                uketorinin.setMosno(uiBean.getMosno());
            }
            uketorinin.setUktsyukbn(C_UktsyuKbn.NKUKT);
            uketorinin.setUktsyurenno(UKTSYURENNO_BEGIN);
            uketorinin.setUktkbn(uiBean.getNenkinuktkbn());
            uketorinin.setUktbnwari(UKTBNWARI_100);
            uketorinin.setGyoumuKousinsyaId(pUserID);
            uketorinin.setGyoumuKousinTime(pSysTime);
            BizPropertyInitializer.initialize(uketorinin);
        }

        if (C_Tkhukaumu.HUKA.eq(uiBean.getKykdrtkykhukakbn())) {

            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();

            if (pAitemoFlg) {
                uketorinin.setMosno(uiBean.getAitemosno());
            }
            else {
                uketorinin.setMosno(uiBean.getMosno());
            }
            uketorinin.setUktsyukbn(C_UktsyuKbn.KYKDRN);
            uketorinin.setUktsyurenno(UKTSYURENNO_BEGIN);
            uketorinin.setUktkbn(uiBean.getKykdrkbn());
            uketorinin.setUktbnwari(UKTBNWARI_100);
            uketorinin.setGyoumuKousinsyaId(pUserID);
            uketorinin.setGyoumuKousinTime(pSysTime);
            BizPropertyInitializer.initialize(uketorinin);
        }

        if (C_Tkhukaumu.HUKA.eq(uiBean.getTeikisiharaitkykhkkbn())) {

            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();
            if (pAitemoFlg) {
                uketorinin.setMosno(uiBean.getAitemosno());
            }
            else {
                uketorinin.setMosno(uiBean.getMosno());
            }
            uketorinin.setUktsyukbn(C_UktsyuKbn.TKSHKUKT);
            uketorinin.setUktsyurenno(UKTSYURENNO_BEGIN);
            uketorinin.setUktkbn(C_UktKbn.KYK);
            uketorinin.setUktbnwari(UKTBNWARI_100);
            uketorinin.setGyoumuKousinsyaId(pUserID);
            uketorinin.setGyoumuKousinTime(pSysTime);
            BizPropertyInitializer.initialize(uketorinin);
        }
    }

    private void setMosTrkKzkFromUiBean(HT_SyoriCTL pSyoriCTL, String pUserID, String pSysTime, boolean pAitemoFlg) {

        if (!BizUtil.isBlank(uiBean.getTrkkzknmkn1())) {

            HT_MosTrkKzk mosTrkKzk = pSyoriCTL.createMosTrkKzk();

            if (pAitemoFlg) {
                mosTrkKzk.setMosno(uiBean.getAitemosno());
            }
            else {
                mosTrkKzk.setMosno(uiBean.getMosno());
            }
            mosTrkKzk.setTrkkzkkbn(C_TrkKzkKbn.TRKKZK1);
            mosTrkKzk.setTrkkzknmkn(uiBean.getTrkkzknmkn1());
            mosTrkKzk.setTrkkzknmkj(uiBean.getTrkkzknmkj1());
            mosTrkKzk.setTrkkzknmkjkhukakbn(uiBean.getTrkkzknmkjkhukakbn1());
            mosTrkKzk.setTrkkzkseiymd(uiBean.getTrkkzkseiymd1());
            mosTrkKzk.setTrkkzksei(uiBean.getTrkkzksei1());
            mosTrkKzk.setTrkkzktdk(uiBean.getTrkkzktdk1());
            mosTrkKzk.setTrkkzktsindousiteikbn(uiBean.getTrkkzktsindousiteikbn1());
            mosTrkKzk.setTrkkzkyno(uiBean.getTrkkzkyno1());
            mosTrkKzk.setTrkkzkadr1kj(uiBean.getTrkkzkadr1kj1());
            mosTrkKzk.setTrkkzkadr2kj(uiBean.getTrkkzkadr2kj1());
            mosTrkKzk.setTrkkzkadr3kj(uiBean.getTrkkzkadr3kj1());
            mosTrkKzk.setTrkkzktelno(uiBean.getTrkkzktelno1());
            mosTrkKzk.setGyoumuKousinsyaId(pUserID);
            mosTrkKzk.setGyoumuKousinTime(pSysTime);
            BizPropertyInitializer.initialize(mosTrkKzk);

            if (!BizUtil.isBlank(uiBean.getTrkkzknmkn2())) {

                HT_MosTrkKzk mosTrkKzk2 = pSyoriCTL.createMosTrkKzk();

                mosTrkKzk2.setTrkkzkkbn(C_TrkKzkKbn.TRKKZK2);
                mosTrkKzk2.setTrkkzknmkn(uiBean.getTrkkzknmkn2());
                mosTrkKzk2.setTrkkzknmkj(uiBean.getTrkkzknmkj2());
                mosTrkKzk2.setTrkkzknmkjkhukakbn(uiBean.getTrkkzknmkjkhukakbn2());
                mosTrkKzk2.setTrkkzkseiymd(uiBean.getTrkkzkseiymd2());
                mosTrkKzk2.setTrkkzksei(uiBean.getTrkkzksei2());
                mosTrkKzk2.setTrkkzktdk(uiBean.getTrkkzktdk2());
                mosTrkKzk2.setTrkkzktsindousiteikbn(uiBean.getTrkkzktsindousiteikbn2());
                mosTrkKzk2.setTrkkzkyno(uiBean.getTrkkzkyno2());
                mosTrkKzk2.setTrkkzkadr1kj(uiBean.getTrkkzkadr1kj2());
                mosTrkKzk2.setTrkkzkadr2kj(uiBean.getTrkkzkadr2kj2());
                mosTrkKzk2.setTrkkzkadr3kj(uiBean.getTrkkzkadr3kj2());
                mosTrkKzk2.setTrkkzktelno(uiBean.getTrkkzktelno2());
                mosTrkKzk2.setGyoumuKousinsyaId(pUserID);
                mosTrkKzk2.setGyoumuKousinTime(pSysTime);
                BizPropertyInitializer.initialize(mosTrkKzk2);
            }
        }
    }

    private void setMosDairitenFromUiBean(HT_SyoriCTL pSyoriCTL, String pUserID, String pSysTime, boolean pAitemoFlg) {
        List<String> drtenJimCdLst = Lists.newArrayList();
        drtenJimCdLst.add(uiBean.getDrtenjimcd1());
        drtenJimCdLst.add(uiBean.getDrtenjimcd2());
        List<String> bosyuuTrkNoLst = Lists.newArrayList();
        bosyuuTrkNoLst.add(uiBean.getBosyuunintourokuno1());
        bosyuuTrkNoLst.add(uiBean.getBosyuunintourokuno2());
        List<String> drtKinyuukikanCdLst = Lists.newArrayList();
        drtKinyuukikanCdLst.add(uiBean.getDairitenkinyuukikancd1());
        drtKinyuukikanCdLst.add(uiBean.getDairitenkinyuukikancd2());
        List<String> drtKinyuukikanSitenCdLst = Lists.newArrayList();
        drtKinyuukikanSitenCdLst.add(uiBean.getDairitenkinyuukikansitencd1());
        drtKinyuukikanSitenCdLst.add(uiBean.getDairitenkinyuukikansitencd2());
        List<String> drtTratkikouinCdLst = Lists.newArrayList();
        drtTratkikouinCdLst.add(uiBean.getDairitentoriatukaikouincd1());
        drtTratkikouinCdLst.add(uiBean.getDairitentoriatukaikouincd2());
        List<String> inputBosyuuCdLst = Lists.newArrayList();
        inputBosyuuCdLst.add(uiBean.getInputbosyuucd1());
        inputBosyuuCdLst.add(uiBean.getInputbosyuucd2());
        List<String> gyskkjsakiSosikiCdLst = Lists.newArrayList();
        gyskkjsakiSosikiCdLst.add(uiBean.getGyskkjsakisosikicd1());
        gyskkjsakiSosikiCdLst.add(uiBean.getGyskkjsakisosikicd2());
        List<BizNumber> drtBunwariLst = Lists.newArrayList();
        drtBunwariLst.add(uiBean.getDairitenbuntanwariai1());
        drtBunwariLst.add(uiBean.getDairitenbuntanwariai2());

        List<String> oyaDrtCdLst = Lists.newArrayList();
        oyaDrtCdLst.add(uiBean.getOyadairitencd1());
        oyaDrtCdLst.add(uiBean.getOyadairitencd2());
        List<String> toriatukaiDrtCdLst = Lists.newArrayList();
        toriatukaiDrtCdLst.add(uiBean.getToriatukaidairitencd1());
        toriatukaiDrtCdLst.add(uiBean.getToriatukaidairitencd2());
        List<String> bosyuuCdLst = Lists.newArrayList();
        bosyuuCdLst.add(uiBean.getBosyuucd1());
        bosyuuCdLst.add(uiBean.getBosyuucd2());

        int dairitenCnt = 0;

        for (int index = 0; index < MAX_DAIRITEN; index++) {

            CheckTblMosDairiten checkTblMosDairiten = SWAKInjector.getInstance(CheckTblMosDairiten.class);

            C_ErrorKbn errorKbn = checkTblMosDairiten.checkDirInfoPattern(drtKinyuukikanCdLst.get(index),
                drtKinyuukikanSitenCdLst.get(index), inputBosyuuCdLst.get(index), drtTratkikouinCdLst.get(index),
                drtenJimCdLst.get(index), bosyuuTrkNoLst.get(index), index + 1);

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                dairitenCnt++;

                HT_MosDairiten mosDairiten = pSyoriCTL.createMosDairiten();

                if (pAitemoFlg) {
                    mosDairiten.setMosno(uiBean.getAitemosno());
                }
                else {
                    mosDairiten.setMosno(uiBean.getMosno());
                }
                mosDairiten.setRenno(dairitenCnt);

                if (dairitenCnt == 1) {
                    mosDairiten.setBsyujoyadrtencd(uiBean.getInitBsyujoyadrtencd());
                }
                else {
                    mosDairiten.setBsyujoyadrtencd("");
                }

                mosDairiten.setKinyuucd(drtKinyuukikanCdLst.get(index));
                mosDairiten.setKinyuusitencd(drtKinyuukikanSitenCdLst.get(index));
                mosDairiten.setTratkiagcd(toriatukaiDrtCdLst.get(index));
                mosDairiten.setOyadrtencd(oyaDrtCdLst.get(index));
                mosDairiten.setJimusyocd(drtenJimCdLst.get(index));
                mosDairiten.setBosyuutrkno(bosyuuTrkNoLst.get(index));

                if (dairitenCnt == 1) {
                    mosDairiten.setCifcd(uiBean.getCifcd());
                }
                else {
                    mosDairiten.setCifcd("");
                }

                mosDairiten.setBosyuucd(bosyuuCdLst.get(index));
                mosDairiten.setInputbosyuucd(inputBosyuuCdLst.get(index));
                mosDairiten.setTratkikouinncd(drtTratkikouinCdLst.get(index));
                mosDairiten.setGyousekikeijyousakisosikicd(gyskkjsakiSosikiCdLst.get(index));
                mosDairiten.setBunwari(drtBunwariLst.get(index));
                mosDairiten.setGyoumuKousinsyaId(pUserID);
                mosDairiten.setGyoumuKousinTime(pSysTime);
                BizPropertyInitializer.initialize(mosDairiten);
            }
        }
    }

    private void setUketoriKouzaJyouhouFromUiBean(HT_SyoriCTL pSyoriCTL, String pUserID, String pSysTime,
        boolean pAitemoFlg) {

        HT_UketoriKouzaJyouhou uketoriKouzaJyouhou = pSyoriCTL.createUketoriKouzaJyouhou();

        uketoriKouzaJyouhou.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);
        uketoriKouzaJyouhou.setKouzainfoinputhoryuukbn(uiBean.getShkstkzinfkzinfoinputhrykbn());
        uketoriKouzaJyouhou.setKzsyuruikbn(uiBean.getKzsyuruikbn());
        uketoriKouzaJyouhou.setBankcd(uiBean.getBankcd());
        uketoriKouzaJyouhou.setSitencd(uiBean.getSitencd());
        uketoriKouzaJyouhou.setYokinkbn(uiBean.getYokinkbn());
        uketoriKouzaJyouhou.setKouzano(uiBean.getKouzano());
        uketoriKouzaJyouhou.setKzkykdoukbn(uiBean.getKzkykdoukbn());
        uketoriKouzaJyouhou.setKzmeiginmkn(uiBean.getShkstkzinfkzinfoNewkzmeiginmkn());
        uketoriKouzaJyouhou.setGyoumuKousinsyaId(pUserID);
        uketoriKouzaJyouhou.setGyoumuKousinTime(pSysTime);
        BizPropertyInitializer.initialize(uketoriKouzaJyouhou);
    }

    private void setKouzaJyouhouFromUiBean(HT_SyoriCTL pSyoriCTL, String pUserID, BizDate pSysDate, String pSysTime,
        int pNrksaiumu, HT_KouzaJyouhou pBeforeKouzaJyouhou, boolean pAitemoFlg) {

        HT_KouzaJyouhou kouzaJyouhou = pSyoriCTL.createKouzaJyouhou();

        kouzaJyouhou.setKzmeiginmkn(uiBean.getNewkzmeiginmkn());
        kouzaJyouhou.setKzkykdoukbn(uiBean.getKouhurikouzainfokzdoukbn());
        kouzaJyouhou.setBankcd(uiBean.getKouhurikouzainfobankcd());
        kouzaJyouhou.setSitencd(uiBean.getKouhurikouzainfositencd());
        kouzaJyouhou.setYokinkbn(uiBean.getKouhurikouzainfoyokinkbn());
        kouzaJyouhou.setKouzano(uiBean.getKouhurikouzainfokouzano());
        kouzaJyouhou.setSinkeizkkbn(C_SinkeizkKbn.SHINKI);

        if (C_KzhuritourokuhouKbn.QR.eq(uiBean.getKzhuritourokuhoukbn())) {

            kouzaJyouhou.setSyuudaikocd(C_Syuudaikocd.CSS);
        }
        else {

            kouzaJyouhou.setSyuudaikocd(C_Syuudaikocd.SIS);
        }

        if (C_KouzaInfoInputHoryuuKbn.BLNK.eq(uiBean.getKouzainfoinputhoryuukbn())) {
            kouzaJyouhou.setKouzakakuniniraikbn(uiBean.getKouzakakuniniraikbn());

            if (E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
                SaiDataTouroku.NRKSAINASI == pNrksaiumu) {
                if (C_YouhiblnkKbn.YOU.eq(uiBean.getKouzakakuniniraikbn())) {
                    kouzaJyouhou.setKouzakakuniniraiymd(pSysDate);
                }
            }
            else if (E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
                if (C_YouhiblnkKbn.YOU.eq(uiBean.getKouzakakuniniraikbn())) {
                    kouzaJyouhou.setKouzakakuniniraiymd(pSysDate);
                }
                else {
                    kouzaJyouhou.setKouzakakuniniraiymd(null);
                }
            }
            else if (E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
                E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn())) {
                if (kouzakakuniniraikbnHantei(pBeforeKouzaJyouhou)) {
                    if (C_YouhiblnkKbn.YOU.eq(uiBean.getKouzakakuniniraikbn())) {
                        kouzaJyouhou.setKouzakakuniniraiymd(pSysDate);
                    }
                    else if (C_YouhiblnkKbn.HUYOU.eq(uiBean.getKouzakakuniniraikbn())) {
                        kouzaJyouhou.setKouzakakuniniraiymd(null);
                    }
                }
                else {
                    if (kouhurikouzainfoHantei(pBeforeKouzaJyouhou)) {
                        if (C_YouhiblnkKbn.YOU.eq(uiBean.getKouzakakuniniraikbn())) {
                            kouzaJyouhou.setKouzakakuniniraiymd(pSysDate);
                        }
                        else if (C_YouhiblnkKbn.HUYOU.eq(uiBean.getKouzakakuniniraikbn())) {
                            kouzaJyouhou.setKouzakakuniniraiymd(null);
                        }
                    }
                    else {
                        kouzaJyouhou.setKouzakakuniniraiymd(pBeforeKouzaJyouhou.getKouzakakuniniraiymd());
                    }
                }
            }

            if ((E_SyoriKbn.MOUSIKOMISYO_2JI.equals(uiBean.getSyoriKbn()) &&
                SaiDataTouroku.NRKSAINASI == pNrksaiumu) ||
                E_SyoriKbn.MOUSIKOMISYO_3JI.equals(uiBean.getSyoriKbn())) {
                kouzaJyouhou.setKouzajyouhounyuuryokuymd(pSysDate);
            }
            else if (E_SyoriKbn.SYORI_UPD.equals(uiBean.getSyoriKbn()) ||
                E_SyoriKbn.SYORI_INPUT_UPD.equals(uiBean.getSyoriKbn())) {

                if (kouhurikouzainfoHantei(pBeforeKouzaJyouhou)) {

                    kouzaJyouhou.setKouzajyouhounyuuryokuymd(pSysDate);
                }
                else {
                    kouzaJyouhou.setKouzajyouhounyuuryokuymd(pBeforeKouzaJyouhou.getKouzajyouhounyuuryokuymd());
                }
            }
        }

        kouzaJyouhou.setKzhuritourokuhoukbn(uiBean.getKzhuritourokuhoukbn());

        kouzaJyouhou.setGyoumuKousinsyaId(pUserID);

        kouzaJyouhou.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(kouzaJyouhou);
    }

    private void setCreditCardJyouhouFromUiBean(HT_SyoriCTL pSyoriCTL, String pUserID, String pSysTime,
        E_CreditCardhnsyuKbn pCreditCardhnsyuKbn, boolean pAitemoFlg) {

        if (E_CreditCardhnsyuKbn.ADD.equals(pCreditCardhnsyuKbn)) {

            String creditkessaiyouNo = saibanCreditKessaiyouNo(pSyoriCTL.getMosno(), pAitemoFlg);

            HT_CreditCardJyouhou creditCardJyouhou = pSyoriCTL.createCreditCardJyouhou();

            if (pAitemoFlg) {
                creditCardJyouhou.setMosno(uiBean.getAitemosno());
            }
            else {
                creditCardJyouhou.setMosno(uiBean.getMosno());
            }
            creditCardJyouhou.setCreditkessaiyouno(creditkessaiyouNo);
            creditCardJyouhou.setCardbrandkbn(C_CardBrandKbn.BLNK);
            creditCardJyouhou.setCredittrkhoukbn(C_CreditTrkhouKbn.SYOMEN);
            creditCardJyouhou.setGyoumuKousinsyaId(pUserID);
            creditCardJyouhou.setGyoumuKousinTime(pSysTime);
            BizPropertyInitializer.initialize(creditCardJyouhou);
        }
        else if (E_CreditCardhnsyuKbn.ADD_INPUT_UPD.equals(pCreditCardhnsyuKbn)) {

            HT_CreditCardJyouhou creditCardJyouhou = pSyoriCTL.createCreditCardJyouhou();

            creditCardJyouhou.setMosno(uiBean.getMosno());
            creditCardJyouhou.setCreditkessaiyouno("");
            creditCardJyouhou.setCardbrandkbn(C_CardBrandKbn.BLNK);
            creditCardJyouhou.setCredittrkhoukbn(C_CreditTrkhouKbn.SYOMEN);
            creditCardJyouhou.setGyoumuKousinsyaId(pUserID);
            creditCardJyouhou.setGyoumuKousinTime(pSysTime);
            BizPropertyInitializer.initialize(creditCardJyouhou);
        }
        else if (E_CreditCardhnsyuKbn.ADD_PAPER_LESS.equals(pCreditCardhnsyuKbn)) {

            String creditkessaiyouNo = "";
            C_CreditTrkhouKbn creditTrkhouKbn = C_CreditTrkhouKbn.BLNK;

            if (C_PplessrendoucreditkousouKbn.ARI.eq(pSyoriCTL.getMosKihon().getPplessrendoucreditkousoukbn())) {

                creditkessaiyouNo = saibanCreditKessaiyouNo(uiBean.getMosno(), pAitemoFlg);
                creditTrkhouKbn = C_CreditTrkhouKbn.SYOMEN;
            }
            else {

                creditTrkhouKbn = C_CreditTrkhouKbn.QR;
            }

            HT_CreditCardJyouhou creditCardJyouhou = pSyoriCTL.createCreditCardJyouhou();

            creditCardJyouhou.setCreditkessaiyouno(creditkessaiyouNo);
            creditCardJyouhou.setCredittrkhoukbn(creditTrkhouKbn);
            creditCardJyouhou.setGyoumuKousinsyaId(pUserID);
            creditCardJyouhou.setGyoumuKousinTime(pSysTime);
            BizPropertyInitializer.initialize(creditCardJyouhou);
        }
        else if (E_CreditCardhnsyuKbn.UPD_INPUT_UPD.equals(pCreditCardhnsyuKbn)) {

            HT_CreditCardJyouhou creditCardJyouhou = pSyoriCTL.getCreditCardJyouhou();

            if (creditCardJyouhou != null) {

                creditCardJyouhou.setCardbrandkbn(C_CardBrandKbn.BLNK);
                creditCardJyouhou.setGyoumuKousinsyaId(pUserID);
                creditCardJyouhou.setGyoumuKousinTime(pSysTime);
            }
        }
    }

    private void clearSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        pSyoriCTL.setMosKihons(new ArrayList<HT_MosKihon>());
        pSyoriCTL.setCreditCardJyouhous(new ArrayList<HT_CreditCardJyouhou>());
        pSyoriCTL.setSkTtdkTyuuiKanris(new ArrayList<HT_SkTtdkTyuuiKanri>());
        pSyoriCTL.setSkTtdkTyuuis(new ArrayList<HT_SkTtdkTyuui>());
        pSyoriCTL.setHubiMsgs(new ArrayList<HT_HubiMsg>());
        pSyoriCTL.setHenteiRirekis(new ArrayList<HT_HenteiRireki>());
        pSyoriCTL.setKmTsRirekis(new ArrayList<HT_KmTsRireki>());
        pSyoriCTL.setSkLincTourokuInfos(new ArrayList<HT_SkLincTourokuInfo>());
        pSyoriCTL.setUketoriKouzaJyouhous(new ArrayList<HT_UketoriKouzaJyouhou>());
        pSyoriCTL.setMosDairitens(new ArrayList<HT_MosDairiten>());
        pSyoriCTL.setUketorinins(new ArrayList<HT_Uketorinin>());
        pSyoriCTL.setMosSyouhns(new ArrayList<HT_MosSyouhn>());
        pSyoriCTL.setSkHubis(new ArrayList<HT_SkHubi>());
        pSyoriCTL.setKokutisyos(new ArrayList<HT_Kokutisyo>());
        pSyoriCTL.setHoujyous(new ArrayList<HT_Houjyou>());
        pSyoriCTL.setTokujyous(new ArrayList<HT_Tokujyou>());
        pSyoriCTL.setImusateiTokujyous(new ArrayList<HT_ImusateiTokujyou>());
        pSyoriCTL.setSyouhnTokujyous(new ArrayList<HT_SyouhnTokujyou>());
        pSyoriCTL.setImusateiSyouhnTokujyous(new ArrayList<HT_ImusateiSyouhnTokujyou>());
        pSyoriCTL.setDakuhiKetteis(new ArrayList<HT_DakuhiKettei>());
        pSyoriCTL.setImusateiRirekis(new ArrayList<HT_ImusateiRireki>());
        pSyoriCTL.setKnksateiRirekis(new ArrayList<HT_KnksateiRireki>());
        pSyoriCTL.setMostenkenRirekis(new ArrayList<HT_MostenkenRireki>());
        pSyoriCTL.setTokunins(new ArrayList<HT_Tokunin>());
        pSyoriCTL.setImuSonotaTkykJktks(new ArrayList<HT_ImuSonotaTkykJktk>());
        pSyoriCTL.setSonotaTkykJktks(new ArrayList<HT_SonotaTkykJktk>());
        pSyoriCTL.setRuleHanteiMsgs(new ArrayList<HT_RuleHanteiMsg>());
        pSyoriCTL.setKykKaks(new ArrayList<HT_KykKak>());
        pSyoriCTL.setTuusans(new ArrayList<HT_Tuusan>());
        pSyoriCTL.setNayoseKekkas(new ArrayList<HT_NayoseKekka>());
        pSyoriCTL.setNyuukins(new ArrayList<HT_Nyuukin>());
        pSyoriCTL.setHenkins(new ArrayList<HT_Henkin>());
        pSyoriCTL.setMosKihonVrfs(new ArrayList<HT_MosKihonVrf>());
        pSyoriCTL.setNrkDifs(new ArrayList<HT_NrkDif>());
        pSyoriCTL.setUketorininVrfs(new ArrayList<HT_UketorininVrf>());
        pSyoriCTL.setMosDairitenVrfs(new ArrayList<HT_MosDairitenVrf>());
        pSyoriCTL.setMosSyouhnVrfs(new ArrayList<HT_MosSyouhnVrf>());
        pSyoriCTL.setKouzaJyouhouVrfs(new ArrayList<HT_KouzaJyouhouVrf>());
        pSyoriCTL.setUketoriKouzaJyouhouVrfs(new ArrayList<HT_UketoriKouzaJyouhouVrf>());
        pSyoriCTL.setKokutisyoVrfs(new ArrayList<HT_KokutisyoVrf>());
        pSyoriCTL.setSentakuJyouhous(new ArrayList<HT_SentakuJyouhou>());
        pSyoriCTL.setKouzaJyouhous(new ArrayList<HT_KouzaJyouhou>());
        pSyoriCTL.setMosTrkKzks(new ArrayList<HT_MosTrkKzk>());
        pSyoriCTL.setMosTrkKzkVrfs(new ArrayList<HT_MosTrkKzkVrf>());
        pSyoriCTL.setSkLincSyoukaikekkas(new ArrayList<HT_SkLincSyoukaikekka>());
    }

    private BizDate getKeiyakuDate(C_Tuukasyu kyktuukasyu) {

        BizDate rsYmd = null;
        BM_SyouhnZokusei syouhnZokusei = uiBean.getSyouhnZokusei();

        if(uiBean.getSyoriCTL() != null){
            rsYmd = uiBean.getSyoriCTL().getRyosyuymd();

        }

        SetSknnkaisiymd setSknnkaisiymd = SWAKInjector.getInstance(SetSknnkaisiymd.class);
        setSknnkaisiymd.exec(uiBean.getSntkhoukbn(), null, uiBean.getMosymd(), rsYmd,
            C_SknnkaisikitkhukaKbn.BLNK, null);
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        HT_MosKihon mosKihon = new HT_MosKihon();
        mosKihon.setMosno(uiBean.getMosno());
        mosKihon.setKykymd(null);
        mosKihon.setHrkkaisuu(uiBean.getHrkkaisuu());
        mosKihon.setFstphrkkeirokbn(uiBean.getFstphrkkeirokbn());

        if(C_Tuukasyu.USD.equals(kyktuukasyu)){
            syouhnZokusei = uiBean.getSyouhnZokusei();
        }else if(C_Tuukasyu.AUD.equals(kyktuukasyu)){

            C_UmuKbn syksbyensitihsyutktekiumu = C_UmuKbn.NONE;
            if (C_Tkhukaumu.HUKA.eq(uiBean.getSyksbyensitihsyutkhkkbn())) {
                syksbyensitihsyutktekiumu = C_UmuKbn.ARI;
            }

            List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(
                kariSknnKaisiYmd, C_SyutkKbn.SYU, uiBean.getDaihyouHknSyuruiNo(), 0, 0,
                kyktuukasyu, syksbyensitihsyutktekiumu, uiBean.getSknenkinsyu(), syouhnZokusei.getTeikisiharaikinumu());

            if (syouhnZokuseiLst.size() == 0) {
                throw new BizLogicException(MessageId.EHA1060, "商品情報", "商品");
            }

            syouhnZokusei = syouhnZokuseiLst.get(0);

            syouhnZokusei.detach();

        }

        HT_MosSyouhn mosSyouhn = new HT_MosSyouhn();
        mosSyouhn.setMosno(uiBean.getMosno());
        mosSyouhn.setSyouhncd(syouhnZokusei.getSyouhncd());


        SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);
        BizDate keiyakuDate = setKisoKoumoku.setkykymdHantei(mosKihon, mosSyouhn, rsYmd, uiBean.getMosymd(),
            kariSknnKaisiYmd,
            BizDate.getSysDate(), C_SysKbn.SKEI, C_YoteikykymdKbn.SITEI);

        return keiyakuDate;

    }

    private String saibanCreditKessaiyouNo(String pMosno, boolean pAitemoFlg) {

        SaibanCreditKessaiyouNo saibanCreditKessaiyouNo = SWAKInjector.getInstance(SaibanCreditKessaiyouNo.class);
        CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu = SWAKInjector.getInstance(CreditKessaiyouNoHensyuu.class);

        String creditkessaiyouNo = saibanCreditKessaiyouNo.exec(C_CreditCardKeySyuruiKbn.MOSNO, pMosno);
        String dispCreditkessaiyouNo = creditKessaiyouNoHensyuu.exec(creditkessaiyouNo);

        if (!pAitemoFlg) {

            uiBean.setDispcreditkessaiyouno(dispCreditkessaiyouNo);
        }
        else {

            uiBean.setDispcreditkessaiyouno2(dispCreditkessaiyouNo);
        }

        return creditkessaiyouNo;
    }

}