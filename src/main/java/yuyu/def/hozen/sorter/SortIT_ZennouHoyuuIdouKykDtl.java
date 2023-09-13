package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.meta.QIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.hozen.comparator.OrderIT_ZennouHoyuuIdouKykDtl;

public class SortIT_ZennouHoyuuIdouKykDtl {

    public List<IT_ZennouHoyuuIdouKykDtl> OrderIT_ZennouHoyuuIdouKykDtlByPkAsc(List<IT_ZennouHoyuuIdouKykDtl> pEntity) {
        List<SortCondition<IT_ZennouHoyuuIdouKykDtl>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).sakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).syoricd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).kykmfksnctr, SortOrder.ASC));
        List<IT_ZennouHoyuuIdouKykDtl> copyList = new ArrayList<IT_ZennouHoyuuIdouKykDtl>(pEntity);
        Collections.sort(copyList, new OrderIT_ZennouHoyuuIdouKykDtl(orders));
        return copyList;
    }

    public List<IT_ZennouHoyuuIdouKykDtl> OrderIT_ZennouHoyuuIdouKykDtlByPkDesc(List<IT_ZennouHoyuuIdouKykDtl> pEntity) {
        List<SortCondition<IT_ZennouHoyuuIdouKykDtl>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).sakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).syoricd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouHoyuuIdouKykDtl()).kykmfksnctr, SortOrder.DESC));
        List<IT_ZennouHoyuuIdouKykDtl> copyList = new ArrayList<IT_ZennouHoyuuIdouKykDtl>(pEntity);
        Collections.sort(copyList, new OrderIT_ZennouHoyuuIdouKykDtl(orders));
        return copyList;
    }
}
