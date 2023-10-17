package yuyu.app.workflow.processkanri.wariatekaijyo;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;

/**
 * 担当者割当解除 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenWariateKaijyoUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<TaskserInfoDataSourceBean> taskserInfoDataSource = new DataSource<>();
    public DataSource<TaskserInfoDataSourceBean> getTaskserInfoDataSource() {
        return taskserInfoDataSource;
    }

    @Deprecated
    public List<TaskserInfoDataSourceBean> getTaskserInfo() {
        return taskserInfoDataSource.getDatas();
    }

    public void setTaskserInfo(List<TaskserInfoDataSourceBean> pTaskserInfo) {
        taskserInfoDataSource.setDatas(pTaskserInfo, 10);
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

    private String workflowTskNm;

    public String getWorkflowTskNm() {
        return workflowTskNm;
    }

    public void setWorkflowTskNm(String pWorkflowTskNm) {
        workflowTskNm = pWorkflowTskNm;
    }

    private String tantid;

    public String getTantid() {
        return tantid;
    }

    public void setTantid(String pTantid) {
        tantid = pTantid;
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

    private LoopChain<UserDefsList> workflowTskNmOptionBeanList = new LoopChain<>();
    public UserDefsList getWorkflowTskNmOptionBeanList() {
        return workflowTskNmOptionBeanList.get();
    }

    public void setWorkflowTskNmOptionBeanList(UserDefsList pWorkflowTskNmOptionBeanList) {
        clearWorkflowTskNmOptionBeanList();
        workflowTskNmOptionBeanList.add(pWorkflowTskNmOptionBeanList);
    }

    public void clearWorkflowTskNmOptionBeanList() {
        workflowTskNmOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> tantidOptionBeanList = new LoopChain<>();
    public UserDefsList getTantidOptionBeanList() {
        return tantidOptionBeanList.get();
    }

    public void setTantidOptionBeanList(UserDefsList pTantidOptionBeanList) {
        clearTantidOptionBeanList();
        tantidOptionBeanList.add(pTantidOptionBeanList);
    }

    public void clearTantidOptionBeanList() {
        tantidOptionBeanList.clear();
    }
}
