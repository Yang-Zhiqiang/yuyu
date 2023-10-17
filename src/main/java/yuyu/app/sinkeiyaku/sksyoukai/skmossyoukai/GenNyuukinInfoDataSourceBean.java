package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_NyknsyubetuKbn;

/**
 * 申込状況照会 - ●入金情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenNyuukinInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency disprskingaku;

    public BizCurrency getDisprskingaku() {
        return disprskingaku;
    }

    public void setDisprskingaku(BizCurrency pDisprskingaku) {
        disprskingaku = pDisprskingaku;
    }


    private BizCurrency disprsdengkyen;

    public BizCurrency getDisprsdengkyen() {
        return disprsdengkyen;
    }

    public void setDisprsdengkyen(BizCurrency pDisprsdengkyen) {
        disprsdengkyen = pDisprsdengkyen;
    }


    private BizDate dispryosyuymd;

    public BizDate getDispryosyuymd() {
        return dispryosyuymd;
    }

    public void setDispryosyuymd(BizDate pDispryosyuymd) {
        dispryosyuymd = pDispryosyuymd;
    }


    private C_NyknsyubetuKbn dispnyknsyubetu;

    public C_NyknsyubetuKbn getDispnyknsyubetu() {
        return dispnyknsyubetu;
    }

    public void setDispnyknsyubetu(C_NyknsyubetuKbn pDispnyknsyubetu) {
        dispnyknsyubetu = pDispnyknsyubetu;
    }


    private String dispsoukincd;

    public String getDispsoukincd() {
        return dispsoukincd;
    }

    public void setDispsoukincd(String pDispsoukincd) {
        dispsoukincd = pDispsoukincd;
    }


    private BizDate disptyakkinymd;

    public BizDate getDisptyakkinymd() {
        return disptyakkinymd;
    }

    public void setDisptyakkinymd(BizDate pDisptyakkinymd) {
        disptyakkinymd = pDisptyakkinymd;
    }

}
