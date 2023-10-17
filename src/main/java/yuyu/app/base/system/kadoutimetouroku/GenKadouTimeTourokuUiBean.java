package yuyu.app.base.system.kadoutimetouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.entity.AT_KadouTimeGroup;

/**
 * 稼働時間登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKadouTimeTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AT_HolidayGroup holidayGroup;

    public AT_HolidayGroup getHolidayGroup() {
        return holidayGroup;
    }

    public void setHolidayGroup(AT_HolidayGroup pHolidayGroup) {
        holidayGroup = pHolidayGroup;
    }

    @Inject
    private AT_KadouTime kadouTime;

    public AT_KadouTime getKadouTime() {
        return kadouTime;
    }

    public void setKadouTime(AT_KadouTime pKadouTime) {
        kadouTime = pKadouTime;
    }

    @Inject
    private AT_KadouTimeGroup kadouTimeGroup;

    public AT_KadouTimeGroup getKadouTimeGroup() {
        return kadouTimeGroup;
    }

    public void setKadouTimeGroup(AT_KadouTimeGroup pKadouTimeGroup) {
        kadouTimeGroup = pKadouTimeGroup;
    }

    private DataSource<KeyInfoDataSourceBean> keyInfoDataSource = new DataSource<>();
    public DataSource<KeyInfoDataSourceBean> getKeyInfoDataSource() {
        return keyInfoDataSource;
    }

    @Deprecated
    public List<KeyInfoDataSourceBean> getKeyInfo() {
        return keyInfoDataSource.getDatas();
    }

    public void setKeyInfo(List<KeyInfoDataSourceBean> pKeyInfo) {
        keyInfoDataSource.setDatas(pKeyInfo);
    }

    private DataSource<EigyoubiKadouTimeInfoDataSourceBean> eigyoubiKadouTimeInfoDataSource = new DataSource<>();
    public DataSource<EigyoubiKadouTimeInfoDataSourceBean> getEigyoubiKadouTimeInfoDataSource() {
        return eigyoubiKadouTimeInfoDataSource;
    }

    @Deprecated
    public List<EigyoubiKadouTimeInfoDataSourceBean> getEigyoubiKadouTimeInfo() {
        return eigyoubiKadouTimeInfoDataSource.getDatas();
    }

    public void setEigyoubiKadouTimeInfo(List<EigyoubiKadouTimeInfoDataSourceBean> pEigyoubiKadouTimeInfo) {
        eigyoubiKadouTimeInfoDataSource.setDatas(pEigyoubiKadouTimeInfo);
    }

    private DataSource<HiEigyoubiKadouTimeInfoDataSourceBean> hiEigyoubiKadouTimeInfoDataSource = new DataSource<>();
    public DataSource<HiEigyoubiKadouTimeInfoDataSourceBean> getHiEigyoubiKadouTimeInfoDataSource() {
        return hiEigyoubiKadouTimeInfoDataSource;
    }

    @Deprecated
    public List<HiEigyoubiKadouTimeInfoDataSourceBean> getHiEigyoubiKadouTimeInfo() {
        return hiEigyoubiKadouTimeInfoDataSource.getDatas();
    }

    public void setHiEigyoubiKadouTimeInfo(List<HiEigyoubiKadouTimeInfoDataSourceBean> pHiEigyoubiKadouTimeInfo) {
        hiEigyoubiKadouTimeInfoDataSource.setDatas(pHiEigyoubiKadouTimeInfo);
    }

    private String hyoujunKadouTimeInfo;

    public String getHyoujunKadouTimeInfo() {
        return hyoujunKadouTimeInfo;
    }

    @Trim("both")
    public void setHyoujunKadouTimeInfo(String pHyoujunKadouTimeInfo) {
        hyoujunKadouTimeInfo = pHyoujunKadouTimeInfo;
    }
}
