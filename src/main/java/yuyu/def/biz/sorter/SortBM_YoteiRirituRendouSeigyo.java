package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_YoteiRirituRendouSeigyo;
import yuyu.def.db.entity.BM_YoteiRirituRendouSeigyo;
import yuyu.def.db.meta.QBM_YoteiRirituRendouSeigyo;

public class SortBM_YoteiRirituRendouSeigyo {

    public List<BM_YoteiRirituRendouSeigyo> OrderBM_YoteiRirituRendouSeigyoByPkAsc(List<BM_YoteiRirituRendouSeigyo> pEntity) {
        List<SortCondition<BM_YoteiRirituRendouSeigyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_YoteiRirituRendouSeigyo()).yoteirirituhanteidfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRirituRendouSeigyo()).yoteirirituhanteidto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_YoteiRirituRendouSeigyo()).syouhncd, SortOrder.ASC));
        List<BM_YoteiRirituRendouSeigyo> copyList = new ArrayList<BM_YoteiRirituRendouSeigyo>(pEntity);
        Collections.sort(copyList, new OrderBM_YoteiRirituRendouSeigyo(orders));
        return copyList;
    }

    public List<BM_YoteiRirituRendouSeigyo> OrderBM_YoteiRirituRendouSeigyoByPkDesc(List<BM_YoteiRirituRendouSeigyo> pEntity) {
        List<SortCondition<BM_YoteiRirituRendouSeigyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_YoteiRirituRendouSeigyo()).yoteirirituhanteidfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRirituRendouSeigyo()).yoteirirituhanteidto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_YoteiRirituRendouSeigyo()).syouhncd, SortOrder.DESC));
        List<BM_YoteiRirituRendouSeigyo> copyList = new ArrayList<BM_YoteiRirituRendouSeigyo>(pEntity);
        Collections.sort(copyList, new OrderBM_YoteiRirituRendouSeigyo(orders));
        return copyList;
    }
}
