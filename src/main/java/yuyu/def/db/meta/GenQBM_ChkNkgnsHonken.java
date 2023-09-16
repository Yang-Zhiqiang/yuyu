package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkNkgnsHonken;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 年金原資本件チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkNkgnsHonken extends AbstractExDBTable<BM_ChkNkgnsHonken> {

    public GenQBM_ChkNkgnsHonken() {
        this("BM_ChkNkgnsHonken");
    }

    public GenQBM_ChkNkgnsHonken(String pAlias) {
        super("BM_ChkNkgnsHonken", BM_ChkNkgnsHonken.class, pAlias);
    }

    public String BM_ChkNkgnsHonken() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkNkgnsHonken, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkNkgnsHonken, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkNkgnsHonken, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkNkgnsHonken, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkNkgnsHonken, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<BM_ChkNkgnsHonken> nkgnsgndgk = new ExDBFieldBizCurrency<>("nkgnsgndgk", this);
}
