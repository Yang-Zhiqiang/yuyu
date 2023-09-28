package yuyu.common.biz.bzcommon;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.bizinfr.configuration.fieldconfig.FieldDefManager;
import jp.co.slcs.swak.bizinfr.configuration.fieldconfig.MFieldDef;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import jp.co.slcs.swak.util.string.StringUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;

import com.google.common.base.Strings;

/**
 * 業務共通 共通 連携項目変換用ユーティリティクラス
 */
public class BzRenkeiHenkanUtil<T1, T2> {

    private final static Logger logger = LoggerFactory.getLogger(BzRenkeiHenkanUtil.class);

    private C_SystemRenkeiSyoriHousikiKbn systemRenkeiSyoriHousikiKbn;

    private C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn;

    private C_SystemRenkeiFileSyubetuKbn systemRenkeiFileSyubetuKbn;

    private Class<T1> convertLayout;

    private Class<T2> convertedLayout;

    private List<String> convDDList;

    private Map<String,Padding> convPadingMap;

    private Map<String,Method> getMethodMap;

    private Map<String,Method> setMethodMap;

    private boolean koteityouFlg = true;

    FieldDefManager fieldDefManager;

    private C_ErrorKbn errorKbn;

    private String convYmString;

    private BizDateYM convYmBizDate;

    private String convYmdString;

    private BizDate convYmdBizDate;

    public BzRenkeiHenkanUtil() {
        super();
    }

    public void initialize(Class<T2> pConvertedLayout,
            C_SystemRenkeiSyoriHousikiKbn pSystemRenkeiSyoriHousikiKbn,
            C_SystemRenkeiHenkanHoukouKbn pSystemRenkeiHenkanHoukouKbn) {

        if(pConvertedLayout == null || pSystemRenkeiSyoriHousikiKbn == null || pSystemRenkeiHenkanHoukouKbn == null){
            throw new BizAppException(MessageId.EBA1039);
        }

        if(!pSystemRenkeiSyoriHousikiKbn.eq(C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC)){
            throw new BizAppException(MessageId.EBA1040);
        }

        convertedLayout = pConvertedLayout;
        systemRenkeiSyoriHousikiKbn = pSystemRenkeiSyoriHousikiKbn;
        systemRenkeiHenkanHoukouKbn = pSystemRenkeiHenkanHoukouKbn;
        fieldDefManager = FieldDefManager.getInstance();

        convDDList = getHenkanList(convertedLayout);

        if(convDDList.size() == 0){
            String errMsgParam0 = ( convertedLayout == null ? "null" : convertedLayout.getSimpleName() );

            throw new BizAppException(MessageId.EBA1041, errMsgParam0);
        }
        convPadingMap = getPadingMap(convertedLayout);
    }

    public void initialize(Class<T2> pConvertedLayout,
            C_SystemRenkeiSyoriHousikiKbn pSystemRenkeiSyoriHousikiKbn,
            C_SystemRenkeiHenkanHoukouKbn pSystemRenkeiHenkanHoukouKbn,
            C_SystemRenkeiFileSyubetuKbn pSystemRenkeiFileSyubetuKbn) {

        if(pConvertedLayout == null || pSystemRenkeiSyoriHousikiKbn == null
                || pSystemRenkeiHenkanHoukouKbn == null || pSystemRenkeiFileSyubetuKbn == null){
            throw new BizAppException(MessageId.EBA1039);
        }

        if(!pSystemRenkeiSyoriHousikiKbn.eq(C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI)){
            throw new BizAppException(MessageId.EBA1040);
        }

        convertedLayout = pConvertedLayout;
        systemRenkeiSyoriHousikiKbn = pSystemRenkeiSyoriHousikiKbn;
        systemRenkeiHenkanHoukouKbn = pSystemRenkeiHenkanHoukouKbn;
        systemRenkeiFileSyubetuKbn = pSystemRenkeiFileSyubetuKbn;
        fieldDefManager = FieldDefManager.getInstance();

        convDDList = getHenkanList(convertedLayout);

        if(convDDList.size() == 0){

            String errMsgParam0 = ( convertedLayout == null ? "null" : convertedLayout.getSimpleName() );

            throw new BizAppException(MessageId.EBA1041, errMsgParam0);
        }

        if (C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH.eq(systemRenkeiFileSyubetuKbn)) {

            koteityouFlg = false;
        }

        convPadingMap = getPadingMap(convertedLayout);
    }

