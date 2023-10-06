package yuyu.batch.biz.bzinterf.bzsikinidoulistcsvfsks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzinterf.bzsikinidoulistcsvfsks.dba.BzSikinIdouListCsvFSksDao;
import yuyu.batch.biz.bzinterf.bzsikinidoulistcsvfsks.dba.SikinIdouMeisaigkDataBean;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.file.csv.BzSikinIdouListCsvfFile;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SikinIdouListCsvFLayout;
import yuyu.def.db.entity.BT_SikinIdouListCsvFSks;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 資金移動リストＣＳＶファイル作成
 */
public class BzSikinIdouListCsvFSksBatch implements Batch {

    private static final String ZEROYEN = "0";

    private static final String ZEROGAI = "0.00";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzSikinIdouListCsvFSksDao bzSikinIdouListCsvFSksDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        HashMap<String, SikinIdouMeisaigkDataBean> sikinIdouMeisaigkDataMap = new HashMap<String, SikinIdouMeisaigkDataBean>();
        List<BzSikinIdouListCsvfFile> bzSikinIdouListCsvfFileList = new ArrayList<>();
        long syoriKensuu = 0;
        BizDate sikinidouYmd = syoriYmd.addBusinessDays(1);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        try (ExDBResults<SikinIdouMeisaigkDataBean> sikinIdouMeisaigkDataBeanList =
            bzSikinIdouListCsvFSksDao.getSikinIdouMeisaigkData(sikinidouYmd);) {

            for (SikinIdouMeisaigkDataBean sikinIdouMeisaigkDataBean : sikinIdouMeisaigkDataBeanList) {

                String mapKey = sikinIdouMeisaigkDataBean.getSikinidoulistkbn().getValue() +
                    sikinIdouMeisaigkDataBean.getSyukkinkouzatuukasyu().getValue() +
                    sikinIdouMeisaigkDataBean.getSyukkinkouzano() +
                    sikinIdouMeisaigkDataBean.getNyuukinkouzatuukasyu().getValue() +
                    sikinIdouMeisaigkDataBean.getNyuukinkouzano();

                sikinIdouMeisaigkDataMap.put(mapKey, sikinIdouMeisaigkDataBean);
            }
        }

        List<BM_SikinIdouListCsvFLayout> sikinIdouListCsvFLayoutList = bzSikinIdouListCsvFSksDao.getSikinIdouListCsvFLayout();

        for (BM_SikinIdouListCsvFLayout sikinIdouListCsvFLayout : sikinIdouListCsvFLayoutList) {

            BzSikinIdouListCsvfFile bzSikinIdouListCsvfFile = SWAKInjector.getInstance(BzSikinIdouListCsvfFile.class);
            bzSikinIdouListCsvfFile.setIfcSikinidouymd(String.valueOf(sikinidouYmd));
            bzSikinIdouListCsvfFile.setIfcSikinidoulist(sikinIdouListCsvFLayout.getSikinidoulistkbn().getContent());
            bzSikinIdouListCsvfFile.setIfcSyukkinkouza(sikinIdouListCsvFLayout.getSyukkinkouzakbn().getContent());
            bzSikinIdouListCsvfFile.setIfcNyuukinkouza(sikinIdouListCsvFLayout.getNyuukinkouzakbn().getContent());
            bzSikinIdouListCsvfFile.setIfcTuukasyu(sikinIdouListCsvFLayout.getSyukkinkouzatuukasyu().getValue());

            String mapKey = sikinIdouListCsvFLayout.getSikinidoulistkbn().getValue() +
                sikinIdouListCsvFLayout.getSyukkinkouzatuukasyu().getValue() +
                sikinIdouListCsvFLayout.getSyukkinkouzano() +
                sikinIdouListCsvFLayout.getNyuukinkouzatuukasyu().getValue() +
                sikinIdouListCsvFLayout.getNyuukinkouzano();

            if (sikinIdouMeisaigkDataMap.containsKey(mapKey)) {

                SikinIdouMeisaigkDataBean sikinIdouMeisaigkDataBean = sikinIdouMeisaigkDataMap.get(mapKey);
                bzSikinIdouListCsvfFile.setIfcSikinidoumeisaigk(String.valueOf(sikinIdouMeisaigkDataBean.getSikinidoumeisaigk()));

                syoriKensuu++;
            }

            else {
                if (C_Tuukasyu.JPY.eq(sikinIdouListCsvFLayout.getSyukkinkouzatuukasyu())) {

                    bzSikinIdouListCsvfFile.setIfcSikinidoumeisaigk(ZEROYEN);
                }

                else {

                    bzSikinIdouListCsvfFile.setIfcSikinidoumeisaigk(ZEROGAI);
                }
            }

            bzSikinIdouListCsvfFileList.add(bzSikinIdouListCsvfFile);
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn =bzFileUploadUtil.exec(
            C_FileSyuruiCdKbn.BZ_SIKINIDOULISTSIKINIDOUBICSVF,
            bzSikinIdouListCsvfFileList,
            true);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        List<BT_SikinIdouListCsvFSks> sikinIdouListCsvFSksList = bzSikinIdouListCsvFSksDao.getSksMotoData(sikinidouYmd);

        for (BT_SikinIdouListCsvFSks sikinIdouListCsvFSks : sikinIdouListCsvFSksList) {

            sikinIdouListCsvFSks.setFilesakuseiymd(syoriYmd);
            bizDomManager.update(sikinIdouListCsvFSks);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }
}
