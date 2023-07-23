package yuyu.infr.batch.reportandfile;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.batch.engine.BatchJob;
import jp.co.slcs.swak.batch.reportandfile.ReportAndFileManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.entity.AT_BatchLogFile;
import yuyu.def.db.entity.AT_BatchLogReport;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.entity.AT_TyouhyouHozon;

/**
 * バッチ結果添付管理クラスです。<br />
 * バッチ結果添付ファイル、および帳票をセットできるようにします。<br/>
 */
@BatchScoped
public class ReportAndFileControl implements ReportAndFileManager {

    @Inject
    private BatchJob batchJob;

    @Inject
    private BaseDomManager baseDomManager;

    @Override
    public void appendBatchLogReport(String... reportKeys) {
        if (reportKeys == null || reportKeys.length == 0) {
            return;
        }

        for (String reportKey : reportKeys) {

            if (reportKey == null || "".equals(reportKey)) {
                continue;
            }

            final AT_BatchLogReport batchLogReport = new AT_BatchLogReport();

            batchLogReport.setBatchJobId(batchJob.getBatchJobId());
            batchLogReport.setReportKey(reportKey);
            batchLogReport.setBatchSyoriYmd(BizDate.getSysDate());

            ExDBTransactional.run(
                new TransactionalCode() {
                    @Override
                    public void accept(ExDBEntityManager entityManager) {
                        entityManager.persist(batchLogReport);
                    }
                }
                );
        }
    }

    @Override
    public void appendBatchLogFile(String... fileKeys) {
        if (fileKeys == null || fileKeys.length == 0) {
            return;
        }

        for (String fileKey : fileKeys) {

            if (fileKey == null || "".equals(fileKey)) {
                continue;
            }

            final AT_BatchLogFile batchLogFile = new AT_BatchLogFile();

            batchLogFile.setBatchJobId(batchJob.getBatchJobId());
            batchLogFile.setUniqueId(fileKey);
            batchLogFile.setBatchSyoriYmd(BizDate.getSysDate());

            ExDBTransactional.run(
                new TransactionalCode() {
                    @Override
                    public void accept(ExDBEntityManager entityManager) {
                        entityManager.persist(batchLogFile);
                    }
                }
                );
        }
    }

    @Override
    public byte[] getBatchLogReport(String reportKey) {

        AT_TyouhyouHozon tyouhyouHozon = baseDomManager.getTyouhyouHozon(reportKey);

        if (tyouhyouHozon == null) {
            return null;
        }

        return tyouhyouHozon.getPdfData();
    }

    @Override
    public byte[] getBatchLogFile(String fileKey) {
        AT_FileHozon fileHozon = baseDomManager.getFileHozon(fileKey);

        if (fileHozon == null) {
            return null;
        }

        return fileHozon.getFileContents();
    }

    @Override
    public List<byte[]> getBatchLogReportList(String batchJobId) {
        List<byte[]> byteList = null;

        AT_BatchJob batchJobEntity = baseDomManager.getBatchJob(batchJobId);

        if (batchJobEntity == null) {
            return null;
        }

        List<AT_BatchLogReport> logReports = batchJobEntity.getBatchLogReports();

        if (logReports != null && logReports.size() > 0) {
            byteList = new ArrayList<byte[]>();
        } else {
            return null;
        }

        for (AT_BatchLogReport report : logReports) {
            AT_TyouhyouHozon tyouhyouHozon = baseDomManager.getTyouhyouHozon(report.getReportKey());
            byteList.add(tyouhyouHozon.getPdfData());
        }

        return byteList;
    }

    @Override
    public List<byte[]> getBatchLogFileList(String batchJobId) {
        List<byte[]> byteList = null;

        AT_BatchJob batchJobEntity = baseDomManager.getBatchJob(batchJobId);

        if (batchJobEntity == null) {
            return null;
        }

        List<AT_BatchLogFile> logFiles = batchJobEntity.getBatchLogFiles();

        if (logFiles != null && logFiles.size() > 0) {
            byteList = new ArrayList<byte[]>();
        } else {
            return null;
        }

        for (AT_BatchLogFile report : logFiles) {
            AT_FileHozon fileHozon = baseDomManager.getFileHozon(report.getUniqueId());
            byteList.add(fileHozon.getFileContents());
        }

        return byteList;
    }

}
