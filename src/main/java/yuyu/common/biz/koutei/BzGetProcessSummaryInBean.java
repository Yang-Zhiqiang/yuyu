package yuyu.common.biz.koutei;

import java.io.Serializable;
import java.util.Comparator;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 工程 業務共通工程サマリ取得入力Bean
 */
public class BzGetProcessSummaryInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kouteiKanriId = null;

    private String[] kouteiKanriIds = null;

    private String jimuTetuzukiCd = null;

    private BizDate kouteiStartYmdFrom = null;

    private BizDate kouteiStartYmdTo = null;

    private BizDate kouteEndYmdFrom = null;

    private BizDate kouteEndYmdTo = null;

    private String jimuKaisiYmdFrom = null;

    private String jimuKaisiYmdTo = null;

    private C_Kouteikanristatus[] kouteiKanriStatuss = null;

    private String[] taskIds = null;

    private String taskId = null;

    private String mosNo = null;

    private String syoNo = null;

    private String[] skNos = null;

    private String nkSysyNo = null;

    private C_KetteiKbn[] ketteiKbn = null;

    private C_SeirituKbn[] seirituKbn = null;

    private C_LincjkKbn[] lincjkKbn = null;

    private String subSystemId = null;

    private String kekkajyougenkensu = null;

    private C_UmuKbn syukouteiSiborikomiUmu = C_UmuKbn.NONE;

    private Comparator<BzGetProcessSummaryOutBean> bzGetProcessSummaryComparator = null;

    public String getKouteiKanriId(){
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId){
        kouteiKanriId = pKouteiKanriId;
    }

    public String[] getKouteiKanriIds(){
        return kouteiKanriIds;
    }

    public void setKouteiKanriIds(String[] pKouteiKanriIds){
        kouteiKanriIds = pKouteiKanriIds;
    }

    public String getJimuTetuzukiCd(){
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimutetuzukiCd){
        jimuTetuzukiCd = pJimutetuzukiCd;
    }

    public BizDate getKouteiStartYmdFrom(){
        return kouteiStartYmdFrom;
    }

    public void setKouteiStartYmdFrom(BizDate pKouteiStartYmdFrom){
        kouteiStartYmdFrom = pKouteiStartYmdFrom;
    }

    public BizDate getKouteiStartYmdTo(){
        return kouteiStartYmdTo;
    }

    public void setKouteiStartYmdTo(BizDate pKouteiStartYmdTo){
        kouteiStartYmdTo = pKouteiStartYmdTo;
    }

    public BizDate getKouteEndYmdFrom(){
        return kouteEndYmdFrom;
    }

    public void setKouteEndYmdFrom(BizDate pKouteEndYmdFrom){
        kouteEndYmdFrom = pKouteEndYmdFrom;
    }

    public BizDate getKouteEndYmdTo(){
        return kouteEndYmdTo;
    }

    public void setKouteEndYmdTo(BizDate pKouteEndYmdTo){
        kouteEndYmdTo = pKouteEndYmdTo;
    }

    public String getJimuKaisiYmdFrom(){
        return jimuKaisiYmdFrom;
    }

    public void setJimuKaisiYmdFrom(String pJimuKaisiYmdFrom){
        jimuKaisiYmdFrom = pJimuKaisiYmdFrom;
    }

    public String getJimuKaisiYmdTo(){
        return jimuKaisiYmdTo;
    }

    public void setJimuKaisiYmdTo(String pJimuKaisiYmdTo){
        jimuKaisiYmdTo = pJimuKaisiYmdTo;
    }

    public C_Kouteikanristatus[] getKouteiKanriStatuss(){
        return kouteiKanriStatuss;
    }

    public void setKouteiKanriStatuss(C_Kouteikanristatus... pKouteikanristatuss){
        kouteiKanriStatuss = pKouteikanristatuss;
    }

    public String[] getTaskIds(){
        return taskIds;
    }

    public void setTaskIds(String[] pTaskIds){
        taskIds = pTaskIds;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String pTaskId) {
        this.taskId = pTaskId;
    }

    public String getMosNo(){
        return mosNo;
    }

    public void setMosNo(String pMosNo){
        mosNo = pMosNo;
    }

    public String getSyoNo(){
        return syoNo;
    }

    public void setSyoNo(String pSyoNo){
        syoNo = pSyoNo;
    }

    public String[] getSkNos(){
        return skNos;
    }

    @Deprecated
    public void setSkNos(String[] pSkNos){
        skNos = pSkNos;
    }

    public String getNkSysyNo(){
        return nkSysyNo;
    }

    public void setNkSysyNo(String pNkSysyNo){
        nkSysyNo = pNkSysyNo;
    }

    public C_KetteiKbn[] getKetteiKbn(){
        return ketteiKbn;
    }

    public void setKetteiKbn(C_KetteiKbn[] pKetteiKbn){
        ketteiKbn = pKetteiKbn;
    }

    public C_SeirituKbn[] getSeirituKbn(){
        return seirituKbn;
    }

    public void setSeirituKbn(C_SeirituKbn[] pSeirituKbn){
        seirituKbn = pSeirituKbn;
    }

    public C_LincjkKbn[] getLincjkKbn(){
        return lincjkKbn;
    }

    public void setLincjkKbn(C_LincjkKbn[] pLincjkKbn){
        lincjkKbn = pLincjkKbn;
    }

    public String getSubSystemId(){
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId){
        subSystemId = pSubSystemId;
    }

    public String getKekkajyougenkensu(){
        return kekkajyougenkensu;
    }

    public void setKekkajyougenkensu(String pKekkajyougenkensu){
        kekkajyougenkensu = pKekkajyougenkensu;
    }

    public C_UmuKbn getSyukouteiSiborikomiUmu(){
        return syukouteiSiborikomiUmu;
    }

    public void setSyukouteiSiborikomiUmu(C_UmuKbn pSyukouteiSiborikomiUmu){
        syukouteiSiborikomiUmu = pSyukouteiSiborikomiUmu;
    }

    public Comparator<BzGetProcessSummaryOutBean> getBzGetProcessSummaryComparator(){
        return bzGetProcessSummaryComparator;
    }

    public void setBzGetProcessSummaryComparator(Comparator<BzGetProcessSummaryOutBean> pBzGetProcessSummaryComparator){
        bzGetProcessSummaryComparator = pBzGetProcessSummaryComparator;
    }
}
