package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkJhSaikouSSTani;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 最高ＳＳ単位事方書チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkJhSaikouSSTani extends AbstractExDBTable<BM_ChkJhSaikouSSTani> {

    public GenQBM_ChkJhSaikouSSTani() {
        this("BM_ChkJhSaikouSSTani");
    }

    public GenQBM_ChkJhSaikouSSTani(String pAlias) {
        super("BM_ChkJhSaikouSSTani", BM_ChkJhSaikouSSTani.class, pAlias);
    }

    public String BM_ChkJhSaikouSSTani() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkJhSaikouSSTani, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkJhSaikouSSTani, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkJhSaikouSSTani, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkJhSaikouSSTani, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhSaikouSSTani, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkJhSaikouSSTani, Integer> moskbnfrom = new ExDBFieldNumber<>("moskbnfrom", this);

    public final ExDBFieldNumber<BM_ChkJhSaikouSSTani, Integer> moskbnto = new ExDBFieldNumber<>("moskbnto", this);

    public final ExDBFieldString<BM_ChkJhSaikouSSTani, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BM_ChkJhSaikouSSTani> saikous = new ExDBFieldBizCurrency<>("saikous", this);

    public final ExDBFieldBizCurrency<BM_ChkJhSaikouSSTani> stani = new ExDBFieldBizCurrency<>("stani", this);

    public final ExDBFieldString<BM_ChkJhSaikouSSTani, BizNumber> bairitu = new ExDBFieldString<>("bairitu", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhSaikouSSTani, BizNumber> bairitu2 = new ExDBFieldString<>("bairitu2", this, BizNumberType.class);
}
