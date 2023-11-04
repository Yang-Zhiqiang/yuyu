package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.siharai.edittbl.EditSiharaiRirekiTbl;
import yuyu.common.siharai.edittbl.EditSiharaiRirekiTblBean;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払履歴TBL編集のメイン処理{@link EditSiharaiRirekiTbl#exec(EditSiharaiRirekiTblParam,
            EditSiharaiRirekiTblBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSiharaiRirekiTblTest_exec {

    @Inject
    private EditSiharaiRirekiTbl editSiharaiRirekiTbl;

    @Inject
    private EditSiharaiRirekiTblTestUiBean uiBean;

    @Inject
    private EditSiharaiRirekiTblTest2UiBean uiBean2;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinoumode;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = null;
        try{
            editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pEditSiharaiRirekiTblBean'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();

        uiBean = null;

        try{
            editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pEditSiharaiRirekiTblParam'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno(null);

        try{
            editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='skno'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("");

        try{
            editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='skno'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono(null);

        try{
            editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syono'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono("");

        try{
            editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syono'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono("80000000026");
        editSiharaiRirekiTblBean.setShrsikibetukey(null);

        try{
            editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='shrsikibetukey'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono("80000000026");
        editSiharaiRirekiTblBean.setShrsikibetukey("");

        try{
            editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='shrsikibetukey'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono("80000000026");
        editSiharaiRirekiTblBean.setShrsikibetukey("100005");
        editSiharaiRirekiTblBean.setSeikyuurirekino(101);
        editSiharaiRirekiTblBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        editSiharaiRirekiTblBean.setShrsyoriymd(BizDate.valueOf(20151111));
        editSiharaiRirekiTblBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        editSiharaiRirekiTblBean.setTorikesiflg(C_UmuKbn.ARI);
        editSiharaiRirekiTblBean.setTorikesiymd(BizDate.valueOf(20151112));

        editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean2, editSiharaiRirekiTblBean);

        exStringEquals(editSiharaiRirekiTblBean.getSkno(), "12345678901", "請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSyono(), "80000000026", "証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getShrsikibetukey(), "100005", "支払識別キー");
        exNumericEquals(editSiharaiRirekiTblBean.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getShrsyoriymd(), BizDate.valueOf(20151111), "支払処理日");
        exClassificationEquals(editSiharaiRirekiTblBean.getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getTorikesiflg(), C_UmuKbn.ARI, "取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getTorikesiymd(), BizDate.valueOf(20151112), "取消日");

        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSkno(), "12345678901", "支払履歴テーブルエンティティ．請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSyono(), "80000000026", "支払履歴テーブルエンティティ．証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getShrsikibetukey(), "100005", "支払履歴テーブルエンティティ．支払識別キー");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSeikyuurirekino().toString(), "101", "支払履歴テーブルエンティティ．請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払履歴テーブルエンティティ．支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getShrsyoriymd(), BizDate.valueOf(20151111), "支払履歴テーブルエンティティ．支払処理日");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTyakkinymd(), null, "支払履歴テーブルエンティティ．着金日");
        exBizCalcbleEquals(editSiharaiRirekiTblBean.getSirireki().getShrgkkei(), null, "支払履歴テーブルエンティティ．支払額合計");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "支払履歴テーブルエンティティ．税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiflg(), C_UmuKbn.ARI, "支払履歴テーブルエンティティ．取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiymd(), BizDate.valueOf(20151112), "支払履歴テーブルエンティティ．取消日");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyoricd(), kinou.getKinouId(), "支払履歴テーブルエンティティ．更新処理コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyorisscd(), kinoumode.getKinouMode(), "支払履歴テーブルエンティティ．更新処理詳細コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(), "支払履歴テーブルエンティティ．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizPropertyInitializer.initialize(uiBean);
        uiBean.setTyakkinymd(BizDate.valueOf(20151113));
        uiBean.setShrgkkei(BizCurrency.valueOf(-1));

        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono("80000000026");
        editSiharaiRirekiTblBean.setShrsikibetukey("100005");
        editSiharaiRirekiTblBean.setSeikyuurirekino(101);
        editSiharaiRirekiTblBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        editSiharaiRirekiTblBean.setShrsyoriymd(BizDate.valueOf(20151111));
        editSiharaiRirekiTblBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        editSiharaiRirekiTblBean.setTorikesiflg(C_UmuKbn.ARI);
        editSiharaiRirekiTblBean.setTorikesiymd(BizDate.valueOf(20151112));

        editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);

        exStringEquals(editSiharaiRirekiTblBean.getSkno(), "12345678901", "請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSyono(), "80000000026", "証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getShrsikibetukey(), "100005", "支払識別キー");
        exNumericEquals(editSiharaiRirekiTblBean.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getShrsyoriymd(), BizDate.valueOf(20151111), "支払処理日");
        exClassificationEquals(editSiharaiRirekiTblBean.getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getTorikesiflg(), C_UmuKbn.ARI, "取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getTorikesiymd(), BizDate.valueOf(20151112), "取消日");

        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSkno(), "12345678901", "支払履歴テーブルエンティティ．請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSyono(), "80000000026", "支払履歴テーブルエンティティ．証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getShrsikibetukey(), "100005", "支払履歴テーブルエンティティ．支払識別キー");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSeikyuurirekino().toString(), "101", "支払履歴テーブルエンティティ．請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払履歴テーブルエンティティ．支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getShrsyoriymd(), BizDate.valueOf(20151111), "支払履歴テーブルエンティティ．支払処理日");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTyakkinymd(), null, "支払履歴テーブルエンティティ．着金日");
        exBizCalcbleEquals(editSiharaiRirekiTblBean.getSirireki().getShrgkkei(), BizCurrency.valueOf(-1), "支払履歴テーブルエンティティ．支払額合計");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "支払履歴テーブルエンティティ．税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiflg(), C_UmuKbn.ARI, "支払履歴テーブルエンティティ．取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiymd(), BizDate.valueOf(20151112), "支払履歴テーブルエンティティ．取消日");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyoricd(), kinou.getKinouId(), "支払履歴テーブルエンティティ．更新処理コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyorisscd(), kinoumode.getKinouMode(), "支払履歴テーブルエンティティ．更新処理詳細コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(), "支払履歴テーブルエンティティ．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BizPropertyInitializer.initialize(uiBean);
        uiBean.setTyakkinymd(BizDate.valueOf(20151113));
        uiBean.setShrgkkei(BizCurrency.valueOf(0));

        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono("80000000026");
        editSiharaiRirekiTblBean.setShrsikibetukey("100005");
        editSiharaiRirekiTblBean.setSeikyuurirekino(101);
        editSiharaiRirekiTblBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        editSiharaiRirekiTblBean.setShrsyoriymd(BizDate.valueOf(20151111));
        editSiharaiRirekiTblBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        editSiharaiRirekiTblBean.setTorikesiflg(C_UmuKbn.ARI);
        editSiharaiRirekiTblBean.setTorikesiymd(BizDate.valueOf(20151112));

        editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);

        exStringEquals(editSiharaiRirekiTblBean.getSkno(), "12345678901", "請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSyono(), "80000000026", "証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getShrsikibetukey(), "100005", "支払識別キー");
        exNumericEquals(editSiharaiRirekiTblBean.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getShrsyoriymd(), BizDate.valueOf(20151111), "支払処理日");
        exClassificationEquals(editSiharaiRirekiTblBean.getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getTorikesiflg(), C_UmuKbn.ARI, "取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getTorikesiymd(), BizDate.valueOf(20151112), "取消日");

        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSkno(), "12345678901", "支払履歴テーブルエンティティ．請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSyono(), "80000000026", "支払履歴テーブルエンティティ．証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getShrsikibetukey(), "100005", "支払履歴テーブルエンティティ．支払識別キー");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSeikyuurirekino().toString(), "101", "支払履歴テーブルエンティティ．請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払履歴テーブルエンティティ．支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getShrsyoriymd(), BizDate.valueOf(20151111), "支払履歴テーブルエンティティ．支払処理日");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTyakkinymd(), null, "支払履歴テーブルエンティティ．着金日");
        exBizCalcbleEquals(editSiharaiRirekiTblBean.getSirireki().getShrgkkei(), BizCurrency.valueOf(0), "支払履歴テーブルエンティティ．支払額合計");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "支払履歴テーブルエンティティ．税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiflg(), C_UmuKbn.ARI, "支払履歴テーブルエンティティ．取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiymd(), BizDate.valueOf(20151112), "支払履歴テーブルエンティティ．取消日");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyoricd(), kinou.getKinouId(), "支払履歴テーブルエンティティ．更新処理コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyorisscd(), kinoumode.getKinouMode(), "支払履歴テーブルエンティティ．更新処理詳細コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(), "支払履歴テーブルエンティティ．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BizPropertyInitializer.initialize(uiBean);
        uiBean.setTyakkinymd(BizDate.valueOf(20151113));
        uiBean.setShrgkkei(BizCurrency.valueOf(1));

        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono("80000000026");
        editSiharaiRirekiTblBean.setShrsikibetukey("100005");
        editSiharaiRirekiTblBean.setSeikyuurirekino(101);
        editSiharaiRirekiTblBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        editSiharaiRirekiTblBean.setShrsyoriymd(BizDate.valueOf(20151111));
        editSiharaiRirekiTblBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        editSiharaiRirekiTblBean.setTorikesiflg(C_UmuKbn.ARI);
        editSiharaiRirekiTblBean.setTorikesiymd(BizDate.valueOf(20151112));

        editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);

        exStringEquals(editSiharaiRirekiTblBean.getSkno(), "12345678901", "請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSyono(), "80000000026", "証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getShrsikibetukey(), "100005", "支払識別キー");
        exNumericEquals(editSiharaiRirekiTblBean.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getShrsyoriymd(), BizDate.valueOf(20151111), "支払処理日");
        exClassificationEquals(editSiharaiRirekiTblBean.getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getTorikesiflg(), C_UmuKbn.ARI, "取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getTorikesiymd(), BizDate.valueOf(20151112), "取消日");

        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSkno(), "12345678901", "支払履歴テーブルエンティティ．請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSyono(), "80000000026", "支払履歴テーブルエンティティ．証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getShrsikibetukey(), "100005", "支払履歴テーブルエンティティ．支払識別キー");
        exNumericEquals(editSiharaiRirekiTblBean.getSirireki().getSeikyuurirekino(), 101, "支払履歴テーブルエンティティ．請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払履歴テーブルエンティティ．支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getShrsyoriymd(), BizDate.valueOf(20151111), "支払履歴テーブルエンティティ．支払処理日");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTyakkinymd(), BizDate.valueOf(20151113), "支払履歴テーブルエンティティ．着金日");
        exBizCalcbleEquals(editSiharaiRirekiTblBean.getSirireki().getShrgkkei(), BizCurrency.valueOf(1), "支払履歴テーブルエンティティ．支払額合計");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "支払履歴テーブルエンティティ．税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiflg(), C_UmuKbn.ARI, "支払履歴テーブルエンティティ．取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiymd(), BizDate.valueOf(20151112), "支払履歴テーブルエンティティ．取消日");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyoricd(), kinou.getKinouId(), "支払履歴テーブルエンティティ．更新処理コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyorisscd(), kinoumode.getKinouMode(), "支払履歴テーブルエンティティ．更新処理詳細コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(), "支払履歴テーブルエンティティ．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BizPropertyInitializer.initialize(uiBean);
        uiBean.setTyakkinymd(BizDate.valueOf(20151113));
        uiBean.setShrgkkei(BizCurrency.optional());

        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono("80000000026");
        editSiharaiRirekiTblBean.setShrsikibetukey("100005");
        editSiharaiRirekiTblBean.setSeikyuurirekino(101);
        editSiharaiRirekiTblBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        editSiharaiRirekiTblBean.setShrsyoriymd(BizDate.valueOf(20151111));
        editSiharaiRirekiTblBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        editSiharaiRirekiTblBean.setTorikesiflg(C_UmuKbn.ARI);
        editSiharaiRirekiTblBean.setTorikesiymd(BizDate.valueOf(20151112));

        editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);

        exStringEquals(editSiharaiRirekiTblBean.getSkno(), "12345678901", "請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSyono(), "80000000026", "証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getShrsikibetukey(), "100005", "支払識別キー");
        exNumericEquals(editSiharaiRirekiTblBean.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getShrsyoriymd(), BizDate.valueOf(20151111), "支払処理日");
        exClassificationEquals(editSiharaiRirekiTblBean.getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getTorikesiflg(), C_UmuKbn.ARI, "取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getTorikesiymd(), BizDate.valueOf(20151112), "取消日");

        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSkno(), "12345678901", "支払履歴テーブルエンティティ．請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSyono(), "80000000026", "支払履歴テーブルエンティティ．証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getShrsikibetukey(), "100005", "支払履歴テーブルエンティティ．支払識別キー");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSeikyuurirekino().toString(), "101", "支払履歴テーブルエンティティ．請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払履歴テーブルエンティティ．支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getShrsyoriymd(), BizDate.valueOf(20151111), "支払履歴テーブルエンティティ．支払処理日");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTyakkinymd(), null, "支払履歴テーブルエンティティ．着金日");
        exBizCalcbleEquals(editSiharaiRirekiTblBean.getSirireki().getShrgkkei(), BizCurrency.optional(), "支払履歴テーブルエンティティ．支払額合計");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "支払履歴テーブルエンティティ．税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiflg(), C_UmuKbn.ARI, "支払履歴テーブルエンティティ．取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiymd(), BizDate.valueOf(20151112), "支払履歴テーブルエンティティ．取消日");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyoricd(), kinou.getKinouId(), "支払履歴テーブルエンティティ．更新処理コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyorisscd(), kinoumode.getKinouMode(), "支払履歴テーブルエンティティ．更新処理詳細コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(), "支払履歴テーブルエンティティ．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BizPropertyInitializer.initialize(uiBean);
        uiBean.setTyakkinymd(BizDate.valueOf(20151113));
        uiBean.setShrgkkei(null);

        EditSiharaiRirekiTblBean editSiharaiRirekiTblBean = new EditSiharaiRirekiTblBean();
        editSiharaiRirekiTblBean.setSkno("12345678901");
        editSiharaiRirekiTblBean.setSyono("80000000026");
        editSiharaiRirekiTblBean.setShrsikibetukey("100005");
        editSiharaiRirekiTblBean.setSeikyuurirekino(101);
        editSiharaiRirekiTblBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        editSiharaiRirekiTblBean.setShrsyoriymd(BizDate.valueOf(20151111));
        editSiharaiRirekiTblBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        editSiharaiRirekiTblBean.setTorikesiflg(C_UmuKbn.ARI);
        editSiharaiRirekiTblBean.setTorikesiymd(BizDate.valueOf(20151112));

        editSiharaiRirekiTblBean = editSiharaiRirekiTbl.exec(uiBean, editSiharaiRirekiTblBean);

        exStringEquals(editSiharaiRirekiTblBean.getSkno(), "12345678901", "請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSyono(), "80000000026", "証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getShrsikibetukey(), "100005", "支払識別キー");
        exNumericEquals(editSiharaiRirekiTblBean.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getShrsyoriymd(), BizDate.valueOf(20151111), "支払処理日");
        exClassificationEquals(editSiharaiRirekiTblBean.getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getTorikesiflg(), C_UmuKbn.ARI, "取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getTorikesiymd(), BizDate.valueOf(20151112), "取消日");

        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSkno(), "12345678901", "支払履歴テーブルエンティティ．請求番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSyono(), "80000000026", "支払履歴テーブルエンティティ．証券番号");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getShrsikibetukey(), "100005", "支払履歴テーブルエンティティ．支払識別キー");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getSeikyuurirekino().toString(), "101", "支払履歴テーブルエンティティ．請求履歴番号");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払履歴テーブルエンティティ．支払結果区分");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getShrsyoriymd(), BizDate.valueOf(20151111), "支払履歴テーブルエンティティ．支払処理日");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTyakkinymd(), null, "支払履歴テーブルエンティティ．着金日");
        exBizCalcbleEquals(editSiharaiRirekiTblBean.getSirireki().getShrgkkei(), null, "支払履歴テーブルエンティティ．支払額合計");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getZeitratkikbn(), C_ZeitratkiKbn.SOUZOKU, "支払履歴テーブルエンティティ．税取扱区分");
        exClassificationEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiflg(), C_UmuKbn.ARI, "支払履歴テーブルエンティティ．取消フラグ");
        exDateEquals(editSiharaiRirekiTblBean.getSirireki().getTorikesiymd(), BizDate.valueOf(20151112), "支払履歴テーブルエンティティ．取消日");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyoricd(), kinou.getKinouId(), "支払履歴テーブルエンティティ．更新処理コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getKossyorisscd(), kinoumode.getKinouMode(), "支払履歴テーブルエンティティ．更新処理詳細コード");
        exStringEquals(editSiharaiRirekiTblBean.getSirireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(), "支払履歴テーブルエンティティ．業務用更新者ＩＤ");
        MockObjectManager.initialize();
    }
}
