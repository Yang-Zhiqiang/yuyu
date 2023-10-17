package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import static yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.GenSkMosSyoukaiConstants.*;
import static yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.SkMosSyoukaiConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.SkMosSyoukaiConstants.E_SyoriKeiyu;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetProcessRecord;
import yuyu.common.biz.bzcommon.BzGetProcessRecordBean;
import yuyu.common.biz.bzcommon.BzGetProcessRecordInputBean;
import yuyu.common.biz.bzcommon.BzGetProcessRecordOutputBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzcommon.GetBankSitenNm;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bznayose.BzKeiyakuHozenSakuinKekkaBean;
import yuyu.common.biz.bznayose.BzKeiyakuMfSakuinKekkaBean;
import yuyu.common.biz.bznayose.BzMousikomiFSakuinKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.common.biz.bznayose.BzSinkeiyakuSakuinKekkaBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuu;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanTargetMokuhyougk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.hozen.khcommon.SetSyokenhakkouymd;
import yuyu.common.sinkeiyaku.skcommon.EditGamenString;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.common.sinkeiyaku.skcommon.GetSkTtdkTyuui;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_DrtnCdKensakuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GaitouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HubiSyoriKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KeihiKbn;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KkthjyKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_MsgSyubetu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SkykymdKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.def.db.entity.BM_Syoubyou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.result.bean.KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean;
import yuyu.def.sinkeiyaku.result.bean.SyoukaiIchiranInfosByMosymdBosyuuymItemsBean;
import yuyu.def.sinkeiyaku.sorter.SortHT_MosSyouhn;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkHubiDetail;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 申込状況照会 のビジネスロジックです。
 */
