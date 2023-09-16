package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import yuyu.def.db.id.PKAT_HolidayGroup;
import yuyu.def.db.mapping.GenAT_HolidayGroup;
import yuyu.def.db.meta.GenQAT_HolidayGroup;
import yuyu.def.db.meta.QAT_HolidayGroup;

import com.google.common.collect.Lists;

/**
 * 休日グループテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_HolidayGroup} の JavaDoc を参照してください。
 * @see     GenAT_HolidayGroup
 * @see     PKAT_HolidayGroup
 * @see     QAT_HolidayGroup
 * @see     GenQAT_HolidayGroup
 */
@Entity
public class AT_HolidayGroup extends GenAT_HolidayGroup {

    private static final long serialVersionUID = 1L;

    public AT_HolidayGroup() {
    }

    public AT_HolidayGroup(String pHolidayGroupCd) {
        super(pHolidayGroupCd);
    }

    private List<AT_Holiday> aT_Holidays = Lists.newLinkedList();

    public AT_Holiday createHoliday() {
        AT_Holiday aT_Holiday = new AT_Holiday();
        aT_Holiday.setHolidayGroupCd(this.getHolidayGroupCd());
        aT_Holiday.setHolidayGroup(this);
        getHolidays().add(aT_Holiday);
        return aT_Holiday;
    }

    @OneToMany(
        fetch         = FetchType.LAZY,
        cascade       = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumn(name=AT_Holiday.HOLIDAYGROUPCD, referencedColumnName=AT_HolidayGroup.HOLIDAYGROUPCD, insertable=false, updatable=false)
    public List<AT_Holiday> getHolidays() {
        return aT_Holidays;
    }

    public void setHolidays(List<AT_Holiday> pHolidays) {
        aT_Holidays = pHolidays;
    }

    public AT_Holiday getHoliday(String pHolidayCd) {
        for (AT_Holiday holiday : getHolidays()) {
            if (holiday.getHolidayCd().equals(pHolidayCd)) {
                return holiday;
            }
        }
        return null;
    }

    private List<AT_HolidayYoyaku> aT_HolidayYoyakus = Lists.newLinkedList();

    public AT_HolidayYoyaku createHolidayYoyaku() {
        AT_HolidayYoyaku aT_HolidayYoyaku = new AT_HolidayYoyaku();
        aT_HolidayYoyaku.setHolidayGroupCd(this.getHolidayGroupCd());
        aT_HolidayYoyaku.setHolidayGroup(this);
        getHolidayYoyakus().add(aT_HolidayYoyaku);
        return aT_HolidayYoyaku;
    }

    @OneToMany(
        fetch         = FetchType.LAZY,
        cascade       = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumn(name=AT_HolidayYoyaku.HOLIDAYGROUPCD, referencedColumnName=AT_HolidayGroup.HOLIDAYGROUPCD, insertable=false, updatable=false)
    public List<AT_HolidayYoyaku> getHolidayYoyakus() {
        return aT_HolidayYoyakus;
    }

    public void setHolidayYoyakus(List<AT_HolidayYoyaku> pHolidayYoyakus) {
        aT_HolidayYoyakus = pHolidayYoyakus;
    }

    public AT_HolidayYoyaku getHolidayYoyaku(String holidayCd) {
        for (AT_HolidayYoyaku holidayYoyaku : getHolidayYoyakus()) {
            if (holidayYoyaku.getHolidayCd().equals(holidayCd)) {
                return holidayYoyaku;
            }
        }
        return null;
    }

}
