package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_IkkatuTekiyouNo;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo;
import yuyu.def.db.meta.QBM_IkkatuTekiyouNo;

public class SortBM_IkkatuTekiyouNo {

    public List<BM_IkkatuTekiyouNo> OrderBM_IkkatuTekiyouNoByPkAsc(List<BM_IkkatuTekiyouNo> pEntity) {
        List<SortCondition<BM_IkkatuTekiyouNo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo()).ryouritusdno, SortOrder.ASC));
        List<BM_IkkatuTekiyouNo> copyList = new ArrayList<BM_IkkatuTekiyouNo>(pEntity);
        Collections.sort(copyList, new OrderBM_IkkatuTekiyouNo(orders));
        return copyList;
    }

    public List<BM_IkkatuTekiyouNo> OrderBM_IkkatuTekiyouNoByPkDesc(List<BM_IkkatuTekiyouNo> pEntity) {
        List<SortCondition<BM_IkkatuTekiyouNo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo()).ryouritusdno, SortOrder.DESC));
        List<BM_IkkatuTekiyouNo> copyList = new ArrayList<BM_IkkatuTekiyouNo>(pEntity);
        Collections.sort(copyList, new OrderBM_IkkatuTekiyouNo(orders));
        return copyList;
    }
}
