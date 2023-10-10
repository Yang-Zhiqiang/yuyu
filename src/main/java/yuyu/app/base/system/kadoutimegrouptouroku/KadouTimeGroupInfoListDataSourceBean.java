package yuyu.app.base.system.kadoutimegrouptouroku;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;

/**
 * 稼働時間グループ登録 - kadouTimeGroupInfoList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KadouTimeGroupInfoListDataSourceBean extends GenKadouTimeGroupInfoListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public KadouTimeGroupInfoListDataSourceBean() {
    }

    @MaxLength(max = 20)
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

}
