package yuyu.common.biz.bzcommon;


import java.util.Map;

import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import sli.java.lib.RayKanaHenkanChangeSetUtil;

/**
 * 業務共通　カナ名義変換クラス
 */
public class ConvertTestDataForKanaMeigi {

    private static final Logger LOGGER    = LoggerFactory.getLogger(ConvertTestDataForKanaMeigi.class);

    private static final String DAKUON    = "ﾞ";

    private static final String HANDAKUON = "ﾟ";

    private static Map<String, String> getKanaHenkanMap1;

    private static Map<String, String> getKanaHenkanMap2;

    private ConvertTestDataForKanaMeigi() {
        LOGGER.debug("ConvertTestDataForKanaMeigi const start");

        setMap();
        LOGGER.debug("ConvertTestDataForKanaMeigi const end");

    }

    public static ConvertTestDataForKanaMeigi getInstance() {
        return new ConvertTestDataForKanaMeigi();
    }

    public String getKnmeigi(String pHenkanmaeKana) {

        LOGGER.debug("▽ カナ名義変換処理 開始");

        int henkanStartKeta = 0;
        int henkanEndKeta = 0;
        String henkangoKana = "";

        if ( BizUtil.isBlank(pHenkanmaeKana)){
            LOGGER.debug("△79行目");
            LOGGER.debug("△ カナ名義変換処理 終了");
            return henkangoKana;
        }

        if (pHenkanmaeKana == null){
            henkangoKana = "<NULL>";
            return henkangoKana;
        }

        LOGGER.debug("△93行目");

        String henkanmaeKanaHankakuKana = ConvertUtil.toHanAll(pHenkanmaeKana, 0, 1);

        String[] henkanmaeKanas = new String[ henkanmaeKanaHankakuKana.length() ];
        String[] henkangoKanas  = new String[ henkanmaeKanaHankakuKana.length() ];

        for( int i = 0; i <= henkanmaeKanaHankakuKana.length() - 1; i++ ){

            henkanmaeKanas[i] = String.valueOf(henkanmaeKanaHankakuKana.charAt(i));

            henkangoKanas[i]  = String.valueOf(henkanmaeKanaHankakuKana.charAt(i));
        }

        henkanEndKeta= henkanmaeKanaHankakuKana.length() - 1;

        henkangoKanas = convMojiretu(henkanmaeKanas, henkanStartKeta, henkanEndKeta);

        for( int i = 0; i <= henkanmaeKanaHankakuKana.length() - 1; i++ ){
            henkanmaeKanas[i] = henkangoKanas[i];
        }

        if ( (henkanmaeKanaHankakuKana.length() >= 2) && ( (DAKUON.equals(henkanmaeKanas[1])) || (HANDAKUON.equals(henkanmaeKanas[1])) ) ){

            henkanStartKeta = 2;

            if ( (henkanmaeKanaHankakuKana.length() >= 5) && ( (DAKUON.equals(henkanmaeKanas[4])) || (HANDAKUON.equals(henkanmaeKanas[4])) ) ){
                henkanEndKeta = 2;
            }else{
                henkanEndKeta = 3;
            }

        }else{

            henkanStartKeta = 1;

            if ( (henkanmaeKanaHankakuKana.length() >= 4) && ( (DAKUON.equals(henkanmaeKanas[3])) || (HANDAKUON.equals(henkanmaeKanas[3])) ) ){
                henkanEndKeta = 3;
            }else{
                henkanEndKeta = 2;
            }
        }

        LOGGER.debug("△【文字列変換処理】(convMojiretu)開始");
        henkangoKanas = convMojiretu(henkanmaeKanas, henkanStartKeta, henkanEndKeta);
        LOGGER.debug("△【文字列変換処理】(convMojiretu)終了");

        for( int i = 0; i <= henkanmaeKanaHankakuKana.length() - 1; i++ ){
            henkangoKana = henkangoKana.concat(henkangoKanas[i]);
        }

        henkangoKana = ConvertUtil.toZenAll(henkangoKana, 0, 1);

        LOGGER.debug("△ カナ名義変換処理 終了");

        return henkangoKana;
    }

