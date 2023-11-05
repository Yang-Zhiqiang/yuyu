package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TyokusouhtkekKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全直送判定のメソッド {@link KhTyokusouHantei#execTrkkzkTyokusouHantei(TrkkzkTyokusouhtBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhTyokusouHanteiTest_execTrkkzkTyokusouHantei {

    @Inject
    private KhTyokusouHantei khTyokusouHantei;

    @Test
    @TestOrder(10)
    public void KhTyokusouHanteiTest_execTrkkzkTyokusouHantei_A1() {

        TrkkzkTyokusouhtBean trkkzkTyokusouhtBean = new TrkkzkTyokusouhtBean();

        trkkzkTyokusouhtBean.setKijyunymd(BizDate.valueOf("20200703"));
        trkkzkTyokusouhtBean.setKykseiymd(BizDate.valueOf("19500801"));
        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(C_TsindousiteiKbn.BLNK);

        C_TyokusouhtkekKbn tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

        exClassificationEquals(tyokusouhtkekKbn, C_TyokusouhtkekKbn.TYOKUSOUTSYGAI, "直送判定結果区分");
    }

    @Test
    @TestOrder(20)
    public void KhTyokusouHanteiTest_execTrkkzkTyokusouHantei_A2() {

        TrkkzkTyokusouhtBean trkkzkTyokusouhtBean = new TrkkzkTyokusouhtBean();

        trkkzkTyokusouhtBean.setKijyunymd(BizDate.valueOf("20200703"));
        trkkzkTyokusouhtBean.setKykseiymd(BizDate.valueOf("19500601"));
        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(C_TsindousiteiKbn.BLNK);

        C_TyokusouhtkekKbn tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

        exClassificationEquals(tyokusouhtkekKbn, C_TyokusouhtkekKbn.TYOKUSOUTSY, "直送判定結果区分");
    }

    @Test
    @TestOrder(30)
    public void KhTyokusouHanteiTest_execTrkkzkTyokusouHantei_A3() {

        TrkkzkTyokusouhtBean trkkzkTyokusouhtBean = new TrkkzkTyokusouhtBean();

        trkkzkTyokusouhtBean.setKijyunymd(BizDate.valueOf("20200703"));
        trkkzkTyokusouhtBean.setKykseiymd(BizDate.valueOf("19490601"));
        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(C_TsindousiteiKbn.BLNK);

        C_TyokusouhtkekKbn tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

        exClassificationEquals(tyokusouhtkekKbn, C_TyokusouhtkekKbn.TYOKUSOUTSY, "直送判定結果区分");
    }

    @Test
    @TestOrder(40)
    public void KhTyokusouHanteiTest_execTrkkzkTyokusouHantei_A4() {

        TrkkzkTyokusouhtBean trkkzkTyokusouhtBean = new TrkkzkTyokusouhtBean();

        trkkzkTyokusouhtBean.setKijyunymd(BizDate.valueOf("20200703"));
        trkkzkTyokusouhtBean.setKykseiymd(BizDate.valueOf("19490601"));
        trkkzkTyokusouhtBean.setTrkkzktsindousiteikbn(C_TsindousiteiKbn.ARI);

        C_TyokusouhtkekKbn tyokusouhtkekKbn = khTyokusouHantei.execTrkkzkTyokusouHantei(trkkzkTyokusouhtBean);

        exClassificationEquals(tyokusouhtkekKbn, C_TyokusouhtkekKbn.TYOKUSOUTSYGAI, "直送判定結果区分");
    }
}
