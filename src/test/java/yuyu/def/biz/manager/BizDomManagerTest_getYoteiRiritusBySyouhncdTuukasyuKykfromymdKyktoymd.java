package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金支払<br />
 * 年金情報取込<br />
 * 予定利率マスタエンティティリスト取得(商品コード、通貨種類、契約日)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)

public class BizDomManagerTest_getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd {

    @Inject
    private BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "1111";
    static String P_SYOUHNCD_02 = "1112";
    static String P_SYOUHNCD_03 = "1113";

    @BeforeClass
    @Transactional()
    public static void insertTestData(){

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(P_SYOUHNCD_01, C_Tuukasyu.JPY, BizDate.valueOf(20160331));

        Assert.assertEquals(0,yoteiRirituLst.size());

        BM_YoteiRiritu yoteiRiritu1 = new BM_YoteiRiritu(P_SYOUHNCD_01, C_Tuukasyu.valueOf("USD"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160329), BizDate.valueOf(20160402));

        bizDomManager.insert(yoteiRiritu1);

        BM_YoteiRiritu yoteiRiritu2 = new BM_YoteiRiritu(P_SYOUHNCD_01, C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160329), BizDate.valueOf(20160330));

        bizDomManager.insert(yoteiRiritu2);

        BM_YoteiRiritu yoteiRiritu3 = new BM_YoteiRiritu(P_SYOUHNCD_01, C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160401), BizDate.valueOf(20160402));

        bizDomManager.insert(yoteiRiritu3);

        BM_YoteiRiritu yoteiRiritu4 = new BM_YoteiRiritu(P_SYOUHNCD_01, C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160329), BizDate.valueOf(20160331));

        bizDomManager.insert(yoteiRiritu4);

        BM_YoteiRiritu yoteiRiritu5 = new BM_YoteiRiritu(P_SYOUHNCD_01, C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160329), BizDate.valueOf(20160402));

        bizDomManager.insert(yoteiRiritu5);

        BM_YoteiRiritu yoteiRiritu6 = new BM_YoteiRiritu(P_SYOUHNCD_01, C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160331), BizDate.valueOf(20160402));

        bizDomManager.insert(yoteiRiritu6);

        BM_YoteiRiritu yoteiRiritu7 = new BM_YoteiRiritu(P_SYOUHNCD_02, C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160329), BizDate.valueOf(20160402));

        bizDomManager.insert(yoteiRiritu7);

        BM_YoteiRiritu yoteiRiritu8 = new BM_YoteiRiritu(P_SYOUHNCD_03, C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160329), BizDate.valueOf(20160402));

        bizDomManager.insert(yoteiRiritu8);
    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(P_SYOUHNCD_01, C_Tuukasyu.EUR, BizDate.valueOf(20160331));

        Assert.assertEquals(0,yoteiRirituLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(P_SYOUHNCD_03, C_Tuukasyu.JPY, BizDate.valueOf(20160331));

        Assert.assertEquals(1,yoteiRirituLst.size());

        Assert.assertEquals(P_SYOUHNCD_03, yoteiRirituLst.get(0).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.JPY, yoteiRirituLst.get(0).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160329), yoteiRirituLst.get(0).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20160402), yoteiRirituLst.get(0).getKyktoymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd(P_SYOUHNCD_01, C_Tuukasyu.JPY, BizDate.valueOf(20160331));

        Assert.assertEquals(3,yoteiRirituLst.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_SYOUHNCD_01,C_Tuukasyu.JPY,BizDate.valueOf(20160329),BizDate.valueOf(20160331)), "1");
        map.put($(P_SYOUHNCD_01,C_Tuukasyu.JPY,BizDate.valueOf(20160329),BizDate.valueOf(20160402)), "1");
        map.put($(P_SYOUHNCD_01,C_Tuukasyu.JPY,BizDate.valueOf(20160331),BizDate.valueOf(20160402)), "1");

        for(BM_YoteiRiritu yoteiRiritu : yoteiRirituLst){
            map.remove($(yoteiRiritu.getSyouhncd(),yoteiRiritu.getTuukasyu(),yoteiRiritu.getKykfromymd(),yoteiRiritu.getKyktoymd()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuKykfromymdKyktoymd("", C_Tuukasyu.JPY, BizDate.valueOf(20160331));

        Assert.assertEquals(0,yoteiRirituLst.size());
    }
}
