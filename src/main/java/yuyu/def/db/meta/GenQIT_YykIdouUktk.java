package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_YykIdouUktk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_YykidousyoriKbn;

/**
 * 予約異動受付テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_YykIdouUktk extends AbstractExDBTable<IT_YykIdouUktk> {

    public GenQIT_YykIdouUktk() {
        this("IT_YykIdouUktk");
    }

    public GenQIT_YykIdouUktk(String pAlias) {
        super("IT_YykIdouUktk", IT_YykIdouUktk.class, pAlias);
    }

    public String IT_YykIdouUktk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_YykIdouUktk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_YykIdouUktk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_YykIdouUktk, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_YykIdouUktk, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IT_YykIdouUktk, C_YykidousyoriKbn> yykidousyorikbn = new ExDBFieldString<>("yykidousyorikbn", this, UserType_C_YykidousyoriKbn.class);

    public final ExDBFieldString<IT_YykIdouUktk, BizDate> uktkymd = new ExDBFieldString<>("uktkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_YykIdouUktk, BizDateYM> syoriym = new ExDBFieldString<>("syoriym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_YykIdouUktk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_YykIdouUktk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_YykIdouUktk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