    public void initialize(Class<T1> pConvertLayout,
            Class<T2> pConvertedLayout,
            C_SystemRenkeiSyoriHousikiKbn pSystemRenkeiSyoriHousikiKbn,
            C_SystemRenkeiHenkanHoukouKbn pSystemRenkeiHenkanHoukouKbn) {

        if(pConvertLayout == null){
            throw new BizAppException(MessageId.EBA1039);
        }
        convertLayout = pConvertLayout;

        this.initialize(pConvertedLayout, pSystemRenkeiSyoriHousikiKbn, pSystemRenkeiHenkanHoukouKbn);

        this.analyzeMethods(convertLayout, convertedLayout);
    }

    public void initialize(Class<T1> pConvertLayout,
            Class<T2> pConvertedLayout,
            C_SystemRenkeiSyoriHousikiKbn pSystemRenkeiSyoriHousikiKbn,
            C_SystemRenkeiHenkanHoukouKbn pSystemRenkeiHenkanHoukouKbn,
            C_SystemRenkeiFileSyubetuKbn pSystemRenkeiFileSyubetuKbn) {

        if(pConvertLayout == null){
            throw new BizAppException(MessageId.EBA1039);
        }
        convertLayout = pConvertLayout;

        this.initialize(pConvertedLayout, pSystemRenkeiSyoriHousikiKbn,
                pSystemRenkeiHenkanHoukouKbn,pSystemRenkeiFileSyubetuKbn);

        this.analyzeMethods(convertLayout, convertedLayout);
    }

    public T2 convBean(T1 pConvBean) {

        T2 convertedObject = null;
        String convertedDDName = null;
        String convertDDName = null;
        MFieldDef mFieldDef = null;
        Object convData = null;
        Object convertedData = null;

        try {
            convertedObject = this.convertedLayout.newInstance();

            for (String convDD : convDDList) {
                convertedDDName = convDD;

                convertDDName = getHenkanTaiObjectNm(convertedDDName);

                mFieldDef = fieldDefManager.getMFieldDef(convertedDDName);

                convData = getMethodMap.get(convertDDName).invoke(pConvBean);

                convertedData = convert(systemRenkeiHenkanHoukouKbn, mFieldDef, convData, koteityouFlg);

                setMethodMap.get(convertedDDName).invoke(convertedObject, convertedData);
            }
        } catch (Throwable t) {
            if (t instanceof BizAppException) {
                throw (BizAppException) t;
            }
            throw new BizAppException(t,MessageId.EAS0027);
        }

        return convertedObject;
    }


    public T2 convDouituBean(T2 pConvBean) {

        String convertedDDName = null;
        MFieldDef mFieldDef = null;
        Object convData = null;
        Object convertedData = null;
        Method getMethod = null;
        Method setMethod = null;
        PropertyDescriptor propertyDescriptor = null;

        try {
            for (String convDD : convDDList) {
                convertedDDName = convDD;

                mFieldDef = fieldDefManager.getMFieldDef(convDD);

                propertyDescriptor = new PropertyDescriptor(convDD, convertedLayout);

                getMethod = propertyDescriptor.getReadMethod();

                convData = getMethod.invoke(pConvBean);

                convertedData = convert(systemRenkeiHenkanHoukouKbn, mFieldDef, convData, koteityouFlg);

                propertyDescriptor = new PropertyDescriptor(convertedDDName, this.convertedLayout);

                setMethod = propertyDescriptor.getWriteMethod();

                setMethod.invoke(pConvBean, convertedData);
            }
        } catch (Throwable t) {
            if (t instanceof BizAppException) {
                throw (BizAppException) t;
            }
            throw new BizAppException(t,MessageId.EAS0027);
        }

        return pConvBean;
    }

