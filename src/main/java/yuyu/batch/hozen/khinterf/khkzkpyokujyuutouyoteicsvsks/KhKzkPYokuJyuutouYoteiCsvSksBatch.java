package yuyu.batch.hozen.khinterf.khkzkpyokujyuutouyoteicsvsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khkzkpyokujyuutouyoteicsvsks.dba.KhKzkPYokuJyuutouYoteiCsvSksDao;
import yuyu.batch.hozen.khinterf.khkzkpyokujyuutouyoteicsvsks.dba.KhKzkPYokuJyuutouYoteiWkBean;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.hozen.file.csv.KhKzkPYokuJyuutouYoteiFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 継続Ｐ翌月充当予定ＣＳＶ作成
 */
public class KhKzkPYokuJyuutouYoteiCsvSksBatch implements Batch {

    private final int CSV_MAX_KENSUU = 30000;

    private  List<KhKzkPYokuJyuutouYoteiWkBean> uSdKhKzkPYokuJyuutouYoteiWkLst = new ArrayList<>();

    private  List<KhKzkPYokuJyuutouYoteiWkBean> aUdKhKzkPYokuJyuutouYoteiWkLst = new ArrayList<>();

    private  List<KhKzkPYokuJyuutouYoteiWkBean> jPyKhKzkPYokuJyuutouYoteiWkLst = new ArrayList<>();

    private  List<KhKzkPYokuJyuutouYoteiFile> khKzkPYokuJyuutouYoteiFileLst = new ArrayList<>();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private KhKzkPYokuJyuutouYoteiCsvSksDao KhKzkPYokuJyuutouYoteiCsvSksDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();

        BizDateYM jyuutouym = syoriYmd.getBizDateYM().getNextMonth();

