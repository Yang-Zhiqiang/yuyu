package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_FileSansyoKaisu;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_FileSansyoKaisu;
import yuyu.def.db.meta.QAT_FileSansyoKaisu;

public class SortAT_FileSansyoKaisu {

    public List<AT_FileSansyoKaisu> OrderAT_FileSansyoKaisuByPkAsc(List<AT_FileSansyoKaisu> pEntity) {
        List<SortCondition<AT_FileSansyoKaisu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileSansyoKaisu()).uniqueId, SortOrder.ASC));
        List<AT_FileSansyoKaisu> copyList = new ArrayList<AT_FileSansyoKaisu>(pEntity);
        Collections.sort(copyList, new OrderAT_FileSansyoKaisu(orders));
        return copyList;
    }

    public List<AT_FileSansyoKaisu> OrderAT_FileSansyoKaisuByPkDesc(List<AT_FileSansyoKaisu> pEntity) {
        List<SortCondition<AT_FileSansyoKaisu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_FileSansyoKaisu()).uniqueId, SortOrder.DESC));
        List<AT_FileSansyoKaisu> copyList = new ArrayList<AT_FileSansyoKaisu>(pEntity);
        Collections.sort(copyList, new OrderAT_FileSansyoKaisu(orders));
        return copyList;
    }
}
