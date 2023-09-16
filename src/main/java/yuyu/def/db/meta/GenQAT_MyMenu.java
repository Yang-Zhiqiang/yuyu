package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_MyMenu;

/**
 * マイメニューテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_MyMenu extends AbstractExDBTable<AT_MyMenu> {

    public GenQAT_MyMenu() {
        this("AT_MyMenu");
    }

    public GenQAT_MyMenu(String pAlias) {
        super("AT_MyMenu", AT_MyMenu.class, pAlias);
    }

    public String AT_MyMenu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_MyMenu, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<AT_MyMenu, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<AT_MyMenu, String> categoryId = new ExDBFieldString<>("categoryId", this);

    public final ExDBFieldString<AT_MyMenu, String> kinouId = new ExDBFieldString<>("kinouId", this);
}
