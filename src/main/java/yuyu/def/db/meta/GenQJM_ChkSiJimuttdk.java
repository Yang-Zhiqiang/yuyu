package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JM_ChkSiJimuttdk;
import yuyu.def.db.type.UserType_C_SKNaiyouChkKbn;

/**
 * 支払事務手続チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_ChkSiJimuttdk extends AbstractExDBTable<JM_ChkSiJimuttdk> {

    public GenQJM_ChkSiJimuttdk() {
        this("JM_ChkSiJimuttdk");
    }

    public GenQJM_ChkSiJimuttdk(String pAlias) {
        super("JM_ChkSiJimuttdk", JM_ChkSiJimuttdk.class, pAlias);
    }

    public String JM_ChkSiJimuttdk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_ChkSiJimuttdk, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<JM_ChkSiJimuttdk, String> syorijimuttdkcd = new ExDBFieldString<>("syorijimuttdkcd", this);

    public final ExDBFieldString<JM_ChkSiJimuttdk, C_SKNaiyouChkKbn> sknaiyouchkkbn = new ExDBFieldString<>("sknaiyouchkkbn", this, UserType_C_SKNaiyouChkKbn.class);
}
