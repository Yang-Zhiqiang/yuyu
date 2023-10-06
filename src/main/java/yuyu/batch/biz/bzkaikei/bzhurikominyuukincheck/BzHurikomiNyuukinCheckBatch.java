package yuyu.batch.biz.bzkaikei.bzhurikominyuukincheck;

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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.SkHurikomiKouzaInfo;
import yuyu.common.biz.bzcommon.SkHurikomiKouzaInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.bean.report.BzHurikomiErrInfoListBean;
import yuyu.def.biz.bean.report.BzHurikomiErrInfoListDataSourceBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_Nyknmeisai;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;

/**
 * 業務共通 経理・会計 振込入金データチェック
 */
public class BzHurikomiNyuukinCheckBatch implements Batch {

    private static final String IRIBARAIKBN_NYUKIN = "1";

    private static final String IRIBARAIKBN_DEKIN = "2";

    private static final String TRHKKBN_GENKIN = "10";

    private static final String TRHKKBN_FURIKOMI = "11";

    private static final String TRHKKBN_TATENKENNYUKIN = "12";

    private static final String TRHKKBN_KOUKAN = "13";

    private static final String TRHKKBN_FURIKAU = "14";

    private static final String TRHKKBN_SONOTA = "18";

    private static final String TRHKKBN_TEISEI = "19";

    private static final String NYKNMEISAITBL = "BT_Nyknmeisai";

    private static final String NYKNMEISAIFILE = "Bz101";

    private static final String ZERO_6KETA = "000000";

    private static final String SYSTEM_HONBAN_KADOU_YMD = "290323";

    private static final String GETGENGOU_YUUKOU_YMD = "20250101";

    private String eraMessage;

    private String genGou;

    private final List<IReportDataSouceBean> bzHurikomiErrInfoListDataSourceBeanLst = new ArrayList<>();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInf;

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

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        long syoriCount = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        genGou = syoriYmd.getLatestGengouInfo().getGengouSymbol();


        try (ExDBResults<BT_Nyknmeisai> nyknmeisaiLst = bizDomManager.getNyknmeisaisByKakutyoujobcdHrkmsakuseiymd6keta(
            bzBatchParam.getIbKakutyoujobcd(), Strings.padStart(String.valueOf(syoriYmd.getYearW(genGou)), 2, '0') + syoriYmd.getBizDateMD())) {

            Iterator<BT_Nyknmeisai> nyknmeisaiIter = nyknmeisaiLst.iterator();
            if (!nyknmeisaiIter.hasNext()) {
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));

