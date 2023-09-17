package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkJhSaiteiS;
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import yuyu.def.db.meta.QBM_ChkJhSaiteiS;

public class SortBM_ChkJhSaiteiS {

    public List<BM_ChkJhSaiteiS> OrderBM_ChkJhSaiteiSByPkAsc(List<BM_ChkJhSaiteiS> pEntity) {
        List<SortCondition<BM_ChkJhSaiteiS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).dntsdnumufrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).dntsdnumuto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).hrkkknsmnkbnfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).hrkkknsmnkbnto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).hknkknfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).hknkknto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).saiteisknwtkumufrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).saiteisknwtkumuto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).tuukasyu, SortOrder.ASC));
        List<BM_ChkJhSaiteiS> copyList = new ArrayList<BM_ChkJhSaiteiS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhSaiteiS(orders));
        return copyList;
    }

    public List<BM_ChkJhSaiteiS> OrderBM_ChkJhSaiteiSByPkDesc(List<BM_ChkJhSaiteiS> pEntity) {
        List<SortCondition<BM_ChkJhSaiteiS>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).dntsdnumufrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).dntsdnumuto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).hrkkknsmnkbnfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).hrkkknsmnkbnto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).hknkknfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).hknkknto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).saiteisknwtkumufrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).saiteisknwtkumuto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkJhSaiteiS()).tuukasyu, SortOrder.DESC));
        List<BM_ChkJhSaiteiS> copyList = new ArrayList<BM_ChkJhSaiteiS>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkJhSaiteiS(orders));
        return copyList;
    }

}

