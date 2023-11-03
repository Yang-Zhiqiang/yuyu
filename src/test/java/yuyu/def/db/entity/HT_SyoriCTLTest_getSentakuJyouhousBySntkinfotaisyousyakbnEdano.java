package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 処理コントロールテーブルエンティティから、<br />
 * 選択情報対象者区分、枝番号を指定して、<br />
 * 選択情報テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getSentakuJyouhousBySntkinfotaisyousyakbnEdano {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_001 = "791112219";
    static Integer P_EDANO_001 = new Integer(12);
    static Integer P_EDANO_002 = new Integer(13);
    static String P_SNTKINFONO_001 = "SN001";
    static String P_SNTKINFONO_002 = "SN002";
    static String P_SNTKINFONO_003 = "SN003";
    static String P_SNTKINFONO_004 = "SN004";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL(P_MOSNO_001);

        List<HT_SentakuJyouhou> hT_SentakuJyouhousLst = hT_SyoriCTL.getSentakuJyouhousBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, P_EDANO_001);
        Assert.assertEquals(0, hT_SentakuJyouhousLst.size());

        HT_SentakuJyouhou hT_SentakuJyouhou3 = hT_SyoriCTL.createSentakuJyouhou();
        hT_SentakuJyouhou3.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
        hT_SentakuJyouhou3.setEdano(P_EDANO_001);
        hT_SentakuJyouhou3.setSntkinfono(P_SNTKINFONO_001);

        HT_SentakuJyouhou hT_SentakuJyouhou4 = hT_SyoriCTL.createSentakuJyouhou();
        hT_SentakuJyouhou4.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
        hT_SentakuJyouhou4.setEdano(P_EDANO_002);
        hT_SentakuJyouhou4.setSntkinfono(P_SNTKINFONO_002);

        HT_SentakuJyouhou hT_SentakuJyouhou5 = hT_SyoriCTL.createSentakuJyouhou();
        hT_SentakuJyouhou5.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
        hT_SentakuJyouhou5.setEdano(P_EDANO_002);
        hT_SentakuJyouhou5.setSntkinfono(P_SNTKINFONO_003);

        HT_SentakuJyouhou hT_SentakuJyouhou6 = hT_SyoriCTL.createSentakuJyouhou();
        hT_SentakuJyouhou6.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
        hT_SentakuJyouhou6.setEdano(P_EDANO_002);
        hT_SentakuJyouhou6.setSntkinfono(P_SNTKINFONO_004);

        sinkeiyakuDomManager.insert(hT_SyoriCTL);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        List<HT_SentakuJyouhou> hT_SentakuJyouhousLst = hT_SyoriCTL.getSentakuJyouhousBySntkinfotaisyousyakbnEdano(
                C_SntkInfoTaisyousyaKbn.BLNK, P_EDANO_001);

        Assert.assertEquals(0, hT_SentakuJyouhousLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        List<HT_SentakuJyouhou> hT_SentakuJyouhousLst = hT_SyoriCTL.getSentakuJyouhousBySntkinfotaisyousyakbnEdano(
                C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, P_EDANO_001);

        Assert.assertEquals(1, hT_SentakuJyouhousLst.size());

        Assert.assertEquals(P_MOSNO_001, hT_SentakuJyouhousLst.get(0).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, hT_SentakuJyouhousLst.get(0).getSntkinfotaisyousyakbn());
        Assert.assertEquals(P_EDANO_001, hT_SentakuJyouhousLst.get(0).getEdano());
        Assert.assertEquals(P_SNTKINFONO_001, hT_SentakuJyouhousLst.get(0).getSntkinfono());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        List<HT_SentakuJyouhou> hT_SentakuJyouhousLst = hT_SyoriCTL.getSentakuJyouhousBySntkinfotaisyousyakbnEdano(
                C_SntkInfoTaisyousyaKbn.HIHOKENSYA, P_EDANO_002);

        Assert.assertEquals(3, hT_SentakuJyouhousLst.size());

        Assert.assertEquals(P_MOSNO_001, hT_SentakuJyouhousLst.get(0).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.HIHOKENSYA, hT_SentakuJyouhousLst.get(0).getSntkinfotaisyousyakbn());
        Assert.assertEquals(P_EDANO_002, hT_SentakuJyouhousLst.get(0).getEdano());
        Assert.assertEquals(P_SNTKINFONO_002, hT_SentakuJyouhousLst.get(0).getSntkinfono());

        Assert.assertEquals(P_MOSNO_001, hT_SentakuJyouhousLst.get(1).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.HIHOKENSYA, hT_SentakuJyouhousLst.get(1).getSntkinfotaisyousyakbn());
        Assert.assertEquals(P_EDANO_002, hT_SentakuJyouhousLst.get(1).getEdano());
        Assert.assertEquals(P_SNTKINFONO_003, hT_SentakuJyouhousLst.get(1).getSntkinfono());

        Assert.assertEquals(P_MOSNO_001, hT_SentakuJyouhousLst.get(2).getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.HIHOKENSYA, hT_SentakuJyouhousLst.get(2).getSntkinfotaisyousyakbn());
        Assert.assertEquals(P_EDANO_002, hT_SentakuJyouhousLst.get(2).getEdano());
        Assert.assertEquals(P_SNTKINFONO_004, hT_SentakuJyouhousLst.get(2).getSntkinfono());
    }
}
