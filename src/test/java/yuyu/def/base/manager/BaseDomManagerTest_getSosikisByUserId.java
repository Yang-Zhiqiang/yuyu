package yuyu.def.base.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AM_IdCard;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AT_UserIdKanren;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 操作者所属組織情報取得<br />
 * 組織マスタエンティティ取得（ユーザーＩＤ）のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getSosikisByUserId extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    static String P_USERID_01 = "UID01";
    static String P_USERID_02 = "UID02";
    static String P_USERID_03 = "UID03";
    static String P_USERID_BLANK = "";
    static String P_IDCD_01 = "IDCD01";
    static String P_IDCD_02 = "IDCD02";
    static String P_IDCD_03 = "IDCD03";
    static String P_IDCD_04 = "IDCD04";
    static String P_IDCD_05 = "IDCD05";
    static String P_SOSIKICD_01  = "SSCD01";
    static String P_SOSIKICD_02  = "SSCD02";
    static String P_SOSIKICD_03  = "SSCD03";
    static String P_SOSIKICD_04  = "SSCD04";
    static String P_SOSIKICD_05  = "SSCD05";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        Assert.assertEquals(0, baseDomManager.getSosikisByUserId(P_USERID_01).size());


        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        AT_UserIdKanren userIdKanren1 = new AT_UserIdKanren("01", P_IDCD_01);
        userIdKanren1.setUserId(P_USERID_01);

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.insert(userIdKanren1);

        AT_UserIdKanren userIdKanren2 = new AT_UserIdKanren("02", P_IDCD_01);
        userIdKanren2.setUserId(P_USERID_02);

        baseDomManager.insert(userIdKanren2);

        AT_UserIdKanren userIdKanren3 = new AT_UserIdKanren("02", P_IDCD_02);
        userIdKanren3.setUserId(P_USERID_02);

        baseDomManager.insert(userIdKanren3);

        AT_UserIdKanren userIdKanren4 = new AT_UserIdKanren("02", P_IDCD_03);
        userIdKanren4.setUserId(P_USERID_02);

        baseDomManager.insert(userIdKanren4);

        AT_UserIdKanren userIdKanren5 = new AT_UserIdKanren("02", P_IDCD_04);
        userIdKanren5.setUserId(P_USERID_02);

        baseDomManager.insert(userIdKanren5);

        AT_UserIdKanren userIdKanren6 = new AT_UserIdKanren("03", P_IDCD_03);
        userIdKanren6.setUserId(P_USERID_02);

        baseDomManager.insert(userIdKanren6);

        AT_UserIdKanren userIdKanren7 = new AT_UserIdKanren("02", P_IDCD_05);
        userIdKanren7.setUserId(P_USERID_02);

        baseDomManager.insert(userIdKanren7);

        AM_IdCard idCard1 = new AM_IdCard("01", P_IDCD_01);
        idCard1.setSyozokusosikicd(P_SOSIKICD_01);

        baseDomManager.insert(idCard1);

        AM_IdCard idCard2 = new AM_IdCard("02", P_IDCD_01);
        idCard2.setSyozokusosikicd(P_SOSIKICD_01);

        baseDomManager.insert(idCard2);

        AM_IdCard idCard3 = new AM_IdCard("02", P_IDCD_02);
        idCard3.setSyozokusosikicd(P_SOSIKICD_02);

        baseDomManager.insert(idCard3);

        AM_IdCard idCard4 = new AM_IdCard("02", P_IDCD_03);
        idCard4.setSyozokusosikicd(P_SOSIKICD_03);

        baseDomManager.insert(idCard4);

        AM_IdCard idCard5 = new AM_IdCard("02", P_IDCD_05);
        idCard5.setSyozokusosikicd(P_SOSIKICD_05);

        baseDomManager.insert(idCard5);

        AM_Sosiki sosiki1 = new AM_Sosiki(P_SOSIKICD_01);

        baseDomManager.insert(sosiki1);

        AM_Sosiki sosiki2 = new AM_Sosiki(P_SOSIKICD_02);

        baseDomManager.insert(sosiki2);

        AM_Sosiki sosiki3 = new AM_Sosiki(P_SOSIKICD_03);

        baseDomManager.insert(sosiki3);

        AM_Sosiki sosiki4 = new AM_Sosiki(P_SOSIKICD_04);

        baseDomManager.insert(sosiki4);
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Assert.assertEquals(0, baseDomManager.getSosikisByUserId(P_USERID_03).size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<AM_Sosiki> AM_Sosikis = baseDomManager.getSosikisByUserId(P_USERID_01);

        Assert.assertEquals(1, AM_Sosikis.size());
        Assert.assertEquals(P_SOSIKICD_01, AM_Sosikis.get(0).getSosikicd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<AM_Sosiki> AM_Sosikis = baseDomManager.getSosikisByUserId(P_USERID_02);

        Assert.assertEquals(3, AM_Sosikis.size());
        Assert.assertEquals(P_SOSIKICD_01, AM_Sosikis.get(0).getSosikicd());
        Assert.assertEquals(P_SOSIKICD_02, AM_Sosikis.get(1).getSosikicd());
        Assert.assertEquals(P_SOSIKICD_03, AM_Sosikis.get(2).getSosikicd());
    }

    @Test
    @TestOrder(40)
    public void blank() {

        List<AM_Sosiki> AM_Sosikis = baseDomManager.getSosikisByUserId(P_USERID_BLANK);

        Assert.assertEquals(0, AM_Sosikis.size());
    }

    @Transactional
    public static void deleteTestSubData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        List<AT_UserIdKanren> userIdKanrenList = baseDomManager.getAllUserIdKanrens();
        if(userIdKanrenList.size() > 0){
            baseDomManager.delete(userIdKanrenList);
        }
        List<AM_IdCard> idCardList = baseDomManager.getAllIdCards();
        if(idCardList.size() > 0){
            baseDomManager.delete(idCardList);
        }
        List<AM_Sosiki> sosikiList = baseDomManager.getAllSosikis();
        if(sosikiList.size() > 0){
            baseDomManager.delete(sosikiList);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
