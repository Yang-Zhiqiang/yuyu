package yuyu.batch.biz.bzmaster.bzginkoutorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HrkmKanouihyj;
import yuyu.def.classification.C_Kokunaikwskameihyj;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.def.db.entity.ZT_KinyuuKikanInfoRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（金融機関情報連動ファイルテーブル（連））を読み込み、銀行マスタに反映するクラス
 */
public class BzGinkouTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzGinkouTorikomiDao bzGinkouTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    public void execute() {

        Long kinyuuKikanInfoRnCount = zdbDomManager.getKinyuuKikanInfoRnCountByZrnsitencdNe4Space();

        if (kinyuuKikanInfoRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "金融機関情報連動ファイルテーブル（連）");

        }

        deleteGinkouData();

        BzRenkeiHenkanUtil<BM_Ginkou, BM_Ginkou> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();
        Long goukeiSyoriCount = 0L;

        bzRenkeiHenkanUtil.initialize(BM_Ginkou.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        for (int n = 0; n < 10; n++){
            goukeiSyoriCount += registGinkouData(bzRenkeiHenkanUtil,n);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(goukeiSyoriCount)));
    }

    @Transactional
    void deleteGinkouData() {

        bzGinkouTorikomiDao.deleteGinkou();
    }

    @Transactional
    Long registGinkouData(BzRenkeiHenkanUtil<BM_Ginkou, BM_Ginkou> pBzRenkeiHenkanUtil,int pBunkatuKensakuti) {

        Long syoriCount = 0L;

        try (EntityInserter<BM_Ginkou> entityInserter = new EntityInserter<>()) {

            try (ExDBResults<ZT_KinyuuKikanInfoRn> exDBResults =
                zdbDomManager.getKinyuuKikanInfoRnsByZrnkinyuukikancdKeta4Zrnsitencd(String.valueOf(pBunkatuKensakuti))) {

                BM_Ginkou bmGinkou = null;
                for (ZT_KinyuuKikanInfoRn ztKinyuuKikanInfoRn : exDBResults) {

                    bmGinkou = createGinkouData(ztKinyuuKikanInfoRn);

                    bmGinkou = pBzRenkeiHenkanUtil.convDouituBean(bmGinkou);

                    BizPropertyInitializer.initialize(bmGinkou);

                    entityInserter.add(bmGinkou);

                    syoriCount++;
                }
            }
        }
        return syoriCount;
    }

    private BM_Ginkou createGinkouData(ZT_KinyuuKikanInfoRn pZtKinyuuKikanInfoRn) {

        BM_Ginkou bmGinkou = new BM_Ginkou();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
            SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        bmGinkou.setBankcd(pZtKinyuuKikanInfoRn.getZrnkinyuukikancd());
        bmGinkou.setSitencd(pZtKinyuuKikanInfoRn.getZrnsitencd().substring(1));
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrnkousinymd());
        bmGinkou.setKousinymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrnsinsetuymd());
        bmGinkou.setSinsetuymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrnhaisiymd());
        bmGinkou.setHaisiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bmGinkou.setBanknmkn(pZtKinyuuKikanInfoRn.getZrnkanakinyuukikannm());
        bmGinkou.setSitennmkn(pZtKinyuuKikanInfoRn.getZrnkanasitennm());
        bmGinkou.setBanknmkj(pZtKinyuuKikanInfoRn.getZrnkanjikinyuukikannm());
        bmGinkou.setSitennmkj(pZtKinyuuKikanInfoRn.getZrnkanjisitennm());
        bmGinkou.setBanknmej(pZtKinyuuKikanInfoRn.getZrneijikinyuukikannm());
        bmGinkou.setSitennmej(pZtKinyuuKikanInfoRn.getZrneijisitennm());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrncsskyouteikaisiymd());
        bmGinkou.setCsskyouteikaisiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrncsskyouteikaijyoymd());
        bmGinkou.setCsskyouteikaijyoymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bmGinkou.setKokunaikwskameihyj(C_Kokunaikwskameihyj.valueOf(pZtKinyuuKikanInfoRn.getZrnkokunaikawasehyouji()));
        bmGinkou.setHrkmKanouihyj(C_HrkmKanouihyj.valueOf(pZtKinyuuKikanInfoRn.getZrnhurikomikanousitenhyouji()));

        return bmGinkou;
    }

}
