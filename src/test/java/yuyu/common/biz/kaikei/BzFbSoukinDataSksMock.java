package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateTest_exec;
import yuyu.common.siharai.sicommon.SiEditFbTest_exec;
import yuyu.common.sinkeiyaku.skcommon.HenkinTest_exec;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.JT_SiFBSoukinData;

/**
 * {@link BzFbSoukinDataSks}のモッククラスです。<br />
 */
public class BzFbSoukinDataSksMock extends BzFbSoukinDataSks {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public JT_SiFBSoukinData execSi(BzFbSoukinDataSksBean pBzFbSoukinDataSksBean) {
        super.execSi(pBzFbSoukinDataSksBean);

        if (caller == SiEditFbTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            JT_SiFBSoukinData siFBSoukinData = new JT_SiFBSoukinData();
            siFBSoukinData.setFbsoukindatasikibetukey("FB001");
            siFBSoukinData.setDenrenno("QR0001");
            siFBSoukinData.setEdano(10);
            siFBSoukinData.setDensyskbn(C_DensysKbn.HKSIHARAI);
            siFBSoukinData.setGyoumucd(C_Gyoumucd.SKFUSEIRITUPHENKIN);
            siFBSoukinData.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
            siFBSoukinData.setSyoricd("0001");
            siFBSoukinData.setSyorisosikicd("0002");
            siFBSoukinData.setSyoriYmd(BizDate.valueOf("20160218"));
            siFBSoukinData.setDenymd(BizDate.valueOf("20160222"));
            siFBSoukinData.setSyono("11807111118");
            siFBSoukinData.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            siFBSoukinData.setBankcd("QQ101");
            siFBSoukinData.setSitencd("QR101");
            siFBSoukinData.setYokinkbn(C_YokinKbn.HUTUU);
            siFBSoukinData.setKouzano("SDR101");
            siFBSoukinData.setKzmeiginmkn("加奈欄");
            siFBSoukinData.setSoukingk(BizCurrency.valueOf(10000));
            siFBSoukinData.setKyktuukasyu(C_Tuukasyu.JPY);
            siFBSoukinData.setGaikataikagk(BizCurrency.valueOf(20000));
            siFBSoukinData.setSoukinkwsrate(BizNumber.valueOf(9));
            siFBSoukinData.setGyoumuKousinKinou("dls002");
            siFBSoukinData.setGyoumuKousinsyaId("dls003");
            siFBSoukinData.setGyoumuKousinTime("20160218");
            return siFBSoukinData;
        }
        else if (caller == SiEditFbTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return null;
        }
        return super.execSi(pBzFbSoukinDataSksBean);
    }

    @Override
    public HT_SkFBSoukinData execSk(BzFbSoukinDataSksBean pBzFbSoukinDataSksBean) {

        if (caller == HenkinTest_exec.class) {
            HT_SkFBSoukinData skFBSoukinData = new HT_SkFBSoukinData();
            skFBSoukinData.setFbsoukindatasikibetukey("FB001");
            return skFBSoukinData;
        }
        return super.execSk(pBzFbSoukinDataSksBean);
    }

    @Override
    public IT_KhFBSoukinData execKh(BzFbSoukinDataSksBean pBzFbSoukinDataSksBean) {

        if(caller == EditKaiyakuTblUpdateTest_exec.class){
            IT_KhFBSoukinData khFBSoukinData = new IT_KhFBSoukinData();
            if (TESTPATTERN1.equals(SYORIPTN)) {
                khFBSoukinData.setFbsoukindatasikibetukey("2002");
                return khFBSoukinData;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                khFBSoukinData.setFbsoukindatasikibetukey("4004");
                return khFBSoukinData;
            }
        }
        return super.execKh(pBzFbSoukinDataSksBean);
    }

}
