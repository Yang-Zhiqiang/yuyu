package yuyu.infr.inject;

import javax.persistence.EntityTransaction;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.hibernate.inject.HibernateModule;

import org.aopalliance.intercept.MethodInterceptor;

import yuyu.common.workflowcore.api.api.IWorkflowContext;

import com.google.inject.persist.jpa.JpaLocalTxnInterceptor;
import com.google.inject.persist.jpa.JpaPersistModule;

public class IwfJpaModule extends HibernateModule {

    @Override
    protected void configure() {
        if (persistenceUnitName != null) {
            install(new IwfJpaPersistModule(persistenceUnitName));
        }
    }

    public static class IwfJpaPersistModule extends JpaPersistModule {

        private MethodInterceptor transactionInterceptor;

        public IwfJpaPersistModule(String jpaUnit) {
            super(jpaUnit);
        }

        @Override
        protected void configurePersistence() {
            super.configurePersistence();

            transactionInterceptor = new IwfJpaLocalTxnInterceptor();
            requestInjection(transactionInterceptor);
        }

        @Override
        protected MethodInterceptor getTransactionInterceptor() {
            return transactionInterceptor;
        }

    }

    public static class IwfJpaLocalTxnInterceptor extends JpaLocalTxnInterceptor {

        @Override
        @SuppressWarnings("deprecation")
        protected void commitTransaction(EntityTransaction txn) {
            super.commitTransaction(txn);
            SWAKInjector.getInstance(IWorkflowContext.class).commitAndClose();
        }

        @Override
        @SuppressWarnings("deprecation")
        protected void rollbackTransaction(EntityTransaction txn) {
            super.rollbackTransaction(txn);
            SWAKInjector.getInstance(IWorkflowContext.class).rollbackAndClose();
        }
    }
}
