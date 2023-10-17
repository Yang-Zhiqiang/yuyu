package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoukesikomi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoukesikomi.dba.BzKbtKarikanjyouKesikomiDao;
import yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoukesikomi.dba.KbtKarikanjyouKesikomiDataBean;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.BT_KbtKarikanjyou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 個別仮勘定消込
 */
public class BzKbtKarikanjyouKesikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzKbtKarikanjyouKesikomiDao bzKbtKarikanjyouKesikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long count = 0;
        HashMap<String, List<KbtKarikanjyouKesikomiDataBean>> kasikataMap = new HashMap<String, List<KbtKarikanjyouKesikomiDataBean>>();
        String mapKey = "";

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf( bzBatchParam.getSyoriYmd())));

        try (
            ExDBResults<KbtKarikanjyouKesikomiDataBean> kbtKarikanjyouKesikomiDataBeanKarikataLst =
            bzKbtKarikanjyouKesikomiDao.getKbtKarikanjyouKesikomiByTaisyakuKbn(C_TaisyakuKbn.KARIKATA);

            ExDBResults<KbtKarikanjyouKesikomiDataBean> kbtKarikanjyouKesikomiDataBeanKasikataLst =
                bzKbtKarikanjyouKesikomiDao.getKbtKarikanjyouKesikomiByTaisyakuKbn(C_TaisyakuKbn.KASIKATA);

            EntityUpdater<BT_KbtKarikanjyou> kbtKarikanjyou = new EntityUpdater<>();) {

            for (KbtKarikanjyouKesikomiDataBean kbtKarikanjyouKesikomiDataBean : kbtKarikanjyouKesikomiDataBeanKasikataLst) {

                mapKey = kbtKarikanjyouKesikomiDataBean.getKanjyoukmkcd() +  "," +
                    kbtKarikanjyouKesikomiDataBean.getKeirisyono() + "," +
                    kbtKarikanjyouKesikomiDataBean.getDenyenkagk();

                List<KbtKarikanjyouKesikomiDataBean> mapKbtKarikanjyouKesikomiDataBeanLst =  kasikataMap.get(mapKey);

                if (mapKbtKarikanjyouKesikomiDataBeanLst == null) {

                    mapKbtKarikanjyouKesikomiDataBeanLst = new ArrayList<KbtKarikanjyouKesikomiDataBean>();
                    mapKbtKarikanjyouKesikomiDataBeanLst.add(kbtKarikanjyouKesikomiDataBean);
                    kasikataMap.put(mapKey, mapKbtKarikanjyouKesikomiDataBeanLst);

                }
                else {

                    mapKbtKarikanjyouKesikomiDataBeanLst.add(kbtKarikanjyouKesikomiDataBean);

                }
            }

            for (KbtKarikanjyouKesikomiDataBean kbtKarikanjyouKesikomiDataBean : kbtKarikanjyouKesikomiDataBeanKarikataLst) {

                mapKey = kbtKarikanjyouKesikomiDataBean.getKanjyoukmkcd() +  "," +
                    kbtKarikanjyouKesikomiDataBean.getKeirisyono() + "," +
                    kbtKarikanjyouKesikomiDataBean.getDenyenkagk();

                List<KbtKarikanjyouKesikomiDataBean> mapKbtKarikanjyouKesikomiDataBeanLst =  kasikataMap.get(mapKey);
                if (mapKbtKarikanjyouKesikomiDataBeanLst != null) {

                    BT_KbtKarikanjyou btKarikanjyouKarikata = bizDomManager.getKbtKarikanjyou(
                        kbtKarikanjyouKesikomiDataBean.getKbtkarikanjyouskbtkey());

                    BT_KbtKarikanjyou btKarikanjyouKasikata = bizDomManager.getKbtKarikanjyou(
                        mapKbtKarikanjyouKesikomiDataBeanLst.get(0).getKbtkarikanjyouskbtkey());

                    btKarikanjyouKarikata.setKskmkanryouymd(bzBatchParam.getSyoriYmd());
                    btKarikanjyouKasikata.setKskmkanryouymd(bzBatchParam.getSyoriYmd());

                    kbtKarikanjyou.add(btKarikanjyouKarikata);
                    kbtKarikanjyou.add(btKarikanjyouKasikata);

                    count = count + 2;

                    if (mapKbtKarikanjyouKesikomiDataBeanLst.size() == 1) {

                        kasikataMap.remove(mapKey);
                    }
                    else {

                        mapKbtKarikanjyouKesikomiDataBeanLst.remove(0);
                    }
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }
}
