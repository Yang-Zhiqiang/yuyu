package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import yuyu.def.db.id.PKAT_Holiday;
import yuyu.def.db.mapping.GenAT_Holiday;
import yuyu.def.db.meta.GenQAT_Holiday;
import yuyu.def.db.meta.QAT_Holiday;

/**
 * 休日テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_Holiday} の JavaDoc を参照してください。
 * @see     GenAT_Holiday
 * @see     PKAT_Holiday
 * @see     QAT_Holiday
 * @see     GenQAT_Holiday
 */
@Entity
public class AT_Holiday extends GenAT_Holiday {

    private static final long serialVersionUID = 1L;

    public AT_Holiday() {
    }

    public AT_Holiday(String pHolidayGroupCd, String pHolidayCd) {
        super(pHolidayGroupCd, pHolidayCd);
    }

    private AT_HolidayGroup aT_HolidayGroup;

    @ManyToOne
    @JoinColumn(name=AT_Holiday.HOLIDAYGROUPCD, referencedColumnName=AT_HolidayGroup.HOLIDAYGROUPCD, insertable=false, updatable=false)
    public AT_HolidayGroup getHolidayGroup() {
        return aT_HolidayGroup;
    }

    void setHolidayGroup(AT_HolidayGroup pHolidayGroup) {
        aT_HolidayGroup = pHolidayGroup;
    }

}
