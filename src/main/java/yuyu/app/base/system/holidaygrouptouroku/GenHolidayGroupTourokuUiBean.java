package yuyu.app.base.system.holidaygrouptouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.db.entity.AT_HolidayGroup;

/**
 * 休日グループ登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenHolidayGroupTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AT_HolidayGroup holidayGroup;

    public AT_HolidayGroup getHolidayGroup() {
        return holidayGroup;
    }

    public void setHolidayGroup(AT_HolidayGroup pHolidayGroup) {
        holidayGroup = pHolidayGroup;
    }

    private DataSource<HolidayGroupInfoListDataSourceBean> holidayGroupInfoListDataSource = new DataSource<>();
    public DataSource<HolidayGroupInfoListDataSourceBean> getHolidayGroupInfoListDataSource() {
        return holidayGroupInfoListDataSource;
    }

    @Deprecated
    public List<HolidayGroupInfoListDataSourceBean> getHolidayGroupInfoList() {
        return holidayGroupInfoListDataSource.getDatas();
    }

    public void setHolidayGroupInfoList(List<HolidayGroupInfoListDataSourceBean> pHolidayGroupInfoList) {
        holidayGroupInfoListDataSource.setDatas(pHolidayGroupInfoList);
    }
}
