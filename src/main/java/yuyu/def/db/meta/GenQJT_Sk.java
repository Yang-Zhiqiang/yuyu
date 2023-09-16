package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_FirstGanSindanKyhKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKyksyaTdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_Sk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_FirstGanSindanKyhKbn;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_KanryotuutioutKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_NaiteiKakuteiKbn;
import yuyu.def.db.type.UserType_C_SUketoriHouhouKbn;
import yuyu.def.db.type.UserType_C_SbjiShrKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_SeikyuusyaKbn;
import yuyu.def.db.type.UserType_C_SiHonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_SiharaiTuukaKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_SindansyoRyouShrYouhiKbn;
import yuyu.def.db.type.UserType_C_SinsaGendoKknKbn;
import yuyu.def.db.type.UserType_C_SkskknsyubetuKbn;
import yuyu.def.db.type.UserType_C_SouhusakiKbn;
import yuyu.def.db.type.UserType_C_SoukinsakiKbn;
import yuyu.def.db.type.UserType_C_SyuhiYouhi;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_Tkhukaumu;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UktKyksyaTdk;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 請求テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_Sk extends AbstractExDBTable<JT_Sk> {

    public GenQJT_Sk() {
        this("JT_Sk");
    }

    public GenQJT_Sk(String pAlias) {
        super("JT_Sk", JT_Sk.class, pAlias);
    }

    public String JT_Sk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_Sk, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_Sk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_Sk, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_Sk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Sk, BizDate> hubikanryouymd = new ExDBFieldString<>("hubikanryouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Sk, C_SeikyuusyaKbn> seikyuusyakbn = new ExDBFieldString<>("seikyuusyakbn", this, UserType_C_SeikyuusyaKbn.class);

    public final ExDBFieldString<JT_Sk, C_SyuhiYouhi> syuhiyouhi = new ExDBFieldString<>("syuhiyouhi", this, UserType_C_SyuhiYouhi.class);

    public final ExDBFieldString<JT_Sk, String> seikyuusyanmkn = new ExDBFieldString<>("seikyuusyanmkn", this);

    public final ExDBFieldString<JT_Sk, String> seikyuusyanmkj = new ExDBFieldString<>("seikyuusyanmkj", this);

    public final ExDBFieldString<JT_Sk, BizDate> seikyuusyaseiymd = new ExDBFieldString<>("seikyuusyaseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Sk, C_Seibetu> seikyuusyasei = new ExDBFieldString<>("seikyuusyasei", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<JT_Sk, C_SiHonninKakninKekkaKbn> sihonninkakninkbn = new ExDBFieldString<>("sihonninkakninkbn", this, UserType_C_SiHonninKakninKekkaKbn.class);

    public final ExDBFieldString<JT_Sk, C_Tdk> seikyuusyatdk = new ExDBFieldString<>("seikyuusyatdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<JT_Sk, C_SbjiShrKbn> sbjishrkbn = new ExDBFieldString<>("sbjishrkbn", this, UserType_C_SbjiShrKbn.class);

    public final ExDBFieldString<JT_Sk, C_UktKyksyaTdk> uktkyksyatdk = new ExDBFieldString<>("uktkyksyatdk", this, UserType_C_UktKyksyaTdk.class);

    public final ExDBFieldString<JT_Sk, C_SouhusakiKbn> souhusakikbn = new ExDBFieldString<>("souhusakikbn", this, UserType_C_SouhusakiKbn.class);

    public final ExDBFieldString<JT_Sk, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<JT_Sk, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<JT_Sk, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<JT_Sk, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<JT_Sk, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<JT_Sk, String> saikennmkj = new ExDBFieldString<>("saikennmkj", this);

    public final ExDBFieldString<JT_Sk, String> saikennyno = new ExDBFieldString<>("saikennyno", this);

    public final ExDBFieldString<JT_Sk, String> saikenadr1kj = new ExDBFieldString<>("saikenadr1kj", this);

    public final ExDBFieldString<JT_Sk, String> saikenadr2kj = new ExDBFieldString<>("saikenadr2kj", this);

    public final ExDBFieldString<JT_Sk, String> saikenadr3kj = new ExDBFieldString<>("saikenadr3kj", this);

    public final ExDBFieldString<JT_Sk, String> skskknnmkn = new ExDBFieldString<>("skskknnmkn", this);

    public final ExDBFieldString<JT_Sk, String> skskknnmkj = new ExDBFieldString<>("skskknnmkj", this);

    public final ExDBFieldString<JT_Sk, C_SkskknsyubetuKbn> skskknsyubetu = new ExDBFieldString<>("skskknsyubetu", this, UserType_C_SkskknsyubetuKbn.class);

    public final ExDBFieldString<JT_Sk, C_SoukinsakiKbn> soukinsakikbn = new ExDBFieldString<>("soukinsakikbn", this, UserType_C_SoukinsakiKbn.class);

    public final ExDBFieldString<JT_Sk, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<JT_Sk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<JT_Sk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<JT_Sk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<JT_Sk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<JT_Sk, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<JT_Sk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<JT_Sk, C_SUketoriHouhouKbn> suketorihouhoukbn = new ExDBFieldString<>("suketorihouhoukbn", this, UserType_C_SUketoriHouhouKbn.class);

    public final ExDBFieldString<JT_Sk, C_SiharaiTuukaKbn> siharaituukakbn = new ExDBFieldString<>("siharaituukakbn", this, UserType_C_SiharaiTuukaKbn.class);

    public final ExDBFieldString<JT_Sk, C_Tkhukaumu> nstkhukaumukbn = new ExDBFieldString<>("nstkhukaumukbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldBizCurrency<JT_Sk> nkkknjyutougk = new ExDBFieldBizCurrency<>("nkkknjyutougk", this);

    public final ExDBFieldString<JT_Sk, C_UmuKbn> sateikaksaigaikanouseikbn = new ExDBFieldString<>("sateikaksaigaikanouseikbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_Sk, C_YouhiKbn> sateikakmeigihnkkbn = new ExDBFieldString<>("sateikakmeigihnkkbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<JT_Sk, C_UmuKbn> sateikakkaigaisbkbn = new ExDBFieldString<>("sateikakkaigaisbkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_Sk, C_UmuKbn> sateikakhusyousikbn = new ExDBFieldString<>("sateikakhusyousikbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_Sk, C_UmuKbn> sateikakkaigaikbn = new ExDBFieldString<>("sateikakkaigaikbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_Sk, C_KanryotuutioutKbn> shrdtlsyooutkbn = new ExDBFieldString<>("shrdtlsyooutkbn", this, UserType_C_KanryotuutioutKbn.class);

    public final ExDBFieldString<JT_Sk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<JT_Sk, String> uktmnmeigibangou = new ExDBFieldString<>("uktmnmeigibangou", this);

    public final ExDBFieldString<JT_Sk, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<JT_Sk, C_SiinKbn> siinkbn = new ExDBFieldString<>("siinkbn", this, UserType_C_SiinKbn.class);

    public final ExDBFieldString<JT_Sk, BizDateYM> misyuupjyuutouym = new ExDBFieldString<>("misyuupjyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<JT_Sk, Integer> misyuupjyuutoukaisuuy = new ExDBFieldNumber<>("misyuupjyuutoukaisuuy", this);

    public final ExDBFieldNumber<JT_Sk, Integer> misyuupjyuutoukaisuum = new ExDBFieldNumber<>("misyuupjyuutoukaisuum", this);

    public final ExDBFieldString<JT_Sk, C_BlnktkumuKbn> saigaimousideumukbn = new ExDBFieldString<>("saigaimousideumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<JT_Sk, C_SindansyoRyouShrYouhiKbn> sindansyoryoushryouhikbn = new ExDBFieldString<>("sindansyoryoushryouhikbn", this, UserType_C_SindansyoRyouShrYouhiKbn.class);

    public final ExDBFieldNumber<JT_Sk, Integer> sindansyomaisuu = new ExDBFieldNumber<>("sindansyomaisuu", this);

    public final ExDBFieldString<JT_Sk, C_SinsaGendoKknKbn> sinsagendokknkbn = new ExDBFieldString<>("sinsagendokknkbn", this, UserType_C_SinsaGendoKknKbn.class);

    public final ExDBFieldNumber<JT_Sk, Integer> rikoukityuutuudannissuu = new ExDBFieldNumber<>("rikoukityuutuudannissuu", this);

    public final ExDBFieldString<JT_Sk, BizDate> tienrisokukisanymd = new ExDBFieldString<>("tienrisokukisanymd", this, BizDateType.class);

    public final ExDBFieldNumber<JT_Sk, Integer> tienrsknissuu = new ExDBFieldNumber<>("tienrsknissuu", this);

    public final ExDBFieldString<JT_Sk, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<JT_Sk, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<JT_Sk, BizDate> shrkwsratekjnymd = new ExDBFieldString<>("shrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Sk, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<JT_Sk, BizDate> zeimukwsratekjnymd = new ExDBFieldString<>("zeimukwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Sk, BizNumber> zeimukwsrate = new ExDBFieldString<>("zeimukwsrate", this, BizNumberType.class);

    public final ExDBFieldString<JT_Sk, BizDate> gaikaknsnkwsratekjymd = new ExDBFieldString<>("gaikaknsnkwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Sk, BizNumber> gaikaknsnkwsrate = new ExDBFieldString<>("gaikaknsnkwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<JT_Sk> shrgk = new ExDBFieldBizCurrency<>("shrgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> kyhkngkgoukei = new ExDBFieldBizCurrency<>("kyhkngkgoukei", this);

    public final ExDBFieldBizCurrency<JT_Sk> hokenkngkgoukei = new ExDBFieldBizCurrency<>("hokenkngkgoukei", this);

    public final ExDBFieldBizCurrency<JT_Sk> haitoukin = new ExDBFieldBizCurrency<>("haitoukin", this);

    public final ExDBFieldBizCurrency<JT_Sk> sonotahaitoukin = new ExDBFieldBizCurrency<>("sonotahaitoukin", this);

    public final ExDBFieldBizCurrency<JT_Sk> misyuup = new ExDBFieldBizCurrency<>("misyuup", this);

    public final ExDBFieldBizCurrency<JT_Sk> mikeikap = new ExDBFieldBizCurrency<>("mikeikap", this);

    public final ExDBFieldBizCurrency<JT_Sk> zennouseisankgk = new ExDBFieldBizCurrency<>("zennouseisankgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> azukarikingk = new ExDBFieldBizCurrency<>("azukarikingk", this);

    public final ExDBFieldBizCurrency<JT_Sk> sonotaseisangk = new ExDBFieldBizCurrency<>("sonotaseisangk", this);

    public final ExDBFieldBizCurrency<JT_Sk> krkgk = new ExDBFieldBizCurrency<>("krkgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> shrtienrsk = new ExDBFieldBizCurrency<>("shrtienrsk", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenshrgk = new ExDBFieldBizCurrency<>("yenshrgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkyhgkgoukei = new ExDBFieldBizCurrency<>("yenkyhgkgoukei", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenhkgkgoukei = new ExDBFieldBizCurrency<>("yenhkgkgoukei", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkahaitoukin = new ExDBFieldBizCurrency<>("yenkahaitoukin", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkasonotahaitoukin = new ExDBFieldBizCurrency<>("yenkasonotahaitoukin", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkamisyuup = new ExDBFieldBizCurrency<>("yenkamisyuup", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkamikeikap = new ExDBFieldBizCurrency<>("yenkamikeikap", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkazennouseisankgk = new ExDBFieldBizCurrency<>("yenkazennouseisankgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkaazukarikingk = new ExDBFieldBizCurrency<>("yenkaazukarikingk", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkasonotaseisangk = new ExDBFieldBizCurrency<>("yenkasonotaseisangk", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkakrkgk = new ExDBFieldBizCurrency<>("yenkakrkgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenshrtienrsk = new ExDBFieldBizCurrency<>("yenshrtienrsk", this);

    public final ExDBFieldBizCurrency<JT_Sk> zitkazukarikingksiteituuka = new ExDBFieldBizCurrency<>("zitkazukarikingksiteituuka", this);

    public final ExDBFieldBizCurrency<JT_Sk> zitkazukarikingkyen = new ExDBFieldBizCurrency<>("zitkazukarikingkyen", this);

    public final ExDBFieldBizCurrency<JT_Sk> gaikaknsntkgk = new ExDBFieldBizCurrency<>("gaikaknsntkgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> gaikaknsnkekkakgk = new ExDBFieldBizCurrency<>("gaikaknsnkekkakgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkaknsntkgk = new ExDBFieldBizCurrency<>("yenkaknsntkgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> yenkaknsnkekkakgk = new ExDBFieldBizCurrency<>("yenkaknsnkekkakgk", this);

    public final ExDBFieldBizCurrency<JT_Sk> misyuusyonendojikaiikoup = new ExDBFieldBizCurrency<>("misyuusyonendojikaiikoup", this);

    public final ExDBFieldBizCurrency<JT_Sk> misyuujinendoikoup = new ExDBFieldBizCurrency<>("misyuujinendoikoup", this);

    public final ExDBFieldString<JT_Sk, BizDate> pmkouryokuhasseiymd = new ExDBFieldString<>("pmkouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Sk, BizDateYM> mikeikapjyuutouym = new ExDBFieldString<>("mikeikapjyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<JT_Sk, Integer> mikeikapjyuutoukaisuuy = new ExDBFieldNumber<>("mikeikapjyuutoukaisuuy", this);

    public final ExDBFieldNumber<JT_Sk, Integer> mikeikapjyuutoukaisuum = new ExDBFieldNumber<>("mikeikapjyuutoukaisuum", this);

    public final ExDBFieldString<JT_Sk, C_UmuKbn> tokusyushrkbn = new ExDBFieldString<>("tokusyushrkbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_Sk, C_FirstGanSindanKyhKbn> firstgansindankyhkbn = new ExDBFieldString<>("firstgansindankyhkbn", this, UserType_C_FirstGanSindanKyhKbn.class);

    public final ExDBFieldBizCurrency<JT_Sk> goukeihituyoukeihi = new ExDBFieldBizCurrency<>("goukeihituyoukeihi", this);

    public final ExDBFieldNumber<JT_Sk, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldBizCurrency<JT_Sk> shrkykhtykeihi = new ExDBFieldBizCurrency<>("shrkykhtykeihi", this);

    public final ExDBFieldBizCurrency<JT_Sk> kijitumitouraimikeikap = new ExDBFieldBizCurrency<>("kijitumitouraimikeikap", this);

    public final ExDBFieldBizCurrency<JT_Sk> kyhknshrtyousyomisyuup = new ExDBFieldBizCurrency<>("kyhknshrtyousyomisyuup", this);

    public final ExDBFieldBizCurrency<JT_Sk> kyhknshrtyousyomikeikap = new ExDBFieldBizCurrency<>("kyhknshrtyousyomikeikap", this);

    public final ExDBFieldBizCurrency<JT_Sk> kyhknshrtysykjtmitrmikeikap = new ExDBFieldBizCurrency<>("kyhknshrtysykjtmitrmikeikap", this);

    public final ExDBFieldString<JT_Sk, C_NaiteiKakuteiKbn> vhtnaiteikakuteikbn = new ExDBFieldString<>("vhtnaiteikakuteikbn", this, UserType_C_NaiteiKakuteiKbn.class);

    public final ExDBFieldString<JT_Sk, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_Sk, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_Sk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_Sk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
