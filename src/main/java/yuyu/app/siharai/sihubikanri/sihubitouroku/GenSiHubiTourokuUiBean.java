package yuyu.app.siharai.sihubikanri.sihubitouroku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
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
 * 保険金給付金不備登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiHubiTourokuUiBean extends AbstractUiBean {

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

    private DataSource<HasinzumihubiListDataSourceBean> hasinzumihubiListDataSource = new DataSource<>();
    public DataSource<HasinzumihubiListDataSourceBean> getHasinzumihubiListDataSource() {
        return hasinzumihubiListDataSource;
    }

    @Deprecated
    public List<HasinzumihubiListDataSourceBean> getHasinzumihubiList() {
        return hasinzumihubiListDataSource.getDatas();
    }

    public void setHasinzumihubiList(List<HasinzumihubiListDataSourceBean> pHasinzumihubiList) {
        hasinzumihubiListDataSource.setDatas(pHasinzumihubiList);
    }

    private DataSource<MihasinhubiListDataSourceBean> mihasinhubiListDataSource = new DataSource<>();
    public DataSource<MihasinhubiListDataSourceBean> getMihasinhubiListDataSource() {
        return mihasinhubiListDataSource;
    }

    @Deprecated
    public List<MihasinhubiListDataSourceBean> getMihasinhubiList() {
        return mihasinhubiListDataSource.getDatas();
    }

    public void setMihasinhubiList(List<MihasinhubiListDataSourceBean> pMihasinhubiList) {
        mihasinhubiListDataSource.setDatas(pMihasinhubiList);
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

    private String skno;

    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
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

    private String kouteilockkey;

    public String getKouteilockkey() {
        return kouteilockkey;
    }

    public void setKouteilockkey(String pKouteilockkey) {
        kouteilockkey = pKouteilockkey;
    }

    @Length(length=3)
    @SingleByteStrings
    private String sisyacd;

    public String getSisyacd() {
        return sisyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSisyacd(String pSisyacd) {
        sisyacd = pSisyacd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String sisyanm;

    public String getSisyanm() {
        return sisyanm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSisyanm(String pSisyanm) {
        sisyanm = pSisyanm;
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
    private String tsinyno;

    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr1kj;

    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr2kj;

    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String tsinadr3kj;

    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
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

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String toiawasesosikinmkj;

    public String getToiawasesosikinmkj() {
        return toiawasesosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setToiawasesosikinmkj(String pToiawasesosikinmkj) {
        toiawasesosikinmkj = pToiawasesosikinmkj;
    }

    @AlphaDigitOrExceptionCode(except=("-()"))
    @MaxLength(max=14)
    private String toiawasetelno;

    public String getToiawasetelno() {
        return toiawasetelno;
    }

    @DataConvert("toSingleByte")
    public void setToiawasetelno(String pToiawasetelno) {
        toiawasetelno = pToiawasetelno;
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

    @MaxLength(max=1500)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String syanaicomment;

    public String getSyanaicomment() {
        return syanaicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyanaicomment(String pSyanaicomment) {
        syanaicomment = pSyanaicomment;
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

    private String nyuuryokutantounm;

    public String getNyuuryokutantounm() {
        return nyuuryokutantounm;
    }

    public void setNyuuryokutantounm(String pNyuuryokutantounm) {
        nyuuryokutantounm = pNyuuryokutantounm;
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
