package yuyu.batch.biz.bzimagekanri.bzgazoukaimagesakujyo;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YesNoKbn;

/**
 * 業務共通 イメージ管理 削除帳票Bean
 */
public class BzDropCyouhyouBean {

    private String imageId;

    private String kouteiKanriId;

    private C_SyoruiCdKbn syoruiCd;

    private String syoruiTtykYmdTime;

    private C_Kouteikanristatus kouteiKanriStatus;

    private String kengenUmu;

    private String tourokuAccountId;

    private String pageCount;

    private String jimuTetuzukiCd;

    private String jimuTetuzukiNm;

    private BizDate kouteiStartYmd;

    private BizDate kouteEndYmd;

    private String lastKosTime;

    private String firstTantId;

    private String znkTantId;

    private String znkNodeId;

    private String znkNodeNm;

    private String nowTantId;

    private String nowNodeId;

    private String nowNodeNm;

    private BizDate jimuStartYmd;

    private String mosNo;

    private String syoNo;

    private String skNo;

    private String nkSysyNo;

    private C_SkeijimuKbn skeijimuKbn;

    private C_MosUketukeKbn mosUketukeKbn;

    private C_HknsyuruiNo hknsyuruiNo;

    private String dairitencd1;

    private String dairitencd2;

    private String jimuyoucd;

    private C_UmuKbn jmycdMisetteiKbn;

    private C_UmuKbn doujimosumu;

    private String jimuStartYmdTime;

    private BizDate mosymd;

    private C_KetteiKbn ketteiKbn;

    private C_SeirituKbn seirituKbn;

    private C_LincjkKbn lincjkKbn;

    private C_YesNoKbn syukouteiKbn;

    private String subSystemId;

    private Integer jimutetuzukiDispOrder;

    private Integer tskDispOrder;

    public String getImageId(){
        return imageId;
    }

    public void setImageId(String pImageId){
        imageId = pImageId;
    }

    public String getKouteiKanriId(){
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId){
        kouteiKanriId = pKouteiKanriId;
    }

    public C_SyoruiCdKbn getSyoruiCd(){
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd){
        syoruiCd = pSyoruiCd;
    }

    public String getSyoruiTtykYmdTime(){
        return syoruiTtykYmdTime;
    }

    public void setSyoruiTtykYmdTime(String pSyoruiTtykYmdTime){
        syoruiTtykYmdTime = pSyoruiTtykYmdTime;
    }

    public C_Kouteikanristatus getKouteiKanriStatus(){
        return kouteiKanriStatus;
    }

    public void setKouteiKanriStatus(C_Kouteikanristatus pKouteiKanriStatus){
        kouteiKanriStatus = pKouteiKanriStatus;
    }

    public String getKengenUmu(){
        return kengenUmu;
    }

    public void setKengenUmu(String pKengenUmu){
        kengenUmu = pKengenUmu;
    }

    public String getTourokuAccountId(){
        return tourokuAccountId;
    }

    public void setTourokuAccountId(String pTourokuAccountId){
        tourokuAccountId = pTourokuAccountId;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pPageCount) {
        pageCount = pPageCount;
    }

    public String getJimuTetuzukiCd() {
        return jimuTetuzukiCd;
    }

    public void setJimuTetuzukiCd(String pJimutetuzukiCd) {
        jimuTetuzukiCd = pJimutetuzukiCd;
    }

    public String getJimuTetuzukiNm() {
        return jimuTetuzukiNm;
    }

    public void setJimuTetuzukiNm(String pJimutetuzukiNm) {
        jimuTetuzukiNm = pJimutetuzukiNm;
    }

    public BizDate getKouteiStartYmd() {
        return kouteiStartYmd;
    }

    public void setKouteiStartYmd(BizDate pKouteiStartYmd) {
        kouteiStartYmd = pKouteiStartYmd;
    }

    public BizDate getKouteEndYmd() {
        return kouteEndYmd;
    }

    public void setKouteEndYmd(BizDate pKouteEndYmd) {
        kouteEndYmd = pKouteEndYmd;
    }

