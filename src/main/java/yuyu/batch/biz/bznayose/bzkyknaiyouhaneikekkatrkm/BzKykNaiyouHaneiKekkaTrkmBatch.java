package yuyu.batch.biz.bznayose.bzkyknaiyouhaneikekkatrkm;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.file.csv.BzKykIdouHaneiKekkaCsvfFile;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaTr;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 名寄せ PAL契約内容反映結果取込
 */
public class BzKykNaiyouHaneiKekkaTrkmBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        long syoriKensuu = 0;
        List<BzKykIdouHaneiKekkaCsvfFile> bzKykIdouHaneiKekkaLst = new ArrayList<>();

        try (ExDBResults<ZT_KykIdouHaneiKekkaTr> kykIdouHaneiKekkaTrLst = zdbDomManager.getAllKykIdouHaneiKekkaTr()) {
            for (ZT_KykIdouHaneiKekkaTr kykIdouHaneiKekkaTr : kykIdouHaneiKekkaTrLst) {

                BzKykIdouHaneiKekkaCsvfFile bzKykIdouHaneiKekka =
                    SWAKInjector.getInstance(BzKykIdouHaneiKekkaCsvfFile.class);

                if ((!"0".equals(kykIdouHaneiKekkaTr.getZtrkyknaiyouhaneierrkbn()))
                    || ("1".equals(kykIdouHaneiKekkaTr.getZtrtsnkijyuntyoukahyj()))
                    || ("1".equals(kykIdouHaneiKekkaTr.getZtrhhknnayosehumeihyj()))
                    || ("1".equals(kykIdouHaneiKekkaTr.getZtrkyknayosehumeihyj()))
                    || ("1".equals(kykIdouHaneiKekkaTr.getZtrnkuktnayosehumeihyj()))) {

                    bzKykIdouHaneiKekka.setIfcHuho2kyknokbn(kykIdouHaneiKekkaTr.getZtrhuho2kyknokbn());
                    bzKykIdouHaneiKekka.setIfcHuho2kykno(kykIdouHaneiKekkaTr.getZtrhuho2kykno());
                    bzKykIdouHaneiKekka.setIfcKyknaiyouhaneierrkbn(kykIdouHaneiKekkaTr.getZtrkyknaiyouhaneierrkbn());
                    bzKykIdouHaneiKekka.setIfcTsnkijyuntyoukahyj(kykIdouHaneiKekkaTr.getZtrtsnkijyuntyoukahyj());
                    bzKykIdouHaneiKekka.setIfcHhknnayosehumeihyj(kykIdouHaneiKekkaTr.getZtrhhknnayosehumeihyj());
                    bzKykIdouHaneiKekka.setIfcKyknayosehumeihyj(kykIdouHaneiKekkaTr.getZtrkyknayosehumeihyj());
                    bzKykIdouHaneiKekka.setIfcNkuktnayosehumeihyj(kykIdouHaneiKekkaTr.getZtrnkuktnayosehumeihyj());

                    bzKykIdouHaneiKekkaLst.add(bzKykIdouHaneiKekka);
                    syoriKensuu++;
                }
            }
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.BZ_KYKIDOUHANEIKEKKACSVF,
            bzKykIdouHaneiKekkaLst, true);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), kinou.getKinouNm()));
    }

}
