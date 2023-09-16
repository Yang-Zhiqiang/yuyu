package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_YykIdouUktksyorikahi;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 予約異動受付中処理可否マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_YykIdouUktksyorikahi extends AbstractExDBTable<IM_YykIdouUktksyorikahi> {

    public GenQIM_YykIdouUktksyorikahi() {
        this("IM_YykIdouUktksyorikahi");
    }

    public GenQIM_YykIdouUktksyorikahi(String pAlias) {
        super("IM_YykIdouUktksyorikahi", IM_YykIdouUktksyorikahi.class, pAlias);
    }

    public String IM_YykIdouUktksyorikahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_YykIdouUktksyorikahi, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IM_YykIdouUktksyorikahi, String> yykuktkkinouid = new ExDBFieldString<>("yykuktkkinouid", this);

    public final ExDBFieldString<IM_YykIdouUktksyorikahi, C_YuukoujyotaikahiKbn> yuukoujyotaikahikbn = new ExDBFieldString<>("yuukoujyotaikahikbn", this, UserType_C_YuukoujyotaikahiKbn.class);

    public final ExDBFieldString<IM_YykIdouUktksyorikahi, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_YykIdouUktksyorikahi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_YykIdouUktksyorikahi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
