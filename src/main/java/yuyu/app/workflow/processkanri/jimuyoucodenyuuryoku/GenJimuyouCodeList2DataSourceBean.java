package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;

import java.io.Serializable;

/**
 * 事務用コード入力 - jimuyouCodeList2 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenJimuyouCodeList2DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispGyoumuKey;

    public String getDispGyoumuKey() {
        return dispGyoumuKey;
    }

    public void setDispGyoumuKey(String pDispGyoumuKey) {
        dispGyoumuKey = pDispGyoumuKey;
    }


    private String dispjimuyoucd;

    public String getDispjimuyoucd() {
        return dispjimuyoucd;
    }

    public void setDispjimuyoucd(String pDispjimuyoucd) {
        dispjimuyoucd = pDispjimuyoucd;
    }


    private String disphnkmaejimuyoucd;

    public String getDisphnkmaejimuyoucd() {
        return disphnkmaejimuyoucd;
    }

    public void setDisphnkmaejimuyoucd(String pDisphnkmaejimuyoucd) {
        disphnkmaejimuyoucd = pDisphnkmaejimuyoucd;
    }

}
