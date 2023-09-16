package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_DshrToukeiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * Ｄ支払統計Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DshrToukeiRn extends AbstractExDBTable<ZT_DshrToukeiRn> {

    public GenQZT_DshrToukeiRn() {
        this("ZT_DshrToukeiRn");
    }

    public GenQZT_DshrToukeiRn(String pAlias) {
        super("ZT_DshrToukeiRn", ZT_DshrToukeiRn.class, pAlias);
    }

    public String ZT_DshrToukeiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_DshrToukeiRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_DshrToukeiRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnmisskbn = new ExDBFieldString<>("zrnmisskbn", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrndshrym = new ExDBFieldString<>("zrndshrym", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnsrsyoumetucd = new ExDBFieldString<>("zrnsrsyoumetucd", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnannaikigetu = new ExDBFieldString<>("zrnannaikigetu", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnshrriyuukbn = new ExDBFieldString<>("zrnshrriyuukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnannaikbn = new ExDBFieldString<>("zrnannaikbn", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnduketorihouhoukbn = new ExDBFieldString<>("zrnduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnbikinhyj = new ExDBFieldString<>("zrnbikinhyj", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnskskbn = new ExDBFieldString<>("zrnskskbn", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnsegcd = new ExDBFieldString<>("zrnsegcd", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldNumber<ZT_DshrToukeiRn, Integer> zrnsrkensuu = new ExDBFieldNumber<>("zrnsrkensuu", this);

    public final ExDBFieldNumber<ZT_DshrToukeiRn, Long> zrnsrhsys = new ExDBFieldNumber<>("zrnsrhsys", this);

    public final ExDBFieldNumber<ZT_DshrToukeiRn, Long> zrntoujigyounendod = new ExDBFieldNumber<>("zrntoujigyounendod", this);

    public final ExDBFieldNumber<ZT_DshrToukeiRn, Long> zrntoujigyounendohasseidrsk = new ExDBFieldNumber<>("zrntoujigyounendohasseidrsk", this);

    public final ExDBFieldNumber<ZT_DshrToukeiRn, Long> zrnzenjigyounendomatudzndk = new ExDBFieldNumber<>("zrnzenjigyounendomatudzndk", this);

    public final ExDBFieldNumber<ZT_DshrToukeiRn, Long> zrnyokujigyounendod = new ExDBFieldNumber<>("zrnyokujigyounendod", this);

    public final ExDBFieldNumber<ZT_DshrToukeiRn, Long> zrnhushrtoujigyounendod = new ExDBFieldNumber<>("zrnhushrtoujigyounendod", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_DshrToukeiRn, BizNumber> zrndaihyouyoteiriritu = new ExDBFieldString<>("zrndaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DshrToukeiRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);
}
