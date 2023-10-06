package yuyu.app.workflow.imagekanri.imagetorikomi;

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
import yuyu.infr.validation.constraints.NenkinSyousyoNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * イメージ取込 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenImageTorikomiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<AnkenListDataSourceBean> ankenListDataSource = new DataSource<>();
    public DataSource<AnkenListDataSourceBean> getAnkenListDataSource() {
        return ankenListDataSource;
    }

    @Deprecated
    public List<AnkenListDataSourceBean> getAnkenList() {
        return ankenListDataSource.getDatas();
    }

    public void setAnkenList(List<AnkenListDataSourceBean> pAnkenList) {
        ankenListDataSource.setDatas(pAnkenList, 10);
    }

    private DataSource<AnkenList2DataSourceBean> ankenList2DataSource = new DataSource<>();
    public DataSource<AnkenList2DataSourceBean> getAnkenList2DataSource() {
        return ankenList2DataSource;
    }

    @Deprecated
    public List<AnkenList2DataSourceBean> getAnkenList2() {
        return ankenList2DataSource.getDatas();
    }

    public void setAnkenList2(List<AnkenList2DataSourceBean> pAnkenList2) {
        ankenList2DataSource.setDatas(pAnkenList2);
    }

    private DataSource<SyoruiInfo01DataSourceBean> syoruiInfo01DataSource = new DataSource<>();
    public DataSource<SyoruiInfo01DataSourceBean> getSyoruiInfo01DataSource() {
        return syoruiInfo01DataSource;
    }

    @Deprecated
    public List<SyoruiInfo01DataSourceBean> getSyoruiInfo01() {
        return syoruiInfo01DataSource.getDatas();
    }

    public void setSyoruiInfo01(List<SyoruiInfo01DataSourceBean> pSyoruiInfo01) {
        syoruiInfo01DataSource.setDatas(pSyoruiInfo01);
    }

    private DataSource<SyoruiInfo02DataSourceBean> syoruiInfo02DataSource = new DataSource<>();
    public DataSource<SyoruiInfo02DataSourceBean> getSyoruiInfo02DataSource() {
        return syoruiInfo02DataSource;
    }

    @Deprecated
    public List<SyoruiInfo02DataSourceBean> getSyoruiInfo02() {
        return syoruiInfo02DataSource.getDatas();
    }

    public void setSyoruiInfo02(List<SyoruiInfo02DataSourceBean> pSyoruiInfo02) {
        syoruiInfo02DataSource.setDatas(pSyoruiInfo02);
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

    private Integer selectindex;

    public Integer getSelectindex() {
        return selectindex;
    }

    public void setSelectindex(Integer pSelectindex) {
        selectindex = pSelectindex;
    }

    private String tyouhyouSyuturyokuLink;

    public String getTyouhyouSyuturyokuLink() {
        return tyouhyouSyuturyokuLink;
    }

    public void setTyouhyouSyuturyokuLink(String pTyouhyouSyuturyokuLink) {
        tyouhyouSyuturyokuLink = pTyouhyouSyuturyokuLink;
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
