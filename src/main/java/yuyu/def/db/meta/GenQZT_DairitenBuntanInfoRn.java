package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DairitenBuntanInfoRn;

/**
 * 代理店手数料分担情報Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DairitenBuntanInfoRn extends AbstractExDBTable<ZT_DairitenBuntanInfoRn> {

    public GenQZT_DairitenBuntanInfoRn() {
        this("ZT_DairitenBuntanInfoRn");
    }

    public GenQZT_DairitenBuntanInfoRn(String pAlias) {
        super("ZT_DairitenBuntanInfoRn", ZT_DairitenBuntanInfoRn.class, pAlias);
    }

    public String ZT_DairitenBuntanInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DairitenBuntanInfoRn, String> zrndairitencd = new ExDBFieldString<>("zrndairitencd", this);

    public final ExDBFieldString<ZT_DairitenBuntanInfoRn, String> zrndairitensyouhincd = new ExDBFieldString<>("zrndairitensyouhincd", this);

    public final ExDBFieldString<ZT_DairitenBuntanInfoRn, String> zrntesuuryoubuntandrtencd = new ExDBFieldString<>("zrntesuuryoubuntandrtencd", this);

    public final ExDBFieldString<ZT_DairitenBuntanInfoRn, String> zrntesuuryoubuntanstartym = new ExDBFieldString<>("zrntesuuryoubuntanstartym", this);

    public final ExDBFieldString<ZT_DairitenBuntanInfoRn, String> zrntesuuryoubuntanendym = new ExDBFieldString<>("zrntesuuryoubuntanendym", this);

    public final ExDBFieldNumber<ZT_DairitenBuntanInfoRn, Long> zrntesuuryoubuntanwariai = new ExDBFieldNumber<>("zrntesuuryoubuntanwariai", this);

    public final ExDBFieldString<ZT_DairitenBuntanInfoRn, String> zrnyobiv67 = new ExDBFieldString<>("zrnyobiv67", this);
}
