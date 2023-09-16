package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_RateP2;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * Ｐレートマスタ２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_RateP2 extends AbstractExDBTable<BM_RateP2> {

    public GenQBM_RateP2() {
        this("BM_RateP2");
    }

    public GenQBM_RateP2(String pAlias) {
        super("BM_RateP2", BM_RateP2.class, pAlias);
    }

    public String BM_RateP2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_RateP2, String> palhokensyuruikigou = new ExDBFieldString<>("palhokensyuruikigou", this);

    public final ExDBFieldString<BM_RateP2, String> palhokensyuruikigousdicode = new ExDBFieldString<>("palhokensyuruikigousdicode", this);

    public final ExDBFieldString<BM_RateP2, String> palyoteiriritu = new ExDBFieldString<>("palyoteiriritu", this);

    public final ExDBFieldString<BM_RateP2, String> palpmencode = new ExDBFieldString<>("palpmencode", this);

    public final ExDBFieldString<BM_RateP2, String> palharaikomikaisuu = new ExDBFieldString<>("palharaikomikaisuu", this);

    public final ExDBFieldString<BM_RateP2, String> palhhknsei = new ExDBFieldString<>("palhhknsei", this);

    public final ExDBFieldString<BM_RateP2, String> palkeiyakujihhknnen = new ExDBFieldString<>("palkeiyakujihhknnen", this);

    public final ExDBFieldString<BM_RateP2, String> palsaimankihyouji = new ExDBFieldString<>("palsaimankihyouji", this);

    public final ExDBFieldString<BM_RateP2, String> palhokenkikan = new ExDBFieldString<>("palhokenkikan", this);

    public final ExDBFieldString<BM_RateP2, String> palpharaikomikikan = new ExDBFieldString<>("palpharaikomikikan", this);

    public final ExDBFieldString<BM_RateP2, String> palannaihuyouriyuukbn = new ExDBFieldString<>("palannaihuyouriyuukbn", this);

    public final ExDBFieldString<BM_RateP2, String> ratetuukasyukbn = new ExDBFieldString<>("ratetuukasyukbn", this);

    public final ExDBFieldString<BM_RateP2, String> ratedai1hknkkn = new ExDBFieldString<>("ratedai1hknkkn", this);

    public final ExDBFieldString<BM_RateP2, String> palryouritukbn = new ExDBFieldString<>("palryouritukbn", this);

    public final ExDBFieldString<BM_RateP2, BizNumber> prate = new ExDBFieldString<>("prate", this, BizNumberType.class);

    public final ExDBFieldString<BM_RateP2, BizNumber> pdatesrate = new ExDBFieldString<>("pdatesrate", this, BizNumberType.class);
}
