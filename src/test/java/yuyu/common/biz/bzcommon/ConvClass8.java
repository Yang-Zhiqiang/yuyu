package yuyu.common.biz.bzcommon;

import javax.persistence.Column;

import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.mapping.GenAM_Batch;
import yuyu.def.db.mapping.GenAT_BatchJob;

public class ConvClass8 {

    private String batchJobId;

    @Column(name=GenAT_BatchJob.BATCHJOBID)
    public String getBatchJobId() {
        return batchJobId;
    }

    @Padding(mode = "left", padChar = '0', length = 20)
    public void setBatchJobId(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }

    private String batchClass;

    @Column(name=GenAM_Batch.BATCHCLASS)
    public String getBatchClass() {
        return batchClass;
    }

    public void setBatchClass(String pBatchClass) {
        batchJobId = pBatchClass;
    }
}
