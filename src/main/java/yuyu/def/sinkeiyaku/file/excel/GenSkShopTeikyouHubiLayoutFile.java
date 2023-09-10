package yuyu.def.sinkeiyaku.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）ショップ提供用不備一覧レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkShopTeikyouHubiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkShopTeikyouHubiLayoutFile() {
    }


    @Column(order = 1, label = "申込番号")
    private String ifeMosno;


    public String getIfeMosno() {
        return ifeMosno;
    }


    public void setIfeMosno(String pIfeMosno) {
        ifeMosno = pIfeMosno;
    }


    @Column(order = 2, label = "代理店登録番号")
    private String ifeDrtentrkno;


    public String getIfeDrtentrkno() {
        return ifeDrtentrkno;
    }


    public void setIfeDrtentrkno(String pIfeDrtentrkno) {
        ifeDrtentrkno = pIfeDrtentrkno;
    }


    @Column(order = 3, label = "事務所コード")
    private String ifeJimusyocd;


    public String getIfeJimusyocd() {
        return ifeJimusyocd;
    }


    public void setIfeJimusyocd(String pIfeJimusyocd) {
        ifeJimusyocd = pIfeJimusyocd;
    }


    @Column(order = 4, label = "不備内容メッセージ")
    private String ifeHubinaiyoumsg;


    public String getIfeHubinaiyoumsg() {
        return ifeHubinaiyoumsg;
    }


    public void setIfeHubinaiyoumsg(String pIfeHubinaiyoumsg) {
        ifeHubinaiyoumsg = pIfeHubinaiyoumsg;
    }


    @Column(order = 5, label = "不備判明日")
    private String ifeHubihanmeiymd;


    public String getIfeHubihanmeiymd() {
        return ifeHubihanmeiymd;
    }


    public void setIfeHubihanmeiymd(String pIfeHubihanmeiymd) {
        ifeHubihanmeiymd = pIfeHubihanmeiymd;
    }


    @Column(order = 6, label = "連番_３桁")
    private Integer ifeRenno;


    public Integer getIfeRenno() {
        return ifeRenno;
    }


    public void setIfeRenno(Integer pIfeRenno) {
        ifeRenno = pIfeRenno;
    }


    @Column(order = 7, label = "代理店コード")
    private String ifeDrtencd;


    public String getIfeDrtencd() {
        return ifeDrtencd;
    }


    public void setIfeDrtencd(String pIfeDrtencd) {
        ifeDrtencd = pIfeDrtencd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
