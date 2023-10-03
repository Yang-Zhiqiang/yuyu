package yuyu.batch.suuri.srsuuritoukei.srbikinkykseisand;

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
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 備金契約精算Ｄ情報作成クラス
 */
public class SrBikinKykSeisanDBatch implements Batch{

    @Inject
    private SrBikinKykSeisanDBatchParam batchParam;

    @Inject
    private BatchLogger batchLogger;

    private long tableTourokuCount;

    @Override
    public SrBikinKykSeisanDBatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void exec() {

        tableTourokuCount = 0;

        SrBikinKykSeisanDBatchDbAccess srBikinKykSeisanDBatchDbAccess = SWAKInjector
            .getInstance(SrBikinKykSeisanDBatchDbAccess.class);

        SrBikinKykSeisanDBatchEdit srBikinKykSeisanDBatchEdit = SWAKInjector
            .getInstance(SrBikinKykSeisanDBatchEdit.class);

        String kakutyoujobcd = "";

        if(SrBikinKykSeisanDBatchParam.RGKRM002.equals(batchParam.getIbKakutyoujobcd())){

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_BKNKYKHTJYNBKNDATA;
        }
        else if (SrBikinKykSeisanDBatchParam.RGKRM004.equals(batchParam.getIbKakutyoujobcd())){

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_BKNKYKHTJYNBKNDATA;
        }

        try (ExDBResults<ST_BknkykHtjynbkn> bknkykHtjynbknList = srBikinKykSeisanDBatchDbAccess.
            getBikinKykHaitouJyunbikin(batchParam.getKijyunymd(), kakutyoujobcd);

            EntityInserter<ZT_BikinKeiyakuSeisandTy> bikinKeiyakuSeisandTyList = new EntityInserter<>()) {

            for (ST_BknkykHtjynbkn bknkykHtjynbkn : bknkykHtjynbknList) {

                ZT_BikinKeiyakuSeisandTy bikinKeiyakuSeisandTy = new ZT_BikinKeiyakuSeisandTy();

                srBikinKykSeisanDBatchEdit.editKoumoku(batchParam, bknkykHtjynbkn, bikinKeiyakuSeisandTy);

                BizPropertyInitializer.initialize(bikinKeiyakuSeisandTy);

                bikinKeiyakuSeisandTyList.add(bikinKeiyakuSeisandTy);

                tableTourokuCount++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "備金契約精算ＤＦテーブル（中）",
            String.valueOf(tableTourokuCount)));
    }
}
