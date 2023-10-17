package yuyu.app.hozen.khansyuu.khharaikatahenkou.dba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_CreditCardKaisya;
import yuyu.def.db.entity.BM_CreditCardKaisya;
import yuyu.def.db.meta.QBM_CreditCardKaisya;

/**
 * 契約保全 契約保全 払方変更機能ソートクラス
 */
public class SortKhHaraikataHenkou {

    public List<BM_CreditCardKaisya> OrderBM_CreditCardKaisya1(List<BM_CreditCardKaisya> pCreditCardKaisyaList) {
        List<SortCondition<BM_CreditCardKaisya>> orders = new ArrayList<>();

        orders.add(new SortCondition<>((new QBM_CreditCardKaisya()).hyoujijyun, SortOrder.ASC));

        List<BM_CreditCardKaisya> copyList = new ArrayList<BM_CreditCardKaisya>(pCreditCardKaisyaList);

        Collections.sort(copyList, new OrderBM_CreditCardKaisya(orders));

        return copyList;
    }
}
