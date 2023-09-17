package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_TokujyouSakugenRate;
import yuyu.def.db.entity.BM_TokujyouSakugenRate;
import yuyu.def.db.meta.QBM_TokujyouSakugenRate;

public class SortBM_TokujyouSakugenRate {

    public List<BM_TokujyouSakugenRate> OrderBM_TokujyouSakugenRateByPkAsc(List<BM_TokujyouSakugenRate> pEntity) {
        List<SortCondition<BM_TokujyouSakugenRate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TokujyouSakugenRate()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_TokujyouSakugenRate()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_TokujyouSakugenRate()).tkjyskgnkkn, SortOrder.ASC));
        List<BM_TokujyouSakugenRate> copyList = new ArrayList<BM_TokujyouSakugenRate>(pEntity);
        Collections.sort(copyList, new OrderBM_TokujyouSakugenRate(orders));
        return copyList;
    }

    public List<BM_TokujyouSakugenRate> OrderBM_TokujyouSakugenRateByPkDesc(List<BM_TokujyouSakugenRate> pEntity) {
        List<SortCondition<BM_TokujyouSakugenRate>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_TokujyouSakugenRate()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_TokujyouSakugenRate()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_TokujyouSakugenRate()).tkjyskgnkkn, SortOrder.DESC));
        List<BM_TokujyouSakugenRate> copyList = new ArrayList<BM_TokujyouSakugenRate>(pEntity);
        Collections.sort(copyList, new OrderBM_TokujyouSakugenRate(orders));
        return copyList;
    }

}

