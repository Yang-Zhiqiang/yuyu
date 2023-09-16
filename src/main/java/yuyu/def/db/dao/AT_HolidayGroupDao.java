package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.Comparator;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.meta.QAT_HolidayGroup;
import yuyu.def.db.meta.QAT_KadouTimeGroup;

import com.google.common.base.Strings;

/**
 * 休日グループテーブル( AT_HolidayGroup ) に対するDB操作を提供する。
 */
public class AT_HolidayGroupDao extends AbstractDao<AT_HolidayGroup> {

    protected AT_HolidayGroupDao() {
        super(AT_HolidayGroup.class);
    }

    public AT_HolidayGroup getAT_HolidayGroup(String pHolidayGroupCd) {
        AT_HolidayGroup condEntity = new AT_HolidayGroup();
        condEntity.setHolidayGroupCd(pHolidayGroupCd);
        return selectOne(condEntity);
    }

    public long getKadouTimeGroupByCountHolidayGroupCd(String pHolidayGroupCd) {

        QAT_KadouTimeGroup qKadouTimeGroup = new QAT_KadouTimeGroup();

        return  em.createJPQL(
            $SELECT + $COUNT(qKadouTimeGroup.kadouTimeGroupCd) +
            $FROM   + qKadouTimeGroup.AT_KadouTimeGroup() +
            $WHERE  + qKadouTimeGroup.holidayGroupCd.eq(pHolidayGroupCd)
            ).bind(qKadouTimeGroup).<Long>getSingleResult();
    }

    public List<AT_HolidayGroup> getHolidayGroup4Gyoumu() {

        QAT_HolidayGroup qHolidayGroup = new QAT_HolidayGroup();
        return em.createJPQL(
            $SELECT + qHolidayGroup +
            $FROM   + qHolidayGroup.AT_HolidayGroup() +
            $WHERE  + qHolidayGroup.sysSiyouKbn.ne(C_SysSiyouKbn.SYSSIYOU) +
            $ORDER_BY(qHolidayGroup.holidayGroupCd)
            ).bind(qHolidayGroup).getResultList();
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
}