                return;
            }

            List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getHurikomiKouzasByTuukasyu(C_Tuukasyu.JPY);

            try (EntityInserter<HT_HrkmNyknData> entityInserter = new EntityInserter<>()) {

                while (nyknmeisaiIter.hasNext()) {

                    BT_Nyknmeisai nyknmeisai = nyknmeisaiIter.next();
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                    bzRecoveryDatasikibetuBean.setIbTableid(NYKNMEISAITBL);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(NYKNMEISAIFILE);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(nyknmeisai.getHrkmsakuseiymd6keta());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(nyknmeisai.getHrkmbankcd());

                    if (!((IRIBARAIKBN_NYUKIN.equals(nyknmeisai.getHrkmiribaraikbn()) && (TRHKKBN_GENKIN
                        .equals(nyknmeisai.getHrkmtrhkkbn()) ||
                        TRHKKBN_FURIKOMI.equals(nyknmeisai.getHrkmtrhkkbn()) ||
                        TRHKKBN_TATENKENNYUKIN.equals(nyknmeisai.getHrkmtrhkkbn()) ||
                        TRHKKBN_KOUKAN.equals(nyknmeisai.getHrkmtrhkkbn()) ||
                        TRHKKBN_FURIKAU.equals(nyknmeisai.getHrkmtrhkkbn()) || TRHKKBN_SONOTA.equals(nyknmeisai
                            .getHrkmtrhkkbn())))
                            || (IRIBARAIKBN_DEKIN.equals(nyknmeisai.getHrkmiribaraikbn()) && TRHKKBN_TEISEI.equals(nyknmeisai
                                .getHrkmtrhkkbn())))) {
                        continue;

                    }

                    boolean kka = false;
                    for (HM_HurikomiKouza hurikomiKouza : hurikomiKouzaLst) {
                        if (hurikomiKouza.getBankcd().equals(nyknmeisai.getHrkmbankcd()) &&
                            hurikomiKouza.getSitencd().equals(nyknmeisai.getHrkmshitencd()) &&
                            hurikomiKouza.getKouzano().equals(nyknmeisai.getHrkmkouzano()) &&
                            hurikomiKouza.getYokinkbn().eq(C_YokinKbn.valueOf(nyknmeisai.getHrkmyokinkbn()))) {
                            kka = true;
                            break;
                        }
                    }
                    if (!kka) {
                        eraMessage = MessageUtil.getMessage(MessageId.EBF1006, nyknmeisai.getHrkmbankcd(),
                            nyknmeisai.getHrkmshitencd(), nyknmeisai.getHrkmrensakuseiymd6keta(),
                            nyknmeisai.getHrkmsyoukaino(), nyknmeisai.getHrkmkouzano());

                        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean = SWAKInjector
                            .getInstance(BzHurikomiErrInfoListDataSourceBean.class);
                        bzHurikomiErrInfoListDataSourceBean.setIrErrormsg(eraMessage);
                        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn1(nyknmeisai.getHrkmdatakbn1());
                        bzHurikomiErrInfoListDataSourceBean.setIrSyubetucd(nyknmeisai.getHrkmsyubetucd());
                        bzHurikomiErrInfoListDataSourceBean.setIrCdkbn(nyknmeisai.getHrkmcdkbn());
                        bzHurikomiErrInfoListDataSourceBean.setIrSakuseiymd6keta(nyknmeisai.getHrkmrensakuseiymd6keta());
                        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom6keta(nyknmeisai.getHrkmknjyymdfrom6keta());
                        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdto6keta(nyknmeisai.getHrkmknjyymdto6keta());
                        bzHurikomiErrInfoListDataSourceBean.setIrBankcd(nyknmeisai.getHrkmbankcd());
                        bzHurikomiErrInfoListDataSourceBean.setIrBanknmkn(nyknmeisai.getHrkmbanknmkn());
                        bzHurikomiErrInfoListDataSourceBean.setIrSitencd(nyknmeisai.getHrkmshitencd());
                        bzHurikomiErrInfoListDataSourceBean.setIrSitennmkn(nyknmeisai.getHrkmsitennmkn());
                        bzHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.valueOf(nyknmeisai
                            .getHrkmyokinkbn()));
                        bzHurikomiErrInfoListDataSourceBean.setIrKouzano(nyknmeisai.getHrkmkouzano());
                        bzHurikomiErrInfoListDataSourceBean.setIrKznmkn(nyknmeisai.getHrkmkznmkn());
                        bzHurikomiErrInfoListDataSourceBean.setIrKasikosikbn(nyknmeisai.getHrkmkasikosikbn());
                        bzHurikomiErrInfoListDataSourceBean.setIrTuutyousysykbn(nyknmeisai.getHrkmtuutyousysykbn());
                        bzHurikomiErrInfoListDataSourceBean.setIrTrhkmaezndk(nyknmeisai.getHrkmtrhkmaezndk());
                        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn2(nyknmeisai.getHrkmdatakbn2());
                        bzHurikomiErrInfoListDataSourceBean.setIrSyoukaino(nyknmeisai.getHrkmsyoukaino());
                        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymd6keta(nyknmeisai.getHrkmknjyymd6keta());
                        bzHurikomiErrInfoListDataSourceBean.setIrAzkrhrdsymd6keta(nyknmeisai.getHrkmazkrhrdsymd6keta());
                        bzHurikomiErrInfoListDataSourceBean.setIrIribaraikbn(nyknmeisai.getHrkmiribaraikbn());
                        bzHurikomiErrInfoListDataSourceBean.setIrTrhkkbn(nyknmeisai.getHrkmtrhkkbn());
                        bzHurikomiErrInfoListDataSourceBean.setIrTrhkgk(nyknmeisai.getHrkmtrhkgk());
                        bzHurikomiErrInfoListDataSourceBean.setIrTatenkengk(nyknmeisai.getHrkmtatenkengk());
                        bzHurikomiErrInfoListDataSourceBean.setIrKknteijiymd6keta(nyknmeisai.getHrkmkknteijiymd6keta());
                        bzHurikomiErrInfoListDataSourceBean.setIrHwtrhnknymd6keta(nyknmeisai.getHrkmhwtrhnknymd6keta());
                        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtkbn(nyknmeisai.getHrkmtgtkgtkbn());
                        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtno(nyknmeisai.getHrkmtgtkgtno());
                        bzHurikomiErrInfoListDataSourceBean.setIrRyoutenno(nyknmeisai.getHrkmryoutenno());
                        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirnincd(nyknmeisai.getHrkmhrkmirnincd());
                        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirninnm48(nyknmeisai.getHrkmhrkmirninnm());
                        bzHurikomiErrInfoListDataSourceBean.setIrSimukebanknmkn(nyknmeisai.getHrkmsimukebanknmkn());
                        bzHurikomiErrInfoListDataSourceBean.setIrSimuketennmkn(nyknmeisai.getHrkmsimuketennmkn());
                        bzHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyou(nyknmeisai.getHrkmtekiyounaiyou());
                        bzHurikomiErrInfoListDataSourceBean.setIrEdiinfo(nyknmeisai.getHrkmediinfo());

                        bzHurikomiErrInfoListDataSourceBeanLst.add(bzHurikomiErrInfoListDataSourceBean);

                        batchLogger.info(eraMessage);
                        continue;
                    }

                    BizDate hrkmrensakuseiymd6keta;
                    try {
                        hrkmrensakuseiymd6keta = BizDate.valueOf(getGengou(nyknmeisai.getHrkmrensakuseiymd6keta()),
                            Integer.parseInt(nyknmeisai.getHrkmrensakuseiymd6keta().substring(0, 2)),
                            Integer.parseInt(nyknmeisai.getHrkmrensakuseiymd6keta().substring(2, 4)),
                            Integer.parseInt(nyknmeisai.getHrkmrensakuseiymd6keta().substring(4)));
                    }
                    catch (Exception e) {
                        tankoumokuError(MessageId.EBF1007, MessageId.IBW1001, nyknmeisai);
                        continue;
                    }

                    BizDate hrkmknjyymdfrom6keta;
                    try {
                        hrkmknjyymdfrom6keta = BizDate.valueOf(getGengou(nyknmeisai.getHrkmknjyymdfrom6keta()),
                            Integer.parseInt(nyknmeisai.getHrkmknjyymdfrom6keta().substring(0, 2)),
                            Integer.parseInt(nyknmeisai.getHrkmknjyymdfrom6keta().substring(2, 4)),
                            Integer.parseInt(nyknmeisai.getHrkmknjyymdfrom6keta().substring(4)));
                    }
                    catch (Exception e) {
                        tankoumokuError(MessageId.EBF1007, MessageId.IBW1003, nyknmeisai);
                        continue;
                    }

                    BizDate hrkmknjyymdto6keta;
                    try {
                        hrkmknjyymdto6keta = BizDate.valueOf(getGengou(nyknmeisai.getHrkmknjyymdto6keta()),
                            Integer.parseInt(nyknmeisai.getHrkmknjyymdto6keta().substring(0, 2)),
                            Integer.parseInt(nyknmeisai.getHrkmknjyymdto6keta().substring(2, 4)),
                            Integer.parseInt(nyknmeisai.getHrkmknjyymdto6keta().substring(4)));
                    }
                    catch (Exception e) {
                        tankoumokuError(MessageId.EBF1007, MessageId.IBW1004, nyknmeisai);
                        continue;
                    }

                    BizDate hrkmknjyymd6keta;
                    try {
                        hrkmknjyymd6keta = BizDate.valueOf(getGengou(nyknmeisai.getHrkmknjyymd6keta()),
                            Integer.parseInt(nyknmeisai.getHrkmknjyymd6keta().substring(0, 2)),
                            Integer.parseInt(nyknmeisai.getHrkmknjyymd6keta().substring(2, 4)),
                            Integer.parseInt(nyknmeisai.getHrkmknjyymd6keta().substring(4)));
                    }
                    catch (Exception e) {
                        tankoumokuError(MessageId.EBF1007, MessageId.IBW1005, nyknmeisai);
                        continue;
                    }

                    BizDate hrkmazkrhrdsymd6keta;
                    try {
                        hrkmazkrhrdsymd6keta = BizDate.valueOf(getGengou(nyknmeisai.getHrkmazkrhrdsymd6keta()),
                            Integer.parseInt(nyknmeisai.getHrkmazkrhrdsymd6keta().substring(0, 2)),
                            Integer.parseInt(nyknmeisai.getHrkmazkrhrdsymd6keta().substring(2, 4)),
                            Integer.parseInt(nyknmeisai.getHrkmazkrhrdsymd6keta().substring(4)));
                    }
                    catch (Exception e) {
                        tankoumokuError(MessageId.EBF1007, MessageId.IBW1007, nyknmeisai);
                        continue;
                    }

                    BizDate hrkmkknteijiymd6keta = null;
                    if (!BizUtil.isBlank(nyknmeisai.getHrkmkknteijiymd6keta()) && !ZERO_6KETA.equals(nyknmeisai.getHrkmkknteijiymd6keta())) {
                        try {
                            hrkmkknteijiymd6keta = BizDate.valueOf(getGengou(nyknmeisai.getHrkmkknteijiymd6keta()),
                                Integer.parseInt(nyknmeisai.getHrkmkknteijiymd6keta().substring(0, 2)),
                                Integer.parseInt(nyknmeisai.getHrkmkknteijiymd6keta().substring(2, 4)),
                                Integer.parseInt(nyknmeisai.getHrkmkknteijiymd6keta().substring(4)));
                        }
                        catch (Exception e) {
                            tankoumokuError(MessageId.EBF1007, MessageId.IBW1008, nyknmeisai);
                            continue;
                        }
                    }

                    BizDate hrkmhwtrhnknymd6keta = null;
                    if (!BizUtil.isBlank(nyknmeisai.getHrkmhwtrhnknymd6keta()) && !ZERO_6KETA.equals(nyknmeisai.getHrkmhwtrhnknymd6keta())) {
                        try {
                            hrkmhwtrhnknymd6keta = BizDate.valueOf(getGengou(nyknmeisai.getHrkmhwtrhnknymd6keta()),
                                Integer.parseInt(nyknmeisai.getHrkmhwtrhnknymd6keta().substring(0, 2)),
                                Integer.parseInt(nyknmeisai.getHrkmhwtrhnknymd6keta().substring(2, 4)),
                                Integer.parseInt(nyknmeisai.getHrkmhwtrhnknymd6keta().substring(4)));
                        }
                        catch (Exception e) {
                            tankoumokuError(MessageId.EBF1007, MessageId.IBW1009, nyknmeisai);
                            continue;
                        }
                    }

                    BizCurrency hrkmtrhkmaezndk;
                    BizCurrency hrkmtrhkgk;
                    BizCurrency hrkmtatenkengk;
                    try {
                        hrkmtrhkmaezndk = BizCurrency.valueOf(Long.valueOf(nyknmeisai.getHrkmtrhkmaezndk()),
                            BizCurrencyTypes.YEN);
                    } catch (Exception e) {
                        tankoumokuError(MessageId.EBF1008, MessageId.IBW1010, nyknmeisai);
                        continue;
                    }

                    try {
                        hrkmtrhkgk = BizCurrency.valueOf(Long.valueOf(nyknmeisai.getHrkmtrhkgk()),
                            BizCurrencyTypes.YEN);
                    } catch (Exception e) {
                        tankoumokuError(MessageId.EBF1008, MessageId.IBW1011, nyknmeisai);
                        continue;
                    }

                    try {
                        hrkmtatenkengk = BizCurrency.valueOf(Long.valueOf(nyknmeisai.getHrkmtatenkengk()),
                            BizCurrencyTypes.YEN);
                    } catch (Exception e) {
                        tankoumokuError(MessageId.EBF1008, MessageId.IBW1012, nyknmeisai);
                        continue;
                    }

                    if (hrkmtrhkmaezndk.toString().length() > 13) {
                        tankoumokuError(MessageId.EBF1009, MessageId.IBW1010, nyknmeisai);
                        continue;
                    }

                    SkHurikomiKouzaInfo skHurikomiKouzaInfo = SWAKInjector.getInstance(SkHurikomiKouzaInfo.class);
                    SkHurikomiKouzaInfoBean skHurikomiKouzaInfoBean = SWAKInjector
                        .getInstance(SkHurikomiKouzaInfoBean.class);

                    skHurikomiKouzaInfoBean.setBankCd(nyknmeisai.getHrkmbankcd());
                    skHurikomiKouzaInfoBean.setSitenCd(nyknmeisai.getHrkmshitencd());
                    skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.valueOf(nyknmeisai.getHrkmyokinkbn()));
                    skHurikomiKouzaInfoBean.setKouzaNo(nyknmeisai.getHrkmkouzano());
                    skHurikomiKouzaInfoBean.setHrkmirninCd(nyknmeisai.getHrkmhrkmirnincd());
                    skHurikomiKouzaInfoBean.setHrkmirninNm(nyknmeisai.getHrkmhrkmirninnm());

                    SkHurikomiKouzaInfoBean skHurikomiKouzaInfoOutBean = skHurikomiKouzaInfo
                        .getHurikomiInfoYen(skHurikomiKouzaInfoBean);

                    HT_HrkmNyknData hrkmNyknData = new HT_HrkmNyknData();

                    hrkmNyknData.setDensyskbn(C_DensysKbn.SKEI);
                    hrkmNyknData.setSyoriYmd(syoriYmd);
                    hrkmNyknData.setItirenno(uniqueKeyGenerator.generateUniqueKey());
                    hrkmNyknData.setNykmosno(skHurikomiKouzaInfoOutBean.getMosno());
                    hrkmNyknData.setSyouhnno(skHurikomiKouzaInfoOutBean.getSyouhnNo());
                    hrkmNyknData.setSyubetucd(Integer.parseInt(nyknmeisai.getHrkmsyubetucd()));
                    hrkmNyknData.setCdkbn(Integer.parseInt(nyknmeisai.getHrkmcdkbn()));
                    hrkmNyknData.setSakuseiymd(hrkmrensakuseiymd6keta);
                    hrkmNyknData.setKnjyymdfrom(hrkmknjyymdfrom6keta);
                    hrkmNyknData.setKnjyymdto(hrkmknjyymdto6keta);
                    hrkmNyknData.setBankcd(nyknmeisai.getHrkmbankcd());
                    hrkmNyknData.setBanknmkn(nyknmeisai.getHrkmbanknmkn());
                    hrkmNyknData.setSitencd(nyknmeisai.getHrkmshitencd());
                    hrkmNyknData.setSitennmkn(nyknmeisai.getHrkmsitennmkn());
                    hrkmNyknData.setYokinkbn(C_YokinKbn.valueOf(nyknmeisai.getHrkmyokinkbn()));
                    hrkmNyknData.setKouzano(nyknmeisai.getHrkmkouzano());
                    hrkmNyknData.setKznmkn(nyknmeisai.getHrkmkznmkn());
                    hrkmNyknData.setTrhkmaezndk(hrkmtrhkmaezndk);
                    hrkmNyknData.setSyoukaino(nyknmeisai.getHrkmsyoukaino());
                    hrkmNyknData.setKnjyymd(hrkmknjyymd6keta);
                    hrkmNyknData.setAzkrhrdsymd(hrkmazkrhrdsymd6keta);
                    hrkmNyknData.setIribaraikbn(Integer.parseInt(nyknmeisai.getHrkmiribaraikbn()));
                    hrkmNyknData.setTrhkkbn(Integer.parseInt(nyknmeisai.getHrkmtrhkkbn()));
                    hrkmNyknData.setTrhkkgk(hrkmtrhkgk);
                    hrkmNyknData.setTatenkengk(hrkmtatenkengk);
                    if (!BizUtil.isBlank(nyknmeisai.getHrkmkknteijiymd6keta())) {
                        hrkmNyknData.setKknteijiymd(hrkmkknteijiymd6keta);
                    }
                    if (!BizUtil.isBlank(nyknmeisai.getHrkmhwtrhnknymd6keta())) {
                        hrkmNyknData.setHwtrhnknymd(hrkmhwtrhnknymd6keta);
                    }
                    hrkmNyknData.setTgtkgtkbn(nyknmeisai.getHrkmtgtkgtkbn());
                    hrkmNyknData.setTgtkgtno(nyknmeisai.getHrkmtgtkgtno());
                    hrkmNyknData.setRyoutenno(nyknmeisai.getHrkmryoutenno());
                    hrkmNyknData.setHrkmirnincd(nyknmeisai.getHrkmhrkmirnincd());
                    hrkmNyknData.setHrkmirninnm(ConvertUtil.toZenAll(skHurikomiKouzaInfoOutBean.getHrkmirninNmKana(), 1, 1));
                    hrkmNyknData.setHrkmirninnm140(ConvertUtil.toZenAll(nyknmeisai.getHrkmhrkmirninnm(), 1, 1));
                    hrkmNyknData.setSimukebanknmkn(nyknmeisai.getHrkmsimukebanknmkn());
                    hrkmNyknData.setSimuketennmkn(nyknmeisai.getHrkmsimuketennmkn());
                    hrkmNyknData.setTekiyounaiyou(nyknmeisai.getHrkmtekiyounaiyou());
                    hrkmNyknData.setEdiinfo(nyknmeisai.getHrkmediinfo());
                    hrkmNyknData.setOyadrtencd(skHurikomiKouzaInfoOutBean.getOyadrtenCd());
                    hrkmNyknData.setJidonykntargethyouji(skHurikomiKouzaInfoOutBean.getJidonyknTargetHyouji());
                    hrkmNyknData.setOyadrtensyoritarget(skHurikomiKouzaInfoOutBean.getOyadrtenSyoriTarget());
                    hrkmNyknData.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                    hrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());
                    hrkmNyknData.setGyoumuKousinsyaId(baseUserInf.getUserId());
                    hrkmNyknData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                    hrkmNyknData.setHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.NYKNMEISAI);
                    hrkmNyknData.setNyuukinoyadrtennm(skHurikomiKouzaInfoOutBean.getNyuukinOyadrtenNm());
                    hrkmNyknData.setSiteituuka(skHurikomiKouzaInfoOutBean.getSiteiTuuka());
                    hrkmNyknData.setHonkouzacd(skHurikomiKouzaInfoOutBean.getHonkouzaCd());
                    hrkmNyknData.setNyktyhyoutkbn(skHurikomiKouzaInfoOutBean.getNyktyhyoutKbn());

                    BizPropertyInitializer.initialize(hrkmNyknData);

                    entityInserter.add(hrkmNyknData);

                    syoriCount++;
                }
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        if (bzHurikomiErrInfoListDataSourceBeanLst.size() != 0) {
            BzHurikomiErrInfoListBean bzHurikomiErrInfoListBean = SWAKInjector
                .getInstance(BzHurikomiErrInfoListBean.class);

            bzHurikomiErrInfoListBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJINoEx(syoriYmd));

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.CM_HURIKOMIERRINFOLIST);

            reportServicesBean.setSyoriYmd(syoriYmd);
            reportServicesBean.addParamObjects(bzHurikomiErrInfoListDataSourceBeanLst, bzHurikomiErrInfoListBean);
            createReport.execNoCommit(reportServicesBean);

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0018, String.valueOf(syoriCount)));

        }
        else {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0019, String.valueOf(syoriCount)));
        }

    }

    private void tankoumokuError(String pMessageId, String pKoumokuid, BT_Nyknmeisai pNyknmeisai) {

        eraMessage = MessageUtil.getMessage(pMessageId, pNyknmeisai.getHrkmbankcd(),
            pNyknmeisai.getHrkmshitencd(), pNyknmeisai.getHrkmrensakuseiymd6keta(),
            pNyknmeisai.getHrkmsyoukaino(), MessageUtil.getMessage(pKoumokuid));

        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean = SWAKInjector
            .getInstance(BzHurikomiErrInfoListDataSourceBean.class);
        bzHurikomiErrInfoListDataSourceBean.setIrErrormsg(eraMessage);
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn1(pNyknmeisai.getHrkmdatakbn1());
        bzHurikomiErrInfoListDataSourceBean.setIrSyubetucd(pNyknmeisai.getHrkmsyubetucd());
        bzHurikomiErrInfoListDataSourceBean.setIrCdkbn(pNyknmeisai.getHrkmcdkbn());
        bzHurikomiErrInfoListDataSourceBean.setIrSakuseiymd6keta(pNyknmeisai.getHrkmrensakuseiymd6keta());
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom6keta(pNyknmeisai.getHrkmknjyymdfrom6keta());
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdto6keta(pNyknmeisai.getHrkmknjyymdto6keta());
        bzHurikomiErrInfoListDataSourceBean.setIrBankcd(pNyknmeisai.getHrkmbankcd());
        bzHurikomiErrInfoListDataSourceBean.setIrBanknmkn(pNyknmeisai.getHrkmbanknmkn());
        bzHurikomiErrInfoListDataSourceBean.setIrSitencd(pNyknmeisai.getHrkmshitencd());
        bzHurikomiErrInfoListDataSourceBean.setIrSitennmkn(pNyknmeisai.getHrkmsitennmkn());
        bzHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.valueOf(pNyknmeisai.getHrkmyokinkbn()));
        bzHurikomiErrInfoListDataSourceBean.setIrKouzano(pNyknmeisai.getHrkmkouzano());
        bzHurikomiErrInfoListDataSourceBean.setIrKznmkn(pNyknmeisai.getHrkmkznmkn());
        bzHurikomiErrInfoListDataSourceBean.setIrKasikosikbn(pNyknmeisai.getHrkmkasikosikbn());
        bzHurikomiErrInfoListDataSourceBean.setIrTuutyousysykbn(pNyknmeisai.getHrkmtuutyousysykbn());
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkmaezndk(pNyknmeisai.getHrkmtrhkmaezndk());
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn2(pNyknmeisai.getHrkmdatakbn2());
        bzHurikomiErrInfoListDataSourceBean.setIrSyoukaino(pNyknmeisai.getHrkmsyoukaino());
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymd6keta(pNyknmeisai.getHrkmknjyymd6keta());
        bzHurikomiErrInfoListDataSourceBean.setIrAzkrhrdsymd6keta(pNyknmeisai.getHrkmazkrhrdsymd6keta());
        bzHurikomiErrInfoListDataSourceBean.setIrIribaraikbn(pNyknmeisai.getHrkmiribaraikbn());
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkkbn(pNyknmeisai.getHrkmtrhkkbn());
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkgk(pNyknmeisai.getHrkmtrhkgk());
        bzHurikomiErrInfoListDataSourceBean.setIrTatenkengk(pNyknmeisai.getHrkmtatenkengk());
        bzHurikomiErrInfoListDataSourceBean.setIrKknteijiymd6keta(pNyknmeisai.getHrkmkknteijiymd6keta());
        bzHurikomiErrInfoListDataSourceBean.setIrHwtrhnknymd6keta(pNyknmeisai.getHrkmhwtrhnknymd6keta());
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtkbn(pNyknmeisai.getHrkmtgtkgtkbn());
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtno(pNyknmeisai.getHrkmtgtkgtno());
        bzHurikomiErrInfoListDataSourceBean.setIrRyoutenno(pNyknmeisai.getHrkmryoutenno());
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirnincd(pNyknmeisai.getHrkmhrkmirnincd());
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirninnm48(pNyknmeisai.getHrkmhrkmirninnm());
        bzHurikomiErrInfoListDataSourceBean.setIrSimukebanknmkn(pNyknmeisai.getHrkmsimukebanknmkn());
        bzHurikomiErrInfoListDataSourceBean.setIrSimuketennmkn(pNyknmeisai.getHrkmsimuketennmkn());
        bzHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyou(pNyknmeisai.getHrkmtekiyounaiyou());
        bzHurikomiErrInfoListDataSourceBean.setIrEdiinfo(pNyknmeisai.getHrkmediinfo());

        bzHurikomiErrInfoListDataSourceBeanLst.add(bzHurikomiErrInfoListDataSourceBean);

        batchLogger.info(eraMessage);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }

    private String getGengou(String pWareki6Ymd) {

        String tmpGengou = "";

        if (Integer.parseInt(bzBatchParam.getSyoriYmd().toString()) < Integer.parseInt(GETGENGOU_YUUKOU_YMD) &&
            Integer.parseInt(SYSTEM_HONBAN_KADOU_YMD) <= Integer.parseInt(pWareki6Ymd)) {
            tmpGengou = "H";
        }
        else {
            tmpGengou = genGou;
        }

        return tmpGengou;
    }

}
