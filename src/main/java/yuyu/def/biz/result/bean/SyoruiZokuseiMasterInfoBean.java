package yuyu.def.biz.result.bean;

import java.util.ArrayList;
import java.util.List;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.result.bean.GenResultBean;

/**
 * 伝票データ情報Beanクラス<br />
 */
public class SyoruiZokuseiMasterInfoBean extends GenResultBean {

    private static final long serialVersionUID = 1L;

    public SyoruiZokuseiMasterInfoBean() {

        super();
    }

    private C_SyoruiCdKbn syoruiCd;

    private String syoruinm;

    private String subSystemId;

    private String subSystemNm;

    private String kensakuKey1;

    private String kensakuKey2;

    private String kensakuKey3;

    private String kensakuKey4;

    private String kensakuKey5;

    private Integer syoruiZokuseiSortNo;

    private Integer subSystemSortNo;

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn syoruiCd) {
        this.syoruiCd = syoruiCd;
    }

    public String getSyoruinm() {
        return syoruinm;
    }

    public void setSyoruinm(String syoruinm) {
        this.syoruinm = syoruinm;
    }

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String subSystemId) {
        this.subSystemId = subSystemId;
    }

    public String getSubSystemNm() {
        return subSystemNm;
    }

    public void setSubSystemNm(String subSystemNm) {
        this.subSystemNm = subSystemNm;
    }

    public String getKensakuKey1() {
        return kensakuKey1;
    }

    public void setKensakuKey1(String kensakuKey1) {
        this.kensakuKey1 = kensakuKey1;
    }

    public String getKensakuKey2() {
        return kensakuKey2;
    }

    public void setKensakuKey2(String kensakuKey2) {
        this.kensakuKey2 = kensakuKey2;
    }

    public String getKensakuKey3() {
        return kensakuKey3;
    }

    public void setKensakuKey3(String kensakuKey3) {
        this.kensakuKey3 = kensakuKey3;
    }

    public String getKensakuKey4() {
        return kensakuKey4;
    }

    public void setKensakuKey4(String kensakuKey4) {
        this.kensakuKey4 = kensakuKey4;
    }

    public String getKensakuKey5() {
        return kensakuKey5;
    }

    public void setKensakuKey5(String kensakuKey5) {
        this.kensakuKey5 = kensakuKey5;
    }

    public Integer getSyoruiZokuseiSortNo() {
        return syoruiZokuseiSortNo;
    }

    public void setSyoruiZokuseiSortNo(Integer syoruiZokuseiSortNo) {
        this.syoruiZokuseiSortNo = syoruiZokuseiSortNo;
    }

    public Integer getSubSystemSortNo() {
        return subSystemSortNo;
    }

    public void setSubSystemSortNo(Integer subSystemSortNo) {
        this.subSystemSortNo = subSystemSortNo;
    }

    public  List<SyoruiZokuseiMasterInfoBean> setSyoruiZokuseiMasterInfoBean(List<Object[]> pObj) {

        List<SyoruiZokuseiMasterInfoBean> syoruiZokuseiMasterInfoBeanLst = new ArrayList<>();
        for (Object[] object : pObj) {
            SyoruiZokuseiMasterInfoBean syoruiZokuseiMasterInfoBean = new SyoruiZokuseiMasterInfoBean();

            syoruiZokuseiMasterInfoBean.setSyoruiCd((C_SyoruiCdKbn)object[0]);
            syoruiZokuseiMasterInfoBean.setSyoruinm((String)object[1]);
            syoruiZokuseiMasterInfoBean.setSubSystemId((String)object[2]);
            syoruiZokuseiMasterInfoBean.setSubSystemNm((String)object[3]);
            syoruiZokuseiMasterInfoBean.setKensakuKey1((String)object[4]);
            syoruiZokuseiMasterInfoBean.setKensakuKey2((String)object[5]);
            syoruiZokuseiMasterInfoBean.setKensakuKey3((String)object[6]);
            syoruiZokuseiMasterInfoBean.setKensakuKey4((String)object[7]);
            syoruiZokuseiMasterInfoBean.setKensakuKey5((String)object[8]);
            syoruiZokuseiMasterInfoBean.setSyoruiZokuseiSortNo((Integer)object[9]);
            syoruiZokuseiMasterInfoBean.setSubSystemSortNo((Integer)object[10]);

            syoruiZokuseiMasterInfoBeanLst.add(syoruiZokuseiMasterInfoBean);
        }

        return syoruiZokuseiMasterInfoBeanLst;
    }

}