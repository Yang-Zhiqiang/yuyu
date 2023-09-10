package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.meta.QHM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.sinkeiyaku.comparator.OrderHM_TokuteiKankeiHjnNmTotugou;

public class SortHM_TokuteiKankeiHjnNmTotugou {

    
    public List<HM_TokuteiKankeiHjnNmTotugou> OrderHM_TokuteiKankeiHjnNmTotugouByPkAsc(List<HM_TokuteiKankeiHjnNmTotugou> pEntity) {
        List<SortCondition<HM_TokuteiKankeiHjnNmTotugou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHjnNmTotugou()).tkhjnkinyuucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHjnNmTotugou()).meisaino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHjnNmTotugou()).renno, SortOrder.ASC));
        List<HM_TokuteiKankeiHjnNmTotugou> copyList = new ArrayList<HM_TokuteiKankeiHjnNmTotugou>(pEntity);
        Collections.sort(copyList, new OrderHM_TokuteiKankeiHjnNmTotugou(orders));
        return copyList;
    }

    
    public List<HM_TokuteiKankeiHjnNmTotugou> OrderHM_TokuteiKankeiHjnNmTotugouByPkDesc(List<HM_TokuteiKankeiHjnNmTotugou> pEntity) {
        List<SortCondition<HM_TokuteiKankeiHjnNmTotugou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHjnNmTotugou()).tkhjnkinyuucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHjnNmTotugou()).meisaino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_TokuteiKankeiHjnNmTotugou()).renno, SortOrder.DESC));
        List<HM_TokuteiKankeiHjnNmTotugou> copyList = new ArrayList<HM_TokuteiKankeiHjnNmTotugou>(pEntity);
        Collections.sort(copyList, new OrderHM_TokuteiKankeiHjnNmTotugou(orders));
        return copyList;
    }
}
