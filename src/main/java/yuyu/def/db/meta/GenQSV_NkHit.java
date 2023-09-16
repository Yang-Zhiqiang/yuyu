package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_AnnaiKbn;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknhouskKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NenreiCalcKbn;
import yuyu.def.classification.C_NkGnsKbn;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Nkshrhsijiyuu;
import yuyu.def.classification.C_Nkshrjk;
import yuyu.def.classification.C_Nkukthou;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Sznjk;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_NkHit;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_AnnaiKbn;
import yuyu.def.db.type.UserType_C_Bnshrkaisuu;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknhouskKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_NenkinJimuTesuuryouKbn;
import yuyu.def.db.type.UserType_C_NenkinKbn;
import yuyu.def.db.type.UserType_C_NenkinKigouSedaiKbn;
import yuyu.def.db.type.UserType_C_NenreiCalcKbn;
import yuyu.def.db.type.UserType_C_NkGnsKbn;
import yuyu.def.db.type.UserType_C_NkHaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_NkSyoumetuCd;
import yuyu.def.db.type.UserType_C_Nkshrhsijiyuu;
import yuyu.def.db.type.UserType_C_Nkshrjk;
import yuyu.def.db.type.UserType_C_Nkukthou;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Sznjk;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 年金配当所要額ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_NkHit extends AbstractExDBTable<SV_NkHit> {

    public GenQSV_NkHit() {
        this("SV_NkHit");
    }

    public GenQSV_NkHit(String pAlias) {
        super("SV_NkHit", SV_NkHit.class, pAlias);
    }

    public String SV_NkHit() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<SV_NkHit, Integer> renno8keta = new ExDBFieldNumber<>("renno8keta", this);

    public final ExDBFieldString<SV_NkHit, C_Sznjk> sznjk = new ExDBFieldString<>("sznjk", this, UserType_C_Sznjk.class);

    public final ExDBFieldString<SV_NkHit, BizDate> seisikakymd = new ExDBFieldString<>("seisikakymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldString<SV_NkHit, BizDate> nkkknsetymd = new ExDBFieldString<>("nkkknsetymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, BizDate> nkshrstartymd = new ExDBFieldString<>("nkshrstartymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, BizDate> nkkknmanryouymd = new ExDBFieldString<>("nkkknmanryouymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, C_Bnshrkaisuu> bnshrkaisuu = new ExDBFieldString<>("bnshrkaisuu", this, UserType_C_Bnshrkaisuu.class);

    public final ExDBFieldString<SV_NkHit, C_Bnshrkaisuu> jinendobnshrkaisuu = new ExDBFieldString<>("jinendobnshrkaisuu", this, UserType_C_Bnshrkaisuu.class);

    public final ExDBFieldString<SV_NkHit, C_Nkukthou> nkukthou = new ExDBFieldString<>("nkukthou", this, UserType_C_Nkukthou.class);

    public final ExDBFieldString<SV_NkHit, C_Nkshrhsijiyuu> nkshrhsijiyuu = new ExDBFieldString<>("nkshrhsijiyuu", this, UserType_C_Nkshrhsijiyuu.class);

    public final ExDBFieldString<SV_NkHit, BizDate> nextnsymd = new ExDBFieldString<>("nextnsymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, BizDate> nextnkshrkjt = new ExDBFieldString<>("nextnkshrkjt", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, BizDate> nextshryoteisakuseiymd = new ExDBFieldString<>("nextshryoteisakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, BizDate> nexthurikaeymd = new ExDBFieldString<>("nexthurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, C_Nkshrjk> nkshrjk = new ExDBFieldString<>("nkshrjk", this, UserType_C_Nkshrjk.class);

    public final ExDBFieldString<SV_NkHit, C_NkSyoumetuCd> nksyoumetucd = new ExDBFieldString<>("nksyoumetucd", this, UserType_C_NkSyoumetuCd.class);

    public final ExDBFieldString<SV_NkHit, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, C_UmuKbn> iktumu = new ExDBFieldString<>("iktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_NkHit, BizDate> nksysyhkymd = new ExDBFieldString<>("nksysyhkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, BizDate> nksysysaihkymd = new ExDBFieldString<>("nksysysaihkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, BizDate> ssnannaisksiymd = new ExDBFieldString<>("ssnannaisksiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, C_AnnaiKbn> annaikbn = new ExDBFieldString<>("annaikbn", this, UserType_C_AnnaiKbn.class);

    public final ExDBFieldString<SV_NkHit, String> oyadairitencd1 = new ExDBFieldString<>("oyadairitencd1", this);

    public final ExDBFieldString<SV_NkHit, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<SV_NkHit, String> bosyuucd1 = new ExDBFieldString<>("bosyuucd1", this);

    public final ExDBFieldString<SV_NkHit, BizNumber> dairitenbuntanwariai1 = new ExDBFieldString<>("dairitenbuntanwariai1", this, BizNumberType.class);

    public final ExDBFieldString<SV_NkHit, String> oyadairitencd2 = new ExDBFieldString<>("oyadairitencd2", this);

    public final ExDBFieldString<SV_NkHit, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<SV_NkHit, String> bosyuucd2 = new ExDBFieldString<>("bosyuucd2", this);

    public final ExDBFieldString<SV_NkHit, BizNumber> dairitenbuntanwariai2 = new ExDBFieldString<>("dairitenbuntanwariai2", this, BizNumberType.class);

    public final ExDBFieldString<SV_NkHit, String> drtenkanrisosikicd1 = new ExDBFieldString<>("drtenkanrisosikicd1", this);

    public final ExDBFieldString<SV_NkHit, String> drtenkanritodoufukencd = new ExDBFieldString<>("drtenkanritodoufukencd", this);

    public final ExDBFieldString<SV_NkHit, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<SV_NkHit, String> motosyono = new ExDBFieldString<>("motosyono", this);

    public final ExDBFieldString<SV_NkHit, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<SV_NkHit, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<SV_NkHit, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<SV_NkHit, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, C_HknhouskKbn> hknhouskkbn = new ExDBFieldString<>("hknhouskkbn", this, UserType_C_HknhouskKbn.class);

    public final ExDBFieldString<SV_NkHit, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_NkHit, C_UmuKbn> yenshrtkumukbn = new ExDBFieldString<>("yenshrtkumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_NkHit, C_UmuKbn> stdrsktky = new ExDBFieldString<>("stdrsktky", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_NkHit, C_UmuKbn> keizknenkinuktsiteitk = new ExDBFieldString<>("keizknenkinuktsiteitk", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_NkHit, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<SV_NkHit, C_SyutkKbn> teisyutkykbn = new ExDBFieldString<>("teisyutkykbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<SV_NkHit, C_NenkinKbn> nenkinkbn = new ExDBFieldString<>("nenkinkbn", this, UserType_C_NenkinKbn.class);

    public final ExDBFieldString<SV_NkHit, String> teinksyu = new ExDBFieldString<>("teinksyu", this);

    public final ExDBFieldString<SV_NkHit, String> teinksyuruiversion = new ExDBFieldString<>("teinksyuruiversion", this);

    public final ExDBFieldString<SV_NkHit, C_NenkinKigouSedaiKbn> nenkinkigousedaikbn = new ExDBFieldString<>("nenkinkigousedaikbn", this, UserType_C_NenkinKigouSedaiKbn.class);

    public final ExDBFieldString<SV_NkHit, String> teinkspan = new ExDBFieldString<>("teinkspan", this);

    public final ExDBFieldBizCurrency<SV_NkHit> teikihongk = new ExDBFieldBizCurrency<>("teikihongk", this);

    public final ExDBFieldBizCurrency<SV_NkHit> teihitukeihiyen = new ExDBFieldBizCurrency<>("teihitukeihiyen", this);

    public final ExDBFieldBizCurrency<SV_NkHit> teihitukeihigaika = new ExDBFieldBizCurrency<>("teihitukeihigaika", this);

    public final ExDBFieldString<SV_NkHit, String> teihyounkspan = new ExDBFieldString<>("teihyounkspan", this);

    public final ExDBFieldBizCurrency<SV_NkHit> teinkkikingk = new ExDBFieldBizCurrency<>("teinkkikingk", this);

    public final ExDBFieldString<SV_NkHit, C_NkGnsKbn> nkgnskbn = new ExDBFieldString<>("nkgnskbn", this, UserType_C_NkGnsKbn.class);

    public final ExDBFieldString<SV_NkHit, String> nenkinkaisigoyoteiriritukbn = new ExDBFieldString<>("nenkinkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<SV_NkHit, C_NenkinJimuTesuuryouKbn> nenkinjimutesuuryoukbn = new ExDBFieldString<>("nenkinjimutesuuryoukbn", this, UserType_C_NenkinJimuTesuuryouKbn.class);

    public final ExDBFieldString<SV_NkHit, BizNumber> kyktumitateriritu = new ExDBFieldString<>("kyktumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<SV_NkHit, BizNumber> tumitateriritu = new ExDBFieldString<>("tumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<SV_NkHit, BizDate> tumitatekijyunymd = new ExDBFieldString<>("tumitatekijyunymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, BizNumber> tumitatekijyunnen = new ExDBFieldString<>("tumitatekijyunnen", this, BizNumberType.class);

    public final ExDBFieldString<SV_NkHit, BizNumber> tumitatekijyunkkn = new ExDBFieldString<>("tumitatekijyunkkn", this, BizNumberType.class);

    public final ExDBFieldString<SV_NkHit, BizDate> fstinymd = new ExDBFieldString<>("fstinymd", this, BizDateType.class);

    public final ExDBFieldString<SV_NkHit, C_NkHaitoukinuketorihouKbn> nkhaitoukinuketorihoukbn = new ExDBFieldString<>("nkhaitoukinuketorihoukbn", this, UserType_C_NkHaitoukinuketorihouKbn.class);

    public final ExDBFieldString<SV_NkHit, C_NenreiCalcKbn> nenreicalckbn = new ExDBFieldString<>("nenreicalckbn", this, UserType_C_NenreiCalcKbn.class);

    public final ExDBFieldString<SV_NkHit, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<SV_NkHit, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<SV_NkHit, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_NkHit, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<SV_NkHit, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<SV_NkHit, String> hhknadrkj = new ExDBFieldString<>("hhknadrkj", this);

    public final ExDBFieldString<SV_NkHit, String> hhknsakuinmeino = new ExDBFieldString<>("hhknsakuinmeino", this);
}
