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
import yuyu.def.db.entity.IT_BAK_KhGaikaFBSoukinData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Gkgyoumucd;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Tantositucd;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 契約保全外貨ＦＢ送金データバックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhGaikaFBSoukinData extends AbstractExDBTable<IT_BAK_KhGaikaFBSoukinData> {

    public GenQIT_BAK_KhGaikaFBSoukinData() {
        this("IT_BAK_KhGaikaFBSoukinData");
    }

    public GenQIT_BAK_KhGaikaFBSoukinData(String pAlias) {
        super("IT_BAK_KhGaikaFBSoukinData", IT_BAK_KhGaikaFBSoukinData.class, pAlias);
    }

    public String IT_BAK_KhGaikaFBSoukinData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> fbsoukindatasikibetukey = new ExDBFieldString<>("fbsoukindatasikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<IT_BAK_KhGaikaFBSoukinData, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, C_Gkgyoumucd> gkgyoumucd = new ExDBFieldString<>("gkgyoumucd", this, UserType_C_Gkgyoumucd.class);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, C_Tantositucd> tantositucd = new ExDBFieldString<>("tantositucd", this, UserType_C_Tantositucd.class);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> banknmej = new ExDBFieldString<>("banknmej", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> sitennmej = new ExDBFieldString<>("sitennmej", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> kzmeiginmei = new ExDBFieldString<>("kzmeiginmei", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhGaikaFBSoukinData> gaikashrgk = new ExDBFieldBizCurrency<>("gaikashrgk", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhGaikaFBSoukinData> crossrateshrgk = new ExDBFieldBizCurrency<>("crossrateshrgk", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, BizNumber> soukinkwsrate = new ExDBFieldString<>("soukinkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> irninnmei = new ExDBFieldString<>("irninnmei", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhGaikaFBSoukinData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
