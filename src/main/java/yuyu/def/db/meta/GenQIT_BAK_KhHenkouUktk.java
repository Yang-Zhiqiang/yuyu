package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_TourokuRouteKbn;
import yuyu.def.db.type.UserType_C_UktkJyoutaiKbn;
import yuyu.def.db.type.UserType_C_UktkSyoriKbn;

/**
 * 契約保全変更受付バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhHenkouUktk extends AbstractExDBTable<IT_BAK_KhHenkouUktk> {

    public GenQIT_BAK_KhHenkouUktk() {
        this("IT_BAK_KhHenkouUktk");
    }

    public GenQIT_BAK_KhHenkouUktk(String pAlias) {
        super("IT_BAK_KhHenkouUktk", IT_BAK_KhHenkouUktk.class, pAlias);
    }

    public String IT_BAK_KhHenkouUktk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_KhHenkouUktk, Integer> hozenhenkouuktkrenno = new ExDBFieldNumber<>("hozenhenkouuktkrenno", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, BizDate> uktkymd = new ExDBFieldString<>("uktkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, C_TourokuRouteKbn> tourokuroute = new ExDBFieldString<>("tourokuroute", this, UserType_C_TourokuRouteKbn.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, C_UktkSyoriKbn> uktksyorikbn = new ExDBFieldString<>("uktksyorikbn", this, UserType_C_UktkSyoriKbn.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, BizDate> syoriyoteiymd = new ExDBFieldString<>("syoriyoteiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, C_UktkJyoutaiKbn> uktkjyoutaikbn = new ExDBFieldString<>("uktkjyoutaikbn", this, UserType_C_UktkJyoutaiKbn.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
