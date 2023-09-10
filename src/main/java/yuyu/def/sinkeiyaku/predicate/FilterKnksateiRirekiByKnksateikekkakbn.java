package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_KnksateiRireki;

import com.google.common.base.Predicate;

/**
 * 環境査定履歴テーブル用 Predicate<br />
 * 環境査定履歴テーブルエンティティリスト取得　環境査定結果区分が固定値<br />
 */
public class FilterKnksateiRirekiByKnksateikekkakbn implements Predicate<HT_KnksateiRireki>{

    public FilterKnksateiRirekiByKnksateikekkakbn() {

        super();
    }

    @Override
    public boolean apply(HT_KnksateiRireki pKnksateikekkakbn) {

        if(C_SyorikekkaKbn.KANRYOU.equals(pKnksateikekkakbn.getKnksateikekkakbn())) {

            return true;
        }

        return false;
    }
}
