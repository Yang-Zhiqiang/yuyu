package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAS_BatchOrder;
import yuyu.def.db.mapping.GenAS_BatchOrder;
import yuyu.def.db.meta.GenQAS_BatchOrder;
import yuyu.def.db.meta.QAS_BatchOrder;

/**
 * バッチ予約テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_BatchOrder} の JavaDoc を参照してください。
 * @see     GenAS_BatchOrder
 * @see     PKAS_BatchOrder
 * @see     QAS_BatchOrder
 * @see     GenQAS_BatchOrder
 */
@Entity
public class AS_BatchOrder extends GenAS_BatchOrder {

    private static final long serialVersionUID = 1L;

    public AS_BatchOrder() {
    }

    public AS_BatchOrder(String pBatchJobId) {
        super(pBatchJobId);
    }

    private AM_Batch aM_Batch;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AS_BatchOrder.KINOUID, referencedColumnName=AM_Batch.KINOUID, insertable=false, updatable=false)
    public AM_Batch getBatch(){
        return aM_Batch;
    }

    public void setBatch(AM_Batch pBatch){
        aM_Batch = pBatch;
    }

}
