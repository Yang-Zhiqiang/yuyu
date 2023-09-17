package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_FileSyurui;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.meta.QAS_FileSyurui;

public class SortAS_FileSyurui {

    public List<AS_FileSyurui> OrderAS_FileSyuruiByPkAsc(List<AS_FileSyurui> pEntity) {
        List<SortCondition<AS_FileSyurui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_FileSyurui()).fileSyuruiCd, SortOrder.ASC));
        List<AS_FileSyurui> copyList = new ArrayList<AS_FileSyurui>(pEntity);
        Collections.sort(copyList, new OrderAS_FileSyurui(orders));
        return copyList;
    }

    public List<AS_FileSyurui> OrderAS_FileSyuruiByPkDesc(List<AS_FileSyurui> pEntity) {
        List<SortCondition<AS_FileSyurui>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_FileSyurui()).fileSyuruiCd, SortOrder.DESC));
        List<AS_FileSyurui> copyList = new ArrayList<AS_FileSyurui>(pEntity);
        Collections.sort(copyList, new OrderAS_FileSyurui(orders));
        return copyList;
    }
}
