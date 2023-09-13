package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.meta.QIW_KhSiteidairiTokuyakuWk;
import yuyu.def.hozen.comparator.OrderIW_KhSiteidairiTokuyakuWk;

public class SortIW_KhSiteidairiTokuyakuWk {

    public List<IW_KhSiteidairiTokuyakuWk> OrderIW_KhSiteidairiTokuyakuWkByPkAsc(List<IW_KhSiteidairiTokuyakuWk> pEntity) {
        List<SortCondition<IW_KhSiteidairiTokuyakuWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhSiteidairiTokuyakuWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhSiteidairiTokuyakuWk> copyList = new ArrayList<IW_KhSiteidairiTokuyakuWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhSiteidairiTokuyakuWk(orders));
        return copyList;
    }

    public List<IW_KhSiteidairiTokuyakuWk> OrderIW_KhSiteidairiTokuyakuWkByPkDesc(List<IW_KhSiteidairiTokuyakuWk> pEntity) {
        List<SortCondition<IW_KhSiteidairiTokuyakuWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhSiteidairiTokuyakuWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhSiteidairiTokuyakuWk> copyList = new ArrayList<IW_KhSiteidairiTokuyakuWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhSiteidairiTokuyakuWk(orders));
        return copyList;
    }

}

