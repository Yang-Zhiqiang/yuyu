package yuyu.batch.hozen.khinterf.khzennouhoyuuidoufsks;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khzennouhoyuuidoufsks.dba.KhZennouHoyuuIdouFSksDao;
import yuyu.batch.hozen.khinterf.khzennouhoyuuidoufsks.dba.ZennouHoyuuIdouKykDtlBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 前納保有異動契約明細Ｆ作成
 */
public class KhZennouHoyuuIdouFSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhZennouHoyuuIdouFSksDao khZennouHoyuuIdouFSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        long syoriKensuu = 0;

        try (ExDBResults<ZennouHoyuuIdouKykDtlBean> zennouHoyuuIdouKykDtlBeanLst =
            khZennouHoyuuIdouFSksDao.getZennouHoyuuIdouKykDtlBeans(bzBatchParam.getSyoriYmd());

            EntityInserter<ZT_ZennouHoyuuIdouKykDtlTy> zennouHoyuuIdouKykDtlTyInserter = new EntityInserter<>();) {

            for (ZennouHoyuuIdouKykDtlBean zennouHoyuuIdouKykDtlBean : zennouHoyuuIdouKykDtlBeanLst) {

                BizDate znnnyknjiKawaserateTkyuYmd = zennouHoyuuIdouKykDtlBean.getZnnnyknjikawaseratetkyuymd();

                if (znnnyknjiKawaserateTkyuYmd == null) {

                    znnnyknjiKawaserateTkyuYmd = BizDate.valueOf(00000000);
                }

                ZT_ZennouHoyuuIdouKykDtlTy zennouHoyuuIdouKykDtlTy = new ZT_ZennouHoyuuIdouKykDtlTy();
                zennouHoyuuIdouKykDtlTy.setZtyraysystemhyj("1");
                zennouHoyuuIdouKykDtlTy.setZtyrecordkbn(zennouHoyuuIdouKykDtlBean.getZennoukessanrecordkbn());
                zennouHoyuuIdouKykDtlTy.setZtykeijyouym(String.valueOf(zennouHoyuuIdouKykDtlBean.getKeijyouym()));
                zennouHoyuuIdouKykDtlTy.setZtysyoricd(zennouHoyuuIdouKykDtlBean.getSyoricd());
                zennouHoyuuIdouKykDtlTy.setZtyhenkousyoriymd(
                    String.valueOf(zennouHoyuuIdouKykDtlBean.getHenkousyoriymd()));
                zennouHoyuuIdouKykDtlTy.setZtydenymd(String.valueOf(zennouHoyuuIdouKykDtlBean.getDenymd()));
                zennouHoyuuIdouKykDtlTy.setZtyzennoucalckijyunymd(
                    String.valueOf(zennouHoyuuIdouKykDtlBean.getZennoucalckijyunymd()));
                zennouHoyuuIdouKykDtlTy.setZtykykmfksnctr(zennouHoyuuIdouKykDtlBean.getKykmfksnctr());
                zennouHoyuuIdouKykDtlTy.setZtyzennoubikinkbn(
                    zennouHoyuuIdouKykDtlBean.getZennoubikinkbn().getValue());
                zennouHoyuuIdouKykDtlTy.setZtydatakanrino(zennouHoyuuIdouKykDtlBean.getSyono());
                zennouHoyuuIdouKykDtlTy.setZtysyukeiyakusyuruicdv2(zennouHoyuuIdouKykDtlBean.getSyukeiyakusyuruicd());
                zennouHoyuuIdouKykDtlTy.setZtykbnkeiriyousegmentcd(
                    zennouHoyuuIdouKykDtlBean.getKbnkeirisegcd().getValue());
                zennouHoyuuIdouKykDtlTy.setZtyzennoutoukeilistkbn(
                    zennouHoyuuIdouKykDtlBean.getZennoutoukeilistkbn().getValue());
                zennouHoyuuIdouKykDtlTy.setZtykykymd(String.valueOf(zennouHoyuuIdouKykDtlBean.getKeiyakuymd()));
                zennouHoyuuIdouKykDtlTy.setZtyzennouwrbkrt(zennouHoyuuIdouKykDtlBean.getZennouwrbkrt());
                zennouHoyuuIdouKykDtlTy.setZtytkyrt1(zennouHoyuuIdouKykDtlBean.getTndmatutkyrt());
                zennouHoyuuIdouKykDtlTy.setZtytndzndkhikakukbn(zennouHoyuuIdouKykDtlBean.getTndzndkhikakukbn());
                zennouHoyuuIdouKykDtlTy.setZtyzennoukaisiymd(
                    String.valueOf(zennouHoyuuIdouKykDtlBean.getZennoukaisiymd()));
                zennouHoyuuIdouKykDtlTy.setZtyzennoukbn(zennouHoyuuIdouKykDtlBean.getZennoukbn().getValue());
                zennouHoyuuIdouKykDtlTy.setZtyzennoukikan(zennouHoyuuIdouKykDtlBean.getZennoukikan());
                zennouHoyuuIdouKykDtlTy.setZtyzennounyuukinymd(
                    String.valueOf(zennouHoyuuIdouKykDtlBean.getZennounyuukinymd()));
                zennouHoyuuIdouKykDtlTy.setZtyzennounyuukinkgk(
                    new BigDecimal(zennouHoyuuIdouKykDtlBean.getZennounyuukinkgk().toAdsoluteString()).longValue());
                zennouHoyuuIdouKykDtlTy.setZtytoukimatuzennouzndk(
                    new BigDecimal(zennouHoyuuIdouKykDtlBean.getToukimatuzennouzndk().toAdsoluteString()).longValue());
                zennouHoyuuIdouKykDtlTy.setZtytoukijyuutoup(
                    new BigDecimal(zennouHoyuuIdouKykDtlBean.getToukijyuutoup().toAdsoluteString()).longValue());
                zennouHoyuuIdouKykDtlTy.setZtytoukizennouseisangk(
                    new BigDecimal(zennouHoyuuIdouKykDtlBean.getToukizennouseisangk().toAdsoluteString()).longValue());
                zennouHoyuuIdouKykDtlTy.setZtytoukizennounyuukinkgk(
                    new BigDecimal(zennouHoyuuIdouKykDtlBean.getToukizennounyuukinkgk().toAdsoluteString()).longValue());
                zennouHoyuuIdouKykDtlTy.setZtyyokukinenbaraip(
                    new BigDecimal(zennouHoyuuIdouKykDtlBean.getYokukinenbaraip().toAdsoluteString()).longValue());
                zennouHoyuuIdouKykDtlTy.setZtywrbkrttkyrttekiyouzndk(
                    new BigDecimal(zennouHoyuuIdouKykDtlBean.getWrbkrttkyrt().toAdsoluteString()).longValue());
                zennouHoyuuIdouKykDtlTy.setZtygkdtznnhyj(zennouHoyuuIdouKykDtlBean.getGkdtznnhyj());
                zennouHoyuuIdouKykDtlTy.setZtygaikakbn(zennouHoyuuIdouKykDtlBean.getZnngaikakbn());
                zennouHoyuuIdouKykDtlTy.setZtyyenkanyknhyj(zennouHoyuuIdouKykDtlBean.getYenkanyknhyj());
                zennouHoyuuIdouKykDtlTy.setZtynyknjikawaserate(zennouHoyuuIdouKykDtlBean.getZnnnyknjikawaserate());
                zennouHoyuuIdouKykDtlTy.setZtynyknjikawaseratetkyuymd(znnnyknjiKawaserateTkyuYmd.toString());
                zennouHoyuuIdouKykDtlTy.setZtyksnkisikawaserate(zennouHoyuuIdouKykDtlBean.getKsnkisikawaserate());
                zennouHoyuuIdouKykDtlTy.setZtyznncalckjynymdkwsrate(zennouHoyuuIdouKykDtlBean.getZnncalckjynymdkwsrate());
                zennouHoyuuIdouKykDtlTy.setZtyksnkimatukawaserate(zennouHoyuuIdouKykDtlBean.getKsnkimatukawaserate());
                zennouHoyuuIdouKykDtlTy.setZtyzennounyuukinkgktkmatu(
                    new BigDecimal(zennouHoyuuIdouKykDtlBean.getZennounyuukinkgktkmatu().toAdsoluteString()).longValue());
                zennouHoyuuIdouKykDtlTy.setZtytkmatuznnzndktkmatu(
                    new BigDecimal(zennouHoyuuIdouKykDtlBean.getTkmatuznnzndktkmatu().toAdsoluteString()).longValue());

                BizPropertyInitializer.initialize(zennouHoyuuIdouKykDtlTy);

                zennouHoyuuIdouKykDtlTyInserter.add(zennouHoyuuIdouKykDtlTy);

                syoriKensuu++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }
}