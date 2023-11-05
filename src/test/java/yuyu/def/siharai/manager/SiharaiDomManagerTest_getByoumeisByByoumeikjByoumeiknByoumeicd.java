package yuyu.def.siharai.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JM_Byoumei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getByoumeisByByoumeikjByoumeiknByoumeicd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getByoumeisByByoumeikjByoumeiknByoumeicd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JM_Byoumei> byoumeiLst = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd("五五","イイ","5");

        Assert.assertEquals(0,byoumeiLst.size());

        JM_Byoumei byoumei1 = new JM_Byoumei("110000");
        byoumei1.setByoumeikj("氏五五氏");
        byoumei1.setByoumeikn("エイイエ");
        byoumei1.setByoumeicd("5666");

        siharaiDomManager.insert(byoumei1);

        JM_Byoumei byoumei2 = new JM_Byoumei("110100");
        byoumei2.setByoumeikj("五氏氏五");
        byoumei2.setByoumeikn("イエエイ");
        byoumei2.setByoumeicd("6555");

        siharaiDomManager.insert(byoumei2);

        JM_Byoumei byoumei3 = new JM_Byoumei("110200");
        byoumei3.setByoumeikj("五");
        byoumei3.setByoumeikn("イ");
        byoumei3.setByoumeicd("5555");

        siharaiDomManager.insert(byoumei3);

        JM_Byoumei byoumei4 = new JM_Byoumei("110300");
        byoumei4.setByoumeikj("氏");
        byoumei4.setByoumeikn("エ");
        byoumei4.setByoumeicd("6666");

        siharaiDomManager.insert(byoumei4);

        JM_Byoumei byoumei5 = new JM_Byoumei("110400");
        byoumei5.setByoumeikj("五五五五");
        byoumei5.setByoumeikn("イイイイ");
        byoumei5.setByoumeicd("5555");

        siharaiDomManager.insert(byoumei5);

        JM_Byoumei byoumei6 = new JM_Byoumei("110500");
        byoumei6.setByoumeikj("氏氏氏氏");
        byoumei6.setByoumeikn("エエエエ");
        byoumei6.setByoumeicd("6666");

        siharaiDomManager.insert(byoumei6);

        JM_Byoumei byoumei7 = new JM_Byoumei("110600");
        byoumei7.setByoumeikj("且丕世丘");
        byoumei7.setByoumeikn("オレラロ");
        byoumei7.setByoumeicd("9001");

        siharaiDomManager.insert(byoumei7);

        JM_Byoumei byoumei8 = new JM_Byoumei("110601");
        byoumei8.setByoumeikj("亜入雨画");
        byoumei8.setByoumeikn("オレラロ");
        byoumei8.setByoumeicd("8001");

        siharaiDomManager.insert(byoumei8);

        JM_Byoumei byoumei9 = new JM_Byoumei("110602");
        byoumei9.setByoumeikj("且丕世丘");
        byoumei9.setByoumeikn("ハヘフホ");
        byoumei9.setByoumeicd("8001");

        siharaiDomManager.insert(byoumei9);

        JM_Byoumei byoumei10 = new JM_Byoumei("110603");
        byoumei10.setByoumeikj("氏氏氏氏");
        byoumei10.setByoumeikn("オレラロ");
        byoumei10.setByoumeicd("8000");

        siharaiDomManager.insert(byoumei10);



    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllByoumei());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JM_Byoumei> byoumeiLst = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd("五五","イイ","8");

        Assert.assertEquals(0,byoumeiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JM_Byoumei> byoumeiLst = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd("丕世","レラ","9");

        Assert.assertEquals(1,byoumeiLst.size());
        Assert.assertEquals("110600", byoumeiLst.get(0).getByoumeitourokuno());
        Assert.assertEquals("且丕世丘", byoumeiLst.get(0).getByoumeikj());
        Assert.assertEquals("オレラロ", byoumeiLst.get(0).getByoumeikn());
        Assert.assertEquals("9001", byoumeiLst.get(0).getByoumeicd());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<JM_Byoumei> byoumeiLst = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd("五五","イイ","5");

        Assert.assertEquals(2,byoumeiLst.size());
        Assert.assertEquals("110400", byoumeiLst.get(0).getByoumeitourokuno());
        Assert.assertEquals("五五五五", byoumeiLst.get(0).getByoumeikj());
        Assert.assertEquals("イイイイ", byoumeiLst.get(0).getByoumeikn());
        Assert.assertEquals("5555", byoumeiLst.get(0).getByoumeicd());

        Assert.assertEquals("110000", byoumeiLst.get(1).getByoumeitourokuno());
        Assert.assertEquals("氏五五氏", byoumeiLst.get(1).getByoumeikj());
        Assert.assertEquals("エイイエ", byoumeiLst.get(1).getByoumeikn());
        Assert.assertEquals("5666", byoumeiLst.get(1).getByoumeicd());
    }

    @Test
    @TestOrder(40)
    public void normal3(){

        List<JM_Byoumei> byoumeiLst = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd("五","イ","5");

        Assert.assertEquals(3,byoumeiLst.size());
        Assert.assertEquals("110200", byoumeiLst.get(0).getByoumeitourokuno());
        Assert.assertEquals("五", byoumeiLst.get(0).getByoumeikj());
        Assert.assertEquals("イ", byoumeiLst.get(0).getByoumeikn());
        Assert.assertEquals("5555", byoumeiLst.get(0).getByoumeicd());

        Assert.assertEquals("110400", byoumeiLst.get(1).getByoumeitourokuno());
        Assert.assertEquals("五五五五", byoumeiLst.get(1).getByoumeikj());
        Assert.assertEquals("イイイイ", byoumeiLst.get(1).getByoumeikn());
        Assert.assertEquals("5555", byoumeiLst.get(1).getByoumeicd());

        Assert.assertEquals("110000", byoumeiLst.get(2).getByoumeitourokuno());
        Assert.assertEquals("氏五五氏", byoumeiLst.get(2).getByoumeikj());
        Assert.assertEquals("エイイエ", byoumeiLst.get(2).getByoumeikn());
        Assert.assertEquals("5666", byoumeiLst.get(2).getByoumeicd());
    }

    @Test
    @TestOrder(50)
    public void blank1() {

        List<JM_Byoumei> byoumeiLst = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd("","レラ","9");

        Assert.assertEquals(1,byoumeiLst.size());
        Assert.assertEquals("110600", byoumeiLst.get(0).getByoumeitourokuno());
        Assert.assertEquals("且丕世丘", byoumeiLst.get(0).getByoumeikj());
        Assert.assertEquals("オレラロ", byoumeiLst.get(0).getByoumeikn());
        Assert.assertEquals("9001", byoumeiLst.get(0).getByoumeicd());
    }

    @Test
    @TestOrder(60)
    public void blank2() {
        List<JM_Byoumei> byoumeiLst1 = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd("丕世","","9");

        Assert.assertEquals(1,byoumeiLst1.size());
        Assert.assertEquals("110600", byoumeiLst1.get(0).getByoumeitourokuno());
        Assert.assertEquals("且丕世丘", byoumeiLst1.get(0).getByoumeikj());
        Assert.assertEquals("オレラロ", byoumeiLst1.get(0).getByoumeikn());
        Assert.assertEquals("9001", byoumeiLst1.get(0).getByoumeicd());
    }

    @Test
    @TestOrder(70)
    public void blank3() {
        List<JM_Byoumei> byoumeiLst2 = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd("丕世","レラ","");

        Assert.assertEquals(1,byoumeiLst2.size());
        Assert.assertEquals("110600", byoumeiLst2.get(0).getByoumeitourokuno());
        Assert.assertEquals("且丕世丘", byoumeiLst2.get(0).getByoumeikj());
        Assert.assertEquals("オレラロ", byoumeiLst2.get(0).getByoumeikn());
        Assert.assertEquals("9001", byoumeiLst2.get(0).getByoumeicd());

    }

    @Test
    @TestOrder(80)
    public void blank4() {
        List<JM_Byoumei> byoumeiLst2 = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd("","","");

        Assert.assertEquals(10,byoumeiLst2.size());
        Assert.assertEquals("110200", byoumeiLst2.get(0).getByoumeitourokuno());
        Assert.assertEquals("五", byoumeiLst2.get(0).getByoumeikj());
        Assert.assertEquals("イ", byoumeiLst2.get(0).getByoumeikn());
        Assert.assertEquals("5555", byoumeiLst2.get(0).getByoumeicd());

        Assert.assertEquals("110400", byoumeiLst2.get(1).getByoumeitourokuno());
        Assert.assertEquals("五五五五", byoumeiLst2.get(1).getByoumeikj());
        Assert.assertEquals("イイイイ", byoumeiLst2.get(1).getByoumeikn());
        Assert.assertEquals("5555", byoumeiLst2.get(1).getByoumeicd());

        Assert.assertEquals("110000", byoumeiLst2.get(2).getByoumeitourokuno());
        Assert.assertEquals("氏五五氏", byoumeiLst2.get(2).getByoumeikj());
        Assert.assertEquals("エイイエ", byoumeiLst2.get(2).getByoumeikn());
        Assert.assertEquals("5666", byoumeiLst2.get(2).getByoumeicd());

        Assert.assertEquals("110100", byoumeiLst2.get(3).getByoumeitourokuno());
        Assert.assertEquals("五氏氏五", byoumeiLst2.get(3).getByoumeikj());
        Assert.assertEquals("イエエイ", byoumeiLst2.get(3).getByoumeikn());
        Assert.assertEquals("6555", byoumeiLst2.get(3).getByoumeicd());

        Assert.assertEquals("110300", byoumeiLst2.get(4).getByoumeitourokuno());
        Assert.assertEquals("氏", byoumeiLst2.get(4).getByoumeikj());
        Assert.assertEquals("エ", byoumeiLst2.get(4).getByoumeikn());
        Assert.assertEquals("6666", byoumeiLst2.get(4).getByoumeicd());

        Assert.assertEquals("110500", byoumeiLst2.get(5).getByoumeitourokuno());
        Assert.assertEquals("氏氏氏氏", byoumeiLst2.get(5).getByoumeikj());
        Assert.assertEquals("エエエエ", byoumeiLst2.get(5).getByoumeikn());
        Assert.assertEquals("6666", byoumeiLst2.get(5).getByoumeicd());

        Assert.assertEquals("110603", byoumeiLst2.get(6).getByoumeitourokuno());
        Assert.assertEquals("氏氏氏氏", byoumeiLst2.get(6).getByoumeikj());
        Assert.assertEquals("オレラロ", byoumeiLst2.get(6).getByoumeikn());
        Assert.assertEquals("8000", byoumeiLst2.get(6).getByoumeicd());

        Assert.assertEquals("110601", byoumeiLst2.get(7).getByoumeitourokuno());
        Assert.assertEquals("亜入雨画", byoumeiLst2.get(7).getByoumeikj());
        Assert.assertEquals("オレラロ", byoumeiLst2.get(7).getByoumeikn());
        Assert.assertEquals("8001", byoumeiLst2.get(7).getByoumeicd());

        Assert.assertEquals("110602", byoumeiLst2.get(8).getByoumeitourokuno());
        Assert.assertEquals("且丕世丘", byoumeiLst2.get(8).getByoumeikj());
        Assert.assertEquals("ハヘフホ", byoumeiLst2.get(8).getByoumeikn());
        Assert.assertEquals("8001", byoumeiLst2.get(8).getByoumeicd());

        Assert.assertEquals("110600", byoumeiLst2.get(9).getByoumeitourokuno());
        Assert.assertEquals("且丕世丘", byoumeiLst2.get(9).getByoumeikj());
        Assert.assertEquals("オレラロ", byoumeiLst2.get(9).getByoumeikn());
        Assert.assertEquals("9001", byoumeiLst2.get(9).getByoumeicd());

    }
}
