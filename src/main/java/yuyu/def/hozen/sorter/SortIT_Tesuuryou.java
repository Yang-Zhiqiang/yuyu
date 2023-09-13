package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.meta.QIT_Tesuuryou;
import yuyu.def.hozen.comparator.OrderIT_Tesuuryou;

public class SortIT_Tesuuryou {

    public List<IT_Tesuuryou> OrderIT_TesuuryouByPkAsc(List<IT_Tesuuryou> pEntity) {
        List<SortCondition<IT_Tesuuryou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Tesuuryou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Tesuuryou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Tesuuryou()).tsrysyorikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Tesuuryou()).renno, SortOrder.ASC));
        List<IT_Tesuuryou> copyList = new ArrayList<IT_Tesuuryou>(pEntity);
        Collections.sort(copyList, new OrderIT_Tesuuryou(orders));
        return copyList;
    }

    public List<IT_Tesuuryou> OrderIT_TesuuryouByPkDesc(List<IT_Tesuuryou> pEntity) {
        List<SortCondition<IT_Tesuuryou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Tesuuryou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Tesuuryou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Tesuuryou()).tsrysyorikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Tesuuryou()).renno, SortOrder.DESC));
        List<IT_Tesuuryou> copyList = new ArrayList<IT_Tesuuryou>(pEntity);
        Collections.sort(copyList, new OrderIT_Tesuuryou(orders));
        return copyList;
    }
    public List<IT_Tesuuryou> OrderIT_TesuuryouByRennoDesc(List<IT_Tesuuryou> pEntity) {
        List<SortCondition<IT_Tesuuryou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Tesuuryou()).renno, SortOrder.DESC));
        List<IT_Tesuuryou> copyList = new ArrayList<IT_Tesuuryou>(pEntity);
        Collections.sort(copyList, new OrderIT_Tesuuryou(orders));
        return copyList;
    }


}

