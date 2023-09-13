package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TRGinkouTouhaigou;
import yuyu.def.db.meta.QIT_TRGinkouTouhaigou;
import yuyu.def.hozen.comparator.OrderIT_TRGinkouTouhaigou;

public class SortIT_TRGinkouTouhaigou {

    public List<IT_TRGinkouTouhaigou> OrderIT_TRGinkouTouhaigouByPkAsc(List<IT_TRGinkouTouhaigou> pEntity) {
        List<SortCondition<IT_TRGinkouTouhaigou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRGinkouTouhaigou()).bfrikkatuseibibankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRGinkouTouhaigou()).bfrikkatuseibisitencd, SortOrder.ASC));
        List<IT_TRGinkouTouhaigou> copyList = new ArrayList<IT_TRGinkouTouhaigou>(pEntity);
        Collections.sort(copyList, new OrderIT_TRGinkouTouhaigou(orders));
        return copyList;
    }

    public List<IT_TRGinkouTouhaigou> OrderIT_TRGinkouTouhaigouByPkDesc(List<IT_TRGinkouTouhaigou> pEntity) {
        List<SortCondition<IT_TRGinkouTouhaigou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRGinkouTouhaigou()).bfrikkatuseibibankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRGinkouTouhaigou()).bfrikkatuseibisitencd, SortOrder.DESC));
        List<IT_TRGinkouTouhaigou> copyList = new ArrayList<IT_TRGinkouTouhaigou>(pEntity);
        Collections.sort(copyList, new OrderIT_TRGinkouTouhaigou(orders));
        return copyList;
    }
}
