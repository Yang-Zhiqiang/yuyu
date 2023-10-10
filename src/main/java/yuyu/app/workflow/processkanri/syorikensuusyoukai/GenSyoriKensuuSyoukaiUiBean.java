package yuyu.app.workflow.processkanri.syorikensuusyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 処理件数照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSyoriKensuuSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<TaskuserInfoDataSourceBean> taskuserInfoDataSource = new DataSource<>();
    public DataSource<TaskuserInfoDataSourceBean> getTaskuserInfoDataSource() {
        return taskuserInfoDataSource;
    }

    @Deprecated
    public List<TaskuserInfoDataSourceBean> getTaskuserInfo() {
        return taskuserInfoDataSource.getDatas();
    }

    public void setTaskuserInfo(List<TaskuserInfoDataSourceBean> pTaskuserInfo) {
        taskuserInfoDataSource.setDatas(pTaskuserInfo);
    }

    private DataSource<TaskuserInfo2DataSourceBean> taskuserInfo2DataSource = new DataSource<>();
    public DataSource<TaskuserInfo2DataSourceBean> getTaskuserInfo2DataSource() {
        return taskuserInfo2DataSource;
    }

    @Deprecated
    public List<TaskuserInfo2DataSourceBean> getTaskuserInfo2() {
        return taskuserInfo2DataSource.getDatas();
    }

    public void setTaskuserInfo2(List<TaskuserInfo2DataSourceBean> pTaskuserInfo2) {
        taskuserInfo2DataSource.setDatas(pTaskuserInfo2);
    }

    private DataSource<TaskuserInfo3DataSourceBean> taskuserInfo3DataSource = new DataSource<>();
    public DataSource<TaskuserInfo3DataSourceBean> getTaskuserInfo3DataSource() {
        return taskuserInfo3DataSource;
    }

    @Deprecated
    public List<TaskuserInfo3DataSourceBean> getTaskuserInfo3() {
        return taskuserInfo3DataSource.getDatas();
    }

    public void setTaskuserInfo3(List<TaskuserInfo3DataSourceBean> pTaskuserInfo3) {
        taskuserInfo3DataSource.setDatas(pTaskuserInfo3);
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

    @ValidDate
    private BizDate syoriYmd;

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    @ValidDate
    private BizDate syoriYmdTo;

    public BizDate getSyoriYmdTo() {
        return syoriYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmdTo(BizDate pSyoriYmdTo) {
        syoriYmdTo = pSyoriYmdTo;
    }

    @MaxLength(max=30)
    @AlphaDigit
    private String userId;

    public String getUserId() {
        return userId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String userNm;

    public String getUserNm() {
        return userNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserNm(String pUserNm) {
        userNm = pUserNm;
    }

    private String dispsubsystemnm;

    public String getDispsubsystemnm() {
        return dispsubsystemnm;
    }

    public void setDispsubsystemnm(String pDispsubsystemnm) {
        dispsubsystemnm = pDispsubsystemnm;
    }

    private BizDate dispsyoriymd;

    public BizDate getDispsyoriymd() {
        return dispsyoriymd;
    }

    public void setDispsyoriymd(BizDate pDispsyoriymd) {
        dispsyoriymd = pDispsyoriymd;
    }

    private BizDate dispsyoriymdto;

    public BizDate getDispsyoriymdto() {
        return dispsyoriymdto;
    }

    public void setDispsyoriymdto(BizDate pDispsyoriymdto) {
        dispsyoriymdto = pDispsyoriymdto;
    }

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }

    private String disptantcd;

    public String getDisptantcd() {
        return disptantcd;
    }

    public void setDisptantcd(String pDisptantcd) {
        disptantcd = pDisptantcd;
    }

    private String disptantounm;

    public String getDisptantounm() {
        return disptantounm;
    }

    public void setDisptantounm(String pDisptantounm) {
        disptantounm = pDisptantounm;
    }

    private String disptasknm;

    public String getDisptasknm() {
        return disptasknm;
    }

    public void setDisptasknm(String pDisptasknm) {
        disptasknm = pDisptasknm;
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
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
}
