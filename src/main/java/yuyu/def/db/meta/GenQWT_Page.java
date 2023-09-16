package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_Page;

/**
 * ページテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_Page extends AbstractExDBTable<WT_Page> {

    public GenQWT_Page() {
        this("WT_Page");
    }

    public GenQWT_Page(String pAlias) {
        super("WT_Page", WT_Page.class, pAlias);
    }

    public String WT_Page() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_Page, String> iwfImageId = new ExDBFieldString<>("iwfImageId", this);

    public final ExDBFieldString<WT_Page, String> syoruittykymdtime = new ExDBFieldString<>("syoruittykymdtime", this);

    public final ExDBFieldNumber<WT_Page, Integer> pageno = new ExDBFieldNumber<>("pageno", this);

    public final ExDBFieldString<WT_Page, String> pageId = new ExDBFieldString<>("pageId", this);

    public final ExDBFieldString<WT_Page, String> torikomiSousasyaId = new ExDBFieldString<>("torikomiSousasyaId", this);
}
