package yuyu.common.biz.koutei;

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
 * 業務共通 工程 業務共通工程作成入力Bean
 */
public class BzProcessCreateInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subSystemId;

    private String mosNo;

    private String syoNo;

    private String skNo;

    private String nkSysyNo;

    private C_SkeijimuKbn skeijimuKbn;

    private C_MosUketukeKbn mosUketukeKbn;

    private C_HknsyuruiNo hknsyuruiNo;

    private String dairitenCd1;

    private String dairitenCd2;

    private String jimuyouCd;

    private C_UmuKbn jmycdMisetteiKbn;

    private C_UmuKbn doujiMosumu;

    private String jimustartYmd;

    private BizDate mosymd;

    private String jimuTetuzukiCd;

    private String oyaKouteiKanriId;

    private String oyaKouteiJimuTetuzukiCd;

    private C_KetteiKbn ketteiKbn;

    private C_SeirituKbn seirituKbn;

    private C_LincjkKbn lincjkKbn;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    public String getMosNo() {
        return mosNo;
    }

    public void setMosNo(String pMosNo) {
        mosNo = pMosNo;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public String getSkNo() {
        return skNo;
    }

    public void setSkNo(String pSkNo) {
        skNo = pSkNo;
    }

    public String getNkSysyNo() {
        return nkSysyNo;
    }

    public void setNkSysyNo(String pNkSysyNo) {
        nkSysyNo = pNkSysyNo;
    }

    public C_SkeijimuKbn getSkeijimuKbn() {
        return skeijimuKbn;
    }

    public void setSkeijimuKbn(C_SkeijimuKbn pSkeijimuKbn) {
        skeijimuKbn = pSkeijimuKbn;
    }

    public C_MosUketukeKbn getMosUketukeKbn() {
        return mosUketukeKbn;
    }

    public void setMosUketukeKbn(C_MosUketukeKbn pMosUketukeKbn) {
        mosUketukeKbn = pMosUketukeKbn;
    }

    public C_HknsyuruiNo getHknsyuruiNo() {
        return hknsyuruiNo;
    }

    public void setHknsyuruiNo(C_HknsyuruiNo pHknsyuruiNo) {
        hknsyuruiNo = pHknsyuruiNo;
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

    public C_UmuKbn getDoujiMosumu() {
        return doujiMosumu;
    }

    public void setDoujiMosumu(C_UmuKbn pDoujiMosumu) {
        doujiMosumu = pDoujiMosumu;
    }

    public String getJimustartYmd() {
        return jimustartYmd;
    }

    public void setJimustartYmd(String pJimustartYmd) {
        jimustartYmd = pJimustartYmd;
    }

    public BizDate getMosymd() {
        return mosymd;
    }

    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    public String getJimuTetuzukiCd() {
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimuTetuzukiCd) {
        jimuTetuzukiCd = pJimuTetuzukiCd;
    }

    public String getOyaKouteiKanriId() {
        return oyaKouteiKanriId;
    }

    public void setOyaKouteiKanriId(String pOyaKouteiKanriId) {
        oyaKouteiKanriId = pOyaKouteiKanriId;
    }

    public String getOyaKouteiJimuTetuzukiCd() {
        return oyaKouteiJimuTetuzukiCd;
    }

    public void setOyaKouteiJimuTetuzukiCd(String pOyaKouteiJimuTetuzukiCd) {
        oyaKouteiJimuTetuzukiCd = pOyaKouteiJimuTetuzukiCd;
    }

    public C_KetteiKbn getKetteiKbn() {
        return ketteiKbn;
    }

    public void setKetteiKbn(C_KetteiKbn pKetteiKbn) {
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
