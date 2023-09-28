package yuyu.common.biz.koutei;

/**
 * 業務共通 工程 工程情報表示設定UiBeanパラメータ
 */
public interface SetKouteiInfoExecUiBeanParam {
    String getVktifdispjimutetuzukinm();

    void setVktifdispjimutetuzukinm(String pVktifdispjimutetuzukinm);

    String getVktifdisptasknm();

    void setVktifdisptasknm(String pVktifdisptasknm);

    BzWorkflowInfo getBzWorkflowInfo();
}
