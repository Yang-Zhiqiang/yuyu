package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_TourokuRouteKbn;
import yuyu.def.db.type.UserType_C_UktkJyoutaiKbn;
import yuyu.def.db.type.UserType_C_UktkSyoriKbn;

/**
 * 契約保全変更受付予約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_KhHenkouUktkYyk extends AbstractExDBTable<MT_KhHenkouUktkYyk> {

    public GenQMT_KhHenkouUktkYyk() {
        this("MT_KhHenkouUktkYyk");
    }

    public GenQMT_KhHenkouUktkYyk(String pAlias) {
        super("MT_KhHenkouUktkYyk", MT_KhHenkouUktkYyk.class, pAlias);
    }

    public String MT_KhHenkouUktkYyk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_KhHenkouUktkYyk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<MT_KhHenkouUktkYyk, Integer> hozenhenkouuktkrenno = new ExDBFieldNumber<>("hozenhenkouuktkrenno", this);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, BizDate> uktkymd = new ExDBFieldString<>("uktkymd", this, BizDateType.class);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, C_TourokuRouteKbn> tourokuroute = new ExDBFieldString<>("tourokuroute", this, UserType_C_TourokuRouteKbn.class);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, C_UktkSyoriKbn> uktksyorikbn = new ExDBFieldString<>("uktksyorikbn", this, UserType_C_UktkSyoriKbn.class);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, BizDate> syoriyoteiymd = new ExDBFieldString<>("syoriyoteiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, C_UktkJyoutaiKbn> uktkjyoutaikbn = new ExDBFieldString<>("uktkjyoutaikbn", this, UserType_C_UktkJyoutaiKbn.class);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_KhHenkouUktkYyk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
