package yuyu.app.workflow.processkanri.kouteijyoukyousyoukai;

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
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 工程状況照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKouteiJyoukyouSyoukaiUiBean extends AbstractUiBean {

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
        taskuserInfoDataSource.setDatas(pTaskuserInfo, 10);
    }

    private DataSource<ResultInfoDataSourceBean> resultInfoDataSource = new DataSource<>();
    public DataSource<ResultInfoDataSourceBean> getResultInfoDataSource() {
        return resultInfoDataSource;
    }

    @Deprecated
    public List<ResultInfoDataSourceBean> getResultInfo() {
        return resultInfoDataSource.getDatas();
    }

    public void setResultInfo(List<ResultInfoDataSourceBean> pResultInfo) {
        resultInfoDataSource.setDatas(pResultInfo, 10);
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

    private Boolean subflowincludeCheckBox;

    public Boolean getSubflowincludeCheckBox() {
        return (subflowincludeCheckBox == null) ? Boolean.FALSE : subflowincludeCheckBox;
    }

    public void setSubflowincludeCheckBox(Boolean pSubflowincludeCheckBox) {
        subflowincludeCheckBox = (pSubflowincludeCheckBox == null) ? Boolean.FALSE : pSubflowincludeCheckBox;
    }

    private String tskid;

    public String getTskid() {
        return tskid;
    }

    public void setTskid(String pTskid) {
        tskid = pTskid;
    }

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
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

    @ValidDate
    private BizDate srchjimustartymdfrom;

    public BizDate getSrchjimustartymdfrom() {
        return srchjimustartymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchjimustartymdfrom(BizDate pSrchjimustartymdfrom) {
        srchjimustartymdfrom = pSrchjimustartymdfrom;
    }

    @ValidDate
    private BizDate srchjimustartymdto;

    public BizDate getSrchjimustartymdto() {
        return srchjimustartymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchjimustartymdto(BizDate pSrchjimustartymdto) {
        srchjimustartymdto = pSrchjimustartymdto;
    }

    @ValidDate
    private BizDate srchKouteikanStartYmdFrom;

    public BizDate getSrchKouteikanStartYmdFrom() {
        return srchKouteikanStartYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchKouteikanStartYmdFrom(BizDate pSrchKouteikanStartYmdFrom) {
        srchKouteikanStartYmdFrom = pSrchKouteikanStartYmdFrom;
    }

    @ValidDate
    private BizDate srchKouteikanStartYmdTo;

    public BizDate getSrchKouteikanStartYmdTo() {
        return srchKouteikanStartYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchKouteikanStartYmdTo(BizDate pSrchKouteikanStartYmdTo) {
        srchKouteikanStartYmdTo = pSrchKouteikanStartYmdTo;
    }

    @ValidDate
    private BizDate srchLastkosStartYmdFrom;

    public BizDate getSrchLastkosStartYmdFrom() {
        return srchLastkosStartYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchLastkosStartYmdFrom(BizDate pSrchLastkosStartYmdFrom) {
        srchLastkosStartYmdFrom = pSrchLastkosStartYmdFrom;
    }

    @ValidDate
    private BizDate srchLastkosStartYmdTo;

    public BizDate getSrchLastkosStartYmdTo() {
        return srchLastkosStartYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchLastkosStartYmdTo(BizDate pSrchLastkosStartYmdTo) {
        srchLastkosStartYmdTo = pSrchLastkosStartYmdTo;
    }

    private C_Kouteikanristatus kouteikanristatus;

    public C_Kouteikanristatus getKouteikanristatus() {
        return kouteikanristatus;
    }

    public void setKouteikanristatus(C_Kouteikanristatus pKouteikanristatus) {
        kouteikanristatus = pKouteikanristatus;
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

    private Boolean commonCheckBox;

    public Boolean getCommonCheckBox() {
        return (commonCheckBox == null) ? Boolean.FALSE : commonCheckBox;
    }

    public void setCommonCheckBox(Boolean pCommonCheckBox) {
        commonCheckBox = (pCommonCheckBox == null) ? Boolean.FALSE : pCommonCheckBox;
    }

    private String dispGyoumuKey;

    public String getDispGyoumuKey() {
        return dispGyoumuKey;
    }

    public void setDispGyoumuKey(String pDispGyoumuKey) {
        dispGyoumuKey = pDispGyoumuKey;
    }

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }

    private C_Kouteikanristatus dispkouteikanristatus;

    public C_Kouteikanristatus getDispkouteikanristatus() {
        return dispkouteikanristatus;
    }

    public void setDispkouteikanristatus(C_Kouteikanristatus pDispkouteikanristatus) {
        dispkouteikanristatus = pDispkouteikanristatus;
    }

    private String disptasknm;

    public String getDisptasknm() {
        return disptasknm;
    }

    public void setDisptasknm(String pDisptasknm) {
        disptasknm = pDisptasknm;
    }

    private String dispnowsyoritantounm;

    public String getDispnowsyoritantounm() {
        return dispnowsyoritantounm;
    }

    public void setDispnowsyoritantounm(String pDispnowsyoritantounm) {
        dispnowsyoritantounm = pDispnowsyoritantounm;
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

    private LoopChain<UserDefsList> tskidOptionBeanList = new LoopChain<>();
    public UserDefsList getTskidOptionBeanList() {
        return tskidOptionBeanList.get();
    }

    public void setTskidOptionBeanList(UserDefsList pTskidOptionBeanList) {
        clearTskidOptionBeanList();
        tskidOptionBeanList.add(pTskidOptionBeanList);
    }

    public void clearTskidOptionBeanList() {
        tskidOptionBeanList.clear();
    }
}
