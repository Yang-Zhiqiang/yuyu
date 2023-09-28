package yuyu.common.biz.bzcommon;

import java.io.Serializable;
import java.util.List;

/**
 * 業務共通 共通 業務共通イメージプロパティ取得出力Bean
 */
public class BzGetImagePropsOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kekkaStatus;

    private String syousaiMsgCd;

    private String syousaiMsg;

    private List<BzGetImagePropsBean> bzGetImagePropsBeanLst;

    public String getKekkaStatus(){
        return kekkaStatus;
    }

    public void setKekkaStatus(String pKekkaStatus){
        kekkaStatus = pKekkaStatus;
    }

    public String getSyousaiMsgCd(){
        return syousaiMsgCd;
    }

    public void setSyousaiMsgCd(String pSyousaiMsgCd){
        syousaiMsgCd = pSyousaiMsgCd;
    }

    public String getSyousaiMsg(){
        return syousaiMsg;
    }

    public void setSyousaiMsg(String pSyousaiMsg){
        syousaiMsg = pSyousaiMsg;
    }

    public List<BzGetImagePropsBean> getBzGetImagePropsBeanLst(){
        return bzGetImagePropsBeanLst;
    }

    public void setBzGetImagePropsBeanLst(List<BzGetImagePropsBean> pBzGetImagePropsBeanLst){
        bzGetImagePropsBeanLst = pBzGetImagePropsBeanLst;
    }

}
