package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

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
 * 契約保全 配当 配当共通ＤＢアクセス 積立Ｄ管理情報削除
 * {@link DBAccessDCommon#deleteTumitateDKanri(List)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_deleteTumitateDKanri {

    @Test
    @Transactional
    @TestOrder(10)
    public void testDeleteTumitateDKanri_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhTumitateDKanri> khTumitateDKanriList = new ArrayList<IT_KhTumitateDKanri>();

        IT_KhTumitateDKanri khTumitateDKanri1 = hozenDomManager.getKhTumitateDKanri("18806000139",
            BizDate.valueOf(20180831), 1);

        khTumitateDKanriList.add(khTumitateDKanri1);

        IT_KhTumitateDKanri khTumitateDKanri2 = hozenDomManager.getKhTumitateDKanri("18806000139",
            BizDate.valueOf(20180831), 2);

        khTumitateDKanriList.add(khTumitateDKanri2);

        IT_KhTumitateDKanri khTumitateDKanri3 = hozenDomManager.getKhTumitateDKanri("18806000139",
            BizDate.valueOf(20180831), 3);

        khTumitateDKanriList.add(khTumitateDKanri3);

        dbAccessDCommon.deleteTumitateDKanri(khTumitateDKanriList);

        List<IT_KhTumitateDKanri> khTumitateDKanriListResult = hozenDomManager.getKhTumitateDKanriBySyono("18806000139");

        exNumericEquals(khTumitateDKanriListResult.size(), 0, "配当管理ＴＢＬエンティティリスト");

    }

}
