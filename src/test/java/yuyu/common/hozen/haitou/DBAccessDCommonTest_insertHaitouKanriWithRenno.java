package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateY;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス 配当管理情報作成（連番自動設定）
 * {@link DBAccessDCommon#insertHaitouKanriWithRenno(IT_KhHaitouKanri)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_insertHaitouKanriWithRenno {

    @Test
    @Transactional
    @TestOrder(10)
    public void testInsertHaitouKanriWithRenno_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri("18808000010", BizDateY.valueOf(2015), 10,
            C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        dbAccessDCommon.insertHaitouKanriWithRenno(khHaitouKanri);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult = hozenDomManager.getKhHaitouKanri("18808000010", BizDateY.valueOf(2015),
            1, C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        assertNotNull(khHaitouKanriResult);
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testInsertHaitouKanriWithRenno_A2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri("18806000025", BizDateY.valueOf(2015), 1,
            C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        dbAccessDCommon.insertHaitouKanriWithRenno(khHaitouKanri);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult = hozenDomManager.getKhHaitouKanri("18806000025", BizDateY.valueOf(2015),
            11, C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        assertNotNull(khHaitouKanriResult);
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testInsertHaitouKanriWithRenno_A3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri("18806000025", BizDateY.valueOf(2016), 10,
            C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        dbAccessDCommon.insertHaitouKanriWithRenno(khHaitouKanri);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult = hozenDomManager.getKhHaitouKanri("18806000025", BizDateY.valueOf(2016),
            1, C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        assertNotNull(khHaitouKanriResult);
    }
}