package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 業務共通 共通 業務共通イメージプロパティ取得Bean
 */
public class BzGetImagePropsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String imageId;

    private String kouteiKanriId;

    private C_SyoruiCdKbn syoruiCd;

    private String syoruiTtykYmdTime;

    private C_Kouteikanristatus kouteiKanriStatus;

    private String kengenUmu;

    private String tourokuAccountId;

    private String pageCount;

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
}
