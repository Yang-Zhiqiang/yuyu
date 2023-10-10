package yuyu.app.biz.bztyouhyou.bztyouhyoukobetu;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;

/**
 * 帳票個別出力 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzTyouhyouKobetuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<KensakuKekkaItiranListDataSourceBean> kensakuKekkaItiranListDataSource = new DataSource<>();
    public DataSource<KensakuKekkaItiranListDataSourceBean> getKensakuKekkaItiranListDataSource() {
        return kensakuKekkaItiranListDataSource;
    }

    @Deprecated
    public List<KensakuKekkaItiranListDataSourceBean> getKensakuKekkaItiranList() {
        return kensakuKekkaItiranListDataSource.getDatas();
    }

    public void setKensakuKekkaItiranList(List<KensakuKekkaItiranListDataSourceBean> pKensakuKekkaItiranList) {
        kensakuKekkaItiranListDataSource.setDatas(pKensakuKekkaItiranList, 10);
    }

    private String srchsubsystemid;

    public String getSrchsubsystemid() {
        return srchsubsystemid;
    }

    public void setSrchsubsystemid(String pSrchsubsystemid) {
        srchsubsystemid = pSrchsubsystemid;
    }

    private String srchsyoruicd;

    public String getSrchsyoruicd() {
        return srchsyoruicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsyoruicd(String pSrchsyoruicd) {
        srchsyoruicd = pSrchsyoruicd;
    }

    @ValidDate
    private BizDate tyouhyouymdfrom;

    public BizDate getTyouhyouymdfrom() {
        return tyouhyouymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymdfrom(BizDate pTyouhyouymdfrom) {
        tyouhyouymdfrom = pTyouhyouymdfrom;
    }

    @ValidDate
    private BizDate tyouhyouymdto;

    public BizDate getTyouhyouymdto() {
        return tyouhyouymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymdto(BizDate pTyouhyouymdto) {
        tyouhyouymdto = pTyouhyouymdto;
    }

    private String knskkmkid1;

    public String getKnskkmkid1() {
        return knskkmkid1;
    }

    @Trim("both")
    public void setKnskkmkid1(String pKnskkmkid1) {
        knskkmkid1 = pKnskkmkid1;
    }

    private String knskkmkid2;

    public String getKnskkmkid2() {
        return knskkmkid2;
    }

    @Trim("both")
    public void setKnskkmkid2(String pKnskkmkid2) {
        knskkmkid2 = pKnskkmkid2;
    }

    private String knskkmkid3;

    public String getKnskkmkid3() {
        return knskkmkid3;
    }

    @Trim("both")
    public void setKnskkmkid3(String pKnskkmkid3) {
        knskkmkid3 = pKnskkmkid3;
    }

    private String knskkmkid4;

    public String getKnskkmkid4() {
        return knskkmkid4;
    }

    @Trim("both")
    public void setKnskkmkid4(String pKnskkmkid4) {
        knskkmkid4 = pKnskkmkid4;
    }

    private String knskkmkid5;

    public String getKnskkmkid5() {
        return knskkmkid5;
    }

    @Trim("both")
    public void setKnskkmkid5(String pKnskkmkid5) {
        knskkmkid5 = pKnskkmkid5;
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
    }

    private LoopChain<UserDefsList> srchsubsystemidOptionBeanList = new LoopChain<>();
    public UserDefsList getSrchsubsystemidOptionBeanList() {
        return srchsubsystemidOptionBeanList.get();
    }

    public void setSrchsubsystemidOptionBeanList(UserDefsList pSrchsubsystemidOptionBeanList) {
        clearSrchsubsystemidOptionBeanList();
        srchsubsystemidOptionBeanList.add(pSrchsubsystemidOptionBeanList);
    }

    public void clearSrchsubsystemidOptionBeanList() {
        srchsubsystemidOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> srchsyoruicdOptionBeanList = new LoopChain<>();
    public UserDefsList getSrchsyoruicdOptionBeanList() {
        return srchsyoruicdOptionBeanList.get();
    }

    public void setSrchsyoruicdOptionBeanList(UserDefsList pSrchsyoruicdOptionBeanList) {
        clearSrchsyoruicdOptionBeanList();
        srchsyoruicdOptionBeanList.add(pSrchsyoruicdOptionBeanList);
    }

    public void clearSrchsyoruicdOptionBeanList() {
        srchsyoruicdOptionBeanList.clear();
    }
}
