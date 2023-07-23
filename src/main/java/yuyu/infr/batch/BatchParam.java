package yuyu.infr.batch;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_BatchKidouKbn;

/**
 * バッチパラメータ基底クラス
 */
@BatchScoped
public class BatchParam implements jp.co.slcs.swak.batch.engine.BatchParam {

    private static final long serialVersionUID = 9058278350004588880L;

    @Inject
    @Nullable
    @Named("userId")
    private String userId;

    @Inject
    private C_BatchKidouKbn kidouKbn;

    @Inject
    @Nullable
    @Named("batchSyoriYmd")
    private BizDate syoriYmd;

    private Integer batchExecOffsetDays;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public C_BatchKidouKbn getKidouKbn() {
        return kidouKbn;
    }

    public void setKidouKbn(C_BatchKidouKbn kidouKbn) {
        this.kidouKbn = kidouKbn;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        this.syoriYmd = pSyoriYmd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this, true);
    }

    public Integer getBatchExecOffsetDays() {
        return batchExecOffsetDays;
    }

    public void setBatchExecOffsetDays(Integer pBatchExecOffsetDays) {
        this.batchExecOffsetDays = pBatchExecOffsetDays;
    }

}
