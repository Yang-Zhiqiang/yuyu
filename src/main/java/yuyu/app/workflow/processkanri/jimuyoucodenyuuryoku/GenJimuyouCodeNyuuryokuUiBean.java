package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;

/**
 * 事務用コード入力 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenJimuyouCodeNyuuryokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<JimuyouCodeListDataSourceBean> jimuyouCodeListDataSource = new DataSource<>();
    public DataSource<JimuyouCodeListDataSourceBean> getJimuyouCodeListDataSource() {
        return jimuyouCodeListDataSource;
    }

    @Deprecated
    public List<JimuyouCodeListDataSourceBean> getJimuyouCodeList() {
        return jimuyouCodeListDataSource.getDatas();
    }

    public void setJimuyouCodeList(List<JimuyouCodeListDataSourceBean> pJimuyouCodeList) {
        jimuyouCodeListDataSource.setDatas(pJimuyouCodeList);
    }

    private DataSource<JimuyouCodeList2DataSourceBean> jimuyouCodeList2DataSource = new DataSource<>();
    public DataSource<JimuyouCodeList2DataSourceBean> getJimuyouCodeList2DataSource() {
        return jimuyouCodeList2DataSource;
    }

    @Deprecated
    public List<JimuyouCodeList2DataSourceBean> getJimuyouCodeList2() {
        return jimuyouCodeList2DataSource.getDatas();
    }

    public void setJimuyouCodeList2(List<JimuyouCodeList2DataSourceBean> pJimuyouCodeList2) {
        jimuyouCodeList2DataSource.setDatas(pJimuyouCodeList2);
    }

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }

    private LoopChain<UserDefsList> subSystemIdOptionBeanList = new LoopChain<>();
    public UserDefsList getSubSystemIdOptionBeanList() {
        return subSystemIdOptionBeanList.get();
    }

    public void setSubSystemIdOptionBeanList(UserDefsList pSubSystemIdOptionBeanList) {
        clearSubSystemIdOptionBeanList();
        subSystemIdOptionBeanList.add(pSubSystemIdOptionBeanList);
    }

    public void clearSubSystemIdOptionBeanList() {
        subSystemIdOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> jimutetuzukicdOptionBeanList = new LoopChain<>();
    public UserDefsList getJimutetuzukicdOptionBeanList() {
        return jimutetuzukicdOptionBeanList.get();
    }

    public void setJimutetuzukicdOptionBeanList(UserDefsList pJimutetuzukicdOptionBeanList) {
        clearJimutetuzukicdOptionBeanList();
        jimutetuzukicdOptionBeanList.add(pJimutetuzukicdOptionBeanList);
    }

    public void clearJimutetuzukicdOptionBeanList() {
        jimutetuzukicdOptionBeanList.clear();
    }
}
