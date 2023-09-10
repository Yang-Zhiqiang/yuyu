package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * （新契約）送付案内帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkSouhuannaiBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkSouhuannaiBean() {
    }


    private String irShsyno;


    public String getIrShsyno() {
        return irShsyno;
    }


    public void setIrShsyno(String pIrShsyno) {
        irShsyno = pIrShsyno;
    }


    private String irShadr1kj;


    public String getIrShadr1kj() {
        return irShadr1kj;
    }


    public void setIrShadr1kj(String pIrShadr1kj) {
        irShadr1kj = pIrShadr1kj;
    }


    private String irShadr2kj;


    public String getIrShadr2kj() {
        return irShadr2kj;
    }


    public void setIrShadr2kj(String pIrShadr2kj) {
        irShadr2kj = pIrShadr2kj;
    }


    private String irShadr3kj;


    public String getIrShadr3kj() {
        return irShadr3kj;
    }


    public void setIrShadr3kj(String pIrShadr3kj) {
        irShadr3kj = pIrShadr3kj;
    }


    private String irShsnmkj;


    public String getIrShsnmkj() {
        return irShsnmkj;
    }


    public void setIrShsnmkj(String pIrShsnmkj) {
        irShsnmkj = pIrShsnmkj;
    }


    private String irTyouhyousakuseiymd;


    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }


    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }


    private String irSyono;


    public String getIrSyono() {
        return irSyono;
    }


    public void setIrSyono(String pIrSyono) {
        irSyono = pIrSyono;
    }


    private String irKyknmkj;


    public String getIrKyknmkj() {
        return irKyknmkj;
    }


    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }


    private String irHhknnmkj;


    public String getIrHhknnmkj() {
        return irHhknnmkj;
    }


    public void setIrHhknnmkj(String pIrHhknnmkj) {
        irHhknnmkj = pIrHhknnmkj;
    }


    private String irHknsyurui;


    public String getIrHknsyurui() {
        return irHknsyurui;
    }


    public void setIrHknsyurui(String pIrHknsyurui) {
        irHknsyurui = pIrHknsyurui;
    }


    private String irMosymd;


    public String getIrMosymd() {
        return irMosymd;
    }


    public void setIrMosymd(String pIrMosymd) {
        irMosymd = pIrMosymd;
    }


    private String irDrtennmkj;


    public String getIrDrtennmkj() {
        return irDrtennmkj;
    }


    public void setIrDrtennmkj(String pIrDrtennmkj) {
        irDrtennmkj = pIrDrtennmkj;
    }


    private String irTantnm;


    public String getIrTantnm() {
        return irTantnm;
    }


    public void setIrTantnm(String pIrTantnm) {
        irTantnm = pIrTantnm;
    }


    private C_UmuKbn irDrtenbosyuuumu;


    public C_UmuKbn getIrDrtenbosyuuumu() {
        return irDrtenbosyuuumu;
    }


    public void setIrDrtenbosyuuumu(C_UmuKbn pIrDrtenbosyuuumu) {
        irDrtenbosyuuumu = pIrDrtenbosyuuumu;
    }


    private C_SyoruiCdKbn irSyoruicd;


    public C_SyoruiCdKbn getIrSyoruicd() {
        return irSyoruicd;
    }


    public void setIrSyoruicd(C_SyoruiCdKbn pIrSyoruicd) {
        irSyoruicd = pIrSyoruicd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
