package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

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
 * 契約保全 配当 配当共通ＤＢアクセス 配当管理情報削除
 * {@link DBAccessDCommon#deleteHaitouKanri(List)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_deleteHaitouKanri {

    @Test
    @Transactional
    @TestOrder(10)
    public void testDeleteHaitouKanri_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhHaitouKanri> khHaitouKanriList = new ArrayList<IT_KhHaitouKanri>();

        IT_KhHaitouKanri khHaitouKanri1 = hozenDomManager.getKhHaitouKanri("18806000162", BizDateY.valueOf(2015), 1,
            C_HaitoukinsksKbn.KARIWARIATE1, C_HaitoumeisaiKbn.SYU);

        khHaitouKanriList.add(khHaitouKanri1);

        IT_KhHaitouKanri khHaitouKanri2 = hozenDomManager.getKhHaitouKanri("18806000162", BizDateY.valueOf(2015), 2,
            C_HaitoukinsksKbn.KARIWARIATE1, C_HaitoumeisaiKbn.SYU);

        khHaitouKanriList.add(khHaitouKanri2);

        IT_KhHaitouKanri khHaitouKanri3 = hozenDomManager.getKhHaitouKanri("18806000162", BizDateY.valueOf(2015), 3,
            C_HaitoukinsksKbn.KARIWARIATE1, C_HaitoumeisaiKbn.SYU);

        khHaitouKanriList.add(khHaitouKanri3);

        dbAccessDCommon.deleteHaitouKanri(khHaitouKanriList);

        List<IT_KhHaitouKanri> khHaitouKanriListResult = hozenDomManager.getKhHaitouKanriBySyono("18806000162");

        exNumericEquals(khHaitouKanriListResult.size(), 0, "配当管理ＴＢＬエンティティリスト");

    }

}
