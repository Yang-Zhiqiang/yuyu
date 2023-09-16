package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_KhHenkouUktksyorikahi;
import yuyu.def.db.type.UserType_C_UktkSyoriKbn;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 契約保全変更受付中処理可否マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_KhHenkouUktksyorikahi extends AbstractExDBTable<IM_KhHenkouUktksyorikahi> {

    public GenQIM_KhHenkouUktksyorikahi() {
        this("IM_KhHenkouUktksyorikahi");
    }

    public GenQIM_KhHenkouUktksyorikahi(String pAlias) {
        super("IM_KhHenkouUktksyorikahi", IM_KhHenkouUktksyorikahi.class, pAlias);
    }

    public String IM_KhHenkouUktksyorikahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_KhHenkouUktksyorikahi, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IM_KhHenkouUktksyorikahi, C_UktkSyoriKbn> uktksyorikbn = new ExDBFieldString<>("uktksyorikbn", this, UserType_C_UktkSyoriKbn.class);

    public final ExDBFieldString<IM_KhHenkouUktksyorikahi, C_YuukoujyotaikahiKbn> yuukoujyotaikahikbn = new ExDBFieldString<>("yuukoujyotaikahikbn", this, UserType_C_YuukoujyotaikahiKbn.class);

    public final ExDBFieldString<IM_KhHenkouUktksyorikahi, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_KhHenkouUktksyorikahi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_KhHenkouUktksyorikahi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
