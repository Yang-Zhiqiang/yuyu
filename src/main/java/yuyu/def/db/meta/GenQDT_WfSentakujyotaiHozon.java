package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BooleanType;

/**
 * ワークフロー選択状態保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQDT_WfSentakujyotaiHozon extends AbstractExDBTable<DT_WfSentakujyotaiHozon> {

    public GenQDT_WfSentakujyotaiHozon() {
        this("DT_WfSentakujyotaiHozon");
    }

    public GenQDT_WfSentakujyotaiHozon(String pAlias) {
        super("DT_WfSentakujyotaiHozon", DT_WfSentakujyotaiHozon.class, pAlias);
    }

    public String DT_WfSentakujyotaiHozon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> skeiJimuKbnHzn = new ExDBFieldString<>("skeiJimuKbnHzn", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> mosUketukeKbnHzn = new ExDBFieldString<>("mosUketukeKbnHzn", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> hokensyuruinohozon = new ExDBFieldString<>("hokensyuruinohozon", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> drtencd3 = new ExDBFieldString<>("drtencd3", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> drtencd4 = new ExDBFieldString<>("drtencd4", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> drtencd5 = new ExDBFieldString<>("drtencd5", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, Boolean> koDairitenTaisyouKbn = new ExDBFieldString<>("koDairitenTaisyouKbn", this, BooleanType.class);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> jimuyoucd = new ExDBFieldString<>("jimuyoucd", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, Boolean> jmycdMisetteiKbn = new ExDBFieldString<>("jmycdMisetteiKbn", this, BooleanType.class);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, Boolean> djmskmKeiyakuKbn = new ExDBFieldString<>("djmskmKeiyakuKbn", this, BooleanType.class);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, BizDate> mosYmdFrom = new ExDBFieldString<>("mosYmdFrom", this, BizDateType.class);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, BizDate> mosYmdTo = new ExDBFieldString<>("mosYmdTo", this, BizDateType.class);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, BizDate> jimustartYmdFrom = new ExDBFieldString<>("jimustartYmdFrom", this, BizDateType.class);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, BizDate> jimustartYmdTo = new ExDBFieldString<>("jimustartYmdTo", this, BizDateType.class);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<DT_WfSentakujyotaiHozon, String> nksysyno = new ExDBFieldString<>("nksysyno", this);
}
