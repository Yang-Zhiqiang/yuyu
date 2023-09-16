package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_HolidayYoyaku;
import yuyu.def.db.mapping.GenAT_HolidayYoyaku;
import yuyu.def.db.meta.GenQAT_HolidayYoyaku;
import yuyu.def.db.meta.QAT_HolidayYoyaku;

/**
 * 休日予約テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_HolidayYoyaku} の JavaDoc を参照してください。
 * @see     GenAT_HolidayYoyaku
 * @see     PKAT_HolidayYoyaku
 * @see     QAT_HolidayYoyaku
 * @see     GenQAT_HolidayYoyaku
 */
@Entity
public class AT_HolidayYoyaku extends GenAT_HolidayYoyaku {

    private static final long serialVersionUID = 1L;

    public AT_HolidayYoyaku() {
    }

    public AT_HolidayYoyaku(String pHolidayGroupCd, String pHolidayCd) {
        super(pHolidayGroupCd, pHolidayCd);
    }

    private AT_HolidayGroup aT_HolidayGroup;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_HolidayYoyaku.HOLIDAYGROUPCD, referencedColumnName=AT_HolidayGroup.HOLIDAYGROUPCD, insertable=false, updatable=false)
    public AT_HolidayGroup getHolidayGroup() {
        return aT_HolidayGroup;
    }

    void setHolidayGroup(AT_HolidayGroup pHolidayGroup) {
        aT_HolidayGroup = pHolidayGroup;
    }

}
