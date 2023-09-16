package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.JT_SiKekka;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HushrGeninKbn;
import yuyu.def.db.type.UserType_C_MisyuumikeikaKbn;
import yuyu.def.db.type.UserType_C_ShiharaikekkadataKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 支払処理結果テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiKekka extends AbstractExDBTable<JT_SiKekka> {

    public GenQJT_SiKekka() {
        this("JT_SiKekka");
    }

    public GenQJT_SiKekka(String pAlias) {
        super("JT_SiKekka", JT_SiKekka.class, pAlias);
    }

    public String JT_SiKekka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiKekka, C_ShiharaikekkadataKbn> shiharaikekkadatakbn = new ExDBFieldString<>("shiharaikekkadatakbn", this, UserType_C_ShiharaikekkadataKbn.class);

    public final ExDBFieldString<JT_SiKekka, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiKekka, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<JT_SiKekka, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<JT_SiKekka, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<JT_SiKekka, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<JT_SiKekka, BizDateYM> nexthrkym = new ExDBFieldString<>("nexthrkym", this, BizDateYMType.class);

    public final ExDBFieldString<JT_SiKekka, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKekka, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<JT_SiKekka, String> gansindankakuteiymd = new ExDBFieldString<>("gansindankakuteiymd", this);

    public final ExDBFieldBizCurrency<JT_SiKekka> krkgk = new ExDBFieldBizCurrency<>("krkgk", this);

    public final ExDBFieldString<JT_SiKekka, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKekka, C_MisyuumikeikaKbn> misyuumikeikakbn = new ExDBFieldString<>("misyuumikeikakbn", this, UserType_C_MisyuumikeikaKbn.class);

    public final ExDBFieldString<JT_SiKekka, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<JT_SiKekka, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<JT_SiKekka, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<JT_SiKekka> seisanpgoukei = new ExDBFieldBizCurrency<>("seisanpgoukei", this);

    public final ExDBFieldString<JT_SiKekka, C_HushrGeninKbn> hushrgeninkbn = new ExDBFieldString<>("hushrgeninkbn", this, UserType_C_HushrGeninKbn.class);

    public final ExDBFieldString<JT_SiKekka, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<JT_SiKekka> zennouseisankgk = new ExDBFieldBizCurrency<>("zennouseisankgk", this);

    public final ExDBFieldBizCurrency<JT_SiKekka> zennouseisankgkshrtk = new ExDBFieldBizCurrency<>("zennouseisankgkshrtk", this);

    public final ExDBFieldBizCurrency<JT_SiKekka> zitkazukarikingksiteituuka = new ExDBFieldBizCurrency<>("zitkazukarikingksiteituuka", this);

    public final ExDBFieldBizCurrency<JT_SiKekka> zitkazukarikingkyen = new ExDBFieldBizCurrency<>("zitkazukarikingkyen", this);

    public final ExDBFieldString<JT_SiKekka, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<JT_SiKekka, BizDate> shrkwsratekjnymd = new ExDBFieldString<>("shrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKekka, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiKekka, BizNumber> zeimukwsrate = new ExDBFieldString<>("zeimukwsrate", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiKekka, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SiKekka, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SiKekka, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiKekka, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
