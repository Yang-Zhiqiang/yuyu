package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス 積立Ｄ管理情報作成（連番自動設定）{@link DBAccessDCommon#insertTumitateDKanriWithRenno(
 * IT_KhTumitateDKanri)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_insertTumitateDKanriWithRenno {

    @Test
    @Transactional
    @TestOrder(10)
    public void testInsertTumitateDKanriWithRenno_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri("18808000010", BizDate.valueOf(20180301), 10);

        dbAccessDCommon.insertTumitateDKanriWithRenno(khTumitateDKanri);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhTumitateDKanri khTumitateDKanriResult = hozenDomManager.getKhTumitateDKanri("18808000010",
            BizDate.valueOf(20180301), 1);

        assertNotNull(khTumitateDKanriResult);
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testInsertTumitateDKanriWithRenno_A2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri("18806000025", BizDate.valueOf(20180301), 10);

        dbAccessDCommon.insertTumitateDKanriWithRenno(khTumitateDKanri);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhTumitateDKanri khTumitateDKanriResult = hozenDomManager.getKhTumitateDKanri("18806000025",
            BizDate.valueOf(20180301), 11);

        assertNotNull(khTumitateDKanriResult);
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testInsertTumitateDKanriWithRenno_A3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri("18806000025", BizDate.valueOf(20180302), 10);

        dbAccessDCommon.insertTumitateDKanriWithRenno(khTumitateDKanri);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhTumitateDKanri khTumitateDKanriResult = hozenDomManager.getKhTumitateDKanri("18806000025",
            BizDate.valueOf(20180302), 1);

        assertNotNull(khTumitateDKanriResult);
    }
}