package yuyu.batch.biz.bznayose.bzsntkinfohaneikekkatrkm;

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
import yuyu.def.biz.file.csv.BzSntkInfoHaneiKekkaCsvfFile;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaTr;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 名寄せ PAL選択情報反映結果取込
 */
public class BzSntkInfoHaneiKekkaTrkmBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzbatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzbatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzbatchParam.getSyoriYmd())));

        long syoriKensuu = 0;
        List<BzSntkInfoHaneiKekkaCsvfFile> bzSntkInfoHaneiKekkaLst = new ArrayList<BzSntkInfoHaneiKekkaCsvfFile>();

        try (ExDBResults<ZT_SntkInfoHaneiKekkaTr> sntkInfoHaneiKekkaTrLst = zdbDomManager.getAllSntkInfoHaneiKekkaTr()) {
            for (ZT_SntkInfoHaneiKekkaTr sntkInfoHaneiKekkaTr : sntkInfoHaneiKekkaTrLst) {
                BzSntkInfoHaneiKekkaCsvfFile bzSntkInfoHaneiKekka =
                    SWAKInjector.getInstance(BzSntkInfoHaneiKekkaCsvfFile.class);

                if ((!"0".equals(sntkInfoHaneiKekkaTr.getZtrsntkinjotourokuerrkbn()))
                    || ("1".equals(sntkInfoHaneiKekkaTr.getZtrnayosehumeihyj()))) {

                    bzSntkInfoHaneiKekka.setIfcSntkinfono(sntkInfoHaneiKekkaTr.getZtrsntkinfono());
                    bzSntkInfoHaneiKekka.setIfcSntkinfotourokusyskbn(sntkInfoHaneiKekkaTr.getZtrsntkinfotourokusyskbn());
                    bzSntkInfoHaneiKekka.setIfcRenno(sntkInfoHaneiKekkaTr.getZtrrenno());
                    bzSntkInfoHaneiKekka.setIfcHuho2kyknokbn(sntkInfoHaneiKekkaTr.getZtrhuho2kyknokbn());
                    bzSntkInfoHaneiKekka.setIfcHuho2kykno(sntkInfoHaneiKekkaTr.getZtrhuho2kykno());
                    bzSntkInfoHaneiKekka.setIfcSntkinfokankeisyakbn(sntkInfoHaneiKekkaTr.getZtrsntkinfofsegkbn());
                    bzSntkInfoHaneiKekka.setIfcSntkinfofkojinkbn(sntkInfoHaneiKekkaTr.getZtrsntkinfofkojinkbn());
                    bzSntkInfoHaneiKekka.setIfcDakuhiketnaiyouarihyj(sntkInfoHaneiKekkaTr.getZtrdakuhiketnaiyouarihyj());
                    bzSntkInfoHaneiKekka.setIfcKktnaiyouarihyj(sntkInfoHaneiKekkaTr.getZtrkktnaiyouarihyj());
                    bzSntkInfoHaneiKekka.setIfcKijinaiyouarihyj(sntkInfoHaneiKekkaTr.getZtrkijinaiyouarihyj());
                    bzSntkInfoHaneiKekka.setIfcMrarihyj(sntkInfoHaneiKekkaTr.getZtrmrarihyj());
                    bzSntkInfoHaneiKekka.setIfcKoudosyougaiarihyj(sntkInfoHaneiKekkaTr.getZtrkoudosyougaiarihyj());
                    bzSntkInfoHaneiKekka.setIfcTorikaijyoarihyj(sntkInfoHaneiKekkaTr.getZtrtorikaijoarihyj());
                    bzSntkInfoHaneiKekka.setIfcSntkinfotourokuerrkbn(sntkInfoHaneiKekkaTr.getZtrsntkinjotourokuerrkbn());
                    bzSntkInfoHaneiKekka.setIfcNayosehumeihyj(sntkInfoHaneiKekkaTr.getZtrnayosehumeihyj());

                    bzSntkInfoHaneiKekkaLst.add(bzSntkInfoHaneiKekka);
                    syoriKensuu++;
                }
            }
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.BZ_SNTKINFOHANEIKEKKACSVF,
            bzSntkInfoHaneiKekkaLst, true);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(syoriKensuu), kinou.getKinouNm()));
    }

}
