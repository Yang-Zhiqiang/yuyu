package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_HaitaSyurui;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_HaitaSyurui;
import yuyu.def.db.meta.QAM_HaitaSyurui;

public class SortAM_HaitaSyurui {

    public List<AM_HaitaSyurui> OrderAM_HaitaSyuruiByPkAsc(List<AM_HaitaSyurui> pEntity) {
        List<SortCondition<AM_HaitaSyurui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_HaitaSyurui()).haitaSyuruiCd, SortOrder.ASC));
        List<AM_HaitaSyurui> copyList = new ArrayList<AM_HaitaSyurui>(pEntity);
        Collections.sort(copyList, new OrderAM_HaitaSyurui(orders));
        return copyList;
    }

    public List<AM_HaitaSyurui> OrderAM_HaitaSyuruiByPkDesc(List<AM_HaitaSyurui> pEntity) {
        List<SortCondition<AM_HaitaSyurui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_HaitaSyurui()).haitaSyuruiCd, SortOrder.DESC));
        List<AM_HaitaSyurui> copyList = new ArrayList<AM_HaitaSyurui>(pEntity);
        Collections.sort(copyList, new OrderAM_HaitaSyurui(orders));
        return copyList;
    }
}
