package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;

/**
 * 保険料積立金テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HokenryouTmttkn extends AbstractExDBTable<IT_HokenryouTmttkn> {

    public GenQIT_HokenryouTmttkn() {
        this("IT_HokenryouTmttkn");
    }

    public GenQIT_HokenryouTmttkn(String pAlias) {
        super("IT_HokenryouTmttkn", IT_HokenryouTmttkn.class, pAlias);
    }

    public String IT_HokenryouTmttkn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HokenryouTmttkn, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HokenryouTmttkn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HokenryouTmttkn, BizDateYM> tmttkntaisyouym = new ExDBFieldString<>("tmttkntaisyouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_HokenryouTmttkn, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldBizCurrency<IT_HokenryouTmttkn> ptmttkngk = new ExDBFieldBizCurrency<>("ptmttkngk", this);

    public final ExDBFieldBizCurrency<IT_HokenryouTmttkn> kihrkmpstgk = new ExDBFieldBizCurrency<>("kihrkmpstgk", this);

    public final ExDBFieldBizCurrency<IT_HokenryouTmttkn> tyouseimaeptmttkngk = new ExDBFieldBizCurrency<>("tyouseimaeptmttkngk", this);

    public final ExDBFieldString<IT_HokenryouTmttkn, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HokenryouTmttkn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HokenryouTmttkn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
