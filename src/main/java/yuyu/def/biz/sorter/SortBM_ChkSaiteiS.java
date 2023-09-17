package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkSaiteiS;
import yuyu.def.db.entity.BM_ChkSaiteiS;
import yuyu.def.db.meta.QBM_ChkSaiteiS;

public class SortBM_ChkSaiteiS {

    public List<BM_ChkSaiteiS> OrderBM_ChkSaiteiSByPkAsc(List<BM_ChkSaiteiS> pEntity) {
        List<SortCondition<BM_ChkSaiteiS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).dntsdnumufrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).dntsdnumuto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).hrkkknsmnkbnfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).hrkkknsmnkbnto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).hknkknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).hknkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).saiteisknwtkumufrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).saiteisknwtkumuto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).tuukasyu, SortOrder.ASC));
        List<BM_ChkSaiteiS> copyList = new ArrayList<BM_ChkSaiteiS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSaiteiS(orders));
        return copyList;
    }

    public List<BM_ChkSaiteiS> OrderBM_ChkSaiteiSByPkDesc(List<BM_ChkSaiteiS> pEntity) {
        List<SortCondition<BM_ChkSaiteiS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).dntsdnumufrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).dntsdnumuto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).hrkkknsmnkbnfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).hrkkknsmnkbnto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).hknkknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).hknkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).saiteisknwtkumufrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).saiteisknwtkumuto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkSaiteiS()).tuukasyu, SortOrder.DESC));
        List<BM_ChkSaiteiS> copyList = new ArrayList<BM_ChkSaiteiS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkSaiteiS(orders));
        return copyList;
    }

}

