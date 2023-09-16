package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_MisyuupRendo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 未収Ｐ連動テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_MisyuupRendo extends AbstractExDBTable<JT_MisyuupRendo> {

    public GenQJT_MisyuupRendo() {
        this("JT_MisyuupRendo");
    }

    public GenQJT_MisyuupRendo(String pAlias) {
        super("JT_MisyuupRendo", JT_MisyuupRendo.class, pAlias);
    }

    public String JT_MisyuupRendo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_MisyuupRendo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_MisyuupRendo, Integer> datarenno = new ExDBFieldNumber<>("datarenno", this);

    public final ExDBFieldString<JT_MisyuupRendo, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<JT_MisyuupRendo, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<JT_MisyuupRendo, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<JT_MisyuupRendo, C_UmuKbn> iktnyuukinnumu = new ExDBFieldString<>("iktnyuukinnumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_MisyuupRendo, BizDateYM> misyuupjyuutouym = new ExDBFieldString<>("misyuupjyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<JT_MisyuupRendo, Integer> misyuupjyuutoukaisuuy = new ExDBFieldNumber<>("misyuupjyuutoukaisuuy", this);

    public final ExDBFieldNumber<JT_MisyuupRendo, Integer> misyuupjyuutoukaisuum = new ExDBFieldNumber<>("misyuupjyuutoukaisuum", this);

    public final ExDBFieldBizCurrency<JT_MisyuupRendo> misyuup = new ExDBFieldBizCurrency<>("misyuup", this);

    public final ExDBFieldString<JT_MisyuupRendo, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<JT_MisyuupRendo, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<JT_MisyuupRendo, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<JT_MisyuupRendo, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<JT_MisyuupRendo, BizDate> nyknkwsratekijyunymd = new ExDBFieldString<>("nyknkwsratekijyunymd", this, BizDateType.class);

    public final ExDBFieldString<JT_MisyuupRendo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<JT_MisyuupRendo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_MisyuupRendo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_MisyuupRendo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_MisyuupRendo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
