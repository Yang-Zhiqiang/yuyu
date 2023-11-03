package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.siharai.edittbl.EditSkTbl;
import yuyu.common.siharai.edittbl.EditSkTblBean;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiNenkinInfoBean;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.edittbl.SkTblSetBean;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceBeanCommonParam;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HushrSyousaiKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KyhkinTaniKbn;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_NitigakuHokenKngkKbn;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SibouBasyoKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKyksyaTdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.entity.JT_NenkinInfo;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求TBL編集のメソッド{@link EditSkTbl#setEditKyhSkTbl(EditSkTblParam, EditSkTblBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSkTblTest_setEditKyhSkTbl {

    @Inject
    private EditSkTbl editSkTbl;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinouMode;

    @Test
    @TestOrder(10)
    public void testSetEditKyhSkTbl_A1() {

        EditSkTblBean editSkTblBean = new EditSkTblBean();
        try {
            editSkTbl.setEditKyhSkTbl(null, editSkTblBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pEditSkTblParam'", "エラーメッセージ");
        }

    }

    @Test
    @TestOrder(20)
    public void testSetEditKyhSkTbl_A2() {

        SiSeikyuusyaSindansyoParamImplTest siSeikyuusyaSindansyoParamImplTest = SWAKInjector
            .getInstance(SiSeikyuusyaSindansyoParamImplTest.class);

        try {
            editSkTbl.setEditKyhSkTbl(siSeikyuusyaSindansyoParamImplTest, null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pEditSkTblBean'", "エラーメッセージ");
        }

    }

    @Test
    @TestOrder(30)
    public void testSetEditKyhSkTbl_A3() {

        SiSeikyuusyaSindansyoParamImplTest siSeikyuusyaSindansyoParamImplTest = SWAKInjector
            .getInstance(SiSeikyuusyaSindansyoParamImplTest.class);

        EditSkTblBean editSkTblBean = new EditSkTblBean();
        editSkTblBean.setSkNo("");

        try {
            editSkTbl.setEditKyhSkTbl(siSeikyuusyaSindansyoParamImplTest, editSkTblBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='skNo'", "エラーメッセージ");
        }

    }

    @Test
    @TestOrder(40)
    public void testSetEditKyhSkTbl_A4() {

        SiSeikyuusyaSindansyoParamImplTest siSeikyuusyaSindansyoParamImplTest = SWAKInjector
            .getInstance(SiSeikyuusyaSindansyoParamImplTest.class);

        EditSkTblBean editSkTblBean = new EditSkTblBean();
        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("");

        try {
            editSkTbl.setEditKyhSkTbl(siSeikyuusyaSindansyoParamImplTest, editSkTblBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoNo'", "エラーメッセージ");
        }

    }

    @Test
    @TestOrder(50)
    public void testSetEditKyhSkTbl_A5() {

        SiSeikyuusyaSindansyoParamImplTest siSeikyuusyaSindansyoParamImplTest = SWAKInjector
            .getInstance(SiSeikyuusyaSindansyoParamImplTest.class);

        EditSkTblBean editSkTblBean = new EditSkTblBean();
        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(0);

        try {
            editSkTbl.setEditKyhSkTbl(siSeikyuusyaSindansyoParamImplTest, editSkTblBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuuRirekiNo'", "エラーメッセージ");
        }

    }

    @Test
    @TestOrder(60)
    public void testSetEditKyhSkTbl_A6() {

        SiSeikyuusyaSindansyoParamImplTest siSeikyuusyaSindansyoParamImplTest = SWAKInjector
            .getInstance(SiSeikyuusyaSindansyoParamImplTest.class);

        EditSkTblBean editSkTblBean = new EditSkTblBean();
        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(0);

        try {
            editSkTbl.setEditKyhSkTbl(siSeikyuusyaSindansyoParamImplTest, editSkTblBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='uketukeNo'", "エラーメッセージ");
        }

    }

    @Test
    @TestOrder(70)
    public void testSetEditKyhSkTbl_B1() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSeikyuusyaSindansyoParamImplTest siSeikyuusyaSindansyoParamImplTest = SWAKInjector
            .getInstance(SiSeikyuusyaSindansyoParamImplTest.class);
        siSeikyuusyaSindansyoParamImplTest.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        siSeikyuusyaSindansyoParamImplTest.setSeikyuusyanmkj("請求者（漢字）");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        SkTblSetBean skTblSetBean = SWAKInjector.getInstance(SkTblSetBean.class);
        skTblSetBean.setSyuhiyouhi(C_SyuhiYouhi.YOU);
        skTblSetBean.setSbjishrkbn(C_SbjiShrKbn.SBHOKENKIN);
        skTblSetBean.setUktkyksyatdk(C_UktKyksyaTdk.KYKIGAI);
        skTblSetBean.setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        skTblSetBean.setRikoukityuutuudannissuu(10);
        skTblSetBean.setTienrisokukisanymd(BizDate.valueOf(20160224));
        skTblSetBean.setTienrsknissuu(11);
        skTblSetBean.setKyktuukasyu(C_Tuukasyu.JPY);
        skTblSetBean.setShrtuukasyu(C_Tuukasyu.USD);
        skTblSetBean.setShrkwsratekjnymd(BizDate.valueOf(20160225));
        skTblSetBean.setShrkwsrate(BizNumber.valueOf(12));
        skTblSetBean.setZeimukwsratekjnymd(BizDate.valueOf(20160226));
        skTblSetBean.setZeimukwsrate(BizNumber.valueOf(13));
        skTblSetBean.setShrgk(BizCurrency.valueOf(11111));
        skTblSetBean.setHokenkngkgoukei(BizCurrency.valueOf(11112));
        skTblSetBean.setShrtienrsk(BizCurrency.valueOf(11113));
        skTblSetBean.setYenshrgk(BizCurrency.valueOf(11114));
        skTblSetBean.setYenhkgkgoukei(BizCurrency.valueOf(11115));
        skTblSetBean.setYenshrtienrsk(BizCurrency.valueOf(11116));
        skTblSetBean.setGoukeihituyoukeihi(BizCurrency.valueOf(11117));
        skTblSetBean.setKykhnkkaisuu(1);
        skTblSetBean.setShrkykhtykeihi(BizCurrency.valueOf(0));
        skTblSetBean.setMisyuupjyuutouym(BizDateYM.valueOf(201709));
        skTblSetBean.setMisyuupjyuutoukaisuuy(1);
        skTblSetBean.setMisyuupjyuutoukaisuum(2);
        skTblSetBean.setGaikaknsnkwsratekjymd(BizDate.valueOf(20171002));
        skTblSetBean.setGaikaknsnkwsrate(BizNumber.valueOf(14));
        skTblSetBean.setHaitoukin(BizCurrency.valueOf(11130));
        skTblSetBean.setSonotahaitoukin(BizCurrency.valueOf(11131));
        skTblSetBean.setMisyuup(BizCurrency.valueOf(11132));
        skTblSetBean.setMikeikap(BizCurrency.valueOf(11133));
        skTblSetBean.setZennouseisankgk(BizCurrency.valueOf(11134));
        skTblSetBean.setAzukarikingk(BizCurrency.valueOf(11135));
        skTblSetBean.setSonotaseisangk(BizCurrency.valueOf(11136));
        skTblSetBean.setKrkgk(BizCurrency.valueOf(11137));
        skTblSetBean.setYenkahaitoukin(BizCurrency.valueOf(11138));
        skTblSetBean.setYenkasonotahaitoukin(BizCurrency.valueOf(11139));
        skTblSetBean.setYenkamisyuup(BizCurrency.valueOf(11140));
        skTblSetBean.setYenkamikeikap(BizCurrency.valueOf(11141));
        skTblSetBean.setYenkazennouseisankgk(BizCurrency.valueOf(11142));
        skTblSetBean.setYenkaazukarikingk(BizCurrency.valueOf(11143));
        skTblSetBean.setYenkasonotaseisangk(BizCurrency.valueOf(11144));
        skTblSetBean.setYenkakrkgk(BizCurrency.valueOf(11145));
        skTblSetBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(11146));
        skTblSetBean.setZitkazukarikingkyen(BizCurrency.valueOf(11147));
        skTblSetBean.setGaikaknsntkgk(BizCurrency.valueOf(11148));
        skTblSetBean.setGaikaknsnkekkakgk(BizCurrency.valueOf(11149));
        skTblSetBean.setYenkaknsntkgk(BizCurrency.valueOf(11150));
        skTblSetBean.setYenkaknsnkekkakgk(BizCurrency.valueOf(11151));
        skTblSetBean.setMisyuusyonendojikaiikoup(BizCurrency.valueOf(11152));
        skTblSetBean.setMisyuujinendoikoup(BizCurrency.valueOf(11153));
        skTblSetBean.setMikeikapjyuutouym(BizDateYM.valueOf(201710));
        skTblSetBean.setMikeikapjyuutoukaisuuy(3);
        skTblSetBean.setMikeikapjyuutoukaisuum(4);
        skTblSetBean.setVhtnaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);

        editSkTblBean.setSkTblSetBean(skTblSetBean);

        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = SWAKInjector.getInstance(SiSiDetailParamBean.class);
        siSiDetailParamBean.setUketukeno(5);
        siSiDetailParamBean.setSyutkkbn(C_SyutkKbn.SYU);
        siSiDetailParamBean.setSyouhncd("1011");
        siSiDetailParamBean.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siSiDetailParamBean.setSyouhnsdno(14);
        siSiDetailParamBean.setKyksyouhnrenno(15);
        siSiDetailParamBean.setKyuuhucd("1111");
        siSiDetailParamBean.setRenno(16);
        siSiDetailParamBean.setKyuuhukbn(C_KyuuhuKbn.NYUUIN);
        siSiDetailParamBean.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        siSiDetailParamBean.setChecktaisyouumukbn(C_UmuKbn.ARI);
        siSiDetailParamBean.setNitigakuhokenkngkkbn(C_NitigakuHokenKngkKbn.NGAKU);
        siSiDetailParamBean.setNitigakuhokenkngk(BizCurrency.valueOf(11118));
        siSiDetailParamBean.setNissuubairitu(17);
        siSiDetailParamBean.setKyhkintanikbn(C_KyhkinTaniKbn.NITI);
        siSiDetailParamBean.setKyhkg(BizCurrency.valueOf(11119));
        siSiDetailParamBean.setYenkyhgk(BizCurrency.valueOf(11120));
        siSiDetailParamBean.setHutanponissuu(18);
        siSiDetailParamBean.setShrriyuugaitouymd(BizDate.valueOf(20160227));
        siSiDetailParamBean.setHknskgnkkntgtumukbn(C_UmuKbn.ARI);
        siSiDetailParamBean.setHokenkinshrwariai(BizNumber.valueOf(19));
        siSiDetailParamBean.setBikoumsg1("MSG１");
        siSiDetailParamBean.setBikoumsg2("MSG２");
        siSiDetailParamBean.setBikoumsg3("MSG３");
        siSiDetailParamBean.setBikoumsg4("MSG４");
        siSiDetailParamBean.setSyouhnnmgm("商品名（画面用）");
        siSiDetailParamBean.setSyouhnnmtyhy("商品名（帳票用）");
        siSiDetailParamBean.setKyuuhunamegamen("給付名（画面用）");
        siSiDetailParamBean.setKyuuhunamereport("給付名（帳票用）");
        siSiDetailParamBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siSiDetailParamBean.setHushrsyousaikbn(C_HushrSyousaiKbn.HTNPKKN);
        siSiDetailParamBean.setKyhkngkgoukei(BizCurrency.valueOf(11121));
        siSiDetailParamBean.setUtiwakeparam("AA");
        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        editSkTblBean.setSiSiDetailParamBeanLst(siSiDetailParamBeanLst);

        SiNenkinInfoBean siNenkinInfoBean = SWAKInjector.getInstance(SiNenkinInfoBean.class);
        siNenkinInfoBean.setNkkknsetymd(BizDate.valueOf(20160228));
        siNenkinInfoBean.setNkshrstartymd(BizDate.valueOf(20160229));
        siNenkinInfoBean.setNkshrtkyknksyukbn(C_Nstknsyu.KAKUTEINENKIN);
        siNenkinInfoBean.setNkshrtkyknksyukkn(20);
        siNenkinInfoBean.setBnshrkaisuu(C_Bnshrkaisuu.NEN12KAI);
        siNenkinInfoBean.setNkhaitoukinuketorihoukbn(C_NkHaitoukinuketorihouKbn.KAIMASI);
        siNenkinInfoBean.setTeinkkikingkgaika(BizCurrency.valueOf(11122));
        siNenkinInfoBean.setTeinkkikingken(BizCurrency.valueOf(11123));
        siNenkinInfoBean.setHtykeihi(BizCurrency.valueOf(11124));
        siNenkinInfoBean.setYenhtykeihi(BizCurrency.valueOf(11125));
        siNenkinInfoBean.setNknengk(BizCurrency.valueOf(11126));
        siNenkinInfoBean.setBnktnkgk(BizCurrency.valueOf(11127));

        editSkTblBean.setSiNenkinInfoBean(siNenkinInfoBean);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSeikyuusyaSindansyoParamImplTest, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        SkTblSetBean skTblSetBeanKekka = editSkTblBean.getSkTblSetBean();
        exClassificationEquals(skTblSetBeanKekka.getSyuhiyouhi(), C_SyuhiYouhi.YOU, "守秘要否");
        exClassificationEquals(skTblSetBeanKekka.getSbjishrkbn(), C_SbjiShrKbn.SBHOKENKIN, "死亡時支払区分");
        exClassificationEquals(skTblSetBeanKekka.getUktkyksyatdk(), C_UktKyksyaTdk.KYKIGAI, "受取人契約者続柄");
        exClassificationEquals(skTblSetBeanKekka.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BD5, "審査限度期間区分");
        exNumericEquals(skTblSetBeanKekka.getRikoukityuutuudannissuu(), 10, "履行期中断日数");
        exDateEquals(skTblSetBeanKekka.getTienrisokukisanymd(), BizDate.valueOf(20160224), "遅延利息起算日");
        exNumericEquals(skTblSetBeanKekka.getTienrsknissuu(), 11, "遅延利息日数");
        exClassificationEquals(skTblSetBeanKekka.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(skTblSetBeanKekka.getShrtuukasyu(), C_Tuukasyu.USD, "支払通貨種類");
        exDateEquals(skTblSetBeanKekka.getShrkwsratekjnymd(), BizDate.valueOf(20160225), "支払時為替レート基準日");
        exBizCalcbleEquals(skTblSetBeanKekka.getShrkwsrate(), BizNumber.valueOf(12), "支払時為替レート");
        exDateEquals(skTblSetBeanKekka.getZeimukwsratekjnymd(), BizDate.valueOf(20160226), "税務用為替レート基準日");
        exBizCalcbleEquals(skTblSetBeanKekka.getZeimukwsrate(), BizNumber.valueOf(13), "税務用為替レート");
        exBizCalcbleEquals(skTblSetBeanKekka.getShrgk(), BizCurrency.valueOf(11111), "支払金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getHokenkngkgoukei(), BizCurrency.valueOf(11112), "保険金額合計");
        exBizCalcbleEquals(skTblSetBeanKekka.getShrtienrsk(), BizCurrency.valueOf(11113), "支払遅延利息");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenshrgk(), BizCurrency.valueOf(11114), "円換算支払金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenhkgkgoukei(), BizCurrency.valueOf(11115), "円換算保険金額合計");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenshrtienrsk(), BizCurrency.valueOf(11116), "円換算支払遅延利息");
        exBizCalcbleEquals(skTblSetBeanKekka.getGoukeihituyoukeihi(), BizCurrency.valueOf(11117), "合計必要経費");
        exNumericEquals(skTblSetBeanKekka.getKykhnkkaisuu(), 1, "契約者変更回数");
        exBizCalcbleEquals(skTblSetBeanKekka.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exDateYMEquals(skTblSetBeanKekka.getMisyuupjyuutouym(), BizDateYM.valueOf(201709), "未収保険料充当年月");
        exNumericEquals(skTblSetBeanKekka.getMisyuupjyuutoukaisuuy(), 1, "未収保険料充当回数（年）");
        exNumericEquals(skTblSetBeanKekka.getMisyuupjyuutoukaisuum(), 2, "未収保険料充当回数（月）");
        exDateEquals(skTblSetBeanKekka.getGaikaknsnkwsratekjymd(), BizDate.valueOf(20171002), "外貨換算為替レート基準日");
        exBizCalcbleEquals(skTblSetBeanKekka.getGaikaknsnkwsrate(), BizNumber.valueOf(14), "外貨換算為替レート");
        exBizCalcbleEquals(skTblSetBeanKekka.getHaitoukin(), BizCurrency.valueOf(11130), "配当金");
        exBizCalcbleEquals(skTblSetBeanKekka.getSonotahaitoukin(), BizCurrency.valueOf(11131), "その他配当金");
        exBizCalcbleEquals(skTblSetBeanKekka.getMisyuup(), BizCurrency.valueOf(11132), "未収保険料");
        exBizCalcbleEquals(skTblSetBeanKekka.getMikeikap(), BizCurrency.valueOf(11133), "未経過保険料");
        exBizCalcbleEquals(skTblSetBeanKekka.getZennouseisankgk(), BizCurrency.valueOf(11134), "前納精算金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getAzukarikingk(), BizCurrency.valueOf(11135), "預り金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getSonotaseisangk(), BizCurrency.valueOf(11136), "その他精算額");
        exBizCalcbleEquals(skTblSetBeanKekka.getKrkgk(), BizCurrency.valueOf(11137), "仮受金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkahaitoukin(), BizCurrency.valueOf(11138), "円貨配当金");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkasonotahaitoukin(), BizCurrency.valueOf(11139), "円貨その他配当金");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkamisyuup(), BizCurrency.valueOf(11140), "円貨未収保険料");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkamikeikap(), BizCurrency.valueOf(11141), "円貨未経過保険料");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkazennouseisankgk(), BizCurrency.valueOf(11142), "円貨前納精算金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkaazukarikingk(), BizCurrency.valueOf(11143), "円貨預り金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkasonotaseisangk(), BizCurrency.valueOf(11144), "円貨その他精算額");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkakrkgk(), BizCurrency.valueOf(11145), "円貨仮受金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(11146), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(skTblSetBeanKekka.getZitkazukarikingkyen(), BizCurrency.valueOf(11147), "税適預り金額（円貨）");
        exBizCalcbleEquals(skTblSetBeanKekka.getGaikaknsntkgk(), BizCurrency.valueOf(11148), "外貨換算対象金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getGaikaknsnkekkakgk(), BizCurrency.valueOf(11149), "外貨換算結果金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkaknsntkgk(), BizCurrency.valueOf(11150), "円貨換算対象金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getYenkaknsnkekkakgk(), BizCurrency.valueOf(11151), "円貨換算結果金額");
        exBizCalcbleEquals(skTblSetBeanKekka.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(11152), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(skTblSetBeanKekka.getMisyuujinendoikoup(), BizCurrency.valueOf(11153), "未収次年度以降Ｐ");
        exDateYMEquals(skTblSetBeanKekka.getMikeikapjyuutouym(), BizDateYM.valueOf(201710), "未経過保険料充当年月");
        exNumericEquals(skTblSetBeanKekka.getMikeikapjyuutoukaisuuy(), 3, "未経過保険料充当回数（年）");
        exNumericEquals(skTblSetBeanKekka.getMikeikapjyuutoukaisuum(), 4, "未経過保険料充当回数（月）");
        exClassificationEquals(skTblSetBeanKekka.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "（配当金情報）内定確定区分");

        List<SiSiDetailParamBean> siSiDetailParamBeanKekkaLst = editSkTblBean.getSiSiDetailParamBeanLst();
        exNumericEquals(siSiDetailParamBeanKekkaLst.size(), 1, "支払明細パラメータBeanリスト");
        SiSiDetailParamBean siSiDetailParamBeanKekka = siSiDetailParamBeanKekkaLst.get(0);
        exNumericEquals(siSiDetailParamBeanKekka.getUketukeno(), 5, "受付番号");
        exClassificationEquals(siSiDetailParamBeanKekka.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBeanKekka.getSyouhncd(), "1011", "商品コード");
        exClassificationEquals(siSiDetailParamBeanKekka.getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE60, "給付限度型区分");
        exNumericEquals(siSiDetailParamBeanKekka.getSyouhnsdno(), 14, "商品世代番号");
        exNumericEquals(siSiDetailParamBeanKekka.getKyksyouhnrenno(), 15, "契約商品連番");
        exStringEquals(siSiDetailParamBeanKekka.getKyuuhucd(), "1111", "給付コード");
        exNumericEquals(siSiDetailParamBeanKekka.getRenno(), 16, "連番");
        exClassificationEquals(siSiDetailParamBeanKekka.getKyuuhukbn(), C_KyuuhuKbn.NYUUIN, "給付区分");
        exClassificationEquals(siSiDetailParamBeanKekka.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBeanKekka.getChecktaisyouumukbn(), C_UmuKbn.ARI, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBeanKekka.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.NGAKU,
            "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getNitigakuhokenkngk(), BizCurrency.valueOf(11118), "日額・保険金額");
        exNumericEquals(siSiDetailParamBeanKekka.getNissuubairitu(), 17, "日数・倍率");
        exClassificationEquals(siSiDetailParamBeanKekka.getKyhkintanikbn(), C_KyhkinTaniKbn.NITI, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getKyhkg(), BizCurrency.valueOf(11119), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getYenkyhgk(), BizCurrency.valueOf(11120), "円換算給付金額");
        exNumericEquals(siSiDetailParamBeanKekka.getHutanponissuu(), 18, "不担保日数");
        exDateEquals(siSiDetailParamBeanKekka.getShrriyuugaitouymd(), BizDate.valueOf(20160227), "支払理由該当日");
        exClassificationEquals(siSiDetailParamBeanKekka.getHknskgnkkntgtumukbn(), C_UmuKbn.ARI, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getHokenkinshrwariai(), BizNumber.valueOf(19), "保険金支払割合");
        exStringEquals(siSiDetailParamBeanKekka.getBikoumsg1(), "MSG１", "備考MSG１");
        exStringEquals(siSiDetailParamBeanKekka.getBikoumsg2(), "MSG２", "備考MSG２");
        exStringEquals(siSiDetailParamBeanKekka.getBikoumsg3(), "MSG３", "備考MSG３");
        exStringEquals(siSiDetailParamBeanKekka.getBikoumsg4(), "MSG４", "備考MSG４");
        exStringEquals(siSiDetailParamBeanKekka.getSyouhnnmgm(), "商品名（画面用）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBeanKekka.getSyouhnnmtyhy(), "商品名（帳票用）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBeanKekka.getKyuuhunamegamen(), "給付名（画面用）", "給付名（画面用）");
        exStringEquals(siSiDetailParamBeanKekka.getKyuuhunamereport(), "給付名（帳票用）", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBeanKekka.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBeanKekka.getHushrsyousaikbn(), C_HushrSyousaiKbn.HTNPKKN, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getKyhkngkgoukei(), BizCurrency.valueOf(11121), "給付金額合計");
        exStringEquals(siSiDetailParamBeanKekka.getUtiwakeparam(), "AA", "内訳パラメータ");

        SiNenkinInfoBean siNenkinInfoBeanKekka = editSkTblBean.getSiNenkinInfoBean();
        exDateEquals(siNenkinInfoBeanKekka.getNkkknsetymd(), BizDate.valueOf(20160228), "年金基金設定日");
        exDateEquals(siNenkinInfoBeanKekka.getNkshrstartymd(), BizDate.valueOf(20160229), "年金支払開始日");
        exClassificationEquals(siNenkinInfoBeanKekka.getNkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN,
            "年金支払特約年金種類区分");
        exNumericEquals(siNenkinInfoBeanKekka.getNkshrtkyknksyukkn(), 20, "年金支払特約年金期間");
        exClassificationEquals(siNenkinInfoBeanKekka.getBnshrkaisuu(), C_Bnshrkaisuu.NEN12KAI, "分割支払回数");
        exClassificationEquals(siNenkinInfoBeanKekka.getNkhaitoukinuketorihoukbn(), C_NkHaitoukinuketorihouKbn.KAIMASI,
            "年金配当金受取方法区分");
        exBizCalcbleEquals(siNenkinInfoBeanKekka.getTeinkkikingkgaika(), BizCurrency.valueOf(11122), "定額年金年金基金額（外貨）");
        exBizCalcbleEquals(siNenkinInfoBeanKekka.getTeinkkikingken(), BizCurrency.valueOf(11123), "定額年金年金基金額（円貨）");
        exBizCalcbleEquals(siNenkinInfoBeanKekka.getHtykeihi(), BizCurrency.valueOf(11124), "必要経費");
        exBizCalcbleEquals(siNenkinInfoBeanKekka.getYenhtykeihi(), BizCurrency.valueOf(11125), "円換算必要経費");
        exBizCalcbleEquals(siNenkinInfoBeanKekka.getNknengk(), BizCurrency.valueOf(11126), "年金年額");
        exBizCalcbleEquals(siNenkinInfoBeanKekka.getBnktnkgk(), BizCurrency.valueOf(11127), "分割年金額");

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(skKekka.getSeikyuusyakbn(), C_SeikyuusyaKbn.UKTHONNIN, "請求者区分");
        exClassificationEquals(skKekka.getSyuhiyouhi(), C_SyuhiYouhi.YOU, "守秘要否");
        exStringEquals(skKekka.getSeikyuusyanmkj(), "請求者（漢字）", "請求者（漢字）");
        exClassificationEquals(skKekka.getSbjishrkbn(), C_SbjiShrKbn.SBHOKENKIN, "死亡時支払区分");
        exClassificationEquals(skKekka.getUktkyksyatdk(), C_UktKyksyaTdk.KYKIGAI, "受取人契約者続柄");
        exClassificationEquals(skKekka.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BD5, "審査限度期間区分");
        exNumericEquals(skKekka.getRikoukityuutuudannissuu(), 10, "履行期中断日数");
        exDateEquals(skKekka.getTienrisokukisanymd(), BizDate.valueOf(20160224), "遅延利息起算日");
        exNumericEquals(skKekka.getTienrsknissuu(), 11, "遅延利息日数");
        exClassificationEquals(skKekka.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(skKekka.getShrtuukasyu(), C_Tuukasyu.USD, "支払通貨種類");
        exDateEquals(skKekka.getShrkwsratekjnymd(), BizDate.valueOf(20160225), "支払時為替レート基準日");
        exBizCalcbleEquals(skKekka.getShrkwsrate(), BizNumber.valueOf(12), "支払時為替レート");
        exDateEquals(skKekka.getZeimukwsratekjnymd(), BizDate.valueOf(20160226), "税務用為替レート基準日");
        exBizCalcbleEquals(skKekka.getZeimukwsrate(), BizNumber.valueOf(13), "税務用為替レート");
        exBizCalcbleEquals(skKekka.getShrgk(), BizCurrency.valueOf(11111), "支払金額");
        exBizCalcbleEquals(skKekka.getHokenkngkgoukei(), BizCurrency.valueOf(11112), "保険金額合計");
        exBizCalcbleEquals(skKekka.getShrtienrsk(), BizCurrency.valueOf(11113), "支払遅延利息");
        exBizCalcbleEquals(skKekka.getYenshrgk(), BizCurrency.valueOf(11114), "円換算支払金額");
        exBizCalcbleEquals(skKekka.getYenhkgkgoukei(), BizCurrency.valueOf(11115), "円換算保険金額合計");
        exBizCalcbleEquals(skKekka.getYenshrtienrsk(), BizCurrency.valueOf(11116), "円換算支払遅延利息");
        exBizCalcbleEquals(skKekka.getGoukeihituyoukeihi(), BizCurrency.valueOf(11117), "合計必要経費");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        List<JT_SiDetail> siDetailKekkaLst = editSkTblBean.getSiDetailLst();
        exNumericEquals(siDetailKekkaLst.size(), 1, "支払明細TBLリスト");
        JT_SiDetail siDetailKekka = siDetailKekkaLst.get(0);
        exStringEquals(siDetailKekka.getSkno(), "1001", "請求番号");
        exStringEquals(siDetailKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(siDetailKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exNumericEquals(siDetailKekka.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siDetailKekka.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siDetailKekka.getSyouhncd(), "1011", "商品コード");
        exClassificationEquals(siDetailKekka.getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE60, "給付限度型区分");
        exNumericEquals(siDetailKekka.getSyouhnsdno(), 14, "商品世代番号");
        exNumericEquals(siDetailKekka.getKyksyouhnrenno(), 15, "契約商品連番");
        exStringEquals(siDetailKekka.getKyuuhucd(), "1111", "給付コード");
        exNumericEquals(siDetailKekka.getRenno(), 1, "連番");
        exClassificationEquals(siDetailKekka.getKyuuhukbn(), C_KyuuhuKbn.NYUUIN, "給付区分");
        exClassificationEquals(siDetailKekka.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exClassificationEquals(siDetailKekka.getChecktaisyouumukbn(), C_UmuKbn.ARI, "チェック対象有無区分");
        exClassificationEquals(siDetailKekka.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.NGAKU,
            "日額・保険金額区分");
        exBizCalcbleEquals(siDetailKekka.getNitigakuhokenkngk(), BizCurrency.valueOf(11118), "日額・保険金額");
        exNumericEquals(siDetailKekka.getNissuubairitu(), 17, "日数・倍率");
        exClassificationEquals(siDetailKekka.getKyhkintanikbn(), C_KyhkinTaniKbn.NITI, "給付金単位区分");
        exBizCalcbleEquals(siDetailKekka.getKyhkg(), BizCurrency.valueOf(11119), "給付金額");
        exBizCalcbleEquals(siDetailKekka.getYenkyhgk(), BizCurrency.valueOf(11120), "円換算給付金額");
        exNumericEquals(siDetailKekka.getHutanponissuu(), 18, "不担保日数");
        exDateEquals(siDetailKekka.getShrriyuugaitouymd(), BizDate.valueOf(20160227), "支払理由該当日");
        exClassificationEquals(siDetailKekka.getHknskgnkkntgtumukbn(), C_UmuKbn.ARI, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siDetailKekka.getHokenkinshrwariai(), BizNumber.valueOf(19), "保険金支払割合");
        exStringEquals(siDetailKekka.getBikoumsg1(), "MSG１", "備考MSG１");
        exStringEquals(siDetailKekka.getBikoumsg2(), "MSG２", "備考MSG２");
        exStringEquals(siDetailKekka.getBikoumsg3(), "MSG３", "備考MSG３");
        exStringEquals(siDetailKekka.getBikoumsg4(), "MSG４", "備考MSG４");
        exStringEquals(siDetailKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(siDetailKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(siDetailKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        JT_NenkinInfo nenkinInfoKekka = editSkTblBean.getNenkinInfo();
        exStringEquals(nenkinInfoKekka.getSkno(), "1001", "請求番号");
        exStringEquals(nenkinInfoKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(nenkinInfoKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exDateEquals(nenkinInfoKekka.getNkkknsetymd(), BizDate.valueOf(20160228), "年金基金設定日");
        exDateEquals(nenkinInfoKekka.getNkshrstartymd(), BizDate.valueOf(20160229), "年金支払開始日");
        exClassificationEquals(nenkinInfoKekka.getNkshrtkyknksyukbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(nenkinInfoKekka.getNkshrtkyknksyukkn(), 20, "年金支払特約年金期間");
        exClassificationEquals(nenkinInfoKekka.getBnshrkaisuu(), C_Bnshrkaisuu.NEN12KAI, "分割支払回数");
        exClassificationEquals(nenkinInfoKekka.getNkhaitoukinuketorihoukbn(), C_NkHaitoukinuketorihouKbn.KAIMASI,
            "年金配当金受取方法区分");
        exBizCalcbleEquals(nenkinInfoKekka.getTeinkkikingkgaika(), BizCurrency.valueOf(11122), "定額年金年金基金額（外貨）");
        exBizCalcbleEquals(nenkinInfoKekka.getTeinkkikingken(), BizCurrency.valueOf(11123), "定額年金年金基金額（円貨）");
        exBizCalcbleEquals(nenkinInfoKekka.getHtykeihi(), BizCurrency.valueOf(11124), "必要経費");
        exBizCalcbleEquals(nenkinInfoKekka.getYenhtykeihi(), BizCurrency.valueOf(11125), "円換算必要経費");
        exBizCalcbleEquals(nenkinInfoKekka.getNknengk(), BizCurrency.valueOf(11126), "年金年額");
        exBizCalcbleEquals(nenkinInfoKekka.getBnktnkgk(), BizCurrency.valueOf(11127), "分割年金額");
        exStringEquals(nenkinInfoKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(nenkinInfoKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(nenkinInfoKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(80)
    public void testSetEditKyhSkTbl_B2() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSouhusakiSindansyoParamImplTest siSouhusakiSindansyoParamImplTest = SWAKInjector
            .getInstance(SiSouhusakiSindansyoParamImplTest.class);

        siSouhusakiSindansyoParamImplTest.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        siSouhusakiSindansyoParamImplTest.setTsinyno("12345678");
        siSouhusakiSindansyoParamImplTest.setTsinadr1kj("住所１");
        siSouhusakiSindansyoParamImplTest.setTsinadr2kj("住所２");
        siSouhusakiSindansyoParamImplTest.setTsinadr3kj("住所３");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        SkTblSetBean skTblSetBean = SWAKInjector.getInstance(SkTblSetBean.class);
        skTblSetBean.setShrtuukasyu(C_Tuukasyu.JPY);
        editSkTblBean.setSkTblSetBean(skTblSetBean);

        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = SWAKInjector.getInstance(SiSiDetailParamBean.class);
        siSiDetailParamBean.setUketukeno(1);
        siSiDetailParamBean.setSyutkkbn(C_SyutkKbn.SYU);
        siSiDetailParamBean.setSyouhncd("1011");
        siSiDetailParamBean.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siSiDetailParamBean.setSyouhnsdno(14);
        siSiDetailParamBean.setKyksyouhnrenno(15);
        siSiDetailParamBean.setKyuuhucd("1111");
        siSiDetailParamBean.setRenno(16);
        siSiDetailParamBean.setKyuuhukbn(C_KyuuhuKbn.NYUUIN);
        siSiDetailParamBean.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        siSiDetailParamBean.setChecktaisyouumukbn(C_UmuKbn.ARI);
        siSiDetailParamBean.setNitigakuhokenkngkkbn(C_NitigakuHokenKngkKbn.NGAKU);
        siSiDetailParamBean.setNitigakuhokenkngk(BizCurrency.valueOf(11118));
        siSiDetailParamBean.setNissuubairitu(17);
        siSiDetailParamBean.setKyhkintanikbn(C_KyhkinTaniKbn.NITI);
        siSiDetailParamBean.setKyhkg(BizCurrency.valueOf(11119));
        siSiDetailParamBean.setYenkyhgk(BizCurrency.valueOf(11120));
        siSiDetailParamBean.setHutanponissuu(18);
        siSiDetailParamBean.setShrriyuugaitouymd(BizDate.valueOf(20160227));
        siSiDetailParamBean.setHknskgnkkntgtumukbn(C_UmuKbn.ARI);
        siSiDetailParamBean.setHokenkinshrwariai(BizNumber.valueOf(19));
        siSiDetailParamBean.setBikoumsg1("MSG１");
        siSiDetailParamBean.setBikoumsg2("MSG２");
        siSiDetailParamBean.setBikoumsg3("MSG３");
        siSiDetailParamBean.setBikoumsg4("MSG４");
        siSiDetailParamBean.setSyouhnnmgm("商品名（画面用）");
        siSiDetailParamBean.setSyouhnnmtyhy("商品名（帳票用）");
        siSiDetailParamBean.setKyuuhunamegamen("給付名（画面用）");
        siSiDetailParamBean.setKyuuhunamereport("給付名（帳票用）");
        siSiDetailParamBean.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siSiDetailParamBean.setHushrsyousaikbn(C_HushrSyousaiKbn.HTNPKKN);
        siSiDetailParamBean.setKyhkngkgoukei(BizCurrency.valueOf(11121));
        siSiDetailParamBean.setUtiwakeparam("AA");
        siSiDetailParamBeanLst.add(siSiDetailParamBean);
        SiSiDetailParamBean siSiDetailParamBean2 = SWAKInjector.getInstance(SiSiDetailParamBean.class);
        siSiDetailParamBean2.setUketukeno(2);
        siSiDetailParamBean2.setSyutkkbn(C_SyutkKbn.SYU);
        siSiDetailParamBean2.setSyouhncd("1012");
        siSiDetailParamBean2.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siSiDetailParamBean2.setSyouhnsdno(24);
        siSiDetailParamBean2.setKyksyouhnrenno(25);
        siSiDetailParamBean2.setKyuuhucd("1112");
        siSiDetailParamBean2.setRenno(26);
        siSiDetailParamBean2.setKyuuhukbn(C_KyuuhuKbn.NYUUIN);
        siSiDetailParamBean2.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        siSiDetailParamBean2.setChecktaisyouumukbn(C_UmuKbn.ARI);
        siSiDetailParamBean2.setNitigakuhokenkngkkbn(C_NitigakuHokenKngkKbn.NGAKU);
        siSiDetailParamBean2.setNitigakuhokenkngk(BizCurrency.valueOf(21118));
        siSiDetailParamBean2.setNissuubairitu(27);
        siSiDetailParamBean2.setKyhkintanikbn(C_KyhkinTaniKbn.NITI);
        siSiDetailParamBean2.setKyhkg(BizCurrency.valueOf(21119));
        siSiDetailParamBean2.setYenkyhgk(BizCurrency.valueOf(21120));
        siSiDetailParamBean2.setHutanponissuu(28);
        siSiDetailParamBean2.setShrriyuugaitouymd(BizDate.valueOf(20160327));
        siSiDetailParamBean2.setHknskgnkkntgtumukbn(C_UmuKbn.ARI);
        siSiDetailParamBean2.setHokenkinshrwariai(BizNumber.valueOf(29));
        siSiDetailParamBean2.setBikoumsg1("MSG５");
        siSiDetailParamBean2.setBikoumsg2("MSG６");
        siSiDetailParamBean2.setBikoumsg3("MSG７");
        siSiDetailParamBean2.setBikoumsg4("MSG８");
        siSiDetailParamBean2.setSyouhnnmgm("商品名（画面用）");
        siSiDetailParamBean2.setSyouhnnmtyhy("商品名（帳票用）");
        siSiDetailParamBean2.setKyuuhunamegamen("給付名（画面用）");
        siSiDetailParamBean2.setKyuuhunamereport("給付名（帳票用）");
        siSiDetailParamBean2.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siSiDetailParamBean2.setHushrsyousaikbn(C_HushrSyousaiKbn.HTNPKKN);
        siSiDetailParamBean2.setKyhkngkgoukei(BizCurrency.valueOf(11121));
        siSiDetailParamBean2.setUtiwakeparam("AA");
        siSiDetailParamBeanLst.add(siSiDetailParamBean2);
        SiSiDetailParamBean siSiDetailParamBean3 = SWAKInjector.getInstance(SiSiDetailParamBean.class);
        siSiDetailParamBean3.setUketukeno(3);
        siSiDetailParamBean3.setSyutkkbn(C_SyutkKbn.SYU);
        siSiDetailParamBean3.setSyouhncd("1013");
        siSiDetailParamBean3.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siSiDetailParamBean3.setSyouhnsdno(34);
        siSiDetailParamBean3.setKyksyouhnrenno(35);
        siSiDetailParamBean3.setKyuuhucd("1113");
        siSiDetailParamBean3.setRenno(36);
        siSiDetailParamBean3.setKyuuhukbn(C_KyuuhuKbn.NYUUIN);
        siSiDetailParamBean3.setKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        siSiDetailParamBean3.setChecktaisyouumukbn(C_UmuKbn.ARI);
        siSiDetailParamBean3.setNitigakuhokenkngkkbn(C_NitigakuHokenKngkKbn.NGAKU);
        siSiDetailParamBean3.setNitigakuhokenkngk(BizCurrency.valueOf(31118));
        siSiDetailParamBean3.setNissuubairitu(37);
        siSiDetailParamBean3.setKyhkintanikbn(C_KyhkinTaniKbn.NITI);
        siSiDetailParamBean3.setKyhkg(BizCurrency.valueOf(31119));
        siSiDetailParamBean3.setYenkyhgk(BizCurrency.valueOf(31120));
        siSiDetailParamBean3.setHutanponissuu(38);
        siSiDetailParamBean3.setShrriyuugaitouymd(BizDate.valueOf(20160427));
        siSiDetailParamBean3.setHknskgnkkntgtumukbn(C_UmuKbn.ARI);
        siSiDetailParamBean3.setHokenkinshrwariai(BizNumber.valueOf(39));
        siSiDetailParamBean3.setBikoumsg1("MSG９");
        siSiDetailParamBean3.setBikoumsg2("MSG１０");
        siSiDetailParamBean3.setBikoumsg3("MSG１１");
        siSiDetailParamBean3.setBikoumsg4("MSG１２");
        siSiDetailParamBean3.setSyouhnnmgm("商品名（画面用）");
        siSiDetailParamBean3.setSyouhnnmtyhy("商品名（帳票用）");
        siSiDetailParamBean3.setKyuuhunamegamen("給付名（画面用）");
        siSiDetailParamBean3.setKyuuhunamereport("給付名（帳票用）");
        siSiDetailParamBean3.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siSiDetailParamBean3.setHushrsyousaikbn(C_HushrSyousaiKbn.HTNPKKN);
        siSiDetailParamBean3.setKyhkngkgoukei(BizCurrency.valueOf(11121));
        siSiDetailParamBean3.setUtiwakeparam("AA");
        siSiDetailParamBeanLst.add(siSiDetailParamBean3);

        editSkTblBean.setSiSiDetailParamBeanLst(siSiDetailParamBeanLst);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSouhusakiSindansyoParamImplTest, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        SkTblSetBean skTblSetBeanKekka = editSkTblBean.getSkTblSetBean();
        exClassificationEquals(skTblSetBeanKekka.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");

        List<SiSiDetailParamBean> siSiDetailParamBeanKekkaLst = editSkTblBean.getSiSiDetailParamBeanLst();
        exNumericEquals(siSiDetailParamBeanKekkaLst.size(), 3, "支払明細パラメータBeanリスト");
        SiSiDetailParamBean siSiDetailParamBeanKekka = siSiDetailParamBeanKekkaLst.get(0);
        exNumericEquals(siSiDetailParamBeanKekka.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBeanKekka.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBeanKekka.getSyouhncd(), "1011", "商品コード");
        exClassificationEquals(siSiDetailParamBeanKekka.getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE60, "給付限度型区分");
        exNumericEquals(siSiDetailParamBeanKekka.getSyouhnsdno(), 14, "商品世代番号");
        exNumericEquals(siSiDetailParamBeanKekka.getKyksyouhnrenno(), 15, "契約商品連番");
        exStringEquals(siSiDetailParamBeanKekka.getKyuuhucd(), "1111", "給付コード");
        exNumericEquals(siSiDetailParamBeanKekka.getRenno(), 16, "連番");
        exClassificationEquals(siSiDetailParamBeanKekka.getKyuuhukbn(), C_KyuuhuKbn.NYUUIN, "給付区分");
        exClassificationEquals(siSiDetailParamBeanKekka.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBeanKekka.getChecktaisyouumukbn(), C_UmuKbn.ARI, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBeanKekka.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.NGAKU,
            "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getNitigakuhokenkngk(), BizCurrency.valueOf(11118), "日額・保険金額");
        exNumericEquals(siSiDetailParamBeanKekka.getNissuubairitu(), 17, "日数・倍率");
        exClassificationEquals(siSiDetailParamBeanKekka.getKyhkintanikbn(), C_KyhkinTaniKbn.NITI, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getKyhkg(), BizCurrency.valueOf(11119), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getYenkyhgk(), BizCurrency.valueOf(11120), "円換算給付金額");
        exNumericEquals(siSiDetailParamBeanKekka.getHutanponissuu(), 18, "不担保日数");
        exDateEquals(siSiDetailParamBeanKekka.getShrriyuugaitouymd(), BizDate.valueOf(20160227), "支払理由該当日");
        exClassificationEquals(siSiDetailParamBeanKekka.getHknskgnkkntgtumukbn(), C_UmuKbn.ARI, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getHokenkinshrwariai(), BizNumber.valueOf(19), "保険金支払割合");
        exStringEquals(siSiDetailParamBeanKekka.getBikoumsg1(), "MSG１", "備考MSG１");
        exStringEquals(siSiDetailParamBeanKekka.getBikoumsg2(), "MSG２", "備考MSG２");
        exStringEquals(siSiDetailParamBeanKekka.getBikoumsg3(), "MSG３", "備考MSG３");
        exStringEquals(siSiDetailParamBeanKekka.getBikoumsg4(), "MSG４", "備考MSG４");
        exStringEquals(siSiDetailParamBeanKekka.getSyouhnnmgm(), "商品名（画面用）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBeanKekka.getSyouhnnmtyhy(), "商品名（帳票用）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBeanKekka.getKyuuhunamegamen(), "給付名（画面用）", "給付名（画面用）");
        exStringEquals(siSiDetailParamBeanKekka.getKyuuhunamereport(), "給付名（帳票用）", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBeanKekka.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBeanKekka.getHushrsyousaikbn(), C_HushrSyousaiKbn.HTNPKKN, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka.getKyhkngkgoukei(), BizCurrency.valueOf(11121), "給付金額合計");
        exStringEquals(siSiDetailParamBeanKekka.getUtiwakeparam(), "AA", "内訳パラメータ");
        SiSiDetailParamBean siSiDetailParamBeanKekka2 = siSiDetailParamBeanKekkaLst.get(1);
        exNumericEquals(siSiDetailParamBeanKekka2.getUketukeno(), 2, "受付番号");
        exClassificationEquals(siSiDetailParamBeanKekka2.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBeanKekka2.getSyouhncd(), "1012", "商品コード");
        exClassificationEquals(siSiDetailParamBeanKekka2.getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE60, "給付限度型区分");
        exNumericEquals(siSiDetailParamBeanKekka2.getSyouhnsdno(), 24, "商品世代番号");
        exNumericEquals(siSiDetailParamBeanKekka2.getKyksyouhnrenno(), 25, "契約商品連番");
        exStringEquals(siSiDetailParamBeanKekka2.getKyuuhucd(), "1112", "給付コード");
        exNumericEquals(siSiDetailParamBeanKekka2.getRenno(), 26, "連番");
        exClassificationEquals(siSiDetailParamBeanKekka2.getKyuuhukbn(), C_KyuuhuKbn.NYUUIN, "給付区分");
        exClassificationEquals(siSiDetailParamBeanKekka2.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBeanKekka2.getChecktaisyouumukbn(), C_UmuKbn.ARI, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBeanKekka2.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.NGAKU,
            "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka2.getNitigakuhokenkngk(), BizCurrency.valueOf(21118), "日額・保険金額");
        exNumericEquals(siSiDetailParamBeanKekka2.getNissuubairitu(), 27, "日数・倍率");
        exClassificationEquals(siSiDetailParamBeanKekka2.getKyhkintanikbn(), C_KyhkinTaniKbn.NITI, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka2.getKyhkg(), BizCurrency.valueOf(21119), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBeanKekka2.getYenkyhgk(), BizCurrency.valueOf(21120), "円換算給付金額");
        exNumericEquals(siSiDetailParamBeanKekka2.getHutanponissuu(), 28, "不担保日数");
        exDateEquals(siSiDetailParamBeanKekka2.getShrriyuugaitouymd(), BizDate.valueOf(20160327), "支払理由該当日");
        exClassificationEquals(siSiDetailParamBeanKekka2.getHknskgnkkntgtumukbn(), C_UmuKbn.ARI, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka2.getHokenkinshrwariai(), BizNumber.valueOf(29), "保険金支払割合");
        exStringEquals(siSiDetailParamBeanKekka2.getBikoumsg1(), "MSG５", "備考MSG１");
        exStringEquals(siSiDetailParamBeanKekka2.getBikoumsg2(), "MSG６", "備考MSG２");
        exStringEquals(siSiDetailParamBeanKekka2.getBikoumsg3(), "MSG７", "備考MSG３");
        exStringEquals(siSiDetailParamBeanKekka2.getBikoumsg4(), "MSG８", "備考MSG４");
        exStringEquals(siSiDetailParamBeanKekka2.getSyouhnnmgm(), "商品名（画面用）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBeanKekka2.getSyouhnnmtyhy(), "商品名（帳票用）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBeanKekka2.getKyuuhunamegamen(), "給付名（画面用）", "給付名（画面用）");
        exStringEquals(siSiDetailParamBeanKekka2.getKyuuhunamereport(), "給付名（帳票用）", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBeanKekka2.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBeanKekka2.getHushrsyousaikbn(), C_HushrSyousaiKbn.HTNPKKN, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka2.getKyhkngkgoukei(), BizCurrency.valueOf(11121), "給付金額合計");
        exStringEquals(siSiDetailParamBeanKekka2.getUtiwakeparam(), "AA", "内訳パラメータ");
        SiSiDetailParamBean siSiDetailParamBeanKekka3 = siSiDetailParamBeanKekkaLst.get(2);
        exNumericEquals(siSiDetailParamBeanKekka3.getUketukeno(), 3, "受付番号");
        exClassificationEquals(siSiDetailParamBeanKekka3.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBeanKekka3.getSyouhncd(), "1013", "商品コード");
        exClassificationEquals(siSiDetailParamBeanKekka3.getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE60, "給付限度型区分");
        exNumericEquals(siSiDetailParamBeanKekka3.getSyouhnsdno(), 34, "商品世代番号");
        exNumericEquals(siSiDetailParamBeanKekka3.getKyksyouhnrenno(), 35, "契約商品連番");
        exStringEquals(siSiDetailParamBeanKekka3.getKyuuhucd(), "1113", "給付コード");
        exNumericEquals(siSiDetailParamBeanKekka3.getRenno(), 36, "連番");
        exClassificationEquals(siSiDetailParamBeanKekka3.getKyuuhukbn(), C_KyuuhuKbn.NYUUIN, "給付区分");
        exClassificationEquals(siSiDetailParamBeanKekka3.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBeanKekka3.getChecktaisyouumukbn(), C_UmuKbn.ARI, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBeanKekka3.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.NGAKU,
            "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka3.getNitigakuhokenkngk(), BizCurrency.valueOf(31118), "日額・保険金額");
        exNumericEquals(siSiDetailParamBeanKekka3.getNissuubairitu(), 37, "日数・倍率");
        exClassificationEquals(siSiDetailParamBeanKekka3.getKyhkintanikbn(), C_KyhkinTaniKbn.NITI, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka3.getKyhkg(), BizCurrency.valueOf(31119), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBeanKekka3.getYenkyhgk(), BizCurrency.valueOf(31120), "円換算給付金額");
        exNumericEquals(siSiDetailParamBeanKekka3.getHutanponissuu(), 38, "不担保日数");
        exDateEquals(siSiDetailParamBeanKekka3.getShrriyuugaitouymd(), BizDate.valueOf(20160427), "支払理由該当日");
        exClassificationEquals(siSiDetailParamBeanKekka3.getHknskgnkkntgtumukbn(), C_UmuKbn.ARI, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka3.getHokenkinshrwariai(), BizNumber.valueOf(39), "保険金支払割合");
        exStringEquals(siSiDetailParamBeanKekka3.getBikoumsg1(), "MSG９", "備考MSG１");
        exStringEquals(siSiDetailParamBeanKekka3.getBikoumsg2(), "MSG１０", "備考MSG２");
        exStringEquals(siSiDetailParamBeanKekka3.getBikoumsg3(), "MSG１１", "備考MSG３");
        exStringEquals(siSiDetailParamBeanKekka3.getBikoumsg4(), "MSG１２", "備考MSG４");
        exStringEquals(siSiDetailParamBeanKekka3.getSyouhnnmgm(), "商品名（画面用）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBeanKekka3.getSyouhnnmtyhy(), "商品名（帳票用）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBeanKekka3.getKyuuhunamegamen(), "給付名（画面用）", "給付名（画面用）");
        exStringEquals(siSiDetailParamBeanKekka3.getKyuuhunamereport(), "給付名（帳票用）", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBeanKekka3.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBeanKekka3.getHushrsyousaikbn(), C_HushrSyousaiKbn.HTNPKKN, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBeanKekka3.getKyhkngkgoukei(), BizCurrency.valueOf(11121), "給付金額合計");
        exStringEquals(siSiDetailParamBeanKekka3.getUtiwakeparam(), "AA", "内訳パラメータ");

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(skKekka.getSouhusakikbn(), C_SouhusakiKbn.TDADD, "送付先区分");
        exStringEquals(skKekka.getTsinyno(), "12345678", "通信先郵便番号");
        exStringEquals(skKekka.getTsinadr1kj(), "住所１", "通信先住所１（漢字）");
        exStringEquals(skKekka.getTsinadr2kj(), "住所２", "通信先住所２（漢字）");
        exStringEquals(skKekka.getTsinadr3kj(), "住所３", "通信先住所３（漢字）");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");
        exClassificationEquals(skKekka.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        List<JT_SiDetail> siDetailKekkaLst = editSkTblBean.getSiDetailLst();
        exNumericEquals(siDetailKekkaLst.size(), 3, "支払明細TBLリスト");
        JT_SiDetail siDetailKekka = siDetailKekkaLst.get(0);
        exStringEquals(siDetailKekka.getSkno(), "1001", "請求番号");
        exStringEquals(siDetailKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(siDetailKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exNumericEquals(siDetailKekka.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siDetailKekka.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siDetailKekka.getSyouhncd(), "1011", "商品コード");
        exClassificationEquals(siDetailKekka.getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE60, "給付限度型区分");
        exNumericEquals(siDetailKekka.getSyouhnsdno(), 14, "商品世代番号");
        exNumericEquals(siDetailKekka.getKyksyouhnrenno(), 15, "契約商品連番");
        exStringEquals(siDetailKekka.getKyuuhucd(), "1111", "給付コード");
        exNumericEquals(siDetailKekka.getRenno(), 1, "連番");
        exClassificationEquals(siDetailKekka.getKyuuhukbn(), C_KyuuhuKbn.NYUUIN, "給付区分");
        exClassificationEquals(siDetailKekka.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exClassificationEquals(siDetailKekka.getChecktaisyouumukbn(), C_UmuKbn.ARI, "チェック対象有無区分");
        exClassificationEquals(siDetailKekka.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.NGAKU,
            "日額・保険金額区分");
        exBizCalcbleEquals(siDetailKekka.getNitigakuhokenkngk(), BizCurrency.valueOf(11118), "日額・保険金額");
        exNumericEquals(siDetailKekka.getNissuubairitu(), 17, "日数・倍率");
        exClassificationEquals(siDetailKekka.getKyhkintanikbn(), C_KyhkinTaniKbn.NITI, "給付金単位区分");
        exBizCalcbleEquals(siDetailKekka.getKyhkg(), BizCurrency.valueOf(11119), "給付金額");
        exBizCalcbleEquals(siDetailKekka.getYenkyhgk(), BizCurrency.valueOf(11120), "円換算給付金額");
        exNumericEquals(siDetailKekka.getHutanponissuu(), 18, "不担保日数");
        exDateEquals(siDetailKekka.getShrriyuugaitouymd(), BizDate.valueOf(20160227), "支払理由該当日");
        exClassificationEquals(siDetailKekka.getHknskgnkkntgtumukbn(), C_UmuKbn.ARI, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siDetailKekka.getHokenkinshrwariai(), BizNumber.valueOf(19), "保険金支払割合");
        exStringEquals(siDetailKekka.getBikoumsg1(), "MSG１", "備考MSG１");
        exStringEquals(siDetailKekka.getBikoumsg2(), "MSG２", "備考MSG２");
        exStringEquals(siDetailKekka.getBikoumsg3(), "MSG３", "備考MSG３");
        exStringEquals(siDetailKekka.getBikoumsg4(), "MSG４", "備考MSG４");
        exStringEquals(siDetailKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(siDetailKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(siDetailKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");
        JT_SiDetail siDetailKekka2 = siDetailKekkaLst.get(1);
        exStringEquals(siDetailKekka2.getSkno(), "1001", "請求番号");
        exStringEquals(siDetailKekka2.getSyono(), "1101", "証券番号");
        exNumericEquals(siDetailKekka2.getSeikyuurirekino(), 101, "請求履歴番号");
        exNumericEquals(siDetailKekka2.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siDetailKekka2.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siDetailKekka2.getSyouhncd(), "1012", "商品コード");
        exClassificationEquals(siDetailKekka2.getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE60, "給付限度型区分");
        exNumericEquals(siDetailKekka2.getSyouhnsdno(), 24, "商品世代番号");
        exNumericEquals(siDetailKekka2.getKyksyouhnrenno(), 25, "契約商品連番");
        exStringEquals(siDetailKekka2.getKyuuhucd(), "1112", "給付コード");
        exNumericEquals(siDetailKekka2.getRenno(), 2, "連番");
        exClassificationEquals(siDetailKekka2.getKyuuhukbn(), C_KyuuhuKbn.NYUUIN, "給付区分");
        exClassificationEquals(siDetailKekka2.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exClassificationEquals(siDetailKekka2.getChecktaisyouumukbn(), C_UmuKbn.ARI, "チェック対象有無区分");
        exClassificationEquals(siDetailKekka2.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.NGAKU,
            "日額・保険金額区分");
        exBizCalcbleEquals(siDetailKekka2.getNitigakuhokenkngk(), BizCurrency.valueOf(21118), "日額・保険金額");
        exNumericEquals(siDetailKekka2.getNissuubairitu(), 27, "日数・倍率");
        exClassificationEquals(siDetailKekka2.getKyhkintanikbn(), C_KyhkinTaniKbn.NITI, "給付金単位区分");
        exBizCalcbleEquals(siDetailKekka2.getKyhkg(), BizCurrency.valueOf(21119), "給付金額");
        exBizCalcbleEquals(siDetailKekka2.getYenkyhgk(), BizCurrency.valueOf(21120), "円換算給付金額");
        exNumericEquals(siDetailKekka2.getHutanponissuu(), 28, "不担保日数");
        exDateEquals(siDetailKekka2.getShrriyuugaitouymd(), BizDate.valueOf(20160327), "支払理由該当日");
        exClassificationEquals(siDetailKekka2.getHknskgnkkntgtumukbn(), C_UmuKbn.ARI, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siDetailKekka2.getHokenkinshrwariai(), BizNumber.valueOf(29), "保険金支払割合");
        exStringEquals(siDetailKekka2.getBikoumsg1(), "MSG５", "備考MSG１");
        exStringEquals(siDetailKekka2.getBikoumsg2(), "MSG６", "備考MSG２");
        exStringEquals(siDetailKekka2.getBikoumsg3(), "MSG７", "備考MSG３");
        exStringEquals(siDetailKekka2.getBikoumsg4(), "MSG８", "備考MSG４");
        exStringEquals(siDetailKekka2.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(siDetailKekka2.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(siDetailKekka2.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");
        JT_SiDetail siDetailKekka3 = siDetailKekkaLst.get(2);
        exStringEquals(siDetailKekka3.getSkno(), "1001", "請求番号");
        exStringEquals(siDetailKekka3.getSyono(), "1101", "証券番号");
        exNumericEquals(siDetailKekka3.getSeikyuurirekino(), 101, "請求履歴番号");
        exNumericEquals(siDetailKekka3.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siDetailKekka3.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siDetailKekka3.getSyouhncd(), "1013", "商品コード");
        exClassificationEquals(siDetailKekka3.getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE60, "給付限度型区分");
        exNumericEquals(siDetailKekka3.getSyouhnsdno(), 34, "商品世代番号");
        exNumericEquals(siDetailKekka3.getKyksyouhnrenno(), 35, "契約商品連番");
        exStringEquals(siDetailKekka3.getKyuuhucd(), "1113", "給付コード");
        exNumericEquals(siDetailKekka3.getRenno(), 3, "連番");
        exClassificationEquals(siDetailKekka3.getKyuuhukbn(), C_KyuuhuKbn.NYUUIN, "給付区分");
        exClassificationEquals(siDetailKekka3.getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exClassificationEquals(siDetailKekka3.getChecktaisyouumukbn(), C_UmuKbn.ARI, "チェック対象有無区分");
        exClassificationEquals(siDetailKekka3.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.NGAKU,
            "日額・保険金額区分");
        exBizCalcbleEquals(siDetailKekka3.getNitigakuhokenkngk(), BizCurrency.valueOf(31118), "日額・保険金額");
        exNumericEquals(siDetailKekka3.getNissuubairitu(), 37, "日数・倍率");
        exClassificationEquals(siDetailKekka3.getKyhkintanikbn(), C_KyhkinTaniKbn.NITI, "給付金単位区分");
        exBizCalcbleEquals(siDetailKekka3.getKyhkg(), BizCurrency.valueOf(31119), "給付金額");
        exBizCalcbleEquals(siDetailKekka3.getYenkyhgk(), BizCurrency.valueOf(31120), "円換算給付金額");
        exNumericEquals(siDetailKekka3.getHutanponissuu(), 38, "不担保日数");
        exDateEquals(siDetailKekka3.getShrriyuugaitouymd(), BizDate.valueOf(20160427), "支払理由該当日");
        exClassificationEquals(siDetailKekka3.getHknskgnkkntgtumukbn(), C_UmuKbn.ARI, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siDetailKekka3.getHokenkinshrwariai(), BizNumber.valueOf(39), "保険金支払割合");
        exStringEquals(siDetailKekka3.getBikoumsg1(), "MSG９", "備考MSG１");
        exStringEquals(siDetailKekka3.getBikoumsg2(), "MSG１０", "備考MSG２");
        exStringEquals(siDetailKekka3.getBikoumsg3(), "MSG１１", "備考MSG３");
        exStringEquals(siDetailKekka3.getBikoumsg4(), "MSG１２", "備考MSG４");
        exStringEquals(siDetailKekka3.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(siDetailKekka3.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(siDetailKekka3.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(90)
    public void testSetEditKyhSkTbl_B3() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSoukinsakiParamImplTest siSoukinsakiParamImplTest = SWAKInjector
            .getInstance(SiSoukinsakiParamImplTest.class);

        siSoukinsakiParamImplTest.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siSoukinsakiParamImplTest.setBankcd("2001");
        siSoukinsakiParamImplTest.setSitencd("2002");
        siSoukinsakiParamImplTest.setYokinkbn(C_YokinKbn.HUTUU);
        siSoukinsakiParamImplTest.setKouzano("2003");
        siSoukinsakiParamImplTest.setKzdoukbn(C_Kzdou.DOUITU);
        siSoukinsakiParamImplTest.setKzmeiginmkn("かかか");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(new ArrayList<SiSiDetailParamBean>());

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSoukinsakiParamImplTest, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        exNumericEquals(editSkTblBean.getSiSiDetailParamBeanLst().size(), 0, "支払明細パラメータBeanリスト");

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(skKekka.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN, "入力用支払方法指定区分");
        exStringEquals(skKekka.getBankcd(), "2001", "銀行コード");
        exStringEquals(skKekka.getSitencd(), "2002", "支店コード");
        exClassificationEquals(skKekka.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skKekka.getKouzano(), "2003", "口座番号");
        exClassificationEquals(skKekka.getKzdoukbn(), C_Kzdou.DOUITU, "預金種目区分");
        exStringEquals(skKekka.getKzmeiginmkn(), "かかか", "口座名義人氏名（カナ）");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(100)
    public void testSetEditKyhSkTbl_B4() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSindansyoryouShrParamImplTest siSindansyoryouShrParamImplTest = SWAKInjector
            .getInstance(SiSindansyoryouShrParamImplTest.class);

        siSindansyoryouShrParamImplTest.setSindansyomaisuu(11);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSindansyoryouShrParamImplTest, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exNumericEquals(skKekka.getSindansyomaisuu(), 11, "診断書枚数");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(110)
    public void testSetEditKyhSkTbl_B5() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiShrdtlsyoHassouParamImplTest siShrdtlsyoHassouParamImplTest = SWAKInjector
            .getInstance(SiShrdtlsyoHassouParamImplTest.class);

        siShrdtlsyoHassouParamImplTest.setShrdtlsyooutkbn(C_KanryotuutioutKbn.PDF);
        siShrdtlsyoHassouParamImplTest.setHassoukbn(C_HassouKbn.TYOKUSOU);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siShrdtlsyoHassouParamImplTest, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(skKekka.getShrdtlsyooutkbn(), C_KanryotuutioutKbn.PDF, "支払明細書出力区分");
        exClassificationEquals(skKekka.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(120)
    public void testSetEditKyhSkTbl_B6() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSeikyuusyaParamImplTest siSeikyuusyaParamImpl = SWAKInjector
            .getInstance(SiSeikyuusyaParamImplTest.class);

        siSeikyuusyaParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        siSeikyuusyaParamImpl.setSihonninkakninkbn(C_SiHonninKakninKekkaKbn.KOUZA);
        siSeikyuusyaParamImpl.setSeikyuusyaseiymd(BizDate.valueOf(20160224));
        siSeikyuusyaParamImpl.setSeikyuusyasei(C_Seibetu.MALE);
        siSeikyuusyaParamImpl.setSeikyuusyanmkn("かかか");
        siSeikyuusyaParamImpl.setSeikyuusyanmkj("請求者（漢字）");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSeikyuusyaParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(skKekka.getSeikyuusyakbn(), C_SeikyuusyaKbn.UKTHONNIN, "請求者区分");
        exStringEquals(skKekka.getSeikyuusyanmkn(), "かかか", "請求者（カナ）");
        exStringEquals(skKekka.getSeikyuusyanmkj(), "請求者（漢字）", "請求者（漢字）");
        exDateEquals(skKekka.getSeikyuusyaseiymd(), BizDate.valueOf(20160224), "請求者生年月日");
        exClassificationEquals(skKekka.getSeikyuusyasei(), C_Seibetu.MALE, "請求者性別");
        exClassificationEquals(skKekka.getSihonninkakninkbn(), C_SiHonninKakninKekkaKbn.KOUZA, "保険金本人確認結果区分");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(130)
    public void testSetEditKyhSkTbl_B7() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSinkensyaKoukenninParamImplTest siSinkensyaKoukenninParamImpl = SWAKInjector
            .getInstance(SiSinkensyaKoukenninParamImplTest.class);

        siSinkensyaKoukenninParamImpl.setSkskknnmkn("かかか");
        siSinkensyaKoukenninParamImpl.setSkskknnmkj("親権者");
        siSinkensyaKoukenninParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.SINKENSYA);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSinkensyaKoukenninParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getSkskknnmkn(), "かかか", "親権者後見人名（カナ）");
        exStringEquals(skKekka.getSkskknnmkj(), "親権者", "親権者後見人名（漢字）");
        exClassificationEquals(skKekka.getSkskknsyubetu(), C_SkskknsyubetuKbn.SINKENSYA, "親権者後見人種別");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(140)
    public void testSetEditKyhSkTbl_B8() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSeikyuuNaiyouParamImplTest siSeikyuuNaiyouParam = SWAKInjector
            .getInstance(SiSeikyuuNaiyouParamImplTest.class);

        siSeikyuuNaiyouParam.setSuketorihouhoukbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSeikyuuNaiyouParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(skKekka.getSuketorihouhoukbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(150)
    public void testSetEditKyhSkTbl_B9() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSindansyoJyouhouSbParamImplTest siSindansyoJyouhouSbParamImpl = SWAKInjector
            .getInstance(SiSindansyoJyouhouSbParamImplTest.class);

        siSindansyoJyouhouSbParamImpl.setGeninkbn(C_GeninKbn.SP);
        siSindansyoJyouhouSbParamImpl.setSibouymd(BizDate.valueOf(20160224));
        siSindansyoJyouhouSbParamImpl.setSiboubasyokbn(C_SibouBasyoKbn.BYOUIN);
        siSindansyoJyouhouSbParamImpl.setSiboubasyo("病院");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSindansyoJyouhouSbParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        List<JT_SkJiyuu> skJiyuuLst = editSkTblBean.getSkJiyuuLst();
        exNumericEquals(skJiyuuLst.size(), 1, "請求事由TBLリスト");
        JT_SkJiyuu skJiyuu = skJiyuuLst.get(0);
        exStringEquals(skJiyuu.getSkno(), "1001", "請求番号");
        exStringEquals(skJiyuu.getSyono(), "1101", "証券番号");
        exNumericEquals(skJiyuu.getSeikyuurirekino(), 101, "請求履歴番号");
        exNumericEquals(skJiyuu.getUketukeno(), 1, "受付番号");
        exClassificationEquals(skJiyuu.getGeninkbn(), C_GeninKbn.SP, "原因区分");
        exDateEquals(skJiyuu.getSibouymd(), BizDate.valueOf(20160224), "死亡日");
        exClassificationEquals(skJiyuu.getSiboubasyokbn(), C_SibouBasyoKbn.BYOUIN, "死亡場所区分");
        exStringEquals(skJiyuu.getSiboubasyo(), "病院", "死亡場所");
        exStringEquals(skJiyuu.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skJiyuu.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skJiyuu.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(160)
    public void testSetEditKyhSkTbl_B10() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSyoruiUketukeYmdSkukeParamImplTest siSyoruiUketukeYmdSkukeParam = SWAKInjector
            .getInstance(SiSyoruiUketukeYmdSkukeParamImplTest.class);

        siSyoruiUketukeYmdSkukeParam.setSyoruiukeymd(BizDate.valueOf(20160224));

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSyoruiUketukeYmdSkukeParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exDateEquals(skKekka.getSyoruiukeymd(), BizDate.valueOf(20160224), "書類受付日");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(170)
    public void testSetEditKyhSkTbl_B11() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSyoruiUketukeYmdSateiParamImplTest siSyoruiUketukeYmdSateiParam = SWAKInjector
            .getInstance(SiSyoruiUketukeYmdSateiParamImplTest.class);

        siSyoruiUketukeYmdSateiParam.setSyoruiukeymd(BizDate.valueOf(20160224));
        siSyoruiUketukeYmdSateiParam.setHubikanryouymd(BizDate.valueOf(20160225));

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSyoruiUketukeYmdSateiParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exDateEquals(skKekka.getSyoruiukeymd(), BizDate.valueOf(20160224), "書類受付日");
        exDateEquals(skKekka.getHubikanryouymd(), BizDate.valueOf(20160225), "不備完了日");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(180)
    public void testSetEditKyhSkTbl_B12() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSouhusakiInfoParamImplTest siSouhusakiInfoParam = SWAKInjector
            .getInstance(SiSouhusakiInfoParamImplTest.class);
        siSouhusakiInfoParam.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        siSouhusakiInfoParam.setTsinyno("12345678");
        siSouhusakiInfoParam.setTsinadr1kj("住所１");
        siSouhusakiInfoParam.setTsinadr2kj("住所２");
        siSouhusakiInfoParam.setTsinadr3kj("住所３");
        siSouhusakiInfoParam.setTsintelno("12345");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSouhusakiInfoParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(siSouhusakiInfoParam.getSouhusakikbn(), C_SouhusakiKbn.TDADD, "送付先区分");
        exStringEquals(skKekka.getTsinyno(), "12345678", "通信先郵便番号");
        exStringEquals(skKekka.getTsinadr1kj(), "住所１", "通信先住所１（漢字）");
        exStringEquals(skKekka.getTsinadr2kj(), "住所２", "通信先住所２（漢字）");
        exStringEquals(skKekka.getTsinadr3kj(), "住所３", "通信先住所３（漢字）");
        exStringEquals(skKekka.getTsintelno(), "12345", "通信先電話番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(190)
    public void testSetEditKyhSkTbl_B13() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSateiKakSbParamImplTest siSateiKakSbParamImpl = SWAKInjector.getInstance(SiSateiKakSbParamImplTest.class);
        siSateiKakSbParamImpl.setSateikakmeigihnkkbn(C_YouhiKbn.YOU);
        siSateiKakSbParamImpl.setSateikakkaigaisbkbn(C_UmuKbn.ARI);
        siSateiKakSbParamImpl.setSateikakhusyousikbn(C_UmuKbn.ARI);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSateiKakSbParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(skKekka.getSateikakmeigihnkkbn(), C_YouhiKbn.YOU, "査定回送要否確認（名義変更査定）区分");
        exClassificationEquals(skKekka.getSateikakkaigaisbkbn(), C_UmuKbn.ARI, "査定回送要否確認（海外死亡）区分");
        exClassificationEquals(skKekka.getSateikakhusyousikbn(), C_UmuKbn.ARI, "査定回送要否確認（不詳の死）区分");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(200)
    public void testSetEditKyhSkTbl_B14() {
        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiByoumeiParamImplTest siByoumeiParam = SWAKInjector.getInstance(SiByoumeiParamImplTest.class);
        List<ViewSindansyoInfo2DataSourceBeanCommonParam> viewSindansyoInfo2Lst = new ArrayList<>();
        ViewSindansyoInfo2DataSourceBeanCommonParamImpl viewSindansyoInfo2DataSourceBeanCommonParamImpl =
            SWAKInjector.getInstance(ViewSindansyoInfo2DataSourceBeanCommonParamImpl.class);

        viewSindansyoInfo2DataSourceBeanCommonParamImpl.setByoumeitourokuno("1011");
        viewSindansyoInfo2DataSourceBeanCommonParamImpl.setByoumeikn("かかか");
        viewSindansyoInfo2DataSourceBeanCommonParamImpl.setByoumeikj("病名");
        viewSindansyoInfo2DataSourceBeanCommonParamImpl.setSakujyoflg(C_Delflag.BLNK);

        viewSindansyoInfo2Lst.add(viewSindansyoInfo2DataSourceBeanCommonParamImpl);
        siByoumeiParam.setViewSindansyoInfo2Lst(viewSindansyoInfo2Lst);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siByoumeiParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        exNumericEquals(editSkTblBean.getSkByoumeiLst().size(), 1, "請求病名TBLリスト");
        JT_SkByoumei skByoumei = editSkTblBean.getSkByoumeiLst().get(0);

        exStringEquals(skByoumei.getSkno(),"1001","請求番号");
        exStringEquals(skByoumei.getSyono(),"1101","証券番号");
        exNumericEquals(skByoumei.getSeikyuurirekino(),101,"請求履歴番号");
        exNumericEquals(skByoumei.getUketukeno(),1,"受付番号");
        exNumericEquals(skByoumei.getRenno(),1,"連番");
        exStringEquals(skByoumei.getByoumeitourokuno(),"1011","病名登録番号");
        exStringEquals(skByoumei.getByoumeikn(),"かかか","病名（カナ）");
        exStringEquals(skByoumei.getByoumeikj(),"病名","病名（漢字）");
        assertNull(skByoumei.getGankbn());
        assertNull(skByoumei.getSandaisippeikbn());
        assertNull(skByoumei.getNanadaisippeikbn());
        assertNull(skByoumei.getKansensyoukbn());
        exStringEquals(skByoumei.getKossyoricd(),"kinouTest","更新処理コード");
        exStringEquals(skByoumei.getKossyorisscd(),"kinouModeTest","更新処理詳細コード");
        exStringEquals(skByoumei.getGyoumuKousinsyaId(),"kou","業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());
    }

    @Test
    @TestOrder(210)
    public void testSetEditKyhSkTbl_B15() {
        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiByoumeiParamImplTest siByoumeiParam = SWAKInjector.getInstance(SiByoumeiParamImplTest.class);
        List<ViewSindansyoInfo2DataSourceBeanCommonParam> viewSindansyoInfo2Lst = new ArrayList<>();
        ViewSindansyoInfo2DataSourceBeanCommonParamImpl commonParamImpl1 =
            SWAKInjector.getInstance(ViewSindansyoInfo2DataSourceBeanCommonParamImpl.class);
        ViewSindansyoInfo2DataSourceBeanCommonParamImpl commonParamImpl2 =
            SWAKInjector.getInstance(ViewSindansyoInfo2DataSourceBeanCommonParamImpl.class);
        ViewSindansyoInfo2DataSourceBeanCommonParamImpl commonParamImpl3 =
            SWAKInjector.getInstance(ViewSindansyoInfo2DataSourceBeanCommonParamImpl.class);
        commonParamImpl1.setByoumeitourokuno("1011");
        commonParamImpl1.setByoumeikn("かかか");
        commonParamImpl1.setByoumeikj("病名");
        commonParamImpl1.setSakujyoflg(C_Delflag.BLNK);

        viewSindansyoInfo2Lst.add(commonParamImpl1);

        commonParamImpl2.setByoumeitourokuno("1012");
        commonParamImpl2.setByoumeikn("かかか２");
        commonParamImpl2.setByoumeikj("病名２");
        commonParamImpl2.setSakujyoflg(C_Delflag.SAKUJYO);

        viewSindansyoInfo2Lst.add(commonParamImpl2);

        commonParamImpl3.setByoumeitourokuno("1013");
        commonParamImpl3.setByoumeikn("かかか３");
        commonParamImpl3.setByoumeikj("病名３");
        commonParamImpl3.setSakujyoflg(C_Delflag.BLNK);

        viewSindansyoInfo2Lst.add(commonParamImpl3);

        siByoumeiParam.setViewSindansyoInfo2Lst(viewSindansyoInfo2Lst);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siByoumeiParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        exNumericEquals(editSkTblBean.getSkByoumeiLst().size(), 2, "請求病名TBLリスト");
        JT_SkByoumei skByoumei1 = editSkTblBean.getSkByoumeiLst().get(0);
        JT_SkByoumei skByoumei2 = editSkTblBean.getSkByoumeiLst().get(1);

        exStringEquals(skByoumei1.getSkno(),"1001","請求番号");
        exStringEquals(skByoumei1.getSyono(),"1101","証券番号");
        exNumericEquals(skByoumei1.getSeikyuurirekino(),101,"請求履歴番号");
        exNumericEquals(skByoumei1.getUketukeno(),1,"受付番号");
        exNumericEquals(skByoumei1.getRenno(),1,"連番");
        exStringEquals(skByoumei1.getByoumeitourokuno(),"1011","病名登録番号");
        exStringEquals(skByoumei1.getByoumeikn(),"かかか","病名（カナ）");
        exStringEquals(skByoumei1.getByoumeikj(),"病名","病名（漢字）");
        assertNull(skByoumei1.getGankbn());
        assertNull(skByoumei1.getSandaisippeikbn());
        assertNull(skByoumei1.getNanadaisippeikbn());
        assertNull(skByoumei1.getKansensyoukbn());
        exStringEquals(skByoumei1.getKossyoricd(),"kinouTest","更新処理コード");
        exStringEquals(skByoumei1.getKossyorisscd(),"kinouModeTest","更新処理詳細コード");
        exStringEquals(skByoumei1.getGyoumuKousinsyaId(),"kou","業務用更新者ＩＤ");

        exStringEquals(skByoumei2.getSkno(),"1001","請求番号");
        exStringEquals(skByoumei2.getSyono(),"1101","証券番号");
        exNumericEquals(skByoumei2.getSeikyuurirekino(),101,"請求履歴番号");
        exNumericEquals(skByoumei2.getUketukeno(),1,"受付番号");
        exNumericEquals(skByoumei2.getRenno(),2,"連番");
        exStringEquals(skByoumei2.getByoumeitourokuno(),"1013","病名登録番号");
        exStringEquals(skByoumei2.getByoumeikn(),"かかか３","病名（カナ）");
        exStringEquals(skByoumei2.getByoumeikj(),"病名３","病名（漢字）");
        assertNull(skByoumei2.getGankbn());
        assertNull(skByoumei2.getSandaisippeikbn());
        assertNull(skByoumei2.getNanadaisippeikbn());
        assertNull(skByoumei2.getKansensyoukbn());
        exStringEquals(skByoumei2.getKossyoricd(),"kinouTest","更新処理コード");
        exStringEquals(skByoumei2.getKossyorisscd(),"kinouModeTest","更新処理詳細コード");
        exStringEquals(skByoumei2.getGyoumuKousinsyaId(),"kou","業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());
    }

    @Test
    @TestOrder(220)
    public void testSetEditKyhSkTbl_B16() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSateiIppanHanteiParamImplTest siSateiIppanHanteiParam = SWAKInjector.getInstance(SiSateiIppanHanteiParamImplTest.class);
        siSateiIppanHanteiParam.setIppanhanteitensuu1("");
        siSateiIppanHanteiParam.setIppanhanteicomment1("");
        siSateiIppanHanteiParam.setIppanhanteitensuu2("");
        siSateiIppanHanteiParam.setIppanhanteicomment2("");
        siSateiIppanHanteiParam.setIppanhanteitensuu3("");
        siSateiIppanHanteiParam.setIppanhanteicomment3("");
        siSateiIppanHanteiParam.setIppanhanteitensuu4("");
        siSateiIppanHanteiParam.setIppanhanteicomment4("");
        siSateiIppanHanteiParam.setIppanhanteitensuu5("");
        siSateiIppanHanteiParam.setIppanhanteicomment5("");
        siSateiIppanHanteiParam.setIppanhanteitensuu6("");
        siSateiIppanHanteiParam.setIppanhanteicomment6("");
        siSateiIppanHanteiParam.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParam.setIppanhanteigoukeicomment("");


        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);
        editSkTblBean.setSateiIppanHanteiInfo(new JT_SateiIppanHanteiInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSateiIppanHanteiParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(230)
    public void testSetEditKyhSkTbl_B17() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSateiIppanHanteiParamImplTest siSateiIppanHanteiParam = SWAKInjector.getInstance(SiSateiIppanHanteiParamImplTest.class);
        siSateiIppanHanteiParam.setIppanhanteitensuu1("11");
        siSateiIppanHanteiParam.setIppanhanteicomment1("22");
        siSateiIppanHanteiParam.setIppanhanteitensuu2("33");
        siSateiIppanHanteiParam.setIppanhanteicomment2("44");
        siSateiIppanHanteiParam.setIppanhanteitensuu3("55");
        siSateiIppanHanteiParam.setIppanhanteicomment3("66");
        siSateiIppanHanteiParam.setIppanhanteitensuu4("77");
        siSateiIppanHanteiParam.setIppanhanteicomment4("88");
        siSateiIppanHanteiParam.setIppanhanteitensuu5("99");
        siSateiIppanHanteiParam.setIppanhanteicomment5("110");
        siSateiIppanHanteiParam.setIppanhanteitensuu6("121");
        siSateiIppanHanteiParam.setIppanhanteicomment6("132");
        siSateiIppanHanteiParam.setIppanhanteitensuugoukei("143");
        siSateiIppanHanteiParam.setIppanhanteigoukeicomment("154");


        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setSateiIppanHanteiInfo(new JT_SateiIppanHanteiInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSateiIppanHanteiParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        JT_SateiIppanHanteiInfo sateiIppanHanteiInfo= editSkTblBean.getSateiIppanHanteiInfo();
        exStringEquals(sateiIppanHanteiInfo.getSkno(), "1001", "請求番号");
        exStringEquals(sateiIppanHanteiInfo.getSyono(), "1101", "証券番号");
        exNumericEquals(sateiIppanHanteiInfo.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteitensuu1(), "11", "一般判定点数１");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteicomment1(), "22", "一般判定コメント１");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteitensuu2(), "33", "一般判定点数２");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteicomment2(), "44", "一般判定コメント２");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteitensuu3(), "55", "一般判定点数３");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteicomment3(), "66", "一般判定コメント３");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteitensuu4(), "77", "一般判定点数４");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteicomment4(), "88", "一般判定コメント４");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteitensuu5(), "99", "一般判定点数５");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteicomment5(), "110", "一般判定コメント５");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteitensuu6(), "121", "一般判定点数６");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteicomment6(), "132", "一般判定コメント６");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteitensuugoukei(), "143", "一般判定点数合計");
        exStringEquals(sateiIppanHanteiInfo.getIppanhanteigoukeicomment(), "154", "一般判定合計コメント");
        exStringEquals(sateiIppanHanteiInfo.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(sateiIppanHanteiInfo.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(sateiIppanHanteiInfo.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(240)
    public void testSetEditKyhSkTbl_B18() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSateiKokuhanCheckParamImplTest siSateiKokuhanCheckParamImpl = SWAKInjector.getInstance(SiSateiKokuhanCheckParamImplTest.class);
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setSateiKokuhanInfo(new JT_SateiKokuhanInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSateiKokuhanCheckParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(250)
    public void testSetEditKyhSkTbl_B19() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSateiKokuhanCheckParamImplTest siSateiKokuhanCheckParamImpl = SWAKInjector.getInstance(SiSateiKokuhanCheckParamImplTest.class);
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("11");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("22");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("33");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("44");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("55");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("66");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("77");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("88");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setSateiKokuhanInfo(new JT_SateiKokuhanInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSateiKokuhanCheckParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        JT_SateiKokuhanInfo sateiKokuhanInfo =editSkTblBean.getSateiKokuhanInfo();
        exStringEquals(sateiKokuhanInfo.getSkno(), "1001", "請求番号");
        exStringEquals(sateiKokuhanInfo.getSyono(), "1101", "証券番号");
        exNumericEquals(sateiKokuhanInfo.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(sateiKokuhanInfo.getKokuhancheckkbn1(), C_UmuKbn.ARI, "告反チェック区分１");
        exStringEquals(sateiKokuhanInfo.getKokuhanchecomment1(), "11", "告反チェックコメント１");
        exClassificationEquals(sateiKokuhanInfo.getKokuhancheckkbn2(), C_UmuKbn.ARI, "告反チェック区分２");
        exStringEquals(sateiKokuhanInfo.getKokuhanchecomment2(), "22", "告反チェックコメント２");
        exClassificationEquals(sateiKokuhanInfo.getKokuhancheckkbn3(), C_UmuKbn.ARI, "告反チェック区分３");
        exStringEquals(sateiKokuhanInfo.getKokuhanchecomment3(), "33", "告反チェックコメント３");
        exClassificationEquals(sateiKokuhanInfo.getKokuhancheckkbn4(), C_UmuKbn.ARI, "告反チェック区分４");
        exStringEquals(sateiKokuhanInfo.getKokuhanchecomment4(), "44", "告反チェックコメント４");
        exClassificationEquals(sateiKokuhanInfo.getKokuhancheckkbn5(), C_UmuKbn.ARI, "告反チェック区分５");
        exStringEquals(sateiKokuhanInfo.getKokuhanchecomment5(), "55", "告反チェックコメント５");
        exClassificationEquals(sateiKokuhanInfo.getKokuhancheckkbn6(), C_UmuKbn.ARI, "告反チェック区分６");
        exStringEquals(sateiKokuhanInfo.getKokuhanchecomment6(), "66", "告反チェックコメント６");
        exClassificationEquals(sateiKokuhanInfo.getKokuhancheckkbn7(), C_UmuKbn.ARI, "告反チェック区分７");
        exStringEquals(sateiKokuhanInfo.getKokuhanchecomment7(), "77", "告反チェックコメント７");
        exClassificationEquals(sateiKokuhanInfo.getKokuhancheckkbn8(), C_UmuKbn.ARI, "告反チェック区分８");
        exStringEquals(sateiKokuhanInfo.getKokuhanchecomment8(), "88", "告反チェックコメント８");
        exStringEquals(sateiKokuhanInfo.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(sateiKokuhanInfo.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(sateiKokuhanInfo.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");


        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(260)
    public void testSetEditKyhSkTbl_B20() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiKaijoKigenParamImplTest siKaijoKigenParamImpl = SWAKInjector.getInstance(SiKaijoKigenParamImplTest.class);
        siKaijoKigenParamImpl.setKaijokigenymd(null);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setSateiKaijyoInfo(new JT_SateiKaijyoInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siKaijoKigenParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(270)
    public void testSetEditKyhSkTbl_B21() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiKaijoKigenParamImplTest siKaijoKigenParamImpl = SWAKInjector.getInstance(SiKaijoKigenParamImplTest.class);
        siKaijoKigenParamImpl.setKaijokigenymd(BizDate.valueOf(20160225));

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setSateiKaijyoInfo(new JT_SateiKaijyoInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siKaijoKigenParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());

        JT_SateiKaijyoInfo sateiKaijyoInfo=editSkTblBean.getSateiKaijyoInfo();
        exStringEquals(sateiKaijyoInfo.getSkno(), "1001", "請求番号");
        exStringEquals(sateiKaijyoInfo.getSyono(), "1101", "証券番号");
        exNumericEquals(sateiKaijyoInfo.getSeikyuurirekino(), 101, "請求履歴番号");
        exDateEquals(sateiKaijyoInfo.getKaijokigenymd(), BizDate.valueOf(20160225), "解除期限日");
        exStringEquals(sateiKaijyoInfo.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(sateiKaijyoInfo.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(sateiKaijyoInfo.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");


        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(280)
    public void testSetEditKyhSkTbl_B22() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiMeigihenkouSateiParamImplTest siMeigihenkouSateiParamImpl = SWAKInjector.getInstance(SiMeigihenkouSateiParamImplTest.class);
        siMeigihenkouSateiParamImpl.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.BLNK);
        siMeigihenkouSateiParamImpl.setMeihenuktkbn(C_MeihenUktKbn.BLNK);
        siMeigihenkouSateiParamImpl.setMeihenuktnm("");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setSateiMeigihenkouInfo(new JT_SateiMeigihenkouInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siMeigihenkouSateiParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());

        assertNull(editSkTblBean.getSateiKaijyoInfo());

        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(290)
    public void testSetEditKyhSkTbl_B23() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiMeigihenkouSateiParamImplTest siMeigihenkouSateiParamImpl = SWAKInjector.getInstance(SiMeigihenkouSateiParamImplTest.class);
        siMeigihenkouSateiParamImpl.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.ENABLE);
        siMeigihenkouSateiParamImpl.setMeihenuktkbn(C_MeihenUktKbn.SOUI);
        siMeigihenkouSateiParamImpl.setMeihenuktnm("AAA");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setSateiMeigihenkouInfo(new JT_SateiMeigihenkouInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siMeigihenkouSateiParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());

        assertNull(editSkTblBean.getSateiKaijyoInfo());

        JT_SateiMeigihenkouInfo sateiMeigihenkouInfo =editSkTblBean.getSateiMeigihenkouInfo();
        exStringEquals(sateiMeigihenkouInfo.getSkno(), "1001", "請求番号");
        exStringEquals(sateiMeigihenkouInfo.getSyono(), "1101", "証券番号");
        exNumericEquals(sateiMeigihenkouInfo.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(sateiMeigihenkouInfo.getMeihenyuukoumukoukbn(), C_MeihenYuukouMukouKbn.ENABLE, "名義変更有効無効区分");
        exClassificationEquals(sateiMeigihenkouInfo.getMeihenuktkbn(), C_MeihenUktKbn.SOUI, "名義変更受取人区分");
        exStringEquals(sateiMeigihenkouInfo.getMeihenuktnm(), "AAA", "名義変更受取人名");
        exStringEquals(sateiMeigihenkouInfo.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(sateiMeigihenkouInfo.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(sateiMeigihenkouInfo.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");


        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(300)
    public void testSetEditKyhSkTbl_B24() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiToriatukaifuryouParamImplTest siToriatukaifuryouParamImpl = SWAKInjector.getInstance(SiToriatukaifuryouParamImplTest.class);
        siToriatukaifuryouParamImpl.setTratkihuryouumukbn(C_NoinitUmuKbn.BLNK);
        siToriatukaifuryouParamImpl.setGyousinkaisouyouhikbn(C_NoinitYouhiKbn.BLNK);
        siToriatukaifuryouParamImpl.setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn.BLNK);
        siToriatukaifuryouParamImpl.setTratkihuryoucomment("");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setToriatukaifuryouinfo(new JT_Toriatukaifuryouinfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siToriatukaifuryouParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());

        assertNull(editSkTblBean.getSateiKaijyoInfo());

        assertNull(editSkTblBean.getSateiMeigihenkouInfo());


        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(310)
    public void testSetEditKyhSkTbl_B25() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiToriatukaifuryouParamImplTest siToriatukaifuryouParamImpl = SWAKInjector.getInstance(SiToriatukaifuryouParamImplTest.class);
        siToriatukaifuryouParamImpl.setTratkihuryouumukbn(C_NoinitUmuKbn.ARI);
        siToriatukaifuryouParamImpl.setGyousinkaisouyouhikbn(C_NoinitYouhiKbn.HI);
        siToriatukaifuryouParamImpl.setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn.SYORIZUMI);
        siToriatukaifuryouParamImpl.setTratkihuryoucomment("AAA");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setToriatukaifuryouinfo(new JT_Toriatukaifuryouinfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siToriatukaifuryouParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        assertNull(editSkTblBean.getSibouSateiChkInfo());
        JT_Toriatukaifuryouinfo toriatukaifuryouinfo= editSkTblBean.getToriatukaifuryouinfo();
        exStringEquals(toriatukaifuryouinfo.getSkno(), "1001", "請求番号");
        exStringEquals(toriatukaifuryouinfo.getSyono(), "1101", "証券番号");
        exNumericEquals(toriatukaifuryouinfo.getSeikyuurirekino(), 101, "請求履歴番号");

        exClassificationEquals(toriatukaifuryouinfo.getTratkihuryouumukbn(), C_NoinitUmuKbn.ARI, "取扱不良有無区分");
        exClassificationEquals(toriatukaifuryouinfo.getGyousinkaisouyouhikbn(), C_NoinitYouhiKbn.HI, "業審回送要否区分");
        exClassificationEquals(toriatukaifuryouinfo.getAireqdaityoukisaikbn(), C_NoinitSyorizumiKbn.SYORIZUMI, "あいリク台帳記載区分");
        exStringEquals(toriatukaifuryouinfo.getTratkihuryoucomment(), "AAA", "取扱不良コメント");
        exStringEquals(toriatukaifuryouinfo.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(toriatukaifuryouinfo.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(toriatukaifuryouinfo.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSateiKaijyoInfo());

        assertNull(editSkTblBean.getSateiMeigihenkouInfo());


        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(320)
    public void testSetEditKyhSkTbl_B26() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSonotaSateiSbParamImplTest siSonotaSateiSbParamImpl = SWAKInjector.getInstance(SiSonotaSateiSbParamImplTest.class);
        siSonotaSateiSbParamImpl.setBengosikenkaiumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKujyouumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setJimumissumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.BLNK);


        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setSibouSateiChkInfo(new JT_SibouSateiChkInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSonotaSateiSbParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());


        assertNull(editSkTblBean.getSateiKaijyoInfo());

        assertNull(editSkTblBean.getSateiMeigihenkouInfo());


        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(330)
    public void testSetEditKyhSkTbl_B27() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSonotaSateiSbParamImplTest siSonotaSateiSbParamImpl = SWAKInjector.getInstance(SiSonotaSateiSbParamImplTest.class);
        siSonotaSateiSbParamImpl.setBengosikenkaiumukbn(C_NoinitUmuKbn.ARI);
        siSonotaSateiSbParamImpl.setKujyouumukbn(C_NoinitUmuKbn.NONE);
        siSonotaSateiSbParamImpl.setJimumissumukbn(C_NoinitUmuKbn.ARI);
        siSonotaSateiSbParamImpl.setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.HI);


        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setSibouSateiChkInfo(new JT_SibouSateiChkInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSonotaSateiSbParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        JT_SibouSateiChkInfo sibouSateiChkInfo =editSkTblBean.getSibouSateiChkInfo();
        exStringEquals(sibouSateiChkInfo.getSkno(), "1001", "請求番号");
        exStringEquals(sibouSateiChkInfo.getSyono(), "1101", "証券番号");
        exNumericEquals(sibouSateiChkInfo.getSeikyuurirekino(), 101, "請求履歴番号");

        exClassificationEquals(sibouSateiChkInfo.getBengosikenkaiumukbn(), C_NoinitUmuKbn.ARI, "弁護士見解有無区分");
        exClassificationEquals(sibouSateiChkInfo.getKujyouumukbn(), C_NoinitUmuKbn.NONE, "苦情有無区分");
        exClassificationEquals(sibouSateiChkInfo.getJimumissumukbn(), C_NoinitUmuKbn.ARI, "事務ミス有無区分");
        exClassificationEquals(sibouSateiChkInfo.getKyhgksitukaisouyouhikbn(), C_NoinitYouhiKbn.HI, "給付金室回送要否区分");

        exStringEquals(sibouSateiChkInfo.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(sibouSateiChkInfo.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(sibouSateiChkInfo.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");



        assertNull(editSkTblBean.getToriatukaifuryouinfo());


        assertNull(editSkTblBean.getSateiKaijyoInfo());

        assertNull(editSkTblBean.getSateiMeigihenkouInfo());


        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(340)
    public void testSetEditKyhSkTbl_B28() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiBetukutiSateiSbParamImplTest siBetukutiSateiSbParamImpl = SWAKInjector.getInstance(SiBetukutiSateiSbParamImplTest.class);
        siBetukutiSateiSbParamImpl.setBetusibouumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusiboucomment("");
        siBetukutiSateiSbParamImpl.setBetusoukiumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusoukicomment("");


        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setBetukutiSateiInfo(new JT_BetukutiSateiInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siBetukutiSateiSbParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        assertNull(editSkTblBean.getSibouSateiChkInfo());



        assertNull(editSkTblBean.getToriatukaifuryouinfo());


        assertNull(editSkTblBean.getSateiKaijyoInfo());

        assertNull(editSkTblBean.getSateiMeigihenkouInfo());


        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(350)
    public void testSetEditKyhSkTbl_B29() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiBetukutiSateiSbParamImplTest siBetukutiSateiSbParamImpl = SWAKInjector.getInstance(SiBetukutiSateiSbParamImplTest.class);
        siBetukutiSateiSbParamImpl.setBetusibouumukbn(C_NoinitUmuKbn.ARI);
        siBetukutiSateiSbParamImpl.setBetusiboucomment("AAA");
        siBetukutiSateiSbParamImpl.setBetusoukiumukbn(C_NoinitUmuKbn.NONE);
        siBetukutiSateiSbParamImpl.setBetusoukicomment("BBB");


        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        editSkTblBean.setBetukutiSateiInfo(new JT_BetukutiSateiInfo());

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siBetukutiSateiSbParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        assertNull(editSkTblBean.getSkByoumeiLst());

        assertNull(editSkTblBean.getSiDetailLst());

        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());

        assertNull(editSkTblBean.getSibouSateiChkInfo());



        assertNull(editSkTblBean.getToriatukaifuryouinfo());


        assertNull(editSkTblBean.getSateiKaijyoInfo());

        assertNull(editSkTblBean.getSateiMeigihenkouInfo());


        JT_BetukutiSateiInfo betukutiSateiInfo =editSkTblBean.getBetukutiSateiInfo();
        exStringEquals(betukutiSateiInfo.getSkno(), "1001", "請求番号");
        exStringEquals(betukutiSateiInfo.getSyono(), "1101", "証券番号");
        exNumericEquals(betukutiSateiInfo.getSeikyuurirekino(), 101, "請求履歴番号");

        exClassificationEquals(betukutiSateiInfo.getBetusibouumukbn(), C_NoinitUmuKbn.ARI, "別口死亡有無区分");
        exStringEquals(betukutiSateiInfo.getBetusiboucomment(), "AAA", "別口死亡コメント");
        exClassificationEquals(betukutiSateiInfo.getBetusoukiumukbn(), C_NoinitUmuKbn.NONE, "別口早期有無区分");
        exStringEquals(betukutiSateiInfo.getBetusoukicomment(), "BBB", "別口早期コメント");

        exStringEquals(betukutiSateiInfo.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(betukutiSateiInfo.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(betukutiSateiInfo.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(360)
    public void testSetEditKyhSkTbl_B30() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSiharaiSateiParamImplTest siSiharaiSateiParamImpl = SWAKInjector.getInstance(SiSiharaiSateiParamImplTest.class);
        siSiharaiSateiParamImpl.setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn.SDSSHRYH);
        siSiharaiSateiParamImpl.setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        siSiharaiSateiParamImpl.setRikoukityuutuudannissuu(11);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);


        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSiharaiSateiParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(skKekka.getSindansyoryoushryouhikbn(),C_SindansyoRyouShrYouhiKbn.SDSSHRYH,"診断書料支払要否区分");
        exClassificationEquals(skKekka.getSinsagendokknkbn(),C_SinsaGendoKknKbn.BD5,"審査限度期間区分");
        exNumericEquals(skKekka.getRikoukityuutuudannissuu(),11,"履行期中断日数");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());
        assertNull(editSkTblBean.getSkByoumeiLst());
        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());
    }

    @Test
    @TestOrder(370)
    public void testSetEditKyhSkTbl_B31() {
        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiByoumeiParamImplTest siByoumeiParam = SWAKInjector.getInstance(SiByoumeiParamImplTest.class);
        List<ViewSindansyoInfo2DataSourceBeanCommonParam> viewSindansyoInfo2Lst = new ArrayList<>();

        siByoumeiParam.setViewSindansyoInfo2Lst(viewSindansyoInfo2Lst);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siByoumeiParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        exNumericEquals(editSkTblBean.getSkByoumeiLst().size(), 0, "請求病名TBLリスト");

        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());
    }


    @Test
    @TestOrder(380)
    public void testSetEditKyhSkTbl_B32() {
        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiByoumeiParamImplTest siByoumeiParam = SWAKInjector.getInstance(SiByoumeiParamImplTest.class);
        List<ViewSindansyoInfo2DataSourceBeanCommonParam> viewSindansyoInfo2Lst = new ArrayList<>();
        ViewSindansyoInfo2DataSourceBeanCommonParamImpl viewSindansyoInfo2DataSourceBeanCommonParamImpl =
            SWAKInjector.getInstance(ViewSindansyoInfo2DataSourceBeanCommonParamImpl.class);

        viewSindansyoInfo2DataSourceBeanCommonParamImpl.setByoumeitourokuno("1011");
        viewSindansyoInfo2DataSourceBeanCommonParamImpl.setByoumeikn("かかか");
        viewSindansyoInfo2DataSourceBeanCommonParamImpl.setByoumeikj("病名");
        viewSindansyoInfo2DataSourceBeanCommonParamImpl.setSakujyoflg(C_Delflag.SAKUJYO);

        viewSindansyoInfo2Lst.add(viewSindansyoInfo2DataSourceBeanCommonParamImpl);
        siByoumeiParam.setViewSindansyoInfo2Lst(viewSindansyoInfo2Lst);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);

        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siByoumeiParam, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());

        exNumericEquals(editSkTblBean.getSkByoumeiLst().size(), 0, "請求病名TBLリスト");

        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());

    }

    @Test
    @TestOrder(390)
    public void testSetEditKyhSkTbl_B33() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSaikenParamImplTest siSaikenParamImpl = SWAKInjector.getInstance(SiSaikenParamImplTest.class);
        siSaikenParamImpl.setSaikennmkj("債権者債権者氏名");
        siSaikenParamImpl.setSaikennyno("111-2222");
        siSaikenParamImpl.setSaikenadr1kj("債権者住所１漢字");
        siSaikenParamImpl.setSaikenadr2kj("債権者住所２漢字");
        siSaikenParamImpl.setSaikenadr3kj("債権者住所３漢字");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);


        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSaikenParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getSaikennmkj(), "債権者債権者氏名", "債権者氏名（漢字）");
        exStringEquals(skKekka.getSaikennyno(), "111-2222", "債権者郵便番号");
        exStringEquals(skKekka.getSaikenadr1kj(), "債権者住所１漢字", "債権者住所１（漢字）");
        exStringEquals(skKekka.getSaikenadr2kj(), "債権者住所２漢字", "債権者住所２（漢字）");
        exStringEquals(skKekka.getSaikenadr3kj(), "債権者住所３漢字", "債権者住所３（漢字）");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());
        assertNull(editSkTblBean.getSkByoumeiLst());
        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());
        assertNull(editSkTblBean.getSateiJyuukasituChkInfo());
    }

    @Test
    @TestOrder(400)
    public void testSetEditKyhSkTbl_B34() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiMnmeigibangouParamImplTest siMnmeigibangouParamImpl = SWAKInjector.getInstance(SiMnmeigibangouParamImplTest.class);
        siMnmeigibangouParamImpl.setUktmnmeigibangou("123456789");
        siMnmeigibangouParamImpl.setKykmnmeigibangou("987654321");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);


        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siMnmeigibangouParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getUktmnmeigibangou(), "123456789", "受取人ＭＮ名義番号");
        exStringEquals(skKekka.getKykmnmeigibangou(), "987654321", "債権者郵便番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());
        assertNull(editSkTblBean.getSkByoumeiLst());
        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());
        assertNull(editSkTblBean.getSateiJyuukasituChkInfo());
    }

    @Test
    @TestOrder(410)
    public void testSetEditKyhSkTbl_B35() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSiinParamImplTest siSiinParamImpl = SWAKInjector.getInstance(SiSiinParamImplTest.class);
        siSiinParamImpl.setSiinkbn(C_SiinKbn.SP);

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);


        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(siSiinParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(skKekka.getSiinkbn(), C_SiinKbn.SP, "死因区分");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());
        assertNull(editSkTblBean.getSkByoumeiLst());
        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());
        assertNull(editSkTblBean.getSateiJyuukasituChkInfo());
    }

    @Test
    @TestOrder(420)
    public void testSetEditKyhSkTbl_B36() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSateiJuukasituParamImplTest iSateiJuukasituParamImpl = SWAKInjector.getInstance(SiSateiJuukasituParamImplTest.class);
        iSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        iSateiJuukasituParamImpl.setJuukasitucheckcomment1("");
        iSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        iSateiJuukasituParamImpl.setJuukasitucheckcomment2("");
        iSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        iSateiJuukasituParamImpl.setJuukasitucheckcomment3("");
        iSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        iSateiJuukasituParamImpl.setJuukasitucheckcomment4("");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);


        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(iSateiJuukasituParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());
        assertNull(editSkTblBean.getSkByoumeiLst());
        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());
        assertNull(editSkTblBean.getSateiJyuukasituChkInfo());
    }

    @Test
    @TestOrder(430)
    public void testSetEditKyhSkTbl_B37() {

        kinou.setKinouId("kinouTest");
        baseUserInfo.getUser().setUserId("kou");
        kinouMode.setKinouMode("kinouModeTest");

        SiSateiJuukasituParamImplTest iSateiJuukasituParamImpl = SWAKInjector.getInstance(SiSateiJuukasituParamImplTest.class);
        iSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.ARI);
        iSateiJuukasituParamImpl.setJuukasitucheckcomment1("11");
        iSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.ARI);
        iSateiJuukasituParamImpl.setJuukasitucheckcomment2("22");
        iSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.ARI);
        iSateiJuukasituParamImpl.setJuukasitucheckcomment3("33");
        iSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.ARI);
        iSateiJuukasituParamImpl.setJuukasitucheckcomment4("44");

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo("1001");
        editSkTblBean.setSyoNo("1101");
        editSkTblBean.setSeikyuuRirekiNo(101);
        editSkTblBean.setUketukeNo(1);

        editSkTblBean.setSkTblSetBean(null);

        editSkTblBean.setSiSiDetailParamBeanLst(null);

        editSkTblBean.setSiNenkinInfoBean(null);


        JT_Sk sk = new JT_Sk();
        sk.setSkno("1005");
        sk.setSyono("1105");
        sk.setSeikyuurirekino(105);

        editSkTblBean.setSk(sk);

        editSkTbl.setEditKyhSkTbl(iSateiJuukasituParamImpl, editSkTblBean);

        exStringEquals(editSkTblBean.getSkNo(), "1001", "請求番号");
        exStringEquals(editSkTblBean.getSyoNo(), "1101", "証券番号");
        exNumericEquals(editSkTblBean.getSeikyuuRirekiNo(), 101, "請求履歴番号");
        exNumericEquals(editSkTblBean.getUketukeNo(), 1, "受付番号");

        assertNull(editSkTblBean.getSkTblSetBean());

        assertNull(editSkTblBean.getSiSiDetailParamBeanLst());

        assertNull(editSkTblBean.getSiNenkinInfoBean());

        JT_Sk skKekka = editSkTblBean.getSk();
        exStringEquals(skKekka.getSkno(), "1001", "請求番号");
        exStringEquals(skKekka.getSyono(), "1101", "証券番号");
        exNumericEquals(skKekka.getSeikyuurirekino(), 101, "請求履歴番号");
        exStringEquals(skKekka.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(skKekka.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(skKekka.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        assertNull(editSkTblBean.getSkJiyuuLst());
        assertNull(editSkTblBean.getSkByoumeiLst());
        assertNull(editSkTblBean.getSiDetailLst());
        assertNull(editSkTblBean.getNenkinInfo());
        assertNull(editSkTblBean.getSateiIppanHanteiInfo());
        assertNull(editSkTblBean.getSateiKokuhanInfo());
        assertNull(editSkTblBean.getSibouSateiChkInfo());
        assertNull(editSkTblBean.getToriatukaifuryouinfo());
        assertNull(editSkTblBean.getSateiKaijyoInfo());
        assertNull(editSkTblBean.getSateiMeigihenkouInfo());
        assertNull(editSkTblBean.getBetukutiSateiInfo());
        JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo = editSkTblBean.getSateiJyuukasituChkInfo();
        exStringEquals(sateiJyuukasituChkInfo.getSyono(), "1101", "請求番号");
        exStringEquals(sateiJyuukasituChkInfo.getSkno(), "1001", "証券番号");
        exNumericEquals(sateiJyuukasituChkInfo.getSeikyuurirekino(), 101, "請求履歴番号");
        exClassificationEquals(sateiJyuukasituChkInfo.getJuukasitucheckkbn1(), C_UmuKbn.ARI, "重過失チェック区分１");
        exStringEquals(sateiJyuukasituChkInfo.getJuukasitucheckcomment1(), "11", "重過失チェックコメント１");
        exClassificationEquals(sateiJyuukasituChkInfo.getJuukasitucheckkbn2(), C_UmuKbn.ARI, "重過失チェック区分２");
        exStringEquals(sateiJyuukasituChkInfo.getJuukasitucheckcomment2(), "22", "重過失チェックコメント２");
        exClassificationEquals(sateiJyuukasituChkInfo.getJuukasitucheckkbn3(), C_UmuKbn.ARI, "重過失チェック区分３");
        exStringEquals(sateiJyuukasituChkInfo.getJuukasitucheckcomment3(), "33", "重過失チェックコメント３");
        exClassificationEquals(sateiJyuukasituChkInfo.getJuukasitucheckkbn4(), C_UmuKbn.ARI, "重過失チェック区分４");
        exStringEquals(sateiJyuukasituChkInfo.getJuukasitucheckcomment4(), "44", "重過失チェックコメント４");
        exStringEquals(sateiJyuukasituChkInfo.getKossyoricd(), "kinouTest", "更新処理コード");
        exStringEquals(sateiJyuukasituChkInfo.getKossyorisscd(), "kinouModeTest", "更新処理詳細コード");
        exStringEquals(sateiJyuukasituChkInfo.getGyoumuKousinsyaId(), "kou", "業務用更新者ＩＤ");

        MockObjectManager.initialize();
    }
}
