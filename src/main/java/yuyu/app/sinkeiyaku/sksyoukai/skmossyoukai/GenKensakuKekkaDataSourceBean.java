package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KkthjyKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 申込状況照会 - kensakuKekka の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKensakuKekkaDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispmosno;

    public String getDispmosno() {
        return dispmosno;
    }

    public void setDispmosno(String pDispmosno) {
        dispmosno = pDispmosno;
    }


    private String dispkyknmkn;

    public String getDispkyknmkn() {
        return dispkyknmkn;
    }

    public void setDispkyknmkn(String pDispkyknmkn) {
        dispkyknmkn = pDispkyknmkn;
    }


    private BizDate dispkykseiymd;

    public BizDate getDispkykseiymd() {
        return dispkykseiymd;
    }

    public void setDispkykseiymd(BizDate pDispkykseiymd) {
        dispkykseiymd = pDispkykseiymd;
    }


    private C_HknsyuruiNo disphknsyuruino;

    public C_HknsyuruiNo getDisphknsyuruino() {
        return disphknsyuruino;
    }

    public void setDisphknsyuruino(C_HknsyuruiNo pDisphknsyuruino) {
        disphknsyuruino = pDisphknsyuruino;
    }


    private C_KkthjyKbn dispkkthjykbn;

    public C_KkthjyKbn getDispkkthjykbn() {
        return dispkkthjykbn;
    }

    public void setDispkkthjykbn(C_KkthjyKbn pDispkkthjykbn) {
        dispkkthjykbn = pDispkkthjykbn;
    }


    private C_UmuKbn dispnyknnrkumu;

    public C_UmuKbn getDispnyknnrkumu() {
        return dispnyknnrkumu;
    }

    public void setDispnyknnrkumu(C_UmuKbn pDispnyknnrkumu) {
        dispnyknnrkumu = pDispnyknnrkumu;
    }


    private C_UmuKbn disphubiumu;

    public C_UmuKbn getDisphubiumu() {
        return disphubiumu;
    }

    public void setDisphubiumu(C_UmuKbn pDisphubiumu) {
        disphubiumu = pDisphubiumu;
    }


    private C_KetteiKbn dispketteikbn;

    public C_KetteiKbn getDispketteikbn() {
        return dispketteikbn;
    }

    public void setDispketteikbn(C_KetteiKbn pDispketteikbn) {
        dispketteikbn = pDispketteikbn;
    }


    private C_SeirituKbn dispseiritukbn;

    public C_SeirituKbn getDispseiritukbn() {
        return dispseiritukbn;
    }

    public void setDispseiritukbn(C_SeirituKbn pDispseiritukbn) {
        dispseiritukbn = pDispseiritukbn;
    }


    private String dispkyknmkj;

    public String getDispkyknmkj() {
        return dispkyknmkj;
    }

    public void setDispkyknmkj(String pDispkyknmkj) {
        dispkyknmkj = pDispkyknmkj;
    }


    private String disphhknnmkn;

    public String getDisphhknnmkn() {
        return disphhknnmkn;
    }

    public void setDisphhknnmkn(String pDisphhknnmkn) {
        disphhknnmkn = pDisphhknnmkn;
    }


    private BizDate disphhknseiymd;

    public BizDate getDisphhknseiymd() {
        return disphhknseiymd;
    }

    public void setDisphhknseiymd(BizDate pDisphhknseiymd) {
        disphhknseiymd = pDisphhknseiymd;
    }


    private String disphhknnmkj;

    public String getDisphhknnmkj() {
        return disphhknnmkj;
    }

    public void setDisphhknnmkj(String pDisphhknnmkj) {
        disphhknnmkj = pDisphhknnmkj;
    }

}
