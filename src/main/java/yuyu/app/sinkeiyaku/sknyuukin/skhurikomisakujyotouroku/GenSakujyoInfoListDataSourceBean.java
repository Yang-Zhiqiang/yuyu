package yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 振込入金削除データ登録 - sakujyoInfoList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSakujyoInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate disptrkymd;

    public BizDate getDisptrkymd() {
        return disptrkymd;
    }

    public void setDisptrkymd(BizDate pDisptrkymd) {
        disptrkymd = pDisptrkymd;
    }


    private String dispmosno;

    public String getDispmosno() {
        return dispmosno;
    }

    public void setDispmosno(String pDispmosno) {
        dispmosno = pDispmosno;
    }


    private String disphrkmirninnm;

    public String getDisphrkmirninnm() {
        return disphrkmirninnm;
    }

    public void setDisphrkmirninnm(String pDisphrkmirninnm) {
        disphrkmirninnm = pDisphrkmirninnm;
    }


    private String dispoyadrtencd;

    public String getDispoyadrtencd() {
        return dispoyadrtencd;
    }

    public void setDispoyadrtencd(String pDispoyadrtencd) {
        dispoyadrtencd = pDispoyadrtencd;
    }


    private C_Tuukasyu disprstuukasyu;

    public C_Tuukasyu getDisprstuukasyu() {
        return disprstuukasyu;
    }

    public void setDisprstuukasyu(C_Tuukasyu pDisprstuukasyu) {
        disprstuukasyu = pDisprstuukasyu;
    }


    private BizCurrency disprskingaku;

    public BizCurrency getDisprskingaku() {
        return disprskingaku;
    }

    public void setDisprskingaku(BizCurrency pDisprskingaku) {
        disprskingaku = pDisprskingaku;
    }


    private String dispsakujyoLink;

    public String getDispsakujyoLink() {
        return dispsakujyoLink;
    }

    public void setDispsakujyoLink(String pDispsakujyoLink) {
        dispsakujyoLink = pDispsakujyoLink;
    }


    private String sakujyoLink;

    public String getSakujyoLink() {
        return sakujyoLink;
    }

    public void setSakujyoLink(String pSakujyoLink) {
        sakujyoLink = pSakujyoLink;
    }

}
