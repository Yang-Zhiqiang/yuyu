package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 資金移動用履歴テーブル作成クラスのメソッド {@link BzSikinIdouRirekiTblSakusei#editSikinIdouRirekiTblEntity(SikinIdouRirekiDataBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinIdouRirekiTblSakuseiTest_editSikinIdouRirekiTblEntity extends AbstractTest {

    @Inject
    private BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei;

    @Test
    @TestOrder(10)
    public void testEditSikinIdouRirekiTblEntity_A1() {

        SikinIdouRirekiDataBean sikinIdouRirekiDataBean = SWAKInjector.getInstance(SikinIdouRirekiDataBean.class);
        sikinIdouRirekiDataBean.setSyoriYmd(BizDate.valueOf("20201103"));
        sikinIdouRirekiDataBean.setSyono("17806000013");
        sikinIdouRirekiDataBean.setHenkouSikibetuKey("012345678901234567");
        sikinIdouRirekiDataBean.setTargetKinouId("bzSikinIdouRirekiTblSakusei");
        sikinIdouRirekiDataBean.setSkno("112345678901234567");
        sikinIdouRirekiDataBean.setSeikyuuRirekiNo(999);
        sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.SIHARAI);
        sikinIdouRirekiDataBean.setSyoricd("1234");
        sikinIdouRirekiDataBean.setDensysKbn(C_DensysKbn.HKSIHARAI);
        sikinIdouRirekiDataBean.setDenrenno("01234567890123456789");
        sikinIdouRirekiDataBean.setSeg1cd(C_Segcd.JPYNENKIN);
        sikinIdouRirekiDataBean.setKykTuukasyu(C_Tuukasyu.USD);
        sikinIdouRirekiDataBean.setSyutkKbn(C_SyutkKbn.SYU);
        sikinIdouRirekiDataBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        sikinIdouRirekiDataBean.setSyouhnCd("s999");
        sikinIdouRirekiDataBean.setSyouhnSdno(99);
        sikinIdouRirekiDataBean.setKykSyouhnRenno(98);
        sikinIdouRirekiDataBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        sikinIdouRirekiDataBean.setPhendouKaisiYm(BizDateYM.valueOf("202011"));
        sikinIdouRirekiDataBean.setPhendoumaeGk(BizCurrency.valueOf(Long.valueOf("1234567890001"), BizCurrencyTypes.DOLLAR));
        sikinIdouRirekiDataBean.setPhendougoGk(BizCurrency.valueOf(Long.valueOf("1234567890002"), BizCurrencyTypes.DOLLAR));
        sikinIdouRirekiDataBean.setKykYmd(BizDate.valueOf("20201028"));
        sikinIdouRirekiDataBean.setSeirituYmd(BizDate.valueOf("20201029"));
        sikinIdouRirekiDataBean.setSyoumetuYmd(BizDate.valueOf("20201030"));
        sikinIdouRirekiDataBean.setMisyuupJyuutouYm(BizDateYM.valueOf("202010"));
        sikinIdouRirekiDataBean.setShrsyoriKbn(C_ShrsyoriKbn.SONOTA);
        sikinIdouRirekiDataBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SDSSHR);
        sikinIdouRirekiDataBean.setSyoumetuJiyuu(C_Syoumetujiyuu.JIKOU);
        sikinIdouRirekiDataBean.setJkipjytYm(BizDateYM.valueOf("202011"));
        sikinIdouRirekiDataBean.setJyutouStartYm(BizDateYM.valueOf("202009"));
        sikinIdouRirekiDataBean.setJyutouEndYm(BizDateYM.valueOf("202010"));
        sikinIdouRirekiDataBean.setNykkeiro(C_Nykkeiro.OTHER);
        sikinIdouRirekiDataBean.setNyknaiyouKbn(C_NyknaiyouKbn.OTHER);
        sikinIdouRirekiDataBean.setNyktrksFlg(C_Nyktrksflg.TORIKESI);
        sikinIdouRirekiDataBean.setHrkp(BizCurrency.valueOf(Long.valueOf("1234567890003"), BizCurrencyTypes.DOLLAR));
        sikinIdouRirekiDataBean.setHokenryou(BizCurrency.valueOf(Long.valueOf("1234567890004"), BizCurrencyTypes.DOLLAR));

        BT_SikinIdouRireki sikinIdouRireki = bzSikinIdouRirekiTblSakusei.editSikinIdouRirekiTblEntity(sikinIdouRirekiDataBean);

        exDateEquals(sikinIdouRireki.getSyoriYmd(), BizDate.valueOf("20201103"), "処理年月日");
        exStringEquals(sikinIdouRireki.getKeirisyorirenno(), "", "経理用処理連番");
        exStringEquals(sikinIdouRireki.getSyono(), "17806000013", "証券番号");
        exStringEquals(sikinIdouRireki.getHenkousikibetukey(), "012345678901234567", "変更識別キー");
        exStringEquals(sikinIdouRireki.getTargetKinouId(), "bzSikinIdouRirekiTblSakusei", "対象機能ＩＤ");
        exStringEquals(sikinIdouRireki.getSkno(), "112345678901234567", "請求番号");
        exNumericEquals(sikinIdouRireki.getSeikyuurirekino(), 999, "請求履歴番号");
        exClassificationEquals(sikinIdouRireki.getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exClassificationEquals(sikinIdouRireki.getNykshrkbn(), C_NykshrKbn.SIHARAI, "入金支払区分");
        exStringEquals(sikinIdouRireki.getSyoricd(), "1234", "処理コード");
        exClassificationEquals(sikinIdouRireki.getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区");
        exStringEquals(sikinIdouRireki.getDenrenno(), "01234567890123456789", "伝票データ連番");
        exClassificationEquals(sikinIdouRireki.getSeg1cd(), C_Segcd.JPYNENKIN, "セグメント１コード");
        exClassificationEquals(sikinIdouRireki.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(sikinIdouRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(sikinIdouRireki.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exStringEquals(sikinIdouRireki.getSyouhncd(), "s999", "商品コード");
        exNumericEquals(sikinIdouRireki.getSyouhnsdno(), 99, "商品世代番号");
        exNumericEquals(sikinIdouRireki.getKyksyouhnrenno(), 98, "契約商品連番");
        exClassificationEquals(sikinIdouRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI, "支払方法指定区分");
        exDateYMEquals(sikinIdouRireki.getPhendoukaisiym(), BizDateYM.valueOf("202011"), "Ｐ変動開始年月");
        exBizCalcbleEquals(sikinIdouRireki.getPhendoumaegk(), BizCurrency.valueOf(Long.valueOf("1234567890001"), BizCurrencyTypes.DOLLAR), "Ｐ変動前金額");
        exBizCalcbleEquals(sikinIdouRireki.getPhendougogk(), BizCurrency.valueOf(Long.valueOf("1234567890002"), BizCurrencyTypes.DOLLAR), "Ｐ変動後金額");
        exDateEquals(sikinIdouRireki.getKykymd(), BizDate.valueOf("20201028"), "契約日");
        exDateEquals(sikinIdouRireki.getSeirituymd(), BizDate.valueOf("20201029"), "成立日");
        exDateEquals(sikinIdouRireki.getSyoumetuymd(), BizDate.valueOf("20201030"), "消滅日");
        exDateYMEquals(sikinIdouRireki.getMisyuupjyuutouym(), BizDateYM.valueOf("202010"), "未収保険料充当年月");
        exClassificationEquals(sikinIdouRireki.getShrsyorikbn(), C_ShrsyoriKbn.SONOTA, "支払処理区分");
        exClassificationEquals(sikinIdouRireki.getSeikyuusyubetu(), C_SeikyuuSyubetu.SDSSHR, "請求種別");
        exClassificationEquals(sikinIdouRireki.getSyoumetujiyuu(), C_Syoumetujiyuu.JIKOU, "消滅事由");
        exDateYMEquals(sikinIdouRireki.getJkipjytym(), BizDateYM.valueOf("202011"), "次回Ｐ充当年月");
        exDateYMEquals(sikinIdouRireki.getJyutoustartym(), BizDateYM.valueOf("202009"), "充当開始年月");
        exDateYMEquals(sikinIdouRireki.getJyutouendym(), BizDateYM.valueOf("202010"), "充当終了年月");
        exClassificationEquals(sikinIdouRireki.getNykkeiro(), C_Nykkeiro.OTHER, "入金経路");
        exClassificationEquals(sikinIdouRireki.getNyknaiyoukbn(), C_NyknaiyouKbn.OTHER, "入金内容区分");
        exClassificationEquals(sikinIdouRireki.getNyktrksflg(), C_Nyktrksflg.TORIKESI, "入金取消フラグ");
        exBizCalcbleEquals(sikinIdouRireki.getHrkp(), BizCurrency.valueOf(Long.valueOf("1234567890003"), BizCurrencyTypes.DOLLAR), "払込保険料");
        exBizCalcbleEquals(sikinIdouRireki.getHokenryou(), BizCurrency.valueOf(Long.valueOf("1234567890004"), BizCurrencyTypes.DOLLAR), "保険料");
    }
}
