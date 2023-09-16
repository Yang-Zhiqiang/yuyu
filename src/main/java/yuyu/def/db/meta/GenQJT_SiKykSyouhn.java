package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_6daiLdKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KhnkyhkgbairituKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_SyukyhkinkataKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tkjyhyouten;
import yuyu.def.db.type.UserType_C_Tkjyskgnkkn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 支払契約商品テーブル（物理テーブルなし） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiKykSyouhn extends AbstractExDBTable<JT_SiKykSyouhn> {

    public GenQJT_SiKykSyouhn() {
        this("JT_SiKykSyouhn");
    }

    public GenQJT_SiKykSyouhn(String pAlias) {
        super("JT_SiKykSyouhn", JT_SiKykSyouhn.class, pAlias);
    }

    public String JT_SiKykSyouhn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiKykSyouhn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_KyhgndkataKbn> kyhgndkatakbn = new ExDBFieldString<>("kyhgndkatakbn", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldNumber<JT_SiKykSyouhn, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<JT_SiKykSyouhn, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<JT_SiKykSyouhn, String> syouhnnm = new ExDBFieldString<>("syouhnnm", this);

    public final ExDBFieldString<JT_SiKykSyouhn, String> syouhnnmgm = new ExDBFieldString<>("syouhnnmgm", this);

    public final ExDBFieldString<JT_SiKykSyouhn, String> syouhnnmtyhy = new ExDBFieldString<>("syouhnnmtyhy", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_SyukyhkinkataKbn> syukyhkinkatakbn = new ExDBFieldString<>("syukyhkinkatakbn", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, C_KhnkyhkgbairituKbn> khnkyhkgbairitukbn = new ExDBFieldString<>("khnkyhkgbairitukbn", this, UserType_C_KhnkyhkgbairituKbn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, C_6daiLdKbn> rokudaildkbn = new ExDBFieldString<>("rokudaildkbn", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> yuukoukikanfrom = new ExDBFieldString<>("yuukoukikanfrom", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> yuukoukikanto = new ExDBFieldString<>("yuukoukikanto", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> gansknnkaisiymd = new ExDBFieldString<>("gansknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> hkgansknnkaisiymd = new ExDBFieldString<>("hkgansknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldNumber<JT_SiKykSyouhn, Integer> kykage = new ExDBFieldNumber<>("kykage", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_HknkknsmnKbn> hknkknsmnkbn = new ExDBFieldString<>("hknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldNumber<JT_SiKykSyouhn, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> hknkknmanryouymd = new ExDBFieldString<>("hknkknmanryouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, C_HrkkknsmnKbn> hrkkknsmnkbn = new ExDBFieldString<>("hrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldNumber<JT_SiKykSyouhn, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> hrkkknmnryymd = new ExDBFieldString<>("hrkkknmnryymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<JT_SiKykSyouhn> hokenryou = new ExDBFieldBizCurrency<>("hokenryou", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<JT_SiKykSyouhn, C_UmuKbn> kihonsntgkumu = new ExDBFieldString<>("kihonsntgkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<JT_SiKykSyouhn> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_KataKbn> katakbn = new ExDBFieldString<>("katakbn", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, C_Tkjyhyouten> tkjyhyouten = new ExDBFieldString<>("tkjyhyouten", this, UserType_C_Tkjyhyouten.class);

    public final ExDBFieldBizCurrency<JT_SiKykSyouhn> tkjyp = new ExDBFieldBizCurrency<>("tkjyp", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_Tkjyskgnkkn> tkjyskgnkkn = new ExDBFieldString<>("tkjyskgnkkn", this, UserType_C_Tkjyskgnkkn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, String> htnpbuicd1 = new ExDBFieldString<>("htnpbuicd1", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_Htnpkkn> htnpkkn1 = new ExDBFieldString<>("htnpkkn1", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, String> htnpbuicd2 = new ExDBFieldString<>("htnpbuicd2", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_Htnpkkn> htnpkkn2 = new ExDBFieldString<>("htnpkkn2", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, String> htnpbuicd3 = new ExDBFieldString<>("htnpbuicd3", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_Htnpkkn> htnpkkn3 = new ExDBFieldString<>("htnpkkn3", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, String> htnpbuicd4 = new ExDBFieldString<>("htnpbuicd4", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_Htnpkkn> htnpkkn4 = new ExDBFieldString<>("htnpkkn4", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, C_TokkoudosghtnpKbn> tokkoudosghtnpkbn = new ExDBFieldString<>("tokkoudosghtnpkbn", this, UserType_C_TokkoudosghtnpKbn.class);

    public final ExDBFieldString<JT_SiKykSyouhn, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<JT_SiKykSyouhn, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<JT_SiKykSyouhn, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<JT_SiKykSyouhn, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizNumber> kyksjkkktyouseiriritu = new ExDBFieldString<>("kyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizNumber> yoteirrthendohosyurrt = new ExDBFieldString<>("yoteirrthendohosyurrt", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizNumber> tumitateriritu = new ExDBFieldString<>("tumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiKykSyouhn, BizDate> tmttknitenymd = new ExDBFieldString<>("tmttknitenymd", this, BizDateType.class);

    public final ExDBFieldNumber<JT_SiKykSyouhn, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldString<JT_SiKykSyouhn, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SiKykSyouhn, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SiKykSyouhn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiKykSyouhn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
