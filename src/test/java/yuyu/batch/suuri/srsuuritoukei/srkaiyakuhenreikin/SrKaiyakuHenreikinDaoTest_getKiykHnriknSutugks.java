package yuyu.batch.suuri.srsuuritoukei.srkaiyakuhenreikin;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.suuri.srsuuritoukei.srkaiyakuhenreikin.SrKaiyakuHenreikinDao;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 解約返戻金相当額情報作成<br />
 * getKiykHnriknSutugks() メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SrKaiyakuHenreikinDaoTest_getKiykHnriknSutugks {

    @Inject
    private SrKaiyakuHenreikinDao srKaiyakuHenreikinDao;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111131";

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        SrKaiyakuHenreikinDao srKaiyakuHenreikinDao = SWAKInjector.getInstance(SrKaiyakuHenreikinDao.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try(ExDBResults<SV_KiykHnriknSutugk> beans =
            srKaiyakuHenreikinDao.getKiykHnriknSutugks("")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", P_SYONO_01);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("01", P_SYONO_02);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("01", P_SYONO_03);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void normal1(){

        try(ExDBResults<SV_KiykHnriknSutugk> beans =
            srKaiyakuHenreikinDao.getKiykHnriknSutugks("")) {

            int iCount = 0;
            Iterator<SV_KiykHnriknSutugk> iter = beans.iterator();
            SV_KiykHnriknSutugk sV_KiykHnriknSutugk = null;
            while (iter.hasNext()) {

                sV_KiykHnriknSutugk = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(P_SYONO_01, sV_KiykHnriknSutugk.getSyono());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_SYONO_02, sV_KiykHnriknSutugk.getSyono());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_SYONO_03, sV_KiykHnriknSutugk.getSyono());

                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
        }
    }
}
