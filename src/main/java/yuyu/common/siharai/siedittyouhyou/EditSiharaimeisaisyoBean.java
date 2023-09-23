package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_Sk;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 支払明細書Bean
 */
public class EditSiharaimeisaisyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private SeikyuusyaInfoBean seikyuusyaInfoBean;

    private ToiawaseInfoBean toiawaseInfoBean;

    private SaikensyaInfoBean saikensyaInfoBean;

    private String syoNo;

    private String kyknmKj;

    private String hhknnmKj;

    private BizDate tyakkinYmd;

    private BizDate sibouYmd;

    private C_Tuukasyu kykTuukasyu;

    private C_Tuukasyu shrTuukasyu;

    private BizNumber shrKwsrate;

    private BizDate knsnkijyunymd;

    private BizCurrency shrGk;

    private BizCurrency yenShrgk;

    private String banknmKj;

    private String sitennmKj;

    private C_YokinKbn yokinKbn;

    private String kouzaNo;

    private String kzmeiginmKn;

    private BizCurrency synykngk;

    private BizCurrency htykeihi;

    private String cctelNo;

    private JT_Sk sk;

    private List<JT_SiDetail> siDetailLst;

    private BizCurrency kztkgk;

    private C_ZeitratkiKbn zeitratkiKbn;

    private Integer kykhnkkaisuu;

    private BizCurrency shrkykhtykeihi;

    private C_Kykjyoutai kykjyoutai;

    private C_UmuKbn kouzaHyoujiUmu;

    EditSiharaimeisaisyoBean(){
        kouzaHyoujiUmu = C_UmuKbn.ARI;
    }

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

    public SaikensyaInfoBean getSaikensyaInfoBean() {
        return saikensyaInfoBean;
    }

    public void setSaikensyaInfoBean(SaikensyaInfoBean saikensyaInfoBean) {
        this.saikensyaInfoBean = saikensyaInfoBean;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public String getKyknmKj() {
        return kyknmKj;
    }

    public void setKyknmKj(String pKyknmKj) {
        kyknmKj = pKyknmKj;
    }

    public String getHhknnmKj() {
        return hhknnmKj;
    }

    public void setHhknnmKj(String pHhknnmKj) {
        hhknnmKj = pHhknnmKj;
    }

    public BizDate getTyakkinYmd() {
        return tyakkinYmd;
    }

    public void setTyakkinYmd(BizDate pTyakkinYmd) {
        tyakkinYmd = pTyakkinYmd;
    }

    public BizDate getSibouYmd() {
        return sibouYmd;
    }

    public void setSibouYmd(BizDate pSibouYmd) {
        sibouYmd = pSibouYmd;
    }

    public C_Tuukasyu getKykTuukasyu() {
        return kykTuukasyu;
    }

    public void setKykTuukasyu(C_Tuukasyu pKykTuukasyu) {
        kykTuukasyu = pKykTuukasyu;
    }

    public C_Tuukasyu getShrTuukasyu() {
        return shrTuukasyu;
    }

    public void setShrTuukasyu(C_Tuukasyu pShrTuukasyu) {
        shrTuukasyu = pShrTuukasyu;
    }

    public BizNumber getShrKwsrate() {
        return shrKwsrate;
    }

    public void setShrKwsrate(BizNumber pShrKwsrate) {
        shrKwsrate = pShrKwsrate;
    }

    public BizDate getKnsnkijyunymd() {
        return knsnkijyunymd;
    }

    public void setKnsnkijyunymd(BizDate knsnkijyunymd) {
        this.knsnkijyunymd = knsnkijyunymd;
    }

    public BizCurrency getShrGk() {
        return shrGk;
    }

    public void setShrGk(BizCurrency pShrGk) {
        shrGk = pShrGk;
    }

    public BizCurrency getYenShrgk() {
        return yenShrgk;
    }

    public void setYenShrgk(BizCurrency pYenShrgk) {
        yenShrgk = pYenShrgk;
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

    public BizCurrency getSynykngk() {
        return synykngk;
    }

    public void setSynykngk(BizCurrency synykngk) {
        this.synykngk = synykngk;
    }

    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    public void setHtykeihi(BizCurrency htykeihi) {
        this.htykeihi = htykeihi;
    }

    public String getCctelNo() {
        return cctelNo;
    }

    public void setCctelNo(String pCctelNo) {
        cctelNo = pCctelNo;
    }

    public JT_Sk getSk() {
        return sk;
    }

    public void setSk(JT_Sk sk) {
        this.sk = sk;
    }

    public List<JT_SiDetail> getSiDetailLst() {
        return siDetailLst;
    }

    public void setSiDetailLst(List<JT_SiDetail> pSiDetailLst) {
        siDetailLst = pSiDetailLst;
    }

    public BizCurrency getKztkgk() {
        return kztkgk;
    }

    public void setKztkgk(BizCurrency kztkgk) {
        this.kztkgk = kztkgk;
    }

    public C_ZeitratkiKbn getZeitratkiKbn() {
        return zeitratkiKbn;
    }

    public void setZeitratkiKbn(C_ZeitratkiKbn pZeitratkiKbn) {
        zeitratkiKbn = pZeitratkiKbn;
    }

    public Integer getKykHnkKaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykHnkKaisuu(Integer pKykHnkKaisuu) {
        kykhnkkaisuu = pKykHnkKaisuu;
    }

    public BizCurrency getShrKykHtyKeihi() {
        return shrkykhtykeihi;
    }

    public void setShrKykHtyKeihi(BizCurrency pShrKykHtyKeihi) {
        shrkykhtykeihi = pShrKykHtyKeihi;
    }

    public C_Kykjyoutai getKykjyoutai() {
        return kykjyoutai;
    }

    public void setKykjyoutai(C_Kykjyoutai kykjyoutai) {
        this.kykjyoutai = kykjyoutai;
    }

    public C_UmuKbn getKouzaHyoujiUmu() {
        return kouzaHyoujiUmu;
    }

    public void setKouzaHyoujiUmu(C_UmuKbn pKouzaHiHyoujiUmu) {
        this.kouzaHyoujiUmu = pKouzaHiHyoujiUmu;
    }

}
