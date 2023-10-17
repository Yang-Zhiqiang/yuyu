package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_HbtyhyoutKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約不備登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkHubiTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

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

    private DataSource<ToriatukaiTyuuiInfoDataSourceBean> toriatukaiTyuuiInfoDataSource = new DataSource<>();
    public DataSource<ToriatukaiTyuuiInfoDataSourceBean> getToriatukaiTyuuiInfoDataSource() {
        return toriatukaiTyuuiInfoDataSource;
    }

    @Deprecated
    public List<ToriatukaiTyuuiInfoDataSourceBean> getToriatukaiTyuuiInfo() {
        return toriatukaiTyuuiInfoDataSource.getDatas();
    }

    public void setToriatukaiTyuuiInfo(List<ToriatukaiTyuuiInfoDataSourceBean> pToriatukaiTyuuiInfo) {
        toriatukaiTyuuiInfoDataSource.setDatas(pToriatukaiTyuuiInfo);
    }

    private DataSource<HubiList1DataSourceBean> hubiList1DataSource = new DataSource<>();
    public DataSource<HubiList1DataSourceBean> getHubiList1DataSource() {
        return hubiList1DataSource;
    }

    @Deprecated
    public List<HubiList1DataSourceBean> getHubiList1() {
        return hubiList1DataSource.getDatas();
    }

    public void setHubiList1(List<HubiList1DataSourceBean> pHubiList1) {
        hubiList1DataSource.setDatas(pHubiList1);
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

    private String dummykmk1;

    public String getDummykmk1() {
        return dummykmk1;
    }

    public void setDummykmk1(String pDummykmk1) {
        dummykmk1 = pDummykmk1;
    }

    private String dummykmk2;

    public String getDummykmk2() {
        return dummykmk2;
    }

    public void setDummykmk2(String pDummykmk2) {
        dummykmk2 = pDummykmk2;
    }

    private String dummykmk3;

    public String getDummykmk3() {
        return dummykmk3;
    }

    public void setDummykmk3(String pDummykmk3) {
        dummykmk3 = pDummykmk3;
    }

    private String dummykmk4;

    public String getDummykmk4() {
        return dummykmk4;
    }

    public void setDummykmk4(String pDummykmk4) {
        dummykmk4 = pDummykmk4;
    }

    private String dummykmk5;

    public String getDummykmk5() {
        return dummykmk5;
    }

    public void setDummykmk5(String pDummykmk5) {
        dummykmk5 = pDummykmk5;
    }

    private String uniqueid2;

    public String getUniqueid2() {
        return uniqueid2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueid2(String pUniqueid2) {
        uniqueid2 = pUniqueid2;
    }

    private String hubitourokumode;

    public String getHubitourokumode() {
        return hubitourokumode;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubitourokumode(String pHubitourokumode) {
        hubitourokumode = pHubitourokumode;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String utdskknnm1kj;

    public String getUtdskknnm1kj() {
        return utdskknnm1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm1kj(String pUtdskknnm1kj) {
        utdskknnm1kj = pUtdskknnm1kj;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String utdskknnm2kj;

    public String getUtdskknnm2kj() {
        return utdskknnm2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm2kj(String pUtdskknnm2kj) {
        utdskknnm2kj = pUtdskknnm2kj;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String tuutisakitantounmkj;

    public String getTuutisakitantounmkj() {
        return tuutisakitantounmkj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTuutisakitantounmkj(String pTuutisakitantounmkj) {
        tuutisakitantounmkj = pTuutisakitantounmkj;
    }

    @ValidTextArea(length=60, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String commentareagamen;

    public String getCommentareagamen() {
        return commentareagamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setCommentareagamen(String pCommentareagamen) {
        commentareagamen = pCommentareagamen;
    }

    private C_HbtyhyoutKbn hbtyhyoutkbn;

    public C_HbtyhyoutKbn getHbtyhyoutkbn() {
        return hbtyhyoutkbn;
    }

    public void setHbtyhyoutkbn(C_HbtyhyoutKbn pHbtyhyoutkbn) {
        hbtyhyoutkbn = pHbtyhyoutkbn;
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
}
