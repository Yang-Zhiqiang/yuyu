package yuyu.app.base.system.kinouteigitouroku;

import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.db.entity.AS_Kinou;

import com.google.common.base.Predicate;

/**
 * 条件に合致する機能基幹テーブルエンティティを抽出するためのPredicate クラスです。<br />
 * 機能基幹テーブル．機能定義対象区分が対象以外の場合は除外します。<br />
 *
 */
public class KinouEntityPredicate implements Predicate<AS_Kinou> {

    public KinouEntityPredicate() {
    }

    @Override
    public boolean apply(AS_Kinou kinou) {
        if (C_TaisyouKbn.HITAISYOU.eq(kinou.getKinouTeigiTaisyouKbn())) {
            return false;
        }
        return true;
    }

}