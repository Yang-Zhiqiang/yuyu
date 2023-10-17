package yuyu.app.workflow.processkanri.nenkinworklist;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;

/**
 * 年金支払工程ワークリスト : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenNenkinWorkListUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<ResultInfoTskSntkBaseDataSourceBean> resultInfoTskSntkBaseDataSource = new DataSource<>();
    public DataSource<ResultInfoTskSntkBaseDataSourceBean> getResultInfoTskSntkBaseDataSource() {
        return resultInfoTskSntkBaseDataSource;
    }

    @Deprecated
    public List<ResultInfoTskSntkBaseDataSourceBean> getResultInfoTskSntkBase() {
        return resultInfoTskSntkBaseDataSource.getDatas();
    }

    public void setResultInfoTskSntkBase(List<ResultInfoTskSntkBaseDataSourceBean> pResultInfoTskSntkBase) {
        resultInfoTskSntkBaseDataSource.setDatas(pResultInfoTskSntkBase);
    }

    private DataSource<ResultInfoTskSntkDataSourceBean> resultInfoTskSntkDataSource = new DataSource<>();
    public DataSource<ResultInfoTskSntkDataSourceBean> getResultInfoTskSntkDataSource() {
        return resultInfoTskSntkDataSource;
    }

    @Deprecated
    public List<ResultInfoTskSntkDataSourceBean> getResultInfoTskSntk() {
        return resultInfoTskSntkDataSource.getDatas();
    }

    public void setResultInfoTskSntk(List<ResultInfoTskSntkDataSourceBean> pResultInfoTskSntk) {
        resultInfoTskSntkDataSource.setDatas(pResultInfoTskSntk);
    }

    private DataSource<ResultInfoItiranDataSourceBean> resultInfoItiranDataSource = new DataSource<>();
    public DataSource<ResultInfoItiranDataSourceBean> getResultInfoItiranDataSource() {
        return resultInfoItiranDataSource;
    }

    @Deprecated
    public List<ResultInfoItiranDataSourceBean> getResultInfoItiran() {
        return resultInfoItiranDataSource.getDatas();
    }

    public void setResultInfoItiran(List<ResultInfoItiranDataSourceBean> pResultInfoItiran) {
        resultInfoItiranDataSource.setDatas(pResultInfoItiran, 15);
    }

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }

    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }

    @Length(length=3)
    @SingleByteStrings
    @AlphaDigit
    private String jimuyoucd;

    public String getJimuyoucd() {
        return jimuyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    private Boolean jmycdMisetteiKbn;

    public Boolean getJmycdMisetteiKbn() {
        return (jmycdMisetteiKbn == null) ? Boolean.FALSE : jmycdMisetteiKbn;
    }

    public void setJmycdMisetteiKbn(Boolean pJmycdMisetteiKbn) {
        jmycdMisetteiKbn = (pJmycdMisetteiKbn == null) ? Boolean.FALSE : pJmycdMisetteiKbn;
    }

    @ValidDate
    private BizDate jimustartYmdFrom;

    public BizDate getJimustartYmdFrom() {
        return jimustartYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimustartYmdFrom(BizDate pJimustartYmdFrom) {
        jimustartYmdFrom = pJimustartYmdFrom;
    }

    @ValidDate
    private BizDate jimustartYmdTo;

    public BizDate getJimustartYmdTo() {
        return jimustartYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimustartYmdTo(BizDate pJimustartYmdTo) {
        jimustartYmdTo = pJimustartYmdTo;
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

    private String clearbtn;

    public String getClearbtn() {
        return clearbtn;
    }

    public void setClearbtn(String pClearbtn) {
        clearbtn = pClearbtn;
    }

    private String joukenHozonBtn;

    public String getJoukenHozonBtn() {
        return joukenHozonBtn;
    }

    public void setJoukenHozonBtn(String pJoukenHozonBtn) {
        joukenHozonBtn = pJoukenHozonBtn;
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
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
