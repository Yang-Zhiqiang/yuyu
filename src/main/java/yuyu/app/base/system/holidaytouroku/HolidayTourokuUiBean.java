package yuyu.app.base.system.holidaytouroku;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.def.classification.C_HolidayPtn;

/**
 * 休日登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class HolidayTourokuUiBean extends GenHolidayTourokuUiBean {

    private static final long serialVersionUID = 1L;

    public HolidayTourokuUiBean() {
    }

    private String holidayCd;

    public String getHolidayCd() {
        return holidayCd;
    }

    public void setHolidayCd(String holidayCd) {
        this.holidayCd = holidayCd;
    }

    private C_HolidayPtn holidayPattern;

    public C_HolidayPtn getHolidayPattern() {
        return holidayPattern;
    }

    public void setHolidayPattern(C_HolidayPtn holidayPattern) {
        this.holidayPattern = holidayPattern;
    }

    private C_HolidayPtn backHolidayPattern;

    public C_HolidayPtn getBackHolidayPattern() {
        return backHolidayPattern;
    }

    public void setBackHolidayPattern(C_HolidayPtn backHolidayPattern) {
        this.backHolidayPattern = backHolidayPattern;
    }

    private String backHolidayPatternNm;

    public String getBackHolidayPatternNm() {
        return backHolidayPatternNm;
    }

    public void setBackHolidayPatternNm(String backHolidayPatternNm) {
        this.backHolidayPatternNm = backHolidayPatternNm;
    }

}