package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）返金未処理リスト明細帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHenkinmisyorilistDetailBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkHenkinmisyorilistDetailBean() {
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private String irKyknmkj;


    public String getIrKyknmkj() {
        return irKyknmkj;
    }


    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }


    private String irSeiritujk;


    public String getIrSeiritujk() {
        return irSeiritujk;
    }


    public void setIrSeiritujk(String pIrSeiritujk) {
        irSeiritujk = pIrSeiritujk;
    }


    private String irSrsyoriymd;


    public String getIrSrsyoriymd() {
        return irSrsyoriymd;
    }


    public void setIrSrsyoriymd(String pIrSrsyoriymd) {
        irSrsyoriymd = pIrSrsyoriymd;
    }


    private String irLastrsymd;


    public String getIrLastrsymd() {
        return irLastrsymd;
    }


    public void setIrLastrsymd(String pIrLastrsymd) {
        irLastrsymd = pIrLastrsymd;
    }


    private String irTratkiagcd;


    public String getIrTratkiagcd() {
        return irTratkiagcd;
    }


    public void setIrTratkiagcd(String pIrTratkiagcd) {
        irTratkiagcd = pIrTratkiagcd;
    }


    private String irTyouhyousakuseiymd;


    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }


    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }


    private Integer irKensuu;


    public Integer getIrKensuu() {
        return irKensuu;
    }


    public void setIrKensuu(Integer pIrKensuu) {
        irKensuu = pIrKensuu;
    }


    private Integer irSoupagesuu;


    public Integer getIrSoupagesuu() {
        return irSoupagesuu;
    }


    public void setIrSoupagesuu(Integer pIrSoupagesuu) {
        irSoupagesuu = pIrSoupagesuu;
    }


    private Integer irPageno;


    public Integer getIrPageno() {
        return irPageno;
    }


    public void setIrPageno(Integer pIrPageno) {
        irPageno = pIrPageno;
    }


    private String irDrtencd;


    public String getIrDrtencd() {
        return irDrtencd;
    }


    public void setIrDrtencd(String pIrDrtencd) {
        irDrtencd = pIrDrtencd;
    }


    private String irDrtennmkj;


    public String getIrDrtennmkj() {
        return irDrtennmkj;
    }


    public void setIrDrtennmkj(String pIrDrtennmkj) {
        irDrtennmkj = pIrDrtennmkj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
