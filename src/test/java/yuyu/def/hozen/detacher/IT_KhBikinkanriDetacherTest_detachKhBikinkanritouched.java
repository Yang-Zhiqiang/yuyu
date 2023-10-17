package yuyu.def.hozen.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 異動明細情報作成<br />
 * 契約保全備金管理テーブルエンティティリストをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KhBikinkanriDetacherTest_detachKhBikinkanritouched {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_SYONO_01 = "11807111117";
    static String P_SYONO_02 = "11807111118";
    static String P_SYONO_03 = "11807111119";
    static BizDate P_KESSANKIJYUNYMD_01 = BizDate.valueOf("20160101");
    static BizDate P_KESSANKIJYUNYMD_02 = BizDate.valueOf("20160102");
    static BizDate P_KESSANKIJYUNYMD_03 = BizDate.valueOf("20160103");
    static BizDate P_BKNKKTYMD_01 = BizDate.valueOf("20160501");
    static BizDate P_BKNKKTYMD_02 = BizDate.valueOf("20160502");
    static BizDate P_BKNKKTYMD_03 = BizDate.valueOf("20160503");
    static Integer P_RENNO = new Integer(0);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhBikinkanri iT_KhBikinkanri1 = new IT_KhBikinkanri(P_SYONO_01, P_KESSANKIJYUNYMD_01, C_BkncdKbn.SIBOUUKETUKE, P_BKNKKTYMD_01, P_RENNO);

        hozenDomManager.insert(iT_KhBikinkanri1);

        IT_KhBikinkanri iT_KhBikinkanri2 = new IT_KhBikinkanri(P_SYONO_02, P_KESSANKIJYUNYMD_02, C_BkncdKbn.SIBOUKARIUKETUKE, P_BKNKKTYMD_02, P_RENNO);

        hozenDomManager.insert(iT_KhBikinkanri2);

        IT_KhBikinkanri iT_KhBikinkanri3 = new IT_KhBikinkanri(P_SYONO_03, P_KESSANKIJYUNYMD_03, C_BkncdKbn.KOUDOSYOUGAIUKETUKE, P_BKNKKTYMD_03, P_RENNO);

        hozenDomManager.insert(iT_KhBikinkanri3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<IT_KhBikinkanri> iT_KhBikinkanriLst = hozenDomManager.getAllKhBikinkanri();

        List<IT_KhBikinkanri> entityList = IT_KhBikinkanriDetacher.detachKhBikinkanritouched(iT_KhBikinkanriLst);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(IT_KhBikinkanri entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<IT_KhBikinkanri> iT_KhBikinkanriLst = new ArrayList<>();

        iT_KhBikinkanriLst.add(null);
        iT_KhBikinkanriLst.add(null);

        List<IT_KhBikinkanri> entityList = IT_KhBikinkanriDetacher.detachKhBikinkanritouched(iT_KhBikinkanriLst);

        for(IT_KhBikinkanri entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
