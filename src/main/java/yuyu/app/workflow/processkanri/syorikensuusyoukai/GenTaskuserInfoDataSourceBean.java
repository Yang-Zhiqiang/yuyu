package yuyu.app.workflow.processkanri.syorikensuusyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;

/**
 * 処理件数照会 - taskuserInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTaskuserInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }


    private BizNumber zenjituzanKensuu;

    public BizNumber getZenjituzanKensuu() {
        return zenjituzanKensuu;
    }

    public void setZenjituzanKensuu(BizNumber pZenjituzanKensuu) {
        zenjituzanKensuu = pZenjituzanKensuu;
    }


    private BizNumber zanKensuu;

    public BizNumber getZanKensuu() {
        return zanKensuu;
    }

    public void setZanKensuu(BizNumber pZanKensuu) {
        zanKensuu = pZanKensuu;
    }


    private BizNumber kanryoKensuu;

    public BizNumber getKanryoKensuu() {
        return kanryoKensuu;
    }

    public void setKanryoKensuu(BizNumber pKanryoKensuu) {
        kanryoKensuu = pKanryoKensuu;
    }


    private String syousaiLink;

    public String getSyousaiLink() {
        return syousaiLink;
    }

    public void setSyousaiLink(String pSyousaiLink) {
        syousaiLink = pSyousaiLink;
    }

}
