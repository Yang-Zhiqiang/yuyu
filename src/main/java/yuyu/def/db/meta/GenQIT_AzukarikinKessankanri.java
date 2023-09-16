package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AzukarijikiKbn;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AzukarijikiKbn;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;

/**
 * 預り金決算管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_AzukarikinKessankanri extends AbstractExDBTable<IT_AzukarikinKessankanri> {

    public GenQIT_AzukarikinKessankanri() {
        this("IT_AzukarikinKessankanri");
    }

    public GenQIT_AzukarikinKessankanri(String pAlias) {
        super("IT_AzukarikinKessankanri", IT_AzukarikinKessankanri.class, pAlias);
    }

    public String IT_AzukarikinKessankanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_AzukarikinKessankanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> kessankijyunymd = new ExDBFieldString<>("kessankijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, C_YuukousyoumetuKbn> yuukousyoumetukbn = new ExDBFieldString<>("yuukousyoumetukbn", this, UserType_C_YuukousyoumetuKbn.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> azukarikinhsiymd = new ExDBFieldString<>("azukarikinhsiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> azukarigankin = new ExDBFieldBizCurrency<>("azukarigankin", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, C_AzukarijikiKbn> azukarijikikbn = new ExDBFieldString<>("azukarijikikbn", this, UserType_C_AzukarijikiKbn.class);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> azukariganrikin = new ExDBFieldBizCurrency<>("azukariganrikin", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> tounendgankin = new ExDBFieldBizCurrency<>("tounendgankin", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> tounendrsk = new ExDBFieldBizCurrency<>("tounendrsk", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> kwsratekjymd = new ExDBFieldString<>("kwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizNumber> kawaserate = new ExDBFieldString<>("kawaserate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> gaikaazukariganrikin = new ExDBFieldBizCurrency<>("gaikaazukariganrikin", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> gaikatounendgankin = new ExDBFieldBizCurrency<>("gaikatounendgankin", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> gaikatounendrsk = new ExDBFieldBizCurrency<>("gaikatounendrsk", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> gaikashrkwsratekjnymd = new ExDBFieldString<>("gaikashrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizNumber> gaikashrkwsrate = new ExDBFieldString<>("gaikashrkwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> gaikaknsnmaeazukariganrikin = new ExDBFieldBizCurrency<>("gaikaknsnmaeazukariganrikin", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> gaikaknsnmaetounendgankin = new ExDBFieldBizCurrency<>("gaikaknsnmaetounendgankin", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> gaikaknsnmaetounendrsk = new ExDBFieldBizCurrency<>("gaikaknsnmaetounendrsk", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> azukarikinshrgk = new ExDBFieldBizCurrency<>("azukarikinshrgk", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> azukarikinshrrskgk = new ExDBFieldBizCurrency<>("azukarikinshrrskgk", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> tounendsyoumetuukemishrgk = new ExDBFieldBizCurrency<>("tounendsyoumetuukemishrgk", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> sinbikinkeirskgk = new ExDBFieldBizCurrency<>("sinbikinkeirskgk", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, C_BknJkuKbn> bknjkukbn = new ExDBFieldString<>("bknjkukbn", this, UserType_C_BknJkuKbn.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> bikinkeiymd = new ExDBFieldString<>("bikinkeiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, C_BkncdKbn> bkncdkbn = new ExDBFieldString<>("bkncdkbn", this, UserType_C_BkncdKbn.class);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> tounendrsksyukeisitu = new ExDBFieldBizCurrency<>("tounendrsksyukeisitu", this);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> zennendrsksyukeisitu = new ExDBFieldBizCurrency<>("zennendrsksyukeisitu", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> kwsratekjymd1q = new ExDBFieldString<>("kwsratekjymd1q", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizNumber> kawaserate1q = new ExDBFieldString<>("kawaserate1q", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> azukarikinrsk1q = new ExDBFieldBizCurrency<>("azukarikinrsk1q", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> kwsratekjymd2q = new ExDBFieldString<>("kwsratekjymd2q", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizNumber> kawaserate2q = new ExDBFieldString<>("kawaserate2q", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> azukarikinrsk2q = new ExDBFieldBizCurrency<>("azukarikinrsk2q", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> kwsratekjymd3q = new ExDBFieldString<>("kwsratekjymd3q", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizNumber> kawaserate3q = new ExDBFieldString<>("kawaserate3q", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> azukarikinrsk3q = new ExDBFieldBizCurrency<>("azukarikinrsk3q", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizDate> kwsratekjymd4q = new ExDBFieldString<>("kwsratekjymd4q", this, BizDateType.class);

    public final ExDBFieldString<IT_AzukarikinKessankanri, BizNumber> kawaserate4q = new ExDBFieldString<>("kawaserate4q", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_AzukarikinKessankanri> azukarikinrsk4q = new ExDBFieldBizCurrency<>("azukarikinrsk4q", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_AzukarikinKessankanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
