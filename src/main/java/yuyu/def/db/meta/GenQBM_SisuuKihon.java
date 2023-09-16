package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.type.UserType_C_Sisuukbn;

/**
 * 指数基本マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SisuuKihon extends AbstractExDBTable<BM_SisuuKihon> {

    public GenQBM_SisuuKihon() {
        this("BM_SisuuKihon");
    }

    public GenQBM_SisuuKihon(String pAlias) {
        super("BM_SisuuKihon", BM_SisuuKihon.class, pAlias);
    }

    public String BM_SisuuKihon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SisuuKihon, C_Sisuukbn> sisuukbn = new ExDBFieldString<>("sisuukbn", this, UserType_C_Sisuukbn.class);

    public final ExDBFieldString<BM_SisuuKihon, String> sisuunm = new ExDBFieldString<>("sisuunm", this);
}
