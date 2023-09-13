package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.hozen.comparator.OrderIT_KhSisuurendoTmttkn;

public class SortIT_KhSisuurendoTmttkn {

    public List<IT_KhSisuurendoTmttkn> OrderIT_KhSisuurendoTmttknByPkAsc(List<IT_KhSisuurendoTmttkn> pEntity) {
        List<SortCondition<IT_KhSisuurendoTmttkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhSisuurendoTmttkn()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhSisuurendoTmttkn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhSisuurendoTmttkn()).tmttkntaisyouym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhSisuurendoTmttkn()).renno, SortOrder.ASC));
        List<IT_KhSisuurendoTmttkn> copyList = new ArrayList<IT_KhSisuurendoTmttkn>(pEntity);
        Collections.sort(copyList, new OrderIT_KhSisuurendoTmttkn(orders));
        return copyList;
    }

    public List<IT_KhSisuurendoTmttkn> OrderIT_KhSisuurendoTmttknByPkDesc(List<IT_KhSisuurendoTmttkn> pEntity) {
        List<SortCondition<IT_KhSisuurendoTmttkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhSisuurendoTmttkn()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhSisuurendoTmttkn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhSisuurendoTmttkn()).tmttkntaisyouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhSisuurendoTmttkn()).renno, SortOrder.DESC));
        List<IT_KhSisuurendoTmttkn> copyList = new ArrayList<IT_KhSisuurendoTmttkn>(pEntity);
        Collections.sort(copyList, new OrderIT_KhSisuurendoTmttkn(orders));
        return copyList;
    }
}
