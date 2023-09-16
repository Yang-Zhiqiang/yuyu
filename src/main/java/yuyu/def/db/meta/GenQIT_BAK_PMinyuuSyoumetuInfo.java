package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_JidousoukinHukaRiyuuKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_BAK_PMinyuuSyoumetuInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_JidousoukinHukaRiyuuKbn;
import yuyu.def.db.type.UserType_C_StknsetKbn;
import yuyu.def.db.type.UserType_C_SyorikahiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * Ｐ未入消滅情報バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_PMinyuuSyoumetuInfo extends AbstractExDBTable<IT_BAK_PMinyuuSyoumetuInfo> {

    public GenQIT_BAK_PMinyuuSyoumetuInfo() {
        this("IT_BAK_PMinyuuSyoumetuInfo");
    }

    public GenQIT_BAK_PMinyuuSyoumetuInfo(String pAlias) {
        super("IT_BAK_PMinyuuSyoumetuInfo", IT_BAK_PMinyuuSyoumetuInfo.class, pAlias);
    }

    public String IT_BAK_PMinyuuSyoumetuInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, BizDateYM> syoriym = new ExDBFieldString<>("syoriym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, C_JidousoukinHukaRiyuuKbn> jidousoukinhukariyuu = new ExDBFieldString<>("jidousoukinhukariyuu", this, UserType_C_JidousoukinHukaRiyuuKbn.class);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, C_SyorikahiKbn> ttdktyuuihanteikekka = new ExDBFieldString<>("ttdktyuuihanteikekka", this, UserType_C_SyorikahiKbn.class);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, C_StknsetKbn> stknsetkbn = new ExDBFieldString<>("stknsetkbn", this, UserType_C_StknsetKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> shrgkkei = new ExDBFieldBizCurrency<>("shrgkkei", this);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> shrtuukakaiyakuhrkngkkei = new ExDBFieldBizCurrency<>("shrtuukakaiyakuhrkngkkei", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> kaiyakuhrkngkkeisiteituuka = new ExDBFieldBizCurrency<>("kaiyakuhrkngkkeisiteituuka", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> sonotaseisan = new ExDBFieldBizCurrency<>("sonotaseisan", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> yenkansanhaitoukin = new ExDBFieldBizCurrency<>("yenkansanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> yensonotahaitoukin = new ExDBFieldBizCurrency<>("yensonotahaitoukin", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> shrtuukagstszeigk = new ExDBFieldBizCurrency<>("shrtuukagstszeigk", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> zitkazukarikingksiteituuka = new ExDBFieldBizCurrency<>("zitkazukarikingksiteituuka", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> zitkazukarikingkyen = new ExDBFieldBizCurrency<>("zitkazukarikingkyen", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> kaiyakuhrknsiteituuka = new ExDBFieldBizCurrency<>("kaiyakuhrknsiteituuka", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> kaiyakuhryen = new ExDBFieldBizCurrency<>("kaiyakuhryen", this);

    public final ExDBFieldBizCurrency<IT_BAK_PMinyuuSyoumetuInfo> yenkrkgk = new ExDBFieldBizCurrency<>("yenkrkgk", this);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_PMinyuuSyoumetuInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
