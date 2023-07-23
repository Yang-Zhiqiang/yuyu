package yuyu.infr.uniquekey;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;

import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalFunction;
import jp.co.slcs.swak.uniquekey.AbstractAppIdentifierManager;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.db.entity.AT_AppIdentifier;
import yuyu.def.db.id.PKAT_AppIdentifier;
import yuyu.def.db.meta.QAT_AppIdentifier;

@Singleton
public class YuyuAppIdentifierManager extends AbstractAppIdentifierManager {

    @Inject
    private YuyuBaseConfig yuyuBaseConfig;

    @Override
    protected void refresh(final String id, final int interval) {
        ExDBTransactional.run(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager exDBEntityManager) {
                    AT_AppIdentifier idEntity = exDBEntityManager.findByPK(new PKAT_AppIdentifier(id));
                    idEntity.setTouchTime(BizDate.getSysDateTimeMilli());
                    exDBEntityManager.flush();

                    Calendar now = BizDate.getSystemDate();
                    now.add(Calendar.MILLISECOND, interval * -1);

                    QAT_AppIdentifier i = new QAT_AppIdentifier("i");
                    String jpql = $DELETE_FROM + i.AT_AppIdentifier() +
                                        $WHERE + i.touchTime.lt(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(now.getTime()));

                    exDBEntityManager.createJPQL(jpql)
                                     .bind(i)
                                     .executeUpdate();

                    exDBEntityManager.getTransaction().commit();
                }
            }
        );
    }

    @Override
    protected String requestIdentifier() {
        return ExDBTransactional.run(
            new TransactionalFunction<String>() {
                @Override
                public String apply(ExDBEntityManager exDBEntityManager) {
                    QAT_AppIdentifier i = new QAT_AppIdentifier("i");
                    List<AT_AppIdentifier> list;
                    list = exDBEntityManager.selectJPQL(i)
                                                .orderBy(i.identifier.asc())
                                                .buildSelect()
                                                .getResultList();
                    String lastId = null;
                    Set<String> existed = new HashSet<>();
                    if (list != null && !list.isEmpty()) {
                        for (AT_AppIdentifier idEntity : list) {
                            lastId = idEntity.getIdentifier();
                            existed.add(lastId);
                            exDBEntityManager.detach(idEntity);
                        }
                    }
                    lastId = countUp(lastId);
                    while (existed.contains(lastId)) {
                        lastId = countUp(lastId);
                    }
                    while (!tryRegister(exDBEntityManager, lastId)) {
                        lastId = countUp(lastId);
                        while (existed.contains(lastId)) {
                            lastId = countUp(lastId);
                        }
                    }
                    return lastId;
                }
            }
        );
    }

    @SuppressWarnings("deprecation")
    static boolean tryRegister(ExDBEntityManager exDBEntityManager, String id) {
        try {
            AT_AppIdentifier idEntity = new AT_AppIdentifier(id);
            idEntity.setTouchTime(BizDate.getSysDateTimeMilli());
            AccessLog.pause();
            try {
                exDBEntityManager.persist(idEntity);
                exDBEntityManager.flush();
            } finally {
                AccessLog.resume();
            }
            return true;
        } catch (PersistenceException e) {
            exDBEntityManager.getTransaction().rollback();
            exDBEntityManager.getTransaction().begin();
            return false;
        }
    }

    @Override
    protected int getIdentifierLength() {
        return yuyuBaseConfig.getIdentifierLength();
    }

    @Override
    protected int getInterval() {
        return yuyuBaseConfig.getIdentifierRefreshInterval() * 60 * 60 * 1000;
    }

}
