package yuyu.app.base.system.holidaytouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateMd;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_YoubiKbn;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_HolidayYoyaku;

/**
 * 休日登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenHolidayTourokuUiBean extends AbstractUiBean {

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
    private AT_HolidayYoyaku holidayYoyaku;

    public AT_HolidayYoyaku getHolidayYoyaku() {
        return holidayYoyaku;
    }

    public void setHolidayYoyaku(AT_HolidayYoyaku pHolidayYoyaku) {
        holidayYoyaku = pHolidayYoyaku;
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

    private DataSource<HolidayPatternInfoDataSourceBean> holidayPatternInfoDataSource = new DataSource<>();
    public DataSource<HolidayPatternInfoDataSourceBean> getHolidayPatternInfoDataSource() {
        return holidayPatternInfoDataSource;
    }

    @Deprecated
    public List<HolidayPatternInfoDataSourceBean> getHolidayPatternInfo() {
        return holidayPatternInfoDataSource.getDatas();
    }

    public void setHolidayPatternInfo(List<HolidayPatternInfoDataSourceBean> pHolidayPatternInfo) {
        holidayPatternInfoDataSource.setDatas(pHolidayPatternInfo, 10);
    }

    @MaxLength(max=20)
    @AlphaDigit
    private String holidayGroupCd;

    public String getHolidayGroupCd() {
        return holidayGroupCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayGroupCd(String pHolidayGroupCd) {
        holidayGroupCd = pHolidayGroupCd;
    }

    @ValidDate
    private BizDate holidayYmd;

    public BizDate getHolidayYmd() {
        return holidayYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayYmd(BizDate pHolidayYmd) {
        holidayYmd = pHolidayYmd;
    }

    @ValidDateMd
    private BizDateMD holidayMd;

    public BizDateMD getHolidayMd() {
        return holidayMd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayMd(BizDateMD pHolidayMd) {
        holidayMd = pHolidayMd;
    }

    @Range(min="1", max="12")
    private Integer holidayM;

    public Integer getHolidayM() {
        return holidayM;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayM(Integer pHolidayM) {
        holidayM = pHolidayM;
    }

    @Range(min="1", max="5")
    private Integer holidayNth;

    public Integer getHolidayNth() {
        return holidayNth;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayNth(Integer pHolidayNth) {
        holidayNth = pHolidayNth;
    }

    private C_YoubiKbn holidaySiteiYoubi;

    public C_YoubiKbn getHolidaySiteiYoubi() {
        return holidaySiteiYoubi;
    }

    public void setHolidaySiteiYoubi(C_YoubiKbn pHolidaySiteiYoubi) {
        holidaySiteiYoubi = pHolidaySiteiYoubi;
    }

    private C_YoubiKbn holidayYoubi;

    public C_YoubiKbn getHolidayYoubi() {
        return holidayYoubi;
    }

    public void setHolidayYoubi(C_YoubiKbn pHolidayYoubi) {
        holidayYoubi = pHolidayYoubi;
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
