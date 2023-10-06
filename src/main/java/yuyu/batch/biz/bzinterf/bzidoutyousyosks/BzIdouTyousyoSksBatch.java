package yuyu.batch.biz.bzinterf.bzidoutyousyosks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzinterf.bzidoutyousyosks.dba.BzIdouTyousyoSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BaitaiSksHnRiyuuKbn;
import yuyu.def.db.entity.IT_KhIdouTyousyo;
import yuyu.def.db.entity.ZT_IdouTyousyoTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 異動調書Ｆ作成
 */
public class BzIdouTyousyoSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzIdouTyousyoSksDao bzIdouTyousyoSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String tysyttaisyouTableId = "IT_KhIdouTyousyo";
        String recoveryfilterID = "Bz001";
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
                String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
                kakutyouJobCd));

        try (ExDBResults<IT_KhIdouTyousyo> khIdouTyousyoList = bzIdouTyousyoSksDao.
                getIdouTyousyosByKakutyoujobcdSyoriYmd(kakutyouJobCd, syoriYmd);

                EntityInserter<ZT_IdouTyousyoTy> idouTyousyoTyInserter = new EntityInserter<>()) {

            long syoriKensuuKhIdouTyousyo = 0;

            long syoriKensuuIdouTyousyoTy = 0;

            for (IT_KhIdouTyousyo khIdouTyousyo : khIdouTyousyoList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryfilterID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khIdouTyousyo.getSyono());

                ZT_IdouTyousyoTy idouTyousyoTy = new ZT_IdouTyousyoTy();

                idouTyousyoTy.setZtysubsystemid("hozen");

                idouTyousyoTy.setZtysequenceno((int) syoriKensuuIdouTyousyoTy);

                if (khIdouTyousyo.getSyono().length() > 11) {

                    idouTyousyoTy.setZtysyono(khIdouTyousyo.getSyono().substring(0, 11));
                }
                else {

                    idouTyousyoTy.setZtysyono(khIdouTyousyo.getSyono());
                }

                idouTyousyoTy.setZtyhknsyukigou(khIdouTyousyo.getHknsyukigou());

                idouTyousyoTy.setZtykacd(khIdouTyousyo.getKacd());

                idouTyousyoTy.setZtytantocd(khIdouTyousyo.getTantocd().getValue());

                idouTyousyoTy.setZtysyorisosikicd(khIdouTyousyo.getSyorisosikicd());

                idouTyousyoTy.setZtyshrtysysyuruicd(khIdouTyousyo.getShrtysysyuruicd());

                idouTyousyoTy.setZtysyoritaisyoukbn(khIdouTyousyo.getSyoritaisyoukbn());

                if (khIdouTyousyo.getTblsakuseihunodisp().equals("1")) {
                    idouTyousyoTy.setZtybaitaiskshunoriyuukbn1(C_BaitaiSksHnRiyuuKbn.BAITAISAKUSEIHUKA.getValue());
                }
                else {
                    idouTyousyoTy.setZtybaitaiskshunoriyuukbn1(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());

                }

                idouTyousyoTy.setZtybaitaiskshunoriyuukbn2(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());

                idouTyousyoTy.setZtybaitaiskshunoriyuukbn3(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());

                idouTyousyoTy.setZtybaitaiskshunoriyuukbn4(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());

                idouTyousyoTy.setZtybaitaiskshunoriyuukbn5(C_BaitaiSksHnRiyuuKbn.BLNK.getValue());

                idouTyousyoTy.setZtyshrtysyjyuusyocd(khIdouTyousyo.getTsinyno());

                if ((khIdouTyousyo.getTsinadr1kj() + khIdouTyousyo.getTsinadr2kj()
                        + khIdouTyousyo.getTsinadr3kj()).length() > 62) {

                    idouTyousyoTy.setZtyshrtysyjyuusyo((khIdouTyousyo.getTsinadr1kj() + khIdouTyousyo.getTsinadr2kj()
                            + khIdouTyousyo.getTsinadr3kj()).substring(0, 62));
                }
                else {

                    idouTyousyoTy.setZtyshrtysyjyuusyo((khIdouTyousyo.getTsinadr1kj() + khIdouTyousyo.getTsinadr2kj()
                            + khIdouTyousyo.getTsinadr3kj()));
                }

                idouTyousyoTy.setZtykyknmkj35(khIdouTyousyo.getKyknmkj());

                idouTyousyoTy.setZtyyobiv3("000");

                idouTyousyoTy.setZtyyobiv25("");

                idouTyousyoTy.setZtyoldkykadrcd(khIdouTyousyo.getOldtsinyno());


                if ((khIdouTyousyo.getOldtsinadr1kj() + khIdouTyousyo.getOldtsinadr2kj()
                        + khIdouTyousyo.getOldtsinadr3kj()).length() > 62) {

                    idouTyousyoTy.setZtykjoldkykadr((khIdouTyousyo.getOldtsinadr1kj() + khIdouTyousyo.getOldtsinadr2kj() +
                            khIdouTyousyo.getOldtsinadr3kj()).substring(0, 62));
                }
                else {

                    idouTyousyoTy.setZtykjoldkykadr((khIdouTyousyo.getOldtsinadr1kj() + khIdouTyousyo.getOldtsinadr2kj() +
                            khIdouTyousyo.getOldtsinadr3kj()));
                }

                idouTyousyoTy.setZtykjoldkyknm35(khIdouTyousyo.getOldkyknmkj());

                idouTyousyoTy.setZtyyobiv3x2("000");

                idouTyousyoTy.setZtyyobiv25x1("");

                idouTyousyoTy.setZtyhhknnmkj(khIdouTyousyo.getHhknnmkj());

                idouTyousyoTy.setZtyyobiv3x3("000");

                idouTyousyoTy.setZtyyobiv17("");

                if (khIdouTyousyo.getOldkyksibouymd() == null) {

                    idouTyousyoTy.setZtykyksibouymd("00000000");
                }
                else {
                    idouTyousyoTy.setZtykyksibouymd(khIdouTyousyo.getOldkyksibouymd().toString());
                }

                if (khIdouTyousyo.getKouryokuhasseiymd() == null) {

                    idouTyousyoTy.setZtykouryokuhasseiymd("00000000");
                }
                else {

                    idouTyousyoTy.setZtykouryokuhasseiymd(khIdouTyousyo.getKouryokuhasseiymd().toString());
                }

                if (khIdouTyousyo.getKyksiboumeighnksyoriymd() == null) {
                    idouTyousyoTy.setZtykyksiboumeihensyoriymd("00000000");
                }
                else {
                    idouTyousyoTy.setZtykyksiboumeihensyoriymd(khIdouTyousyo.getKyksiboumeighnksyoriymd().toString());
                }

                idouTyousyoTy.setZtyyobiv8("00000000");

                idouTyousyoTy.setZtyyobiv8x2("00000000");

                idouTyousyoTy.setZtyyobiv8x3("00000000");

                idouTyousyoTy.setZtyyobiv8x4("00000000");

                idouTyousyoTy.setZtykyksibouhyoukagk(Long.valueOf(khIdouTyousyo.getKaiyakuhrstgk().toAdsoluteString()));

                idouTyousyoTy.setZtykihrkmp(Long.valueOf(khIdouTyousyo.getKihrkmp().toAdsoluteString()));

                idouTyousyoTy.setZtyoldkykkihrkmpyouhyj(khIdouTyousyo.getOldkykkihrkmpyouhyj());

                idouTyousyoTy.setZtyoldkykkihrkmp(Long.valueOf(khIdouTyousyo.getOldkykkihrkmp().toAdsoluteString()));

                idouTyousyoTy.setZtyyobin11(0L);

                idouTyousyoTy.setZtyyobin11x2(0L);

                idouTyousyoTy.setZtyyobin11x3(0L);

                idouTyousyoTy.setZtyyobin11x4(0L);

                if (khIdouTyousyo.getSakuseiymd() == null) {

                    idouTyousyoTy.setZtysakuseiymd("00000000");
                }
                else {
                    idouTyousyoTy.setZtysakuseiymd(khIdouTyousyo.getSakuseiymd().toString());
                }

                idouTyousyoTy.setZtyhuho2kykdisp(khIdouTyousyo.getHuho2kykdisp());

                idouTyousyoTy.setZtyshrtysyhknsyukbn(khIdouTyousyo.getShrtysyhknsyukbn().getContent());

                idouTyousyoTy.setZtyyobiv9("");

                idouTyousyoTy.setZtytekiyouranhensyuukbn1("00");

                idouTyousyoTy.setZtytekiyouranhensyuukbn2("00");

                idouTyousyoTy.setZtytekiyouranhensyuukbn3("00");

                idouTyousyoTy.setZtytekiyouranhensyuukbn4("00");

                idouTyousyoTy.setZtytekiyouranhensyuukbn5("00");

                idouTyousyoTy.setZtyyobiv116("");

                BizPropertyInitializer.initialize(idouTyousyoTy);

                idouTyousyoTyInserter.add(idouTyousyoTy);

                syoriKensuuKhIdouTyousyo = syoriKensuuKhIdouTyousyo + 1;

                syoriKensuuIdouTyousyoTy = syoriKensuuIdouTyousyoTy + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuuKhIdouTyousyo),
                    "契約保全異動調書テーブル"));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuuIdouTyousyoTy),
                    "異動調書テーブル（中）"));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
                SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}