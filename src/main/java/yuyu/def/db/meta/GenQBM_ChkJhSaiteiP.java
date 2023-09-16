package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkJhSaiteiP;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 最低Ｐ事方書チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkJhSaiteiP extends AbstractExDBTable<BM_ChkJhSaiteiP> {

    public GenQBM_ChkJhSaiteiP() {
        this("BM_ChkJhSaiteiP");
    }

    public GenQBM_ChkJhSaiteiP(String pAlias) {
        super("BM_ChkJhSaiteiP", BM_ChkJhSaiteiP.class, pAlias);
    }

    public String BM_ChkJhSaiteiP() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkJhSaiteiP, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_ChkJhSaiteiP, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<BM_ChkJhSaiteiP, BizNumber> hrkkknfrom = new ExDBFieldString<>("hrkkknfrom", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkJhSaiteiP, BizNumber> hrkkknto = new ExDBFieldString<>("hrkkknto", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkJhSaiteiP, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkJhSaiteiP, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkJhSaiteiP, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<BM_ChkJhSaiteiP, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_ChkJhSaiteiP, String> syouhinbetukey1 = new ExDBFieldString<>("syouhinbetukey1", this);

    public final ExDBFieldBizCurrency<BM_ChkJhSaiteiP> saiteip = new ExDBFieldBizCurrency<>("saiteip", this);

    public final ExDBFieldBizCurrency<BM_ChkJhSaiteiP> ptani = new ExDBFieldBizCurrency<>("ptani", this);
}
