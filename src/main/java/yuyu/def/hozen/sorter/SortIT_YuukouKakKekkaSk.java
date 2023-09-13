package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_YuukouKakKekkaSk;
import yuyu.def.db.meta.QIT_YuukouKakKekkaSk;
import yuyu.def.hozen.comparator.OrderIT_YuukouKakKekkaSk;

public class SortIT_YuukouKakKekkaSk {

    public List<IT_YuukouKakKekkaSk> OrderIT_YuukouKakKekkaSkByPkAsc(List<IT_YuukouKakKekkaSk> pEntity) {
        List<SortCondition<IT_YuukouKakKekkaSk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YuukouKakKekkaSk()).creditkessaiyouno, SortOrder.ASC));
        List<IT_YuukouKakKekkaSk> copyList = new ArrayList<IT_YuukouKakKekkaSk>(pEntity);
        Collections.sort(copyList, new OrderIT_YuukouKakKekkaSk(orders));
        return copyList;
    }

    public List<IT_YuukouKakKekkaSk> OrderIT_YuukouKakKekkaSkByPkDesc(List<IT_YuukouKakKekkaSk> pEntity) {
        List<SortCondition<IT_YuukouKakKekkaSk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YuukouKakKekkaSk()).creditkessaiyouno, SortOrder.DESC));
        List<IT_YuukouKakKekkaSk> copyList = new ArrayList<IT_YuukouKakKekkaSk>(pEntity);
        Collections.sort(copyList, new OrderIT_YuukouKakKekkaSk(orders));
        return copyList;
    }
}
