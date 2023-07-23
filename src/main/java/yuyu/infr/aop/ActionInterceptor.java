package yuyu.infr.aop;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.persistence.OptimisticLockException;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.aop.TraceInterceptor;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.util.comparator.PropertyNameComparator;
import jp.co.slcs.swak.util.string.StringUtil;
import jp.co.slcs.swak.web.config.annotations.UIBean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.LazyInitializationException;
import org.slf4j.Logger;

import yuyu.def.db.mapping.AbstractExDBEntity;
import yuyu.infr.inject.RequestUriProvider;
import yuyu.infrext.RayDB2Util;
import yuyu.infrext.RayUtil;
import yuyu.infrext.exception.RayDB2DeadLockException;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * 業務アクションクラスのイベントハンドラメソッド実行前後に処理を追加する Interceptor です。<br />
 * 生保基盤では、イベントハンドラメソッド実行前に Entity を初期化（必要に応じて EntityManager に merge）します。
 */
@Singleton
public class ActionInterceptor implements MethodInterceptor {

    public static final ActionInterceptor instance = new ActionInterceptor();

    private static final Logger logger = LoggerFactory.getLogger(ActionInterceptor.class);

    private ActionInterceptor() {
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Object invoke(MethodInvocation pInvocation) throws Throwable {

        RayUtil.setupDBConnectionLogInfo();

        String requestURI = SWAKInjector.getInstance(String.class, RequestUriProvider.BIND_NAME);

        Object  result  = null;
        boolean cancel = false;
        try {
            UIBean uiBeanAnnotation = pInvocation.getMethod().getDeclaringClass().getAnnotation(UIBean.class);
            Class<? extends Serializable> uiBeanClass = uiBeanAnnotation.beanClass();
            final Serializable uiBean = SWAKInjector.getInstance(uiBeanClass);
            Prop2EntityTransformer transformer = new Prop2EntityTransformer(uiBean);

            final Map<String, Collection<AbstractExDBEntity>> allListEntityMap = new HashMap<>();

            Collection<PropertyDescriptor> entityProps = Collections2.filter(
                    Lists.newArrayList(
                            PropertyUtils.getPropertyDescriptors(uiBeanClass)
                            ),
                            new Predicate<PropertyDescriptor>() {
                        @Override
                        public boolean apply(PropertyDescriptor pProp) {
                            if (null == pProp.getPropertyType()) {
                                return false;
                            }

                            if (Collection.class.isAssignableFrom(pProp.getPropertyType())) {
                                try {
                                    Collection<?> coll = (Collection<?>) PropertyUtils
                                            .getProperty(uiBean, pProp.getName());
                                    if (coll != null) {
                                        for(Object entity : coll){
                                            if (entity == null)
                                                continue;
                                            if (entity instanceof AbstractExDBEntity) {
                                                allListEntityMap.put(pProp.getName(),
                                                        (Collection<AbstractExDBEntity>) coll);
                                                break;
                                            }
                                        }
                                    }
                                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                                    throw new BizAppException(e, "イベントハンドラメソッド実行前に Entity を初期化する時、エラーになります。");
                                }
                            }
                            return
                                    AbstractExDBEntity.class.isAssignableFrom(pProp.getPropertyType()) &&
                                    PropertyUtils.isReadable (uiBean, pProp.getName()) &&
                                    PropertyUtils.isWriteable(uiBean, pProp.getName());
                        }
                    }
                    );

            final Map<PropertyDescriptor, AbstractExDBEntity<?, ?>> entitiesMap = new HashMap<>(entityProps.size());
            for (PropertyDescriptor prop : entityProps) {
                entitiesMap.put(prop, transformer.apply(prop));
            }

            if (logger.isTraceEnabled()) {
                if (entitiesMap.size() == 0) {
                    logger.trace("◇ no entities in {}", uiBean);
                } else {
                    logger.trace("▽ member entities in {}", uiBean);
                    TraceInterceptor.incrementNestingLevel();
                    try {
                        if (logger.isTraceEnabled()) {
                            int maxLength = StringUtil.maxLength(
                                    Collections2.transform(
                                            entityProps,
                                            new Function<PropertyDescriptor, String>() {
                                                @Override
                                                public String apply(PropertyDescriptor pProp) {
                                                    return pProp.getPropertyType().getSimpleName();
                                                }
                                            }
                                            )
                                    );
                            List<PropertyDescriptor> keys = Lists.newArrayList(entitiesMap.keySet());
                            Collections.sort(keys, PropertyNameComparator.instance);
                            for (PropertyDescriptor key : keys) {
                                AbstractExDBEntity<?, ?> entity = entitiesMap.get(key);
                                logger.trace("{} = {}", Strings.padEnd(key.getPropertyType().getSimpleName(), maxLength, ' '), entity);
                                if (entity != null) {
                                    logger.trace("└ loaded={}, removed={}", Boolean.valueOf(entity.isLoaded()), Boolean.valueOf(entity.isRemoved()));
                                }
                            }
                        }
                    } finally {
                        TraceInterceptor.decrementNestingLevel();
                        logger.trace("△");
                    }
                }
            }

            for (PropertyDescriptor prop : entitiesMap.keySet()) {
                AbstractExDBEntity entity = entitiesMap.get(prop);
                if ((entity != null) && entity.isLoaded() && (! entity.isRemoved())) {
                    ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
                    if(em.getEntityManager().find(entity.getClass(), entity.getPrimaryKey()) == null){
                        throw new OptimisticLockException("The entity was deleted by other thread. entity is " + entity.getClass().getSimpleName());
                    }
                    try{
                        AbstractExDBEntity entitytmp = em.getEntityManager().contains(entity) ? entity : em.merge(entity);
                        if (entity.isLoaded() && !entitytmp.isLoaded()) {
                            throw new OptimisticLockException("The entity was deleted by other thread.");
                        }
                        PropertyUtils.setProperty(uiBean, prop.getName(),entitytmp);
                    }
                    catch(Exception e){
                        if(!hasLazyInitializationException(e)){
                            throw e;
                        }
                    }
                }
            }

            for (String key : allListEntityMap.keySet()) {
                int i = 0;
                for (AbstractExDBEntity entity : allListEntityMap.get(key)) {
                    if ((entity != null) && entity.isLoaded() && (!entity.isRemoved())) {
                        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
                        if (em.getEntityManager().find(entity.getClass(), entity.getPrimaryKey()) == null) {
                            throw new OptimisticLockException("The entity was deleted by other thread. entity is "
                                    + entity.getClass().getSimpleName());
                        }
                        try{
                            AbstractExDBEntity entitytmp = em.merge(entity);
                            if (entity.isLoaded() && !entitytmp.isLoaded()) {
                                throw new OptimisticLockException("The entity was deleted by other thread.");
                            }
                            PropertyUtils.setIndexedProperty(uiBean, key, i, entitytmp);
                        }
                        catch(Exception e){
                            if(!hasLazyInitializationException(e)){
                                throw e;
                            }
                        }
                        i++;
                    }
                }
            }

            if (pInvocation.getMethod().getName().equals("bizAppSetup")) {
                cancel = true;
            }

            if (! cancel) {
                logger.debug(
                    "▽ {}#{}() 実行 (requestURI={})",
                    pInvocation.getMethod().getDeclaringClass().getSimpleName(),
                    pInvocation.getMethod().getName(),
                    requestURI
                );
                TraceInterceptor.incrementNestingLevel();
                try {
                    result = pInvocation.proceed();
                }catch(Throwable  e){
                    if(RayDB2Util.isDeadRockException(e)){
                        throw new RayDB2DeadLockException(e);
                    }

                    throw e;

                } finally {
                    TraceInterceptor.decrementNestingLevel();
                    logger.debug("△");
                }
            }
        } finally {
            RayUtil.clearDBConnectionLogInfo();

            if (cancel) {
                logger.trace(
                        "◇ {}#{}() の実行はキャンセルされました。",
                        pInvocation.getMethod().getDeclaringClass().getSimpleName(),
                        pInvocation.getMethod().getName()
                        );
            }
        }
        return result;
    }

    private static boolean hasLazyInitializationException(Throwable e){
        if(e instanceof LazyInitializationException){
            logger.debug("LazyInitializationExceptionが発生しました。");
            return true;
        }
        if(e.getCause() != null){
            return hasLazyInitializationException(e.getCause());
        }
        return false;
    }

    private static class Prop2EntityTransformer implements Function<PropertyDescriptor, AbstractExDBEntity<?, ?>> {
        private final Object uiBean;

        Prop2EntityTransformer(Object pUiBean) {
            uiBean = pUiBean;
        }

        @Override
        public AbstractExDBEntity<?, ?> apply(PropertyDescriptor pProp) {
            try {
                return (AbstractExDBEntity<?, ?>) PropertyUtils.getProperty(uiBean, pProp.getName());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
