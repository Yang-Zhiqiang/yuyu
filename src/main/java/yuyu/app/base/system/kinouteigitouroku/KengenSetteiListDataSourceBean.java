package yuyu.app.base.system.kinouteigitouroku;

/**
 * 機能定義登録 - ● 権限設定 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KengenSetteiListDataSourceBean extends GenKengenSetteiListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public KengenSetteiListDataSourceBean() {
    }

    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String pRoleCd) {
        this.roleCd = pRoleCd;
    }

}
