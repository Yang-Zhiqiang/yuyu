package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
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
 * 差異データ登録RegisterSaiDataMousikomisyoインタフェースの実装クラス
 */
public class SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParamImpl extends AbstractUiBean
implements SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParam {

    private static final long serialVersionUID = 1L;
    private String mosno;
    private String aitemosno;
    private String doujikaiyakusyono;
    private BizDate mosymd;
    private String jimuyoucd;
    private C_HknsyuruiNo hknsyuruino;
    private C_KykKbn kykkbn;
    private C_YakkanJyuryouKbn yakkanjyuryouhoukbn;
    private C_FatcasnsiKbn fatcasnsikbn;
    private C_BikkjnssinfoKbn bikkjnssinfokbn;
    private String bikknzsyno;
    private C_AeoisnsiKbn aeoisnsikbn;
    private C_Tdk kyktdk;
    private String kyknmkn;
    private String kyknmkj;
    private C_KjkhukaKbn kyknmkjkhukakbn;
    private BizDate kykseiymd;
    private C_Kyksei kyksei;
    private String tsinyno;
    private String tsinadr1kj;
    private String tsinadr2kj;
    private String tsinadr3kj;
    private String tsintelno;
    private String dai2tsintelno;
    private String hhknnmkn;
    private String hhknnmkj;
    private C_KjkhukaKbn hhknnmkjkhukakbn;
    private BizDate hhknseiymd;
    private C_Hhknsei hhknsei;
    private String hhknsykgycd;
    private BizDate kktymd;
    private C_NensyuuKbn hhknnensyuukbn;
    private C_TsindousiteiKbn tsindousiteikbn;
    private String hhknyno;
    private String hhknadr1kj;
    private String hhknadr2kj;
    private String hhknadr3kj;
    private String hhkntelno;
    private C_Sdpd sdpdkbn;
    private C_Tuukasyu kyktuukasyu;
    private C_Tuukasyu hrktuukasyu;
    private BizCurrency kihons;
    private BizCurrency hrktuukasyukykp;
    private BizCurrency mosikkatup;
    private BizCurrency mossyukykp;
    private BizCurrency moszennoupsyokaiari;
    private C_TumitatekinHaibunWariKbn teirituhaibunwarikbn;
    private C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn;
    private String sueokikknmosinput;
    private C_Sknenkinsyu sknenkinsyu;
    private C_NkgnsHosyourituKbn nkgnshosyouritukbn;
    private C_Tuukasyu kyktuukasyu2;
    private C_Tuukasyu hrktuukasyu2;
    private BizCurrency kihons2;
    private BizCurrency hrktuukasyukykp2;
    private BizCurrency mosikkatup2;
    private BizCurrency moszennoupsyokaiari2;
    private C_Tkhukaumu kjnnkpzeitekitkhukakbn2;
    private C_Tkhukaumu nstkhkkbn;
    private Integer nstksbnkkn;
    private C_TargetTkMokuhyoutiKbn targettkmkhtkbn;
    private C_Tkhukaumu teikisiharaitkykhkkbn;
    private C_KouzaInfoInputHoryuuKbn shkstkzinfkzinfoinputhrykbn;
    private C_KouzasyuruiKbn kzsyuruikbn;
    private String bankcd;
    private String sitencd;
    private C_KzkykdouKbn kzkykdoukbn;
    private C_UktKbn nenkinuktkbn;
    private Integer sbuktnin;
    private C_UktKbn sibouuktkbn1;
    private String sibouuktnmkana1;
    private String sibouuktnmkanji1;
    private C_KjkhukaKbn sibouuktnmkanjikahukakbn1;
    private BizDate sibouuktseiymd1;
    private C_Tdk sibouukttdk1;
    private BizNumber sibouuktbnwari1;
    private C_UktKbn sibouuktkbn2;
    private String sibouuktnmkana2;
    private String sibouuktnmkanji2;
    private C_KjkhukaKbn sibouuktnmkanjikahukakbn2;
    private BizDate sibouuktseiymd2;
    private C_Tdk sibouukttdk2;
    private BizNumber sibouuktbnwari2;
    private C_UktKbn sibouuktkbn3;
    private String sibouuktnmkana3;
    private String sibouuktnmkanji3;
    private C_KjkhukaKbn sibouuktnmkanjikahukakbn3;
    private BizDate sibouuktseiymd3;
    private C_Tdk sibouukttdk3;
    private BizNumber sibouuktbnwari3;
    private C_UktKbn sibouuktkbn4;
    private String sibouuktnmkana4;
    private String sibouuktnmkanji4;
    private C_KjkhukaKbn sibouuktnmkanjikahukakbn4;
    private BizDate sibouuktseiymd4;
    private C_Tdk sibouukttdk4;
    private BizNumber sibouuktbnwari4;
    private C_KzktourokuserviceTourokuKbn kzktourokuserviceTourokuKbn;
    private String trkkzknmkn1;
    private String trkkzknmkj1;
    private C_KjkhukaKbn trkkzknmkjkhukakbn1;
    private BizDate trkkzkseiymd1;
    private C_Seibetu trkkzksei1;
    private C_Tdk trkkzktdk1;
    private C_TsindousiteiKbn trkkzktsindousiteikbn1;
    private String trkkzkyno1;
    private String trkkzkadr1kj1;
    private String trkkzkadr2kj1;
    private String trkkzkadr3kj1;
    private String trkkzktelno1;
    private C_Tkhukaumu stdrsktkyhkkbn;
    private C_UktKbn stdruktkbn;
    private String siteidruktnmkn;
    private String siteidruktnmkj;
    private C_KjkhukaKbn stdrsknmkjhukakbn;
    private BizDate stdrskseiymd;
    private C_Tdk stdrsktdk;
    private C_YokinKbn yokinkbn;
    private String kouzano;
    private String kzmeiginmkn;
    private C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn;
    private C_HonninkakuninSyoruiKbn skskknhonninkakninsyoruikbn;
    private C_KoureiKzkSetumeiHouKbn koureikzksetumeihoukbn;
    private C_KoureiMndnHukusuukaiKbn koureimndnhukusuukaikbn;
    private C_KoureiTratkisyaIgiDskKbn koureitratkisyaigidskkbn;
    private String cifcd;
    private String uktkid;
    private String drtenjimcd1;
    private String bosyuunintourokuno1;
    private String dairitenkinyuukikancd1;
    private String dairitenkinyuukikansitencd1;
    private String dairitentoriatukaikouincd1;
    private String inputbosyuucd1;
    private String gyousekikeijyousakisosikicd1;
    private BizNumber dairitenbuntanwariai1;
    private String drtenjimcd2;
    private String bosyuunintourokuno2;
    private String dairitenkinyuukikancd2;
    private String dairitenkinyuukikansitencd2;
    private String dairitentoriatukaikouincd2;
    private String inputbosyuucd2;
    private String gyousekikeijyousakisosikicd2;
    private C_UmuKbn tsryhshrkykumukbn;
    private C_UmuKbn syosisyatodokeumukbn;
    private C_UmuKbn kakukisyouryakukbumukbn;
    private C_UmuKbn seiymdmosseitouumukbn;
    private C_DirectServiceMosKbn drctservicemoskbn;
    private C_YnkHrkmgkAnniTuutiKbn ynkhrkmgkannituutikbn;
    private C_UmuKbn tkhsyouryakuumukbn;
    private String syudai1hknkknmosinput;
    private C_Tkhukaumu syksbyensitihsyutkhkkbn;
    private C_Tkhukaumu jyudkaigomehrtkhkkbn;
    private Integer syuhknkkn;
    private Integer syuhrkkkn;
    private Integer phrkmnrynen;
    private Integer nkshrstartnen;
    private C_Hrkkaisuu hrkkaisuu;
    private C_Hrkkeiro hrkkeiro;
    private C_FstphrkkeiroKbn fstphrkkeirokbn;
    private C_BlnktkumuKbn zenkizennouumu;
    private Integer znnkai;
    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;
    private C_Tkhukaumu kjnnkpzeitekitkhukakbn;
    private C_KouzaInfoInputHoryuuKbn kouzainfoinputhoryuukbn;
    private String kouhurikouzainfobankcd;
    private String kouhurikouzainfositencd;
    private C_YokinKbn kouhurikouzainfoyokinkbn;
    private String kouhurikouzainfokouzano;
    private C_KzkykdouKbn kouhurikouzainfokzdoukbn;
    private String kouhurikouzainfokzmeiginmkn;
    private C_YouhiblnkKbn kouzakakuniniraikbn;
    @Override
    public String getMosno() {
        return mosno;
    }
    @Override
    public String getAitemosno() {
        return aitemosno;
    }
    @Override
    public String getDoujikaiyakusyono() {
        return doujikaiyakusyono;
    }
    @Override
    public BizDate getMosymd() {
        return mosymd;
    }
    @Override
    public String getJimuyoucd() {
        return jimuyoucd;
    }

    @Override
    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    @Override
    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    @Override
    public C_YakkanJyuryouKbn getYakkanjyuryouhoukbn() {
        return yakkanjyuryouhoukbn;
    }

    @Override
    public C_FatcasnsiKbn getFatcasnsikbn() {
        return fatcasnsikbn;
    }

    @Override
    public C_BikkjnssinfoKbn getBikkjnssinfokbn() {
        return bikkjnssinfokbn;
    }

    @Override
    public String getBikknzsyno() {
        return bikknzsyno;
    }

    @Override
    public C_AeoisnsiKbn getAeoisnsikbn() {
        return aeoisnsikbn;
    }

    @Override
    public C_Tdk getKyktdk() {
        return kyktdk;
    }
    @Override
    public String getKyknmkn() {
        return kyknmkn;
    }
    @Override
    public String getKyknmkj() {
        return kyknmkj;
    }
    @Override
    public C_KjkhukaKbn getKyknmkjkhukakbn(){
        return kyknmkjkhukakbn;
    }

    @Override
    public BizDate getKykseiymd() {
        return kykseiymd;
    }
    @Override
    public C_Kyksei getKyksei() {
        return kyksei;
    }
    @Override
    public String getTsinyno() {
        return tsinyno;
    }
    @Override
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }
    @Override
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }
    @Override
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }
    @Override
    public String getTsintelno() {
        return tsintelno;
    }
    @Override
    public String getDai2tsintelno() {
        return dai2tsintelno;
    }
    @Override
    public String getHhknnmkn() {
        return hhknnmkn;
    }
    @Override
    public String getHhknnmkj() {
        return hhknnmkj;
    }
    @Override
    public C_KjkhukaKbn getHhknnmkjkhukakbn(){
        return hhknnmkjkhukakbn;
    }

    @Override
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }
    @Override
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }
    @Override
    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Override
    public BizDate getKktymd() {
        return kktymd;
    }

    @Override
    public C_NensyuuKbn getHhknnensyuukbn() {
        return hhknnensyuukbn;
    }

    @Override
    public C_TsindousiteiKbn getTsindousiteikbn() {
        return tsindousiteikbn;
    }
    @Override
    public String getHhknyno() {
        return hhknyno;
    }
    @Override
    public String getHhknadr1kj() {
        return hhknadr1kj;
    }
    @Override
    public String getHhknadr2kj() {
        return hhknadr2kj;
    }
    @Override
    public String getHhknadr3kj() {
        return hhknadr3kj;
    }
    @Override
    public String getHhkntelno() {
        return hhkntelno;
    }

    @Override
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    @Override
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    @Override
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    @Override
    public BizCurrency getKihons() {
        return kihons;
    }

    @Override
    public BizCurrency getHrktuukasyukykp() {
        return hrktuukasyukykp;
    }

    @Override
    public BizCurrency getMosikkatup() {
        return mosikkatup;
    }

    @Override
    public BizCurrency getMossyukykp() {
        return mossyukykp;
    }

    @Override
    public BizCurrency getMoszennoupsyokaiari() {
        return moszennoupsyokaiari;
    }

    @Override
    public C_TumitatekinHaibunWariKbn getTeirituhaibunwarikbn() {
        return teirituhaibunwarikbn;
    }

    @Override
    public C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn() {
        return sisuuhaibunwarikbn;
    }

    @Override
    public String getSueokikknmosinput() {
        return sueokikknmosinput;
    }

    @Override
    public C_Sknenkinsyu getSknenkinsyu() {
        return sknenkinsyu;
    }

    @Override
    public C_NkgnsHosyourituKbn getNkgnshosyouritukbn() {
        return nkgnshosyouritukbn;
    }

    @Override
    public C_Tuukasyu getKyktuukasyu2() {
        return kyktuukasyu2;
    }

    @Override
    public C_Tuukasyu getHrktuukasyu2() {
        return hrktuukasyu2;
    }

    @Override
    public BizCurrency getKihons2() {
        return kihons2;
    }

    @Override
    public BizCurrency getHrktuukasyukykp2() {
        return hrktuukasyukykp2;
    }

    @Override
    public BizCurrency getMosikkatup2() {
        return mosikkatup2;
    }

    @Override
    public BizCurrency getMoszennoupsyokaiari2() {
        return moszennoupsyokaiari2;
    }

    @Override
    public C_Tkhukaumu getKjnnkpzeitekitkhukakbn2() {
        return kjnnkpzeitekitkhukakbn2;
    }

    @Override
    public C_Tkhukaumu getNstkhkkbn() {
        return nstkhkkbn;
    }

    @Override
    public Integer getNstksbnkkn() {
        return nstksbnkkn;
    }

    @Override
    public C_TargetTkMokuhyoutiKbn getTargettkmkhtkbn() {
        return targettkmkhtkbn;
    }

    @Override
    public C_Tkhukaumu getTeikisiharaitkykhkkbn() {
        return teikisiharaitkykhkkbn;
    }

    @Override
    public C_KouzaInfoInputHoryuuKbn getShkstkzinfkzinfoinputhrykbn() {
        return shkstkzinfkzinfoinputhrykbn;
    }

    @Override
    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    @Override
    public String getBankcd() {
        return bankcd;
    }

    @Override
    public String getSitencd() {
        return sitencd;
    }

    @Override
    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    @Override
    public C_UktKbn getNenkinuktkbn() {
        return nenkinuktkbn;
    }

    @Override
    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Override
    public C_UktKbn getSibouuktkbn1() {
        return sibouuktkbn1;
    }

    @Override
    public String getSibouuktnmkana1() {
        return sibouuktnmkana1;
    }

    @Override
    public String getSibouuktnmkanji1() {
        return sibouuktnmkanji1;
    }

    @Override
    public C_KjkhukaKbn getSibouuktnmkanjikahukakbn1() {
        return sibouuktnmkanjikahukakbn1;
    }

    @Override
    public BizDate getSibouuktseiymd1() {
        return sibouuktseiymd1;
    }

    @Override
    public C_Tdk getSibouukttdk1() {
        return sibouukttdk1;
    }

    @Override
    public BizNumber getSibouuktbnwari1() {
        return sibouuktbnwari1;
    }

    @Override
    public C_UktKbn getSibouuktkbn2() {
        return sibouuktkbn2;
    }

    @Override
    public String getSibouuktnmkana2() {
        return sibouuktnmkana2;
    }

    @Override
    public String getSibouuktnmkanji2() {
        return sibouuktnmkanji2;
    }

    @Override
    public C_KjkhukaKbn getSibouuktnmkanjikahukakbn2() {
        return sibouuktnmkanjikahukakbn2;
    }

    @Override
    public BizDate getSibouuktseiymd2() {
        return sibouuktseiymd2;
    }

    @Override
    public C_Tdk getSibouukttdk2() {
        return sibouukttdk2;
    }

    @Override
    public BizNumber getSibouuktbnwari2() {
        return sibouuktbnwari2;
    }

    @Override
    public C_UktKbn getSibouuktkbn3() {
        return sibouuktkbn3;
    }

    @Override
    public String getSibouuktnmkana3() {
        return sibouuktnmkana3;
    }

    @Override
    public String getSibouuktnmkanji3() {
        return sibouuktnmkanji3;
    }

    @Override
    public C_KjkhukaKbn getSibouuktnmkanjikahukakbn3() {
        return sibouuktnmkanjikahukakbn3;
    }

    @Override
    public BizDate getSibouuktseiymd3() {
        return sibouuktseiymd3;
    }

    @Override
    public C_Tdk getSibouukttdk3() {
        return sibouukttdk3;
    }

    @Override
    public BizNumber getSibouuktbnwari3() {
        return sibouuktbnwari3;
    }

    @Override
    public C_UktKbn getSibouuktkbn4() {
        return sibouuktkbn4;
    }

    @Override
    public String getSibouuktnmkana4() {
        return sibouuktnmkana4;
    }

    @Override
    public String getSibouuktnmkanji4() {
        return sibouuktnmkanji4;
    }

    @Override
    public C_KjkhukaKbn getSibouuktnmkanjikahukakbn4() {
        return sibouuktnmkanjikahukakbn4;
    }

    @Override
    public BizDate getSibouuktseiymd4() {
        return sibouuktseiymd4;
    }

    @Override
    public C_Tdk getSibouukttdk4() {
        return sibouukttdk4;
    }

    @Override
    public BizNumber getSibouuktbnwari4() {
        return sibouuktbnwari4;
    }

    @Override
    public C_Tkhukaumu getStdrsktkyhkkbn() {
        return stdrsktkyhkkbn;
    }

    @Override
    public C_UktKbn getStdruktkbn() {
        return stdruktkbn;
    }

    @Override
    public String getSiteidruktnmkn() {
        return siteidruktnmkn;
    }

    @Override
    public String getSiteidruktnmkj() {
        return siteidruktnmkj;
    }

    @Override
    public C_KjkhukaKbn getStdrsknmkjhukakbn() {
        return stdrsknmkjhukakbn;
    }

    @Override
    public C_Tdk getStdrsktdk() {
        return stdrsktdk;
    }

    @Override
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    @Override
    public String getKouzano() {
        return kouzano;
    }

    @Override
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Override
    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn() {
        return kykhonninkakninsyoruikbn;
    }

    @Override
    public C_HonninkakuninSyoruiKbn getSkskknhonninkakninsyoruikbn() {
        return skskknhonninkakninsyoruikbn;
    }

    @Override
    public C_KoureiKzkSetumeiHouKbn getKoureikzksetumeihoukbn() {
        return koureikzksetumeihoukbn;
    }

    @Override
    public C_KoureiMndnHukusuukaiKbn getKoureimndnhukusuukaikbn() {
        return koureimndnhukusuukaikbn;
    }

    @Override
    public C_KoureiTratkisyaIgiDskKbn getKoureitratkisyaigidskkbn() {
        return koureitratkisyaigidskkbn;
    }

    @Override
    public String getCifcd() {
        return cifcd;
    }

    @Override
    public String getUktkid() {
        return uktkid;
    }
    @Override
    public String getDrtenjimcd1() {
        return drtenjimcd1;
    }

    @Override
    public String getBosyuunintourokuno1() {
        return bosyuunintourokuno1;
    }

    @Override
    public String getDairitenkinyuukikancd1() {
        return dairitenkinyuukikancd1;
    }

    @Override
    public String getDairitenkinyuukikansitencd1() {
        return dairitenkinyuukikansitencd1;
    }

    @Override
    public String getDairitentoriatukaikouincd1() {
        return dairitentoriatukaikouincd1;
    }

    @Override
    public String getInputbosyuucd1() {
        return inputbosyuucd1;
    }

    @Override
    public String getGyousekikeijyousakisosikicd1() {
        return gyousekikeijyousakisosikicd1;
    }

    @Override
    public BizNumber getDairitenbuntanwariai1() {
        return dairitenbuntanwariai1;
    }

    @Override
    public String getDrtenjimcd2() {
        return drtenjimcd2;
    }

    @Override
    public String getBosyuunintourokuno2() {
        return bosyuunintourokuno2;
    }

    @Override
    public String getDairitenkinyuukikancd2() {
        return dairitenkinyuukikancd2;
    }

    @Override
    public String getDairitenkinyuukikansitencd2() {
        return dairitenkinyuukikansitencd2;
    }

    @Override
    public String getDairitentoriatukaikouincd2() {
        return dairitentoriatukaikouincd2;
    }

    @Override
    public String getInputbosyuucd2() {
        return inputbosyuucd2;
    }

    @Override
    public String getGyousekikeijyousakisosikicd2() {
        return gyousekikeijyousakisosikicd2;
    }

    @Override
    public C_UmuKbn getTsryhshrkykumukbn() {
        return tsryhshrkykumukbn;
    }

    @Override
    public C_UmuKbn getSyosisyatodokeumukbn() {
        return syosisyatodokeumukbn;
    }

    @Override
    public C_UmuKbn getKakukisyouryakukbumukbn() {
        return kakukisyouryakukbumukbn;
    }

    @Override
    public C_UmuKbn getSeiymdmosseitouumukbn() {
        return seiymdmosseitouumukbn;
    }

    @Override
    public C_DirectServiceMosKbn getDrctservicemoskbn() {
        return drctservicemoskbn;
    }

    @Override
    public C_YnkHrkmgkAnniTuutiKbn getYnkhrkmgkannituutikbn() {
        return ynkhrkmgkannituutikbn;
    }

    @Override
    public C_UmuKbn getTkhsyouryakuumukbn() {
        return tkhsyouryakuumukbn;
    }

    @Override
    public String getSyudai1hknkknmosinput() {
        return syudai1hknkknmosinput;
    }

    @Override
    public C_Tkhukaumu getSyksbyensitihsyutkhkkbn() {
        return syksbyensitihsyutkhkkbn;
    }

    @Override
    public C_Tkhukaumu getJyudkaigomehrtkhkkbn() {
        return jyudkaigomehrtkhkkbn;
    }

    @Override
    public Integer getSyuhknkkn() {
        return syuhknkkn;
    }

    @Override
    public Integer getSyuhrkkkn() {
        return syuhrkkkn;
    }

    @Override
    public Integer getPhrkmnrynen() {
        return phrkmnrynen;
    }

    @Override
    public Integer getNkshrstartnen() {
        return nkshrstartnen;
    }

    @Override
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    @Override
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    @Override
    public C_BlnktkumuKbn getZenkizennouumu() {
        return zenkizennouumu;
    }

    @Override
    public Integer getZnnkai() {
        return znnkai;
    }

    @Override
    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    @Override
    public C_Tkhukaumu getKjnnkpzeitekitkhukakbn() {
        return kjnnkpzeitekitkhukakbn;
    }

    @Override
    public C_KouzaInfoInputHoryuuKbn getKouzainfoinputhoryuukbn() {
        return kouzainfoinputhoryuukbn;
    }

    @Override
    public String getKouhurikouzainfobankcd() {
        return kouhurikouzainfobankcd;
    }

    @Override
    public String getKouhurikouzainfositencd() {
        return kouhurikouzainfositencd;
    }

    @Override
    public C_YokinKbn getKouhurikouzainfoyokinkbn() {
        return kouhurikouzainfoyokinkbn;
    }

    @Override
    public String getKouhurikouzainfokouzano() {
        return kouhurikouzainfokouzano;
    }

    @Override
    public C_KzkykdouKbn getKouhurikouzainfokzdoukbn() {
        return kouhurikouzainfokzdoukbn;
    }

    @Override
    public String getKouhurikouzainfokzmeiginmkn() {
        return kouhurikouzainfokzmeiginmkn;
    }

    @Override
    public C_YouhiblnkKbn getKouzakakuniniraikbn() {
        return kouzakakuniniraikbn;
    }

    public void setMosno(String mosno) {
        this.mosno = mosno;
    }

    public void setAitemosno(String aitemosno) {
        this.aitemosno = aitemosno;
    }

    public void setDoujikaiyakusyono(String doujikaiyakusyono) {
        this.doujikaiyakusyono = doujikaiyakusyono;
    }

    public void setMosymd(BizDate mosymd) {
        this.mosymd = mosymd;
    }

    public void setJimuyoucd(String jimuyoucd) {
        this.jimuyoucd = jimuyoucd;
    }

    public void setHknsyuruino(C_HknsyuruiNo hknsyuruino) {
        this.hknsyuruino = hknsyuruino;
    }

    public void setKykkbn(C_KykKbn kykkbn) {
        this.kykkbn = kykkbn;
    }

    public void setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn yakkanjyuryouhoukbn) {
        this.yakkanjyuryouhoukbn = yakkanjyuryouhoukbn;
    }

    public void setFatcasnsikbn(C_FatcasnsiKbn fatcasnsikbn) {
        this.fatcasnsikbn = fatcasnsikbn;
    }

    public void setBikkjnssinfokbn(C_BikkjnssinfoKbn bikkjnssinfokbn) {
        this.bikkjnssinfokbn = bikkjnssinfokbn;
    }

    public void setAeoisnsikbn(C_AeoisnsiKbn aeoisnsikbn) {
        this.aeoisnsikbn = aeoisnsikbn;
    }

    public void setBikknzsyno(String bikknzsyno) {
        this.bikknzsyno = bikknzsyno;
    }

    public void setKyktdk(C_Tdk kyktdk) {
        this.kyktdk = kyktdk;
    }

    public void setKyknmkn(String kyknmkn) {
        this.kyknmkn = kyknmkn;
    }

    public void setKyknmkj(String kyknmkj) {
        this.kyknmkj = kyknmkj;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn kyknmkjkhukakbn) {
        this.kyknmkjkhukakbn = kyknmkjkhukakbn;
    }

    public void setKykseiymd(BizDate kykseiymd) {
        this.kykseiymd = kykseiymd;
    }

    public void setKyksei(C_Kyksei kyksei) {
        this.kyksei = kyksei;
    }

    public void setTsinyno(String tsinyno) {
        this.tsinyno = tsinyno;
    }

    public void setTsinadr1kj(String tsinadr1kj) {
        this.tsinadr1kj = tsinadr1kj;
    }

    public void setTsinadr2kj(String tsinadr2kj) {
        this.tsinadr2kj = tsinadr2kj;
    }

    public void setTsinadr3kj(String tsinadr3kj) {
        this.tsinadr3kj = tsinadr3kj;
    }

    public void setTsintelno(String tsintelno) {
        this.tsintelno = tsintelno;
    }

    public void setDai2tsintelno(String dai2tsintelno) {
        this.dai2tsintelno = dai2tsintelno;
    }

    public void setHhknnmkn(String hhknnmkn) {
        this.hhknnmkn = hhknnmkn;
    }

    public void setHhknnmkj(String hhknnmkj) {
        this.hhknnmkj = hhknnmkj;
    }

    public void setHhknnmkjkhukakbn(C_KjkhukaKbn hhknnmkjkhukakbn) {
        this.hhknnmkjkhukakbn = hhknnmkjkhukakbn;
    }

    public void setHhknseiymd(BizDate hhknseiymd) {
        this.hhknseiymd = hhknseiymd;
    }

    public void setHhknsei(C_Hhknsei hhknsei) {
        this.hhknsei = hhknsei;
    }

    public void setHhknsykgycd(String hhknsykgycd) {
        this.hhknsykgycd = hhknsykgycd;
    }

    public void setKktymd(BizDate kktymd) {
        this.kktymd = kktymd;
    }

    public void setHhknnensyuukbn(C_NensyuuKbn hhknnensyuukbn) {
        this.hhknnensyuukbn = hhknnensyuukbn;
    }

    public void setTsindousiteikbn(C_TsindousiteiKbn tsindousiteikbn) {
        this.tsindousiteikbn = tsindousiteikbn;
    }

    public void setHhknyno(String hhknyno) {
        this.hhknyno = hhknyno;
    }

    public void setHhknadr1kj(String hhknadr1kj) {
        this.hhknadr1kj = hhknadr1kj;
    }

    public void setHhknadr2kj(String hhknadr2kj) {
        this.hhknadr2kj = hhknadr2kj;
    }

    public void setHhknadr3kj(String hhknadr3kj) {
        this.hhknadr3kj = hhknadr3kj;
    }

    public void setHhkntelno(String hhkntelno) {
        this.hhkntelno = hhkntelno;
    }

    public void setSdpdkbn(C_Sdpd sdpdkbn) {
        this.sdpdkbn = sdpdkbn;
    }

    public void setKyktuukasyu(C_Tuukasyu kyktuukasyu) {
        this.kyktuukasyu = kyktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu hrktuukasyu) {
        this.hrktuukasyu = hrktuukasyu;
    }

    public void setKihons(BizCurrency kihons) {
        this.kihons = kihons;
    }

    public void setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn teirituhaibunwarikbn) {
        this.teirituhaibunwarikbn = teirituhaibunwarikbn;
    }

    public void setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn) {
        this.sisuuhaibunwarikbn = sisuuhaibunwarikbn;
    }

    public void setSueokikknmosinput(String sueokikknmosinput) {
        this.sueokikknmosinput = sueokikknmosinput;
    }

    public void setHrktuukasyukykp(BizCurrency hrktuukasyukykp) {
        this.hrktuukasyukykp = hrktuukasyukykp;
    }

    public void setSknenkinsyu(C_Sknenkinsyu sknenkinsyu) {
        this.sknenkinsyu = sknenkinsyu;
    }

    public void setNkgnshosyouritukbn(C_NkgnsHosyourituKbn nkgnshosyouritukbn) {
        this.nkgnshosyouritukbn = nkgnshosyouritukbn;
    }

    public void setNstkhkkbn(C_Tkhukaumu nstkhkkbn) {
        this.nstkhkkbn = nstkhkkbn;
    }

    public void setNstksbnkkn(Integer nstksbnkkn) {
        this.nstksbnkkn = nstksbnkkn;
    }

    public void setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn targettkmkhtkbn) {
        this.targettkmkhtkbn = targettkmkhtkbn;
    }

    public C_KzktourokuserviceTourokuKbn getKzktourokuserviceTourokuKbn() {
        return kzktourokuserviceTourokuKbn;
    }

    public void setTeikisiharaitkykhkkbn(C_Tkhukaumu teikisiharaitkykhkkbn) {
        this.teikisiharaitkykhkkbn = teikisiharaitkykhkkbn;
    }

    public void setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn shkstkzinfkzinfoinputhrykbn) {
        this.shkstkzinfkzinfoinputhrykbn = shkstkzinfkzinfoinputhrykbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn kzsyuruikbn) {
        this.kzsyuruikbn = kzsyuruikbn;
    }

    public void setBankcd(String bankcd) {
        this.bankcd = bankcd;
    }

    public void setSitencd(String sitencd) {
        this.sitencd = sitencd;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn kzkykdoukbn) {
        this.kzkykdoukbn = kzkykdoukbn;
    }

    public void setNenkinuktkbn(C_UktKbn nenkinuktkbn) {
        this.nenkinuktkbn = nenkinuktkbn;
    }

    public void setSbuktnin(Integer sbuktnin) {
        this.sbuktnin = sbuktnin;
    }

    public void setSibouuktkbn1(C_UktKbn sibouuktkbn1) {
        this.sibouuktkbn1 = sibouuktkbn1;
    }

    public void setSibouuktnmkana1(String sibouuktnmkana1) {
        this.sibouuktnmkana1 = sibouuktnmkana1;
    }

    public void setSibouuktnmkanji1(String sibouuktnmkanji1) {
        this.sibouuktnmkanji1 = sibouuktnmkanji1;
    }

    public void setSibouuktnmkanjikahukakbn1(C_KjkhukaKbn sibouuktnmkanjikahukakbn1) {
        this.sibouuktnmkanjikahukakbn1 = sibouuktnmkanjikahukakbn1;
    }

    public void setSibouuktseiymd1(BizDate sibouuktseiymd1) {
        this.sibouuktseiymd1 = sibouuktseiymd1;
    }

    public void setSibouukttdk1(C_Tdk sibouukttdk1) {
        this.sibouukttdk1 = sibouukttdk1;
    }

    public void setSibouuktbnwari1(BizNumber sibouuktbnwari1) {
        this.sibouuktbnwari1 = sibouuktbnwari1;
    }

    public void setSibouuktkbn2(C_UktKbn sibouuktkbn2) {
        this.sibouuktkbn2 = sibouuktkbn2;
    }

    public void setSibouuktnmkana2(String sibouuktnmkana2) {
        this.sibouuktnmkana2 = sibouuktnmkana2;
    }

    public void setSibouuktnmkanji2(String sibouuktnmkanji2) {
        this.sibouuktnmkanji2 = sibouuktnmkanji2;
    }

    public void setSibouuktnmkanjikahukakbn2(C_KjkhukaKbn sibouuktnmkanjikahukakbn2) {
        this.sibouuktnmkanjikahukakbn2 = sibouuktnmkanjikahukakbn2;
    }

    public void setSibouuktseiymd2(BizDate sibouuktseiymd2) {
        this.sibouuktseiymd2 = sibouuktseiymd2;
    }

    public void setSibouukttdk2(C_Tdk sibouukttdk2) {
        this.sibouukttdk2 = sibouukttdk2;
    }

    public void setSibouuktbnwari2(BizNumber sibouuktbnwari2) {
        this.sibouuktbnwari2 = sibouuktbnwari2;
    }

    public void setSibouuktkbn3(C_UktKbn sibouuktkbn3) {
        this.sibouuktkbn3 = sibouuktkbn3;
    }

    public void setSibouuktnmkana3(String sibouuktnmkana3) {
        this.sibouuktnmkana3 = sibouuktnmkana3;
    }

    public void setSibouuktnmkanji3(String sibouuktnmkanji3) {
        this.sibouuktnmkanji3 = sibouuktnmkanji3;
    }

    public void setSibouuktnmkanjikahukakbn3(C_KjkhukaKbn sibouuktnmkanjikahukakbn3) {
        this.sibouuktnmkanjikahukakbn3 = sibouuktnmkanjikahukakbn3;
    }

    public void setSibouuktseiymd3(BizDate sibouuktseiymd3) {
        this.sibouuktseiymd3 = sibouuktseiymd3;
    }

    public void setSibouukttdk3(C_Tdk sibouukttdk3) {
        this.sibouukttdk3 = sibouukttdk3;
    }

    public void setSibouuktbnwari3(BizNumber sibouuktbnwari3) {
        this.sibouuktbnwari3 = sibouuktbnwari3;
    }

    public void setSibouuktkbn4(C_UktKbn sibouuktkbn4) {
        this.sibouuktkbn4 = sibouuktkbn4;
    }

    public void setSibouuktnmkana4(String sibouuktnmkana4) {
        this.sibouuktnmkana4 = sibouuktnmkana4;
    }

    public void setSibouuktnmkanji4(String sibouuktnmkanji4) {
        this.sibouuktnmkanji4 = sibouuktnmkanji4;
    }

    public void setSibouuktnmkanjikahukakbn4(C_KjkhukaKbn sibouuktnmkanjikahukakbn4) {
        this.sibouuktnmkanjikahukakbn4 = sibouuktnmkanjikahukakbn4;
    }

    public void setSibouuktseiymd4(BizDate sibouuktseiymd4) {
        this.sibouuktseiymd4 = sibouuktseiymd4;
    }

    public void setSibouukttdk4(C_Tdk sibouukttdk4) {
        this.sibouukttdk4 = sibouukttdk4;
    }

    public void setSibouuktbnwari4(BizNumber sibouuktbnwari4) {
        this.sibouuktbnwari4 = sibouuktbnwari4;
    }

    public void setStdrsktkyhkkbn(C_Tkhukaumu stdrsktkyhkkbn) {
        this.stdrsktkyhkkbn = stdrsktkyhkkbn;
    }

    public void setStdruktkbn(C_UktKbn stdruktkbn) {
        this.stdruktkbn = stdruktkbn;
    }

    public void setSiteidruktnmkn(String siteidruktnmkn) {
        this.siteidruktnmkn = siteidruktnmkn;
    }

    public void setSiteidruktnmkj(String siteidruktnmkj) {
        this.siteidruktnmkj = siteidruktnmkj;
    }

    public void setStdrsknmkjhukakbn(C_KjkhukaKbn stdrsknmkjhukakbn) {
        this.stdrsknmkjhukakbn = stdrsknmkjhukakbn;
    }

    public void setStdrsktdk(C_Tdk stdrsktdk) {
        this.stdrsktdk = stdrsktdk;
    }

    public void setYokinkbn(C_YokinKbn yokinkbn) {
        this.yokinkbn = yokinkbn;
    }

    public void setKouzano(String kouzano) {
        this.kouzano = kouzano;
    }

    public void setKzmeiginmkn(String kzmeiginmkn) {
        this.kzmeiginmkn = kzmeiginmkn;
    }

    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn) {
        this.kykhonninkakninsyoruikbn = kykhonninkakninsyoruikbn;
    }

    public void setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn skskknhonninkakninsyoruikbn) {
        this.skskknhonninkakninsyoruikbn = skskknhonninkakninsyoruikbn;
    }

    public void setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn koureikzksetumeihoukbn) {
        this.koureikzksetumeihoukbn = koureikzksetumeihoukbn;
    }

    public void setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn koureimndnhukusuukaikbn) {
        this.koureimndnhukusuukaikbn = koureimndnhukusuukaikbn;
    }

    public void setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn koureitratkisyaigidskkbn) {
        this.koureitratkisyaigidskkbn = koureitratkisyaigidskkbn;
    }

    public void setCifcd(String cifcd) {
        this.cifcd = cifcd;
    }

    public void setUktkid(String uktkid) {
        this.uktkid = uktkid;
    }

    public void setDrtenjimcd1(String drtenjimcd1) {
        this.drtenjimcd1 = drtenjimcd1;
    }

    public void setBosyuunintourokuno1(String bosyuunintourokuno1) {
        this.bosyuunintourokuno1 = bosyuunintourokuno1;
    }

    public void setDairitenkinyuukikancd1(String dairitenkinyuukikancd1) {
        this.dairitenkinyuukikancd1 = dairitenkinyuukikancd1;
    }

    public void setDairitenkinyuukikansitencd1(String dairitenkinyuukikansitencd1) {
        this.dairitenkinyuukikansitencd1 = dairitenkinyuukikansitencd1;
    }

    public void setDairitentoriatukaikouincd1(String dairitentoriatukaikouincd1) {
        this.dairitentoriatukaikouincd1 = dairitentoriatukaikouincd1;
    }

    public void setInputbosyuucd1(String inputbosyuucd1) {
        this.inputbosyuucd1 = inputbosyuucd1;
    }

    public void setGyousekikeijyousakisosikicd1(String gyousekikeijyousakisosikicd1) {
        this.gyousekikeijyousakisosikicd1 = gyousekikeijyousakisosikicd1;
    }

    public void setDairitenbuntanwariai1(BizNumber dairitenbuntanwariai1) {
        this.dairitenbuntanwariai1 = dairitenbuntanwariai1;
    }

    public void setDrtenjimcd2(String drtenjimcd2) {
        this.drtenjimcd2 = drtenjimcd2;
    }

    public void setBosyuunintourokuno2(String bosyuunintourokuno2) {
        this.bosyuunintourokuno2 = bosyuunintourokuno2;
    }

    public void setDairitenkinyuukikancd2(String dairitenkinyuukikancd2) {
        this.dairitenkinyuukikancd2 = dairitenkinyuukikancd2;
    }

    public void setDairitenkinyuukikansitencd2(String dairitenkinyuukikansitencd2) {
        this.dairitenkinyuukikansitencd2 = dairitenkinyuukikansitencd2;
    }

    public void setDairitentoriatukaikouincd2(String dairitentoriatukaikouincd2) {
        this.dairitentoriatukaikouincd2 = dairitentoriatukaikouincd2;
    }

    public void setInputbosyuucd2(String inputbosyuucd2) {
        this.inputbosyuucd2 = inputbosyuucd2;
    }

    public void setGyousekikeijyousakisosikicd2(String gyousekikeijyousakisosikicd2) {
        this.gyousekikeijyousakisosikicd2 = gyousekikeijyousakisosikicd2;
    }

    public void setTsryhshrkykumukbn(C_UmuKbn tsryhshrkykumukbn) {
        this.tsryhshrkykumukbn = tsryhshrkykumukbn;
    }

    public void setSyosisyatodokeumukbn(C_UmuKbn syosisyatodokeumukbn) {
        this.syosisyatodokeumukbn = syosisyatodokeumukbn;
    }

    public void setKakukisyouryakukbumukbn(C_UmuKbn kakukisyouryakukbumukbn) {
        this.kakukisyouryakukbumukbn = kakukisyouryakukbumukbn;
    }

    public void setSeiymdmosseitouumukbn(C_UmuKbn seiymdmosseitouumukbn) {
        this.seiymdmosseitouumukbn = seiymdmosseitouumukbn;
    }

    public void setDrctservicemoskbn(C_DirectServiceMosKbn drctservicemoskbn) {
        this.drctservicemoskbn = drctservicemoskbn;
    }

    public void setYnkhrkmgkannituutikbn(C_YnkHrkmgkAnniTuutiKbn ynkhrkmgkannituutikbn) {
        this.ynkhrkmgkannituutikbn = ynkhrkmgkannituutikbn;
    }

    public void setTkhsyouryakuumukbn(C_UmuKbn tkhsyouryakuumukbn) {
        this.tkhsyouryakuumukbn = tkhsyouryakuumukbn;
    }

    public void setSyudai1hknkknmosinput(String syudai1hknkknmosinput) {
        this.syudai1hknkknmosinput = syudai1hknkknmosinput;
    }

    public void setSyksbyensitihsyutkhkkbn(C_Tkhukaumu syksbyensitihsyutkhkkbn) {
        this.syksbyensitihsyutkhkkbn = syksbyensitihsyutkhkkbn;
    }

    public void setJyudkaigomehrtkhkkbn(C_Tkhukaumu jyudkaigomehrtkhkkbn) {
        this.jyudkaigomehrtkhkkbn = jyudkaigomehrtkhkkbn;
    }

    public void setSyuhknkkn(Integer syuhknkkn) {
        this.syuhknkkn = syuhknkkn;
    }

    public void setSyuhrkkkn(Integer syuhrkkkn) {
        this.syuhrkkkn = syuhrkkkn;
    }

    public void setPhrkmnrynen(Integer phrkmnrynen) {
        this.phrkmnrynen = phrkmnrynen;
    }

    public void setNkshrstartnen(Integer nkshrstartnen) {
        this.nkshrstartnen = nkshrstartnen;
    }
    public void setHrkkaisuu(C_Hrkkaisuu hrkkaisuu) {
        this.hrkkaisuu = hrkkaisuu;
    }

    public void setHrkkeiro(C_Hrkkeiro hrkkeiro) {
        this.hrkkeiro = hrkkeiro;
    }

    public void setZenkizennouumu(C_BlnktkumuKbn zenkizennouumu) {
        this.zenkizennouumu = zenkizennouumu;
    }

    public void setKjnnkpzeitekitkhukakbn(C_Tkhukaumu kjnnkpzeitekitkhukakbn) {
        this.kjnnkpzeitekitkhukakbn = kjnnkpzeitekitkhukakbn;
    }

    public void setZnnkai(Integer znnkai) {
        this.znnkai = znnkai;
    }

    public void setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn kouzainfoinputhoryuukbn) {
        this.kouzainfoinputhoryuukbn = kouzainfoinputhoryuukbn;
    }

    public void setKouhurikouzainfobankcd(String kouhurikouzainfobankcd) {
        this.kouhurikouzainfobankcd = kouhurikouzainfobankcd;
    }

    public void setKouhurikouzainfositencd(String kouhurikouzainfositencd) {
        this.kouhurikouzainfositencd = kouhurikouzainfositencd;
    }

    public void setKouhurikouzainfoyokinkbn(C_YokinKbn kouhurikouzainfoyokinkbn) {
        this.kouhurikouzainfoyokinkbn = kouhurikouzainfoyokinkbn;
    }

    public void setKouhurikouzainfokouzano(String kouhurikouzainfokouzano) {
        this.kouhurikouzainfokouzano = kouhurikouzainfokouzano;
    }

    public void setKouhurikouzainfokzdoukbn(C_KzkykdouKbn kouhurikouzainfokzdoukbn) {
        this.kouhurikouzainfokzdoukbn = kouhurikouzainfokzdoukbn;
    }

    public void setKouhurikouzainfokzmeiginmkn(String kouhurikouzainfokzmeiginmkn) {
        this.kouhurikouzainfokzmeiginmkn = kouhurikouzainfokzmeiginmkn;
    }

    public void setKouzakakuniniraikbn(C_YouhiblnkKbn kouzakakuniniraikbn) {
        this.kouzakakuniniraikbn = kouzakakuniniraikbn;
    }

    public void setMosikkatup(BizCurrency mosikkatup) {
        this.mosikkatup = mosikkatup;
    }

    public void setMossyukykp(BizCurrency mossyukykp) {
        this.mossyukykp = mossyukykp;
    }

    public void setMoszennoupsyokaiari(BizCurrency moszennoupsyokaiari) {
        this.moszennoupsyokaiari = moszennoupsyokaiari;
    }

    public void setKyktuukasyu2(C_Tuukasyu kyktuukasyu2) {
        this.kyktuukasyu2 = kyktuukasyu2;
    }

    public void setHrktuukasyu2(C_Tuukasyu hrktuukasyu2) {
        this.hrktuukasyu2 = hrktuukasyu2;
    }

    public void setKihons2(BizCurrency kihons2) {
        this.kihons2 = kihons2;
    }

    public void setHrktuukasyukykp2(BizCurrency hrktuukasyukykp2) {
        this.hrktuukasyukykp2 = hrktuukasyukykp2;
    }

    public void setMosikkatup2(BizCurrency mosikkatup2) {
        this.mosikkatup2 = mosikkatup2;
    }

    public void setMoszennoupsyokaiari2(BizCurrency moszennoupsyokaiari2) {
        this.moszennoupsyokaiari2 = moszennoupsyokaiari2;
    }

    public void setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu kjnnkpzeitekitkhukakbn2) {
        this.kjnnkpzeitekitkhukakbn2 = kjnnkpzeitekitkhukakbn2;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu) {
        this.ikkatubaraikaisuu = ikkatubaraikaisuu;
    }


    @Override
    public C_KzktourokuserviceTourokuKbn getKzktourokuservicetourokukbn() {
        return kzktourokuserviceTourokuKbn;
    }

    public void setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn kzktourokuserviceTourokuKbn) {
        this.kzktourokuserviceTourokuKbn = kzktourokuserviceTourokuKbn;
    }

    @Override
    public String getTrkkzknmkn1() {
        return trkkzknmkn1;
    }
    public void setTrkkzknmkn1(String trkkzknmkn1) {
        this.trkkzknmkn1 = trkkzknmkn1;
    }

    @Override
    public String getTrkkzknmkj1() {
        return trkkzknmkj1;
    }
    public void setTrkkzknmkj1(String trkkzknmkj1) {
        this.trkkzknmkj1 = trkkzknmkj1;
    }

    @Override
    public C_KjkhukaKbn getTrkkzknmkjkhukakbn1() {
        return trkkzknmkjkhukakbn1;
    }
    public void setTrkkzknmkjkhukakbn1(C_KjkhukaKbn trkkzknmkjkhukakbn1) {
        this.trkkzknmkjkhukakbn1 = trkkzknmkjkhukakbn1;
    }

    @Override
    public BizDate getTrkkzkseiymd1() {
        return trkkzkseiymd1;
    }
    public void setTrkkzkseiymd1(BizDate trkkzkseiymd1) {
        this.trkkzkseiymd1 = trkkzkseiymd1;
    }

    @Override
    public C_Seibetu getTrkkzksei1() {
        return trkkzksei1;
    }
    public void setTrkkzksei1(C_Seibetu trkkzksei1) {
        this.trkkzksei1 = trkkzksei1;
    }

    @Override
    public C_Tdk getTrkkzktdk1() {
        return trkkzktdk1;
    }
    public void setTrkkzktdk1(C_Tdk trkkzktdk1) {
        this.trkkzktdk1 = trkkzktdk1;
    }

    @Override
    public C_TsindousiteiKbn getTrkkzktsindousiteikbn1() {
        return trkkzktsindousiteikbn1;
    }
    public void setTrkkzktsindousiteikbn1(C_TsindousiteiKbn trkkzktsindousiteikbn1) {
        this.trkkzktsindousiteikbn1 = trkkzktsindousiteikbn1;
    }

    @Override
    public String getTrkkzkyno1() {
        return trkkzkyno1;
    }
    public void setTrkkzkyno1(String trkkzkyno1) {
        this.trkkzkyno1 = trkkzkyno1;
    }

    @Override
    public String getTrkkzkadr1kj1() {
        return trkkzkadr1kj1;
    }
    public void setTrkkzkadr1kj1(String trkkzkadr1kj1) {
        this.trkkzkadr1kj1 = trkkzkadr1kj1;
    }

    @Override
    public String getTrkkzkadr2kj1() {
        return trkkzkadr2kj1;
    }
    public void setTrkkzkadr2kj1(String trkkzkadr2kj1) {
        this.trkkzkadr2kj1 = trkkzkadr2kj1;
    }

    @Override
    public String getTrkkzkadr3kj1() {
        return trkkzkadr3kj1;
    }
    public void setTrkkzkadr3kj1(String trkkzkadr3kj1) {
        this.trkkzkadr3kj1 = trkkzkadr3kj1;
    }

    @Override
    public String getTrkkzktelno1() {
        return trkkzktelno1;
    }
    public void setTrkkzktelno1(String trkkzktelno1) {
        this.trkkzktelno1 = trkkzktelno1;
    }

    @Override
    public BizDate getStdrskseiymd() {
        return stdrskseiymd;
    }
    public void setStdrskseiymd(BizDate siteidrseiymd) {
        this.stdrskseiymd = siteidrseiymd;
    }

    @Override
    public C_FstphrkkeiroKbn getFstphrkkeirokbn() {
        return fstphrkkeirokbn;
    }
    public void setFstphrkkeirokbn(C_FstphrkkeiroKbn fstphrkkeirokbn) {
        this.fstphrkkeirokbn = fstphrkkeirokbn;
    }

}