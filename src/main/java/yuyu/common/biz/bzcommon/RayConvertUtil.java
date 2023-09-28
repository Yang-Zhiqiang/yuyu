package yuyu.common.biz.bzcommon;

import static yuyu.def.YuyuStandardCharsets.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * 文字列変換ユーティリティ<br />
 */
public class RayConvertUtil {

    private static Map<Character,Character> toValidCharConvMap;

    private static Map<CharByteHolder,Character> toPrintableConvMap;

    static{
        toValidCharConvMap = new HashMap<Character,Character>();
        toPrintableConvMap = new HashMap<CharByteHolder,Character>();

        toValidCharConvMap.put('a','A');     toValidCharConvMap.put('ａ','Ａ');
        toValidCharConvMap.put('b','B');     toValidCharConvMap.put('ｂ','Ｂ');
        toValidCharConvMap.put('c','C');     toValidCharConvMap.put('ｃ','Ｃ');
        toValidCharConvMap.put('d','D');     toValidCharConvMap.put('ｄ','Ｄ');
        toValidCharConvMap.put('e','E');     toValidCharConvMap.put('ｅ','Ｅ');
        toValidCharConvMap.put('f','F');     toValidCharConvMap.put('ｆ','Ｆ');
        toValidCharConvMap.put('g','G');     toValidCharConvMap.put('ｇ','Ｇ');
        toValidCharConvMap.put('h','H');     toValidCharConvMap.put('ｈ','Ｈ');
        toValidCharConvMap.put('i','I');     toValidCharConvMap.put('ｉ','Ｉ');
        toValidCharConvMap.put('j','J');     toValidCharConvMap.put('ｊ','Ｊ');
        toValidCharConvMap.put('k','K');     toValidCharConvMap.put('ｋ','Ｋ');
        toValidCharConvMap.put('l','L');     toValidCharConvMap.put('ｌ','Ｌ');
        toValidCharConvMap.put('m','M');     toValidCharConvMap.put('ｍ','Ｍ');
        toValidCharConvMap.put('n','N');     toValidCharConvMap.put('ｎ','Ｎ');
        toValidCharConvMap.put('o','O');     toValidCharConvMap.put('ｏ','Ｏ');
        toValidCharConvMap.put('p','P');     toValidCharConvMap.put('ｐ','Ｐ');
        toValidCharConvMap.put('q','Q');     toValidCharConvMap.put('ｑ','Ｑ');
        toValidCharConvMap.put('r','R');     toValidCharConvMap.put('ｒ','Ｒ');
        toValidCharConvMap.put('s','S');     toValidCharConvMap.put('ｓ','Ｓ');
        toValidCharConvMap.put('t','T');     toValidCharConvMap.put('ｔ','Ｔ');
        toValidCharConvMap.put('u','U');     toValidCharConvMap.put('ｕ','Ｕ');
        toValidCharConvMap.put('v','V');     toValidCharConvMap.put('ｖ','Ｖ');
        toValidCharConvMap.put('w','W');     toValidCharConvMap.put('ｗ','Ｗ');
        toValidCharConvMap.put('x','X');     toValidCharConvMap.put('ｘ','Ｘ');
        toValidCharConvMap.put('y','Y');     toValidCharConvMap.put('ｙ','Ｙ');
        toValidCharConvMap.put('z','Z');     toValidCharConvMap.put('ｚ','Ｚ');
        toValidCharConvMap.put('ｦ','ｵ');     toValidCharConvMap.put('ヲ','オ');
        toValidCharConvMap.put('ｧ','ｱ');     toValidCharConvMap.put('ァ','ア');
        toValidCharConvMap.put('ｨ','ｲ');     toValidCharConvMap.put('ィ','イ');
        toValidCharConvMap.put('ｩ','ｳ');     toValidCharConvMap.put('ゥ','ウ');
        toValidCharConvMap.put('ｪ','ｴ');     toValidCharConvMap.put('ェ','エ');
        toValidCharConvMap.put('ｫ','ｵ');     toValidCharConvMap.put('ォ','オ');
        toValidCharConvMap.put('ｬ','ﾔ');     toValidCharConvMap.put('ャ','ヤ');
        toValidCharConvMap.put('ｭ','ﾕ');     toValidCharConvMap.put('ュ','ユ');
        toValidCharConvMap.put('ｮ','ﾖ');     toValidCharConvMap.put('ョ','ヨ');
        toValidCharConvMap.put('ｯ','ﾂ');     toValidCharConvMap.put('ッ','ツ');
        toValidCharConvMap.put('!',' ');     toValidCharConvMap.put('！','　');
        toValidCharConvMap.put('[',' ');     toValidCharConvMap.put('［','　');
        toValidCharConvMap.put(']',' ');     toValidCharConvMap.put('］','　');
        toValidCharConvMap.put('^',' ');     toValidCharConvMap.put('＾','　');
        toValidCharConvMap.put('ｰ','-');     toValidCharConvMap.put('ー','－');
        toValidCharConvMap.put('`','@');     toValidCharConvMap.put('｀','＠');
        toValidCharConvMap.put('{',' ');     toValidCharConvMap.put('｛','　');
        toValidCharConvMap.put('|','\\');    toValidCharConvMap.put('｜','￥');
        toValidCharConvMap.put('}',' ');     toValidCharConvMap.put('｝','　');
        toValidCharConvMap.put('~',' ');     toValidCharConvMap.put('￣','　');

        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x40},WINDOWS_31J), '養');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x41},WINDOWS_31J), '統');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x42},WINDOWS_31J), '財');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x43},WINDOWS_31J), 'Ｄ');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x44},WINDOWS_31J), 'Ｐ');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x45},WINDOWS_31J), '分');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x46},WINDOWS_31J), '継');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x47},WINDOWS_31J), '新');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x48},WINDOWS_31J), '任');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x5F},WINDOWS_31J), '桒');

        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x75},WINDOWS_31J), '泰');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x8D},WINDOWS_31J), '礼');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x6A},WINDOWS_31J), '初');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x8A},WINDOWS_31J), '裕');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x6D},WINDOWS_31J), '真');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x82},WINDOWS_31J), '博');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x58},WINDOWS_31J), '喜');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x65},WINDOWS_31J), '廣');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x59},WINDOWS_31J), '吉');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x89},WINDOWS_31J), '槙');

        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x70},WINDOWS_31J), '批');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x7A},WINDOWS_31J), '週');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x8B},WINDOWS_31J), '祥');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x5B},WINDOWS_31J), '龍');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x61},WINDOWS_31J), '甎');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x69},WINDOWS_31J), '鑚');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x7C},WINDOWS_31J), '閭');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x4C},WINDOWS_31J), '叡');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x83},WINDOWS_31J), '藩');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x80},WINDOWS_31J), '壽');

        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x5A},WINDOWS_31J), '鱚');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x52},WINDOWS_31J), '管');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x4D},WINDOWS_31J), '澤');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x88},WINDOWS_31J), '牛');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x86},WINDOWS_31J), '虫');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x63},WINDOWS_31J), '黄');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x7D},WINDOWS_31J), '填');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x7B},WINDOWS_31J), '雉');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x62},WINDOWS_31J), '滸');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x5D},WINDOWS_31J), '勤');

        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x73},WINDOWS_31J), '洗');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x4E},WINDOWS_31J), '嗚');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x4F},WINDOWS_31J), '烏');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x4A},WINDOWS_31J), '緯');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x78},WINDOWS_31J), '堤');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x50},WINDOWS_31J), '挂');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x71},WINDOWS_31J), '精');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x49},WINDOWS_31J), '堰');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x6E},WINDOWS_31J), '隹');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x68},WINDOWS_31J), '柵');

        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x5E},WINDOWS_31J), '拘');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x55},WINDOWS_31J), '其');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x53},WINDOWS_31J), '完');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x87},WINDOWS_31J), '砲');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x7E},WINDOWS_31J), '徐');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x56},WINDOWS_31J), '希');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x6B},WINDOWS_31J), '汕');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x6C},WINDOWS_31J), '辛');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x5C},WINDOWS_31J), '供');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x54},WINDOWS_31J), '筧');

        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x51},WINDOWS_31J), '枷');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x72},WINDOWS_31J), '赧');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x64},WINDOWS_31J), '交');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x8F},WINDOWS_31J), '窪');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x8E},WINDOWS_31J), '簾');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x8C},WINDOWS_31J), '冷');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x84},WINDOWS_31J), '密');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x77},WINDOWS_31J), '召');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x66},WINDOWS_31J), '国');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x79},WINDOWS_31J), '帝');

        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x81},WINDOWS_31J), '屯');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x74},WINDOWS_31J), '草');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x6F},WINDOWS_31J), '藁');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x60},WINDOWS_31J), '刑');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x85},WINDOWS_31J), '分');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x67},WINDOWS_31J), '乢');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x4B},WINDOWS_31J), '巳');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x76},WINDOWS_31J), '貯');
        toPrintableConvMap.put(new CharByteHolder(new byte[]{(byte)0xF0,(byte)0x57},WINDOWS_31J), '邪');
    }

    public static void toValidString(final Object pBean){

        if(pBean == null){
            return;
        }

        Field[]  fields  = findAllFields(pBean.getClass());
        Method[] methods = findAllMethods(pBean.getClass());

        if(fields == null || methods == null ){
            return;
        }

        for(Field f : fields){
            if(f.isAnnotationPresent(HostInvalidCharacter.class)){
                Method writeMethod = null;
                Method readMethod  = null;
                for (Method method : methods) {

                    if (method.getName().equalsIgnoreCase("set" + f.getName())) {
                        writeMethod = method;
                    }

                    if (method.getName().equalsIgnoreCase("get" + f.getName())) {
                        readMethod = method;
                    }

                    if(writeMethod != null && readMethod != null){
                        try{
                            writeMethod.invoke(pBean,toValidString((String)readMethod.invoke(pBean)));
                        }catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }


    public static void toPrintableString(ReportServicesBean pBean){

        if(pBean == null){
            return;
        }

        for(C_SyoruiCdKbn syoruiCdKbn : pBean.getSyoruiCdKbns()){
            List<IReportDataSouceBean> dsBeanList = pBean.getBeanDataSouceData().get(syoruiCdKbn.getValue());
            if(dsBeanList != null){
                convToPrintableString(dsBeanList);
            }

            Object[] objectArray = pBean.getParamObjectsData().get(syoruiCdKbn.getValue());
            if(objectArray != null){
                convToPrintableString(Arrays.asList(objectArray));
            }

        }

    }

    private static void convToPrintableString(List<?> dsBeanList) {
        for(final Object dsBean : dsBeanList){
            Collection<PropertyDescriptor> stringProps = Collections2.filter(
                Lists.newArrayList(PropertyUtils.getPropertyDescriptors(dsBean.getClass())),
                new Predicate<PropertyDescriptor>() {
                    @Override
                    public boolean apply(PropertyDescriptor pProp) {
                        if (pProp.getPropertyType() == null) {
                            return false;
                        }

                        return
                                String.class.isAssignableFrom(pProp.getPropertyType()) &&
                                PropertyUtils.isReadable (dsBean, pProp.getName()) &&
                                PropertyUtils.isWriteable(dsBean, pProp.getName());
                    }
                }
            );

            for(PropertyDescriptor p : stringProps){
                try{
                    p.getWriteMethod().invoke(dsBean,toPrintableString((String)p.getReadMethod().invoke(dsBean)));
                }catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static String toValidString(String fromString){

        if(Strings.isNullOrEmpty(fromString)){
            return fromString;
        }

        char[] charArray = fromString.toCharArray();

        StringBuilder sb = new StringBuilder();

       for(char c : charArray){
            if(toValidCharConvMap.containsKey(c)){
                sb.append(toValidCharConvMap.get(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static Field[] findAllFields(Class<?> entityClass) {
        Map<String, Field> fields = new HashMap<String, Field>();
        findAllFields(entityClass, fields);
        return fields.values().toArray(new Field[fields.values().size()]);
    }

    private static void findAllFields(Class<?> entityClass, Map<String, Field> fields) {
        if (entityClass == Object.class) {
            return;
        }
        Field[] fs = entityClass.getDeclaredFields();
        for (Field f : fs) {
            if (!fields.containsKey(f.getName())) {
                fields.put(f.getName(), f);
            }
        }
        findAllFields(entityClass.getSuperclass(), fields);
    }


    private static Method[] findAllMethods(Class<?> entityClass) {
        Map<String, Method> methods = new HashMap<String, Method>();
        findAllMethods(entityClass, methods);
        return methods.values().toArray(new Method[methods.values().size()]);
    }

    private static void findAllMethods(Class<?> entityClass, Map<String, Method> methods) {
        if (entityClass == Object.class) {
            return;
        }
        Method[] ms = entityClass.getDeclaredMethods();
        for (Method m : ms) {
            if (!methods.containsKey(m.getName())) {
                methods.put(m.getName(), m);
            }
        }
        findAllMethods(entityClass.getSuperclass(), methods);
    }

    private static String toPrintableString(String fromString){

        if(Strings.isNullOrEmpty(fromString)){
            return fromString;
        }

        char[] charArray = fromString.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(char c : charArray){
            CharByteHolder charByteHolder = new CharByteHolder(c);
            if(toPrintableConvMap.containsKey(charByteHolder)){
                sb.append(toPrintableConvMap.get(charByteHolder));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
