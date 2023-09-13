package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.db.meta.QIW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.hozen.comparator.OrderIW_KhSeinengappiSeiTeiseiWk;

public class SortIW_KhSeinengappiSeiTeiseiWk {

    public List<IW_KhSeinengappiSeiTeiseiWk> OrderIW_KhSeinengappiSeiTeiseiWkByPkAsc(List<IW_KhSeinengappiSeiTeiseiWk> pEntity) {
        List<SortCondition<IW_KhSeinengappiSeiTeiseiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhSeinengappiSeiTeiseiWk()).kouteikanriid, SortOrder.ASC));
        List<IW_KhSeinengappiSeiTeiseiWk> copyList = new ArrayList<IW_KhSeinengappiSeiTeiseiWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhSeinengappiSeiTeiseiWk(orders));
        return copyList;
    }

    public List<IW_KhSeinengappiSeiTeiseiWk> OrderIW_KhSeinengappiSeiTeiseiWkByPkDesc(List<IW_KhSeinengappiSeiTeiseiWk> pEntity) {
        List<SortCondition<IW_KhSeinengappiSeiTeiseiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhSeinengappiSeiTeiseiWk()).kouteikanriid, SortOrder.DESC));
        List<IW_KhSeinengappiSeiTeiseiWk> copyList = new ArrayList<IW_KhSeinengappiSeiTeiseiWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhSeinengappiSeiTeiseiWk(orders));
        return copyList;
    }

}

