package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_SyuyakukyohiKbn;
import yuyu.def.classification.C_TratkidrtenKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_SkKouzahuriAnnaiData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_SyuyakukyohiKbn;
import yuyu.def.db.type.UserType_C_TratkidrtenKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 新契約口座振替案内データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkKouzahuriAnnaiData extends AbstractExDBTable<HT_SkKouzahuriAnnaiData> {

    public GenQHT_SkKouzahuriAnnaiData() {
        this("HT_SkKouzahuriAnnaiData");
    }

    public GenQHT_SkKouzahuriAnnaiData(String pAlias) {
        super("HT_SkKouzahuriAnnaiData", HT_SkKouzahuriAnnaiData.class, pAlias);
    }

    public String HT_SkKouzahuriAnnaiData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<HT_SkKouzahuriAnnaiData, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<HT_SkKouzahuriAnnaiData, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<HT_SkKouzahuriAnnaiData> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, BizDate> hurikaeymd = new ExDBFieldString<>("hurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, C_SinkeizkKbn> sinkeizkkbn = new ExDBFieldString<>("sinkeizkkbn", this, UserType_C_SinkeizkKbn.class);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, C_SyuyakukyohiKbn> syuyakukyohikbn = new ExDBFieldString<>("syuyakukyohikbn", this, UserType_C_SyuyakukyohiKbn.class);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> daimosno = new ExDBFieldString<>("daimosno", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> hknsyuruicd = new ExDBFieldString<>("hknsyuruicd", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> hknkaisyacd = new ExDBFieldString<>("hknkaisyacd", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, C_TratkidrtenKbn> tratkidrtenkbn = new ExDBFieldString<>("tratkidrtenkbn", this, UserType_C_TratkidrtenKbn.class);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkKouzahuriAnnaiData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
