package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkJhTuusanS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 通算限度Ｓ事方書チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkJhTuusanS extends AbstractExDBTable<BM_ChkJhTuusanS> {

    public GenQBM_ChkJhTuusanS() {
        this("BM_ChkJhTuusanS");
    }

    public GenQBM_ChkJhTuusanS(String pAlias) {
        super("BM_ChkJhTuusanS", BM_ChkJhTuusanS.class, pAlias);
    }

    public String BM_ChkJhTuusanS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkJhTuusanS, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhTuusanS, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<BM_ChkJhTuusanS> gnds1 = new ExDBFieldBizCurrency<>("gnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkJhTuusanS> gnds2 = new ExDBFieldBizCurrency<>("gnds2", this);

    public final ExDBFieldBizCurrency<BM_ChkJhTuusanS> gnds3 = new ExDBFieldBizCurrency<>("gnds3", this);

    public final ExDBFieldBizCurrency<BM_ChkJhTuusanS> gnds4 = new ExDBFieldBizCurrency<>("gnds4", this);

    public final ExDBFieldBizCurrency<BM_ChkJhTuusanS> gnds5 = new ExDBFieldBizCurrency<>("gnds5", this);

    public final ExDBFieldBizCurrency<BM_ChkJhTuusanS> oldkijyungnds1 = new ExDBFieldBizCurrency<>("oldkijyungnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkJhTuusanS> oldkijyungnds2 = new ExDBFieldBizCurrency<>("oldkijyungnds2", this);
}
