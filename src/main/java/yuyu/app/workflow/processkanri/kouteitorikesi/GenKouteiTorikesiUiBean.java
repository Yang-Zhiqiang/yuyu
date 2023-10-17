package yuyu.app.workflow.processkanri.kouteitorikesi;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 工程取消 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKouteiTorikesiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<KouteiListDataSourceBean> kouteiListDataSource = new DataSource<>();
    public DataSource<KouteiListDataSourceBean> getKouteiListDataSource() {
        return kouteiListDataSource;
    }

    @Deprecated
    public List<KouteiListDataSourceBean> getKouteiList() {
        return kouteiListDataSource.getDatas();
    }

    public void setKouteiList(List<KouteiListDataSourceBean> pKouteiList) {
        kouteiListDataSource.setDatas(pKouteiList);
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

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @NenkinSyousyoNo
    private String nksysyno;

    public String getNksysyno() {
        return nksysyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }

    private BizDate dispkouteikaisiymd;

    public BizDate getDispkouteikaisiymd() {
        return dispkouteikaisiymd;
    }

    public void setDispkouteikaisiymd(BizDate pDispkouteikaisiymd) {
        dispkouteikaisiymd = pDispkouteikaisiymd;
    }

    private String disptantounm;

    public String getDisptantounm() {
        return disptantounm;
    }

    public void setDisptantounm(String pDisptantounm) {
        disptantounm = pDisptantounm;
    }

    @ValidTextArea(length=50, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String workflowTorikesiComment;

    public String getWorkflowTorikesiComment() {
        return workflowTorikesiComment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setWorkflowTorikesiComment(String pWorkflowTorikesiComment) {
        workflowTorikesiComment = pWorkflowTorikesiComment;
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
