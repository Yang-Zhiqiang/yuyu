package yuyu.batch.hozen.khinterf.khkessanzennoufsks;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khkessanzennoufsks.dba.KessanZennouBean;
import yuyu.batch.hozen.khinterf.khkessanzennoufsks.dba.KhKessanZennouFSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.db.entity.ZT_KessanZennouFTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 決算用前納Ｆ作成クラス
 */
public class KhKessanZennouFSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKessanZennouFSksDao khKessanZennouFSksDao;

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

        try(
            ExDBResults<KessanZennouBean> KhKessanZennouFSksList =
            khKessanZennouFSksDao.getKessanZennou(bzBatchParam.getSyoriYmd());

            EntityInserter<ZT_KessanZennouFTy> entityInserter = new EntityInserter<ZT_KessanZennouFTy>();){

            for (KessanZennouBean kessanZennouBean : KhKessanZennouFSksList) {

                ZT_KessanZennouFTy kessanZennouFTy = new ZT_KessanZennouFTy();

                kessanZennouFTy.setZtyraysystemhyj("1");

                kessanZennouFTy.setZtysyono(kessanZennouBean.getSyono());

                kessanZennouFTy.setZtykbnkeiriyousegmentcd(kessanZennouBean.getKbnkeirisegcd().getValue());

                kessanZennouFTy.setZtyzennoutoukeilistkbn(kessanZennouBean.getZennoutoukeilistkbn().getValue());

                kessanZennouFTy.setZtyzennoukbn(kessanZennouBean.getZennoukbn().getValue());

                kessanZennouFTy.setZtyzennoukaisiymd(kessanZennouBean.getZennoukaisiymd().toString());

                kessanZennouFTy.setZtyzennoukaisijizndk(
                    new BigDecimal(kessanZennouBean.getZennoukaisijizndk().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtykykymd(kessanZennouBean.getKeiyakuymd().toString());

                kessanZennouFTy.setZtyzennouwrbkrt(kessanZennouBean.getZennouwrbkrt());

                kessanZennouFTy.setZtyrthndzndk1(
                    new BigDecimal(kessanZennouBean.getRthndzndk1().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtytkyrt1(kessanZennouBean.getTkyrt1());

                if (kessanZennouBean.getRthndymd1() != null) {
                    kessanZennouFTy.setZtyrthndymd1(kessanZennouBean.getRthndymd1().toString());
                }
                kessanZennouFTy.setZtyrthndzndk2(
                    new BigDecimal(kessanZennouBean.getRthndzndk2().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtytkyrt2(kessanZennouBean.getTkyrt2());

                if (kessanZennouBean.getRthndymd2() != null) {
                    kessanZennouFTy.setZtyrthndymd2(kessanZennouBean.getRthndymd2().toString());
                }

                kessanZennouFTy.setZtyrthndzndk3(
                    new BigDecimal(kessanZennouBean.getRthndzndk3().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtytkyrt3(kessanZennouBean.getTkyrt3());

                if (kessanZennouBean.getRthndymd3() != null) {
                    kessanZennouFTy.setZtyrthndymd3(kessanZennouBean.getRthndymd3().toString());
                }

                kessanZennouFTy.setZtyrthndzndk4(
                    new BigDecimal(kessanZennouBean.getRthndzndk4().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtytkyrt4(kessanZennouBean.getTkyrt4());

                if (kessanZennouBean.getRthndymd4() != null) {
                    kessanZennouFTy.setZtyrthndymd4(kessanZennouBean.getRthndymd4().toString());
                }

                kessanZennouFTy.setZtytndmatuzndk(
                    new BigDecimal(kessanZennouBean.getTndmatuzndk().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtytndmatutkyrt(kessanZennouBean.getTndmatutkyrt());

                kessanZennouFTy.setZtyzennounyuukinymd(kessanZennouBean.getZennounyuukinymd().toString());

                kessanZennouFTy.setZtytndzndkhikakukbn(kessanZennouBean.getTndzndkhikakukbn());

                kessanZennouFTy.setZtyzennoukikan(kessanZennouBean.getZennoukikan());

                kessanZennouFTy.setZtybosyuukeitaikbn(kessanZennouBean.getBosyuukeitaikbn());

                kessanZennouFTy.setZtygkdtznnhyj(kessanZennouBean.getGkdtznnhyj());

                kessanZennouFTy.setZtygaikakbn(kessanZennouBean.getZnngaikakbn());

                kessanZennouFTy.setZtyyenkanyknhyj(kessanZennouBean.getYenkanyknhyj());

                kessanZennouFTy.setZtynyknjikawaserate(kessanZennouBean.getZnnnyknjikawaserate());

                if(kessanZennouBean.getZnnnyknjikawaseratetkyuymd() != null) {
                    kessanZennouFTy.setZtynyknjikawaseratetkyuymd(kessanZennouBean.getZnnnyknjikawaseratetkyuymd().toString());
                }

                kessanZennouFTy.setZtyksnkisikawaserate(kessanZennouBean.getKsnkisikawaserate());

                kessanZennouFTy.setZtytndmatuzndkksnjkwsrate(kessanZennouBean.getTndmatuzndkksnjkwsrate());

                kessanZennouFTy.setZtyzennounyuukinkgkgaika(
                    new BigDecimal(kessanZennouBean.getZennounyuukinkgkgaika().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtyzennounyuukinkgktkmatu(
                    new BigDecimal(kessanZennouBean.getZennounyuukinkgktkmatu().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtyzennoukaisijizndktkmatu(
                    new BigDecimal(kessanZennouBean.getZennoukaisijizndktkmatu().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtyrthndzndk1tkmatu(
                    new BigDecimal(kessanZennouBean.getRthndzndk1tkmatu().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtyrthndzndk2tkmatu(
                    new BigDecimal(kessanZennouBean.getRthndzndk2tkmatu().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtyrthndzndk3tkmatu(
                    new BigDecimal(kessanZennouBean.getRthndzndk3tkmatu().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtyrthndzndk4tkmatu(
                    new BigDecimal(kessanZennouBean.getRthndzndk4tkmatu().toAdsoluteString()).longValue());

                kessanZennouFTy.setZtytndmatuzndktkmatu(
                    new BigDecimal(kessanZennouBean.getTndmatuzndktkmatu().toAdsoluteString()).longValue());

                BizPropertyInitializer.initialize(kessanZennouFTy);

                entityInserter.add(kessanZennouFTy);

                syoriKensuu++;
            }

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

    }

}