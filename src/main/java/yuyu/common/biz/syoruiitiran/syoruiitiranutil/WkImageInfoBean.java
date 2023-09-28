package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import java.io.Serializable;


/**
 * 【書類情報一覧】WK．イメージ情報Bean<br />
 */
public class WkImageInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sortNo;

    private String sSyoruitoutyakutime_;

    private byte[] opdfimage_;


    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer pSortNo) {
        this.sortNo = pSortNo;
    }

    public String getSyoruitoutyakutime() {
        return sSyoruitoutyakutime_;
    }

    public void setSyoruitoutyakutime(String psSyoruitoutyakutime) {
        sSyoruitoutyakutime_ = psSyoruitoutyakutime;
    }

    public byte[] getPdfimage() {
        return opdfimage_;
    }

    public void setPdfimage(byte[] poPDFimage) {
        opdfimage_ = poPDFimage;
    }
}

