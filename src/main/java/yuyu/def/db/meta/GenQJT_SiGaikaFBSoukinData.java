package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Gkgyoumucd;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Tantositucd;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 支払外貨ＦＢ送金データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiGaikaFBSoukinData extends AbstractExDBTable<JT_SiGaikaFBSoukinData> {

    public GenQJT_SiGaikaFBSoukinData() {
        this("JT_SiGaikaFBSoukinData");
    }

    public GenQJT_SiGaikaFBSoukinData(String pAlias) {
        super("JT_SiGaikaFBSoukinData", JT_SiGaikaFBSoukinData.class, pAlias);
    }

    public String JT_SiGaikaFBSoukinData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> fbsoukindatasikibetukey = new ExDBFieldString<>("fbsoukindatasikibetukey", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<JT_SiGaikaFBSoukinData, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, C_Gkgyoumucd> gkgyoumucd = new ExDBFieldString<>("gkgyoumucd", this, UserType_C_Gkgyoumucd.class);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, C_Tantositucd> tantositucd = new ExDBFieldString<>("tantositucd", this, UserType_C_Tantositucd.class);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> banknmej = new ExDBFieldString<>("banknmej", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> sitennmej = new ExDBFieldString<>("sitennmej", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> kzmeiginmei = new ExDBFieldString<>("kzmeiginmei", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<JT_SiGaikaFBSoukinData> gaikashrgk = new ExDBFieldBizCurrency<>("gaikashrgk", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<JT_SiGaikaFBSoukinData> crossrateshrgk = new ExDBFieldBizCurrency<>("crossrateshrgk", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, BizNumber> soukinkwsrate = new ExDBFieldString<>("soukinkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> irninnmei = new ExDBFieldString<>("irninnmei", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiGaikaFBSoukinData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
