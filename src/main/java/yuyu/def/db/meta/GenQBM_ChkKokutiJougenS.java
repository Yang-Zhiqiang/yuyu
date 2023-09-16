package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkKokutiJougenS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 告知上限Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkKokutiJougenS extends AbstractExDBTable<BM_ChkKokutiJougenS> {

    public GenQBM_ChkKokutiJougenS() {
        this("BM_ChkKokutiJougenS");
    }

    public GenQBM_ChkKokutiJougenS(String pAlias) {
        super("BM_ChkKokutiJougenS", BM_ChkKokutiJougenS.class, pAlias);
    }

    public String BM_ChkKokutiJougenS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkKokutiJougenS, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkKokutiJougenS, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkKokutiJougenS, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkKokutiJougenS, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkKokutiJougenS, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkKokutiJougenS, Integer> moskbnfrom = new ExDBFieldNumber<>("moskbnfrom", this);

    public final ExDBFieldNumber<BM_ChkKokutiJougenS, Integer> moskbnto = new ExDBFieldNumber<>("moskbnto", this);

    public final ExDBFieldBizCurrency<BM_ChkKokutiJougenS> saikous = new ExDBFieldBizCurrency<>("saikous", this);
}
