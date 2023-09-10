package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.meta.QJT_SiDetail;
import yuyu.def.siharai.comparator.OrderJT_SiDetail;

public class SortJT_SiDetail {

    
    public List<JT_SiDetail> OrderJT_SiDetailByPkAsc(List<JT_SiDetail> pEntity) {
        List<SortCondition<JT_SiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDetail()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).seikyuurirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).uketukeno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).kyhgndkatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).kyksyouhnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).kyuuhucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).renno, SortOrder.ASC));
        List<JT_SiDetail> copyList = new ArrayList<JT_SiDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDetail(orders));
        return copyList;
    }

    
    public List<JT_SiDetail> OrderJT_SiDetailByPkDesc(List<JT_SiDetail> pEntity) {
        List<SortCondition<JT_SiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDetail()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).seikyuurirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).uketukeno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).kyhgndkatakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).kyksyouhnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).kyuuhucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).renno, SortOrder.DESC));
        List<JT_SiDetail> copyList = new ArrayList<JT_SiDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDetail(orders));
        return copyList;
    }
    
    public List<JT_SiDetail> OrderJT_SiDetailByUketukenoKyuuhukbnKyuuhucdRennoAsc(List<JT_SiDetail> pEntity) {
        List<SortCondition<JT_SiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDetail()).uketukeno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).kyuuhukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).kyuuhucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).renno, SortOrder.ASC));
        List<JT_SiDetail> copyList = new ArrayList<JT_SiDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDetail(orders));
        return copyList;
    }
    
    public List<JT_SiDetail> OrderJT_SiDetailByUketukenoRennoAsc(List<JT_SiDetail> pEntity) {
        List<SortCondition<JT_SiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDetail()).uketukeno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetail()).renno, SortOrder.ASC));
        List<JT_SiDetail> copyList = new ArrayList<JT_SiDetail>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDetail(orders));
        return copyList;
    }



}

