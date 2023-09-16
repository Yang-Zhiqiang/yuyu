package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SknnkaisikitkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateMDType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_SknnkaisikitkKbn;
import yuyu.def.db.type.UserType_C_TargetTkKbn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YennykntksyuruiKbn;

/**
 * 契約その他特約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KykSonotaTkyk extends AbstractExDBTable<IT_KykSonotaTkyk> {

    public GenQIT_KykSonotaTkyk() {
        this("IT_KykSonotaTkyk");
    }

    public GenQIT_KykSonotaTkyk(String pAlias) {
        super("IT_KykSonotaTkyk", IT_KykSonotaTkyk.class, pAlias);
    }

    public String IT_KykSonotaTkyk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KykSonotaTkyk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> livingneedshukaumu = new ExDBFieldString<>("livingneedshukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> stdrsktkyhkumu = new ExDBFieldString<>("stdrsktkyhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> stdrsktkyhkymd = new ExDBFieldString<>("stdrsktkyhkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> yennykntkhkumu = new ExDBFieldString<>("yennykntkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> gaikanykntkhkumu = new ExDBFieldString<>("gaikanykntkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> yenshrtkhkumu = new ExDBFieldString<>("yenshrtkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> yenshrkykkykhenkoymd = new ExDBFieldString<>("yenshrkykkykhenkoymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> nkgkkateitkumu = new ExDBFieldString<>("nkgkkateitkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizNumber> nksgkhosyuwari = new ExDBFieldString<>("nksgkhosyuwari", this, BizNumberType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> skjbrnktsumu = new ExDBFieldString<>("skjbrnktsumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> nenkingaku8waritkumu = new ExDBFieldString<>("nenkingaku8waritkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> nenkingaku9waritkumu = new ExDBFieldString<>("nenkingaku9waritkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> nkyentkhukaumu = new ExDBFieldString<>("nkyentkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> kwsttkhukaumu = new ExDBFieldString<>("kwsttkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<IT_KykSonotaTkyk, Integer> kwstargetrate = new ExDBFieldNumber<>("kwstargetrate", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> targettkhkumu = new ExDBFieldString<>("targettkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> targettkykkykhenkoymd = new ExDBFieldString<>("targettkykkykhenkoymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_TargetTkKbn> targettkkbn = new ExDBFieldString<>("targettkkbn", this, UserType_C_TargetTkKbn.class);

    public final ExDBFieldNumber<IT_KykSonotaTkyk, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> ysknkshtkumu = new ExDBFieldString<>("ysknkshtkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> pmnjtkkykymd = new ExDBFieldString<>("pmnjtkkykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> pmnjtksknnkaisiymd = new ExDBFieldString<>("pmnjtksknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> pmnjtkgansknnkaisiymd = new ExDBFieldString<>("pmnjtkgansknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> pmhktsknnkaisiymd = new ExDBFieldString<>("pmhktsknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> pmnjhktgansknnkaisiymd = new ExDBFieldString<>("pmnjhktgansknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, String> pmnjtkhtnpbuicd1 = new ExDBFieldString<>("pmnjtkhtnpbuicd1", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_Htnpkkn> pmnjtkhtnpkkn1 = new ExDBFieldString<>("pmnjtkhtnpkkn1", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, String> pmnjtkhtnpbuicd2 = new ExDBFieldString<>("pmnjtkhtnpbuicd2", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_Htnpkkn> pmnjtkhtnpkkn2 = new ExDBFieldString<>("pmnjtkhtnpkkn2", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, String> pmnjtkhtnpbuicd3 = new ExDBFieldString<>("pmnjtkhtnpbuicd3", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_Htnpkkn> pmnjtkhtnpkkn3 = new ExDBFieldString<>("pmnjtkhtnpkkn3", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, String> pmnjtkhtnpbuicd4 = new ExDBFieldString<>("pmnjtkhtnpbuicd4", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_Htnpkkn> pmnjtkhtnpkkn4 = new ExDBFieldString<>("pmnjtkhtnpkkn4", this, UserType_C_Htnpkkn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_TokkoudosghtnpKbn> pmnjtokkoudosghtnpkbn = new ExDBFieldString<>("pmnjtokkoudosghtnpkbn", this, UserType_C_TokkoudosghtnpKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_SknnkaisikitkKbn> sknnkaisikitkkbn = new ExDBFieldString<>("sknnkaisikitkkbn", this, UserType_C_SknnkaisikitkKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> nstkhkumu = new ExDBFieldString<>("nstkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> nkshrtkykhenkoymd = new ExDBFieldString<>("nkshrtkykhenkoymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_Nstknsyu> nkshrtkyknksyukbn = new ExDBFieldString<>("nkshrtkyknksyukbn", this, UserType_C_Nstknsyu.class);

    public final ExDBFieldNumber<IT_KykSonotaTkyk, Integer> nkshrtkyknksyukkn = new ExDBFieldNumber<>("nkshrtkyknksyukkn", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<IT_KykSonotaTkyk> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> jyudkaigomeharaitkhukaumu = new ExDBFieldString<>("jyudkaigomeharaitkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> jyudkaigomeharaitkhukaymd = new ExDBFieldString<>("jyudkaigomeharaitkhukaymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> targettkykhkymd = new ExDBFieldString<>("targettkykhkymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KykSonotaTkyk> targettkykkijyungk = new ExDBFieldBizCurrency<>("targettkykkijyungk", this);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> zeiseitkkktkykhukaumu = new ExDBFieldString<>("zeiseitkkktkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> zeiseitkkktkykhukaymd = new ExDBFieldString<>("zeiseitkkktkykhukaymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> zeiseitkkktkyksyoumetuymd = new ExDBFieldString<>("zeiseitkkktkyksyoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_YennykntksyuruiKbn> yennyknsyuruikbn = new ExDBFieldString<>("yennyknsyuruikbn", this, UserType_C_YennykntksyuruiKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> kykdrtkykhukaumu = new ExDBFieldString<>("kykdrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> kykdrtkykhukaymd = new ExDBFieldString<>("kykdrtkykhukaymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDate> kykdrtkykkaiyakuymd = new ExDBFieldString<>("kykdrtkykkaiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_UmuKbn> teikishrtkykhukaumu = new ExDBFieldString<>("teikishrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, C_Tuukasyu> teikishrkinshrtuukasyu = new ExDBFieldString<>("teikishrkinshrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_KykSonotaTkyk, BizDateMD> teikishrkinshrmd = new ExDBFieldString<>("teikishrkinshrmd", this, BizDateMDType.class);
}
