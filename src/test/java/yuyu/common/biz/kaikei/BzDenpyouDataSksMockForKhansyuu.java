package yuyu.common.biz.kaikei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec3;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec5;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.JT_SiDenpyoData;

/**
 * {@link BzDenpyouDataSks}のモッククラスです。<br />
 */
public class BzDenpyouDataSksMockForKhansyuu extends BzDenpyouDataSks {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<HT_SkDenpyoData> execSk(BzSinkeiyakuDenpyouDataTourokuBean pBzSinkeiyakuDenpyouDataTourokuBean) {
        return super.execSk(pBzSinkeiyakuDenpyouDataTourokuBean);
    }

    @Override
    public int getEdano() {
        if (caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec3.class){
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return 10;
            }
        }
        return super.getEdano();
    }

    @Override
    public int getCreditHnknEdano() {
        if (caller == CommonNyuukinTest_exec5.class ||
            caller == CommonNyuukinTest_exec3.class){
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return 10;
            }
        }
        return super.getCreditHnknEdano();
    }

    @Override
    public List<JT_SiDenpyoData> execSi(BzDenpyouDataTourokuBean pBzDenpyouDataTourokuBean) {
        return super.execSi(pBzDenpyouDataTourokuBean);
    }

    @Override
    public List<IT_KhDenpyoData> execKh(BzDenpyouDataTourokuBean pBzDenpyouDataTourokuBean) {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec5.class){
            List<IT_KhDenpyoData> khDenpyoDataList = new ArrayList<>();
            IT_KhDenpyoData khDenpyoData = new IT_KhDenpyoData();
            if (TESTPATTERN1.equals(SYORIPTN)) {
                khDenpyoData.setDenrenno("100001");
                khDenpyoData.setEdano(10);
                khDenpyoData.setDengyoumucd("90001");
                khDenpyoData.setDenymd(BizDate.valueOf(20151231));
                khDenpyoData.setDensyskbn(C_DensysKbn.HOZEN);
                khDenpyoData.setSuitoubumoncd("001");
                khDenpyoDataList.add(khDenpyoData);
                return khDenpyoDataList;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                khDenpyoData.setSyono(pBzDenpyouDataTourokuBean.getIbSyono());
                khDenpyoData.setDenrenno("100001");
                khDenpyoData.setEdano(10);
                khDenpyoData.setDengyoumucd("90001");
                khDenpyoData.setDenymd(BizDate.valueOf(20151231));
                khDenpyoData.setHuridenatesakicd("1234");
                khDenpyoData.setDensyskbn(C_DensysKbn.HOZEN);
                khDenpyoData.setTantocd(C_TantouCdKbn.KAIYAKU);
                khDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                khDenpyoData.setSuitoubumoncd("1234");
                khDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
                khDenpyoData.setDengaikagk(BizCurrency.valueOf(0));
                khDenpyoData.setDenkawaserate(BizNumber.valueOf(0));
                khDenpyoData.setDenyenkagk(BizCurrency.valueOf(0));
                khDenpyoData.setHuridenskskbn(C_HuridensksKbn.BLNK);
                khDenpyoData.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
                khDenpyoData.setDenshrhoukbn(C_DenshrhouKbn.BLNK);
                khDenpyoData.setSyoriYmd(BizDate.valueOf("20160105"));
                khDenpyoData.setSyoricd("RG9F");
                khDenpyoData.setSyorisosikicd("12340000");
                khDenpyoData.setKakokawaserateshiteiflg(false);
                khDenpyoData.setKakokawaserateshiteiymd(null);
                khDenpyoData.setKyktuukasyu(C_Tuukasyu.JPY);
                khDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(0));
                khDenpyoData.setGyoumuKousinsyaId("JUnit");
                khDenpyoData.setSyusyouhncd("001");
                khDenpyoData.setSyouhnsdno(1);
                khDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU);
                khDenpyoDataList.add(khDenpyoData);
                return khDenpyoDataList;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                khDenpyoData.setSyono(pBzDenpyouDataTourokuBean.getIbSyono());
                khDenpyoData.setDenrenno("100001");
                khDenpyoData.setEdano(10);
                khDenpyoData.setDengyoumucd("90001");
                khDenpyoData.setDenymd(BizDate.valueOf(20151231));
                khDenpyoData.setHuridenatesakicd("1234");
                khDenpyoData.setDensyskbn(C_DensysKbn.HOZEN);
                khDenpyoData.setTantocd(C_TantouCdKbn.KAIYAKU);
                khDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                khDenpyoData.setSuitoubumoncd("1234");
                khDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
                khDenpyoData.setDengaikagk(BizCurrency.valueOf(0));
                khDenpyoData.setDenkawaserate(BizNumber.valueOf(0));
                khDenpyoData.setDenyenkagk(BizCurrency.valueOf(0));
                khDenpyoData.setHuridenskskbn(C_HuridensksKbn.BLNK);
                khDenpyoData.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
                khDenpyoData.setDenshrhoukbn(C_DenshrhouKbn.BLNK);
                khDenpyoData.setSyoriYmd(BizDate.valueOf("20160105"));
                khDenpyoData.setSyoricd("RG9F");
                khDenpyoData.setSyorisosikicd("12340000");
                khDenpyoData.setKakokawaserateshiteiflg(false);
                khDenpyoData.setKakokawaserateshiteiymd(null);
                khDenpyoData.setKyktuukasyu(C_Tuukasyu.JPY);
                khDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(0));
                khDenpyoData.setGyoumuKousinsyaId("JUnit");
                khDenpyoData.setSyusyouhncd("001");
                khDenpyoData.setSyouhnsdno(1);
                khDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU);
                khDenpyoDataList.add(khDenpyoData);

                IT_KhDenpyoData khDenpyoData2 = new IT_KhDenpyoData();
                khDenpyoData2.setSyono(pBzDenpyouDataTourokuBean.getIbSyono());
                khDenpyoData2.setDenrenno("100001");
                khDenpyoData2.setEdano(11);
                khDenpyoData2.setDengyoumucd("90001");
                khDenpyoData2.setDenymd(BizDate.valueOf(20151231));
                khDenpyoData2.setHuridenatesakicd("1234");
                khDenpyoData2.setDensyskbn(C_DensysKbn.HOZEN);
                khDenpyoData2.setTantocd(C_TantouCdKbn.KAIYAKU);
                khDenpyoData2.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
                khDenpyoData2.setSuitoubumoncd("1234");
                khDenpyoData2.setTuukasyu(C_Tuukasyu.JPY);
                khDenpyoData2.setDengaikagk(BizCurrency.valueOf(0));
                khDenpyoData2.setDenkawaserate(BizNumber.valueOf(0));
                khDenpyoData2.setDenyenkagk(BizCurrency.valueOf(0));
                khDenpyoData2.setHuridenskskbn(C_HuridensksKbn.BLNK);
                khDenpyoData2.setDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
                khDenpyoData2.setDenshrhoukbn(C_DenshrhouKbn.BLNK);
                khDenpyoData2.setSyoriYmd(BizDate.valueOf("20160105"));
                khDenpyoData2.setSyoricd("RG9F");
                khDenpyoData2.setSyorisosikicd("12340000");
                khDenpyoData2.setKakokawaserateshiteiflg(false);
                khDenpyoData2.setKakokawaserateshiteiymd(null);
                khDenpyoData2.setKyktuukasyu(C_Tuukasyu.JPY);
                khDenpyoData2.setKeiyakutuukagk(BizCurrency.valueOf(0));
                khDenpyoData2.setGyoumuKousinsyaId("JUnit");
                khDenpyoData2.setSyusyouhncd("001");
                khDenpyoData2.setSyouhnsdno(1);
                khDenpyoData2.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_YOHURI);
                khDenpyoDataList.add(khDenpyoData2);
                return khDenpyoDataList;
            }
        }
        return super.execKh(pBzDenpyouDataTourokuBean);
    }

}
