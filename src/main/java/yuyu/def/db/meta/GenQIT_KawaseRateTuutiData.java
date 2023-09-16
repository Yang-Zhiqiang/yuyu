package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KawaseRateTuutiData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 為替レート通知データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KawaseRateTuutiData extends AbstractExDBTable<IT_KawaseRateTuutiData> {

    public GenQIT_KawaseRateTuutiData() {
        this("IT_KawaseRateTuutiData");
    }

    public GenQIT_KawaseRateTuutiData(String pAlias) {
        super("IT_KawaseRateTuutiData", IT_KawaseRateTuutiData.class, pAlias);
    }

    public String IT_KawaseRateTuutiData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_KawaseRateTuutiData, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, BizDateYM> annaiym = new ExDBFieldString<>("annaiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KawaseRateTuutiData, BizDate> kwsratekjymd = new ExDBFieldString<>("kwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KawaseRateTuutiData, BizNumber> kawaserate = new ExDBFieldString<>("kawaserate", this, BizNumberType.class);

    public final ExDBFieldString<IT_KawaseRateTuutiData, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_KawaseRateTuutiData> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldBizCurrency<IT_KawaseRateTuutiData> siteituukap = new ExDBFieldBizCurrency<>("siteituukap", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> bosyuujiaatukaidrtencd = new ExDBFieldString<>("bosyuujiaatukaidrtencd", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> bosyuujiaatukaidrtenkj = new ExDBFieldString<>("bosyuujiaatukaidrtenkj", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<IT_KawaseRateTuutiData, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KawaseRateTuutiData, C_YnkHrkmgkAnniTuutiKbn> ynkhrkmgkannituutikbn = new ExDBFieldString<>("ynkhrkmgkannituutikbn", this, UserType_C_YnkHrkmgkAnniTuutiKbn.class);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KawaseRateTuutiData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
