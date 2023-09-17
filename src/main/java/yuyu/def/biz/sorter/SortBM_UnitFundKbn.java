package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_UnitFundKbn;
import yuyu.def.db.entity.BM_UnitFundKbn;
import yuyu.def.db.meta.QBM_UnitFundKbn;

public class SortBM_UnitFundKbn {

    public List<BM_UnitFundKbn> OrderBM_UnitFundKbnByPkAsc(List<BM_UnitFundKbn> pEntity) {
        List<SortCondition<BM_UnitFundKbn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_UnitFundKbn()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_UnitFundKbn()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_UnitFundKbn()).tuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_UnitFundKbn()).renno, SortOrder.ASC));
        List<BM_UnitFundKbn> copyList = new ArrayList<BM_UnitFundKbn>(pEntity);
        Collections.sort(copyList, new OrderBM_UnitFundKbn(orders));
        return copyList;
    }

    public List<BM_UnitFundKbn> OrderBM_UnitFundKbnByPkDesc(List<BM_UnitFundKbn> pEntity) {
        List<SortCondition<BM_UnitFundKbn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_UnitFundKbn()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_UnitFundKbn()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_UnitFundKbn()).tuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_UnitFundKbn()).renno, SortOrder.DESC));
        List<BM_UnitFundKbn> copyList = new ArrayList<BM_UnitFundKbn>(pEntity);
        Collections.sort(copyList, new OrderBM_UnitFundKbn(orders));
        return copyList;
    }

}

