package yuyu.batch.biz.bzkaikei.bzgkhurikominyuukincheck;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Strings;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.SkHurikomiKouzaInfo;
import yuyu.common.biz.bzcommon.SkHurikomiKouzaInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.bean.report.BzGkHurikomiErrInfoListBean;
import yuyu.def.biz.bean.report.BzGkHurikomiErrInfoListDataSourceBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_Gknyknmeisai;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 業務共通 経理・会計 外貨振込入金データチェッククラス
 */
public class BzGkhurikomiNyuukinCheckBatch implements Batch{

    private final String GKNYKNMEISAITABLEID = "BT_Gknyknmeisai";

    private final String GKNYKNMEISAIFILTERID = "Bz102";

    private final String IRIBARAIKBN_NYUKIN = "1";

    private final String IRIBARAIKBN_DEKIN = "2";

    private final String TRHKKBN_GENKIN = "10";

    private final String TRHKKBN_FURIKOMI = "11";

    private final String TRHKKBN_TATENKENNYUKIN = "12";

    private final String TRHKKBN_KOUKAN = "13";

    private final String TRHKKBN_FURIKAU = "14";

    private final String TRHKKBN_SONOTA = "18";

    private final String TRHKKBN_TEISEI = "19";

    private final int STRTRI_START = 0;

    private final int STRTRI_END = 96;

    private final int UPPER_STR = 97;

    private final int SIMUKEBANKNMEIJI_MAX_LENGTH = 70;

    private final int SIMUKETENNMEIJI_MAX_LENGTH = 35;

    private static final int KAHEN_PREFIX_LENGTH = 6;

    private static final int KAHEN_PREFIX_SIZE_INDEX = 3;

    private static final String KAHEN_SOUKINBANK_PREFIX = "BSW";

    private static final String KAHEN_SIMUKEBANK_PREFIX = "BSN";

    private static final String KAHEN_SIMUKESITEN_PREFIX = "BSB";

    private String errorMessage;

