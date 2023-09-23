package yuyu.common.siharai.edittbl;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKyksyaTdk;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求TBL設定用Bean
 */
public class SkTblSetBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SyuhiYouhi syuhiyouhi;

    private C_SbjiShrKbn sbjishrkbn;

    private C_UktKyksyaTdk uktkyksyatdk;

    private C_SinsaGendoKknKbn sinsagendokknkbn;

    private Integer rikoukityuutuudannissuu;

    private BizDate tienrisokukisanymd;

    private Integer tienrsknissuu;

    private C_Tuukasyu kyktuukasyu;

    private C_Tuukasyu shrtuukasyu;

    private BizDate shrkwsratekjnymd;

    private BizNumber shrkwsrate;

    private BizDate zeimukwsratekjnymd;

    private BizNumber zeimukwsrate;

    private BizCurrency shrgk;

    private BizCurrency hokenkngkgoukei;

    private BizCurrency shrtienrsk;

    private BizCurrency yenshrgk;

    private BizCurrency yenhkgkgoukei;

    private BizCurrency yenshrtienrsk;

    private BizCurrency goukeihituyoukeihi;

    private Integer kykhnkkaisuu;

    private BizCurrency shrkykhtykeihi;

    private BizDateYM misyuupjyuutouym;

    private Integer misyuupjyuutoukaisuuy;

    private Integer misyuupjyuutoukaisuum;

    private BizDate gaikaknsnkwsratekjymd;

    private BizNumber gaikaknsnkwsrate;

    private BizCurrency haitoukin;

    private BizCurrency sonotahaitoukin;

    private BizCurrency misyuup;

    private BizCurrency mikeikap;

    private BizCurrency zennouseisankgk;

    private BizCurrency azukarikingk;

    private BizCurrency sonotaseisangk;

    private BizCurrency krkgk;

    private BizCurrency yenkahaitoukin;

    private BizCurrency yenkasonotahaitoukin;

    private BizCurrency yenkamisyuup;

    private BizCurrency yenkamikeikap;

    private BizCurrency yenkazennouseisankgk;

    private BizCurrency yenkaazukarikingk;

    private BizCurrency yenkasonotaseisangk;

    private BizCurrency yenkakrkgk;

    private BizCurrency zitkazukarikingksiteituuka;

    private BizCurrency zitkazukarikingkyen;

    private BizCurrency gaikaknsntkgk;

    private BizCurrency gaikaknsnkekkakgk;

    private BizCurrency yenkaknsntkgk;

    private BizCurrency yenkaknsnkekkakgk;

    private BizCurrency misyuusyonendojikaiikoup;

    private BizCurrency misyuujinendoikoup;

    private BizDateYM mikeikapjyuutouym;

    private Integer mikeikapjyuutoukaisuuy;

    private Integer mikeikapjyuutoukaisuum;

    private C_NaiteiKakuteiKbn vhtnaiteikakuteikbn;

    public C_SyuhiYouhi getSyuhiyouhi() {
        return syuhiyouhi;
    }

    public void setSyuhiyouhi(C_SyuhiYouhi pSyuhiyouhi) {
        syuhiyouhi = pSyuhiyouhi;
    }

    public C_SbjiShrKbn getSbjishrkbn() {
        return sbjishrkbn;
    }

    public void setSbjishrkbn(C_SbjiShrKbn pSbjishrkbn) {
        sbjishrkbn = pSbjishrkbn;
    }

    public C_UktKyksyaTdk getUktkyksyatdk() {
        return uktkyksyatdk;
    }

    public void setUktkyksyatdk(C_UktKyksyaTdk pUktkyksyatdk) {
        uktkyksyatdk = pUktkyksyatdk;
    }

    public C_SinsaGendoKknKbn getSinsagendokknkbn() {
        return sinsagendokknkbn;
    }

    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn) {
        sinsagendokknkbn = pSinsagendokknkbn;
    }

    public Integer getRikoukityuutuudannissuu() {
        return rikoukityuutuudannissuu;
    }

    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu) {
        rikoukityuutuudannissuu = pRikoukityuutuudannissuu;
    }

    public BizDate getTienrisokukisanymd() {
        return tienrisokukisanymd;
    }

    public void setTienrisokukisanymd(BizDate pTienrisokukisanymd) {
        tienrisokukisanymd = pTienrisokukisanymd;
    }

    public Integer getTienrsknissuu() {
        return tienrsknissuu;
    }

    public void setTienrsknissuu(Integer pTienrsknissuu) {
        tienrsknissuu = pTienrsknissuu;
    }

    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    public BizCurrency getShrgk() {
        return shrgk;
    }

    public void setShrgk(BizCurrency pShrgk) {
        shrgk = pShrgk;
    }

    public BizCurrency getHokenkngkgoukei() {
        return hokenkngkgoukei;
    }

    public void setHokenkngkgoukei(BizCurrency pHokenkngkgoukei) {
        hokenkngkgoukei = pHokenkngkgoukei;
    }

    public BizCurrency getShrtienrsk() {
        return shrtienrsk;
    }

    public void setShrtienrsk(BizCurrency pShrtienrsk) {
        shrtienrsk = pShrtienrsk;
    }

    public BizCurrency getYenshrgk() {
        return yenshrgk;
    }

    public void setYenshrgk(BizCurrency pYenshrgk) {
        yenshrgk = pYenshrgk;
    }

    public BizCurrency getYenhkgkgoukei() {
        return yenhkgkgoukei;
    }

    public void setYenhkgkgoukei(BizCurrency pYenhkgkgoukei) {
        yenhkgkgoukei = pYenhkgkgoukei;
    }

    public BizCurrency getYenshrtienrsk() {
        return yenshrtienrsk;
    }

    public void setYenshrtienrsk(BizCurrency pYenshrtienrsk) {
        yenshrtienrsk = pYenshrtienrsk;
    }

    public BizCurrency getGoukeihituyoukeihi() {
        return goukeihituyoukeihi;
    }

    public void setGoukeihituyoukeihi(BizCurrency pGoukeihituyoukeihi) {
        goukeihituyoukeihi = pGoukeihituyoukeihi;
    }

    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        shrkykhtykeihi = pShrkykhtykeihi;
    }

    public BizDateYM getMisyuupjyuutouym() {
        return misyuupjyuutouym;
    }

    public void setMisyuupjyuutouym(BizDateYM misyuupjyuutouym) {
        this.misyuupjyuutouym = misyuupjyuutouym;
    }

    public Integer getMisyuupjyuutoukaisuuy() {
        return misyuupjyuutoukaisuuy;
    }

    public void setMisyuupjyuutoukaisuuy(Integer misyuupjyuutoukaisuuy) {
        this.misyuupjyuutoukaisuuy = misyuupjyuutoukaisuuy;
    }

    public Integer getMisyuupjyuutoukaisuum() {
        return misyuupjyuutoukaisuum;
    }

    public void setMisyuupjyuutoukaisuum(Integer misyuupjyuutoukaisuum) {
        this.misyuupjyuutoukaisuum = misyuupjyuutoukaisuum;
    }

    public BizDate getGaikaknsnkwsratekjymd() {
        return gaikaknsnkwsratekjymd;
    }

    public void setGaikaknsnkwsratekjymd(BizDate gaikaknsnkwsratekjymd) {
        this.gaikaknsnkwsratekjymd = gaikaknsnkwsratekjymd;
    }

    public BizNumber getGaikaknsnkwsrate() {
        return gaikaknsnkwsrate;
    }

    public void setGaikaknsnkwsrate(BizNumber gaikaknsnkwsrate) {
        this.gaikaknsnkwsrate = gaikaknsnkwsrate;
    }

    public BizCurrency getHaitoukin() {
        return haitoukin;
    }

    public void setHaitoukin(BizCurrency haitoukin) {
        this.haitoukin = haitoukin;
    }

    public BizCurrency getSonotahaitoukin() {
        return sonotahaitoukin;
    }

    public void setSonotahaitoukin(BizCurrency sonotahaitoukin) {
        this.sonotahaitoukin = sonotahaitoukin;
    }

    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency misyuup) {
        this.misyuup = misyuup;
    }

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency mikeikap) {
        this.mikeikap = mikeikap;
    }

    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency zennouseisankgk) {
        this.zennouseisankgk = zennouseisankgk;
    }

    public BizCurrency getAzukarikingk() {
        return azukarikingk;
    }

    public void setAzukarikingk(BizCurrency azukarikingk) {
        this.azukarikingk = azukarikingk;
    }

    public BizCurrency getSonotaseisangk() {
        return sonotaseisangk;
    }

    public void setSonotaseisangk(BizCurrency sonotaseisangk) {
        this.sonotaseisangk = sonotaseisangk;
    }

    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency krkgk) {
        this.krkgk = krkgk;
    }

    public BizCurrency getYenkahaitoukin() {
        return yenkahaitoukin;
    }

    public void setYenkahaitoukin(BizCurrency yenkahaitoukin) {
        this.yenkahaitoukin = yenkahaitoukin;
    }

    public BizCurrency getYenkasonotahaitoukin() {
        return yenkasonotahaitoukin;
    }

    public void setYenkasonotahaitoukin(BizCurrency yenkasonotahaitoukin) {
        this.yenkasonotahaitoukin = yenkasonotahaitoukin;
    }

    public BizCurrency getYenkamisyuup() {
        return yenkamisyuup;
    }

    public void setYenkamisyuup(BizCurrency yenkamisyuup) {
        this.yenkamisyuup = yenkamisyuup;
    }

    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    public void setYenkamikeikap(BizCurrency yenkamikeikap) {
        this.yenkamikeikap = yenkamikeikap;
    }

    public BizCurrency getYenkazennouseisankgk() {
        return yenkazennouseisankgk;
    }

    public void setYenkazennouseisankgk(BizCurrency yenkazennouseisankgk) {
        this.yenkazennouseisankgk = yenkazennouseisankgk;
    }

    public BizCurrency getYenkaazukarikingk() {
        return yenkaazukarikingk;
    }

    public void setYenkaazukarikingk(BizCurrency yenkaazukarikingk) {
        this.yenkaazukarikingk = yenkaazukarikingk;
    }

    public BizCurrency getYenkasonotaseisangk() {
        return yenkasonotaseisangk;
    }

    public void setYenkasonotaseisangk(BizCurrency yenkasonotaseisangk) {
        this.yenkasonotaseisangk = yenkasonotaseisangk;
    }

    public BizCurrency getYenkakrkgk() {
        return yenkakrkgk;
    }

    public void setYenkakrkgk(BizCurrency yenkakrkgk) {
        this.yenkakrkgk = yenkakrkgk;
    }

    public BizCurrency getZitkazukarikingksiteituuka() {
        return zitkazukarikingksiteituuka;
    }

    public void setZitkazukarikingksiteituuka(BizCurrency zitkazukarikingksiteituuka) {
        this.zitkazukarikingksiteituuka = zitkazukarikingksiteituuka;
    }

    public BizCurrency getZitkazukarikingkyen() {
        return zitkazukarikingkyen;
    }

    public void setZitkazukarikingkyen(BizCurrency zitkazukarikingkyen) {
        this.zitkazukarikingkyen = zitkazukarikingkyen;
    }

    public BizCurrency getGaikaknsntkgk() {
        return gaikaknsntkgk;
    }

    public void setGaikaknsntkgk(BizCurrency gaikaknsntkgk) {
        this.gaikaknsntkgk = gaikaknsntkgk;
    }

    public BizCurrency getGaikaknsnkekkakgk() {
        return gaikaknsnkekkakgk;
    }

    public void setGaikaknsnkekkakgk(BizCurrency gaikaknsnkekkakgk) {
        this.gaikaknsnkekkakgk = gaikaknsnkekkakgk;
    }

    public BizCurrency getYenkaknsntkgk() {
        return yenkaknsntkgk;
    }

    public void setYenkaknsntkgk(BizCurrency yenkaknsntkgk) {
        this.yenkaknsntkgk = yenkaknsntkgk;
    }

    public BizCurrency getYenkaknsnkekkakgk() {
        return yenkaknsnkekkakgk;
    }

    public void setYenkaknsnkekkakgk(BizCurrency yenkaknsnkekkakgk) {
        this.yenkaknsnkekkakgk = yenkaknsnkekkakgk;
    }

    public BizCurrency getMisyuusyonendojikaiikoup() {
        return misyuusyonendojikaiikoup;
    }

    public void setMisyuusyonendojikaiikoup(BizCurrency misyuusyonendojikaiikoup) {
        this.misyuusyonendojikaiikoup = misyuusyonendojikaiikoup;
    }

    public BizCurrency getMisyuujinendoikoup() {
        return misyuujinendoikoup;
    }

    public void setMisyuujinendoikoup(BizCurrency misyuujinendoikoup) {
        this.misyuujinendoikoup = misyuujinendoikoup;
    }

    public BizDateYM getMikeikapjyuutouym() {
        return mikeikapjyuutouym;
    }

    public void setMikeikapjyuutouym(BizDateYM mikeikapjyuutouym) {
        this.mikeikapjyuutouym = mikeikapjyuutouym;
    }

    public Integer getMikeikapjyuutoukaisuuy() {
        return mikeikapjyuutoukaisuuy;
    }

    public void setMikeikapjyuutoukaisuuy(Integer mikeikapjyuutoukaisuuy) {
        this.mikeikapjyuutoukaisuuy = mikeikapjyuutoukaisuuy;
    }

    public Integer getMikeikapjyuutoukaisuum() {
        return mikeikapjyuutoukaisuum;
    }

    public void setMikeikapjyuutoukaisuum(Integer mikeikapjyuutoukaisuum) {
        this.mikeikapjyuutoukaisuum = mikeikapjyuutoukaisuum;
    }

    public C_NaiteiKakuteiKbn getVhtnaiteikakuteikbn() {
        return vhtnaiteikakuteikbn;
    }

    public void setVhtnaiteikakuteikbn(C_NaiteiKakuteiKbn vhtnaiteikakuteikbn) {
        this.vhtnaiteikakuteikbn = vhtnaiteikakuteikbn;
    }

}
