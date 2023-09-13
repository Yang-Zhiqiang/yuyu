package yuyu.def.hozen.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）成立契約明細ファイルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSeirituKykDtlFileLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSeirituKykDtlFileLayoutFile() {
    }

    @Column(order = 1, label = "証券番号")
    private String ifeSyono;

    public String getIfeSyono() {
        return ifeSyono;
    }

    public void setIfeSyono(String pIfeSyono) {
        ifeSyono = pIfeSyono;
    }

    @Column(order = 2, label = "契約年月日")
    private String ifeKykymd;

    public String getIfeKykymd() {
        return ifeKykymd;
    }

    public void setIfeKykymd(String pIfeKykymd) {
        ifeKykymd = pIfeKykymd;
    }

    @Column(order = 3, label = "Ａ扱者募集代理店コード")
    private String ifeAatkisyaBosyuuDrtencd;

    public String getIfeAatkisyaBosyuuDrtencd() {
        return ifeAatkisyaBosyuuDrtencd;
    }

    public void setIfeAatkisyaBosyuuDrtencd(String pIfeAatkisyaBosyuuDrtencd) {
        ifeAatkisyaBosyuuDrtencd = pIfeAatkisyaBosyuuDrtencd;
    }

    @Column(order = 4, label = "Ｂ扱者募集代理店コード")
    private String ifeBatkisyaBosyuuDrtencd;

    public String getIfeBatkisyaBosyuuDrtencd() {
        return ifeBatkisyaBosyuuDrtencd;
    }

    public void setIfeBatkisyaBosyuuDrtencd(String pIfeBatkisyaBosyuuDrtencd) {
        ifeBatkisyaBosyuuDrtencd = pIfeBatkisyaBosyuuDrtencd;
    }

    @Column(order = 5, label = "商品分類区分")
    private String ifeSyouhinbunruikbn;

    public String getIfeSyouhinbunruikbn() {
        return ifeSyouhinbunruikbn;
    }

    public void setIfeSyouhinbunruikbn(String pIfeSyouhinbunruikbn) {
        ifeSyouhinbunruikbn = pIfeSyouhinbunruikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
