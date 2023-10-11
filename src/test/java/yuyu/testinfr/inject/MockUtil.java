package yuyu.testinfr.inject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

public class MockUtil {

    @Deprecated
    @SuppressWarnings("unchecked")
    public static <T> T forceGet(Object pInstance, String pFieldNm){

        Class<?> clazz = pInstance.getClass();

        while(clazz != null){

            try{

                Field f = clazz.getDeclaredField(pFieldNm);
                f.setAccessible(true);
                return (T)f.get(pInstance);
            }
            catch(NoSuchFieldException e){
                clazz = clazz.getSuperclass();
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }

        throw new RuntimeException(pFieldNm + "は" + pInstance.getClass().getSimpleName() +"に存在しません。");
    }

    @Deprecated
    public static void forceSet(Object pInstance, String pFieldNm, Object pValue){

        Class<?> clazz = pInstance.getClass();

        while(clazz != null){

            try{

                Field f = clazz.getDeclaredField(pFieldNm);
                f.setAccessible(true);
                f.set(pInstance, pValue);

                break;
            }
            catch(NoSuchFieldException e){
                clazz = clazz.getSuperclass();
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }

        if(clazz == null) throw new RuntimeException(pFieldNm + "は" + pInstance.getClass().getSimpleName() +"に存在しません。");
    }

    @Deprecated
    public static Object forceCall(Object pInstance, String pMethodNm, Class<?>[] paramTypes, Object[] params){

        Class<?> clazz = pInstance.getClass();
        Object ret;

        while(clazz != null){

            try{

                Method m;
                if(paramTypes == null || paramTypes.length == 0){
                    m = clazz.getDeclaredMethod(pMethodNm);
                    m.setAccessible(true);
                    ret = m.invoke(pInstance);
                }
                else{
                    m = clazz.getDeclaredMethod(pMethodNm, paramTypes);
                    m.setAccessible(true);
                    ret = m.invoke(pInstance, params);
                }

                return ret;
            }
            catch(NoSuchMethodException e){
                clazz = clazz.getSuperclass();
            }
            catch(UndeclaredThrowableException e){
                throw new RuntimeException(getReflectExceptionCause(e));
            }
            catch(InvocationTargetException e){
                throw new RuntimeException(getReflectExceptionCause(e));
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }

        throw new RuntimeException(pMethodNm + "は" + pInstance.getClass().getSimpleName() +"に存在しません。");
    }

    private static Throwable getReflectExceptionCause(Throwable t){

        Throwable cause = t.getCause();
        if(cause == null){
            return t;
        }
        else if(cause instanceof UndeclaredThrowableException || cause instanceof InvocationTargetException){
            return getReflectExceptionCause(cause);
        }

        return cause;
    }
}
