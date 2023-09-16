package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_BAK_KihrkmpSeisanRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KiharaiPseisanNaiyouKbn;
import yuyu.def.db.type.UserType_C_MisyuumikeikaKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 既払込Ｐ精算履歴バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KihrkmpSeisanRireki extends AbstractExDBTable<IT_BAK_KihrkmpSeisanRireki> {

    public GenQIT_BAK_KihrkmpSeisanRireki() {
        this("IT_BAK_KihrkmpSeisanRireki");
    }

    public GenQIT_BAK_KihrkmpSeisanRireki(String pAlias) {
        super("IT_BAK_KihrkmpSeisanRireki", IT_BAK_KihrkmpSeisanRireki.class, pAlias);
    }

    public String IT_BAK_KihrkmpSeisanRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_KihrkmpSeisanRireki, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, C_KiharaiPseisanNaiyouKbn> kihrkpssnaiyoukbn = new ExDBFieldString<>("kihrkpssnaiyoukbn", this, UserType_C_KiharaiPseisanNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_BAK_KihrkmpSeisanRireki, Integer> seijyutoukaisuum = new ExDBFieldNumber<>("seijyutoukaisuum", this);

    public final ExDBFieldNumber<IT_BAK_KihrkmpSeisanRireki, Integer> seijyutoukaisuuy = new ExDBFieldNumber<>("seijyutoukaisuuy", this);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, C_MisyuumikeikaKbn> misyuumikeikakbn = new ExDBFieldString<>("misyuumikeikakbn", this, UserType_C_MisyuumikeikaKbn.class);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_KihrkmpSeisanRireki> seisanpgoukei = new ExDBFieldBizCurrency<>("seisanpgoukei", this);

    public final ExDBFieldBizCurrency<IT_BAK_KihrkmpSeisanRireki> yenkansansspgoukei = new ExDBFieldBizCurrency<>("yenkansansspgoukei", this);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, BizDate> yenkansantkykwsrateymd = new ExDBFieldString<>("yenkansantkykwsrateymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, BizNumber> yenkansantkykwsrate = new ExDBFieldString<>("yenkansantkykwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KihrkmpSeisanRireki> henkank = new ExDBFieldBizCurrency<>("henkank", this);

    public final ExDBFieldBizCurrency<IT_BAK_KihrkmpSeisanRireki> yenkansanhenkankin = new ExDBFieldBizCurrency<>("yenkansanhenkankin", this);

    public final ExDBFieldBizCurrency<IT_BAK_KihrkmpSeisanRireki> tuityouk = new ExDBFieldBizCurrency<>("tuityouk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KihrkmpSeisanRireki> yenkansantuityoukin = new ExDBFieldBizCurrency<>("yenkansantuityoukin", this);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, BizDate> zeimukwsratekjnymd = new ExDBFieldString<>("zeimukwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, BizNumber> zeimukwsrate = new ExDBFieldString<>("zeimukwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KihrkmpSeisanRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldBizCurrency<IT_BAK_KihrkmpSeisanRireki> hituyoukeihiitijisytktysgk = new ExDBFieldBizCurrency<>("hituyoukeihiitijisytktysgk", this);
}
