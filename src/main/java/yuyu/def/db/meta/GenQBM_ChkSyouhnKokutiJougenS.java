package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkSyouhnKokutiJougenS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 商品単位告知上限Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkSyouhnKokutiJougenS extends AbstractExDBTable<BM_ChkSyouhnKokutiJougenS> {

    public GenQBM_ChkSyouhnKokutiJougenS() {
        this("BM_ChkSyouhnKokutiJougenS");
    }

    public GenQBM_ChkSyouhnKokutiJougenS(String pAlias) {
        super("BM_ChkSyouhnKokutiJougenS", BM_ChkSyouhnKokutiJougenS.class, pAlias);
    }

    public String BM_ChkSyouhnKokutiJougenS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkSyouhnKokutiJougenS, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkSyouhnKokutiJougenS, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkSyouhnKokutiJougenS, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkSyouhnKokutiJougenS, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkSyouhnKokutiJougenS, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkSyouhnKokutiJougenS, Integer> moskbnfrom = new ExDBFieldNumber<>("moskbnfrom", this);

    public final ExDBFieldNumber<BM_ChkSyouhnKokutiJougenS, Integer> moskbnto = new ExDBFieldNumber<>("moskbnto", this);

    public final ExDBFieldBizCurrency<BM_ChkSyouhnKokutiJougenS> saikous = new ExDBFieldBizCurrency<>("saikous", this);

    public final ExDBFieldString<BM_ChkSyouhnKokutiJougenS, BizNumber> bairitu = new ExDBFieldString<>("bairitu", this, BizNumberType.class);
}
