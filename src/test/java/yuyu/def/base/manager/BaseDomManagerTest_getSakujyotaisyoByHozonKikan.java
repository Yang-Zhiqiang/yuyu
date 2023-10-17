package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getSakujyotaisyoByHozonKikan() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getSakujyotaisyoByHozonKikan extends AbstractTest {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BaseDomManager baseDomManager;

    @Test
    @Transactional
    public void test001(){

        insertTest001();

        Integer hozonKikan = null;

        List<AS_Sakujyotaisyo> sakujyotaisyoList = baseDomManager.getSakujyotaisyoByHozonKikan(hozonKikan);

        assertEquals(0, sakujyotaisyoList.size());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test002(){

        insertTest001();

        Integer hozonKikan = Integer.parseInt("99");

        List<AS_Sakujyotaisyo> sakujyotaisyoList = baseDomManager.getSakujyotaisyoByHozonKikan(hozonKikan);

        assertEquals(2, sakujyotaisyoList.size());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test003(){

        insertTest001();

        Integer hozonKikan = Integer.parseInt("99");

        List<AS_Sakujyotaisyo> sakujyotaisyoList = baseDomManager.getSakujyotaisyoByHozonKikan(hozonKikan);

        assertEquals(2, sakujyotaisyoList.size());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test004(){

        insertTest002();

        Integer hozonKikan = Integer.parseInt("99");

        List<AS_Sakujyotaisyo> sakujyotaisyoList = baseDomManager.getSakujyotaisyoByHozonKikan(hozonKikan);

        assertEquals(1, sakujyotaisyoList.size());
        assertEquals("TestTable002", sakujyotaisyoList.get(0).getSakujyoTableId());
        assertEquals("98", sakujyotaisyoList.get(0).getHozonKikan().toString());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test005() {

        insertTest002();

        Integer hozonKikan = Integer.parseInt("98");

        List<AS_Sakujyotaisyo> sakujyotaisyoList = baseDomManager.getSakujyotaisyoByHozonKikan(hozonKikan);

        assertEquals(4, sakujyotaisyoList.size());
        assertEquals("TestTable001", sakujyotaisyoList.get(0).getSakujyoTableId());
        assertEquals("99", sakujyotaisyoList.get(0).getHozonKikan().toString());
        assertEquals("TestTable003", sakujyotaisyoList.get(1).getSakujyoTableId());
        assertEquals("99", sakujyotaisyoList.get(0).getHozonKikan().toString());
        assertEquals("TestTable004", sakujyotaisyoList.get(2).getSakujyoTableId());
        assertEquals("99", sakujyotaisyoList.get(0).getHozonKikan().toString());
        assertEquals("TestTable005", sakujyotaisyoList.get(3).getSakujyoTableId());
        assertEquals("99", sakujyotaisyoList.get(0).getHozonKikan().toString());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test06() {

        insertTest003();

        Integer hozonKikan = Integer.parseInt("99");

        List<AS_Sakujyotaisyo> sakujyotaisyoList = baseDomManager.getSakujyotaisyoByHozonKikan(hozonKikan);

        assertEquals(5, sakujyotaisyoList.size());
        assertEquals("TestTable001", sakujyotaisyoList.get(0).getSakujyoTableId());
        assertEquals("TestTable002", sakujyotaisyoList.get(1).getSakujyoTableId());
        assertEquals("TestTable003", sakujyotaisyoList.get(2).getSakujyoTableId());
        assertEquals("TestTable004", sakujyotaisyoList.get(3).getSakujyoTableId());
        assertEquals("TestTable005", sakujyotaisyoList.get(4).getSakujyoTableId());

        deleteTestCommon();

    }
    @Transactional
    private void insertTest001() {

        String sakujyoTableId001 = "TestTable001";
        String sakujyoTableId002 = "TestTable002";
        String sakujyoTableId003 = "TestTable003";
        String sakujyoTableId004 = "TestTable004";
        String sakujyoTableId005 = "TestTable005";

        Integer hozonKikan99 = Integer.parseInt("99");
        Integer hozonKikan98 = Integer.parseInt("98");

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId001) == null) {

            AS_Sakujyotaisyo sakujyotaisyo001 = new AS_Sakujyotaisyo();

            sakujyotaisyo001.setSakujyoTableId(sakujyoTableId001);
            sakujyotaisyo001.setHozonKikan(hozonKikan98);

            baseDomManager.insert(sakujyotaisyo001);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId002) == null) {

            AS_Sakujyotaisyo sakujyotaisyo002 = new AS_Sakujyotaisyo();

            sakujyotaisyo002.setSakujyoTableId(sakujyoTableId002);
            sakujyotaisyo002.setHozonKikan(hozonKikan99);

            baseDomManager.insert(sakujyotaisyo002);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId003) == null) {

            AS_Sakujyotaisyo sakujyotaisyo003 = new AS_Sakujyotaisyo();

            sakujyotaisyo003.setSakujyoTableId(sakujyoTableId003);
            sakujyotaisyo003.setHozonKikan(hozonKikan99);

            baseDomManager.insert(sakujyotaisyo003);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId004) == null) {

            AS_Sakujyotaisyo sakujyotaisyo004 = new AS_Sakujyotaisyo();

            sakujyotaisyo004.setSakujyoTableId(sakujyoTableId004);
            sakujyotaisyo004.setHozonKikan(hozonKikan98);

            baseDomManager.insert(sakujyotaisyo004);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId005) == null) {

            AS_Sakujyotaisyo sakujyotaisyo005 = new AS_Sakujyotaisyo();

            sakujyotaisyo005.setSakujyoTableId(sakujyoTableId005);
            sakujyotaisyo005.setHozonKikan(hozonKikan99);

            baseDomManager.insert(sakujyotaisyo005);

        }

    }

    @Transactional
    private void insertTest002() {

        String sakujyoTableId001 = "TestTable001";
        String sakujyoTableId002 = "TestTable002";
        String sakujyoTableId003 = "TestTable003";
        String sakujyoTableId004 = "TestTable004";
        String sakujyoTableId005 = "TestTable005";

        Integer hozonKikan99 = Integer.parseInt("99");
        Integer hozonKikan98 = Integer.parseInt("98");

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId001) == null) {

            AS_Sakujyotaisyo sakujyotaisyo001 = new AS_Sakujyotaisyo();

            sakujyotaisyo001.setSakujyoTableId(sakujyoTableId001);
            sakujyotaisyo001.setHozonKikan(hozonKikan99);

            baseDomManager.insert(sakujyotaisyo001);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId002) == null) {

            AS_Sakujyotaisyo sakujyotaisyo002 = new AS_Sakujyotaisyo();

            sakujyotaisyo002.setSakujyoTableId(sakujyoTableId002);
            sakujyotaisyo002.setHozonKikan(hozonKikan98);

            baseDomManager.insert(sakujyotaisyo002);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId003) == null) {

            AS_Sakujyotaisyo sakujyotaisyo003 = new AS_Sakujyotaisyo();

            sakujyotaisyo003.setSakujyoTableId(sakujyoTableId003);
            sakujyotaisyo003.setHozonKikan(hozonKikan99);

            baseDomManager.insert(sakujyotaisyo003);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId004) == null) {

            AS_Sakujyotaisyo sakujyotaisyo004 = new AS_Sakujyotaisyo();

            sakujyotaisyo004.setSakujyoTableId(sakujyoTableId004);
            sakujyotaisyo004.setHozonKikan(hozonKikan99);

            baseDomManager.insert(sakujyotaisyo004);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId005) == null) {

            AS_Sakujyotaisyo sakujyotaisyo005 = new AS_Sakujyotaisyo();

            sakujyotaisyo005.setSakujyoTableId(sakujyoTableId005);
            sakujyotaisyo005.setHozonKikan(hozonKikan99);

            baseDomManager.insert(sakujyotaisyo005);

        }

    }

    @Transactional
    private void insertTest003() {

        String sakujyoTableId001 = "TestTable001";
        String sakujyoTableId002 = "TestTable002";
        String sakujyoTableId003 = "TestTable003";
        String sakujyoTableId004 = "TestTable004";
        String sakujyoTableId005 = "TestTable005";

        Integer hozonKikan98 = Integer.parseInt("98");

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId005) == null) {

            AS_Sakujyotaisyo sakujyotaisyo005 = new AS_Sakujyotaisyo();

            sakujyotaisyo005.setSakujyoTableId(sakujyoTableId005);
            sakujyotaisyo005.setHozonKikan(hozonKikan98);

            baseDomManager.insert(sakujyotaisyo005);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId003) == null) {

            AS_Sakujyotaisyo sakujyotaisyo003 = new AS_Sakujyotaisyo();

            sakujyotaisyo003.setSakujyoTableId(sakujyoTableId003);
            sakujyotaisyo003.setHozonKikan(hozonKikan98);

            baseDomManager.insert(sakujyotaisyo003);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId001) == null) {

            AS_Sakujyotaisyo sakujyotaisyo001 = new AS_Sakujyotaisyo();

            sakujyotaisyo001.setSakujyoTableId(sakujyoTableId001);
            sakujyotaisyo001.setHozonKikan(hozonKikan98);

            baseDomManager.insert(sakujyotaisyo001);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId004) == null) {

            AS_Sakujyotaisyo sakujyotaisyo004 = new AS_Sakujyotaisyo();

            sakujyotaisyo004.setSakujyoTableId(sakujyoTableId004);
            sakujyotaisyo004.setHozonKikan(hozonKikan98);

            baseDomManager.insert(sakujyotaisyo004);

        }

        if (baseDomManager.getSakujyotaisyo(sakujyoTableId002) == null) {

            AS_Sakujyotaisyo sakujyotaisyo002 = new AS_Sakujyotaisyo();

            sakujyotaisyo002.setSakujyoTableId(sakujyoTableId002);
            sakujyotaisyo002.setHozonKikan(hozonKikan98);

            baseDomManager.insert(sakujyotaisyo002);

        }

    }

    @Transactional
    private void deleteTestCommon() {

        String sakujyoTableId001 = "TestTable001";
        String sakujyoTableId002 = "TestTable002";
        String sakujyoTableId003 = "TestTable003";
        String sakujyoTableId004 = "TestTable004";
        String sakujyoTableId005 = "TestTable005";

        AS_Sakujyotaisyo sakujyotaisyo001 = baseDomManager.getSakujyotaisyo(sakujyoTableId001);
        AS_Sakujyotaisyo sakujyotaisyo002 = baseDomManager.getSakujyotaisyo(sakujyoTableId002);
        AS_Sakujyotaisyo sakujyotaisyo003 = baseDomManager.getSakujyotaisyo(sakujyoTableId003);
        AS_Sakujyotaisyo sakujyotaisyo004 = baseDomManager.getSakujyotaisyo(sakujyoTableId004);
        AS_Sakujyotaisyo sakujyotaisyo005 = baseDomManager.getSakujyotaisyo(sakujyoTableId005);

        if (sakujyotaisyo001 != null) {

            baseDomManager.delete(sakujyotaisyo001);

        }

        if (sakujyotaisyo002 != null) {

            baseDomManager.delete(sakujyotaisyo002);

        }

        if (sakujyotaisyo003 != null) {

            baseDomManager.delete(sakujyotaisyo003);

        }

        if (sakujyotaisyo004 != null) {

            baseDomManager.delete(sakujyotaisyo004);

        }

        if (sakujyotaisyo005 != null) {

            baseDomManager.delete(sakujyotaisyo005);

        }
    }
}
