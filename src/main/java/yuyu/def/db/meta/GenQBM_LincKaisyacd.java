package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_LincKaisyacd;

/**
 * ＬＩＮＣ会社コードマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_LincKaisyacd extends AbstractExDBTable<BM_LincKaisyacd> {

    public GenQBM_LincKaisyacd() {
        this("BM_LincKaisyacd");
    }

    public GenQBM_LincKaisyacd(String pAlias) {
        super("BM_LincKaisyacd", BM_LincKaisyacd.class, pAlias);
    }

    public String BM_LincKaisyacd() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_LincKaisyacd, String> linckaisyacdnum = new ExDBFieldString<>("linckaisyacdnum", this);

    public final ExDBFieldString<BM_LincKaisyacd, String> linckaisyanm = new ExDBFieldString<>("linckaisyanm", this);
}
