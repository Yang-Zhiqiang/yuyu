package yuyu.infr.date;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.reader.AbstractHolidayInfoReader;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_LegalHolidayKbn;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.entity.AT_HolidayGroup;

/**
 * {@link BizDate} 用の 休日情報 DB Reader です。<br />
 * {@link AT_HolidayGroup} テーブルと {@link AT_Holiday} テーブルの休日データを読み込み、
 * {@link BizDate} の休日情報として登録します。<br />
 */
public class HolidayInfoDbReader extends AbstractHolidayInfoReader {

    @Inject
    private BaseDomManager domManager;

    @Override
    public void read() {
        List<AT_HolidayGroup> holidayGroups = domManager.getAllHolidayGroups();
        for (AT_HolidayGroup group : holidayGroups) {
            addGroup(group.getHolidayGroupCd(), group.getHolidayGroupNm(), group.getHolidayGroupDescription());
        }

        for (AT_HolidayGroup group : holidayGroups) {
            for (AT_Holiday holiday : group.getHolidays()) {
                try {
                    addPattern(
                        holiday.getHolidayGroupCd(),
                        holiday.getLegalHolidayKbn().eq(C_LegalHolidayKbn.LEGAL_HOLIDAY),
                        holiday.getTekiyouYmdFrom(),
                        holiday.getTekiyouYmdTo(),
                        holiday.getHolidayPattern().getValue(),
                        holiday.getHolidayPatternParam(),
                        holiday.getHolidayPatternNm(),
                        holiday.getHolidayPatternDescription()
                    );
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
