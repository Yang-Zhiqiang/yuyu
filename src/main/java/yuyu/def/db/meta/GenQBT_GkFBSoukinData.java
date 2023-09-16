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
import yuyu.def.db.entity.BT_GkFBSoukinData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Gkgyoumucd;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Tantositucd;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 外貨ＦＢ送金データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_GkFBSoukinData extends AbstractExDBTable<BT_GkFBSoukinData> {

    public GenQBT_GkFBSoukinData() {
        this("BT_GkFBSoukinData");
    }

    public GenQBT_GkFBSoukinData(String pAlias) {
        super("BT_GkFBSoukinData", BT_GkFBSoukinData.class, pAlias);
    }

    public String BT_GkFBSoukinData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_GkFBSoukinData, String> fbsoukindatasikibetukey = new ExDBFieldString<>("fbsoukindatasikibetukey", this);

    public final ExDBFieldString<BT_GkFBSoukinData, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<BT_GkFBSoukinData, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<BT_GkFBSoukinData, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<BT_GkFBSoukinData, C_Gkgyoumucd> gkgyoumucd = new ExDBFieldString<>("gkgyoumucd", this, UserType_C_Gkgyoumucd.class);

    public final ExDBFieldString<BT_GkFBSoukinData, C_Tantositucd> tantositucd = new ExDBFieldString<>("tantositucd", this, UserType_C_Tantositucd.class);

    public final ExDBFieldString<BT_GkFBSoukinData, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<BT_GkFBSoukinData, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<BT_GkFBSoukinData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_GkFBSoukinData, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<BT_GkFBSoukinData, String> keirisyono = new ExDBFieldString<>("keirisyono", this);

    public final ExDBFieldString<BT_GkFBSoukinData, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<BT_GkFBSoukinData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<BT_GkFBSoukinData, String> banknmej = new ExDBFieldString<>("banknmej", this);

    public final ExDBFieldString<BT_GkFBSoukinData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<BT_GkFBSoukinData, String> sitennmej = new ExDBFieldString<>("sitennmej", this);

    public final ExDBFieldString<BT_GkFBSoukinData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<BT_GkFBSoukinData, String> kzmeiginmei = new ExDBFieldString<>("kzmeiginmei", this);

    public final ExDBFieldString<BT_GkFBSoukinData, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_GkFBSoukinData> gaikashrgk = new ExDBFieldBizCurrency<>("gaikashrgk", this);

    public final ExDBFieldString<BT_GkFBSoukinData, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_GkFBSoukinData> crossrateshrgk = new ExDBFieldBizCurrency<>("crossrateshrgk", this);

    public final ExDBFieldString<BT_GkFBSoukinData, BizNumber> soukinkwsrate = new ExDBFieldString<>("soukinkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<BT_GkFBSoukinData, String> irninnmei = new ExDBFieldString<>("irninnmei", this);
}
