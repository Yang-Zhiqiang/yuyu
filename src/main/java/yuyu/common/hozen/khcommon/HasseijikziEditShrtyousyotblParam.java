package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 発生時課税支払調書ＴＢＬ編集パラメータ
 */
public class HasseijikziEditShrtyousyotblParam {

    private String syono;

    private BizDate syoriymd;

    private C_ShrsyoriKbn shrsyorikbn;

    private BizDate kouryokuhasseiymd;

    private C_UmuKbn mfadrsiyouhyouji;

    private BizCurrency shrgk;

    private BizCurrency yenkansansonotaseisank;

    private BizCurrency yenhaitoukin;

    private BizCurrency yensonotahaitoukin;

    private BizCurrency synykngk;

    private BizCurrency mihrkmp;

    private BizDate shrymd;

    private String syorisosikicd;

    private String shrtysytsinyno;

    private String shrtysyadr1kj;

    private String shrtysyadr2kj;

    private String shrtysyadr3kj;

    private String uktnmkj;

    private C_HtsiryosyuKbn htsiryosyukbn;

    private C_ShrhousiteiKbn shrhousiteikbn;

    private BizCurrency kihrkmp;

    private String kykmnmeigibangou;

    private String uktmnmeigibangou;

    private Integer kykhnkkaisuu;

    private BizCurrency shrkykhtykeihi;

    public HasseijikziEditShrtyousyotblParam() {
        super();
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public BizDate getSyoriymd() {
        return syoriymd;
    }

    public void setSyoriymd(BizDate pSyoriymd) {
        this.syoriymd = pSyoriymd;
    }

    public C_ShrsyoriKbn getShrsyorikbn() {
        return shrsyorikbn;
    }

    public void setShrsyoriKbn(C_ShrsyoriKbn pShrsyorikbn) {
        this.shrsyorikbn = pShrsyorikbn;
    }

    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiYmd(BizDate pKouryokuhasseiymd) {
        this.kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    public C_UmuKbn getMfadrsiyouhyouji() {
        return mfadrsiyouhyouji;
    }

    public void setMfadrsiyouhyouji(C_UmuKbn pMfadrsiyouhyouji) {
        this.mfadrsiyouhyouji = pMfadrsiyouhyouji;
    }

    public BizCurrency getShrgk() {
        return shrgk;
    }

    public void setShrgk(BizCurrency pShrgk) {
        this.shrgk = pShrgk;
    }

    public BizCurrency getYenkansansonotaseisank() {
        return yenkansansonotaseisank;
    }

    public void setYenkansansonotaseisank(BizCurrency pYenkansansonotaseisank) {
        this.yenkansansonotaseisank = pYenkansansonotaseisank;
    }

    public BizCurrency getYenhaitoukin() {
        return yenhaitoukin;
    }

    public void setYenhaitoukin(BizCurrency pYenhaitoukin) {
        this.yenhaitoukin = pYenhaitoukin;
    }

    public BizCurrency getYensonotahaitoukin() {
        return yensonotahaitoukin;
    }

    public void setYensonotahaitoukin(BizCurrency pYensonotahaitoukin) {
        this.yensonotahaitoukin = pYensonotahaitoukin;
    }

    public BizCurrency getSynykngk() {
        return synykngk;
    }

    public void setSynykngk(BizCurrency pSynykngk) {
        this.synykngk = pSynykngk;
    }

    public BizCurrency getMihrkmp() {
        return mihrkmp;
    }

    public void setMihrkmp(BizCurrency pMihrkmp) {
        this.mihrkmp = pMihrkmp;
    }

    public BizDate getShrymd() {
        return shrymd;
    }

    public void setShrymd(BizDate pShrymd) {
        this.shrymd = pShrymd;
    }

    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        this.syorisosikicd = pSyorisosikicd;
    }

    public String getShrtysytsinyno() {
        return shrtysytsinyno;
    }

    public void setShrtysytsinyno(String pShrtysytsinyno) {
        this.shrtysytsinyno = pShrtysytsinyno;
    }

    public String getShrtysyadr1kj() {
        return shrtysyadr1kj;
    }

    public void setShrtysyadr1kj(String pShrtysyadr1kj) {
        this.shrtysyadr1kj = pShrtysyadr1kj;
    }

    public String getShrtysyadr2kj() {
        return shrtysyadr2kj;
    }

    public void setShrtysyadr2kj(String pShrtysyadr2kj) {
        this.shrtysyadr2kj = pShrtysyadr2kj;
    }

    public String getShrtysyadr3kj() {
        return shrtysyadr3kj;
    }

    public void setShrtysyadr3kj(String pShrtysyadr3kj) {
        this.shrtysyadr3kj = pShrtysyadr3kj;
    }

    public String getUktnmkj() {
        return uktnmkj;
    }

    public void setUktnmkj(String pUktnmkj) {
        this.uktnmkj = pUktnmkj;
    }

    public C_HtsiryosyuKbn getHtsiryosyukbn() {
        return htsiryosyukbn;
    }

    public void setHtsiryosyuKbn(C_HtsiryosyuKbn pHtsiryosyukbn) {
        this.htsiryosyukbn = pHtsiryosyukbn;
    }

    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteiKbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        this.shrhousiteikbn = pShrhousiteikbn;
    }

    public BizCurrency getKihrkmp() {
        return kihrkmp;
    }

    public void setKihrkmp(BizCurrency pKihrkmp) {
        this.kihrkmp = pKihrkmp;
    }

    public String getKykmnmeigibangou() {
        return kykmnmeigibangou;
    }

    public void setKykmnmeigibangou(String pKykmnmeigibangou) {
        this.kykmnmeigibangou = pKykmnmeigibangou;
    }

    public String getUktmnmeigibangou() {
        return uktmnmeigibangou;
    }

    public void setUktmnmeigibangou(String pUktmnmeigibangou) {
        this.uktmnmeigibangou = pUktmnmeigibangou;
    }

    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        this.kykhnkkaisuu = pKykhnkkaisuu;
    }

    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        this.shrkykhtykeihi = pShrkykhtykeihi;
    }
}
