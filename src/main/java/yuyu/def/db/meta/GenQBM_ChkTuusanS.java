package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkTuusanS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 通算限度Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkTuusanS extends AbstractExDBTable<BM_ChkTuusanS> {

    public GenQBM_ChkTuusanS() {
        this("BM_ChkTuusanS");
    }

    public GenQBM_ChkTuusanS(String pAlias) {
        super("BM_ChkTuusanS", BM_ChkTuusanS.class, pAlias);
    }

    public String BM_ChkTuusanS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkTuusanS, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkTuusanS, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<BM_ChkTuusanS> gnds1 = new ExDBFieldBizCurrency<>("gnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkTuusanS> gnds2 = new ExDBFieldBizCurrency<>("gnds2", this);

    public final ExDBFieldBizCurrency<BM_ChkTuusanS> gnds3 = new ExDBFieldBizCurrency<>("gnds3", this);

    public final ExDBFieldBizCurrency<BM_ChkTuusanS> gnds4 = new ExDBFieldBizCurrency<>("gnds4", this);

    public final ExDBFieldBizCurrency<BM_ChkTuusanS> gnds5 = new ExDBFieldBizCurrency<>("gnds5", this);

    public final ExDBFieldBizCurrency<BM_ChkTuusanS> oldkijyungnds1 = new ExDBFieldBizCurrency<>("oldkijyungnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkTuusanS> oldkijyungnds2 = new ExDBFieldBizCurrency<>("oldkijyungnds2", this);
}
