package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_GrossNykn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * グロス入金テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_GrossNykn extends AbstractExDBTable<HT_GrossNykn> {

    public GenQHT_GrossNykn() {
        this("HT_GrossNykn");
    }

    public GenQHT_GrossNykn(String pAlias) {
        super("HT_GrossNykn", HT_GrossNykn.class, pAlias);
    }

    public String HT_GrossNykn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_GrossNykn, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<HT_GrossNykn, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldNumber<HT_GrossNykn, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_GrossNykn, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_GrossNykn, C_Tuukasyu> hrktuukasyu = new ExDBFieldString<>("hrktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_GrossNykn, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_GrossNykn, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_GrossNykn, String> nyuukinoyadrtennm = new ExDBFieldString<>("nyuukinoyadrtennm", this);

    public final ExDBFieldString<HT_GrossNykn, BizNumber> kawaserate = new ExDBFieldString<>("kawaserate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<HT_GrossNykn> grossnykngk = new ExDBFieldBizCurrency<>("grossnykngk", this);

    public final ExDBFieldBizCurrency<HT_GrossNykn> grossdengk = new ExDBFieldBizCurrency<>("grossdengk", this);

    public final ExDBFieldBizCurrency<HT_GrossNykn> meisaigoukeidengk = new ExDBFieldBizCurrency<>("meisaigoukeidengk", this);

    public final ExDBFieldBizCurrency<HT_GrossNykn> kawasesasonekikngk = new ExDBFieldBizCurrency<>("kawasesasonekikngk", this);

    public final ExDBFieldString<HT_GrossNykn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_GrossNykn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
