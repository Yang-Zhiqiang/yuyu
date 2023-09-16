package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_DrtenMinyuKykTaisyo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 代理店未入契約明細対象テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_DrtenMinyuKykTaisyo extends AbstractExDBTable<IT_DrtenMinyuKykTaisyo> {

    public GenQIT_DrtenMinyuKykTaisyo() {
        this("IT_DrtenMinyuKykTaisyo");
    }

    public GenQIT_DrtenMinyuKykTaisyo(String pAlias) {
        super("IT_DrtenMinyuKykTaisyo", IT_DrtenMinyuKykTaisyo.class, pAlias);
    }

    public String IT_DrtenMinyuKykTaisyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> minyuutrrenno = new ExDBFieldString<>("minyuutrrenno", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_DrtenMinyuKykTaisyo, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_DrtenMinyuKykTaisyo, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<IT_DrtenMinyuKykTaisyo> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> dantaikobetukbn = new ExDBFieldString<>("dantaikobetukbn", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> kzhurikaetkbtannaihyj = new ExDBFieldString<>("kzhurikaetkbtannaihyj", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<IT_DrtenMinyuKykTaisyo> jkiannaikg = new ExDBFieldBizCurrency<>("jkiannaikg", this);

    public final ExDBFieldNumber<IT_DrtenMinyuKykTaisyo, Integer> jkijyutoukaisuuy = new ExDBFieldNumber<>("jkijyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_DrtenMinyuKykTaisyo, Integer> jkijyutoukaisuum = new ExDBFieldNumber<>("jkijyutoukaisuum", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_DrtenMinyuKykTaisyo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
