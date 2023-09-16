package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 備金契約精算ＤＦテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_BikinKeiyakuSeisandRn extends AbstractExDBTable<ZT_BikinKeiyakuSeisandRn> {

    public GenQZT_BikinKeiyakuSeisandRn() {
        this("ZT_BikinKeiyakuSeisandRn");
    }

    public GenQZT_BikinKeiyakuSeisandRn(String pAlias) {
        super("ZT_BikinKeiyakuSeisandRn", ZT_BikinKeiyakuSeisandRn.class, pAlias);
    }

    public String ZT_BikinKeiyakuSeisandRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnbikinkbn = new ExDBFieldString<>("zrnbikinkbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnbikinnendokbn = new ExDBFieldString<>("zrnbikinnendokbn", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandRn, Long> zrnseisand = new ExDBFieldNumber<>("zrnseisand", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandRn, Long> zrntumitaterisoku = new ExDBFieldNumber<>("zrntumitaterisoku", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnsyuruicd1 = new ExDBFieldString<>("zrnsyuruicd1", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnsyuruicd3 = new ExDBFieldString<>("zrnsyuruicd3", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnsrkijyunym = new ExDBFieldString<>("zrnsrkijyunym", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnsyuruicd2 = new ExDBFieldString<>("zrnsyuruicd2", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandRn, Long> zrnkariwariatedganrikin = new ExDBFieldNumber<>("zrnkariwariatedganrikin", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandRn, Long> zrnkariwariatedrisoku = new ExDBFieldNumber<>("zrnkariwariatedrisoku", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, BizNumber> zrndaihyouyoteiriritu = new ExDBFieldString<>("zrndaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandRn, String> zrnyobiv32 = new ExDBFieldString<>("zrnyobiv32", this);
}
