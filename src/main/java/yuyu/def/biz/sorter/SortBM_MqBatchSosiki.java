package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_MqBatchSosiki;
import yuyu.def.db.entity.BM_MqBatchSosiki;
import yuyu.def.db.meta.QBM_MqBatchSosiki;

public class SortBM_MqBatchSosiki {

    public List<BM_MqBatchSosiki> OrderBM_MqBatchSosikiByPkAsc(List<BM_MqBatchSosiki> pEntity) {
        List<SortCondition<BM_MqBatchSosiki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_MqBatchSosiki()).kinouId, SortOrder.ASC));
        List<BM_MqBatchSosiki> copyList = new ArrayList<BM_MqBatchSosiki>(pEntity);
        Collections.sort(copyList, new OrderBM_MqBatchSosiki(orders));
        return copyList;
    }

    public List<BM_MqBatchSosiki> OrderBM_MqBatchSosikiByPkDesc(List<BM_MqBatchSosiki> pEntity) {
        List<SortCondition<BM_MqBatchSosiki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_MqBatchSosiki()).kinouId, SortOrder.DESC));
        List<BM_MqBatchSosiki> copyList = new ArrayList<BM_MqBatchSosiki>(pEntity);
        Collections.sort(copyList, new OrderBM_MqBatchSosiki(orders));
        return copyList;
    }
}
