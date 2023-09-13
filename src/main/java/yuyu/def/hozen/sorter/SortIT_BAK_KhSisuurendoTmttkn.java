package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_BAK_KhSisuurendoTmttkn;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhSisuurendoTmttkn;

public class SortIT_BAK_KhSisuurendoTmttkn {

    public List<IT_BAK_KhSisuurendoTmttkn> OrderIT_BAK_KhSisuurendoTmttknByPkAsc(List<IT_BAK_KhSisuurendoTmttkn> pEntity) {
        List<SortCondition<IT_BAK_KhSisuurendoTmttkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).tmttkntaisyouym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).renno, SortOrder.ASC));
        List<IT_BAK_KhSisuurendoTmttkn> copyList = new ArrayList<IT_BAK_KhSisuurendoTmttkn>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhSisuurendoTmttkn(orders));
        return copyList;
    }

    public List<IT_BAK_KhSisuurendoTmttkn> OrderIT_BAK_KhSisuurendoTmttknByPkDesc(List<IT_BAK_KhSisuurendoTmttkn> pEntity) {
        List<SortCondition<IT_BAK_KhSisuurendoTmttkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).tmttkntaisyouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSisuurendoTmttkn()).renno, SortOrder.DESC));
        List<IT_BAK_KhSisuurendoTmttkn> copyList = new ArrayList<IT_BAK_KhSisuurendoTmttkn>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhSisuurendoTmttkn(orders));
        return copyList;
    }
}
