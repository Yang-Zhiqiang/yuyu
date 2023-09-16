package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import yuyu.def.db.id.PKAT_BatchJob;
import yuyu.def.db.mapping.GenAT_BatchJob;
import yuyu.def.db.meta.GenQAT_BatchJob;
import yuyu.def.db.meta.QAT_BatchJob;

import com.google.common.collect.Lists;

/**
 * バッチジョブテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_BatchJob} の JavaDoc を参照してください。
 * @see     GenAT_BatchJob
 * @see     PKAT_BatchJob
 * @see     QAT_BatchJob
 * @see     GenQAT_BatchJob
 */
@Entity
public class AT_BatchJob extends GenAT_BatchJob {

    private static final long serialVersionUID = 1L;

    public AT_BatchJob() {
    }

    public AT_BatchJob(String pBatchJobId) {
        super(pBatchJobId);
    }

    private AM_Batch aM_Batch;

    @ManyToOne
    @JoinColumn(name = AT_BatchJob.BATCHID, referencedColumnName = AM_Batch.KINOUID, insertable = false, updatable = false)
    public AM_Batch getBatch() {
        return aM_Batch;
    }

    void setBatch(AM_Batch pBatch) {
        aM_Batch = pBatch;
    }

    private List<AT_BatchLog> aT_BatchLogs = Lists.newLinkedList();

    // 2014/03/18 T.Hoshino createBatchLog() は削除
    //
    // バッチログはバッチ基盤が自動的に出力するモノだ。
    // 業務側で勝手にバッチログ追加とか、できちゃいかんだろ..
    // (実際は実行していないバッチ処理をあたかも「実行しました」のように
    //  でっち上げるプログラム、とか作れちゃマズいだろ..
    //  こんなメソッドが存在しているだけで「このシステム、本当に大丈夫か？」
    //  って疑われるぞ...)
    //
    // たぶん「AT_BatchLog は AT_BatchJob の子テーブルに当たるので、条件反射的に crete() メソッドも用意した」
    // とかなんだろうけど、中にはこのメソッドのように「業務に公開すべきではないメソッド」も存在する。
    // ちゃんと「そのメソッドが用意してあることの意義」を考えること。
    //
    //    public AT_BatchLog createBatchLog() {
    //        AT_BatchLog aT_BatchLog = new AT_BatchLog();
    //        aT_BatchLog.setBatchJob(this);
    //        aT_BatchLog.setBatchJobId(this.getBatchJobId());
    //        getBatchLogs().add(aT_BatchLog);
    //        return aT_BatchLog;
    //    }

    public AT_BatchLog createBatchLog() {
        AT_BatchLog aT_BatchLog = new AT_BatchLog();
        aT_BatchLog.setBatchJob(this);
        aT_BatchLog.setBatchJobId(this.getBatchJobId());
        getBatchLogs().add(aT_BatchLog);
        return aT_BatchLog;
    }

    @OneToMany(
        cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumn(name = AT_BatchLog.BATCHJOBID, referencedColumnName = AT_BatchJob.BATCHJOBID, insertable = false, updatable = false)
    public List<AT_BatchLog> getBatchLogs() {
        return aT_BatchLogs;
    }

    public void setBatchLogs(List<AT_BatchLog> pBatchLogs) {
        aT_BatchLogs = pBatchLogs;
    }

    private List<AT_BatchLogReport> aT_BatchLogReports = Lists.newLinkedList();

    public AT_BatchLogReport createBatchLogReport() {
        AT_BatchLogReport aT_BatchLogReport = new AT_BatchLogReport();
        aT_BatchLogReport.setBatchJob(this);
        aT_BatchLogReport.setBatchJobId(this.getBatchJobId());
        getBatchLogReports().add(aT_BatchLogReport);
        return aT_BatchLogReport;
    }

    @OneToMany(
        cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumn(name = AT_BatchLogReport.BATCHJOBID, referencedColumnName = AT_BatchJob.BATCHJOBID, insertable = false, updatable = false)
    public List<AT_BatchLogReport> getBatchLogReports() {
        return aT_BatchLogReports;
    }

    public void setBatchLogReports(List<AT_BatchLogReport> pBatchLogReports) {
        aT_BatchLogReports = pBatchLogReports;
    }

    private List<AT_BatchLogFile> aT_BatchLogFiles = Lists.newLinkedList();

    public AT_BatchLogFile createBatchLogFile() {
        AT_BatchLogFile aT_BatchLogFile = new AT_BatchLogFile();
        aT_BatchLogFile.setBatchJob(this);
        aT_BatchLogFile.setBatchJobId(this.getBatchJobId());
        getBatchLogFiles().add(aT_BatchLogFile);
        return aT_BatchLogFile;
    }

    @OneToMany(
        cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumn(name = AT_BatchLogFile.BATCHJOBID, referencedColumnName = AT_BatchJob.BATCHJOBID, insertable = false, updatable = false)
    public List<AT_BatchLogFile> getBatchLogFiles() {
        return aT_BatchLogFiles;
    }

    public void setBatchLogFiles(List<AT_BatchLogFile> pBatchLogFiles) {
        aT_BatchLogFiles = pBatchLogFiles;
    }

    public AT_BatchLog getBatchLog(int pBatchLogEdaNo) {
        for (AT_BatchLog log : getBatchLogs()) {
            if (log.getBatchLogEdaNo().longValue() == pBatchLogEdaNo) {
                return log;
            }
        }
        return null;
    }

    public AT_BatchLogFile getBatchLogFile(String pUniqueId) {
        for (AT_BatchLogFile logfile : getBatchLogFiles()) {
            if (logfile.getUniqueId().equals(pUniqueId)) {
                return logfile;
            }
        }
        return null;
    }

    public AT_BatchLogReport getBatchLogReport(String pReportKey) {
        for (AT_BatchLogReport logfile : getBatchLogReports()) {
            if (logfile.getReportKey().equals(pReportKey)) {
                return logfile;
            }
        }
        return null;
    }
}
