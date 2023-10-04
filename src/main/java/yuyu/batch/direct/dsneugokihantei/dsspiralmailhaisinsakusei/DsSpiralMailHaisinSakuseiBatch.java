package yuyu.batch.direct.dsneugokihantei.dsspiralmailhaisinsakusei;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.direct.dsneugokihantei.dsspiralmailhaisinsakusei.dba.DsSpiralMailHaisinSakuseiDao;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.classification.C_DsBatchKadouKnkKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.direct.file.csv.DsSpiralMailHaisinDataRecordLayoutFile;
import yuyu.def.direct.file.csv.DsSpiralMailHaisinHeaderRecordLayoutFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.file.FileControlManager;

import com.google.common.collect.Lists;

/**
 * ダイレクトサービス 値動き判定 ＳＰＩＲＡＬメール配信Ｆ作成
 */
public class DsSpiralMailHaisinSakuseiBatch implements Batch {

    private final String FILE_NAME_TJKNK = "SpiralMailHaisin2_";

    private final String FILE_NAME_DAI2KNK = "SpiralMailHaisin_";

    private final String EXTENSOPM_TSV = ".tsv";

    private final String EXTENSOPM_FIN = ".fin";

    private int syoriKensuu = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private DsSpiralMailHaisinSakuseiBatchParam dsSpiralMailHaisinSakuseiBatchParam;

    @Inject
    private DsSpiralMailHaisinSakuseiDao dsSpiralMailHaisinSakuseiDao;

    @Inject
    private FileControlManager fileControlManager;

