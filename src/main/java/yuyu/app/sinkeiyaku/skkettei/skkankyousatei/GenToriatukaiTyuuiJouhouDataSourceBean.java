package yuyu.app.sinkeiyaku.skkettei.skkankyousatei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 環境査定 - ●新契約取扱注意情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenToriatukaiTyuuiJouhouDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispskeittdktyuitrttrkymd;

    public BizDate getDispskeittdktyuitrttrkymd() {
        return dispskeittdktyuitrttrkymd;
    }

    public void setDispskeittdktyuitrttrkymd(BizDate pDispskeittdktyuitrttrkymd) {
        dispskeittdktyuitrttrkymd = pDispskeittdktyuitrttrkymd;
    }


    private String dispskeittdktyuitrtnaiyo;

    public String getDispskeittdktyuitrtnaiyo() {
        return dispskeittdktyuitrtnaiyo;
    }

    public void setDispskeittdktyuitrtnaiyo(String pDispskeittdktyuitrtnaiyo) {
        dispskeittdktyuitrtnaiyo = pDispskeittdktyuitrtnaiyo;
    }


    private String dispskeittdktyuitrttantou;

    public String getDispskeittdktyuitrttantou() {
        return dispskeittdktyuitrttantou;
    }

    public void setDispskeittdktyuitrttantou(String pDispskeittdktyuitrttantou) {
        dispskeittdktyuitrttantou = pDispskeittdktyuitrttantou;
    }

}
