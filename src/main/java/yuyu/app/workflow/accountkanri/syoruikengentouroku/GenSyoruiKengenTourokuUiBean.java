package yuyu.app.workflow.accountkanri.syoruikengentouroku;

import java.util.List;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;

/**
 * 書類権限登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSyoruiKengenTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SyoruiInfoDataSourceBean> syoruiInfoDataSource = new DataSource<>();
    public DataSource<SyoruiInfoDataSourceBean> getSyoruiInfoDataSource() {
        return syoruiInfoDataSource;
    }

    @Deprecated
    public List<SyoruiInfoDataSourceBean> getSyoruiInfo() {
        return syoruiInfoDataSource.getDatas();
    }

    public void setSyoruiInfo(List<SyoruiInfoDataSourceBean> pSyoruiInfo) {
        syoruiInfoDataSource.setDatas(pSyoruiInfo);
    }

    @MaxLength(max=30)
    @AlphaDigit
    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRoleCd(String pRoleCd) {
        roleCd = pRoleCd;
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

    private String disproleSetumei;

    public String getDisproleSetumei() {
        return disproleSetumei;
    }

    public void setDisproleSetumei(String pDisproleSetumei) {
        disproleSetumei = pDisproleSetumei;
    }

    private LoopChain<UserDefsList> roleCdOptionBeanList = new LoopChain<>();
    public UserDefsList getRoleCdOptionBeanList() {
        return roleCdOptionBeanList.get();
    }

    public void setRoleCdOptionBeanList(UserDefsList pRoleCdOptionBeanList) {
        clearRoleCdOptionBeanList();
        roleCdOptionBeanList.add(pRoleCdOptionBeanList);
    }

    public void clearRoleCdOptionBeanList() {
        roleCdOptionBeanList.clear();
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
