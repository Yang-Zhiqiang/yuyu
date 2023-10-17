package yuyu.def.base.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.result.bean.FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AT_FileKengen;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BaseDomManagerクラスの、<br />
 * getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BaseDomManagerTest_getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds {

    @Inject
    BaseDomManager baseDomManager;

    public static String[] userRoleCd1 = {"10004", "10005", "10006"};
    public static String[] userRoleCd2 = {"10001","10002","10003"};
    public static String[] userRoleCd3 = {"10004", "22222"};
    public static String[] userRoleCd4 = {"10004", "10005", "10006", "10007"};
    public static String[] userRoleCd0 = {""};

    public static String[] TanmatusettisosikiRoleCd1 = {"10004","10005","10006"};
    public static String[] TanmatusettisosikiRoleCd2 = {"10001","10002","10003"};
    public static String[] TanmatusettisosikiRoleCd3 = {"10004", "33333"};
    public static String[] TanmatusettisosikiRoleCd4 = {"10004", "10005", "10006", "10007"};
    public static String[] TanmatusettisosikiRoleCd0 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst = baseDomManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(userRoleCd1, TanmatusettisosikiRoleCd1);
        Assert.assertEquals(0, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.size());

        AS_FileSyurui fileSyurui1 = new AS_FileSyurui(C_FileSyuruiCdKbn.SK_KOUKANKYKLST);
        fileSyurui1.setFileSyuruiNm("種類5");

        AT_FileKengen fileKengen1 = fileSyurui1.createFileKengen();
        fileKengen1.setRoleCd("10004");

        baseDomManager.insert(fileSyurui1);

        AS_FileSyurui fileSyurui2 = new AS_FileSyurui(C_FileSyuruiCdKbn.SK_KOUSEIINKYKLST);
        fileSyurui2.setFileSyuruiNm("種類4");

        AT_FileKengen fileKengen2 = fileSyurui2.createFileKengen();
        fileKengen2.setRoleCd("11111");

        baseDomManager.insert(fileSyurui2);

        AS_FileSyurui fileSyurui3 = new AS_FileSyurui(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);
        fileSyurui3.setFileSyuruiNm("種類1");

        baseDomManager.insert(fileSyurui3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileSyuruis());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst = baseDomManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(userRoleCd2, TanmatusettisosikiRoleCd1);
        Assert.assertEquals(0, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.size());
    }

    @Test
    @TestOrder(20)
    public void noResult2() {

        List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst = baseDomManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(userRoleCd1, TanmatusettisosikiRoleCd2);
        Assert.assertEquals(0, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.size());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal1() {

        List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst = baseDomManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(userRoleCd3, TanmatusettisosikiRoleCd3);
        Assert.assertEquals(1, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.size());

        Assert.assertEquals(C_FileSyuruiCdKbn.SK_KOUKANKYKLST, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.get(0).getFileSyuruiCd());
        Assert.assertEquals("種類5", fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.get(0).getFileSyuruiNm());

        baseDomManager.delete(baseDomManager.getAllFileSyuruis());

        AS_FileSyurui fileSyurui1 = new AS_FileSyurui(C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST);
        fileSyurui1.setFileSyuruiNm("種類3");

        AT_FileKengen fileKengen1 = fileSyurui1.createFileKengen();
        fileKengen1.setRoleCd("10004");

        AT_FileKengen fileKengen2 = fileSyurui1.createFileKengen();
        fileKengen2.setRoleCd("10005");

        baseDomManager.insert(fileSyurui1);

        AS_FileSyurui fileSyurui2 = new AS_FileSyurui(C_FileSyuruiCdKbn.SK_HUBIMIKAISYOLST);
        fileSyurui2.setFileSyuruiNm("種類2");

        AT_FileKengen fileKengen3 = fileSyurui2.createFileKengen();
        fileKengen3.setRoleCd("10006");

        baseDomManager.insert(fileSyurui2);

        AS_FileSyurui fileSyurui3 = new AS_FileSyurui(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);
        fileSyurui3.setFileSyuruiNm("種類1");

        AT_FileKengen fileKengen4 = fileSyurui3.createFileKengen();
        fileKengen4.setRoleCd("10007");

        baseDomManager.insert(fileSyurui3);

    }

    @Test
    @TestOrder(40)
    public void normal2() {

        List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst = baseDomManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(userRoleCd4, TanmatusettisosikiRoleCd4);
        Assert.assertEquals(3, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.size());

        Assert.assertEquals(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.get(0).getFileSyuruiCd());
        Assert.assertEquals("種類1", fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.get(0).getFileSyuruiNm());

        Assert.assertEquals(C_FileSyuruiCdKbn.SK_HUBIMIKAISYOLST, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.get(1).getFileSyuruiCd());
        Assert.assertEquals("種類2", fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.get(1).getFileSyuruiNm());

        Assert.assertEquals(C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.get(2).getFileSyuruiCd());
        Assert.assertEquals("種類3", fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.get(2).getFileSyuruiNm());

    }

    @Test
    @TestOrder(50)
    public void blank1() {

        List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst = baseDomManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(userRoleCd0, TanmatusettisosikiRoleCd4);
        Assert.assertEquals(0, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.size());
    }

    @Test
    @TestOrder(60)
    public void blank2() {

        List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst = baseDomManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(userRoleCd4, TanmatusettisosikiRoleCd0);
        Assert.assertEquals(0, fileSyuruisByRoleCdsTanmatusettisosikiRoleCdBeanLst.size());
    }

}


