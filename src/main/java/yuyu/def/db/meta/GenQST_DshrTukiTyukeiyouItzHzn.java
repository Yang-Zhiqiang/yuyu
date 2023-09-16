package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * Ｄ支払統計中継用一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_DshrTukiTyukeiyouItzHzn extends AbstractExDBTable<ST_DshrTukiTyukeiyouItzHzn> {

    public GenQST_DshrTukiTyukeiyouItzHzn() {
        this("ST_DshrTukiTyukeiyouItzHzn");
    }

    public GenQST_DshrTukiTyukeiyouItzHzn(String pAlias) {
        super("ST_DshrTukiTyukeiyouItzHzn", ST_DshrTukiTyukeiyouItzHzn.class, pAlias);
    }

    public String ST_DshrTukiTyukeiyouItzHzn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ST_DshrTukiTyukeiyouItzHzn, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ST_DshrTukiTyukeiyouItzHzn, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztymisskbn = new ExDBFieldString<>("ztymisskbn", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztydshrym = new ExDBFieldString<>("ztydshrym", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztysrsyoumetucd = new ExDBFieldString<>("ztysrsyoumetucd", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyannaikigetu = new ExDBFieldString<>("ztyannaikigetu", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyshrriyuukbn = new ExDBFieldString<>("ztyshrriyuukbn", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyannaikbn = new ExDBFieldString<>("ztyannaikbn", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyduketorihouhoukbn = new ExDBFieldString<>("ztyduketorihouhoukbn", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztybikinhyj = new ExDBFieldString<>("ztybikinhyj", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyskskbn = new ExDBFieldString<>("ztyskskbn", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztysegcd = new ExDBFieldString<>("ztysegcd", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldNumber<ST_DshrTukiTyukeiyouItzHzn, Integer> ztysrkensuu = new ExDBFieldNumber<>("ztysrkensuu", this);

    public final ExDBFieldNumber<ST_DshrTukiTyukeiyouItzHzn, Long> ztysrhsys = new ExDBFieldNumber<>("ztysrhsys", this);

    public final ExDBFieldNumber<ST_DshrTukiTyukeiyouItzHzn, Long> ztytoujigyounendod = new ExDBFieldNumber<>("ztytoujigyounendod", this);

    public final ExDBFieldNumber<ST_DshrTukiTyukeiyouItzHzn, Long> ztytoujigyounendohasseidrsk = new ExDBFieldNumber<>("ztytoujigyounendohasseidrsk", this);

    public final ExDBFieldNumber<ST_DshrTukiTyukeiyouItzHzn, Long> ztyzenjigyounendomatudzndk = new ExDBFieldNumber<>("ztyzenjigyounendomatudzndk", this);

    public final ExDBFieldNumber<ST_DshrTukiTyukeiyouItzHzn, Long> ztyyokujigyounendod = new ExDBFieldNumber<>("ztyyokujigyounendod", this);

    public final ExDBFieldNumber<ST_DshrTukiTyukeiyouItzHzn, Long> ztyhushrtoujigyounendod = new ExDBFieldNumber<>("ztyhushrtoujigyounendod", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, BizNumber> ztydaihyouyoteiriritu = new ExDBFieldString<>("ztydaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztyhknsyruikbn = new ExDBFieldString<>("ztyhknsyruikbn", this);

    public final ExDBFieldString<ST_DshrTukiTyukeiyouItzHzn, String> ztysyoumetukbn = new ExDBFieldString<>("ztysyoumetukbn", this);
}
