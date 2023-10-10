package yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_TourokustatusKbn;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 取引サービス登録 - ●取引サービス登録一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTrhkServiceInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dsjimukaisiymd;

    public BizDate getDsjimukaisiymd() {
        return dsjimukaisiymd;
    }

    public void setDsjimukaisiymd(BizDate pDsjimukaisiymd) {
        dsjimukaisiymd = pDsjimukaisiymd;
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


    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }


    private String dispkakkyknmkj;

    public String getDispkakkyknmkj() {
        return dispkakkyknmkj;
    }

    public void setDispkakkyknmkj(String pDispkakkyknmkj) {
        dispkakkyknmkj = pDispkakkyknmkj;
    }


    private C_TourokustatusKbn tourokustatus;

    public C_TourokustatusKbn getTourokustatus() {
        return tourokustatus;
    }

    public void setTourokustatus(C_TourokustatusKbn pTourokustatus) {
        tourokustatus = pTourokustatus;
    }


    private String dispsyoritntnmkj;

    public String getDispsyoritntnmkj() {
        return dispsyoritntnmkj;
    }

    public void setDispsyoritntnmkj(String pDispsyoritntnmkj) {
        dispsyoritntnmkj = pDispsyoritntnmkj;
    }


    private String dsnyuuryokulink;

    public String getDsnyuuryokulink() {
        return dsnyuuryokulink;
    }

    public void setDsnyuuryokulink(String pDsnyuuryokulink) {
        dsnyuuryokulink = pDsnyuuryokulink;
    }

}
