package yuyu.app.base.log.batchjyoukyousyoukai;

/**
 * バッチ状況照会 - batchJobList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class BatchJobListDataSourceBean extends GenBatchJobListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public BatchJobListDataSourceBean() {
    }

    private String batchJobId;

    public String getBatchJobId() {
        return batchJobId;
    }

    public void setBatchJobId(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }

}
