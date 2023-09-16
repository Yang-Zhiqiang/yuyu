package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.HT_HenteiRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 変更訂正履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_HenteiRireki extends AbstractExDBTable<HT_HenteiRireki> {

    public GenQHT_HenteiRireki() {
        this("HT_HenteiRireki");
    }

    public GenQHT_HenteiRireki(String pAlias) {
        super("HT_HenteiRireki", HT_HenteiRireki.class, pAlias);
    }

    public String HT_HenteiRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_HenteiRireki, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_HenteiRireki, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_HenteiRireki, BizDate> henteiymd = new ExDBFieldString<>("henteiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_HenteiRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_HenteiRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
