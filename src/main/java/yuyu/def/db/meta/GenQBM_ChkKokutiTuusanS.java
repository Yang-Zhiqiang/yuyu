package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.db.entity.BM_ChkKokutiTuusanS;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KijiKbn;

/**
 * 告知扱通算限度Ｓチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkKokutiTuusanS extends AbstractExDBTable<BM_ChkKokutiTuusanS> {

    public GenQBM_ChkKokutiTuusanS() {
        this("BM_ChkKokutiTuusanS");
    }

    public GenQBM_ChkKokutiTuusanS(String pAlias) {
        super("BM_ChkKokutiTuusanS", BM_ChkKokutiTuusanS.class, pAlias);
    }

    public String BM_ChkKokutiTuusanS() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkKokutiTuusanS, BizNumber> hhknfromnen = new ExDBFieldString<>("hhknfromnen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkKokutiTuusanS, BizNumber> hhkntonen = new ExDBFieldString<>("hhkntonen", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkKokutiTuusanS, C_KijiKbn> kijikbn = new ExDBFieldString<>("kijikbn", this, UserType_C_KijiKbn.class);

    public final ExDBFieldNumber<BM_ChkKokutiTuusanS, Integer> iktkktkbnfrom = new ExDBFieldNumber<>("iktkktkbnfrom", this);

    public final ExDBFieldNumber<BM_ChkKokutiTuusanS, Integer> iktkktkbnto = new ExDBFieldNumber<>("iktkktkbnto", this);

    public final ExDBFieldBizCurrency<BM_ChkKokutiTuusanS> gnds1 = new ExDBFieldBizCurrency<>("gnds1", this);

    public final ExDBFieldBizCurrency<BM_ChkKokutiTuusanS> gnds2 = new ExDBFieldBizCurrency<>("gnds2", this);

    public final ExDBFieldBizCurrency<BM_ChkKokutiTuusanS> gnds3 = new ExDBFieldBizCurrency<>("gnds3", this);
}
