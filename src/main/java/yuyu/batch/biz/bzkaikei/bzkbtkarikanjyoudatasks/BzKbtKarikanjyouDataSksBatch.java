package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoudatasks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoudatasks.dba.BzKbtKarikanjyouDataSksDao;
import yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoudatasks.dba.KbtKarikanjyouKrDenpyoDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_KbtKarikanjyou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 個別仮勘定データ作成
 */
public class BzKbtKarikanjyouDataSksBatch implements Batch {

    private final static String KBTKARIKANJYOUKBN_IPPAN = "01";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzKbtKarikanjyouDataSksDao bzKbtKarikanjyouDataSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        BizDate denymdFrom = syoriYmd.getBizDateYM().getPreviousMonth().getFirstDay();
        BizDate denymdTo = syoriYmd.getBizDateYM().getPreviousMonth().getLastDay();
        long count = 0;
        BizNumber kbtKarikanjyouSkbtkey = BizNumber.valueOf(0);

        try (ExDBResults<KbtKarikanjyouKrDenpyoDataBean> kbtKarikanjyouKrDenpyoDataBeanLst =
            bzKbtKarikanjyouDataSksDao.getKbtKarikanjyouKrDenpyoDataBeans(denymdFrom, denymdTo);

            EntityInserter<BT_KbtKarikanjyou> kbtKarikanjyouInserter = new EntityInserter<>();) {

            BizNumber kbtKarikanjyouSkbtkeyMax = bzKbtKarikanjyouDataSksDao.getKbtKarikanjyouSkbtkeyMax();
            if (kbtKarikanjyouSkbtkeyMax != null) {

                kbtKarikanjyouSkbtkey = kbtKarikanjyouSkbtkeyMax;
            }

            for (KbtKarikanjyouKrDenpyoDataBean kbtKarikanjyouKrDenpyoDataBean : kbtKarikanjyouKrDenpyoDataBeanLst) {

                kbtKarikanjyouSkbtkey = kbtKarikanjyouSkbtkey.add(BizNumber.valueOf(1));
                BT_KbtKarikanjyou kbtKarikanjyou = new BT_KbtKarikanjyou();
                kbtKarikanjyou.setKbtkarikanjyouskbtkey(kbtKarikanjyouSkbtkey);
                kbtKarikanjyou.setDensyskbn(kbtKarikanjyouKrDenpyoDataBean.getDensyskbn());
                kbtKarikanjyou.setDenrenno(kbtKarikanjyouKrDenpyoDataBean.getDenrenno());
                kbtKarikanjyou.setEdano(kbtKarikanjyouKrDenpyoDataBean.getEdano());
                kbtKarikanjyou.setKeirisyono(kbtKarikanjyouKrDenpyoDataBean.getKeirisyono());
                kbtKarikanjyou.setNyuukinkakusyouno(kbtKarikanjyouKrDenpyoDataBean.getNyuukinkakusyouno());
                kbtKarikanjyou.setHurikaedenskssyoriymd(kbtKarikanjyouKrDenpyoDataBean.getSyoriYmd());
                kbtKarikanjyou.setDenymd(kbtKarikanjyouKrDenpyoDataBean.getDenymd());
                kbtKarikanjyou.setHuridenatesakicd(kbtKarikanjyouKrDenpyoDataBean.getHuridenatesakicd());
                kbtKarikanjyou.setTaisyakukbn(kbtKarikanjyouKrDenpyoDataBean.getTaisyakukbn());
                kbtKarikanjyou.setKanjyoukmkcd(C_Kanjyoukmkcd.valueOf(kbtKarikanjyouKrDenpyoDataBean.getDenkanjokamokucd()));
                kbtKarikanjyou.setDenyenkagk(kbtKarikanjyouKrDenpyoDataBean.getDenyenkagk());
                kbtKarikanjyou.setSyoricd(kbtKarikanjyouKrDenpyoDataBean.getSyoricd());
                kbtKarikanjyou.setSyorisosikicd(kbtKarikanjyouKrDenpyoDataBean.getSyorisosikicd());
                kbtKarikanjyou.setKbtkarikanjyoukbn(KBTKARIKANJYOUKBN_IPPAN);
                kbtKarikanjyou.setSeg1cd(kbtKarikanjyouKrDenpyoDataBean.getSeg1cd());
                kbtKarikanjyou.setSyoriYmd(syoriYmd);
                BizPropertyInitializer.initialize(kbtKarikanjyou);
                kbtKarikanjyouInserter.add(kbtKarikanjyou);

                count++;
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }
}
