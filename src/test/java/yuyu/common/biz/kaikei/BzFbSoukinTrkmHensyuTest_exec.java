package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.FBSoukinDataParam;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＦＢ送金データ取込編集クラスのメソッド {@link BzFbSoukinTrkmHensyu#exec(FBSoukinDataParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFbSoukinTrkmHensyuTest_exec {

    @Inject
    private BzFbSoukinTrkmHensyu bzFbSoukinTrkmHensyu;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        FBSoukinDataParam fBSoukinDataParam = new FBSoukinDataParamImpl();

        fBSoukinDataParam.setFbsoukindatasikibetukey("12345678901234567890");
        fBSoukinDataParam.setDenrenno("denrenno001234567890");
        fBSoukinDataParam.setEdano(99);
        fBSoukinDataParam.setDensyskbn(C_DensysKbn.AGKANRI);
        fBSoukinDataParam.setGyoumucd(C_Gyoumucd.NENKINJIDOUSOUKIN);
        fBSoukinDataParam.setSyoricd("0001");
        fBSoukinDataParam.setSyorisosikicd("1234567");
        fBSoukinDataParam.setSyoriYmd(BizDate.valueOf("20160120"));
        fBSoukinDataParam.setDenymd(BizDate.valueOf("20160121"));
        fBSoukinDataParam.setSyono("11807111129");
        fBSoukinDataParam.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        fBSoukinDataParam.setBankcd("2876");
        fBSoukinDataParam.setSitencd("003");
        fBSoukinDataParam.setYokinkbn(C_YokinKbn.HUTUU);
        fBSoukinDataParam.setKouzano("123456789012");
        fBSoukinDataParam.setKzmeiginmkn("カザメイギカザメイギカザメイギカザメイギカザメイギカザメイギ");
        fBSoukinDataParam.setSoukingk(BizCurrency.valueOf(1234567890));
        fBSoukinDataParam.setKyktuukasyu(C_Tuukasyu.USD);
        fBSoukinDataParam.setGaikataikagk(BizCurrency.valueOf(123456789012345L));
        fBSoukinDataParam.setSoukinkwsrate(BizNumber.valueOf(190.1234));

        C_FbSoukinBatchKbn fbSoukinBatchKbn = C_FbSoukinBatchKbn.BATCH;

        BT_FBSoukinData bf = bzFbSoukinTrkmHensyu.exec(fBSoukinDataParam, fbSoukinBatchKbn);

        exStringEquals(bf.getFbsoukindatasikibetukey(), "12345678901234567890", "FB送金データ識別キー");
        exStringEquals(bf.getDenrenno(), "denrenno001234567890", "伝票データ連番");
        exNumericEquals(bf.getEdano(), 99, "枝番号");
        exClassificationEquals(bf.getDensyskbn(), C_DensysKbn.AGKANRI, "伝票用システム区分");
        exClassificationEquals(bf.getGyoumucd(), C_Gyoumucd.NENKINJIDOUSOUKIN, "業務コード");
        exStringEquals(bf.getSyoricd(), "0001", "処理コード");
        exStringEquals(bf.getSyorisosikicd(), "1234567", "処理組織コード");
        exDateEquals(bf.getSyoriYmd(), BizDate.valueOf("20160120"), "処理年月日");
        exDateEquals(bf.getDenymd(), BizDate.valueOf("20160121"), "伝票日付");
        exStringEquals(bf.getKeirisyono(), "11807111129", "経理用証券番号");
        exClassificationEquals(bf.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(bf.getBankcd(), "2876", "銀行コード");
        exStringEquals(bf.getSitencd(), "003", "支店コード");

        exClassificationEquals(bf.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(bf.getKouzano(), "123456789012", "口座番号");
        exStringEquals(bf.getKzmeiginmkn(), "カザメイギカザメイギカザメイギカザメイギカザメイギカザメイギ",
            "口座名義人氏名（カナ）");
        exBizCalcbleEquals(bf.getSoukingk(), BizCurrency.valueOf(1234567890), "送金金額");
        exClassificationEquals(bf.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(bf.getGaikataikagk(), BizCurrency.valueOf(123456789012345L), "外貨対価額");
        exBizCalcbleEquals(bf.getSoukinkwsrate(), BizNumber.valueOf(190.1234), "送金用為替レート");
        exClassificationEquals(bf.getFbsoukinbatchkbn(), C_FbSoukinBatchKbn.BATCH, "ＦＢ送金バッチ区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        FBSoukinDataParam fBSoukinDataParam = new FBSoukinDataParamImpl();
        C_FbSoukinBatchKbn fbSoukinBatchKbn = C_FbSoukinBatchKbn.NONE;

        BT_FBSoukinData bf = bzFbSoukinTrkmHensyu.exec(fBSoukinDataParam, fbSoukinBatchKbn);

        exStringEquals(bf.getFbsoukindatasikibetukey(), null, "FB送金データ識別キー");
        exStringEquals(bf.getDenrenno(), "", "伝票データ連番");
        exNumericEquals(bf.getEdano(), 0, "枝番号");
        exClassificationEquals(bf.getDensyskbn(), C_DensysKbn.BLNK, "伝票用システム区分");
        exClassificationEquals(bf.getGyoumucd(), C_Gyoumucd.BLNK, "業務コード");
        exClassificationEquals(bf.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(bf.getSyoricd(), "", "処理コード");
        exStringEquals(bf.getSyorisosikicd(), "", "処理組織コード");
        exDateEquals(bf.getSyoriYmd(), null, "処理年月日");
        exDateEquals(bf.getDenymd(), null, "伝票日付");
        exStringEquals(bf.getKeirisyono(), "", "経理用証券番号");
        exClassificationEquals(bf.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(bf.getBankcd(), "", "銀行コード");
        exStringEquals(bf.getSitencd(), "", "支店コード");

        exClassificationEquals(bf.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(bf.getKouzano(), "", "口座番号");
        exStringEquals(bf.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(bf.getSoukingk(), BizCurrency.valueOf(0), "送金金額");
        exClassificationEquals(bf.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(bf.getGaikataikagk(), BizCurrency.valueOf(0), "外貨対価額");
        exBizCalcbleEquals(bf.getSoukinkwsrate(), BizNumber.valueOf(0), "送金用為替レート");
        exClassificationEquals(bf.getFbsoukinbatchkbn(), C_FbSoukinBatchKbn.NONE, "ＦＢ送金バッチ区分");

        MockObjectManager.initialize();
    }
}