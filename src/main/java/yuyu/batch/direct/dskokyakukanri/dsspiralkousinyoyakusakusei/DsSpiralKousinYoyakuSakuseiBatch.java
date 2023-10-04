package yuyu.batch.direct.dskokyakukanri.dsspiralkousinyoyakusakusei;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.direct.file.csv.DsSpiralkousinyoyakuDataRecordLayoutFile;
import yuyu.def.direct.file.csv.DsSpiralkousinyoyakuHeaderRecordLayoutFile;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;

import com.google.common.base.Strings;

/**
 * ダイレクトサービス 顧客管理 ＳＰＩＲＡＬ更新予約Ｆ作成クラス
 */
public class DsSpiralKousinYoyakuSakuseiBatch implements Batch {

    private final String FILE_NAME = "SpiralKousinYoyaku_";

    private final String EXTENSOPM_TSV = ".tsv";

    private final String EXTENSOPM_FIN = ".fin";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        BizDate fileSakuseiYmd = bzBatchParam.getSyoriYmd().addDays(1);
        String batchOutputDir = YuyuBaseConfig.getInstance().getBatchOutputDir();
        String filePathTsv = batchOutputDir + "/" + FILE_NAME + fileSakuseiYmd.toString() + EXTENSOPM_TSV;
        String filePathFin = batchOutputDir + "/" + FILE_NAME + fileSakuseiYmd.toString() + EXTENSOPM_FIN;
        List<DsSpiralkousinyoyakuHeaderRecordLayoutFile> dsHeaderLst = new ArrayList<>();
        List<DsSpiralkousinyoyakuDataRecordLayoutFile> dsDataLst = new ArrayList<>();
        int count = 0;

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);
        File[]  taisyouDirs = new File(batchOutputDir).listFiles();

        for (File taisyouDir : taisyouDirs) {

            String fileNm = getFilename(taisyouDir);

            if  (fileNm.startsWith(FILE_NAME)) {
                fileControlManager.remove(taisyouDir);
            }

        }

        try (
            ExDBResults<MT_DsMailAddressSpiralYyk> dsMailAddressSpiralYykLst =
            directDomManager.getDsMailAddressSpiralYyksByDsdatasakuseiymd(bzBatchParam.getSyoriYmd())) {

            for (MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk : dsMailAddressSpiralYykLst) {

                DsSpiralkousinyoyakuDataRecordLayoutFile dsData = new DsSpiralkousinyoyakuDataRecordLayoutFile();
                dsData.setIfcDskokmailaddressskbtkey(dsMailAddressSpiralYyk.getDskokno() +
                    Strings.padStart(dsMailAddressSpiralYyk.getDsmailaddressrenban().toString(), 9, '0'));
                dsData.setIfcDsmailaddress(dsMailAddressSpiralYyk.getDsmailaddress());
                dsData.setIfcDsmailaddressdbsyorikbn(dsMailAddressSpiralYyk.getDsmaildbsyorikbn().getValue());
                dsDataLst.add(dsData);
                count++;
            }
        }

        DsSpiralkousinyoyakuHeaderRecordLayoutFile dsHeader = new DsSpiralkousinyoyakuHeaderRecordLayoutFile();
        dsHeader.setIfcRecordsikibetumojiretu("h");
        dsHeader.setIfcDtrecordkensuu(count);
        dsHeaderLst.add(dsHeader);

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filePathTsv);
            FileEntityManager fileEntityManager =
                FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.CSV);

            fileEntityManager.write(DsSpiralkousinyoyakuHeaderRecordLayoutFile.class,
                dsHeaderLst, fileOutputStream, false);
            fileEntityManager.write(DsSpiralkousinyoyakuDataRecordLayoutFile.class,
                dsDataLst, fileOutputStream, false);
            new File(filePathFin).createNewFile();
        }
        catch (Exception e) {
            throw new BizAppException(e, MessageId.EAS0027);
        }
        finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }catch (Exception e) {
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(count)));
    }

    private String getFilename(File pPath)  {

        String file = pPath.toString();

        int index = getSeparatorPosition(file);

        if (index < 0) {
            return file;
        }

        return file.substring(index + 1);
    }

    private int getSeparatorPosition(String pPath) {

        int index1 = pPath.lastIndexOf("/");
        int index2 = pPath.lastIndexOf("\\");

        if  (index2 > index1) {
            return index2;
        }

        return index1;
    }

}
