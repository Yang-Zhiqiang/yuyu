package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_BatchLogFile;
import yuyu.def.db.mapping.GenAT_BatchLogFile;
import yuyu.def.db.meta.GenQAT_BatchLogFile;
import yuyu.def.db.meta.QAT_BatchLogFile;

/**
 * バッチログファイルテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_BatchLogFile} の JavaDoc を参照してください。
 * @see     GenAT_BatchLogFile
 * @see     PKAT_BatchLogFile
 * @see     QAT_BatchLogFile
 * @see     GenQAT_BatchLogFile
 */
@Entity
public class AT_BatchLogFile extends GenAT_BatchLogFile {

    private static final long serialVersionUID = 1L;

    public AT_BatchLogFile() {
    }

    public AT_BatchLogFile(String pBatchJobId, String pUniqueId) {
        super(pBatchJobId, pUniqueId);
    }

    private AT_BatchJob aT_BatchJob;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_BatchLogFile.BATCHJOBID, referencedColumnName=AT_BatchJob.BATCHJOBID, insertable=false, updatable=false)
    public AT_BatchJob getBatchJob() {
        return aT_BatchJob;
    }

    void setBatchJob(AT_BatchJob pBatchJob) {
        aT_BatchJob = pBatchJob;
    }

}
