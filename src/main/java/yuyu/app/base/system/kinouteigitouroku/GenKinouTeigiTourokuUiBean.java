package yuyu.app.base.system.kinouteigitouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_KousinNaiyouHaneiKbn;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_SubSystem;

/**
 * 機能定義登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKinouTeigiTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AS_Category category;

    public AS_Category getCategory() {
        return category;
    }

    public void setCategory(AS_Category pCategory) {
        category = pCategory;
    }

    @Inject
    private AS_Kinou kinou;

    public AS_Kinou getKinou() {
        return kinou;
    }

    public void setKinou(AS_Kinou pKinou) {
        kinou = pKinou;
    }

    @Inject
    private AS_KinouMode kinouMode;

    public AS_KinouMode getKinouMode() {
        return kinouMode;
    }

    public void setKinouMode(AS_KinouMode pKinouMode) {
        kinouMode = pKinouMode;
    }

    @Inject
    private AS_SubSystem subSystem;

    public AS_SubSystem getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(AS_SubSystem pSubSystem) {
        subSystem = pSubSystem;
    }

    private DataSource<KengenSetteiListDataSourceBean> kengenSetteiListDataSource = new DataSource<>();
    public DataSource<KengenSetteiListDataSourceBean> getKengenSetteiListDataSource() {
        return kengenSetteiListDataSource;
    }

    @Deprecated
    public List<KengenSetteiListDataSourceBean> getKengenSetteiList() {
        return kengenSetteiListDataSource.getDatas();
    }

    public void setKengenSetteiList(List<KengenSetteiListDataSourceBean> pKengenSetteiList) {
        kengenSetteiListDataSource.setDatas(pKengenSetteiList);
    }

    private DataSource<KinouModeInfoListDataSourceBean> kinouModeInfoListDataSource = new DataSource<>();
    public DataSource<KinouModeInfoListDataSourceBean> getKinouModeInfoListDataSource() {
        return kinouModeInfoListDataSource;
    }

    @Deprecated
    public List<KinouModeInfoListDataSourceBean> getKinouModeInfoList() {
        return kinouModeInfoListDataSource.getDatas();
    }

    public void setKinouModeInfoList(List<KinouModeInfoListDataSourceBean> pKinouModeInfoList) {
        kinouModeInfoListDataSource.setDatas(pKinouModeInfoList);
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

    private C_KousinNaiyouHaneiKbn kousinNaiyouHaneiKbn;

    public C_KousinNaiyouHaneiKbn getKousinNaiyouHaneiKbn() {
        return kousinNaiyouHaneiKbn;
    }

    public void setKousinNaiyouHaneiKbn(C_KousinNaiyouHaneiKbn pKousinNaiyouHaneiKbn) {
        kousinNaiyouHaneiKbn = pKousinNaiyouHaneiKbn;
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

    private LoopChain<UserDefsList> kadouTimeGroupCdOptionBeanList = new LoopChain<>();
    public UserDefsList getKadouTimeGroupCdOptionBeanList() {
        return kadouTimeGroupCdOptionBeanList.get();
    }

    public void setKadouTimeGroupCdOptionBeanList(UserDefsList pKadouTimeGroupCdOptionBeanList) {
        clearKadouTimeGroupCdOptionBeanList();
        kadouTimeGroupCdOptionBeanList.add(pKadouTimeGroupCdOptionBeanList);
    }

    public void clearKadouTimeGroupCdOptionBeanList() {
        kadouTimeGroupCdOptionBeanList.clear();
    }
}
