package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.EditSiDshrTukiTbl;
import yuyu.common.siharai.edittbl.EditSiDshrTukiTblBean;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.common.suuri.srcommon.EditDshrTukiTanKoumokuBean;
import yuyu.common.suuri.srcommon.SrDshrTukiDataSks;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金Ｄ支払統計TBL編集のメソッド{@link EditSiDshrTukiTbl#exec(EditSiDshrTukiTblBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSiDshrTukiTblTest_exec extends AbstractTest {

    @Inject
    private EditSiDshrTukiTbl editSiDshrTukiTbl;

    @Test
    @TestOrder(10)
    public void testEditsidshrtukitbl_A1() {

        EditSiDshrTukiTblBean editSiDshrTukiTblBean = new EditSiDshrTukiTblBean();

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("99806002387");
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("99806002387");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        editSiDshrTukiTblBean.setSiKykKihon(siKykKihon);
        editSiDshrTukiTblBean.setSiKykSyouhn(siKykKihon.getSiKykSyouhns().get(0));
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = null;
        editSiDshrTukiTblBean.setEditDshrTukiDKoumokuBean(editDshrTukiDKoumokuBean);
        editSiDshrTukiTblBean.setSkno("000000000000000080");
        editSiDshrTukiTblBean.setSeikyuurirekino(1);
        editSiDshrTukiTblBean.setSyoriYmd(BizDate.valueOf("20200707"));
        editSiDshrTukiTblBean.setDenymd(BizDate.valueOf("20200708"));
        editSiDshrTukiTblBean.setSiharaid(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
        editSiDshrTukiTblBean.setGyoumuKousinsyaId("56430206");
        editSiDshrTukiTblBean.setGyoumuKousinKinou("sisateisb");

        JT_SiDshrTuki siDshrTuki = editSiDshrTukiTbl.exec(editSiDshrTukiTblBean);

        exBooleanEquals(siDshrTuki == null, true, "保険金給付金Ｄ支払統計テーブルエンティティ");

    }

    @Test
    @TestOrder(100)
    public void testEditsidshrtukitbl_B1() {

        EditSiDshrTukiTblBean editSiDshrTukiTblBean = new EditSiDshrTukiTblBean();

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("99806002398");
        siKykKihon.setHrkkeiro(C_Hrkkeiro.BLNK);
        siKykKihon.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("99806002398");
        siKykSyouhn.setSyouhncd("ﾕｱ");
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKykymd(BizDate.valueOf("20170424"));
        siKykSyouhn.setYendthnkymd(BizDate.valueOf("20170524"));
        siKykSyouhn.setKihons(BizCurrency.valueOf(10000000, BizCurrencyTypes.YEN));
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.0055));
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        editSiDshrTukiTblBean.setSiKykKihon(siKykKihon);
        editSiDshrTukiTblBean.setSiKykSyouhn(siKykKihon.getSiKykSyouhns().get(0));
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
        editSiDshrTukiTblBean.setEditDshrTukiDKoumokuBean(editDshrTukiDKoumokuBean);
        editSiDshrTukiTblBean.setSkno("000000000000000090");
        editSiDshrTukiTblBean.setSeikyuurirekino(2);
        editSiDshrTukiTblBean.setSyoriYmd(BizDate.valueOf("20200709"));
        editSiDshrTukiTblBean.setDenymd(BizDate.valueOf("20200710"));
        editSiDshrTukiTblBean.setSiharaid(BizCurrency.valueOf(30000, BizCurrencyTypes.YEN));
        editSiDshrTukiTblBean.setGyoumuKousinsyaId("56430406");
        editSiDshrTukiTblBean.setGyoumuKousinKinou("sisateisb");

        JT_SiDshrTuki siDshrTuki = editSiDshrTukiTbl.exec(editSiDshrTukiTblBean);

        exBooleanEquals(siDshrTuki == null, false, "保険金給付金Ｄ支払統計テーブルエンティティ");

        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = (EditDshrTukiTanKoumokuBean) MockObjectManager
            .getArgument(SrDshrTukiDataSks.class, "execSi", 0, 0);
        exNumericEquals(editDshrTukiTanKoumokuBean.getRenno(), 1, "連番");
        exStringEquals(editDshrTukiTanKoumokuBean.getSkno(), "000000000000000090", "請求番号");
        exStringEquals(editDshrTukiTanKoumokuBean.getSyono(), "99806002398", "証券番号");
        exNumericEquals(editDshrTukiTanKoumokuBean.getSeikyuurirekiNo(), 2, "請求履歴番号");
        exStringEquals(editDshrTukiTanKoumokuBean.getHenkousikibetuKey(), null, "変更識別キー");
        exDateEquals(editDshrTukiTanKoumokuBean.getSyoriYmd(), BizDate.valueOf("20200709"), "処理年月日");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exStringEquals(editDshrTukiTanKoumokuBean.getSyouhnCd(), "ﾕｱ", "商品コード");
        exNumericEquals(editDshrTukiTanKoumokuBean.getSyouhnsdNo(), 1, "商品世代番号");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getKykjyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exClassificationEquals(editDshrTukiTanKoumokuBean.getSyoumetujiyuu(), null, "消滅事由");
        exDateEquals(editDshrTukiTanKoumokuBean.getKykymd(), BizDate.valueOf("20170424"), "契約日");
        exDateEquals(editDshrTukiTanKoumokuBean.getYendthnkymd(), BizDate.valueOf("20170524"), "円建変更日");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean.getKihons(), BizCurrency.valueOf(10000000, BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean.getYoteiriritu(), BizNumber.valueOf(0.0055), "予定利率");
        exDateEquals(editDshrTukiTanKoumokuBean.getDenymd(), BizDate.valueOf("20200710"), "伝票日付");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean.getSiharaid(), BizCurrency.valueOf(30000, BizCurrencyTypes.YEN), "支払Ｄ");
        exBooleanEquals(editDshrTukiTanKoumokuBean.getKhHaitouKanri() == null, true, "配当管理テーブルエンティティ");
        exBooleanEquals(editDshrTukiTanKoumokuBean.getKhTumitateDKanri() == null, true, "積立Ｄ管理テーブルエンティティ");
        exStringEquals(editDshrTukiTanKoumokuBean.getGyoumuKousinsyaId(), "56430406", "業務用更新者ＩＤ");
        exStringEquals(editDshrTukiTanKoumokuBean.getGyoumuKousinKinou(), "sisateisb", "業務用更新機能ＩＤ");

    }
}
