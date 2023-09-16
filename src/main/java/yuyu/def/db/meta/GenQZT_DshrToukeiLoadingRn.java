package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingRn;

/**
 * Ｄ支払統計ローディングＦテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DshrToukeiLoadingRn extends AbstractExDBTable<ZT_DshrToukeiLoadingRn> {

    public GenQZT_DshrToukeiLoadingRn() {
        this("ZT_DshrToukeiLoadingRn");
    }

    public GenQZT_DshrToukeiLoadingRn(String pAlias) {
        super("ZT_DshrToukeiLoadingRn", ZT_DshrToukeiLoadingRn.class, pAlias);
    }

    public String ZT_DshrToukeiLoadingRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrndshrym = new ExDBFieldString<>("zrndshrym", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnannaikigetu = new ExDBFieldString<>("zrnannaikigetu", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnhknsyruikbn = new ExDBFieldString<>("zrnhknsyruikbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnsegcd = new ExDBFieldString<>("zrnsegcd", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnshrriyuukbn = new ExDBFieldString<>("zrnshrriyuukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnannaikbn = new ExDBFieldString<>("zrnannaikbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnduketorihouhoukbn = new ExDBFieldString<>("zrnduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnsyoumetukbn = new ExDBFieldString<>("zrnsyoumetukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnbikinhyj = new ExDBFieldString<>("zrnbikinhyj", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingRn, String> zrnskskbn = new ExDBFieldString<>("zrnskskbn", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingRn, Integer> zrnsrkensuu = new ExDBFieldNumber<>("zrnsrkensuu", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingRn, Long> zrnsrhsys = new ExDBFieldNumber<>("zrnsrhsys", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingRn, Long> zrntoujigyounendod = new ExDBFieldNumber<>("zrntoujigyounendod", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingRn, Long> zrntoujigyounendohasseidrsk = new ExDBFieldNumber<>("zrntoujigyounendohasseidrsk", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingRn, Long> zrnzenjigyounendomatudzndk = new ExDBFieldNumber<>("zrnzenjigyounendomatudzndk", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingRn, Long> zrnyokujigyounendod = new ExDBFieldNumber<>("zrnyokujigyounendod", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingRn, Long> zrnhushrtoujigyounendod = new ExDBFieldNumber<>("zrnhushrtoujigyounendod", this);
}
