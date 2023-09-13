package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
import yuyu.def.db.meta.QIT_KhShrRirekiDetail;
import yuyu.def.hozen.comparator.OrderIT_KhShrRirekiDetail;

public class SortIT_KhShrRirekiDetail {

    public List<IT_KhShrRirekiDetail> OrderIT_KhShrRirekiDetailByPkAsc(List<IT_KhShrRirekiDetail> pEntity) {
        List<SortCondition<IT_KhShrRirekiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_KhShrRirekiDetail> copyList = new ArrayList<IT_KhShrRirekiDetail>(pEntity);
        Collections.sort(copyList, new OrderIT_KhShrRirekiDetail(orders));
        return copyList;
    }

    public List<IT_KhShrRirekiDetail> OrderIT_KhShrRirekiDetailByPkDesc(List<IT_KhShrRirekiDetail> pEntity) {
        List<SortCondition<IT_KhShrRirekiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhShrRirekiDetail()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_KhShrRirekiDetail> copyList = new ArrayList<IT_KhShrRirekiDetail>(pEntity);
        Collections.sort(copyList, new OrderIT_KhShrRirekiDetail(orders));
        return copyList;
    }

}

