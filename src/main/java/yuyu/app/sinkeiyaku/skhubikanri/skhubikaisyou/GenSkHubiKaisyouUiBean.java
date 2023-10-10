package yuyu.app.sinkeiyaku.skhubikanri.skhubikaisyou;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約不備解消 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkHubiKaisyouUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<ItiranInfoDataSourceBean> itiranInfoDataSource = new DataSource<>();
    public DataSource<ItiranInfoDataSourceBean> getItiranInfoDataSource() {
        return itiranInfoDataSource;
    }

    @Deprecated
    public List<ItiranInfoDataSourceBean> getItiranInfo() {
        return itiranInfoDataSource.getDatas();
    }

    public void setItiranInfo(List<ItiranInfoDataSourceBean> pItiranInfo) {
        itiranInfoDataSource.setDatas(pItiranInfo);
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

    private DataSource<HubiListDataSourceBean> hubiListDataSource = new DataSource<>();
    public DataSource<HubiListDataSourceBean> getHubiListDataSource() {
        return hubiListDataSource;
    }

    @Deprecated
    public List<HubiListDataSourceBean> getHubiList() {
        return hubiListDataSource.getDatas();
    }

    public void setHubiList(List<HubiListDataSourceBean> pHubiList) {
        hubiListDataSource.setDatas(pHubiList);
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

    private String currenttsknm;

    public String getCurrenttsknm() {
        return currenttsknm;
    }

    public void setCurrenttsknm(String pCurrenttsknm) {
        currenttsknm = pCurrenttsknm;
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

    private String commentarea;

    public String getCommentarea() {
        return commentarea;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setCommentarea(String pCommentarea) {
        commentarea = pCommentarea;
    }

    private C_SyorikekkaKbn mostenkenkekkakbn;

    public C_SyorikekkaKbn getMostenkenkekkakbn() {
        return mostenkenkekkakbn;
    }

    public void setMostenkenkekkakbn(C_SyorikekkaKbn pMostenkenkekkakbn) {
        mostenkenkekkakbn = pMostenkenkekkakbn;
    }

    private String mostenkentnsketsyacd;

    public String getMostenkentnsketsyacd() {
        return mostenkentnsketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMostenkentnsketsyacd(String pMostenkentnsketsyacd) {
        mostenkentnsketsyacd = pMostenkentnsketsyacd;
    }

    private String mostentnsketsyanm;

    public String getMostentnsketsyanm() {
        return mostentnsketsyanm;
    }

    public void setMostentnsketsyanm(String pMostentnsketsyanm) {
        mostentnsketsyanm = pMostentnsketsyanm;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String mostenkencommentgamen;

    public String getMostenkencommentgamen() {
        return mostenkencommentgamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setMostenkencommentgamen(String pMostenkencommentgamen) {
        mostenkencommentgamen = pMostenkencommentgamen;
    }

    private C_SyorikekkaKbn knksateisateikekka;

    public C_SyorikekkaKbn getKnksateisateikekka() {
        return knksateisateikekka;
    }

    public void setKnksateisateikekka(C_SyorikekkaKbn pKnksateisateikekka) {
        knksateisateikekka = pKnksateisateikekka;
    }

    private String knktnsketsyacd;

    public String getKnktnsketsyacd() {
        return knktnsketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKnktnsketsyacd(String pKnktnsketsyacd) {
        knktnsketsyacd = pKnktnsketsyacd;
    }

    private String knktnsketsyanm;

    public String getKnktnsketsyanm() {
        return knktnsketsyanm;
    }

    public void setKnktnsketsyanm(String pKnktnsketsyanm) {
        knktnsketsyanm = pKnktnsketsyanm;
    }

    @ValidTextArea(length=40, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String knksateicommentgamen;

    public String getKnksateicommentgamen() {
        return knksateicommentgamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKnksateicommentgamen(String pKnksateicommentgamen) {
        knksateicommentgamen = pKnksateicommentgamen;
    }

    private C_SyorikekkaKbn imusateisateikekka;

    public C_SyorikekkaKbn getImusateisateikekka() {
        return imusateisateikekka;
    }

    public void setImusateisateikekka(C_SyorikekkaKbn pImusateisateikekka) {
        imusateisateikekka = pImusateisateikekka;
    }

    private String imutnsketsyacd;

    public String getImutnsketsyacd() {
        return imutnsketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setImutnsketsyacd(String pImutnsketsyacd) {
        imutnsketsyacd = pImutnsketsyacd;
    }

    private String imutnsketsyanm;

    public String getImutnsketsyanm() {
        return imutnsketsyanm;
    }

    public void setImutnsketsyanm(String pImutnsketsyanm) {
        imutnsketsyanm = pImutnsketsyanm;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String imusateicommentgamen;

    public String getImusateicommentgamen() {
        return imusateicommentgamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setImusateicommentgamen(String pImusateicommentgamen) {
        imusateicommentgamen = pImusateicommentgamen;
    }

    private LoopChain<UserDefsList> mostenkentnsketsyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getMostenkentnsketsyacdOptionBeanList() {
        return mostenkentnsketsyacdOptionBeanList.get();
    }

    public void setMostenkentnsketsyacdOptionBeanList(UserDefsList pMostenkentnsketsyacdOptionBeanList) {
        clearMostenkentnsketsyacdOptionBeanList();
        mostenkentnsketsyacdOptionBeanList.add(pMostenkentnsketsyacdOptionBeanList);
    }

    public void clearMostenkentnsketsyacdOptionBeanList() {
        mostenkentnsketsyacdOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> knktnsketsyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getKnktnsketsyacdOptionBeanList() {
        return knktnsketsyacdOptionBeanList.get();
    }

    public void setKnktnsketsyacdOptionBeanList(UserDefsList pKnktnsketsyacdOptionBeanList) {
        clearKnktnsketsyacdOptionBeanList();
        knktnsketsyacdOptionBeanList.add(pKnktnsketsyacdOptionBeanList);
    }

    public void clearKnktnsketsyacdOptionBeanList() {
        knktnsketsyacdOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> imutnsketsyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getImutnsketsyacdOptionBeanList() {
        return imutnsketsyacdOptionBeanList.get();
    }

    public void setImutnsketsyacdOptionBeanList(UserDefsList pImutnsketsyacdOptionBeanList) {
        clearImutnsketsyacdOptionBeanList();
        imutnsketsyacdOptionBeanList.add(pImutnsketsyacdOptionBeanList);
    }

    public void clearImutnsketsyacdOptionBeanList() {
        imutnsketsyacdOptionBeanList.clear();
    }
}
