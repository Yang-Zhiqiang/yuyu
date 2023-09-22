package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 新契約 新契約共通 差異データ登録RegisterSaiDataMousikomisyoインタフェース
 */
public interface SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParam {

    String getMosno();

    String getAitemosno();

    String getDoujikaiyakusyono();

    BizDate getMosymd();

    String getJimuyoucd();

    C_HknsyuruiNo getHknsyuruino();

    C_KykKbn getKykkbn();

    C_YakkanJyuryouKbn getYakkanjyuryouhoukbn();

    C_FatcasnsiKbn getFatcasnsikbn();

    C_BikkjnssinfoKbn getBikkjnssinfokbn();

    String getBikknzsyno();

    C_AeoisnsiKbn getAeoisnsikbn();

    String getKyknmkn();

    String getKyknmkj();

    C_KjkhukaKbn getKyknmkjkhukakbn();

    BizDate getKykseiymd();

    C_Kyksei getKyksei();

    C_Tdk getKyktdk();

    String getTsinyno();

    String getTsinadr1kj();

    String getTsinadr2kj();

    String getTsinadr3kj();

    String getTsintelno();

    String getDai2tsintelno();

    String getHhknnmkn();

    String getHhknnmkj();

    C_KjkhukaKbn getHhknnmkjkhukakbn();

    BizDate getHhknseiymd();

    C_Hhknsei getHhknsei();

    C_TsindousiteiKbn getTsindousiteikbn();

    String getHhknyno();

    String getHhknadr1kj();

    String getHhknadr2kj();

    String getHhknadr3kj();

    String getHhkntelno();

    BizDate getKktymd();

    String getHhknsykgycd();

    C_NensyuuKbn getHhknnensyuukbn();

    C_UktKbn getNenkinuktkbn();

    Integer getSbuktnin();

    C_UktKbn getSibouuktkbn1();

    String getSibouuktnmkana1();

    String getSibouuktnmkanji1();

    C_KjkhukaKbn getSibouuktnmkanjikahukakbn1();

    BizDate getSibouuktseiymd1();

    C_Tdk getSibouukttdk1();

    BizNumber getSibouuktbnwari1();

    C_UktKbn getSibouuktkbn2();

    String getSibouuktnmkana2();

    String getSibouuktnmkanji2();

    C_KjkhukaKbn getSibouuktnmkanjikahukakbn2();

    BizDate getSibouuktseiymd2();

    C_Tdk getSibouukttdk2();

    BizNumber getSibouuktbnwari2();

    C_UktKbn getSibouuktkbn3();

    String getSibouuktnmkana3();

    String getSibouuktnmkanji3();

    C_KjkhukaKbn getSibouuktnmkanjikahukakbn3();

    BizDate getSibouuktseiymd3();

    C_Tdk getSibouukttdk3();

    BizNumber getSibouuktbnwari3();

    C_UktKbn getSibouuktkbn4();

    String getSibouuktnmkana4();

    String getSibouuktnmkanji4();

    C_KjkhukaKbn getSibouuktnmkanjikahukakbn4();

    BizDate getSibouuktseiymd4();

    C_Tdk getSibouukttdk4();

    BizNumber getSibouuktbnwari4();

    String getSyudai1hknkknmosinput();

    C_Sdpd getSdpdkbn();

    C_Tuukasyu getKyktuukasyu();

    C_Tuukasyu getHrktuukasyu();

    BizCurrency getKihons();

    Integer getSyuhknkkn();

    Integer getSyuhrkkkn();

    Integer getPhrkmnrynen();

    Integer getNkshrstartnen();

    BizCurrency getHrktuukasyukykp();

    BizCurrency getMosikkatup();

    BizCurrency getMossyukykp();

    BizCurrency getMoszennoupsyokaiari();

    C_TumitatekinHaibunWariKbn getTeirituhaibunwarikbn();

    C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn();

    String getSueokikknmosinput();

    C_Sknenkinsyu getSknenkinsyu();

    C_NkgnsHosyourituKbn getNkgnshosyouritukbn();

    C_Tuukasyu getKyktuukasyu2();

    C_Tuukasyu getHrktuukasyu2();

