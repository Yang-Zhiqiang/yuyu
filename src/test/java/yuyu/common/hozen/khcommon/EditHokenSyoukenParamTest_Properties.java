package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険証券作成用パラメータクラスのメソッド {@link EditHokenSyoukenParam} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditHokenSyoukenParamTest_Properties {

    private C_SyoukensaihkKbn syoukensaihkKbn = C_SyoukensaihkKbn.SYOUKENSAIHAKKOU;

    private C_InsizeiShryouhiKbn insizeiShryouhiKbn = C_InsizeiShryouhiKbn.HUYOU;

    private C_StdrsktkyhnkKbn stdrsktkyhnkKbn = C_StdrsktkyhnkKbn.HUKA;

    private C_UmuKbn kariukeUmu = C_UmuKbn.ARI;

    private C_UmuKbn hukusuuUmu = C_UmuKbn.ARI;

    private BizDate calcKijyunYmd = BizDate.valueOf(20180403);

    private C_HnskariyuuKbn hnskaRiyuu1 = C_HnskariyuuKbn.JIMU_ARI;

    private C_HnskariyuuKbn hnskaRiyuu2 = C_HnskariyuuKbn.YENDTHNKHR_ARI;

    private C_TantouCdKbn tantouCd = C_TantouCdKbn.IMUSATEI;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testProperties_A1(){

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);

        editHokenSyoukenParam.setSyoukenSaihk(syoukensaihkKbn);
        editHokenSyoukenParam.setInsizeiShryouhi(insizeiShryouhiKbn);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(stdrsktkyhnkKbn);
        editHokenSyoukenParam.setKariukeUmu(kariukeUmu);
        editHokenSyoukenParam.setHukusuuUmu(hukusuuUmu);
        editHokenSyoukenParam.setCalckijyunYMD(calcKijyunYmd);
        editHokenSyoukenParam.setHnskariyuu1(hnskaRiyuu1);
        editHokenSyoukenParam.setHnskariyuu2(hnskaRiyuu2);
        editHokenSyoukenParam.setTantoucd(tantouCd);

        exClassificationEquals(editHokenSyoukenParam.getSyoukenSaihk() ,syoukensaihkKbn , "証券再発行区分");
        exClassificationEquals(editHokenSyoukenParam.getInsizeiShryouhi() ,insizeiShryouhiKbn , "印紙税支払要否区分");
        exClassificationEquals(editHokenSyoukenParam.getStdrsktkyhnkKbn() ,stdrsktkyhnkKbn , "指定代理請求特約変更区分");
        exClassificationEquals(editHokenSyoukenParam.getKariukeUmu(), kariukeUmu, "仮受計上有無");
        exClassificationEquals(editHokenSyoukenParam.getHukusuuUmu(), hukusuuUmu, "複数発行有無");
        exDateEquals(editHokenSyoukenParam.getCalckijyunYMD(), calcKijyunYmd, "計算基準日");
        exClassificationEquals(editHokenSyoukenParam.getHnskariyuu1(), hnskaRiyuu1, "本社回送理由１");
        exClassificationEquals(editHokenSyoukenParam.getHnskariyuu2(), hnskaRiyuu2, "本社回送理由２");
        exClassificationEquals(editHokenSyoukenParam.getTantoucd(), tantouCd, "担当コード");

    }

    @Test
    @TestOrder(20)
    public void testProperties_A2(){

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);

        exClassificationEquals(editHokenSyoukenParam.getSyoukenSaihk() ,C_SyoukensaihkKbn.BLNK, "証券再発行区分");
        exClassificationEquals(editHokenSyoukenParam.getInsizeiShryouhi() ,C_InsizeiShryouhiKbn.YOU , "印紙税支払要否区分");
        exClassificationEquals(editHokenSyoukenParam.getStdrsktkyhnkKbn() ,C_StdrsktkyhnkKbn.BLNK , "指定代理請求特約変更区分");
        exClassificationEquals(editHokenSyoukenParam.getKariukeUmu(), C_UmuKbn.NONE, "仮受計上有無");
        exClassificationEquals(editHokenSyoukenParam.getHukusuuUmu(), C_UmuKbn.NONE, "複数発行有無");
        exDateEquals(editHokenSyoukenParam.getCalckijyunYMD(), null, "計算基準日");
        exClassificationEquals(editHokenSyoukenParam.getHnskariyuu1(), C_HnskariyuuKbn.BLNK, "本社回送理由１");
        exClassificationEquals(editHokenSyoukenParam.getHnskariyuu2(), C_HnskariyuuKbn.BLNK, "本社回送理由２");
        exClassificationEquals(editHokenSyoukenParam.getTantoucd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");

    }
}