    public Object convert(C_SystemRenkeiHenkanHoukouKbn pSystemRenkeiHenkanHoukouKbn,
            MFieldDef pMFieldDef,
            Object pConvObject,
            boolean pKoteityouFlg) {

        Object convObjectData = null;
        int dataLength = 0;
        int iConvertH2ZAll =  IDataConvert.iCONVERT_H2Z_ALL;
        int iConvertZ2HAll =  IDataConvert.iCONVERT_Z2H_ALL;
        char zSpace = '　';
        char hSpace = ' ';

        if ("String".equals(pMFieldDef.getType())) {

            if (pConvObject instanceof String) {

                convObjectData = pConvObject;
            }
            else if (pConvObject instanceof Long
                    || pConvObject instanceof Double
                    || pConvObject instanceof Integer
                    || pConvObject instanceof BizNumber) {
                convObjectData = String.valueOf(pConvObject);
            }
            else if (pConvObject == null) {

                String errMsgParam0 = ( pMFieldDef.getId() == null ? "null" : pMFieldDef.getId() );

                throw new BizAppException(MessageId.EBA1042, errMsgParam0);
            }
            else {

                String errMsgParam0 = ( pMFieldDef.getId() == null ? "null" : pMFieldDef.getId() );

                String errMsgParam1 = ( pConvObject == null ? "null" : pConvObject.toString() );

                throw new BizAppException(MessageId.EBA1008, errMsgParam0, errMsgParam1);
            }

            if (C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER.eq(pSystemRenkeiHenkanHoukouKbn)) {
                if (pKoteityouFlg == true) {
                    if ("Z".equals(pMFieldDef.getZenhanKbn())) {
                        convObjectData = ConvertUtil.convZenHan(iConvertH2ZAll, String.valueOf(convObjectData));

                        convObjectData = ddSiteiPadding(iConvertH2ZAll, pMFieldDef, convObjectData);

                        convObjectData = Strings.padEnd(
                                String.valueOf(convObjectData),
                                pMFieldDef.getMaxlength().intValue(),
                                zSpace);
                    }
                    else if ("H".equals(pMFieldDef.getZenhanKbn())) {
                        convObjectData = ConvertUtil.convZenHan(iConvertZ2HAll, String.valueOf(convObjectData));

                        convObjectData = ddSiteiPadding(iConvertZ2HAll, pMFieldDef, convObjectData);

                        convObjectData = Strings.padEnd(
                                String.valueOf(convObjectData),
                                pMFieldDef.getMaxlength().intValue(),
                                hSpace);
                    }
                }
                else if (pKoteityouFlg == false) {
                    if ("Z".equals(pMFieldDef.getZenhanKbn())) {
                        convObjectData = ConvertUtil.convZenHan(iConvertH2ZAll, String.valueOf(convObjectData));

                        convObjectData = ddSiteiPadding(iConvertH2ZAll, pMFieldDef, convObjectData);
                    }
                    else if ("H".equals(pMFieldDef.getZenhanKbn())) {
                        convObjectData = ConvertUtil.convZenHan(iConvertZ2HAll, String.valueOf(convObjectData));

                        convObjectData = ddSiteiPadding(iConvertZ2HAll, pMFieldDef, convObjectData);
                    }
                }
            }
            else if (C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY.eq(pSystemRenkeiHenkanHoukouKbn)) {
                if ("Z".equals(pMFieldDef.getZenhanKbn())) {
                    convObjectData = ConvertUtil.convZenHan(iConvertH2ZAll, String.valueOf(convObjectData));

                    convObjectData = StringUtil.rTrim(String.valueOf(convObjectData));

                    convObjectData = ddSiteiPadding(iConvertH2ZAll, pMFieldDef, convObjectData);
                }
                else if ("H".equals(pMFieldDef.getZenhanKbn())) {
                    convObjectData = ConvertUtil.convZenHan(iConvertZ2HAll, String.valueOf(convObjectData));

                    convObjectData = StringUtil.rTrim(String.valueOf(convObjectData));

                    convObjectData = ddSiteiPadding(iConvertZ2HAll, pMFieldDef, convObjectData);
                }
            }

            dataLength = String.valueOf(convObjectData).length();

            if (dataLength <= pMFieldDef.getMaxlength().intValue()) {
            }
            else if (dataLength > pMFieldDef.getMaxlength().intValue()) {

                Object tConvObjectData = String.valueOf(convObjectData).substring(0, pMFieldDef.getMaxlength().intValue());

                logger.trace("変換後文字列が最大桁数を超過しています。切り落とし処理を実行します。");
                logger.trace("▽切り落とし前後の文字列");
                logger.trace("｜[before] : " + String.valueOf(convObjectData));
                logger.trace("｜[after]  : " + String.valueOf(tConvObjectData));
                logger.trace("△");


                convObjectData = tConvObjectData;
            }
        }
        else if ("Long".equals(pMFieldDef.getType())
                || "Double".equals(pMFieldDef.getType())
                || "Integer".equals(pMFieldDef.getType())
                || "BizNumber".equals(pMFieldDef.getType())) {

            if (pConvObject instanceof String) {

                boolean chkKeka = chkNumber(String.valueOf(pConvObject));

                if (chkKeka == true) {

                    if ("Long".equals(pMFieldDef.getType())) {

                        convObjectData = Long.valueOf(String.valueOf(pConvObject));
                    }
                    else if ("Double".equals(pMFieldDef.getType())) {

                        convObjectData = Double.valueOf(String.valueOf(pConvObject));
                    }
                    else if ("Integer".equals(pMFieldDef.getType())) {

                        convObjectData = Integer.valueOf(String.valueOf(pConvObject));
                    }
                    else if ("BizNumber".equals(pMFieldDef.getType())) {

                        convObjectData = BizNumber.valueOf(new BigDecimal(String.valueOf(pConvObject)));
                    }
                }
                else {

                    String errMsgParam0 = ( pMFieldDef.getId() == null ? "null" : pMFieldDef.getId() );

                    String errMsgParam1 = ( pConvObject == null ? "null" : pConvObject.toString() );

                    throw new BizAppException(MessageId.EBA1010, errMsgParam0, errMsgParam1);
                }
            }
            else if (pConvObject instanceof Long ||
                    pConvObject instanceof Double ||
                    pConvObject instanceof Integer ||
                    pConvObject instanceof BizNumber) {

                convObjectData = pConvObject;
            }
            else {

                String errMsgParam0 = ( pMFieldDef.getId() == null ? "null" : pMFieldDef.getId() );

                String errMsgParam1 = ( pConvObject == null ? "null" : pConvObject.toString() );

                throw new BizAppException(MessageId.EBA1008, errMsgParam0, errMsgParam1);
            }
        }
        else {

            convObjectData = pConvObject;
        }

        return convObjectData;
    }

