package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込内容チェック<br />
 * 払込Ｐ単位チェックマスタエンティティリスト取得　主キー範囲のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkHrkPTanisByPK {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkHrkPTani> BM_ChkHrkPTani = bizDomManager.getChkHrkPTanisByPK("01", C_Hrkkaisuu.BLNK, 10,
            C_Channelcd.BLNK, C_Tuukasyu.BLNK);

        Assert.assertFalse(BM_ChkHrkPTani.iterator().hasNext());

        BM_ChkHrkPTani chkHrkPTani1 = new BM_ChkHrkPTani("01", C_Hrkkaisuu.BLNK, 9, 11, C_Channelcd.BLNK, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkHrkPTani1);

        BM_ChkHrkPTani chkHrkPTani2 = new BM_ChkHrkPTani("02", C_Hrkkaisuu.BLNK, 9, 11, C_Channelcd.BLNK, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkHrkPTani2);

        BM_ChkHrkPTani chkHrkPTani3 = new BM_ChkHrkPTani("01", C_Hrkkaisuu.TUKI, 9, 11, C_Channelcd.BLNK, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkHrkPTani3);

        BM_ChkHrkPTani chkHrkPTani4 = new BM_ChkHrkPTani("01", C_Hrkkaisuu.BLNK, 9, 11, C_Channelcd.SMBC, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkHrkPTani4);

        BM_ChkHrkPTani chkHrkPTani5 = new BM_ChkHrkPTani("01", C_Hrkkaisuu.BLNK, 9, 11, C_Channelcd.BLNK, C_Tuukasyu.JPY);

        bizDomManager.insert(chkHrkPTani5);

        BM_ChkHrkPTani chkHrkPTani6 = new BM_ChkHrkPTani("01", C_Hrkkaisuu.BLNK, 11, 11, C_Channelcd.BLNK, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkHrkPTani6);

        BM_ChkHrkPTani chkHrkPTani7 = new BM_ChkHrkPTani("01", C_Hrkkaisuu.BLNK, 9, 9, C_Channelcd.BLNK, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkHrkPTani7);

        BM_ChkHrkPTani chkHrkPTani8 = new BM_ChkHrkPTani("03", C_Hrkkaisuu.HALFY, 5, 6, C_Channelcd.MIZUHO, C_Tuukasyu.USD);

        bizDomManager.insert(chkHrkPTani8);

        BM_ChkHrkPTani chkHrkPTani9 = new BM_ChkHrkPTani("03", C_Hrkkaisuu.HALFY, 6, 7, C_Channelcd.MIZUHO, C_Tuukasyu.USD);

        bizDomManager.insert(chkHrkPTani9);

        BM_ChkHrkPTani chkHrkPTani10 = new BM_ChkHrkPTani("03", C_Hrkkaisuu.HALFY, 6, 6, C_Channelcd.MIZUHO, C_Tuukasyu.USD);

        bizDomManager.insert(chkHrkPTani10);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkHrkPTani());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkHrkPTani> BM_ChkHrkPTani = bizDomManager.getChkHrkPTanisByPK("10", C_Hrkkaisuu.BLNK, 10,
            C_Channelcd.BLNK, C_Tuukasyu.BLNK);

        Assert.assertEquals(0, BM_ChkHrkPTani.size());
    }


    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkHrkPTani> BM_ChkHrkPTani = bizDomManager.getChkHrkPTanisByPK("01", C_Hrkkaisuu.BLNK, 10,
            C_Channelcd.BLNK, C_Tuukasyu.BLNK);

        Assert.assertEquals(1, BM_ChkHrkPTani.size());

        Assert.assertEquals("01", BM_ChkHrkPTani.get(0).getSyouhncd());
        Assert.assertEquals(C_Hrkkaisuu.BLNK, BM_ChkHrkPTani.get(0).getHrkkaisuu());
        Assert.assertEquals(9, BM_ChkHrkPTani.get(0).getSyusyouhnsdnofrom().intValue());
        Assert.assertEquals(11, BM_ChkHrkPTani.get(0).getSyusyouhnsdnoto().intValue());
        Assert.assertEquals(C_Channelcd.BLNK, BM_ChkHrkPTani.get(0).getChannelcd());
        Assert.assertEquals(C_Tuukasyu.BLNK, BM_ChkHrkPTani.get(0).getHrktuukasyu());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkHrkPTani> BM_ChkHrkPTani = bizDomManager.getChkHrkPTanisByPK("03", C_Hrkkaisuu.HALFY, 6,
            C_Channelcd.MIZUHO, C_Tuukasyu.USD);

        Assert.assertEquals(3, BM_ChkHrkPTani.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($("03", C_Hrkkaisuu.HALFY, 5, 6, C_Channelcd.MIZUHO, C_Tuukasyu.USD),"1");
        map.put($("03", C_Hrkkaisuu.HALFY, 6, 6, C_Channelcd.MIZUHO, C_Tuukasyu.USD),"2");
        map.put($("03", C_Hrkkaisuu.HALFY, 6, 7, C_Channelcd.MIZUHO, C_Tuukasyu.USD),"3");

        assertTrue(map.containsKey($(BM_ChkHrkPTani.get(0).getSyouhncd(), BM_ChkHrkPTani.get(0).getHrkkaisuu(), BM_ChkHrkPTani.get(0).getSyusyouhnsdnofrom().intValue(), BM_ChkHrkPTani.get(0).getSyusyouhnsdnoto().intValue(), BM_ChkHrkPTani.get(0).getChannelcd(), BM_ChkHrkPTani.get(0).getHrktuukasyu())));
        assertTrue(map.containsKey($(BM_ChkHrkPTani.get(1).getSyouhncd(), BM_ChkHrkPTani.get(1).getHrkkaisuu(), BM_ChkHrkPTani.get(1).getSyusyouhnsdnofrom().intValue(), BM_ChkHrkPTani.get(1).getSyusyouhnsdnoto().intValue(), BM_ChkHrkPTani.get(1).getChannelcd(), BM_ChkHrkPTani.get(1).getHrktuukasyu())));
        assertTrue(map.containsKey($(BM_ChkHrkPTani.get(2).getSyouhncd(), BM_ChkHrkPTani.get(2).getHrkkaisuu(), BM_ChkHrkPTani.get(2).getSyusyouhnsdnofrom().intValue(), BM_ChkHrkPTani.get(2).getSyusyouhnsdnoto().intValue(), BM_ChkHrkPTani.get(2).getChannelcd(), BM_ChkHrkPTani.get(2).getHrktuukasyu())));

        map.remove($(BM_ChkHrkPTani.get(0).getSyouhncd(), BM_ChkHrkPTani.get(0).getHrkkaisuu(), BM_ChkHrkPTani.get(0).getSyusyouhnsdnofrom().intValue(), BM_ChkHrkPTani.get(0).getSyusyouhnsdnoto().intValue(), BM_ChkHrkPTani.get(0).getChannelcd(), BM_ChkHrkPTani.get(0).getHrktuukasyu()));
        map.remove($(BM_ChkHrkPTani.get(1).getSyouhncd(), BM_ChkHrkPTani.get(1).getHrkkaisuu(), BM_ChkHrkPTani.get(1).getSyusyouhnsdnofrom().intValue(), BM_ChkHrkPTani.get(1).getSyusyouhnsdnoto().intValue(), BM_ChkHrkPTani.get(1).getChannelcd(), BM_ChkHrkPTani.get(1).getHrktuukasyu()));
        map.remove($(BM_ChkHrkPTani.get(2).getSyouhncd(), BM_ChkHrkPTani.get(2).getHrkkaisuu(), BM_ChkHrkPTani.get(2).getSyusyouhnsdnofrom().intValue(), BM_ChkHrkPTani.get(2).getSyusyouhnsdnoto().intValue(), BM_ChkHrkPTani.get(2).getChannelcd(), BM_ChkHrkPTani.get(2).getHrktuukasyu()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BM_ChkHrkPTani> BM_ChkHrkPTani = bizDomManager.getChkHrkPTanisByPK("", C_Hrkkaisuu.BLNK, 10,
            C_Channelcd.BLNK, C_Tuukasyu.BLNK);

        Assert.assertEquals(0, BM_ChkHrkPTani.size());
    }
}

