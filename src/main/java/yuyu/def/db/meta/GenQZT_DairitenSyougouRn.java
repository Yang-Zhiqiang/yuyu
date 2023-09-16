package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DairitenSyougouRn;

/**
 * 代理店法人商号連動ＵＬＦテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DairitenSyougouRn extends AbstractExDBTable<ZT_DairitenSyougouRn> {

    public GenQZT_DairitenSyougouRn() {
        this("ZT_DairitenSyougouRn");
    }

    public GenQZT_DairitenSyougouRn(String pAlias) {
        super("ZT_DairitenSyougouRn", ZT_DairitenSyougouRn.class, pAlias);
    }

    public String ZT_DairitenSyougouRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DairitenSyougouRn, String> zrndairitencd = new ExDBFieldString<>("zrndairitencd", this);

    public final ExDBFieldString<ZT_DairitenSyougouRn, String> zrnkanjihoujinsyougou = new ExDBFieldString<>("zrnkanjihoujinsyougou", this);

    public final ExDBFieldString<ZT_DairitenSyougouRn, String> zrnyobiv13 = new ExDBFieldString<>("zrnyobiv13", this);
}
