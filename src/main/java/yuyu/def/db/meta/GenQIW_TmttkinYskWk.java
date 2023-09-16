package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_SyouhnBunruiTmttkinyskKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IW_TmttkinYskWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_SyouhnBunruiTmttkinyskKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 積立金予測ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_TmttkinYskWk extends AbstractExDBTable<IW_TmttkinYskWk> {

    public GenQIW_TmttkinYskWk() {
        this("IW_TmttkinYskWk");
    }

    public GenQIW_TmttkinYskWk(String pAlias) {
        super("IW_TmttkinYskWk", IW_TmttkinYskWk.class, pAlias);
    }

    public String IW_TmttkinYskWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_TmttkinYskWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_TmttkinYskWk, C_SyouhnBunruiTmttkinyskKbn> syouhnbunruitmttkinyskkbn = new ExDBFieldString<>("syouhnbunruitmttkinyskkbn", this, UserType_C_SyouhnBunruiTmttkinyskKbn.class);

    public final ExDBFieldString<IW_TmttkinYskWk, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IW_TmttkinYskWk, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IW_TmttkinYskWk, BizNumber> kyksjkkktyouseiriritu = new ExDBFieldString<>("kyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<IW_TmttkinYskWk, C_UmuKbn> targettkhkumu = new ExDBFieldString<>("targettkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<IW_TmttkinYskWk, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);

    public final ExDBFieldBizCurrency<IW_TmttkinYskWk> kyktuukap = new ExDBFieldBizCurrency<>("kyktuukap", this);

    public final ExDBFieldBizCurrency<IW_TmttkinYskWk> kyktuukatmttkngk = new ExDBFieldBizCurrency<>("kyktuukatmttkngk", this);

    public final ExDBFieldBizCurrency<IW_TmttkinYskWk> kyktuukakaiyakuhrgk = new ExDBFieldBizCurrency<>("kyktuukakaiyakuhrgk", this);

    public final ExDBFieldString<IW_TmttkinYskWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_TmttkinYskWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_TmttkinYskWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
