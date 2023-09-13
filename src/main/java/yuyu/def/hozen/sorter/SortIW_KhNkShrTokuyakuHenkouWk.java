package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhNkShrTokuyakuHenkouWk;
import yuyu.def.db.meta.QIW_KhNkShrTokuyakuHenkouWk;
import yuyu.def.hozen.comparator.OrderIW_KhNkShrTokuyakuHenkouWk;

public class SortIW_KhNkShrTokuyakuHenkouWk {

    public List<IW_KhNkShrTokuyakuHenkouWk> OrderIW_KhNkShrTokuyakuHenkouWkByPkAsc(List<IW_KhNkShrTokuyakuHenkouWk> pEntity) {
        List<SortCondition<IW_KhNkShrTokuyakuHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhNkShrTokuyakuHenkouWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhNkShrTokuyakuHenkouWk> copyList = new ArrayList<IW_KhNkShrTokuyakuHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhNkShrTokuyakuHenkouWk(orders));
        return copyList;
    }

    public List<IW_KhNkShrTokuyakuHenkouWk> OrderIW_KhNkShrTokuyakuHenkouWkByPkDesc(List<IW_KhNkShrTokuyakuHenkouWk> pEntity) {
        List<SortCondition<IW_KhNkShrTokuyakuHenkouWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhNkShrTokuyakuHenkouWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhNkShrTokuyakuHenkouWk> copyList = new ArrayList<IW_KhNkShrTokuyakuHenkouWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhNkShrTokuyakuHenkouWk(orders));
        return copyList;
    }

}