    private List<IReportDataSouceBean> bzHurikomiErrInfoListDataSourceBeanLst;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private CreateReport createReport;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String sysTime = BizDate.getSysDateTimeMilli();
        bzHurikomiErrInfoListDataSourceBeanLst = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        try (ExDBResults<BT_Gknyknmeisai> gknyknmeisaiLst = bizDomManager.getGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd(
            bzBatchParam.getIbKakutyoujobcd(), String.valueOf(syoriYmd));
            EntityInserter<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataEntityInserter = new EntityInserter<>()) {

            List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager
                .getHurikomiKouzasByTuukasyuNe(C_Tuukasyu.JPY);

            HT_GaikaHrkmNyknData gaikaHrkmNyknData = null;

            Iterator<BT_Gknyknmeisai> gknyknmeisaiTrIter = gknyknmeisaiLst.iterator();
            while (gknyknmeisaiTrIter.hasNext()) {

                BT_Gknyknmeisai gknyknmeisai = gknyknmeisaiTrIter.next();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(GKNYKNMEISAITABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(GKNYKNMEISAIFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(gknyknmeisai.getHrkmsakuseiymd());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(gknyknmeisai.getHrkmbankcd());

                String hrkmiribaraikbn = gknyknmeisai.getHrkmiribaraikbn();
                String hrkmtrhkkbn = gknyknmeisai.getHrkmtrhkkbn();

                if (!((IRIBARAIKBN_NYUKIN.equals(hrkmiribaraikbn) && (TRHKKBN_GENKIN.equals(hrkmtrhkkbn) ||
                    TRHKKBN_FURIKOMI.equals(hrkmtrhkkbn) || TRHKKBN_TATENKENNYUKIN.equals(hrkmtrhkkbn) ||
                    TRHKKBN_KOUKAN.equals(hrkmtrhkkbn) || TRHKKBN_FURIKAU.equals(hrkmtrhkkbn) ||
                    TRHKKBN_SONOTA.equals(hrkmtrhkkbn))) ||
                    (IRIBARAIKBN_DEKIN.equals(hrkmiribaraikbn) && TRHKKBN_TEISEI.equals(hrkmtrhkkbn)))) {

                    continue;
                }

                boolean taisiyouFlg = false;
                for (HM_HurikomiKouza hurikomiKouza :hurikomiKouzaLst) {

                    String kouzaJyouhouKouzaNo;
                    if(hurikomiKouza.getKouzano().length() < 10){
                        kouzaJyouhouKouzaNo = Strings.padStart(hurikomiKouza.getKouzano(), 10, '0');
                    }
                    else{
                        kouzaJyouhouKouzaNo =  hurikomiKouza.getKouzano();
                    }

                    if (hurikomiKouza.getBankcd().equals(gknyknmeisai.getHrkmbankcd()) &&
                        hurikomiKouza.getSitencd().equals(gknyknmeisai.getHrkmshitencd()) &&
                        kouzaJyouhouKouzaNo.equals(gknyknmeisai.getHrkmkouzano()) &&
                        hurikomiKouza.getTuukasyu().getValue().equals(gknyknmeisai.getHrkmzndktuukasyu())) {

                        taisiyouFlg = true;
                        break;
                    }
                }

                if (!taisiyouFlg) {

                    errorMessage = MessageUtil.getMessage(MessageId.EBF1010,
                        gknyknmeisai.getHrkmbankcd(),
                        gknyknmeisai.getHrkmshitencd(),
                        gknyknmeisai.getHrkmrensakuseiymd(),
                        gknyknmeisai.getHrkmsyorino1(),
                        gknyknmeisai.getHrkmkouzano());

                    BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiLstDaSouBean = SWAKInjector.
                        getInstance(BzGkHurikomiErrInfoListDataSourceBean.class);

                    bzGkHurikomiLstDaSouBean.setIrErrormsg(errorMessage);
                    bzGkHurikomiLstDaSouBean.setIrDatakbn1(gknyknmeisai.getHrkmdatakbn1());
                    bzGkHurikomiLstDaSouBean.setIrSyubetucd(gknyknmeisai.getHrkmsyubetucd());
                    bzGkHurikomiLstDaSouBean.setIrCdkbn(gknyknmeisai.getHrkmcdkbn());
                    bzGkHurikomiLstDaSouBean.setIrSakuseiymd(gknyknmeisai.getHrkmrensakuseiymd());
                    bzGkHurikomiLstDaSouBean.setIrRenrakuymd(gknyknmeisai.getHrkmrenrakuymd());
                    bzGkHurikomiLstDaSouBean.setIrRenrakukaisuu(gknyknmeisai.getHrkmrenrakukaisuu());
                    bzGkHurikomiLstDaSouBean.setIrKnjyymdfrom(gknyknmeisai.getHrkmknjyymdfrom());
                    bzGkHurikomiLstDaSouBean.setIrKnjyymdto(gknyknmeisai.getHrkmknjyymdto());
                    bzGkHurikomiLstDaSouBean.setIrBankcd(gknyknmeisai.getHrkmbankcd());
                    bzGkHurikomiLstDaSouBean.setIrBanknmej(gknyknmeisai.getHrkmbanknmej());
                    bzGkHurikomiLstDaSouBean.setIrSitencdtori(gknyknmeisai.getHrkmsitencdtori());
                    bzGkHurikomiLstDaSouBean.setIrSitennmejtori(gknyknmeisai.getHrkmsitennmejtori());
                    bzGkHurikomiLstDaSouBean.setIrSitencd(gknyknmeisai.getHrkmshitencd());
                    bzGkHurikomiLstDaSouBean.setIrSitennmej(gknyknmeisai.getHrkmsitennmej());
                    bzGkHurikomiLstDaSouBean.setIrYokinkbn(C_YokinKbn.valueOf(gknyknmeisai.getHrkmyokinkbn()));
                    bzGkHurikomiLstDaSouBean.setIrKouzano(gknyknmeisai.getHrkmkouzano());
                    bzGkHurikomiLstDaSouBean.setIrKznmej(gknyknmeisai.getHrkmkznmej());
                    bzGkHurikomiLstDaSouBean.setIrZndktuukasyu(gknyknmeisai.getHrkmzndktuukasyu());
                    bzGkHurikomiLstDaSouBean.setIrZndkssketa(gknyknmeisai.getHrkmzndkssketa());
                    bzGkHurikomiLstDaSouBean.setIrGktrhkmaezndk(gknyknmeisai.getHrkmgktrhkmaezndk());
                    bzGkHurikomiLstDaSouBean.setIrKasikosikbn(gknyknmeisai.getHrkmkasikosikbn());
                    bzGkHurikomiLstDaSouBean.setIrDatakbn2(gknyknmeisai.getHrkmdatakbn2());
                    bzGkHurikomiLstDaSouBean.setIrDtrecordkbn1(gknyknmeisai.getHrkmdtrecordkbn1());
                    bzGkHurikomiLstDaSouBean.setIrDtrecordkousei(gknyknmeisai.getHrkmdtrecordkousei());
                    bzGkHurikomiLstDaSouBean.setIrSyorino1(gknyknmeisai.getHrkmsyorino1());
                    bzGkHurikomiLstDaSouBean.setIrKnjyymd(gknyknmeisai.getHrkmknjyymd());
                    bzGkHurikomiLstDaSouBean.setIrKsnymd(gknyknmeisai.getHrkmksnymd());
                    bzGkHurikomiLstDaSouBean.setIrIribaraikbn(hrkmiribaraikbn);
                    bzGkHurikomiLstDaSouBean.setIrTrhkkbn(hrkmtrhkkbn);
                    bzGkHurikomiLstDaSouBean.setIrTrhktuukasyu(gknyknmeisai.getHrkmtrhktuukasyu());
                    bzGkHurikomiLstDaSouBean.setIrTrhkssketa(gknyknmeisai.getHrkmtrhkssketa());
                    bzGkHurikomiLstDaSouBean.setIrGktrhkgk(gknyknmeisai.getHrkmgktrhkgk());
                    bzGkHurikomiLstDaSouBean.setIrBanksyoukaino(gknyknmeisai.getHrkmbanksyoukaino());
                    bzGkHurikomiLstDaSouBean.setIrTrhksyoukaino(gknyknmeisai.getHrkmtrhksyoukaino());
                    bzGkHurikomiLstDaSouBean.setIrTekiyounaiyouej(gknyknmeisai.getHrkmtekiyounaiyouej());
                    bzGkHurikomiLstDaSouBean.setIrIrninnm(gknyknmeisai.getHrkmirninnmej());

                    bzHurikomiErrInfoListDataSourceBeanLst.add(bzGkHurikomiLstDaSouBean);

                    batchLogger.info(errorMessage);

                    continue;
                }

                if (!BizDate.valueOf(gknyknmeisai.getHrkmrensakuseiymd()).isRekijyou()) {

                    tankoumokuError(MessageId.EBF1011, MessageUtil.getMessage(MessageId.IBW1001), gknyknmeisai);
                    continue;
                }

                if (!BizDate.valueOf(gknyknmeisai.getHrkmrenrakuymd()).isRekijyou()) {

                    tankoumokuError(MessageId.EBF1011, MessageUtil.getMessage(MessageId.IBW1002), gknyknmeisai);
                    continue;
                }

                if (!BizDate.valueOf(gknyknmeisai.getHrkmknjyymdfrom()).isRekijyou()) {

                    tankoumokuError(MessageId.EBF1011, MessageUtil.getMessage(MessageId.IBW1003), gknyknmeisai);
                    continue;
                }

                if (!BizDate.valueOf(gknyknmeisai.getHrkmknjyymdto()).isRekijyou()) {

                    tankoumokuError(MessageId.EBF1011, MessageUtil.getMessage(MessageId.IBW1004), gknyknmeisai);
                    continue;
                }

                if (!BizDate.valueOf(gknyknmeisai.getHrkmknjyymd()).isRekijyou()) {

                    tankoumokuError(MessageId.EBF1011, MessageUtil.getMessage(MessageId.IBW1005), gknyknmeisai);
                    continue;
                }

                if (!BizDate.valueOf(gknyknmeisai.getHrkmksnymd()).isRekijyou()) {

                    tankoumokuError(MessageId.EBF1011, MessageUtil.getMessage(MessageId.IBW1006), gknyknmeisai);
                    continue;
                }

                if (!C_Tuukasyu.USD.getValue().equals(gknyknmeisai.getHrkmzndktuukasyu()) &&
                    !C_Tuukasyu.EUR.getValue().equals(gknyknmeisai.getHrkmzndktuukasyu()) &&
                    !C_Tuukasyu.AUD.getValue().equals(gknyknmeisai.getHrkmzndktuukasyu())) {

                    tankoumokuError(MessageId.EBF1012, MessageUtil.getMessage(MessageId.IBW1013), gknyknmeisai);
                    continue;
                }

                if (!C_Tuukasyu.USD.getValue().equals(gknyknmeisai.getHrkmtrhktuukasyu()) &&
                    !C_Tuukasyu.EUR.getValue().equals(gknyknmeisai.getHrkmtrhktuukasyu()) &&
                    !C_Tuukasyu.AUD.getValue().equals(gknyknmeisai.getHrkmtrhktuukasyu())) {

                    tankoumokuError(MessageId.EBF1012, MessageUtil.getMessage(MessageId.IBW1014), gknyknmeisai);
                    continue;
                }

                BizNumber hrkmzndkssKeta;
                try {

                    hrkmzndkssKeta = BizNumber.valueOf(Long.valueOf(gknyknmeisai.getHrkmzndkssketa()));
                } catch (Exception e) {

                    tankoumokuError(MessageId.EBF1013, MessageUtil.getMessage(MessageId.IBW1015), gknyknmeisai);
                    continue;
                }

                BizNumber hrkmtrhkssKeta;
                try {

                    hrkmtrhkssKeta = BizNumber.valueOf(Long.valueOf(gknyknmeisai.getHrkmtrhkssketa()));
                } catch (Exception e) {

                    tankoumokuError(MessageId.EBF1013, MessageUtil.getMessage(MessageId.IBW1016), gknyknmeisai);
                    continue;
                }

                BizCurrency hrkmgktrhkmaeZndk;
                try {

                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                    CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(
                        C_Tuukasyu.valueOf(gknyknmeisai.getHrkmzndktuukasyu()));
                    hrkmgktrhkmaeZndk = BizCurrency.absoluteValueOf(new BigDecimal(gknyknmeisai.getHrkmgktrhkmaezndk()),
                        currencyType);

                } catch (Exception e) {

                    tankoumokuError(MessageId.EBF1013, MessageUtil.getMessage(MessageId.IBW1010), gknyknmeisai);
                    continue;
                }

                BizCurrency hrkmgktrhkGk;
                try {

                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                    CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(
                        C_Tuukasyu.valueOf(gknyknmeisai.getHrkmtrhktuukasyu()));
                    hrkmgktrhkGk = BizCurrency.absoluteValueOf(new BigDecimal(gknyknmeisai.getHrkmgktrhkgk()), currencyType);

                } catch (Exception e) {

                    tankoumokuError(MessageId.EBF1013, MessageUtil.getMessage(MessageId.IBW1011), gknyknmeisai);
                    continue;
                }

                if (!hrkmzndkssKeta.equals(BizNumber.valueOf(2))) {

                    tankoumokuError(MessageId.EBF1014, MessageUtil.getMessage(MessageId.IBW1015), gknyknmeisai);
                    continue;
                }

                if (!hrkmtrhkssKeta.equals(BizNumber.valueOf(2))) {

                    tankoumokuError(MessageId.EBF1014, MessageUtil.getMessage(MessageId.IBW1016), gknyknmeisai);
                    continue;
                }

                if (String.valueOf(new BigDecimal(hrkmgktrhkmaeZndk.toString())).split("\\.")[0].length() > 11) {

                    tankoumokuError(MessageId.EBF1015, MessageUtil.getMessage(MessageId.IBW1010), gknyknmeisai);
                    continue;
                }

                if (String.valueOf(new BigDecimal(hrkmgktrhkGk.toString())).split("\\.")[0].length() > 11) {

                    tankoumokuError(MessageId.EBF1015, MessageUtil.getMessage(MessageId.IBW1011), gknyknmeisai);
                    continue;
                }
                SkHurikomiKouzaInfo skHurikomiKouzaInfo = SWAKInjector.getInstance(SkHurikomiKouzaInfo.class);
                SkHurikomiKouzaInfoBean skHurikomiKouzaInfoBean = SWAKInjector.getInstance(
                    SkHurikomiKouzaInfoBean.class);

                skHurikomiKouzaInfoBean.setBankCd(gknyknmeisai.getHrkmbankcd());
                skHurikomiKouzaInfoBean.setSitenCd(gknyknmeisai.getHrkmshitencd());
                skHurikomiKouzaInfoBean.setKouzaNo(gknyknmeisai.getHrkmkouzano());
                skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.valueOf(gknyknmeisai.getHrkmzndktuukasyu()));
                skHurikomiKouzaInfoBean.setHrkmirninNm(gknyknmeisai.getHrkmirninnmej());
                skHurikomiKouzaInfoBean = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

                String hrkmkahen1 = gknyknmeisai.getHrkmkahen1();

                String simukebanknmeiji = "";

                String simuketennmeiji = "";

                if (!BizUtil.isBlank(hrkmkahen1)) {

                    if (hrkmkahen1.startsWith(KAHEN_SOUKINBANK_PREFIX)) {

                        int soukinbankLength = Integer.parseInt(hrkmkahen1.substring(KAHEN_PREFIX_SIZE_INDEX, KAHEN_PREFIX_LENGTH));

                        int simukeBankLength;
                        if (SIMUKEBANKNMEIJI_MAX_LENGTH < soukinbankLength) {
                            simukeBankLength = SIMUKEBANKNMEIJI_MAX_LENGTH;
                        } else {
                            simukeBankLength = soukinbankLength;
                        }
                        simukebanknmeiji = hrkmkahen1.substring(KAHEN_PREFIX_LENGTH, KAHEN_PREFIX_LENGTH + simukeBankLength);

                        int simukSitenLength;
                        if (SIMUKEBANKNMEIJI_MAX_LENGTH + SIMUKETENNMEIJI_MAX_LENGTH < soukinbankLength) {
                            simukSitenLength = SIMUKEBANKNMEIJI_MAX_LENGTH + SIMUKETENNMEIJI_MAX_LENGTH;
                        } else {
                            simukSitenLength = soukinbankLength;
                        }

                        simuketennmeiji = hrkmkahen1.substring(KAHEN_PREFIX_LENGTH + simukeBankLength, KAHEN_PREFIX_LENGTH + simukSitenLength);
                    }

                    else if (hrkmkahen1.startsWith(KAHEN_SIMUKEBANK_PREFIX)) {
                        int simukeBankLength = Integer.parseInt(hrkmkahen1.substring(KAHEN_PREFIX_SIZE_INDEX, KAHEN_PREFIX_LENGTH));

                        simukebanknmeiji = hrkmkahen1.substring(KAHEN_PREFIX_LENGTH, KAHEN_PREFIX_LENGTH + Math.min(simukeBankLength, SIMUKEBANKNMEIJI_MAX_LENGTH));

                        String simukeSitenIkou = hrkmkahen1.substring(KAHEN_PREFIX_LENGTH + simukeBankLength);

                        if (simukeSitenIkou.startsWith(KAHEN_SIMUKESITEN_PREFIX)) {
                            int simukeSitenLength = Integer.parseInt(simukeSitenIkou.substring(KAHEN_PREFIX_SIZE_INDEX, KAHEN_PREFIX_LENGTH));
                            simuketennmeiji = simukeSitenIkou.substring(KAHEN_PREFIX_LENGTH, KAHEN_PREFIX_LENGTH + Math.min(simukeSitenLength, SIMUKETENNMEIJI_MAX_LENGTH));
                        }
                    }
                }

                gaikaHrkmNyknData = new HT_GaikaHrkmNyknData();

                gaikaHrkmNyknData.setDensyskbn(C_DensysKbn.SKEI);
                gaikaHrkmNyknData.setSyoriYmd(syoriYmd);
                gaikaHrkmNyknData.setItirenno(uniqueKeyGenerator.generateUniqueKey());
                gaikaHrkmNyknData.setNykmosno(skHurikomiKouzaInfoBean.getMosno());
                gaikaHrkmNyknData.setSyouhnno(skHurikomiKouzaInfoBean.getSyouhnNo());
                gaikaHrkmNyknData.setSyubetucd(Integer.parseInt(gknyknmeisai.getHrkmsyubetucd()));
                gaikaHrkmNyknData.setCdkbn(Integer.parseInt(gknyknmeisai.getHrkmcdkbn()));
                gaikaHrkmNyknData.setSakuseiymd(BizDate.valueOf(gknyknmeisai.getHrkmrensakuseiymd()));
                gaikaHrkmNyknData.setKnjyymdfrom(BizDate.valueOf(gknyknmeisai.getHrkmknjyymdfrom()));
                gaikaHrkmNyknData.setKnjyymdto(BizDate.valueOf(gknyknmeisai.getHrkmknjyymdto()));
                gaikaHrkmNyknData.setBankcd(gknyknmeisai.getHrkmbankcd());
                gaikaHrkmNyknData.setBanknmkn(ConvertUtil.toZenAll(gknyknmeisai.getHrkmbanknmej(), 1, 1));
                gaikaHrkmNyknData.setSitencd(gknyknmeisai.getHrkmshitencd());
                gaikaHrkmNyknData.setSitennmkn(ConvertUtil.toZenAll(gknyknmeisai.getHrkmsitennmej(), 1, 1));
                gaikaHrkmNyknData.setYokinkbn(C_YokinKbn.valueOf(gknyknmeisai.getHrkmyokinkbn()));
                gaikaHrkmNyknData.setKouzano(skHurikomiKouzaInfoBean.getKouzaNo());
                gaikaHrkmNyknData.setKznmkn(ConvertUtil.toZenAll(gknyknmeisai.getHrkmkznmej(), 1, 1));
                gaikaHrkmNyknData.setKasikosikbn(Integer.parseInt(gknyknmeisai.getHrkmkasikosikbn()));
                gaikaHrkmNyknData.setTrhkmaezndk(hrkmgktrhkmaeZndk);
                gaikaHrkmNyknData.setTrhksakisyoukaino(gknyknmeisai.getHrkmtrhksyoukaino());
                gaikaHrkmNyknData.setKnjyymd(BizDate.valueOf(gknyknmeisai.getHrkmknjyymd()));
                gaikaHrkmNyknData.setKsnymd(BizDate.valueOf(gknyknmeisai.getHrkmksnymd()));
                gaikaHrkmNyknData.setIribaraikbn(Integer.parseInt(hrkmiribaraikbn));
                gaikaHrkmNyknData.setTrhkkbn(Integer.parseInt(hrkmtrhkkbn));
                gaikaHrkmNyknData.setTrhkkgk(hrkmgktrhkGk);
                gaikaHrkmNyknData.setTuukasyu(C_Tuukasyu.valueOf(gknyknmeisai.getHrkmtrhktuukasyu()));
                String hurikomiNm =  skHurikomiKouzaInfoBean.getHrkmirninNmKana();
                if(hurikomiNm.length() >= UPPER_STR ) {
                    hurikomiNm = hurikomiNm.substring(STRTRI_START, STRTRI_END);
                }
                gaikaHrkmNyknData.setHrkmirninnm(ConvertUtil.toZenAll(StringUtils.stripEnd(hurikomiNm, " "), 1, 1));
                gaikaHrkmNyknData.setHrkmirninnm140(ConvertUtil.toZenAll(gknyknmeisai.getHrkmirninnmej(), 1, 1));
                gaikaHrkmNyknData.setSimukebanknmeiji(simukebanknmeiji);
                gaikaHrkmNyknData.setSimuketennmeiji(simuketennmeiji);
                gaikaHrkmNyknData.setTekiyounaiyoueiji(gknyknmeisai.getHrkmtekiyounaiyouej());
                gaikaHrkmNyknData.setOyadrtencd(skHurikomiKouzaInfoBean.getOyadrtenCd());
                gaikaHrkmNyknData.setOyadrtensyoritarget(skHurikomiKouzaInfoBean.getOyadrtenSyoriTarget());
                gaikaHrkmNyknData.setJidonykntargethyouji(skHurikomiKouzaInfoBean.getJidonyknTargetHyouji());
                gaikaHrkmNyknData.setMostokusokuumu(C_UmuKbn.NONE);
                gaikaHrkmNyknData.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                gaikaHrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());
                gaikaHrkmNyknData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                gaikaHrkmNyknData.setGyoumuKousinTime(sysTime);
                gaikaHrkmNyknData.setHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.NYKNMEISAI);
                gaikaHrkmNyknData.setNyuukinoyadrtennm(skHurikomiKouzaInfoBean.getNyuukinOyadrtenNm());
                gaikaHrkmNyknData.setSiteituuka(skHurikomiKouzaInfoBean.getSiteiTuuka());
                gaikaHrkmNyknData.setHonkouzacd(skHurikomiKouzaInfoBean.getHonkouzaCd());

                BizPropertyInitializer.initialize(gaikaHrkmNyknData);
                gaikaHrkmNyknDataEntityInserter.add(gaikaHrkmNyknData);
                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (bzHurikomiErrInfoListDataSourceBeanLst.size() != 0) {

                BzGkHurikomiErrInfoListBean bzGkHurikomiErrInfoListBean = SWAKInjector.getInstance(
                    BzGkHurikomiErrInfoListBean.class);
                bzGkHurikomiErrInfoListBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJINoEx(syoriYmd));

                ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                    kinou.getSubSystemId(),
                    kinou.getCategoryId(),
                    kinou.getKinouId(),
                    C_SyoruiCdKbn.CM_GKHURIKOMIERRINFOLIST);

