package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_TokusyuKyuHantei;
import yuyu.def.db.meta.QJM_TokusyuKyuHantei;
import yuyu.def.siharai.comparator.OrderJM_TokusyuKyuHantei;

public class SortJM_TokusyuKyuHantei {

    
    public List<JM_TokusyuKyuHantei> OrderJM_TokusyuKyuHanteiByPkAsc(List<JM_TokusyuKyuHantei> pEntity) {
        List<SortCondition<JM_TokusyuKyuHantei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).byoumeitourokuno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).tekiyoukknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).tekiyoukknkto, SortOrder.ASC));
        List<JM_TokusyuKyuHantei> copyList = new ArrayList<JM_TokusyuKyuHantei>(pEntity);
        Collections.sort(copyList, new OrderJM_TokusyuKyuHantei(orders));
        return copyList;
    }

    
    public List<JM_TokusyuKyuHantei> OrderJM_TokusyuKyuHanteiByPkDesc(List<JM_TokusyuKyuHantei> pEntity) {
        List<SortCondition<JM_TokusyuKyuHantei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).byoumeitourokuno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).tekiyoukknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_TokusyuKyuHantei()).tekiyoukknkto, SortOrder.DESC));
        List<JM_TokusyuKyuHantei> copyList = new ArrayList<JM_TokusyuKyuHantei>(pEntity);
        Collections.sort(copyList, new OrderJM_TokusyuKyuHantei(orders));
        return copyList;
    }

}

