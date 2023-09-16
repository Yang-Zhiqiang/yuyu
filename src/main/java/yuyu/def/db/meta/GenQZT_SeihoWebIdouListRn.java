package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SeihoWebIdouListRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SeihoWebIdouListRn extends AbstractExDBTable<ZT_SeihoWebIdouListRn> {

    public GenQZT_SeihoWebIdouListRn() {
        this("ZT_SeihoWebIdouListRn");
    }

    public GenQZT_SeihoWebIdouListRn(String pAlias) {
        super("ZT_SeihoWebIdouListRn", ZT_SeihoWebIdouListRn.class, pAlias);
    }

    public String ZT_SeihoWebIdouListRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SeihoWebIdouListRn, Long> zrnsakuseiymd7keta = new ExDBFieldNumber<>("zrnsakuseiymd7keta", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnbsydrtencd = new ExDBFieldString<>("zrnbsydrtencd", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrntntusycd = new ExDBFieldString<>("zrntntusycd", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnhasseiymd = new ExDBFieldString<>("zrnhasseiymd", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnidoukbn1 = new ExDBFieldString<>("zrnidoukbn1", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnkydatkikbnkj = new ExDBFieldString<>("zrnkydatkikbnkj", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnkykyymm = new ExDBFieldString<>("zrnkykyymm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnmidasikbn = new ExDBFieldString<>("zrnmidasikbn", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnatesakinm = new ExDBFieldString<>("zrnatesakinm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnhassinka = new ExDBFieldString<>("zrnhassinka", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnbsyyymm = new ExDBFieldString<>("zrnbsyyymm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrntntusynm = new ExDBFieldString<>("zrntntusynm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnkyknmkjseihoweb = new ExDBFieldString<>("zrnkyknmkjseihoweb", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnpjyuutouyymm = new ExDBFieldString<>("zrnpjyuutouyymm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnhrkkaisuukj = new ExDBFieldString<>("zrnhrkkaisuukj", this);

    public final ExDBFieldNumber<ZT_SeihoWebIdouListRn, Long> zrnp11keta = new ExDBFieldNumber<>("zrnp11keta", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnhrkkeirobtjhmidasi = new ExDBFieldString<>("zrnhrkkeirobtjhmidasi", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnhrkkeirobtjh = new ExDBFieldString<>("zrnhrkkeirobtjh", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrntntusyjk = new ExDBFieldString<>("zrntntusyjk", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnhrkkeirokj = new ExDBFieldString<>("zrnhrkkeirokj", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnhknsyuruimei = new ExDBFieldString<>("zrnhknsyuruimei", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnidoukbn2 = new ExDBFieldString<>("zrnidoukbn2", this);

    public final ExDBFieldNumber<ZT_SeihoWebIdouListRn, Long> zrndbskyoteiymd7keta = new ExDBFieldNumber<>("zrndbskyoteiymd7keta", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, BizNumber> zrngaikakykhrkp = new ExDBFieldString<>("zrngaikakykhrkp", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeihoWebIdouListRn, String> zrnkyktuukasyukbn = new ExDBFieldString<>("zrnkyktuukasyukbn", this);
}
