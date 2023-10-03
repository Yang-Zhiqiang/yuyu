package yuyu.batch.suuri.srsuuritoukei.srtmttdmeisai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 積立配当金明細情報作成クラス
 */
public class SrTmttDMeisaiBatch implements Batch {

    @Inject
    private SrTmttDMeisaiBatchParam batchParam;

    @Inject
    private BatchLogger batchLogger;

    private long tableTourokuCount;

    @Override
    public SrTmttDMeisaiBatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        tableTourokuCount = 0;

        SrTmttDMeisaiBatchDbAccess srTmttDMeisaiBatchDbAccess = SWAKInjector.getInstance(
            SrTmttDMeisaiBatchDbAccess.class);

        SrTmttDMeisaiBatchEdit srTmttDMeisaiBatchEdit = SWAKInjector.getInstance(SrTmttDMeisaiBatchEdit.class);

        String kakutyoujobcd = "";

        if (SrTmttDMeisaiBatchParam.RGKLM002.equals(batchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_YUUKOUKYKHTJYNBKNDATA;
        }
        else if (SrTmttDMeisaiBatchParam.RGKLM004.equals(batchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_YUUKOUKYKHTJYNBKNDATA;
        }

        try (ExDBResults<ST_YuukoukykHtjynbknTmttd> yuukoukykHtjynbknTmttdList = srTmttDMeisaiBatchDbAccess
            .getTmttDMeisai(batchParam.getKijyunymd(), kakutyoujobcd);

            EntityInserter<ZT_TmttHaitoukinMeisaiTy> tmttHaitoukinMeisaiTyList = new EntityInserter<>()) {

            for (ST_YuukoukykHtjynbknTmttd yuukoukykHtjynbknTmttd : yuukoukykHtjynbknTmttdList) {

                ZT_TmttHaitoukinMeisaiTy tmttHaitoukinMeisaiTy = new ZT_TmttHaitoukinMeisaiTy();

                srTmttDMeisaiBatchEdit.editKoumoku(batchParam, yuukoukykHtjynbknTmttd, tmttHaitoukinMeisaiTy);

                BizPropertyInitializer.initialize(tmttHaitoukinMeisaiTy);

                tmttHaitoukinMeisaiTyList.add(tmttHaitoukinMeisaiTy);

                tableTourokuCount++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "積立配当金明細Ｆテーブル（中）",
            String.valueOf(tableTourokuCount)));
    }
}
