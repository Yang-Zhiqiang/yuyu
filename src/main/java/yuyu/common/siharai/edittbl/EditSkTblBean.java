package yuyu.common.siharai.edittbl;

import java.io.Serializable;
import java.util.List;

import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.entity.JT_NenkinInfo;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求TBL編集Bean
 */
public class EditSkTblBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skNo;

    private String syoNo;

    private Integer seikyuuRirekiNo;

    private Integer uketukeNo;

    private SkTblSetBean skTblSetBean;

    private List<SiSiDetailParamBean> siSiDetailParamBeanLst;

    private SiNenkinInfoBean siNenkinInfoBean;

    private JT_Sk sk;

    private List<JT_SkJiyuu> skJiyuuLst;

    private List<JT_SkByoumei> skByoumeiLst;

    private List<JT_SiDetail> siDetailLst;

    private JT_NenkinInfo nenkinInfo;

    private JT_SateiIppanHanteiInfo sateiIppanHanteiInfo;

    private JT_SateiKokuhanInfo sateiKokuhanInfo;

    private JT_SibouSateiChkInfo sibouSateiChkInfo;

    private JT_Toriatukaifuryouinfo toriatukaifuryouinfo;

    private JT_SateiKaijyoInfo sateiKaijyoInfo;

    private JT_SateiMeigihenkouInfo sateiMeigihenkouInfo;

    private JT_BetukutiSateiInfo betukutiSateiInfo;

    private JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo;

    public EditSkTblBean() {

        skNo = "";
        syoNo = "";
        seikyuuRirekiNo = 0;
        uketukeNo = 0;
        sk = new JT_Sk();

    }

    public String getSkNo() {
        return skNo;
    }

    public void setSkNo(String pSkNo) {
        skNo = pSkNo;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public Integer getSeikyuuRirekiNo() {
        return seikyuuRirekiNo;
    }

    public void setSeikyuuRirekiNo(Integer pSeikyuuRirekiNo) {
        seikyuuRirekiNo = pSeikyuuRirekiNo;
    }

    public Integer getUketukeNo() {
        return uketukeNo;
    }

    public void setUketukeNo(Integer pUketukeNo) {
        uketukeNo = pUketukeNo;
    }

    public SkTblSetBean getSkTblSetBean() {
        return skTblSetBean;
    }

    public void setSkTblSetBean(SkTblSetBean pSkTblSetBean) {
        skTblSetBean = pSkTblSetBean;
    }

    public List<SiSiDetailParamBean> getSiSiDetailParamBeanLst() {
        return siSiDetailParamBeanLst;
    }

    public void setSiSiDetailParamBeanLst(List<SiSiDetailParamBean> pSiSiDetailParamBeanLst) {
        siSiDetailParamBeanLst = pSiSiDetailParamBeanLst;
    }

    public SiNenkinInfoBean getSiNenkinInfoBean() {
        return siNenkinInfoBean;
    }

    public void setSiNenkinInfoBean(SiNenkinInfoBean pSiNenkinInfoBean) {
        siNenkinInfoBean = pSiNenkinInfoBean;
    }

    public JT_Sk getSk() {
        return sk;
    }

    public void setSk(JT_Sk pSk) {
        sk = pSk;
    }

    public List<JT_SkJiyuu> getSkJiyuuLst() {
        return skJiyuuLst;
    }

    public void setSkJiyuuLst(List<JT_SkJiyuu> pSkJiyuuLst) {
        skJiyuuLst = pSkJiyuuLst;
    }

    public List<JT_SkByoumei> getSkByoumeiLst() {
        return skByoumeiLst;
    }

    public void setSkByoumeiLst(List<JT_SkByoumei> pSkByoumeiLst) {
        skByoumeiLst = pSkByoumeiLst;
    }

    public List<JT_SiDetail> getSiDetailLst() {
        return siDetailLst;
    }

    public void setSiDetailLst(List<JT_SiDetail> pSiDetailLst) {
        siDetailLst = pSiDetailLst;
    }

    public JT_NenkinInfo getNenkinInfo() {
        return nenkinInfo;
    }

    public void setNenkinInfo(JT_NenkinInfo pNenkinInfo) {
        nenkinInfo = pNenkinInfo;
    }

    public JT_SateiIppanHanteiInfo getSateiIppanHanteiInfo() {
        return sateiIppanHanteiInfo;
    }

    public void setSateiIppanHanteiInfo(JT_SateiIppanHanteiInfo pSateiIppanHanteiInfo) {
        sateiIppanHanteiInfo = pSateiIppanHanteiInfo;
    }

    public JT_SateiKokuhanInfo getSateiKokuhanInfo() {
        return sateiKokuhanInfo;
    }

    public void setSateiKokuhanInfo(JT_SateiKokuhanInfo pSateiKokuhanInfo) {
        sateiKokuhanInfo = pSateiKokuhanInfo;
    }

    public JT_SibouSateiChkInfo getSibouSateiChkInfo() {
        return sibouSateiChkInfo;
    }

    public void setSibouSateiChkInfo(JT_SibouSateiChkInfo pSibouSateiChkInfo) {
        sibouSateiChkInfo = pSibouSateiChkInfo;
    }

    public JT_Toriatukaifuryouinfo getToriatukaifuryouinfo() {
        return toriatukaifuryouinfo;
    }

    public void setToriatukaifuryouinfo(JT_Toriatukaifuryouinfo pToriatukaifuryouinfo) {
        toriatukaifuryouinfo = pToriatukaifuryouinfo;
    }

    public JT_SateiKaijyoInfo getSateiKaijyoInfo() {
        return sateiKaijyoInfo;
    }

    public void setSateiKaijyoInfo(JT_SateiKaijyoInfo pSateiKaijyoInfo) {
        sateiKaijyoInfo = pSateiKaijyoInfo;
    }

    public JT_SateiMeigihenkouInfo getSateiMeigihenkouInfo() {
        return sateiMeigihenkouInfo;
    }

    public void setSateiMeigihenkouInfo(JT_SateiMeigihenkouInfo pSateiMeigihenkouInfo) {
        sateiMeigihenkouInfo = pSateiMeigihenkouInfo;
    }

    public JT_BetukutiSateiInfo getBetukutiSateiInfo() {
        return betukutiSateiInfo;
    }

    public void setBetukutiSateiInfo(JT_BetukutiSateiInfo pBetukutiSateiInfo) {
        betukutiSateiInfo = pBetukutiSateiInfo;
    }


    public JT_SateiJyuukasituChkInfo getSateiJyuukasituChkInfo() {
        return sateiJyuukasituChkInfo;
    }

    public void setSateiJyuukasituChkInfo(JT_SateiJyuukasituChkInfo pSateiJyuukasituChkInfo) {
        sateiJyuukasituChkInfo = pSateiJyuukasituChkInfo;
    }

}
