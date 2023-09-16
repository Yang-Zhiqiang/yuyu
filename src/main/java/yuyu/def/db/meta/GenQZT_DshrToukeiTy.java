package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_DshrToukeiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * Ｄ支払統計Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DshrToukeiTy extends AbstractExDBTable<ZT_DshrToukeiTy> {

    public GenQZT_DshrToukeiTy() {
        this("ZT_DshrToukeiTy");
    }

    public GenQZT_DshrToukeiTy(String pAlias) {
        super("ZT_DshrToukeiTy", ZT_DshrToukeiTy.class, pAlias);
    }

    public String ZT_DshrToukeiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_DshrToukeiTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_DshrToukeiTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztymisskbn = new ExDBFieldString<>("ztymisskbn", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztydshrym = new ExDBFieldString<>("ztydshrym", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztysrsyoumetucd = new ExDBFieldString<>("ztysrsyoumetucd", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztyannaikigetu = new ExDBFieldString<>("ztyannaikigetu", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztyshrriyuukbn = new ExDBFieldString<>("ztyshrriyuukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztyannaikbn = new ExDBFieldString<>("ztyannaikbn", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztyduketorihouhoukbn = new ExDBFieldString<>("ztyduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztybikinhyj = new ExDBFieldString<>("ztybikinhyj", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztyskskbn = new ExDBFieldString<>("ztyskskbn", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztysegcd = new ExDBFieldString<>("ztysegcd", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldNumber<ZT_DshrToukeiTy, Integer> ztysrkensuu = new ExDBFieldNumber<>("ztysrkensuu", this);

    public final ExDBFieldNumber<ZT_DshrToukeiTy, Long> ztysrhsys = new ExDBFieldNumber<>("ztysrhsys", this);

    public final ExDBFieldNumber<ZT_DshrToukeiTy, Long> ztytoujigyounendod = new ExDBFieldNumber<>("ztytoujigyounendod", this);

    public final ExDBFieldNumber<ZT_DshrToukeiTy, Long> ztytoujigyounendohasseidrsk = new ExDBFieldNumber<>("ztytoujigyounendohasseidrsk", this);

    public final ExDBFieldNumber<ZT_DshrToukeiTy, Long> ztyzenjigyounendomatudzndk = new ExDBFieldNumber<>("ztyzenjigyounendomatudzndk", this);

    public final ExDBFieldNumber<ZT_DshrToukeiTy, Long> ztyyokujigyounendod = new ExDBFieldNumber<>("ztyyokujigyounendod", this);

    public final ExDBFieldNumber<ZT_DshrToukeiTy, Long> ztyhushrtoujigyounendod = new ExDBFieldNumber<>("ztyhushrtoujigyounendod", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_DshrToukeiTy, BizNumber> ztydaihyouyoteiriritu = new ExDBFieldString<>("ztydaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DshrToukeiTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);
}
