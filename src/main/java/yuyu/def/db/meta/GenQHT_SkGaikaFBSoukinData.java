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
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Gkgyoumucd;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Tantositucd;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 新契約外貨ＦＢ送金データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkGaikaFBSoukinData extends AbstractExDBTable<HT_SkGaikaFBSoukinData> {

    public GenQHT_SkGaikaFBSoukinData() {
        this("HT_SkGaikaFBSoukinData");
    }

    public GenQHT_SkGaikaFBSoukinData(String pAlias) {
        super("HT_SkGaikaFBSoukinData", HT_SkGaikaFBSoukinData.class, pAlias);
    }

    public String HT_SkGaikaFBSoukinData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> fbsoukindatasikibetukey = new ExDBFieldString<>("fbsoukindatasikibetukey", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<HT_SkGaikaFBSoukinData, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, C_Gkgyoumucd> gkgyoumucd = new ExDBFieldString<>("gkgyoumucd", this, UserType_C_Gkgyoumucd.class);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, C_Tantositucd> tantositucd = new ExDBFieldString<>("tantositucd", this, UserType_C_Tantositucd.class);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> banknmej = new ExDBFieldString<>("banknmej", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> sitennmej = new ExDBFieldString<>("sitennmej", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> kzmeiginmei = new ExDBFieldString<>("kzmeiginmei", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<HT_SkGaikaFBSoukinData> gaikashrgk = new ExDBFieldBizCurrency<>("gaikashrgk", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<HT_SkGaikaFBSoukinData> crossrateshrgk = new ExDBFieldBizCurrency<>("crossrateshrgk", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, BizNumber> soukinkwsrate = new ExDBFieldString<>("soukinkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> irninnmei = new ExDBFieldString<>("irninnmei", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkGaikaFBSoukinData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