    public String getLastKosTime() {
        return lastKosTime;
    }

    public void setLastKosTime(String pLastKostime) {
        lastKosTime = pLastKostime;
    }

    public String getFirstTantId() {
        return firstTantId;
    }

    public void setFirstTantId(String pFirstTantId) {
        firstTantId = pFirstTantId;
    }

    public String getZnkTantId() {
        return znkTantId;
    }

    public void setZnkTantId(String pZenkaiTantId) {
        znkTantId = pZenkaiTantId;
    }

    public String getZnkNodoId() {
        return znkNodeId;
    }

    public void setZnkNodoId(String pZenkaiNodoId) {
        znkNodeId = pZenkaiNodoId;
    }

    public String getZnkNodoNm() {
        return znkNodeNm;
    }

    public void setZnkNodoNm(String pZenkaiNodoNm) {
        znkNodeNm = pZenkaiNodoNm;
    }

    public String getNowTantId() {
        return nowTantId;
    }

    public void setNowTantId(String pNowTantId) {
        nowTantId = pNowTantId;
    }

    public String getNowNodoId() {
        return nowNodeId;
    }

    public void setNowNodoId(String pNowNodoId) {
        nowNodeId = pNowNodoId;
    }

    public String getNowNodoNm() {
        return nowNodeNm;
    }

    public void setNowNodoNm(String pNowNodoNm) {
        nowNodeNm = pNowNodoNm;
    }

    public BizDate getJimuStartYmd() {
        return jimuStartYmd;
    }

    public void setJimuStartYmd(BizDate pJimuStartYmd) {
        jimuStartYmd = pJimuStartYmd;
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

    public String getJimuyoucd() {
        return jimuyoucd;
    }

    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    public C_UmuKbn getJmycdMisetteiKbn() {
        return jmycdMisetteiKbn;
    }

    public void setJmycdMisetteiKbn(C_UmuKbn pJmycdMisetteiKbn) {
        jmycdMisetteiKbn = pJmycdMisetteiKbn;
    }

    public C_UmuKbn getDoujimosumu() {
        return doujimosumu;
    }

    public void setDoujimosumu(C_UmuKbn pDoujimosumu) {
        doujimosumu = pDoujimosumu;
    }

    public String getJimuStartYmdTime() {
        return jimuStartYmdTime;
    }

    public void setJimuStartYmdTime(String pJimuStartYmdTime) {
        jimuStartYmdTime = pJimuStartYmdTime;
    }

    public BizDate getMosymd() {
        return mosymd;
    }

    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    public C_KetteiKbn getKetteiKbn(){
        return ketteiKbn;
    }

    public void setKetteiKbn(C_KetteiKbn pKetteiKbn){
        ketteiKbn = pKetteiKbn;
    }

    public C_SeirituKbn getSeirituKbn(){
        return seirituKbn;
    }

    public void setSeirituKbn(C_SeirituKbn pSeirituKbn){
        seirituKbn = pSeirituKbn;
    }

    public C_LincjkKbn getLincjkKbn(){
        return lincjkKbn;
    }

    public void setLincjkKbn(C_LincjkKbn pLincjkKbn){
        lincjkKbn = pLincjkKbn;
    }

    public C_YesNoKbn getSyukouteiKbn() {
        return syukouteiKbn;
    }

    public void setSyukouteiKbn(C_YesNoKbn pSyukouteiKbn) {
        syukouteiKbn = pSyukouteiKbn;
    }

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    public Integer getJimutetuzukiDispOrder() {
        return jimutetuzukiDispOrder;
    }

    public void setJimutetuzukiDispOrder(Integer pJimutetuzukiDispOrder) {
        jimutetuzukiDispOrder = pJimutetuzukiDispOrder;
    }

    public Integer getTskDispOrder() {
        return tskDispOrder;
    }

    public void setTaskDispOrder(Integer pTaskDispOrder) {
        tskDispOrder = pTaskDispOrder;
    }
}
