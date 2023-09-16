package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KykIdouHaraikataKbn;
import yuyu.def.classification.C_TumitatekinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZfiIdoujiyuuKbn;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_KykIdouHaraikataKbn;
import yuyu.def.db.type.UserType_C_TumitatekinKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_ZfiIdoujiyuuKbn;
import yuyu.def.db.type.UserType_C_ZougenKbn;

/**
 * 保険契約異動情報履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HokenKykIdouRireki extends AbstractExDBTable<IT_HokenKykIdouRireki> {

    public GenQIT_HokenKykIdouRireki() {
        this("IT_HokenKykIdouRireki");
    }

    public GenQIT_HokenKykIdouRireki(String pAlias) {
        super("IT_HokenKykIdouRireki", IT_HokenKykIdouRireki.class, pAlias);
    }

    public String IT_HokenKykIdouRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HokenKykIdouRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HokenKykIdouRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HokenKykIdouRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_HokenKykIdouRireki, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_HokenKykIdouRireki, BizDate> idouymd = new ExDBFieldString<>("idouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HokenKykIdouRireki, C_ZfiIdoujiyuuKbn> idoujiyuukbn = new ExDBFieldString<>("idoujiyuukbn", this, UserType_C_ZfiIdoujiyuuKbn.class);

    public final ExDBFieldNumber<IT_HokenKykIdouRireki, Integer> ttdkrenno = new ExDBFieldNumber<>("ttdkrenno", this);

    public final ExDBFieldString<IT_HokenKykIdouRireki, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_HokenKykIdouRireki, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<IT_HokenKykIdouRireki, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<IT_HokenKykIdouRireki, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<IT_HokenKykIdouRireki, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<IT_HokenKykIdouRireki, C_ZougenKbn> zougenkbn = new ExDBFieldString<>("zougenkbn", this, UserType_C_ZougenKbn.class);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> hokenkngk = new ExDBFieldBizCurrency<>("hokenkngk", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> hokenryou = new ExDBFieldBizCurrency<>("hokenryou", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> ptumitatekin = new ExDBFieldBizCurrency<>("ptumitatekin", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> kaiyakuhrgoukei = new ExDBFieldBizCurrency<>("kaiyakuhrgoukei", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> kaiyakuhr = new ExDBFieldBizCurrency<>("kaiyakuhr", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> mikeikap = new ExDBFieldBizCurrency<>("mikeikap", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> zennouseisankgk = new ExDBFieldBizCurrency<>("zennouseisankgk", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> idouhokenkngk = new ExDBFieldBizCurrency<>("idouhokenkngk", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> idoup = new ExDBFieldBizCurrency<>("idoup", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> idouptumitatekin = new ExDBFieldBizCurrency<>("idouptumitatekin", this);

    public final ExDBFieldBizCurrency<IT_HokenKykIdouRireki> idoukiykhnrikn = new ExDBFieldBizCurrency<>("idoukiykhnrikn", this);

    public final ExDBFieldNumber<IT_HokenKykIdouRireki, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldString<IT_HokenKykIdouRireki, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_HokenKykIdouRireki, C_TumitatekinKbn> tumitatekinkbn = new ExDBFieldString<>("tumitatekinkbn", this, UserType_C_TumitatekinKbn.class);

    public final ExDBFieldString<IT_HokenKykIdouRireki, C_KykIdouHaraikataKbn> kykidouharaikatakbn = new ExDBFieldString<>("kykidouharaikatakbn", this, UserType_C_KykIdouHaraikataKbn.class);

    public final ExDBFieldString<IT_HokenKykIdouRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HokenKykIdouRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HokenKykIdouRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
