package yuyu.app.workflow.processkanri.lockkyouseikaijyo;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 工程ロック強制解除 - lockedTaskInfoList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenLockedTaskInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispGyoumuKey;

    public String getDispGyoumuKey() {
        return dispGyoumuKey;
    }

    public void setDispGyoumuKey(String pDispGyoumuKey) {
        dispGyoumuKey = pDispGyoumuKey;
    }


    private BizDate dispjimustartymd;

    public BizDate getDispjimustartymd() {
        return dispjimustartymd;
    }

    public void setDispjimustartymd(BizDate pDispjimustartymd) {
        dispjimustartymd = pDispjimustartymd;
    }


    private String disptasknm;

    public String getDisptasknm() {
        return disptasknm;
    }

    public void setDisptasknm(String pDisptasknm) {
        disptasknm = pDisptasknm;
    }


    private String disptantounm;

    public String getDisptantounm() {
        return disptantounm;
    }

    public void setDisptantounm(String pDisptantounm) {
        disptantounm = pDisptantounm;
    }


    private String lockKaijyoLink;

    public String getLockKaijyoLink() {
        return lockKaijyoLink;
    }

    public void setLockKaijyoLink(String pLockKaijyoLink) {
        lockKaijyoLink = pLockKaijyoLink;
    }

}
