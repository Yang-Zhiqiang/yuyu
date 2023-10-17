package yuyu.def.hozen.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ダイレクトサービス共通DBアクセス<br />
 * 契約基本テーブルエンティティリスト取得(処理年月日FROM、処理年月日TO)<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KykKihon> iT_KykKihonLst = hozenDomManager.
                getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(BizDate.valueOf("20160202"), BizDate.valueOf("20160202"));

        Assert.assertEquals(0,iT_KykKihonLst.size());

        IT_KykKihon iT_KykKihon = null;
        List<String> syonos = getSyonosBySome("11", "807", "1", 506);
        int iCount = syonos.size();
        for (int i = iCount - 1; i >= 0; i--) {

            iT_KykKihon = new IT_KykKihon(syonos.get(i));
            iT_KykKihon.setSeirituymd(BizDate.valueOf("20160105"));
            iT_KykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);

            if (i == 1) {

                iT_KykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            } else if (i == 2) {

                iT_KykKihon.setSeirituymd(BizDate.valueOf("20160101"));
            } else if (i == 3) {

                iT_KykKihon.setSeirituymd(BizDate.valueOf("20160106"));
            } else if (i == 4) {

                iT_KykKihon.setSeirituymd(BizDate.valueOf("20160102"));
            } else if (i == 5) {

                iT_KykKihon.setSeirituymd(BizDate.valueOf("20160103"));
            } else if (i == 6) {

                iT_KykKihon.setSeirituymd(BizDate.valueOf("20160104"));
            }

            if (i != 0) {

                iT_KykKihon.createKykSya();
            }

            hozenDomManager.insert(iT_KykKihon);
        }
    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KykKihon> iT_KykKihonLst = hozenDomManager.
                getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(BizDate.valueOf("20160109"), BizDate.valueOf("20160110"));

        Assert.assertEquals(0, iT_KykKihonLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KykKihon> iT_KykKihonLst = hozenDomManager.
                getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(BizDate.valueOf("20160102"), BizDate.valueOf("20160102"));

        Assert.assertEquals(1, iT_KykKihonLst.size());

        Assert.assertEquals("11807000054", iT_KykKihonLst.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf("20160102"), iT_KykKihonLst.get(0).getSeirituymd());
        Assert.assertEquals(C_DirectServiceMosKbn.CHECK, iT_KykKihonLst.get(0).getDrctservicemoskbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KykKihon> iT_KykKihonLst = hozenDomManager.
                getKykKihonsByDrctservicemoskbnSyoriYmdFromSyoriYmdToROWNUM(BizDate.valueOf("20160102"), BizDate.valueOf("20160105"));

        Assert.assertEquals(501, iT_KykKihonLst.size());

        List<String> syonos = getSyonosBySome("11", "807", "1", 506);
        int iCount = syonos.size();
        int iIndex = 0;
        IT_KykKihon iT_KykKihon = null;
        for (int i = 4; i < iCount; i++) {

            if (i == 505) {

                return;
            }

            iIndex = i - 4;
            iT_KykKihon = iT_KykKihonLst.get(iIndex);

            Assert.assertEquals(syonos.get(i), iT_KykKihon.getSyono());
            Assert.assertEquals(C_DirectServiceMosKbn.CHECK, iT_KykKihon.getDrctservicemoskbn());

            if (iIndex == 0) {

                Assert.assertEquals(BizDate.valueOf("20160102"), iT_KykKihon.getSeirituymd());
            } else if (iIndex == 1) {

                Assert.assertEquals(BizDate.valueOf("20160103"), iT_KykKihon.getSeirituymd());
            } else if (iIndex == 2) {

                Assert.assertEquals(BizDate.valueOf("20160104"), iT_KykKihon.getSeirituymd());
            } else {

                Assert.assertEquals(BizDate.valueOf("20160105"), iT_KykKihon.getSeirituymd());
            }
        }
    }

    public static List<String> getSyonosBySome(String pKey1, String pKey2, String pKey3, int pCount) {

        Integer[] arrWeights = new Integer[] {3, 1, 3, 1, 3, 1, 3, 1, 3, 1};
        String strDigit = "";
        Long lTempDigit = 0L;
        Integer ISum = 0;
        List<String> syonos = new ArrayList<>();
        String strKey3 = pKey3;
        while(strKey3.length() < 5) {
            strKey3 = "0" + strKey3;
        }

        String strDigittemp = "10" + strKey3;
        lTempDigit = Long.parseLong(strDigittemp);

        for(int i = 1; i <= pCount; i++) {

            strDigit = pKey1 + pKey2 + strDigittemp.substring(strDigittemp.length() - 5, strDigittemp.length());
            ISum = 0;
            for(int j = 0; j < strDigit.length(); j++) {
                Integer a = Integer.parseInt(strDigit.substring(j, j + 1)) ;
                ISum = ISum + a * arrWeights[j];
            }
            ISum = ISum % 10;
            lTempDigit = lTempDigit + 1;
            if(lTempDigit > 1079989) {
                lTempDigit = new Long(1000000);
            }
            strDigittemp = String.valueOf(lTempDigit);
            syonos.add(strDigit + ISum);
        }

        return syonos;
    }
}
