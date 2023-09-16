package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiRn;

/**
 * Ｄ精算支払調書修正テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DSeisanShrTysySyuseiRn extends AbstractExDBTable<ZT_DSeisanShrTysySyuseiRn> {

    public GenQZT_DSeisanShrTysySyuseiRn() {
        this("ZT_DSeisanShrTysySyuseiRn");
    }

    public GenQZT_DSeisanShrTysySyuseiRn(String pAlias) {
        super("ZT_DSeisanShrTysySyuseiRn", ZT_DSeisanShrTysySyuseiRn.class, pAlias);
    }

    public String ZT_DSeisanShrTysySyuseiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DSeisanShrTysySyuseiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_DSeisanShrTysySyuseiRn, String> zrnseisandshrymd = new ExDBFieldString<>("zrnseisandshrymd", this);

    public final ExDBFieldNumber<ZT_DSeisanShrTysySyuseiRn, Long> zrnseisandkgk11 = new ExDBFieldNumber<>("zrnseisandkgk11", this);

    public final ExDBFieldNumber<ZT_DSeisanShrTysySyuseiRn, Long> zrntyouseidkgk11 = new ExDBFieldNumber<>("zrntyouseidkgk11", this);

    public final ExDBFieldString<ZT_DSeisanShrTysySyuseiRn, String> zrnyobiv19 = new ExDBFieldString<>("zrnyobiv19", this);
}
