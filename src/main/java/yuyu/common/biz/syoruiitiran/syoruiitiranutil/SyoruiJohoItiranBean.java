package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import java.io.Serializable;


/**
 * 【書類情報一覧】書類情報一覧Bean の処理結果クラスです。<br />
 */
public class SyoruiJohoItiranBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoruiNnm;

    public String getSyoruiNnm() {
        return syoruiNnm;
    }

    public void setSyoruiNnm(String pSyoruiNnm) {
        syoruiNnm = pSyoruiNnm;
    }


    private String syoruiTtykYmdTime;

    public String getSyoruiTtykYmdTime() {
        return syoruiTtykYmdTime;
    }

    public void setSyoruiTtykYmdTime(String pSyoruiTtykYmdTime) {
        syoruiTtykYmdTime = pSyoruiTtykYmdTime;
    }


    private String hituyouSyorui;

    public String getHituyouSyorui() {
        return hituyouSyorui;
    }

    public void setHituyouSyorui(String pHituyouSyorui) {
        hituyouSyorui = pHituyouSyorui;
    }


    private String hyoujiLink;

    public String getHyoujiLink() {
        return hyoujiLink;
    }

    public void setHyoujiLink(String pHyoujiLink) {
        hyoujiLink = pHyoujiLink;
    }


    private String imageId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String pImageId) {
        imageId = pImageId;
    }


    private String torikomiSyoruiCd;

    public String getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }


    private String hyoujiLinkFlg;

    public String getHyoujiLinkFlg() {
        return hyoujiLinkFlg;
    }

    public void setHyoujiLinkFlg(String pHyoujiLinkFlg) {
        hyoujiLinkFlg = pHyoujiLinkFlg;
    }


    private String kouteikanriId;

    public String getKouteikanriId() {
        return kouteikanriId;
    }

    public void setKouteikanriId(String pKouteikanriId) {
        kouteikanriId = pKouteikanriId;
    }

    private Integer sortNo;

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer pSortNo) {
        this.sortNo = pSortNo;
    }
}