    private void setMap(){

        LOGGER.debug("△カナ変換用マップ設定処理");
        LOGGER.debug("△ロード開始");
        getKanaHenkanMap1 = RayKanaHenkanChangeSetUtil.getKanaHenkanMap1();

        getKanaHenkanMap2 = RayKanaHenkanChangeSetUtil.getKanaHenkanMap2();
        LOGGER.debug("△ロード終了");
    }

    private static String[] convMojiretu(String[] pHenkanmaekana, int pHenkanStartKeta, int pHenkanEndKeta){

        LOGGER.debug("△221行目");

        String[] henkangoKana = new String[pHenkanmaekana.length];
        int counter = pHenkanStartKeta;
        boolean henkanzumiFlg = false;

        LOGGER.debug("△230行目");
        if ( pHenkanmaekana.length < pHenkanEndKeta ){
            return pHenkanmaekana;
        }

        LOGGER.debug("△237行目");
        for( int i = 0; i <= pHenkanmaekana.length - 1 ; i++ ){
            henkangoKana[i] = pHenkanmaekana[i];
        }

        LOGGER.debug("△245行目");
        if (getKanaHenkanMap1 == null){
            LOGGER.debug("getKanaHenkanMap1 is null");
        } else {
            LOGGER.debug("getKanaHenkanMap1 is NOT null");
        }

        if (getKanaHenkanMap2 == null){
            LOGGER.debug("getKanaHenkanMap2 is null");
        } else {
            LOGGER.debug("getKanaHenkanMap2 is NOT null");
        }

        while( (counter <= pHenkanEndKeta) && (counter < pHenkanmaekana.length) ){
            henkanzumiFlg = false;

            LOGGER.debug("counter:"+counter);

            LOGGER.debug("△266行目");
            if( (counter < pHenkanEndKeta) && ( counter + 1 < pHenkanmaekana.length )){

                LOGGER.debug("△269行目");
                LOGGER.debug("henkangoKana[counter]"+henkangoKana[counter]);
                LOGGER.debug("henkangoKana[counter+1]"+henkangoKana[counter+1]);

                if ( getKanaHenkanMap2.containsKey(henkangoKana[counter] + henkangoKana[counter+1]) ){
                    String henkangoMojiretu = getKanaHenkanMap2.get(henkangoKana[counter] + henkangoKana[counter+1]);
                    LOGGER.debug("2文字MAPヒットあり。henkangoMojiretu:"+henkangoMojiretu);

                    henkangoKana[counter] = String.valueOf(henkangoMojiretu.charAt(0));

                    henkangoKana[counter + 1] = String.valueOf(henkangoMojiretu.charAt(1));

                    henkanzumiFlg = true;
                }
            }

            LOGGER.debug("△290行目");
            if ( henkanzumiFlg == false ){
                LOGGER.debug("△294行目");
                if ( getKanaHenkanMap1.containsKey(henkangoKana[counter]) ){

                    LOGGER.debug("1文字MAPヒットあり。henkangoKana[counter]:"+henkangoKana[counter]);

                    String henkangoMojiretu = getKanaHenkanMap1.get(henkangoKana[counter]);

                    henkangoKana[counter] = henkangoMojiretu;

                }else{
                    LOGGER.debug("△307行目");
                    LOGGER.debug("★カナ名義変換に失敗しました。対象文字＝[" + String.valueOf(counter) + "]");
                    LOGGER.debug("★カナ名義変換に失敗しました。対象文字＝[" + henkangoKana[counter] + "]");
                    throw new CommonBizAppException("カナ名義変換に失敗しました。対象文字＝[" + henkangoKana[counter] + "]");
                }
            }else{
                LOGGER.debug("△317行目");
                counter++;
            }

            LOGGER.debug("△322行目");
            counter++;
        }

        LOGGER.debug("△326行目");
        return henkangoKana;
    }
}