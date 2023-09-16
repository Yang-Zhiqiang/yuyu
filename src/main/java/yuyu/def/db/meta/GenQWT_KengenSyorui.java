package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_KengenSyorui;

/**
 * 権限明細（書類）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_KengenSyorui extends AbstractExDBTable<WT_KengenSyorui> {

    public GenQWT_KengenSyorui() {
        this("WT_KengenSyorui");
    }

    public GenQWT_KengenSyorui(String pAlias) {
        super("WT_KengenSyorui", WT_KengenSyorui.class, pAlias);
    }

    public String WT_KengenSyorui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_KengenSyorui, String> roleCd = new ExDBFieldString<>("roleCd", this);

    public final ExDBFieldString<WT_KengenSyorui, String> torikomiSyoruiCd = new ExDBFieldString<>("torikomiSyoruiCd", this);
}
