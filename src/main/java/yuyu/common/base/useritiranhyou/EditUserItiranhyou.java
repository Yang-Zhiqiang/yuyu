package yuyu.common.base.useritiranhyou;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.base.format.ReportBizDateFormatUtil;
import yuyu.def.classification.C_KyokaKbn;

import com.google.common.base.Strings;

/***
 * ユーザー一覧表 機能の帳票編集クラスです。
 */
public class EditUserItiranhyou {

    public static String editYMD(BizDate pYMD){

        String ymd = null;

        if(pYMD != null){
            ymd = ReportBizDateFormatUtil.toFormatedYmd(pYMD);
        }
        return ymd == null ? "" : ymd;
    }

    public static String editYMDhm(String pYMDhm){

        StringBuffer sbYMDhm = new StringBuffer();
        BizDate ymd = null;

        if(!Strings.isNullOrEmpty(pYMDhm)){

            if ( pYMDhm.length() > 8 ){
                ymd = BizDate.valueOf(pYMDhm.substring(0, 8));
            }
            sbYMDhm.append(ReportBizDateFormatUtil.toFormatedYmd(ymd));
            sbYMDhm.append(" ");
            sbYMDhm.append(pYMDhm.substring(8, 10));
            sbYMDhm.append(":");
            sbYMDhm.append(pYMDhm.substring(10, 12));
        }
        return sbYMDhm.toString() == null ? "" : sbYMDhm.toString();
    }

    public static String editPasswordHenkouKyokaKbn(C_KyokaKbn pPasswordHenkouKyokaKbn){
        return C_KyokaKbn.getContentByValue(C_KyokaKbn.PATTERN_PASSWORD,pPasswordHenkouKyokaKbn.getValue());
    }

    public static String editLoginKyokaKbn(C_KyokaKbn pLoginKyokaKbn){
        return C_KyokaKbn.getContentByValue(C_KyokaKbn.PATTERN_LOGIN,pLoginKyokaKbn.getValue());
    }

    public static String editHoyuuRoleKakuninFlg(boolean pHoyuuRoleKakuninFlg){
        return pHoyuuRoleKakuninFlg ? "*" : "";
    }
}
