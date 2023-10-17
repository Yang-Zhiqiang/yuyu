package yuyu.app.base.system.kinouteigitouroku;

import java.util.List;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.ui.DataSource;

/**
 * 機能定義登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KinouTeigiTourokuUiBean extends GenKinouTeigiTourokuUiBean {

    private static final long serialVersionUID = 1L;

    public KinouTeigiTourokuUiBean() {
    }

    private List<KinouModeInfoListDataSourceBean> kinouModeInfoListDataSourceBeanBak;

    public List<KinouModeInfoListDataSourceBean> getKinouModeInfoListDataSourceBeanBak() {
        return kinouModeInfoListDataSourceBeanBak;
    }

    public void setKinouModeInfoListDataSourceBeanBak(
        List<KinouModeInfoListDataSourceBean> pKinouModeInfoListDataSourceBeanBak) {
        this.kinouModeInfoListDataSourceBeanBak = pKinouModeInfoListDataSourceBeanBak;
    }

    private boolean subSystemEnableFlg;

    public boolean getSubSystemEnableFlg() {
        return subSystemEnableFlg;
    }

    public void setSubSystemEnableFlg(boolean pSubSystemEnableFlg) {
        this.subSystemEnableFlg = pSubSystemEnableFlg;
    }

    private boolean kinouModeSiborikomiDataumuFlg;

    public boolean getKinouModeSiborikomiDataumuFlg() {
        return kinouModeSiborikomiDataumuFlg;
    }

    public void setKinouModeSiborikomiDataumuFlg(boolean pKinouModeSiborikomiDataumuFlg) {
        kinouModeSiborikomiDataumuFlg = pKinouModeSiborikomiDataumuFlg;
    }

    private DataSource<KengenSetteiListDataSourceBean> bakRoleInfo = new DataSource<KengenSetteiListDataSourceBean>();

    public DataSource<KengenSetteiListDataSourceBean> getBakRoleInfo() {
        return bakRoleInfo;
    }

    public void setBakRoleInfo(List<KengenSetteiListDataSourceBean> pBakRoleInfo) {
        this.bakRoleInfo.setDatas(pBakRoleInfo);
    }
}