                reportServicesBean.setSyoriYmd(syoriYmd);

                reportServicesBean.addParamObjects(bzHurikomiErrInfoListDataSourceBeanLst,
                    bzGkHurikomiErrInfoListBean);
                createReport.execNoCommit(reportServicesBean);

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0018, String.valueOf(syoriKensuu)));
            }
            else {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0019, String.valueOf(syoriKensuu)));
            }
        }
    }

    private void tankoumokuError(String pMessageId, String pKoumokuId, BT_Gknyknmeisai pGknyknmeisai) {

        errorMessage = MessageUtil.getMessage(pMessageId,
            pGknyknmeisai.getHrkmbankcd(),
            pGknyknmeisai.getHrkmshitencd(),
            pGknyknmeisai.getHrkmrensakuseiymd(),
            pGknyknmeisai.getHrkmsyorino1(),
            pKoumokuId);

        BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean = SWAKInjector.getInstance(
            BzGkHurikomiErrInfoListDataSourceBean.class);

        bzGkHurikomiErrInfoListDataSourceBean.setIrErrormsg(errorMessage);
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn1(pGknyknmeisai.getHrkmdatakbn1());
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyubetucd(pGknyknmeisai.getHrkmsyubetucd());
        bzGkHurikomiErrInfoListDataSourceBean.setIrCdkbn(pGknyknmeisai.getHrkmcdkbn());
        bzGkHurikomiErrInfoListDataSourceBean.setIrSakuseiymd(pGknyknmeisai.getHrkmrensakuseiymd());
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakuymd(pGknyknmeisai.getHrkmrenrakuymd());
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakukaisuu(pGknyknmeisai.getHrkmrenrakukaisuu());
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom(pGknyknmeisai.getHrkmknjyymdfrom());
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdto(pGknyknmeisai.getHrkmknjyymdto());
        bzGkHurikomiErrInfoListDataSourceBean.setIrBankcd(pGknyknmeisai.getHrkmbankcd());
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanknmej(pGknyknmeisai.getHrkmbanknmej());
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencdtori(pGknyknmeisai.getHrkmsitencdtori());
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmejtori(pGknyknmeisai.getHrkmsitennmejtori());
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencd(pGknyknmeisai.getHrkmshitencd());
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmej(pGknyknmeisai.getHrkmsitennmej());
        bzGkHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.valueOf(pGknyknmeisai.getHrkmyokinkbn()));
        bzGkHurikomiErrInfoListDataSourceBean.setIrKouzano(pGknyknmeisai.getHrkmkouzano());
        bzGkHurikomiErrInfoListDataSourceBean.setIrKznmej(pGknyknmeisai.getHrkmkznmej());
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndktuukasyu(pGknyknmeisai.getHrkmzndktuukasyu());
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndkssketa(pGknyknmeisai.getHrkmzndkssketa());
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkmaezndk(pGknyknmeisai.getHrkmgktrhkmaezndk());
        bzGkHurikomiErrInfoListDataSourceBean.setIrKasikosikbn(pGknyknmeisai.getHrkmkasikosikbn());
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn2(pGknyknmeisai.getHrkmdatakbn2());
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkbn1(pGknyknmeisai.getHrkmdtrecordkbn1());
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkousei(pGknyknmeisai.getHrkmdtrecordkousei());
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyorino1(pGknyknmeisai.getHrkmsyorino1());
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymd(pGknyknmeisai.getHrkmknjyymd());
        bzGkHurikomiErrInfoListDataSourceBean.setIrKsnymd(pGknyknmeisai.getHrkmksnymd());
        bzGkHurikomiErrInfoListDataSourceBean.setIrIribaraikbn(pGknyknmeisai.getHrkmiribaraikbn());
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkkbn(pGknyknmeisai.getHrkmtrhkkbn());
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhktuukasyu(pGknyknmeisai.getHrkmtrhktuukasyu());
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkssketa(pGknyknmeisai.getHrkmtrhkssketa());
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkgk(pGknyknmeisai.getHrkmgktrhkgk());
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanksyoukaino(pGknyknmeisai.getHrkmbanksyoukaino());
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhksyoukaino(pGknyknmeisai.getHrkmtrhksyoukaino());
        bzGkHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyouej(pGknyknmeisai.getHrkmtekiyounaiyouej());
        bzGkHurikomiErrInfoListDataSourceBean.setIrIrninnm(pGknyknmeisai.getHrkmirninnmej());

        bzHurikomiErrInfoListDataSourceBeanLst.add(bzGkHurikomiErrInfoListDataSourceBean);

        batchLogger.info(errorMessage);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
