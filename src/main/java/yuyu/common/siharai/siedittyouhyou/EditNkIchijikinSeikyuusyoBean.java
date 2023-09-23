package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 年金基金変更請求書兼一時金請求書編集Bean
 */
public class EditNkIchijikinSeikyuusyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private SeikyuusyaInfoBean seikyuusyaInfoBean;

    private String syono;

    private Integer kakuteiNenkinKikan;

    private String tuukaTeni;

    private String toritsugisyaKjnCd;

    private String toritsugisyaKjnNm;

    private String toritsugisyaSosikiNm;

    public EditNkIchijikinSeikyuusyoBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public SeikyuusyaInfoBean getSeikyuusyaInfoBean() {
        return seikyuusyaInfoBean;
    }

    public void setSeikyuusyaInfoBean(SeikyuusyaInfoBean pSeikyuusyaInfoBean) {
        seikyuusyaInfoBean = pSeikyuusyaInfoBean;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public Integer getKakuteiNenkinKikan() {
        return kakuteiNenkinKikan;
    }

    public void setKakuteiNenkinKikan(Integer pKakuteiNenkinKikan) {
        kakuteiNenkinKikan = pKakuteiNenkinKikan;
    }

    public String getTuukaTeni() {
        return tuukaTeni;
    }

    public void setTuukaTeni(String pTuukaTeni) {
        tuukaTeni = pTuukaTeni;
    }

    public String getToritsugisyaKjnCd() {
        return toritsugisyaKjnCd;
    }

    public void setToritsugisyaKjnCd(String pToritsugisyaKjnCd) {
        toritsugisyaKjnCd = pToritsugisyaKjnCd;
    }

    public String getToritsugisyaKjnNm() {
        return toritsugisyaKjnNm;
    }

    public void setToritsugisyaKjnNm(String pToritsugisyaKjnNm) {
        toritsugisyaKjnNm = pToritsugisyaKjnNm;
    }

    public String getToritsugisyaSosikiNm() {
        return toritsugisyaSosikiNm;
    }

    public void setToritsugisyaSosikiNm(String pToritsugisyaSosikiNm) {
        toritsugisyaSosikiNm = pToritsugisyaSosikiNm;
    }

}
