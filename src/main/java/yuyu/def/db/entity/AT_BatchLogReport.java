package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_BatchLogReport;
import yuyu.def.db.mapping.GenAT_BatchLogReport;
import yuyu.def.db.meta.GenQAT_BatchLogReport;
import yuyu.def.db.meta.QAT_BatchLogReport;

/**
 * バッチログレポートテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_BatchLogReport} の JavaDoc を参照してください。
 * @see     GenAT_BatchLogReport
 * @see     PKAT_BatchLogReport
 * @see     QAT_BatchLogReport
 * @see     GenQAT_BatchLogReport
 */
@Entity
public class AT_BatchLogReport extends GenAT_BatchLogReport {

    private static final long serialVersionUID = 1L;

    public AT_BatchLogReport() {
    }

    public AT_BatchLogReport(String pBatchJobId, String pReportKey) {
        super(pBatchJobId, pReportKey);
    }


    private AT_BatchJob aT_BatchJob;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_BatchLogReport.BATCHJOBID, referencedColumnName=AT_BatchJob.BATCHJOBID, insertable=false, updatable=false)
    public AT_BatchJob getBatchJob() {
        return aT_BatchJob;
    }

    void setBatchJob(AT_BatchJob pBatchJob) {
        aT_BatchJob = pBatchJob;
    }

}