        long csvRenno = 1;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "<<バッチ処理年月日>>", String.valueOf(syoriYmd)));

        try (ExDBResults<KhKzkPYokuJyuutouYoteiWkBean> khKzkPYokuJyuutouYoteiWkLst = KhKzkPYokuJyuutouYoteiCsvSksDao.
            getKhKzkPYokuJyuutouYoteiCsvSksWkOrderByKykTuukaSyuKykYmHknKkn()) {

            for (KhKzkPYokuJyuutouYoteiWkBean khKzkPYokuJyuutouYoteiWk : khKzkPYokuJyuutouYoteiWkLst) {

                if (C_Tuukasyu.USD.eq(khKzkPYokuJyuutouYoteiWk.getKyktuukasyu())) {

                    uSdKhKzkPYokuJyuutouYoteiWkLst.add(khKzkPYokuJyuutouYoteiWk);
                }
                else if (C_Tuukasyu.AUD.eq(khKzkPYokuJyuutouYoteiWk.getKyktuukasyu())) {

                    aUdKhKzkPYokuJyuutouYoteiWkLst.add(khKzkPYokuJyuutouYoteiWk);
                }
                else if (C_Tuukasyu.JPY.eq(khKzkPYokuJyuutouYoteiWk.getKyktuukasyu())) {

                    jPyKhKzkPYokuJyuutouYoteiWkLst.add(khKzkPYokuJyuutouYoteiWk);
                }
            }

            if (uSdKhKzkPYokuJyuutouYoteiWkLst.size() == 0) {
                KhKzkPYokuJyuutouYoteiWkBean khKzkPYokuJyuutouYoteiWk =
                    new KhKzkPYokuJyuutouYoteiWkBean(C_Tuukasyu.USD, null, jyuutouym, 0,
                        BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                uSdKhKzkPYokuJyuutouYoteiWkLst.add(khKzkPYokuJyuutouYoteiWk);
            }

            if (aUdKhKzkPYokuJyuutouYoteiWkLst.size() == 0) {
                KhKzkPYokuJyuutouYoteiWkBean khKzkPYokuJyuutouYoteiWk =
                    new KhKzkPYokuJyuutouYoteiWkBean(C_Tuukasyu.AUD, null, jyuutouym, 0,
                        BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
                aUdKhKzkPYokuJyuutouYoteiWkLst.add(khKzkPYokuJyuutouYoteiWk);
            }

            if (jPyKhKzkPYokuJyuutouYoteiWkLst.size() == 0) {
                KhKzkPYokuJyuutouYoteiWkBean khKzkPYokuJyuutouYoteiWk =
                    new KhKzkPYokuJyuutouYoteiWkBean(C_Tuukasyu.JPY, null, jyuutouym, 0,
                        BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                jPyKhKzkPYokuJyuutouYoteiWkLst.add(khKzkPYokuJyuutouYoteiWk);
            }

            for (KhKzkPYokuJyuutouYoteiWkBean uSdkhKzkPYokuJyuutouYoteiWk : uSdKhKzkPYokuJyuutouYoteiWkLst) {
                KhKzkPYokuJyuutouYoteiFile khKzkPYokuJyuutouYoteiFile = new KhKzkPYokuJyuutouYoteiFile();
                khKzkPYokuJyuutouYoteiFile.setIfcKyktuukasyu(uSdkhKzkPYokuJyuutouYoteiWk.getKyktuukasyu().getValue());
                khKzkPYokuJyuutouYoteiFile.setIfcKykym(uSdkhKzkPYokuJyuutouYoteiWk.getKykym());
                khKzkPYokuJyuutouYoteiFile.setIfcJyutouym(uSdkhKzkPYokuJyuutouYoteiWk.getJyuutouym());
                khKzkPYokuJyuutouYoteiFile.setIfcHknkkssyu(BizNumber.valueOf(uSdkhKzkPYokuJyuutouYoteiWk.getHknkkn()));
                khKzkPYokuJyuutouYoteiFile.setIfcHokenryougoukei(uSdkhKzkPYokuJyuutouYoteiWk.getHokenryou().toString());
                khKzkPYokuJyuutouYoteiFileLst.add(khKzkPYokuJyuutouYoteiFile);
            }
            for (KhKzkPYokuJyuutouYoteiWkBean aUdkhKzkPYokuJyuutouYoteiWk : aUdKhKzkPYokuJyuutouYoteiWkLst) {
                KhKzkPYokuJyuutouYoteiFile khKzkPYokuJyuutouYoteiFile = new KhKzkPYokuJyuutouYoteiFile();
                khKzkPYokuJyuutouYoteiFile.setIfcKyktuukasyu(aUdkhKzkPYokuJyuutouYoteiWk.getKyktuukasyu().getValue());
                khKzkPYokuJyuutouYoteiFile.setIfcKykym(aUdkhKzkPYokuJyuutouYoteiWk.getKykym());
                khKzkPYokuJyuutouYoteiFile.setIfcJyutouym(aUdkhKzkPYokuJyuutouYoteiWk.getJyuutouym());
                khKzkPYokuJyuutouYoteiFile.setIfcHknkkssyu(BizNumber.valueOf(aUdkhKzkPYokuJyuutouYoteiWk.getHknkkn()));
                khKzkPYokuJyuutouYoteiFile.setIfcHokenryougoukei(aUdkhKzkPYokuJyuutouYoteiWk.getHokenryou().toString());
                khKzkPYokuJyuutouYoteiFileLst.add(khKzkPYokuJyuutouYoteiFile);
            }
            for (KhKzkPYokuJyuutouYoteiWkBean jPykhKzkPYokuJyuutouYoteiWk : jPyKhKzkPYokuJyuutouYoteiWkLst) {
                KhKzkPYokuJyuutouYoteiFile khKzkPYokuJyuutouYoteiFile = new KhKzkPYokuJyuutouYoteiFile();
                khKzkPYokuJyuutouYoteiFile.setIfcKyktuukasyu(jPykhKzkPYokuJyuutouYoteiWk.getKyktuukasyu().getValue());
                khKzkPYokuJyuutouYoteiFile.setIfcKykym(jPykhKzkPYokuJyuutouYoteiWk.getKykym());
                khKzkPYokuJyuutouYoteiFile.setIfcJyutouym(jPykhKzkPYokuJyuutouYoteiWk.getJyuutouym());
                khKzkPYokuJyuutouYoteiFile.setIfcHknkkssyu(BizNumber.valueOf(jPykhKzkPYokuJyuutouYoteiWk.getHknkkn()));
                khKzkPYokuJyuutouYoteiFile.setIfcHokenryougoukei(jPykhKzkPYokuJyuutouYoteiWk.getHokenryou().toString());
                khKzkPYokuJyuutouYoteiFileLst.add(khKzkPYokuJyuutouYoteiFile);
            }

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            List<KhKzkPYokuJyuutouYoteiFile> outKhKzkPYokuJyuutouYoteiFileLst = new ArrayList<>();

            for (KhKzkPYokuJyuutouYoteiFile khKzkPYokuJyuutouYoteiFileBean : khKzkPYokuJyuutouYoteiFileLst) {

                outKhKzkPYokuJyuutouYoteiFileLst.add(khKzkPYokuJyuutouYoteiFileBean);

                int outKhKzkPYokuJyuutouYoteiFileLstSize = outKhKzkPYokuJyuutouYoteiFileLst.size();

                if (outKhKzkPYokuJyuutouYoteiFileLstSize == CSV_MAX_KENSUU) {

                    C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                        C_FileSyuruiCdKbn.KH_KZKPYOKUJYUUTOUYOTEICSVF,
                        outKhKzkPYokuJyuutouYoteiFileLst,
                        true, String.valueOf(csvRenno));

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
                    }
                    outKhKzkPYokuJyuutouYoteiFileLst.removeAll(outKhKzkPYokuJyuutouYoteiFileLst);
                    csvRenno = csvRenno + 1;
                }
            }

            if (outKhKzkPYokuJyuutouYoteiFileLst.size() > 0) {
                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_KZKPYOKUJYUUTOUYOTEICSVF,
                    outKhKzkPYokuJyuutouYoteiFileLst,
                    true,
                    String.valueOf(csvRenno));

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
                }
            }

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(uSdKhKzkPYokuJyuutouYoteiWkLst.size()), C_Tuukasyu.USD.getContent()));
            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(aUdKhKzkPYokuJyuutouYoteiWkLst.size()), C_Tuukasyu.AUD.getContent()));
            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(jPyKhKzkPYokuJyuutouYoteiWkLst.size()), C_Tuukasyu.JPY.getContent()));

        }
    }
}
