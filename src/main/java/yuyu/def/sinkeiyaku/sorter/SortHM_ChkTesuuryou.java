package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_ChkTesuuryou;
import yuyu.def.db.meta.QHM_ChkTesuuryou;
import yuyu.def.sinkeiyaku.comparator.OrderHM_ChkTesuuryou;

public class SortHM_ChkTesuuryou {

    
    public List<HM_ChkTesuuryou> OrderHM_ChkTesuuryouByPkAsc(List<HM_ChkTesuuryou> pEntity) {
        List<SortCondition<HM_ChkTesuuryou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_ChkTesuuryou()).renno3keta, SortOrder.ASC));
        List<HM_ChkTesuuryou> copyList = new ArrayList<HM_ChkTesuuryou>(pEntity);
        Collections.sort(copyList, new OrderHM_ChkTesuuryou(orders));
        return copyList;
    }

    
    public List<HM_ChkTesuuryou> OrderHM_ChkTesuuryouByPkDesc(List<HM_ChkTesuuryou> pEntity) {
        List<SortCondition<HM_ChkTesuuryou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_ChkTesuuryou()).renno3keta, SortOrder.DESC));
        List<HM_ChkTesuuryou> copyList = new ArrayList<HM_ChkTesuuryou>(pEntity);
        Collections.sort(copyList, new OrderHM_ChkTesuuryou(orders));
        return copyList;
    }

}

