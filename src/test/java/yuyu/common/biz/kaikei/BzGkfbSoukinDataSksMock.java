package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateTest_exec;
import yuyu.common.siharai.sicommon.SiEditFbTest_exec;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;

/**
 * {@link BzGkfbSoukinDataSks}のモッククラスです。<br />
 */
public class BzGkfbSoukinDataSksMock extends BzGkfbSoukinDataSks {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    @Override
    public JT_SiGaikaFBSoukinData execSi(BzGkfbSoukinDataSksBean pBzGkfbSoukinDataSksBean) {

        if (caller == SiEditFbTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            super.execSi(pBzGkfbSoukinDataSksBean);
            JT_SiGaikaFBSoukinData siGaikaFBSoukinData = SWAKInjector.getInstance(JT_SiGaikaFBSoukinData.class);
            siGaikaFBSoukinData.setFbsoukindatasikibetukey("FB001");
            siGaikaFBSoukinData.setDenrenno("QR0003");
            siGaikaFBSoukinData.setEdano(12);
            siGaikaFBSoukinData.setDensyskbn(C_DensysKbn.HOZEN);
            siGaikaFBSoukinData.setGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
            siGaikaFBSoukinData.setTantositucd(C_Tantositucd.DAIRITENKEIYAKU);
            siGaikaFBSoukinData.setSyoricd("0001");
            siGaikaFBSoukinData.setSyorisosikicd("0004");
            siGaikaFBSoukinData.setSyoriYmd(BizDate.valueOf("20160503"));
            siGaikaFBSoukinData.setDenymd(BizDate.valueOf("20160225"));
            siGaikaFBSoukinData.setSyono("11807111130");
            siGaikaFBSoukinData.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            siGaikaFBSoukinData.setBankcd("9900");
            siGaikaFBSoukinData.setBanknmej("BBS");
            siGaikaFBSoukinData.setSitencd("990");
            siGaikaFBSoukinData.setSitennmej("BBQ");
            siGaikaFBSoukinData.setKouzano("SDR101");
            siGaikaFBSoukinData.setKzmeiginmei("toms");
            siGaikaFBSoukinData.setShrtuukasyu(C_Tuukasyu.JPY);
            siGaikaFBSoukinData.setGaikashrgk(BizCurrency.valueOf(15000));
            siGaikaFBSoukinData.setKyktuukasyu(C_Tuukasyu.USD);
            siGaikaFBSoukinData.setCrossrateshrgk(BizCurrency.valueOf(20000));
            siGaikaFBSoukinData.setSoukinkwsrate(BizNumber.valueOf(9));
            siGaikaFBSoukinData.setGyoumuKousinKinou("dls002");
            siGaikaFBSoukinData.setGyoumuKousinsyaId("dls003");
            siGaikaFBSoukinData.setGyoumuKousinTime("20160218");
            return siGaikaFBSoukinData;
        }
        else if (caller == SiEditFbTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return null;
        }
        return super.execSi(pBzGkfbSoukinDataSksBean);
    }

    @Override
    public IT_KhGaikaFBSoukinData execKh(BzGkfbSoukinDataSksBean pBzGkfbSoukinDataSksBean) {

        if (caller == EditKaiyakuTblUpdateTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                IT_KhGaikaFBSoukinData khGaikaFBSoukinData = new IT_KhGaikaFBSoukinData();
                khGaikaFBSoukinData.setFbsoukindatasikibetukey("2003");
                return khGaikaFBSoukinData;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                IT_KhGaikaFBSoukinData khGaikaFBSoukinData = new IT_KhGaikaFBSoukinData();
                khGaikaFBSoukinData.setFbsoukindatasikibetukey("5005");
                return khGaikaFBSoukinData;
            }
        }
        return super.execKh(pBzGkfbSoukinDataSksBean);
    }
}
