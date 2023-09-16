package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KhKouzahuriAnnaiData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 口座振替案内データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhKouzahuriAnnaiData extends AbstractExDBTable<IT_KhKouzahuriAnnaiData> {

    public GenQIT_KhKouzahuriAnnaiData() {
        this("IT_KhKouzahuriAnnaiData");
    }

    public GenQIT_KhKouzahuriAnnaiData(String pAlias) {
        super("IT_KhKouzahuriAnnaiData", IT_KhKouzahuriAnnaiData.class, pAlias);
    }

    public String IT_KhKouzahuriAnnaiData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_KhKouzahuriAnnaiData, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_KhKouzahuriAnnaiData, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<IT_KhKouzahuriAnnaiData> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, BizDate> hurikaeymd = new ExDBFieldString<>("hurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, C_SinkeizkKbn> sinkeizkkbn = new ExDBFieldString<>("sinkeizkkbn", this, UserType_C_SinkeizkKbn.class);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> dantaikobetukbn = new ExDBFieldString<>("dantaikobetukbn", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> kzhurikaetkbtannaihyj = new ExDBFieldString<>("kzhurikaetkbtannaihyj", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhKouzahuriAnnaiData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
