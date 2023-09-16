package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoubyouCdTyuubunruiKbn;
import yuyu.def.db.entity.BM_Syoubyou;
import yuyu.def.db.type.UserType_C_SyoubyouCdTyuubunruiKbn;

/**
 * 傷病マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Syoubyou extends AbstractExDBTable<BM_Syoubyou> {

    public GenQBM_Syoubyou() {
        this("BM_Syoubyou");
    }

    public GenQBM_Syoubyou(String pAlias) {
        super("BM_Syoubyou", BM_Syoubyou.class, pAlias);
    }

    public String BM_Syoubyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Syoubyou, String> syoubyoucd = new ExDBFieldString<>("syoubyoucd", this);

    public final ExDBFieldString<BM_Syoubyou, String> syoubyounm = new ExDBFieldString<>("syoubyounm", this);

    public final ExDBFieldString<BM_Syoubyou, C_SyoubyouCdTyuubunruiKbn> syoubyoucdtyuubunruikbn = new ExDBFieldString<>("syoubyoucdtyuubunruikbn", this, UserType_C_SyoubyouCdTyuubunruiKbn.class);

    public final ExDBFieldString<BM_Syoubyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_Syoubyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
