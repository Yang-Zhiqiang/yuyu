package yuyu.infrext.mq;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import org.slf4j.Logger;

import yuyu.def.db.entity.AT_MqInfo;

/**
 * ＭＱ情報テーブル( AT_MqInfo ) に対してNaviteQueryを用いたDB操作を提供する。
 */
public class MqControlSignalReceiveDao extends AbstractDao<AT_MqInfo> {

    @Inject
    private static Logger logger;

    public MqControlSignalReceiveDao() {
        super(AT_MqInfo.class);
    }


    public String getMqOnlineStatus(String pServerType){

        String selectQuery = "select mqonlinestatus "
            + "from AT_MqInfo where serverType = " +"'" + pServerType + "' "
            + "with RS use and keep exclusive locks";

        logger.debug("SQL selectQuery = " + selectQuery);

        String mqOnlineStatus = null;

        try{

            mqOnlineStatus = em.createNativeSQL(selectQuery).<String>getSingleResult();

        }catch(Exception e){

            logger.debug("テーブルがロックされており30秒でタイムアウト発生（正常終了）");

            return "error";
        }


        logger.debug("mqOnlineStatus = " + mqOnlineStatus);

        return mqOnlineStatus;

    }

    public String getRkmAtesaki(String pServerType){


        String selectQuery = "select rkmAtesaki "
            + "from AT_MqInfo where serverType = " +"'" + pServerType + "' "
            + "with RS use and keep exclusive locks";

        logger.debug("SQL selectQuery = " + selectQuery);

        String rkmAtesaki = em.createNativeSQL(selectQuery).<String>getSingleResult();

        logger.debug("rkmAtesaki = " + rkmAtesaki);

        return rkmAtesaki;

    }

    public void updateMqOnlineStatus(String pServerType, String pUpdateStatus){

        String updateQuery = "update AT_MqInfo " +
            "SET mqonlinestatus = " + "'" + pUpdateStatus + "'" +
            " WHERE serverType = " +"'" + pServerType + "'";

        logger.debug("SQL updateQuery = " + updateQuery);

        em.createNativeSQL(updateQuery).executeUpdate();
    }

    @Deprecated
    public void commitMqOnlineStatus(){

        String commitQuery = "commit";
        logger.debug("SQL commitQuery = " + commitQuery);
        em.createNativeSQL(commitQuery).executeUpdate();

    }

    @Deprecated
    public void rollbackMqOnlineStatus(){

        String commitQuery = "rollback";
        logger.debug("SQL commitQuery = " + commitQuery);
        em.createNativeSQL(commitQuery).executeUpdate();

    }
}
