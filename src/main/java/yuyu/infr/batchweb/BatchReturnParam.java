package yuyu.infr.batchweb;

import java.io.Serializable;

/**
 * クライアントバッチモジュール
 */
public class BatchReturnParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private String batchJobId;

    private String batchWarningMsg;

    public String getBatchJobId() {
        return batchJobId;
    }

    public void setBatchJobId(String batchJobId) {
        this.batchJobId = batchJobId;
    }

    public String getBatchWarningMsg() {
        return batchWarningMsg;
    }

    public void setBatchWarningMsg(String batchWarningMsg) {
        this.batchWarningMsg = batchWarningMsg;
    }
}