    @Override
    public BatchParam getParam() {

        return dsSpiralMailHaisinSakuseiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate hoseizenSyoriYmd = dsSpiralMailHaisinSakuseiBatchParam.getSyoriYmd();
        BizDate syoriYmd = dsSpiralMailHaisinSakuseiBatchParam.getSyoriYmd().addBusinessDays(
            dsSpiralMailHaisinSakuseiBatchParam.getSyoriymdhoseinissuu());
        C_DsSousinMailSyubetuKbn dsSousinMailSyubetuKbn =
            dsSpiralMailHaisinSakuseiBatchParam.getDssousinmailsyubetukbn();
        C_DsBatchKadouKnkKbn dsBatchKadouknkKbn =
            dsSpiralMailHaisinSakuseiBatchParam.getDsBatchKadouknkKbn();
        String batchOutputDir = YuyuBaseConfig.getInstance().getBatchOutputDir();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(hoseizenSyoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IMW1003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IMW1005), dsSousinMailSyubetuKbn.getValue()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IMW1010), dsBatchKadouknkKbn.getValue()));

        String filename = "";
        if (C_DsBatchKadouKnkKbn.TUUJYOU_RAY1.eq(dsBatchKadouknkKbn)) {

            filename = FILE_NAME_TJKNK;
        }
        else {

            filename = FILE_NAME_DAI2KNK;
        }
        String filePathTsv = batchOutputDir + "/" + filename + String.valueOf(syoriYmd) + EXTENSOPM_TSV;
        String filePathFin = batchOutputDir + "/" + filename + String.valueOf(syoriYmd) + EXTENSOPM_FIN;

        File[] taisyouDirs = new File(batchOutputDir).listFiles();

        for (File taisyouDir : taisyouDirs) {

            String taisyouPath = taisyouDir.toString();

            String taisyouFileName = getFilename(taisyouPath);

            if (taisyouFileName.startsWith(filename)) {
                fileControlManager.remove(taisyouDir);
            }
        }

        List<DsSpiralMailHaisinHeaderRecordLayoutFile> headerRecordLayoutFileLst = Lists.newArrayList();
        List<DsSpiralMailHaisinDataRecordLayoutFile> dataRecordLayoutFileLst = Lists.newArrayList();

        if (C_DsBatchKadouKnkKbn.TUUJYOU_RAY1.eq(dsBatchKadouknkKbn)) {

            try (ExDBResults<MT_DsMailHaisin> dsMailHaisinLst =
                dsSpiralMailHaisinSakuseiDao.getDsMailHaisinByDssousinmailsyubetukbn()) {

                editSPIRALMailfile(dsMailHaisinLst, dataRecordLayoutFileLst);
            }
        }
        else {

            try (ExDBResults<MT_DsMailHaisin> dsMailHaisinLst =
                dsSpiralMailHaisinSakuseiDao.getDsMailHaisinByDssousinmailsyubetukbn(dsSousinMailSyubetuKbn)) {

                editSPIRALMailfile(dsMailHaisinLst, dataRecordLayoutFileLst);
            }
        }

        DsSpiralMailHaisinHeaderRecordLayoutFile headerRecordLayoutFile =
            SWAKInjector.getInstance(DsSpiralMailHaisinHeaderRecordLayoutFile.class);
        headerRecordLayoutFile.setIfcRecordsikibetumojiretu("h");
        headerRecordLayoutFile.setIfcDtrecordkensuu(syoriKensuu);

        headerRecordLayoutFileLst.add(headerRecordLayoutFile);

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filePathTsv);

            FileEntityManager fileEntityManager =
                FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.CSV);
            fileEntityManager.write(DsSpiralMailHaisinHeaderRecordLayoutFile.class,
                headerRecordLayoutFileLst, fileOutputStream, false);
            fileEntityManager.write(DsSpiralMailHaisinDataRecordLayoutFile.class,
                dataRecordLayoutFileLst, fileOutputStream, false);

            new File(filePathFin).createNewFile();

        } catch (Exception e) {
            throw new BizAppException(e, MessageId.EAS0027);
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Exception e) {
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensuu)));
    }

    private String getFilename(String pTaisyouPath) {

        int index1 = pTaisyouPath.lastIndexOf("/");
        int index2 = pTaisyouPath.lastIndexOf("\\");
        int lastIndex = 0;

        if (index2 > index1) {
            lastIndex = index2;
        }
        else {
            lastIndex = index1;
        }

        if (lastIndex < 0) {
            return pTaisyouPath;
        }

        return pTaisyouPath.substring(lastIndex + 1);
    }

    private void editSPIRALMailfile(ExDBResults<MT_DsMailHaisin> pDsMailHaisinLst,
        List<DsSpiralMailHaisinDataRecordLayoutFile> pDataRecordLayoutFileLst) {

        for (MT_DsMailHaisin dsMailHaisin : pDsMailHaisinLst) {
            DsSpiralMailHaisinDataRecordLayoutFile dataRecordLayoutFile =
                SWAKInjector.getInstance(DsSpiralMailHaisinDataRecordLayoutFile.class);

            dataRecordLayoutFile.setIfcDskokmailaddressskbtkey(dsMailHaisin.getDskokmailaddressskbtkey());
            dataRecordLayoutFile.setIfcDssousinmailsyubetukbn(dsMailHaisin.getDssousinmailsyubetukbn().getValue());
            dataRecordLayoutFile.setIfcDssousinno(dsMailHaisin.getDssousinno());
            dataRecordLayoutFile.setIfcSyono(dsMailHaisin.getSyono());
            dataRecordLayoutFile.setIfcDsmailaddress(dsMailHaisin.getDsmailaddress());
            dataRecordLayoutFile.setIfcSousinymd(new BizDateFormat("yyyy-MM-dd", FillStyle.Zero)
            .format(dsMailHaisin.getSousinymd()));
            dataRecordLayoutFile.setIfcSakujyoymd(new BizDateFormat("yyyy-MM-dd", FillStyle.Zero)
            .format(dsMailHaisin.getSousinymd().addBusinessDays(2)));
            dataRecordLayoutFile.setIfcSasikomikoumokusyou01(dsMailHaisin.getSasikomikoumokusyou01());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou02(dsMailHaisin.getSasikomikoumokusyou02());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou03(dsMailHaisin.getSasikomikoumokusyou03());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou04(dsMailHaisin.getSasikomikoumokusyou04());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou05(dsMailHaisin.getSasikomikoumokusyou05());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou06(dsMailHaisin.getSasikomikoumokusyou06());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou07(dsMailHaisin.getSasikomikoumokusyou07());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou08(dsMailHaisin.getSasikomikoumokusyou08());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou09(dsMailHaisin.getSasikomikoumokusyou09());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou10(dsMailHaisin.getSasikomikoumokusyou10());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou11(dsMailHaisin.getSasikomikoumokusyou11());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou12(dsMailHaisin.getSasikomikoumokusyou12());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou13(dsMailHaisin.getSasikomikoumokusyou13());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou14(dsMailHaisin.getSasikomikoumokusyou14());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou15(dsMailHaisin.getSasikomikoumokusyou15());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou16(dsMailHaisin.getSasikomikoumokusyou16());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou17(dsMailHaisin.getSasikomikoumokusyou17());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou18(dsMailHaisin.getSasikomikoumokusyou18());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou19(dsMailHaisin.getSasikomikoumokusyou19());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou20(dsMailHaisin.getSasikomikoumokusyou20());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou21(dsMailHaisin.getSasikomikoumokusyou21());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou22(dsMailHaisin.getSasikomikoumokusyou22());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou23(dsMailHaisin.getSasikomikoumokusyou23());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou24(dsMailHaisin.getSasikomikoumokusyou24());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou25(dsMailHaisin.getSasikomikoumokusyou25());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou26(dsMailHaisin.getSasikomikoumokusyou26());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou27(dsMailHaisin.getSasikomikoumokusyou27());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou28(dsMailHaisin.getSasikomikoumokusyou28());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou29(dsMailHaisin.getSasikomikoumokusyou29());
            dataRecordLayoutFile.setIfcSasikomikoumokusyou30(dsMailHaisin.getSasikomikoumokusyou30());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu01(dsMailHaisin.getSasikomikoumokutyuu01());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu02(dsMailHaisin.getSasikomikoumokutyuu02());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu03(dsMailHaisin.getSasikomikoumokutyuu03());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu04(dsMailHaisin.getSasikomikoumokutyuu04());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu05(dsMailHaisin.getSasikomikoumokutyuu05());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu06(dsMailHaisin.getSasikomikoumokutyuu06());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu07(dsMailHaisin.getSasikomikoumokutyuu07());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu08(dsMailHaisin.getSasikomikoumokutyuu08());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu09(dsMailHaisin.getSasikomikoumokutyuu09());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu10(dsMailHaisin.getSasikomikoumokutyuu10());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu11(dsMailHaisin.getSasikomikoumokutyuu11());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu12(dsMailHaisin.getSasikomikoumokutyuu12());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu13(dsMailHaisin.getSasikomikoumokutyuu13());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu14(dsMailHaisin.getSasikomikoumokutyuu14());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu15(dsMailHaisin.getSasikomikoumokutyuu15());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu16(dsMailHaisin.getSasikomikoumokutyuu16());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu17(dsMailHaisin.getSasikomikoumokutyuu17());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu18(dsMailHaisin.getSasikomikoumokutyuu18());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu19(dsMailHaisin.getSasikomikoumokutyuu19());
            dataRecordLayoutFile.setIfcSasikomikoumokutyuu20(dsMailHaisin.getSasikomikoumokutyuu20());
            dataRecordLayoutFile.setIfcSasikomikoumokudai01(dsMailHaisin.getSasikomikoumokudai01());
            dataRecordLayoutFile.setIfcSasikomikoumokudai02(dsMailHaisin.getSasikomikoumokudai02());
            dataRecordLayoutFile.setIfcSasikomikoumokudai03(dsMailHaisin.getSasikomikoumokudai03());
            dataRecordLayoutFile.setIfcSasikomikoumokudai04(dsMailHaisin.getSasikomikoumokudai04());
            dataRecordLayoutFile.setIfcSasikomikoumokudai05(dsMailHaisin.getSasikomikoumokudai05());
            dataRecordLayoutFile.setIfcSasikomikoumokudai06(dsMailHaisin.getSasikomikoumokudai06());
            dataRecordLayoutFile.setIfcSasikomikoumokudai07(dsMailHaisin.getSasikomikoumokudai07());
            dataRecordLayoutFile.setIfcSasikomikoumokudai08(dsMailHaisin.getSasikomikoumokudai08());
            dataRecordLayoutFile.setIfcSasikomikoumokudai09(dsMailHaisin.getSasikomikoumokudai09());
            dataRecordLayoutFile.setIfcSasikomikoumokudai10(dsMailHaisin.getSasikomikoumokudai10());
            pDataRecordLayoutFileLst.add(dataRecordLayoutFile);

            syoriKensuu++;
        }

    }
}
