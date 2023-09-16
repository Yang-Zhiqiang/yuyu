package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSaiteiP;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 最低Ｐチェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkSaiteiP extends AbstractExDBTable<BM_ChkSaiteiP> {

    public GenQBM_ChkSaiteiP() {
        this("BM_ChkSaiteiP");
    }

    public GenQBM_ChkSaiteiP(String pAlias) {
        super("BM_ChkSaiteiP", BM_ChkSaiteiP.class, pAlias);
    }

    public String BM_ChkSaiteiP() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkSaiteiP, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_ChkSaiteiP, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<BM_ChkSaiteiP, BizNumber> hrkkknfrom = new ExDBFieldString<>("hrkkknfrom", this, BizNumberType.class);

    public final ExDBFieldString<BM_ChkSaiteiP, BizNumber> hrkkknto = new ExDBFieldString<>("hrkkknto", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_ChkSaiteiP, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkSaiteiP, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkSaiteiP, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<BM_ChkSaiteiP, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_ChkSaiteiP, String> syouhinbetukey1 = new ExDBFieldString<>("syouhinbetukey1", this);

    public final ExDBFieldBizCurrency<BM_ChkSaiteiP> saiteip = new ExDBFieldBizCurrency<>("saiteip", this);

    public final ExDBFieldBizCurrency<BM_ChkSaiteiP> ptani = new ExDBFieldBizCurrency<>("ptani", this);
}
