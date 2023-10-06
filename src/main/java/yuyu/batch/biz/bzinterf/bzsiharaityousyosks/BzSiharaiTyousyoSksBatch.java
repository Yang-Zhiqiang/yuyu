package yuyu.batch.biz.bzinterf.bzsiharaityousyosks;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BaitaiSksHnRiyuuKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.db.entity.BV_SiharaiTyousyo;
import yuyu.def.db.entity.ZT_SiharaiTyousyoTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 支払調書Ｆ作成
 */
public class BzSiharaiTyousyoSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String tysyttaisyouTableId = "BV_SiharaiTyousyo";
        String recoveryFilterId = "Bz001";
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
                String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
                ibKakutyoujobcd));

        try (ExDBResults<BV_SiharaiTyousyo> siharaiTyousyoExDBResults =
                bizDomManager.getSiharaiTyousyosByKakutyoujobcdSyoriYmd(ibKakutyoujobcd, syoriYmd);
                EntityInserter<ZT_SiharaiTyousyoTy> siharaiTyousyoTyInserter = new EntityInserter<>()) {

            long syoriKensuuKhTyousyo = 0;
            long syoriKensuuSiTyousyo = 0;
            long syoriKensuuSiharaiTyousyoTy = 0;

            for (BV_SiharaiTyousyo siharaiTyousyoExDBResult : siharaiTyousyoExDBResults) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(siharaiTyousyoExDBResult.getSyono());

                ZT_SiharaiTyousyoTy siharaiTyousyoTy = new ZT_SiharaiTyousyoTy();
                siharaiTyousyoTy.setZtysubsystemid(siharaiTyousyoExDBResult.getSubSystemId());
                siharaiTyousyoTy.setZtysequenceno((int) syoriKensuuSiharaiTyousyoTy);
                if (siharaiTyousyoExDBResult.getSyono().length() > 11) {
                    siharaiTyousyoTy.setZtysyono(siharaiTyousyoExDBResult.getSyono().substring(0, 11));
                }
                else {
                    siharaiTyousyoTy.setZtysyono(siharaiTyousyoExDBResult.getSyono());
                }
                siharaiTyousyoTy.setZtyhknsyukigou(siharaiTyousyoExDBResult.getHknsyukigou());
                siharaiTyousyoTy.setZtykacd(siharaiTyousyoExDBResult.getKacd());
                siharaiTyousyoTy.setZtytantocd(siharaiTyousyoExDBResult.getTantocd().getValue());
                siharaiTyousyoTy.setZtysyorisosikicd(siharaiTyousyoExDBResult.getSyorisosikicd());
                siharaiTyousyoTy.setZtyshrtysysyuruicd(siharaiTyousyoExDBResult.getShrtysysyuruicd());
                siharaiTyousyoTy.setZtysyoritaisyoukbn(siharaiTyousyoExDBResult.getSyoritaisyoukbn());
                if ("1".equals(siharaiTyousyoExDBResult.getTblsakuseihunodisp())) {
                    siharaiTyousyoTy.setZtybaitaiskshunoriyuukbn1(C_BaitaiSksHnRiyuuKbn.BAITAISAKUSEIHUKA.getValue());
                }
                else {
                    siharaiTyousyoTy.setZtybaitaiskshunoriyuukbn1(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());
                }
                siharaiTyousyoTy.setZtybaitaiskshunoriyuukbn2(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());
                siharaiTyousyoTy.setZtybaitaiskshunoriyuukbn3(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());
                siharaiTyousyoTy.setZtybaitaiskshunoriyuukbn4(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());
                siharaiTyousyoTy.setZtybaitaiskshunoriyuukbn5(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());
                siharaiTyousyoTy.setZtyshrtysyjyuusyocd(siharaiTyousyoExDBResult.getShrtysytsinyno());
                if ((siharaiTyousyoExDBResult.getShrtysyadr1kj() + siharaiTyousyoExDBResult.getShrtysyadr2kj() +
                        siharaiTyousyoExDBResult.getShrtysyadr3kj()).length() > 62) {
                    siharaiTyousyoTy.setZtyshrtysyjyuusyo(
                            (siharaiTyousyoExDBResult.getShrtysyadr1kj() + siharaiTyousyoExDBResult.getShrtysyadr2kj() +
                                    siharaiTyousyoExDBResult.getShrtysyadr3kj()).substring(0, 62));
                }
                else {
                    siharaiTyousyoTy.setZtyshrtysyjyuusyo(
                            (siharaiTyousyoExDBResult.getShrtysyadr1kj() + siharaiTyousyoExDBResult.getShrtysyadr2kj() +
                                    siharaiTyousyoExDBResult.getShrtysyadr3kj()));
                }
                siharaiTyousyoTy.setZtyuktnmkj35(siharaiTyousyoExDBResult.getUktnmkj());
                siharaiTyousyoTy.setZtydaihyouktkbn(siharaiTyousyoExDBResult.getDaihyouktkbn());
                siharaiTyousyoTy.setZtykjdaihyouuktnm(siharaiTyousyoExDBResult.getKjdaihyouuktnm());
                siharaiTyousyoTy.setZtyuktmnmeigibangou(siharaiTyousyoExDBResult.getUktmnmeigibangou());
                siharaiTyousyoTy.setZtyyobiv24("");
                siharaiTyousyoTy.setZtymfjyuusyocd(siharaiTyousyoExDBResult.getTsinyno());
                if ((siharaiTyousyoExDBResult.getTsinadr1kj() + siharaiTyousyoExDBResult.getTsinadr2kj() +
                        siharaiTyousyoExDBResult.getTsinadr3kj()).length() > 62) {
                    siharaiTyousyoTy.setZtymfjyuusyo(
                            (siharaiTyousyoExDBResult.getTsinadr1kj() + siharaiTyousyoExDBResult.getTsinadr2kj() +
                                    siharaiTyousyoExDBResult.getTsinadr3kj()).substring(0, 62));
                }
                else {
                    siharaiTyousyoTy.setZtymfjyuusyo(
                            (siharaiTyousyoExDBResult.getTsinadr1kj() + siharaiTyousyoExDBResult.getTsinadr2kj() +
                                    siharaiTyousyoExDBResult.getTsinadr3kj()));
                }
                siharaiTyousyoTy.setZtykyknmkj35(siharaiTyousyoExDBResult.getKyknmkj());
                siharaiTyousyoTy.setZtykykmnmeigibangou(siharaiTyousyoExDBResult.getKykmnmeigibangou());
                siharaiTyousyoTy.setZtyjigyoukykmndantaicd(siharaiTyousyoExDBResult.getJigyoukykmndantaicd());
                siharaiTyousyoTy.setZtyyobiv17("");
                siharaiTyousyoTy.setZtyhhknnmkj(siharaiTyousyoExDBResult.getHhknnmkj());
                siharaiTyousyoTy.setZtyyobiv3("000");
                siharaiTyousyoTy.setZtyyobiv17x2("");
                siharaiTyousyoTy.setZtyoldkykkihontikucd(siharaiTyousyoExDBResult.getOldtsinyno());
                if ((siharaiTyousyoExDBResult.getOldtsinadr1kj() + siharaiTyousyoExDBResult.getOldtsinadr2kj() +
                        siharaiTyousyoExDBResult.getOldtsinadr3kj()).length() > 62) {
                    siharaiTyousyoTy.setZtykjoldkykkaiadr(
                            (siharaiTyousyoExDBResult.getOldtsinadr1kj() + siharaiTyousyoExDBResult.getOldtsinadr2kj() +
                                    siharaiTyousyoExDBResult.getOldtsinadr3kj()).substring(0, 62));
                }
                else {
                    siharaiTyousyoTy.setZtykjoldkykkaiadr(
                            (siharaiTyousyoExDBResult.getOldtsinadr1kj() + siharaiTyousyoExDBResult.getOldtsinadr2kj() +
                                    siharaiTyousyoExDBResult.getOldtsinadr3kj()));
                }
                siharaiTyousyoTy.setZtykjoldkyknm(siharaiTyousyoExDBResult.getOldkyknmkj());
                siharaiTyousyoTy.setZtykykhnkkaisuu(String.valueOf(siharaiTyousyoExDBResult.getKykhnkkaisuu()));
                siharaiTyousyoTy.setZtyyobiv3x2("000");
                siharaiTyousyoTy.setZtyyobiv23("");
                if (siharaiTyousyoExDBResult.getShrymd() != null) {
                    siharaiTyousyoTy.setZtyshrymd(String.valueOf(siharaiTyousyoExDBResult.getShrymd()));
                }
                else {
                    siharaiTyousyoTy.setZtyshrymd("");
                }
                if (siharaiTyousyoExDBResult.getSakuseiymd() != null) {
                    siharaiTyousyoTy.setZtysakuseiymd(String.valueOf(siharaiTyousyoExDBResult.getSakuseiymd()));
                }
                else {
                    siharaiTyousyoTy.setZtysakuseiymd("");
                }
                if (siharaiTyousyoExDBResult.getKouryokuhasseiymd() != null) {
                    siharaiTyousyoTy.setZtykouryokuhasseiymd(
                            String.valueOf(siharaiTyousyoExDBResult.getKouryokuhasseiymd()));
                }
                else {
                    siharaiTyousyoTy.setZtykouryokuhasseiymd("");
                }
                siharaiTyousyoTy.setZtyyobiv8("00000000");
                siharaiTyousyoTy.setZtyyobiv8x2("00000000");
                siharaiTyousyoTy.setZtyyobiv8x3("00000000");
                siharaiTyousyoTy.setZtyyobiv8x4("00000000");
                siharaiTyousyoTy.setZtyshrgk11(
                        new BigDecimal(siharaiTyousyoExDBResult.getShrgk().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtywarimsishrgk(
                        new BigDecimal(siharaiTyousyoExDBResult.getWarimsishrgkbizc().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtyznnphr(
                        new BigDecimal(siharaiTyousyoExDBResult.getZnnphrbizc().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtyttkekstkganri(
                        new BigDecimal(siharaiTyousyoExDBResult.getTtkekstkganribizc().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtysshkd(
                        new BigDecimal(siharaiTyousyoExDBResult.getSshkdbizc().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtysasihikisiharaigaku(
                        new BigDecimal(siharaiTyousyoExDBResult.getSshkshrgk().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtymihrkmp(
                        new BigDecimal(siharaiTyousyoExDBResult.getMihrkmpbizc().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtyshrtienrsk11(
                        new BigDecimal(siharaiTyousyoExDBResult.getShrtienrsk().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtytysyouhtykeihi(
                        new BigDecimal(siharaiTyousyoExDBResult.getKihrkmp().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtygenkykhtykeihiyouhyj(siharaiTyousyoExDBResult.getShrkykhtykeihiyouhyj());
                siharaiTyousyoTy.setZtygenkykhtykeihi(
                        new BigDecimal(siharaiTyousyoExDBResult.getShrkykhtykeihi().toAdsoluteString()).longValue());
                siharaiTyousyoTy.setZtyyobin11(0L);
                siharaiTyousyoTy.setZtyyobin11x2(0L);
                siharaiTyousyoTy.setZtyyobin11x3(0L);
                siharaiTyousyoTy.setZtyyobin11x4(0L);
                siharaiTyousyoTy.setZtygensenkbn("0");
                siharaiTyousyoTy.setZtygensentaisyoukkngai("0000");
                siharaiTyousyoTy.setZtygensentaisyoukkn("0000");
                siharaiTyousyoTy.setZtymnsaiannaihnskakbn(siharaiTyousyoExDBResult.getMnsaiannaihnskakbn());

                if (siharaiTyousyoExDBResult.getShrhousiteikbn().eq(C_ShrhousiteiKbn.BLNK)) {
                    siharaiTyousyoTy.setZtyshrhousiteikbn("00");
                } else if (siharaiTyousyoExDBResult.getShrhousiteikbn().eq(C_ShrhousiteiKbn.FB_YOKUJITU)) {
                    siharaiTyousyoTy.setZtyshrhousiteikbn("06");
                } else if (siharaiTyousyoExDBResult.getShrhousiteikbn().eq(C_ShrhousiteiKbn.FB_2EIGYOUBI)) {
                    siharaiTyousyoTy.setZtyshrhousiteikbn("16");
                } else if (siharaiTyousyoExDBResult.getShrhousiteikbn().eq(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI)) {
                    siharaiTyousyoTy.setZtyshrhousiteikbn("04");
                } else if (siharaiTyousyoExDBResult.getShrhousiteikbn().eq(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI)) {
                    siharaiTyousyoTy.setZtyshrhousiteikbn("05");
                } else if (siharaiTyousyoExDBResult.getShrhousiteikbn().eq(C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI)) {
                    siharaiTyousyoTy.setZtyshrhousiteikbn("06");
                } else if (siharaiTyousyoExDBResult.getShrhousiteikbn().eq(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI)) {
                    siharaiTyousyoTy.setZtyshrhousiteikbn("04");
                }

                siharaiTyousyoTy.setZtyshrtysykurikosidisp(siharaiTyousyoExDBResult.getShrtysykurikosidisp());
                siharaiTyousyoTy.setZtymfadrsiyouhyouji(siharaiTyousyoExDBResult.getMfadrsiyouhyouji());
                siharaiTyousyoTy.setZtynkshrhkjksyuruikbn("00");
                siharaiTyousyoTy.setZtynenkinkkn(String.valueOf(siharaiTyousyoExDBResult.getNenkinkkn()));
                siharaiTyousyoTy.setZtysynyhsjykykndisp(siharaiTyousyoExDBResult.getSynyhsjykykndisp());
                siharaiTyousyoTy.setZtyonlinecentercutkbn(siharaiTyousyoExDBResult.getOnlinecentercutkbn());
                siharaiTyousyoTy.setZtyhuho2kykdisp(siharaiTyousyoExDBResult.getHuho2kykdisp());
                siharaiTyousyoTy.setZtyshrtysyhknsyukbn(siharaiTyousyoExDBResult.getShrtysyhknsyukbn().getContent());
                siharaiTyousyoTy.setZtyyobiv9x5("");
                siharaiTyousyoTy.setZtytekiyouranhensyuukbn1("00");
                siharaiTyousyoTy.setZtytekiyouranhensyuukbn2("00");
                siharaiTyousyoTy.setZtytekiyouranhensyuukbn3("00");
                siharaiTyousyoTy.setZtytekiyouranhensyuukbn4("00");
                siharaiTyousyoTy.setZtytekiyouranhensyuukbn5("00");
                siharaiTyousyoTy.setZtyyobiv181("");

                BizPropertyInitializer.initialize(siharaiTyousyoTy);

                siharaiTyousyoTyInserter.add(siharaiTyousyoTy);

                if ("hozen".equals(siharaiTyousyoExDBResult.getSubSystemId())) {
                    syoriKensuuKhTyousyo = syoriKensuuKhTyousyo + 1;
                }
                else if ("siharai".equals(siharaiTyousyoExDBResult.getSubSystemId())) {
                    syoriKensuuSiTyousyo = syoriKensuuSiTyousyo + 1;
                }

                syoriKensuuSiharaiTyousyoTy = syoriKensuuSiharaiTyousyoTy + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(
                    MessageId.IBF0002, String.valueOf(syoriKensuuKhTyousyo), "契約保全支払調書テーブル"));

            batchLogger.info(MessageUtil.getMessage(
                    MessageId.IBF0002, String.valueOf(syoriKensuuSiTyousyo), "保険金給付金支払調書テーブル"));

            batchLogger.info(MessageUtil.getMessage(
                    MessageId.IBF0002, String.valueOf(syoriKensuuSiharaiTyousyoTy), "支払調書テーブル（中）"));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
                SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