    public void convYmdZeroToNull(String pConvYmdString) {

        if (BizUtil.isBlank(pConvYmdString)) {

            convYmdBizDate = null;
            convYmdString = null;
            errorKbn = C_ErrorKbn.ERROR;
        }
        else if ("00000000".equals(pConvYmdString)) {

            convYmdBizDate = null;
            convYmdString = null;
            errorKbn = C_ErrorKbn.OK;
        }
        else {
            if (pConvYmdString.length() == 8) {
                convYmdBizDate = BizDate.valueOf(pConvYmdString);
                convYmdString = pConvYmdString;
                errorKbn = C_ErrorKbn.OK;
            }
            else {

                convYmdBizDate = null;
                convYmdString = null;
                errorKbn = C_ErrorKbn.ERROR;
            }


        }
    }

    public void convYmdNullToZero(BizDate pConvYmdBizDate) {

        if (pConvYmdBizDate == null) {

            convYmdBizDate = BizDate.MIN_VALUE;
            convYmdString = BizDate.MIN_VALUE.toString();
            errorKbn = C_ErrorKbn.OK;
        }
        else {

            convYmdBizDate = pConvYmdBizDate;
            convYmdString = pConvYmdBizDate.toString();
            errorKbn = C_ErrorKbn.OK;
        }
    }

    public void convYmZeroToNull(String pConvYmString) {
        if (BizUtil.isBlank(pConvYmString)) {

            convYmBizDate = null;
            convYmString = null;
            errorKbn = C_ErrorKbn.ERROR;
        }
        else if ("000000".equals(pConvYmString)) {

            convYmBizDate = null;
            convYmString = null;
            errorKbn = C_ErrorKbn.OK;
        }
        else {

            if (pConvYmString.length() == 6) {

                convYmBizDate = BizDateYM.valueOf(pConvYmString);
                convYmString = pConvYmString;
                errorKbn = C_ErrorKbn.OK;

            }
            else {

                convYmBizDate = null;
                convYmString = null;
                errorKbn = C_ErrorKbn.ERROR;

            }


        }

    }

    public void convYmNullToZero(BizDateYM pConvYmBizDate) {

        if (pConvYmBizDate == null) {

            convYmBizDate = BizDateYM.MIN_VALUE;
            convYmString = BizDateYM.MIN_VALUE.toString();
            errorKbn = C_ErrorKbn.OK;
        }
        else {

            convYmBizDate = pConvYmBizDate;
            convYmString = pConvYmBizDate.toString();
            errorKbn = C_ErrorKbn.OK;
        }
    }

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public String getConvYmString() {
        return convYmString;
    }

    public BizDateYM getConvYmBizDate() {
        return convYmBizDate;
    }

    public String getConvYmdString() {
        return convYmdString;
    }

    public BizDate getConvYmdBizDate() {
        return convYmdBizDate;
    }


    private boolean chkNumber(String pNumber) {
        String regex = "^[１２３４５６７８９０1234567890]+$";
        boolean chkkeka = false;

        chkkeka = pNumber.matches(regex);

        return chkkeka;
    }

