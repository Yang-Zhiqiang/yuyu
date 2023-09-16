package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SeihoWebIdouListTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SeihoWebIdouListTy extends AbstractExDBTable<ZT_SeihoWebIdouListTy> {

    public GenQZT_SeihoWebIdouListTy() {
        this("ZT_SeihoWebIdouListTy");
    }

    public GenQZT_SeihoWebIdouListTy(String pAlias) {
        super("ZT_SeihoWebIdouListTy", ZT_SeihoWebIdouListTy.class, pAlias);
    }

    public String ZT_SeihoWebIdouListTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztysakuseiymd7keta = new ExDBFieldString<>("ztysakuseiymd7keta", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztytntusycd = new ExDBFieldString<>("ztytntusycd", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyhasseiymd = new ExDBFieldString<>("ztyhasseiymd", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyidoukbn1 = new ExDBFieldString<>("ztyidoukbn1", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztykydatkikbnkj = new ExDBFieldString<>("ztykydatkikbnkj", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztykykyymm = new ExDBFieldString<>("ztykykyymm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztymidasikbn = new ExDBFieldString<>("ztymidasikbn", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyatesakinm = new ExDBFieldString<>("ztyatesakinm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyhassinka = new ExDBFieldString<>("ztyhassinka", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztybsyyymm = new ExDBFieldString<>("ztybsyyymm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztytntusynm = new ExDBFieldString<>("ztytntusynm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztykyknmkjseihoweb = new ExDBFieldString<>("ztykyknmkjseihoweb", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztypjyuutouyymm = new ExDBFieldString<>("ztypjyuutouyymm", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyhrkkaisuukj = new ExDBFieldString<>("ztyhrkkaisuukj", this);

    public final ExDBFieldNumber<ZT_SeihoWebIdouListTy, Long> ztyp11keta = new ExDBFieldNumber<>("ztyp11keta", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyhrkkeirobtjhmidasi = new ExDBFieldString<>("ztyhrkkeirobtjhmidasi", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyhrkkeirobtjh = new ExDBFieldString<>("ztyhrkkeirobtjh", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztytntusyjk = new ExDBFieldString<>("ztytntusyjk", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyhrkkeirokj = new ExDBFieldString<>("ztyhrkkeirokj", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyhknsyuruimei = new ExDBFieldString<>("ztyhknsyuruimei", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztyidoukbn2 = new ExDBFieldString<>("ztyidoukbn2", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztydbskyoteiymd7keta = new ExDBFieldString<>("ztydbskyoteiymd7keta", this);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, BizNumber> ztygaikakykhrkp = new ExDBFieldString<>("ztygaikakykhrkp", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SeihoWebIdouListTy, String> ztykyktuukasyukbn = new ExDBFieldString<>("ztykyktuukasyukbn", this);
}
