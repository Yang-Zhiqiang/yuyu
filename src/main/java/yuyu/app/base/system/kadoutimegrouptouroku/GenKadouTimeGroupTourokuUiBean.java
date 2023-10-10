package yuyu.app.base.system.kadoutimegrouptouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.db.entity.AT_KadouTimeGroup;

/**
 * 稼働時間グループ登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKadouTimeGroupTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AT_KadouTimeGroup kadouTimeGroup;

    public AT_KadouTimeGroup getKadouTimeGroup() {
        return kadouTimeGroup;
    }

    public void setKadouTimeGroup(AT_KadouTimeGroup pKadouTimeGroup) {
        kadouTimeGroup = pKadouTimeGroup;
    }

    private DataSource<KadouTimeGroupInfoListDataSourceBean> kadouTimeGroupInfoListDataSource = new DataSource<>();
    public DataSource<KadouTimeGroupInfoListDataSourceBean> getKadouTimeGroupInfoListDataSource() {
        return kadouTimeGroupInfoListDataSource;
    }

    @Deprecated
    public List<KadouTimeGroupInfoListDataSourceBean> getKadouTimeGroupInfoList() {
        return kadouTimeGroupInfoListDataSource.getDatas();
    }

    public void setKadouTimeGroupInfoList(List<KadouTimeGroupInfoListDataSourceBean> pKadouTimeGroupInfoList) {
        kadouTimeGroupInfoListDataSource.setDatas(pKadouTimeGroupInfoList);
    }

    @MaxLength(max=20)
    @AlphaDigit
    private String kadouTimeGroupCd;

    public String getKadouTimeGroupCd() {
        return kadouTimeGroupCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeGroupCd(String pKadouTimeGroupCd) {
        kadouTimeGroupCd = pKadouTimeGroupCd;
    }

    private LoopChain<UserDefsList> holidayGroupCdOptionBeanList = new LoopChain<>();
    public UserDefsList getHolidayGroupCdOptionBeanList() {
        return holidayGroupCdOptionBeanList.get();
    }

    public void setHolidayGroupCdOptionBeanList(UserDefsList pHolidayGroupCdOptionBeanList) {
        clearHolidayGroupCdOptionBeanList();
        holidayGroupCdOptionBeanList.add(pHolidayGroupCdOptionBeanList);
    }

    public void clearHolidayGroupCdOptionBeanList() {
        holidayGroupCdOptionBeanList.clear();
    }
}