    private List<String> getHenkanList(Class<T2> pConvertedLayout) {

        List<String> convObjectDDList = new ArrayList<>();
        Class<? super T2> superClass = null;
        Method[] methods = null;
        Field[] fields = null;
        Annotation[] annotations = null;

        if (C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI.eq(systemRenkeiSyoriHousikiKbn)
                && C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER.eq(systemRenkeiHenkanHoukouKbn)) {
            superClass = pConvertedLayout.getSuperclass();

            fields = superClass.getDeclaredFields();

            for (Field field : fields) {

                annotations = field.getAnnotations();

                for (Annotation annotation : annotations) {

                    if (annotation instanceof jp.co.slcs.swak.file.description.text.csv.annotations.Column
                            || annotation instanceof jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column) {
                        convObjectDDList.add(field.getName());
                    }
                }
            }
        }
        else {

            superClass = pConvertedLayout.getSuperclass();

            methods = superClass.getDeclaredMethods();

            for (Method method : methods) {

                annotations = method.getAnnotations();

                for (Annotation annotation : annotations) {

                    if (annotation instanceof javax.persistence.Column) {

                        convObjectDDList.add(((javax.persistence.Column) annotation).name());
                    }
                }
            }
        }

        return convObjectDDList;
    }

    private Map<String, Padding>  getPadingMap(Class<T2> pConvertedLayout) {

        HashMap<String,Padding> targetPadingMap = new HashMap<String,Padding>();

        Class<? super T2> superClass = null;

        PropertyDescriptor pd = null;

        Method method = null;

        superClass = pConvertedLayout.getSuperclass();

        try {

            for(String name : convDDList){

                pd = new PropertyDescriptor(name,superClass);
                method = pd.getWriteMethod();

                if(method.isAnnotationPresent(Padding.class)){

                    targetPadingMap.put(name, method.getAnnotation(Padding.class));
                } else {

                    targetPadingMap.put(name, null);
                }
            }
        } catch (Throwable t) {
            if (t instanceof BizAppException) {
                throw (BizAppException) t;
            }
            throw new BizAppException(t, t.getClass().getSimpleName());
        }

        return targetPadingMap;
    }

    private String getHenkanTaiObjectNm(String pDDName) {

        String convertDDName = null;

        if ("zrn".equals(pDDName.substring(0, 3))) {
            convertDDName = pDDName.replaceFirst("zrn", "zty");
        }
        else if ("ztr".equals(pDDName.substring(0, 3))) {
            convertDDName = pDDName.replaceFirst("ztr", "zrn");
        }
        else {
            throw new BizAppException(MessageId.EBA1014, pDDName);
        }

        return convertDDName;
    }

    private Object ddSiteiPadding(int pConvertFilter, MFieldDef pMFieldDef, Object pConvObject){

        Padding padding = null;
        Object convObjectData = String.valueOf(pConvObject);

        if(convPadingMap != null) {
            padding = convPadingMap.get(pMFieldDef.getId());
        }

        if(padding != null) {

            if(padding.length() == 0) {

                String errMsgParam0 = ( pMFieldDef.getId() == null ? "null" : pMFieldDef.getId() );

                throw new BizAppException(MessageId.EBA1038, errMsgParam0);
            }

            String tempPadChar = ConvertUtil.convZenHan(pConvertFilter, String.valueOf(padding.padChar()));
            char padChar = tempPadChar.charAt(0);

            if(padding.mode().equals("left")) {
                convObjectData = Strings.padStart(
                        String.valueOf(pConvObject),
                        padding.length(),
                        padChar);
            } else {
                convObjectData = Strings.padEnd(
                        String.valueOf(pConvObject),
                        padding.length(),
                        padChar);
            }
        }
        return convObjectData;
    }

    private void analyzeMethods(Class<?> pConvertLayout, Class<?> pConvertedLayout){

        String convertDDName = null;
        try {
            getMethodMap = new HashMap<String,Method>();
            setMethodMap = new HashMap<String,Method>();

            for (String convertedDDName : convDDList) {

                convertDDName = getHenkanTaiObjectNm(convertedDDName);

                PropertyDescriptor getMethodPD = new PropertyDescriptor(convertDDName, pConvertLayout);
                getMethodMap.put(convertDDName, getMethodPD.getReadMethod());

                PropertyDescriptor setMethodPD = new PropertyDescriptor(convertedDDName, pConvertedLayout);
                setMethodMap.put(convertedDDName, setMethodPD.getWriteMethod());
            }

        } catch (Throwable t) {
            if (t instanceof BizAppException) {
                throw (BizAppException) t;
            }
            throw new BizAppException(t,MessageId.EAS0027);
        }
    }
}
