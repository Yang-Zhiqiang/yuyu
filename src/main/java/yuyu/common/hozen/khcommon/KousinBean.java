package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 契約保全 契約保全共通 更新内容明細項目Bean
 */
public class KousinBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate koushinBi;

    private BizCurrency hknry = BizCurrency.valueOf(0);

    private String syouhnCd = "";

    private int syouhnSdNo = 0;

    private int hknKkn = 0;

    private int hrkKkn = 0;

    private int hhknNen = 0;

    public KousinBean() {
        super();
    }

    public BizDate getKoushinbi() {
        return koushinBi;
    }

    public void setKoushinbi(BizDate pKoushinbi) {
        koushinBi = pKoushinbi;
    }

    public BizCurrency getHknry(){
        return hknry;
    }

    public void setHknry(BizCurrency pHknry){
        hknry = pHknry;
    }

    public String getSyouhncd() {
        return syouhnCd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhnCd = pSyouhncd;
    }

    public int getSyouhnSdno() {
        return syouhnSdNo;
    }

    public void setSyouhnSdno(int pSyouhnSdno) {
        syouhnSdNo = pSyouhnSdno;
    }

    public int getHknkkn(){
        return hknKkn;
    }

    public void setHknkkn(int pHknkkn) {
        hknKkn = pHknkkn;
    }

    public int getHrkkkn() {
        return hrkKkn;
    }

    public void setHrkkkn(int pHrkkkn) {
        hrkKkn = pHrkkkn;
    }

    public int getHhknNen() {
        return hhknNen;
    }

    public void setHhknNen(int pHhknNen) {
        hhknNen = pHhknNen;
    }
}
