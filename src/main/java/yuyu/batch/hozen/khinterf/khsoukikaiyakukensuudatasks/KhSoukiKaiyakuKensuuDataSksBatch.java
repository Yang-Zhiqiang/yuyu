package yuyu.batch.hozen.khinterf.khsoukikaiyakukensuudatasks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khsoukikaiyakukensuudatasks.dba.KhSoukiKaiyakuKensuuDataBean;
import yuyu.batch.hozen.khinterf.khsoukikaiyakukensuudatasks.dba.KhSoukiKaiyakuKensuuDataSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.hozen.file.csv.KhSoukiKaiyakuKensuuDataCsvFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 契約保全早期解約件数データ作成クラス
 */
public class KhSoukiKaiyakuKensuuDataSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhSoukiKaiyakuKensuuDataSksDao khSoukiKaiyakuKensuuDataSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd()))));

        BizDate taisyouKknFrom = null;
        BizDate taisyouKknTo = null;

        if (bzBatchParam.getSyoriYmd().getMonth() == 4 || bzBatchParam.getSyoriYmd().getMonth() == 5) {
            taisyouKknFrom = BizDate.valueOf(bzBatchParam.getSyoriYmd().getPreviousYear().getBizDateY(), 4, 1);
            taisyouKknTo = BizDate.valueOf(bzBatchParam.getSyoriYmd().getBizDateY(), 3, 31);
        }
        else if (bzBatchParam.getSyoriYmd().getMonth() == 10 || bzBatchParam.getSyoriYmd().getMonth() == 11) {
            taisyouKknFrom = BizDate.valueOf(bzBatchParam.getSyoriYmd().getBizDateY(), 4, 1);
            taisyouKknTo = BizDate.valueOf(bzBatchParam.getSyoriYmd().getBizDateY(), 9, 30);
        }

        long skikaiykkensuu = 0;
        long skikaiykkensuuznkizennou = 0;
        long skikaiykkensuuitiji = 0;
        long skikaiykkensuuitiji3y = 0;

        try (ExDBResults<KhSoukiKaiyakuKensuuDataBean> khSoukiKaiyakuKensuuDataSksBeanLst =
            khSoukiKaiyakuKensuuDataSksDao.getKhSoukiKaiyakuKensuuDataBean(taisyouKknFrom, taisyouKknTo)) {

            for (KhSoukiKaiyakuKensuuDataBean khSoukiKaiyakuKensuuDataSksBean : khSoukiKaiyakuKensuuDataSksBeanLst) {

                int kankakuGetusuu = BizDateUtil.calcDifferenceMonths(
                    khSoukiKaiyakuKensuuDataSksBean.getIT_KykSyouhn().getSyoumetuymd().getBizDateYM(),
                    khSoukiKaiyakuKensuuDataSksBean.getIT_KykKihon().getBosyuuym());

                if (kankakuGetusuu <= 4) {
                    skikaiykkensuu++;

                    if (khSoukiKaiyakuKensuuDataSksBean.getIT_KykSyouhn().getHknkkn() == 99
                        && C_Hrkkaisuu.NEN.eq(khSoukiKaiyakuKensuuDataSksBean.getIT_KykKihon().getHrkkaisuu())
                        && C_Hrkkeiro.HURIKAE.eq(khSoukiKaiyakuKensuuDataSksBean.getIT_KykKihon().getHrkkeiro())) {
                        skikaiykkensuuznkizennou++;
                    }
                    else if (C_Kykjyoutai.ITIJIBARAI.eq(khSoukiKaiyakuKensuuDataSksBean.getIT_KykSyouhn().getKykjyoutai())) {
                        skikaiykkensuuitiji++;
                    }
                }

                BizDate hanteiYmd = khSoukiKaiyakuKensuuDataSksBean.getIT_KykSyouhn().getKykymd().addYears(3).getRekijyou();

                if ((BizDateUtil.compareYmd(khSoukiKaiyakuKensuuDataSksBean.getIT_KykSyouhn().getSyoumetuymd(),
                    hanteiYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(khSoukiKaiyakuKensuuDataSksBean.getIT_KykSyouhn().getSyoumetuymd(),
                        hanteiYmd) == BizDateUtil.COMPARE_EQUAL) &&
                        (C_Kykjyoutai.ITIJIBARAI.eq(khSoukiKaiyakuKensuuDataSksBean.getIT_KykSyouhn().getKykjyoutai()))) {
                    skikaiykkensuuitiji3y++;
                }
            }

            List<KhSoukiKaiyakuKensuuDataCsvFile> khSoukiKaiyakuKensuuDataCsvFileList = new ArrayList<>();

            KhSoukiKaiyakuKensuuDataCsvFile khSoukiKaiyakuKensuuDataCsvFile =
                SWAKInjector.getInstance(KhSoukiKaiyakuKensuuDataCsvFile.class);

            khSoukiKaiyakuKensuuDataCsvFile.setIfcSkikaiykkensuu(String.valueOf(skikaiykkensuu));
            khSoukiKaiyakuKensuuDataCsvFile.setIfcSkikaiykkensuuznkizennou(String.valueOf(skikaiykkensuuznkizennou));
            khSoukiKaiyakuKensuuDataCsvFile.setIfcSkikaiykkensuuitiji(String.valueOf(skikaiykkensuuitiji));
            khSoukiKaiyakuKensuuDataCsvFile.setIfcSkikaiykkensuuitiji3y(String.valueOf(skikaiykkensuuitiji3y));

            khSoukiKaiyakuKensuuDataCsvFileList.add(khSoukiKaiyakuKensuuDataCsvFile);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.KH_SOUKIKAIYAKUKENSUUDATACSVF,
                khSoukiKaiyakuKensuuDataCsvFileList,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, "ファイルアップロードユーティリティ");
            }

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(skikaiykkensuu), "早期解約契約件数"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(skikaiykkensuuznkizennou), "前納契約早期解約件数"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(skikaiykkensuuitiji), "一時払い契約早期解約件数"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(skikaiykkensuuitiji3y), "一時払い契約３年以内解約件数"));
    }
}
