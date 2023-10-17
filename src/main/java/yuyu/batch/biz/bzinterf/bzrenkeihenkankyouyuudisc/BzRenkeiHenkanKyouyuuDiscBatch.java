package yuyu.batch.biz.bzinterf.bzrenkeihenkankyouyuudisc;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.db.entity.BT_SystemRenkei;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 連携項目変換処理（共有ディスク方式）クラス
 */
public class BzRenkeiHenkanKyouyuuDiscBatch<T1, T2 extends AbstractExDBEntity<T2, ?>> implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRenkeiHenkanKyouyuuDiscBatchParam bzRenkeiHenkanKyouyuuDiscBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRenkeiHenkanKyouyuuDiscDao bzRenkeiHenkanKyouyuuDiscDao;

    public final String INTERFACEID = "インターフェースＩＤ";

    public final String SYORIHOUSIKI = "処理方式";

    public final String HENKANHOUKOU = "変換方向";

    public final String HENKANMAELAYOUTNAME = "変換前レイアウト名";

    public final String HENKANGOLAYOUTNAME = "変換後レイアウト名";

    @Override
    public BatchParam getParam() {
        return bzRenkeiHenkanKyouyuuDiscBatchParam;
    }

    @SuppressWarnings("unchecked")
    @Execute
    @Transactional
    public void execute() {

        String interfaceId = bzRenkeiHenkanKyouyuuDiscBatchParam.getInterfaceId();

        if (BizUtil.isBlank(interfaceId)) {

            throw new BizAppException(MessageId.EBF0010, String.valueOf(interfaceId));

        }

        BT_SystemRenkei btSystemRenkei = bizDomManager.getSystemRenkei(interfaceId);

        if (btSystemRenkei == null) {

            throw new BizAppException(MessageId.EBF0010, interfaceId);

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, INTERFACEID,
            btSystemRenkei.getInterfaceid()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, SYORIHOUSIKI,
            btSystemRenkei.getSyorihousiki().getValue()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, HENKANHOUKOU,
            btSystemRenkei.getHenkanhoukou().getValue()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, HENKANMAELAYOUTNAME,
            btSystemRenkei.getHenkanmaelayoutname()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, HENKANGOLAYOUTNAME,
            btSystemRenkei.getHenkangolayoutname()));

        bzRenkeiHenkanKyouyuuDiscDao.deleteByTableid(btSystemRenkei.getHenkangolayoutid());

        long henkanMaeRecordKensu = bzRenkeiHenkanKyouyuuDiscDao.getCountByTableid(
            btSystemRenkei.getHenkanmaelayoutid());

        if (henkanMaeRecordKensu == 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(henkanMaeRecordKensu)));

            return;

        }

        try (ExDBResults<T1> henkanMaeDataList = bzRenkeiHenkanKyouyuuDiscDao.getAllByTableid(
            btSystemRenkei.getHenkanmaelayoutid());
            EntityInserter<T2> entityInserter = new EntityInserter<>()) {

            String tableTeigiInfoKakunouPackage = YuyuBizConfig.getInstance().getTableTeigiInfoKakunouPass();

            String tableTeigiInfoKakunouPass = tableTeigiInfoKakunouPackage.concat(
                btSystemRenkei.getHenkangolayoutid());

            Class<T1> henkanMaeClass = null;
            Class<T2> henkanGoClass = null;
            try {

                henkanMaeClass = (Class<T1>) Class.forName(tableTeigiInfoKakunouPackage.concat(
                    btSystemRenkei.getHenkanmaelayoutid()));

                henkanGoClass = (Class<T2>) Class.forName(tableTeigiInfoKakunouPass);

            } catch (ClassNotFoundException e) {
            }

            BzRenkeiHenkanUtil<T1, T2> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<T1, T2>();

            long henkanGoRecordKensu = 0;

            bzRenkeiHenkanUtil.initialize(henkanMaeClass,
                henkanGoClass,
                btSystemRenkei.getSyorihousiki(),
                btSystemRenkei.getHenkanhoukou());

            for (T1 henkanMaeData :henkanMaeDataList) {

                T2 henkanGoData = bzRenkeiHenkanUtil.convBean(henkanMaeData);

                entityInserter.add(henkanGoData);

                henkanGoRecordKensu ++;

            }

            if (henkanMaeRecordKensu == henkanGoRecordKensu) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(henkanGoRecordKensu)));

            }
            else {

                throw new BizAppException(MessageUtil.getMessage(MessageId.EBF1003,
                    btSystemRenkei.getHenkanmaelayoutname(),
                    String.valueOf(henkanMaeRecordKensu),
                    btSystemRenkei.getHenkangolayoutname(),
                    String.valueOf(henkanGoRecordKensu)));

            }

            if (C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER.eq(btSystemRenkei.getHenkanhoukou())) {

                bzRenkeiHenkanKyouyuuDiscDao.deleteByTableid(btSystemRenkei.getHenkanmaelayoutid());

            }
        }
    }
}
