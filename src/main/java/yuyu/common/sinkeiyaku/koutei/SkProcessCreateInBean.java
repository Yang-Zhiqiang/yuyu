package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 工程 新契約工程作成入力Bean
 */
public class SkProcessCreateInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SkeijimuKbn skeiJimuKbn;

    private C_MosUketukeKbn mosUketukeKbn;

    private C_HknsyuruiNo hknSyuruiNo;

    private String dairitenCd1;

    private String dairitenCd2;

    private String jimuyouCd;

    private C_UmuKbn jmycdMisetteiKbn;

    private C_UmuKbn doujimosUmu;

    private BizDate mosYmd;

    private String jimuStartYmd;

    private String syoNo;

    private String mosNo;

    private String jimuTetuzukiCd;

    private C_KetteiKbn ketteiKbn;

    private C_SeirituKbn seirituKbn;

    private C_LincjkKbn lincjkKbn;

    public C_SkeijimuKbn getSkeiJimuKbn() {
        return skeiJimuKbn;
    }

    public void setSkeiJimuKbn(C_SkeijimuKbn pSkeiJimuKbn) {
        skeiJimuKbn = pSkeiJimuKbn;
    }

    public C_MosUketukeKbn getMosUketukeKbn() {
        return mosUketukeKbn;
    }

    public void setMosUketukeKbn(C_MosUketukeKbn pMosUketukeKbn) {
        mosUketukeKbn = pMosUketukeKbn;
    }

    public C_HknsyuruiNo getHknSyuruiNo() {
        return hknSyuruiNo;
    }

    public void setHknSyuruiNo(C_HknsyuruiNo pHknSyuruiNo) {
        hknSyuruiNo = pHknSyuruiNo;
    }

    public String getDairitenCd1() {
        return dairitenCd1;
    }

    public void setDairitenCd1(String pDairitenCd1) {
        dairitenCd1 = pDairitenCd1;
    }

    public String getDairitenCd2() {
        return dairitenCd2;
    }

    public void setDairitenCd2(String pDairitenCd2) {
        dairitenCd2 = pDairitenCd2;
    }

    public String getJimuyouCd() {
        return jimuyouCd;
    }

    public void setJimuyouCd(String pJimuyouCd) {
        jimuyouCd = pJimuyouCd;
    }

    public C_UmuKbn getJmycdMisetteiKbn() {
        return jmycdMisetteiKbn;
    }

    public void setJmycdMisetteiKbn(C_UmuKbn pJmycdMisetteiKbn) {
        jmycdMisetteiKbn = pJmycdMisetteiKbn;
    }

    public C_UmuKbn getDoujimosUmu() {
        return doujimosUmu;
    }

    public void setDoujimosUmu(C_UmuKbn pDoujimosUmu) {
        doujimosUmu = pDoujimosUmu;
    }

    public BizDate getMosYmd() {
        return mosYmd;
    }

    public void setMosYmd(BizDate pMosYmd) {
        mosYmd = pMosYmd;
    }

    public String getJimuStartYmd() {
        return jimuStartYmd;
    }

    public void setJimuStartYmd(String pJimuStartYmd) {
        jimuStartYmd = pJimuStartYmd;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public String getMosNo() {
        return mosNo;
    }

    public void setMosNo(String pMosNo) {
        mosNo = pMosNo;
    }

    public String getJimuTetuzukiCd() {
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimuTetuzukiCd) {
        jimuTetuzukiCd = pJimuTetuzukiCd;
    }

    public C_KetteiKbn getKetteiKbn() {
        return ketteiKbn;
    }

    public void setKetteiKbns(C_KetteiKbn pKetteiKbn) {
        ketteiKbn = pKetteiKbn;
    }

    public C_SeirituKbn getSeirituKbn() {
        return seirituKbn;
    }

    public void setSeirituKbn(C_SeirituKbn pSeirituKbn) {
        seirituKbn = pSeirituKbn;
    }

    public C_LincjkKbn getLincjkKbn() {
        return lincjkKbn;
    }

    public void setLincjkKbn(C_LincjkKbn pLincjkKbn) {
        lincjkKbn = pLincjkKbn;
    }
}