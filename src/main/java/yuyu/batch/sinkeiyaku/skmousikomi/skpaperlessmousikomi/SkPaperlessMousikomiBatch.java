package yuyu.batch.sinkeiyaku.skmousikomi.skpaperlessmousikomi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzLockProcess;
import yuyu.common.biz.koutei.BzLockProcessOutBean;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.hozen.khcommon.SaibanCreditKessaiyouNo;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreate;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardPaperlessMousikomi;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.CheckTkhjn;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.GetHknsyuruinm;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.common.sinkeiyaku.skcommon.SyoukenNoUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HandketsijiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KoukankykKbn;
import yuyu.def.classification.C_KouseiinkykKbn;
import yuyu.def.classification.C_KouteiLockKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_MosTourokuJyoukyouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MosUktkErrKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_Nstkumu;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_SinkihnkKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyssrhKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkhjnKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_BosDairiten;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.entity.HT_BosKokutisyo;
import yuyu.def.db.entity.HT_BosKoumokuCheckError;
import yuyu.def.db.entity.HT_BosKouzaJyouhou;
import yuyu.def.db.entity.HT_BosSyouhn;
import yuyu.def.db.entity.HT_BosTrkKzk;
import yuyu.def.db.entity.HT_BosUketoriKouzaJyouhou;
import yuyu.def.db.entity.HT_BosUketorinin;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.bean.report.SkJimurenrakuhyouBean;
import yuyu.def.sinkeiyaku.bean.report.SkJimurenrakuhyouDetailBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.result.bean.BosKihonInfosByKakutyoujobcdItemsBean;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 申込入力 ペーパーレス申込入力
 */
public class SkPaperlessMousikomiBatch implements Batch {
    private static final String MOSYMD = "mosymd";
    private static final String SEKNO = "sekno";
    private static final String MOSSAKUSEIYMD = "mossakuseiymd";
    private static final String PPLESSMOSUKEYMD = "pplessmosukeymd";
    private static final String HKRYOYKKIGENYMD = "pykkigenymd";
    private static final String MOSCALCKIJYUNYMD = "moscalckijyunymd";
    private static final String KYKNMKN = "kyknmkn";
    private static final String KYKNMKJ = "kyknmkj";
    private static final String KYKSEIYMD = "kykseiymd";
    private static final String KYKKINMUSAKINM = "kykkinmusakinm";
    private static final String TSINYNO = "tsinyno";
    private static final String TSINADR1KJ = "tsinadr1kj";
    private static final String TSINADR2KJ = "tsinadr2kj";
    private static final String TSINADR3KJ = "tsinadr3kj";
    private static final String TSINTELNO = "tsintelno";
    private static final String DAI2TSINTELNO = "dai2tsintelno";
    private static final String HHKNNMKN = "hhknnmkn";
    private static final String HHKNNMKJ = "hhknnmkj";
    private static final String HHKNSEIYMD = "hhknseiymd";
    private static final String KKTYMD = "kktymd";
    private static final String HHKNSYKGYCD = "hhknsykgycd";
    private static final String HHKNYNO = "hhknyno";
    private static final String HHKNADR1KJ = "hhknadr1kj";
    private static final String HHKNADR2KJ = "hhknadr2kj";
    private static final String HHKNADR3KJ = "hhknadr3kj";
    private static final String HHKNTELNO = "hhkntelno";
    private static final String HHKNKINMUSAKINM = "hhknkinmusakinm";
    private static final String SYUKIHONKINGAKU = "syukihons";
    private static final String MOSSYUKYKP = "mossyukykp";
    private static final String NSTKSBNKKN = "nstksbnkkn";
    private static final String SBUKTNIN = "sbuktnin";
    private static final String SBUKTNMKN1 = "sbuktnmkn1";
    private static final String SBUKTNMKJ1 = "sbuktnmkj1";
    private static final String SBUKTSEIYMD1 = "sbuktseiymd1";
    private static final String SBUKTBNKTWARI1 = "sbuktbnwari1";
    private static final String SBUKTNMKN2 = "sbuktnmkn2";
    private static final String SBUKTNMKJ2 = "sbuktnmkj2";
    private static final String SBUKTSEIYMD2 = "sbuktseiymd2";
    private static final String SBUKTBNKTWARI2 = "sbuktbnwari2";
    private static final String SBUKTNMKN3 = "sbuktnmkn3";
    private static final String SBUKTNMKJ3 = "sbuktnmkj3";
    private static final String SBUKTSEIYMD3 = "sbuktseiymd3";
    private static final String SBUKTBNKTWARI3 = "sbuktbnwari3";
    private static final String SBUKTNMKN4 = "sbuktnmkn4";
    private static final String SBUKTNMKJ4 = "sbuktnmkj4";
    private static final String SBUKTSEIYMD4 = "sbuktseiymd4";
    private static final String SBUKTBNKTWARI4 = "sbuktbnwari4";
    private static final String NENKINUKTNMKANA = "nenkinuktnmkana";
    private static final String NENKINUKTNMKANJI = "nenkinuktnmkanji";
    private static final String NENKINUKTSEIYMD = "nenkinuktseiymd";
    private static final String HKNKKN = "hknkkn";
    private static final String HRKKKN = "hrkkkn";
    private static final String SYUDAI1HKNKKN = "syudai1hknkkn";
    private static final String ZNNKAI = "znnkai";
    private static final String MOSIKKATUP = "mosikkatup";
    private static final String MOSZENNOUPSYOKAIARI = "moszennoupsyokaiari";
    private static final String KOUHURIKOUZAINFOSITENCD = "kouhurikouzainfositencd";
    private static final String KOUHURIKOUZAINFOKOUZANO = "kouhurikouzainfokouzano";
    private static final String BANKCD = "bankcd";
    private static final String SITENCD = "sitencd";
    private static final String KOUZANO = "kouzano";
    private static final String KZMEIGINMKN = "kzmeiginmkn";
    private static final String CIFCD = "cifcd";
    private static final String UKTKID = "uktkid";
    private static final String DRTENJIMCD1 = "drtenjimcd1";
    private static final String BOSYUUNINTOUROKUNO1 = "bosyuunintourokuno1";
    private static final String DAIRITENKINYUUKIKANCD1 = "dairitenkinyuukikancd1";
    private static final String DAIRITENKINYUUKIKANSITENCD1 = "dairitenkinyuukikansitencd1";
    private static final String DAIRITENTORIATUKAIKOUINCD1 = "dairitentoriatukaikouincd1";
    private static final String INPUTBOSYUUCD1 = "inputbosyuucd1";
    private static final String DAIRITENBUNTANWARIAI1 = "dairitenbuntanwariai1";
    private static final String INPUTBOSYUUCD2 = "inputbosyuucd2";
    private static final String DSMAILADDRESS = "dsmailaddress";
    private static final String DSBANKCD = "dsbankcd";
    private static final String DSSITENCD = "dssitencd";
    private static final String DSKOUZANO = "dskouzano";
    private static final String DSKZMEIGINMKN = "dskzmeiginmkn";
    private static final String SINTYOU = "sintyou";
    private static final String TAIJYUU = "taijyuu";
    private static final String TRKKZKNMKN1 = "trkkzknmkn1";
    private static final String TRKKZKNMKJ1 = "trkkzknmkj1";
    private static final String TRKKZKSEIYMD1 = "trkkzkseiymd1";
    private static final String TRKKZKYNO1 = "trkkzkyno1";
    private static final String TRKKZKADR1KJ1 = "trkkzkadr1kj1";
    private static final String TRKKZKADR2KJ1 = "trkkzkadr2kj1";
    private static final String TRKKZKADR3KJ1 = "trkkzkadr3kj1";
    private static final String TRKKZKTELNO1 = "trkkzktelno1";
    private static final String HHKDRNMKN = "hhkdrnmkn";
    private static final String HHKDRNMKJ = "hhkdrnmkj";
    private static final String HHKDRSEIYMD = "hhkdrseiymd";

    public long JMRNRKHYOUCOUNT = 0;

    public long SYORIOKCOUNT = 0;

    public long SYORINGCOUNT = 0;

    public String SYSTEMTIME = "";

    private String kouteiKanriId = "";

