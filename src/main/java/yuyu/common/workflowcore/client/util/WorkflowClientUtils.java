package yuyu.common.workflowcore.client.util;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

/**
 * ワークフロークライアント処理のユーティリティです。<br />
 * 業務キー、機能キー、権限キーは、IWFコアに汎用性を持たせるため、<br />
 * 業務個社の対応をできる限りExcutor側に持たせるような作りとしている。<br />
 * 業務キーを例にすると、以下のようになる。
 * <table>
 *     <tr>
 *       <td>
 *         <table width="150px" border="1" cellspacing="0" cellpadding="1">
 *           <tr bgcolor="whitesmoke">
 *             <th>業務APPがExecutorに<br / >渡すとき</th>
 *           </tr>
 *           <tr>
 *             <td>契約番号</td>
 *           </tr>
 *           <tr>
 *             <td>契約連番</td>
 *           </tr>
 *         </table>
 *       </td>
 *       <td>
 *         <table width="15px" >
 *           <tr >
 *             <th >→</th>
 *           </tr>
 *         </table>
 *       </td>
 *       <td>
 *         <table  width="150px" border="1" cellspacing="0" cellpadding="1">
 *           <tr bgcolor="whitesmoke">
 *             <th>ExecutorがIwfClientに<br / >渡すとき</th>
 *           </tr>
 *           <tr>
 *             <td>業務キー配列[要素１]</td>
 *           </tr>
 *           <tr>
 *             <td>業務キー配列[要素２]</td>
 *           </tr>
 *         </table>
 *       </td>
 *       <td>
 *         <table width="15px" >
 *           <tr >
 *             <th >→</th>
 *           </tr>
 *         </table>
 *       </td>
 *       <td>
 *         <table  width="150px" border="1" cellspacing="0" cellpadding="1">
 *           <tr bgcolor="whitesmoke">
 *             <th>IwfClientがIwfCoreに<br / >渡すとき</th>
 *           </tr>
 *           <tr>
 *             <td>業務キー</td>
 *           </tr>
 *         </table>
 *       </td>
 *     </tr>
 * </table>
 */
public class WorkflowClientUtils {

    public static final String sUNKNOWN_FLOW = "UnknownFlow";

    private static Properties oProp__ = null;

    public static String getFlowId(KinouKey kinoukey){

        if(kinoukey == null){
            throw new NullPointerException("機能キーが未設定です。フローIDを取得できません。");

        }
        return getProperty(createNodeid(kinoukey.getKeys()), sUNKNOWN_FLOW);

    }

    public static boolean isExistsIwfFunc(String...keys){

        @SuppressWarnings("synthetic-access")
        String flowid = getFlowId(new KinouKey(keys));

        if(sUNKNOWN_FLOW.equals(flowid)){
            return false;
        }
        else{
            return true;
        }
    }

    public static String createAuthid(String...sKengenKeys){

        return StringUtils.join(sKengenKeys, ".");
    }

    public static String[] createAuthids(List<String[]> poKengenKeyslist){
        ArrayList<String> kengenkeylist = new ArrayList<String>();
        for(String[] inKengenkeys : poKengenKeyslist) {
            kengenkeylist.add(createAuthid(inKengenkeys));
        }
        return kengenkeylist.toArray(new String[0]);
    }

    public static String createNodeid(String...sKinouKeys){

        return StringUtils.join(sKinouKeys, ".");
    }

    public static String createGyoumukey(String...sGyoumuKeys){

        return StringUtils.join(sGyoumuKeys, ".");
    }

    public static String[] toGyoumuKeyArray(String sGyoumuKey){

        return StringUtils.split(sGyoumuKey, ".");
    }

    public static String[] createGyounukeys(List<String[]> psGyoumuKeyslist){
        ArrayList<String> gyoumukeylist = new ArrayList<String>();
        for(String[] inGyoumukeys : psGyoumuKeyslist) {
            gyoumukeylist.add(createGyoumukey(inGyoumukeys));
        }
        return gyoumukeylist.toArray(new String[0]);
    }

    public static String[] toKengenKeyArray(String sKengenKey){

        return StringUtils.split(sKengenKey,".");
    }

    public static class KinouKey{

        private static final long serialVersionUID = 1L;
        private String[] keys_;
        private KinouKey(String ... keys){
            super();
            if(keys != null){
                keys_ = keys;
            }
        }
        public static KinouKey newKinouKey(String ... keys){
            return new KinouKey(keys);
        }
        public String[] getKeys(){
            return keys_;
        }
    }

    @SuppressWarnings("rawtypes")
    public static Class getClassForName(String pClassName) throws Exception {
        if(pClassName == null) {
            throw new Exception("クラス名がnullです。");
        }
        try {
            return Class.forName(pClassName);
        } catch (ClassNotFoundException e) {
            throw new Exception("クラス名が無効です。クラス名：" + pClassName);
        } catch (Exception e) {
            throw new Exception("想定外の例外が発生しました。", e);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Method getMethodForName(Class pClass, String pMethodName) throws Exception{
        if(pClass == null) {
            throw new Exception("クラスオブジェクトがnullです。");
        }
        if(pMethodName == null) {
            throw new Exception("メソッド名がnullです。");
        }
        try {
            return pClass.getMethod(pMethodName);
        } catch (NoSuchMethodException e) {
            throw new Exception("メソッド名が無効です。メソッド名：" + pMethodName);
        } catch (Exception e) {
            throw new Exception("想定外の例外が発生しました。", e);
        }
    }

    public static String getProperty(String psKey, String...sDefault){
        String sProp = oProp__.getProperty(psKey);
        if(StringUtils.isEmpty(sProp)){
            if(sDefault == null || sDefault.length < 1){
                return "";
            }
            return sDefault[0];
        }
        return sProp;
    }
}
