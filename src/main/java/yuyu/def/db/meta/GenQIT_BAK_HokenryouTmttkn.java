package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_BAK_HokenryouTmttkn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;

/**
 * 保険料積立金バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_HokenryouTmttkn extends AbstractExDBTable<IT_BAK_HokenryouTmttkn> {

    public GenQIT_BAK_HokenryouTmttkn() {
        this("IT_BAK_HokenryouTmttkn");
    }

    public GenQIT_BAK_HokenryouTmttkn(String pAlias) {
        super("IT_BAK_HokenryouTmttkn", IT_BAK_HokenryouTmttkn.class, pAlias);
    }

    public String IT_BAK_HokenryouTmttkn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_HokenryouTmttkn, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_HokenryouTmttkn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_HokenryouTmttkn, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_HokenryouTmttkn, BizDateYM> tmttkntaisyouym = new ExDBFieldString<>("tmttkntaisyouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_BAK_HokenryouTmttkn, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenryouTmttkn> ptmttkngk = new ExDBFieldBizCurrency<>("ptmttkngk", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenryouTmttkn> kihrkmpstgk = new ExDBFieldBizCurrency<>("kihrkmpstgk", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenryouTmttkn> tyouseimaeptmttkngk = new ExDBFieldBizCurrency<>("tyouseimaeptmttkngk", this);

    public final ExDBFieldString<IT_BAK_HokenryouTmttkn, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_HokenryouTmttkn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_HokenryouTmttkn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
