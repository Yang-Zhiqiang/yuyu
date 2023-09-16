package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.BT_KbtKarikanjyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;

/**
 * 個別仮勘定テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_KbtKarikanjyou extends AbstractExDBTable<BT_KbtKarikanjyou> {

    public GenQBT_KbtKarikanjyou() {
        this("BT_KbtKarikanjyou");
    }

    public GenQBT_KbtKarikanjyou(String pAlias) {
        super("BT_KbtKarikanjyou", BT_KbtKarikanjyou.class, pAlias);
    }

    public String BT_KbtKarikanjyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_KbtKarikanjyou, BizNumber> kbtkarikanjyouskbtkey = new ExDBFieldString<>("kbtkarikanjyouskbtkey", this, BizNumberType.class);

    public final ExDBFieldString<BT_KbtKarikanjyou, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<BT_KbtKarikanjyou, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<BT_KbtKarikanjyou, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<BT_KbtKarikanjyou, String> keirisyono = new ExDBFieldString<>("keirisyono", this);

    public final ExDBFieldString<BT_KbtKarikanjyou, String> nyuukinkakusyouno = new ExDBFieldString<>("nyuukinkakusyouno", this);

    public final ExDBFieldString<BT_KbtKarikanjyou, BizDate> hurikaedenskssyoriymd = new ExDBFieldString<>("hurikaedenskssyoriymd", this, BizDateType.class);

    public final ExDBFieldString<BT_KbtKarikanjyou, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<BT_KbtKarikanjyou, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<BT_KbtKarikanjyou, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<BT_KbtKarikanjyou, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldBizCurrency<BT_KbtKarikanjyou> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<BT_KbtKarikanjyou, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<BT_KbtKarikanjyou, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<BT_KbtKarikanjyou, String> kbtkarikanjyoukbn = new ExDBFieldString<>("kbtkarikanjyoukbn", this);

    public final ExDBFieldString<BT_KbtKarikanjyou, BizDate> kskmkanryouymd = new ExDBFieldString<>("kskmkanryouymd", this, BizDateType.class);

    public final ExDBFieldString<BT_KbtKarikanjyou, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BT_KbtKarikanjyou, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);
}
