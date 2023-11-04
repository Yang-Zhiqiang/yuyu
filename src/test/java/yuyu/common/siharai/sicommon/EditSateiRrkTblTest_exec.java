package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.siharai.edittbl.EditSateiRrkTbl;
import yuyu.common.siharai.edittbl.EditSateiRrkTblBean;
import yuyu.def.classification.C_HigaitouRiyuuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 査定承認履歴TBL編集のメソッド{@link EditSateiRrkTbl#exec(EditSateiRrkTblParam} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSateiRrkTblTest_exec extends AbstractTest {

    @Inject
    private EditSateiRrkTbl editSateiRrkTbl;

    @Inject
    private EditSateiRrkTblParamImpl editSateiRrkTblParamImpl;

    @Inject
    private EditSateiRrkTblParamSateiImpl editSateiRrkTblParamSateiImpl;

    @Inject
    private EditSateiRrkTblParamKekkaImpl editSateiRrkTblParamKekkaImpl;

    @Inject
    private EditSateiRrkTblImpl editSateiRrkTblImpl;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinoumode;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Test
    @TestOrder(10)
    public void testEditsateirrktbl_A1() {
        try {
            editSateiRrkTbl.exec(null, new EditSateiRrkTblBean());
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pEditSateiRrkTblParam'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testEditsateirrktbl_A2() {
        try {
            editSateiRrkTbl.exec(editSateiRrkTblParamImpl, null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pEditSateiRrkTblBean'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testEditsateirrktbl_A4() {

        EditSateiRrkTblBean bean = new EditSateiRrkTblBean();

        bean.setSkno("");

        try {
            editSateiRrkTbl.exec(editSateiRrkTblParamImpl, bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='skno'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testEditsateirrktbl_A6() {

        EditSateiRrkTblBean bean = new EditSateiRrkTblBean();

        bean.setSkno("800000000000000001");

        bean.setSyono("");

        try {
            editSateiRrkTbl.exec(editSateiRrkTblParamImpl, bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syono'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testEditsateirrktbl_A8() {

        EditSateiRrkTblBean bean = new EditSateiRrkTblBean();

        bean.setSkno("800000000000000001");

        bean.setSyono("80000000010");

        bean.setSateisyouninskbtkey("");

        try {
            editSateiRrkTbl.exec(editSateiRrkTblParamImpl, bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='sateisyouninskbtkey'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    public void testEditsateirrktbl_B1() {

        EditSateiRrkTblBean bean = new EditSateiRrkTblBean();

        bean.setSkno("800000000000000001");

        bean.setSyono("80000000010");

        bean.setSateisyouninskbtkey("100000000000000001");

        bean.setSeikyuurirekino(Integer.valueOf("801"));

        editSateiRrkTblParamKekkaImpl.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);

        editSateiRrkTblParamKekkaImpl.setTennousakisousasyacd("123123123");

        kinou.setKinouId("E10000001");

        kinoumode.setKinouMode("S1000001");

        EditSateiRrkTblBean resultBean = editSateiRrkTbl.exec(editSateiRrkTblParamKekkaImpl, bean);

        exStringEquals(resultBean.getSkno(), "800000000000000001", "請求番号");

        exStringEquals(resultBean.getSyono(), "80000000010", "証券番号");

        exStringEquals(resultBean.getSateisyouninskbtkey(), "100000000000000001", "査定承認識別キー");

        exStringEquals(resultBean.getSeikyuurirekino().toString(), "801", "請求履歴番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSkno(), "800000000000000001", "査定承認履歴TBL．請求番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSyono(), "80000000010", "査定承認履歴TBL．証券番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSateisyouninskbtkey(), "100000000000000001",
            "査定承認履歴TBL．査定承認識別キー");

        exStringEquals(resultBean.getSateiSyouninRireki().getSeikyuurirekino().toString(), "801",
            "査定承認履歴TBL．請求履歴番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSyorikekkakbn().toString(), "110",
            "査定承認履歴TBL．処理結果区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getTennousakisousasyacd(), "123123123",
            "査定承認履歴TBL．転送先操作者コード");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getHushrgeninkbn(), null,
            "査定承認履歴TBL．不支払原因区分");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getHigaitouriyuukbn(), null,
            "査定承認履歴TBL．非該当理由区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getReportcomment(), null,
            "査定承認履歴TBL．帳票用コメント");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getSessyouyhkbn(), null,
            "査定承認履歴TBL．折衝要否区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getSessyousisyacd(), null,
            "査定承認履歴TBL．折衝支社コード");

        exDateEquals(resultBean.getSateiSyouninRireki().getKaiketuymd(), null,
            "査定承認履歴TBL．解決日");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyoricd(), "E10000001",
            "査定承認履歴TBL．更新処理コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyorisscd(), "S1000001",
            "査定承認履歴TBL．更新処理詳細コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(),
            "査定承認履歴TBL．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(70)
    public void testEditsateirrktbl_C1() {

        EditSateiRrkTblBean bean = new EditSateiRrkTblBean();

        bean.setSkno("800000000000000001");

        bean.setSyono("80000000010");

        bean.setSateisyouninskbtkey("100000000000000001");

        bean.setSeikyuurirekino(Integer.valueOf("801"));

        editSateiRrkTblParamSateiImpl.setHushrgeninkbn(C_HushrGeninKbn.SG);

        editSateiRrkTblParamSateiImpl.setHigaitouriyuukbn(C_HigaitouRiyuuKbn.HHST);

        editSateiRrkTblParamSateiImpl.setReportcomment("帳票用コメント");

        editSateiRrkTblParamSateiImpl.setSessyouyhkbn(C_YouhiblnkKbn.YOU);

        editSateiRrkTblParamSateiImpl.setSessyousisyacd("101");

        editSateiRrkTblParamSateiImpl.setKaiketuymd(BizDate.valueOf("20160101"));

        kinou.setKinouId("E10000001");

        kinoumode.setKinouMode("S1000001");

        EditSateiRrkTblBean resultBean = editSateiRrkTbl.exec(editSateiRrkTblParamSateiImpl, bean);

        exStringEquals(resultBean.getSkno(), "800000000000000001", "請求番号");

        exStringEquals(resultBean.getSyono(), "80000000010", "証券番号");

        exStringEquals(resultBean.getSateisyouninskbtkey(), "100000000000000001", "査定承認識別キー");

        exStringEquals(resultBean.getSeikyuurirekino().toString(), "801", "請求履歴番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSkno(), "800000000000000001", "査定承認履歴TBL．請求番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSyono(), "80000000010", "査定承認履歴TBL．証券番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSateisyouninskbtkey(), "100000000000000001",
            "査定承認履歴TBL．査定承認識別キー");

        exStringEquals(resultBean.getSateiSyouninRireki().getSeikyuurirekino().toString(), "801",
            "査定承認履歴TBL．請求履歴番号");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getSyorikekkakbn(), null,
            "査定承認履歴TBL．処理結果区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getTennousakisousasyacd(), null,
            "査定承認履歴TBL．転送先操作者コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getHushrgeninkbn().toString(), C_HushrGeninKbn.SG.toString(),
            "査定承認履歴TBL．不支払原因区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getHigaitouriyuukbn().toString(),
            C_HigaitouRiyuuKbn.HHST.toString(), "査定承認履歴TBL．非該当理由区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getReportcomment(), "帳票用コメント",
            "査定承認履歴TBL．帳票用コメント");

        exStringEquals(resultBean.getSateiSyouninRireki().getSessyouyhkbn().toString(), C_YouhiblnkKbn.YOU.toString(),
            "査定承認履歴TBL．折衝要否区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getSessyousisyacd(), "101",
            "査定承認履歴TBL．折衝支社コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getKaiketuymd().toString(), "20160101",
            "査定承認履歴TBL．解決日");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyoricd(), "E10000001",
            "査定承認履歴TBL．更新処理コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyorisscd(), "S1000001",
            "査定承認履歴TBL．更新処理詳細コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(),
            "査定承認履歴TBL．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(80)
    public void testEditsateirrktbl_D1() {

        EditSateiRrkTblBean bean = new EditSateiRrkTblBean();

        bean.setSkno("800000000000000001");

        bean.setSyono("80000000010");

        bean.setSateisyouninskbtkey("100000000000000001");

        bean.setSeikyuurirekino(Integer.valueOf("801"));

        editSateiRrkTblParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);

        editSateiRrkTblParamImpl.setTennousakisousasyacd("123123123");

        editSateiRrkTblParamImpl.setHushrgeninkbn(C_HushrGeninKbn.SG);

        editSateiRrkTblParamImpl.setHigaitouriyuukbn(C_HigaitouRiyuuKbn.HHST);

        editSateiRrkTblParamImpl.setReportcomment("帳票用コメント");

        editSateiRrkTblParamImpl.setSessyouyhkbn(C_YouhiblnkKbn.YOU);

        editSateiRrkTblParamImpl.setSessyousisyacd("101");

        editSateiRrkTblParamImpl.setKaiketuymd(BizDate.valueOf("20160101"));

        kinou.setKinouId("E10000001");

        kinoumode.setKinouMode("S1000001");

        EditSateiRrkTblBean resultBean = editSateiRrkTbl.exec(editSateiRrkTblParamImpl, bean);

        exStringEquals(resultBean.getSkno(), "800000000000000001", "請求番号");

        exStringEquals(resultBean.getSyono(), "80000000010", "証券番号");

        exStringEquals(resultBean.getSateisyouninskbtkey(), "100000000000000001", "査定承認識別キー");

        exStringEquals(resultBean.getSeikyuurirekino().toString(), "801", "請求履歴番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSkno(), "800000000000000001", "査定承認履歴TBL．請求番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSyono(), "80000000010", "査定承認履歴TBL．証券番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSateisyouninskbtkey(), "100000000000000001",
            "査定承認履歴TBL．査定承認識別キー");

        exStringEquals(resultBean.getSateiSyouninRireki().getSeikyuurirekino().toString(), "801",
            "査定承認履歴TBL．請求履歴番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSyorikekkakbn().toString(), "110",
            "査定承認履歴TBL．処理結果区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getTennousakisousasyacd(), "123123123",
            "査定承認履歴TBL．転送先操作者コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getHushrgeninkbn().toString(), C_HushrGeninKbn.SG.toString(),
            "査定承認履歴TBL．不支払原因区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getHigaitouriyuukbn().toString(),
            C_HigaitouRiyuuKbn.HHST.toString(), "査定承認履歴TBL．非該当理由区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getReportcomment(), "帳票用コメント",
            "査定承認履歴TBL．帳票用コメント");

        exStringEquals(resultBean.getSateiSyouninRireki().getSessyouyhkbn().toString(), C_YouhiblnkKbn.YOU.toString(),
            "査定承認履歴TBL．折衝要否区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getSessyousisyacd(), "101",
            "査定承認履歴TBL．折衝支社コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getKaiketuymd().toString(), "20160101",
            "査定承認履歴TBL．解決日");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyoricd(), "E10000001",
            "査定承認履歴TBL．更新処理コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyorisscd(), "S1000001",
            "査定承認履歴TBL．更新処理詳細コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(),
            "査定承認履歴TBL．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(90)
    public void testEditsateirrktbl_D2() {

        EditSateiRrkTblBean bean = new EditSateiRrkTblBean();

        bean.setSkno("8000000000000001");

        bean.setSyono("80000000010");

        bean.setSateisyouninskbtkey("100000000000000001");

        bean.setSeikyuurirekino(Integer.valueOf("801"));

        kinou.setKinouId("E10000001");

        kinoumode.setKinouMode("S1000001");

        EditSateiRrkTblBean resultBean = editSateiRrkTbl.exec(editSateiRrkTblImpl, bean);

        exStringEquals(resultBean.getSkno(), "8000000000000001", "請求番号");

        exStringEquals(resultBean.getSyono(), "80000000010", "証券番号");

        exStringEquals(resultBean.getSateisyouninskbtkey(), "100000000000000001", "査定承認識別キー");

        exStringEquals(resultBean.getSeikyuurirekino().toString(), "801", "請求履歴番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSkno(), "8000000000000001",
            "査定承認履歴TBL．請求番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSyono(), "80000000010",
            "査定承認履歴TBL．証券番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSateisyouninskbtkey(), "100000000000000001",
            "査定承認履歴TBL．査定承認識別キー");

        exStringEquals(resultBean.getSateiSyouninRireki().getSeikyuurirekino().toString(), "801",
            "査定承認履歴TBL．請求履歴番号");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getSyorikekkakbn(), null,
            "査定承認履歴TBL．処理結果区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getTennousakisousasyacd(), null,
            "査定承認履歴TBL．転送先操作者コード");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getHushrgeninkbn(), null,
            "査定承認履歴TBL．不支払原因区分");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getHigaitouriyuukbn(), null,
            "査定承認履歴TBL．非該当理由区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getReportcomment(), null,
            "査定承認履歴TBL．帳票用コメント");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getSessyouyhkbn(), null,
            "査定承認履歴TBL．折衝要否区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getSessyousisyacd(), null,
            "査定承認履歴TBL．折衝支社コード");

        exDateEquals(resultBean.getSateiSyouninRireki().getKaiketuymd(), null,
            "査定承認履歴TBL．解決日");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyoricd(), "E10000001",
            "査定承認履歴TBL．更新処理コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyorisscd(), "S1000001",
            "査定承認履歴TBL．更新処理詳細コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(),
            "査定承認履歴TBL．業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(100)
    public void testEditsateirrktbl_D3() {

        EditSateiRrkTblBean bean = new EditSateiRrkTblBean();

        bean.setSkno("800000000000000001");

        bean.setSyono("80000000010");

        bean.setSateisyouninskbtkey("100000000000000001");

        bean.setSeikyuurirekino(Integer.valueOf("801"));

        editSateiRrkTblParamImpl.setSyorikekkakbn(null);

        editSateiRrkTblParamImpl.setTennousakisousasyacd(null);

        editSateiRrkTblParamImpl.setHushrgeninkbn(null);

        editSateiRrkTblParamImpl.setHigaitouriyuukbn(null);

        editSateiRrkTblParamImpl.setReportcomment(null);

        editSateiRrkTblParamImpl.setSessyouyhkbn(null);

        editSateiRrkTblParamImpl.setSessyousisyacd(null);

        editSateiRrkTblParamImpl.setKaiketuymd(null);

        kinou.setKinouId("E10000001");

        kinoumode.setKinouMode("S1000001");

        EditSateiRrkTblBean resultBean = editSateiRrkTbl.exec(editSateiRrkTblParamImpl, bean);

        exStringEquals(resultBean.getSkno(), "800000000000000001", "請求番号");

        exStringEquals(resultBean.getSyono(), "80000000010", "証券番号");

        exStringEquals(resultBean.getSateisyouninskbtkey(), "100000000000000001", "査定承認識別キー");

        exStringEquals(resultBean.getSeikyuurirekino().toString(), "801", "請求履歴番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSkno(), "800000000000000001",
            "査定承認履歴TBL．請求番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSyono(), "80000000010",
            "査定承認履歴TBL．証券番号");

        exStringEquals(resultBean.getSateiSyouninRireki().getSateisyouninskbtkey(), "100000000000000001",
            "査定承認履歴TBL．査定承認識別キー");

        exStringEquals(resultBean.getSateiSyouninRireki().getSeikyuurirekino().toString(), "801",
            "査定承認履歴TBL．請求履歴番号");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getSyorikekkakbn(), null,
            "査定承認履歴TBL．処理結果区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getTennousakisousasyacd(), null,
            "査定承認履歴TBL．転送先操作者コード");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getHushrgeninkbn(), null,
            "査定承認履歴TBL．不支払原因区分");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getHigaitouriyuukbn(), null,
            "査定承認履歴TBL．非該当理由区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getReportcomment(), null,
            "査定承認履歴TBL．帳票用コメント");

        exClassificationEquals(resultBean.getSateiSyouninRireki().getSessyouyhkbn(), null,
            "査定承認履歴TBL．折衝要否区分");

        exStringEquals(resultBean.getSateiSyouninRireki().getSessyousisyacd(), null,
            "査定承認履歴TBL．折衝支社コード");

        exDateEquals(resultBean.getSateiSyouninRireki().getKaiketuymd(), null,
            "査定承認履歴TBL．解決日");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyoricd(), "E10000001",
            "査定承認履歴TBL．更新処理コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getKossyorisscd(), "S1000001",
            "査定承認履歴TBL．更新処理詳細コード");

        exStringEquals(resultBean.getSateiSyouninRireki().getGyoumuKousinsyaId(), baseUserInfo.getUserId(),
            "査定承認履歴TBL．業務用更新者ＩＤ");

        MockObjectManager.initialize();
    }
}
