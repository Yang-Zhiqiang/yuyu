package yuyu.def.biz.result.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 対象帳票情報Beanクラス<br />
 */
@AllArgsConstructor
public class SyoruiZokuseiTyouhyouInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public SyoruiZokuseiTyouhyouInfoBean() {

        super();
    }

    private C_SyoruiCdKbn syoruiCd;

    private String syoruinm;

    private String kensakuKey1;

    private String kensakuKey2;

    private String kensakuKey3;

    private String kensakuKey4;

    private String kensakuKey5;

    private Integer sortNo;

    private long notOutputCount;

    private long amount;

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        this.syoruiCd = pSyoruiCd;
    }

    public String getSyoruinm() {
        return syoruinm;
    }

    public void setSyoruinm(String pSyoruinm) {
        this.syoruinm = pSyoruinm;
    }

    public String getKensakuKey1() {
        return kensakuKey1;
    }

    public void setKensakuKey1(String pKensakuKey1) {
        this.kensakuKey1 = pKensakuKey1;
    }

    public String getKensakuKey2() {
        return kensakuKey2;
    }

    public void setKensakuKey2(String pKensakuKey2) {
        this.kensakuKey2 = pKensakuKey2;
    }

    public String getKensakuKey3() {
        return kensakuKey3;
    }

    public void setKensakuKey3(String pKensakuKey3) {
        this.kensakuKey3 = pKensakuKey3;
    }

    public String getKensakuKey4() {
        return kensakuKey4;
    }

    public void setKensakuKey4(String pKensakuKey4) {
        this.kensakuKey4 = pKensakuKey4;
    }

    public String getKensakuKey5() {
        return kensakuKey5;
    }

    public void setKensakuKey5(String pKensakuKey5) {
        this.kensakuKey5 = pKensakuKey5;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer pSortNo) {
        this.sortNo = pSortNo;
    }

    public long getNotOutputCount() {
        return notOutputCount;
    }

    public void setNotOutputCount(long pNotOutputCount) {
        this.notOutputCount = pNotOutputCount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long pAmount) {
        this.amount = pAmount;
    }

}