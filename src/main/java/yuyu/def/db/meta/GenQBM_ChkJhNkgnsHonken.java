package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkJhNkgnsHonken;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 年金原資本件事方書チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkJhNkgnsHonken extends AbstractExDBTable<BM_ChkJhNkgnsHonken> {

    public GenQBM_ChkJhNkgnsHonken() {
        this("BM_ChkJhNkgnsHonken");
    }

    public GenQBM_ChkJhNkgnsHonken(String pAlias) {
        super("BM_ChkJhNkgnsHonken", BM_ChkJhNkgnsHonken.class, pAlias);
    }

    public String BM_ChkJhNkgnsHonken() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkJhNkgnsHonken, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkJhNkgnsHonken, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkJhNkgnsHonken, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkJhNkgnsHonken, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhNkgnsHonken, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<BM_ChkJhNkgnsHonken> nkgnsgndgk = new ExDBFieldBizCurrency<>("nkgnsgndgk", this);
}
