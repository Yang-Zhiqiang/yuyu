package yuyu.infrext;

import java.sql.Connection;
import java.sql.SQLClientInfoException;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.slf4j.Logger;

import yuyu.def.db.entity.AS_Kinou;

/**
 * DB2専用のプロパティ設定ユーティリティです。
 */
public class RayUtil {

    private static Logger logger = LoggerFactory.getLogger(RayUtil.class);

    private RayUtil(){
    }

    @SuppressWarnings("resource")
    public static void setupDBConnectionLogInfo(){
        ExDBEntityManager e = SWAKInjector.getInstance(ExDBEntityManager.class);
        @SuppressWarnings("deprecation")
        Connection c = e.getJDBCConnection();

        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        try{
            c.setClientInfo("ApplicationName", kinou.getSyoricd() == null ? "unknown function" : kinou.getSyoricd());
            logger.debug("クライアント情報設定処理：成功");
        }catch(SQLClientInfoException e1){
            logger.debug("クライアント情報設定処理：失敗");
            logger.warn(e1.getMessage(), e1);
        }catch(Throwable t){
            logger.debug("クライアント情報設定処理：失敗");
            logger.warn("コネクションへのクライアント情報設定処理はこの環境では使用できません。", t);
        }
    }

    @SuppressWarnings("resource")
    public static void clearDBConnectionLogInfo(){
        ExDBEntityManager e = SWAKInjector.getInstance(ExDBEntityManager.class);
        @SuppressWarnings("deprecation")
        Connection c = e.getJDBCConnection();
        try{
            c.setClientInfo("ApplicationName",null);
            logger.debug("クライアント情報クリア処理：成功");
        }catch(SQLClientInfoException e1){
            logger.debug("クライアント情報クリア処理：失敗");
            logger.warn(e1.getMessage(), e1);
        }catch(Throwable t){
            logger.debug("クライアント情報クリア処理：失敗");
            logger.warn("コネクションへのクライアント情報設定処理はこの環境では使用できません。", t);
        }
    }

}
