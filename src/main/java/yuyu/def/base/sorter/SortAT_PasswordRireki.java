package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_PasswordRireki;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_PasswordRireki;
import yuyu.def.db.meta.QAT_PasswordRireki;

public class SortAT_PasswordRireki {

    public List<AT_PasswordRireki> OrderAT_PasswordRirekiByPkAsc(List<AT_PasswordRireki> pEntity) {
        List<SortCondition<AT_PasswordRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_PasswordRireki()).uniqueId, SortOrder.ASC));
        List<AT_PasswordRireki> copyList = new ArrayList<AT_PasswordRireki>(pEntity);
        Collections.sort(copyList, new OrderAT_PasswordRireki(orders));
        return copyList;
    }

    public List<AT_PasswordRireki> OrderAT_PasswordRirekiByPkDesc(List<AT_PasswordRireki> pEntity) {
        List<SortCondition<AT_PasswordRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_PasswordRireki()).uniqueId, SortOrder.DESC));
        List<AT_PasswordRireki> copyList = new ArrayList<AT_PasswordRireki>(pEntity);
        Collections.sort(copyList, new OrderAT_PasswordRireki(orders));
        return copyList;
    }
}
