package yuyu.batch.biz.bzinterf.bzyoteiririturendoufilesks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.util.SeparateConvertUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.FilePathUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.file.csv.BzYoteirirituRendouFileDataRecordLayoutFile;
import yuyu.def.biz.file.csv.BzYoteirirituRendouFileHeaderRecordLayoutFile;
import yuyu.def.biz.file.csv.BzYoteirirituRendouFileLayoutFile;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.entity.BM_YoteiRirituRendouSeigyo;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;

import com.google.common.base.Strings;

/**
 * 業務共通 インターフェイス 予定利率連動ファイル作成
 */
public class BzYoteiRirituRendouFileSksBatch implements Batch {

    private static final String HEADER = "HEADER";

    private static final String FILENM = "BM_YoteiRiritu_rendou.csv";

    private static final char KONMU = ',';

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        long count = 0;
        List<BzYoteirirituRendouFileLayoutFile> bzYoteirirituRendouFileLayoutFileLst = new ArrayList<>();
        List<BzYoteirirituRendouFileLayoutFile> bzYoteirirituRendouFileLayoutFileLst2 = new ArrayList<>();
        BzYoteirirituRendouFileHeaderRecordLayoutFile bzYoteirirituRendouFileHeaderRecordLayoutFile = SWAKInjector
            .getInstance(BzYoteirirituRendouFileHeaderRecordLayoutFile.class);

        List<BM_YoteiRirituRendouSeigyo> yoteiRirituRendouSeigyoList =
            bizDomManager.getYoteiRirituRendouSeigyosByYoteirirituhanteid(bzBatchParam.getSyoriYmd().toString().substring(6));

