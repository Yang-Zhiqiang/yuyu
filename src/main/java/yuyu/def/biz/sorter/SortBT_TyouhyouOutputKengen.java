package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_TyouhyouOutputKengen;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.def.db.meta.QBT_TyouhyouOutputKengen;

public class SortBT_TyouhyouOutputKengen {

    public List<BT_TyouhyouOutputKengen> OrderBT_TyouhyouOutputKengenByPkAsc(List<BT_TyouhyouOutputKengen> pEntity) {
        List<SortCondition<BT_TyouhyouOutputKengen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TyouhyouOutputKengen()).roleCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_TyouhyouOutputKengen()).syoruiCd, SortOrder.ASC));
        List<BT_TyouhyouOutputKengen> copyList = new ArrayList<BT_TyouhyouOutputKengen>(pEntity);
        Collections.sort(copyList, new OrderBT_TyouhyouOutputKengen(orders));
        return copyList;
    }

    public List<BT_TyouhyouOutputKengen> OrderBT_TyouhyouOutputKengenByPkDesc(List<BT_TyouhyouOutputKengen> pEntity) {
        List<SortCondition<BT_TyouhyouOutputKengen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_TyouhyouOutputKengen()).roleCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_TyouhyouOutputKengen()).syoruiCd, SortOrder.DESC));
        List<BT_TyouhyouOutputKengen> copyList = new ArrayList<BT_TyouhyouOutputKengen>(pEntity);
        Collections.sort(copyList, new OrderBT_TyouhyouOutputKengen(orders));
        return copyList;
    }

}

