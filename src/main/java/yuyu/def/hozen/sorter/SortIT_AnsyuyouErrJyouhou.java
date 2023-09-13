package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_AnsyuyouErrJyouhou;
import yuyu.def.db.meta.QIT_AnsyuyouErrJyouhou;
import yuyu.def.hozen.comparator.OrderIT_AnsyuyouErrJyouhou;

public class SortIT_AnsyuyouErrJyouhou {

    public List<IT_AnsyuyouErrJyouhou> OrderIT_AnsyuyouErrJyouhouByPkAsc(List<IT_AnsyuyouErrJyouhou> pEntity) {
        List<SortCondition<IT_AnsyuyouErrJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).kakutyoujobcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).gyoumuKousinTime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).ansyuyouerrnaiyou, SortOrder.ASC));
        List<IT_AnsyuyouErrJyouhou> copyList = new ArrayList<IT_AnsyuyouErrJyouhou>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuyouErrJyouhou(orders));
        return copyList;
    }

    public List<IT_AnsyuyouErrJyouhou> OrderIT_AnsyuyouErrJyouhouByPkDesc(List<IT_AnsyuyouErrJyouhou> pEntity) {
        List<SortCondition<IT_AnsyuyouErrJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).kakutyoujobcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).gyoumuKousinTime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuyouErrJyouhou()).ansyuyouerrnaiyou, SortOrder.DESC));
        List<IT_AnsyuyouErrJyouhou> copyList = new ArrayList<IT_AnsyuyouErrJyouhou>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuyouErrJyouhou(orders));
        return copyList;
    }
}
