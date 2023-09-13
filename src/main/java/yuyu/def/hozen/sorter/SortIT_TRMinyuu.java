package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TRMinyuu;
import yuyu.def.db.meta.QIT_TRMinyuu;
import yuyu.def.hozen.comparator.OrderIT_TRMinyuu;

public class SortIT_TRMinyuu {

    public List<IT_TRMinyuu> OrderIT_TRMinyuuByPkAsc(List<IT_TRMinyuu> pEntity) {
        List<SortCondition<IT_TRMinyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRMinyuu()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRMinyuu()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRMinyuu()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRMinyuu()).minyuutrrenno, SortOrder.ASC));
        List<IT_TRMinyuu> copyList = new ArrayList<IT_TRMinyuu>(pEntity);
        Collections.sort(copyList, new OrderIT_TRMinyuu(orders));
        return copyList;
    }

    public List<IT_TRMinyuu> OrderIT_TRMinyuuByPkDesc(List<IT_TRMinyuu> pEntity) {
        List<SortCondition<IT_TRMinyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRMinyuu()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRMinyuu()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRMinyuu()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRMinyuu()).minyuutrrenno, SortOrder.DESC));
        List<IT_TRMinyuu> copyList = new ArrayList<IT_TRMinyuu>(pEntity);
        Collections.sort(copyList, new OrderIT_TRMinyuu(orders));
        return copyList;
    }
}
