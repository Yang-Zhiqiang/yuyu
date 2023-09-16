package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_YoteiRirituRendouSeigyo;

/**
 * 予定利率連動制御マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_YoteiRirituRendouSeigyo extends AbstractExDBTable<BM_YoteiRirituRendouSeigyo> {

    public GenQBM_YoteiRirituRendouSeigyo() {
        this("BM_YoteiRirituRendouSeigyo");
    }

    public GenQBM_YoteiRirituRendouSeigyo(String pAlias) {
        super("BM_YoteiRirituRendouSeigyo", BM_YoteiRirituRendouSeigyo.class, pAlias);
    }

    public String BM_YoteiRirituRendouSeigyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_YoteiRirituRendouSeigyo, String> yoteirirituhanteidfrom = new ExDBFieldString<>("yoteirirituhanteidfrom", this);

    public final ExDBFieldString<BM_YoteiRirituRendouSeigyo, String> yoteirirituhanteidto = new ExDBFieldString<>("yoteirirituhanteidto", this);

    public final ExDBFieldString<BM_YoteiRirituRendouSeigyo, String> syouhncd = new ExDBFieldString<>("syouhncd", this);
}
