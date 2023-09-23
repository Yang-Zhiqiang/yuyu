package yuyu.common.siharai.edittbl;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.JT_SiDenpyoData;

/**
 * 保険金給付金ＦＢ送金データテーブル編集入力Bean
 */
public class SiEditFbInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ShrhousiteiKbn shrhouSiteiKbn;

    private String bankCd;

    private String sitenCd;

    private C_YokinKbn yokinKbn;

    private String kouzaNo;

    private String kzMeiginmKn;

    private BizCurrency soukinGk ;

    private C_Tuukasyu kykTuukasyu;

    private BizCurrency gaikaTaikaGk;

    private BizNumber soukinKwsRate;

    private String kzMeiginmei ;

    private C_Tuukasyu shrTuukaSyu ;

    private BizCurrency gaikaShrgk;

    private BizCurrency crossRateShrgk ;

    private Integer fbSokinEdaBangou;

    private List<JT_SiDenpyoData> siDenpyoDataLst;

    public SiEditFbInBean() {
        super();
    }

    public C_ShrhousiteiKbn getShrhouSiteiKbn() {
        return shrhouSiteiKbn;
    }

    public void setShrhouSiteiKbn(C_ShrhousiteiKbn pShrhouSiteiKbn) {
        shrhouSiteiKbn = pShrhouSiteiKbn;
    }

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String pBankCd) {
        bankCd = pBankCd;
    }

    public String getSitenCd() {
        return sitenCd;
    }

    public void setSitenCd(String pSitenCd) {
        sitenCd = pSitenCd;
    }

    public C_YokinKbn getYokinKbn() {
        return yokinKbn;
    }

    public void setYokinKbn(C_YokinKbn pYokinKbn) {
        yokinKbn = pYokinKbn;
    }

    public String getKouzaNo() {
        return kouzaNo;
    }

    public void setKouzaNo(String pKouzaNo) {
        kouzaNo = pKouzaNo;
    }

    public String getKzMeiginmKn() {
        return kzMeiginmKn;
    }

    public void setKzMeiginmKn(String pKzMeiginmKn) {
        kzMeiginmKn = pKzMeiginmKn;
    }

    public BizCurrency getSoukinGk () {
        return soukinGk ;
    }

    public void setSoukinGk (BizCurrency pSoukinGk ) {
        soukinGk  = pSoukinGk ;
    }

    public C_Tuukasyu getKykTuukasyu() {
        return kykTuukasyu;
    }

    public void setKykTuukasyu(C_Tuukasyu pKykTuukasyu) {
        kykTuukasyu = pKykTuukasyu;
    }

    public BizCurrency getGaikaTaikaGk() {
        return gaikaTaikaGk;
    }

    public void setGaikaTaikaGk(BizCurrency pGaikaTaikaGk) {
        gaikaTaikaGk = pGaikaTaikaGk;
    }

    public BizNumber getSoukinKwsRate() {
        return soukinKwsRate;
    }

    public void setSoukinKwsRate(BizNumber pSoukinKwsRate) {
        soukinKwsRate = pSoukinKwsRate;
    }

    public String getKzMeiginmei () {
        return kzMeiginmei ;
    }

    public void setKzMeiginmei (String pKzMeiginmei ) {
        kzMeiginmei  = pKzMeiginmei ;
    }

    public C_Tuukasyu getShrTuukaSyu () {
        return shrTuukaSyu ;
    }

    public void setShrTuukaSyu (C_Tuukasyu pShrTuukaSyu ) {
        shrTuukaSyu  = pShrTuukaSyu ;
    }

    public BizCurrency getGaikaShrgk() {
        return gaikaShrgk;
    }

    public void setGaikaShrgk(BizCurrency pGaikaShrgk) {
        gaikaShrgk = pGaikaShrgk;
    }

    public BizCurrency getCrossRateShrgk () {
        return crossRateShrgk ;
    }

    public void setCrossRateShrgk (BizCurrency pCrossRateShrgk ) {
        crossRateShrgk  = pCrossRateShrgk ;
    }

    public Integer getFbSokinEdaBangou() {
        return fbSokinEdaBangou;
    }

    public void setFbSokinEdaBangou(Integer pFbSokinEdaBangou) {
        fbSokinEdaBangou = pFbSokinEdaBangou;
    }

    public List<JT_SiDenpyoData> getSiDenpyoDataLst() {
        return siDenpyoDataLst;
    }

    public void setSiDenpyoDataLst(List<JT_SiDenpyoData> pSiDenpyoDataLst) {
        siDenpyoDataLst = pSiDenpyoDataLst;
    }

}