public class SkMosSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkMosSyoukaiUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private GetBankSitenNm getBankSitenNm;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private GetSkTtdkTyuui getSkTtdkTyuui;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private MessageManager messageManager;

    void init() {
        uiBean.setSrchketteikbn(C_KetteiKbn.BLNK);
        uiBean.setSrchseiritukbn(C_SeirituKbn.BLNK);
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
        clearParam(true);
    }

    void clearForKensakuResult() {
        clearParam(false);
    }

    E_SyoriKeiyu getModoruBtnForward() {
        return uiBean.getGmSyoriKbn();
    }


    void pushSyoukaiBL() {

        String mosNo = null;
        String syoukenNo = null;
        String uktkId = null;
        HT_SyoriCTL syoriCTL = null;
        List<HT_SyoriCTL> syoriCtlLst = null;

        mosNo = uiBean.getSrchmosno();
        syoukenNo = uiBean.getSrchsyono();
        uktkId = uiBean.getSrchkanriid();

        if (isBlank(mosNo) && isBlank(syoukenNo) && isBlank(uktkId)) {
            throw new BizLogicException(MessageId.EHF1001);
        }

        if ((!isBlank(mosNo) && !isBlank(syoukenNo)) ||
            (!isBlank(mosNo) && !isBlank(uktkId)) ||
            (!isBlank(syoukenNo) && !isBlank(uktkId))) {
            throw new BizLogicException(MessageId.EHF1002);
        }

        if (!isBlank(mosNo)) {
            syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

            if (syoriCTL == null) {
                throw new BizLogicException(MessageId.EBA0090);
            }

            uiBean.setMosno(syoriCTL.getMosno());
        }
        else if (!isBlank(syoukenNo)) {
            syoriCtlLst = sinkeiyakuDomManager.getSyoriCTLsBySyono(syoukenNo);

            if (syoriCtlLst.size() == 0) {
                throw new BizLogicException(MessageId.EBA0090);
            }

            syoriCTL = syoriCtlLst.get(0);

            uiBean.setMosno(syoriCTL.getMosno());
        }
        else if (!isBlank(uktkId)) {
            List<HT_MosKihon> mosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkid(uktkId);

            if (mosKihonLst.size() == 0) {
                throw new BizLogicException(MessageId.EBA0090);
            }

            syoriCTL = mosKihonLst.get(0).getSyoriCTL();
            uiBean.setMosno(syoriCTL.getMosno());
        }

        if (syoriCTL != null) {

            kykSyoukaiKengen();
            keiyakuSearch();

            uiBean.setGmSyoriKbn(E_SyoriKeiyu.SYORI_SYOUKAI);
        }
    }

    void pushSearchBL() {

        BizDate         mosFromYmd   = null;
        BizDate         mosToYmd     = null;
        String          drtenCd      = null;
        String          kinYuuCd     = null;
        String          kyknmkn      = null;
        BizDate         kykseiymd    = null;

        mosFromYmd = uiBean.getSrchmosfromymd();
        mosToYmd = uiBean.getSrchmostoymd();
        drtenCd = uiBean.getDrtencd();
        kinYuuCd = uiBean.getSrchkinyuucd();
        kyknmkn = uiBean.getSrchkyknmkn();
        kykseiymd = uiBean.getSrchkykseiymd();

        if (mosFromYmd == null && mosToYmd == null
            && (isBlank(drtenCd)) && (isBlank(kinYuuCd)) && (isBlank(kyknmkn)) && kykseiymd == null) {
            throw new BizLogicException(MessageId.EHA0074);
        }

        if (!BizUtil.isBlank(drtenCd) && !BizUtil.isBlank(kinYuuCd)) {
            throw new BizLogicException(MessageId.EHA1081,
                new Item[] {DDID_KENSAKUJYOUKENSITEI_DRTENCD,DDID_KENSAKUJYOUKENSITEI_SRCHKINYUUCD},
                MessageUtil.getMessage(DDID_KENSAKUJYOUKENSITEI_DRTENCD.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_KENSAKUJYOUKENSITEI_SRCHKINYUUCD.getErrorResourceKey()));
        }

        searchData();
        uiBean.setGmSyoriKbn(E_SyoriKeiyu.SYORI_KENSAKU);
    }

    void pushDispMoshiNoBL() {

        KensakuKekkaDataSourceBean kensakuKekkaDataSourceBean = uiBean.getKensakuKekkaDataSource().getSelectedBean();
        uiBean.setMosno(kensakuKekkaDataSourceBean.getDispmosno());
        keiyakuSearch();
        uiBean.setGmSyoriKbn(E_SyoriKeiyu.SYORI_KENSAKU);
        kykSyoukaiKengen();
    }

    void pushHubijkbtnbykeiyakunaiyouBL() {
        hubiSearch();
    }

    void pushHbtrjhBtnByKeiyakuNaiyouBL() {
        hubiInsertSearch();
    }

    void pushKtjkBtnByKeiyakuNaiyouBL() {
        ketteiSearch();
    }

    void pushKouteijkBtnByKeiyakuNaiyouBL() {
        kouteijkListSearch();
    }

    void pushNkjkBtnByKeiyakuNaiyouBL() {
        nyuukinSearch();
    }

    void pushSyoruiTtykBtnByKeiyakuNaiyouBL() {
        syoruiToutyakuJkSearch();
    }

    void pushTsrrkBtnByKeiyakuNaiyouBL() {
        teiseiRrkListSearch();
    }

    void pushSakuinInfoBtnByKeiyakuNaiyouBL() {
        sakuinInfoSearch();
    }

    void pushKykNaiyouBtnByHubijkBL() {
        keiyakuSearch();
    }

    void pushHubiTourokuInfoBtnByHubijkBL() {
        hubiInsertSearch();
    }

    void pushKetteiJyoukyouBtnByHubijkBL() {
        ketteiSearch();
    }

    void pushNyuukinjyoukyouBtnByHubijkBL() {
        nyuukinSearch();
    }

    void pushKouteijkBtnByHubijkBL() {
        kouteijkListSearch();
    }

    void pushSyoruiTtykBtnByHubijkBL() {
        syoruiToutyakuJkSearch();
    }

    void pushTsrrkBtnByHubijkBL() {
        teiseiRrkListSearch();
    }

    void pushSakuinInfoBtnByHubijkBL() {
        sakuinInfoSearch();
    }

    void pushKykNaiyouBtnByHubitrkinfoBL() {
        keiyakuSearch();
    }

    void pushHubijkBtnByHubitrkInfoBL() {
        hubiSearch();
    }

    void pushKtjkBtnByHubitrkInfoBL() {
        ketteiSearch();
    }

    void pushNkjkBtnByHubitrkInfoBL() {
        nyuukinSearch();
    }

    void pushKouteijkBtnByHubitrkInfoBL() {
        kouteijkListSearch();
    }

    void pushSyoruiTtykBtnByHubitrkInfoBL() {
        syoruiToutyakuJkSearch();
    }

    void pushTsrrkBtnByHubitrkInfoBL() {
        teiseiRrkListSearch();
    }

    void pushSakuinInfoBtnByHubitrkInfoBL() {
        sakuinInfoSearch();
    }

    void pushKykNaiyouBtnByKetteijkBL() {
        keiyakuSearch();
    }

    void pushHubiJyoukyouBtnByKetteijkBL() {
        hubiSearch();
    }

    void pushHbtrjhBtnByKetteijkBL() {
        hubiInsertSearch();
    }

    void pushNkjkBtnByKetteijkBL() {
        nyuukinSearch();
    }

    void pushKouteijkBtnByKetteijkBL() {
        kouteijkListSearch();
    }

    void pushSyoruiTtykBtnByKetteijkBL() {
        syoruiToutyakuJkSearch();
    }

    void pushTsrrkBtnByKetteijkBL() {
        teiseiRrkListSearch();
    }

    void pushSakuinInfoBtnByKetteijkBL() {
        sakuinInfoSearch();
    }

    void pushKykNaiyouBtnByNyuukinjkBL() {
        keiyakuSearch();
    }

    void pushHubiJyoukyouBtnByNyuukinjkBL() {
        hubiSearch();
    }

    void pushHbtrjhBtnByNyuukinjkBL() {
        hubiInsertSearch();
    }

    void pushKtjkBtnByNyuukinjkBL() {
        ketteiSearch();
    }

    void pushKouteijkBtnByNyuukinjkBL() {
        kouteijkListSearch();
    }

    void pushSyoruiTtykBtnByNyuukinjkBL() {
        syoruiToutyakuJkSearch();
    }

    void pushTsrrkBtnByNyuukinjkBL() {
        teiseiRrkListSearch();
    }

    void pushSakuinInfoBtnByNyuukinjkBL() {
        sakuinInfoSearch();
    }

    void pushKykNaiyouBtnByKouteijkBL() {
        keiyakuSearch();
    }

    void pushHubiJyoukyouBtnByKouteijkBL() {
        hubiSearch();
    }

    void pushHbtrjhBtnByKouteijkBL() {
        hubiInsertSearch();
    }

    void pushKtjkBtnByKouteijkBL() {
        ketteiSearch();
    }

    void pushNyuukinjkBtnByKouteijkBL() {
        nyuukinSearch();
    }

    void pushSyoruiTtykBtnByKouteijkBL() {
        syoruiToutyakuJkSearch();
    }

    void pushTsrrkBtnByKouteijkBL() {
        teiseiRrkListSearch();
    }

    void pushSakuinInfoBtnByKouteijkBL() {
        sakuinInfoSearch();
    }

    void pushKyknyBtnBySyoruiToutyakujkBL() {
        keiyakuSearch();
    }

    void pushHubijkBtnBySyoruiToutyakujkBL() {
        hubiSearch();
    }

    void pushHbtrjhBtnBySyoruiToutyakujkBL() {
        hubiInsertSearch();
    }

    void pushKtjkBtnBySyoruiToutyakujkBL() {
        ketteiSearch();
    }

    void pushNkjkBtnBySyoruiToutyakujkBL() {
        nyuukinSearch();
    }

    void pushKouteijkBtnBysyoruiToutyakujkBL() {
        kouteijkListSearch();
    }

    void pushTsrrkBtnBysyoruiToutyakujkBL() {
        teiseiRrkListSearch();
    }

    void pushSakuinInfoBtnBySyoruiToutyakujkBL() {
        sakuinInfoSearch();
    }

    void printHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void pushKykNaiyouBtnByTeiseirrklistBL() {
        keiyakuSearch();
    }

    void pushHubijkBtnByTeiseirrklistBL() {
        hubiSearch();
    }

    void pushHbtrjhBtnByteiseirrklistBL() {
        hubiInsertSearch();
    }

    void pushKtjkBtnByTeiseirrklistBL() {
        ketteiSearch();
    }

    void pushNkjkBtnbyTeiseirrklistBL() {
        nyuukinSearch();
    }

    void pushKouteijkBtnbyTeiseirrklistBL() {
        kouteijkListSearch();
    }

    void pushSyoruiTtykBtnByTeiseirrklistBL() {
        syoruiToutyakuJkSearch();
    }

    void pushSakuinInfoBtnByTeiseirrklistBL() {
        sakuinInfoSearch();
    }

    void pushKykNaiyouBtnBySakuinInfoBL() {
        clearWarningMsg();
        keiyakuSearch();
    }

    void pushHubijkBtnBySakuinInfoBL() {
        clearWarningMsg();
        hubiSearch();
    }

    void pushHbtrjhBtnBySakuinInfoBL() {
        clearWarningMsg();
        hubiInsertSearch();
    }

    void pushKtjkBtnBySakuinInfoBL() {
        clearWarningMsg();
        ketteiSearch();
    }

    void pushNkjkBtnbySakuinInfoBL() {
        clearWarningMsg();
        nyuukinSearch();
    }

    void pushKouteijkBtnbySakuinInfoBL() {
        clearWarningMsg();
        kouteijkListSearch();
    }

    void pushSyoruiTtykBtnBySakuinInfoBL() {
        clearWarningMsg();
        syoruiToutyakuJkSearch();
    }

    void pushTsrrkBtnBySakuinInfoBL() {
        clearWarningMsg();
        teiseiRrkListSearch();
    }

    void pushModoruBtnBySakuinInfoBL() {
        clearWarningMsg();
    }

    private void keiyakuSearch() {

        checkMosno();

        String   mosNo     = null;
        C_UmuKbn mosnrkUmu = null;

        clearParamKeiyakuNaiyou();
        BizPropertyInitializer.initialize(uiBean);

        mosNo   = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL != null) {
            setPropertyFromTSyoriCTL(syoriCTL);
        }
        else {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        mosnrkUmu = uiBean.getMosnrkumu();

        if (!C_UmuKbn.NONE.eq(mosnrkUmu)) {
            HT_MosKihon mosKihon = syoriCTL.getMosKihon();
            if (mosKihon != null) {
                setPropertyFromTMosKihon(mosKihon, syoriCTL);
            }

            List<HT_MosSyouhn> mosSyouhnSyuLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

            List<HT_MosSyouhn> mosSyouhnSyuForSortList = new ArrayList<>(mosSyouhnSyuLst);

            mosSyouhnSyuForSortList = new SortHT_MosSyouhn().
                OrderHT_MosSyouhnByBM_SyouhnZokuseiSyohnsortnoAsc(mosSyouhnSyuForSortList);

            if (mosSyouhnSyuForSortList.size() > 0) {
                HT_MosSyouhn mosSyouhin = mosSyouhnSyuForSortList.get(0);
                BM_SyouhnZokusei syouhnZokusei = mosSyouhin.getSyouhnZokusei();
                if (syouhnZokusei != null) {

                    uiBean.setSyokugyoukktumu(syouhnZokusei.getSyokugyoukktumu());
                    uiBean.setGaikatatkiumu(syouhnZokusei.getGaikatatkiumu());
                    uiBean.setNkhknumu(syouhnZokusei.getNkhknumu());
                    uiBean.setHengakuumu(syouhnZokusei.getHengakuumu());
                    uiBean.setNstkumu(syouhnZokusei.getNstkumu());
                    uiBean.setTargettkhukakanoukbn(syouhnZokusei.getTargettkhukakanoukbn());
                    uiBean.setJyudkaigomehrtktekiumu(syouhnZokusei.getJyudkaigomehrtktekiumu());
                    uiBean.setSyuusinhknumu(syouhnZokusei.getSyuusinhknumu());
                    uiBean.setSbuktumu(syouhnZokusei.getSbuktumu());
                    uiBean.setTeikisiharaikinumu(syouhnZokusei.getTeikisiharaikinumu());
                    uiBean.setKykdrtentuusanumu(syouhnZokusei.getKykdrtentuusanumu());
                    uiBean.setTmttknhaibunwarisiteiumu(syouhnZokusei.getTmttknhaibunwarisiteiumu());
                    uiBean.setNkuktumu(syouhnZokusei.getNkuktumu());
                    uiBean.setZeiseitekikakuumu(syouhnZokusei.getZeiseitekikakuumu());
                    uiBean.setZennouumu(syouhnZokusei.getZennouumu());
                    uiBean.setKouzahurikaebaraitekiumu(syouhnZokusei.getKouzahurikaebaraitekiumu());
                    uiBean.setPyennykntktekiumu(syouhnZokusei.getPyennykntktekiumu());
                    uiBean.setGaikanyuukintktekiumu(syouhnZokusei.getGaikanyuukintktekiumu());
                    uiBean.setHeijyunbaraiumu(syouhnZokusei.getHeijyunbaraiumu());
                    uiBean.setTeikiikkatubaraiumu(syouhnZokusei.getTeikiikkatubaraiumu());
                    uiBean.setPwaribikikbn(syouhnZokusei.getPwaribikikbn());
                    uiBean.setCreditcardhrtekiumu(syouhnZokusei.getCreditcardhrtekiumu());
                    uiBean.setPtratkituukasiteikbn(syouhnZokusei.getPtratkituukasiteikbn());
                    uiBean.setHokenkngkyakujyouumu(syouhnZokusei.getHokenkngkyakujyouumu());

                    setPropertyFromTMosSyouhinSyuKeiyaku(mosSyouhin, syoriCTL);

                    if (mosSyouhin.getHknkkn() != 0){
                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                            EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);
                            C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(mosSyouhin.getHknkkn(),
                                mosSyouhin.getHknkknsmnkbn(), mosKihon.getHhknnen());
                            if (C_ErrorKbn.OK.eq(errorKbn)) {

                                uiBean.setNkshrstartnen(editNenkinKoumokuUtil.getNenkinSiharaiKaisiNenrei());
                            }
                        }
                    }

                    if (mosSyouhin.getHknkkn() != 0){
                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                            EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);
                            C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(mosSyouhin.getHknkkn(),
                                mosSyouhin.getHknkknsmnkbn(), mosSyouhin.getHrkkkn(), mosSyouhin.getHrkkknsmnkbn(), mosKihon.getHhknnen());
                            if (C_ErrorKbn.OK.eq(errorKbn)) {

                                uiBean.setSueokikkn(editNenkinKoumokuUtil.getNenkinSueokikikan());
                            }
                        }
                    }

                    if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(mosKihon.getHknsyuruino())) {
                        uiBean.setSyukihons(BizCurrency.optional());
                    }
                    else {
                        uiBean.setSyukihons(mosSyouhin.getSeitoukihons());
                    }

                    if (C_UmuKbn.ARI.eq(uiBean.getHokenkngkyakujyouumu())){
                        uiBean.setSyumoskihons(mosSyouhin.getKihons());
                    }
                    else {
                        uiBean.setSyumoskihons(BizCurrency.optional());
                    }

                    C_SntkhouKbn sntkhouKbn = mosKihon.getSntkhoukbn();
                    String kokutiKbn = syouhnZokusei.getKokutikbn().getContent();
                    String snsHuhuSyurui = "";

                    if (C_SntkhouKbn.KKT.eq(sntkhouKbn)) {
                        kokutiKbn = "（" + kokutiKbn + "）";
                        snsHuhuSyurui = sntkhouKbn.getContent() + kokutiKbn;
                    }
                    else {
                        snsHuhuSyurui = sntkhouKbn.getContent();
                    }

                    uiBean.setSnshuhusyurui(snsHuhuSyurui);

                    if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(mosKihon.getHknsyuruino()) ||
                        C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(mosKihon.getHknsyuruino()) ||
                        C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT.eq(mosKihon.getHknsyuruino()) ||
                        C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT.eq(mosKihon.getHknsyuruino())) {

                        uiBean.setInquiryyoteiriritu(
                            BizUtil.num((mosSyouhin.getYoteiriritu().multiply(100)).toString(),
                                BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2) + PERCENT);

                        if (mosKihon.getSknnkaisiymd() == null) {

                            uiBean.setTyuuimongon3(TYUUIMONGON2);

                        }
                        else {

                            uiBean.setTyuuimongon3("");
                        }

                    }
                    else {

                        uiBean.setInquiryyoteiriritu(MARK);

                        uiBean.setTyuuimongon3("");
                    }

                    if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(mosKihon.getHknsyuruino()) ||
                        C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(mosKihon.getHknsyuruino()) ||
                        C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(mosKihon.getHknsyuruino()) ||
                        C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(mosKihon.getHknsyuruino()) ||
                        C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(mosKihon.getHknsyuruino())) {

                        uiBean.setInquirytumitateriritu(
                            BizUtil.num((mosSyouhin.getTumitateriritu().multiply(100)).toString(),
                                BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2) + PERCENT);

                        if (mosKihon.getSknnkaisiymd() == null) {

                            uiBean.setTyuuimongon4(TYUUIMONGON2);

                        }
                        else {

                            uiBean.setTyuuimongon4("");
                        }

                    }
                    else {

                        uiBean.setInquirytumitateriritu(MARK);

                        uiBean.setTyuuimongon4("");
                    }

                    if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(mosKihon.getHknsyuruino())) {
                        uiBean.setInquiryloadinghnkgtmttrrt(KBKAKKOSTART
                            + BizUtil.num((mosSyouhin.getLoadinghnkgtumitateriritu().multiply(100)).toString(),
                                BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2) + PERCENT
                                + INQUIRYLOADINGHNKGTMTTRRT);
                    }
                    else {
                        uiBean.setInquiryloadinghnkgtmttrrt("");
                    }

                    if (C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(mosKihon.getHknsyuruino())) {
                        uiBean.setInquirytmttknzoukaritujygn(
                            BizUtil.num((mosSyouhin.getTmttknzoukaritujygn().multiply(100)).toString(),
                                BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2) + PERCENT);
                        uiBean.setInquirysetteibairitu(
                            BizUtil.num((mosSyouhin.getSetteibairitu()).toString(),
                                BizUtil.ZERO_FILL_LAST_ONLY, 1, BizUtil.ZERO_FILL, 2) + BAI);

                        if (mosKihon.getSknnkaisiymd() == null) {
                            uiBean.setTyuuimongon5(TYUUIMONGON2);
                            uiBean.setTyuuimongon6(TYUUIMONGON2);
                        }
                        else {
                            uiBean.setTyuuimongon5("");
                            uiBean.setTyuuimongon6("");
                        }
                    }
                    else {
                        uiBean.setInquirytmttknzoukaritujygn(MARK);
                        uiBean.setInquirysetteibairitu(MARK);
                        uiBean.setTyuuimongon5("");
                        uiBean.setTyuuimongon6("");
                    }

                    if (C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(mosKihon.getHknsyuruino())) {
                        uiBean.setInquiryrendouritu(
                            BizUtil.num((mosSyouhin.getRendouritu().multiply(100)).toString(),
                                BizUtil.ZERO_FILL_LAST_ONLY, 3, BizUtil.ZERO_FILL, 2) + PERCENT);

                        if (mosKihon.getSknnkaisiymd() == null) {
                            uiBean.setTyuuimongon7(TYUUIMONGON2);
                        }
                        else {
                            uiBean.setTyuuimongon7("");
                        }
                    }
                    else {
                        uiBean.setInquiryrendouritu(MARK);
                        uiBean.setTyuuimongon7("");
                    }

                    if (C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(mosKihon.getHknsyuruino())) {
                        if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {
                            uiBean.setTeikisiharaikin(mosSyouhin.getTeikisiharaikin());
                        }
                        else {
                            uiBean.setTeikisiharaikin(BizCurrency.optional());
                        }
                    }
                    else {
                        uiBean.setTeikisiharaikin(BizCurrency.optional());
                    }

                    if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn())) {
                        if (uiBean.getRyosyuymd() != null) {
                            uiBean.setNyknkwsratekijyunymd(syoriCTL.getNyknkwsratekijyunymd());
                            uiBean.setNyknkwsrate(zeroToOptional(syoriCTL.getNyknkwsrate()));
                        }
                    }
                    else {
                        uiBean.setNyknkwsratekijyunymd(syoriCTL.getNyknkwsratekijyunymd());
                        uiBean.setNyknkwsrate(zeroToOptional(syoriCTL.getNyknkwsrate()));
                    }

                    if (!C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn())) {
                        if (syoriCTL.getRyosyuymd() == null) {

                            if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {

                                uiBean.setTyuuimongon1(SkMosSyoukaiConstants.TYUUIMONGON1);
                            }
                            else {

                                uiBean.setTyuuimongon1(SkMosSyoukaiConstants.TYUUIMONGON1_2);
                            }
                        }
                    }

                    if (!C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn())) {
                        if (syoriCTL.getRyosyuymd() == null) {
                            uiBean.setTyuuimongon2(SkMosSyoukaiConstants.TYUUIMONGON2);
                        }
                    }

                    uiBean.setZennouphrkgk(BizCurrency.optional());
                    if (!uiBean.getZennoup().isOptional()) {
                        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn())) {
                            if (uiBean.getRyosyuymd() != null) {
                                if (!uiBean.getKyktuukasyu().eq(uiBean.getHrktuukasyu())) {
                                    uiBean.setZennouphrkgk(mosKihon.getHrktuukafstphrkgk());
                                }
                            }
                        }
                    }
                }
            }

            // S社導入対応時は、特約情報は考慮しないため、コメントアウト対応
            //            List<HT_MosSyouhn> mosSyouhnTkLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
            //
            //            List<HT_MosSyouhn> mosSyouhnTkForSortList = new ArrayList<>(mosSyouhnTkLst);
            //
            //            mosSyouhnTkForSortList = new SortHT_MosSyouhn().
            //            OrderHT_MosSyouhnByBM_SyouhnZokuseiSyohnsortnoAsc(mosSyouhnTkForSortList);
            //            setPropertyFromTMosSyouhinTokuyaku(mosSyouhnTkForSortList);

            List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
            setPropertyFromTUketorinin(uketorininLst);

            editDairitenInfo(mosKihon.getMosymd(), syoriCTL.getMosDairitens());

            List<HT_UketoriKouzaJyouhou> uketoriKouzaJyouhouLst = syoriCTL.getUketoriKouzaJyouhous();

            if (uketoriKouzaJyouhouLst.size() > 0) {
                setPropertyFromTUketoriKouzaInfo(uketoriKouzaJyouhouLst, mosKihon);
            }

            HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();

            if (kouzaJyouhou != null) {

                setPropertyFromTUkouhuriKouzaInfo(kouzaJyouhou, mosKihon);
            }

            HT_CreditCardJyouhou creditCardJyouhou = syoriCTL.getCreditCardJyouhou();
            if (creditCardJyouhou != null) {
                setPropertyFromCreditCardJyouhouInfo(creditCardJyouhou,syoriCTL);
            }

            List<HT_MosTrkKzk> mosTrkKzkLst = syoriCTL.getMosTrkKzks();
            setPropertyFromMosTrkKzkInfo(mosTrkKzkLst);
        }
        else {
            uiBean.setTsryhshrkykumukbn(null);
            uiBean.setSyosisyatodokeumukbn(null);
            uiBean.setKakukisyouryakukbumukbn(null);
            uiBean.setSeiymdmosseitouumukbn(null);
            uiBean.setDrctservicemoskbn(null);
        }

        if (!BizUtil.isBlank(uiBean.getMosno())) {

            HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMaxRenno(uiBean.getMosno());
            if (nyuukin != null) {

                uiBean.setLastrsymd(nyuukin.getRyosyuymd());
                uiBean.setZenhnknkbn(nyuukin.getZenhnknkbn());
            }

        }
    }

    private void setListData() {
        String          dispMosNo              = null;
        String          dispHhknnmkj           = null;
        C_KkthjyKbn     dispKkthjyKbn          = null;
        C_UmuKbn        dispNyknnrkUmu         = null;
        C_UmuKbn        dispHubiUmu            = null;
        C_KetteiKbn     dispKetteiKbn          = null;
        C_SeirituKbn    dispSeirituKbn         = null;
        C_HknsyuruiNo   dispHknsyuruiNo        = null;
        String          dispKyknmkn            = null;
        String          dispKyknmkj            = null;
        BizDate         dispKykseiymd          = null;
        String          dispHhknnmkn           = null;
        BizDate         dispHhknseiymd         = null;

        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfoLst = uiBean.getKensakuKekkaLst();
        if (syoukaiIchiranInfoLst.isEmpty()) {
            throw new BizLogicException(MessageId.EHA0057);
        }

        List<KensakuKekkaDataSourceBean> kensakuKekkaDataSourceBeanLst = new ArrayList<KensakuKekkaDataSourceBean>();

        for (int i = 0; i < syoukaiIchiranInfoLst.size(); i++) {

            KensakuKekkaDataSourceBean kensakuKekkaDataSourceBean = new KensakuKekkaDataSourceBean();

            SyoukaiIchiranInfosByMosymdBosyuuymItemsBean syoukaiIchiranInfo = syoukaiIchiranInfoLst.get(i);
            dispMosNo = syoukaiIchiranInfo.getMosno();

            dispHhknnmkn = syoukaiIchiranInfo.getHhknnmkn();
            dispHhknnmkj = syoukaiIchiranInfo.getHhknnmkj();
            dispHhknseiymd = syoukaiIchiranInfo.getHhknseiymd();
            dispHknsyuruiNo = syoukaiIchiranInfo.getHknsyuruino();

            if (C_KykKbn.KEIHI_DOUITU.eq(syoukaiIchiranInfo.getKykkbn())) {
                dispKyknmkn = syoukaiIchiranInfo.getHhknnmkn();
                dispKyknmkj = syoukaiIchiranInfo.getHhknnmkj();
                dispKykseiymd = syoukaiIchiranInfo.getHhknseiymd();
            }
            else {
                dispKyknmkn = syoukaiIchiranInfo.getKyknmkn();
                dispKyknmkj = syoukaiIchiranInfo.getKyknmkj();
                dispKykseiymd = syoukaiIchiranInfo.getKykseiymd();
            }

            if (C_UmuKbn.ARI.eq(syoukaiIchiranInfo.getKktnrkumu())) {
                dispKkthjyKbn = C_KkthjyKbn.KKTNRK_ARI;
            }
            else {
                dispKkthjyKbn = C_KkthjyKbn.NONE;
            }

            dispNyknnrkUmu = syoukaiIchiranInfo.getNyknnrkumu();

            if (C_UmuKbn.ARI.eq(syoukaiIchiranInfo.getKthhbkbn())) {
                dispHubiUmu = C_UmuKbn.ARI;
            }
            else if (C_UmuKbn.ARI.eq(syoukaiIchiranInfo.getSrhhbkbn())) {
                dispHubiUmu = C_UmuKbn.ARI;
            }
            else if (C_UmuKbn.ARI.eq(syoukaiIchiranInfo.getKhnhbkbn())) {
                dispHubiUmu = C_UmuKbn.ARI;
            }
            else {
                dispHubiUmu = C_UmuKbn.NONE;
            }

            dispKetteiKbn = syoukaiIchiranInfo.getKetteikbn();
            dispSeirituKbn = syoukaiIchiranInfo.getSeiritukbn();


            kensakuKekkaDataSourceBean.setDispmosno(dispMosNo);
            kensakuKekkaDataSourceBean.setDispkyknmkn(dispKyknmkn);
            kensakuKekkaDataSourceBean.setDispkyknmkj(dispKyknmkj);
            kensakuKekkaDataSourceBean.setDisphhknnmkn(dispHhknnmkn);
            kensakuKekkaDataSourceBean.setDisphhknnmkj(dispHhknnmkj);
            kensakuKekkaDataSourceBean.setDispkykseiymd(dispKykseiymd);
            kensakuKekkaDataSourceBean.setDisphhknseiymd(dispHhknseiymd);
            kensakuKekkaDataSourceBean.setDisphknsyuruino(dispHknsyuruiNo);
            kensakuKekkaDataSourceBean.setDispkkthjykbn(dispKkthjyKbn);
            kensakuKekkaDataSourceBean.setDispnyknnrkumu(dispNyknnrkUmu);
            kensakuKekkaDataSourceBean.setDisphubiumu(dispHubiUmu);
            kensakuKekkaDataSourceBean.setDispketteikbn(dispKetteiKbn);
            kensakuKekkaDataSourceBean.setDispseiritukbn(dispSeirituKbn);


            kensakuKekkaDataSourceBeanLst.add(kensakuKekkaDataSourceBean);

        }
        uiBean.setKensakuKekka(kensakuKekkaDataSourceBeanLst);
    }

    private void nyuukinSearch() {

        checkMosno();

        clearParamNyuukinJK();
        BizPropertyInitializer.initialize(uiBean);

        String mosNo = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);

        getRsgakukei.getHenkinsumiRsgaku(syoriCTL);

        BizCurrency rsGakukei = getRsgakukei.getRsgakukei();

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon != null) {
            uiBean.setNyuukinjoutaikbn(syoriCTL.getNyuukinjoutaikbn());
            uiBean.setFstphrkgk(mosKihon.getFstphrkgk());
            uiBean.setYennykntkhkkbn(mosKihon.getYennykntkhkkbn());

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getHrktuukasyu());

            if (BizUtil.isZero(rsGakukei)) {
                uiBean.setRsgakukei(BizCurrency.valueOf(0, tuukaType));
            }
            else {
                uiBean.setRsgakukei(rsGakukei);
            }

            if (uiBean.getRyosyuymd() != null) {
                if (!uiBean.getFstphrkgk().isZeroOrOptional()) {
                    uiBean.setFstphrkgkhrktuuka(mosKihon.getHrktuukafstphrkgk());
                }
                else {
                    uiBean.setFstphrkgkhrktuuka(BizCurrency.valueOf(0, tuukaType));
                }

                uiBean.setNyknkwsratetkyymd(syoriCTL.getNyknkwsratekijyunymd());
                uiBean.setNyknkwsrate2(zeroToOptional(syoriCTL.getNyknkwsrate()));
            }
            else {
                uiBean.setFstphrkgkhrktuuka(BizCurrency.optional());
                uiBean.setNyknkwsrate2(BizNumber.optional());
            }

            BizDate kwsrateKjymd = syoriCTL.getRyosyuymd();

            if (C_UmuKbn.ARI.eq(syoriCTL.getNyknnrkumu())
                && kwsrateKjymd != null
                && C_Tkhukaumu.NONE.eq(mosKihon.getYennykntkhkkbn())) {

                if (kwsrateKjymd.isHoliday()) {
                    kwsrateKjymd = kwsrateKjymd.getBusinessDay(CHolidayAdjustingMode.NEXT);
                }

                uiBean.setFstpryosyuymd(kwsrateKjymd);
            }

            uiBean.setDispzenkizennouumu(mosKihon.getZenkizennouumu());
            uiBean.setDisphrkkaisuu(mosKihon.getHrkkaisuu());
            uiBean.setDisphrkkeiro(mosKihon.getHrkkeiro());
            uiBean.setDispfstphrkkeirokbn(mosKihon.getFstphrkkeirokbn());
            uiBean.setDispteikiikkatubaraikaisuu(mosKihon.getIkkatubaraikaisuu());

            if (mosKihon.getZnnkai() > 0) {

                uiBean.setDispznnkai(mosKihon.getZnnkai() + 1);

            }
            else {

                uiBean.setZnnkai(zeroToNull(mosKihon.getZnnkai()));

            }

            if (mosKihon.getIkkatuyoupkaisuu() != 0) {

                KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
                List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst = new ArrayList<KeisanIkkatuNyuukinGkSyouhnBean>();
                KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
                KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);
                BizCurrency hrkmTuukaHituyouIkkatuP = new BizCurrency();
                BizDate annnaiTysytymdFirst = null;
                BizDateYM annnaiTysytymdFirstYm = null;

                if(C_SeirituKbn.NONE.eq(uiBean.getSeiritukbn())) {
                    List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                    if (mosSyouhnLst.size() != 1) {
                        throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCTL.getMosno());
                    }

                    HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);

                    BizDate kykymdnoNextMymd = mosKihon.getKykymd().getNextMonth();

                    kykymdnoNextMymd = kykymdnoNextMymd.getRekijyou();



                    if (C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro())) {
                        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                        setHurikaebi.exec(kykymdnoNextMymd);

                        annnaiTysytymdFirst = setHurikaebi.getTyokugoAnnaibi();

                        annnaiTysytymdFirstYm = annnaiTysytymdFirst.getBizDateYM();

                    }
                    else {
                        SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

                        setCreditUriageSeikyuubi.exec(kykymdnoNextMymd);

                        annnaiTysytymdFirst = setCreditUriageSeikyuubi.getJikaiUrsktysytbi();

                        annnaiTysytymdFirstYm = annnaiTysytymdFirst.getBizDateYM();

                    }

                    keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd(mosSyouhn.getSyouhncd());
                    keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(mosSyouhn.getSyouhnsdno());
                    keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo(mosSyouhn.getRyouritusdno());
                    keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(mosSyouhn.getYoteiriritu());
                    keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(mosKihon.getHeijyunp());

                    keisanIkkatuNyuukinGkSyouhnBeanLst.add(keisanIkkatuNyuukinGkSyouhnBean);

                    keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNyuukinGkSyouhnBeanLst);
                    keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
                    keisanIkkatuNyuukinGkBean.setRstuukasyu(mosKihon.getHrktuukasyu());
                    keisanIkkatuNyuukinGkBean.setJyutoustartYm(annnaiTysytymdFirstYm);


                    if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn()) &&
                        !C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu()) &&
                        C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(mosKihon.getIkkatuyoupkaisuu() - 1);
                        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
                        if (C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro())) {
                            keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.KZHRK);
                        }
                        else {
                            keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.CREDIT);
                        }
                        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.getSysDate());

                    }
                    else {

                        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(mosKihon.getIkkatuyoupkaisuu());
                        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.SYOKAIP);
                        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
                        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(syoriCTL.getRyosyuymd());

                    }

                    C_ErrorKbn errorKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean, true);

                    if (C_ErrorKbn.OK.eq(errorKbn)) {
                        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn()) &&
                            !C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu()) &&
                            C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                            hrkmTuukaHituyouIkkatuP = mosKihon.getHrktuukaheijyunp().add(keisanTukiIkkatuNyuukinGk.getIktnyknkgk());

                        }
                        else {

                            hrkmTuukaHituyouIkkatuP = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();

                        }

                    }
                    else {

                        throw new CommonBizAppException("月払一括入金額計算異常 申込番号：" + syoriCTL.getMosno());

                    }
                }

                uiBean.setIkkatuyoupkaisuu(mosKihon.getIkkatuyoupkaisuu());
                uiBean.setGenzaiikkatukaisuu(1);
                uiBean.setHituyouikkatup(uiBean.getFstphrkgk().multiply(uiBean.getIkkatuyoupkaisuu()));

                if (!uiBean.getHituyouikkatup().isOptional() &&
                    C_SeirituKbn.NONE.eq(uiBean.getSeiritukbn())) {
                    BizCurrency husokuikkatup = hrkmTuukaHituyouIkkatuP.subtract(uiBean.getRsgakukei());
                    if (husokuikkatup.compareTo(BizCurrency.valueOf(0, husokuikkatup.getType())) < 0) {
                        uiBean.setHusokuikkatup(BizCurrency.valueOf(0, tuukaType));
                    }
                    else {
                        uiBean.setHusokuikkatup(husokuikkatup);
                    }
                }
                else {
                    uiBean.setHusokuikkatup(BizCurrency.optional());
                }
            }

            mosKihon = null;
        }
        else {
            uiBean.setFstphrkgk(BizCurrency.optional());
            uiBean.setRsgakukei(BizCurrency.optional());
        }

        setPropertyFromTSkDenpyoData(mosNo, syoriCTL.getRyosyuymd());

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        setPropertyFromTNyuukin(nyuukinLst);
        nyuukinLst = null;

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        setPropertyFromTHenkinForPKakin(henkinLst);

        setPropertyFromTHenkin(henkinLst);
        henkinLst = null;

    }

    private void teiseiRrkListSearch() {

        checkMosno();

        String mosNo = null;

        clearParamTeiseiRrkList();
        BizPropertyInitializer.initialize(uiBean);

        mosNo = uiBean.getMosno();

        List<KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean> kmkTsRrkInfoBeanLst =
            sinkeiyakuDomManager.getKoumokuTeiseiRirekiInfoByMosnoSubSystemId(mosNo, kinou.getSubSystemId());

        List<TeiseiRirekiInfoItiranDataSourceBean> teiRirekiInfoLst = new ArrayList<TeiseiRirekiInfoItiranDataSourceBean>();

        if (kmkTsRrkInfoBeanLst != null && kmkTsRrkInfoBeanLst.size() > 0) {
            for (int i = 0; i < kmkTsRrkInfoBeanLst.size(); i++) {
                TeiseiRirekiInfoItiranDataSourceBean teiRirekiInfo = new TeiseiRirekiInfoItiranDataSourceBean();

                KoumokuTeiseiRirekiInfoByMosnoSubSystemIdBean kmkuTeiRrkInfo = kmkTsRrkInfoBeanLst.get(i);
                AM_User userTemp = baseDomManager.getUser(kmkuTeiRrkInfo.getTantid());

                teiRirekiInfo.setDispsyoritime(DefaultDateFormatter.formatYMDHMZeroFill(kmkuTeiRrkInfo.getSyoriTime()));

                if (C_SkkinouModeIdKbn.DEFAULT.getValue().equals(kmkuTeiRrkInfo.getKinouModeId())) {
                    teiRirekiInfo.setDispkinoussnm(kmkuTeiRrkInfo.getKinouNm());
                }
                else {
                    teiRirekiInfo.setDispkinoussnm(kmkuTeiRrkInfo.getKinouModeNm());
                }

                teiRirekiInfo.setDisptskmnm(kmkuTeiRrkInfo.getTskmnm());
                teiRirekiInfo.setDisptsmaenaiyou(kmkuTeiRrkInfo.getTsmaenaiyou());
                teiRirekiInfo.setDisptsgonaiyou(kmkuTeiRrkInfo.getTsgonaiyou());

                if (userTemp != null) {
                    teiRirekiInfo.setDisptantounm(userTemp.getUserNm());
                }
                else {
                    teiRirekiInfo.setDisptantounm("");
                }

                teiRirekiInfoLst.add(teiRirekiInfo);
            }
        }
        else {
            TeiseiRirekiInfoItiranDataSourceBean teiRirekiInfo = new TeiseiRirekiInfoItiranDataSourceBean();
            teiRirekiInfoLst.add(teiRirekiInfo);
        }

        uiBean.setTeiseiRirekiInfoItiran(teiRirekiInfoLst);
    }

    private void ketteiSearch() {

        checkMosno();

        String mosNo = null;

        clearParamKetteiJK();
        BizPropertyInitializer.initialize(uiBean);

        mosNo = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        HT_Kokutisyo kokutisyo = syoriCTL.getKokutisyo();
        if (kokutisyo != null) {
            setPropertyFromTKokutisyo(kokutisyo);
            kokutisyo = null;
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon != null) {

            uiBean.setKhnchkcmnt(mosKihon.getKhnchkcmnt());

        }

        List<HT_MostenkenRireki> mostenkenRirekiLst = syoriCTL.getMostenkenRirekis();
        setPropertyFromTMosTnknRrk(mostenkenRirekiLst);
        mostenkenRirekiLst = null;

        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTL.getKnksateiRirekis();
        setPropertyFromTKnkSateiRrk(knksateiRirekiLst);
        knksateiRirekiLst = null;

        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTL.getImusateiRirekis();
        setPropertyFromTImuSateiRrk(imusateiRirekiLst);
        imusateiRirekiLst = null;

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();
        setPropertyFromTDakuhiKettei(dakuhiKetteiLst);
        dakuhiKetteiLst = null;

        List<HT_RuleHanteiMsg> ruleHanteiMsgLstMostenken = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);

        if (ruleHanteiMsgLstMostenken.size() > 0) {
            uiBean.setMostenkensjnaiyou(EditGamenString.editMessegeStringRule(ruleHanteiMsgLstMostenken));
        }

        List<HT_RuleHanteiMsg> ruleHanteiMsgLstKnksatei = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.KNKSATEI);

        if (ruleHanteiMsgLstKnksatei.size() > 0) {
            uiBean.setKnksateisjnaiyou(EditGamenString.editMessegeStringRule(ruleHanteiMsgLstKnksatei));
        }

        List<HT_RuleHanteiMsg> ruleHanteiMsgLstImusatei = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.IMUSATEI);

        if (ruleHanteiMsgLstImusatei.size() > 0) {
            uiBean.setImusateisijinaiyou(EditGamenString.editMessegeStringRule(ruleHanteiMsgLstImusatei));
        }

        ruleHanteiMsgLstMostenken = null;

        ruleHanteiMsgLstKnksatei = null;

        ruleHanteiMsgLstImusatei = null;

    }

    private void hubiSearch() {

        checkMosno();

        String mosNo                    = null;
        ArrayList<String> hnsyuKekkaLst = new ArrayList<String>();
        String[] henkanLists            = new String[0];
        String[] hubiMsgDatas           = null;
        int hubiMsgDataLen              = 0;
        String[] tmpDatas               = null;

        clearParamHubiJK();
        BizPropertyInitializer.initialize(uiBean);

        mosNo = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        if (syoriCTL != null) {
            uiBean.setKthhbkbn(syoriCTL.getKthhbkbn());
            uiBean.setSrhhbkbn(syoriCTL.getSrhhbkbn());
            uiBean.setKhnhbkbn(syoriCTL.getKhnhbkbn());
            syoriCTL = null;
        }
        else {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        hnsyuKekkaLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo, C_HubiSyoriKbn.SYOUKAI);

        hubiMsgDatas = hnsyuKekkaLst.toArray(henkanLists);
        hubiMsgDataLen = hubiMsgDatas.length;

        List<KetteiHoryuuHubiDataSourceBean> ketteiHoryuuHubiDataSourceBeanLst = new ArrayList<KetteiHoryuuHubiDataSourceBean>();
        List<SeirituHoryuuHubiDataSourceBean> seirituHoryuuHubiDataSourceBeanLst = new ArrayList<SeirituHoryuuHubiDataSourceBean>();
        List<WarningDataSourceBean> warningDataSourceBeanLst = new ArrayList<WarningDataSourceBean>();
        List<KihonHubiDataSourceBean> kihonHubiDataSourceBeanLst = new ArrayList<KihonHubiDataSourceBean>();

        for (int i = 0; i < hubiMsgDataLen; i++) {
            tmpDatas = hubiMsgDatas[i].trim().split(" ", 3);

            if (C_HubisyubetuKbn.KETHORYU_HUBI.getValue().equals(tmpDatas[0])) {
                KetteiHoryuuHubiDataSourceBean ketteiHoryuuHubiDataSourceBean = new KetteiHoryuuHubiDataSourceBean();

                ketteiHoryuuHubiDataSourceBean.setMsgsyubetu(C_MsgSyubetu.valueOf(tmpDatas[1].substring(0, 1)));
                ketteiHoryuuHubiDataSourceBean.setDisphubimsgid(tmpDatas[1]);
                ketteiHoryuuHubiDataSourceBean.setDisphubimsg(tmpDatas[2]);

                ketteiHoryuuHubiDataSourceBeanLst.add(ketteiHoryuuHubiDataSourceBean);
            }
            else if (C_HubisyubetuKbn.SRHORYU_HUBI.getValue().equals(tmpDatas[0])) {
                SeirituHoryuuHubiDataSourceBean seirituHoryuuHubiDataSourceBean = new SeirituHoryuuHubiDataSourceBean();

                seirituHoryuuHubiDataSourceBean.setMsgsyubetu(C_MsgSyubetu.valueOf(tmpDatas[1].substring(0, 1)));
                seirituHoryuuHubiDataSourceBean.setDisphubimsgid(tmpDatas[1]);
                seirituHoryuuHubiDataSourceBean.setDisphubimsg(tmpDatas[2]);

                seirituHoryuuHubiDataSourceBeanLst.add(seirituHoryuuHubiDataSourceBean);
            }
            else if (C_HubisyubetuKbn.WARNING.getValue().equals(tmpDatas[0])) {
                WarningDataSourceBean warningDataSourceBean = new WarningDataSourceBean();

                warningDataSourceBean.setMsgsyubetu(C_MsgSyubetu.valueOf(tmpDatas[1].substring(0, 1)));
                warningDataSourceBean.setDisphubimsgid(tmpDatas[1]);
                warningDataSourceBean.setDisphubimsg(tmpDatas[2]);

                warningDataSourceBeanLst.add(warningDataSourceBean);
            }
            else if (C_HubisyubetuKbn.KIHON_HUBI.getValue().equals(tmpDatas[0])) {
                KihonHubiDataSourceBean kihonHubiDataSourceBean = new KihonHubiDataSourceBean();

                kihonHubiDataSourceBean.setMsgsyubetu(C_MsgSyubetu.valueOf(tmpDatas[1].substring(0, 1)));
                kihonHubiDataSourceBean.setDisphubimsgid(tmpDatas[1]);
                kihonHubiDataSourceBean.setDisphubimsg(tmpDatas[2]);

                kihonHubiDataSourceBeanLst.add(kihonHubiDataSourceBean);
            }
        }

        uiBean.setKetteiHoryuuHubi(ketteiHoryuuHubiDataSourceBeanLst);
        uiBean.setSeirituHoryuuHubi(seirituHoryuuHubiDataSourceBeanLst);
        uiBean.setWarning(warningDataSourceBeanLst);
        uiBean.setKihonHubi(kihonHubiDataSourceBeanLst);

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri = getSkTtdkTyuui.getTtdkTyuuiKanri(mosNo);

        if (skTtdkTyuuiKanri != null) {
            uiBean.setSkeittdkkinkyuyouhikbn(skTtdkTyuuiKanri.getSkeittdkkinkyuyouhikbn());
            uiBean.setSkeittdktyuuiyouhikbn(skTtdkTyuuiKanri.getSkeittdktyuuiyouhikbn());
        }
        ArrayList<String> ttdkTyuiTrtNaiyos = new ArrayList<String>();
        ArrayList<BizDate> ttdkTyuiTrtTrkYmds = new ArrayList<BizDate>();
        ArrayList<String> ttdkTyuiTrtTantous = new ArrayList<String>();
        ArrayList<String> ttdkTyuiStNaiyos = new ArrayList<String>();
        ArrayList<BizDate> ttdkTyuiStTrkYmds = new ArrayList<BizDate>();
        ArrayList<String> ttdkTyuiStTantous = new ArrayList<String>();

        getSTTtdkTyuuiInfo(mosNo,
            C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO,
            ttdkTyuiTrtNaiyos,
            ttdkTyuiTrtTrkYmds,
            ttdkTyuiTrtTantous);

        getSTTtdkTyuuiInfo(
            mosNo,
            C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO,
            ttdkTyuiStNaiyos,
            ttdkTyuiStTrkYmds,
            ttdkTyuiStTantous);

        List<SkToriatukaiTyuuiInfoDataSourceBean> skTorTyuInfoDataSrcLst = new ArrayList<SkToriatukaiTyuuiInfoDataSourceBean>();

        for (int i = 0; i < ttdkTyuiTrtTantous.size(); i++) {
            SkToriatukaiTyuuiInfoDataSourceBean skToriatukaiTyuuiInfoDataSourceBean =
                SWAKInjector.getInstance(SkToriatukaiTyuuiInfoDataSourceBean.class);

            skToriatukaiTyuuiInfoDataSourceBean.setDispskeittdktyuitrttrkymd(ttdkTyuiTrtTrkYmds.get(i));
            skToriatukaiTyuuiInfoDataSourceBean.setDispskeittdktyuitrtnaiyo(ttdkTyuiTrtNaiyos.get(i));
            skToriatukaiTyuuiInfoDataSourceBean.setDispskeittdktyuitrttantou(ttdkTyuiTrtTantous.get(i));

            skTorTyuInfoDataSrcLst.add(skToriatukaiTyuuiInfoDataSourceBean);
        }
        uiBean.setSkToriatukaiTyuuiInfo(skTorTyuInfoDataSrcLst);

        List<SonotaTyuuiInfoDataSourceBean> sonotaTyuuiInfoDataSourceBeanLst = new ArrayList<SonotaTyuuiInfoDataSourceBean>();

        for (int i = 0; i < ttdkTyuiStTantous.size(); i++) {
            SonotaTyuuiInfoDataSourceBean sonotaTyuuiInfoDataSourceBean =
                SWAKInjector.getInstance(SonotaTyuuiInfoDataSourceBean.class);

            sonotaTyuuiInfoDataSourceBean.setDispskeittdktyuisttrkymd(ttdkTyuiStTrkYmds.get(i));
            sonotaTyuuiInfoDataSourceBean.setDispskeittdktyuistnaiyo(ttdkTyuiStNaiyos.get(i));
            sonotaTyuuiInfoDataSourceBean.setDispskeittdktyuisttantou(ttdkTyuiStTantous.get(i));

            sonotaTyuuiInfoDataSourceBeanLst.add(sonotaTyuuiInfoDataSourceBean);
        }
        uiBean.setSonotaTyuuiInfo(sonotaTyuuiInfoDataSourceBeanLst);
    }

    private void hubiInsertSearch() {

        checkMosno();

        String mosNo = null;
        String comment = null;
        HT_SyoriCTL syoriCTL = null;
        List<HT_SkHubi> skHubiLst = null;
        List<HubiItiranDataSourceBean> hubiIchiranDataSourceBeanLst = new ArrayList<HubiItiranDataSourceBean>();

        clearParamHubiTrkInfo();
        BizPropertyInitializer.initialize(uiBean);

        mosNo = uiBean.getMosno();

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        skHubiLst = syoriCTL.getSkHubis();

        if (skHubiLst.size() > 0) {

            EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
            editSecurityKm.init(skHubiLst.get(0).getMosno());
            comment = editSecurityKm.decode(skHubiLst.get(0).getCommentarea());

            uiBean.setUtdskknnm1kj(skHubiLst.get(0).getUtdskknnm1kj());
            uiBean.setUtdskknnm2kj(skHubiLst.get(0).getUtdskknnm2kj());
            uiBean.setTuutisakitantounmkj(skHubiLst.get(0).getTuutisakitantounmkj());
            uiBean.setCommentareagamen(comment);

            List<HT_SkHubiDetail> skHubiDetailLst = skHubiLst.get(0).getSkHubiDetails();

            List<HT_SkHubiDetail> skHubiDetailForSortList = new ArrayList<HT_SkHubiDetail>(skHubiDetailLst);
            SortHT_SkHubiDetail skHubiDetailSort = SWAKInjector.getInstance(SortHT_SkHubiDetail.class);
            skHubiDetailForSortList = skHubiDetailSort.OrderHT_SkHubiDetailByHasinymdAsc(skHubiDetailForSortList);

            String hubiKbn        = null;
            String hubiRiyuu      = null;
            String iraiNaiyou     = null;
            String renrakuJikou   = null;
            String hubiKbnCd      = null;
            String hubiRiyuuCd    = null;
            String sijiNaiyouCd   = null;
            hubiIchiranDataSourceBeanLst = new ArrayList<HubiItiranDataSourceBean>();

            for (int i = 0; i < skHubiDetailForSortList.size(); i++) {
                HubiItiranDataSourceBean hubiIchiranDataSourceBean =
                    SWAKInjector.getInstance(HubiItiranDataSourceBean.class);

                HT_SkHubiDetail skHubiDetail = skHubiDetailForSortList.get(i);
                HM_SkHubiNaiyou skHubiNaiyou = skHubiDetail.getSkHubiNaiyou();
                HM_SkHubiKoumoku skHubiKoumoku = skHubiDetail.getSkHubiKoumoku();
                HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou = skHubiDetail.getSkSeibiSijiNaiyou();

                renrakuJikou = editSecurityKm.decode(skHubiDetail.getSkrenrakujikou());

                if (!BizUtil.isBlank(skHubiDetail.getSkhubikoumokucd())) {
                    hubiKbnCd = ConvertUtil.toZenAll(skHubiDetail.getSkhubikoumokucd() ,0 ,1);
                }

                if (!BizUtil.isBlank(skHubiDetail.getSkhubinaiyoucd())) {
                    hubiRiyuuCd = ConvertUtil.toZenAll(skHubiDetail.getSkhubinaiyoucd() ,0 ,1);
                }

                if (!BizUtil.isBlank(skHubiDetail.getSkseibisijinaiyoucd())) {
                    sijiNaiyouCd = ConvertUtil.toZenAll(skHubiDetail.getSkseibisijinaiyoucd() ,0 ,1);
                }

                hubiKbn = hubiKbnCd + SkMosSyoukaiConstants.ZENNKAKUSPACE + skHubiKoumoku.getSkhubikoumoku();
                hubiRiyuu = hubiRiyuuCd + SkMosSyoukaiConstants.ZENNKAKUSPACE + skHubiNaiyou.getSkhubinaiyou();
                iraiNaiyou = sijiNaiyouCd + SkMosSyoukaiConstants.ZENNKAKUSPACE + skSeibiSijiNaiyou.getSkseibisijinaiyou();

                hubiIchiranDataSourceBean.setDisptrkymd(skHubiDetail.getTrkymd());
                hubiIchiranDataSourceBean.setDispskhubikoumoku(hubiKbn);
                hubiIchiranDataSourceBean.setDispskhubinaiyou(hubiRiyuu);
                hubiIchiranDataSourceBean.setDispskseibisijinaiyou(iraiNaiyou);
                hubiIchiranDataSourceBean.setDisprenrakujikou(renrakuJikou);
                hubiIchiranDataSourceBean.setDisphassinymd(skHubiDetail.getHasinymd());
                hubiIchiranDataSourceBean.setDispkaisyouymd(skHubiDetail.getKaisyouymd());
                hubiIchiranDataSourceBean.setDisphasinkyokakbn(skHubiDetail.getHasinkyokakbn());
                hubiIchiranDataSourceBean.setDisphassinsakikbn(skHubiDetail.getHassinsakikbn());

                AM_User user = skHubiDetail.getUser();
                if (user != null) {
                    hubiIchiranDataSourceBean.setDispnyuryokutantounm(user.getUserNm());
                }
                else {
                    hubiIchiranDataSourceBean.setDispnyuryokutantounm("");
                }

                hubiIchiranDataSourceBean.setTyoubunFlg(skHubiDetail.getTyoubunflg());

                if (C_UmuKbn.ARI.eq(skHubiDetail.getTyoubunflg())) {
                    hubiIchiranDataSourceBean.setTyoubundisprenrakujikou(renrakuJikou);
                }
                else {
                    hubiIchiranDataSourceBean.setDisprenrakujikou(renrakuJikou);
                }

                hubiIchiranDataSourceBeanLst.add(hubiIchiranDataSourceBean);
            }
        }
        else {
            hubiIchiranDataSourceBeanLst.add(SWAKInjector.getInstance(HubiItiranDataSourceBean.class));
        }

        uiBean.setHubiItiran(hubiIchiranDataSourceBeanLst);

    }

    private void kykSyoukaiKengen() {
        boolean kyknaiyou = baseUserInfo.hasAuthenticatedFunctionModeByFunctionId("khkeiyakusyoukai", KHKINOUMODE_DEFAULT);

        if (kyknaiyou) {
            uiBean.setKyksyoukaiKngnUmu(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKyksyoukaiKngnUmu(C_UmuKbn.NONE);
        }
    }

    private boolean isBlank(String pValue) {
        if (pValue == null || pValue.length() == 0) {
            return true;
        }
        return false;
    }

    private void clearParam(boolean pAllclearflg) {

        if (pAllclearflg) {
            clearParamCommon();
            clearParamKeyInput();
            clearParamKensakuResult();
        }

        clearParamKeiyakuNaiyou();
        clearParamHubiJK();
        clearParamHubiTrkInfo();
        clearParamKetteiJK();
        clearParamNyuukinJK();
        clearParamSyoruiToutyakuJK();
        clearParamTeiseiRrkList();
        clearParamSakuinInfo();
        clearParamKouteijkList();

        BizPropertyInitializer.initialize(uiBean);
    }

    private void clearParamCommon() {

        uiBean.setMosno(null);
        uiBean.setSyono(null);
        uiBean.setKyksyoukaiKngnUmu(null);
        uiBean.setMosuktYmdHkUmu(null);
        uiBean.setGmSyoriKbn(null);
    }

    private void clearParamKeyInput() {
        uiBean.setSrchmosno(null);
        uiBean.setSrchsyono(null);
        uiBean.setSrchkanriid(null);
        uiBean.setSrchmosfromymd(null);
        uiBean.setSrchmostoymd(null);
        uiBean.setDrtencd(null);
        uiBean.setSrchkinyuucd(null);
        uiBean.setSrchnyknumu(null);
        uiBean.setSrchketteikbn(null);
        uiBean.setSrchseiritukbn(null);
        uiBean.setSrchkthhbari(null);
        uiBean.setSrchsrhhbari(null);
        uiBean.setSrchmkshbari(null);
        uiBean.setHknsyuruino(null);
        uiBean.setSrchkyknmkn(null);
        uiBean.setSrchkykseiymd(null);
        uiBean.setDrtncdkensakukbn(C_DrtnCdKensakuKbn.TRATKIDRTEN);

        uiBean.setSrchDaimosno(null);
        uiBean.setSrchBosyuuym(null);
    }

    private void clearParamKensakuResult() {
        uiBean.setKensakuKekkaLst(null);
        uiBean.setKensakuKekka(null);
    }

    private void clearParamKeiyakuNaiyou() {


        uiBean.setSateijtkbn(null);
        uiBean.setSateizumiymd(null);
        uiBean.setJimuyoucd(null);
        uiBean.setLastrsymd(null);
        uiBean.setZenhnknkbn(null);
        uiBean.setMosnrkumu(null);
        uiBean.setKkthjykbn(null);
        uiBean.setNyknnrkumu(null);
        uiBean.setRyosyuymd(null);
        uiBean.setMostenkenjoukbn(null);
        uiBean.setHubiumu(null);
        uiBean.setKykkakjkkbn(null);
        uiBean.setLincjkkbn(null);
        uiBean.setLinckknnjkkbn(null);
        uiBean.setKnkysateijyoukbn(null);
        uiBean.setImusateijyoukbn(null);
        uiBean.setKetteikbn(null);
        uiBean.setJimusrhkbn(null);
        uiBean.setSeiritukbn(null);
        uiBean.setSrsyoriymd(null);
        uiBean.setSyohakkouymd(null);

        uiBean.setMostenken1jiyhkbn(null);
        uiBean.setMostenken2jiyhkbn(null);
        uiBean.setKnkysatei1jiyhkbn(null);
        uiBean.setKnkysatei2jiyhkbn(null);
        uiBean.setImusateikaniyhkbn(null);
        uiBean.setLincgthtkekkbn(null);

        uiBean.setMosnrkvrfjkkbn(null);
        uiBean.setKktnrkvrfjkkbn(null);

        uiBean.setAitemosno(null);
        uiBean.setDoujikaiyakusyono(null);
        uiBean.setMosymd(null);
        uiBean.setSsyukeymd(null);
        uiBean.setKykymd(null);
        uiBean.setSkykymdkbn(null);
        uiBean.setBosyuuym(null);
        uiBean.setSknnkaisiymd(null);
        uiBean.setSeisekiym(null);

        uiBean.setMosuketukekbn(null);
        uiBean.setHknsyuruinm(null);
        uiBean.setAisyoumei(null);
        uiBean.setSnshuhusyurui(null);

        uiBean.setKykkbn(null);
        uiBean.setYakkanjyuryouhoukbn(null);
        uiBean.setYakkanbunsyono(null);
        uiBean.setFatcasnsikbn(null);
        uiBean.setBikkjnssinfokbn(null);
        uiBean.setFatcakakkekkakbn(null);
        uiBean.setAeoisnsikbn(null);
        uiBean.setAeoikekkakbn(null);
        uiBean.setKyknmkn(null);
        uiBean.setKyknmkj(null);
        uiBean.setKyknmkjkhukakbn(null);
        uiBean.setKykseiymd(null);
        uiBean.setKyksei(null);
        uiBean.setKyknen(null);
        uiBean.setKyktdk(null);

        uiBean.setTsinyno(null);
        uiBean.setTsinadr1kj(null);
        uiBean.setTsinadr2kj(null);
        uiBean.setTsinadr3kj(null);
        uiBean.setTsintelno(null);
        uiBean.setDai2tsintelno(null);

        uiBean.setHhknnmkn(null);
        uiBean.setHhknnmkj(null);
        uiBean.setHhknnmkjkhukakbn(null);
        uiBean.setHhknseiymd(null);
        uiBean.setHhknsei(null);
        uiBean.setHhknnen(null);
        uiBean.setTsindousiteikbn(null);
        uiBean.setHhknyno(null);
        uiBean.setHhknadr1kj(null);
        uiBean.setHhknadr2kj(null);
        uiBean.setHhknadr3kj(null);
        uiBean.setHhkntelno(null);
        uiBean.setKktymd(null);
        uiBean.setHhknsykgycd(null);
        uiBean.setHhknsykgynm(null);
        uiBean.setHhknnensyuukbn(null);

        uiBean.setNenkinuktkbn(null);

        uiBean.setSbuktnin(null);

        uiBean.setSbuUktSyurenNo1(null);
        uiBean.setDispsbuktkbn1(null);
        uiBean.setDispsbuktnmkn1(null);
        uiBean.setDispsbuktnmkj1(null);
        uiBean.setDispsbuktnmkjhukakbn1(null);
        uiBean.setDispsbuktseiymd1(null);
        uiBean.setDispsbukttdk1(null);
        uiBean.setDispsbuktbnwari1(null);

        uiBean.setSbuUktSyurenNo2(null);
        uiBean.setDispsbuktkbn2(null);
        uiBean.setDispsbuktnmkn2(null);
        uiBean.setDispsbuktnmkj2(null);
        uiBean.setDispsbuktnmkjhukakbn2(null);
        uiBean.setDispsbuktseiymd2(null);
        uiBean.setDispsbukttdk2(null);
        uiBean.setDispsbuktbnwari2(null);

        uiBean.setSbuUktSyurenNo3(null);
        uiBean.setDispsbuktkbn3(null);
        uiBean.setDispsbuktnmkn3(null);
        uiBean.setDispsbuktnmkj3(null);
        uiBean.setDispsbuktnmkjhukakbn3(null);
        uiBean.setDispsbuktseiymd3(null);
        uiBean.setDispsbukttdk3(null);
        uiBean.setDispsbuktbnwari3(null);

        uiBean.setSbuUktSyurenNo4(null);
        uiBean.setDispsbuktkbn4(null);
        uiBean.setDispsbuktnmkn4(null);
        uiBean.setDispsbuktnmkj4(null);
        uiBean.setDispsbuktnmkjhukakbn4(null);
        uiBean.setDispsbuktseiymd4(null);
        uiBean.setDispsbukttdk4(null);
        uiBean.setDispsbuktbnwari4(null);

        uiBean.setKzktourokuservicetourokukbn(null);

        uiBean.setTrkkzknmkn1(null);
        uiBean.setTrkkzknmkj1(null);
        uiBean.setTrkkzknmkjkhukakbn1(null);
        uiBean.setTrkkzkseiymd1(null);
        uiBean.setTrkkzksei1(null);
        uiBean.setTrkkzktdk1(null);
        uiBean.setTrkkzktsindousiteikbn1(null);
        uiBean.setTrkkzkyno1(null);
        uiBean.setTrkkzkadr1kj1(null);
        uiBean.setTrkkzkadr2kj1(null);
        uiBean.setTrkkzkadr3kj1(null);
        uiBean.setTrkkzktelno1(null);

        uiBean.setTrkkzknmkn2(null);
        uiBean.setTrkkzknmkj2(null);
        uiBean.setTrkkzknmkjkhukakbn2(null);
        uiBean.setTrkkzkseiymd2(null);
        uiBean.setTrkkzksei2(null);
        uiBean.setTrkkzktdk2(null);
        uiBean.setTrkkzktsindousiteikbn2(null);
        uiBean.setTrkkzkyno2(null);
        uiBean.setTrkkzkadr1kj2(null);
        uiBean.setTrkkzkadr2kj2(null);
        uiBean.setTrkkzkadr3kj2(null);
        uiBean.setTrkkzktelno2(null);

        uiBean.setKykdrtkykhukakbn(null);
        uiBean.setKykdrkbn(null);

        uiBean.setStdrsktkyhkkbn(null);
        uiBean.setStdruktkbn(null);
        uiBean.setSiteidruktnmkn(null);
        uiBean.setSiteidruktnmkj(null);
        uiBean.setStdrsknmkjhukakbn(null);
        uiBean.setSiteidrseiymd(null);
        uiBean.setSiteidrukttdk(null);

        uiBean.setSyuhknkkn(null);
        uiBean.setSyuhknkknsmnkbn(null);
        uiBean.setSyuhrkkkn(null);
        uiBean.setSyuhrkkknsmnkbn(null);
        uiBean.setNkshrstartnen(null);
        uiBean.setSueokikkn(null);
        uiBean.setSyudai1hknkkn(null);
        uiBean.setSdpdkbn(null);
        uiBean.setHaitoukbn(null);
        uiBean.setSknenkinsyu(null);
        uiBean.setZenkizennouumu(null);
        uiBean.setZnnkai(null);
        uiBean.setHrkkaisuu(null);
        uiBean.setHrkkeiro(null);
        uiBean.setFstphrkkeirokbn(null);
        uiBean.setIkkatubaraikaisuu(null);
        uiBean.setKyktuukasyu(null);
        uiBean.setHrktuukasyu(null);
        uiBean.setSyukihons(null);
        uiBean.setSyumoskihons(null);
        uiBean.setHrktuukasyukykp(null);
        uiBean.setSyup(null);
        uiBean.setMossyup(null);
        uiBean.setNyknkwsratekijyunymd(null);
        uiBean.setTyuuimongon1(null);
        uiBean.setNyknkwsrate(null);
        uiBean.setTyuuimongon2(null);
        uiBean.setSisuuhaibunwarikbn(null);
        uiBean.setSisuunm(null);
        uiBean.setTeirituhaibunwarikbn(null);
        uiBean.setNkgnshosyouritukbn(null);
        uiBean.setPwaribikitekiyoukbn(null);
        uiBean.setInquiryyoteiriritu(null);
        uiBean.setTyuuimongon3(null);
        uiBean.setInquirytumitateriritu(null);
        uiBean.setInquiryloadinghnkgtmttrrt(null);
        uiBean.setTyuuimongon4(null);
        uiBean.setInquirytmttknzoukaritujygn(null);
        uiBean.setTyuuimongon5(null);
        uiBean.setInquirysetteibairitu(null);
        uiBean.setTyuuimongon6(null);
        uiBean.setInquiryrendouritu(null);
        uiBean.setTyuuimongon7(null);
        uiBean.setDispfstphrkgk(null);
        uiBean.setMosfstpkei(null);
        uiBean.setIkkatup(null);
        uiBean.setMosikkatup(null);
        uiBean.setZennoup(null);
        uiBean.setMoszennoupsyokaiari(null);
        uiBean.setPharaikomisougaku(null);

        uiBean.setSyksbyensitihsyutkhkkbn(null);
        uiBean.setJyudkaigomehrtkhkkbn(null);
        uiBean.setNstkhkkbn(null);
        uiBean.setNstksbnkkn(null);
        uiBean.setTargettkmkhtkbn(null);
        uiBean.setMkhyouyensysnikougk(null);
        uiBean.setTargettkykkijyungk(null);
        uiBean.setKjnnkpzeitekitkhukakbn(null);

        uiBean.setTargettkhkkbn(null);
        uiBean.setYennykntkhkkbn(null);
        uiBean.setGaikanykntkhkkbn(null);

        uiBean.setTeikisiharaitkykhkkbn(null);
        uiBean.setYnkhrkmgkannituutikbn(null);
        uiBean.setTeikisiharaikin(null);
        uiBean.setZennouphrkgk(null);

        uiBean.setKzsyuruikbn(null);
        uiBean.setBankcd(null);
        uiBean.setBanknmkj(null);
        uiBean.setSitencd(null);
        uiBean.setSitennmkj(null);
        uiBean.setYokinkbn(null);
        uiBean.setKouzano(null);
        uiBean.setKzkykdoukbn(null);
        uiBean.setKzmeiginmkn(null);

        uiBean.setKzhuritourokuhoukbn(null);
        uiBean.setKouhurikouzainfobankcd(null);
        uiBean.setKouhurikouzainfobanknmkj(null);
        uiBean.setKouhurikouzainfositencd(null);
        uiBean.setKouhurikouzainfositennmkj(null);
        uiBean.setKouhurikouzainfoyokinkbn(null);
        uiBean.setKouhurikouzainfokouzano(null);
        uiBean.setKouhurikouzainfokzdoukbn(null);
        uiBean.setKouhurikouzainfokzmeiginmkn(null);
        uiBean.setKouzakakuniniraikbn(null);

        uiBean.setAuthorikakymd(null);
        uiBean.setCardbrandkbn(null);
        uiBean.setCredittrkjk(null);
        uiBean.setDispcreditkessaiyouno(null);
        uiBean.setCredittrkhoukbn(null);

        uiBean.setKykhonninkakninsyoruikbn(null);
        uiBean.setSkskknhonninkakninsyoruikbn(null);

        uiBean.setKoureikzksetumeihoukbn(null);
        uiBean.setKoureimndnhukusuukaikbn(null);
        uiBean.setKoureitratkisyaigidskkbn(null);

        uiBean.setMosDairitenRenno1(null);
        uiBean.setDispjimusyocd1(null);
        uiBean.setDispkinyuucd1(null);
        uiBean.setDispkinyuusitencd1(null);
        uiBean.setDisptratkikouinncd1(null);
        uiBean.setDispinputbosyuucd1(null);
        uiBean.setDispbosyuutrkno1(null);
        uiBean.setDisptratkiagcd1(null);
        uiBean.setDisptratkiagnm1(null);
        uiBean.setDispoyadrtencd1(null);
        uiBean.setDispoyadrtennm1(null);
        uiBean.setDispbosyuucd1(null);
        uiBean.setDispbosyuunm1(null);
        uiBean.setDispgyskkjsakisosikicd1(null);
        uiBean.setDispgyskkjsakisosikinmkj1(null);
        uiBean.setDispbunwari1(null);
        uiBean.setCifcd(null);
        uiBean.setUktkid(null);

        uiBean.setMosDairitenRenno2(null);
        uiBean.setDispjimusyocd2(null);
        uiBean.setDispkinyuucd2(null);
        uiBean.setDispkinyuusitencd2(null);
        uiBean.setDisptratkikouinncd2(null);
        uiBean.setDispinputbosyuucd2(null);
        uiBean.setDispbosyuutrkno2(null);
        uiBean.setDisptratkiagcd2(null);
        uiBean.setDisptratkiagnm2(null);
        uiBean.setDispoyadrtencd2(null);
        uiBean.setDispoyadrtennm2(null);
        uiBean.setDispbosyuucd2(null);
        uiBean.setDispbosyuunm2(null);
        uiBean.setDispgyskkjsakisosikicd2(null);
        uiBean.setDispgyskkjsakisosikinmkj2(null);
        uiBean.setDispbunwari2(null);

        uiBean.setKouseiinkykkbn(null);
        uiBean.setKouseiinkyktkjkumukbn(null);

        uiBean.setKoukankykkbn(null);
        uiBean.setKoukankykkinmusakinm(null);
        uiBean.setKoukankyksyokumunaiyou(null);
        uiBean.setKoukankyktkjkumukbn(null);

        uiBean.setTsryhshrkykumukbn(null);
        uiBean.setSyosisyatodokeumukbn(null);
        uiBean.setKakukisyouryakukbumukbn(null);
        uiBean.setSeiymdmosseitouumukbn(null);

        uiBean.setDrctservicemoskbn(null);
        uiBean.setDskokno(null);
        uiBean.setDsmailaddress(null);
        uiBean.setDsbankcd(null);
        uiBean.setDsbanknmkj(null);
        uiBean.setDssitencd(null);
        uiBean.setDssitennmkj(null);
        uiBean.setDsyokinkbn(null);
        uiBean.setDskouzano(null);
        uiBean.setDskzmeiginmkn(null);


        uiBean.setTkhjnkbn(null);
        uiBean.setTkhsyouryakuumukbn(null);

        uiBean.setDaimosno(null);
        uiBean.setSyokugyoukktumu(null);
        uiBean.setGaikatatkiumu(null);
        uiBean.setNkhknumu(null);
        uiBean.setHengakuumu(null);
        uiBean.setNstkumu(null);
        uiBean.setTargettkhukakanoukbn(null);
        uiBean.setSyksbyensitihsyutktekiumu(null);
        uiBean.setJyudkaigomehrtktekiumu(null);
        uiBean.setSyuusinhknumu(null);
        uiBean.setSbuktumu(null);
        uiBean.setTeikisiharaikinumu(null);
        uiBean.setKykdrtentuusanumu(null);
        uiBean.setTmttknhaibunwarisiteiumu(null);
        uiBean.setNkuktumu(null);
        uiBean.setCreditcardhrtekiumu(null);
        uiBean.setPtratkituukasiteikbn(null);
        uiBean.setHokenkngkyakujyouumu(null);
        uiBean.setSeigyoHknsyuruino(null);

    }

    private void clearParamHubiJK() {

        uiBean.setKthhbkbn(null);
        uiBean.setSrhhbkbn(null);
        uiBean.setKhnhbkbn(null);
        uiBean.setKetteiHoryuuHubi(null);
        uiBean.setSeirituHoryuuHubi(null);
        uiBean.setWarning(null);
        uiBean.setKihonHubi(null);
        uiBean.setSkeittdkkinkyuyouhikbn(null);
        uiBean.setSkeittdktyuuiyouhikbn(null);
        uiBean.setSkToriatukaiTyuuiInfo(null);
        uiBean.setSonotaTyuuiInfo(null);
    }

    private void clearParamHubiTrkInfo() {

        uiBean.setHubiItiran(null);
        uiBean.setUtdskknnm1kj(null);
        uiBean.setUtdskknnm2kj(null);
        uiBean.setTuutisakitantounmkj(null);
        uiBean.setCommentareagamen(null);
    }

    private void clearParamKetteiJK() {

        uiBean.setKktkktymd(null);
        uiBean.setSintyou(null);
        uiBean.setTaijyuu(null);
        uiBean.setKituenkbn(null);
        uiBean.setKituenhon(null);
        uiBean.setKijikbn(null);
        uiBean.setKzkkijikbn(null);

        uiBean.setKhnchkcmnt(null);

        uiBean.setMostenkensjnaiyou(null);
        uiBean.setMostenkenRirekiNo1(null);
        uiBean.setDispmostenkensyoriymd1(null);
        uiBean.setDispmostnknstktsyorinmkbn1(null);
        uiBean.setDispmostenkenkekkakbn1(null);
        uiBean.setDispmostns1(null);
        uiBean.setDispmostenkenktnm1(null);
        uiBean.setDispmostenkencomment1(null);
        uiBean.setMostenkenRirekiNo2(null);
        uiBean.setDispmostenkensyoriymd2(null);
        uiBean.setDispmostnknstktsyorinmkbn2(null);
        uiBean.setDispmostenkenkekkakbn2(null);
        uiBean.setDispmostns2(null);
        uiBean.setDispmostenkenktnm2(null);
        uiBean.setDispmostenkencomment2(null);
        uiBean.setMostenkenRirekiNo3(null);
        uiBean.setDispmostenkensyoriymd3(null);
        uiBean.setDispmostnknstktsyorinmkbn3(null);
        uiBean.setDispmostenkenkekkakbn3(null);
        uiBean.setDispmostns3(null);
        uiBean.setDispmostenkenktnm3(null);
        uiBean.setDispmostenkencomment3(null);
        uiBean.setMostenkenRirekiNo4(null);
        uiBean.setDispmostenkensyoriymd4(null);
        uiBean.setDispmostnknstktsyorinmkbn4(null);
        uiBean.setDispmostenkenkekkakbn4(null);
        uiBean.setDispmostns4(null);
        uiBean.setDispmostenkenktnm4(null);
        uiBean.setDispmostenkencomment4(null);
        uiBean.setMostenkenRirekiNo5(null);
        uiBean.setDispmostenkensyoriymd5(null);
        uiBean.setDispmostnknstktsyorinmkbn5(null);
        uiBean.setDispmostenkenkekkakbn5(null);
        uiBean.setDispmostns5(null);
        uiBean.setDispmostenkenktnm5(null);
        uiBean.setDispmostenkencomment5(null);
        uiBean.setMostenkenRirekiNo6(null);
        uiBean.setDispmostenkensyoriymd6(null);
        uiBean.setDispmostnknstktsyorinmkbn6(null);
        uiBean.setDispmostenkenkekkakbn6(null);
        uiBean.setDispmostns6(null);
        uiBean.setDispmostenkenktnm6(null);
        uiBean.setDispmostenkencomment6(null);
        uiBean.setMostenkenRirekiNo7(null);
        uiBean.setDispmostenkensyoriymd7(null);
        uiBean.setDispmostnknstktsyorinmkbn7(null);
        uiBean.setDispmostenkenkekkakbn7(null);
        uiBean.setDispmostns7(null);
        uiBean.setDispmostenkenktnm7(null);
        uiBean.setDispmostenkencomment7(null);
        uiBean.setMostenkenRirekiNo8(null);
        uiBean.setDispmostenkensyoriymd8(null);
        uiBean.setDispmostnknstktsyorinmkbn8(null);
        uiBean.setDispmostenkenkekkakbn8(null);
        uiBean.setDispmostns8(null);
        uiBean.setDispmostenkenktnm8(null);
        uiBean.setDispmostenkencomment8(null);
        uiBean.setMostenkenRirekiNo9(null);
        uiBean.setDispmostenkensyoriymd9(null);
        uiBean.setDispmostnknstktsyorinmkbn9(null);
        uiBean.setDispmostenkenkekkakbn9(null);
        uiBean.setDispmostns9(null);
        uiBean.setDispmostenkenktnm9(null);
        uiBean.setDispmostenkencomment9(null);
        uiBean.setMostenkenRirekiNo10(null);
        uiBean.setDispmostenkensyoriymd10(null);
        uiBean.setDispmostnknstktsyorinmkbn10(null);
        uiBean.setDispmostenkenkekkakbn10(null);
        uiBean.setDispmostns10(null);
        uiBean.setDispmostenkenktnm10(null);
        uiBean.setDispmostenkencomment10(null);
        uiBean.setMostenkenRirekiNo11(null);
        uiBean.setDispmostenkensyoriymd11(null);
        uiBean.setDispmostnknstktsyorinmkbn11(null);
        uiBean.setDispmostenkenkekkakbn11(null);
        uiBean.setDispmostns11(null);
        uiBean.setDispmostenkenktnm11(null);
        uiBean.setDispmostenkencomment11(null);
        uiBean.setMostenkenRirekiNo12(null);
        uiBean.setDispmostenkensyoriymd12(null);
        uiBean.setDispmostnknstktsyorinmkbn12(null);
        uiBean.setDispmostenkenkekkakbn12(null);
        uiBean.setDispmostns12(null);
        uiBean.setDispmostenkenktnm12(null);
        uiBean.setDispmostenkencomment12(null);
        uiBean.setMostenkenRirekiNo13(null);
        uiBean.setDispmostenkensyoriymd13(null);
        uiBean.setDispmostnknstktsyorinmkbn13(null);
        uiBean.setDispmostenkenkekkakbn13(null);
        uiBean.setDispmostns13(null);
        uiBean.setDispmostenkenktnm13(null);
        uiBean.setDispmostenkencomment13(null);
        uiBean.setMostenkenRirekiNo14(null);
        uiBean.setDispmostenkensyoriymd14(null);
        uiBean.setDispmostnknstktsyorinmkbn14(null);
        uiBean.setDispmostenkenkekkakbn14(null);
        uiBean.setDispmostns14(null);
        uiBean.setDispmostenkenktnm14(null);
        uiBean.setDispmostenkencomment14(null);
        uiBean.setMostenkenRirekiNo15(null);
        uiBean.setDispmostenkensyoriymd15(null);
        uiBean.setDispmostnknstktsyorinmkbn15(null);
        uiBean.setDispmostenkenkekkakbn15(null);
        uiBean.setDispmostns15(null);
        uiBean.setDispmostenkenktnm15(null);
        uiBean.setDispmostenkencomment15(null);

        uiBean.setKnksateisjnaiyou(null);
        uiBean.setKankyouSateiRirekiNo1(null);
        uiBean.setDispknksyoriymd1(null);
        uiBean.setDispknkstktsyorinmkbn1(null);
        uiBean.setDispknkkekkakbn1(null);
        uiBean.setDispknktns1(null);
        uiBean.setDispknkktnm1(null);
        uiBean.setDispknkcomment1(null);
        uiBean.setDispknkktkkcd1(null);
        uiBean.setDispknktrkssyousairiyuu1(null);
        uiBean.setDispknkketriyuucd11(null);
        uiBean.setDispknkketriyuunaiyou11(null);
        uiBean.setDispknkketriyuucd21(null);
        uiBean.setDispknkketriyuunaiyou21(null);
        uiBean.setDispknkketriyuucd31(null);
        uiBean.setDispknkketriyuunaiyou31(null);
        uiBean.setDispknkketriyuucd41(null);
        uiBean.setDispknkketriyuunaiyou41(null);
        uiBean.setDispknkmrriyuucdnaiyou1(null);
        uiBean.setKankyouSateiRirekiNo2(null);
        uiBean.setDispknksyoriymd2(null);
        uiBean.setDispknkstktsyorinmkbn2(null);
        uiBean.setDispknkkekkakbn2(null);
        uiBean.setDispknktns2(null);
        uiBean.setDispknkktnm2(null);
        uiBean.setDispknkcomment2(null);
        uiBean.setDispknkktkkcd2(null);
        uiBean.setDispknktrkssyousairiyuu2(null);
        uiBean.setDispknkketriyuucd12(null);
        uiBean.setDispknkketriyuunaiyou12(null);
        uiBean.setDispknkketriyuucd22(null);
        uiBean.setDispknkketriyuunaiyou22(null);
        uiBean.setDispknkketriyuucd32(null);
        uiBean.setDispknkketriyuunaiyou32(null);
        uiBean.setDispknkketriyuucd42(null);
        uiBean.setDispknkketriyuunaiyou42(null);
        uiBean.setDispknkmrriyuucdnaiyou2(null);
        uiBean.setKankyouSateiRirekiNo3(null);
        uiBean.setDispknksyoriymd3(null);
        uiBean.setDispknkstktsyorinmkbn3(null);
        uiBean.setDispknkkekkakbn3(null);
        uiBean.setDispknktns3(null);
        uiBean.setDispknkktnm3(null);
        uiBean.setDispknkcomment3(null);
        uiBean.setDispknkktkkcd3(null);
        uiBean.setDispknktrkssyousairiyuu3(null);
        uiBean.setDispknkketriyuucd13(null);
        uiBean.setDispknkketriyuunaiyou13(null);
        uiBean.setDispknkketriyuucd23(null);
        uiBean.setDispknkketriyuunaiyou23(null);
        uiBean.setDispknkketriyuucd33(null);
        uiBean.setDispknkketriyuunaiyou33(null);
        uiBean.setDispknkketriyuucd43(null);
        uiBean.setDispknkketriyuunaiyou43(null);
        uiBean.setDispknkmrriyuucdnaiyou3(null);
        uiBean.setKankyouSateiRirekiNo4(null);
        uiBean.setDispknksyoriymd4(null);
        uiBean.setDispknkstktsyorinmkbn4(null);
        uiBean.setDispknkkekkakbn4(null);
        uiBean.setDispknktns4(null);
        uiBean.setDispknkktnm4(null);
        uiBean.setDispknkcomment4(null);
        uiBean.setDispknkktkkcd4(null);
        uiBean.setDispknktrkssyousairiyuu4(null);
        uiBean.setDispknkketriyuucd14(null);
        uiBean.setDispknkketriyuunaiyou14(null);
        uiBean.setDispknkketriyuucd24(null);
        uiBean.setDispknkketriyuunaiyou24(null);
        uiBean.setDispknkketriyuucd34(null);
        uiBean.setDispknkketriyuunaiyou34(null);
        uiBean.setDispknkketriyuucd44(null);
        uiBean.setDispknkketriyuunaiyou44(null);
        uiBean.setDispknkmrriyuucdnaiyou4(null);
        uiBean.setKankyouSateiRirekiNo5(null);
        uiBean.setDispknksyoriymd5(null);
        uiBean.setDispknkstktsyorinmkbn5(null);
        uiBean.setDispknkkekkakbn5(null);
        uiBean.setDispknktns5(null);
        uiBean.setDispknkktnm5(null);
        uiBean.setDispknkcomment5(null);
        uiBean.setDispknkktkkcd5(null);
        uiBean.setDispknktrkssyousairiyuu5(null);
        uiBean.setDispknkketriyuucd15(null);
        uiBean.setDispknkketriyuunaiyou15(null);
        uiBean.setDispknkketriyuucd25(null);
        uiBean.setDispknkketriyuunaiyou25(null);
        uiBean.setDispknkketriyuucd35(null);
        uiBean.setDispknkketriyuunaiyou35(null);
        uiBean.setDispknkketriyuucd45(null);
        uiBean.setDispknkketriyuunaiyou45(null);
        uiBean.setDispknkmrriyuucdnaiyou5(null);
        uiBean.setKankyouSateiRirekiNo6(null);
        uiBean.setDispknksyoriymd6(null);
        uiBean.setDispknkstktsyorinmkbn6(null);
        uiBean.setDispknkkekkakbn6(null);
        uiBean.setDispknktns6(null);
        uiBean.setDispknkktnm6(null);
        uiBean.setDispknkcomment6(null);
        uiBean.setDispknkktkkcd6(null);
        uiBean.setDispknktrkssyousairiyuu6(null);
        uiBean.setDispknkketriyuucd16(null);
        uiBean.setDispknkketriyuunaiyou16(null);
        uiBean.setDispknkketriyuucd26(null);
        uiBean.setDispknkketriyuunaiyou26(null);
        uiBean.setDispknkketriyuucd36(null);
        uiBean.setDispknkketriyuunaiyou36(null);
        uiBean.setDispknkketriyuucd46(null);
        uiBean.setDispknkketriyuunaiyou46(null);
        uiBean.setDispknkmrriyuucdnaiyou6(null);
        uiBean.setKankyouSateiRirekiNo7(null);
        uiBean.setDispknksyoriymd7(null);
        uiBean.setDispknkstktsyorinmkbn7(null);
        uiBean.setDispknkkekkakbn7(null);
        uiBean.setDispknktns7(null);
        uiBean.setDispknkktnm7(null);
        uiBean.setDispknkcomment7(null);
        uiBean.setDispknkktkkcd7(null);
        uiBean.setDispknktrkssyousairiyuu7(null);
        uiBean.setDispknkketriyuucd17(null);
        uiBean.setDispknkketriyuunaiyou17(null);
        uiBean.setDispknkketriyuucd27(null);
        uiBean.setDispknkketriyuunaiyou27(null);
        uiBean.setDispknkketriyuucd37(null);
        uiBean.setDispknkketriyuunaiyou37(null);
        uiBean.setDispknkketriyuucd47(null);
        uiBean.setDispknkketriyuunaiyou47(null);
        uiBean.setDispknkmrriyuucdnaiyou7(null);
        uiBean.setKankyouSateiRirekiNo8(null);
        uiBean.setDispknksyoriymd8(null);
        uiBean.setDispknkstktsyorinmkbn8(null);
        uiBean.setDispknkkekkakbn8(null);
        uiBean.setDispknktns8(null);
        uiBean.setDispknkktnm8(null);
        uiBean.setDispknkcomment8(null);
        uiBean.setDispknkktkkcd8(null);
        uiBean.setDispknktrkssyousairiyuu8(null);
        uiBean.setDispknkketriyuucd18(null);
        uiBean.setDispknkketriyuunaiyou18(null);
        uiBean.setDispknkketriyuucd28(null);
        uiBean.setDispknkketriyuunaiyou28(null);
        uiBean.setDispknkketriyuucd38(null);
        uiBean.setDispknkketriyuunaiyou38(null);
        uiBean.setDispknkketriyuucd48(null);
        uiBean.setDispknkketriyuunaiyou48(null);
        uiBean.setDispknkmrriyuucdnaiyou8(null);
        uiBean.setKankyouSateiRirekiNo9(null);
        uiBean.setDispknksyoriymd9(null);
        uiBean.setDispknkstktsyorinmkbn9(null);
        uiBean.setDispknkkekkakbn9(null);
        uiBean.setDispknktns9(null);
        uiBean.setDispknkktnm9(null);
        uiBean.setDispknkcomment9(null);
        uiBean.setDispknkktkkcd9(null);
        uiBean.setDispknktrkssyousairiyuu9(null);
        uiBean.setDispknkketriyuucd19(null);
        uiBean.setDispknkketriyuunaiyou19(null);
        uiBean.setDispknkketriyuucd29(null);
        uiBean.setDispknkketriyuunaiyou29(null);
        uiBean.setDispknkketriyuucd39(null);
        uiBean.setDispknkketriyuunaiyou39(null);
        uiBean.setDispknkketriyuucd49(null);
        uiBean.setDispknkketriyuunaiyou49(null);
        uiBean.setDispknkmrriyuucdnaiyou9(null);
        uiBean.setKankyouSateiRirekiNo10(null);
        uiBean.setDispknksyoriymd10(null);
        uiBean.setDispknkstktsyorinmkbn10(null);
        uiBean.setDispknkkekkakbn10(null);
        uiBean.setDispknktns10(null);
        uiBean.setDispknkktnm10(null);
        uiBean.setDispknkcomment10(null);
        uiBean.setDispknkktkkcd10(null);
        uiBean.setDispknktrkssyousairiyuu10(null);
        uiBean.setDispknkketriyuucd110(null);
        uiBean.setDispknkketriyuunaiyou110(null);
        uiBean.setDispknkketriyuucd210(null);
        uiBean.setDispknkketriyuunaiyou210(null);
        uiBean.setDispknkketriyuucd310(null);
        uiBean.setDispknkketriyuunaiyou310(null);
        uiBean.setDispknkketriyuucd410(null);
        uiBean.setDispknkketriyuunaiyou410(null);
        uiBean.setDispknkmrriyuucdnaiyou10(null);
        uiBean.setKankyouSateiRirekiNo11(null);
        uiBean.setDispknksyoriymd11(null);
        uiBean.setDispknkstktsyorinmkbn11(null);
        uiBean.setDispknkkekkakbn11(null);
        uiBean.setDispknktns11(null);
        uiBean.setDispknkktnm11(null);
        uiBean.setDispknkcomment11(null);
        uiBean.setDispknkktkkcd11(null);
        uiBean.setDispknktrkssyousairiyuu11(null);
        uiBean.setDispknkketriyuucd111(null);
        uiBean.setDispknkketriyuunaiyou111(null);
        uiBean.setDispknkketriyuucd211(null);
        uiBean.setDispknkketriyuunaiyou211(null);
        uiBean.setDispknkketriyuucd311(null);
        uiBean.setDispknkketriyuunaiyou311(null);
        uiBean.setDispknkketriyuucd411(null);
        uiBean.setDispknkketriyuunaiyou411(null);
        uiBean.setDispknkmrriyuucdnaiyou11(null);
        uiBean.setKankyouSateiRirekiNo12(null);
        uiBean.setDispknksyoriymd12(null);
        uiBean.setDispknkstktsyorinmkbn12(null);
        uiBean.setDispknkkekkakbn12(null);
        uiBean.setDispknktns12(null);
        uiBean.setDispknkktnm12(null);
        uiBean.setDispknkcomment12(null);
        uiBean.setDispknkktkkcd12(null);
        uiBean.setDispknktrkssyousairiyuu12(null);
        uiBean.setDispknkketriyuucd112(null);
        uiBean.setDispknkketriyuunaiyou112(null);
        uiBean.setDispknkketriyuucd212(null);
        uiBean.setDispknkketriyuunaiyou212(null);
        uiBean.setDispknkketriyuucd312(null);
        uiBean.setDispknkketriyuunaiyou312(null);
        uiBean.setDispknkketriyuucd412(null);
        uiBean.setDispknkketriyuunaiyou412(null);
        uiBean.setDispknkmrriyuucdnaiyou12(null);
        uiBean.setKankyouSateiRirekiNo13(null);
        uiBean.setDispknksyoriymd13(null);
        uiBean.setDispknkstktsyorinmkbn13(null);
        uiBean.setDispknkkekkakbn13(null);
        uiBean.setDispknktns13(null);
        uiBean.setDispknkktnm13(null);
        uiBean.setDispknkcomment13(null);
        uiBean.setDispknkktkkcd13(null);
        uiBean.setDispknktrkssyousairiyuu13(null);
        uiBean.setDispknkketriyuucd113(null);
        uiBean.setDispknkketriyuunaiyou113(null);
        uiBean.setDispknkketriyuucd213(null);
        uiBean.setDispknkketriyuunaiyou213(null);
        uiBean.setDispknkketriyuucd313(null);
        uiBean.setDispknkketriyuunaiyou313(null);
        uiBean.setDispknkketriyuucd413(null);
        uiBean.setDispknkketriyuunaiyou413(null);
        uiBean.setDispknkmrriyuucdnaiyou13(null);
        uiBean.setKankyouSateiRirekiNo14(null);
        uiBean.setDispknksyoriymd14(null);
        uiBean.setDispknkstktsyorinmkbn14(null);
        uiBean.setDispknkkekkakbn14(null);
        uiBean.setDispknktns14(null);
        uiBean.setDispknkktnm14(null);
        uiBean.setDispknkcomment14(null);
        uiBean.setDispknkktkkcd14(null);
        uiBean.setDispknktrkssyousairiyuu14(null);
        uiBean.setDispknkketriyuucd114(null);
        uiBean.setDispknkketriyuunaiyou114(null);
        uiBean.setDispknkketriyuucd214(null);
        uiBean.setDispknkketriyuunaiyou214(null);
        uiBean.setDispknkketriyuucd314(null);
        uiBean.setDispknkketriyuunaiyou314(null);
        uiBean.setDispknkketriyuucd414(null);
        uiBean.setDispknkketriyuunaiyou414(null);
        uiBean.setDispknkmrriyuucdnaiyou14(null);
        uiBean.setKankyouSateiRirekiNo15(null);
        uiBean.setDispknksyoriymd15(null);
        uiBean.setDispknkstktsyorinmkbn15(null);
        uiBean.setDispknkkekkakbn15(null);
        uiBean.setDispknktns15(null);
        uiBean.setDispknkktnm15(null);
        uiBean.setDispknkcomment15(null);
        uiBean.setDispknkktkkcd15(null);
        uiBean.setDispknktrkssyousairiyuu15(null);
        uiBean.setDispknkketriyuucd115(null);
        uiBean.setDispknkketriyuunaiyou115(null);
        uiBean.setDispknkketriyuucd215(null);
        uiBean.setDispknkketriyuunaiyou215(null);
        uiBean.setDispknkketriyuucd315(null);
        uiBean.setDispknkketriyuunaiyou315(null);
        uiBean.setDispknkketriyuucd415(null);
        uiBean.setDispknkketriyuunaiyou415(null);
        uiBean.setDispknkmrriyuucdnaiyou15(null);

        uiBean.setImusateisijinaiyou(null);
        uiBean.setImuSateiRenban1(null);
        uiBean.setDispimusyoriymd1(null);
        uiBean.setDispimustktsyorinmkbn1(null);
        uiBean.setDispimukekkakbn1(null);
        uiBean.setDispimutns1(null);
        uiBean.setDispimuktnm1(null);
        uiBean.setDispimucomment1(null);
        uiBean.setDispimuketkekkacd1(null);
        uiBean.setDispimusntksakuseiyh1(null);
        uiBean.setDispimuketriyuucd11(null);
        uiBean.setDispimuketriyuunaiyou11(null);
        uiBean.setDispimuketriyuucd21(null);
        uiBean.setDispimuketriyuunaiyou21(null);
        uiBean.setDispimuketriyuucd31(null);
        uiBean.setDispimuketriyuunaiyou31(null);
        uiBean.setDispimuketriyuucd41(null);
        uiBean.setDispimuketriyuunaiyou41(null);
        uiBean.setDispimusyoubyoucd11(null);
        uiBean.setDispimusyoubyounm11(null);
        uiBean.setDispimusyoubyoujyoutai11(null);
        uiBean.setDispimukantiym11(null);
        uiBean.setDispimusyoubyoucd21(null);
        uiBean.setDispimusyoubyounm21(null);
        uiBean.setDispimusyoubyoujyoutai21(null);
        uiBean.setDispimukantiym21(null);
        uiBean.setImuSateiRenban2(null);
        uiBean.setDispimusyoriymd2(null);
        uiBean.setDispimustktsyorinmkbn2(null);
        uiBean.setDispimukekkakbn2(null);
        uiBean.setDispimutns2(null);
        uiBean.setDispimuktnm2(null);
        uiBean.setDispimucomment2(null);
        uiBean.setDispimuketkekkacd2(null);
        uiBean.setDispimusntksakuseiyh2(null);
        uiBean.setDispimuketriyuucd12(null);
        uiBean.setDispimuketriyuunaiyou12(null);
        uiBean.setDispimuketriyuucd22(null);
        uiBean.setDispimuketriyuunaiyou22(null);
        uiBean.setDispimuketriyuucd32(null);
        uiBean.setDispimuketriyuunaiyou32(null);
        uiBean.setDispimuketriyuucd42(null);
        uiBean.setDispimuketriyuunaiyou42(null);
        uiBean.setDispimusyoubyoucd12(null);
        uiBean.setDispimusyoubyounm12(null);
        uiBean.setDispimusyoubyoujyoutai12(null);
        uiBean.setDispimukantiym12(null);
        uiBean.setDispimusyoubyoucd22(null);
        uiBean.setDispimusyoubyounm22(null);
        uiBean.setDispimusyoubyoujyoutai22(null);
        uiBean.setDispimukantiym22(null);
        uiBean.setImuSateiRenban3(null);
        uiBean.setDispimusyoriymd3(null);
        uiBean.setDispimustktsyorinmkbn3(null);
        uiBean.setDispimukekkakbn3(null);
        uiBean.setDispimutns3(null);
        uiBean.setDispimuktnm3(null);
        uiBean.setDispimucomment3(null);
        uiBean.setDispimuketkekkacd3(null);
        uiBean.setDispimusntksakuseiyh3(null);
        uiBean.setDispimuketriyuucd13(null);
        uiBean.setDispimuketriyuunaiyou13(null);
        uiBean.setDispimuketriyuucd23(null);
        uiBean.setDispimuketriyuunaiyou23(null);
        uiBean.setDispimuketriyuucd33(null);
        uiBean.setDispimuketriyuunaiyou33(null);
        uiBean.setDispimuketriyuucd43(null);
        uiBean.setDispimuketriyuunaiyou43(null);
        uiBean.setDispimusyoubyoucd13(null);
        uiBean.setDispimusyoubyounm13(null);
        uiBean.setDispimusyoubyoujyoutai13(null);
        uiBean.setDispimukantiym13(null);
        uiBean.setDispimusyoubyoucd23(null);
        uiBean.setDispimusyoubyounm23(null);
        uiBean.setDispimusyoubyoujyoutai23(null);
        uiBean.setDispimukantiym23(null);
        uiBean.setImuSateiRenban4(null);
        uiBean.setDispimusyoriymd4(null);
        uiBean.setDispimustktsyorinmkbn4(null);
        uiBean.setDispimukekkakbn4(null);
        uiBean.setDispimutns4(null);
        uiBean.setDispimuktnm4(null);
        uiBean.setDispimucomment4(null);
        uiBean.setDispimuketkekkacd4(null);
        uiBean.setDispimusntksakuseiyh4(null);
        uiBean.setDispimuketriyuucd14(null);
        uiBean.setDispimuketriyuunaiyou14(null);
        uiBean.setDispimuketriyuucd24(null);
        uiBean.setDispimuketriyuunaiyou24(null);
        uiBean.setDispimuketriyuucd34(null);
        uiBean.setDispimuketriyuunaiyou34(null);
        uiBean.setDispimuketriyuucd44(null);
        uiBean.setDispimuketriyuunaiyou44(null);
        uiBean.setDispimusyoubyoucd14(null);
        uiBean.setDispimusyoubyounm14(null);
        uiBean.setDispimusyoubyoujyoutai14(null);
        uiBean.setDispimukantiym14(null);
        uiBean.setDispimusyoubyoucd24(null);
        uiBean.setDispimusyoubyounm24(null);
        uiBean.setDispimusyoubyoujyoutai24(null);
        uiBean.setDispimukantiym24(null);
        uiBean.setImuSateiRenban5(null);
        uiBean.setDispimusyoriymd5(null);
        uiBean.setDispimustktsyorinmkbn5(null);
        uiBean.setDispimukekkakbn5(null);
        uiBean.setDispimutns5(null);
        uiBean.setDispimuktnm5(null);
        uiBean.setDispimucomment5(null);
        uiBean.setDispimuketkekkacd5(null);
        uiBean.setDispimusntksakuseiyh5(null);
        uiBean.setDispimuketriyuucd15(null);
        uiBean.setDispimuketriyuunaiyou15(null);
        uiBean.setDispimuketriyuucd25(null);
        uiBean.setDispimuketriyuunaiyou25(null);
        uiBean.setDispimuketriyuucd35(null);
        uiBean.setDispimuketriyuunaiyou35(null);
        uiBean.setDispimuketriyuucd45(null);
        uiBean.setDispimuketriyuunaiyou45(null);
        uiBean.setDispimusyoubyoucd15(null);
        uiBean.setDispimusyoubyounm15(null);
        uiBean.setDispimusyoubyoujyoutai15(null);
        uiBean.setDispimukantiym15(null);
        uiBean.setDispimusyoubyoucd25(null);
        uiBean.setDispimusyoubyounm25(null);
        uiBean.setDispimusyoubyoujyoutai25(null);
        uiBean.setDispimukantiym25(null);
        uiBean.setImuSateiRenban6(null);
        uiBean.setDispimusyoriymd6(null);
        uiBean.setDispimustktsyorinmkbn6(null);
        uiBean.setDispimukekkakbn6(null);
        uiBean.setDispimutns6(null);
        uiBean.setDispimuktnm6(null);
        uiBean.setDispimucomment6(null);
        uiBean.setDispimuketkekkacd6(null);
        uiBean.setDispimusntksakuseiyh6(null);
        uiBean.setDispimuketriyuucd16(null);
        uiBean.setDispimuketriyuunaiyou16(null);
        uiBean.setDispimuketriyuucd26(null);
        uiBean.setDispimuketriyuunaiyou26(null);
        uiBean.setDispimuketriyuucd36(null);
        uiBean.setDispimuketriyuunaiyou36(null);
        uiBean.setDispimuketriyuucd46(null);
        uiBean.setDispimuketriyuunaiyou46(null);
        uiBean.setDispimusyoubyoucd16(null);
        uiBean.setDispimusyoubyounm16(null);
        uiBean.setDispimusyoubyoujyoutai16(null);
        uiBean.setDispimukantiym16(null);
        uiBean.setDispimusyoubyoucd26(null);
        uiBean.setDispimusyoubyounm26(null);
        uiBean.setDispimusyoubyoujyoutai26(null);
        uiBean.setDispimukantiym26(null);
        uiBean.setImuSateiRenban7(null);
        uiBean.setDispimusyoriymd7(null);
        uiBean.setDispimustktsyorinmkbn7(null);
        uiBean.setDispimukekkakbn7(null);
        uiBean.setDispimutns7(null);
        uiBean.setDispimuktnm7(null);
        uiBean.setDispimucomment7(null);
        uiBean.setDispimuketkekkacd7(null);
        uiBean.setDispimusntksakuseiyh7(null);
        uiBean.setDispimuketriyuucd17(null);
        uiBean.setDispimuketriyuunaiyou17(null);
        uiBean.setDispimuketriyuucd27(null);
        uiBean.setDispimuketriyuunaiyou27(null);
        uiBean.setDispimuketriyuucd37(null);
        uiBean.setDispimuketriyuunaiyou37(null);
        uiBean.setDispimuketriyuucd47(null);
        uiBean.setDispimuketriyuunaiyou47(null);
        uiBean.setDispimusyoubyoucd17(null);
        uiBean.setDispimusyoubyounm17(null);
        uiBean.setDispimusyoubyoujyoutai17(null);
        uiBean.setDispimukantiym17(null);
        uiBean.setDispimusyoubyoucd27(null);
        uiBean.setDispimusyoubyounm27(null);
        uiBean.setDispimusyoubyoujyoutai27(null);
        uiBean.setDispimukantiym27(null);
        uiBean.setImuSateiRenban8(null);
        uiBean.setDispimusyoriymd8(null);
        uiBean.setDispimustktsyorinmkbn8(null);
        uiBean.setDispimukekkakbn8(null);
        uiBean.setDispimutns8(null);
        uiBean.setDispimuktnm8(null);
        uiBean.setDispimucomment8(null);
        uiBean.setDispimuketkekkacd8(null);
        uiBean.setDispimusntksakuseiyh8(null);
        uiBean.setDispimuketriyuucd18(null);
        uiBean.setDispimuketriyuunaiyou18(null);
        uiBean.setDispimuketriyuucd28(null);
        uiBean.setDispimuketriyuunaiyou28(null);
        uiBean.setDispimuketriyuucd38(null);
        uiBean.setDispimuketriyuunaiyou38(null);
        uiBean.setDispimuketriyuucd48(null);
        uiBean.setDispimuketriyuunaiyou48(null);
        uiBean.setDispimusyoubyoucd18(null);
        uiBean.setDispimusyoubyounm18(null);
        uiBean.setDispimusyoubyoujyoutai18(null);
        uiBean.setDispimukantiym18(null);
        uiBean.setDispimusyoubyoucd28(null);
        uiBean.setDispimusyoubyounm28(null);
        uiBean.setDispimusyoubyoujyoutai28(null);
        uiBean.setDispimukantiym28(null);
        uiBean.setImuSateiRenban9(null);
        uiBean.setDispimusyoriymd9(null);
        uiBean.setDispimustktsyorinmkbn9(null);
        uiBean.setDispimukekkakbn9(null);
        uiBean.setDispimutns9(null);
        uiBean.setDispimuktnm9(null);
        uiBean.setDispimucomment9(null);
        uiBean.setDispimuketkekkacd9(null);
        uiBean.setDispimusntksakuseiyh9(null);
        uiBean.setDispimuketriyuucd19(null);
        uiBean.setDispimuketriyuunaiyou19(null);
        uiBean.setDispimuketriyuucd29(null);
        uiBean.setDispimuketriyuunaiyou29(null);
        uiBean.setDispimuketriyuucd39(null);
        uiBean.setDispimuketriyuunaiyou39(null);
        uiBean.setDispimuketriyuucd49(null);
        uiBean.setDispimuketriyuunaiyou49(null);
        uiBean.setDispimusyoubyoucd19(null);
        uiBean.setDispimusyoubyounm19(null);
        uiBean.setDispimusyoubyoujyoutai19(null);
        uiBean.setDispimukantiym19(null);
        uiBean.setDispimusyoubyoucd29(null);
        uiBean.setDispimusyoubyounm29(null);
        uiBean.setDispimusyoubyoujyoutai29(null);
        uiBean.setDispimukantiym29(null);
        uiBean.setImuSateiRenban10(null);
        uiBean.setDispimusyoriymd10(null);
        uiBean.setDispimustktsyorinmkbn10(null);
        uiBean.setDispimukekkakbn10(null);
        uiBean.setDispimutns10(null);
        uiBean.setDispimuktnm10(null);
        uiBean.setDispimucomment10(null);
        uiBean.setDispimuketkekkacd10(null);
        uiBean.setDispimusntksakuseiyh10(null);
        uiBean.setDispimuketriyuucd110(null);
        uiBean.setDispimuketriyuunaiyou110(null);
        uiBean.setDispimuketriyuucd210(null);
        uiBean.setDispimuketriyuunaiyou210(null);
        uiBean.setDispimuketriyuucd310(null);
        uiBean.setDispimuketriyuunaiyou310(null);
        uiBean.setDispimuketriyuucd410(null);
        uiBean.setDispimuketriyuunaiyou410(null);
        uiBean.setDispimusyoubyoucd110(null);
        uiBean.setDispimusyoubyounm110(null);
        uiBean.setDispimusyoubyoujyoutai110(null);
        uiBean.setDispimukantiym110(null);
        uiBean.setDispimusyoubyoucd210(null);
        uiBean.setDispimusyoubyounm210(null);
        uiBean.setDispimusyoubyoujyoutai210(null);
        uiBean.setDispimukantiym210(null);
        uiBean.setImuSateiRenban11(null);
        uiBean.setDispimusyoriymd11(null);
        uiBean.setDispimustktsyorinmkbn11(null);
        uiBean.setDispimukekkakbn11(null);
        uiBean.setDispimutns11(null);
        uiBean.setDispimuktnm11(null);
        uiBean.setDispimucomment11(null);
        uiBean.setDispimuketkekkacd11(null);
        uiBean.setDispimusntksakuseiyh11(null);
        uiBean.setDispimuketriyuucd111(null);
        uiBean.setDispimuketriyuunaiyou111(null);
        uiBean.setDispimuketriyuucd211(null);
        uiBean.setDispimuketriyuunaiyou211(null);
        uiBean.setDispimuketriyuucd311(null);
        uiBean.setDispimuketriyuunaiyou311(null);
        uiBean.setDispimuketriyuucd411(null);
        uiBean.setDispimuketriyuunaiyou411(null);
        uiBean.setDispimusyoubyoucd111(null);
        uiBean.setDispimusyoubyounm111(null);
        uiBean.setDispimusyoubyoujyoutai111(null);
        uiBean.setDispimukantiym111(null);
        uiBean.setDispimusyoubyoucd211(null);
        uiBean.setDispimusyoubyounm211(null);
        uiBean.setDispimusyoubyoujyoutai211(null);
        uiBean.setDispimukantiym211(null);
        uiBean.setImuSateiRenban12(null);
        uiBean.setDispimusyoriymd12(null);
        uiBean.setDispimustktsyorinmkbn12(null);
        uiBean.setDispimukekkakbn12(null);
        uiBean.setDispimutns12(null);
        uiBean.setDispimuktnm12(null);
        uiBean.setDispimucomment12(null);
        uiBean.setDispimuketkekkacd12(null);
        uiBean.setDispimusntksakuseiyh12(null);
        uiBean.setDispimuketriyuucd112(null);
        uiBean.setDispimuketriyuunaiyou112(null);
        uiBean.setDispimuketriyuucd212(null);
        uiBean.setDispimuketriyuunaiyou212(null);
        uiBean.setDispimuketriyuucd312(null);
        uiBean.setDispimuketriyuunaiyou312(null);
        uiBean.setDispimuketriyuucd412(null);
        uiBean.setDispimuketriyuunaiyou412(null);
        uiBean.setDispimusyoubyoucd112(null);
        uiBean.setDispimusyoubyounm112(null);
        uiBean.setDispimusyoubyoujyoutai112(null);
        uiBean.setDispimukantiym112(null);
        uiBean.setDispimusyoubyoucd212(null);
        uiBean.setDispimusyoubyounm212(null);
        uiBean.setDispimusyoubyoujyoutai212(null);
        uiBean.setDispimukantiym212(null);
        uiBean.setImuSateiRenban13(null);
        uiBean.setDispimusyoriymd13(null);
        uiBean.setDispimustktsyorinmkbn13(null);
        uiBean.setDispimukekkakbn13(null);
        uiBean.setDispimutns13(null);
        uiBean.setDispimuktnm13(null);
        uiBean.setDispimucomment13(null);
        uiBean.setDispimuketkekkacd13(null);
        uiBean.setDispimusntksakuseiyh13(null);
        uiBean.setDispimuketriyuucd113(null);
        uiBean.setDispimuketriyuunaiyou113(null);
        uiBean.setDispimuketriyuucd213(null);
        uiBean.setDispimuketriyuunaiyou213(null);
        uiBean.setDispimuketriyuucd313(null);
        uiBean.setDispimuketriyuunaiyou313(null);
        uiBean.setDispimuketriyuucd413(null);
        uiBean.setDispimuketriyuunaiyou413(null);
        uiBean.setDispimusyoubyoucd113(null);
        uiBean.setDispimusyoubyounm113(null);
        uiBean.setDispimusyoubyoujyoutai113(null);
        uiBean.setDispimukantiym113(null);
        uiBean.setDispimusyoubyoucd213(null);
        uiBean.setDispimusyoubyounm213(null);
        uiBean.setDispimusyoubyoujyoutai213(null);
        uiBean.setDispimukantiym213(null);
        uiBean.setImuSateiRenban14(null);
        uiBean.setDispimusyoriymd14(null);
        uiBean.setDispimustktsyorinmkbn14(null);
        uiBean.setDispimukekkakbn14(null);
        uiBean.setDispimutns14(null);
        uiBean.setDispimuktnm14(null);
        uiBean.setDispimucomment14(null);
        uiBean.setDispimuketkekkacd14(null);
        uiBean.setDispimusntksakuseiyh14(null);
        uiBean.setDispimuketriyuucd114(null);
        uiBean.setDispimuketriyuunaiyou114(null);
        uiBean.setDispimuketriyuucd214(null);
        uiBean.setDispimuketriyuunaiyou214(null);
        uiBean.setDispimuketriyuucd314(null);
        uiBean.setDispimuketriyuunaiyou314(null);
        uiBean.setDispimuketriyuucd414(null);
        uiBean.setDispimuketriyuunaiyou414(null);
        uiBean.setDispimusyoubyoucd114(null);
        uiBean.setDispimusyoubyounm114(null);
        uiBean.setDispimusyoubyoujyoutai114(null);
        uiBean.setDispimukantiym114(null);
        uiBean.setDispimusyoubyoucd214(null);
        uiBean.setDispimusyoubyounm214(null);
        uiBean.setDispimusyoubyoujyoutai214(null);
        uiBean.setDispimukantiym214(null);
        uiBean.setImuSateiRenban15(null);
        uiBean.setDispimusyoriymd15(null);
        uiBean.setDispimustktsyorinmkbn15(null);
        uiBean.setDispimukekkakbn15(null);
        uiBean.setDispimutns15(null);
        uiBean.setDispimuktnm15(null);
        uiBean.setDispimucomment15(null);
        uiBean.setDispimuketkekkacd15(null);
        uiBean.setDispimusntksakuseiyh15(null);
        uiBean.setDispimuketriyuucd115(null);
        uiBean.setDispimuketriyuunaiyou115(null);
        uiBean.setDispimuketriyuucd215(null);
        uiBean.setDispimuketriyuunaiyou215(null);
        uiBean.setDispimuketriyuucd315(null);
        uiBean.setDispimuketriyuunaiyou315(null);
        uiBean.setDispimuketriyuucd415(null);
        uiBean.setDispimuketriyuunaiyou415(null);
        uiBean.setDispimusyoubyoucd115(null);
        uiBean.setDispimusyoubyounm115(null);
        uiBean.setDispimusyoubyoujyoutai115(null);
        uiBean.setDispimukantiym115(null);
        uiBean.setDispimusyoubyoucd215(null);
        uiBean.setDispimusyoubyounm215(null);
        uiBean.setDispimusyoubyoujyoutai215(null);
        uiBean.setDispimukantiym215(null);

        uiBean.setDisprenno1(null);
        uiBean.setDispketymd1(null);
        uiBean.setDispketkekkacd1(null);
        uiBean.setDispsntksakuseiyh1(null);
        uiBean.setDisptorikesisyousairiyuu1(null);
        uiBean.setDispketriyuucd11(null);
        uiBean.setDispketteiriyuunaiyou11(null);
        uiBean.setDispketriyuucd21(null);
        uiBean.setDispketteiriyuunaiyou21(null);
        uiBean.setDispketriyuucd31(null);
        uiBean.setDispketteiriyuunaiyou31(null);
        uiBean.setDispketriyuucd41(null);
        uiBean.setDispketteiriyuunaiyou41(null);
        uiBean.setDispmrriyuucdnaiyou1(null);
        uiBean.setDispsyoubyoucd11(null);
        uiBean.setDispsyoubyounm11(null);
        uiBean.setDispsyoubyoujyoutai11(null);
        uiBean.setDispkantiym11(null);
        uiBean.setDispsyoubyoucd21(null);
        uiBean.setDispsyoubyounm21(null);
        uiBean.setDispsyoubyoujyoutai21(null);
        uiBean.setDispkantiym21(null);
        uiBean.setDisprenno2(null);
        uiBean.setDispketymd2(null);
        uiBean.setDispketkekkacd2(null);
        uiBean.setDispsntksakuseiyh2(null);
        uiBean.setDisptorikesisyousairiyuu2(null);
        uiBean.setDispketriyuucd12(null);
        uiBean.setDispketteiriyuunaiyou12(null);
        uiBean.setDispketriyuucd22(null);
        uiBean.setDispketteiriyuunaiyou22(null);
        uiBean.setDispketriyuucd32(null);
        uiBean.setDispketteiriyuunaiyou32(null);
        uiBean.setDispketriyuucd42(null);
        uiBean.setDispketteiriyuunaiyou42(null);
        uiBean.setDispmrriyuucdnaiyou2(null);
        uiBean.setDispsyoubyoucd12(null);
        uiBean.setDispsyoubyounm12(null);
        uiBean.setDispsyoubyoujyoutai12(null);
        uiBean.setDispkantiym12(null);
        uiBean.setDispsyoubyoucd22(null);
        uiBean.setDispsyoubyounm22(null);
        uiBean.setDispsyoubyoujyoutai22(null);
        uiBean.setDispkantiym22(null);
        uiBean.setDisprenno3(null);
        uiBean.setDispketymd3(null);
        uiBean.setDispketkekkacd3(null);
        uiBean.setDispsntksakuseiyh3(null);
        uiBean.setDisptorikesisyousairiyuu3(null);
        uiBean.setDispketriyuucd13(null);
        uiBean.setDispketteiriyuunaiyou13(null);
        uiBean.setDispketriyuucd23(null);
        uiBean.setDispketteiriyuunaiyou23(null);
        uiBean.setDispketriyuucd33(null);
        uiBean.setDispketteiriyuunaiyou33(null);
        uiBean.setDispketriyuucd43(null);
        uiBean.setDispketteiriyuunaiyou43(null);
        uiBean.setDispmrriyuucdnaiyou3(null);
        uiBean.setDispsyoubyoucd13(null);
        uiBean.setDispsyoubyounm13(null);
        uiBean.setDispsyoubyoujyoutai13(null);
        uiBean.setDispkantiym13(null);
        uiBean.setDispsyoubyoucd23(null);
        uiBean.setDispsyoubyounm23(null);
        uiBean.setDispsyoubyoujyoutai23(null);
        uiBean.setDispkantiym23(null);
        uiBean.setDisprenno4(null);
        uiBean.setDispketymd4(null);
        uiBean.setDispketkekkacd4(null);
        uiBean.setDispsntksakuseiyh4(null);
        uiBean.setDisptorikesisyousairiyuu4(null);
        uiBean.setDispketriyuucd14(null);
        uiBean.setDispketteiriyuunaiyou14(null);
        uiBean.setDispketriyuucd24(null);
        uiBean.setDispketteiriyuunaiyou24(null);
        uiBean.setDispketriyuucd34(null);
        uiBean.setDispketteiriyuunaiyou34(null);
        uiBean.setDispketriyuucd44(null);
        uiBean.setDispketteiriyuunaiyou44(null);
        uiBean.setDispmrriyuucdnaiyou4(null);
        uiBean.setDispsyoubyoucd14(null);
        uiBean.setDispsyoubyounm14(null);
        uiBean.setDispsyoubyoujyoutai14(null);
        uiBean.setDispkantiym14(null);
        uiBean.setDispsyoubyoucd24(null);
        uiBean.setDispsyoubyounm24(null);
        uiBean.setDispsyoubyoujyoutai24(null);
        uiBean.setDispkantiym24(null);
        uiBean.setDisprenno5(null);
        uiBean.setDispketymd5(null);
        uiBean.setDispketkekkacd5(null);
        uiBean.setDispsntksakuseiyh5(null);
        uiBean.setDisptorikesisyousairiyuu5(null);
        uiBean.setDispketriyuucd15(null);
        uiBean.setDispketteiriyuunaiyou15(null);
        uiBean.setDispketriyuucd25(null);
        uiBean.setDispketteiriyuunaiyou25(null);
        uiBean.setDispketriyuucd35(null);
        uiBean.setDispketteiriyuunaiyou35(null);
        uiBean.setDispketriyuucd45(null);
        uiBean.setDispketteiriyuunaiyou45(null);
        uiBean.setDispmrriyuucdnaiyou5(null);
        uiBean.setDispsyoubyoucd15(null);
        uiBean.setDispsyoubyounm15(null);
        uiBean.setDispsyoubyoujyoutai15(null);
        uiBean.setDispkantiym15(null);
        uiBean.setDispsyoubyoucd25(null);
        uiBean.setDispsyoubyounm25(null);
        uiBean.setDispsyoubyoujyoutai25(null);
        uiBean.setDispkantiym25(null);
        uiBean.setDisprenno6(null);
        uiBean.setDispketymd6(null);
        uiBean.setDispketkekkacd6(null);
        uiBean.setDispsntksakuseiyh6(null);
        uiBean.setDisptorikesisyousairiyuu6(null);
        uiBean.setDispketriyuucd16(null);
        uiBean.setDispketteiriyuunaiyou16(null);
        uiBean.setDispketriyuucd26(null);
        uiBean.setDispketteiriyuunaiyou26(null);
        uiBean.setDispketriyuucd36(null);
        uiBean.setDispketteiriyuunaiyou36(null);
        uiBean.setDispketriyuucd46(null);
        uiBean.setDispketteiriyuunaiyou46(null);
        uiBean.setDispmrriyuucdnaiyou6(null);
        uiBean.setDispsyoubyoucd16(null);
        uiBean.setDispsyoubyounm16(null);
        uiBean.setDispsyoubyoujyoutai16(null);
        uiBean.setDispkantiym16(null);
        uiBean.setDispsyoubyoucd26(null);
        uiBean.setDispsyoubyounm26(null);
        uiBean.setDispsyoubyoujyoutai26(null);
        uiBean.setDispkantiym26(null);
        uiBean.setDisprenno7(null);
        uiBean.setDispketymd7(null);
        uiBean.setDispketkekkacd7(null);
        uiBean.setDispsntksakuseiyh7(null);
        uiBean.setDisptorikesisyousairiyuu7(null);
        uiBean.setDispketriyuucd17(null);
        uiBean.setDispketteiriyuunaiyou17(null);
        uiBean.setDispketriyuucd27(null);
        uiBean.setDispketteiriyuunaiyou27(null);
        uiBean.setDispketriyuucd37(null);
        uiBean.setDispketteiriyuunaiyou37(null);
        uiBean.setDispketriyuucd47(null);
        uiBean.setDispketteiriyuunaiyou47(null);
        uiBean.setDispmrriyuucdnaiyou7(null);
        uiBean.setDispsyoubyoucd17(null);
        uiBean.setDispsyoubyounm17(null);
        uiBean.setDispsyoubyoujyoutai17(null);
        uiBean.setDispkantiym17(null);
        uiBean.setDispsyoubyoucd27(null);
        uiBean.setDispsyoubyounm27(null);
        uiBean.setDispsyoubyoujyoutai27(null);
        uiBean.setDispkantiym27(null);
        uiBean.setDisprenno8(null);
        uiBean.setDispketymd8(null);
        uiBean.setDispketkekkacd8(null);
        uiBean.setDispsntksakuseiyh8(null);
        uiBean.setDisptorikesisyousairiyuu8(null);
        uiBean.setDispketriyuucd18(null);
        uiBean.setDispketteiriyuunaiyou18(null);
        uiBean.setDispketriyuucd28(null);
        uiBean.setDispketteiriyuunaiyou28(null);
        uiBean.setDispketriyuucd38(null);
        uiBean.setDispketteiriyuunaiyou38(null);
        uiBean.setDispketriyuucd48(null);
        uiBean.setDispketteiriyuunaiyou48(null);
        uiBean.setDispmrriyuucdnaiyou8(null);
        uiBean.setDispsyoubyoucd18(null);
        uiBean.setDispsyoubyounm18(null);
        uiBean.setDispsyoubyoujyoutai18(null);
        uiBean.setDispkantiym18(null);
        uiBean.setDispsyoubyoucd28(null);
        uiBean.setDispsyoubyounm28(null);
        uiBean.setDispsyoubyoujyoutai28(null);
        uiBean.setDispkantiym28(null);
        uiBean.setDisprenno9(null);
        uiBean.setDispketymd9(null);
        uiBean.setDispketkekkacd9(null);
        uiBean.setDispsntksakuseiyh9(null);
        uiBean.setDisptorikesisyousairiyuu9(null);
        uiBean.setDispketriyuucd19(null);
        uiBean.setDispketteiriyuunaiyou19(null);
        uiBean.setDispketriyuucd29(null);
        uiBean.setDispketteiriyuunaiyou29(null);
        uiBean.setDispketriyuucd39(null);
        uiBean.setDispketteiriyuunaiyou39(null);
        uiBean.setDispketriyuucd49(null);
        uiBean.setDispketteiriyuunaiyou49(null);
        uiBean.setDispmrriyuucdnaiyou9(null);
        uiBean.setDispsyoubyoucd19(null);
        uiBean.setDispsyoubyounm19(null);
        uiBean.setDispsyoubyoujyoutai19(null);
        uiBean.setDispkantiym19(null);
        uiBean.setDispsyoubyoucd29(null);
        uiBean.setDispsyoubyounm29(null);
        uiBean.setDispsyoubyoujyoutai29(null);
        uiBean.setDispkantiym29(null);
        uiBean.setDisprenno10(null);
        uiBean.setDispketymd10(null);
        uiBean.setDispketkekkacd10(null);
        uiBean.setDispsntksakuseiyh10(null);
        uiBean.setDisptorikesisyousairiyuu10(null);
        uiBean.setDispketriyuucd110(null);
        uiBean.setDispketteiriyuunaiyou110(null);
        uiBean.setDispketriyuucd210(null);
        uiBean.setDispketteiriyuunaiyou210(null);
        uiBean.setDispketriyuucd310(null);
        uiBean.setDispketteiriyuunaiyou310(null);
        uiBean.setDispketriyuucd410(null);
        uiBean.setDispketteiriyuunaiyou410(null);
        uiBean.setDispmrriyuucdnaiyou10(null);
        uiBean.setDispsyoubyoucd110(null);
        uiBean.setDispsyoubyounm110(null);
        uiBean.setDispsyoubyoujyoutai110(null);
        uiBean.setDispkantiym110(null);
        uiBean.setDispsyoubyoucd210(null);
        uiBean.setDispsyoubyounm210(null);
        uiBean.setDispsyoubyoujyoutai210(null);
        uiBean.setDispkantiym210(null);
        uiBean.setDisprenno11(null);
        uiBean.setDispketymd11(null);
        uiBean.setDispketkekkacd11(null);
        uiBean.setDispsntksakuseiyh11(null);
        uiBean.setDisptorikesisyousairiyuu11(null);
        uiBean.setDispketriyuucd111(null);
        uiBean.setDispketteiriyuunaiyou111(null);
        uiBean.setDispketriyuucd211(null);
        uiBean.setDispketteiriyuunaiyou211(null);
        uiBean.setDispketriyuucd311(null);
        uiBean.setDispketteiriyuunaiyou311(null);
        uiBean.setDispketriyuucd411(null);
        uiBean.setDispketteiriyuunaiyou411(null);
        uiBean.setDispmrriyuucdnaiyou11(null);
        uiBean.setDispsyoubyoucd111(null);
        uiBean.setDispsyoubyounm111(null);
        uiBean.setDispsyoubyoujyoutai111(null);
        uiBean.setDispkantiym111(null);
        uiBean.setDispsyoubyoucd211(null);
        uiBean.setDispsyoubyounm211(null);
        uiBean.setDispsyoubyoujyoutai211(null);
        uiBean.setDispkantiym211(null);
        uiBean.setDisprenno12(null);
        uiBean.setDispketymd12(null);
        uiBean.setDispketkekkacd12(null);
        uiBean.setDispsntksakuseiyh12(null);
        uiBean.setDisptorikesisyousairiyuu12(null);
        uiBean.setDispketriyuucd112(null);
        uiBean.setDispketteiriyuunaiyou112(null);
        uiBean.setDispketriyuucd212(null);
        uiBean.setDispketteiriyuunaiyou212(null);
        uiBean.setDispketriyuucd312(null);
        uiBean.setDispketteiriyuunaiyou312(null);
        uiBean.setDispketriyuucd412(null);
        uiBean.setDispketteiriyuunaiyou412(null);
        uiBean.setDispmrriyuucdnaiyou12(null);
        uiBean.setDispsyoubyoucd112(null);
        uiBean.setDispsyoubyounm112(null);
        uiBean.setDispsyoubyoujyoutai112(null);
        uiBean.setDispkantiym112(null);
        uiBean.setDispsyoubyoucd212(null);
        uiBean.setDispsyoubyounm212(null);
        uiBean.setDispsyoubyoujyoutai212(null);
        uiBean.setDispkantiym212(null);
        uiBean.setDisprenno13(null);
        uiBean.setDispketymd13(null);
        uiBean.setDispketkekkacd13(null);
        uiBean.setDispsntksakuseiyh13(null);
        uiBean.setDisptorikesisyousairiyuu13(null);
        uiBean.setDispketriyuucd113(null);
        uiBean.setDispketteiriyuunaiyou113(null);
        uiBean.setDispketriyuucd213(null);
        uiBean.setDispketteiriyuunaiyou213(null);
        uiBean.setDispketriyuucd313(null);
        uiBean.setDispketteiriyuunaiyou313(null);
        uiBean.setDispketriyuucd413(null);
        uiBean.setDispketteiriyuunaiyou413(null);
        uiBean.setDispmrriyuucdnaiyou13(null);
        uiBean.setDispsyoubyoucd113(null);
        uiBean.setDispsyoubyounm113(null);
        uiBean.setDispsyoubyoujyoutai113(null);
        uiBean.setDispkantiym113(null);
        uiBean.setDispsyoubyoucd213(null);
        uiBean.setDispsyoubyounm213(null);
        uiBean.setDispsyoubyoujyoutai213(null);
        uiBean.setDispkantiym213(null);
        uiBean.setDisprenno14(null);
        uiBean.setDispketymd14(null);
        uiBean.setDispketkekkacd14(null);
        uiBean.setDispsntksakuseiyh14(null);
        uiBean.setDisptorikesisyousairiyuu14(null);
        uiBean.setDispketriyuucd114(null);
        uiBean.setDispketteiriyuunaiyou114(null);
        uiBean.setDispketriyuucd214(null);
        uiBean.setDispketteiriyuunaiyou214(null);
        uiBean.setDispketriyuucd314(null);
        uiBean.setDispketteiriyuunaiyou314(null);
        uiBean.setDispketriyuucd414(null);
        uiBean.setDispketteiriyuunaiyou414(null);
        uiBean.setDispmrriyuucdnaiyou14(null);
        uiBean.setDispsyoubyoucd114(null);
        uiBean.setDispsyoubyounm114(null);
        uiBean.setDispsyoubyoujyoutai114(null);
        uiBean.setDispkantiym114(null);
        uiBean.setDispsyoubyoucd214(null);
        uiBean.setDispsyoubyounm214(null);
        uiBean.setDispsyoubyoujyoutai214(null);
        uiBean.setDispkantiym214(null);
        uiBean.setDisprenno15(null);
        uiBean.setDispketymd15(null);
        uiBean.setDispketkekkacd15(null);
        uiBean.setDispsntksakuseiyh15(null);
        uiBean.setDisptorikesisyousairiyuu15(null);
        uiBean.setDispketriyuucd115(null);
        uiBean.setDispketteiriyuunaiyou115(null);
        uiBean.setDispketriyuucd215(null);
        uiBean.setDispketteiriyuunaiyou215(null);
        uiBean.setDispketriyuucd315(null);
        uiBean.setDispketteiriyuunaiyou315(null);
        uiBean.setDispketriyuucd415(null);
        uiBean.setDispketteiriyuunaiyou415(null);
        uiBean.setDispmrriyuucdnaiyou15(null);
        uiBean.setDispsyoubyoucd115(null);
        uiBean.setDispsyoubyounm115(null);
        uiBean.setDispsyoubyoujyoutai115(null);
        uiBean.setDispkantiym115(null);
        uiBean.setDispsyoubyoucd215(null);
        uiBean.setDispsyoubyounm215(null);
        uiBean.setDispsyoubyoujyoutai215(null);
        uiBean.setDispkantiym215(null);
    }

    private void clearParamNyuukinJK() {

        uiBean.setNyuukinjoutaikbn(null);
        uiBean.setFstphrkgk(null);
        uiBean.setRsgakukei(null);
        uiBean.setFstphrkgkhrktuuka(null);
        uiBean.setNyknkwsratetkyymd(null);
        uiBean.setNyknkwsrate2(null);
        uiBean.setFstpryosyuymd(null);
        uiBean.setDenkawaserate(null);
        uiBean.setDispzenkizennouumu(null);
        uiBean.setDispznnkai(null);
        uiBean.setDisphrkkaisuu(null);
        uiBean.setDisphrkkeiro(null);
        uiBean.setDispfstphrkkeirokbn(null);
        uiBean.setDispteikiikkatubaraikaisuu(null);
        uiBean.setHituyouikkatup(null);
        uiBean.setHusokuikkatup(null);
        uiBean.setIkkatuyoupkaisuu(null);
        uiBean.setGenzaiikkatukaisuu(null);
        uiBean.setNyuukinInfo(null);
        uiBean.setPkakinInfo(null);
        uiBean.setHenkinInfo(null);
    }

    private void clearParamKouteijkList() {

        uiBean.setKouteiJyoukyouBaseInfo(null);
    }

    private void clearParamSyoruiToutyakuJK() {

        uiBean.setSyoruiInfoList(null);
    }

    private void clearParamTeiseiRrkList() {

        uiBean.setTeiseiRirekiInfoItiran(null);
    }

    private void clearParamSakuinInfo() {

        uiBean.setVkykskyknmkn(null);
        uiBean.setVkykskykseiymd(null);
        uiBean.setKykSakuinInfo(null);
        uiBean.setVhhkshhknnmkn(null);
        uiBean.setVhhkshhknseiymd(null);
        uiBean.setHhknSakuinInfo(null);
        uiBean.setKeikokuMsgUmu(null);
        uiBean.setMqErrMsgUmu(null);
        uiBean.setPalAteSyoukaiErrMsgUmu(null);
        uiBean.setSknInfoSyoukaiErrMsgUmu(null);
        uiBean.setSknInfoKensakuFlag(false);
    }

    private void setPropertyFromTMosKihon(HT_MosKihon pMosKihon, HT_SyoriCTL pSyoriCTL) {
        uiBean.setJimuyoucd(pMosKihon.getJimuyoucd());
        uiBean.setAitemosno(pMosKihon.getAitemosno());
        uiBean.setDoujikaiyakusyono(pMosKihon.getDoujikaiyakusyono());
        uiBean.setMosymd(pMosKihon.getMosymd());

        if (pMosKihon.getKykymd() == null && pMosKihon.getSkykymd() != null) {
            uiBean.setKykymd(pMosKihon.getSkykymd());
        }
        else {
            uiBean.setKykymd(pMosKihon.getKykymd());
        }

        if (pMosKihon.getSkykymd() != null) {
            uiBean.setSkykymdkbn(C_SkykymdKbn.ARI);
        }

        uiBean.setSknnkaisiymd(pMosKihon.getSknnkaisiymd());
        uiBean.setBosyuuym(pMosKihon.getBosyuuym());
        uiBean.setSeisekiym(pMosKihon.getSeisekiym());
        uiBean.setHknsyuruinm(pMosKihon.getHknsyuruino().getContent());
        uiBean.setAisyoumei(pMosKihon.getAisyoumeikbn().getContent());
        uiBean.setKykkbn(pMosKihon.getKykkbn());
        uiBean.setYakkanjyuryouhoukbn(pMosKihon.getYakkanjyuryouhoukbn());
        if (!BizUtil.isBlank(pMosKihon.getYakkanbunsyono())) {
            String yakkanbunsyono = pMosKihon.getYakkanbunsyono();
            String yakkanbunsyonoStringBuilder = new StringBuilder(yakkanbunsyono).insert(2, '-').insert(7, '-').toString();
            uiBean.setYakkanbunsyono(yakkanbunsyonoStringBuilder);
        }
        uiBean.setFatcasnsikbn(pMosKihon.getFatcasnsikbn());
        uiBean.setBikkjnssinfokbn(pMosKihon.getBikkjnssinfokbn());
        uiBean.setAeoisnsikbn(pMosKihon.getAeoisnsikbn());
        uiBean.setKyktdk(pMosKihon.getKyktdk());
        uiBean.setKyknmkn(pMosKihon.getKyknmkn());
        uiBean.setKyknmkj(pMosKihon.getKyknmkj());
        uiBean.setKyknmkjkhukakbn(pMosKihon.getKyknmkjkhukakbn());
        uiBean.setKykseiymd(pMosKihon.getKykseiymd());
        uiBean.setKyksei(pMosKihon.getKyksei());
        uiBean.setKyknen(zeroToNull(pMosKihon.getKyknen()));
        uiBean.setTsinyno(pMosKihon.getTsinyno());
        uiBean.setTsinadr1kj(pMosKihon.getTsinadr1kj());
        uiBean.setTsinadr2kj(pMosKihon.getTsinadr2kj());
        uiBean.setTsinadr3kj(pMosKihon.getTsinadr3kj());
        uiBean.setTsintelno(pMosKihon.getTsintelno());
        uiBean.setDai2tsintelno(pMosKihon.getDai2tsintelno());
        uiBean.setHhknnmkn(pMosKihon.getHhknnmkn());
        uiBean.setHhknnmkjkhukakbn(pMosKihon.getHhknnmkjkhukakbn());
        uiBean.setHhknnmkj(pMosKihon.getHhknnmkj());
        uiBean.setHhknseiymd(pMosKihon.getHhknseiymd());
        uiBean.setHhknsei(pMosKihon.getHhknsei());
        uiBean.setTsindousiteikbn(pMosKihon.getTsindousiteikbn());
        uiBean.setHhknyno(pMosKihon.getHhknyno());
        uiBean.setHhknadr1kj(pMosKihon.getHhknadr1kj());
        uiBean.setHhknadr2kj(pMosKihon.getHhknadr2kj());
        uiBean.setHhknadr3kj(pMosKihon.getHhknadr3kj());
        uiBean.setHhkntelno(pMosKihon.getHhkntelno());
        uiBean.setSdpdkbn(pMosKihon.getSdpdkbn());
        uiBean.setHaitoukbn(pMosKihon.getHaitoukbn());
        uiBean.setHrkkaisuu(pMosKihon.getHrkkaisuu());
        uiBean.setHrkkeiro(pMosKihon.getHrkkeiro());
        uiBean.setFstphrkkeirokbn(pMosKihon.getFstphrkkeirokbn());
        uiBean.setZenkizennouumu(pMosKihon.getZenkizennouumu());
        if (pMosKihon.getZnnkai() > 0) {

            uiBean.setZnnkai(pMosKihon.getZnnkai() + 1);

        }
        else {

            uiBean.setZnnkai(zeroToNull(pMosKihon.getZnnkai()));

        }

        uiBean.setIkkatubaraikaisuu(pMosKihon.getIkkatubaraikaisuu());
        uiBean.setNstksbnkkn(zeroToNull(pMosKihon.getNstksbnkkn()));
        uiBean.setUktkid(pMosKihon.getUktkid());
        uiBean.setHhknnen(pMosKihon.getHhknnen());
        uiBean.setKktymd(pMosKihon.getKktymd());
        uiBean.setHhknsykgycd(pMosKihon.getHhknsykgycd());
        uiBean.setHhknnensyuukbn(pMosKihon.getHhknnensyuukbn());
        uiBean.setKyktuukasyu(pMosKihon.getKyktuukasyu());
        uiBean.setHrktuukasyu(pMosKihon.getHrktuukasyu());
        uiBean.setSisuuhaibunwarikbn(pMosKihon.getSisuuhaibunwarikbn());
        uiBean.setTeirituhaibunwarikbn(pMosKihon.getTeirituhaibunwarikbn());
        uiBean.setNkgnshosyouritukbn(pMosKihon.getNkgnshosyouritukbn());
        uiBean.setPwaribikitekiyoukbn(pMosKihon.getPwaribikitekiyoukbn());
        uiBean.setPharaikomisougaku(pMosKihon.getPharaikomisougaku());

        uiBean.setSyksbyensitihsyutkhkkbn(pMosKihon.getSyksbyensitihsyutkhkkbn());
        uiBean.setJyudkaigomehrtkhkkbn(pMosKihon.getJyudkaigomehrtkhkkbn());
        uiBean.setNstkhkkbn(pMosKihon.getNstkhkkbn());
        uiBean.setTargettkmkhtkbn(pMosKihon.getTargettkmkhtkbn());
        uiBean.setTargettkhkkbn(pMosKihon.getTargettkhkkbn());
        uiBean.setKjnnkpzeitekitkhukakbn(pMosKihon.getKjnnkpzeitekitkhukakbn());
        uiBean.setYennykntkhkkbn(pMosKihon.getYennykntkhkkbn());
        uiBean.setGaikanykntkhkkbn(pMosKihon.getGaikanykntkhkkbn());
        uiBean.setSbuktnin(pMosKihon.getSbuktnin());
        uiBean.setStdrsktkyhkkbn(pMosKihon.getStdrsktkyhkkbn());
        uiBean.setKykhonninkakninsyoruikbn(pMosKihon.getKykhonninkakninsyoruikbn());
        uiBean.setSkskknhonninkakninsyoruikbn(pMosKihon.getSkskknhonninkakninsyoruikbn());
        uiBean.setKoureikzksetumeihoukbn(pMosKihon.getKoureikzksetumeihoukbn());
        uiBean.setKoureimndnhukusuukaikbn(pMosKihon.getKoureimndnhukusuukaikbn());
        uiBean.setKoureitratkisyaigidskkbn(pMosKihon.getKoureitratkisyaigidskkbn());
        uiBean.setKouseiinkyktkjkumukbn(pMosKihon.getKouseiinkyktkjkumukbn());
        uiBean.setKoukankykkinmusakinm(pMosKihon.getKoukankykkinmusakinm());
        uiBean.setKoukankyksyokumunaiyou(pMosKihon.getKoukankyksyokumunaiyou());
        uiBean.setKoukankyktkjkumukbn(pMosKihon.getKoukankyktkjkumukbn());
        uiBean.setDrctservicemoskbn(pMosKihon.getDrctservicemoskbn());
        uiBean.setDskokno(pMosKihon.getDskokno());
        uiBean.setDsmailaddress(pMosKihon.getDsmailaddress());

        if (C_Hrkkaisuu.ITIJI.eq(pMosKihon.getHrkkaisuu())) {

            uiBean.setDispfstphrkgk(pMosKihon.getFstphrkgk());
            uiBean.setMosfstpkei(pMosKihon.getMosfstpkei());

        }
        else {

            uiBean.setDispfstphrkgk(pMosKihon.getHeijyunp());
            uiBean.setMosfstpkei(pMosKihon.getMosheijyunp());

        }
        if (pMosKihon.getIkkatup().compareTo(BizCurrency.valueOf(0, pMosKihon.getIkkatup().getType())) == 0) {

            uiBean.setIkkatup(BizCurrency.optional());
        }
        else {

            uiBean.setIkkatup(pMosKihon.getIkkatup());
        }

        if (pMosKihon.getMosikkatup().compareTo(BizCurrency.valueOf(0, pMosKihon.getMosikkatup().getType())) == 0) {

            uiBean.setMosikkatup(BizCurrency.optional());
        }
        else {

            uiBean.setMosikkatup(pMosKihon.getMosikkatup());
        }

        if (pMosKihon.getZennoup().add(pMosKihon.getZennoujyuutoup()).compareTo(
            BizCurrency.valueOf(0, pMosKihon.getZennoup().getType())) == 0) {

            uiBean.setZennoup(BizCurrency.optional());
        }
        else {

            uiBean.setZennoup(pMosKihon.getZennoup().add(pMosKihon.getZennoujyuutoup()));
        }

        if (pMosKihon.getMoszennoupsyokaiari().compareTo(
            BizCurrency.valueOf(0, pMosKihon.getMoszennoupsyokaiari().getType())) == 0) {

            uiBean.setMoszennoupsyokaiari(BizCurrency.optional());
        }
        else {

            uiBean.setMoszennoupsyokaiari(pMosKihon.getMoszennoupsyokaiari());
        }
        if (C_UmuKbn.ARI.eq(pMosKihon.getTsryhshrkykumukbn())) {
            uiBean.setTsryhshrkykumukbn(pMosKihon.getTsryhshrkykumukbn());
        }
        else {
            uiBean.setTsryhshrkykumukbn(null);
        }

        if (C_UmuKbn.ARI.eq(pMosKihon.getSyosisyatodokeumukbn())) {
            uiBean.setSyosisyatodokeumukbn(pMosKihon.getSyosisyatodokeumukbn());
        }
        else {
            uiBean.setSyosisyatodokeumukbn(null);
        }

        if (C_UmuKbn.ARI.eq(pMosKihon.getKakukisyouryakukbumukbn())) {
            uiBean.setKakukisyouryakukbumukbn(pMosKihon.getKakukisyouryakukbumukbn());
        }
        else {
            uiBean.setKakukisyouryakukbumukbn(null);
        }

        if (C_UmuKbn.ARI.eq(pMosKihon.getSeiymdmosseitouumukbn())) {
            uiBean.setSeiymdmosseitouumukbn(pMosKihon.getSeiymdmosseitouumukbn());
        }
        else {
            uiBean.setSeiymdmosseitouumukbn(null);
        }

        if (!BizUtil.isBlank(uiBean.getHhknsykgycd())) {
            BM_Syokugyou syokugyou = bizDomManager.getSyokugyou(uiBean.getHhknsykgycd());

            if (syokugyou != null) {
                uiBean.setHhknsykgynm(syokugyou.getSyokugyounm());
            }
        }

        if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(pMosKihon.getHknsyuruino()) ||
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(pMosKihon.getHknsyuruino())) {
            uiBean.setSyksbyensitihsyutktekiumu(C_UmuKbn.ARI);
        }

        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getTargettkhkkbn()) && C_UmuKbn.ARI.eq(uiBean.getNyknnrkumu())){
            if (uiBean.getRyosyuymd() != null &&
                (!pMosKihon.getSeitoufstpkei().equalsValue(BizCurrency.valueOf(0, pMosKihon.getSeitoufstpkei().getType())))){

                KeisanKijyungk keisankijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);
                BizCurrency kijyungk = new BizCurrency();
                if(C_ErrorKbn.OK.eq(keisankijyungk.exec(uiBean.getRyosyuymd(),pMosKihon.getMosfstpkei(),
                    pMosKihon.getSeitoufstpkei(),pMosKihon.getKyktuukasyu(),pMosKihon.getYennykntkhkkbn()))){
                    kijyungk = keisankijyungk.getKijyungk();
                    uiBean.setTargettkykkijyungk(kijyungk);
                }

                if (!C_TargetTkMokuhyoutiKbn.NOTARGET.eq(pMosKihon.getTargettkmkhtkbn()) &&
                    (!C_TargetTkMokuhyoutiKbn.BLNK.eq(pMosKihon.getTargettkmkhtkbn()))){

                    if(!uiBean.getTargettkykkijyungk().equals(BizCurrency.optional())){
                        KeisanTargetMokuhyougk keisantargetmokuhyougk = SWAKInjector.getInstance(KeisanTargetMokuhyougk.class);
                        uiBean.setMkhyouyensysnikougk(keisantargetmokuhyougk.exec(kijyungk,Integer.valueOf
                            (pMosKihon.getTargettkmkhtkbn().getValue())));
                    }
                }
            }
        }

        if (!C_Sisuukbn.BLNK.eq(pMosKihon.getSisuukbn()) &&
            !C_TumitatekinHaibunWariKbn.BLNK.eq(pMosKihon.getSisuuhaibunwarikbn()) &&
            !C_TumitatekinHaibunWariKbn.WARIAI000.eq(pMosKihon.getSisuuhaibunwarikbn())) {

            BM_SisuuKihon sisuunm = bizDomManager.getSisuuKihon(pMosKihon.getSisuukbn());

            if (sisuunm != null) {
                uiBean.setSisuunm(sisuunm.getSisuunm());
            }
        }
        uiBean.setZennoumousideumu(pMosKihon.getZennoumousideumu());

        uiBean.setKzktourokuservicetourokukbn(pMosKihon.getKzktourokuservicetourokukbn());
        uiBean.setKykdrtkykhukakbn(pMosKihon.getKykdrtkykhukakbn());
        uiBean.setSeigyoHknsyuruino(pMosKihon.getHknsyuruino());
        uiBean.setTeikisiharaitkykhkkbn(pMosKihon.getTeikisiharaitkykhkkbn());
        uiBean.setYnkhrkmgkannituutikbn(pMosKihon.getYnkhrkmgkannituutikbn());
    }

    private void setPropertyFromTMosSyouhinSyuKeiyaku(HT_MosSyouhn pMosSyouhn, HT_SyoriCTL pSyoriCTL) {

        if (C_UmuKbn.ARI.eq(uiBean.getNkhknumu())) {
            uiBean.setSyuhknkkn(null);
            uiBean.setSyuhknkknsmnkbn(C_HknkknsmnKbn.BLNK);
        }
        else {
            uiBean.setSyuhknkkn(zeroToNull(pMosSyouhn.getHknkkn()));
            uiBean.setSyuhknkknsmnkbn(pMosSyouhn.getHknkknsmnkbn());
        }

        uiBean.setSyuhrkkkn(zeroToNull(pMosSyouhn.getHrkkkn()));
        uiBean.setSyuhrkkknsmnkbn(pMosSyouhn.getHrkkknsmnkbn());

        uiBean.setSyudai1hknkkn(zeroToNull(pMosSyouhn.getDai1hknkkn()));

        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn())) {
            if (uiBean.getKyktuukasyu().eq(uiBean.getHrktuukasyu())) {
                uiBean.setHrktuukasyukykp(pMosSyouhn.getSyutkp());
            }
            else {
                if (uiBean.getRyosyuymd() == null) {
                    uiBean.setHrktuukasyukykp(BizCurrency.optional());
                }
                else {
                    if (BizNumber.ZERO.compareTo(pSyoriCTL.getNyknkwsrate()) != 0) {
                        if (!pMosSyouhn.getSyutkp().isZeroOrOptional()) {
                            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                            BizCurrency kanzanGaku = keisanGaikakanzan.exec(uiBean.getHrktuukasyu(),
                                pMosSyouhn.getSyutkp(), pSyoriCTL.getNyknkwsrate(), C_HasuusyoriKbn.SUTE);

                            uiBean.setHrktuukasyukykp(kanzanGaku);
                        }
                        else {
                            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(uiBean.getHrktuukasyu());

                            uiBean.setHrktuukasyukykp(BizCurrency.valueOf(0, currencyType));
                        }
                    }
                    else {
                        uiBean.setHrktuukasyukykp(BizCurrency.optional());
                    }
                }
            }
        }
        else {
            uiBean.setHrktuukasyukykp(pMosSyouhn.getHrktuukasyutkp());
        }

        uiBean.setSyup(pMosSyouhn.getSyutkp());

        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(uiBean.getPtratkituukasiteikbn())) {
            uiBean.setMossyup(pMosSyouhn.getHrktuukasyutkp());
        }
        else {
            uiBean.setMossyup(BizCurrency.optional());
        }

        uiBean.setSknenkinsyu(pMosSyouhn.getSknenkinsyu());
    }

    // S社導入対応時は、特約情報は考慮しないため、コメントアウト
    //
    //    private void setPropertyFromTMosSyouhinTokuyaku(List<HT_MosSyouhn> pMosSyouhnTkForSortList) {
    //        BizCurrency      syutkp                  = BizCurrency.valueOf(0);
    //        BizCurrency      syutktkjyp              = BizCurrency.valueOf(0);
    //        BizCurrency      syutkpkei               = BizCurrency.valueOf(0);
    //        BizCurrency      tkjypkei                = BizCurrency.valueOf(0);
    //
    //        if (pMosSyouhnTkForSortList != null && pMosSyouhnTkForSortList.size() > 0) {
    //            for (int i=0; i<pMosSyouhnTkForSortList.size();i++) {
    //                if (i == 0) {
    //                    HT_MosSyouhn mosSyouhn1 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei1 = null;
    //                    if (mosSyouhn1 != null) {
    //                        syouhnZokusei1 = mosSyouhn1.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei1 != null) {
    //                        uiBean.setDisptksyouhnnm1(syouhnZokusei1.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei1.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons1(mosSyouhn1.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons1(syouhnZokusei1.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn1.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn1(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn1(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd1(mosSyouhn1.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn1(mosSyouhn1.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn1(mosSyouhn1.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn1(mosSyouhn1.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn1(mosSyouhn1.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn1(mosSyouhn1.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp1(mosSyouhn1.getSyutkp());
    //
    //                        uiBean.setDisptkjyp1(mosSyouhn1.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn1.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn1.getTkjyp());
    //                    }
    //
    //                } else if (i == 1) {
    //                    HT_MosSyouhn mosSyouhn2 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei2 = null;
    //                    if (mosSyouhn2 != null) {
    //                        syouhnZokusei2 = mosSyouhn2.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei2 != null) {
    //                        uiBean.setDisptksyouhnnm2(syouhnZokusei2.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei2.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons2(mosSyouhn2.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons2(syouhnZokusei2.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn2.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn2(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn2(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd2(mosSyouhn2.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn2(mosSyouhn2.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn2(mosSyouhn2.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn2(mosSyouhn2.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn2(mosSyouhn2.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn2(mosSyouhn2.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp2(mosSyouhn2.getSyutkp());
    //
    //                        uiBean.setDisptkjyp2(mosSyouhn2.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn2.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn2.getTkjyp());
    //                    }
    //
    //                } else if (i == 2) {
    //                    HT_MosSyouhn mosSyouhn3 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei3 = null;
    //                    if (mosSyouhn3 != null) {
    //                        syouhnZokusei3 = mosSyouhn3.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei3 != null) {
    //                        uiBean.setDisptksyouhnnm3(syouhnZokusei3.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei3.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons3(mosSyouhn3.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons3(syouhnZokusei3.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn3.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn3(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn3(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd3(mosSyouhn3.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn3(mosSyouhn3.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn3(mosSyouhn3.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn3(mosSyouhn3.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn3(mosSyouhn3.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn3(mosSyouhn3.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp3(mosSyouhn3.getSyutkp());
    //
    //                        uiBean.setDisptkjyp3(mosSyouhn3.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn3.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn3.getTkjyp());
    //                    }
    //
    //                } else if (i == 3) {
    //                    HT_MosSyouhn mosSyouhn4 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei4 = null;
    //                    if (mosSyouhn4 != null) {
    //                        syouhnZokusei4 = mosSyouhn4.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei4 != null) {
    //                        uiBean.setDisptksyouhnnm4(syouhnZokusei4.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei4.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons4(mosSyouhn4.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons4(syouhnZokusei4.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn4.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn4(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn4(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd4(mosSyouhn4.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn4(mosSyouhn4.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn4(mosSyouhn4.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn4(mosSyouhn4.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn4(mosSyouhn4.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn4(mosSyouhn4.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp4(mosSyouhn4.getSyutkp());
    //
    //                        uiBean.setDisptkjyp4(mosSyouhn4.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn4.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn4.getTkjyp());
    //                    }
    //
    //                } else if (i == 4) {
    //                    HT_MosSyouhn mosSyouhn5 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei5 = null;
    //                    if (mosSyouhn5 != null) {
    //                        syouhnZokusei5 = mosSyouhn5.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei5 != null) {
    //                        uiBean.setDisptksyouhnnm5(syouhnZokusei5.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei5.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons5(mosSyouhn5.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons5(syouhnZokusei5.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn5.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn5(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn5(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd5(mosSyouhn5.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn5(mosSyouhn5.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn5(mosSyouhn5.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn5(mosSyouhn5.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn5(mosSyouhn5.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn5(mosSyouhn5.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp5(mosSyouhn5.getSyutkp());
    //
    //                        uiBean.setDisptkjyp5(mosSyouhn5.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn5.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn5.getTkjyp());
    //                    }
    //
    //                } else if (i == 5) {
    //                    HT_MosSyouhn mosSyouhn6 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei6 = null;
    //                    if (mosSyouhn6 != null) {
    //                        syouhnZokusei6 = mosSyouhn6.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei6 != null) {
    //                        uiBean.setDisptksyouhnnm6(syouhnZokusei6.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei6.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons6(mosSyouhn6.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons6(syouhnZokusei6.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn6.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn6(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn6(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd6(mosSyouhn6.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn6(mosSyouhn6.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn6(mosSyouhn6.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn6(mosSyouhn6.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn6(mosSyouhn6.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn6(mosSyouhn6.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp6(mosSyouhn6.getSyutkp());
    //
    //                        uiBean.setDisptkjyp6(mosSyouhn6.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn6.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn6.getTkjyp());
    //                    }
    //
    //                } else if (i == 6) {
    //                    HT_MosSyouhn mosSyouhn7 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei7 = null;
    //                    if (mosSyouhn7 != null) {
    //                        syouhnZokusei7 = mosSyouhn7.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei7 != null) {
    //                        uiBean.setDisptksyouhnnm7(syouhnZokusei7.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei7.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons7(mosSyouhn7.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons7(syouhnZokusei7.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn7.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn7(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn7(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd7(mosSyouhn7.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn7(mosSyouhn7.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn7(mosSyouhn7.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn7(mosSyouhn7.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn7(mosSyouhn7.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn7(mosSyouhn7.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp7(mosSyouhn7.getSyutkp());
    //
    //                        uiBean.setDisptkjyp7(mosSyouhn7.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn7.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn7.getTkjyp());
    //                    }
    //
    //                } else if (i == 7) {
    //                    HT_MosSyouhn mosSyouhn8 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei8 = null;
    //                    if (mosSyouhn8 != null) {
    //                        syouhnZokusei8 = mosSyouhn8.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei8 != null) {
    //                        uiBean.setDisptksyouhnnm8(syouhnZokusei8.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei8.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons8(mosSyouhn8.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons8(syouhnZokusei8.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn8.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn8(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn8(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd8(mosSyouhn8.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn8(mosSyouhn8.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn8(mosSyouhn8.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn8(mosSyouhn8.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn8(mosSyouhn8.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn8(mosSyouhn8.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp8(mosSyouhn8.getSyutkp());
    //
    //                        uiBean.setDisptkjyp8(mosSyouhn8.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn8.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn8.getTkjyp());
    //                    }
    //
    //                } else if (i == 8) {
    //                    HT_MosSyouhn mosSyouhn9 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei9 = null;
    //                    if (mosSyouhn9 != null) {
    //                        syouhnZokusei9 = mosSyouhn9.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei9 != null) {
    //                        uiBean.setDisptksyouhnnm9(syouhnZokusei9.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei9.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons9(mosSyouhn9.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons9(syouhnZokusei9.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn9.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn9(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn9(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd9(mosSyouhn9.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn9(mosSyouhn9.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn9(mosSyouhn9.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn9(mosSyouhn9.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn9(mosSyouhn9.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn9(mosSyouhn9.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp9(mosSyouhn9.getSyutkp());
    //
    //                        uiBean.setDisptkjyp9(mosSyouhn9.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn9.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn9.getTkjyp());
    //                    }
    //
    //                } else if (i == 9) {
    //                    HT_MosSyouhn mosSyouhn10 = pMosSyouhnTkForSortList.get(i);
    //                    BM_SyouhnZokusei syouhnZokusei10 = null;
    //                    if (mosSyouhn10 != null) {
    //                        syouhnZokusei10 = mosSyouhn10.getSyouhnZokusei();
    //                    }
    //                    if (syouhnZokusei10 != null) {
    //                        uiBean.setDisptksyouhnnm10(syouhnZokusei10.getSyouhnnm());
    //
    //                        C_UmuKbn tsnshrgndgkHyoujiumu = syouhnZokusei10.getTsnshrgndgkhyoujiumu();
    //                        if (C_UmuKbn.NONE.eq(tsnshrgndgkHyoujiumu)) {
    //                            uiBean.setDisptkkihons10(mosSyouhn10.getKihons());
    //                        }
    //                        else {
    //                            uiBean.setDisptkkihons10(syouhnZokusei10.getTsnshrgndgk());
    //                        }
    //
    //                        C_KataKbn katakbn = mosSyouhn10.getKatakbn();
    //                        if (C_KataKbn.HONNIN.eq(katakbn)) {
    //                            uiBean.setDisptokuyakukatakbn10(C_KataKbn.BLNK);
    //                        } else {
    //                            uiBean.setDisptokuyakukatakbn10(katakbn);
    //                        }
    //
    //                        uiBean.setSyouhnCd10(mosSyouhn10.getSyouhncd());
    //
    //                        uiBean.setDisptkkyhkatakbn10(mosSyouhn10.getKyhkatakbn());
    //
    //                        uiBean.setDisptkhknkkn10(mosSyouhn10.getHknkkn());
    //
    //                        uiBean.setDisptkhknkknsmnkbn10(mosSyouhn10.getHknkknsmnkbn());
    //
    //                        uiBean.setDisptkhrkkkn10(mosSyouhn10.getHrkkkn());
    //
    //                        uiBean.setDisptkhrkkknsmnkbn10(mosSyouhn10.getHrkkknsmnkbn());
    //
    //                        uiBean.setDisptkp10(mosSyouhn10.getSyutkp());
    //
    //                        uiBean.setDisptkjyp10(mosSyouhn10.getTkjyp());
    //
    //                        syutkpkei = syutkpkei.add(mosSyouhn10.getSyutkp());
    //
    //                        tkjypkei = tkjypkei.add(mosSyouhn10.getTkjyp());
    //                    }
    //                }
    //            }
    //        }
    //        syutkp = uiBean.getSyup();
    //        syutktkjyp = uiBean.getSyutkjyp();
    //
    //        syutkpkei = syutkpkei.add(syutkp);
    //        tkjypkei = tkjypkei.add(syutktkjyp);
    //
    //        uiBean.setSyutkpkei(syutkpkei);
    //        uiBean.setTkjypkei(tkjypkei);
    //    }

    private void setPropertyFromTUketoriKouzaInfo(List<HT_UketoriKouzaJyouhou> pUketoriKouzaJyouhouLst,
        HT_MosKihon pMosKihon) {

        for (HT_UketoriKouzaJyouhou uketoriKouzaJyouhou : pUketoriKouzaJyouhouLst) {
            String bankcd = uketoriKouzaJyouhou.getBankcd();
            String sitencd = uketoriKouzaJyouhou.getSitencd();

            getBankSitenNm.exec(bankcd, sitencd);

            String bankNmKj = getBankSitenNm.getBankNmKj();
            String sitenNmKj = getBankSitenNm.getSitenNmKj();
            if (C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN.eq(uketoriKouzaJyouhou.getUktkzsyubetukbn())) {
                if (!C_KouzaInfoInputHoryuuKbn.HORYUU.eq(uketoriKouzaJyouhou.getKouzainfoinputhoryuukbn())) {
                    uiBean.setKzsyuruikbn(uketoriKouzaJyouhou.getKzsyuruikbn());
                    uiBean.setBankcd(bankcd);
                    uiBean.setBanknmkj(bankNmKj);
                    uiBean.setSitencd(sitencd);
                    uiBean.setSitennmkj(sitenNmKj);
                    uiBean.setYokinkbn(uketoriKouzaJyouhou.getYokinkbn());
                    uiBean.setKouzano(uketoriKouzaJyouhou.getKouzano());
                    uiBean.setKzkykdoukbn(uketoriKouzaJyouhou.getKzkykdoukbn());
                    if (C_KzkykdouKbn.DOUITU.eq(uketoriKouzaJyouhou.getKzkykdoukbn())) {
                        if (C_KykKbn.KEIHI_DOUITU.eq(pMosKihon.getKykkbn())) {
                            uiBean.setKzmeiginmkn(pMosKihon.getHhknnmkn());
                        }
                        else {
                            uiBean.setKzmeiginmkn(pMosKihon.getKyknmkn());
                        }
                    }
                    else {
                        uiBean.setKzmeiginmkn(uketoriKouzaJyouhou.getKzmeiginmkn());
                    }
                }
            }
            if (C_UketorikouzasyubetuKbn.DSSOUKINYOUKOUZA.eq(uketoriKouzaJyouhou.getUktkzsyubetukbn())) {
                uiBean.setDsbankcd(bankcd);
                uiBean.setDsbanknmkj(bankNmKj);
                uiBean.setDssitencd(sitencd);
                uiBean.setDssitennmkj(sitenNmKj);
                uiBean.setDsyokinkbn(uketoriKouzaJyouhou.getYokinkbn());
                uiBean.setDskouzano(uketoriKouzaJyouhou.getKouzano());
                uiBean.setDskzmeiginmkn(uketoriKouzaJyouhou.getKzmeiginmkn());
            }
        }
    }

    private void setPropertyFromTUkouhuriKouzaInfo(HT_KouzaJyouhou pKouzaJyouhou, HT_MosKihon pMosKihon) {

        String bankcd = pKouzaJyouhou.getBankcd();
        String sitencd = pKouzaJyouhou.getSitencd();

        getBankSitenNm.exec(bankcd, sitencd);

        String bankNmKj = getBankSitenNm.getBankNmKj();
        String sitenNmKj = getBankSitenNm.getSitenNmKj();
        uiBean.setKzhuritourokuhoukbn(pKouzaJyouhou.getKzhuritourokuhoukbn());
        uiBean.setKouhurikouzainfobankcd(bankcd);
        uiBean.setKouhurikouzainfobanknmkj(bankNmKj);
        uiBean.setKouhurikouzainfositencd(sitencd);
        uiBean.setKouhurikouzainfositennmkj(sitenNmKj);
        uiBean.setKouhurikouzainfoyokinkbn(pKouzaJyouhou.getYokinkbn());
        uiBean.setKouhurikouzainfokouzano(pKouzaJyouhou.getKouzano());
        uiBean.setKouhurikouzainfokzdoukbn(pKouzaJyouhou.getKzkykdoukbn());
        if (C_KzkykdouKbn.DOUITU.eq(pKouzaJyouhou.getKzkykdoukbn())) {

            if (C_KykKbn.KEIHI_DOUITU.eq(pMosKihon.getKykkbn())) {

                uiBean.setKouhurikouzainfokzmeiginmkn(pMosKihon.getHhknnmkn());

            }
            else {

                uiBean.setKouhurikouzainfokzmeiginmkn(pMosKihon.getKyknmkn());
            }

        }
        else {

            uiBean.setKouhurikouzainfokzmeiginmkn(pKouzaJyouhou.getKzmeiginmkn());
        }

        uiBean.setKouzakakuniniraikbn(pKouzaJyouhou.getKouzakakuniniraikbn());

    }

    private void setPropertyFromCreditCardJyouhouInfo (HT_CreditCardJyouhou pCreditCardJyouhou,HT_SyoriCTL pSyoriCTL) {
        CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu = SWAKInjector.getInstance(CreditKessaiyouNoHensyuu.class);

        String dispCreditcardKessaiyouNo = creditKessaiyouNoHensyuu.exec(pCreditCardJyouhou.getCreditkessaiyouno());

        uiBean.setCardbrandkbn(pCreditCardJyouhou.getCardbrandkbn());
        if (C_CreditTrkjkKbn.BLNK.eq(pSyoriCTL.getCredittrkjkkbn())) {
            uiBean.setCredittrkjk("");
        }
        else if (C_CreditTrkjkKbn.TOUROKUTYUU.eq(pSyoriCTL.getCredittrkjkkbn())) {
            uiBean.setCredittrkjk("未登録");
        }
        else if (C_CreditTrkjkKbn.NG.eq(pSyoriCTL.getCredittrkjkkbn())) {
            uiBean.setCredittrkjk("登録済み（有効性エラー）");
        }
        else if (C_CreditTrkjkKbn.SUMI.eq(pSyoriCTL.getCredittrkjkkbn())) {
            if (C_CreditYuukoukakKbn.NG.eq(pSyoriCTL.getCredityuukoukakkbn()) ||
                C_CreditYuukoukakKbn.SYOUGOUERR.eq(pSyoriCTL.getCredityuukoukakkbn()) ||
                C_CreditYuukoukakKbn.CARDKAISYAHANTEIERR.eq(pSyoriCTL.getCredityuukoukakkbn())) {
                uiBean.setCredittrkjk("登録済み（有効性エラー）");
            }
            else if (C_CreditYuukoukakKbn.OK.eq(pSyoriCTL.getCredityuukoukakkbn())) {
                uiBean.setCredittrkjk("登録済み");
            }
        }

        uiBean.setDispcreditkessaiyouno(dispCreditcardKessaiyouNo);
        uiBean.setCredittrkhoukbn(pCreditCardJyouhou.getCredittrkhoukbn());
    }

    private void setPropertyFromMosTrkKzkInfo(List<HT_MosTrkKzk> pMosTrkKzkLst) {

        for (HT_MosTrkKzk mosTrkKzk : pMosTrkKzkLst) {
            if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {
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

            if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {
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

    private void setPropertyFromTUketorinin(List<HT_Uketorinin> pUketorininLst) {

        int uketorininIndex = 0;

        for (int i = 0; i < pUketorininLst.size(); i++) {
            if (C_UktsyuKbn.NKUKT.eq(pUketorininLst.get(i).getUktsyukbn())) {
                uiBean.setNenkinuktkbn(pUketorininLst.get(i).getUktkbn());
            }
            else if (C_UktsyuKbn.STDRSK.eq(pUketorininLst.get(i).getUktsyukbn())) {
                uiBean.setStdruktkbn(pUketorininLst.get(i).getUktkbn());
                uiBean.setSiteidruktnmkn(pUketorininLst.get(i).getUktnmkn());
                uiBean.setSiteidruktnmkj(pUketorininLst.get(i).getUktnmkj());
                uiBean.setStdrsknmkjhukakbn(pUketorininLst.get(i).getUktnmkjkhukakbn());
                uiBean.setSiteidrseiymd(pUketorininLst.get(i).getUktseiymd());
                uiBean.setSiteidrukttdk(pUketorininLst.get(i).getUkttdk());
            }
            else if (C_UktsyuKbn.KYKDRN.eq(pUketorininLst.get(i).getUktsyukbn())) {
                uiBean.setKykdrkbn(pUketorininLst.get(i).getUktkbn());
            }
            else {
                if (uketorininIndex == 0) {
                    uiBean.setSbuUktSyurenNo1(pUketorininLst.get(i).getUktsyurenno());
                    uiBean.setDispsbuktkbn1(pUketorininLst.get(i).getUktkbn());
                    uiBean.setDispsbuktnmkn1(pUketorininLst.get(i).getUktnmkn());
                    uiBean.setDispsbuktnmkj1(pUketorininLst.get(i).getUktnmkj());
                    uiBean.setDispsbuktnmkjhukakbn1(pUketorininLst.get(i).getUktnmkjkhukakbn());
                    uiBean.setDispsbuktseiymd1(pUketorininLst.get(i).getUktseiymd());
                    uiBean.setDispsbukttdk1(pUketorininLst.get(i).getUkttdk());
                    uiBean.setDispsbuktbnwari1(pUketorininLst.get(i).getUktbnwari());
                }
                else if (uketorininIndex == 1) {
                    uiBean.setSbuUktSyurenNo2(pUketorininLst.get(i).getUktsyurenno());
                    uiBean.setDispsbuktkbn2(pUketorininLst.get(i).getUktkbn());
                    uiBean.setDispsbuktnmkn2(pUketorininLst.get(i).getUktnmkn());
                    uiBean.setDispsbuktnmkj2(pUketorininLst.get(i).getUktnmkj());
                    uiBean.setDispsbuktnmkjhukakbn2(pUketorininLst.get(i).getUktnmkjkhukakbn());
                    uiBean.setDispsbuktseiymd2(pUketorininLst.get(i).getUktseiymd());
                    uiBean.setDispsbukttdk2(pUketorininLst.get(i).getUkttdk());
                    uiBean.setDispsbuktbnwari2(pUketorininLst.get(i).getUktbnwari());
                }
                else if (uketorininIndex == 2) {
                    uiBean.setSbuUktSyurenNo3(pUketorininLst.get(i).getUktsyurenno());
                    uiBean.setDispsbuktkbn3(pUketorininLst.get(i).getUktkbn());
                    uiBean.setDispsbuktnmkn3(pUketorininLst.get(i).getUktnmkn());
                    uiBean.setDispsbuktnmkj3(pUketorininLst.get(i).getUktnmkj());
                    uiBean.setDispsbuktnmkjhukakbn3(pUketorininLst.get(i).getUktnmkjkhukakbn());
                    uiBean.setDispsbuktseiymd3(pUketorininLst.get(i).getUktseiymd());
                    uiBean.setDispsbukttdk3(pUketorininLst.get(i).getUkttdk());
                    uiBean.setDispsbuktbnwari3(pUketorininLst.get(i).getUktbnwari());
                }
                else if (uketorininIndex == 3) {
                    uiBean.setSbuUktSyurenNo4(pUketorininLst.get(i).getUktsyurenno());
                    uiBean.setDispsbuktkbn4(pUketorininLst.get(i).getUktkbn());
                    uiBean.setDispsbuktnmkn4(pUketorininLst.get(i).getUktnmkn());
                    uiBean.setDispsbuktnmkj4(pUketorininLst.get(i).getUktnmkj());
                    uiBean.setDispsbuktnmkjhukakbn4(pUketorininLst.get(i).getUktnmkjkhukakbn());
                    uiBean.setDispsbuktseiymd4(pUketorininLst.get(i).getUktseiymd());
                    uiBean.setDispsbukttdk4(pUketorininLst.get(i).getUkttdk());
                    uiBean.setDispsbuktbnwari4(pUketorininLst.get(i).getUktbnwari());
                }

                uketorininIndex = uketorininIndex + 1;
            }
        }
    }

    private void editDairitenInfo(BizDate pMosymd, List<HT_MosDairiten> pMosDairiten) {

        String[] jimusyoCdLst                    = new String[pMosDairiten.size()];
        String[] bosyuuninTourokuNoLst           = new String[pMosDairiten.size()];
        String[] inputBosyuuCdLst                = new String[pMosDairiten.size()];
        String[] kinyuuCdLst                     = new String[pMosDairiten.size()];
        String[] kinyuuSitenCdLst                = new String[pMosDairiten.size()];
        String[] tratkiKouinnCdLst               = new String[pMosDairiten.size()];
        String[] tratkiDrtenCdLst                = new String[pMosDairiten.size()];
        String[] tratkiDrtenNmLst                = new String[pMosDairiten.size()];
        String[] oyaDrtenCdLst                   = new String[pMosDairiten.size()];
        String[] oyaDrtenNmLst                   = new String[pMosDairiten.size()];
        String[] bosyuuCdLst                     = new String[pMosDairiten.size()];
        String[] bosyuuninNmLst                  = new String[pMosDairiten.size()];
        String[] gyskKjsakiSosikiCdLst           = new String[pMosDairiten.size()];
        String[] gyskKjsakiSosikiNmLst           = new String[pMosDairiten.size()];
        BizNumber[] bunwariLst                   = new BizNumber[pMosDairiten.size()];
        String cifCd                             = "";
        int count                                = 0;
        Integer[] drtenRennoLst                  = new  Integer[pMosDairiten.size()];
        String tratkidrtrnNmKj                   = "";
        String oyadrtenNmKj                      = "";
        String bosyuuNmKj                        = "";

        for (int i = 0; i < pMosDairiten.size(); i++) {

            HT_MosDairiten mosDairiten = pMosDairiten.get(i);

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
            List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

            if (bzGetAgInfoBeanLst.size() >= 1) {
                tratkidrtrnNmKj = bzGetAgInfoBeanLst.get(0).getKanjiDairitenNm();
            }
            if (bzGetAgInfoBeanLst.size() >= 2) {
                oyadrtenNmKj = bzGetAgInfoBeanLst.get(1).getKanjiDairitenNm();
            }

            BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
            BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(mosDairiten.getBosyuucd());

            if (bzGetBsInfoBean != null) {
                bosyuuNmKj = bzGetBsInfoBean.getKanjiBosyuuninNm();
            }

            BzGetSosikiData BzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
            BzGetSosikiDataBean bzGetSosikiDataBean =
                BzGetSosikiData.exec(mosDairiten.getGyousekikeijyousakisosikicd(), null);

            jimusyoCdLst[count] = mosDairiten.getJimusyocd();
            bosyuuninTourokuNoLst[count] = mosDairiten.getBosyuutrkno();
            inputBosyuuCdLst[count] = mosDairiten.getInputbosyuucd();
            kinyuuCdLst[count] = mosDairiten.getKinyuucd();
            kinyuuSitenCdLst[count] = mosDairiten.getKinyuusitencd();
            tratkiKouinnCdLst[count] = mosDairiten.getTratkikouinncd();
            tratkiDrtenCdLst[count] = mosDairiten.getTratkiagcd();
            tratkiDrtenNmLst[count] = tratkidrtrnNmKj;
            oyaDrtenCdLst[count] = mosDairiten.getOyadrtencd();
            oyaDrtenNmLst[count] = oyadrtenNmKj;
            bosyuuCdLst[count] = mosDairiten.getBosyuucd();
            bosyuuninNmLst[count] = bosyuuNmKj;
            gyskKjsakiSosikiCdLst[count] = mosDairiten.getGyousekikeijyousakisosikicd();
            gyskKjsakiSosikiNmLst[count] = bzGetSosikiDataBean.getKanjisosikinm20();
            bunwariLst[count] = mosDairiten.getBunwari();
            drtenRennoLst[count] = mosDairiten.getRenno();

            if (Integer.valueOf("1").equals(mosDairiten.getRenno())) {
                cifCd = mosDairiten.getCifcd();
            }
            count++;

            tratkidrtrnNmKj = "";
            oyadrtenNmKj    = "";
            bosyuuNmKj      = "";
        }

        if (jimusyoCdLst.length > 0) {
            for (int i = 0; i < jimusyoCdLst.length; i++) {
                if (i == 0) {
                    uiBean.setMosDairitenRenno1(drtenRennoLst[i]);
                    uiBean.setDispjimusyocd1(jimusyoCdLst[i]);
                    uiBean.setDispbosyuutrkno1(bosyuuninTourokuNoLst[i]);
                    uiBean.setDispinputbosyuucd1(inputBosyuuCdLst[i]);
                    uiBean.setDispkinyuucd1(kinyuuCdLst[i]);
                    uiBean.setDispkinyuusitencd1(kinyuuSitenCdLst[i]);
                    uiBean.setDisptratkikouinncd1(tratkiKouinnCdLst[i]);
                    uiBean.setDisptratkiagcd1(tratkiDrtenCdLst[i]);
                    uiBean.setDisptratkiagnm1(tratkiDrtenNmLst[i]);
                    uiBean.setDispoyadrtencd1(oyaDrtenCdLst[i]);
                    uiBean.setDispoyadrtennm1(oyaDrtenNmLst[i]);
                    uiBean.setDispbosyuucd1(bosyuuCdLst[i]);
                    uiBean.setDispbosyuunm1(bosyuuninNmLst[i]);
                    uiBean.setDispgyskkjsakisosikicd1(gyskKjsakiSosikiCdLst[i]);
                    uiBean.setDispgyskkjsakisosikinmkj1(gyskKjsakiSosikiNmLst[i]);
                    uiBean.setDispbunwari1(bunwariLst[i]);
                }
                else if (i == 1) {
                    uiBean.setMosDairitenRenno2(drtenRennoLst[i]);
                    uiBean.setDispjimusyocd2(jimusyoCdLst[i]);
                    uiBean.setDispbosyuutrkno2(bosyuuninTourokuNoLst[i]);
                    uiBean.setDispinputbosyuucd2(inputBosyuuCdLst[i]);
                    uiBean.setDispkinyuucd2(kinyuuCdLst[i]);
                    uiBean.setDispkinyuusitencd2(kinyuuSitenCdLst[i]);
                    uiBean.setDisptratkikouinncd2(tratkiKouinnCdLst[i]);
                    uiBean.setDisptratkiagcd2(tratkiDrtenCdLst[i]);
                    uiBean.setDisptratkiagnm2(tratkiDrtenNmLst[i]);
                    uiBean.setDispoyadrtencd2(oyaDrtenCdLst[i]);
                    uiBean.setDispoyadrtennm2(oyaDrtenNmLst[i]);
                    uiBean.setDispbosyuucd2(bosyuuCdLst[i]);
                    uiBean.setDispbosyuunm2(bosyuuninNmLst[i]);
                    uiBean.setDispgyskkjsakisosikicd2(gyskKjsakiSosikiCdLst[i]);
                    uiBean.setDispgyskkjsakisosikinmkj2(gyskKjsakiSosikiNmLst[i]);
                    uiBean.setDispbunwari2(bunwariLst[i]);
                }
            }

            uiBean.setCifcd(cifCd);
        }
    }

    private void setPropertyFromTKokutisyo(HT_Kokutisyo pKokutisyo) {

        uiBean.setKktkktymd(pKokutisyo.getKktymd());
        uiBean.setSintyou(pKokutisyo.getSintyou());
        uiBean.setTaijyuu(pKokutisyo.getTaijyuu());
        uiBean.setKijikbn(pKokutisyo.getKijikbn());
    }

    private void setPropertyFromTMosTnknRrk(List<HT_MostenkenRireki> pMostenkenRirekiLst) {

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(uiBean.getMosno());

        if (pMostenkenRirekiLst != null && pMostenkenRirekiLst.size() > 0) {
            for (int i = 0; i < pMostenkenRirekiLst.size(); i++) {
                if (i == 0) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo1(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd1(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn1(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn1(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment1(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns1(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm1(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 1) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo2(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd2(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn2(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn2(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment2(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns2(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm2(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 2) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo3(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd3(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn3(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn3(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment3(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns3(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm3(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 3) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo4(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd4(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn4(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn4(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment4(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns4(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm4(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 4) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo5(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd5(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn5(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn5(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment5(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns5(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm5(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 5) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo6(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd6(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn6(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn6(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment6(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns6(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm6(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 6) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo7(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd7(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn7(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn7(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment7(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns7(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm7(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 7) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo8(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd8(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn8(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn8(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment8(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns8(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm8(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 8) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo9(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd9(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn9(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn9(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment9(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns9(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm9(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 9) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo10(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd10(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn10(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn10(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment10(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns10(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm10(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 10) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo11(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd11(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn11(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn11(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment11(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns11(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm11(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 11) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo12(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd12(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn12(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn12(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment12(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns12(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm12(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 12) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo13(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd13(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn13(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn13(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment13(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns13(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm13(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 13) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo14(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd14(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn14(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn14(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment14(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns14(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm14(ketteiSya2.getKetsyanm());
                    }
                }

                if (i == 14) {
                    HM_KetteiSya ketteiSya1 = pMostenkenRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pMostenkenRirekiLst.get(i).getKetteiSya();

                    String mostenkenComment = editSecurityKm.decode(pMostenkenRirekiLst.get(i).getMostenkencomment());

                    uiBean.setMostenkenRirekiNo15(pMostenkenRirekiLst.get(i).getRenno());
                    uiBean.setDispmostenkensyoriymd15(pMostenkenRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispmostnknstktsyorinmkbn15(pMostenkenRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispmostenkenkekkakbn15(pMostenkenRirekiLst.get(i).getMostenkenkekkakbn());
                    uiBean.setDispmostenkencomment15(mostenkenComment);

                    if (ketteiSya1 != null) {
                        uiBean.setDispmostns15(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispmostenkenktnm15(ketteiSya2.getKetsyanm());
                    }
                }
            }
        }
        else {
            uiBean.setDispmostnknstktsyorinmkbn1(null);
        }
    }

    private void setPropertyFromTKnkSateiRrk(List<HT_KnksateiRireki> pKnksateiRirekiLst) {

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(uiBean.getMosno());

        if (pKnksateiRirekiLst != null && pKnksateiRirekiLst.size() > 0) {
            for (int i = 0; i < pKnksateiRirekiLst.size(); i++) {
                if (i == 0) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment1 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo1(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd1(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn1(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn1(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns1(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm1(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment1(knksateiComment1);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd1(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd11(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd21(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd31(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd41(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou11(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou21(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou31(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou41(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu1(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou1(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 1) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment2 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo2(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd2(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn2(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn2(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns2(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm2(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment2(knksateiComment2);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd2(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd12(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd22(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd32(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd42(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou12(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou22(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou32(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou42(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu2(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou2(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 2) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment3 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo3(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd3(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn3(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn3(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns3(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm3(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment3(knksateiComment3);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd3(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd13(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd23(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd33(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd43(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou13(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou23(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou33(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou43(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu3(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou3(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 3) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment4 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo4(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd4(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn4(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn4(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns4(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm4(ketteiSya2.getKetsyanm());
                    }
                    uiBean.setDispknkcomment4(knksateiComment4);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd4(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd14(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd24(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd34(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd44(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou14(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou24(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou34(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou44(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu4(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou4(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 4) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment5 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo5(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd5(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn5(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn5(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns5(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm5(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment5(knksateiComment5);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd5(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd15(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd25(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd35(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd45(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou15(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou25(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou35(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou45(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu5(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou5(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 5) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment6 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo6(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd6(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn6(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn6(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns6(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm6(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment6(knksateiComment6);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd6(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd16(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd26(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd36(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd46(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou16(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou26(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou36(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou46(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu6(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou6(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 6) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment7 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo7(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd7(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn7(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn7(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns7(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm7(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment7(knksateiComment7);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd7(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd17(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd27(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd37(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd47(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou17(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou27(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou37(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou47(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu7(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou7(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 7) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment8 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo8(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd8(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn8(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn8(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns8(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm8(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment8(knksateiComment8);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd8(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd18(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd28(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd38(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd48(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou18(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou28(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou38(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou48(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu8(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou8(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 8) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment9 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo9(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd9(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn9(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn9(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns9(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm9(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment9(knksateiComment9);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd9(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd19(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd29(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd39(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd49(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou19(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou29(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou39(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou49(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu9(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou9(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 9) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment10 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo10(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd10(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn10(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn10(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns10(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm10(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment10(knksateiComment10);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd10(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd110(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd210(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd310(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd410(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou110(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou210(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou310(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou410(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu10(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou10(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 10) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment11 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo11(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd11(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn11(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn11(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns11(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm11(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment11(knksateiComment11);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd11(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd111(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd211(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd311(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd411(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou111(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou211(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou311(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou411(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu11(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou11(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 11) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment12 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo12(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd12(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn12(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn12(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns12(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm12(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment12(knksateiComment12);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd12(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd112(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd212(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd312(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd412(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou112(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou212(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou312(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou412(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu12(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou12(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 12) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment13 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo13(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd13(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn13(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn13(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns13(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm13(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment13(knksateiComment13);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd13(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd113(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd213(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd313(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd413(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou113(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou213(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou313(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou413(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu13(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou13(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 13) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment14 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo14(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd14(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn14(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn14(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns14(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm14(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment14(knksateiComment14);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd14(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd114(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd214(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd314(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd414(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou114(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou214(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou314(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou414(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu14(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou14(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
                else if (i == 14) {
                    HM_KetteiSya ketteiSya1 = pKnksateiRirekiLst.get(i).getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = pKnksateiRirekiLst.get(i).getKetteiSya();

                    String knksateiComment15 = editSecurityKm.decode(pKnksateiRirekiLst.get(i).getKnksateicomment());

                    uiBean.setKankyouSateiRirekiNo15(pKnksateiRirekiLst.get(i).getRenno());
                    uiBean.setDispknksyoriymd15(pKnksateiRirekiLst.get(i).getSyoriYmd());
                    uiBean.setDispknkstktsyorinmkbn15(pKnksateiRirekiLst.get(i).getSateiketsyorinmkbn());
                    uiBean.setDispknkkekkakbn15(pKnksateiRirekiLst.get(i).getKnksateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispknktns15(ketteiSya1.getKetsyanm());
                    }

                    if (ketteiSya2 != null) {
                        uiBean.setDispknkktnm15(ketteiSya2.getKetsyanm());
                    }

                    uiBean.setDispknkcomment15(knksateiComment15);

                    C_Ketriyuucd ketRiyuuCdKbn1 = pKnksateiRirekiLst.get(i).getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = pKnksateiRirekiLst.get(i).getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = pKnksateiRirekiLst.get(i).getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = pKnksateiRirekiLst.get(i).getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispknkktkkcd15(pKnksateiRirekiLst.get(i).getKetkekkacd());
                    uiBean.setDispknkketriyuucd115(ketRiyuuCd1);
                    uiBean.setDispknkketriyuucd215(ketRiyuuCd2);
                    uiBean.setDispknkketriyuucd315(ketRiyuuCd3);
                    uiBean.setDispknkketriyuucd415(ketRiyuuCd4);
                    uiBean.setDispknkketriyuunaiyou115(ketRiyuu1);
                    uiBean.setDispknkketriyuunaiyou215(ketRiyuu2);
                    uiBean.setDispknkketriyuunaiyou315(ketRiyuu3);
                    uiBean.setDispknkketriyuunaiyou415(ketRiyuu4);
                    uiBean.setDispknktrkssyousairiyuu15(pKnksateiRirekiLst.get(i).getTorikesisyousairiyuucd());
                    uiBean.setDispknkmrriyuucdnaiyou15(pKnksateiRirekiLst.get(i).getMrriyuucdkbn());
                }
            }
        }

        else {
            uiBean.setDispknkstktsyorinmkbn1(null);
        }
    }

    private void setPropertyFromTImuSateiRrk(List<HT_ImusateiRireki> pImusateiRirekiLst) {

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(uiBean.getMosno());

        String syoubyouCd1;
        String syoubyouCd2;

        if (pImusateiRirekiLst != null && pImusateiRirekiLst.size() > 0) {

            for (int i = 0; i < pImusateiRirekiLst.size(); i++) {
                if (i == 0) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban1(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd1(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn1(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn1(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns1(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment1(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm1(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd1(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd11(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd21(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd31(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd41(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou11(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou21(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou31(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou41(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh1(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd11(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm11(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm11("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm11("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd21(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm21(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm21("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm21("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai11(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym11(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai21(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym21(kantiYm2);
                }
                else if (i == 1) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban2(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd2(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn2(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn2(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns2(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment2(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm2(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd2(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd12(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd22(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd32(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd42(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou12(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou22(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou32(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou42(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh2(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd12(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm12(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm12("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm12("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd22(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm22(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm22("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm22("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai12(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym12(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai22(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym22(kantiYm2);
                }
                else if (i == 2) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban3(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd3(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn3(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn3(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns3(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment3(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm3(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd3(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd13(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd23(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd33(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd43(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou13(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou23(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou33(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou43(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh3(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd13(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm13(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm13("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm13("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd23(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm23(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm23("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm23("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai13(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym13(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai23(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym23(kantiYm2);

                }
                else if (i == 3) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());
                    uiBean.setImuSateiRenban4(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd4(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn4(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn4(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns4(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment4(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm4(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd4(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd14(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd24(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd34(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd44(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou14(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou24(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou34(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou44(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh4(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd14(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm14(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm14("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm14("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd24(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm24(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm24("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm24("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai14(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym14(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai24(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym24(kantiYm2);

                }
                else if (i == 4) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban5(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd5(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn5(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn5(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns5(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment5(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm5(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd5(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd15(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd25(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd35(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd45(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou15(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou25(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou35(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou45(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh5(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd15(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm15(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm15("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm15("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd25(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm25(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm25("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm25("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai15(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym15(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai25(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym25(kantiYm2);
                }
                else if (i == 5) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban6(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd6(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn6(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn6(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns6(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment6(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm6(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd6(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd16(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd26(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd36(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd46(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou16(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou26(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou36(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou46(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh6(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd16(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm16(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm16("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm16("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd26(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm26(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm26("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm26("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai16(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym16(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai26(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym26(kantiYm2);

                }
                else if (i == 6) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban7(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd7(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn7(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn7(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns7(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment7(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm7(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd7(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd17(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd27(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd37(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd47(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou17(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou27(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou37(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou47(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh7(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd17(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm17(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm17("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm17("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd27(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm27(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm27("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm27("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai17(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym17(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai27(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym27(kantiYm2);

                }
                else if (i == 7) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban8(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd8(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn8(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn8(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns8(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment8(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm8(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd8(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd18(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd28(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd38(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd48(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou18(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou28(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou38(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou48(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh8(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd18(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm18(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm18("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm18("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd28(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm28(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm28("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm28("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai18(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym18(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai28(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym28(kantiYm2);
                }
                else if (i == 8) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban9(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd9(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn9(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn9(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns9(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment9(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm9(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd9(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd19(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd29(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd39(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd49(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou19(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou29(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou39(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou49(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh9(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd19(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm19(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm19("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm19("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd29(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm29(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm29("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm29("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai19(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym19(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai29(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym29(kantiYm2);

                }
                else if (i == 9) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban10(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd10(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn10(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn10(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns10(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment10(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm10(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd10(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd110(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd210(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd310(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd410(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou110(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou210(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou310(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou410(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh10(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd110(syoubyouCd1);

                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm110(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm110("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm110("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd210(syoubyouCd2);

                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm210(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm210("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm210("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai110(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym110(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai210(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym210(kantiYm2);

                }
                else if (i == 10) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban11(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd11(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn11(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn11(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns11(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment11(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm11(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd11(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd111(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd211(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd311(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd411(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou111(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou211(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou311(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou411(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh11(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd111(syoubyouCd1);
                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm111(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm111("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm111("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd211(syoubyouCd2);
                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm211(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm211("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm211("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai111(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym111(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai211(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym211(kantiYm2);

                }
                else if (i == 11) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban12(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd12(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn12(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn12(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns12(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment12(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm12(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd12(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd112(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd212(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd312(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd412(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou112(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou212(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou312(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou412(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh12(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd112(syoubyouCd1);
                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm112(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm112("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm112("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd212(syoubyouCd2);
                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm212(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm212("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm212("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai112(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym112(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai212(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym212(kantiYm2);
                }
                else if (i == 12) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban13(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd13(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn13(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn13(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns13(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment13(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm13(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd13(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd113(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd213(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd313(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd413(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou113(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou213(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou313(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou413(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh13(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd113(syoubyouCd1);
                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm113(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm113("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm113("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd213(syoubyouCd2);
                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm213(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm213("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm213("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai113(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym113(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai213(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym213(kantiYm2);
                }
                else if (i == 13) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban14(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd14(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn14(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn14(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns14(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment14(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm14(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd14(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd114(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd214(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd314(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd414(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou114(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou214(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou314(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou414(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh14(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd114(syoubyouCd1);
                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm114(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm114("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm114("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd214(syoubyouCd2);
                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm214(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm214("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm214("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai114(syoubyouJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym114(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai214(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym214(kantiYm2);
                }
                else if (i == 14) {
                    HT_ImusateiRireki imusateiRireki = pImusateiRirekiLst.get(i);

                    HM_KetteiSya ketteiSya1 = imusateiRireki.getTensousakiKetteiSya();
                    HM_KetteiSya ketteiSya2 = imusateiRireki.getKetteiSya();

                    String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());

                    uiBean.setImuSateiRenban15(imusateiRireki.getRenno());
                    uiBean.setDispimusyoriymd15(imusateiRireki.getSyoriYmd());
                    uiBean.setDispimustktsyorinmkbn15(imusateiRireki.getSateiketsyorinmkbn());
                    uiBean.setDispimukekkakbn15(imusateiRireki.getImusateikekkakbn());

                    if (ketteiSya1 != null) {
                        uiBean.setDispimutns15(ketteiSya1.getKetsyanm());
                    }

                    uiBean.setDispimucomment15(imusateiComment);

                    if (ketteiSya2 != null) {
                        uiBean.setDispimuktnm15(ketteiSya2.getKetsyanm());
                    }

                    C_Ketriyuucd ketRiyuuCdKbn1 = imusateiRireki.getKetriyuucd1();
                    C_Ketriyuucd ketRiyuuCdKbn2 = imusateiRireki.getKetriyuucd2();
                    C_Ketriyuucd ketRiyuuCdKbn3 = imusateiRireki.getKetriyuucd3();
                    C_Ketriyuucd ketRiyuuCdKbn4 = imusateiRireki.getKetriyuucd4();
                    String ketRiyuuCd1 = "";
                    String ketRiyuuCd2 = "";
                    String ketRiyuuCd3 = "";
                    String ketRiyuuCd4 = "";
                    String ketRiyuu1 = "";
                    String ketRiyuu2 = "";
                    String ketRiyuu3 = "";
                    String ketRiyuu4 = "";

                    if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                        ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                        ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                    }

                    if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                        ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                        ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                    }

                    if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                        ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                        ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                    }

                    if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                        ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                        ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                    }

                    uiBean.setDispimuketkekkacd15(imusateiRireki.getKetkekkacd());
                    uiBean.setDispimuketriyuucd115(ketRiyuuCd1);
                    uiBean.setDispimuketriyuucd215(ketRiyuuCd2);
                    uiBean.setDispimuketriyuucd315(ketRiyuuCd3);
                    uiBean.setDispimuketriyuucd415(ketRiyuuCd4);
                    uiBean.setDispimuketriyuunaiyou115(ketRiyuu1);
                    uiBean.setDispimuketriyuunaiyou215(ketRiyuu2);
                    uiBean.setDispimuketriyuunaiyou315(ketRiyuu3);
                    uiBean.setDispimuketriyuunaiyou415(ketRiyuu4);
                    uiBean.setDispimusntksakuseiyh15(imusateiRireki.getSntkinfosakuseiyhkbn());

                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    uiBean.setDispimusyoubyoucd115(syoubyouCd1);
                    if (!BizUtil.isBlank(syoubyouCd1)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm115(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm115("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm115("");
                    }

                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    uiBean.setDispimusyoubyoucd215(syoubyouCd2);
                    if (!BizUtil.isBlank(syoubyouCd2)) {
                        BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                        if (syoubyou != null) {
                            uiBean.setDispimusyoubyounm215(syoubyou.getSyoubyounm());
                        }
                        else {
                            uiBean.setDispimusyoubyounm215("");
                        }
                        syoubyou = null;
                    }
                    else {
                        uiBean.setDispimusyoubyounm215("");
                    }

                    C_SyoubyoujyoutaiKbn syoubyoujJyoutai1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    uiBean.setDispimusyoubyoujyoutai115(syoubyoujJyoutai1);

                    BizDateYM kantiYm1 = imusateiRireki.getKantiym1();
                    uiBean.setDispimukantiym115(kantiYm1);

                    C_SyoubyoujyoutaiKbn syoubyouJyoutai2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    uiBean.setDispimusyoubyoujyoutai215(syoubyouJyoutai2);

                    BizDateYM kantiYm2 = imusateiRireki.getKantiym2();
                    uiBean.setDispimukantiym215(kantiYm2);
                }
            }
        }

        else {
            uiBean.setDispimustktsyorinmkbn1(null);
            uiBean.setDispimusntksakuseiyh1(null);
        }

    }

    private void setPropertyFromTDakuhiKettei(List<HT_DakuhiKettei> pDakuhiKetteiLst) {

        String syoubyouCd1;
        String syoubyouCd2;

        if (pDakuhiKetteiLst.size() == 0) {
            uiBean.setDispsntksakuseiyh1(null);
        }

        for (int i = 0; i < pDakuhiKetteiLst.size(); i++) {
            if (i == 0) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno1(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd1(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd1(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh1(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu1(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou1(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd11(ketRiyuuCd1);
                uiBean.setDispketriyuucd21(ketRiyuuCd2);
                uiBean.setDispketriyuucd31(ketRiyuuCd3);
                uiBean.setDispketriyuucd41(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou11(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou21(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou31(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou41(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd11(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm11(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm11("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm11("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd21(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm21(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm21("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm21("");
                }

                C_SyoubyoujyoutaiKbn syoubyouJyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiYm1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyouJyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiYm2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai11(syoubyouJyoutaikbn1);
                uiBean.setDispkantiym11(kantiYm1);
                uiBean.setDispsyoubyoujyoutai21(syoubyouJyoutaikbn2);
                uiBean.setDispkantiym21(kantiYm2);

            }
            else if (i == 1) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno2(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd2(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd2(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh2(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu2(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou2(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd12(ketRiyuuCd1);
                uiBean.setDispketriyuucd22(ketRiyuuCd2);
                uiBean.setDispketriyuucd32(ketRiyuuCd3);
                uiBean.setDispketriyuucd42(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou12(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou22(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou32(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou42(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd12(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm12(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm12("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm12("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd22(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm22(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm22("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm22("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai12(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym12(kantiym1);
                uiBean.setDispsyoubyoujyoutai22(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym22(kantiym2);

            }
            else if (i == 2) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno3(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd3(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd3(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh3(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu3(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou3(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd13(ketRiyuuCd1);
                uiBean.setDispketriyuucd23(ketRiyuuCd2);
                uiBean.setDispketriyuucd33(ketRiyuuCd3);
                uiBean.setDispketriyuucd43(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou13(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou23(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou33(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou43(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd13(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm13(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm13("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm13("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd23(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm23(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm23("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm23("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai13(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym13(kantiym1);
                uiBean.setDispsyoubyoujyoutai23(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym23(kantiym2);
            }
            else if (i == 3) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno4(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd4(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd4(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh4(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu4(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou4(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd14(ketRiyuuCd1);
                uiBean.setDispketriyuucd24(ketRiyuuCd2);
                uiBean.setDispketriyuucd34(ketRiyuuCd3);
                uiBean.setDispketriyuucd44(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou14(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou24(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou34(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou44(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd14(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm14(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm14("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm14("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd24(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm24(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm24("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm24("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai14(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym14(kantiym1);
                uiBean.setDispsyoubyoujyoutai24(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym24(kantiym2);
            }
            else if (i == 4) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno5(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd5(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd5(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh5(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu5(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou5(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd15(ketRiyuuCd1);
                uiBean.setDispketriyuucd25(ketRiyuuCd2);
                uiBean.setDispketriyuucd35(ketRiyuuCd3);
                uiBean.setDispketriyuucd45(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou15(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou25(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou35(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou45(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd15(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm15(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm15("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm15("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd25(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm25(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm25("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm25("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai15(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym15(kantiym1);
                uiBean.setDispsyoubyoujyoutai25(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym25(kantiym2);

            }
            else if (i == 5) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno6(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd6(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd6(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh6(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu6(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou6(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd16(ketRiyuuCd1);
                uiBean.setDispketriyuucd26(ketRiyuuCd2);
                uiBean.setDispketriyuucd36(ketRiyuuCd3);
                uiBean.setDispketriyuucd46(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou16(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou26(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou36(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou46(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd16(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm16(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm16("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm16("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd26(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm26(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm26("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm26("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai16(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym16(kantiym1);
                uiBean.setDispsyoubyoujyoutai26(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym26(kantiym2);

            }
            else if (i == 6) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno7(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd7(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd7(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh7(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu7(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou7(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd17(ketRiyuuCd1);
                uiBean.setDispketriyuucd27(ketRiyuuCd2);
                uiBean.setDispketriyuucd37(ketRiyuuCd3);
                uiBean.setDispketriyuucd47(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou17(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou27(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou37(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou47(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd17(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm17(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm17("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm17("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd27(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm27(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm27("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm27("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai17(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym17(kantiym1);
                uiBean.setDispsyoubyoujyoutai27(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym27(kantiym2);
            }
            else if (i == 7) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno8(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd8(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd8(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh8(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu8(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou8(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd18(ketRiyuuCd1);
                uiBean.setDispketriyuucd28(ketRiyuuCd2);
                uiBean.setDispketriyuucd38(ketRiyuuCd3);
                uiBean.setDispketriyuucd48(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou18(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou28(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou38(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou48(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd18(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm18(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm18("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm18("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd28(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm28(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm28("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm28("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai18(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym18(kantiym1);
                uiBean.setDispsyoubyoujyoutai28(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym28(kantiym2);
            }
            else if (i == 8) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno9(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd9(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd9(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh9(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu9(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou9(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd19(ketRiyuuCd1);
                uiBean.setDispketriyuucd29(ketRiyuuCd2);
                uiBean.setDispketriyuucd39(ketRiyuuCd3);
                uiBean.setDispketriyuucd49(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou19(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou29(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou39(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou49(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd19(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm19(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm19("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm19("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd29(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm29(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm29("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm29("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai19(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym19(kantiym1);
                uiBean.setDispsyoubyoujyoutai29(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym29(kantiym2);

            }
            else if (i == 9) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno10(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd10(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd10(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh10(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu10(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou10(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd110(ketRiyuuCd1);
                uiBean.setDispketriyuucd210(ketRiyuuCd2);
                uiBean.setDispketriyuucd310(ketRiyuuCd3);
                uiBean.setDispketriyuucd410(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou110(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou210(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou310(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou410(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd110(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm110(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm110("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm110("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd210(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm210(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm210("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm210("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai110(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym110(kantiym1);
                uiBean.setDispsyoubyoujyoutai210(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym210(kantiym2);

            }
            else if (i == 10) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno11(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd11(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd11(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh11(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu11(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou11(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd111(ketRiyuuCd1);
                uiBean.setDispketriyuucd211(ketRiyuuCd2);
                uiBean.setDispketriyuucd311(ketRiyuuCd3);
                uiBean.setDispketriyuucd411(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou111(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou211(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou311(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou411(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd111(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm111(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm111("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm111("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd211(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm211(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm211("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm211("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai111(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym111(kantiym1);
                uiBean.setDispsyoubyoujyoutai211(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym211(kantiym2);

            }
            else if (i == 11) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno12(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd12(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd12(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh12(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu12(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou12(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd112(ketRiyuuCd1);
                uiBean.setDispketriyuucd212(ketRiyuuCd2);
                uiBean.setDispketriyuucd312(ketRiyuuCd3);
                uiBean.setDispketriyuucd412(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou112(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou212(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou312(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou412(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd112(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm112(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm112("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm112("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd212(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm212(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm212("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm212("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai112(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym112(kantiym1);
                uiBean.setDispsyoubyoujyoutai212(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym212(kantiym2);

            }
            else if (i == 12) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno13(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd13(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd13(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh13(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu13(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou13(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd113(ketRiyuuCd1);
                uiBean.setDispketriyuucd213(ketRiyuuCd2);
                uiBean.setDispketriyuucd313(ketRiyuuCd3);
                uiBean.setDispketriyuucd413(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou113(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou213(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou313(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou413(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd113(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm113(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm113("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm113("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd213(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm213(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm213("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm213("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai113(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym113(kantiym1);
                uiBean.setDispsyoubyoujyoutai213(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym213(kantiym2);

            }
            else if (i == 13) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno14(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd14(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd14(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh14(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu14(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou14(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd114(ketRiyuuCd1);
                uiBean.setDispketriyuucd214(ketRiyuuCd2);
                uiBean.setDispketriyuucd314(ketRiyuuCd3);
                uiBean.setDispketriyuucd414(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou114(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou214(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou314(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou414(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd114(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm114(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm114("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm114("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd214(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm214(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm214("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm214("");
                }

                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiym1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiym2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai114(syoubyoujyoutaikbn1);
                uiBean.setDispkantiym114(kantiym1);
                uiBean.setDispsyoubyoujyoutai214(syoubyoujyoutaikbn2);
                uiBean.setDispkantiym214(kantiym2);

            }
            else if (i == 14) {
                HT_DakuhiKettei dakuhiKettei = pDakuhiKetteiLst.get(i);

                uiBean.setDisprenno15(dakuhiKettei.getDakuhiktrenno());
                uiBean.setDispketymd15(dakuhiKettei.getKetymd());
                uiBean.setDispketkekkacd15(dakuhiKettei.getKetkekkacd());
                uiBean.setDispsntksakuseiyh15(dakuhiKettei.getSntkinfosakuseiyhkbn());
                uiBean.setDisptorikesisyousairiyuu15(dakuhiKettei.getTorikesisyousairiyuucd());
                uiBean.setDispmrriyuucdnaiyou15(dakuhiKettei.getMrriyuucdkbn());

                C_Ketriyuucd ketRiyuuCdKbn1 = dakuhiKettei.getKetriyuucd1();
                C_Ketriyuucd ketRiyuuCdKbn2 = dakuhiKettei.getKetriyuucd2();
                C_Ketriyuucd ketRiyuuCdKbn3 = dakuhiKettei.getKetriyuucd3();
                C_Ketriyuucd ketRiyuuCdKbn4 = dakuhiKettei.getKetriyuucd4();
                String ketRiyuuCd1 = "";
                String ketRiyuuCd2 = "";
                String ketRiyuuCd3 = "";
                String ketRiyuuCd4 = "";
                String ketRiyuu1 = "";
                String ketRiyuu2 = "";
                String ketRiyuu3 = "";
                String ketRiyuu4 = "";

                if (ketRiyuuCdKbn1 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn1)) {
                    ketRiyuu1 = ketRiyuuCdKbn1.getContent();
                    ketRiyuuCd1 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn1.getValue());
                }

                if (ketRiyuuCdKbn2 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn2)) {
                    ketRiyuu2 = ketRiyuuCdKbn2.getContent();
                    ketRiyuuCd2 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn2.getValue());
                }

                if (ketRiyuuCdKbn3 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn3)) {
                    ketRiyuu3 = ketRiyuuCdKbn3.getContent();
                    ketRiyuuCd3 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn3.getValue());
                }

                if (ketRiyuuCdKbn4 != null && !C_Ketriyuucd.BLNK.eq(ketRiyuuCdKbn4)) {
                    ketRiyuu4 = ketRiyuuCdKbn4.getContent();
                    ketRiyuuCd4 = ConvertUtil.toZenNumeric(ketRiyuuCdKbn4.getValue());
                }

                uiBean.setDispketriyuucd115(ketRiyuuCd1);
                uiBean.setDispketriyuucd215(ketRiyuuCd2);
                uiBean.setDispketriyuucd315(ketRiyuuCd3);
                uiBean.setDispketriyuucd415(ketRiyuuCd4);
                uiBean.setDispketteiriyuunaiyou115(ketRiyuu1);
                uiBean.setDispketteiriyuunaiyou215(ketRiyuu2);
                uiBean.setDispketteiriyuunaiyou315(ketRiyuu3);
                uiBean.setDispketteiriyuunaiyou415(ketRiyuu4);

                syoubyouCd1 = dakuhiKettei.getSyoubyoucd1();
                uiBean.setDispsyoubyoucd115(syoubyouCd1);
                if (!BizUtil.isBlank(syoubyouCd1)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd1);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm115(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm115("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm115("");
                }

                syoubyouCd2 = dakuhiKettei.getSyoubyoucd2();
                uiBean.setDispsyoubyoucd215(syoubyouCd2);
                if (!BizUtil.isBlank(syoubyouCd2)) {
                    BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(syoubyouCd2);
                    if (syoubyou != null) {
                        uiBean.setDispsyoubyounm215(syoubyou.getSyoubyounm());
                    }
                    else {
                        uiBean.setDispsyoubyounm215("");
                    }
                    syoubyou = null;
                }
                else {
                    uiBean.setDispsyoubyounm215("");
                }

                C_SyoubyoujyoutaiKbn syoubyouJyoutaikbn1 = dakuhiKettei.getSyoubyoujyoutaikbn1();
                BizDateYM kantiYm1 = dakuhiKettei.getKantiym1();
                C_SyoubyoujyoutaiKbn syoubyouJyoutaikbn2 = dakuhiKettei.getSyoubyoujyoutaikbn2();
                BizDateYM kantiYm2 = dakuhiKettei.getKantiym2();

                uiBean.setDispsyoubyoujyoutai115(syoubyouJyoutaikbn1);
                uiBean.setDispkantiym115(kantiYm1);
                uiBean.setDispsyoubyoujyoutai215(syoubyouJyoutaikbn2);
                uiBean.setDispkantiym215(kantiYm2);
            }
        }
    }

    private void setPropertyFromTSkDenpyoData(String pMosno, BizDate pRyosyuymd) {

        if (pRyosyuymd != null) {

            HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoRyosyuymdZenhnknkbn(pMosno, pRyosyuymd);

            HT_SkDenpyoData skDenpyoData = null;
            if (nyuukin != null) {
                skDenpyoData = sinkeiyakuDomManager.getSkDenpyoData(nyuukin.getDenrenno(), nyuukin.getEdano());
            }

            if (skDenpyoData != null) {
                uiBean.setDenkawaserate(zeroToOptional(skDenpyoData.getDenkawaserate()));
            }
        }
    }

    private void setPropertyFromTNyuukin(List<HT_Nyuukin> pNyuukinLst) {

        List<NyuukinInfoDataSourceBean> nyuukinInfoDataSourceBeanLst = new ArrayList<NyuukinInfoDataSourceBean>();

        if (pNyuukinLst != null && pNyuukinLst.size() > 0) {
            for (HT_Nyuukin nyuukin : pNyuukinLst) {
                NyuukinInfoDataSourceBean nyuukinInfoDataSourceBean = new NyuukinInfoDataSourceBean();

                BizCurrency rsDengkYen = BizCurrency.optional();
                C_Tuukasyu rsTuukaSyu = nyuukin.getRstuukasyu();

                if (!C_Tuukasyu.JPY.eq(rsTuukaSyu)) {
                    HT_SkDenpyoData skDenpyoData =
                        sinkeiyakuDomManager.getSkDenpyoData(nyuukin.getDenrenno(), nyuukin.getEdano());

                    rsDengkYen = skDenpyoData.getDenyenkagk();
                }

                nyuukinInfoDataSourceBean.setDispsoukincd(nyuukin.getSoukincd());
                nyuukinInfoDataSourceBean.setDispSoukinYmd(nyuukin.getSoukinymd());
                nyuukinInfoDataSourceBean.setDisptyakkinymd(nyuukin.getTyakkinymd());
                nyuukinInfoDataSourceBean.setDisprskingaku(nyuukin.getRsgaku());
                nyuukinInfoDataSourceBean.setDisprsdengkyen(rsDengkYen);
                nyuukinInfoDataSourceBean.setDispryosyuymd(nyuukin.getRyosyuymd());
                nyuukinInfoDataSourceBean.setDispnyknsyubetu(nyuukin.getNyknsyubetu());
                nyuukinInfoDataSourceBean.setDispRssyouNo(nyuukin.getRssyouno());
                nyuukinInfoDataSourceBean.setRsgakuTuukasyu(rsTuukaSyu);

                nyuukinInfoDataSourceBeanLst.add(nyuukinInfoDataSourceBean);
            }
        }
        else {
            NyuukinInfoDataSourceBean nyuukinInfoDataSourceBean = new NyuukinInfoDataSourceBean();

            nyuukinInfoDataSourceBean.setDisprskingaku(BizCurrency.optional());
            nyuukinInfoDataSourceBean.setDisprsdengkyen(BizCurrency.optional());

            nyuukinInfoDataSourceBeanLst.add(nyuukinInfoDataSourceBean);
        }

        uiBean.setNyuukinInfo(nyuukinInfoDataSourceBeanLst);
    }

    private void setPropertyFromTHenkinForPKakin(List<HT_Henkin> pHenkinLst) {

        List<PkakinInfoDataSourceBean> pkakinInfoDataSourceBeanLst = new ArrayList<PkakinInfoDataSourceBean>();
        int lineCout = 0;

        if (pHenkinLst != null && pHenkinLst.size() > 0) {

            for (HT_Henkin henkin : pHenkinLst) {

                if (henkin.getHnknymd() != null) {
                    continue;
                }

                PkakinInfoDataSourceBean pkakinInfoDataSourceBean =
                    SWAKInjector.getInstance(PkakinInfoDataSourceBean.class);

                BizCurrency pkakinDengkYen = BizCurrency.optional();
                C_Tuukasyu pkakinTuukaSyu = henkin.getHnkntuukasyu();

                if (!C_Tuukasyu.JPY.eq(pkakinTuukaSyu)) {

                    HT_SkDenpyoData skDenpyoData = sinkeiyakuDomManager.getSkDenpyoData(
                        henkin.getPkakindenrenno(), henkin.getPkakindenedano());

                    pkakinDengkYen = skDenpyoData.getDenyenkagk();
                }

                pkakinInfoDataSourceBean.setDisppkakingk(henkin.getHnkngk());
                pkakinInfoDataSourceBean.setDisppkakindengkyen(pkakinDengkYen);
                pkakinInfoDataSourceBean.setDisppkakinsyoriymd(henkin.getPkakinsyoriymd());
                pkakinInfoDataSourceBean.setDisppkakinhnknriyuu(henkin.getHnknriyuukbn());
                pkakinInfoDataSourceBean.setPkakinTuukasyu(pkakinTuukaSyu);

                pkakinInfoDataSourceBeanLst.add(pkakinInfoDataSourceBean);

                lineCout++;
            }
        }

        if (lineCout == 0) {
            PkakinInfoDataSourceBean pkakinInfoDataSourceBean =
                SWAKInjector.getInstance(PkakinInfoDataSourceBean.class);

            pkakinInfoDataSourceBean.setDisppkakingk(BizCurrency.optional());
            pkakinInfoDataSourceBean.setDisppkakindengkyen(BizCurrency.optional());

            pkakinInfoDataSourceBeanLst.add(pkakinInfoDataSourceBean);
        }

        uiBean.setPkakinInfo(pkakinInfoDataSourceBeanLst);
    }

    private void setPropertyFromTHenkin(List<HT_Henkin> pHenkinLst) {

        List<HenkinInfoDataSourceBean> henkinInfoDataSourceBeanLst = new ArrayList<HenkinInfoDataSourceBean>();
        int lineCout = 0;

        if (pHenkinLst != null && pHenkinLst.size() > 0) {

            for (HT_Henkin henkin : pHenkinLst) {
                if (henkin.getHnknymd() == null) {
                    continue;
                }

                getBankSitenNm.exec(henkin.getBankcd(), henkin.getSitencd());

                HenkinInfoDataSourceBean henkinInfoDataSourceBean = new HenkinInfoDataSourceBean();

                BizCurrency hnknDengkYen = BizCurrency.optional();
                C_Tuukasyu hnknTuukaSyu = henkin.getHnkntuukasyu();

                if (!C_Tuukasyu.JPY.eq(hnknTuukaSyu)) {
                    HT_SkDenpyoData skDenpyoData = sinkeiyakuDomManager.getSkDenpyoData(
                        henkin.getDenrenno(), henkin.getEdano());

                    hnknDengkYen = skDenpyoData.getDenyenkagk();
                }

                henkinInfoDataSourceBean.setDisphnkngk(henkin.getHnkngk());
                henkinInfoDataSourceBean.setDisphnkndengkyen(hnknDengkYen);
                henkinInfoDataSourceBean.setDisphnknymd(henkin.getHnknymd());
                henkinInfoDataSourceBean.setDisphnknriyuu(henkin.getHnknriyuukbn());
                henkinInfoDataSourceBean.setDisphnknhoukbn(henkin.getHnknhoukbn());
                henkinInfoDataSourceBean.setDispbankcd(henkin.getBankcd());
                henkinInfoDataSourceBean.setDispbanknmkj(getBankSitenNm.getBankNmKj());
                henkinInfoDataSourceBean.setDispsitennmkj(getBankSitenNm.getSitenNmKj());
                henkinInfoDataSourceBean.setDispsitencd(henkin.getSitencd());
                henkinInfoDataSourceBean.setDispyokinkbn(henkin.getYokinkbn());
                henkinInfoDataSourceBean.setDispkouzano(henkin.getKouzano());
                henkinInfoDataSourceBean.setDispkzmeiginmkn(henkin.getKzmeiginmkn());
                henkinInfoDataSourceBean.setHnkngkTuukasyu(hnknTuukaSyu);

                henkinInfoDataSourceBeanLst.add(henkinInfoDataSourceBean);

                lineCout++;
            }
        }

        if (lineCout == 0) {
            HenkinInfoDataSourceBean henkinInfoDataSourceBean = new HenkinInfoDataSourceBean();

            henkinInfoDataSourceBean.setDisphnkngk(BizCurrency.optional());
            henkinInfoDataSourceBean.setDisphnkndengkyen(BizCurrency.optional());

            henkinInfoDataSourceBeanLst.add(henkinInfoDataSourceBean);
        }

        uiBean.setHenkinInfo(henkinInfoDataSourceBeanLst);
    }

    private void searchData() {

        String              tratkiagcd      = null;
        String              oyadrtencd      = null;
        String              daiMosno        = null;
        BizDateYM           bosyuuYm        = null;
        C_KetteiKbn         ketteiKbn       = null;
        C_SeirituKbn        seirituKbn      = null;
        boolean             kthhbFlg;
        C_UmuKbn            kthhbKbn        = null;
        BizDate             mosFromYmd      = null;
        BizDate             mosToYmd        = null;
        C_BlnktkumuKbn      nyknUmu         = null;
        String              kinyuuCd        = null;
        boolean             srhhbUmuFlg;
        boolean             mkshbUmuFlg;
        C_HknsyuruiNo       hknSyuruiNo     = null;
        String              kyknmkn         = null;
        BizDate             kykseiymd       = null;
        daiMosno = uiBean.getSrchDaimosno();
        bosyuuYm = uiBean.getSrchBosyuuym();
        ketteiKbn = uiBean.getSrchketteikbn();
        seirituKbn = uiBean.getSrchseiritukbn();
        kthhbFlg = uiBean.getSrchkthhbari();
        mosFromYmd = uiBean.getSrchmosfromymd();
        mosToYmd = uiBean.getSrchmostoymd();
        nyknUmu = uiBean.getSrchnyknumu();
        kinyuuCd = uiBean.getSrchkinyuucd();
        srhhbUmuFlg = uiBean.getSrchsrhhbari();
        mkshbUmuFlg = uiBean.getSrchmkshbari();
        kyknmkn = uiBean.getSrchkyknmkn();
        kykseiymd = uiBean.getSrchkykseiymd();

        if (kthhbFlg) {
            kthhbKbn = C_UmuKbn.ARI;
        }
        else {
            kthhbKbn = C_UmuKbn.NONE;
        }

        C_UmuKbn nyuukinUmu = null;
        if (C_BlnktkumuKbn.ARI.getValue().equals(nyknUmu.getValue())) {
            nyuukinUmu = C_UmuKbn.ARI;
        }
        else if (C_BlnktkumuKbn.NONE.getValue().equals(nyknUmu.getValue())) {
            nyuukinUmu = C_UmuKbn.NONE;
        }

        if (!C_HknsyuruiNo.BLNK.eq(uiBean.getHknsyuruino())) {
            hknSyuruiNo = uiBean.getHknsyuruino();
        }

        if (!BizUtil.isBlank(kinyuuCd)) {
            List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByKinyuucd(kinyuuCd);

            if (dairitenLst.size() == 0) {
                throw new BizLogicException(MessageId.EBA0090);
            }

            oyadrtencd = dairitenLst.get(0).getOyadrtencd();
        }

        if (!BizUtil.isBlank(uiBean.getDrtencd())) {
            if (C_DrtnCdKensakuKbn.OYADRTEN.eq(uiBean.getDrtncdkensakukbn())) {
                BM_Dairiten dairiten = bizDomManager.getDairiten(uiBean.getDrtencd());

                if (dairiten == null) {
                    throw new BizLogicException(MessageId.EBA0090);
                }

                oyadrtencd = dairiten.getOyadrtencd();
            }
            else if (C_DrtnCdKensakuKbn.TRATKIDRTEN.eq(uiBean.getDrtncdkensakukbn())) {
                tratkiagcd = uiBean.getDrtencd();
            }
        }

        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfoBeanLst =
            sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
                mosFromYmd,
                mosToYmd,
                daiMosno,
                bosyuuYm,
                nyuukinUmu,
                ketteiKbn,
                seirituKbn,
                kthhbKbn,
                hknSyuruiNo,
                tratkiagcd,
                oyadrtencd,
                srhhbUmuFlg,
                mkshbUmuFlg,
                kyknmkn,
                kykseiymd);

        if (syoukaiIchiranInfoBeanLst.size() == 0) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        else if (syoukaiIchiranInfoBeanLst.size() > DATA_LIMIT_COUNT) {
            throw new BizLogicException(MessageId.IBA0019, String.valueOf(DATA_LIMIT_COUNT));
        }

        uiBean.setKensakuKekkaLst(syoukaiIchiranInfoBeanLst);

        setListData();
    }

    private void getSTTtdkTyuuiInfo(
        String pMosno,
        C_SkeittdkrenrakuKbn pSkeiTtdkRenrakuKbn,
        ArrayList<String> pNaiyos,
        ArrayList<BizDate> pTrkymds,
        ArrayList<String> pTantous) {

        List<HT_SkTtdkTyuui> skTtdkTyuuiLst = getSkTtdkTyuui.getTtdkTyuui(pMosno, pSkeiTtdkRenrakuKbn);

        if (skTtdkTyuuiLst != null) {
            EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
            editSecurityKm.init(pMosno);

            for( HT_SkTtdkTyuui skTtdkTyuui : skTtdkTyuuiLst) {
                AM_User user = skTtdkTyuui.getUser();

                String userNm = "";

                if (user != null) {
                    userNm = user.getUserNm();
                }
                pNaiyos.add(editSecurityKm.decode(skTtdkTyuui.getSkeittdktyuuinaiyou()));
                pTrkymds.add(skTtdkTyuui.getTrkymd());
                pTantous.add(userNm);
            }
        }
    }

    private void setPropertyFromTSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        uiBean.setMosnrkumu(pSyoriCTL.getMosnrkumu());

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKktnrkumu())) {
            uiBean.setKkthjykbn(C_KkthjyKbn.KKTNRK_ARI);
        }
        else {
            uiBean.setKkthjykbn(C_KkthjyKbn.NONE);
        }

        uiBean.setNyknnrkumu(pSyoriCTL.getNyknnrkumu());

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKthhbkbn())) {
            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getSrhhbkbn())) {
            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getKhnhbkbn())) {
            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else {
            uiBean.setHubiumu(C_UmuKbn.NONE);
        }

        uiBean.setKetteikbn(pSyoriCTL.getKetteikbn());
        uiBean.setSeiritukbn(pSyoriCTL.getSeiritukbn());

        C_SeirituKbn seirituKbn = pSyoriCTL.getSeiritukbn();

        if (C_SeirituKbn.SEIRITU.eq(seirituKbn) || C_SeirituKbn.HUSEIRITU.eq(seirituKbn)) {
            uiBean.setSrsyoriymd(pSyoriCTL.getSrsyoriymd());
        }

        uiBean.setSateijtkbn(pSyoriCTL.getSateijtkbn());

        C_SateijtKbn sateijtKbn = pSyoriCTL.getSateijtkbn();

        if (C_SateijtKbn.SATEI_SUMI.eq(sateijtKbn)) {
            uiBean.setSateizumiymd(pSyoriCTL.getSateizumiymd());
        }

        uiBean.setKykkakjkkbn(pSyoriCTL.getKykkakjkkbn());
        uiBean.setLincjkkbn(pSyoriCTL.getLincjkkbn());
        uiBean.setLinckknnjkkbn(pSyoriCTL.getLinckknnjkkbn());
        uiBean.setKnkysateijyoukbn(pSyoriCTL.getKnkysateijyoukbn());
        uiBean.setImusateijyoukbn(pSyoriCTL.getImusateijyoukbn());
        uiBean.setJimusrhkbn(pSyoriCTL.getJimusrhkbn());
        uiBean.setLincgthtkekkbn(pSyoriCTL.getLincgthtkekkbn());
        uiBean.setKnkysatei1jiyhkbn(pSyoriCTL.getKnkysatei1jiyhkbn());
        uiBean.setKnkysatei2jiyhkbn(pSyoriCTL.getKnkysatei2jiyhkbn());
        uiBean.setImusateikaniyhkbn(pSyoriCTL.getImusateikaniyhkbn());
        uiBean.setDaimosno(pSyoriCTL.getDaimosno());
        uiBean.setMosnrkvrfjkkbn(pSyoriCTL.getMosnrkvrfjkkbn());
        uiBean.setMosuketukekbn(pSyoriCTL.getMosuketukekbn());
        uiBean.setMostenkenjoukbn(pSyoriCTL.getMostenkenjoukbn());
        uiBean.setMostenken1jiyhkbn(pSyoriCTL.getMostenken1jiyhkbn());
        uiBean.setMostenken2jiyhkbn(pSyoriCTL.getMostenken2jiyhkbn());
        uiBean.setKktnrkvrfjkkbn(pSyoriCTL.getKktnrkvrfjkkbn());
        uiBean.setSyono(pSyoriCTL.getSyono());

        uiBean.setKouseiinkykkbn(pSyoriCTL.getKouseiinkykkbn());
        uiBean.setKoukankykkbn(pSyoriCTL.getKoukankykkbn());
        uiBean.setTkhjnkbn(pSyoriCTL.getTkhjnkbn());

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getNyknnrkumu())) {

            uiBean.setRyosyuymd(pSyoriCTL.getRyosyuymd());
        }

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getMosnrkumu())) {
            uiBean.setFatcakakkekkakbn(pSyoriCTL.getFatcakakkekkakbn());
            uiBean.setAeoikekkakbn(pSyoriCTL.getAeoikekkakbn());
        }

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getTkhsyouryakuumukbn())) {
            uiBean.setTkhsyouryakuumukbn(pSyoriCTL.getTkhsyouryakuumukbn());
        }
        else {
            uiBean.setTkhsyouryakuumukbn(null);
        }

        if (C_SeirituKbn.SEIRITU.eq(pSyoriCTL.getSeiritukbn())) {
            SetSyokenhakkouymd setSyokenhakkouymd = SWAKInjector.getInstance(SetSyokenhakkouymd.class);
            uiBean.setSyohakkouymd(setSyokenhakkouymd.exec(pSyoriCTL.getSrsyoriymd()));
        }

        uiBean.setAuthorikakymd(pSyoriCTL.getAuthorikakymd());

    }

    private void kouteijkListSearch() {

        checkMosno();

        clearParamKouteijkList();
        BizPropertyInitializer.initialize(uiBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> summaryOutBeanLst = Lists.newArrayList();

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        summaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (summaryOutBeanLst.size() == 0) {
            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());
            bzGetProcessSummaryInBean.setSyoNo(uiBean.getSyono());

            summaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        }

        if (summaryOutBeanLst.size() > 0 ) {
            BzGetProcessRecordBean getProcessRecordBean = null;

            BzGetProcessRecordInputBean getProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);

            BzGetProcessRecord getProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);

            getProcessRecordInputBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            getProcessRecordInputBean.setKouteiKanriId(summaryOutBeanLst.get(0).getKouteiKanriId());
            getProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.GYOUMU);

            BzGetProcessRecordOutputBean getProcessRecordOutputBean = getProcessRecord.exec(getProcessRecordInputBean);

            List<BzGetProcessRecordBean> getProcessRecordBeanLst = getProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst();

            if (getProcessRecordBeanLst.size() != 0) {

                List<KouteiJyoukyouBaseInfoDataSourceBean> kouteiJyoukyouInfoLst =
                    new ArrayList<KouteiJyoukyouBaseInfoDataSourceBean>();

                for (int i = 0; i < getProcessRecordBeanLst.size(); i++) {

                    KouteiJyoukyouBaseInfoDataSourceBean kouteiJyoukyouBaseInfo = SWAKInjector.getInstance(
                        KouteiJyoukyouBaseInfoDataSourceBean.class);

                    getProcessRecordBean = getProcessRecordBeanLst.get(i);

                    AM_User user = baseDomManager.getUser(getProcessRecordBean.getUserId());

                    kouteiJyoukyouBaseInfo.setSyoriTime(
                        DefaultDateFormatter.formatYMDHMSZeroFill(getProcessRecordBean.getSyoriTime()));
                    kouteiJyoukyouBaseInfo.setVprghsdisptasknm(getProcessRecordBean.getTasknm());
                    kouteiJyoukyouBaseInfo.setVprghsdispsyorikekkakbn(getProcessRecordBean.getSyorikekkaKbn());

                    if (user != null) {
                        kouteiJyoukyouBaseInfo.setVprghsdispsousasyanm(user.getUserNm());
                    }
                    else {
                        kouteiJyoukyouBaseInfo.setVprghsdispsousasyanm("");
                    }

                    kouteiJyoukyouBaseInfo.setVprghsdispcomment(getProcessRecordBean.getRirekiMessage());

                    kouteiJyoukyouInfoLst.add(kouteiJyoukyouBaseInfo);
                }

                uiBean.setKouteiJyoukyouBaseInfo(kouteiJyoukyouInfoLst);
            }
        }
    }

    private void syoruiToutyakuJkSearch() {

        checkMosno();

        clearParamSyoruiToutyakuJK();
        BizPropertyInitializer.initialize(uiBean);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.size() == 0) {

            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());
            bzGetProcessSummaryInBean.setSyoNo(uiBean.getSyono());

            bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        }

        if (bzGetProcessSummaryOutBeanLst.size() > 0) {

            uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());


            SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
            setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);
        }
    }

    private void sakuinInfoSearch() {

        checkMosno();

        if (uiBean.getSknInfoKensakuFlag()) {
            if (C_UmuKbn.ARI.eq(uiBean.getMqErrMsgUmu())) {
                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WIA1004);
            }
            else if (C_UmuKbn.ARI.eq(uiBean.getPalAteSyoukaiErrMsgUmu())) {
                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WIA1005);
            }
            else if (C_UmuKbn.ARI.eq(uiBean.getSknInfoSyoukaiErrMsgUmu())) {
                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WIA1006);
            }
            else if (C_UmuKbn.ARI.eq(uiBean.getKeikokuMsgUmu())) {
                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WHA1001);
            }

            return;
        }

        clearParamSakuinInfo();
        BizPropertyInitializer.initialize(uiBean);

        String mosNo = uiBean.getMosno();
        C_KykKbn kykKbn = null;
        List<KykSakuinInfoDataSourceBean> kyksyaSkuinInfoLst = new ArrayList<KykSakuinInfoDataSourceBean>();
        List<HhknSakuinInfoDataSourceBean> hhknSakuinInfoLst = new ArrayList<HhknSakuinInfoDataSourceBean>();
        C_BlnktkumuKbn kykMfKsTkUmuKyksya = C_BlnktkumuKbn.BLNK;
        C_BlnktkumuKbn mosFKsTkUmuKyksya = C_BlnktkumuKbn.BLNK;
        C_BlnktkumuKbn khKsTkUmuKyksya = C_BlnktkumuKbn.BLNK;
        C_BlnktkumuKbn skKsTkUmuKyksya = C_BlnktkumuKbn.BLNK;
        C_BlnktkumuKbn kykMfKsTkUmuHhknsya = C_BlnktkumuKbn.BLNK;
        C_BlnktkumuKbn mosFKsTkUmuHhknsya = C_BlnktkumuKbn.BLNK;
        C_BlnktkumuKbn khKsTkUmuHhknsya = C_BlnktkumuKbn.BLNK;
        C_BlnktkumuKbn skKsTkUmuHhknsya = C_BlnktkumuKbn.BLNK;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        HT_MosKihon mosKihon = null;

        if (syoriCTL != null) {
            mosKihon = syoriCTL.getMosKihon();
        }
        else {
            return;
        }

        if (mosKihon != null) {

            kykKbn = mosKihon.getKykkbn();

            uiBean.setKykkbn(kykKbn);

            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                uiBean.setVkykskyknmkn(mosKihon.getKyknmkn());
                uiBean.setVkykskykseiymd(mosKihon.getKykseiymd());
            }
            else {

                uiBean.setVkykskyknmkn(mosKihon.getHhknnmkn());
                uiBean.setVkykskykseiymd(mosKihon.getHhknseiymd());
            }

        }
        else {
            return;
        }

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSykYokenBean = setSakuinInfoSyoukaiInBean(mosNo, C_SakuintsnTaisyouKbn.KYK);

        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSykKekkaBean = bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSykYokenBean);

        uiBean.setSknInfoKensakuFlag(true);

        if (!C_MQSyorikekkaKbn.ERROR.eq(bzSakuinTsnSykKekkaBean.getMqsyorikekkakbn())) {

            kykMfKsTkUmuKyksya = bzSakuinTsnSykKekkaBean.getKykmfkensuutyoukaumu();
            mosFKsTkUmuKyksya = bzSakuinTsnSykKekkaBean.getMosfkensuutyoukaumu();
            khKsTkUmuKyksya = bzSakuinTsnSykKekkaBean.getKhkensuutyoukaumu();
            skKsTkUmuKyksya = bzSakuinTsnSykKekkaBean.getSkkensuutyoukaumu();

            List<KykSakuinInfoDataSourceBean> kykMFSkuinLst = new ArrayList<KykSakuinInfoDataSourceBean>();
            List<KykSakuinInfoDataSourceBean> mskmFSkuinLst = new ArrayList<KykSakuinInfoDataSourceBean>();
            List<KykSakuinInfoDataSourceBean> kykhozenSkuinLst = new ArrayList<KykSakuinInfoDataSourceBean>();
            List<KykSakuinInfoDataSourceBean> sinkeyakuSkuinLst = new ArrayList<KykSakuinInfoDataSourceBean>();

            kykMFSkuinLst = setKykSakuinInfoBeanForKykMF(bzSakuinTsnSykKekkaBean);
            mskmFSkuinLst = setKykSakuinInfoBeanForMosF(bzSakuinTsnSykKekkaBean);
            kykhozenSkuinLst = setKykSakuinInfoBeanForKykHozen(bzSakuinTsnSykKekkaBean);
            sinkeyakuSkuinLst = setKykSakuinInfoBeanForSkei(bzSakuinTsnSykKekkaBean);

            kyksyaSkuinInfoLst.addAll(kykMFSkuinLst);
            kyksyaSkuinInfoLst.addAll(mskmFSkuinLst);
            kyksyaSkuinInfoLst.addAll(kykhozenSkuinLst);
            kyksyaSkuinInfoLst.addAll(sinkeyakuSkuinLst);
        }

        if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {
            uiBean.setVhhkshhknnmkn(mosKihon.getHhknnmkn());
            uiBean.setVhhkshhknseiymd(mosKihon.getHhknseiymd());

            bzSakuinTsnSykYokenBean = setSakuinInfoSyoukaiInBean(mosNo, C_SakuintsnTaisyouKbn.HHKN);
            bzSakuinTsnSykKekkaBean = bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSykYokenBean);

            if (!C_MQSyorikekkaKbn.ERROR.eq(bzSakuinTsnSykKekkaBean.getMqsyorikekkakbn())) {

                kykMfKsTkUmuHhknsya = bzSakuinTsnSykKekkaBean.getKykmfkensuutyoukaumu();
                mosFKsTkUmuHhknsya = bzSakuinTsnSykKekkaBean.getMosfkensuutyoukaumu();
                khKsTkUmuHhknsya = bzSakuinTsnSykKekkaBean.getKhkensuutyoukaumu();
                skKsTkUmuHhknsya = bzSakuinTsnSykKekkaBean.getSkkensuutyoukaumu();

                List<HhknSakuinInfoDataSourceBean> kykMFSkuinLst = new ArrayList<HhknSakuinInfoDataSourceBean>();
                List<HhknSakuinInfoDataSourceBean> mskmFSkuinLst = new ArrayList<HhknSakuinInfoDataSourceBean>();
                List<HhknSakuinInfoDataSourceBean> kykhozenSkuinLst = new ArrayList<HhknSakuinInfoDataSourceBean>();
                List<HhknSakuinInfoDataSourceBean> sinkeyakuSkuinLst = new ArrayList<HhknSakuinInfoDataSourceBean>();

                kykMFSkuinLst = setHhknSakuinInfoBeanForKykMF(bzSakuinTsnSykKekkaBean);
                mskmFSkuinLst = setHhknSakuinInfoBeanForMosF(bzSakuinTsnSykKekkaBean);
                kykhozenSkuinLst = setHhknSakuinInfoBeanForKykHozen(bzSakuinTsnSykKekkaBean);
                sinkeyakuSkuinLst = setHhknSakuinInfoBeanForSkei(bzSakuinTsnSykKekkaBean);

                hhknSakuinInfoLst.addAll(kykMFSkuinLst);
                hhknSakuinInfoLst.addAll(mskmFSkuinLst);
                hhknSakuinInfoLst.addAll(kykhozenSkuinLst);
                hhknSakuinInfoLst.addAll(sinkeyakuSkuinLst);
            }
        }

        List<KykSakuinInfoDataSourceBean> sortedKykSaBeanLst = new ArrayList<KykSakuinInfoDataSourceBean>();
        if (kyksyaSkuinInfoLst.size() != 0) {

            Ordering<KykSakuinInfoDataSourceBean> ordering = Ordering.from(new KykSakuinInfoSortComparator());
            sortedKykSaBeanLst = ordering.sortedCopy(kyksyaSkuinInfoLst);
        }

        List<HhknSakuinInfoDataSourceBean> sortedhhknSaBeanLst = new ArrayList<HhknSakuinInfoDataSourceBean>();
        if (hhknSakuinInfoLst.size() != 0) {
            Ordering<HhknSakuinInfoDataSourceBean> ordering = Ordering.from(new HhknSakuinInfoSortComparator());
            sortedhhknSaBeanLst = ordering.sortedCopy(hhknSakuinInfoLst);
        }

        uiBean.setKykSakuinInfo(sortedKykSaBeanLst);
        uiBean.setHhknSakuinInfo(sortedhhknSaBeanLst);

        if (C_MQSyorikekkaKbn.ERROR.eq(bzSakuinTsnSykKekkaBean.getMqsyorikekkakbn())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WIA1004);

            uiBean.setMqErrMsgUmu(C_UmuKbn.ARI);
        }
        else if (C_PalSyoukaiJissiumuKbn.NONE.eq(bzSakuinTsnSykKekkaBean.getPalsyoukaijissiumukbn())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WIA1005);

            uiBean.setPalAteSyoukaiErrMsgUmu(C_UmuKbn.ARI);
        }
        else if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(bzSakuinTsnSykKekkaBean.getSakuininfosyoukaierrkbn())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WIA1006);

            uiBean.setSknInfoSyoukaiErrMsgUmu(C_UmuKbn.ARI);
        }

        else if (kykMfKsTkUmuKyksya.eq(C_BlnktkumuKbn.ARI) ||
            mosFKsTkUmuKyksya.eq(C_BlnktkumuKbn.ARI) ||
            khKsTkUmuKyksya.eq(C_BlnktkumuKbn.ARI) ||
            skKsTkUmuKyksya.eq(C_BlnktkumuKbn.ARI) ||
            kykMfKsTkUmuHhknsya.eq(C_BlnktkumuKbn.ARI) ||
            mosFKsTkUmuHhknsya.eq(C_BlnktkumuKbn.ARI) ||
            khKsTkUmuHhknsya.eq(C_BlnktkumuKbn.ARI) ||
            skKsTkUmuHhknsya.eq(C_BlnktkumuKbn.ARI)) {

            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WHA1001);
            uiBean.setKeikokuMsgUmu(C_UmuKbn.ARI);
        }
    }

    private BzSakuinTsnSyoukaiYokenBean setSakuinInfoSyoukaiInBean(
        String pMosno, C_SakuintsnTaisyouKbn pSakuintsnTaisyouKbn) {

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean =
            SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);

        bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);
        bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        bzSakuinTsnSyoukaiYokenBean.setHuho2kykno(pMosno);
        bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(pSakuintsnTaisyouKbn);
        bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.YOU);
        bzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN);
        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno(pMosno);
        bzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(BizDate.getSysDate());
        bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.BLNK);
        bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
        bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);

        return bzSakuinTsnSyoukaiYokenBean;
    }

    private List<KykSakuinInfoDataSourceBean> setKykSakuinInfoBeanForKykMF(
        BzSakuinTsnSyoukaiKekkaBean pSakuinTsnSyoukaiKekkaBean) {

        List<KykSakuinInfoDataSourceBean> kyksyaSkuinInfoLst = new ArrayList<KykSakuinInfoDataSourceBean>();

        List<BzKeiyakuMfSakuinKekkaBean> bzSakuinTsnSyoukaiKekkaBeanLst =
            pSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist();

        if (bzSakuinTsnSyoukaiKekkaBeanLst == null || bzSakuinTsnSyoukaiKekkaBeanLst.size() == 0) {
            return kyksyaSkuinInfoLst;
        }

        for (BzKeiyakuMfSakuinKekkaBean keiyakuMfSakuinKekkaBean : bzSakuinTsnSyoukaiKekkaBeanLst) {

            C_KeihiKbn taisyou = null;
            KykSakuinInfoDataSourceBean kykSakuinInfoDataSourceBean =
                SWAKInjector.getInstance(KykSakuinInfoDataSourceBean.class);

            if (C_KankeisyaKbn.HHKN_KYKDOUITU.eq(keiyakuMfSakuinKekkaBean.getKykmfkykkankeisyakbn()) ||
                C_KankeisyaKbn.DAI2HHKN_KYKDOUITU.eq(keiyakuMfSakuinKekkaBean.getKykmfkykkankeisyakbn())) {
                taisyou = C_KeihiKbn.KEIHIDOUITU;
            }
            else if (C_KankeisyaKbn.KYK.eq(keiyakuMfSakuinKekkaBean.getKykmfkykkankeisyakbn())) {
                taisyou = C_KeihiKbn.KYK;
            }
            else {
                taisyou = C_KeihiKbn.HHKN;
            }

            kykSakuinInfoDataSourceBean.setDispkyksakuinsyono(keiyakuMfSakuinKekkaBean.getKykmfsyono());
            kykSakuinInfoDataSourceBean.setDispkyksakuinmosno("");
            kykSakuinInfoDataSourceBean.setDispkyksakuintaisyou(taisyou);
            kykSakuinInfoDataSourceBean.setDispkyksakuinkykymd(keiyakuMfSakuinKekkaBean.getKykmfkykymd());
            kykSakuinInfoDataSourceBean.setDispkyksakuinsyoumetuymd(keiyakuMfSakuinKekkaBean.getKykmfsyoumetuymd());
            kykSakuinInfoDataSourceBean.setDispkyksakuinhuseiritu(C_GaitouKbn.BLNK);
            kykSakuinInfoDataSourceBean.setDispkyksakuin(C_SysCdKbn.PAL);
            kykSakuinInfoDataSourceBean.setSeirituJyoukyo("");

            kyksyaSkuinInfoLst.add(kykSakuinInfoDataSourceBean);
        }

        return kyksyaSkuinInfoLst;
    }

    private List<KykSakuinInfoDataSourceBean> setKykSakuinInfoBeanForMosF(
        BzSakuinTsnSyoukaiKekkaBean pSakuinTsnSyoukaiKekkaBean) {

        List<KykSakuinInfoDataSourceBean> kyksyaSkuinInfolst = new ArrayList<KykSakuinInfoDataSourceBean>();

        List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst =
            pSakuinTsnSyoukaiKekkaBean.getBzmousikomifsakuinkekkabeanlist();

        if (bzMousikomiFSakuinKekkaBeanLst == null || bzMousikomiFSakuinKekkaBeanLst.size() == 0) {
            return kyksyaSkuinInfolst;
        }

        for (BzMousikomiFSakuinKekkaBean mousikomiFSakuinKekkaBean : bzMousikomiFSakuinKekkaBeanLst) {

            if (C_Mfrenflg.SUMI.eq(mousikomiFSakuinKekkaBean.getMosfmfrenflg())) {
                continue;
            }

            C_KeihiKbn taisyou = null;
            C_GaitouKbn huseiritu = null;
            KykSakuinInfoDataSourceBean kykSakuinInfoDataSourceBean =
                SWAKInjector.getInstance(KykSakuinInfoDataSourceBean.class);

            if (C_KankeisyaKbn.HHKN_KYKDOUITU.eq(mousikomiFSakuinKekkaBean.getMosfmoskankeisyakbn()) ||
                C_KankeisyaKbn.DAI2HHKN_KYKDOUITU.eq(mousikomiFSakuinKekkaBean.getMosfmoskankeisyakbn())) {
                taisyou = C_KeihiKbn.KEIHIDOUITU;
            }
            else if (C_KankeisyaKbn.KYK.eq(mousikomiFSakuinKekkaBean.getMosfmoskankeisyakbn())) {
                taisyou = C_KeihiKbn.KYK;
            }
            else {
                taisyou = C_KeihiKbn.HHKN;
            }

            huseiritu = isHuseirituForPAL(mousikomiFSakuinKekkaBean.getMosfmossyoumetukbn());

            kykSakuinInfoDataSourceBean.setDispkyksakuinsyono("");
            kykSakuinInfoDataSourceBean.setDispkyksakuinmosno(mousikomiFSakuinKekkaBean.getMosfmosno());
            kykSakuinInfoDataSourceBean.setDispkyksakuintaisyou(taisyou);
            kykSakuinInfoDataSourceBean.setDispkyksakuinkykymd(mousikomiFSakuinKekkaBean.getMosfkykymd());
            kykSakuinInfoDataSourceBean.setDispkyksakuinsyoumetuymd(null);
            kykSakuinInfoDataSourceBean.setDispkyksakuinhuseiritu(huseiritu);
            kykSakuinInfoDataSourceBean.setDispkyksakuin(C_SysCdKbn.PAL);
            kykSakuinInfoDataSourceBean.setSeirituJyoukyo(mousikomiFSakuinKekkaBean.getMosfmossyoumetukbn().getValue());

            kyksyaSkuinInfolst.add(kykSakuinInfoDataSourceBean);
        }

        return kyksyaSkuinInfolst;
    }

    private List<KykSakuinInfoDataSourceBean> setKykSakuinInfoBeanForKykHozen(
        BzSakuinTsnSyoukaiKekkaBean pSakuinTsnSyoukaiKekkaBean) {

        List<KykSakuinInfoDataSourceBean> kyksyaSkuinInfoLst = new ArrayList<KykSakuinInfoDataSourceBean>();

        List<BzKeiyakuHozenSakuinKekkaBean> bzKeiyakuHozenSakuinKekkaBeanLst =
            pSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist();

        if (bzKeiyakuHozenSakuinKekkaBeanLst == null || bzKeiyakuHozenSakuinKekkaBeanLst.size() == 0) {
            return kyksyaSkuinInfoLst;
        }

        for (BzKeiyakuHozenSakuinKekkaBean keiyakuHozenSakuinKekkaBean : bzKeiyakuHozenSakuinKekkaBeanLst) {

            C_KeihiKbn taisyou = null;
            KykSakuinInfoDataSourceBean kykSakuinInfoDataSourceBean = SWAKInjector.getInstance(KykSakuinInfoDataSourceBean.class);

            if (C_KankeisyaKbn.HHKN_KYKDOUITU.eq(keiyakuHozenSakuinKekkaBean.getKhkykkankeisyakbn())) {
                taisyou = C_KeihiKbn.KEIHIDOUITU;
            }
            else if (C_KankeisyaKbn.KYK.eq(keiyakuHozenSakuinKekkaBean.getKhkykkankeisyakbn())) {
                taisyou = C_KeihiKbn.KYK;
            }
            else {
                taisyou = C_KeihiKbn.HHKN;
            }

            kykSakuinInfoDataSourceBean.setDispkyksakuinsyono(keiyakuHozenSakuinKekkaBean.getKhsyono());
            kykSakuinInfoDataSourceBean.setDispkyksakuinmosno("");
            kykSakuinInfoDataSourceBean.setDispkyksakuintaisyou(taisyou);
            kykSakuinInfoDataSourceBean.setDispkyksakuinkykymd(keiyakuHozenSakuinKekkaBean.getKhkykymd());
            kykSakuinInfoDataSourceBean.setDispkyksakuinsyoumetuymd(keiyakuHozenSakuinKekkaBean.getKhsyoumetuymd());
            kykSakuinInfoDataSourceBean.setDispkyksakuinhuseiritu(C_GaitouKbn.BLNK);
            kykSakuinInfoDataSourceBean.setDispkyksakuin(C_SysCdKbn.RAY);
            kykSakuinInfoDataSourceBean.setSeirituJyoukyo("");

            kyksyaSkuinInfoLst.add(kykSakuinInfoDataSourceBean);
        }

        return kyksyaSkuinInfoLst;
    }

    private List<KykSakuinInfoDataSourceBean> setKykSakuinInfoBeanForSkei(
        BzSakuinTsnSyoukaiKekkaBean pSakuinTsnSyoukaiKekkaBean) {

        List<KykSakuinInfoDataSourceBean> kyksyaSkuinInfoLst = new ArrayList<KykSakuinInfoDataSourceBean>();

        List<BzSinkeiyakuSakuinKekkaBean> bzSkeiSakuinKekkaBeanLst =
            pSakuinTsnSyoukaiKekkaBean.getBzsinkeiyakusakuinkekkabeanlist();

        if (bzSkeiSakuinKekkaBeanLst == null || bzSkeiSakuinKekkaBeanLst.size() == 0) {
            return kyksyaSkuinInfoLst;
        }

        for (BzSinkeiyakuSakuinKekkaBean sinkeiyakuSakuinKekkaBean : bzSkeiSakuinKekkaBeanLst) {

            if (C_Mfrenflg.SUMI.eq(sinkeiyakuSakuinKekkaBean.getSkmfrenflg())) {
                continue;
            }

            C_KeihiKbn taisyou = null;
            C_GaitouKbn huseiritu = null;
            KykSakuinInfoDataSourceBean kykSakuinInfoDataSourceBean =
                SWAKInjector.getInstance(KykSakuinInfoDataSourceBean.class);

            if (C_KankeisyaKbn.HHKN_KYKDOUITU.eq(sinkeiyakuSakuinKekkaBean.getSkmoskankeisyakbn())) {
                taisyou = C_KeihiKbn.KEIHIDOUITU;
            }
            else if (C_KankeisyaKbn.KYK.eq(sinkeiyakuSakuinKekkaBean.getSkmoskankeisyakbn())) {
                taisyou = C_KeihiKbn.KYK;
            }
            else {
                taisyou = C_KeihiKbn.HHKN;
            }

            huseiritu = isHuseirituForRAY(sinkeiyakuSakuinKekkaBean.getSkseiritukbn());

            kykSakuinInfoDataSourceBean.setDispkyksakuinsyono("");
            kykSakuinInfoDataSourceBean.setDispkyksakuinmosno(sinkeiyakuSakuinKekkaBean.getSkmosno());
            kykSakuinInfoDataSourceBean.setDispkyksakuintaisyou(taisyou);
            kykSakuinInfoDataSourceBean.setDispkyksakuinkykymd(sinkeiyakuSakuinKekkaBean.getSkkykymd());
            kykSakuinInfoDataSourceBean.setDispkyksakuinsyoumetuymd(null);
            kykSakuinInfoDataSourceBean.setDispkyksakuinhuseiritu(huseiritu);
            kykSakuinInfoDataSourceBean.setDispkyksakuin(C_SysCdKbn.RAY);
            kykSakuinInfoDataSourceBean.setSeirituJyoukyo(
                sinkeiyakuSakuinKekkaBean.getSkseiritukbn().getValue());

            kyksyaSkuinInfoLst.add(kykSakuinInfoDataSourceBean);
        }

        return kyksyaSkuinInfoLst;
    }

    private List<HhknSakuinInfoDataSourceBean> setHhknSakuinInfoBeanForKykMF(
        BzSakuinTsnSyoukaiKekkaBean pSakuinTsnSyoukaiKekkaBean) {

        List<HhknSakuinInfoDataSourceBean> hhknSakuinInfoLst = new ArrayList<HhknSakuinInfoDataSourceBean>();

        List<BzKeiyakuMfSakuinKekkaBean> bzSakuinTsnSyoukaiKekkaBeanLst =
            pSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist();

        if (bzSakuinTsnSyoukaiKekkaBeanLst == null || bzSakuinTsnSyoukaiKekkaBeanLst.size() == 0) {
            return hhknSakuinInfoLst;
        }

        for (BzKeiyakuMfSakuinKekkaBean keiyakuMfSakuinKekkaBean : bzSakuinTsnSyoukaiKekkaBeanLst) {

            C_KeihiKbn taisyou = null;
            HhknSakuinInfoDataSourceBean hhknSakuinInfoDataSourceBean =
                SWAKInjector.getInstance(HhknSakuinInfoDataSourceBean.class);

            if (C_KankeisyaKbn.HHKN_KYKDOUITU.eq(keiyakuMfSakuinKekkaBean.getKykmfkykkankeisyakbn()) ||
                C_KankeisyaKbn.DAI2HHKN_KYKDOUITU.eq(keiyakuMfSakuinKekkaBean.getKykmfkykkankeisyakbn())) {
                taisyou = C_KeihiKbn.KEIHIDOUITU;
            }
            else if (C_KankeisyaKbn.KYK.eq(keiyakuMfSakuinKekkaBean.getKykmfkykkankeisyakbn())) {
                taisyou = C_KeihiKbn.KYK;
            }
            else {
                taisyou = C_KeihiKbn.HHKN;
            }

            hhknSakuinInfoDataSourceBean.setDisphhknsakuinsyono(keiyakuMfSakuinKekkaBean.getKykmfsyono());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinmosno("");
            hhknSakuinInfoDataSourceBean.setDisphhknsakuintaisyou(taisyou);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinkykymd(keiyakuMfSakuinKekkaBean.getKykmfkykymd());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinsyoumetuymd(keiyakuMfSakuinKekkaBean.getKykmfsyoumetuymd());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinhuseiritu(C_GaitouKbn.BLNK);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuin(C_SysCdKbn.PAL);
            hhknSakuinInfoDataSourceBean.setSeirituJyoukyo("");

            hhknSakuinInfoLst.add(hhknSakuinInfoDataSourceBean);
        }

        return hhknSakuinInfoLst;
    }

    private List<HhknSakuinInfoDataSourceBean> setHhknSakuinInfoBeanForMosF(
        BzSakuinTsnSyoukaiKekkaBean pSakuinTsnSyoukaiKekkaBean) {

        List<HhknSakuinInfoDataSourceBean> hhknSakuinInfoLst = new ArrayList<HhknSakuinInfoDataSourceBean>();

        List<BzMousikomiFSakuinKekkaBean> bzMousikomiFSakuinKekkaBeanLst =
            pSakuinTsnSyoukaiKekkaBean.getBzmousikomifsakuinkekkabeanlist();

        if (bzMousikomiFSakuinKekkaBeanLst == null || bzMousikomiFSakuinKekkaBeanLst.size() == 0) {
            return hhknSakuinInfoLst;
        }

        for (BzMousikomiFSakuinKekkaBean mousikomiFSakuinKekkaBean : bzMousikomiFSakuinKekkaBeanLst) {

            if (C_Mfrenflg.SUMI.eq(mousikomiFSakuinKekkaBean.getMosfmfrenflg())) {
                continue;
            }

            C_KeihiKbn taisyou = null;
            C_GaitouKbn huseiritu = null;
            HhknSakuinInfoDataSourceBean hhknSakuinInfoDataSourceBean =
                SWAKInjector.getInstance(HhknSakuinInfoDataSourceBean.class);

            if (C_KankeisyaKbn.HHKN_KYKDOUITU.eq(mousikomiFSakuinKekkaBean.getMosfmoskankeisyakbn()) ||
                C_KankeisyaKbn.DAI2HHKN_KYKDOUITU.eq(mousikomiFSakuinKekkaBean.getMosfmoskankeisyakbn())) {
                taisyou = C_KeihiKbn.KEIHIDOUITU;
            }
            else if (C_KankeisyaKbn.KYK.eq(mousikomiFSakuinKekkaBean.getMosfmoskankeisyakbn())) {
                taisyou = C_KeihiKbn.KYK;
            }
            else {
                taisyou = C_KeihiKbn.HHKN;
            }

            huseiritu = isHuseirituForPAL(mousikomiFSakuinKekkaBean.getMosfmossyoumetukbn());

            hhknSakuinInfoDataSourceBean.setDisphhknsakuinsyono("");
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinmosno(mousikomiFSakuinKekkaBean.getMosfmosno());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuintaisyou(taisyou);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinkykymd(mousikomiFSakuinKekkaBean.getMosfkykymd());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinsyoumetuymd(null);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinhuseiritu(huseiritu);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuin(C_SysCdKbn.PAL);
            hhknSakuinInfoDataSourceBean.setSeirituJyoukyo(mousikomiFSakuinKekkaBean.getMosfmossyoumetukbn().getValue());

            hhknSakuinInfoLst.add(hhknSakuinInfoDataSourceBean);
        }

        return hhknSakuinInfoLst;
    }

    private List<HhknSakuinInfoDataSourceBean> setHhknSakuinInfoBeanForKykHozen(
        BzSakuinTsnSyoukaiKekkaBean pSakuinTsnSyoukaiKekkaBean) {

        List<HhknSakuinInfoDataSourceBean> hhknSakuinInfoLst = new ArrayList<HhknSakuinInfoDataSourceBean>();

        List<BzKeiyakuHozenSakuinKekkaBean> bzKeiyakuHozenSakuinKekkaBeanLst =
            pSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist();

        if (bzKeiyakuHozenSakuinKekkaBeanLst == null || bzKeiyakuHozenSakuinKekkaBeanLst.size() == 0) {
            return hhknSakuinInfoLst;
        }

        for (BzKeiyakuHozenSakuinKekkaBean keiyakuHozenSakuinKekkaBean : bzKeiyakuHozenSakuinKekkaBeanLst) {

            C_KeihiKbn taisyou = null;
            HhknSakuinInfoDataSourceBean hhknSakuinInfoDataSourceBean =
                SWAKInjector.getInstance(HhknSakuinInfoDataSourceBean.class);

            if (C_KankeisyaKbn.HHKN_KYKDOUITU.eq(keiyakuHozenSakuinKekkaBean.getKhkykkankeisyakbn())) {
                taisyou = C_KeihiKbn.KEIHIDOUITU;
            }
            else if (C_KankeisyaKbn.KYK.eq(keiyakuHozenSakuinKekkaBean.getKhkykkankeisyakbn())) {
                taisyou = C_KeihiKbn.KYK;
            }
            else {
                taisyou = C_KeihiKbn.HHKN;
            }

            hhknSakuinInfoDataSourceBean.setDisphhknsakuinsyono(keiyakuHozenSakuinKekkaBean.getKhsyono());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinmosno("");
            hhknSakuinInfoDataSourceBean.setDisphhknsakuintaisyou(taisyou);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinkykymd(keiyakuHozenSakuinKekkaBean.getKhkykymd());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinsyoumetuymd(keiyakuHozenSakuinKekkaBean.getKhsyoumetuymd());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinhuseiritu(C_GaitouKbn.BLNK);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuin(C_SysCdKbn.RAY);
            hhknSakuinInfoDataSourceBean.setSeirituJyoukyo("");

            hhknSakuinInfoLst.add(hhknSakuinInfoDataSourceBean);
        }

        return hhknSakuinInfoLst;
    }

    private List<HhknSakuinInfoDataSourceBean> setHhknSakuinInfoBeanForSkei(
        BzSakuinTsnSyoukaiKekkaBean pSakuinTsnSyoukaiKekkaBean) {

        List<HhknSakuinInfoDataSourceBean> hhknSakuinInfoLst = new ArrayList<HhknSakuinInfoDataSourceBean>();

        List<BzSinkeiyakuSakuinKekkaBean> bzSkeiSakuinKekkaBeanLst =
            pSakuinTsnSyoukaiKekkaBean.getBzsinkeiyakusakuinkekkabeanlist();

        if (bzSkeiSakuinKekkaBeanLst == null || bzSkeiSakuinKekkaBeanLst.size() == 0) {
            return hhknSakuinInfoLst;
        }

        for (BzSinkeiyakuSakuinKekkaBean skeiSakuinKekkaBeanLst : bzSkeiSakuinKekkaBeanLst) {

            if (C_Mfrenflg.SUMI.eq(skeiSakuinKekkaBeanLst.getSkmfrenflg())) {
                continue;
            }

            C_KeihiKbn taisyou = null;
            C_GaitouKbn huseiritu = null;
            HhknSakuinInfoDataSourceBean hhknSakuinInfoDataSourceBean =
                SWAKInjector.getInstance(HhknSakuinInfoDataSourceBean.class);

            if (C_KankeisyaKbn.HHKN_KYKDOUITU.eq(skeiSakuinKekkaBeanLst.getSkmoskankeisyakbn())) {
                taisyou = C_KeihiKbn.KEIHIDOUITU;
            }
            else if (C_KankeisyaKbn.KYK.eq(skeiSakuinKekkaBeanLst.getSkmoskankeisyakbn())) {
                taisyou = C_KeihiKbn.KYK;
            }
            else {
                taisyou = C_KeihiKbn.HHKN;
            }

            huseiritu = isHuseirituForRAY(skeiSakuinKekkaBeanLst.getSkseiritukbn());

            hhknSakuinInfoDataSourceBean.setDisphhknsakuinsyono("");
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinmosno(skeiSakuinKekkaBeanLst.getSkmosno());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuintaisyou(taisyou);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinkykymd(skeiSakuinKekkaBeanLst.getSkkykymd());
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinsyoumetuymd(null);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuinhuseiritu(huseiritu);
            hhknSakuinInfoDataSourceBean.setDisphhknsakuin(C_SysCdKbn.RAY);
            hhknSakuinInfoDataSourceBean.setSeirituJyoukyo(skeiSakuinKekkaBeanLst.getSkseiritukbn().getValue());

            hhknSakuinInfoLst.add(hhknSakuinInfoDataSourceBean);
        }

        return hhknSakuinInfoLst;
    }

    private void clearWarningMsg() {

        if (C_UmuKbn.ARI.eq(uiBean.getMqErrMsgUmu()) ||
            C_UmuKbn.ARI.eq(uiBean.getPalAteSyoukaiErrMsgUmu()) ||
            C_UmuKbn.ARI.eq(uiBean.getSknInfoSyoukaiErrMsgUmu()) ||
            C_UmuKbn.ARI.eq(uiBean.getKeikokuMsgUmu())) {
            messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);
        }
    }

    private C_GaitouKbn isHuseirituForPAL(C_MossyoumetuKbn pMossyoumetuKbn) {

        if (C_MossyoumetuKbn.MIAWASE.eq(pMossyoumetuKbn) ||
            C_MossyoumetuKbn.ENKI.eq(pMossyoumetuKbn) ||
            C_MossyoumetuKbn.MOSTRKS.eq(pMossyoumetuKbn) ||
            C_MossyoumetuKbn.YUUKOUKIKANKEIKA.eq(pMossyoumetuKbn)) {
            return C_GaitouKbn.GAITOU;
        }

        return C_GaitouKbn.BLNK;
    }

    private C_GaitouKbn isHuseirituForRAY(C_SeirituKbn pSeirituKbn) {

        if (C_SeirituKbn.HUSEIRITU.eq(pSeirituKbn)) {
            return C_GaitouKbn.GAITOU;
        }

        return C_GaitouKbn.BLNK;
    }

    private BizNumber zeroToOptional(BizNumber pHenkanTaiyou) {

        if (pHenkanTaiyou == null || pHenkanTaiyou.isOptional() || pHenkanTaiyou.compareTo(BizNumber.ZERO) == 0) {
            return BizNumber.optional();
        }

        return pHenkanTaiyou;
    }

    private Integer zeroToNull(Integer pHenkanTaiyou) {

        if (pHenkanTaiyou == 0) {
            return null;
        }

        return pHenkanTaiyou;
    }

    private void checkMosno() {

        if (isBlank(uiBean.getMosno()) ||
            uiBean.getMosno() == null) {
            throw new BizLogicException(MessageId.EBA1051, INPUTKEY);
        }
    }
}
