package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_TaisyakuKbn;

/**
 * （新契約）ハンド仮勘定票帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkHandkarikanjyouBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkHandkarikanjyouBean() {
    }


    private String irTyouhyousakuseiymd;


    public String getIrTyouhyousakuseiymd() {
        return irTyouhyousakuseiymd;
    }


    public void setIrTyouhyousakuseiymd(String pIrTyouhyousakuseiymd) {
        irTyouhyousakuseiymd = pIrTyouhyousakuseiymd;
    }


    private String irKanjyoukmknm;


    public String getIrKanjyoukmknm() {
        return irKanjyoukmknm;
    }


    public void setIrKanjyoukmknm(String pIrKanjyoukmknm) {
        irKanjyoukmknm = pIrKanjyoukmknm;
    }


    private Integer irHndkarikanjyono;


    public Integer getIrHndkarikanjyono() {
        return irHndkarikanjyono;
    }


    public void setIrHndkarikanjyono(Integer pIrHndkarikanjyono) {
        irHndkarikanjyono = pIrHndkarikanjyono;
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private String irDenkihyouymd;


    public String getIrDenkihyouymd() {
        return irDenkihyouymd;
    }


    public void setIrDenkihyouymd(String pIrDenkihyouymd) {
        irDenkihyouymd = pIrDenkihyouymd;
    }


    private String irDenymd;


    public String getIrDenymd() {
        return irDenymd;
    }


    public void setIrDenymd(String pIrDenymd) {
        irDenymd = pIrDenymd;
    }


    private C_TaisyakuKbn irTaisyakukbn;


    public C_TaisyakuKbn getIrTaisyakukbn() {
        return irTaisyakukbn;
    }


    public void setIrTaisyakukbn(C_TaisyakuKbn pIrTaisyakukbn) {
        irTaisyakukbn = pIrTaisyakukbn;
    }


    private String irDengkhrktuuka;


    public String getIrDengkhrktuuka() {
        return irDengkhrktuuka;
    }


    public void setIrDengkhrktuuka(String pIrDengkhrktuuka) {
        irDengkhrktuuka = pIrDengkhrktuuka;
    }


    private String irDengkyenkansan;


    public String getIrDengkyenkansan() {
        return irDengkyenkansan;
    }


    public void setIrDengkyenkansan(String pIrDengkyenkansan) {
        irDengkyenkansan = pIrDengkyenkansan;
    }


    private String irDenkwsratetekiymd;


    public String getIrDenkwsratetekiymd() {
        return irDenkwsratetekiymd;
    }


    public void setIrDenkwsratetekiymd(String pIrDenkwsratetekiymd) {
        irDenkwsratetekiymd = pIrDenkwsratetekiymd;
    }


    private String irKinounm;


    public String getIrKinounm() {
        return irKinounm;
    }


    public void setIrKinounm(String pIrKinounm) {
        irKinounm = pIrKinounm;
    }


    private String irSousasyanm;


    public String getIrSousasyanm() {
        return irSousasyanm;
    }


    public void setIrSousasyanm(String pIrSousasyanm) {
        irSousasyanm = pIrSousasyanm;
    }


    private String irDenrenno;


    public String getIrDenrenno() {
        return irDenrenno;
    }


    public void setIrDenrenno(String pIrDenrenno) {
        irDenrenno = pIrDenrenno;
    }


    private Integer irEdano;


    public Integer getIrEdano() {
        return irEdano;
    }


    public void setIrEdano(Integer pIrEdano) {
        irEdano = pIrEdano;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
