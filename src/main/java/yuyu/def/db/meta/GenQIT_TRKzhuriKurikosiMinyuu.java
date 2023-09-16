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
import yuyu.def.db.entity.IT_TRKzhuriKurikosiMinyuu;
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
 * 口座振替繰越未入ＴＲテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_TRKzhuriKurikosiMinyuu extends AbstractExDBTable<IT_TRKzhuriKurikosiMinyuu> {

    public GenQIT_TRKzhuriKurikosiMinyuu() {
        this("IT_TRKzhuriKurikosiMinyuu");
    }

    public GenQIT_TRKzhuriKurikosiMinyuu(String pAlias) {
        super("IT_TRKzhuriKurikosiMinyuu", IT_TRKzhuriKurikosiMinyuu.class, pAlias);
    }

    public String IT_TRKzhuriKurikosiMinyuu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> minyuutrrenno = new ExDBFieldString<>("minyuutrrenno", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_TRKzhuriKurikosiMinyuu, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_TRKzhuriKurikosiMinyuu, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<IT_TRKzhuriKurikosiMinyuu> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> dantaikobetukbn = new ExDBFieldString<>("dantaikobetukbn", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> kzhurikaetkbtannaihyj = new ExDBFieldString<>("kzhurikaetkbtannaihyj", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, C_CreditUriageNgJiyuuKbn> credituriagengjiyuu = new ExDBFieldString<>("credituriagengjiyuu", this, UserType_C_CreditUriageNgJiyuuKbn.class);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_TRKzhuriKurikosiMinyuu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
