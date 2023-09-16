package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.db.entity.JT_TtdkRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_JimukakuteiKbn;

/**
 * 手続履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_TtdkRireki extends AbstractExDBTable<JT_TtdkRireki> {

    public GenQJT_TtdkRireki() {
        this("JT_TtdkRireki");
    }

    public GenQJT_TtdkRireki(String pAlias) {
        super("JT_TtdkRireki", JT_TtdkRireki.class, pAlias);
    }

    public String JT_TtdkRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_TtdkRireki, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_TtdkRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_TtdkRireki, String> ttdkrrkskbtkey = new ExDBFieldString<>("ttdkrrkskbtkey", this);

    public final ExDBFieldString<JT_TtdkRireki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<JT_TtdkRireki, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<JT_TtdkRireki, C_JimukakuteiKbn> jimukakuteiumukbn = new ExDBFieldString<>("jimukakuteiumukbn", this, UserType_C_JimukakuteiKbn.class);

    public final ExDBFieldNumber<JT_TtdkRireki, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_TtdkRireki, String> shrsikibetukey = new ExDBFieldString<>("shrsikibetukey", this);

    public final ExDBFieldString<JT_TtdkRireki, String> sateisyouninskbtkey = new ExDBFieldString<>("sateisyouninskbtkey", this);

    public final ExDBFieldString<JT_TtdkRireki, String> syanaicomment = new ExDBFieldString<>("syanaicomment", this);

    public final ExDBFieldString<JT_TtdkRireki, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_TtdkRireki, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_TtdkRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_TtdkRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
