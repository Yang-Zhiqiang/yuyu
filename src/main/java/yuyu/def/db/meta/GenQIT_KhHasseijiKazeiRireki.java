package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HasseijikazeisyoriKbn;
import yuyu.def.classification.C_HasseijikngksyuruiKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HasseijikazeisyoriKbn;
import yuyu.def.db.type.UserType_C_HasseijikngksyuruiKbn;
import yuyu.def.db.type.UserType_C_HtsiryosyuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;

/**
 * 契約保全発生時課税履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhHasseijiKazeiRireki extends AbstractExDBTable<IT_KhHasseijiKazeiRireki> {

    public GenQIT_KhHasseijiKazeiRireki() {
        this("IT_KhHasseijiKazeiRireki");
    }

    public GenQIT_KhHasseijiKazeiRireki(String pAlias) {
        super("IT_KhHasseijiKazeiRireki", IT_KhHasseijiKazeiRireki.class, pAlias);
    }

    public String IT_KhHasseijiKazeiRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, C_HasseijikazeisyoriKbn> hasseijikazeisyorikbn = new ExDBFieldString<>("hasseijikazeisyorikbn", this, UserType_C_HasseijikazeisyoriKbn.class);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, C_UmuKbn> torikesiflg = new ExDBFieldString<>("torikesiflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, BizDate> torikesiymd = new ExDBFieldString<>("torikesiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, C_ZeitratkiKbn> zeitratkikbn = new ExDBFieldString<>("zeitratkikbn", this, UserType_C_ZeitratkiKbn.class);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, C_UmuKbn> gsbunritaisyou = new ExDBFieldString<>("gsbunritaisyou", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, C_HasseijikngksyuruiKbn> hasseijikngksyuruikbn = new ExDBFieldString<>("hasseijikngksyuruikbn", this, UserType_C_HasseijikngksyuruiKbn.class);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> hasseijikngk = new ExDBFieldBizCurrency<>("hasseijikngk", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> hasseijigstszeigk = new ExDBFieldBizCurrency<>("hasseijigstszeigk", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> yenkansangkgoukei = new ExDBFieldBizCurrency<>("yenkansangkgoukei", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> yenkansansyukngkgoukei = new ExDBFieldBizCurrency<>("yenkansansyukngkgoukei", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> yengstszeigk = new ExDBFieldBizCurrency<>("yengstszeigk", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> yengstszeigknationaltax = new ExDBFieldBizCurrency<>("yengstszeigknationaltax", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> yengstszeigklocaltax = new ExDBFieldBizCurrency<>("yengstszeigklocaltax", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> nztodouhukencd = new ExDBFieldString<>("nztodouhukencd", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> htykeihi = new ExDBFieldBizCurrency<>("htykeihi", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> kztgk = new ExDBFieldBizCurrency<>("kztgk", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> yenhtykeihi = new ExDBFieldBizCurrency<>("yenhtykeihi", this);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> yenkztgk = new ExDBFieldBizCurrency<>("yenkztgk", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, BizDate> zeimukwsratekjnymd = new ExDBFieldString<>("zeimukwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, BizNumber> zeimukwsrate = new ExDBFieldString<>("zeimukwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> kykyno = new ExDBFieldString<>("kykyno", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> kykadr1kj = new ExDBFieldString<>("kykadr1kj", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> kykadr2kj = new ExDBFieldString<>("kykadr2kj", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> kykadr3kj = new ExDBFieldString<>("kykadr3kj", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> uktmnmeigibangou = new ExDBFieldString<>("uktmnmeigibangou", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, C_HtsiryosyuKbn> shrtysysyuruikbn = new ExDBFieldString<>("shrtysysyuruikbn", this, UserType_C_HtsiryosyuKbn.class);

    public final ExDBFieldBizCurrency<IT_KhHasseijiKazeiRireki> yenshrkykhtykeihi = new ExDBFieldBizCurrency<>("yenshrkykhtykeihi", this);

    public final ExDBFieldNumber<IT_KhHasseijiKazeiRireki, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhHasseijiKazeiRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
