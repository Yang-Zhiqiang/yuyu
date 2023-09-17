package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_TyouhyouSakujyotaisyo;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_TyouhyouSakujyotaisyo;
import yuyu.def.db.meta.QAS_TyouhyouSakujyotaisyo;

public class SortAS_TyouhyouSakujyotaisyo {

    public List<AS_TyouhyouSakujyotaisyo> OrderAS_TyouhyouSakujyotaisyoByPkAsc(List<AS_TyouhyouSakujyotaisyo> pEntity) {
        List<SortCondition<AS_TyouhyouSakujyotaisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_TyouhyouSakujyotaisyo()).syoruiCd, SortOrder.ASC));
        List<AS_TyouhyouSakujyotaisyo> copyList = new ArrayList<AS_TyouhyouSakujyotaisyo>(pEntity);
        Collections.sort(copyList, new OrderAS_TyouhyouSakujyotaisyo(orders));
        return copyList;
    }

    public List<AS_TyouhyouSakujyotaisyo> OrderAS_TyouhyouSakujyotaisyoByPkDesc(List<AS_TyouhyouSakujyotaisyo> pEntity) {
        List<SortCondition<AS_TyouhyouSakujyotaisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_TyouhyouSakujyotaisyo()).syoruiCd, SortOrder.DESC));
        List<AS_TyouhyouSakujyotaisyo> copyList = new ArrayList<AS_TyouhyouSakujyotaisyo>(pEntity);
        Collections.sort(copyList, new OrderAS_TyouhyouSakujyotaisyo(orders));
        return copyList;
    }
}
