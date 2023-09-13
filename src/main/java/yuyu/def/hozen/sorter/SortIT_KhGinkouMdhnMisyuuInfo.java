package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.meta.QIT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.hozen.comparator.OrderIT_KhGinkouMdhnMisyuuInfo;

public class SortIT_KhGinkouMdhnMisyuuInfo {

    public List<IT_KhGinkouMdhnMisyuuInfo> OrderIT_KhGinkouMdhnMisyuuInfoByPkAsc(List<IT_KhGinkouMdhnMisyuuInfo> pEntity) {
        List<SortCondition<IT_KhGinkouMdhnMisyuuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhGinkouMdhnMisyuuInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhGinkouMdhnMisyuuInfo()).datarenymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhGinkouMdhnMisyuuInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhGinkouMdhnMisyuuInfo()).henkousikibetukey, SortOrder.ASC));
        List<IT_KhGinkouMdhnMisyuuInfo> copyList = new ArrayList<IT_KhGinkouMdhnMisyuuInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_KhGinkouMdhnMisyuuInfo(orders));
        return copyList;
    }

    public List<IT_KhGinkouMdhnMisyuuInfo> OrderIT_KhGinkouMdhnMisyuuInfoByPkDesc(List<IT_KhGinkouMdhnMisyuuInfo> pEntity) {
        List<SortCondition<IT_KhGinkouMdhnMisyuuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhGinkouMdhnMisyuuInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhGinkouMdhnMisyuuInfo()).datarenymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhGinkouMdhnMisyuuInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhGinkouMdhnMisyuuInfo()).henkousikibetukey, SortOrder.DESC));
        List<IT_KhGinkouMdhnMisyuuInfo> copyList = new ArrayList<IT_KhGinkouMdhnMisyuuInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_KhGinkouMdhnMisyuuInfo(orders));
        return copyList;
    }
}
