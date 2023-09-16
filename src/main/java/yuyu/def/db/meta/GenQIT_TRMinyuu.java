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
import yuyu.def.db.entity.IT_TRMinyuu;
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
 * 未入ＴＲテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_TRMinyuu extends AbstractExDBTable<IT_TRMinyuu> {

    public GenQIT_TRMinyuu() {
        this("IT_TRMinyuu");
    }

    public GenQIT_TRMinyuu(String pAlias) {
        super("IT_TRMinyuu", IT_TRMinyuu.class, pAlias);
    }

    public String IT_TRMinyuu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_TRMinyuu, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_TRMinyuu, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_TRMinyuu, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRMinyuu, String> minyuutrrenno = new ExDBFieldString<>("minyuutrrenno", this);

    public final ExDBFieldString<IT_TRMinyuu, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_TRMinyuu, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_TRMinyuu, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_TRMinyuu, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_TRMinyuu, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<IT_TRMinyuu> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_TRMinyuu, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_TRMinyuu, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_TRMinyuu, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_TRMinyuu, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_TRMinyuu, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_TRMinyuu, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_TRMinyuu, String> dantaikobetukbn = new ExDBFieldString<>("dantaikobetukbn", this);

    public final ExDBFieldString<IT_TRMinyuu, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_TRMinyuu, String> kzhurikaetkbtannaihyj = new ExDBFieldString<>("kzhurikaetkbtannaihyj", this);

    public final ExDBFieldString<IT_TRMinyuu, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_TRMinyuu, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_TRMinyuu, C_CreditUriageNgJiyuuKbn> credituriagengjiyuu = new ExDBFieldString<>("credituriagengjiyuu", this, UserType_C_CreditUriageNgJiyuuKbn.class);

    public final ExDBFieldString<IT_TRMinyuu, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_TRMinyuu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_TRMinyuu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
