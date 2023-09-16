package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkItijibrTuusanP;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 一時払通算限度Ｐチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkItijibrTuusanP extends AbstractExDBTable<BM_ChkItijibrTuusanP> {

    public GenQBM_ChkItijibrTuusanP() {
        this("BM_ChkItijibrTuusanP");
    }

    public GenQBM_ChkItijibrTuusanP(String pAlias) {
        super("BM_ChkItijibrTuusanP", BM_ChkItijibrTuusanP.class, pAlias);
    }

    public String BM_ChkItijibrTuusanP() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkItijibrTuusanP, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkItijibrTuusanP, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<BM_ChkItijibrTuusanP> gnditijibaraip = new ExDBFieldBizCurrency<>("gnditijibaraip", this);
}
