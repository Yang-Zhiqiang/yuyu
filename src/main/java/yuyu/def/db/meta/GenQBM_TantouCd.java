package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.type.UserType_C_TantouCdKbn;

/**
 * 担当コードマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_TantouCd extends AbstractExDBTable<BM_TantouCd> {

    public GenQBM_TantouCd() {
        this("BM_TantouCd");
    }

    public GenQBM_TantouCd(String pAlias) {
        super("BM_TantouCd", BM_TantouCd.class, pAlias);
    }

    public String BM_TantouCd() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_TantouCd, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<BM_TantouCd, String> busitucd = new ExDBFieldString<>("busitucd", this);

    public final ExDBFieldString<BM_TantouCd, String> tantounm = new ExDBFieldString<>("tantounm", this);

    public final ExDBFieldString<BM_TantouCd, String> busitunm = new ExDBFieldString<>("busitunm", this);
}
