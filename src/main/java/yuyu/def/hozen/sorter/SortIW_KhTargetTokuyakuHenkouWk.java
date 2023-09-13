package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhTargetTokuyakuHenkouWk;
import yuyu.def.db.meta.QIW_KhTargetTokuyakuHenkouWk;
import yuyu.def.hozen.comparator.OrderIW_KhTargetTokuyakuHenkouWk;

public class SortIW_KhTargetTokuyakuHenkouWk {

    public List<IW_KhTargetTokuyakuHenkouWk> OrderIW_KhTargetTokuyakuHenkouWkByPkAsc(List<IW_KhTargetTokuyakuHenkouWk> pEntity) {
        List<SortCondition<IW_KhTargetTokuyakuHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhTargetTokuyakuHenkouWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhTargetTokuyakuHenkouWk> copyList = new ArrayList<IW_KhTargetTokuyakuHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhTargetTokuyakuHenkouWk(orders));
        return copyList;
    }

    public List<IW_KhTargetTokuyakuHenkouWk> OrderIW_KhTargetTokuyakuHenkouWkByPkDesc(List<IW_KhTargetTokuyakuHenkouWk> pEntity) {
        List<SortCondition<IW_KhTargetTokuyakuHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhTargetTokuyakuHenkouWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhTargetTokuyakuHenkouWk> copyList = new ArrayList<IW_KhTargetTokuyakuHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhTargetTokuyakuHenkouWk(orders));
        return copyList;
    }

}

