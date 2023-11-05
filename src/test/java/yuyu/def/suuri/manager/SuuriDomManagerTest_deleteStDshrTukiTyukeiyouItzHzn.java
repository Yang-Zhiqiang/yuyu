package yuyu.def.suuri.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * deleteStDshrTukiTyukeiyouItzHzn メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_deleteStDshrTukiTyukeiyouItzHzn {

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Transactional
    public static void insertTestData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        ST_DshrTukiTyukeiyouItzHzn dshrTukiTyukeiyouItzHzn1 = new ST_DshrTukiTyukeiyouItzHzn();
        dshrTukiTyukeiyouItzHzn1.setZtysequenceno(12345678);

        suuriDomManager.insert(dshrTukiTyukeiyouItzHzn1);

        ST_DshrTukiTyukeiyouItzHzn dshrTukiTyukeiyouItzHzn2 = new ST_DshrTukiTyukeiyouItzHzn();
        dshrTukiTyukeiyouItzHzn2.setZtysequenceno(12345679);

        suuriDomManager.insert(dshrTukiTyukeiyouItzHzn2);

        ST_DshrTukiTyukeiyouItzHzn dshrTukiTyukeiyouItzHzn3 = new ST_DshrTukiTyukeiyouItzHzn();
        dshrTukiTyukeiyouItzHzn3.setZtysequenceno(12345680);

        suuriDomManager.insert(dshrTukiTyukeiyouItzHzn3);

        ST_DshrTukiTyukeiyouItzHzn dshrTukiTyukeiyouItzHzn4 = new ST_DshrTukiTyukeiyouItzHzn();
        dshrTukiTyukeiyouItzHzn4.setZtysequenceno(12345681);

        suuriDomManager.insert(dshrTukiTyukeiyouItzHzn4);

        ST_DshrTukiTyukeiyouItzHzn dshrTukiTyukeiyouItzHzn5 = new ST_DshrTukiTyukeiyouItzHzn();
        dshrTukiTyukeiyouItzHzn5.setZtysequenceno(12345682);

        suuriDomManager.insert(dshrTukiTyukeiyouItzHzn5);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        srCommonKinouDao.deleteStDshrTukiTyukeiyouItzHzn();

        assertEquals(0, suuriDomManager.getAllDshrTukiTyukeiyouItzHzn().size());
    }
}
