package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_FileKengen;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_FileKengen;
import yuyu.def.db.meta.QAT_FileKengen;

public class SortAT_FileKengen {

    public List<AT_FileKengen> OrderAT_FileKengenByPkAsc(List<AT_FileKengen> pEntity) {
        List<SortCondition<AT_FileKengen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileKengen()).roleCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_FileKengen()).fileSyuruiCd, SortOrder.ASC));
        List<AT_FileKengen> copyList = new ArrayList<AT_FileKengen>(pEntity);
        Collections.sort(copyList, new OrderAT_FileKengen(orders));
        return copyList;
    }

    public List<AT_FileKengen> OrderAT_FileKengenByPkDesc(List<AT_FileKengen> pEntity) {
        List<SortCondition<AT_FileKengen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileKengen()).roleCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_FileKengen()).fileSyuruiCd, SortOrder.DESC));
        List<AT_FileKengen> copyList = new ArrayList<AT_FileKengen>(pEntity);
        Collections.sort(copyList, new OrderAT_FileKengen(orders));
        return copyList;
    }
}
