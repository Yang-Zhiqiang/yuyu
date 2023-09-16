package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 処理状態処理可否マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_Syorijtkahi extends AbstractExDBTable<IM_Syorijtkahi> {

    public GenQIM_Syorijtkahi() {
        this("IM_Syorijtkahi");
    }

    public GenQIM_Syorijtkahi(String pAlias) {
        super("IM_Syorijtkahi", IM_Syorijtkahi.class, pAlias);
    }

    public String IM_Syorijtkahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_Syorijtkahi, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IM_Syorijtkahi, String> syorijimuttdkcd = new ExDBFieldString<>("syorijimuttdkcd", this);

    public final ExDBFieldString<IM_Syorijtkahi, String> syoritaskid = new ExDBFieldString<>("syoritaskid", this);

    public final ExDBFieldString<IM_Syorijtkahi, C_YuukoujyotaikahiKbn> yuukoujyotaikahikbn = new ExDBFieldString<>("yuukoujyotaikahikbn", this, UserType_C_YuukoujyotaikahiKbn.class);

    public final ExDBFieldString<IM_Syorijtkahi, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_Syorijtkahi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_Syorijtkahi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
