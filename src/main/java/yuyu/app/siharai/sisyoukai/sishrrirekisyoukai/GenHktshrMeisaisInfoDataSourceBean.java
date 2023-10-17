package yuyu.app.siharai.sisyoukai.sishrrirekisyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 支払履歴照会 - ●支払詳細 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHktshrMeisaisInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syouhnnmgm;

    public String getSyouhnnmgm() {
        return syouhnnmgm;
    }

    public void setSyouhnnmgm(String pSyouhnnmgm) {
        syouhnnmgm = pSyouhnnmgm;
    }


    private BizCurrency kyhkg;

    public BizCurrency getKyhkg() {
        return kyhkg;
    }

    public void setKyhkg(BizCurrency pKyhkg) {
        kyhkg = pKyhkg;
    }


    private String bikoumsg1;

    public String getBikoumsg1() {
        return bikoumsg1;
    }

    public void setBikoumsg1(String pBikoumsg1) {
        bikoumsg1 = pBikoumsg1;
    }


    private String bikoumsg2;

    public String getBikoumsg2() {
        return bikoumsg2;
    }

    public void setBikoumsg2(String pBikoumsg2) {
        bikoumsg2 = pBikoumsg2;
    }


    private String bikoumsg3;

    public String getBikoumsg3() {
        return bikoumsg3;
    }

    public void setBikoumsg3(String pBikoumsg3) {
        bikoumsg3 = pBikoumsg3;
    }


    private String bikoumsg4;

    public String getBikoumsg4() {
        return bikoumsg4;
    }

    public void setBikoumsg4(String pBikoumsg4) {
        bikoumsg4 = pBikoumsg4;
    }

}
