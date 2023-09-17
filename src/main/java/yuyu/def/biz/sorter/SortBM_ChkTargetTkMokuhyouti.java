package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.def.db.meta.QBM_ChkTargetTkMokuhyouti;

public class SortBM_ChkTargetTkMokuhyouti {

    public List<BM_ChkTargetTkMokuhyouti> OrderBM_ChkTargetTkMokuhyoutiByPkAsc(List<BM_ChkTargetTkMokuhyouti> pEntity) {
        List<SortCondition<BM_ChkTargetTkMokuhyouti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).syusyouhnsdnofrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).syusyouhnsdnoto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).channelcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).targettkmokuhyouti, SortOrder.ASC));
        List<BM_ChkTargetTkMokuhyouti> copyList = new ArrayList<BM_ChkTargetTkMokuhyouti>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTargetTkMokuhyouti(orders));
        return copyList;
    }

    public List<BM_ChkTargetTkMokuhyouti> OrderBM_ChkTargetTkMokuhyoutiByPkDesc(List<BM_ChkTargetTkMokuhyouti> pEntity) {
        List<SortCondition<BM_ChkTargetTkMokuhyouti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).syusyouhnsdnofrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).syusyouhnsdnoto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).channelcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_ChkTargetTkMokuhyouti()).targettkmokuhyouti, SortOrder.DESC));
        List<BM_ChkTargetTkMokuhyouti> copyList = new ArrayList<BM_ChkTargetTkMokuhyouti>(pEntity);
        Collections.sort(copyList, new OrderBM_ChkTargetTkMokuhyouti(orders));
        return copyList;
    }
}
