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
 * 契約保全 配当 配当共通ＤＢアクセス 配当管理情報作成
 * {@link DBAccessDCommon#insertHaitouKanri(IT_KhHaitouKanri)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_insertHaitouKanri {

    @Test
    @Transactional
    @TestOrder(10)
    public void testInsertHaitouKanri_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri("18807000017", BizDateY.valueOf(2016), 12,
            C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        dbAccessDCommon.insertHaitouKanri(khHaitouKanri);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult = hozenDomManager.getKhHaitouKanri("18807000017", BizDateY.valueOf(2016),
            12, C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        assertNotNull(khHaitouKanriResult);

    }
}