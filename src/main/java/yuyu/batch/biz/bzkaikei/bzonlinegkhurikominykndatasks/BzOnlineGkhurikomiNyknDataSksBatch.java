package yuyu.batch.biz.bzkaikei.bzonlinegkhurikominykndatasks;

import java.math.BigDecimal;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.SkHurikomiKouzaInfo;
import yuyu.common.biz.bzcommon.SkHurikomiKouzaInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_OnlineGknyknmeisai;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 オンライン外貨振込入金データ作成
 */
public class BzOnlineGkhurikomiNyknDataSksBatch implements Batch{

    private final String ONLINEGK_NYKNMEISAI_TABLE_ID = "BT_OnlineGknyknmeisai";

    private final String GKNYKNMEISAI_FILTER_ID = "Bz102";

    private final int HRKMIRNINNM_MAX_LENGTH = 96;

    private final int SIMUKEBANKNMEIJI_MAX_LENGTH = 70;

    private final int SIMUKETENNMEIJI_MAX_LENGTH = 35;

    private static final int KAHEN_PREFIX_LENGTH = 6;

    private static final int KAHEN_PREFIX_SIZE_INDEX = 3;

    private final String ZERO_8KETA = "00000000";

    private final C_HrkmnykndatarenmotoKbn HRKMNYKNDATARENMOTOKBN_ONLINE = C_HrkmnykndatarenmotoKbn.ONLINE;

    private final String IRIBARAIKBN_NYUKIN = "1";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzOnlineGkhurikomiNyknDataSksDao bzOnlineGkhurikomiNyknDataSksDao;

    @Inject
    private HenkanTuuka henkanTuuka;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private static Logger logger;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        int syoriKensuu = 0;

