package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_BatchLog;
import yuyu.def.db.mapping.GenAT_BatchLog;
import yuyu.def.db.meta.GenQAT_BatchLog;
import yuyu.def.db.meta.QAT_BatchLog;

/**
 * バッチログテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_BatchLog} の JavaDoc を参照してください。
 * @see     GenAT_BatchLog
 * @see     PKAT_BatchLog
 * @see     QAT_BatchLog
 * @see     GenQAT_BatchLog
 */
@Entity
public class AT_BatchLog extends GenAT_BatchLog {

    private static final long serialVersionUID = 1L;

    public AT_BatchLog() {
    }

    public AT_BatchLog(String pBatchJobId, Integer pBatchLogEdaNo) {
        super(pBatchJobId, pBatchLogEdaNo);
    }

    private AT_BatchJob aT_BatchJob;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_BatchLog.BATCHJOBID, referencedColumnName=AT_BatchJob.BATCHJOBID, insertable=false, updatable=false)
    public AT_BatchJob getBatchJob() {
        return aT_BatchJob;
    }

    void setBatchJob(AT_BatchJob pBatchJob) {
        aT_BatchJob = pBatchJob;
    }

}
