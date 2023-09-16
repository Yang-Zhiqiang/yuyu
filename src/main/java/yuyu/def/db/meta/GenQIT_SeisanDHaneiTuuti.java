package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_SeisanDHaneiTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;

/**
 * 精算Ｄ反映通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_SeisanDHaneiTuuti extends AbstractExDBTable<IT_SeisanDHaneiTuuti> {

    public GenQIT_SeisanDHaneiTuuti() {
        this("IT_SeisanDHaneiTuuti");
    }

    public GenQIT_SeisanDHaneiTuuti(String pAlias) {
        super("IT_SeisanDHaneiTuuti", IT_SeisanDHaneiTuuti.class, pAlias);
    }

    public String IT_SeisanDHaneiTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_SeisanDHaneiTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_SeisanDHaneiTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_SeisanDHaneiTuuti, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldBizCurrency<IT_SeisanDHaneiTuuti> kakuteitounendod = new ExDBFieldBizCurrency<>("kakuteitounendod", this);

    public final ExDBFieldBizCurrency<IT_SeisanDHaneiTuuti> naiteitounendod = new ExDBFieldBizCurrency<>("naiteitounendod", this);

    public final ExDBFieldBizCurrency<IT_SeisanDHaneiTuuti> seisandkgk = new ExDBFieldBizCurrency<>("seisandkgk", this);

    public final ExDBFieldString<IT_SeisanDHaneiTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_SeisanDHaneiTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_SeisanDHaneiTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
