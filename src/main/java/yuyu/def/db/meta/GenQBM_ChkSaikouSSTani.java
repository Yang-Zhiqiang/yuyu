package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSaikouSSTani;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 最高ＳＳ単位チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkSaikouSSTani extends AbstractExDBTable<BM_ChkSaikouSSTani> {

    public GenQBM_ChkSaikouSSTani() {
        this("BM_ChkSaikouSSTani");
    }

    public GenQBM_ChkSaikouSSTani(String pAlias) {
        super("BM_ChkSaikouSSTani", BM_ChkSaikouSSTani.class, pAlias);
    }

    public String BM_ChkSaikouSSTani() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkSaikouSSTani, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkSaikouSSTani, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkSaikouSSTani, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkSaikouSSTani, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkSaikouSSTani, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkSaikouSSTani, Integer> moskbnfrom = new ExDBFieldNumber<>("moskbnfrom", this);

    public final ExDBFieldNumber<BM_ChkSaikouSSTani, Integer> moskbnto = new ExDBFieldNumber<>("moskbnto", this);

    public final ExDBFieldString<BM_ChkSaikouSSTani, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BM_ChkSaikouSSTani> saikous = new ExDBFieldBizCurrency<>("saikous", this);

    public final ExDBFieldBizCurrency<BM_ChkSaikouSSTani> stani = new ExDBFieldBizCurrency<>("stani", this);

    public final ExDBFieldString<BM_ChkSaikouSSTani, BizNumber> bairitu = new ExDBFieldString<>("bairitu", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkSaikouSSTani, BizNumber> bairitu2 = new ExDBFieldString<>("bairitu2", this, BizNumberType.class);
}
