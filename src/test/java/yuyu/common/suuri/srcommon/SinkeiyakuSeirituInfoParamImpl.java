package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約成立情報共通インターフェースの実装クラス
 */
public class SinkeiyakuSeirituInfoParamImpl extends AbstractUiBean
implements SinkeiyakuSeirituInfoParam {

    private static final long serialVersionUID = 1L;

    private String mosno;

    @Override
    public String getMosno() {

        return mosno;
    }

    @Override
    public void setMosno(String mosno) {
        this.mosno = mosno;

    }

    private String syono;

    @Override
    public String getSyono() {

        return syono;
    }

    @Override
    public void setSyono(String syono) {
        this.syono = syono;

    }

    private BizDate mosnrkymd;

    @Override
    public BizDate getMosnrkymd() {

        return mosnrkymd;
    }

    @Override
    public void setMosnrkymd(BizDate mosnrkymd) {
        this.mosnrkymd = mosnrkymd;

    }

    private C_SeirituKbn seiritukbn;

    @Override
    public C_SeirituKbn getSeiritukbn() {

        return seiritukbn;
    }

    @Override
    public void setSeiritukbn(C_SeirituKbn seiritukbn) {
        this.seiritukbn = seiritukbn;

    }

    private BizDate srsyoriymd;

    @Override
    public BizDate getSrsyoriymd() {

        return srsyoriymd;
    }

    @Override
    public void setSrsyoriymd(BizDate srsyoriymd) {
        this.srsyoriymd = srsyoriymd;

    }

    private BizDate mosymd;

    @Override
    public BizDate getMosymd() {

        return mosymd;
    }

    @Override
    public void setMosymd(BizDate mosymd) {
        this.mosymd = mosymd;

    }

    private BizDate mossakuseiymd;

    @Override
    public BizDate getMossakuseiymd() {

        return mossakuseiymd;
    }

    @Override
    public void setMossakuseiymd(BizDate mossakuseiymd) {
        this.mossakuseiymd = mossakuseiymd;

    }

    private BizDateYM mosym;

    @Override
    public BizDateYM getMosym() {

        return mosym;
    }

    @Override
    public void setMosym(BizDateYM mosym) {
        this.mosym = mosym;

    }

    private BizDate kykymd;

    @Override
    public BizDate getKykymd() {

        return kykymd;
    }

    @Override
    public void setKykymd(BizDate kykymd) {
        this.kykymd = kykymd;

    }

    private BizDate skykymd;

    @Override
    public BizDate getSkykymd() {

        return skykymd;
    }

    @Override
    public void setSkykymd(BizDate skykymd) {
        this.skykymd = skykymd;

    }

    private BizDate sknnkaisiymd;

    @Override
    public BizDate getSknnkaisiymd() {

        return sknnkaisiymd;
    }

    @Override
    public void setSknnkaisiymd(BizDate sknnkaisiymd) {
        this.sknnkaisiymd = sknnkaisiymd;

    }

    private BizDateYM seisekiym;

    @Override
    public BizDateYM getSeisekiym() {

        return seisekiym;
    }

    @Override
    public void setSeisekiym(BizDateYM seisekiym) {
        this.seisekiym = seisekiym;

    }

    private BizDateYM skeikeijyouym;

    @Override
    public BizDateYM getSkeikeijyouym() {

        return skeikeijyouym;
    }

    @Override
    public void setSkeikeijyouym(BizDateYM skeikeijyouym) {
        this.skeikeijyouym = skeikeijyouym;

    }

    private C_KykKbn kykKbn;

    @Override
    public C_KykKbn getKykkbn() {

        return kykKbn;
    }

    @Override
    public void setKykkbn(C_KykKbn kykKbn) {
        this.kykKbn = kykKbn;

    }

    private C_Tkhukaumu stdrsktkyhkkbn;

    @Override
    public C_Tkhukaumu getStdrsktkyhkkbn() {

        return stdrsktkyhkkbn;
    }

    @Override
    public void setStdrsktkyhkkbn(C_Tkhukaumu stdrsktkyhkkbn) {
        this.stdrsktkyhkkbn = stdrsktkyhkkbn;

    }

    private C_Sdpd sdpdkbn;

    @Override
    public C_Sdpd getSdpdkbn() {

        return sdpdkbn;
    }

    @Override
    public void setSdpdkbn(C_Sdpd sdpdkbn) {
        this.sdpdkbn = sdpdkbn;

    }

    private C_SntkhouKbn sntkhoukbn;

    @Override
    public C_SntkhouKbn getSntkhoukbn() {

        return sntkhoukbn;
    }

    @Override
    public void setSntkhoukbn(C_SntkhouKbn sntkhoukbn) {
        this.sntkhoukbn = sntkhoukbn;

    }

    private C_HaitouKbn haitoukbn;

    @Override
    public C_HaitouKbn getHaitoukbn() {

        return haitoukbn;
    }

    @Override
    public void setHaitoukbn(C_HaitouKbn haitoukbn) {
        this.haitoukbn = haitoukbn;

    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Override
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {

        return haitoukinuketorihoukbn;
    }

    @Override
    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn haitoukinuketorihoukbn) {
        this.haitoukinuketorihoukbn = haitoukinuketorihoukbn;

    }

    private C_Tuukasyu kyktuukasyu;

    @Override
    public C_Tuukasyu getKyktuukasyu() {

        return kyktuukasyu;
    }

    @Override
    public void setKyktuukasyu(C_Tuukasyu kyktuukasyu) {
        this.kyktuukasyu = kyktuukasyu;

    }

    private C_Tuukasyu hrktuukasyu;

    @Override
    public C_Tuukasyu getHrktuukasyu() {

        return hrktuukasyu;
    }

    @Override
    public void setHrktuukasyu(C_Tuukasyu hrktuukasyu) {
        this.hrktuukasyu = hrktuukasyu;

    }

    private BizCurrency hyouteip;

    @Override
    public BizCurrency getHyouteip() {

        return hyouteip;
    }

    @Override
    public void setHyouteip(BizCurrency hyouteip) {
        this.hyouteip = hyouteip;

    }

    private String hhknnmkn;

    @Override
    public String getHhknnmkn() {

        return hhknnmkn;
    }

    @Override
    public void setHhknnmkn(String hhknnmkn) {
        this.hhknnmkn = hhknnmkn;

    }

    private String hhknnmkj;

    @Override
    public String getHhknnmkj() {

        return hhknnmkj;
    }

    @Override
    public void setHhknnmkj(String hhknnmkj) {
        this.hhknnmkj = hhknnmkj;

    }

    private BizDate hhknseiymd;

    @Override
    public BizDate getHhknseiymd() {

        return hhknseiymd;
    }

    @Override
    public void setHhknseiymd(BizDate hhknseiymd) {
        this.hhknseiymd = hhknseiymd;

    }

    private Integer hhknnen;

    @Override
    public Integer getHhknnen() {

        return hhknnen;
    }

    @Override
    public void setHhknnen(Integer hhknnen) {
        this.hhknnen = hhknnen;

    }

    private C_Hhknsei hhknsei;

    @Override
    public C_Hhknsei getHhknsei() {

        return hhknsei;
    }

    @Override
    public void setHhknsei(C_Hhknsei hhknsei) {
        this.hhknsei = hhknsei;

    }

    private String hhknsykgycd;

    @Override
    public String getHhknsykgycd() {

        return hhknsykgycd;
    }

    @Override
    public void setHhknsykgycd(String hhknsykgycd) {
        this.hhknsykgycd = hhknsykgycd;

    }

    private String kyknmkn;

    @Override
    public String getKyknmkn() {

        return kyknmkn;
    }

    @Override
    public void setKyknmkn(String kyknmkn) {
        this.kyknmkn = kyknmkn;

    }

    private String kyknmkj;

    @Override
    public String getKyknmkj() {

        return kyknmkj;
    }

    @Override
    public void setKyknmkj(String kyknmkj) {
        this.kyknmkj = kyknmkj;

    }

    private BizDate kykseiymd;

    @Override
    public BizDate getKykseiymd() {

        return kykseiymd;
    }

    @Override
    public void setKykseiymd(BizDate kykseiymd) {
        this.kykseiymd = kykseiymd;

    }

    private Integer kyknen;

    @Override
    public Integer getKyknen() {

        return kyknen;
    }

    @Override
    public void setKyknen(Integer kyknen) {
        this.kyknen = kyknen;

    }

    private C_Kyksei kyksei;

    @Override
    public C_Kyksei getKyksei() {

        return kyksei;
    }

    @Override
    public void setKyksei(C_Kyksei kyksei) {
        this.kyksei = kyksei;

    }

    private String tsinyno;

    @Override
    public String getTsinyno() {

        return tsinyno;
    }

    @Override
    public void setTsinyno(String tsinyno) {
        this.tsinyno = tsinyno;

    }

    private C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn;

    @Override
    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn() {

        return kykhonninkakninsyoruikbn;
    }

    @Override
    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn) {
        this.kykhonninkakninsyoruikbn = kykhonninkakninsyoruikbn;

    }

    private BizDate kktymd;

    @Override
    public BizDate getKktymd() {

        return kktymd;
    }

    @Override
    public void setKktymd(BizDate kktymd) {
        this.kktymd = kktymd;

    }

    private C_Kykkaksyrui kykkaksyrui;

    @Override
    public C_Kykkaksyrui getKykkaksyrui() {

        return kykkaksyrui;
    }

    @Override
    public void setKykkaksyrui(C_Kykkaksyrui kykkaksyrui) {
        this.kykkaksyrui = kykkaksyrui;

    }

    private C_SpgndtknKbn spgndtknkbn;

    @Override
    public C_SpgndtknKbn getSpgndtknkbn() {

        return spgndtknkbn;
    }

    @Override
    public void setSpgndtknkbn(C_SpgndtknKbn spgndtknkbn) {
        this.spgndtknkbn = spgndtknkbn;

    }

    private C_NenkkntknKbn nenkkntknkbn;

    @Override
    public C_NenkkntknKbn getNenkkntknkbn() {

        return nenkkntknkbn;
    }

    @Override
    public void setNenkkntknkbn(C_NenkkntknKbn nenkkntknkbn) {
        this.nenkkntknkbn = nenkkntknkbn;

    }

    private C_TsngndtknKbn tsngndtknkbn;

    @Override
    public C_TsngndtknKbn getTsngndtknkbn() {

        return tsngndtknkbn;
    }

    @Override
    public void setTsngndtknkbn(C_TsngndtknKbn tsngndtknkbn) {
        this.tsngndtknkbn = tsngndtknkbn;

    }

    private C_SentakuinfotknKbn sentakuinfotknkbn;

    @Override
    public C_SentakuinfotknKbn getSentakuinfotknkbn() {

        return sentakuinfotknkbn;
    }

    @Override
    public void setSentakuinfotknkbn(C_SentakuinfotknKbn sentakuinfotknkbn) {
        this.sentakuinfotknkbn = sentakuinfotknkbn;

    }

    private C_KakoymdkyytknKbn kakoymdkyytknkbn;

    @Override
    public C_KakoymdkyytknKbn getKakoymdkyytknkbn() {

        return kakoymdkyytknkbn;
    }

    @Override
    public void setKakoymdkyytknkbn(C_KakoymdkyytknKbn kakoymdkyytknkbn) {
        this.kakoymdkyytknkbn = kakoymdkyytknkbn;

    }

    private C_SaiteiptknKbn saiteiptknkbn;

    @Override
    public C_SaiteiptknKbn getSaiteiptknkbn() {

        return saiteiptknkbn;
    }

    @Override
    public void setSaiteiptknkbn(C_SaiteiptknKbn saiteiptknkbn) {
        this.saiteiptknkbn = saiteiptknkbn;

    }

    private C_SignalkaihiKbn signalkaihikbn;

    @Override
    public C_SignalkaihiKbn getSignalkaihikbn() {

        return signalkaihikbn;
    }

    @Override
    public void setSignalkaihikbn(C_SignalkaihiKbn signalkaihikbn) {
        this.signalkaihikbn = signalkaihikbn;

    }

    private C_SonotaTokuninKbn sonotatknkbn;

    @Override
    public C_SonotaTokuninKbn getSonotatknkbn() {

        return sonotatknkbn;
    }

    @Override
    public void setSonotatknkbn(C_SonotaTokuninKbn sonotatknkbn) {
        this.sonotatknkbn = sonotatknkbn;

    }

    private String drtenkanritodoufukencd;

    @Override
    public String getDrtenkanritodoufukencd() {

        return drtenkanritodoufukencd;
    }

    @Override
    public void setDrtenkanritodoufukencd(String drtenkanritodoufukencd) {
        this.drtenkanritodoufukencd = drtenkanritodoufukencd;

    }

    private C_UmuKbn yenshrtkhkumu;

    @Override
    public C_UmuKbn getYenshrtkhkumu() {

        return yenshrtkhkumu;
    }

    @Override
    public void setYenshrtkhkumu(C_UmuKbn yenshrtkhkumu) {
        this.yenshrtkhkumu = yenshrtkhkumu;

    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Override
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {

        return initsbjiyensitihsytkhukaumu;
    }

    @Override
    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn initsbjiyensitihsytkhukaumu) {
        this.initsbjiyensitihsytkhukaumu = initsbjiyensitihsytkhukaumu;

    }

    private BizCurrency initsbjiyenkasaiteihsygk;

    @Override
    public BizCurrency getInitsbjiyenkasaiteihsygk() {

        return initsbjiyenkasaiteihsygk;
    }

    @Override
    public void setInitsbjiyenkasaiteihsygk(BizCurrency initsbjiyenkasaiteihsygk) {
        this.initsbjiyenkasaiteihsygk = initsbjiyenkasaiteihsygk;

    }

    private C_UmuKbn jyudkaigomeharaitkhukaumu;

    @Override
    public C_UmuKbn getJyudkaigomeharaitkhukaumu() {

        return jyudkaigomeharaitkhukaumu;
    }

    @Override
    public void setJyudkaigomeharaitkhukaumu(C_UmuKbn jyudkaigomeharaitkhukaumu) {
        this.jyudkaigomeharaitkhukaumu = jyudkaigomeharaitkhukaumu;

    }

    private C_UmuKbn targettkhkumu;

    @Override
    public C_UmuKbn getTargettkhkumu() {

        return targettkhkumu;
    }

    @Override
    public void setTargettkhkumu(C_UmuKbn pTargettkhkumu) {
        this.targettkhkumu = pTargettkhkumu;

    }

    private BizDate targettkykkykhenkoymd;

    @Override
    public BizDate getTargettkykkykhenkoymd() {

        return targettkykkykhenkoymd;
    }

    @Override
    public void setTargettkykkykhenkoymd(BizDate pTargettkykkykhenkoymd) {
        this.targettkykkykhenkoymd = pTargettkykkykhenkoymd;

    }

    private Integer targettkmokuhyouti;

    @Override
    public Integer getTargettkmokuhyouti() {

        return targettkmokuhyouti;
    }

    @Override
    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        this.targettkmokuhyouti = pTargettkmokuhyouti;

    }

    private BizCurrency targettkykkijyungk;

    @Override
    public BizCurrency getTargettkykkijyungk() {

        return targettkykkijyungk;
    }

    @Override
    public void setTargettkykkijyungk(BizCurrency pTargettkykkijyungk) {
        this.targettkykkijyungk = pTargettkykkijyungk;

    }

    private C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn;

    @Override
    public C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn() {
        return sisuuhaibunwarikbn;
    }

    @Override
    public void setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn) {
        this.sisuuhaibunwarikbn = sisuuhaibunwarikbn;
    }

    private C_Sisuukbn sisuukbn;

    @Override
    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    @Override
    public void setSisuukbn(C_Sisuukbn sisuukbn) {
        this.sisuukbn = sisuukbn;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Override
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    @Override
    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        this.hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Override
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    @Override
    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        this.hrkkeiro = pHrkkeiro;
    }

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    @Override
    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    @Override
    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        this.ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    private Integer znnkai;

    @Override
    public Integer getZnnkai() {
        return znnkai;
    }

    @Override
    public void setZnnkai(Integer pZnnkai) {
        this.znnkai = pZnnkai;
    }

    private BizCurrency heijyunp;

    @Override
    public BizCurrency getHeijyunp() {
        return heijyunp;
    }

    @Override
    public void setHeijyunp(BizCurrency pHeijyunp) {
        this.heijyunp = pHeijyunp;
    }

    private BizNumber nyuukinKawaseRate;

    @Override
    public BizNumber getNyknkwsrate() {
        return nyuukinKawaseRate;
    }

    @Override
    public void setNyknkwsrate(BizNumber pNyuukinKawaseRate) {
        this.nyuukinKawaseRate = pNyuukinKawaseRate;
    }

    private C_Tkhukaumu kykdrtkykhukakbn;

    @Override
    public C_Tkhukaumu getKykdrtkykhukakbn() {
        return kykdrtkykhukakbn;
    }

    @Override
    public void setKykdrtkykhukakbn(C_Tkhukaumu pKykdrtkykhukakbn) {
        this.kykdrtkykhukakbn = pKykdrtkykhukakbn;
    }

    private C_UmuKbn teikishrtkykhukaumu;

    @Override
    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    @Override
    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        this.teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }

    private C_UmuKbn zennoumousideumu;

    @Override
    public C_UmuKbn getZennoumousideumu() {
        return zennoumousideumu;
    }

    @Override
    public void setZennoumousideumu(C_UmuKbn pZennoumousideumu) {
        this.zennoumousideumu = pZennoumousideumu;
    }
}
