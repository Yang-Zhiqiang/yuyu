package yuyu.batch.suuri.srkessan.srskkessandataretentionperiod;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 新契約決算用データ保存期間管理<br />
 * deleteSkKessanSyukeisBySyoriYmd() メソッドのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SrSkKessanDataRetentionPeriodDaoTest_deleteSkKessanSyukeisBySyoriYmd {

    @Inject
    private SrSkKessanDataRetentionPeriodDao ｓrSkKessanDataRetentionPeriodDao;
    @Inject
    private SuuriDomManager suuriDomManager;

    public static BizDate P_SYORIYMD_01 = BizDate.valueOf("20160630");
    public static BizDate P_SYORIYMD_02 = BizDate.valueOf("20160701");
    public static BizDate P_SYORIYMD_03 = BizDate.valueOf("20160702");
    public static BizDate P_SYORIYMD_04 = BizDate.valueOf("20160703");
    public static BizDate P_SYORIYMD_05 = BizDate.valueOf("20160704");


    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        SrSkKessanDataRetentionPeriodDao ｓrSkKessanDataRetentionPeriodDao = SWAKInjector.getInstance(SrSkKessanDataRetentionPeriodDao.class);

        assertEquals(0, ｓrSkKessanDataRetentionPeriodDao.deleteSkKessanSyukeisBySyoriYmd(P_SYORIYMD_03));
        assertEquals(0, suuriDomManager.getAllSkKessanSyukei().size());

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        SrSkKessanDataRetentionPeriodDao ｓrSkKessanDataRetentionPeriodDao = SWAKInjector.getInstance(SrSkKessanDataRetentionPeriodDao.class);

        ST_SkKessanSyukei skKessanSyukei1 = new ST_SkKessanSyukei("791112220", BizDate.valueOf(0001), C_Kanjyoukmkcd.BLNK, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei1.setSyoriYmd(P_SYORIYMD_01);

        suuriDomManager.insert(skKessanSyukei1);

        ST_SkKessanSyukei skKessanSyukei2 = new ST_SkKessanSyukei("791112238", BizDate.valueOf(0002), C_Kanjyoukmkcd.BLNK, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei2.setSyoriYmd(P_SYORIYMD_02);

        suuriDomManager.insert(skKessanSyukei2);

        ST_SkKessanSyukei skKessanSyukei3 = new ST_SkKessanSyukei("791112246", BizDate.valueOf(0003), C_Kanjyoukmkcd.BLNK, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei3.setSyoriYmd(P_SYORIYMD_03);

        suuriDomManager.insert(skKessanSyukei3);

        ST_SkKessanSyukei skKessanSyukei4 = new ST_SkKessanSyukei("791112253", BizDate.valueOf(0004), C_Kanjyoukmkcd.BLNK, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei4.setSyoriYmd(P_SYORIYMD_04);

        suuriDomManager.insert(skKessanSyukei4);

        ST_SkKessanSyukei skKessanSyukei5 = new ST_SkKessanSyukei("791112261", BizDate.valueOf(0005), C_Kanjyoukmkcd.BLNK, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei5.setSyoriYmd(P_SYORIYMD_05);

        suuriDomManager.insert(skKessanSyukei5);

    }

    @Test
    @TestOrder(10)
    public void normal1() {

        assertEquals(5, suuriDomManager.getAllSkKessanSyukei().size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        assertEquals(2, ｓrSkKessanDataRetentionPeriodDao.deleteSkKessanSyukeisBySyoriYmd(P_SYORIYMD_03));
    }

    @Test
    @TestOrder(30)
    public void normal3() {

        assertEquals(3, suuriDomManager.getAllSkKessanSyukei().size());
    }

    @Transactional
    public static void deleteTestSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        List<ST_SkKessanSyukei> skKessanSyukeiList = suuriDomManager.getAllSkKessanSyukei();
        if(skKessanSyukeiList.size() > 0){
            suuriDomManager.delete(skKessanSyukeiList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
