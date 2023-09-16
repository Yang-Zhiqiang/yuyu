package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_GinkouMdhnFollowCall;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 銀行窓販フォローコール対象テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_GinkouMdhnFollowCall extends AbstractExDBTable<IT_GinkouMdhnFollowCall> {

    public GenQIT_GinkouMdhnFollowCall() {
        this("IT_GinkouMdhnFollowCall");
    }

    public GenQIT_GinkouMdhnFollowCall(String pAlias) {
        super("IT_GinkouMdhnFollowCall", IT_GinkouMdhnFollowCall.class, pAlias);
    }

    public String IT_GinkouMdhnFollowCall() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> kyksakuinmeino = new ExDBFieldString<>("kyksakuinmeino", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> followcallsyorikbn = new ExDBFieldString<>("followcallsyorikbn", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujdrtencd1 = new ExDBFieldString<>("bsyujdrtencd1", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujbosyuucd1 = new ExDBFieldString<>("bsyujbosyuucd1", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujdrtencd2 = new ExDBFieldString<>("bsyujdrtencd2", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujbosyuucd2 = new ExDBFieldString<>("bsyujbosyuucd2", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujdrtencd3 = new ExDBFieldString<>("bsyujdrtencd3", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujbosyuucd3 = new ExDBFieldString<>("bsyujbosyuucd3", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujdrtencd4 = new ExDBFieldString<>("bsyujdrtencd4", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujbosyuucd4 = new ExDBFieldString<>("bsyujbosyuucd4", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujdrtencd5 = new ExDBFieldString<>("bsyujdrtencd5", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bsyujbosyuucd5 = new ExDBFieldString<>("bsyujbosyuucd5", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> saisindrtencd = new ExDBFieldString<>("saisindrtencd", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> saisinbosyuucd = new ExDBFieldString<>("saisinbosyuucd", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> syouhnnm = new ExDBFieldString<>("syouhnnm", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<IT_GinkouMdhnFollowCall> annaigk = new ExDBFieldBizCurrency<>("annaigk", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> fchrkkaisuu = new ExDBFieldString<>("fchrkkaisuu", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> anniskcd = new ExDBFieldString<>("anniskcd", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, BizDateYM> minyuym = new ExDBFieldString<>("minyuym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> kyknmhnykkbn = new ExDBFieldString<>("kyknmhnykkbn", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> hhknnmhnykkbn = new ExDBFieldString<>("hhknnmhnykkbn", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_GinkouMdhnFollowCall, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
