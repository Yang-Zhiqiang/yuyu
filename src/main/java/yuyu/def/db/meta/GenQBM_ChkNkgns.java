package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkNkgns;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 年金原資限度チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkNkgns extends AbstractExDBTable<BM_ChkNkgns> {

    public GenQBM_ChkNkgns() {
        this("BM_ChkNkgns");
    }

    public GenQBM_ChkNkgns(String pAlias) {
        super("BM_ChkNkgns", BM_ChkNkgns.class, pAlias);
    }

    public String BM_ChkNkgns() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkNkgns, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkNkgns, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<BM_ChkNkgns> nkgnsgndgk = new ExDBFieldBizCurrency<>("nkgnsgndgk", this);
}
