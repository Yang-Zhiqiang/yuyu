package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WM_TorikomiSyouBunrui;

/**
 * 取込書類小分類マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWM_TorikomiSyouBunrui extends AbstractExDBTable<WM_TorikomiSyouBunrui> {

    public GenQWM_TorikomiSyouBunrui() {
        this("WM_TorikomiSyouBunrui");
    }

    public GenQWM_TorikomiSyouBunrui(String pAlias) {
        super("WM_TorikomiSyouBunrui", WM_TorikomiSyouBunrui.class, pAlias);
    }

    public String WM_TorikomiSyouBunrui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WM_TorikomiSyouBunrui, String> syzkSyouBunruiId = new ExDBFieldString<>("syzkSyouBunruiId", this);

    public final ExDBFieldString<WM_TorikomiSyouBunrui, String> syzkSyouBunruiNm = new ExDBFieldString<>("syzkSyouBunruiNm", this);

    public final ExDBFieldString<WM_TorikomiSyouBunrui, String> syzkDaiBunruiId = new ExDBFieldString<>("syzkDaiBunruiId", this);
}