    private String kouteiLockKey = "";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private CreateReport createReport;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);

    @Inject
    private SkPaperlessMousikomiBatchParam skPaperlessMousikomiBatchParam;

    @Override
    public BatchParam getParam() {
        return skPaperlessMousikomiBatchParam;
    }

    @Execute
    public void execute() {

        BizDate syoriYmd = skPaperlessMousikomiBatchParam.getSyoriYmd();

        int maxSyoriCnt = skPaperlessMousikomiBatchParam.getMaxsyoricnt();

        int syoriCnt = 0;

        boolean zanariFlg = false;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        String kakutyouJobCode = skPaperlessMousikomiBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCode));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "最大処理件数",
            String.valueOf(maxSyoriCnt)));

        String tableId = "HT_BosKihon";

        String recoveryFilterId = "Sk001";

        SYSTEMTIME = BizDate.getSysDateTimeMilli();

        List<String> mosnoLst = getMosnoLst(kakutyouJobCode);
        if (mosnoLst.size() > 0) {

            JMRNRKHYOUCOUNT = 0;
            SYORIOKCOUNT = 0;
            SYORINGCOUNT = 0;

            for (String mosCdTemp : mosnoLst) {

                if(syoriCnt >= maxSyoriCnt){
                    zanariFlg = true;
                    break;
                }

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCode);
                bzRecoveryDatasikibetuBean.setIbTableid(tableId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(mosCdTemp);

                paperlessMousikomiSyori(mosCdTemp);

                HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosCdTemp);
                HT_BosKihon bosKihon = sinkeiyakuDomManager.getBosKihon(mosCdTemp);

                if (syoriCTL != null) {

                    syoriCTL.detach();
                }

                if (bosKihon != null) {

                    bosKihon.detach();
                }

                bizDomManager.clear();
                iwfCoreDomManager.clear();

                syoriCnt++;

            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(SYORIOKCOUNT),
                "ペーパーレス申込入力ＯＫ"));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(SYORINGCOUNT),
                "ペーパーレス申込入力ＮＧ"));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(JMRNRKHYOUCOUNT),
                "ペーパーレス申込入力　事務連絡票"));

            if(zanariFlg){
                batchLogger.info("繰越対象あり");
            }

        }
        else {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0003));
        }

    }

    @Transactional
    List<String> getMosnoLst(String pKakutyouJobCode) {
        List<String> mosnoLst = new ArrayList<String>();
        try (ExDBResults<BosKihonInfosByKakutyoujobcdItemsBean> bosKihonInfosByKakutyoujobcdItemBeanLst =
            sinkeiyakuDomManager.getBosKihonInfosByKakutyoujobcdItems(pKakutyouJobCode, C_MosUketukeKbn.PAPERLESS,
                C_MosTourokuJyoukyouKbn.MITOUROKU, C_UmuKbn.ARI)) {
            for (BosKihonInfosByKakutyoujobcdItemsBean tempBean : bosKihonInfosByKakutyoujobcdItemBeanLst) {
                mosnoLst.add(tempBean.getMosno());
            }
        }
        return mosnoLst;
    }

    @Transactional
    void paperlessMousikomiSyori(String pMosNo) {

        BizDate syoriYmd = skPaperlessMousikomiBatchParam.getSyoriYmd();

        String paperlesSmosyojSkip = "";

        String pskeijimuJmrnrkhyouP1 = "";

        String pskeijimuJmrnrkhyouP2 = "";

        String syoNo = "";

        HT_BosKihon bosKihon = new HT_BosKihon();

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = new HT_MosMikakuteiJyouhouKanri();

        List<HT_BosSyouhn> bosSyouhnLst = new ArrayList<>();

        List<HT_BosUketorinin> bosUketorininLst = new ArrayList<>();

        List<HT_BosDairiten> bosDairitenLst = new ArrayList<>();

        HT_BosKokutisyo bosKokutisyo = new HT_BosKokutisyo();

        HT_BosKouzaJyouhou bosKouzaJyouhou = new HT_BosKouzaJyouhou();

        List<HT_BosUketoriKouzaJyouhou> bosUketoriKouzaJyouhouLst = new ArrayList<>();

        List<HT_BosKoumokuCheckError> bosKoumokuCheckErrorLst = new ArrayList<>();

        List<HT_BosTrkKzk> bosTrkKzkLst = new ArrayList<>();

        SkProcessCreate skProcessCreate = SWAKInjector.getInstance(SkProcessCreate.class);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        BzLockProcess bzLockProcess = SWAKInjector.getInstance(BzLockProcess.class);

        SyoukenNoUtil syoukenNoUtil = SWAKInjector.getInstance(SyoukenNoUtil.class);

        CheckTkhjn checkTkhjn = SWAKInjector.getInstance(CheckTkhjn.class);

        MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);

        GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);

        GetHknsyuruinm getHknsyuruinm = SWAKInjector.getInstance(GetHknsyuruinm.class);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        SkProcessForwardPaperlessMousikomi skProcessForwardPaperlessMousikomi = SWAKInjector
            .getInstance(SkProcessForwardPaperlessMousikomi.class);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);

        C_UmuKbn mosymdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sekNoValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn mossakuseiYmdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn pplessmosukeYmdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hkryoYkkigenYmdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn mosCalckijyunYmdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kyknmKnValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kyknmKjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kykseiYmdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kykKinmusakiNmValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn tsinyNoValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn tsinadr1KjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn tsinadr2KjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn tsinadr3KjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn tsinTelnoValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknnmKnValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknnmKjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknseiYmdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kktYmdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kgyYmdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknSykgyCdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknyNoValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknadr1KjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknadr2KjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknadr3KjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknTelnoValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhknKinmusakiNmValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn syuKihonKingakuValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn mossyukykpValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn nstkSbnkknValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbuktNinValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktnmKn1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktnmKj1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktseiYmd1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktBnktwari1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktnmKn2ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktnmKj2ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktseiYmd2ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktBnktwari2ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktnmKn3ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktnmKj3ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktseiYmd3ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktBnktwari3ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktnmKn4ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktnmKj4ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktseiYmd4ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sbUktBnktwari4ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn nkUktnmKnValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn nkUktnmKjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn nkUktseiYmdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hknKknValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hrkKknValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn uktkIdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn bosyuuninTourokuNo1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dairitenKinyuukikanCd1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dairitenKinyuukikanSitencd1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dairitenBuntanWariai1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sintyouValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn taijyuuValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn trkkzknmkn1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn trkkzknmkj1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn trkkzkseiymd1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn trkkzkyno1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn trkkzkadr1kj1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn trkkzkadr2kj1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn trkkzkadr3kj1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn trkkzktelno1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhkdrnmknValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhkdrnmkjValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn hhkdrseiymdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn mosnrkErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kktnrkErrUmu = C_UmuKbn.NONE;

        C_UmuKbn syudai1hknkknValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn znnkaiValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn mosikkatupValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn moszennoupSyokaiariValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kouhurikouzainfoSitencdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kouhurikouzainfoKouzanoValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dsmailaddressValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dsBankcdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dsSitencdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dsKouzanoValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dsKzmeiginmknValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dai2tsintelnoValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn bankcdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn sitencdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kouzanoValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn kzmeiginmknValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn cifcdValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn drtenjimcd1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn dairitentoriatukaikouincd1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn inputbosyuucd1ValidateErrUmu = C_UmuKbn.NONE;

        C_UmuKbn inputbosyuucd2ValidateErrUmu = C_UmuKbn.NONE;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosNo);

        if (syoriCTL != null) {
            if (!C_MosUketukeKbn.PAPERLESS.eq(syoriCTL.getMosuketukekbn())) {
                pskeijimuJmrnrkhyouP1 = "1";
                batchLogger.error(MessageUtil.getMessage(MessageId.EHF1014, pMosNo, "申込受付区分相違"));
            }
            else {
                batchLogger.error(MessageUtil.getMessage(MessageId.EHF1006, pMosNo));
            }

            paperlesSmosyojSkip = "1";

            SYORINGCOUNT = SYORINGCOUNT + 1;
        }

        if (!"1".equals(paperlesSmosyojSkip) || "1".equals(pskeijimuJmrnrkhyouP1)) {
            bosKihon = sinkeiyakuDomManager.getBosKihon(pMosNo);
            if (bosKihon == null) {
                batchLogger.error(MessageUtil.getMessage(MessageId.EBS0004, "HT_BosKihon", "申込番号", pMosNo));
                throw new CommonBizAppException("申込番号=" + pMosNo);
            }
            bosSyouhnLst = bosKihon.getBosSyouhns();

            bosUketorininLst = bosKihon.getBosUketorinins();

            bosDairitenLst = bosKihon.getBosDairitens();

            bosKokutisyo = bosKihon.getBosKokutisyo();

            bosKouzaJyouhou = bosKihon.getBosKouzaJyouhou();

            bosUketoriKouzaJyouhouLst = bosKihon.getBosUketoriKouzaJyouhous();

            bosKoumokuCheckErrorLst = bosKihon.getBosKoumokuCheckErrors();

            bosTrkKzkLst = bosKihon.getBosTrkKzks();

            mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(pMosNo);

            if (mosMikakuteiJyouhouKanri == null) {
                batchLogger.error(MessageUtil.getMessage(MessageId.EBS0004, "HT_MosMikakuteiJyouhouKanri", "申込番号",
                    pMosNo));
                throw new CommonBizAppException("申込番号=" + pMosNo);
            }
        }

        if (!"1".equals(paperlesSmosyojSkip) || "1".equals(pskeijimuJmrnrkhyouP1)) {

            SkProcessCreateInBean skProcessCreateInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);

            skProcessCreateInBean.setSkeiJimuKbn(mosMikakuteiJyouhouKanri.getSkeijimukbn());

            skProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.PAPERLESS);

            skProcessCreateInBean.setHknSyuruiNo(bosKihon.getHknsyuruino());

            skProcessCreateInBean.setMosYmd(bosKihon.getMosymd());

            skProcessCreateInBean.setJimuStartYmd(SYSTEMTIME);

            skProcessCreateInBean.setMosNo(bosKihon.getMosno());

            skProcessCreateInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

            kouteiKanriId = skProcessCreate.exec(skProcessCreateInBean);

            iwfCoreDomManager.flush();

            if (!"1".equals(paperlesSmosyojSkip)) {

                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryInBean.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                bzGetProcessSummaryInBean.setMosNo(bosKihon.getMosno());

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(
                    bzGetProcessSummaryInBean);

                C_MosUketukeKbn mosUketukeKbn = bzGetProcessSummaryOutBeanLst.get(0).getMosUketukeKbn();

                if (!C_MosUketukeKbn.PAPERLESS.eq(mosUketukeKbn)) {

                    pskeijimuJmrnrkhyouP1 = "1";

                    paperlesSmosyojSkip = "1";

                    batchLogger.error(MessageUtil.getMessage(MessageId.EHF1015, bosKihon.getMosno(), "申込受付区分相違"));

                    SYORINGCOUNT = SYORINGCOUNT + 1;
                }
            }
        }

        BzLockProcessOutBean bzLockProcessOutBean = SWAKInjector.getInstance(BzLockProcessOutBean.class);
        if (!"1".equals(paperlesSmosyojSkip) || "1".equals(pskeijimuJmrnrkhyouP1)) {
            bzLockProcessOutBean = bzLockProcess.exec(kouteiKanriId,
                ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            if (!C_KouteiLockKekkaKbn.SUCCESS.eq(bzLockProcessOutBean.getKouteiLockKekkaKbn())) {
                throw new BizLogicException(MessageUtil.getMessage(MessageId.EBA0110));
            }

            kouteiLockKey = bzLockProcessOutBean.getKouteiLockKey();
        }

        if (!"1".equals(paperlesSmosyojSkip)) {
            HT_MosSyouhn mosSyouhnSyokyk = new HT_MosSyouhn();
            C_MosUktkErrKbn mosUktkErrKbn = C_MosUktkErrKbn.BLNK;

            if (bosKoumokuCheckErrorLst.size() > 0) {
                mosUktkErrKbn = C_MosUktkErrKbn.PPLESSUKTKERROR;

                for (HT_BosKoumokuCheckError error : bosKoumokuCheckErrorLst) {
                    if (MOSYMD.equals(error.getErrorkm())) {
                        mosymdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SEKNO.equals(error.getErrorkm())) {
                        sekNoValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (MOSSAKUSEIYMD.equals(error.getErrorkm())) {
                        mossakuseiYmdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (PPLESSMOSUKEYMD.equals(error.getErrorkm())) {
                        pplessmosukeYmdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HKRYOYKKIGENYMD.equals(error.getErrorkm())) {
                        hkryoYkkigenYmdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (MOSCALCKIJYUNYMD.equals(error.getErrorkm())) {
                        mosCalckijyunYmdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (KYKNMKN.equals(error.getErrorkm())) {
                        kyknmKnValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (KYKNMKJ.equals(error.getErrorkm())) {
                        kyknmKjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (KYKSEIYMD.equals(error.getErrorkm())) {
                        kykseiYmdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (KYKKINMUSAKINM.equals(error.getErrorkm())) {
                        kykKinmusakiNmValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TSINYNO.equals(error.getErrorkm())) {
                        tsinyNoValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TSINADR1KJ.equals(error.getErrorkm())) {
                        tsinadr1KjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TSINADR2KJ.equals(error.getErrorkm())) {
                        tsinadr2KjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TSINADR3KJ.equals(error.getErrorkm())) {
                        tsinadr3KjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TSINTELNO.equals(error.getErrorkm())) {
                        tsinTelnoValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DAI2TSINTELNO.equals(error.getErrorkm())) {
                        dai2tsintelnoValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKNNMKN.equals(error.getErrorkm())) {
                        hhknnmKnValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKNNMKJ.equals(error.getErrorkm())) {
                        hhknnmKjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKNSEIYMD.equals(error.getErrorkm())) {
                        hhknseiYmdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKNKINMUSAKINM.equals(error.getErrorkm())) {
                        hhknKinmusakiNmValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (KKTYMD.equals(error.getErrorkm())) {
                        if (bosKokutisyo != null) {
                            kktYmdValidateErrUmu = C_UmuKbn.ARI;
                            kktnrkErrUmu = C_UmuKbn.ARI;
                        }
                        else {
                            kgyYmdValidateErrUmu = C_UmuKbn.ARI;
                            mosnrkErrUmu = C_UmuKbn.ARI;
                        }
                    }
                    if (HHKNSYKGYCD.equals(error.getErrorkm())) {
                        hhknSykgyCdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKNYNO.equals(error.getErrorkm())) {
                        hhknyNoValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKNADR1KJ.equals(error.getErrorkm())) {
                        hhknadr1KjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKNADR2KJ.equals(error.getErrorkm())) {
                        hhknadr2KjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKNADR3KJ.equals(error.getErrorkm())) {
                        hhknadr3KjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKNTELNO.equals(error.getErrorkm())) {
                        hhknTelnoValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SYUKIHONKINGAKU.equals(error.getErrorkm())) {
                        syuKihonKingakuValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (MOSSYUKYKP.equals(error.getErrorkm())) {
                        mossyukykpValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (NSTKSBNKKN.equals(error.getErrorkm())) {
                        nstkSbnkknValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTNIN.equals(error.getErrorkm())) {
                        sbuktNinValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTNMKN1.equals(error.getErrorkm())) {
                        sbUktnmKn1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTNMKJ1.equals(error.getErrorkm())) {
                        sbUktnmKj1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTSEIYMD1.equals(error.getErrorkm())) {
                        sbUktseiYmd1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTBNKTWARI1.equals(error.getErrorkm())) {
                        sbUktBnktwari1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTNMKN2.equals(error.getErrorkm())) {
                        sbUktnmKn2ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTNMKJ2.equals(error.getErrorkm())) {
                        sbUktnmKj2ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTSEIYMD2.equals(error.getErrorkm())) {
                        sbUktseiYmd2ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTBNKTWARI2.equals(error.getErrorkm())) {
                        sbUktBnktwari2ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTNMKN3.equals(error.getErrorkm())) {
                        sbUktnmKn3ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTNMKJ3.equals(error.getErrorkm())) {
                        sbUktnmKj3ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTSEIYMD3.equals(error.getErrorkm())) {
                        sbUktseiYmd3ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTBNKTWARI3.equals(error.getErrorkm())) {
                        sbUktBnktwari3ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTNMKN4.equals(error.getErrorkm())) {
                        sbUktnmKn4ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTNMKJ4.equals(error.getErrorkm())) {
                        sbUktnmKj4ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTSEIYMD4.equals(error.getErrorkm())) {
                        sbUktseiYmd4ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SBUKTBNKTWARI4.equals(error.getErrorkm())) {
                        sbUktBnktwari4ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (NENKINUKTNMKANA.equals(error.getErrorkm())) {
                        nkUktnmKnValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (NENKINUKTNMKANJI.equals(error.getErrorkm())) {
                        nkUktnmKjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (NENKINUKTSEIYMD.equals(error.getErrorkm())) {
                        nkUktseiYmdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HKNKKN.equals(error.getErrorkm())) {
                        hknKknValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HRKKKN.equals(error.getErrorkm())) {
                        hrkKknValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SYUDAI1HKNKKN.equals(error.getErrorkm())) {
                        syudai1hknkknValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (ZNNKAI.equals(error.getErrorkm())) {
                        znnkaiValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (MOSIKKATUP.equals(error.getErrorkm())) {
                        mosikkatupValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (MOSZENNOUPSYOKAIARI.equals(error.getErrorkm())) {
                        moszennoupSyokaiariValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (KOUHURIKOUZAINFOSITENCD.equals(error.getErrorkm())) {
                        kouhurikouzainfoSitencdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (KOUHURIKOUZAINFOKOUZANO.equals(error.getErrorkm())) {
                        kouhurikouzainfoKouzanoValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (BANKCD.equals(error.getErrorkm())) {
                        bankcdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SITENCD.equals(error.getErrorkm())) {
                        sitencdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (KOUZANO.equals(error.getErrorkm())) {
                        kouzanoValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (KZMEIGINMKN.equals(error.getErrorkm())) {
                        kzmeiginmknValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (CIFCD.equals(error.getErrorkm())) {
                        cifcdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (UKTKID.equals(error.getErrorkm())) {
                        uktkIdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DRTENJIMCD1.equals(error.getErrorkm())) {
                        drtenjimcd1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (BOSYUUNINTOUROKUNO1.equals(error.getErrorkm())) {
                        bosyuuninTourokuNo1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DAIRITENKINYUUKIKANCD1.equals(error.getErrorkm())) {
                        dairitenKinyuukikanCd1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DAIRITENKINYUUKIKANSITENCD1.equals(error.getErrorkm())) {
                        dairitenKinyuukikanSitencd1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DAIRITENTORIATUKAIKOUINCD1.equals(error.getErrorkm())) {
                        dairitentoriatukaikouincd1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (INPUTBOSYUUCD1.equals(error.getErrorkm())) {
                        inputbosyuucd1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DAIRITENBUNTANWARIAI1.equals(error.getErrorkm())) {
                        dairitenBuntanWariai1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (INPUTBOSYUUCD2.equals(error.getErrorkm())) {
                        inputbosyuucd2ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DSMAILADDRESS.equals(error.getErrorkm())) {
                        dsmailaddressValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DSBANKCD.equals(error.getErrorkm())) {
                        dsBankcdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DSSITENCD.equals(error.getErrorkm())) {
                        dsSitencdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DSKOUZANO.equals(error.getErrorkm())) {
                        dsKouzanoValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (DSKZMEIGINMKN.equals(error.getErrorkm())) {
                        dsKzmeiginmknValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (SINTYOU.equals(error.getErrorkm())) {
                        sintyouValidateErrUmu = C_UmuKbn.ARI;
                        kktnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TAIJYUU.equals(error.getErrorkm())) {
                        taijyuuValidateErrUmu = C_UmuKbn.ARI;
                        kktnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TRKKZKNMKN1.equals(error.getErrorkm())) {
                        trkkzknmkn1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TRKKZKNMKJ1.equals(error.getErrorkm())) {
                        trkkzknmkj1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TRKKZKSEIYMD1.equals(error.getErrorkm())) {
                        trkkzkseiymd1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TRKKZKYNO1.equals(error.getErrorkm())) {
                        trkkzkyno1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TRKKZKADR1KJ1.equals(error.getErrorkm())) {
                        trkkzkadr1kj1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TRKKZKADR2KJ1.equals(error.getErrorkm())) {
                        trkkzkadr2kj1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TRKKZKADR3KJ1.equals(error.getErrorkm())) {
                        trkkzkadr3kj1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (TRKKZKTELNO1.equals(error.getErrorkm())) {
                        trkkzktelno1ValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKDRNMKN.equals(error.getErrorkm())) {
                        hhkdrnmknValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKDRNMKJ.equals(error.getErrorkm())) {
                        hhkdrnmkjValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                    if (HHKDRSEIYMD.equals(error.getErrorkm())) {
                        hhkdrseiymdValidateErrUmu = C_UmuKbn.ARI;
                        mosnrkErrUmu = C_UmuKbn.ARI;
                    }
                }
            }

            BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
            HM_SkHokenSyuruiNo skHokenSyuruiNo = new HM_SkHokenSyuruiNo();
            HT_BosSyouhn syuBosSyouhn = new HT_BosSyouhn();
            C_UmuKbn syksbyensitihsyutkhkkbn = C_UmuKbn.NONE;
            C_UmuKbn teikisiharaikinUmu = C_UmuKbn.NONE;
            EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);

            List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
                sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(bosKihon.getHknsyuruino(), syoriYmd);

            if (skHokenSyuruiNoLst.size() == 0) {

                batchLogger.error(MessageUtil.getMessage(MessageId.EBS0005, "HM_SkHokenSyuruiNo", "保険種類番号",
                    bosKihon.getHknsyuruino().getValue(), "表示日", syoriYmd.toString()));

                throw new CommonBizAppException("申込番号=" + bosKihon.getMosno());
            }

            skHokenSyuruiNo = skHokenSyuruiNoLst.get(0);

            for (HT_BosSyouhn tempBosSyouhn : bosSyouhnLst) {
                if (C_SyutkKbn.SYU.eq(tempBosSyouhn.getSyutkkbn())) {
                    syuBosSyouhn = tempBosSyouhn;
                    break;
                }
            }

            if (C_Tkhukaumu.HUKA.eq(bosKihon.getSyksbyensitihsyutkhkkbn())) {
                syksbyensitihsyutkhkkbn = C_UmuKbn.ARI;
            }
            else {
                syksbyensitihsyutkhkkbn = C_UmuKbn.NONE;
            }

            if (C_Tkhukaumu.HUKA.eq(bosKihon.getTeikisiharaitkykhkkbn())) {
                teikisiharaikinUmu = C_UmuKbn.ARI;
            }
            else {
                teikisiharaikinUmu = C_UmuKbn.NONE;
            }

            String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(bosKihon.getHknsyuruino());

            if ("1".equals(syouhinHantei)) {

                List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(
                    syoriYmd, C_SyutkKbn.SYU, skHokenSyuruiNo.getDaihyouhknsyuruino(), 0, syuBosSyouhn.getDai1hknkkn(),
                    bosKihon.getKyktuukasyu(), syksbyensitihsyutkhkkbn, syuBosSyouhn.getSknenkinsyu(), teikisiharaikinUmu);

                if (syouhnZokuseiLst.size() == 0) {

                    batchLogger.error(MessageUtil.getMessage(MessageId.EBS1011, "BM_SyouhnZokusei", "表示日", String
                        .valueOf(syoriYmd), "主契約特約区分", C_SyutkKbn.SYU.getValue(), "保険種類番号",
                        skHokenSyuruiNo.getDaihyouhknsyuruino().getValue(), "年金原資最低保証率", "0", "第１保険期間",
                        String.valueOf(syuBosSyouhn.getDai1hknkkn()), "通貨種類", bosKihon.getKyktuukasyu().getValue(),
                        "初期死亡時円換算最低保証特約適用有無", syksbyensitihsyutkhkkbn.getValue(), "新契約年金種類",
                        syuBosSyouhn.getSknenkinsyu().getValue(), "定期支払金有無", teikisiharaikinUmu.getValue()));

                    throw new CommonBizAppException("申込番号=" + bosKihon.getMosno());
                }

                syouhnZokusei = syouhnZokuseiLst.get(0);
            }
            else {

                List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHknsyuruinoItems2(
                    syoriYmd, C_SyutkKbn.SYU, skHokenSyuruiNo.getDaihyouhknsyuruino(), 0,
                    syksbyensitihsyutkhkkbn, syuBosSyouhn.getSknenkinsyu(), teikisiharaikinUmu);

                if (syouhnZokuseiLst.size() == 0) {

                    batchLogger.error(MessageUtil.getMessage(MessageId.EBS1009, "BM_SyouhnZokusei", "表示日", String
                        .valueOf(syoriYmd), "主契約特約区分", C_SyutkKbn.SYU.getValue(), "保険種類番号",
                        skHokenSyuruiNo.getDaihyouhknsyuruino().getValue(), "年金原資最低保証率", "0",
                        "初期死亡時円換算最低保証特約適用有無", syksbyensitihsyutkhkkbn.getValue(), "新契約年金種類",
                        syuBosSyouhn.getSknenkinsyu().getValue(), "定期支払金有無", teikisiharaikinUmu.getValue()));

                    throw new CommonBizAppException("申込番号=" + bosKihon.getMosno());
                }

                syouhnZokusei = syouhnZokuseiLst.get(0);
            }

            try {
                syoNo = syoukenNoUtil.getShokenNo(bosKihon.getMosno(), null, baseUserInfo.getUserId());
            }
            catch (CommonBizAppException e) {

                batchLogger.error(MessageUtil.getMessage(MessageId.EHF1013));
                throw new CommonBizAppException(e, "申込番号=" + bosKihon.getMosno());
            }

            HT_SyoriCTL syoriCTLSksTemp = new HT_SyoriCTL();
            syoriCTLSksTemp.setMosno(bosKihon.getMosno());

            sinkeiyakuDomManager.insert(syoriCTLSksTemp);

            C_YouhiKbn kykTktKkHjnKakuninYouhiKbn = C_YouhiKbn.HUYOU;
            C_YouhiKbn hhkTktKnkHjnKakuninYouhiKbn = C_YouhiKbn.HUYOU;

            if (!C_UmuKbn.ARI.eq(dairitenKinyuukikanCd1ValidateErrUmu) && bosDairitenLst.size() != 0) {

                List<String> totugoutkhjnnmkjLst = new ArrayList<>();
                String htkhjnKinyuuCd = "";
                HT_BosDairiten bosDairitenA = new HT_BosDairiten();

                for (HT_BosDairiten bosDairiten : bosDairitenLst) {

                    if (bosDairiten.getRenno() == 1) {

                        bosDairitenA = bosDairiten;
                        break;
                    }
                }
                if (BizUtil.isBlank(bosDairitenA.getKinyuucd())) {

                    htkhjnKinyuuCd = "s";
                }
                else {
                    htkhjnKinyuuCd = bosDairitenA.getKinyuucd();
                }

                totugoutkhjnnmkjLst = sinkeiyakuDomManager.getTotugoutkhjnnmkjsByTkhjnkinyuucd(htkhjnKinyuuCd);

                if (totugoutkhjnnmkjLst.size() != 0) {
                    if (!C_UmuKbn.ARI.eq(kykKinmusakiNmValidateErrUmu)
                        && !BizUtil.isBlank(bosKihon.getKykkinmusakinm())) {
                        List<String> checkTaiou = checkTkhjn.crtCheckTaisyouLst(bosKihon.getKykkinmusakinm());

                        if (checkTaiou.size() != 0) {
                            C_YouhiKbn youhiKbn = checkTkhjn.checkJissi(totugoutkhjnnmkjLst, checkTaiou);

                            if (C_YouhiKbn.YOU.eq(youhiKbn)) {
                                kykTktKkHjnKakuninYouhiKbn = C_YouhiKbn.YOU;
                            }
                        }
                    }

                    if (!C_UmuKbn.ARI.eq(hhknKinmusakiNmValidateErrUmu)
                        && !BizUtil.isBlank(bosKihon.getHhknkinmusakinm())) {
                        List<String> checkTaiou = checkTkhjn.crtCheckTaisyouLst(bosKihon.getHhknkinmusakinm());

                        if (checkTaiou.size() != 0) {
                            C_YouhiKbn youhiKbn = checkTkhjn.checkJissi(totugoutkhjnnmkjLst, checkTaiou);

                            if (C_YouhiKbn.YOU.eq(youhiKbn)) {
                                hhkTktKnkHjnKakuninYouhiKbn = C_YouhiKbn.YOU;
                            }
                        }
                    }
                }
            }
            HT_SyoriCTL syoriCTLSks = sinkeiyakuDomManager.getSyoriCTL(bosKihon.getMosno());
            syoriCTLSks.setSyono(syoNo);
            syoriCTLSks.setMosuketukekbn(C_MosUketukeKbn.PAPERLESS);
            syoriCTLSks.setMosuktkerrkbn(mosUktkErrKbn);
            syoriCTLSks.setSkeijimukbn(mosMikakuteiJyouhouKanri.getSkeijimukbn());
            if (C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)) {
                if (C_UmuKbn.ARI.eq(mosnrkErrUmu)) {
                    syoriCTLSks.setMosnrkumu(C_UmuKbn.NONE);
                    syoriCTLSks.setMosnrkvrfjkkbn(C_VrfjkKbn.SANJINRKMATI);
                }
                else {
                    syoriCTLSks.setMosnrkumu(C_UmuKbn.ARI);
                    syoriCTLSks.setMosnrkvrfjkkbn(C_VrfjkKbn.TSHN_MIJISSI);
                    syoriCTLSks.setMosnrkymd(syoriYmd);
                }
            }
            else {
                syoriCTLSks.setMosnrkumu(C_UmuKbn.ARI);
                syoriCTLSks.setMosnrkvrfjkkbn(C_VrfjkKbn.TSHN_MIJISSI);
                syoriCTLSks.setMosnrkymd(syoriYmd);
            }
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getKktumu()) && bosKokutisyo != null) {
                if (C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)) {
                    syoriCTLSks.setKktnrkumu(C_UmuKbn.NONE);
                }
                else {
                    syoriCTLSks.setKktnrkumu(C_UmuKbn.ARI);
                }
            }
            else {
                syoriCTLSks.setKktnrkumu(C_UmuKbn.NONE);
            }
            syoriCTLSks.setKktnrkhbumu(C_UmuKbn.NONE);
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getKktumu()) && bosKokutisyo != null) {
                if (C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)) {
                    syoriCTLSks.setKktnrkvrfjkkbn(C_VrfjkKbn.SANJINRKMATI);
                }
                else {
                    syoriCTLSks.setKktnrkvrfjkkbn(C_VrfjkKbn.TSHN_MIJISSI);
                }
            }
            else {
                syoriCTLSks.setKktnrkvrfjkkbn(C_VrfjkKbn.TSHN_MIJISSI);
            }

            syoriCTLSks.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SONOTA_MINYUUKIN);
            syoriCTLSks.setCredittrkjkkbn(C_CreditTrkjkKbn.BLNK);
            syoriCTLSks.setCredityuukoukakkbn(C_CreditYuukoukakKbn.BLNK);
            syoriCTLSks.setKetteikbn(C_KetteiKbn.NONE);
            syoriCTLSks.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            if (C_YouhiKbn.YOU.eq(kykTktKkHjnKakuninYouhiKbn) || C_YouhiKbn.YOU.eq(hhkTktKnkHjnKakuninYouhiKbn)) {
                syoriCTLSks.setTkhjnkbn(C_TkhjnKbn.BLNK);
                syoriCTLSks.setTktkhjnkakuninyouhikbn(C_YouhiKbn.YOU);
            }
            else {
                syoriCTLSks.setTkhjnkbn(C_TkhjnKbn.NASI);
                syoriCTLSks.setTktkhjnkakuninyouhikbn(C_YouhiKbn.HUYOU);
            }
            syoriCTLSks.setKouseiinkykkbn(C_KouseiinkykKbn.GAITOUNASI);
            syoriCTLSks.setKoukankykkbn(C_KoukankykKbn.GAITOUNASI);
            if (C_FatcasnsiKbn.BLNK.eq(bosKihon.getFatcasnsikbn())
                && C_BikkjnssinfoKbn.BLNK.eq(bosKihon.getBikkjnssinfokbn())) {
                syoriCTLSks.setFatcakakkekkakbn(C_FatcakakkekkaKbn.FATCA_TEIKITYOSAHUYOU);
            }
            else {
                syoriCTLSks.setFatcakakkekkakbn(C_FatcakakkekkaKbn.BLNK);
            }
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getAeoitaisyouumu())
                && C_AeoisnsiKbn.BLNK.eq(bosKihon.getAeoisnsikbn())) {
                syoriCTLSks.setAeoikekkakbn(C_AeoiKekkaKbn.HOUKOKUTAISYOUGAI);
            }
            else {
                syoriCTLSks.setAeoikekkakbn(C_AeoiKekkaKbn.BLNK);
            }
            syoriCTLSks.setTkhsyouryakuumukbn(C_UmuKbn.NONE);
            syoriCTLSks.setSeiritukbn(C_SeirituKbn.NONE);
            syoriCTLSks.setSyssrhkbn(C_SyssrhKbn.NONE);
            syoriCTLSks.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            syoriCTLSks.setGyoumuKousinTime(SYSTEMTIME);

            BizPropertyInitializer.initialize(syoriCTLSks);

            HT_MosKihon mosKihon = syoriCTLSks.createMosKihon();
            if (!C_UmuKbn.ARI.eq(sekNoValidateErrUmu)) {
                mosKihon.setSekno(bosKihon.getSekno());
            }
            if (!C_UmuKbn.ARI.eq(hkryoYkkigenYmdValidateErrUmu)) {
                mosKihon.setPykkigenymd(bosKihon.getPykkigenymd());
            }
            if (!C_UmuKbn.ARI.eq(mosymdValidateErrUmu)) {
                mosKihon.setMosymd(bosKihon.getMosymd());
            }
            if (!C_UmuKbn.ARI.eq(mossakuseiYmdValidateErrUmu)) {
                mosKihon.setMossakuseiymd(bosKihon.getMossakuseiymd());
            }
            if (!C_UmuKbn.ARI.eq(mosCalckijyunYmdValidateErrUmu)) {
                mosKihon.setMoscalckijyunymd(bosKihon.getMoscalckijyunymd());
            }
            if (!C_UmuKbn.ARI.eq(pplessmosukeYmdValidateErrUmu)) {
                mosKihon.setPplessmosukeymd(bosKihon.getPplessmosukeymd());
            }
            if (!C_UmuKbn.ARI.eq(kgyYmdValidateErrUmu)) {
                mosKihon.setKktymd(bosKihon.getKktymd());
            }
            mosKihon.setKykkbn(bosKihon.getKykkbn());
            mosKihon.setHknsyuruino(bosKihon.getHknsyuruino());
            mosKihon.setHknsyuruinosd(skHokenSyuruiNo.getHknsyuruinosd());
            mosKihon.setNkgnshosyouritukbn(bosKihon.getNkgnshosyouritukbn());
            mosKihon.setKzktourokuservicetourokukbn(bosKihon.getKzktourokuservicetourokukbn());
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getKykdrtkykumu()) && C_Tkhukaumu.BLNK.eq(bosKihon.getKykdrtkykhukakbn())) {
                mosKihon.setKykdrtkykhukakbn(C_Tkhukaumu.NONE);
            }
            else {
                mosKihon.setKykdrtkykhukakbn(bosKihon.getKykdrtkykhukakbn());
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getStdrsktkumu()) && C_Tkhukaumu.BLNK.eq(bosKihon.getStdrsktkyhkkbn())) {
                mosKihon.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
            }
            else {
                mosKihon.setStdrsktkyhkkbn(bosKihon.getStdrsktkyhkkbn());
            }
            mosKihon.setSdpdkbn(bosKihon.getSdpdkbn());
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyokugyoukktumu())) {
                mosKihon.setSntkhoukbn(C_SntkhouKbn.SYOKUGYOU);
            }
            else {
                mosKihon.setSntkhoukbn(bosKihon.getSntkhoukbn());
            }
            mosKihon.setHaitoukbn(syouhnZokusei.getHaitoukbn());
            if (C_HaitouKbn.RISAHAI.eq(syouhnZokusei.getHaitoukbn())) {
                mosKihon.setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn.TUMIHAI);
            }
            else {
                mosKihon.setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn.BLNK);

            }
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getGaikatatkiumu())) {
                if (!C_Tuukasyu.BLNK.eq(bosKihon.getKyktuukasyu())) {
                    mosKihon.setKyktuukasyu(bosKihon.getKyktuukasyu());
                }
                if (!C_Tuukasyu.BLNK.eq(bosKihon.getHrktuukasyu())) {
                    mosKihon.setHrktuukasyu(bosKihon.getHrktuukasyu());
                }
            }
            else {
                mosKihon.setKyktuukasyu(C_Tuukasyu.JPY);
                mosKihon.setHrktuukasyu(C_Tuukasyu.JPY);
            }

            if (C_Tkhukaumu.HUKA.eq(bosKihon.getYennykntkhkkbn())) {

                mosKihon.setYennykntkhkkbn(C_Tkhukaumu.HUKA);
            }
            else {

                if (C_UmuKbn.NONE.eq(syouhnZokusei.getPyennykntktekiumu())) {

                    mosKihon.setYennykntkhkkbn(C_Tkhukaumu.BLNK);
                }
                else {

                    mosKihon.setYennykntkhkkbn(C_Tkhukaumu.NONE);
                }
            }

            if (C_Tkhukaumu.HUKA.eq(bosKihon.getGaikanykntkhkkbn())) {

                mosKihon.setGaikanykntkhkkbn(C_Tkhukaumu.HUKA);
            }
            else {

                if (C_UmuKbn.NONE.eq(syouhnZokusei.getGaikanyuukintktekiumu())) {

                    mosKihon.setGaikanykntkhkkbn(C_Tkhukaumu.BLNK);
                }
                else {

                    mosKihon.setGaikanykntkhkkbn(C_Tkhukaumu.NONE);
                }
            }

            if (!C_UmuKbn.ARI.eq(mossyukykpValidateErrUmu)) {
                mosKihon.setMosheijyunp(bosKihon.getMosheijyunp());
            }
            mosKihon.setIkkatubaraikbn(bosKihon.getIkkatubaraikbn());
            mosKihon.setIkkatubaraikaisuu(bosKihon.getIkkatubaraikaisuu());
            if (!C_UmuKbn.ARI.eq(mosikkatupValidateErrUmu)) {
                mosKihon.setMosikkatup(bosKihon.getMosikkatup());
            }
            mosKihon.setZennoumousideumu(bosKihon.getZennoumousideumu());
            mosKihon.setZenkizennouumu(bosKihon.getZenkizennouumu());
            if (!C_UmuKbn.ARI.eq(znnkaiValidateErrUmu)) {
                mosKihon.setZnnkai(bosKihon.getZnnkai());
            }
            if (!C_UmuKbn.ARI.eq(moszennoupSyokaiariValidateErrUmu)) {
                mosKihon.setMoszennoupsyokaiari(bosKihon.getMoszennoupsyokaiari());
            }

            if (C_UmuKbn.ARI.eq(bosKihon.getZennoumousideumu())) {

                if (!C_UmuKbn.ARI.eq(moszennoupSyokaiariValidateErrUmu)) {
                    mosKihon.setMosfstpkei(bosKihon.getMoszennoupsyokaiari());
                }
            }
            else if (!C_IkkatubaraiKbn.BLNK.eq(bosKihon.getIkkatubaraikbn())) {

                if (!C_UmuKbn.ARI.eq(mosikkatupValidateErrUmu)) {
                    mosKihon.setMosfstpkei(bosKihon.getMosikkatup());
                }
            }
            else {

                if (!C_UmuKbn.ARI.eq(mossyukykpValidateErrUmu)) {
                    mosKihon.setMosfstpkei(syuBosSyouhn.getHrktuukasyutkp());
                }
            }

            mosKihon.setHrkkaisuu(bosKihon.getHrkkaisuu());
            mosKihon.setHrkkeiro(bosKihon.getHrkkeiro());
            mosKihon.setFstphrkkeirokbn(bosKihon.getFstphrkkeirokbn());
            if (!C_UmuKbn.ARI.eq(hhknnmKnValidateErrUmu)) {
                mosKihon.setHhknnmkn(bosKihon.getHhknnmkn());
            }
            if (!C_UmuKbn.ARI.eq(hhknnmKjValidateErrUmu)) {
                mosKihon.setHhknnmkj(bosKihon.getHhknnmkj());
            }
            mosKihon.setHhknnmkjkhukakbn(bosKihon.getHhknnmkjkhukakbn());
            if (!C_UmuKbn.ARI.eq(hhknseiYmdValidateErrUmu)) {
                mosKihon.setHhknseiymd(bosKihon.getHhknseiymd());
            }
            mosKihon.setHhknsei(bosKihon.getHhknsei());
            if (!C_UmuKbn.ARI.eq(hhknSykgyCdValidateErrUmu)) {
                mosKihon.setHhknsykgycd(bosKihon.getHhknsykgycd());
            }
            mosKihon.setHhknnensyuukbn(bosKihon.getHhknnensyuukbn());
            mosKihon.setTsindousiteikbn(bosKihon.getTsindousiteikbn());
            if (!C_UmuKbn.ARI.eq(hhknyNoValidateErrUmu)) {
                mosKihon.setHhknyno(bosKihon.getHhknyno());
            }
            if (!C_UmuKbn.ARI.eq(hhknadr1KjValidateErrUmu) && !C_UmuKbn.ARI.eq(hhknadr2KjValidateErrUmu) &&
                !C_UmuKbn.ARI.eq(hhknadr3KjValidateErrUmu)) {
                mosKihon.setHhknadr1kj(bosKihon.getHhknadr1kj());
                mosKihon.setHhknadr2kj(bosKihon.getHhknadr2kj());
                mosKihon.setHhknadr3kj(bosKihon.getHhknadr3kj());
            }
            if (!C_UmuKbn.ARI.eq(hhknTelnoValidateErrUmu)) {
                mosKihon.setHhkntelno(bosKihon.getHhkntelno());
            }
            if (!C_UmuKbn.ARI.eq(hhknKinmusakiNmValidateErrUmu)) {
                mosKihon.setHhknkinmusakinm(bosKihon.getHhknkinmusakinm());
            }
            if (!C_UmuKbn.ARI.eq(kyknmKnValidateErrUmu)) {
                mosKihon.setKyknmkn(bosKihon.getKyknmkn());
            }
            if (!C_UmuKbn.ARI.eq(kyknmKjValidateErrUmu)) {
                mosKihon.setKyknmkj(bosKihon.getKyknmkj());
            }
            mosKihon.setKyknmkjkhukakbn(bosKihon.getKyknmkjkhukakbn());
            if (!C_UmuKbn.ARI.eq(kykseiYmdValidateErrUmu)) {
                mosKihon.setKykseiymd(bosKihon.getKykseiymd());
            }
            mosKihon.setKyksei(bosKihon.getKyksei());
            mosKihon.setKyktdk(bosKihon.getKyktdk());
            mosKihon.setKyknensyuukbn(bosKihon.getKyknensyuukbn());
            if (!C_UmuKbn.ARI.eq(kykKinmusakiNmValidateErrUmu)) {
                mosKihon.setKykkinmusakinm(bosKihon.getKykkinmusakinm());
            }
            mosKihon.setYakkanjyuryouhoukbn(bosKihon.getYakkanjyuryouhoukbn());
            mosKihon.setYakkanbunsyono(bosKihon.getYakkanbunsyono());
            mosKihon.setFatcasnsikbn(bosKihon.getFatcasnsikbn());
            mosKihon.setBikkjnssinfokbn(bosKihon.getBikkjnssinfokbn());
            mosKihon.setAeoisnsikbn(bosKihon.getAeoisnsikbn());
            if (!C_UmuKbn.ARI.eq(tsinyNoValidateErrUmu)) {
                mosKihon.setTsinyno(bosKihon.getTsinyno());
            }
            if (!C_UmuKbn.ARI.eq(tsinadr1KjValidateErrUmu) && !C_UmuKbn.ARI.eq(tsinadr2KjValidateErrUmu) &&
                !C_UmuKbn.ARI.eq(tsinadr3KjValidateErrUmu)) {
                mosKihon.setTsinadr1kj(bosKihon.getTsinadr1kj());
                mosKihon.setTsinadr2kj(bosKihon.getTsinadr2kj());
                mosKihon.setTsinadr3kj(bosKihon.getTsinadr3kj());
            }
            if (!C_UmuKbn.ARI.eq(tsinTelnoValidateErrUmu)) {
                mosKihon.setTsintelno(bosKihon.getTsintelno());
            }
            if (!C_TargetTkHukaKanouKbn.NONE.eq(syouhnZokusei.getTargettkhukakanoukbn()) &&
                C_Tkhukaumu.BLNK.eq(bosKihon.getTargettkhkkbn())) {
                mosKihon.setTargettkhkkbn(C_Tkhukaumu.NONE);
            }
            else {
                mosKihon.setTargettkhkkbn(bosKihon.getTargettkhkkbn());
            }
            mosKihon.setTargettkkbn(bosKihon.getTargettkkbn());
            if (C_Tkhukaumu.HUKA.eq(bosKihon.getTargettkhkkbn()) &&
                C_TargetTkMokuhyoutiKbn.BLNK.eq(bosKihon.getTargettkmkhtkbn())) {
                mosKihon.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
            }
            else {
                mosKihon.setTargettkmkhtkbn(bosKihon.getTargettkmkhtkbn());
            }
            if (C_Nstkumu.ST_ARI.eq(syouhnZokusei.getNstkumu()) && C_Tkhukaumu.BLNK.eq(bosKihon.getNstkhkkbn())) {
                mosKihon.setNstkhkkbn(C_Tkhukaumu.NONE);
            }
            else {
                mosKihon.setNstkhkkbn(bosKihon.getNstkhkkbn());
            }
            mosKihon.setNstksbnsyu(bosKihon.getNstksbnsyu());
            if (!C_UmuKbn.ARI.eq(nstkSbnkknValidateErrUmu)) {
                mosKihon.setNstksbnkkn(bosKihon.getNstksbnkkn());
            }

            mosKihon.setSyksbyensitihsyutkhkkbn(bosKihon.getSyksbyensitihsyutkhkkbn());

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getJyudkaigomehrtktekiumu()) && C_Tkhukaumu.BLNK.eq(bosKihon.
                getJyudkaigomehrtkhkkbn())) {
                mosKihon.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.NONE);
            }
            else {
                mosKihon.setJyudkaigomehrtkhkkbn(bosKihon.getJyudkaigomehrtkhkkbn());
            }
            mosKihon.setKjnnkpzeitekitkhukakbn(bosKihon.getKjnnkpzeitekitkhukakbn());
            mosKihon.setTeikisiharaitkykhkkbn(bosKihon.getTeikisiharaitkykhkkbn());
            if (!C_UmuKbn.ARI.eq(sbuktNinValidateErrUmu)) {
                mosKihon.setSbuktnin(bosKihon.getSbuktnin());
            }
            mosKihon.setKykhonninkakninsyoruikbn(bosKihon.getKykhonninkakninsyoruikbn());
            mosKihon.setSkskknhonninkakninsyoruikbn(bosKihon.getSkskknhonninkakninsyoruikbn());
            mosKihon.setKoureikzksetumeihoukbn(bosKihon.getKoureikzksetumeihoukbn());
            mosKihon.setKoureimndnhukusuukaikbn(bosKihon.getKoureimndnhukusuukaikbn());
            mosKihon.setKoureitratkisyaigidskkbn(bosKihon.getKoureitratkisyaigidskkbn());
            mosKihon.setDaihituumukbn(bosKihon.getDaihituumukbn());
            if (!C_UmuKbn.ARI.eq(uktkIdValidateErrUmu)) {
                mosKihon.setUktkid(bosKihon.getUktkid());
            }
            mosKihon.setDrctservicemoskbn(bosKihon.getDrctservicemoskbn());
            if (!C_UmuKbn.ARI.eq(dsmailaddressValidateErrUmu)) {
                mosKihon.setDsmailaddress(bosKihon.getDsmailaddress());
            }
            mosKihon.setYnkhrkmgkannituutikbn(bosKihon.getYnkhrkmgkannituutikbn());
            mosKihon.setTokuteitrhkansyono(bosKihon.getTokuteitrhkansyono());
            mosKihon.setPplessrenjidssymenttdkhyj(bosKihon.getPplessrenjidssymenttdkhyj());
            mosKihon.setPplsrendoukouhurikousoukbn(bosKihon.getPplsrendoukouhurikousoukbn());
            mosKihon.setPplessrendoucreditkousoukbn(bosKihon.getPplessrendoucreditkousoukbn());
            mosKihon.setHnsstjmmouumukbn(bosKihon.getHnsstjmmouumukbn());
            mosKihon.setKjmeigihkhunouumukbn(bosKihon.getKjmeigihkhunouumukbn());
            mosKihon.setTsryhshrkykumukbn(bosKihon.getTsryhshrkykumukbn());
            mosKihon.setSyosisyatodokeumukbn(bosKihon.getSyosisyatodokeumukbn());
            mosKihon.setKakukisyouryakukbumukbn(bosKihon.getKakukisyouryakukbumukbn());
            mosKihon.setSeiymdmosseitouumukbn(bosKihon.getSeiymdmosseitouumukbn());
            mosKihon.setIkokakninsyotokkijkumu(bosKihon.getIkokakninsyotokkijkumu());
            mosKihon.setTrtkhoukokusyotokkijkumu(bosKihon.getTrtkhoukokusyotokkijkumu());
            mosKihon.setHnnkakninhskjikouumukbn(bosKihon.getHnnkakninhskjikouumukbn());
            mosKihon.setHnnkakninhsktkjikouumukbn(bosKihon.getHnnkakninhsktkjikouumukbn());
            mosKihon.setSkskakninhsktkjikouumukbn(bosKihon.getSkskakninhsktkjikouumukbn());
            mosKihon.setMobilebosyuukbn(bosKihon.getMobilebosyuukbn());
            mosKihon.setTeirituhaibunwarikbn(bosKihon.getTeirituhaibunwarikbn());
            mosKihon.setSisuukbn(bosKihon.getSisuukbn());
            mosKihon.setSisuuhaibunwarikbn(bosKihon.getSisuuhaibunwarikbn());
            mosKihon.setTrhkjikakkbn(C_TrhkjiKakKbn.KAKUNINZUMI);
            mosKihon.setKoureitaioukbn(bosKihon.getKoureitaioukbn());
            mosKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            mosKihon.setGyoumuKousinTime(SYSTEMTIME);

            BizPropertyInitializer.initialize(mosKihon);

            if (bosUketorininLst.size() != 0) {
                for (HT_BosUketorinin bosUketorinin : bosUketorininLst) {
                    if (C_UktsyuKbn.SBUKT.eq(bosUketorinin.getUktsyukbn())) {
                        HT_Uketorinin uketorinin = syoriCTLSks.createUketorinin();
                        uketorinin.setUktsyukbn(bosUketorinin.getUktsyukbn());
                        uketorinin.setUktsyurenno(bosUketorinin.getUktsyurenno());
                        uketorinin.setUktkbn(bosUketorinin.getUktkbn());
                        uketorinin.setUktnmkjkhukakbn(bosUketorinin.getUktnmkjkhukakbn());
                        uketorinin.setUkttdk(bosUketorinin.getUkttdk());
                        if (bosUketorinin.getUktsyurenno() == 1) {
                            if (!C_UmuKbn.ARI.eq(sbUktnmKn1ValidateErrUmu)) {
                                uketorinin.setUktnmkn(bosUketorinin.getUktnmkn());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktnmKj1ValidateErrUmu)) {
                                uketorinin.setUktnmkj(bosUketorinin.getUktnmkj());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktBnktwari1ValidateErrUmu)) {
                                uketorinin.setUktbnwari(bosUketorinin.getUktbnwari());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktseiYmd1ValidateErrUmu)) {
                                uketorinin.setUktseiymd(bosUketorinin.getUktseiymd());
                            }
                        }
                        else if (bosUketorinin.getUktsyurenno() == 2) {
                            if (!C_UmuKbn.ARI.eq(sbUktnmKn2ValidateErrUmu)) {
                                uketorinin.setUktnmkn(bosUketorinin.getUktnmkn());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktnmKj2ValidateErrUmu)) {
                                uketorinin.setUktnmkj(bosUketorinin.getUktnmkj());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktBnktwari2ValidateErrUmu)) {
                                uketorinin.setUktbnwari(bosUketorinin.getUktbnwari());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktseiYmd2ValidateErrUmu)) {
                                uketorinin.setUktseiymd(bosUketorinin.getUktseiymd());
                            }
                        }
                        else if (bosUketorinin.getUktsyurenno() == 3) {
                            if (!C_UmuKbn.ARI.eq(sbUktnmKn3ValidateErrUmu)) {
                                uketorinin.setUktnmkn(bosUketorinin.getUktnmkn());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktnmKj3ValidateErrUmu)) {
                                uketorinin.setUktnmkj(bosUketorinin.getUktnmkj());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktBnktwari3ValidateErrUmu)) {
                                uketorinin.setUktbnwari(bosUketorinin.getUktbnwari());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktseiYmd3ValidateErrUmu)) {
                                uketorinin.setUktseiymd(bosUketorinin.getUktseiymd());
                            }
                        }
                        else if (bosUketorinin.getUktsyurenno() == 4) {
                            if (!C_UmuKbn.ARI.eq(sbUktnmKn4ValidateErrUmu)) {
                                uketorinin.setUktnmkn(bosUketorinin.getUktnmkn());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktnmKj4ValidateErrUmu)) {
                                uketorinin.setUktnmkj(bosUketorinin.getUktnmkj());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktBnktwari4ValidateErrUmu)) {
                                uketorinin.setUktbnwari(bosUketorinin.getUktbnwari());
                            }
                            if (!C_UmuKbn.ARI.eq(sbUktseiYmd4ValidateErrUmu)) {
                                uketorinin.setUktseiymd(bosUketorinin.getUktseiymd());
                            }
                        }
                        uketorinin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        uketorinin.setGyoumuKousinTime(SYSTEMTIME);
                        BizPropertyInitializer.initialize(uketorinin);
                    }
                    else if (C_UktsyuKbn.STDRSK.eq(bosUketorinin.getUktsyukbn())) {
                        HT_Uketorinin uketorinin = syoriCTLSks.createUketorinin();
                        uketorinin.setUktsyukbn(bosUketorinin.getUktsyukbn());
                        uketorinin.setUktsyurenno(bosUketorinin.getUktsyurenno());
                        uketorinin.setUktkbn(bosUketorinin.getUktkbn());
                        if (!C_UmuKbn.ARI.eq(hhkdrnmknValidateErrUmu)) {
                            uketorinin.setUktnmkn(bosUketorinin.getUktnmkn());
                        }
                        if (!C_UmuKbn.ARI.eq(hhkdrnmkjValidateErrUmu)) {
                            uketorinin.setUktnmkj(bosUketorinin.getUktnmkj());
                        }
                        uketorinin.setUktnmkjkhukakbn(bosUketorinin.getUktnmkjkhukakbn());
                        uketorinin.setUkttdk(bosUketorinin.getUkttdk());
                        uketorinin.setUktbnwari(bosUketorinin.getUktbnwari());
                        if (!C_UmuKbn.ARI.eq(hhkdrseiymdValidateErrUmu) ) {
                            uketorinin.setUktseiymd(bosUketorinin.getUktseiymd());
                        }
                        uketorinin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        uketorinin.setGyoumuKousinTime(SYSTEMTIME);
                        BizPropertyInitializer.initialize(uketorinin);
                    }
                    else if (C_UktsyuKbn.NKUKT.eq(bosUketorinin.getUktsyukbn())) {
                        HT_Uketorinin uketorinin = syoriCTLSks.createUketorinin();
                        uketorinin.setUktsyukbn(bosUketorinin.getUktsyukbn());
                        uketorinin.setUktsyurenno(bosUketorinin.getUktsyurenno());
                        uketorinin.setUktkbn(bosUketorinin.getUktkbn());
                        if (!C_UmuKbn.ARI.eq(nkUktnmKnValidateErrUmu)) {
                            uketorinin.setUktnmkn(bosUketorinin.getUktnmkn());
                        }
                        if (!C_UmuKbn.ARI.eq(nkUktnmKjValidateErrUmu)) {
                            uketorinin.setUktnmkj(bosUketorinin.getUktnmkj());
                        }
                        uketorinin.setUktnmkjkhukakbn(bosUketorinin.getUktnmkjkhukakbn());
                        uketorinin.setUkttdk(bosUketorinin.getUkttdk());
                        uketorinin.setUktbnwari(bosUketorinin.getUktbnwari());
                        if (!C_UmuKbn.ARI.eq(nkUktseiYmdValidateErrUmu)) {
                            uketorinin.setUktseiymd(bosUketorinin.getUktseiymd());
                        }
                        uketorinin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        uketorinin.setGyoumuKousinTime(SYSTEMTIME);
                        BizPropertyInitializer.initialize(uketorinin);
                    }
                    else if (C_UktsyuKbn.KYKDRN.eq(bosUketorinin.getUktsyukbn())) {
                        HT_Uketorinin uketorinin = syoriCTLSks.createUketorinin();
                        uketorinin.setUktsyukbn(bosUketorinin.getUktsyukbn());
                        uketorinin.setUktsyurenno(bosUketorinin.getUktsyurenno());
                        uketorinin.setUktkbn(bosUketorinin.getUktkbn());
                        uketorinin.setUktbnwari(bosUketorinin.getUktbnwari());
                        uketorinin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        uketorinin.setGyoumuKousinTime(SYSTEMTIME);
                        BizPropertyInitializer.initialize(uketorinin);
                    }
                }
            }

            for (HT_BosSyouhn bosSyouhn : bosSyouhnLst) {
                HT_MosSyouhn mosSyouhn = syoriCTLSks.createMosSyouhn();
                mosSyouhn.setSyouhncd(bosSyouhn.getSyouhncd());
                mosSyouhn.setSyouhnsdno(0);
                mosSyouhn.setSyutkkbn(bosSyouhn.getSyutkkbn());
                mosSyouhn.setSknenkinsyu(bosSyouhn.getSknenkinsyu());
                if (!C_UmuKbn.ARI.eq(syuKihonKingakuValidateErrUmu)) {
                    mosSyouhn.setKihons(bosSyouhn.getKihons());
                }
                if (!C_UmuKbn.ARI.eq(mossyukykpValidateErrUmu)) {
                    mosSyouhn.setHrktuukasyutkp(bosSyouhn.getHrktuukasyutkp());
                }
                if (!C_UmuKbn.ARI.eq(hknKknValidateErrUmu)) {
                    mosSyouhn.setHknkkn(bosSyouhn.getHknkkn());
                }
                if (!C_UmuKbn.ARI.eq(hrkKknValidateErrUmu)) {
                    mosSyouhn.setHrkkkn(bosSyouhn.getHrkkkn());
                }
                mosSyouhn.setHknkknsmnkbn(bosSyouhn.getHknkknsmnkbn());
                mosSyouhn.setHrkkknsmnkbn(bosSyouhn.getHrkkknsmnkbn());
                mosSyouhn.setDai1hknkkn(bosSyouhn.getDai1hknkkn());
                mosSyouhn.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                mosSyouhn.setGyoumuKousinTime(SYSTEMTIME);

                BizPropertyInitializer.initialize(mosSyouhn);

                if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {
                    mosSyouhnSyokyk = mosSyouhn;
                }
            }
            sinkeiyakuDomManager.flush();

            for (HT_BosDairiten bosDairiten : bosDairitenLst) {
                if (bosDairiten.getRenno() == 1) {
                    HT_MosDairiten mosDairiten = syoriCTLSks.createMosDairiten();
                    mosDairiten.setRenno(1);
                    if (!C_UmuKbn.ARI.eq(dairitenKinyuukikanCd1ValidateErrUmu)) {
                        mosDairiten.setKinyuucd(bosDairiten.getKinyuucd());
                    }
                    if (!C_UmuKbn.ARI.eq(dairitenKinyuukikanSitencd1ValidateErrUmu)) {
                        mosDairiten.setKinyuusitencd(bosDairiten.getKinyuusitencd());
                    }
                    if (!C_UmuKbn.ARI.eq(bosyuuninTourokuNo1ValidateErrUmu)) {
                        mosDairiten.setBosyuutrkno(bosDairiten.getBosyuutrkno());
                    }
                    if (!C_UmuKbn.ARI.eq(cifcdValidateErrUmu)) {
                        mosDairiten.setCifcd(bosDairiten.getCifcd());
                    }
                    if (!C_UmuKbn.ARI.eq(dairitenBuntanWariai1ValidateErrUmu)) {
                        mosDairiten.setBunwari(bosDairiten.getBunwari());
                    }
                    mosDairiten.setYuuseikbn(bosDairiten.getYuuseikbn());
                    mosDairiten.setKyokusyocd(bosDairiten.getKyokusyocd());
                    mosDairiten.setYuuseisyainno(bosDairiten.getYuuseisyainno());
                    mosDairiten.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    mosDairiten.setGyoumuKousinTime(SYSTEMTIME);

                    BizPropertyInitializer.initialize(mosDairiten);
                }

                if (bosDairiten.getRenno() == 2) {
                    HT_MosDairiten mosDairiten = syoriCTLSks.createMosDairiten();
                    mosDairiten.setRenno(2);
                    if (!C_UmuKbn.ARI.eq(inputbosyuucd2ValidateErrUmu)) {
                        mosDairiten.setInputbosyuucd(bosDairiten.getInputbosyuucd());
                    }
                    mosDairiten.setYuuseikbn(bosDairiten.getYuuseikbn());
                    mosDairiten.setKyokusyocd(bosDairiten.getKyokusyocd());
                    mosDairiten.setYuuseisyainno(bosDairiten.getYuuseisyainno());
                    mosDairiten.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    mosDairiten.setGyoumuKousinTime(SYSTEMTIME);

                    BizPropertyInitializer.initialize(mosDairiten);
                }
            }

            if (bosKokutisyo != null) {
                HT_Kokutisyo kokutisyo = syoriCTLSks.createKokutisyo();
                if (!C_UmuKbn.ARI.eq(kktYmdValidateErrUmu)) {
                    kokutisyo.setKktymd(bosKokutisyo.getKktymd());
                }
                if (!C_UmuKbn.ARI.eq(sintyouValidateErrUmu)) {
                    kokutisyo.setSintyou(bosKokutisyo.getSintyou());
                }
                if (!C_UmuKbn.ARI.eq(taijyuuValidateErrUmu)) {
                    kokutisyo.setTaijyuu(bosKokutisyo.getTaijyuu());
                }

                kokutisyo.setKijikbn(bosKokutisyo.getKijikbn());

                kokutisyo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                kokutisyo.setGyoumuKousinTime(SYSTEMTIME);

                BizPropertyInitializer.initialize(kokutisyo);
            }

            if (bosKouzaJyouhou != null) {

                if (C_KzhuritourokuhouKbn.PPLESS.eq(bosKouzaJyouhou.getKzhuritourokuhoukbn())) {
                    syoriCTLSks.setKznrkumu(C_UmuKbn.ARI);
                }

                if (C_KzhuritourokuhouKbn.QR.eq(bosKouzaJyouhou.getKzhuritourokuhoukbn())) {
                    syoriCTLSks.setKznrkhbumu(C_UmuKbn.ARI);
                }

                HT_KouzaJyouhou kouzaJyouhou = syoriCTLSks.createKouzaJyouhou();
                if (!C_UmuKbn.ARI.eq(kyknmKnValidateErrUmu)) {
                    kouzaJyouhou.setKzmeiginmkn(bosKouzaJyouhou.getKzmeiginmkn());
                }
                kouzaJyouhou.setKzkykdoukbn(bosKouzaJyouhou.getKzkykdoukbn());
                if (!C_UmuKbn.ARI.eq(dairitenKinyuukikanCd1ValidateErrUmu)) {
                    kouzaJyouhou.setBankcd(bosKouzaJyouhou.getBankcd());
                }
                if (!C_UmuKbn.ARI.eq(kouhurikouzainfoSitencdValidateErrUmu)) {
                    kouzaJyouhou.setSitencd(bosKouzaJyouhou.getSitencd());
                }
                kouzaJyouhou.setYokinkbn(bosKouzaJyouhou.getYokinkbn());
                if (!C_UmuKbn.ARI.eq(kouhurikouzainfoKouzanoValidateErrUmu)) {
                    kouzaJyouhou.setKouzano(bosKouzaJyouhou.getKouzano());
                }
                kouzaJyouhou.setSinkeizkkbn(C_SinkeizkKbn.SHINKI);

                if (C_KzhuritourokuhouKbn.PPLESS.eq(bosKouzaJyouhou.getKzhuritourokuhoukbn()) ||
                    C_KzhuritourokuhouKbn.SYOMEN.eq(bosKouzaJyouhou.getKzhuritourokuhoukbn())) {
                    kouzaJyouhou.setSyuudaikocd(C_Syuudaikocd.SIS);
                }
                else if (C_KzhuritourokuhouKbn.QR.eq(bosKouzaJyouhou.getKzhuritourokuhoukbn())) {
                    kouzaJyouhou.setSyuudaikocd(C_Syuudaikocd.CSS);
                }

                kouzaJyouhou.setKouzakakuniniraikbn(bosKouzaJyouhou.getKouzakakuniniraikbn());
                if (C_KzhuritourokuhouKbn.PPLESS.eq(bosKouzaJyouhou.getKzhuritourokuhoukbn())) {
                    kouzaJyouhou.setKouzajyouhounyuuryokuymd(syoriCTLSks.getMosnrkymd());
                }
                kouzaJyouhou.setKzhuritourokuhoukbn(bosKouzaJyouhou.getKzhuritourokuhoukbn());

                kouzaJyouhou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                kouzaJyouhou.setGyoumuKousinTime(SYSTEMTIME);

                BizPropertyInitializer.initialize(kouzaJyouhou);
            }

            if (bosUketoriKouzaJyouhouLst.size() != 0) {
                for (HT_BosUketoriKouzaJyouhou bosUketoriKouzaJyouhou : bosUketoriKouzaJyouhouLst) {
                    if (C_UketorikouzasyubetuKbn.DSSOUKINYOUKOUZA.eq(bosUketoriKouzaJyouhou.getUktkzsyubetukbn())) {
                        HT_UketoriKouzaJyouhou uketoriKouzaJyouhou = syoriCTLSks.createUketoriKouzaJyouhou();
                        uketoriKouzaJyouhou.setUktkzsyubetukbn(bosUketoriKouzaJyouhou.getUktkzsyubetukbn());
                        uketoriKouzaJyouhou.setKouzainfoinputhoryuukbn(bosUketoriKouzaJyouhou.getKouzainfoinputhoryuukbn());
                        uketoriKouzaJyouhou.setKzsyuruikbn(bosUketoriKouzaJyouhou.getKzsyuruikbn());
                        if (!C_UmuKbn.ARI.eq(dsBankcdValidateErrUmu)) {
                            uketoriKouzaJyouhou.setBankcd(bosUketoriKouzaJyouhou.getBankcd());
                        }
                        if (!C_UmuKbn.ARI.eq(dsSitencdValidateErrUmu)) {
                            uketoriKouzaJyouhou.setSitencd(bosUketoriKouzaJyouhou.getSitencd());
                        }
                        uketoriKouzaJyouhou.setYokinkbn(bosUketoriKouzaJyouhou.getYokinkbn());
                        if (!C_UmuKbn.ARI.eq(dsKouzanoValidateErrUmu)) {
                            uketoriKouzaJyouhou.setKouzano(bosUketoriKouzaJyouhou.getKouzano());
                        }
                        uketoriKouzaJyouhou.setKzkykdoukbn(bosUketoriKouzaJyouhou.getKzkykdoukbn());
                        if (!C_UmuKbn.ARI.eq(dsKzmeiginmknValidateErrUmu)) {
                            uketoriKouzaJyouhou.setKzmeiginmkn(bosUketoriKouzaJyouhou.getKzmeiginmkn());
                        }
                        uketoriKouzaJyouhou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        uketoriKouzaJyouhou.setGyoumuKousinTime(SYSTEMTIME);
                        BizPropertyInitializer.initialize(uketoriKouzaJyouhou);
                    }
                }
            }

            if (bosTrkKzkLst.size() != 0) {
                HT_BosTrkKzk bosTrkKzk = bosTrkKzkLst.get(0);

                HT_MosTrkKzk mosTrkKzk = syoriCTLSks.createMosTrkKzk();
                mosTrkKzk.setTrkkzkkbn(bosTrkKzk.getTrkkzkkbn());
                if (!C_UmuKbn.ARI.eq(trkkzknmkn1ValidateErrUmu)) {
                    mosTrkKzk.setTrkkzknmkn(bosTrkKzk.getTrkkzknmkn());
                }
                if (!C_UmuKbn.ARI.eq(trkkzknmkj1ValidateErrUmu)) {
                    mosTrkKzk.setTrkkzknmkj(bosTrkKzk.getTrkkzknmkj());
                }
                mosTrkKzk.setTrkkzknmkjkhukakbn(bosTrkKzk.getTrkkzknmkjkhukakbn());
                if (!C_UmuKbn.ARI.eq(trkkzkseiymd1ValidateErrUmu)) {
                    mosTrkKzk.setTrkkzkseiymd(bosTrkKzk.getTrkkzkseiymd());
                }
                mosTrkKzk.setTrkkzksei(bosTrkKzk.getTrkkzksei());
                mosTrkKzk.setTrkkzktdk(bosTrkKzk.getTrkkzktdk());
                mosTrkKzk.setTrkkzktsindousiteikbn(bosTrkKzk.getTrkkzktsindousiteikbn());
                if (!C_UmuKbn.ARI.eq(trkkzkyno1ValidateErrUmu)) {
                    mosTrkKzk.setTrkkzkyno(bosTrkKzk.getTrkkzkyno());
                }
                if (!C_UmuKbn.ARI.eq(trkkzkadr1kj1ValidateErrUmu) &&
                    !C_UmuKbn.ARI.eq(trkkzkadr2kj1ValidateErrUmu) &&
                    !C_UmuKbn.ARI.eq(trkkzkadr3kj1ValidateErrUmu)) {
                    mosTrkKzk.setTrkkzkadr1kj(bosTrkKzk.getTrkkzkadr1kj());
                    mosTrkKzk.setTrkkzkadr2kj(bosTrkKzk.getTrkkzkadr2kj());
                    mosTrkKzk.setTrkkzkadr3kj(bosTrkKzk.getTrkkzkadr3kj());
                }
                if (!C_UmuKbn.ARI.eq(trkkzktelno1ValidateErrUmu)) {
                    mosTrkKzk.setTrkkzktelno(bosTrkKzk.getTrkkzktelno());
                }
                mosTrkKzk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                mosTrkKzk.setGyoumuKousinTime(SYSTEMTIME);
                BizPropertyInitializer.initialize(mosTrkKzk);
            }

            boolean checkFlg = true;
            if (!C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)
                || (C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn) && C_UmuKbn.NONE.eq(mosnrkErrUmu))) {
                if (mosKihon.getMosymd() == null && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;

                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "申込日", bosKihon.getMosno()));
                }

                if (C_KykKbn.BLNK.eq(mosKihon.getKykkbn()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "契約者区分", bosKihon.getMosno()));
                }

                if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn()) && checkFlg == true) {
                    if (BizUtil.isBlank(mosKihon.getKyknmkn())) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "契約者名（カナ）",
                            bosKihon.getMosno()));
                    }

                }

                if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn()) && checkFlg == true) {
                    if (mosKihon.getKykseiymd() == null) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "契約者生年月日",
                            bosKihon.getMosno()));
                    }

                }

                if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn()) && checkFlg == true) {
                    if (C_Kyksei.BLNK.eq(mosKihon.getKyksei())) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "契約者性別", bosKihon.getMosno()));
                    }

                }

                if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn()) && checkFlg == true) {
                    if (C_Tdk.BLNK.eq(mosKihon.getKyktdk())) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "契約者続柄", bosKihon.getMosno()));
                    }

                }

                if (BizUtil.isBlank(mosKihon.getTsinyno()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "通信先郵便番号", bosKihon.getMosno()));
                }

                if (BizUtil.isBlank(mosKihon.getTsinadr1kj()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "通信先住所１（漢字）",
                        bosKihon.getMosno()));
                }

                if (BizUtil.isBlank(mosKihon.getTsintelno()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "通信先電話番号", bosKihon.getMosno()));
                }

                if (BizUtil.isBlank(mosKihon.getHhknnmkn()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "被保険者名（カナ）",
                        bosKihon.getMosno()));
                }

                if (mosKihon.getHhknseiymd() == null && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "被保険者生年月日",
                        bosKihon.getMosno()));
                }

                if (C_Hhknsei.BLNK.eq(mosKihon.getHhknsei()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "被保険者性別", bosKihon.getMosno()));
                }

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyokugyoukktumu()) && checkFlg == true) {
                    if (mosKihon.getKktymd() == null) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "職業告知日", bosKihon.getMosno()));
                    }
                }
                else {
                    if (mosKihon.getKktymd() != null && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "職業告知日", bosKihon.getMosno()));
                    }
                }

                if (BizUtil.isBlank(mosKihon.getHhknsykgycd()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "被保険者職業コード", bosKihon.getMosno()));
                }

                if (!C_UmuKbn.ARI.eq(syouhnZokusei.getItijibrumu()) &&
                    !C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu()) &&
                    checkFlg == true) {
                    if (C_NensyuuKbn.BLNK.eq(mosKihon.getHhknnensyuukbn())) {

                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "被保険者年収区分", bosKihon.getMosno()));
                    }
                }

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu()) && checkFlg == true) {
                    if (bosUketorininLst.size() > 0) {
                        for (HT_BosUketorinin tempBosUketorinin : bosUketorininLst) {
                            if (C_UktsyuKbn.NKUKT.eq(tempBosUketorinin.getUktsyukbn())) {
                                if (C_UktKbn.BLNK.eq(tempBosUketorinin.getUktkbn())) {
                                    mosnrkErrUmu = C_UmuKbn.ARI;
                                    checkFlg = false;
                                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "年金受取人区分",
                                        bosKihon.getMosno()));
                                    break;
                                }
                            }

                        }
                    }
                    else {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "年金受取人区分",
                            bosKihon.getMosno()));
                    }
                }
                else {
                    if (bosUketorininLst.size() > 0 && checkFlg == true) {
                        for (HT_BosUketorinin tempBosUketorinin : bosUketorininLst) {
                            if (C_UktsyuKbn.NKUKT.eq(tempBosUketorinin.getUktsyukbn())) {
                                mosnrkErrUmu = C_UmuKbn.ARI;
                                checkFlg = false;
                                batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "年金受取人区分",
                                    bosKihon.getMosno()));
                                break;
                            }
                        }
                    }

                }

                if (C_Sdpd.BLNK.eq(mosKihon.getSdpdkbn()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "Ｓ建Ｐ建区分", bosKihon.getMosno()));
                }

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getGaikatatkiumu())) {
                    if (C_Tuukasyu.BLNK.eq(mosKihon.getKyktuukasyu())
                        && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "契約通貨種類",
                            bosKihon.getMosno()));
                    }

                    if (C_Tuukasyu.BLNK.eq(mosKihon.getHrktuukasyu()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "払込通貨種類",
                            bosKihon.getMosno()));
                    }
                }
                else {
                    if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "契約通貨種類",
                            bosKihon.getMosno()));
                    }

                    if (!C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "払込通貨種類",
                            bosKihon.getMosno()));
                    }
                }

                if (checkFlg) {
                    if (C_UmuKbn.NONE.eq(syouhnZokusei.getHokenkngkyakujyouumu())) {

                        if (mosSyouhnSyokyk.getKihons() != null && !BizUtil.isZero(mosSyouhnSyokyk.getKihons())) {
                            mosnrkErrUmu = C_UmuKbn.ARI;
                            checkFlg = false;
                            batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "主契約基本保険金額",
                                bosKihon.getMosno()));
                        }
                    }
                    else {
                        if ((mosSyouhnSyokyk.getKihons() == null || BizUtil.isZero(mosSyouhnSyokyk.getKihons()))) {
                            mosnrkErrUmu = C_UmuKbn.ARI;
                            checkFlg = false;
                            batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "主契約基本保険金額",
                                bosKihon.getMosno()));
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getGaikatatkiumu())) {
                    if ((mosSyouhnSyokyk.getHrktuukasyutkp() == null || BizUtil.isZero(mosSyouhnSyokyk.
                        getHrktuukasyutkp())) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "申込主契約Ｐ",
                            bosKihon.getMosno()));
                    }
                }
                else {
                    if (mosSyouhnSyokyk.getHrktuukasyutkp() != null && !BizUtil.isZero(mosSyouhnSyokyk.
                        getHrktuukasyutkp()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "申込主契約Ｐ",
                            bosKihon.getMosno()));
                    }
                }

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu()) && checkFlg == true) {
                    if (C_Sknenkinsyu.BLNK.eq(mosSyouhnSyokyk.getSknenkinsyu())) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "新契約年金種類",
                            bosKihon.getMosno()));
                    }
                }
                else {
                    if (!C_Sknenkinsyu.BLNK.eq(mosSyouhnSyokyk.getSknenkinsyu()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "新契約年金種類",
                            bosKihon.getMosno()));
                    }
                }

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getJyudkaigomehrtktekiumu())) {
                    if (C_Tkhukaumu.BLNK.eq(mosKihon.getJyudkaigomehrtkhkkbn()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059,
                            "重度介護前払特約付加区分", bosKihon.getMosno()));
                    }
                }
                else {
                    if (!C_Tkhukaumu.BLNK.eq(mosKihon.getJyudkaigomehrtkhkkbn()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059,
                            "重度介護前払特約付加区分", bosKihon.getMosno()));
                    }
                }

                if (C_Nstkumu.ST_ARI.eq(syouhnZokusei.getNstkumu())) {
                    if (C_Tkhukaumu.BLNK.eq(mosKihon.getNstkhkkbn()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "年金支払特約付加区分",
                            bosKihon.getMosno()));
                    }

                    if (C_Tkhukaumu.NONE.eq(mosKihon.getNstkhkkbn()) && checkFlg == true) {
                        if (mosKihon.getNstksbnkkn() != null && mosKihon.getNstksbnkkn() != 0) {
                            mosnrkErrUmu = C_UmuKbn.ARI;
                            checkFlg = false;
                            batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "年金支払特約死亡年金期間",
                                bosKihon.getMosno()));
                        }
                    }

                    if (C_Tkhukaumu.HUKA.eq(mosKihon.getNstkhkkbn()) && checkFlg == true) {
                        if (mosKihon.getNstksbnkkn() == null || mosKihon.getNstksbnkkn() == 0) {
                            mosnrkErrUmu = C_UmuKbn.ARI;
                            checkFlg = false;
                            batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "年金支払特約死亡年金期間",
                                bosKihon.getMosno()));
                        }
                    }
                }
                else {
                    if (!C_Tkhukaumu.BLNK.eq(mosKihon.getNstkhkkbn()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "年金支払特約付加区分",
                            bosKihon.getMosno()));
                    }
                    if (mosKihon.getNstksbnkkn() != null && mosKihon.getNstksbnkkn() != 0 && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "年金支払特約死亡年金期間",
                            bosKihon.getMosno()));
                    }

                }

                if (!C_TargetTkHukaKanouKbn.NONE.eq(syouhnZokusei.getTargettkhukakanoukbn())) {

                    if (C_Tkhukaumu.BLNK.eq(mosKihon.getTargettkhkkbn()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約付加区分",
                            bosKihon.getMosno()));
                    }

                    if (C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())) {
                        if (C_TargetTkKbn.BLNK.eq(mosKihon.getTargettkkbn()) && checkFlg == true) {
                            mosnrkErrUmu = C_UmuKbn.ARI;
                            checkFlg = false;
                            batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約区分",
                                bosKihon.getMosno()));
                        }
                        else {
                            if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyuusinhknumu()) && checkFlg == true) {
                                if (!C_TargetTkKbn.SYUUSIN.eq(mosKihon.getTargettkkbn())) {
                                    mosnrkErrUmu = C_UmuKbn.ARI;
                                    checkFlg = false;
                                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約区分",
                                        bosKihon.getMosno()));
                                }
                            }

                            if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu()) && checkFlg == true) {
                                if (!C_TargetTkKbn.NENKIN.eq(mosKihon.getTargettkkbn())) {
                                    mosnrkErrUmu = C_UmuKbn.ARI;
                                    checkFlg = false;
                                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約区分",
                                        bosKihon.getMosno()));
                                }
                            }
                        }
                    }
                    else {
                        if (!C_TargetTkKbn.BLNK.eq(mosKihon.getTargettkkbn()) && checkFlg == true) {
                            mosnrkErrUmu = C_UmuKbn.ARI;
                            checkFlg = false;
                            batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約区分",
                                bosKihon.getMosno()));
                        }
                    }

                    if (C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())) {
                        if (C_TargetTkMokuhyoutiKbn.BLNK.eq(mosKihon.getTargettkmkhtkbn()) && checkFlg == true) {
                            mosnrkErrUmu = C_UmuKbn.ARI;
                            checkFlg = false;
                            batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約目標値区分",
                                bosKihon.getMosno()));
                        }
                    }
                    else {
                        if (!C_TargetTkMokuhyoutiKbn.BLNK.eq(mosKihon.getTargettkmkhtkbn()) && checkFlg == true) {
                            mosnrkErrUmu = C_UmuKbn.ARI;
                            checkFlg = false;
                            batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約目標値区分",
                                bosKihon.getMosno()));
                        }
                    }
                }
                else {
                    if (!C_Tkhukaumu.BLNK.eq(mosKihon.getTargettkhkkbn()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約付加区分",
                            bosKihon.getMosno()));
                    }

                    if (!C_TargetTkKbn.BLNK.eq(mosKihon.getTargettkkbn()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約区分",
                            bosKihon.getMosno()));
                    }

                    if (!C_TargetTkMokuhyoutiKbn.BLNK.eq(mosKihon.getTargettkmkhtkbn()) && checkFlg == true) {
                        mosnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ターゲット特約目標値区分",
                            bosKihon.getMosno()));
                    }
                }

                if (C_DirectServiceMosKbn.BLNK.eq(mosKihon.getDrctservicemoskbn()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "ダイレクトサービス申込区分",
                        bosKihon.getMosno()));
                }

                if (C_HonninkakuninSyoruiKbn.BLNK.eq(mosKihon.getKykhonninkakninsyoruikbn()) && checkFlg == true) {
                    mosnrkErrUmu = C_UmuKbn.ARI;
                    checkFlg = false;
                    batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "契約者本人確認書類区分",
                        bosKihon.getMosno()));
                }
            }

            if (!C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)
                || (C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn) && C_UmuKbn.NONE.eq(kktnrkErrUmu))) {
                if (C_UmuKbn.ARI.eq(syouhnZokusei.getKktumu()) && syoriCTLSks.getKokutisyo() != null) {
                    if (syoriCTLSks.getKokutisyo().getSintyou() == 0 && checkFlg == true) {
                        kktnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "身長", bosKihon.getMosno()));
                    }
                    if (syoriCTLSks.getKokutisyo().getTaijyuu() == 0 && checkFlg == true) {
                        kktnrkErrUmu = C_UmuKbn.ARI;
                        checkFlg = false;
                        batchLogger.info(MessageUtil.getMessage(MessageId.EHA1059, "体重", bosKihon.getMosno()));
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(mosnrkErrUmu) || C_UmuKbn.ARI.eq(kktnrkErrUmu)) {
                mosUktkErrKbn = C_MosUktkErrKbn.PPLESSUKTKERROR;
            }

            syoriCTLSks.setMosuktkerrkbn(mosUktkErrKbn);

            if (C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)) {
                if (C_UmuKbn.ARI.eq(mosnrkErrUmu)) {
                    syoriCTLSks.setMosnrkumu(C_UmuKbn.NONE);
                    syoriCTLSks.setMosnrkvrfjkkbn(C_VrfjkKbn.SANJINRKMATI);
                    syoriCTLSks.setMosnrkymd(null);

                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getKktumu())) {
                        syoriCTLSks.setKktnrkumu(C_UmuKbn.NONE);
                        syoriCTLSks.setKktnrkvrfjkkbn(C_VrfjkKbn.SANJINRKMATI);
                    }

                    if (BizUtil.isBlank(mosKihon.getKhnchkcmnt())) {
                        mosKihon.setKhnchkcmnt(
                            "ペーパーレス申込入力で項目チェックエラーにより申込書入力　新規（３次）対象" + "　");
                    }
                    else {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() +
                            "ペーパーレス申込入力で項目チェックエラーにより申込書入力　新規（３次）対象" + "　");
                    }
                    if (C_UmuKbn.ARI.eq(kykKinmusakiNmValidateErrUmu)) {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() + "契約者勤務先名" + "　");
                    }
                    if (C_UmuKbn.ARI.eq(pplessmosukeYmdValidateErrUmu)) {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() + "ペーパーレス申込書受付日" + "　");
                    }
                    if (C_UmuKbn.ARI.eq(hhknKinmusakiNmValidateErrUmu)) {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() + "被保険者勤務先名" + "　");
                    }
                    if (C_UmuKbn.ARI.eq(dsmailaddressValidateErrUmu)) {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() + "ＤＳメールアドレス" + "　");
                    }
                    if (C_UmuKbn.ARI.eq(dsBankcdValidateErrUmu)) {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() + "ＤＳ銀行コード" + "　");
                    }
                    if (C_UmuKbn.ARI.eq(dsSitencdValidateErrUmu)) {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() + "ＤＳ支店コード" + "　");
                    }
                    if (C_UmuKbn.ARI.eq(dsKouzanoValidateErrUmu)) {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() + "ＤＳ口座番号" + "　");
                    }
                    if (C_UmuKbn.ARI.eq(dsKzmeiginmknValidateErrUmu)) {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() + "ＤＳ口座名義人氏名（カナ）" + "　");
                    }
                }
                else {
                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getKktumu())) {
                        syoriCTLSks.setKktnrkumu(C_UmuKbn.NONE);
                        syoriCTLSks.setKktnrkvrfjkkbn(C_VrfjkKbn.SANJINRKMATI);
                    }

                    if (BizUtil.isBlank(mosKihon.getKhnchkcmnt())) {
                        mosKihon.setKhnchkcmnt(
                            "ペーパーレス申込入力で項目チェックエラーにより告知書入力　新規（３次）対象" + "　");
                    }
                    else {
                        mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt() +
                            "ペーパーレス申込入力で項目チェックエラーにより告知書入力　新規（３次）対象" + "　");
                    }
                }

                if (mosKihon.getKhnchkcmnt().endsWith("　")) {
                    mosKihon
                    .setKhnchkcmnt(mosKihon.getKhnchkcmnt().substring(0, mosKihon.getKhnchkcmnt().length() - 1));
                }

                if (mosKihon.getKhnchkcmnt().length() > 80) {
                    mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt().substring(0, 40) + "\r\n"
                        + mosKihon.getKhnchkcmnt().substring(40, 80) + "\r\n"
                        + mosKihon.getKhnchkcmnt().substring(80, mosKihon.getKhnchkcmnt().length()));
                }
                else if (mosKihon.getKhnchkcmnt().length() > 40)
                {
                    mosKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt().substring(0, 40) + "\r\n"
                        + mosKihon.getKhnchkcmnt().substring(40, mosKihon.getKhnchkcmnt().length()));
                }
            }

            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
            if (!C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)
                || (C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn) && C_UmuKbn.NONE.eq(mosnrkErrUmu))) {

                if (C_Hrkkeiro.CREDIT.eq(bosKihon.getHrkkeiro())) {

                    HT_CreditCardJyouhou creditCardJyouhou = syoriCTLSks.createCreditCardJyouhou();

                    if (C_PplessrendoucreditkousouKbn.ARI.eq(bosKihon.getPplessrendoucreditkousoukbn())) {
                        SaibanCreditKessaiyouNo sbCreditKessaiyouNo = SWAKInjector.getInstance(SaibanCreditKessaiyouNo.class);
                        String creditKessaiyouNo = sbCreditKessaiyouNo.exec(C_CreditCardKeySyuruiKbn.MOSNO, syoriCTLSks.getMosno());

                        creditCardJyouhou.setCreditkessaiyouno(creditKessaiyouNo);
                        creditCardJyouhou.setCredittrkhoukbn(C_CreditTrkhouKbn.SYOMEN);
                    }
                    else {
                        creditCardJyouhou.setCredittrkhoukbn(C_CreditTrkhouKbn.QR);
                    }
                    creditCardJyouhou.setCardbrandkbn(C_CardBrandKbn.BLNK);
                    creditCardJyouhou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    creditCardJyouhou.setGyoumuKousinTime(SYSTEMTIME);
                    BizPropertyInitializer.initialize(creditCardJyouhou);

                    syoriCTLSks.setCredittrkjkkbn(C_CreditTrkjkKbn.TOUROKUTYUU);
                }

                mosnaiCheckParam.setDataSyoriControl(syoriCTLSks);
                mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
                mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
                mosnaiCheckParam.setKetteiSijiKbn(C_HandketsijiKbn.HUYOU);

                BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);
                if (gyoumuKouteiInfo == null) {
                    throw new CommonBizAppException("申込番号=" + mosKihon.getMosno());
                }
                mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
                mosnaiCheckParam.setKinouID(kinou.getKinouId());
                mosnaiCheckParam.setSysDate(syoriYmd);
                mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
                mosnaiCheckParam.setKosTime(SYSTEMTIME);
                mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

                mosnaiCheckParam.debug("ペーパーレス申込入力");
                mosnaiCheck.exec(mosnaiCheckParam);

                List<HT_SkDenpyoData> denpyoDataList = mosnaiCheckParam.getListSkDenpyoData();
                if (denpyoDataList.size() > 0) {
                    sinkeiyakuDomManager.insert(denpyoDataList);
                }
            }

            List<HT_MosDairiten> mosDairitenLst = syoriCTLSks.getMosDairitens();
            for (HT_MosDairiten mosDairiten : mosDairitenLst) {

                if (mosDairiten.getRenno() == 1) {
                    if (!BizUtil.isBlank(mosDairiten.getOyadrtencd())) {
                        getSkChannelInfo.exec(null, mosDairiten.getOyadrtencd());
                        mosKihon.setAisyoumeikbn((getHknsyuruinm.setAisyoumeikbn(mosKihon.getHknsyuruino().getValue(),
                            mosKihon.getHknsyuruinosd(), getSkChannelInfo.getAisyoumeiChannelKbn(),
                            syouhnZokusei.getSyouhncd())).getAisyoumeikbn());
                        mosDairiten.setBsyujoyadrtencd(mosDairiten.getOyadrtencd());
                    }
                }

                if (mosDairiten.getRenno() == 2) {
                    mosDairiten.setBsyujoyadrtencd(mosDairiten.getOyadrtencd());
                }
            }
            if (!C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)
                || (C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn) && C_UmuKbn.NONE.eq(mosnrkErrUmu))) {
                sinkeiyakuDomManager.insert(syoriCTLSks);
                bizDomManager.update(mosnaiCheckParam.getGyoumuKouteiInfo());
            }
            else {
                sinkeiyakuDomManager.insert(syoriCTLSks);
            }

            bosKihon.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.TOUROKUZUMI);
            bosKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            bosKihon.setGyoumuKousinTime(SYSTEMTIME);
            sinkeiyakuDomManager.update(bosKihon);

            skProcessUpdate.exec(syoriCTLSks, bzLockProcessOutBean.getKouteiLockKey(), null);
            iwfCoreDomManager.flush();

            SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
            skProcessForwardInBean.setMosNo(bosKihon.getMosno());
            skProcessForwardInBean.setTskNm("ペーパーレス申込入力");
            skProcessForwardInBean.setKouteiLockkey(bzLockProcessOutBean.getKouteiLockKey());
            skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
            skProcessForwardPaperlessMousikomi.kouteiSeni(skProcessForwardInBean);
            iwfCoreDomManager.flush();

            if (!C_MosUktkErrKbn.PPLESSUKTKERROR.eq(mosUktkErrKbn)) {
                SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTLSks);
                if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                    for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {
                        errorMessageCollector.addMessage(errorMsg);
                    }

                    batchLogger.error(MessageUtil.getMessage(MessageId.EHA1058, mosKihon.getMosno()));
                    errorMessageCollector.throwBizLogicException();
                }
            }

            bzUnlockProcess.exec(kouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
                bzLockProcessOutBean.getKouteiLockKey());
            SYORIOKCOUNT = SYORIOKCOUNT + 1;

            BizDate syoruittykymd = getSyoruittykymd.exec(kouteiKanriId,
                C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO);
            if (syoruittykymd == null) {
                pskeijimuJmrnrkhyouP2 = "1";
            }
        }
        else {
            if ("1".equals(pskeijimuJmrnrkhyouP1)) {
                bosKihon.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.TOUROKUZUMI);
                bosKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                bosKihon.setGyoumuKousinTime(SYSTEMTIME);
                sinkeiyakuDomManager.update(bosKihon);

                bzUnlockProcess.exec(kouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
                    bzLockProcessOutBean.getKouteiLockKey());
            }
        }

        if ("1".equals(pskeijimuJmrnrkhyouP1) || "1".equals(pskeijimuJmrnrkhyouP2)) {
            String hnsyuHzkdate = DateFormatUtil.dateKANJINoEx(syoriYmd);

            SkJimurenrakuhyouBean skJimurenrakuhyouBean = SWAKInjector.getInstance(SkJimurenrakuhyouBean.class);
            skJimurenrakuhyouBean.setIrTyouhyousakuseiymd(hnsyuHzkdate);
            skJimurenrakuhyouBean.setIrMosno(bosKihon.getMosno());
            skJimurenrakuhyouBean.setIrKinounm(kinou.getKinouNm());

            List<IReportDataSouceBean> skJimurenrakuhyouDetailBeanLst = new ArrayList<>();
            if ("1".equals(pskeijimuJmrnrkhyouP1)) {
                String moskmSyuriMsg = "書面";

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean1 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean1.setIrMessage("当契約は、" + moskmSyuriMsg +
                    "申込として既に新契約に取り込み済みです。");
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean1);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean2 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean2.setIrMessage("募集人あてに、電子申込と書面申込のどちらが正当なのか確認のう"
                    + "え、システム部に不要な申込の削除を依頼してください。");
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean2);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean3 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean3.setIrMessage("　");
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean3);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean4 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean4.setIrMessage("＊＊電子申込情報＊＊");
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean4);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean5 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean5.setIrMessage("主契約保険種類名：" +
                    bosKihon.getHknsyuruino().getContent());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean5);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean6 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                String hnsyuHzkdateMosYmd = DateFormatUtil.dateKANJINoEx(bosKihon.getMosymd());
                skJimurenrakuhyouDetailBean6.setIrMessage("申込日：" + hnsyuHzkdateMosYmd);
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean6);

                if (C_KykKbn.KEIHI_DOUITU.eq(bosKihon.getKykkbn())) {
                    SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean7 = SWAKInjector.getInstance(
                        SkJimurenrakuhyouDetailBean.class);
                    skJimurenrakuhyouDetailBean7.setIrMessage("契約者漢字名：" + bosKihon.getHhknnmkj());
                    skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean7);

                    SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean8 = SWAKInjector.getInstance(
                        SkJimurenrakuhyouDetailBean.class);
                    skJimurenrakuhyouDetailBean8.setIrMessage("契約者カナ名：" + bosKihon.getHhknnmkn());
                    skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean8);

                    SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean9 = SWAKInjector.getInstance(
                        SkJimurenrakuhyouDetailBean.class);
                    String hnsyuHzkdateHhknseiYmd = DateFormatUtil.dateKANJIWareki(bosKihon.getHhknseiymd());
                    skJimurenrakuhyouDetailBean9.setIrMessage("契約者契約者生年月日：" + hnsyuHzkdateHhknseiYmd);
                    skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean9);

                    SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean10 = SWAKInjector.getInstance(
                        SkJimurenrakuhyouDetailBean.class);
                    skJimurenrakuhyouDetailBean10.setIrMessage("契約者性別：" + bosKihon.getHhknsei().getContent());
                    skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean10);
                }
                else {
                    SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean7 = SWAKInjector.getInstance(
                        SkJimurenrakuhyouDetailBean.class);
                    skJimurenrakuhyouDetailBean7.setIrMessage("契約者漢字名：" + bosKihon.getKyknmkj());
                    skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean7);

                    SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean8 = SWAKInjector.getInstance(
                        SkJimurenrakuhyouDetailBean.class);
                    skJimurenrakuhyouDetailBean8.setIrMessage("契約者カナ名：" + bosKihon.getKyknmkn());
                    skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean8);

                    SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean9 = SWAKInjector.getInstance(
                        SkJimurenrakuhyouDetailBean.class);
                    String hnsyuHzkdateHhknseiYmd = DateFormatUtil.dateKANJIWareki(bosKihon.getKykseiymd());
                    skJimurenrakuhyouDetailBean9.setIrMessage("契約者生年月日：" + hnsyuHzkdateHhknseiYmd);
                    skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean9);

                    SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean10 = SWAKInjector.getInstance(
                        SkJimurenrakuhyouDetailBean.class);
                    skJimurenrakuhyouDetailBean10.setIrMessage("契約者性別：" + bosKihon.getKyksei().getContent());
                    skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean10);
                }

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean11 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean11.setIrMessage("被保険者漢字名：" + bosKihon.getHhknnmkj());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean11);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean12 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean12.setIrMessage("被保険者カナ名：" + bosKihon.getHhknnmkn());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean12);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean13 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                String hnsyuHzkdateHhknseiYmd = DateFormatUtil.dateKANJIWareki(bosKihon.getHhknseiymd());
                skJimurenrakuhyouDetailBean13.setIrMessage("被保険者契約者生年月日：" + hnsyuHzkdateHhknseiYmd);
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean13);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean14 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean14.setIrMessage("被保険者性別：" + bosKihon.getHhknsei().getContent());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean14);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean15 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean15.setIrMessage("　");
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean15);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean16 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean16.setIrMessage("ＣＩＦコード：" + bosDairitenLst.get(0).getCifcd());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean16);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean17 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean17.setIrMessage("受付管理ＩＤ：" + bosKihon.getUktkid());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean17);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean18 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean18.setIrMessage("事務所コード：" + bosDairitenLst.get(0).getJimusyocd());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean18);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean19 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean19.setIrMessage("金融機関コード：" + bosDairitenLst.get(0).getKinyuucd());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean19);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean20 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean20.setIrMessage("支店コード：" + bosDairitenLst.get(0).getKinyuusitencd());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean20);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean21 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean21.setIrMessage("行員コード：" + bosDairitenLst.get(0).getTratkikouinncd());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean21);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean22 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean22.setIrMessage("個人コード：" + bosDairitenLst.get(0).getInputbosyuucd());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean22);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean23 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean23.setIrMessage("募集人登録番号：" + bosDairitenLst.get(0).getBosyuutrkno());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean23);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean24 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean24.setIrMessage("分担割合：" + bosDairitenLst.get(0).getBunwari());
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean24);
            }
            else if ("1".equals(pskeijimuJmrnrkhyouP2)) {
                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean1 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean1.setIrMessage("当契約は、ペーパーレス申込入力時点で申込書類イメージデータ"
                    + "（告知書データ含む）が未着です。");
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean1);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean2 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean2.setIrMessage("書類到着状況を確認の上、到着後に「申込内容チェック実行」を"
                    + "実施してください。");
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean2);

                SkJimurenrakuhyouDetailBean skJimurenrakuhyouDetailBean3 = SWAKInjector.getInstance(
                    SkJimurenrakuhyouDetailBean.class);
                skJimurenrakuhyouDetailBean3.setIrMessage("※必要書類到着不備が解消されます。　");
                skJimurenrakuhyouDetailBeanLst.add(skJimurenrakuhyouDetailBean3);
            }

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.SK_JIMURENRAKU);
            reportServicesBean.setKensakuKeys(new String[] { mosMikakuteiJyouhouKanri.getSkeijimukbn().getValue(),
                skJimurenrakuhyouBean.getIrMosno() });
            reportServicesBean.setSyoriYmd(syoriYmd);
            reportServicesBean.addParamObjects(skJimurenrakuhyouDetailBeanLst, skJimurenrakuhyouBean);
            createReport.execNoCommit(reportServicesBean);
            JMRNRKHYOUCOUNT = JMRNRKHYOUCOUNT + 1;
        }

        kouteiKanriId = "";

        kouteiLockKey = "";

        bizDomManager.flush();
        iwfCoreDomManager.flush();
    }

    private void unlockProcess() {

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setKouteiKanriId(kouteiKanriId);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.size() != 0 && !BizUtil.isBlank(kouteiLockKey)) {
            bzUnlockProcess.exec(kouteiKanriId, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, kouteiLockKey);
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        unlockProcess();

        bzBatchAbendCommonRecovery.exec();
    }
}