package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.HT_GrossNyknMeisai;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * グロス入金明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_GrossNyknMeisai extends AbstractExDBTable<HT_GrossNyknMeisai> {

    public GenQHT_GrossNyknMeisai() {
        this("HT_GrossNyknMeisai");
    }

    public GenQHT_GrossNyknMeisai(String pAlias) {
        super("HT_GrossNyknMeisai", HT_GrossNyknMeisai.class, pAlias);
    }

    public String HT_GrossNyknMeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_GrossNyknMeisai, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<HT_GrossNyknMeisai, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldNumber<HT_GrossNyknMeisai, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldNumber<HT_GrossNyknMeisai, Integer> meisairenno = new ExDBFieldNumber<>("meisairenno", this);

    public final ExDBFieldString<HT_GrossNyknMeisai, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldBizCurrency<HT_GrossNyknMeisai> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldBizCurrency<HT_GrossNyknMeisai> dengk = new ExDBFieldBizCurrency<>("dengk", this);

    public final ExDBFieldString<HT_GrossNyknMeisai, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_GrossNyknMeisai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
