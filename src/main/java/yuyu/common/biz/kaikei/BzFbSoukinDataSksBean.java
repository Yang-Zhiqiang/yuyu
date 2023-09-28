package yuyu.common.biz.kaikei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;


/**
 * ＦＢ送金データ編集Beanクラスです。<br />
 */
public class BzFbSoukinDataSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String denRenno;

    private Integer edaNo;

    private C_DensysKbn denSysKbn ;

    private String syoriCd ;

    private String syoriSosikiCd;

    private BizDate syoriYmd ;

    private BizDate denYmd;

    private String syoNo;

    private C_ShrhousiteiKbn shrHouSiteiKbn;

    private String bankCd;

    private String sitenCd ;

    private C_YokinKbn yokinKbn ;

    private String kouzaNo ;

    private String kzMeigiNmKn;

    private BizCurrency souKingk ;

    private C_Tuukasyu kykTuukasyu;

    private BizCurrency gaikaTaikagk;

    private BizNumber soukinKwsRate;

    private String kinouId ;

    private String userId;

    private String dengyoumuCd;

    public BzFbSoukinDataSksBean() {
        super();
    }

    public String getDenbyouyouDataRenbon() {
        return denRenno;
    }

    public void setDenbyouyouDataRenbon(String pDenbyouyouDataRenbon) {
        denRenno = pDenbyouyouDataRenbon;
    }

    public Integer getEdaNo() {
        return edaNo;
    }

    public void setEdaNo(Integer pEdaNo) {
        edaNo = pEdaNo;
    }

    public C_DensysKbn getDenSysKbn () {
        return denSysKbn ;
    }

    public void setDenSysKbn (C_DensysKbn pDenSysKbn ) {
        denSysKbn  = pDenSysKbn ;
    }

    public String getSyoriCd () {
        return syoriCd ;
    }

    public void setSyoriCd (String pSyoriCd ) {
        syoriCd  = pSyoriCd ;
    }

    public String getSyoriSosikiCd() {
        return syoriSosikiCd;
    }

    public void setSyoriSosikiCd(String pSyoriSosikiCd) {
        syoriSosikiCd = pSyoriSosikiCd;
    }

    public BizDate getSyoriYmd () {
        return syoriYmd ;
    }

    public void setSyoriYmd (BizDate pSyoriYmd ) {
        syoriYmd  = pSyoriYmd ;
    }

    public BizDate getDenYmd() {
        return denYmd;
    }

    public void setDenYmd(BizDate pDenYmd) {
        denYmd = pDenYmd;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public C_ShrhousiteiKbn getShrHouSiteiKbn() {
        return shrHouSiteiKbn;
    }

    public void setShrHouSiteiKbn(C_ShrhousiteiKbn pShrHouSiteiKbn) {
        shrHouSiteiKbn = pShrHouSiteiKbn;
    }

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String pBankCd) {
        bankCd = pBankCd;
    }

    public String getSitenCd () {
        return sitenCd ;
    }

    public void setSitenCd (String pSitenCd ) {
        sitenCd  = pSitenCd ;
    }

    public C_YokinKbn getYokinKbn () {
        return yokinKbn ;
    }

    public void setYokinKbn (C_YokinKbn pYokinKbn ) {
        yokinKbn  = pYokinKbn ;
    }

    public String getKouzaNo () {
        return kouzaNo ;
    }

    public void setKouzaNo (String pKouzaNo ) {
        kouzaNo  = pKouzaNo ;
    }

    public String getKzMeigiNmKn() {
        return kzMeigiNmKn;
    }

    public void setKzMeigiNmKn(String pKzMeigiNmKn) {
        kzMeigiNmKn = pKzMeigiNmKn;
    }

    public BizCurrency getSouKingk () {
        return souKingk ;
    }

    public void setSouKingk (BizCurrency pSouKingk ) {
        souKingk  = pSouKingk ;
    }

    public C_Tuukasyu getKykTuukasyu() {
        return kykTuukasyu;
    }

    public void setKykTuukasyu(C_Tuukasyu pKykTuukasyu) {
        kykTuukasyu = pKykTuukasyu;
    }

    public BizCurrency getGaikaTaikagk() {
        return gaikaTaikagk;
    }

    public void setGaikaTaikagk(BizCurrency pGaikaTaikagk) {
        gaikaTaikagk = pGaikaTaikagk;
    }

    public BizNumber getSoukinKwsRate() {
        return soukinKwsRate;
    }

    public void setSoukinKwsRate(BizNumber pSoukinKwsRate) {
        soukinKwsRate = pSoukinKwsRate;
    }

    public String getKinouId () {
        return kinouId ;
    }

    public void setKinouId (String pKinouId ) {
        kinouId  = pKinouId ;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    public String getDengyoumuCd() {
        return dengyoumuCd;
    }

    public void setDengyoumuCd(String pDengyoumuCd) {
        dengyoumuCd = pDengyoumuCd;
    }

}
