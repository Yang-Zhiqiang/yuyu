package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getSyoruiZokuseiByHozonKikan() メソッドのテストクラスです。
 *
 * ※書類属性マスタ（AM_SyoruiZokusei）のPKキーが書類コードで、書類コードが区分になっている。
 * 書類属性マスタの初期データはすでに登録されているので、書類属性マスタの初期データを退避して確認しないといけない
 * そのため、このテストクラスはコメントアウトとする。
 * ただし、書類属性マスタの初期データを退避してテストを行って確認しました。
 *
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getSyoruiZokuseiByHozonKikan extends AbstractTest {

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

        List<AM_SyoruiZokusei> syoruiZokuseiList = baseDomManager.getSyoruiZokuseiByHozonKikan(hozonKikan);

        assertEquals(0, syoruiZokuseiList.size());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test002(){

        insertTest001();

        Integer hozonKikan = Integer.parseInt("98");

        List<AM_SyoruiZokusei> syoruiZokuseiList = baseDomManager.getSyoruiZokuseiByHozonKikan(hozonKikan);

        assertEquals(2, syoruiZokuseiList.size());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test003(){

        insertTest001();

        Integer hozonKikan = Integer.parseInt("98");

        List<AM_SyoruiZokusei> syoruiZokuseiList = baseDomManager.getSyoruiZokuseiByHozonKikan(hozonKikan);

        assertEquals(2, syoruiZokuseiList.size());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test004(){

        insertTest002();

        Integer hozonKikan = Integer.parseInt("99");

        List<AM_SyoruiZokusei> syoruiZokuseiList = baseDomManager.getSyoruiZokuseiByHozonKikan(hozonKikan);

        assertEquals(1, syoruiZokuseiList.size());
        assertEquals("Ba001", syoruiZokuseiList.get(0).getSyoruiCd().getValue());
        assertEquals("98", syoruiZokuseiList.get(0).getHozonKikan().toString());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test005(){

        insertTest002();

        Integer hozonKikan = Integer.parseInt("98");

        List<AM_SyoruiZokusei> syoruiZokuseiList = baseDomManager.getSyoruiZokuseiByHozonKikan(hozonKikan);

        assertEquals(1, syoruiZokuseiList.size());
        assertEquals("0", syoruiZokuseiList.get(0).getSyoruiCd().getValue());
        assertEquals("99", syoruiZokuseiList.get(0).getHozonKikan().toString());

        deleteTestCommon();

    }

    @Test
    @Transactional
    public void test006(){

        insertTest003();

        Integer hozonKikan = Integer.parseInt("99");

        List<AM_SyoruiZokusei> syoruiZokuseiList = baseDomManager.getSyoruiZokuseiByHozonKikan(hozonKikan);

        assertEquals(2, syoruiZokuseiList.size());
        assertEquals("0", syoruiZokuseiList.get(0).getSyoruiCd().getValue());
        assertEquals("Ba001", syoruiZokuseiList.get(1).getSyoruiCd().getValue());

        deleteTestCommon();

    }

    @Transactional
    private void insertTest001() {

        C_SyoruiCdKbn syoruiCdKbnUseritiranhyou = C_SyoruiCdKbn.USERITIRANHYOU;
        C_SyoruiCdKbn syoruiCdKbnBlnk = C_SyoruiCdKbn.BLNK;

        Integer hozonKikan99 = Integer.parseInt("99");

        if (baseDomManager.getSyoruiZokusei(syoruiCdKbnUseritiranhyou) == null) {

            AM_SyoruiZokusei syoruiZokusei001 = new AM_SyoruiZokusei();

            syoruiZokusei001.setSyoruiCd(syoruiCdKbnUseritiranhyou);
            syoruiZokusei001.setHozonKikan(hozonKikan99);

            baseDomManager.insert(syoruiZokusei001);

        }

        if (baseDomManager.getSyoruiZokusei(syoruiCdKbnBlnk) == null) {

            AM_SyoruiZokusei syoruiZokusei002 = new AM_SyoruiZokusei();

            syoruiZokusei002.setSyoruiCd(syoruiCdKbnBlnk);
            syoruiZokusei002.setHozonKikan(hozonKikan99);

            baseDomManager.insert(syoruiZokusei002);

        }

    }

    @Transactional
    private void insertTest002() {

        C_SyoruiCdKbn syoruiCdKbnUseritiranhyou = C_SyoruiCdKbn.USERITIRANHYOU;
        C_SyoruiCdKbn syoruiCdKbnBlnk = C_SyoruiCdKbn.BLNK;

        Integer hozonKikan99 = Integer.parseInt("99");
        Integer hozonKikan98 = Integer.parseInt("98");

        if (baseDomManager.getSyoruiZokusei(syoruiCdKbnUseritiranhyou) == null) {

            AM_SyoruiZokusei syoruiZokusei001 = new AM_SyoruiZokusei();

            syoruiZokusei001.setSyoruiCd(syoruiCdKbnUseritiranhyou);
            syoruiZokusei001.setHozonKikan(hozonKikan98);

            baseDomManager.insert(syoruiZokusei001);

        }

        if (baseDomManager.getSyoruiZokusei(syoruiCdKbnBlnk) == null) {

            AM_SyoruiZokusei syoruiZokusei002 = new AM_SyoruiZokusei();

            syoruiZokusei002.setSyoruiCd(syoruiCdKbnBlnk);
            syoruiZokusei002.setHozonKikan(hozonKikan99);

            baseDomManager.insert(syoruiZokusei002);

        }

    }

    @Transactional
    private void insertTest003() {

        C_SyoruiCdKbn syoruiCdKbnUseritiranhyou = C_SyoruiCdKbn.USERITIRANHYOU;
        C_SyoruiCdKbn syoruiCdKbnBlnk = C_SyoruiCdKbn.BLNK;

        Integer hozonKikan98 = Integer.parseInt("98");

        if (baseDomManager.getSyoruiZokusei(syoruiCdKbnBlnk) == null) {

            AM_SyoruiZokusei syoruiZokusei002 = new AM_SyoruiZokusei();

            syoruiZokusei002.setSyoruiCd(syoruiCdKbnBlnk);
            syoruiZokusei002.setHozonKikan(hozonKikan98);

            baseDomManager.insert(syoruiZokusei002);

        }

        if (baseDomManager.getSyoruiZokusei(syoruiCdKbnUseritiranhyou) == null) {

            AM_SyoruiZokusei syoruiZokusei001 = new AM_SyoruiZokusei();

            syoruiZokusei001.setSyoruiCd(syoruiCdKbnUseritiranhyou);
            syoruiZokusei001.setHozonKikan(hozonKikan98);

            baseDomManager.insert(syoruiZokusei001);

        }

    }

    @Transactional
    private void deleteTestCommon() {

        C_SyoruiCdKbn syoruiCdKbnUseritiranhyou = C_SyoruiCdKbn.USERITIRANHYOU;
        C_SyoruiCdKbn syoruiCdKbnBlnk = C_SyoruiCdKbn.BLNK;

        AM_SyoruiZokusei syoruiZokusei001 = baseDomManager.getSyoruiZokusei(syoruiCdKbnUseritiranhyou);
        AM_SyoruiZokusei syoruiZokusei002 = baseDomManager.getSyoruiZokusei(syoruiCdKbnBlnk);

        if (syoruiZokusei001 != null) {

            baseDomManager.delete(syoruiZokusei001);

        }

        if (syoruiZokusei002 != null) {

            baseDomManager.delete(syoruiZokusei002);

        }
    }
}
