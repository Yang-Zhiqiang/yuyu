package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KhSyuunouKekkaData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 収納結果データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhSyuunouKekkaData extends AbstractExDBTable<IT_KhSyuunouKekkaData> {

    public GenQIT_KhSyuunouKekkaData() {
        this("IT_KhSyuunouKekkaData");
    }

    public GenQIT_KhSyuunouKekkaData(String pAlias) {
        super("IT_KhSyuunouKekkaData", IT_KhSyuunouKekkaData.class, pAlias);
    }

    public String IT_KhSyuunouKekkaData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, BizDate> hurikaeymd = new ExDBFieldString<>("hurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<IT_KhSyuunouKekkaData> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldNumber<IT_KhSyuunouKekkaData, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_KhSyuunouKekkaData, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> dantaikobetukbn = new ExDBFieldString<>("dantaikobetukbn", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> kzhurikaetkbtannaihyj = new ExDBFieldString<>("kzhurikaetkbtannaihyj", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhSyuunouKekkaData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
