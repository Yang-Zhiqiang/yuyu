package yuyu.common.biz.bzcommon;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.classification.DisplayItem;
import jp.co.slcs.swak.date.AbstractBizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.CaseFormat;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import yuyu.def.MessageId;
import yuyu.def.db.mapping.AbstractExDBEntityForZDB;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * エンティティー・UiBean を初期化するユーティリティークラスです。
 */
@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class BizPropertyInitializer {

    private static final boolean oldVersionCompatible = true;

    private static final Map<Class<?>, PropertyDescriptor[]> propsMap = new HashMap<>();

    private static final String ERROE_MESSAGE = "UIBean或はエンティティ初期化の時、想定外の異常が発生しました。";

    public static <Entity extends yuyu.def.db.mapping.AbstractExDBEntity<?, ?>> Entity createInitializedEntity(Class<Entity> type) {
        if (type == null) {
            throw new BizAppException(MessageId.EBC0001, ERROE_MESSAGE);
        }
        Entity entity;
        try {
            entity = type.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new BizAppException(e, MessageId.EBC0001, ERROE_MESSAGE);
        }
        initialize(entity);
        return entity;
    }

    public static <Entity extends yuyu.def.db.mapping.AbstractExDBEntity<?, ?>> void initialize(Entity e) {
        initialize((AbstractExDBEntity<?, ?>)e);
    }

    public static <Entity extends AbstractExDBEntityForZDB<?, ?>> void initialize(Entity e) {
        initialize((AbstractExDBEntity<?, ?>)e);
    }

    public static <E extends AbstractExDBEntity<?, ?>> void initialize(E entity) {
        if (entity == null) {
            throw new BizAppException(MessageId.EBC0001, ERROE_MESSAGE);
        }
        try {
            if (oldVersionCompatible) {
                final Class<?> type = entity.getClass();

                PropertyDescriptor[] props;
                synchronized (propsMap) {
                    if (! propsMap.containsKey(type)) {
                        List<Field> fields = new ArrayList<>(Arrays.asList(type.getDeclaredFields()));
                        fields.addAll(Arrays.asList(type.getSuperclass().getDeclaredFields()));
                        propsMap.put(
                            type,
                            Iterables.toArray(
                                Iterables.transform(
                                    Iterables.filter(
                                        Iterables.transform(
                                            Iterables.filter(
                                                fields,
                                                new Predicate<Field>() {
                                                    @Override
                                                    public boolean apply(Field field) {
                                                        // if ((field.getModifiers() & Modifier.STATIC) != 0){
                                                        if (Modifier.isStatic(field.getModifiers())){
                                                            return false;
                                                        }
                                                        switch (field.getName()) {
                                                            case "primaryKey": return false;
                                                            default:           break;
                                                        }
                                                        return true;
                                                    }
                                                }
                                            ),
                                            new Function<Field, Optional<PropertyDescriptor>>() {
                                                @Override
                                                public Optional<PropertyDescriptor> apply(Field field) {
                                                    String upperCamel = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL,field.getName());
                                                    Method  readMethod;
                                                    try {
                                                        readMethod = type.getMethod("get" + upperCamel);
                                                    } catch (NoSuchMethodException e) {
                                                        return Optional.absent();
                                                    }
                                                    if (readMethod.isAnnotationPresent(OneToMany.class)) return Optional.absent();
                                                    if (readMethod.isAnnotationPresent(ManyToOne.class)) return Optional.absent();
                                                    if (readMethod.isAnnotationPresent(OneToOne .class)) return Optional.absent();

                                                    Method writeMethod;
                                                    try {
                                                        writeMethod = type.getMethod("set" + upperCamel, field.getType());
                                                    } catch (NoSuchMethodException e) {
                                                        return Optional.absent();
                                                    }
                                                    try {
                                                        return Optional.of(new PropertyDescriptor(field.getName(), readMethod, writeMethod));
                                                    } catch (IntrospectionException e) {
                                                        return Optional.absent();
                                                    }
                                                }
                                            }
                                        ),
                                        new Predicate<Optional<PropertyDescriptor>>() {
                                            @Override
                                            public boolean apply(Optional<PropertyDescriptor> opt) {
                                                return opt.isPresent();
                                            }
                                        }
                                    ),
                                    new Function<Optional<PropertyDescriptor>, PropertyDescriptor>() {
                                        @Override
                                        public PropertyDescriptor apply(Optional<PropertyDescriptor> opt) {
                                            return opt.get();
                                        }
                                    }
                                ),
                                PropertyDescriptor.class
                            )
                        );
                    }
                    props = propsMap.get(type);
                }
                for (PropertyDescriptor prop : props) {
                    initEntityProperty(entity, prop);
                }
            } else {
                for (PropertyDescriptor prop : entity.getPersistProps()) {
                    initEntityProperty(entity, prop);
                }
            }
        } catch (ReflectiveOperationException e) {
            throw new BizAppException(e, MessageId.EBC0001, ERROE_MESSAGE);
        }
    }

    private static void initEntityProperty(Object bean, PropertyDescriptor prop) throws ReflectiveOperationException {
        Object value = prop.getReadMethod().invoke(bean);
        if (value == null) {
            prop.getWriteMethod().invoke(
                bean,
                getEntityDefaultValue(prop)
            );
        } else {
            if (value instanceof BizCurrency) {
                BizCurrency c = (BizCurrency) value;
                if (c.isOptional()) {
                    prop.getWriteMethod().invoke(
                        bean,
                        BizCurrency.valueOf(Integer.valueOf(0), c.getType())
                    );
                }
            } else if (value instanceof BizNumber) {
                BizNumber n = (BizNumber) value;
                if (n.isOptional()) {
                    prop.getWriteMethod().invoke(
                        bean,
                        getEntityDefaultValue(prop)
                    );
                }
            }
        }
    }

    private static Object getEntityDefaultValue(PropertyDescriptor prop) {
        Class<?> type = prop.getPropertyType();
        if (String     .class.isAssignableFrom(type)) return "";
        if (Boolean    .class.isAssignableFrom(type)) return Boolean    .FALSE;
        if (Byte       .class.isAssignableFrom(type)) return Byte       .valueOf( (byte)0);
        if (Short      .class.isAssignableFrom(type)) return Short      .valueOf((short)0);
        if (Integer    .class.isAssignableFrom(type)) return Integer    .valueOf(0);
        if (Long       .class.isAssignableFrom(type)) return Long       .valueOf(0);
        if (Float      .class.isAssignableFrom(type)) return Float      .valueOf(0);
        if (Double     .class.isAssignableFrom(type)) return Double     .valueOf(0);
        if (BigDecimal .class.isAssignableFrom(type)) return BigDecimal .valueOf(0);
        if (BigInteger .class.isAssignableFrom(type)) return BigInteger .valueOf(0);
        if (BizCurrency.class.isAssignableFrom(type)) return BizCurrency.valueOf(Integer.valueOf(0));
        if (BizNumber  .class.isAssignableFrom(type)) return BizNumber  .valueOf(Integer.valueOf(0));
//        if (BizRate    .class.isAssignableFrom(type)) return BizRate    .valueOf(Integer.valueOf(0));
        if (Classification .class.isAssignableFrom(type)) return getClassificationDefaultValue(type);
        if (AbstractBizDate.class.isAssignableFrom(type)) return null;
        if (type.isArray())                               return null;
        return null;
    }

    public static <T extends AbstractUiBean> void initialize(T uiBean) {
        if (uiBean == null) {
            throw new BizAppException(MessageId.EBC0001, ERROE_MESSAGE);
        }

        final Class<?> beanType = uiBean.getClass();
        List<Field> fields = new ArrayList<>(Arrays.asList(beanType.getDeclaredFields()));
        fields.addAll(Arrays.asList(beanType.getSuperclass().getDeclaredFields()));
        for (PropertyDescriptor prop :

            Iterables.transform(
                Iterables.filter(
                    Iterables.transform(
                        Iterables.filter(
                            fields,
                            new Predicate<Field>() {
                                @Override
                                public boolean apply(Field field) {
                                    // if ((field.getModifiers() & Modifier.STATIC) != 0){
                                    if (Modifier.isStatic(field.getModifiers())){
                                        return false;
                                    }
                                    return true;
                                }
                            }
                        ),
                        new Function<Field, Optional<PropertyDescriptor>>() {
                            @Override
                            public Optional<PropertyDescriptor> apply(Field field) {
                                String upperCamel = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL,field.getName());
                                Method  readMethod;
                                try {
                                    readMethod = beanType.getMethod("get" + upperCamel);
                                } catch (NoSuchMethodException e) {
                                    return Optional.absent();
                                }
                                Class<?> propType = readMethod.getReturnType();
                                if (! String        .class.isAssignableFrom(propType) &&
                                    ! Classification.class.isAssignableFrom(propType) &&
                                    ! BizCurrency   .class.isAssignableFrom(propType) &&
                                    ! BizNumber     .class.isAssignableFrom(propType) &&
//                                  ! BizRate       .class.isAssignableFrom(propType) &&  // 旧 Initializer では BizRate は初期化してなかった。もし、これも初期化対象なら AbstractBizNumber.class 1つだけで済むんだけど..
                                    true
                                ) {
                                    return Optional.absent();
                                }

                                Method writeMethod;
                                try {
                                    writeMethod = beanType.getMethod("set" + upperCamel, field.getType());
                                } catch (NoSuchMethodException e) {
                                    return Optional.absent();
                                }
                                try {
                                    return Optional.of(new PropertyDescriptor(field.getName(), readMethod, writeMethod));
                                } catch (IntrospectionException e) {
                                    return Optional.absent();
                                }
                            }
                        }
                    ),
                    new Predicate<Optional<PropertyDescriptor>>() {
                        @Override
                        public boolean apply(Optional<PropertyDescriptor> opt) {
                            return opt.isPresent();
                        }
                    }
                ),
                new Function<Optional<PropertyDescriptor>, PropertyDescriptor>() {
                    @Override
                    public PropertyDescriptor apply(Optional<PropertyDescriptor> opt) {
                        return opt.get();
                    }
                }
            )
        ) {
            initUiBeanProperty(uiBean, prop);
        }
    }

    private static <T extends AbstractUiBean> void initUiBeanProperty(T uiBean, PropertyDescriptor prop) {
        try {
            Object value = prop.getReadMethod().invoke(uiBean);
            if (value != null) return;
            prop.getWriteMethod().invoke(uiBean, getUiBeanDefaultValue(prop));
        } catch (ReflectiveOperationException e) {
            throw new BizAppException(e, MessageId.EBC0001, ERROE_MESSAGE);
        }
    }

    private static Object getUiBeanDefaultValue(PropertyDescriptor prop) {
        Class<?> type = prop.getPropertyType();
        if (String        .class.isAssignableFrom(type)) return "";
        if (Classification.class.isAssignableFrom(type)) return getClassificationDefaultValue(type);
        if (BizCurrency   .class.isAssignableFrom(type)) return BizCurrency.optional();
        if (BizNumber     .class.isAssignableFrom(type)) return BizNumber  .optional();
//        if (BizRate       .class.isAssignableFrom(type)) return BizRate    .optional();
        return null;
    }

    @SuppressWarnings("unchecked")
    private static <C extends Classification<C>> C getClassificationDefaultValue(Class<?> type) {
        String defaultPatternId;
        try {
            defaultPatternId = (String) type.getField("PATTERN_DEFAULT").get(null);
        } catch (ReflectiveOperationException e) {
            throw new BizAppException(e, MessageId.EBC0001, ERROE_MESSAGE);
        }
        for (DisplayItem<C> item : Classification.getDisplayItems((Class<C>)type, defaultPatternId)) {
            if (item.isInitial()) return item.getClassification();
        }
        return Classification.getInitialData((Class<C>)type);
    }
}
