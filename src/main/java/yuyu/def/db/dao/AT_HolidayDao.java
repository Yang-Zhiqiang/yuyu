package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.def.db.meta.QAT_Holiday;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 休日テーブル( AT_Holiday ) に対するDB操作を提供する。
 */
public class AT_HolidayDao extends AbstractDao<AT_Holiday> {

    @Inject
    private AT_HolidayYoyakuDao aT_HolidayYoyakuDao;

    protected AT_HolidayDao() {
        super(AT_Holiday.class);
    }

    public AT_Holiday getAT_Holiday(String pHolidayGroupCd, String pHolidayCd) {
        AT_Holiday condEntity = new AT_Holiday();
        condEntity.setHolidayGroupCd(pHolidayGroupCd);
        condEntity.setHolidayCd(pHolidayCd);
        return selectOne(condEntity);
    }

    public List<AT_Holiday> getHolidaysByHolidayGroupCd(String pHolidayGroupCd) {
        AT_Holiday condEntity = new AT_Holiday();
        condEntity.setHolidayGroupCd(pHolidayGroupCd);
        return select(condEntity);
    }

    public List<AT_Holiday> getHolidaysByHolidayGroupCdNotExistsYoyaku(String pHolidayGroupCd) {


        List<AT_Holiday> holidays = getHolidaysByHolidayGroupCd(pHolidayGroupCd);

        if(!holidays.isEmpty()){
            Collections.sort(holidays, new HolidayCompByPatternNmTekiyouYmdPatternNm());
        }


        List<AT_HolidayYoyaku> holidayYoyakus = aT_HolidayYoyakuDao.getHolidayYoyakusByHolidayGroupCd(pHolidayGroupCd);


        List<AT_Holiday> filteredHolidays = ImmutableList.copyOf(Iterables.filter(holidays, new HolidayYoyakuPredicate(holidayYoyakus)));

        return filteredHolidays;
    }

    public long getCountHolidayByHolidayPattern(String pHolidayPatternParam) {

        QAT_Holiday qHoliday = new QAT_Holiday();
        return em.createJPQL(
            $SELECT + $COUNT(qHoliday.holidayGroupCd) +
            $FROM   + qHoliday.AT_Holiday() +
            $WHERE  + qHoliday.holidayPatternParam.eq(pHolidayPatternParam)
            ).bind(qHoliday).<Long>getSingleResult();
    }

    class HolidayCompByPatternNmTekiyouYmdPatternNm implements Comparator<AT_Holiday> {
        @Override
        public int compare(AT_Holiday holiday1, AT_Holiday holiday2) {
            int compare = 0;

            if (null == holiday1.getHolidayPattern() || null == holiday2.getHolidayPattern()) {
                if (null == holiday1.getHolidayPattern() && null == holiday2.getHolidayPattern()) {
                    compare = 0;
                } else if (null  == holiday1.getHolidayPattern()) {
                    compare = 1;
                } else if (null == holiday2.getHolidayPattern()) {
                    compare = -1;
                }
            } else {
                compare = holiday1.getHolidayPattern().getValue().compareTo(holiday2.getHolidayPattern().getValue());
            }
            if (compare != 0) {
                return compare;
            }


            if (null == holiday1.getTekiyouYmdTo() || null == holiday2.getTekiyouYmdTo()) {
                if (null == holiday1.getTekiyouYmdTo() && null == holiday2.getTekiyouYmdTo()) {
                    compare = 0;
                } else if (null  == holiday1.getTekiyouYmdTo()) {
                    compare = 1;
                } else if (null == holiday2.getTekiyouYmdTo()) {
                    compare = -1;
                }
            } else {
                compare = holiday1.getTekiyouYmdTo().compareTo(holiday2.getTekiyouYmdTo());
            }
            if (compare != 0) {
                return compare;
            }


            if (null == holiday1.getTekiyouYmdFrom() || null == holiday2.getTekiyouYmdFrom()) {
                if (null == holiday1.getTekiyouYmdFrom() && null == holiday2.getTekiyouYmdFrom()) {
                    compare = 0;
                } else if (null  == holiday1.getTekiyouYmdFrom()) {
                    compare = -1;
                } else if (null == holiday2.getTekiyouYmdFrom()) {
                    compare = 1;
                }
            } else {
                compare = holiday1.getTekiyouYmdFrom().compareTo(holiday2.getTekiyouYmdFrom());
            }
            if (compare != 0) {
                return compare;
            }


            if (Strings.isNullOrEmpty(holiday1.getHolidayPatternNm()) || Strings.isNullOrEmpty(holiday2.getHolidayPatternNm())) {
                if (Strings.isNullOrEmpty(holiday1.getHolidayPatternNm()) || Strings.isNullOrEmpty(holiday2.getHolidayPatternNm())) {
                    compare = 0;
                } else if (Strings.isNullOrEmpty(holiday1.getHolidayPatternNm())) {
                    compare = 1;
                } else if (Strings.isNullOrEmpty(holiday2.getHolidayPatternNm())) {
                    compare = -1;
                }
            } else {
                compare = holiday1.getHolidayPatternNm().compareTo(holiday2.getHolidayPatternNm());
            }
            return compare;
        }
    }

    class HolidayYoyakuPredicate implements Predicate<AT_Holiday> {

        List<AT_HolidayYoyaku> holidayYoyakus;

        HolidayYoyakuPredicate(List<AT_HolidayYoyaku> pHolidayYoyakus){
            super();
            holidayYoyakus = pHolidayYoyakus;
        }

        @Override
        public boolean apply(AT_Holiday holiday) {


            for(AT_HolidayYoyaku yoyaku:holidayYoyakus){
                if(holiday.getHolidayGroupCd().equals(yoyaku.getHolidayGroupCd()) &&
                    holiday.getHolidayCd().equals(yoyaku.getHolidayCd())){
                    return false;
                }
            }
            return true;
        }
    }

}
