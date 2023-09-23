package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_YokinKbn;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 支払明細書（診断書）Bean
 */
public class EditSiharaimeisaisyoSindansyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private SeikyuusyaInfoBean seikyuusyaInfoBean;

    private ToiawaseInfoBean toiawaseInfoBean;

    private String syoNo;

    private BizDate tyakkinYmd;

    private String kyuuhuNameReport;

    private Integer sindansyomaisuu;

    private BizCurrency sindansyoryou;

    private String banknmKj;

    private String sitennmKj;

    private C_YokinKbn yokinKbn;

    private String kouzaNo;

    private String kzmeiginmKn;

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public SeikyuusyaInfoBean getSeikyuusyaInfoBean() {
        return seikyuusyaInfoBean;
    }

    public void setSeikyuusyaInfoBean(SeikyuusyaInfoBean pSeikyuusyaInfoBean) {
        seikyuusyaInfoBean = pSeikyuusyaInfoBean;
    }

    public ToiawaseInfoBean getToiawaseInfoBean() {
        return toiawaseInfoBean;
    }

    public void setToiawaseInfoBean(ToiawaseInfoBean pToiawaseInfoBean) {
        toiawaseInfoBean = pToiawaseInfoBean;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public BizDate getTyakkinYmd() {
        return tyakkinYmd;
    }

    public void setTyakkinYmd(BizDate pTyakkinYmd) {
        tyakkinYmd = pTyakkinYmd;
    }

    public String getKyuuhuNameReport() {
        return kyuuhuNameReport;
    }

    public void setKyuuhuNameReport(String pKyuuhuNameReport) {
        kyuuhuNameReport = pKyuuhuNameReport;
    }

    public Integer getSindansyomaisuu() {
        return sindansyomaisuu;
    }

    public void setSindansyomaisuu(Integer pSindansyomaisuu) {
        sindansyomaisuu = pSindansyomaisuu;
    }

    public BizCurrency getSindansyoryou() {
        return sindansyoryou;
    }

    public void setSindansyo(BizCurrency pSindansyoryou) {
        sindansyoryou = pSindansyoryou;
    }

    public String getBanknmKj() {
        return banknmKj;
    }

    public void setBanknmKj(String pBanknmKj) {
        banknmKj = pBanknmKj;
    }

    public String getSitennmKj() {
        return sitennmKj;
    }

    public void setSitennmKj(String pSitennmKj) {
        sitennmKj = pSitennmKj;
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

    public String getKzmeiginmKn() {
        return kzmeiginmKn;
    }

    public void setKzmeiginmKn(String pKzmeiginmKn) {
        kzmeiginmKn = pKzmeiginmKn;
    }

}
