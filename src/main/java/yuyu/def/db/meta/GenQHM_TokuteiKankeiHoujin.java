package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 特定関係法人マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_TokuteiKankeiHoujin extends AbstractExDBTable<HM_TokuteiKankeiHoujin> {

    public GenQHM_TokuteiKankeiHoujin() {
        this("HM_TokuteiKankeiHoujin");
    }

    public GenQHM_TokuteiKankeiHoujin(String pAlias) {
        super("HM_TokuteiKankeiHoujin", HM_TokuteiKankeiHoujin.class, pAlias);
    }

    public String HM_TokuteiKankeiHoujin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_TokuteiKankeiHoujin, String> tkhjnkinyuucd = new ExDBFieldString<>("tkhjnkinyuucd", this);

    public final ExDBFieldString<HM_TokuteiKankeiHoujin, BizNumber> meisaino = new ExDBFieldString<>("meisaino", this, BizNumberType.class);

    public final ExDBFieldString<HM_TokuteiKankeiHoujin, String> marukinhyouji = new ExDBFieldString<>("marukinhyouji", this);

    public final ExDBFieldString<HM_TokuteiKankeiHoujin, String> tkhjnkjdrtennm = new ExDBFieldString<>("tkhjnkjdrtennm", this);

    public final ExDBFieldNumber<HM_TokuteiKankeiHoujin, Integer> dairitenbtno = new ExDBFieldNumber<>("dairitenbtno", this);

    public final ExDBFieldString<HM_TokuteiKankeiHoujin, String> tkhjnnmkj = new ExDBFieldString<>("tkhjnnmkj", this);

    public final ExDBFieldString<HM_TokuteiKankeiHoujin, String> tkhjnnmkn = new ExDBFieldString<>("tkhjnnmkn", this);

    public final ExDBFieldString<HM_TokuteiKankeiHoujin, BizDate> kosymd = new ExDBFieldString<>("kosymd", this, BizDateType.class);
}
