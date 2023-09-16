package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkJhNkgns;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 年金原資限度事方書チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkJhNkgns extends AbstractExDBTable<BM_ChkJhNkgns> {

    public GenQBM_ChkJhNkgns() {
        this("BM_ChkJhNkgns");
    }

    public GenQBM_ChkJhNkgns(String pAlias) {
        super("BM_ChkJhNkgns", BM_ChkJhNkgns.class, pAlias);
    }

    public String BM_ChkJhNkgns() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkJhNkgns, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhNkgns, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<BM_ChkJhNkgns> nkgnsgndgk = new ExDBFieldBizCurrency<>("nkgnsgndgk", this);
}
