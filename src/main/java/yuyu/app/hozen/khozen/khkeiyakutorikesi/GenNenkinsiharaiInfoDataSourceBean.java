package yuyu.app.hozen.khozen.khkeiyakutorikesi;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_NkSyoumetuCd;

/**
 * 契約取消 - ●別契約（年金支払契約） の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenNenkinsiharaiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vbtkkdispbtkyknksysyno;

    public String getVbtkkdispbtkyknksysyno() {
        return vbtkkdispbtkyknksysyno;
    }

    public void setVbtkkdispbtkyknksysyno(String pVbtkkdispbtkyknksysyno) {
        vbtkkdispbtkyknksysyno = pVbtkkdispbtkyknksysyno;
    }


    private BizDate vbtkkdispbtkyknkshrsymd;

    public BizDate getVbtkkdispbtkyknkshrsymd() {
        return vbtkkdispbtkyknkshrsymd;
    }

    public void setVbtkkdispbtkyknkshrsymd(BizDate pVbtkkdispbtkyknkshrsymd) {
        vbtkkdispbtkyknkshrsymd = pVbtkkdispbtkyknkshrsymd;
    }


    private C_NkSyoumetuCd vbtkkdispbtkyknksymtjiyuu;

    public C_NkSyoumetuCd getVbtkkdispbtkyknksymtjiyuu() {
        return vbtkkdispbtkyknksymtjiyuu;
    }

    public void setVbtkkdispbtkyknksymtjiyuu(C_NkSyoumetuCd pVbtkkdispbtkyknksymtjiyuu) {
        vbtkkdispbtkyknksymtjiyuu = pVbtkkdispbtkyknksymtjiyuu;
    }


    private BizDate vbtkkdispbtkyknksymtymd;

    public BizDate getVbtkkdispbtkyknksymtymd() {
        return vbtkkdispbtkyknksymtymd;
    }

    public void setVbtkkdispbtkyknksymtymd(BizDate pVbtkkdispbtkyknksymtymd) {
        vbtkkdispbtkyknksymtymd = pVbtkkdispbtkyknksymtymd;
    }

}
