package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuriDenpyouKykTuukaKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_SougouKobetuKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_HuriDenpyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DenSyorisyousaiKbn;
import yuyu.def.db.type.UserType_C_DenhnknhouKbn;
import yuyu.def.db.type.UserType_C_DenshrhouKbn;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HuriDenpyouKykTuukaKbn;
import yuyu.def.db.type.UserType_C_HuridensksKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KeirisysKbn;
import yuyu.def.db.type.UserType_C_SougouKobetuKbn;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 振替伝票作成用テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_HuriDenpyou extends AbstractExDBTable<BT_HuriDenpyou> {

    public GenQBT_HuriDenpyou() {
        this("BT_HuriDenpyou");
    }

    public GenQBT_HuriDenpyou(String pAlias) {
        super("BT_HuriDenpyou", BT_HuriDenpyou.class, pAlias);
    }

    public String BT_HuriDenpyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_HuriDenpyou, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<BT_HuriDenpyou, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<BT_HuriDenpyou, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<BT_HuriDenpyou, String> torihikino = new ExDBFieldString<>("torihikino", this);

    public final ExDBFieldString<BT_HuriDenpyou, C_KeirisysKbn> keirisyskbn = new ExDBFieldString<>("keirisyskbn", this, UserType_C_KeirisysKbn.class);

    public final ExDBFieldString<BT_HuriDenpyou, String> keirisyono = new ExDBFieldString<>("keirisyono", this);

    public final ExDBFieldString<BT_HuriDenpyou, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<BT_HuriDenpyou, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<BT_HuriDenpyou, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<BT_HuriDenpyou, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<BT_HuriDenpyou, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_HuriDenpyou, String> denkanjokamokucd = new ExDBFieldString<>("denkanjokamokucd", this);

    public final ExDBFieldString<BT_HuriDenpyou, String> jigyouhiutiwakecd = new ExDBFieldString<>("jigyouhiutiwakecd", this);

    public final ExDBFieldString<BT_HuriDenpyou, String> jigyouhiutiwakenm = new ExDBFieldString<>("jigyouhiutiwakenm", this);

    public final ExDBFieldString<BT_HuriDenpyou, String> tekiyoucd = new ExDBFieldString<>("tekiyoucd", this);

    public final ExDBFieldString<BT_HuriDenpyou, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldBizCurrency<BT_HuriDenpyou> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<BT_HuriDenpyou, C_HuridensksKbn> huridenskskbn = new ExDBFieldString<>("huridenskskbn", this, UserType_C_HuridensksKbn.class);

    public final ExDBFieldString<BT_HuriDenpyou, C_DenhnknhouKbn> denhnknhoukbn = new ExDBFieldString<>("denhnknhoukbn", this, UserType_C_DenhnknhouKbn.class);

    public final ExDBFieldString<BT_HuriDenpyou, C_DenshrhouKbn> denshrhoukbn = new ExDBFieldString<>("denshrhoukbn", this, UserType_C_DenshrhouKbn.class);

    public final ExDBFieldString<BT_HuriDenpyou, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_HuriDenpyou, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<BT_HuriDenpyou, C_SougouKobetuKbn> sougoukobetukbn = new ExDBFieldString<>("sougoukobetukbn", this, UserType_C_SougouKobetuKbn.class);

    public final ExDBFieldNumber<BT_HuriDenpyou, Integer> furikaedenpyouitirenno = new ExDBFieldNumber<>("furikaedenpyouitirenno", this);

    public final ExDBFieldString<BT_HuriDenpyou, C_HuriDenpyouKykTuukaKbn> huridenpyoukyktuukakbn = new ExDBFieldString<>("huridenpyoukyktuukakbn", this, UserType_C_HuriDenpyouKykTuukaKbn.class);

    public final ExDBFieldString<BT_HuriDenpyou, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_HuriDenpyou, String> dengyoumucd = new ExDBFieldString<>("dengyoumucd", this);

    public final ExDBFieldString<BT_HuriDenpyou, String> denkarikanjyono = new ExDBFieldString<>("denkarikanjyono", this);

    public final ExDBFieldString<BT_HuriDenpyou, C_DenSyorisyousaiKbn> densyorisyousaikbn = new ExDBFieldString<>("densyorisyousaikbn", this, UserType_C_DenSyorisyousaiKbn.class);

    public final ExDBFieldString<BT_HuriDenpyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_HuriDenpyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
