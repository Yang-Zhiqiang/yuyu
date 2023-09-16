package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkItijibrTuusanS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 一時払通算限度Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkItijibrTuusanS extends AbstractExDBTable<BM_ChkItijibrTuusanS> {

    public GenQBM_ChkItijibrTuusanS() {
        this("BM_ChkItijibrTuusanS");
    }

    public GenQBM_ChkItijibrTuusanS(String pAlias) {
        super("BM_ChkItijibrTuusanS", BM_ChkItijibrTuusanS.class, pAlias);
    }

    public String BM_ChkItijibrTuusanS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkItijibrTuusanS, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkItijibrTuusanS, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<BM_ChkItijibrTuusanS> gnds = new ExDBFieldBizCurrency<>("gnds", this);
}
