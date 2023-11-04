package yuyu.common.suuri.srcommon;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 中継用一時保存テーブル削除クラスのメソッド {@link 中継用一時保存テーブル削除#deleteItzHznTable(SrTyukeiyouItzHznSakujyo)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrTyukeiyouItzHznSakujyoTest {


    @Test
    @TestOrder(10)
    @Transactional
    public void testDeleteItzHznTable_A1() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGHAM000");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(11)
    @Transactional
    public void testDeleteItzHznTable_A2() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGHAM001");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(12)
    @Transactional
    public void testDeleteItzHznTable_A3() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGHAM004");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testDeleteItzHznTable_B1() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGHBM000");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void testDeleteItzHznTable_B2() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGHBM001");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(22)
    @Transactional
    public void testDeleteItzHznTable_B3() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGHBM004");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }



    @Test
    @TestOrder(31)
    @Transactional
    public void testDeleteItzHznTable_C1() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGHCM001");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(32)
    @Transactional
    public void testDeleteItzHznTable_C2() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGHCM004");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testDeleteItzHznTable_D1() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGLBM000");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(41)
    @Transactional
    public void testDeleteItzHznTable_D2() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGLBM002");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testDeleteItzHznTable_D3() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGLBM004");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }

    @Test
    @TestOrder(43)
    @Transactional
    public void testDeleteItzHznTable_D4() {
        BzBatchParam batchParam = SWAKInjector.getInstance(BzBatchParam.class);
        batchParam.setIbKakutyoujobcd("RGIXM000");

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(batchParam);

    }



}
