package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.util.WhereBuilder;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.meta.QAT_AccessLog;

import com.google.common.base.Strings;

/**
 * アクセスログテーブル ( AT_AccessLog ) アクセス用の DAO クラスです。
 */
public class AT_AccessLogDao extends AbstractDao<AT_AccessLog> {

    public AT_AccessLogDao() {
        super(AT_AccessLog.class);
    }

    public AT_AccessLog getAT_AccessLog(String pLogId) {
        AT_AccessLog condEntity = new AT_AccessLog();
        condEntity.setLogId(pLogId);
        return selectOne(condEntity);
    }

    public List<AT_AccessLog> getAccessLogs(AT_AccessLog pCondEntity) {
        return select(pCondEntity);
    }

    public List<AT_AccessLog> getAccessLogs(
        String  subSystemId,
        String  categoryId,
        String  kinouId,
        C_KinouKbn kinouKbn,
        BizDate syoriYmdFrom, String syoriTimeFrom,
        BizDate syoriYmdTo,   String syoriTimeTo,
        String  userId,
        String  ipAddress,
        String  sessionId,
        C_AccessLogSyubetuKbn logKindCd
        ) {
        QAT_AccessLog qAccessLog = new QAT_AccessLog();
        return em.createJPQL(
            $SELECT + qAccessLog + $FROM + qAccessLog.AT_AccessLog() +
            createAccessLogSearchConditions(
                qAccessLog,
                subSystemId,
                categoryId,
                kinouId,
                kinouKbn,
                syoriYmdFrom, syoriTimeFrom,
                syoriYmdTo,   syoriTimeTo,
                userId,
                ipAddress,
                sessionId,
                logKindCd
                ) +
                $ORDER_BY(qAccessLog.timeStamp.desc(), qAccessLog.logId.desc())
            ).bind(qAccessLog).getResultList();
    }

    public long getAccessLogCount(
        String  subSystemId,
        String  categoryId,
        String  kinouId,
        C_KinouKbn kinouKbn,
        BizDate syoriYmdFrom, String syoriTimeFrom,
        BizDate syoriYmdTo,   String syoriTimeTo,
        String  userId,
        String  ipAddress,
        String  sessionId,
        C_AccessLogSyubetuKbn logKindCd
        ) {
        QAT_AccessLog qAccessLog = new QAT_AccessLog();
        return em.createJPQL(
            $SELECT + $COUNT(qAccessLog.logId) +
            $FROM   + qAccessLog.AT_AccessLog() +
            createAccessLogSearchConditions(
                qAccessLog,
                subSystemId,
                categoryId,
                kinouId,
                kinouKbn,
                syoriYmdFrom, syoriTimeFrom,
                syoriYmdTo,   syoriTimeTo,
                userId,
                ipAddress,
                sessionId,
                logKindCd
                )
            ).bind(qAccessLog).<Long>getSingleResult();
    }

    private static String createAccessLogSearchConditions(
        QAT_AccessLog log,
        String  subSystemId,
        String  categoryId,
        String  kinouId,
        C_KinouKbn kinouKbn,
        BizDate syoriYmdFrom, String syoriTimeFrom,
        BizDate syoriYmdTo,   String syoriTimeTo,
        String  userId,
        String  ipAddress,
        String  sessionId,
        C_AccessLogSyubetuKbn logKindCd
        ) {
        WhereBuilder where = new WhereBuilder();


        if (! Strings.isNullOrEmpty(subSystemId)) {
            where.set(log.subSystemId.eq(subSystemId));
        }


        if (! Strings.isNullOrEmpty(categoryId)) {
            where.and(log.categoryId.eq(categoryId));
        }



        if (! Strings.isNullOrEmpty(kinouId)) {
            where.and(log.kinouId.eq(kinouId));
        }


        if (!C_KinouKbn.BLNK.eq(kinouKbn) && kinouKbn != null){

            BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
            List<AS_Kinou> aS_Kinous = baseDomManager.getAS_KinousByC_KinouKbn(kinouKbn);

            for(int i=0; i<aS_Kinous.size(); i++){
                if(i == 0){

                    if(!Strings.isNullOrEmpty(where.toString())){
                        where.append($AND);
                    }

                    where.append("(");
                }

                where.append(log.kinouId.eq(aS_Kinous.get(i).getKinouId().toString()));

                if(aS_Kinous.size() != i+1) {
                    where.append($OR);
                }

                if(aS_Kinous.size() == i+1) {
                    where.append(")");
                }

            }
        }


        if (syoriYmdFrom != null){
            Date syoriTime = syoriYmdFrom.toDate();
            Calendar calendar = GregorianCalendar.getInstance();

            calendar.setTime(syoriTime);

            if (!Strings.isNullOrEmpty(syoriTimeFrom)) {
                calendar.set(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DATE),
                    Integer.parseInt(syoriTimeFrom.substring(0, 2)),
                    Integer.parseInt(syoriTimeFrom.substring(2, 4)),
                    00);
            }else {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DATE),
                    calendar.get(Calendar.HOUR),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND));
            }

            where.and(log.timeStamp.ge(Long.valueOf(calendar.getTimeInMillis())));
        }


        if (syoriYmdTo != null){
            Date syoriTime = syoriYmdTo.toDate();
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(syoriTime);

            if (!Strings.isNullOrEmpty(syoriTimeTo)) {
                calendar.set(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DATE),
                    Integer.parseInt(syoriTimeTo.substring(0, 2)),
                    Integer.parseInt(syoriTimeTo.substring(2, 4)),
                    00);
                calendar.add(Calendar.MINUTE, 1);
            }else {
                calendar.set(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DATE),
                    00,
                    00,
                    00);
                calendar.add(Calendar.DATE, 1);
            }
            where.and(log.timeStamp.lt(Long.valueOf(calendar.getTimeInMillis())));
        }


        if (! Strings.isNullOrEmpty(userId)) {
            where.and(log.syoriUserId.eq(userId));
        }


        if (! Strings.isNullOrEmpty(ipAddress)) {
            where.and(log.ipAddress.eq(ipAddress));
        }


        if (! Strings.isNullOrEmpty(sessionId)) {
            where.and(log.sessionId.eq(sessionId));
        }


        if (logKindCd != null && ( ! logKindCd.eq(C_AccessLogSyubetuKbn.BLNK))) {
            where.and(log.logKindCd.eq(logKindCd));
        }

        return where.toString();
    }

}