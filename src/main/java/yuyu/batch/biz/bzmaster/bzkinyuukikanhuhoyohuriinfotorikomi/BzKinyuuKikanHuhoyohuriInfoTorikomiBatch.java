package yuyu.batch.biz.bzmaster.bzkinyuukikanhuhoyohuriinfotorikomi;

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
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.classification.C_TapekoukanKbn;
import yuyu.def.classification.C_TsrkeisanhouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.entity.ZT_KinyuuKikanInfoRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（金融機関情報連動ファイルテーブル（連））を読み込み、<br />
 * 金融機関普保預振情報マスタに反映するクラス<br />
 */
public class BzKinyuuKikanHuhoyohuriInfoTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzKinyuuKikanHuhoyohuriInfoTorikomiDao bzKinyuuKikanHuhoyohuriInfoTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    public void execute() {

        Long kinyuuKikanInfoRnCount = zdbDomManager.getKinyuuKikanInfoRnCountByZrnsitencdE4Space();

        if (kinyuuKikanInfoRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "金融機関情報連動ファイルテーブル（連）");

        }

        deleteKinyuuKikanHuhoyohuriInfoData();

        Long goukeiSyoriCount = 0L;

        BzRenkeiHenkanUtil<BM_KinyuuKikanHuhoyofuriInfo, BM_KinyuuKikanHuhoyofuriInfo> bzRenkeiHenkanUtilKinyuuKikan = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtilKinyuuKikan.initialize(BM_KinyuuKikanHuhoyofuriInfo.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
                C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        goukeiSyoriCount = registKinyuuKikanHuhoyohuriInfoData(bzRenkeiHenkanUtilKinyuuKikan);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(goukeiSyoriCount)));
    }

    @Transactional
    void deleteKinyuuKikanHuhoyohuriInfoData() {

        bzKinyuuKikanHuhoyohuriInfoTorikomiDao.deleteKinyuuKikanHuhoyohuriInfo();
    }

    @Transactional
    Long registKinyuuKikanHuhoyohuriInfoData(BzRenkeiHenkanUtil<BM_KinyuuKikanHuhoyofuriInfo, BM_KinyuuKikanHuhoyofuriInfo> pBzRenkeiHenkanUtil) {

        Long syoriCount = 0L;

        try (EntityInserter<BM_KinyuuKikanHuhoyofuriInfo> entityInserter = new EntityInserter<>()) {

            try (ExDBResults<ZT_KinyuuKikanInfoRn> exDBResults = zdbDomManager.getKinyuuKikanInfoRnsByZrnsitencdE4Space()) {

                BM_KinyuuKikanHuhoyofuriInfo kinyuuKikan = null;
                for (ZT_KinyuuKikanInfoRn ztKinyuuKikanInfoRn : exDBResults) {

                    kinyuuKikan = createKinyuuKikanHuhoyohuriInfoData(ztKinyuuKikanInfoRn);

                    kinyuuKikan = pBzRenkeiHenkanUtil.convDouituBean(kinyuuKikan);

                    BizPropertyInitializer.initialize(kinyuuKikan);

                    entityInserter.add(kinyuuKikan);

                    syoriCount++;
                }
            }
        }
        return syoriCount;
    }

    private BM_KinyuuKikanHuhoyofuriInfo createKinyuuKikanHuhoyohuriInfoData(ZT_KinyuuKikanInfoRn pZtKinyuuKikanInfoRn) {
        BM_KinyuuKikanHuhoyofuriInfo kinyuuKikan = new BM_KinyuuKikanHuhoyofuriInfo();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil = SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        kinyuuKikan.setBankcd(pZtKinyuuKikanInfoRn.getZrnkinyuukikancd());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrnyofurikyouteikaisiymd());
        kinyuuKikan.setYofurikyouteikaisiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrnyofurikyouteikaijyoymd());
        kinyuuKikan.setYofurikyouteikaijyoymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        kinyuuKikan.setItakusyakinyuucd(pZtKinyuuKikanInfoRn.getZrnitakusyakinyuucd());
        kinyuuKikan.setItakusyasitencd(pZtKinyuuKikanInfoRn.getZrnitakusyasitencd().substring(1));
        kinyuuKikan.setItakusyayokinkbn(C_YokinKbn.valueOf(pZtKinyuuKikanInfoRn.getZrnitakusyayokinkbn()));
        kinyuuKikan.setItakusyakouzano(pZtKinyuuKikanInfoRn.getZrnitakusyakouzano().substring(1));
        kinyuuKikan.setTsrkeisanhoukbn(C_TsrkeisanhouKbn.valueOf(pZtKinyuuKikanInfoRn.getZrntsrkeisanhoukbn()));
        kinyuuKikan.setKinyuutesuuryou(pZtKinyuuKikanInfoRn.getZrnkinyuutesuuryou());
        kinyuuKikan.setItakusyacd(pZtKinyuuKikanInfoRn.getZrnitakusyacd());
        kinyuuKikan.setTapekoukankbn1(C_TapekoukanKbn.valueOf(pZtKinyuuKikanInfoRn.getZrntapekoukankbn1()));
        kinyuuKikan.setMdsisyacd(pZtKinyuuKikanInfoRn.getZrnmdsisyacd());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrnzzkkyouteikaisiymd());
        kinyuuKikan.setZzkkyouteikaisiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrnzzkkyouteikaijyoymd());
        kinyuuKikan.setZzkkyouteikaijyoymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrncsskyouteikaisiymd());
        kinyuuKikan.setCsskyouteikaisiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrncsskyouteikaijyoymd());
        kinyuuKikan.setCsskyouteikaijyoymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtKinyuuKikanInfoRn.getZrnhuhoyofuriinfokousinymd());
        kinyuuKikan.setHuhoyofuriinfokousinymd(bzRenkeiHenkanUtil.getConvYmdBizDate());

        return kinyuuKikan;
    }

}
