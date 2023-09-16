package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuriDenpyouKykTuukaKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HuriDenpyouKykTuukaKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KanjyoukmkgroupKbn;
import yuyu.def.db.type.UserType_C_KeirisysKbn;
import yuyu.def.db.type.UserType_C_NaibuKeiyakuKbn;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TekiyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 新契約振替伝票作成用テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_SinkeiyakuHurikaeDen extends AbstractExDBTable<BT_SinkeiyakuHurikaeDen> {

    public GenQBT_SinkeiyakuHurikaeDen() {
        this("BT_SinkeiyakuHurikaeDen");
    }

    public GenQBT_SinkeiyakuHurikaeDen(String pAlias) {
        super("BT_SinkeiyakuHurikaeDen", BT_SinkeiyakuHurikaeDen.class, pAlias);
    }

    public String BT_SinkeiyakuHurikaeDen() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<BT_SinkeiyakuHurikaeDen, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> torihikino = new ExDBFieldString<>("torihikino", this);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_KeirisysKbn> keirisyskbn = new ExDBFieldString<>("keirisyskbn", this, UserType_C_KeirisysKbn.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> keirisyono = new ExDBFieldString<>("keirisyono", this);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> huridenatesakicd = new ExDBFieldString<>("huridenatesakicd", this);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> denkanjokamokucd = new ExDBFieldString<>("denkanjokamokucd", this);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_KanjyoukmkgroupKbn> kanjyoukmkgroupkbn = new ExDBFieldString<>("kanjyoukmkgroupkbn", this, UserType_C_KanjyoukmkgroupKbn.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldBizCurrency<BT_SinkeiyakuHurikaeDen> denyenkagk = new ExDBFieldBizCurrency<>("denyenkagk", this);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_NaibuKeiyakuKbn> naibukeiyakukbn = new ExDBFieldString<>("naibukeiyakukbn", this, UserType_C_NaibuKeiyakuKbn.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_TekiyouKbn> tekiyoukbn = new ExDBFieldString<>("tekiyoukbn", this, UserType_C_TekiyouKbn.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> tekiyoucd = new ExDBFieldString<>("tekiyoucd", this);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_HuriDenpyouKykTuukaKbn> huridenpyoukyktuukakbn = new ExDBFieldString<>("huridenpyoukyktuukakbn", this, UserType_C_HuriDenpyouKykTuukaKbn.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<BT_SinkeiyakuHurikaeDen, String> dengyoumucd = new ExDBFieldString<>("dengyoumucd", this);
}
