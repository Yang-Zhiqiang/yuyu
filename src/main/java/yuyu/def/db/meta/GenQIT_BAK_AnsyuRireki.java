package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_SyuyakukyohiKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_BAK_AnsyuRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AnnaijkKbn;
import yuyu.def.db.type.UserType_C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Skszumiflg;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_SyuyakukyohiKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 案内収納履歴バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_AnsyuRireki extends AbstractExDBTable<IT_BAK_AnsyuRireki> {

    public GenQIT_BAK_AnsyuRireki() {
        this("IT_BAK_AnsyuRireki");
    }

    public GenQIT_BAK_AnsyuRireki(String pAlias) {
        super("IT_BAK_AnsyuRireki", IT_BAK_AnsyuRireki.class, pAlias);
    }

    public String IT_BAK_AnsyuRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_BAK_AnsyuRireki, Integer> annaino = new ExDBFieldNumber<>("annaino", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldNumber<IT_BAK_AnsyuRireki, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_BAK_AnsyuRireki, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<IT_BAK_AnsyuRireki> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> ryosyukwsratekjymd = new ExDBFieldString<>("ryosyukwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizNumber> ryosyukwsrate = new ExDBFieldString<>("ryosyukwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_AnsyuRireki> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldBizCurrency<IT_BAK_AnsyuRireki> iktwaribikikgk = new ExDBFieldBizCurrency<>("iktwaribikikgk", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_AnnaijkKbn> annaijkkbn = new ExDBFieldString<>("annaijkkbn", this, UserType_C_AnnaijkKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> annaisakuseiymd = new ExDBFieldString<>("annaisakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> minyusyoriymd = new ExDBFieldString<>("minyusyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> dattaiuktkymd = new ExDBFieldString<>("dattaiuktkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> hurikaeymd = new ExDBFieldString<>("hurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> uriageymdkon = new ExDBFieldString<>("uriageymdkon", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_UmuKbn> krkkeijyoflg = new ExDBFieldString<>("krkkeijyoflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> krkkeijyoymd = new ExDBFieldString<>("krkkeijyoymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_AnsyuRireki, Integer> krkno = new ExDBFieldNumber<>("krkno", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_SinkeizkKbn> sinkeizkkbn = new ExDBFieldString<>("sinkeizkkbn", this, UserType_C_SinkeizkKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_SyuyakukyohiKbn> syuyakukyohikbn = new ExDBFieldString<>("syuyakukyohikbn", this, UserType_C_SyuyakukyohiKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> cardkaisyacd = new ExDBFieldString<>("cardkaisyacd", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> yukoukachkymd = new ExDBFieldString<>("yukoukachkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> authorikanryoymd = new ExDBFieldString<>("authorikanryoymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> uriageymdzen = new ExDBFieldString<>("uriageymdzen", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, BizDate> hrkkigen = new ExDBFieldString<>("hrkkigen", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_Skszumiflg> minyutuutizumiflg = new ExDBFieldString<>("minyutuutizumiflg", this, UserType_C_Skszumiflg.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, C_CreditUriageNgJiyuuKbn> credituriagengjiyuu = new ExDBFieldString<>("credituriagengjiyuu", this, UserType_C_CreditUriageNgJiyuuKbn.class);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_AnsyuRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
