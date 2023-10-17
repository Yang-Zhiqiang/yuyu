package yuyu.def.biz.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.entity.AT_FileSansyoKaisu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

/**
 * BizDomManagerクラスの、<br />
 * getFileHozonInfosByFileSyuruiCd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getFileHozonInfosByFileSyuruiCd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<AT_FileHozonInfo> fileHozonInfoLst = bizDomManager.getFileHozonInfosByFileSyuruiCd(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);
        Assert.assertEquals(0,fileHozonInfoLst.size());

        AS_FileSyurui fileSyurui1 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk001"));

        baseDomManager.insert(fileSyurui1);

        AS_FileSyurui fileSyurui2 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk002"));

        baseDomManager.insert(fileSyurui2);

        AS_FileSyurui fileSyurui3 = new AS_FileSyurui(C_FileSyuruiCdKbn.valueOf("Sk003"));

        baseDomManager.insert(fileSyurui3);

        AT_FileHozonInfo fileHozonInfo1 = new AT_FileHozonInfo("User001");
        fileHozonInfo1.setFileSyuruiCd(C_FileSyuruiCdKbn.valueOf("Sk001"));
        fileHozonInfo1.setTourokuTime("20160202");

        AT_FileSansyoKaisu fileSansyoKaisu1 = fileHozonInfo1.createFileSansyoKaisu();

        baseDomManager.insert(fileHozonInfo1);

        AT_FileHozonInfo fileHozonInfo2 = new AT_FileHozonInfo("User002");
        fileHozonInfo2.setFileSyuruiCd(C_FileSyuruiCdKbn.valueOf("Sk002"));
        fileHozonInfo2.setTourokuTime("20160201");

        baseDomManager.insert(fileHozonInfo2);

        AT_FileHozonInfo fileHozonInfo3 = new AT_FileHozonInfo("User003");
        fileHozonInfo3.setFileSyuruiCd(C_FileSyuruiCdKbn.valueOf("Sk002"));
        fileHozonInfo3.setTourokuTime("20160202");

        baseDomManager.insert(fileHozonInfo3);

        AT_FileHozonInfo fileHozonInfo4 = new AT_FileHozonInfo("User004");
        fileHozonInfo4.setFileSyuruiCd(C_FileSyuruiCdKbn.valueOf("Sk002"));
        fileHozonInfo4.setTourokuTime("20160203");

        baseDomManager.insert(fileHozonInfo4);

        AT_FileHozonInfo fileHozonInfo5 = new AT_FileHozonInfo("User005");
        fileHozonInfo5.setFileSyuruiCd(C_FileSyuruiCdKbn.valueOf("Sk003"));
        fileHozonInfo5.setTourokuTime("20160203");

        baseDomManager.insert(fileHozonInfo5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileHozonInfo());
        baseDomManager.delete(baseDomManager.getAllFileSyuruis());
    }

    @Test
    @TestOrder(30)
    public void noResult1(){

        List<AT_FileHozonInfo> fileHozonInfoLst = bizDomManager.getFileHozonInfosByFileSyuruiCd(C_FileSyuruiCdKbn.SK_KOUSEIINKYKLST);
        Assert.assertEquals(0,fileHozonInfoLst.size());
    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<AT_FileHozonInfo> fileHozonInfoLst = bizDomManager.getFileHozonInfosByFileSyuruiCd(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);
        Assert.assertEquals(1,fileHozonInfoLst.size());
        Assert.assertEquals("User001", fileHozonInfoLst.get(0).getUniqueId());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<AT_FileHozonInfo> fileHozonInfoLst = bizDomManager.getFileHozonInfosByFileSyuruiCd(C_FileSyuruiCdKbn.SK_HUBIMIKAISYOLST);
        Assert.assertEquals(3,fileHozonInfoLst.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($("User002"), "1");
        map.put($("User003"), "1");
        map.put($("User004"), "1");

        assertTrue(map.containsKey($(fileHozonInfoLst.get(0).getUniqueId())));
        assertTrue(map.containsKey($(fileHozonInfoLst.get(1).getUniqueId())));
        assertTrue(map.containsKey($(fileHozonInfoLst.get(2).getUniqueId())));

        map.remove($(fileHozonInfoLst.get(0).getUniqueId()));
        map.remove($(fileHozonInfoLst.get(1).getUniqueId()));
        map.remove($(fileHozonInfoLst.get(2).getUniqueId()));

        assertTrue(map.isEmpty());
    }
}