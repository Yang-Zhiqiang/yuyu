package yuyu.app.workflow.processkanri.sinkeiyakuworklist;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約工程ワークリスト : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSinkeiyakuWorkListUiBean extends AbstractUiBean {

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

    private C_SkeijimuKbn[] skeijimukbn;

    public C_SkeijimuKbn[] getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn[] pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    private C_MosUketukeKbn[] mosuketukekbn;

    public C_MosUketukeKbn[] getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn[] pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    private List<String> disphknsyuruiworklist;

    public List<String> getDisphknsyuruiworklist() {
        return disphknsyuruiworklist;
    }

    public void setDisphknsyuruiworklist(List<String> pDisphknsyuruiworklist) {
        disphknsyuruiworklist = pDisphknsyuruiworklist;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd1;

    public String getDairitenkinyuukikancd1() {
        return dairitenkinyuukikancd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd1(String pDairitenkinyuukikancd1) {
        dairitenkinyuukikancd1 = pDairitenkinyuukikancd1;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String dairitencd1;

    public String getDairitencd1() {
        return dairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private String dispdrtennm1;

    public String getDispdrtennm1() {
        return dispdrtennm1;
    }

    public void setDispdrtennm1(String pDispdrtennm1) {
        dispdrtennm1 = pDispdrtennm1;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd2;

    public String getDairitenkinyuukikancd2() {
        return dairitenkinyuukikancd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd2(String pDairitenkinyuukikancd2) {
        dairitenkinyuukikancd2 = pDairitenkinyuukikancd2;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String dairitencd2;

    public String getDairitencd2() {
        return dairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    private String dispdrtennm2;

    public String getDispdrtennm2() {
        return dispdrtennm2;
    }

    public void setDispdrtennm2(String pDispdrtennm2) {
        dispdrtennm2 = pDispdrtennm2;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd3;

    public String getDairitenkinyuukikancd3() {
        return dairitenkinyuukikancd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd3(String pDairitenkinyuukikancd3) {
        dairitenkinyuukikancd3 = pDairitenkinyuukikancd3;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String drtencd3;

    public String getDrtencd3() {
        return drtencd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd3(String pDrtencd3) {
        drtencd3 = pDrtencd3;
    }

    private String dispdrtennm3;

    public String getDispdrtennm3() {
        return dispdrtennm3;
    }

    public void setDispdrtennm3(String pDispdrtennm3) {
        dispdrtennm3 = pDispdrtennm3;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd4;

    public String getDairitenkinyuukikancd4() {
        return dairitenkinyuukikancd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd4(String pDairitenkinyuukikancd4) {
        dairitenkinyuukikancd4 = pDairitenkinyuukikancd4;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String drtencd4;

    public String getDrtencd4() {
        return drtencd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd4(String pDrtencd4) {
        drtencd4 = pDrtencd4;
    }

    private String dispdrtennm4;

    public String getDispdrtennm4() {
        return dispdrtennm4;
    }

    public void setDispdrtennm4(String pDispdrtennm4) {
        dispdrtennm4 = pDispdrtennm4;
    }

    @Length(length=4)
    @Digit
    private String dairitenkinyuukikancd5;

    public String getDairitenkinyuukikancd5() {
        return dairitenkinyuukikancd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenkinyuukikancd5(String pDairitenkinyuukikancd5) {
        dairitenkinyuukikancd5 = pDairitenkinyuukikancd5;
    }

    @MaxLength(max=7)
    @AlphaDigit
    private String drtencd5;

    public String getDrtencd5() {
        return drtencd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd5(String pDrtencd5) {
        drtencd5 = pDrtencd5;
    }

    private String dispdrtennm5;

    public String getDispdrtennm5() {
        return dispdrtennm5;
    }

    public void setDispdrtennm5(String pDispdrtennm5) {
        dispdrtennm5 = pDispdrtennm5;
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

    private Boolean djmskmKeiyakuKbn;

    public Boolean getDjmskmKeiyakuKbn() {
        return (djmskmKeiyakuKbn == null) ? Boolean.FALSE : djmskmKeiyakuKbn;
    }

    public void setDjmskmKeiyakuKbn(Boolean pDjmskmKeiyakuKbn) {
        djmskmKeiyakuKbn = (pDjmskmKeiyakuKbn == null) ? Boolean.FALSE : pDjmskmKeiyakuKbn;
    }

    @ValidDate
    private BizDate srchmosfromymd;

    public BizDate getSrchmosfromymd() {
        return srchmosfromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchmosfromymd(BizDate pSrchmosfromymd) {
        srchmosfromymd = pSrchmosfromymd;
    }

    @ValidDate
    private BizDate srchmostoymd;

    public BizDate getSrchmostoymd() {
        return srchmostoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchmostoymd(BizDate pSrchmostoymd) {
        srchmostoymd = pSrchmostoymd;
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

    private LoopChain<UserDefsList> disphknsyuruiworklistOptionBeanList = new LoopChain<>();
    public UserDefsList getDisphknsyuruiworklistOptionBeanList() {
        return disphknsyuruiworklistOptionBeanList.get();
    }

    public void setDisphknsyuruiworklistOptionBeanList(UserDefsList pDisphknsyuruiworklistOptionBeanList) {
        disphknsyuruiworklistOptionBeanList.add(pDisphknsyuruiworklistOptionBeanList);
    }

    public void clearDisphknsyuruiworklistOptionBeanList() {
        disphknsyuruiworklistOptionBeanList.clear();
    }
}
