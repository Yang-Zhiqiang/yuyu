package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DairitenItakuSyouhnRn;

/**
 * 代理店委託商品情報用連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DairitenItakuSyouhnRn extends AbstractExDBTable<ZT_DairitenItakuSyouhnRn> {

    public GenQZT_DairitenItakuSyouhnRn() {
        this("ZT_DairitenItakuSyouhnRn");
    }

    public GenQZT_DairitenItakuSyouhnRn(String pAlias) {
        super("ZT_DairitenItakuSyouhnRn", ZT_DairitenItakuSyouhnRn.class, pAlias);
    }

    public String ZT_DairitenItakuSyouhnRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DairitenItakuSyouhnRn, String> zrndairitencd = new ExDBFieldString<>("zrndairitencd", this);

    public final ExDBFieldString<ZT_DairitenItakuSyouhnRn, String> zrndrtsyouhinsikibetukbnstr = new ExDBFieldString<>("zrndrtsyouhinsikibetukbnstr", this);

    public final ExDBFieldString<ZT_DairitenItakuSyouhnRn, String> zrndrthrkhouhoukbn = new ExDBFieldString<>("zrndrthrkhouhoukbn", this);

    public final ExDBFieldString<ZT_DairitenItakuSyouhnRn, String> zrndrtplannmkbn = new ExDBFieldString<>("zrndrtplannmkbn", this);

    public final ExDBFieldString<ZT_DairitenItakuSyouhnRn, String> zrnitakuhknhnbkaisiymd = new ExDBFieldString<>("zrnitakuhknhnbkaisiymd", this);

    public final ExDBFieldString<ZT_DairitenItakuSyouhnRn, String> zrnitakuhknhnbsyuuryouymd = new ExDBFieldString<>("zrnitakuhknhnbsyuuryouymd", this);

    public final ExDBFieldString<ZT_DairitenItakuSyouhnRn, String> zrnyobiv22 = new ExDBFieldString<>("zrnyobiv22", this);
}
