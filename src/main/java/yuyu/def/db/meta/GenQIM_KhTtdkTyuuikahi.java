package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.IM_KhTtdkTyuuikahi;
import yuyu.def.db.type.UserType_C_SyorikahiKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;

/**
 * 契約保全手続注意処理可否マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_KhTtdkTyuuikahi extends AbstractExDBTable<IM_KhTtdkTyuuikahi> {

    public GenQIM_KhTtdkTyuuikahi() {
        this("IM_KhTtdkTyuuikahi");
    }

    public GenQIM_KhTtdkTyuuikahi(String pAlias) {
        super("IM_KhTtdkTyuuikahi", IM_KhTtdkTyuuikahi.class, pAlias);
    }

    public String IM_KhTtdkTyuuikahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_KhTtdkTyuuikahi, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IM_KhTtdkTyuuikahi, C_TtdktyuuiKbn> ttdktyuuikbn = new ExDBFieldString<>("ttdktyuuikbn", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<IM_KhTtdkTyuuikahi, C_SyorikahiKbn> syorikahikbn = new ExDBFieldString<>("syorikahikbn", this, UserType_C_SyorikahiKbn.class);

    public final ExDBFieldString<IM_KhTtdkTyuuikahi, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_KhTtdkTyuuikahi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_KhTtdkTyuuikahi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
