package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhHubiDetail;
import yuyu.def.db.meta.QIT_KhHubiDetail;
import yuyu.def.hozen.comparator.OrderIT_KhHubiDetail;

public class SortIT_KhHubiDetail {

    public List<IT_KhHubiDetail> OrderIT_KhHubiDetailByPkAsc(List<IT_KhHubiDetail> pEntity) {
        List<SortCondition<IT_KhHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHubiDetail()).hubisikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHubiDetail()).renno3keta, SortOrder.ASC));
        List<IT_KhHubiDetail> copyList = new ArrayList<IT_KhHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHubiDetail(orders));
        return copyList;
    }

    public List<IT_KhHubiDetail> OrderIT_KhHubiDetailByPkDesc(List<IT_KhHubiDetail> pEntity) {
        List<SortCondition<IT_KhHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHubiDetail()).hubisikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhHubiDetail()).renno3keta, SortOrder.DESC));
        List<IT_KhHubiDetail> copyList = new ArrayList<IT_KhHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHubiDetail(orders));
        return copyList;
    }
    public List<IT_KhHubiDetail> OrderIT_KhHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(List<IT_KhHubiDetail> pEntity) {
        List<SortCondition<IT_KhHubiDetail>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhHubiDetail()).kaisyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHubiDetail()).hasinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhHubiDetail()).renno3keta, SortOrder.ASC));
        List<IT_KhHubiDetail> copyList = new ArrayList<IT_KhHubiDetail>(pEntity);
        Collections.sort(copyList, new OrderIT_KhHubiDetail(orders));
        return copyList;
    }



}

