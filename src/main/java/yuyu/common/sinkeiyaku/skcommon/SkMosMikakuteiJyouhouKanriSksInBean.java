package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;
import java.util.ArrayList;

import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 新契約共通 新契約申込未確定情報作成入力Bean
 */
@ThreadScoped
public class SkMosMikakuteiJyouhouKanriSksInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mosNo;

    private String jimuTetuzukiCd;

    private C_SkeijimuKbn skeijimuKbn;

    private C_MosUketukeKbn mosUketukeKbn;

    private C_HknsyuruiNo hknsyuruiNo;

    private String dairitenCd1;

    private String dairitenCd2;

    private String jimuyouCd;

    private C_UmuKbn  doujiMosUmu;

    private String syoNo;

    private BizDate syoriYmd;

    private String setMosno1;

    private String gyoumuKousinsyaId;

    private String gyoumuKousinTime;

    private ArrayList<SkMosMikakuteiSyoruiSksInBean> skMosMikakuteiSyoruiSksInBeanLst;

    public SkMosMikakuteiJyouhouKanriSksInBean() {
        super();
        mosNo = "";
        jimuTetuzukiCd = "";
        skeijimuKbn = C_SkeijimuKbn.BLNK;
        mosUketukeKbn = C_MosUketukeKbn.BLNK;
        hknsyuruiNo = C_HknsyuruiNo.BLNK;
        dairitenCd1 = "";
        dairitenCd2 = "";
        jimuyouCd = "";
        doujiMosUmu = C_UmuKbn.NONE;
        syoNo = "";
        syoriYmd = null;
        setMosno1 = "";
        gyoumuKousinsyaId = "";
        gyoumuKousinTime = "";
        skMosMikakuteiSyoruiSksInBeanLst = new ArrayList<>();

    }

    public String getMosNo() {
        return mosNo;
    }

    public void setMosNo(String pMosNo) {
        this.mosNo = pMosNo;
    }

    public String getJimuTetuzukiCd() {
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimuTetuzukiCd) {
        this.jimuTetuzukiCd = pJimuTetuzukiCd;
    }

    public C_SkeijimuKbn getSkeijimuKbn() {
        return skeijimuKbn;
    }

    public void setSkeijimuKbn(C_SkeijimuKbn pSkeijimuKbn) {
        this.skeijimuKbn = pSkeijimuKbn;
    }

    public C_MosUketukeKbn getMosUketukeKbn() {
        return mosUketukeKbn;
    }

    public void setMosUketukeKbn(C_MosUketukeKbn pMosUketukeKbn) {
        this.mosUketukeKbn = pMosUketukeKbn;
    }

    public C_HknsyuruiNo getHknsyuruiNo() {
        return hknsyuruiNo;
    }

    public void setHknsyuruiNo(C_HknsyuruiNo pHknsyuruiNo) {
        this.hknsyuruiNo = pHknsyuruiNo;
    }

    public String getDairitenCd1() {
        return dairitenCd1;
    }

    public void setDairitenCd1(String pDairitenCd1) {
        this.dairitenCd1 = pDairitenCd1;
    }

    public String getDairitenCd2() {
        return dairitenCd2;
    }

    public void setDairitenCd2(String pDairitenCd2) {
        this.dairitenCd2 = pDairitenCd2;
    }

    public String getJimuyouCd() {
        return jimuyouCd;
    }

    public void setJimuyouCd(String pJimuyouCd) {
        this.jimuyouCd = pJimuyouCd;
    }

    public C_UmuKbn getDoujiMosUmu() {
        return doujiMosUmu;
    }

    public void setDoujiMosUmu(C_UmuKbn pDoujiMosUmu) {
        this.doujiMosUmu = pDoujiMosUmu;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        this.syoNo = pSyoNo;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        this.syoriYmd = pSyoriYmd;
    }

    public String getSetMosno1() {
        return setMosno1;
    }

    public void setSetMosno1(String pSetMosno1) {
        this.setMosno1 = pSetMosno1;
    }

    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        this.gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        this.gyoumuKousinTime = pGyoumuKousinTime;
    }

    public ArrayList<SkMosMikakuteiSyoruiSksInBean> getSkMosMikakuteiSyoruiSksInBeanLst() {
        return skMosMikakuteiSyoruiSksInBeanLst;
    }

    public void setSkMosMikakuteiSyoruiSksInBeanLst(
        ArrayList<SkMosMikakuteiSyoruiSksInBean> pSkMosMikakuteiSyoruiSksInBeanLst) {
        this.skMosMikakuteiSyoruiSksInBeanLst = pSkMosMikakuteiSyoruiSksInBeanLst;
    }

}
