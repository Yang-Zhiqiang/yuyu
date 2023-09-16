package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kykymdtkrumu;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_Livhukaumu;
import yuyu.def.classification.C_MobilebosyuuKbn;
import yuyu.def.classification.C_MosTourokuJyoukyouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_PmnjtkhukaKbn;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.def.classification.C_PplessrendoukouhurikousouKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.db.entity.HT_BosKihon;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_AeoisnsiKbn;
import yuyu.def.db.type.UserType_C_BikkjnssinfoKbn;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_DirectServiceMosKbn;
import yuyu.def.db.type.UserType_C_DsSyomenTtdkHyouji;
import yuyu.def.db.type.UserType_C_FatcasnsiKbn;
import yuyu.def.db.type.UserType_C_FstphrkkeiroKbn;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HjndaiykKbn;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_HonninkakuninSyoruiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_KoureiKzkSetumeiHouKbn;
import yuyu.def.db.type.UserType_C_KoureiMndnHukusuukaiKbn;
import yuyu.def.db.type.UserType_C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.db.type.UserType_C_KoureisyaTaiouKbn;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Kykymdtkrumu;
import yuyu.def.db.type.UserType_C_KzktourokuserviceTourokuKbn;
import yuyu.def.db.type.UserType_C_Livhukaumu;
import yuyu.def.db.type.UserType_C_MobilebosyuuKbn;
import yuyu.def.db.type.UserType_C_MosTourokuJyoukyouKbn;
import yuyu.def.db.type.UserType_C_MosUketukeKbn;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_NkgnsHosyourituKbn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_PmnjtkhukaKbn;
import yuyu.def.db.type.UserType_C_PplessrendoucreditkousouKbn;
import yuyu.def.db.type.UserType_C_PplessrendoukouhurikousouKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_TargetTkKbn;
import yuyu.def.db.type.UserType_C_TargetTkMokuhyoutiKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_Tkhukaumu;
import yuyu.def.db.type.UserType_C_TrhkjiKakKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.def.db.type.UserType_C_TumitatekinHaibunWariKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YakkanJyuryouKbn;
import yuyu.def.db.type.UserType_C_YnkHrkmgkAnniTuutiKbn;

