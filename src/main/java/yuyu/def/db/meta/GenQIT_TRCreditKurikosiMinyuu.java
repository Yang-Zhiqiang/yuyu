package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_TRCreditKurikosiMinyuu;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * クレカ繰越未入ＴＲテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_TRCreditKurikosiMinyuu extends AbstractExDBTable<IT_TRCreditKurikosiMinyuu> {

    public GenQIT_TRCreditKurikosiMinyuu() {
        this("IT_TRCreditKurikosiMinyuu");
    }

    public GenQIT_TRCreditKurikosiMinyuu(String pAlias) {
        super("IT_TRCreditKurikosiMinyuu", IT_TRCreditKurikosiMinyuu.class, pAlias);
    }

    public String IT_TRCreditKurikosiMinyuu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> minyuutrrenno = new ExDBFieldString<>("minyuutrrenno", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_TRCreditKurikosiMinyuu, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_TRCreditKurikosiMinyuu, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<IT_TRCreditKurikosiMinyuu> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> dantaikobetukbn = new ExDBFieldString<>("dantaikobetukbn", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> kzhurikaetkbtannaihyj = new ExDBFieldString<>("kzhurikaetkbtannaihyj", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, C_CreditUriageNgJiyuuKbn> credituriagengjiyuu = new ExDBFieldString<>("credituriagengjiyuu", this, UserType_C_CreditUriageNgJiyuuKbn.class);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_TRCreditKurikosiMinyuu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