        try (ExDBResults<BT_OnlineGknyknmeisai> onlineGknyknDataLst =
            bzOnlineGkhurikomiNyknDataSksDao.getOnlineGknyknmeisaisByKakutyoujobcdHrkmsakuseiymd(
                bzBatchParam.getIbKakutyoujobcd(), String.valueOf(bzBatchParam.getSyoriYmd()));
            EntityInserter<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataEntityInserter = new EntityInserter<>();) {

            Iterator<BT_OnlineGknyknmeisai> onlineGknyknDataIter = onlineGknyknDataLst.iterator();
            while (onlineGknyknDataIter.hasNext()) {
                logger.debug("オンライン外貨入出金明細データリストの件数分、繰返し処理を実行します。処理件数:" + syoriKensuu);

                BT_OnlineGknyknmeisai onlineGknyknData = onlineGknyknDataIter.next();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(ONLINEGK_NYKNMEISAI_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(GKNYKNMEISAI_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(onlineGknyknData.getHrkmsakuseiymd());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(onlineGknyknData.getHrkmbankcd());

                logger.debug(String.format("リカバリデータ識別用BEAN 設定値 "
                    + "拡張ジョブコード:%s, テーブルＩＤ:%s, リカバリフィルタID:%s, リカバリフィルタキー１:%s, リカバリフィルタキー２:%s",
                    bzRecoveryDatasikibetuBean.getIbKakutyoujobcd(), bzRecoveryDatasikibetuBean.getIbTableid(), bzRecoveryDatasikibetuBean.getIbRecoveryfilterid(),
                    bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey1(), bzRecoveryDatasikibetuBean.getIbRecoveryfilterkey2()));

                if (!IRIBARAIKBN_NYUKIN.equals(onlineGknyknData.getHrkmiribaraikbn())) {
                    continue;
                }

                SkHurikomiKouzaInfo skHurikomiKouzaInfo = SWAKInjector.getInstance(SkHurikomiKouzaInfo.class);
                SkHurikomiKouzaInfoBean skHurikomiKouzaInfoBean = SWAKInjector.getInstance(SkHurikomiKouzaInfoBean.class);
                SkHurikomiKouzaInfoBean gkhrkmnyknkouzaJyouhou = null;

                skHurikomiKouzaInfoBean.setBankCd(onlineGknyknData.getHrkmbankcd());
                skHurikomiKouzaInfoBean.setSitenCd(onlineGknyknData.getHrkmshitencd());
                skHurikomiKouzaInfoBean.setKouzaNo(onlineGknyknData.getHrkmkouzano());
                skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.valueOf(onlineGknyknData.getHrkmzndktuukasyu()));
                skHurikomiKouzaInfoBean.setHrkmirninNm(onlineGknyknData.getHrkmirninnmej());

                gkhrkmnyknkouzaJyouhou = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

                String hrkmirninnm =  gkhrkmnyknkouzaJyouhou.getHrkmirninNmKana();
                if (hrkmirninnm.length() > HRKMIRNINNM_MAX_LENGTH){
                    hrkmirninnm = hrkmirninnm.substring(0, HRKMIRNINNM_MAX_LENGTH);
                }

                String hrkmkahen1 = onlineGknyknData.getHrkmkahen1();
                String simukebanknmeiji = "";
                String simuketennmeiji = "";

                if (!BizUtil.isBlank(hrkmkahen1)) {

                    int simukeBankLength = Integer.parseInt(hrkmkahen1.substring(KAHEN_PREFIX_SIZE_INDEX, KAHEN_PREFIX_LENGTH));
                    simukebanknmeiji = hrkmkahen1.substring(KAHEN_PREFIX_LENGTH, KAHEN_PREFIX_LENGTH + Math.min(simukeBankLength, SIMUKEBANKNMEIJI_MAX_LENGTH));
                    int simukeSitenIndex = KAHEN_PREFIX_LENGTH + simukeBankLength;

                    if (simukeSitenIndex < hrkmkahen1.length()) {
                        int simukeSitenLength = Integer.parseInt(hrkmkahen1.substring(simukeSitenIndex + KAHEN_PREFIX_SIZE_INDEX, simukeSitenIndex + KAHEN_PREFIX_LENGTH));
                        simuketennmeiji = hrkmkahen1.substring(simukeSitenIndex + KAHEN_PREFIX_LENGTH, simukeSitenIndex + KAHEN_PREFIX_LENGTH + Math.min(simukeSitenLength, SIMUKETENNMEIJI_MAX_LENGTH));
                    }
                }

                HT_GaikaHrkmNyknData gaikaHrkmNyknData = new HT_GaikaHrkmNyknData();

                gaikaHrkmNyknData.setDensyskbn(C_DensysKbn.SKEI);
                gaikaHrkmNyknData.setSyoriYmd(bzBatchParam.getSyoriYmd());
                gaikaHrkmNyknData.setItirenno(uniqueKeyGenerator.generateUniqueKey());
                gaikaHrkmNyknData.setNykmosno(gkhrkmnyknkouzaJyouhou.getMosno());
                gaikaHrkmNyknData.setSyouhnno(gkhrkmnyknkouzaJyouhou.getSyouhnNo());
                gaikaHrkmNyknData.setSyubetucd(Integer.parseInt(onlineGknyknData.getHrkmsyubetucd()));
                gaikaHrkmNyknData.setCdkbn(Integer.parseInt(onlineGknyknData.getHrkmcdkbn()));
                gaikaHrkmNyknData.setSakuseiymd(BizDate.valueOf(onlineGknyknData.getHrkmsakuseiymd()));
                if (!BizUtil.isBlank(onlineGknyknData.getHrkmknjyymdfrom()) && !ZERO_8KETA.equals(onlineGknyknData.getHrkmknjyymdfrom())) {
                    gaikaHrkmNyknData.setKnjyymdfrom(BizDate.valueOf(onlineGknyknData.getHrkmknjyymdfrom()));
                }
                if (!BizUtil.isBlank(onlineGknyknData.getHrkmknjyymdto()) && !ZERO_8KETA.equals(onlineGknyknData.getHrkmknjyymdto())) {
                    gaikaHrkmNyknData.setKnjyymdto(BizDate.valueOf(onlineGknyknData.getHrkmknjyymdto()));
                }
                gaikaHrkmNyknData.setBankcd(onlineGknyknData.getHrkmbankcd());
                gaikaHrkmNyknData.setBanknmkn(ConvertUtil.toZenAll(onlineGknyknData.getHrkmbanknmej(), 1, 1));
                gaikaHrkmNyknData.setSitencd(onlineGknyknData.getHrkmshitencd());
                gaikaHrkmNyknData.setSitennmkn(ConvertUtil.toZenAll(onlineGknyknData.getHrkmsitennmej(), 1, 1));
                gaikaHrkmNyknData.setYokinkbn(C_YokinKbn.valueOf(onlineGknyknData.getHrkmyokinkbn()));
                gaikaHrkmNyknData.setKouzano(gkhrkmnyknkouzaJyouhou.getKouzaNo());
                gaikaHrkmNyknData.setKznmkn(ConvertUtil.toZenAll(onlineGknyknData.getHrkmkznmej(), 1, 1));
                gaikaHrkmNyknData.setKasikosikbn(Integer.parseInt(onlineGknyknData.getHrkmkasikosikbn()));
                gaikaHrkmNyknData.setTrhkmaezndk(
                    BizCurrency.absoluteValueOf(new BigDecimal(onlineGknyknData.getHrkmgktrhkmaezndk()),
                        henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.valueOf(onlineGknyknData.getHrkmzndktuukasyu()))));
                gaikaHrkmNyknData.setTrhksakisyoukaino(onlineGknyknData.getHrkmtrhksyoukaino());
                if (!BizUtil.isBlank(onlineGknyknData.getHrkmknjyymd()) && !ZERO_8KETA.equals(onlineGknyknData.getHrkmknjyymd())) {
                    gaikaHrkmNyknData.setKnjyymd(BizDate.valueOf(onlineGknyknData.getHrkmknjyymd()));
                }
                if (!BizUtil.isBlank(onlineGknyknData.getHrkmksnymd()) && !ZERO_8KETA.equals(onlineGknyknData.getHrkmksnymd())) {
                    gaikaHrkmNyknData.setKsnymd(BizDate.valueOf(onlineGknyknData.getHrkmksnymd()));
                }
                gaikaHrkmNyknData.setIribaraikbn(Integer.parseInt(onlineGknyknData.getHrkmiribaraikbn()));
                gaikaHrkmNyknData.setTrhkkbn(Integer.parseInt(onlineGknyknData.getHrkmtrhkkbn()));
                gaikaHrkmNyknData.setTrhkkgk(
                    BizCurrency.absoluteValueOf(new BigDecimal(onlineGknyknData.getHrkmgktrhkgk()),
                        henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.valueOf(onlineGknyknData.getHrkmtrhktuukasyu()))));
                gaikaHrkmNyknData.setTuukasyu(C_Tuukasyu.valueOf(onlineGknyknData.getHrkmtrhktuukasyu()));
                gaikaHrkmNyknData.setHrkmirninnm(ConvertUtil.toZenAll(StringUtils.stripEnd(hrkmirninnm, " "), 1, 1));
                gaikaHrkmNyknData.setHrkmirninnm140(ConvertUtil.toZenAll(onlineGknyknData.getHrkmirninnmej(), 1, 1));
                gaikaHrkmNyknData.setSimukebanknmeiji(simukebanknmeiji);
                gaikaHrkmNyknData.setSimuketennmeiji(simuketennmeiji);
                gaikaHrkmNyknData.setTekiyounaiyoueiji(onlineGknyknData.getHrkmtekiyounaiyouej());
                gaikaHrkmNyknData.setOyadrtencd(gkhrkmnyknkouzaJyouhou.getOyadrtenCd());
                gaikaHrkmNyknData.setOyadrtensyoritarget(gkhrkmnyknkouzaJyouhou.getOyadrtenSyoriTarget());
                gaikaHrkmNyknData.setJidonykntargethyouji(gkhrkmnyknkouzaJyouhou.getJidonyknTargetHyouji());
                gaikaHrkmNyknData.setMostokusokuumu(C_UmuKbn.NONE);
                gaikaHrkmNyknData.setSyorizumiflg(C_Syorizumiflg.MISYORI);
                gaikaHrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());
                gaikaHrkmNyknData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                gaikaHrkmNyknData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                gaikaHrkmNyknData.setHrkmnykndatarenmotoKbn(HRKMNYKNDATARENMOTOKBN_ONLINE);
                gaikaHrkmNyknData.setNyuukinoyadrtennm(gkhrkmnyknkouzaJyouhou.getNyuukinOyadrtenNm());
                gaikaHrkmNyknData.setSiteituuka(gkhrkmnyknkouzaJyouhou.getSiteiTuuka());
                gaikaHrkmNyknData.setHonkouzacd(gkhrkmnyknkouzaJyouhou.getHonkouzaCd());

                BizPropertyInitializer.initialize(gaikaHrkmNyknData);
                gaikaHrkmNyknDataEntityInserter.add(gaikaHrkmNyknData);
                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
