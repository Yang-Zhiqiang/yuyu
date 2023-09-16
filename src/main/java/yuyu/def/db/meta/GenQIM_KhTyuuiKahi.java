package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.db.entity.IM_KhTyuuiKahi;
import yuyu.def.db.type.UserType_C_SyorikahiKbn;

/**
 * 契約保全注意取扱処理可否マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_KhTyuuiKahi extends AbstractExDBTable<IM_KhTyuuiKahi> {

    public GenQIM_KhTyuuiKahi() {
        this("IM_KhTyuuiKahi");
    }

    public GenQIM_KhTyuuiKahi(String pAlias) {
        super("IM_KhTyuuiKahi", IM_KhTyuuiKahi.class, pAlias);
    }

    public String IM_KhTyuuiKahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_KhTyuuiKahi, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IM_KhTyuuiKahi, C_SyorikahiKbn> syorikahikbn = new ExDBFieldString<>("syorikahikbn", this, UserType_C_SyorikahiKbn.class);

    public final ExDBFieldString<IM_KhTyuuiKahi, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_KhTyuuiKahi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_KhTyuuiKahi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
