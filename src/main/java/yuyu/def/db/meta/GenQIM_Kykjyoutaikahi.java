package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_Kykjyoutaikahi;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 契約状態処理可否マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_Kykjyoutaikahi extends AbstractExDBTable<IM_Kykjyoutaikahi> {

    public GenQIM_Kykjyoutaikahi() {
        this("IM_Kykjyoutaikahi");
    }

    public GenQIM_Kykjyoutaikahi(String pAlias) {
        super("IM_Kykjyoutaikahi", IM_Kykjyoutaikahi.class, pAlias);
    }

    public String IM_Kykjyoutaikahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_Kykjyoutaikahi, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IM_Kykjyoutaikahi, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldString<IM_Kykjyoutaikahi, C_YuukoujyotaikahiKbn> yuukoujyotaikahikbn = new ExDBFieldString<>("yuukoujyotaikahikbn", this, UserType_C_YuukoujyotaikahiKbn.class);

    public final ExDBFieldString<IM_Kykjyoutaikahi, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_Kykjyoutaikahi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_Kykjyoutaikahi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
