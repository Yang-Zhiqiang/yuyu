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
 * 契約保全 配当 配当共通ＤＢアクセス 積立Ｄ管理情報作成{@link DBAccessDCommon#insertTumitateDKanri(
 * IT_KhTumitateDKanri)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_insertTumitateDKanri {

    @Test
    @Transactional
    @TestOrder(10)
    public void testInsertTumitateDKanri_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri("18807000017", BizDate.valueOf(20181120), 12);

        dbAccessDCommon.insertTumitateDKanri(khTumitateDKanri);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhTumitateDKanri khTumitateDKanriResult = hozenDomManager.getKhTumitateDKanri(
            "18807000017", BizDate.valueOf(20181120), 12);

        assertNotNull(khTumitateDKanriResult);
    }
}