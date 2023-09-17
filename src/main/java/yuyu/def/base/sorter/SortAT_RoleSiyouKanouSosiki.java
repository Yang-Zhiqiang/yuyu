package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_RoleSiyouKanouSosiki;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_RoleSiyouKanouSosiki;
import yuyu.def.db.meta.QAT_RoleSiyouKanouSosiki;

public class SortAT_RoleSiyouKanouSosiki {

    public List<AT_RoleSiyouKanouSosiki> OrderAT_RoleSiyouKanouSosikiByPkAsc(List<AT_RoleSiyouKanouSosiki> pEntity) {
        List<SortCondition<AT_RoleSiyouKanouSosiki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_RoleSiyouKanouSosiki()).syozokusosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_RoleSiyouKanouSosiki()).roleCd, SortOrder.ASC));
        List<AT_RoleSiyouKanouSosiki> copyList = new ArrayList<AT_RoleSiyouKanouSosiki>(pEntity);
        Collections.sort(copyList, new OrderAT_RoleSiyouKanouSosiki(orders));
        return copyList;
    }

    public List<AT_RoleSiyouKanouSosiki> OrderAT_RoleSiyouKanouSosikiByPkDesc(List<AT_RoleSiyouKanouSosiki> pEntity) {
        List<SortCondition<AT_RoleSiyouKanouSosiki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_RoleSiyouKanouSosiki()).syozokusosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_RoleSiyouKanouSosiki()).roleCd, SortOrder.DESC));
        List<AT_RoleSiyouKanouSosiki> copyList = new ArrayList<AT_RoleSiyouKanouSosiki>(pEntity);
        Collections.sort(copyList, new OrderAT_RoleSiyouKanouSosiki(orders));
        return copyList;
    }
}
