package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_OrderStatusuKbn;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.meta.QAS_BatchOrder;

public class AS_BatchOrderDao extends AbstractDao<AS_BatchOrder> {
    /**
     * コンストラクタ(デフォルト)
     */
    public AS_BatchOrderDao() {
        super(AS_BatchOrder.class);
    }

    public List<AS_BatchOrder> getBatchOrderByKinouId(String pKinouId) {
        AS_BatchOrder batchOrder  = new AS_BatchOrder();
        batchOrder.setKinouId(pKinouId);

        return select(batchOrder);
    }

    public List<AS_BatchOrder> getBatchOrderExecuteList(String pBatchJobId){
        QAS_BatchOrder qBatchOrder = new QAS_BatchOrder();

        StringBuffer query= new StringBuffer();
        query.append(" SELECT " + qBatchOrder.kinouId);
        query.append(" FROM " + qBatchOrder.AS_BatchOrder());
        query.append(" WHERE " + qBatchOrder.orderStatus.eq(C_OrderStatusuKbn.EXECUTE));
        query.append(" AND " + qBatchOrder.batchJobId.ne(pBatchJobId));
        query.append(" GROUP BY " + qBatchOrder.kinouId);

        return select(query.toString(),qBatchOrder);
    }

    public List<AS_BatchOrder> getBatchOrderList() {
        return selectAll();
    }

    public AS_BatchOrder getBatchOrderByBatchJobId(String pBatchJobId){
        return selectOne(new AS_BatchOrder(pBatchJobId));
    }

}
