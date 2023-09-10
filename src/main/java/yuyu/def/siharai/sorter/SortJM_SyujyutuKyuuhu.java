package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_SyujyutuKyuuhu;
import yuyu.def.db.meta.QJM_SyujyutuKyuuhu;
import yuyu.def.siharai.comparator.OrderJM_SyujyutuKyuuhu;

public class SortJM_SyujyutuKyuuhu {

    
    public List<JM_SyujyutuKyuuhu> OrderJM_SyujyutuKyuuhuByPkAsc(List<JM_SyujyutuKyuuhu> pEntity) {
        List<SortCondition<JM_SyujyutuKyuuhu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syujyutubunruicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).kyuuhucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syujyututekiyoukkanfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syujyututekiyoukkanto, SortOrder.ASC));
        List<JM_SyujyutuKyuuhu> copyList = new ArrayList<JM_SyujyutuKyuuhu>(pEntity);
        Collections.sort(copyList, new OrderJM_SyujyutuKyuuhu(orders));
        return copyList;
    }

    
    public List<JM_SyujyutuKyuuhu> OrderJM_SyujyutuKyuuhuByPkDesc(List<JM_SyujyutuKyuuhu> pEntity) {
        List<SortCondition<JM_SyujyutuKyuuhu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syujyutubunruicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).kyuuhucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syujyututekiyoukkanfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SyujyutuKyuuhu()).syujyututekiyoukkanto, SortOrder.DESC));
        List<JM_SyujyutuKyuuhu> copyList = new ArrayList<JM_SyujyutuKyuuhu>(pEntity);
        Collections.sort(copyList, new OrderJM_SyujyutuKyuuhu(orders));
        return copyList;
    }

}

