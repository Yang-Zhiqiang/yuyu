package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.db.entity.BM_ChkJhKokutiTuusanS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KijiKbn;

/**
 * 告知扱通算限度Ｓ事方書チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkJhKokutiTuusanS extends AbstractExDBTable<BM_ChkJhKokutiTuusanS> {

    public GenQBM_ChkJhKokutiTuusanS() {
        this("BM_ChkJhKokutiTuusanS");
    }

    public GenQBM_ChkJhKokutiTuusanS(String pAlias) {
        super("BM_ChkJhKokutiTuusanS", BM_ChkJhKokutiTuusanS.class, pAlias);
    }

    public String BM_ChkJhKokutiTuusanS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkJhKokutiTuusanS, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhKokutiTuusanS, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhKokutiTuusanS, C_KijiKbn> kijikbn = new ExDBFieldString<>("kijikbn", this, UserType_C_KijiKbn.class);

    public final ExDBFieldNumber<BM_ChkJhKokutiTuusanS, Integer> iktkktkbnfrom = new ExDBFieldNumber<>("iktkktkbnfrom", this);

    public final ExDBFieldNumber<BM_ChkJhKokutiTuusanS, Integer> iktkktkbnto = new ExDBFieldNumber<>("iktkktkbnto", this);

    public final ExDBFieldBizCurrency<BM_ChkJhKokutiTuusanS> gnds1 = new ExDBFieldBizCurrency<>("gnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkJhKokutiTuusanS> gnds2 = new ExDBFieldBizCurrency<>("gnds2", this);

    public final ExDBFieldBizCurrency<BM_ChkJhKokutiTuusanS> gnds3 = new ExDBFieldBizCurrency<>("gnds3", this);
}
