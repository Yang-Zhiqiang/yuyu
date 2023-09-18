package yuyu.common.workflowcore.api.api.impl.jbpm3;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * セッションファクトリ生成用のユーティリティです。
 */
public class SessionFactoryUtils {

    private static SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

    private SessionFactoryUtils(){}

    public static SessionFactory getSessionFactory(){
        return sessionfactory;
    }

}
