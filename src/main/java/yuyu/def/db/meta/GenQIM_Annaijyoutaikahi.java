package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnnaijyoutaiKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_Annaijyoutaikahi;
import yuyu.def.db.type.UserType_C_AnnaijyoutaiKbn;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 案内状態処理可否マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_Annaijyoutaikahi extends AbstractExDBTable<IM_Annaijyoutaikahi> {

    public GenQIM_Annaijyoutaikahi() {
        this("IM_Annaijyoutaikahi");
    }

    public GenQIM_Annaijyoutaikahi(String pAlias) {
        super("IM_Annaijyoutaikahi", IM_Annaijyoutaikahi.class, pAlias);
    }

    public String IM_Annaijyoutaikahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_Annaijyoutaikahi, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IM_Annaijyoutaikahi, C_AnnaijyoutaiKbn> annaijyoutaikbn = new ExDBFieldString<>("annaijyoutaikbn", this, UserType_C_AnnaijyoutaiKbn.class);

    public final ExDBFieldString<IM_Annaijyoutaikahi, C_YuukoujyotaikahiKbn> yuukoujyotaikahikbn = new ExDBFieldString<>("yuukoujyotaikahikbn", this, UserType_C_YuukoujyotaikahiKbn.class);

    public final ExDBFieldString<IM_Annaijyoutaikahi, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_Annaijyoutaikahi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_Annaijyoutaikahi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
