package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhTmttknitenWk;
import yuyu.def.db.meta.QIW_KhTmttknitenWk;
import yuyu.def.hozen.comparator.OrderIW_KhTmttknitenWk;

public class SortIW_KhTmttknitenWk {

    public List<IW_KhTmttknitenWk> OrderIW_KhTmttknitenWkByPkAsc(List<IW_KhTmttknitenWk> pEntity) {
        List<SortCondition<IW_KhTmttknitenWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhTmttknitenWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhTmttknitenWk> copyList = new ArrayList<IW_KhTmttknitenWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhTmttknitenWk(orders));
        return copyList;
    }

    public List<IW_KhTmttknitenWk> OrderIW_KhTmttknitenWkByPkDesc(List<IW_KhTmttknitenWk> pEntity) {
        List<SortCondition<IW_KhTmttknitenWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhTmttknitenWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhTmttknitenWk> copyList = new ArrayList<IW_KhTmttknitenWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhTmttknitenWk(orders));
        return copyList;
    }
}
