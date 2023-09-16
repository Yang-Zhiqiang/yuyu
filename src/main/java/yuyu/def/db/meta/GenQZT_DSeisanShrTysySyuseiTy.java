package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiTy;

/**
 * Ｄ精算支払調書修正テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DSeisanShrTysySyuseiTy extends AbstractExDBTable<ZT_DSeisanShrTysySyuseiTy> {

    public GenQZT_DSeisanShrTysySyuseiTy() {
        this("ZT_DSeisanShrTysySyuseiTy");
    }

    public GenQZT_DSeisanShrTysySyuseiTy(String pAlias) {
        super("ZT_DSeisanShrTysySyuseiTy", ZT_DSeisanShrTysySyuseiTy.class, pAlias);
    }

    public String ZT_DSeisanShrTysySyuseiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DSeisanShrTysySyuseiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_DSeisanShrTysySyuseiTy, String> ztyseisandshrymd = new ExDBFieldString<>("ztyseisandshrymd", this);

    public final ExDBFieldNumber<ZT_DSeisanShrTysySyuseiTy, Long> ztyseisandkgk11 = new ExDBFieldNumber<>("ztyseisandkgk11", this);

    public final ExDBFieldNumber<ZT_DSeisanShrTysySyuseiTy, Long> ztytyouseidkgk11 = new ExDBFieldNumber<>("ztytyouseidkgk11", this);

    public final ExDBFieldString<ZT_DSeisanShrTysySyuseiTy, String> ztyyobiv19 = new ExDBFieldString<>("ztyyobiv19", this);
}
