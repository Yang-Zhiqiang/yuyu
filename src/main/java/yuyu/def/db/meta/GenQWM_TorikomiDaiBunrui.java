package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WM_TorikomiDaiBunrui;

/**
 * 取込書類大分類マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWM_TorikomiDaiBunrui extends AbstractExDBTable<WM_TorikomiDaiBunrui> {

    public GenQWM_TorikomiDaiBunrui() {
        this("WM_TorikomiDaiBunrui");
    }

    public GenQWM_TorikomiDaiBunrui(String pAlias) {
        super("WM_TorikomiDaiBunrui", WM_TorikomiDaiBunrui.class, pAlias);
    }

    public String WM_TorikomiDaiBunrui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WM_TorikomiDaiBunrui, String> syzkDaiBunruiId = new ExDBFieldString<>("syzkDaiBunruiId", this);

    public final ExDBFieldString<WM_TorikomiDaiBunrui, String> syzkDaiBunruiNm = new ExDBFieldString<>("syzkDaiBunruiNm", this);
}
