package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_IkkatuTekiyouNo2;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo2;
import yuyu.def.db.meta.QBM_IkkatuTekiyouNo2;

public class SortBM_IkkatuTekiyouNo2 {

    public List<BM_IkkatuTekiyouNo2> OrderBM_IkkatuTekiyouNo2ByPkAsc(List<BM_IkkatuTekiyouNo2> pEntity) {
        List<SortCondition<BM_IkkatuTekiyouNo2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).ryouritusdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).yoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).ikttekiyoubr1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).ikttekiyoubr2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).ikttekiyoubr3, SortOrder.ASC));
        List<BM_IkkatuTekiyouNo2> copyList = new ArrayList<BM_IkkatuTekiyouNo2>(pEntity);
        Collections.sort(copyList, new OrderBM_IkkatuTekiyouNo2(orders));
        return copyList;
    }

    public List<BM_IkkatuTekiyouNo2> OrderBM_IkkatuTekiyouNo2ByPkDesc(List<BM_IkkatuTekiyouNo2> pEntity) {
        List<SortCondition<BM_IkkatuTekiyouNo2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).ryouritusdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).yoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).ikttekiyoubr1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).ikttekiyoubr2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_IkkatuTekiyouNo2()).ikttekiyoubr3, SortOrder.DESC));
        List<BM_IkkatuTekiyouNo2> copyList = new ArrayList<BM_IkkatuTekiyouNo2>(pEntity);
        Collections.sort(copyList, new OrderBM_IkkatuTekiyouNo2(orders));
        return copyList;
    }
}
