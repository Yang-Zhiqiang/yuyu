package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.def.db.meta.QAT_HolidayYoyaku;

import com.google.common.base.Strings;

/**
 * 休日予約テーブル( AT_holidayYoyaku ) に対するDB操作を提供する。
 */
public class AT_HolidayYoyakuDao extends AbstractDao<AT_HolidayYoyaku> {

    protected AT_HolidayYoyakuDao() {
        super(AT_HolidayYoyaku.class);
    }

    public AT_HolidayYoyaku getAT_HolidayYoyaku(String pHolidayGroupCd, String pHolidayCd) {
        AT_HolidayYoyaku condEntity = new AT_HolidayYoyaku();
        condEntity.setHolidayGroupCd(pHolidayGroupCd);
        condEntity.setHolidayCd(pHolidayCd);
        return selectOne(condEntity);
    }

    public List<AT_HolidayYoyaku> getHolidayYoyakusByHolidayGroupCd(String pHolidayGroupCd) {

        AT_HolidayYoyaku condEntity = new AT_HolidayYoyaku();
        condEntity.setHolidayGroupCd(pHolidayGroupCd);
        List<AT_HolidayYoyaku> holidayYoyakus = super.select(condEntity);

        if(!holidayYoyakus.isEmpty()){
            Collections.sort(holidayYoyakus, new HolidayYoyakuCompByPatternNmTekiyouYmdPatternNm());
        }
        return holidayYoyakus;
    }


    public long getCountHolidayYoyakuByHolidayPattern(String pHolidayPatternParam) {

        QAT_HolidayYoyaku qHolidayYoyaku = new QAT_HolidayYoyaku();
        return em.createJPQL(
            $SELECT + $COUNT(qHolidayYoyaku.holidayGroupCd) +
            $FROM   + qHolidayYoyaku.AT_HolidayYoyaku() +
            $WHERE  + qHolidayYoyaku.holidayPatternParam.eq(pHolidayPatternParam)
            ).bind(qHolidayYoyaku).<Long>getSingleResult();
    }

    class HolidayYoyakuCompByPatternNmTekiyouYmdPatternNm implements Comparator<AT_HolidayYoyaku> {
        @Override
        public int compare(AT_HolidayYoyaku holidayYoyaku1, AT_HolidayYoyaku holidayYoyaku2) {

            int compare = 0;

            if (null == holidayYoyaku1.getHolidayPattern() || null == holidayYoyaku2.getHolidayPattern()) {
                if (null == holidayYoyaku1.getHolidayPattern() && null == holidayYoyaku2.getHolidayPattern()) {
                    compare = 0;
                } else if (null  == holidayYoyaku1.getHolidayPattern()) {
                    compare = 1;
                } else if (null == holidayYoyaku2.getHolidayPattern()) {
                    compare = -1;
                }
            } else {
                compare = holidayYoyaku1.getHolidayPattern().compareTo(holidayYoyaku2.getHolidayPattern());
            }
            if (compare != 0) {
                return compare;
            }


            if (null == holidayYoyaku1.getTekiyouYmdTo() || null == holidayYoyaku2.getTekiyouYmdTo()) {
                if (null == holidayYoyaku1.getTekiyouYmdTo() && null == holidayYoyaku2.getTekiyouYmdTo()) {
                    compare = 0;
                } else if (null  == holidayYoyaku1.getTekiyouYmdTo()) {
                    compare = 1;
                } else if (null == holidayYoyaku2.getTekiyouYmdTo()) {
                    compare = -1;
                }
            } else {
                compare = holidayYoyaku1.getTekiyouYmdTo().compareTo(holidayYoyaku2.getTekiyouYmdTo());
            }
            if (compare != 0) {
                return compare;
            }


            if (null == holidayYoyaku1.getTekiyouYmdFrom() || null == holidayYoyaku2.getTekiyouYmdFrom()) {
                if (null == holidayYoyaku1.getTekiyouYmdFrom() && null == holidayYoyaku2.getTekiyouYmdFrom()) {
                    compare = 0;
                } else if (null  == holidayYoyaku1.getTekiyouYmdFrom()) {
                    compare = -1;
                } else if (null == holidayYoyaku2.getTekiyouYmdFrom()) {
                    compare = 1;
                }
            } else {
                compare = holidayYoyaku1.getTekiyouYmdFrom().compareTo(holidayYoyaku2.getTekiyouYmdFrom());
            }
            if (compare != 0) {
                return compare;
            }


            if (Strings.isNullOrEmpty(holidayYoyaku1.getHolidayPatternNm()) || Strings.isNullOrEmpty(holidayYoyaku2.getHolidayPatternNm())) {
                if (Strings.isNullOrEmpty(holidayYoyaku1.getHolidayPatternNm()) || Strings.isNullOrEmpty(holidayYoyaku2.getHolidayPatternNm())) {
                    compare = 0;
                } else if (Strings.isNullOrEmpty(holidayYoyaku1.getHolidayPatternNm())) {
                    compare = 1;
                } else if (Strings.isNullOrEmpty(holidayYoyaku2.getHolidayPatternNm())) {
                    compare = -1;
                }
            } else {
                compare = holidayYoyaku1.getHolidayPatternNm().compareTo(holidayYoyaku2.getHolidayPatternNm());
            }
            return compare;
        }
    }
}