    BizCurrency getKihons2();

    BizCurrency getHrktuukasyukykp2();

    BizCurrency getMosikkatup2();

    BizCurrency getMoszennoupsyokaiari2();

    C_Tkhukaumu getKjnnkpzeitekitkhukakbn2();

    C_Hrkkaisuu getHrkkaisuu();

    C_Hrkkeiro getHrkkeiro();

    C_FstphrkkeiroKbn getFstphrkkeirokbn();

    C_BlnktkumuKbn getZenkizennouumu();

    Integer getZnnkai();

    C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu();

    C_Tkhukaumu getSyksbyensitihsyutkhkkbn();

    C_Tkhukaumu getJyudkaigomehrtkhkkbn();

    C_Tkhukaumu getNstkhkkbn();

    Integer getNstksbnkkn();

    C_Tkhukaumu getKjnnkpzeitekitkhukakbn();

    C_TargetTkMokuhyoutiKbn getTargettkmkhtkbn();

    C_Tkhukaumu getTeikisiharaitkykhkkbn();

    C_KouzaInfoInputHoryuuKbn getShkstkzinfkzinfoinputhrykbn();

    C_KouzasyuruiKbn getKzsyuruikbn();

    String getBankcd();

    String getSitencd();

    C_YokinKbn getYokinkbn();

    String getKouzano();

    C_KzkykdouKbn getKzkykdoukbn();

    String getKzmeiginmkn();

    C_KzktourokuserviceTourokuKbn getKzktourokuservicetourokukbn();

    String getTrkkzknmkn1();

    String getTrkkzknmkj1();

    C_KjkhukaKbn getTrkkzknmkjkhukakbn1();

    BizDate getTrkkzkseiymd1();

    C_Seibetu getTrkkzksei1();

    C_Tdk getTrkkzktdk1();

    C_TsindousiteiKbn getTrkkzktsindousiteikbn1();

    String getTrkkzkyno1();

    String getTrkkzkadr1kj1();

    String getTrkkzkadr2kj1();

    String getTrkkzkadr3kj1();

    String getTrkkzktelno1();

    C_Tkhukaumu getStdrsktkyhkkbn();

    C_UktKbn getStdruktkbn();

    String getSiteidruktnmkn();

    String getSiteidruktnmkj();

    C_KjkhukaKbn getStdrsknmkjhukakbn();

    BizDate getStdrskseiymd();

    C_Tdk getStdrsktdk();

    C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn();

    C_HonninkakuninSyoruiKbn getSkskknhonninkakninsyoruikbn();

    C_KoureiKzkSetumeiHouKbn getKoureikzksetumeihoukbn();

    C_KoureiMndnHukusuukaiKbn getKoureimndnhukusuukaikbn();

    C_KoureiTratkisyaIgiDskKbn getKoureitratkisyaigidskkbn();

    C_KouzaInfoInputHoryuuKbn getKouzainfoinputhoryuukbn();

    String getKouhurikouzainfobankcd();

    String getKouhurikouzainfositencd();

    C_YokinKbn getKouhurikouzainfoyokinkbn();

    String getKouhurikouzainfokouzano();

    C_KzkykdouKbn getKouhurikouzainfokzdoukbn();

    String getKouhurikouzainfokzmeiginmkn();

    C_YouhiblnkKbn getKouzakakuniniraikbn();

