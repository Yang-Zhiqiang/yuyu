package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;
import java.util.List;


/**
 * 保険金給付金支払 保険金給付金支払帳票編集 不備訂正書Bean
 */
public class HubiTeiseisyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private String syoNo;

    private String seikyuusyaNmKj;

    private List<EditHubiTeiseisyoItiranBean> hubiTeiseisyoItiranLst;

    private boolean kariSakusei;

    private String toritsugisyaKjnCd;

    private String toritsugisyaKjnmei;

    private String toritsugisyaSosikinm;

    public HubiTeiseisyoBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public String getSyono() {
        return syoNo;
    }

    public void setSyono(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public String getSeikyuusyanmKj() {
        return seikyuusyaNmKj;
    }

    public void setSeikyuusyanmKj(String pSeikyuusyaNmKj) {
        seikyuusyaNmKj = pSeikyuusyaNmKj;
    }

    public List<EditHubiTeiseisyoItiranBean> getHubiTeiseisyoItiranLst() {
        return hubiTeiseisyoItiranLst;
    }

    public void setHubiTeiseisyoItiranLst(List<EditHubiTeiseisyoItiranBean> pHubiTeiseisyoItiranLst) {
        hubiTeiseisyoItiranLst = pHubiTeiseisyoItiranLst;
    }

    public boolean getKarisakusei() {
        return kariSakusei;
    }

    public void setKarisakusei(boolean pKariSakusei) {
        kariSakusei = pKariSakusei;
    }

    public String getToritsugisyakjncd  () {
        return toritsugisyaKjnCd  ;
    }

    public void setToritsugisyakjncd  (String pToritsugisyaKjnCd  ) {
        toritsugisyaKjnCd   = pToritsugisyaKjnCd  ;
    }

    public String getToritsugisyakjnmei() {
        return toritsugisyaKjnmei;
    }

    public void setToritsugisyakjnmei(String pToritsugisyaKjnmei) {
        toritsugisyaKjnmei = pToritsugisyaKjnmei;
    }

    public String getToritsugisyaSosikinm() {
        return toritsugisyaSosikinm;
    }

    public void setToritsugisyaSosikinm(String pToritsugisyaSosikinm) {
        toritsugisyaSosikinm = pToritsugisyaSosikinm;
    }

}
