package yuyu.app.hozen.khhubikanri.khhubikaisyou;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全不備解消 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhHubiKaisyouUiBean extends AbstractUiBean {

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

    private DataSource<KaisyouzumihubiListDataSourceBean> kaisyouzumihubiListDataSource = new DataSource<>();
    public DataSource<KaisyouzumihubiListDataSourceBean> getKaisyouzumihubiListDataSource() {
        return kaisyouzumihubiListDataSource;
    }

    @Deprecated
    public List<KaisyouzumihubiListDataSourceBean> getKaisyouzumihubiList() {
        return kaisyouzumihubiListDataSource.getDatas();
    }

    public void setKaisyouzumihubiList(List<KaisyouzumihubiListDataSourceBean> pKaisyouzumihubiList) {
        kaisyouzumihubiListDataSource.setDatas(pKaisyouzumihubiList);
    }

    private DataSource<MikaisyouhubiListDataSourceBean> mikaisyouhubiListDataSource = new DataSource<>();
    public DataSource<MikaisyouhubiListDataSourceBean> getMikaisyouhubiListDataSource() {
        return mikaisyouhubiListDataSource;
    }

    @Deprecated
    public List<MikaisyouhubiListDataSourceBean> getMikaisyouhubiList() {
        return mikaisyouhubiListDataSource.getDatas();
    }

    public void setMikaisyouhubiList(List<MikaisyouhubiListDataSourceBean> pMikaisyouhubiList) {
        mikaisyouhubiListDataSource.setDatas(pMikaisyouhubiList);
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

    private C_SyorikekkaKbn syorikekkakbn;

    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
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
}
