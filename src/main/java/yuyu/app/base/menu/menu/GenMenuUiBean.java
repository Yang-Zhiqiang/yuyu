package yuyu.app.base.menu.menu;

import java.util.List;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;

/**
 * メニュー : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenMenuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<MyMenuContentsDataSourceBean> myMenuContentsDataSource = new DataSource<>();
    public DataSource<MyMenuContentsDataSourceBean> getMyMenuContentsDataSource() {
        return myMenuContentsDataSource;
    }

    @Deprecated
    public List<MyMenuContentsDataSourceBean> getMyMenuContents() {
        return myMenuContentsDataSource.getDatas();
    }

    public void setMyMenuContents(List<MyMenuContentsDataSourceBean> pMyMenuContents) {
        myMenuContentsDataSource.setDatas(pMyMenuContents);
    }

    private DataSource<MenuContentsDataSourceBean> menuContentsDataSource = new DataSource<>();
    public DataSource<MenuContentsDataSourceBean> getMenuContentsDataSource() {
        return menuContentsDataSource;
    }

    @Deprecated
    public List<MenuContentsDataSourceBean> getMenuContents() {
        return menuContentsDataSource.getDatas();
    }

    public void setMenuContents(List<MenuContentsDataSourceBean> pMenuContents) {
        menuContentsDataSource.setDatas(pMenuContents);
    }
}
