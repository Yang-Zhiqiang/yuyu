package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_DatatorikomiKbn;
import yuyu.def.classification.C_FirstmiseikyuuKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknhouskKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KeiukeDouKbn;
import yuyu.def.classification.C_KgkyojusikibetuKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NenreiCalcKbn;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nkshrhsijiyuu;
import yuyu.def.classification.C_Nkukthou;
import yuyu.def.classification.C_NkzeiseiKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Seikyuunaiyou;
import yuyu.def.classification.C_Shrhou;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_StdrskstKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UkehiDouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_Uktsei;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.BT_NenkinInfoRendou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Bnshrkaisuu;
import yuyu.def.db.type.UserType_C_DatatorikomiKbn;
import yuyu.def.db.type.UserType_C_FirstmiseikyuuKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknhouskKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KeiukeDouKbn;
import yuyu.def.db.type.UserType_C_KgkyojusikibetuKbn;
import yuyu.def.db.type.UserType_C_KktyuitaKbn;
import yuyu.def.db.type.UserType_C_NenkinJimuTesuuryouKbn;
import yuyu.def.db.type.UserType_C_NenkinKigouSedaiKbn;
import yuyu.def.db.type.UserType_C_NenreiCalcKbn;
import yuyu.def.db.type.UserType_C_NkHaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Nkshrhsijiyuu;
import yuyu.def.db.type.UserType_C_Nkukthou;
import yuyu.def.db.type.UserType_C_NkzeiseiKbn;
import yuyu.def.db.type.UserType_C_SUketoriHouhouKbn;
import yuyu.def.db.type.UserType_C_Seikyuunaiyou;
import yuyu.def.db.type.UserType_C_Shrhou;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_SinsaGendoKknKbn;
import yuyu.def.db.type.UserType_C_SkskknsyubetuKbn;
import yuyu.def.db.type.UserType_C_StdrskstKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UkehiDouKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_Uktsei;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;

