package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IM_KhHituyouSyorui;

/**
 * 契約保全必要書類マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_KhHituyouSyorui extends AbstractExDBTable<IM_KhHituyouSyorui> {

    public GenQIM_KhHituyouSyorui() {
        this("IM_KhHituyouSyorui");
    }

    public GenQIM_KhHituyouSyorui(String pAlias) {
        super("IM_KhHituyouSyorui", IM_KhHituyouSyorui.class, pAlias);
    }

    public String IM_KhHituyouSyorui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_KhHituyouSyorui, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldNumber<IM_KhHituyouSyorui, Integer> hanteikbn1 = new ExDBFieldNumber<>("hanteikbn1", this);

    public final ExDBFieldNumber<IM_KhHituyouSyorui, Integer> hanteikbn2 = new ExDBFieldNumber<>("hanteikbn2", this);

    public final ExDBFieldNumber<IM_KhHituyouSyorui, Integer> hanteikbn3 = new ExDBFieldNumber<>("hanteikbn3", this);

    public final ExDBFieldNumber<IM_KhHituyouSyorui, Integer> htysrirenno = new ExDBFieldNumber<>("htysrirenno", this);

    public final ExDBFieldString<IM_KhHituyouSyorui, String> htysyorui = new ExDBFieldString<>("htysyorui", this);

    public final ExDBFieldString<IM_KhHituyouSyorui, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_KhHituyouSyorui, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_KhHituyouSyorui, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
