package yuyu.batch.biz.bzfiledl.bzdownloaddatasakujyo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_NengappiKbn;
import yuyu.def.db.entity.AS_FileHozonKikan;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileHozonUtil;

/**
 * ダウンロードデータ削除のバッチクラスです。
 */
public class BzDownloadDataSakujyoBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private FileHozonUtil fileHozonUtil;

    @Inject
    private BaseDomManager baseDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        List<C_FileSyuruiCdKbn> fileSyuruiCdLst = new ArrayList<>();

        List<AS_FileSyurui> fileSyuruiLst = baseDomManager.getAllFileSyuruis();

        for (AS_FileSyurui fileSyurui : fileSyuruiLst) {
            fileSyuruiCdLst.add(fileSyurui.getFileSyuruiCd());
        }

        AS_FileHozonKikan fileHozonKikan = null;
        BizDate sakujyoTaisyouYmd = null;
        List<AT_FileHozonInfo> fileHozonInfoLst = new ArrayList<>();
        Integer hozonKikan;
        C_NengappiKbn nengappiKbn;
        List<String> uniqueIdLst;

        for (C_FileSyuruiCdKbn fileSyuruiCd : fileSyuruiCdLst) {
            hozonKikan = 0;
            nengappiKbn = C_NengappiKbn.BLNK;
            uniqueIdLst = new ArrayList<>();

            fileHozonKikan = baseDomManager.getFileSyurui(fileSyuruiCd).getFileHozonKikan();

            if (fileHozonKikan != null) {
                hozonKikan = fileHozonKikan.getHozonKikan();
                nengappiKbn = fileHozonKikan.getNengappiKbn();
            }

            if (C_NengappiKbn.NEN.eq(nengappiKbn) ||
                    C_NengappiKbn.TUKI.eq(nengappiKbn) ||
                    C_NengappiKbn.HI.eq(nengappiKbn)) {
                sakujyoTaisyouYmd = syoriYmd;

                if (C_NengappiKbn.NEN.eq(nengappiKbn)) {
                    sakujyoTaisyouYmd = sakujyoTaisyouYmd.addYears(-hozonKikan);
                }
                else if (C_NengappiKbn.TUKI.eq(nengappiKbn)) {
                    sakujyoTaisyouYmd = sakujyoTaisyouYmd.addMonths(-hozonKikan);
                }
                else if (C_NengappiKbn.HI.eq(nengappiKbn)) {
                    sakujyoTaisyouYmd = sakujyoTaisyouYmd.addDays(-hozonKikan);
                }

                sakujyoTaisyouYmd = sakujyoTaisyouYmd.getRekijyou();

                fileHozonInfoLst = baseDomManager.getFileHozonInfosByFileSyuruiCdTourokuTime(fileSyuruiCd, sakujyoTaisyouYmd.toString() + "000000000");

                for (AT_FileHozonInfo fileHozonInfo : fileHozonInfoLst) {
                    uniqueIdLst.add(fileHozonInfo.getUniqueId());
                }

                syoriKensuu = syoriKensuu + fileHozonUtil.deleteFile(uniqueIdLst);
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensuu)));
    }
}