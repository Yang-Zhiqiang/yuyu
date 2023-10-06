package yuyu.batch.biz.bzinterf.bzsjkkktyouseiyouririturendoufilesks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.base.Strings;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.util.SeparateConvertUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.FilePathUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.file.csv.BzSjkkktysrrtRendouFileDataRecordLayoutFile;
import yuyu.def.biz.file.csv.BzSjkkktysrrtRendouFileHeaderRecordLayoutFile;
import yuyu.def.biz.file.csv.BzSjkkktysrrtRendouFileLayoutFile;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;

/**
 * 業務共通 インターフェイス 市場価格調整用利率連動ファイル作成
 */
public class BzSjkkkTyouseiyouRirituRendouFileSksBatch implements Batch {

    private static final String HEADER = "HEADER";

    private static final String FILENM = "BM_SjkkkTyouseiyouRiritu_rendou.csv";

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
        List<BzSjkkktysrrtRendouFileLayoutFile> bzSjkkktysrrtRendouFileLayoutFileLst = new ArrayList<>();
        BzSjkkktysrrtRendouFileHeaderRecordLayoutFile bzSjkkktysrrtRendouFileHeaderRecordLayoutFile = SWAKInjector
            .getInstance(BzSjkkktysrrtRendouFileHeaderRecordLayoutFile.class);

        List<BM_SjkkkTyouseiyouRiritu2> sjkkkTyouseiyouRiritu2Lst = bizDomManager
            .getSjkkkTyouseiyouRiritu2sByKijyuntoymdMax();

        bzSjkkktysrrtRendouFileHeaderRecordLayoutFile.setIfcRecordsikibetumojiretu(HEADER);
        bzSjkkktysrrtRendouFileHeaderRecordLayoutFile.setIfcSakuseiymd(BizDate.getSysDate());
        bzSjkkktysrrtRendouFileHeaderRecordLayoutFile.setIfcDtrecordkensuu(sjkkkTyouseiyouRiritu2Lst.size());

        String headRecord = SeparateConvertUtil.beanToStringForSeparate(bzSjkkktysrrtRendouFileHeaderRecordLayoutFile,
            KONMU);

        BzSjkkktysrrtRendouFileLayoutFile bzSjkkktysrrtRendouFileLayoutFile = SWAKInjector
            .getInstance(BzSjkkktysrrtRendouFileLayoutFile.class);
        bzSjkkktysrrtRendouFileLayoutFile.setIfcSjkkktysrrtrendoudata(headRecord);
        bzSjkkktysrrtRendouFileLayoutFileLst.add(bzSjkkktysrrtRendouFileLayoutFile);

        count = count + 1;

        for (BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu2 : sjkkkTyouseiyouRiritu2Lst) {

            BzSjkkktysrrtRendouFileDataRecordLayoutFile bzSjkkktysrrtRendouFileDataRecordLayoutFile = SWAKInjector
                .getInstance(BzSjkkktysrrtRendouFileDataRecordLayoutFile.class);
            bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcSyouhncd(sjkkkTyouseiyouRiritu2.getSyouhncd());
            bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcSjkkktyouseiriritutkybr1(Strings.padStart(sjkkkTyouseiyouRiritu2.getSjkkktyouseiriritutkybr1(), 3, '0'));
            bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcSjkkktyouseiriritutkybr2(Strings.padStart(sjkkkTyouseiyouRiritu2.getSjkkktyouseiriritutkybr2(), 3, '0'));
            bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcKijyunfromymd(sjkkkTyouseiyouRiritu2.getKijyunfromymd());
            bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcKijyuntoymd(sjkkkTyouseiyouRiritu2.getKijyuntoymd());
            bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcTuukasyu(sjkkkTyouseiyouRiritu2.getTuukasyu().getValue());
            bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcSjkkktyouseiyouriritu(sjkkkTyouseiyouRiritu2
                .getSjkkktyouseiyouriritu());

            int wkSyohinHanteiKbn = SyouhinUtil.hantei(sjkkkTyouseiyouRiritu2.getSyouhncd());

            if (wkSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                wkSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                if (sjkkkTyouseiyouRiritu2.getKijyunfromymd().toString().substring(6).equals("01") ||
                    sjkkkTyouseiyouRiritu2.getKijyunfromymd().toString().substring(6).equals("16")) {
                    bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcKykymd(sjkkkTyouseiyouRiritu2.getKijyunfromymd().getNextMonth());
                } else {
                    bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcKykymd(null);
                }
            } else {
                bzSjkkktysrrtRendouFileDataRecordLayoutFile.setIfcKykymd(null);
            }


            String dataRecord = SeparateConvertUtil.beanToStringForSeparate(
                bzSjkkktysrrtRendouFileDataRecordLayoutFile, KONMU);

            BzSjkkktysrrtRendouFileLayoutFile bzSjkkktysrrtRendouFileLayoutFileTemp = SWAKInjector
                .getInstance(BzSjkkktysrrtRendouFileLayoutFile.class);
            bzSjkkktysrrtRendouFileLayoutFileTemp.setIfcSjkkktysrrtrendoudata(dataRecord);
            bzSjkkktysrrtRendouFileLayoutFileLst.add(bzSjkkktysrrtRendouFileLayoutFileTemp);

            count = count + 1;

        }

        String filePath = FilePathUtil.getBatchOutDataPath() + "/" + FILENM;

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        try {
            fileControlManager.writeFileData(filePath, bzSjkkktysrrtRendouFileLayoutFileLst, FileType.CSV);
        } catch (Exception e) {
            throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0163, FILENM));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

}
