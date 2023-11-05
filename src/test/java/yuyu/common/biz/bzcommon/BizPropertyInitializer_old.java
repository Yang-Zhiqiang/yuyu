package yuyu.common.biz.bzcommon;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.classification.DisplayItem;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.MessageId;
import yuyu.def.db.mapping.AbstractExDBEntity;
import yuyu.def.db.mapping.AbstractExDBEntityForZDB;

/**
 * UiBean、エンティティの初期化を対応のクラスです<br />
 */
public class BizPropertyInitializer_old {

    private static final String ERROE_MESSAGE = "UIBean或はエンティティ初期化の時、想定外の異常が発生しました。";

    public static <Entity extends AbstractExDBEntity<?, ?>> Entity createInitializedEntity(Class<Entity> c) {
        Entity entity = null;
        if (null == c) {
            throw new BizAppException(MessageId.EBC0001, ERROE_MESSAGE);
        }
        try {
            entity = c.newInstance();
            initialize(entity);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BizAppException(e, MessageId.EBC0001, ERROE_MESSAGE);
        }
        return entity;
    }

    public static <UiBean extends AbstractUiBean> void initialize(UiBean b) {
        initialize(b, ClassType.UIBEAN);
    }

    public static <Entity extends AbstractExDBEntity<?, ?>> void initialize(Entity e) {
        initialize(e, ClassType.ENTITY);
    }

    public static <Entity extends AbstractExDBEntityForZDB<?, ?>> void initialize(Entity e) {
        initialize(e, ClassType.ENTITY);
    }

    private static void initialize(Object obj, ClassType ct) {
        Field[] fieldList = obj.getClass().getDeclaredFields();
        for (Field f : fieldList) {
            resetItem(f, obj, ct);
        }
        Field[] superFieldList = obj.getClass().getSuperclass().getDeclaredFields();
        for (Field f : superFieldList) {
            resetItem(f, obj, ct);
        }
    }

    private static void resetItem(Field f, Object obj, ClassType ct) {
        Class<?> c = f.getType();
        if (null != f.getName() && f.getName().length() > 0) {
            String setMethodName = "set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
            String getMethodName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
            if (methodTest(obj, setMethodName, c, "set") && methodTest(obj, getMethodName, c, "get")) {
                Method setM = null;
                Method getM = null;
                try {
                    setM = obj.getClass().getMethod(setMethodName, c);
                    getM = obj.getClass().getMethod(getMethodName);
                } catch (NoSuchMethodException | SecurityException e) {
                    throw new BizAppException(e, MessageId.EBC0001, ERROE_MESSAGE);
                }
                switch (ct) {
                    case UIBEAN:
                        resetUiBean(setM, getM, c, obj);
                        break;
                    case ENTITY:
                        resetEntity(setM, getM, c, obj);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static boolean methodTest(Object obj, String mName, Class<?> c, String type) {
        Method[] methodList = obj.getClass().getMethods();
        for (Method m : methodList) {
            if (m.getName().equals(mName)) {
                Class<?>[] cList = m.getParameterTypes();
                if (type.equals("get") && cList.length == 0) {
                    return true;
                }
                if (type.equals("set") && cList.length == 1 && cList[0].equals(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void resetUiBean(Method setM, Method getM, Class<?> c, Object obj) {
        try {
            Object o = getM.invoke(obj);
            if (null == o) {
                if (getPSuperClass(c)) {
                    setM.invoke(obj, getKbnClassObj(c));
                } else if (c.getName().endsWith(".BizCurrency")) {
                    setM.invoke(obj, BizCurrency.optional());
                } else if (c.getName().endsWith(".BizNumber")) {
                    setM.invoke(obj, BizNumber.optional());
                } else if (c.getName().endsWith("java.lang.String")) {
                    setM.invoke(obj, "");
                }
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new BizAppException(e, MessageId.EBC0001, ERROE_MESSAGE);
        }
    }

    private static void resetEntity(Method setM, Method getM, Class<?> c, Object obj) {
        try {
            Object o = getM.invoke(obj);
            if (null == o) {
                if (getPSuperClass(c)) {
                    setM.invoke(obj, getKbnClassObj(c));
                } else if (c.getName().endsWith(".BizCurrency")) {
                    setM.invoke(obj, BizCurrency.valueOf(0));
                } else if (c.getName().endsWith(".BizNumber")) {
                    setM.invoke(obj, BizNumber.valueOf(0));
                } else if (c.getName().endsWith("java.lang.Boolean")) {
                    setM.invoke(obj, false);
                } else if (c.getName().endsWith("java.lang.Byte")) {
                    setM.invoke(obj, Byte.valueOf("0"));
                } else if (c.getName().endsWith("java.lang.Integer")) {
                    setM.invoke(obj, Integer.valueOf("0"));
                } else if (c.getName().endsWith("java.lang.Long")) {
                    setM.invoke(obj, Long.valueOf("0"));
                } else if (c.getName().endsWith("java.lang.Double")) {
                    setM.invoke(obj, Double.valueOf("0"));
                } else if (c.getName().endsWith("java.lang.String")) {
                    setM.invoke(obj, "");
                }
            }
            else {
                if (c.getName().endsWith(".BizCurrency")) {
                    if (((BizCurrency) o).isOptional()) {
                        setM.invoke(obj, BizCurrency.valueOf(0, ((BizCurrency) o).getType()));
                    }
                } else if (c.getName().endsWith(".BizNumber")) {
                    if (((BizNumber) o).isOptional()) {
                        setM.invoke(obj, BizNumber.valueOf(0));
                    }
                }
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new BizAppException(e, MessageId.EBC0001, ERROE_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private static Object getKbnClassObj(Class<?> c) {
        Object defaultKbn = null;
        try {
            Field patternDefaultF = c.getDeclaredField("PATTERN_DEFAULT");
            Object defaultPatternId = patternDefaultF.get(c);
            Class<?> kbnClass = Class.forName(c.getName());
            Field displaySets_F = Classification.class.getDeclaredField("displaySets_");
            displaySets_F.setAccessible(true);
            Map<?, ?> mapList = (Map<?, ?>) displaySets_F.get(null);
            Object displaySet = mapList.get(kbnClass);
            Method[] displaySetMList = displaySet.getClass().getDeclaredMethods();
            List<DisplayItem<?>> displayItemList = null;
            for (Method m : displaySetMList) {
                String methodName = m.getName();
                if (methodName.equals("getDisplayItemList")) {
                    m.setAccessible(true);
                    displayItemList = (List<DisplayItem<?>>) m.invoke(displaySet, defaultPatternId.toString());
                    break;
                }
            }
            if (null != displayItemList) {
                for (DisplayItem<?> item : displayItemList) {
                    if (item.isInitial()) {
                        defaultKbn = item.getClassification();
                        break;
                    }
                }
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
            | ClassNotFoundException | InvocationTargetException e) {
            throw new BizAppException(e, MessageId.EBC0001, ERROE_MESSAGE);
        }
        return defaultKbn;

    }

    private static Boolean getPSuperClass(Class<?> c) {
        if (null == c) {
            return false;
        }
        String name = c.getName();
        if (name.endsWith("jp.co.slcs.swak.core.classification.Classification")) {
            return true;
        } else if (!name.endsWith("java.lang.Object")) {
            return getPSuperClass(c.getSuperclass());
        } else {
            return false;
        }
    }

    private static enum ClassType {
        UIBEAN,
        ENTITY
    }
}
