package yuyu.infr.report;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizRate;
import net.arnx.jsonic.JSON;

/**
 * GkDate や 区分クラス も JSON 化できる JSON エンコーダー／デコーダー です。<br />
 * このクラスを使えば、GkDate や 区分クラス が含まれたオブジェクトも JSON 化できます。<br />
 * {@link JSON#encode(Object)}、{@link JSON#decode(String, Class)} 等をする前に
 * 「 <code>JSON.prototype = ReportJSON.class;</code> 」 と書いて、エンコード／デコードに本クラスが使われるよう設定ください。
 */
public class ReportJSON extends JSON {
    @Override
    protected Object preformat(Context pContext, Object pValue) {
        if ((pValue instanceof jp.co.slcs.swak.core.classification.StringValuedEnum) ||
                (pValue instanceof BizDate)    ||
                (pValue instanceof BizDateY)   ||
                (pValue instanceof BizDateYM)  ||
                (pValue instanceof BizDateMD)  ||
                (pValue instanceof BizNumber)  ||
                (pValue instanceof BizCurrency)||
                (pValue instanceof BizRate)
                ) {
            return pValue.toString();
        }
        if (pValue instanceof List<?>) {
            List<Object> objList = new LinkedList<Object>();
            List<?> list = (List<?>)pValue;
            for(Object obj:list){
                try {
                    objList.add(super.preformat(pContext, obj));
                } catch (Exception e) {
                    throw new BizAppException(e,"EAS0012");
                }
            }
            return objList;
        }
        if (pValue.getClass().isArray()) {
            if (pValue instanceof List<?>) {
                List<Object> objList = new LinkedList<Object>();
                Object[] array = (Object[])pValue;
                if(array.length > 0){
                    for(Object obj:array){
                        try {
                            objList.add(super.preformat(pContext, obj));
                        } catch (Exception e) {
                            throw new BizAppException(e,"EAS0012");
                        }
                    }
                }
                return objList.toArray(new Object[0]);
            }
        }

        try {
            return super.preformat(pContext, pValue);
        } catch (Exception e) {
            throw new BizAppException(e,"EAS0012");
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T> T postparse(Context pContext, Object pValue, Class<? extends T> pCls, Type pType) {
        if (pValue instanceof String) {
            String value = (String) pValue;

            if (jp.co.slcs.swak.core.classification.StringValuedEnum.class.isAssignableFrom(pCls)) {
                try {
                    return (T) pCls.getMethod("valueOf", String.class).invoke(null, value);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                        | NoSuchMethodException | SecurityException e) {
                    throw new BizAppException(e,"EAS0013");
                }
            }

            if (BizDate.class.isAssignableFrom(pCls)) {
                return (T) BizDate.valueOf(value);
            }

            if (BizDateY.class.isAssignableFrom(pCls)) {
                return (T) BizDateY.valueOf(value);
            }

            if (BizDateYM.class.isAssignableFrom(pCls)) {
                return (T) BizDateYM.valueOf(value);
            }

            if (BizDateMD.class.isAssignableFrom(pCls)) {
                return (T) BizDateMD.valueOf(value);
            }

            if (BizCurrency.class.isAssignableFrom(pCls)) {
                return (T) BizCurrency.valueOf(new BigDecimal(value));
            }

            if (BizNumber.class.isAssignableFrom(pCls)) {
                return (T) BizNumber.valueOf(new BigDecimal(value));
            }

            if (BizRate.class.isAssignableFrom(pCls)) {
                return (T) BizRate.valueOf(new BigDecimal(value));
            }
        }

        try {
            return super.postparse(pContext, pValue, pCls, pType);
        } catch (Exception e) {
            throw new BizAppException(e,"EAS0013");
        }
    }
}
