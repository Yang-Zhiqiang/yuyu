package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_DairitenItakuSyouhn;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 代理店委託商品情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_DairitenItakuSyouhn extends AbstractExDBTable<BT_DairitenItakuSyouhn> {

    public GenQBT_DairitenItakuSyouhn() {
        this("BT_DairitenItakuSyouhn");
    }

    public GenQBT_DairitenItakuSyouhn(String pAlias) {
        super("BT_DairitenItakuSyouhn", BT_DairitenItakuSyouhn.class, pAlias);
    }

    public String BT_DairitenItakuSyouhn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_DairitenItakuSyouhn, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<BT_DairitenItakuSyouhn, String> drtsyouhinsikibetukbnstr = new ExDBFieldString<>("drtsyouhinsikibetukbnstr", this);

    public final ExDBFieldString<BT_DairitenItakuSyouhn, String> drthrkhouhoukbn = new ExDBFieldString<>("drthrkhouhoukbn", this);

    public final ExDBFieldString<BT_DairitenItakuSyouhn, String> drtplannmkbn = new ExDBFieldString<>("drtplannmkbn", this);

    public final ExDBFieldString<BT_DairitenItakuSyouhn, BizDate> itakuhknhnbkaisiymd = new ExDBFieldString<>("itakuhknhnbkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_DairitenItakuSyouhn, BizDate> itakuhknhnbsyuuryouymd = new ExDBFieldString<>("itakuhknhnbsyuuryouymd", this, BizDateType.class);
}
