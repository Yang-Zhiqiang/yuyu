package yuyu.app.hozen.khozen.khkeiyakusyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.infr.validation.constraints.Tel;

/**
 * 契約内容照会 - kensakuResultInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKensakuResultInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsyono;

    public String getDispsyono() {
        return dispsyono;
    }

    public void setDispsyono(String pDispsyono) {
        dispsyono = pDispsyono;
    }


    private String dispkyknmkn;

    public String getDispkyknmkn() {
        return dispkyknmkn;
    }

    public void setDispkyknmkn(String pDispkyknmkn) {
        dispkyknmkn = pDispkyknmkn;
    }


    private String disptsintelno;

    public String getDisptsintelno() {
        return disptsintelno;
    }

    public void setDisptsintelno(String pDisptsintelno) {
        disptsintelno = pDisptsintelno;
    }


    private BizDate dispkykseiymd;

    public BizDate getDispkykseiymd() {
        return dispkykseiymd;
    }

    public void setDispkykseiymd(BizDate pDispkykseiymd) {
        dispkykseiymd = pDispkykseiymd;
    }


    private String dispsyouhnnm;

    public String getDispsyouhnnm() {
        return dispsyouhnnm;
    }

    public void setDispsyouhnnm(String pDispsyouhnnm) {
        dispsyouhnnm = pDispsyouhnnm;
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


    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String dispdai2tsintelno;

    public String getDispdai2tsintelno() {
        return dispdai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispdai2tsintelno(String pDispdai2tsintelno) {
        dispdai2tsintelno = pDispdai2tsintelno;
    }


    private BizDate disphhknseiymd;

    public BizDate getDisphhknseiymd() {
        return disphhknseiymd;
    }

    public void setDisphhknseiymd(BizDate pDisphhknseiymd) {
        disphhknseiymd = pDisphhknseiymd;
    }


    private C_YuukousyoumetuKbn dispyuukousyoumetukbn;

    public C_YuukousyoumetuKbn getDispyuukousyoumetukbn() {
        return dispyuukousyoumetukbn;
    }

    public void setDispyuukousyoumetukbn(C_YuukousyoumetuKbn pDispyuukousyoumetukbn) {
        dispyuukousyoumetukbn = pDispyuukousyoumetukbn;
    }


    private String disphhknnmkj;

    public String getDisphhknnmkj() {
        return disphhknnmkj;
    }

    public void setDisphhknnmkj(String pDisphhknnmkj) {
        disphhknnmkj = pDisphhknnmkj;
    }

}
