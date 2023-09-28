package yuyu.common.biz.bzcommon;

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
 * 業務共通 工程 追加パラメータ入力Beanクラス
 */
public class TuikaParamInputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SkeijimuKbn skeijimukbn;

    private C_MosUketukeKbn mosuketukekbn;

    private C_HknsyuruiNo hknsyuruiNo;

    private String dairitencd1;

    private String dairitencd2;

    private Boolean koDairitenTaisyouKbn;

    private String jimuyoucd;

    private String jmycdMisetteiKbn;

    private C_UmuKbn doujimosumu;

    private BizDate mosymd;

    private String jimustartymd;

    private String syono;

    private String nksysyno;

    private String mosno;

    private C_KetteiKbn ketteiKbn;

    private C_SeirituKbn seirituKbn;

    private C_LincjkKbn lincjkKbn;

    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    public C_MosUketukeKbn getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    public C_HknsyuruiNo getHknsyuruiNo() {
        return hknsyuruiNo;
    }

    public void setHknsyuruiNo(C_HknsyuruiNo pHknsyuruiNo) {
        hknsyuruiNo = pHknsyuruiNo;
    }

    public String getDairitencd1() {
        return dairitencd1;
    }

    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    public String getDairitencd2() {
        return dairitencd2;
    }

    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    public Boolean getKoDairitenTaisyouKbn() {
        return (koDairitenTaisyouKbn == null) ? Boolean.FALSE : koDairitenTaisyouKbn;
    }

    public void setKoDairitenTaisyouKbn(Boolean pKoDairitenTaisyouKbn) {
        koDairitenTaisyouKbn = (pKoDairitenTaisyouKbn == null) ? Boolean.FALSE : pKoDairitenTaisyouKbn;
    }

    public String getJimuyoucd() {
        return jimuyoucd;
    }

    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    public String getJmycdMisetteiKbn() {
        return jmycdMisetteiKbn;
    }

    public void setJmycdMisetteiKbn(String pJmycdMisetteiKbn) {
        jmycdMisetteiKbn = pJmycdMisetteiKbn;
    }

    public C_UmuKbn getDoujimosumu() {
        return doujimosumu;
    }

    public void setDoujimosumu(C_UmuKbn pDoujimosumu) {
        doujimosumu = pDoujimosumu;
    }

    public BizDate getMosymd() {
        return mosymd;
    }

    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    public String getJimustartymd() {
        return jimustartymd;
    }

    public void setJimustartymd(String pJimustartymd) {
        jimustartymd = pJimustartymd;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public String getNksysyno() {
        return nksysyno;
    }

    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
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
