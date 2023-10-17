package yuyu.app.hozen.khhubikanri.khhubitouroku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全不備登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhHubiTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SyoruiInfoListDataSourceBean> syoruiInfoListDataSource = new DataSource<>();
    public DataSource<SyoruiInfoListDataSourceBean> getSyoruiInfoListDataSource() {
        return syoruiInfoListDataSource;
    }

    @Deprecated
    public List<SyoruiInfoListDataSourceBean> getSyoruiInfoList() {
        return syoruiInfoListDataSource.getDatas();
    }

    public void setSyoruiInfoList(List<SyoruiInfoListDataSourceBean> pSyoruiInfoList) {
        syoruiInfoListDataSource.setDatas(pSyoruiInfoList);
    }

    private DataSource<ProgresshistoryinfoDataSourceBean> progresshistoryinfoDataSource = new DataSource<>();
    public DataSource<ProgresshistoryinfoDataSourceBean> getProgresshistoryinfoDataSource() {
        return progresshistoryinfoDataSource;
    }

    @Deprecated
    public List<ProgresshistoryinfoDataSourceBean> getProgresshistoryinfo() {
        return progresshistoryinfoDataSource.getDatas();
    }

    public void setProgresshistoryinfo(List<ProgresshistoryinfoDataSourceBean> pProgresshistoryinfo) {
        progresshistoryinfoDataSource.setDatas(pProgresshistoryinfo);
    }

    private DataSource<SelectDataListDataSourceBean> selectDataListDataSource = new DataSource<>();
    public DataSource<SelectDataListDataSourceBean> getSelectDataListDataSource() {
        return selectDataListDataSource;
    }

    @Deprecated
    public List<SelectDataListDataSourceBean> getSelectDataList() {
        return selectDataListDataSource.getDatas();
    }

    public void setSelectDataList(List<SelectDataListDataSourceBean> pSelectDataList) {
        selectDataListDataSource.setDatas(pSelectDataList);
    }

    private DataSource<HashinzumiHubiListDataSourceBean> hashinzumiHubiListDataSource = new DataSource<>();
    public DataSource<HashinzumiHubiListDataSourceBean> getHashinzumiHubiListDataSource() {
        return hashinzumiHubiListDataSource;
    }

    @Deprecated
    public List<HashinzumiHubiListDataSourceBean> getHashinzumiHubiList() {
        return hashinzumiHubiListDataSource.getDatas();
    }

    public void setHashinzumiHubiList(List<HashinzumiHubiListDataSourceBean> pHashinzumiHubiList) {
        hashinzumiHubiListDataSource.setDatas(pHashinzumiHubiList);
    }

    private DataSource<HubiList2DataSourceBean> hubiList2DataSource = new DataSource<>();
    public DataSource<HubiList2DataSourceBean> getHubiList2DataSource() {
        return hubiList2DataSource;
    }

    @Deprecated
    public List<HubiList2DataSourceBean> getHubiList2() {
        return hubiList2DataSource.getDatas();
    }

    public void setHubiList2(List<HubiList2DataSourceBean> pHubiList2) {
        hubiList2DataSource.setDatas(pHubiList2);
    }

    private String vktifdispjimutetuzukinm;

    public String getVktifdispjimutetuzukinm() {
        return vktifdispjimutetuzukinm;
    }

    public void setVktifdispjimutetuzukinm(String pVktifdispjimutetuzukinm) {
        vktifdispjimutetuzukinm = pVktifdispjimutetuzukinm;
    }

    private String vktifdisptasknm;

    public String getVktifdisptasknm() {
        return vktifdisptasknm;
    }

    public void setVktifdisptasknm(String pVktifdisptasknm) {
        vktifdisptasknm = pVktifdisptasknm;
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

    private String allhyoujibtn;

    public String getAllhyoujibtn() {
        return allhyoujibtn;
    }

    public void setAllhyoujibtn(String pAllhyoujibtn) {
        allhyoujibtn = pAllhyoujibtn;
    }

    private String imageid;

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String pImageid) {
        imageid = pImageid;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String renrakusakinmkj;

    public String getRenrakusakinmkj() {
        return renrakusakinmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakusakinmkj(String pRenrakusakinmkj) {
        renrakusakinmkj = pRenrakusakinmkj;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String renrakuyno;

    public String getRenrakuyno() {
        return renrakuyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRenrakuyno(String pRenrakuyno) {
        renrakuyno = pRenrakuyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String renrakusakiadr1kj;

    public String getRenrakusakiadr1kj() {
        return renrakusakiadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakusakiadr1kj(String pRenrakusakiadr1kj) {
        renrakusakiadr1kj = pRenrakusakiadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String renrakusakiadr2kj;

    public String getRenrakusakiadr2kj() {
        return renrakusakiadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakusakiadr2kj(String pRenrakusakiadr2kj) {
        renrakusakiadr2kj = pRenrakusakiadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String renrakusakiadr3kj;

    public String getRenrakusakiadr3kj() {
        return renrakusakiadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakusakiadr3kj(String pRenrakusakiadr3kj) {
        renrakusakiadr3kj = pRenrakusakiadr3kj;
    }

    @MaxLength(max=14)
    @SingleByteStrings
    private String renrakusakitelno;

    public String getRenrakusakitelno() {
        return renrakusakitelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRenrakusakitelno(String pRenrakusakitelno) {
        renrakusakitelno = pRenrakusakitelno;
    }

    @ValidTextArea(length=40, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String renrakuarea;

    public String getRenrakuarea() {
        return renrakuarea;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setRenrakuarea(String pRenrakuarea) {
        renrakuarea = pRenrakuarea;
    }

    @ValidDate
    private BizDate hubianswerkjt;

    public BizDate getHubianswerkjt() {
        return hubianswerkjt;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubianswerkjt(BizDate pHubianswerkjt) {
        hubianswerkjt = pHubianswerkjt;
    }

    private C_SyorikekkaKbn syorikekkakbn;

    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }

    private String tennousakisousasyacd;

    public String getTennousakisousasyacd() {
        return tennousakisousasyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTennousakisousasyacd(String pTennousakisousasyacd) {
        tennousakisousasyacd = pTennousakisousasyacd;
    }

    @ValidTextArea(length=40, rows=5)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String syanaicommentkh;

    public String getSyanaicommentkh() {
        return syanaicommentkh;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyanaicommentkh(String pSyanaicommentkh) {
        syanaicommentkh = pSyanaicommentkh;
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

    private LoopChain<UserDefsList> tennousakisousasyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getTennousakisousasyacdOptionBeanList() {
        return tennousakisousasyacdOptionBeanList.get();
    }

    public void setTennousakisousasyacdOptionBeanList(UserDefsList pTennousakisousasyacdOptionBeanList) {
        clearTennousakisousasyacdOptionBeanList();
        tennousakisousasyacdOptionBeanList.add(pTennousakisousasyacdOptionBeanList);
    }

    public void clearTennousakisousasyacdOptionBeanList() {
        tennousakisousasyacdOptionBeanList.clear();
    }
}
