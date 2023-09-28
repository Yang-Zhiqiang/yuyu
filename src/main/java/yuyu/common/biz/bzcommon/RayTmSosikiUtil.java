package yuyu.common.biz.bzcommon;

import com.google.common.base.Strings;

import yuyu.def.biz.configuration.YuyuBizConfig;

/**
 * 端末設置組織コードに関するユーティリティ
 */
public class RayTmSosikiUtil {

    private static final char TM_SOSIKICD_KYOTENHANTEI_COL4   = '8';

    private static final char TM_SOSIKICD_SITENHANTEI_COL4    = '0';

    private static final String TM_SOSIKICD_SITENHANTEI_TOP3  = "300";

    private static final String TM_SOSIKICD_SITEN               = "2999999";

    public static String getTmSosikiCd(String pTmSosikiCd){

        if(Strings.isNullOrEmpty(pTmSosikiCd)){
            return "";
        }


        if(pTmSosikiCd.length() >= 4 && TM_SOSIKICD_KYOTENHANTEI_COL4 == pTmSosikiCd.charAt(3)){
            return "";
        }


        String top3Cd;

        if(pTmSosikiCd.length() >= 3){
            top3Cd = pTmSosikiCd.substring(0,3);
        }else{
            return "";
        }

        YuyuBizConfig bizConf = YuyuBizConfig.getInstance();

        if( ((TM_SOSIKICD_SITENHANTEI_TOP3.compareTo(top3Cd) > 0 || bizConf.getSisyaAtukaiSosikiCdList().contains(top3Cd)) )
          && (pTmSosikiCd.length() >= 4 && pTmSosikiCd.charAt(3) == TM_SOSIKICD_SITENHANTEI_COL4)
          && !bizConf.getSisyaReigaiSosikiCdList().contains(top3Cd)){
            return TM_SOSIKICD_SITEN;
        }


        if(pTmSosikiCd.length() > 7){
            return pTmSosikiCd.substring(0,7);
        }

        return pTmSosikiCd;

    }
}
