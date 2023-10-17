package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 顧客整備 - ●検索結果 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSrchRsltKzInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispbankcd;

    public String getDispbankcd() {
        return dispbankcd;
    }

    public void setDispbankcd(String pDispbankcd) {
        dispbankcd = pDispbankcd;
    }


    private String dispbanknmkj;

    public String getDispbanknmkj() {
        return dispbanknmkj;
    }

    public void setDispbanknmkj(String pDispbanknmkj) {
        dispbanknmkj = pDispbanknmkj;
    }


    private BizDate sinsetuymd;

    public BizDate getSinsetuymd() {
        return sinsetuymd;
    }

    public void setSinsetuymd(BizDate pSinsetuymd) {
        sinsetuymd = pSinsetuymd;
    }


    private String dispkouzano;

    public String getDispkouzano() {
        return dispkouzano;
    }

    public void setDispkouzano(String pDispkouzano) {
        dispkouzano = pDispkouzano;
    }


    private String dispkyknmkn;

    public String getDispkyknmkn() {
        return dispkyknmkn;
    }

    public void setDispkyknmkn(String pDispkyknmkn) {
        dispkyknmkn = pDispkyknmkn;
    }


    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }


    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }


    private String dispsitencd;

    public String getDispsitencd() {
        return dispsitencd;
    }

    public void setDispsitencd(String pDispsitencd) {
        dispsitencd = pDispsitencd;
    }


    private String dispsitennmkj;

    public String getDispsitennmkj() {
        return dispsitennmkj;
    }

    public void setDispsitennmkj(String pDispsitennmkj) {
        dispsitennmkj = pDispsitennmkj;
    }


    private BizDate haisiymd;

    public BizDate getHaisiymd() {
        return haisiymd;
    }

    public void setHaisiymd(BizDate pHaisiymd) {
        haisiymd = pHaisiymd;
    }


    private String dispkzmeiginmkn;

    public String getDispkzmeiginmkn() {
        return dispkzmeiginmkn;
    }

    public void setDispkzmeiginmkn(String pDispkzmeiginmkn) {
        dispkzmeiginmkn = pDispkzmeiginmkn;
    }

}
