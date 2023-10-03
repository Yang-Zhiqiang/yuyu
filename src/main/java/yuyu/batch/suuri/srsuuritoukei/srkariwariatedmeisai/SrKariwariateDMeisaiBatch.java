package yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisai;

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
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 仮割当配当金明細情報作成
 */
public class SrKariwariateDMeisaiBatch implements Batch {

    @Inject
    private SrKariwariateDMeisaiBatchParam batchParam;

    @Inject
    private BatchLogger batchLogger;

    private long tableTourokuCount;

    @Override
    public SrKariwariateDMeisaiBatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        tableTourokuCount = 0;

        SrKariwariateDMeisaiBatchDbAccess srKariwariateDMeisaiBatchDbAccess = SWAKInjector
            .getInstance(SrKariwariateDMeisaiBatchDbAccess.class);

        SrKariwariateDMeisaiBatchEdit srKariwariateDMeisaiBatchEdit = SWAKInjector
            .getInstance(SrKariwariateDMeisaiBatchEdit.class);

        String kakutyoujobcd = "";

        if (SrKariwariateDMeisaiBatchParam.RGKOM002.equals(batchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_YUUKOUKYKHTJYNBKNDATA;
        }
        else if (SrKariwariateDMeisaiBatchParam.RGKOM004.equals(batchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_YUUKOUKYKHTJYNBKNDATA;
        }

        try (
            ExDBResults<ST_YuukoukykHtjynbknKarid> yuukoukykHtjynbknKaridList = srKariwariateDMeisaiBatchDbAccess
            .getKariwariateDMeisai(batchParam.getKijyunymd(), kakutyoujobcd);

            EntityInserter<ZT_KariwariateHtkinMeisaiTy> kariwariateHtkinMeisaiTyList = new EntityInserter<>();) {

            for (ST_YuukoukykHtjynbknKarid yuukoukykHtjynbknKarid : yuukoukykHtjynbknKaridList) {

                ZT_KariwariateHtkinMeisaiTy kariwariateHtkinMeisaiTy = new ZT_KariwariateHtkinMeisaiTy();

                srKariwariateDMeisaiBatchEdit.editKoumoku(batchParam, yuukoukykHtjynbknKarid, kariwariateHtkinMeisaiTy);

                BizPropertyInitializer.initialize(kariwariateHtkinMeisaiTy);

                kariwariateHtkinMeisaiTyList.add(kariwariateHtkinMeisaiTy);

                tableTourokuCount++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "仮割当配当金明細Ｆテーブル（中）",
            String.valueOf(tableTourokuCount)));
    }
}