/**
 * 募集基本テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_BosKihon extends AbstractExDBTable<HT_BosKihon> {

    public GenQHT_BosKihon() {
        this("HT_BosKihon");
    }

    public GenQHT_BosKihon(String pAlias) {
        super("HT_BosKihon", HT_BosKihon.class, pAlias);
    }

    public String HT_BosKihon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_BosKihon, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_BosKihon, String> aitemosno = new ExDBFieldString<>("aitemosno", this);

    public final ExDBFieldString<HT_BosKihon, String> doujikaiyakusyono = new ExDBFieldString<>("doujikaiyakusyono", this);

    public final ExDBFieldString<HT_BosKihon, String> sekno = new ExDBFieldString<>("sekno", this);

    public final ExDBFieldString<HT_BosKihon, C_MosUketukeKbn> mosuketukekbn = new ExDBFieldString<>("mosuketukekbn", this, UserType_C_MosUketukeKbn.class);

    public final ExDBFieldString<HT_BosKihon, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<HT_BosKihon, BizDate> mossakuseiymd = new ExDBFieldString<>("mossakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_BosKihon, BizDate> pplessmosukeymd = new ExDBFieldString<>("pplessmosukeymd", this, BizDateType.class);

    public final ExDBFieldString<HT_BosKihon, BizDate> pykkigenymd = new ExDBFieldString<>("pykkigenymd", this, BizDateType.class);

    public final ExDBFieldString<HT_BosKihon, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldString<HT_BosKihon, BizDate> moscalckijyunymd = new ExDBFieldString<>("moscalckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<HT_BosKihon, C_Kykymdtkrumu> kykymdtkrumu = new ExDBFieldString<>("kykymdtkrumu", this, UserType_C_Kykymdtkrumu.class);

    public final ExDBFieldString<HT_BosKihon, BizDate> skykymd = new ExDBFieldString<>("skykymd", this, BizDateType.class);

    public final ExDBFieldString<HT_BosKihon, C_KykKbn> kykkbn = new ExDBFieldString<>("kykkbn", this, UserType_C_KykKbn.class);

    public final ExDBFieldString<HT_BosKihon, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<HT_BosKihon, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<HT_BosKihon, C_KjkhukaKbn> hhknnmkjkhukakbn = new ExDBFieldString<>("hhknnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<HT_BosKihon, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_BosKihon, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<HT_BosKihon, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<HT_BosKihon, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<HT_BosKihon, C_NensyuuKbn> hhknnensyuukbn = new ExDBFieldString<>("hhknnensyuukbn", this, UserType_C_NensyuuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_TsindousiteiKbn> tsindousiteikbn = new ExDBFieldString<>("tsindousiteikbn", this, UserType_C_TsindousiteiKbn.class);

    public final ExDBFieldString<HT_BosKihon, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<HT_BosKihon, String> hhknadr1kj = new ExDBFieldString<>("hhknadr1kj", this);

    public final ExDBFieldString<HT_BosKihon, String> hhknadr2kj = new ExDBFieldString<>("hhknadr2kj", this);

    public final ExDBFieldString<HT_BosKihon, String> hhknadr3kj = new ExDBFieldString<>("hhknadr3kj", this);

    public final ExDBFieldString<HT_BosKihon, String> hhkntelno = new ExDBFieldString<>("hhkntelno", this);

    public final ExDBFieldString<HT_BosKihon, String> hhknkinmusakinm = new ExDBFieldString<>("hhknkinmusakinm", this);

    public final ExDBFieldString<HT_BosKihon, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<HT_BosKihon, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<HT_BosKihon, C_KjkhukaKbn> kyknmkjkhukakbn = new ExDBFieldString<>("kyknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<HT_BosKihon, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_BosKihon, Integer> kyknen = new ExDBFieldNumber<>("kyknen", this);

    public final ExDBFieldString<HT_BosKihon, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<HT_BosKihon, C_Tdk> kyktdk = new ExDBFieldString<>("kyktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<HT_BosKihon, C_NensyuuKbn> kyknensyuukbn = new ExDBFieldString<>("kyknensyuukbn", this, UserType_C_NensyuuKbn.class);

    public final ExDBFieldString<HT_BosKihon, String> kykkinmusakinm = new ExDBFieldString<>("kykkinmusakinm", this);

    public final ExDBFieldString<HT_BosKihon, C_HjndaiykKbn> hjndaiykkbn = new ExDBFieldString<>("hjndaiykkbn", this, UserType_C_HjndaiykKbn.class);

    public final ExDBFieldString<HT_BosKihon, String> hjndainmkn = new ExDBFieldString<>("hjndainmkn", this);

    public final ExDBFieldString<HT_BosKihon, String> hjndainmkj = new ExDBFieldString<>("hjndainmkj", this);

    public final ExDBFieldString<HT_BosKihon, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<HT_BosKihon, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<HT_BosKihon, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<HT_BosKihon, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<HT_BosKihon, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<HT_BosKihon, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<HT_BosKihon, C_YakkanJyuryouKbn> yakkanjyuryouhoukbn = new ExDBFieldString<>("yakkanjyuryouhoukbn", this, UserType_C_YakkanJyuryouKbn.class);

    public final ExDBFieldString<HT_BosKihon, String> yakkanbunsyono = new ExDBFieldString<>("yakkanbunsyono", this);

    public final ExDBFieldString<HT_BosKihon, C_FatcasnsiKbn> fatcasnsikbn = new ExDBFieldString<>("fatcasnsikbn", this, UserType_C_FatcasnsiKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_BikkjnssinfoKbn> bikkjnssinfokbn = new ExDBFieldString<>("bikkjnssinfokbn", this, UserType_C_BikkjnssinfoKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_AeoisnsiKbn> aeoisnsikbn = new ExDBFieldString<>("aeoisnsikbn", this, UserType_C_AeoisnsiKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_HknsyuruiNo> hknsyuruino = new ExDBFieldString<>("hknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldNumber<HT_BosKihon, Integer> hknsyuruinosd = new ExDBFieldNumber<>("hknsyuruinosd", this);

    public final ExDBFieldString<HT_BosKihon, C_NkgnsHosyourituKbn> nkgnshosyouritukbn = new ExDBFieldString<>("nkgnshosyouritukbn", this, UserType_C_NkgnsHosyourituKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_Livhukaumu> livhukaumu = new ExDBFieldString<>("livhukaumu", this, UserType_C_Livhukaumu.class);

    public final ExDBFieldString<HT_BosKihon, C_PmnjtkhukaKbn> pmnjtkhukakbn = new ExDBFieldString<>("pmnjtkhukakbn", this, UserType_C_PmnjtkhukaKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_KzktourokuserviceTourokuKbn> kzktourokuservicetourokukbn = new ExDBFieldString<>("kzktourokuservicetourokukbn", this, UserType_C_KzktourokuserviceTourokuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> kykdrtkykhukakbn = new ExDBFieldString<>("kykdrtkykhukakbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> stdrsktkyhkkbn = new ExDBFieldString<>("stdrsktkyhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_BosKihon, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<HT_BosKihon, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_BosKihon, C_Tuukasyu> hrktuukasyu = new ExDBFieldString<>("hrktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> yennykntkhkkbn = new ExDBFieldString<>("yennykntkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> gaikanykntkhkkbn = new ExDBFieldString<>("gaikanykntkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> yenshrtkhkkbn = new ExDBFieldString<>("yenshrtkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldBizCurrency<HT_BosKihon> mosheijyunp = new ExDBFieldBizCurrency<>("mosheijyunp", this);

    public final ExDBFieldString<HT_BosKihon, C_IkkatubaraiKbn> ikkatubaraikbn = new ExDBFieldString<>("ikkatubaraikbn", this, UserType_C_IkkatubaraiKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_IkkatubaraiKaisuuKbn> ikkatubaraikaisuu = new ExDBFieldString<>("ikkatubaraikaisuu", this, UserType_C_IkkatubaraiKaisuuKbn.class);

    public final ExDBFieldBizCurrency<HT_BosKihon> mosikkatup = new ExDBFieldBizCurrency<>("mosikkatup", this);

    public final ExDBFieldBizCurrency<HT_BosKihon> syutkpkei = new ExDBFieldBizCurrency<>("syutkpkei", this);

    public final ExDBFieldBizCurrency<HT_BosKihon> fsthrkpkei = new ExDBFieldBizCurrency<>("fsthrkpkei", this);

    public final ExDBFieldString<HT_BosKihon, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<HT_BosKihon, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<HT_BosKihon, C_FstphrkkeiroKbn> fstphrkkeirokbn = new ExDBFieldString<>("fstphrkkeirokbn", this, UserType_C_FstphrkkeiroKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> zennoumousideumu = new ExDBFieldString<>("zennoumousideumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_BlnktkumuKbn> zenkizennouumu = new ExDBFieldString<>("zenkizennouumu", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldNumber<HT_BosKihon, Integer> znnkai = new ExDBFieldNumber<>("znnkai", this);

    public final ExDBFieldBizCurrency<HT_BosKihon> moszennoupsyokaiari = new ExDBFieldBizCurrency<>("moszennoupsyokaiari", this);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> targettkhkkbn = new ExDBFieldString<>("targettkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_BosKihon, C_TargetTkKbn> targettkkbn = new ExDBFieldString<>("targettkkbn", this, UserType_C_TargetTkKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_TargetTkMokuhyoutiKbn> targettkmkhtkbn = new ExDBFieldString<>("targettkmkhtkbn", this, UserType_C_TargetTkMokuhyoutiKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> nstkhkkbn = new ExDBFieldString<>("nstkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldNumber<HT_BosKihon, Integer> nstkmnknsyu = new ExDBFieldNumber<>("nstkmnknsyu", this);

    public final ExDBFieldNumber<HT_BosKihon, Integer> nstkmnknkkn = new ExDBFieldNumber<>("nstkmnknkkn", this);

    public final ExDBFieldString<HT_BosKihon, C_Nstknsyu> nstksbnsyu = new ExDBFieldString<>("nstksbnsyu", this, UserType_C_Nstknsyu.class);

    public final ExDBFieldNumber<HT_BosKihon, Integer> nstksbnkkn = new ExDBFieldNumber<>("nstksbnkkn", this);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> syksbyensitihsyutkhkkbn = new ExDBFieldString<>("syksbyensitihsyutkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> jyudkaigomehrtkhkkbn = new ExDBFieldString<>("jyudkaigomehrtkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> kjnnkpzeitekitkhukakbn = new ExDBFieldString<>("kjnnkpzeitekitkhukakbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_BosKihon, C_Tkhukaumu> teikisiharaitkykhkkbn = new ExDBFieldString<>("teikisiharaitkykhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldNumber<HT_BosKihon, Integer> sbuktnin = new ExDBFieldNumber<>("sbuktnin", this);

    public final ExDBFieldString<HT_BosKihon, C_HonninkakuninSyoruiKbn> kykhonninkakninsyoruikbn = new ExDBFieldString<>("kykhonninkakninsyoruikbn", this, UserType_C_HonninkakuninSyoruiKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_HonninkakuninSyoruiKbn> skskknhonninkakninsyoruikbn = new ExDBFieldString<>("skskknhonninkakninsyoruikbn", this, UserType_C_HonninkakuninSyoruiKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_KoureiKzkSetumeiHouKbn> koureikzksetumeihoukbn = new ExDBFieldString<>("koureikzksetumeihoukbn", this, UserType_C_KoureiKzkSetumeiHouKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_KoureiMndnHukusuukaiKbn> koureimndnhukusuukaikbn = new ExDBFieldString<>("koureimndnhukusuukaikbn", this, UserType_C_KoureiMndnHukusuukaiKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_KoureiTratkisyaIgiDskKbn> koureitratkisyaigidskkbn = new ExDBFieldString<>("koureitratkisyaigidskkbn", this, UserType_C_KoureiTratkisyaIgiDskKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> daihituumukbn = new ExDBFieldString<>("daihituumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, String> uktkid = new ExDBFieldString<>("uktkid", this);

    public final ExDBFieldString<HT_BosKihon, C_DirectServiceMosKbn> drctservicemoskbn = new ExDBFieldString<>("drctservicemoskbn", this, UserType_C_DirectServiceMosKbn.class);

    public final ExDBFieldString<HT_BosKihon, String> dsmailaddress = new ExDBFieldString<>("dsmailaddress", this);

    public final ExDBFieldString<HT_BosKihon, String> tokuteitrhkansyono = new ExDBFieldString<>("tokuteitrhkansyono", this);

    public final ExDBFieldString<HT_BosKihon, C_DsSyomenTtdkHyouji> pplessrenjidssymenttdkhyj = new ExDBFieldString<>("pplessrenjidssymenttdkhyj", this, UserType_C_DsSyomenTtdkHyouji.class);

    public final ExDBFieldString<HT_BosKihon, C_PplessrendoukouhurikousouKbn> pplsrendoukouhurikousoukbn = new ExDBFieldString<>("pplsrendoukouhurikousoukbn", this, UserType_C_PplessrendoukouhurikousouKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_PplessrendoucreditkousouKbn> pplessrendoucreditkousoukbn = new ExDBFieldString<>("pplessrendoucreditkousoukbn", this, UserType_C_PplessrendoucreditkousouKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_YnkHrkmgkAnniTuutiKbn> ynkhrkmgkannituutikbn = new ExDBFieldString<>("ynkhrkmgkannituutikbn", this, UserType_C_YnkHrkmgkAnniTuutiKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> hnsstjmmouumukbn = new ExDBFieldString<>("hnsstjmmouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> kjmeigihkhunouumukbn = new ExDBFieldString<>("kjmeigihkhunouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> tsryhshrkykumukbn = new ExDBFieldString<>("tsryhshrkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> syosisyatodokeumukbn = new ExDBFieldString<>("syosisyatodokeumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> kakukisyouryakukbumukbn = new ExDBFieldString<>("kakukisyouryakukbumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> seiymdmosseitouumukbn = new ExDBFieldString<>("seiymdmosseitouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> ikokakninsyotokkijkumu = new ExDBFieldString<>("ikokakninsyotokkijkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> trtkhoukokusyotokkijkumu = new ExDBFieldString<>("trtkhoukokusyotokkijkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> hnnkakninhskjikouumukbn = new ExDBFieldString<>("hnnkakninhskjikouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> hnnkakninhsktkjikouumukbn = new ExDBFieldString<>("hnnkakninhsktkjikouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> skskakninhsktkjikouumukbn = new ExDBFieldString<>("skskakninhsktkjikouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, String> khnchkcmnt = new ExDBFieldString<>("khnchkcmnt", this);

    public final ExDBFieldString<HT_BosKihon, C_MosTourokuJyoukyouKbn> mostourokujyoukyoukbn = new ExDBFieldString<>("mostourokujyoukyoukbn", this, UserType_C_MosTourokuJyoukyouKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_UmuKbn> pplessdatasousinumukbn = new ExDBFieldString<>("pplessdatasousinumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_MobilebosyuuKbn> mobilebosyuukbn = new ExDBFieldString<>("mobilebosyuukbn", this, UserType_C_MobilebosyuuKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_TumitatekinHaibunWariKbn> teirituhaibunwarikbn = new ExDBFieldString<>("teirituhaibunwarikbn", this, UserType_C_TumitatekinHaibunWariKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_Sisuukbn> sisuukbn = new ExDBFieldString<>("sisuukbn", this, UserType_C_Sisuukbn.class);

    public final ExDBFieldString<HT_BosKihon, C_TumitatekinHaibunWariKbn> sisuuhaibunwarikbn = new ExDBFieldString<>("sisuuhaibunwarikbn", this, UserType_C_TumitatekinHaibunWariKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_TrhkjiKakKbn> trhkjikakkbn = new ExDBFieldString<>("trhkjikakkbn", this, UserType_C_TrhkjiKakKbn.class);

    public final ExDBFieldString<HT_BosKihon, C_KoureisyaTaiouKbn> koureitaioukbn = new ExDBFieldString<>("koureitaioukbn", this, UserType_C_KoureisyaTaiouKbn.class);

    public final ExDBFieldString<HT_BosKihon, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_BosKihon, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
