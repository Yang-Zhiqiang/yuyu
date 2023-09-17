package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SikinIdouGroup;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.meta.QBM_SikinIdouGroup;

public class SortBM_SikinIdouGroup {

    public List<BM_SikinIdouGroup> OrderBM_SikinIdouGroupByPkAsc(List<BM_SikinIdouGroup> pEntity) {
        List<SortCondition<BM_SikinIdouGroup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SikinIdouGroup()).segcd, SortOrder.ASC));
        List<BM_SikinIdouGroup> copyList = new ArrayList<BM_SikinIdouGroup>(pEntity);
        Collections.sort(copyList, new OrderBM_SikinIdouGroup(orders));
        return copyList;
    }

    public List<BM_SikinIdouGroup> OrderBM_SikinIdouGroupByPkDesc(List<BM_SikinIdouGroup> pEntity) {
        List<SortCondition<BM_SikinIdouGroup>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SikinIdouGroup()).segcd, SortOrder.DESC));
        List<BM_SikinIdouGroup> copyList = new ArrayList<BM_SikinIdouGroup>(pEntity);
        Collections.sort(copyList, new OrderBM_SikinIdouGroup(orders));
        return copyList;
    }
}
