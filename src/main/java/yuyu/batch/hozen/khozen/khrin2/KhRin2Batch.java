package yuyu.batch.hozen.khozen.khrin2;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khrin2.dba.KhRin2Dao;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakusei;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakuseiBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 契約保全臨時処理２
 */
public class KhRin2Batch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    KhRin2BatchParam khRin2BatchParam;

    @Inject
    private KhRin2Dao khRin2Dao;

    @Override
    public BatchParam getParam() {
        return khRin2BatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int syoriKensu = 0;

        try (

            ExDBResults<IT_KykKihon> khKhTusanIdouTaisyouList = khRin2Dao.getKhTusanIdouTaisyous();

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

            for (IT_KykKihon kykKihon : khKhTusanIdouTaisyouList) {

                PALKykNaiyouSakuseiBean palKykNaiyouSakuseiBean = SWAKInjector.getInstance(PALKykNaiyouSakuseiBean.class);

                palKykNaiyouSakuseiBean.setKykKihon(kykKihon);

                PALKykNaiyouSakusei palKykNaiyouSakusei = SWAKInjector.getInstance(PALKykNaiyouSakusei.class);

                C_ErrorKbn result = palKykNaiyouSakusei.exec(palKykNaiyouSakuseiBean);

                if (C_ErrorKbn.ERROR.eq(result)) {

                    throw new CommonBizAppException("当日異動内容契約保全テーブルの取得に失敗しました。");
                }

                multipleEntityInserter.add(palKykNaiyouSakusei.getTjtIdouNyKh());

                syoriKensu++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensu)));
    }
}