    //  2016/03/03 S社導入：コメントアウト
    //    String getTokuyakusyouhincd1();
    //
    //    C_KataKbn getTokuyakukatakbn1();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn1();
    //
    //    BizCurrency getTokuyakukihons1();
    //
    //    Integer getTokuyakuhokenkikan1();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn1();
    //
    //    Integer getTokuyakuharaikomikikan1();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn1();
    //
    //    String getTokuyakusyouhincd2();
    //
    //    C_KataKbn getTokuyakukatakbn2();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn2();
    //
    //    BizCurrency getTokuyakukihons2();
    //
    //    Integer getTokuyakuhokenkikan2();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn2();
    //
    //    Integer getTokuyakuharaikomikikan2();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn2();
    //
    //    String getTokuyakusyouhincd3();
    //
    //    C_KataKbn getTokuyakukatakbn3();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn3();
    //
    //    BizCurrency getTokuyakukihons3();
    //
    //    Integer getTokuyakuhokenkikan3();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn3();
    //
    //    Integer getTokuyakuharaikomikikan3();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn3();
    //
    //    String getTokuyakusyouhincd4();
    //
    //    C_KataKbn getTokuyakukatakbn4();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn4();
    //
    //    BizCurrency getTokuyakukihons4();
    //
    //    Integer getTokuyakuhokenkikan4();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn4();
    //
    //    Integer getTokuyakuharaikomikikan4();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn4();
    //
    //    String getTokuyakusyouhincd5();
    //
    //    C_KataKbn getTokuyakukatakbn5();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn5();
    //
    //    BizCurrency getTokuyakukihons5();
    //
    //    Integer getTokuyakuhokenkikan5();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn5();
    //
    //    Integer getTokuyakuharaikomikikan5();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn5();
    //
    //    String getTokuyakusyouhincd6();
    //
    //    C_KataKbn getTokuyakukatakbn6();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn6();
    //
    //    BizCurrency getTokuyakukihons6();
    //
    //    Integer getTokuyakuhokenkikan6();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn6();
    //
    //    Integer getTokuyakuharaikomikikan6();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn6();
    //
    //    String getTokuyakusyouhincd7();
    //
    //    C_KataKbn getTokuyakukatakbn7();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn7();
    //
    //    BizCurrency getTokuyakukihons7();
    //
    //    Integer getTokuyakuhokenkikan7();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn7();
    //
    //    Integer getTokuyakuharaikomikikan7();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn7();
    //
    //    String getTokuyakusyouhincd8();
    //
    //    C_KataKbn getTokuyakukatakbn8();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn8();
    //
    //    BizCurrency getTokuyakukihons8();
    //
    //    Integer getTokuyakuhokenkikan8();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn8();
    //
    //    Integer getTokuyakuharaikomikikan8();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn8();
    //
    //    String getTokuyakusyouhincd9();
    //
    //    C_KataKbn getTokuyakukatakbn9();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn9();
    //
    //    BizCurrency getTokuyakukihons9();
    //
    //    Integer getTokuyakuhokenkikan9();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn9();
    //
    //    Integer getTokuyakuharaikomikikan9();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn9();
    //
    //    String getTokuyakusyouhincd10();
    //
    //    C_KataKbn getTokuyakukatakbn10();
    //
    //    C_KyhgndkataKbn getTokuyakukyuhutukikatakbn10();
    //
    //    BizCurrency getTokuyakukihons10();
    //
    //    Integer getTokuyakuhokenkikan10();
    //
    //    C_HknkknsmnKbn getTokuyakuhknkknsmnkbn10();
    //
    //    Integer getTokuyakuharaikomikikan10();
    //
    //    C_HrkkknsmnKbn getTokuyakuhrkkknsmnkbn10();

    String getDrtenjimcd1();

    String getDairitenkinyuukikancd1();

    String getDairitenkinyuukikansitencd1();

    String getDairitentoriatukaikouincd1();

    String getInputbosyuucd1();

    String getBosyuunintourokuno1();

    String getGyousekikeijyousakisosikicd1();

    BizNumber getDairitenbuntanwariai1();

    String getCifcd();

    String getUktkid();

    String getDrtenjimcd2();

    String getDairitenkinyuukikancd2();

    String getDairitenkinyuukikansitencd2();

    String getDairitentoriatukaikouincd2();

    String getInputbosyuucd2();

    String getBosyuunintourokuno2();

    String getGyousekikeijyousakisosikicd2();

    C_UmuKbn getTsryhshrkykumukbn();

    C_UmuKbn getSyosisyatodokeumukbn();

    C_UmuKbn getKakukisyouryakukbumukbn();

    C_UmuKbn getSeiymdmosseitouumukbn();

    C_DirectServiceMosKbn getDrctservicemoskbn();

    C_YnkHrkmgkAnniTuutiKbn getYnkhrkmgkannituutikbn();

    C_UmuKbn getTkhsyouryakuumukbn();
}