        for (BM_YoteiRirituRendouSeigyo yoteiRirituRendouSeigyo : yoteiRirituRendouSeigyoList) {

            List<BM_YoteiRiritu3> yoteiRirituList = bizDomManager.getYoteiRiritu3sBySyouhncdKijyuntoymdMax(yoteiRirituRendouSeigyo.getSyouhncd());

            if (yoteiRirituList.size() != 0) {

                for (BM_YoteiRiritu3 yoteiRiritu : yoteiRirituList) {

                    if ((yoteiRiritu.getSyouhncd().equals("ﾕｽ") || yoteiRiritu.getSyouhncd().equals("ﾕｾ")
                        || yoteiRiritu.getSyouhncd().equals("ﾕｿ") || yoteiRiritu.getSyouhncd().equals("ﾕﾀ"))
                        && yoteiRiritu.getTuukasyu().eq(C_Tuukasyu.AUD)
                        && yoteiRiritu.getYoteiriritutkybr1().equals("5")) {
                        continue;
                    }

                    if ((yoteiRiritu.getSyouhncd().equals("ﾕｹ") || yoteiRiritu.getSyouhncd().equals("ﾕｺ")
                        || yoteiRiritu.getSyouhncd().equals("ﾕｻ") || yoteiRiritu.getSyouhncd().equals("ﾕｼ"))
                        && yoteiRiritu.getTuukasyu().eq(C_Tuukasyu.USD)
                        && yoteiRiritu.getYoteiriritutkybr1().equals("5")) {
                        continue;
                    }
                	
                    if ((yoteiRiritu.getSyouhncd().equals("ﾕﾕ") || yoteiRiritu.getSyouhncd().equals("ﾕﾖ")
                        || yoteiRiritu.getSyouhncd().equals("ﾕﾗ") || yoteiRiritu.getSyouhncd().equals("ﾕﾘ")
                        || yoteiRiritu.getSyouhncd().equals("ﾕﾙ") || yoteiRiritu.getSyouhncd().equals("ﾕﾚ")
                        || yoteiRiritu.getSyouhncd().equals("ﾕﾛ") || yoteiRiritu.getSyouhncd().equals("ﾕﾜ"))
                        && yoteiRiritu.getTuukasyu().eq(C_Tuukasyu.AUD)
                        && yoteiRiritu.getYoteiriritutkybr1().equals("5")) {
                        continue;
                    }
                	
                    BzYoteirirituRendouFileDataRecordLayoutFile bzYoteirirituRendouFileDataRecordLayoutFileFile = SWAKInjector
                        .getInstance(BzYoteirirituRendouFileDataRecordLayoutFile.class);

                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcSyouhncd(yoteiRiritu.getSyouhncd());
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcYoteiriritutkybr1(Strings.padStart(yoteiRiritu.getYoteiriritutkybr1(), 3, '0'));
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcYoteiriritutkybr2(Strings.padStart(yoteiRiritu.getYoteiriritutkybr2(), 3, '0'));
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcKijyunfromymd(yoteiRiritu.getKijyunfromymd());
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcKijyuntoymd(yoteiRiritu.getKijyuntoymd());
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcTuukasyu(yoteiRiritu.getTuukasyu().getValue());
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcYoteiriritu(yoteiRiritu.getYoteiriritu());
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcTumitateriritu(yoteiRiritu.getTumitateriritu());
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcTmttknzoukaritujygn(yoteiRiritu.getTmttknzoukaritujygn());
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcSetteibairitu(yoteiRiritu.getSetteibairitu());
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcLoadinghnkgtmttrrt(yoteiRiritu.getLoadinghnkgtumitateriritu());
                    bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcRendouritu(yoteiRiritu.getRendouritu());

                    int wkSyohinHanteiKbn = SyouhinUtil.hantei(yoteiRiritu.getSyouhncd());

                    if (wkSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        wkSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                        if (yoteiRiritu.getKijyunfromymd().toString().substring(6).equals("01") ||
                            yoteiRiritu.getKijyunfromymd().toString().substring(6).equals("16")) {

                            bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcKykymd(yoteiRiritu.getKijyunfromymd().getNextMonth());
                        } else {

                            bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcKykymd(null);
                        }
                    } else {

                        bzYoteirirituRendouFileDataRecordLayoutFileFile.setIfcKykymd(null);
                    }

                    String dataRecord = SeparateConvertUtil.beanToStringForSeparate(
                        bzYoteirirituRendouFileDataRecordLayoutFileFile, KONMU);

                    BzYoteirirituRendouFileLayoutFile bzYoteirirituRendouFileLayoutFileTemp = SWAKInjector
                        .getInstance(BzYoteirirituRendouFileLayoutFile.class);
                    bzYoteirirituRendouFileLayoutFileTemp.setIfcYoteiririturendoudata(dataRecord);
                    bzYoteirirituRendouFileLayoutFileLst.add(bzYoteirirituRendouFileLayoutFileTemp);

                    count = count + 1;

                }
            }
        }

        bzYoteirirituRendouFileHeaderRecordLayoutFile.setIfcRecordsikibetumojiretu(HEADER);
        bzYoteirirituRendouFileHeaderRecordLayoutFile.setIfcSakuseiymd(BizDate.getSysDate());
        bzYoteirirituRendouFileHeaderRecordLayoutFile.setIfcDtrecordkensuu((int) count);

        String headRecord = SeparateConvertUtil.beanToStringForSeparate(bzYoteirirituRendouFileHeaderRecordLayoutFile,
            KONMU);

        BzYoteirirituRendouFileLayoutFile bzYoteirirituRendouFileLayoutFile = SWAKInjector
            .getInstance(BzYoteirirituRendouFileLayoutFile.class);
        bzYoteirirituRendouFileLayoutFile.setIfcYoteiririturendoudata(headRecord);
        bzYoteirirituRendouFileLayoutFileLst2.add(bzYoteirirituRendouFileLayoutFile);

        count = count + 1;

        for (BzYoteirirituRendouFileLayoutFile bzYoteirirituRendouFileLayoutFile2 : bzYoteirirituRendouFileLayoutFileLst) {
            bzYoteirirituRendouFileLayoutFileLst2.add(bzYoteirirituRendouFileLayoutFile2);
        }

        String filePath = FilePathUtil.getBatchOutDataPath() + "/" + FILENM;

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        try {
            fileControlManager.writeFileData(filePath, bzYoteirirituRendouFileLayoutFileLst2, FileType.CSV);
        } catch (Exception e) {
            throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0163, FILENM));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

}
