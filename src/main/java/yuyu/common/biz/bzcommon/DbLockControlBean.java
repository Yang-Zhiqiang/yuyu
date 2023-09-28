package yuyu.common.biz.bzcommon;

import java.io.Serializable;

/**
 *  業務共通 共通 DBロック管理ユーティリティBean
 */
public class DbLockControlBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String sCHARSET_DEF  = "Windows-31J";

    private static final int iJOINKEY_MAXSIZE = 100;

    private String sTableId_           = "";

    private StringBuffer  sbJoinKey_   = new StringBuffer();

    private StringBuffer  sbDivNums_   = new StringBuffer();

    private String sCharSet__    = "";

    public void init(String psCharSet){
        sCharSet__ = psCharSet;
    }

    public void setTableId(String psTable){
        sTableId_ = psTable;
    }

    public String getTableId() {
        return sTableId_;
    }

    public void addJoinKey(String psKey) throws Exception{

        String sKey = _editAddstr_Cut(sbJoinKey_.toString(),
            psKey,iJOINKEY_MAXSIZE);

        sbJoinKey_.append(sKey);

        if( sbDivNums_ != null ){

            sbDivNums_.append( sbDivNums_ .length() != 0 ? "," + String.valueOf(sKey.length()) :
                String.valueOf(sKey.length()));
        }
    }

    public String getJoinKey(){
        return sbJoinKey_.toString();
    }

    private String _editAddstr_Cut(String psStr, String psAddStr, int piMaxByte) throws Exception {

        if (psAddStr == null){
            return "";
        }

        if (psStr == null ){
            psStr = "";
        }

        if ((_getStr_ByteLen(psStr + psAddStr)) <= piMaxByte ){
            return psAddStr;
        }

        int iMaxByte = piMaxByte - (_getStr_ByteLen(psStr));


        String sEditStr = psAddStr.substring(0, iMaxByte);
        int iStrLen = sEditStr.length();

        while(_getStr_ByteLen(sEditStr) > iMaxByte) {
            iStrLen--;
            sEditStr = sEditStr.substring(0, iStrLen);
        }

        return sEditStr;
    }

    private int _getStr_ByteLen(String psStr) throws Exception {
        if (sCharSet__ == null) {
            return psStr.getBytes(sCHARSET_DEF).length;
        } else {
            return psStr.getBytes(sCharSet__).length;
        }
    }

}