/**
 * 年金情報連動テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_NenkinInfoRendou extends AbstractExDBTable<BT_NenkinInfoRendou> {

    public GenQBT_NenkinInfoRendou() {
        this("BT_NenkinInfoRendou");
    }

    public GenQBT_NenkinInfoRendou(String pAlias) {
        super("BT_NenkinInfoRendou", BT_NenkinInfoRendou.class, pAlias);
    }

    public String BT_NenkinInfoRendou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<BT_NenkinInfoRendou, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_YouhiKbn> nksysynonosaibanyhkbn = new ExDBFieldString<>("nksysynonosaibanyhkbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_DatatorikomiKbn> datatorikomikbn = new ExDBFieldString<>("datatorikomikbn", this, UserType_C_DatatorikomiKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_FirstmiseikyuuKbn> firstmiseikyuukbn = new ExDBFieldString<>("firstmiseikyuukbn", this, UserType_C_FirstmiseikyuuKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_SUketoriHouhouKbn> suketorihouhoukbn = new ExDBFieldString<>("suketorihouhoukbn", this, UserType_C_SUketoriHouhouKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_UmuKbn> hukusuuuketoriflg = new ExDBFieldString<>("hukusuuuketoriflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> nkkknsetymd = new ExDBFieldString<>("nkkknsetymd", this, BizDateType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> nkshrstartymd = new ExDBFieldString<>("nkshrstartymd", this, BizDateType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_Bnshrkaisuu> bnshrkaisuu = new ExDBFieldString<>("bnshrkaisuu", this, UserType_C_Bnshrkaisuu.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_Nkukthou> nkukthou = new ExDBFieldString<>("nkukthou", this, UserType_C_Nkukthou.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_Nkshrhsijiyuu> nkshrhsijiyuu = new ExDBFieldString<>("nkshrhsijiyuu", this, UserType_C_Nkshrhsijiyuu.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_UmuKbn> nkshrtkykjkghkkbn = new ExDBFieldString<>("nkshrtkykjkghkkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_HknhouskKbn> hknhouskkbn = new ExDBFieldString<>("hknhouskkbn", this, UserType_C_HknhouskKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> motosyono = new ExDBFieldString<>("motosyono", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BT_NenkinInfoRendou, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> oyadairitencd1 = new ExDBFieldString<>("oyadairitencd1", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> bosyuucd1 = new ExDBFieldString<>("bosyuucd1", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizNumber> dairitenbuntanwariai1 = new ExDBFieldString<>("dairitenbuntanwariai1", this, BizNumberType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> oyadairitencd2 = new ExDBFieldString<>("oyadairitencd2", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> bosyuucd2 = new ExDBFieldString<>("bosyuucd2", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizNumber> dairitenbuntanwariai2 = new ExDBFieldString<>("dairitenbuntanwariai2", this, BizNumberType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> drtenkanrisosikicd1 = new ExDBFieldString<>("drtenkanrisosikicd1", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> drtenkanritodoufukencd = new ExDBFieldString<>("drtenkanritodoufukencd", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_ZeitratkiKbn> zeitratkikbn = new ExDBFieldString<>("zeitratkikbn", this, UserType_C_ZeitratkiKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> kykadr = new ExDBFieldString<>("kykadr", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<BT_NenkinInfoRendou, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> hhknadrkj = new ExDBFieldString<>("hhknadrkj", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> hhknsakuinmeino = new ExDBFieldString<>("hhknsakuinmeino", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> uktnmkn = new ExDBFieldString<>("uktnmkn", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_KeiukeDouKbn> keiukedoukbn = new ExDBFieldString<>("keiukedoukbn", this, UserType_C_KeiukeDouKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_UkehiDouKbn> ukehidouitukbn = new ExDBFieldString<>("ukehidouitukbn", this, UserType_C_UkehiDouKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> uktseiymd = new ExDBFieldString<>("uktseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_Uktsei> uktsei = new ExDBFieldString<>("uktsei", this, UserType_C_Uktsei.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_KgkyojusikibetuKbn> kgkyojusikibetukbn = new ExDBFieldString<>("kgkyojusikibetukbn", this, UserType_C_KgkyojusikibetuKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkuktsakuinnmno = new ExDBFieldString<>("nkuktsakuinnmno", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> skskknnmkn = new ExDBFieldString<>("skskknnmkn", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> skskknnmkj = new ExDBFieldString<>("skskknnmkj", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_SkskknsyubetuKbn> skskknsyubetu = new ExDBFieldString<>("skskknsyubetu", this, UserType_C_SkskknsyubetuKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_Shrhou> shrhou = new ExDBFieldString<>("shrhou", this, UserType_C_Shrhou.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> seisikakymd = new ExDBFieldString<>("seisikakymd", this, BizDateType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_Seikyuunaiyou> seikyuunaiyou = new ExDBFieldString<>("seikyuunaiyou", this, UserType_C_Seikyuunaiyou.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_SinsaGendoKknKbn> sinsagendokknkbn = new ExDBFieldString<>("sinsagendokknkbn", this, UserType_C_SinsaGendoKknKbn.class);

    public final ExDBFieldNumber<BT_NenkinInfoRendou, Integer> rikoukityuutuudannissuu = new ExDBFieldNumber<>("rikoukityuutuudannissuu", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_UmuKbn> yenshrtkumukbn = new ExDBFieldString<>("yenshrtkumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_UmuKbn> keizknenkinuktsiteitk = new ExDBFieldString<>("keizknenkinuktsiteitk", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_UktKbn> keizknenkinuktkbn = new ExDBFieldString<>("keizknenkinuktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> keizknenkinuktnmkana = new ExDBFieldString<>("keizknenkinuktnmkana", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> keizknenkinuktnmkanji = new ExDBFieldString<>("keizknenkinuktnmkanji", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> keizknenkiuktseiymd = new ExDBFieldString<>("keizknenkiuktseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_UmuKbn> stdrsktky = new ExDBFieldString<>("stdrsktky", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, BizDate> stdrsktkyhkymd = new ExDBFieldString<>("stdrsktkyhkymd", this, BizDateType.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_StdrskstKbn> stdrskstkbn = new ExDBFieldString<>("stdrskstkbn", this, UserType_C_StdrskstKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> stdrsknmkn = new ExDBFieldString<>("stdrsknmkn", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> stdrsknmkj = new ExDBFieldString<>("stdrsknmkj", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_UktKbn> stdruktkbn = new ExDBFieldString<>("stdruktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_KktyuitaKbn> kktyuitakbn = new ExDBFieldString<>("kktyuitakbn", this, UserType_C_KktyuitaKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou1 = new ExDBFieldString<>("nkttdktyuuinaiyou1", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou2 = new ExDBFieldString<>("nkttdktyuuinaiyou2", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou3 = new ExDBFieldString<>("nkttdktyuuinaiyou3", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou4 = new ExDBFieldString<>("nkttdktyuuinaiyou4", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou5 = new ExDBFieldString<>("nkttdktyuuinaiyou5", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou6 = new ExDBFieldString<>("nkttdktyuuinaiyou6", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou7 = new ExDBFieldString<>("nkttdktyuuinaiyou7", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou8 = new ExDBFieldString<>("nkttdktyuuinaiyou8", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou9 = new ExDBFieldString<>("nkttdktyuuinaiyou9", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou10 = new ExDBFieldString<>("nkttdktyuuinaiyou10", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou11 = new ExDBFieldString<>("nkttdktyuuinaiyou11", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou12 = new ExDBFieldString<>("nkttdktyuuinaiyou12", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou13 = new ExDBFieldString<>("nkttdktyuuinaiyou13", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou14 = new ExDBFieldString<>("nkttdktyuuinaiyou14", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou15 = new ExDBFieldString<>("nkttdktyuuinaiyou15", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou16 = new ExDBFieldString<>("nkttdktyuuinaiyou16", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou17 = new ExDBFieldString<>("nkttdktyuuinaiyou17", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nkttdktyuuinaiyou18 = new ExDBFieldString<>("nkttdktyuuinaiyou18", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_SyutkKbn> teisyutkykbn = new ExDBFieldString<>("teisyutkykbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> teinksyu = new ExDBFieldString<>("teinksyu", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> teinksyuruiversion = new ExDBFieldString<>("teinksyuruiversion", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_NenkinKigouSedaiKbn> nenkinkigousedaikbn = new ExDBFieldString<>("nenkinkigousedaikbn", this, UserType_C_NenkinKigouSedaiKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> teinkspan = new ExDBFieldString<>("teinkspan", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> teikihongk = new ExDBFieldBizCurrency<>("teikihongk", this);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> teihitukeihiyen = new ExDBFieldBizCurrency<>("teihitukeihiyen", this);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> teihitukeihigaika = new ExDBFieldBizCurrency<>("teihitukeihigaika", this);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> teinkkikingken = new ExDBFieldBizCurrency<>("teinkkikingken", this);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> teinkkikingkgaika = new ExDBFieldBizCurrency<>("teinkkikingkgaika", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> nenkinkaisigoyoteiriritukbn = new ExDBFieldString<>("nenkinkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_NenkinJimuTesuuryouKbn> nenkinjimutesuuryoukbn = new ExDBFieldString<>("nenkinjimutesuuryoukbn", this, UserType_C_NenkinJimuTesuuryouKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_NenreiCalcKbn> nenreicalckbn = new ExDBFieldString<>("nenreicalckbn", this, UserType_C_NenreiCalcKbn.class);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> tyoukankseigk = new ExDBFieldBizCurrency<>("tyoukankseigk", this);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> ksnnkgk = new ExDBFieldBizCurrency<>("ksnnkgk", this);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> ksnnkkkngk = new ExDBFieldBizCurrency<>("ksnnkkkngk", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_NkzeiseiKbn> nkzeiseikbn = new ExDBFieldString<>("nkzeiseikbn", this, UserType_C_NkzeiseiKbn.class);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> kykkstkkn = new ExDBFieldBizCurrency<>("kykkstkkn", this);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> jhurikstkkn = new ExDBFieldBizCurrency<>("jhurikstkkn", this);

    public final ExDBFieldBizCurrency<BT_NenkinInfoRendou> misyuup = new ExDBFieldBizCurrency<>("misyuup", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, C_NkHaitoukinuketorihouKbn> nkhaitoukinuketorihoukbn = new ExDBFieldString<>("nkhaitoukinuketorihoukbn", this, UserType_C_NkHaitoukinuketorihouKbn.class);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_NenkinInfoRendou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
