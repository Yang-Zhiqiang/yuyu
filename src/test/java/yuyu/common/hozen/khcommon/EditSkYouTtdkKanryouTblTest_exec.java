package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約直送用手続完了TBL編集クラスのメソッド {@link EditSkYouTtdkKanryouTbl#exec(KhozenCommonParam, IT_KykKihon, List, IT_KykSya, IT_KykSonotaTkyk, IT_KykUkt, IT_KykUkt, BizDate, C_HassouKbn, List)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSkYouTtdkKanryouTblTest_exec {

    @Inject
    private EditSkYouTtdkKanryouTbl editSkYouTtdkKanryouTbl;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        KhozenCommonParam khozenCommonParam = new KhozenCommonParam();
        khozenCommonParam.setSikibetuKey("10");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono("17806000013");

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKykymd(BizDate.valueOf("20200101"));
        List<IT_KykSyouhn> kykSyouhnListSyu = new ArrayList<IT_KykSyouhn>();
        kykSyouhnListSyu.add(kykSyouhn);

        IT_KykSya kykSya = new IT_KykSya();
        kykSya.setKyknmkj("山本　一郎");

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.ARI);
        kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);

        IT_KykUkt kykDairiUkt = new IT_KykUkt();
        kykDairiUkt.setUktkbn(C_UktKbn.HHKN);

        IT_KykUkt hhknDairiUkt = new IT_KykUkt();
        hhknDairiUkt.setUktkbn(C_UktKbn.HHKN);

        BizDate syoriYmd = BizDate.valueOf("20201111");

        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanList = new ArrayList<TyokusouTaisyouBean>();

        List<IT_TtdkKan> ttdkKanResultList = editSkYouTtdkKanryouTbl.exec(
            khozenCommonParam,
            kykKihon,
            kykSyouhnListSyu,
            kykSya,
            kykSonotaTkyk,
            kykDairiUkt,
            hhknDairiUkt,
            syoriYmd,
            hassouKbn,
            tyokusouTaisyouBeanList);

        exNumericEquals(ttdkKanResultList.size(), 0, "直送対象者Beanリスト");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setSikibetuKey("10");
        khozenCommonParam.setFunctionId("EditSkYouTtdkKanryouTblTest_exec");

        AM_User user = new AM_User();
        user.setUserId("junit");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono("17806000024");
        kykKihon.setSkjmosno("860000017");
        kykKihon.setKbnkey("02");

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKykymd(BizDate.valueOf("20200101"));
        List<IT_KykSyouhn> kykSyouhnListSyu = new ArrayList<IT_KykSyouhn>();
        kykSyouhnListSyu.add(kykSyouhn);

        IT_KykSya kykSya = new IT_KykSya();
        kykSya.setKyknmkj("山本　一郎");

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.NONE);

        IT_KykUkt kykDairiUkt = new IT_KykUkt();
        kykDairiUkt.setUktkbn(C_UktKbn.HHKN);

        IT_KykUkt hhknDairiUkt = new IT_KykUkt();
        hhknDairiUkt.setUktkbn(C_UktKbn.HHKN);

        BizDate syoriYmd = BizDate.valueOf("20201111");

        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;

        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();

        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.BLNK);
        tyokusouTaisyouBean.setNmkj("山本　次郎");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf("20040101"));
        tyokusouTaisyouBean.setYno("1111111");
        tyokusouTaisyouBean.setAdr1kj("住所一");
        tyokusouTaisyouBean.setAdr2kj("住所二");
        tyokusouTaisyouBean.setAdr3kj("住所三");
        tyokusouTaisyouBean.setTelno(null);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanList = new ArrayList<TyokusouTaisyouBean>();
        tyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        List<IT_TtdkKan> ttdkKanResultList = editSkYouTtdkKanryouTbl.exec(
            khozenCommonParam,
            kykKihon,
            kykSyouhnListSyu,
            kykSya,
            kykSonotaTkyk,
            kykDairiUkt,
            hhknDairiUkt,
            syoriYmd,
            hassouKbn,
            tyokusouTaisyouBeanList);

        exNumericEquals(ttdkKanResultList.size(), 1, "直送対象者Beanリスト");

        exStringEquals(ttdkKanResultList.get(0).getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKanResultList.get(0).getSyono(), "17806000024", "証券番号");
        exClassificationEquals(ttdkKanResultList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, "書類コード");
        exDateEquals(ttdkKanResultList.get(0).getTyouhyouymd(), BizDate.valueOf("20201111"), "帳票作成日");
        exClassificationEquals(ttdkKanResultList.get(0).getHassoukbn(), C_HassouKbn.BLNK, "発送区分");
        exClassificationEquals(ttdkKanResultList.get(0).getTantousitukbn(), C_TantousituKbn.KEIYAKUSINSA, "担当室区分");
        exStringEquals(ttdkKanResultList.get(0).getToiawasesosikinmkj(), "", "問合せ先組織名（漢字");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr3kj(), "", "問合せ先住所３（漢字");
        exStringEquals(ttdkKanResultList.get(0).getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawasetelno(), "", "問合せ先電話番号");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseteluktkkanou1(), "", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseteluktkkanou2(), "", "問合せ先電話受付可能時間２");
        exStringEquals(ttdkKanResultList.get(0).getKyknmkj(), "山本　一郎", "契約者名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getGyoumuKousinKinou(), "EditSkYouTtdkKanryouTblTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKanResultList.get(0).getGyoumuKousinsyaId(), "junit", "業務用更新者ＩＤ");
        assertNotNull(null, BizDate.getSysDateTimeMilli());
        exStringEquals(ttdkKanResultList.get(0).getKhmosno1(), "860000017", "（契約保全）申込番号１");

    }
    @Test
    @TestOrder(30)
    public void testExec_A3() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setSikibetuKey("000000000000000010");
        khozenCommonParam.setFunctionId("EditSkYouTtdkKanryouTblTest_exec");

        AM_User user = new AM_User();
        user.setUserId("junit");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono("17806000035");
        kykKihon.setSkjmosno("860000033");
        kykKihon.setKbnkey("03");

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKykymd(BizDate.valueOf("20200101"));
        List<IT_KykSyouhn> kykSyouhnListSyu = new ArrayList<IT_KykSyouhn>();
        kykSyouhnListSyu.add(kykSyouhn);

        IT_KykSya kykSya = new IT_KykSya();
        kykSya.setKyknmkj("山本　一郎");

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.ARI);
        kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);

        IT_KykUkt kykDairiUkt = new IT_KykUkt();
        kykDairiUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);

        IT_KykUkt hhknDairiUkt = new IT_KykUkt();
        hhknDairiUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);

        BizDate syoriYmd = BizDate.valueOf("20201111");

        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;

        TyokusouTaisyouBean tyokusouTaisyouBean1 = new TyokusouTaisyouBean();

        tyokusouTaisyouBean1.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean1.setNmkj("山本　次郎");
        tyokusouTaisyouBean1.setSeiYmd(BizDate.valueOf("20040101"));
        tyokusouTaisyouBean1.setYno("12345674890");
        tyokusouTaisyouBean1.setAdr1kj("住所１（漢字）１");
        tyokusouTaisyouBean1.setAdr2kj("住所２（漢字）1");
        tyokusouTaisyouBean1.setAdr3kj("住所３（漢字）１");
        tyokusouTaisyouBean1.setTelno("12345678901234");

        TyokusouTaisyouBean tyokusouTaisyouBean2 = new TyokusouTaisyouBean();

        tyokusouTaisyouBean2.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBean2.setNmkj("山本　三郎");
        tyokusouTaisyouBean2.setSeiYmd(BizDate.valueOf("20050101"));
        tyokusouTaisyouBean2.setYno("12345674891");
        tyokusouTaisyouBean2.setAdr1kj("住所１（漢字）２");
        tyokusouTaisyouBean2.setAdr2kj("住所２（漢字）２");
        tyokusouTaisyouBean2.setAdr3kj("住所３（漢字）２");
        tyokusouTaisyouBean2.setTelno(null);

        TyokusouTaisyouBean tyokusouTaisyouBean3 = new TyokusouTaisyouBean();

        tyokusouTaisyouBean3.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean3.setNmkj("山本　四郎");
        tyokusouTaisyouBean3.setSeiYmd(BizDate.valueOf("20060101"));
        tyokusouTaisyouBean3.setYno("12345674892");
        tyokusouTaisyouBean3.setAdr1kj("住所１（漢字）３");
        tyokusouTaisyouBean3.setAdr2kj("住所２（漢字）３");
        tyokusouTaisyouBean3.setAdr3kj("住所３（漢字）３");
        tyokusouTaisyouBean3.setTelno("12345678901234");

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanList = new ArrayList<TyokusouTaisyouBean>();
        tyokusouTaisyouBeanList.add(tyokusouTaisyouBean1);
        tyokusouTaisyouBeanList.add(tyokusouTaisyouBean2);
        tyokusouTaisyouBeanList.add(tyokusouTaisyouBean3);

        List<IT_TtdkKan> ttdkKanResultList = editSkYouTtdkKanryouTbl.exec(
            khozenCommonParam,
            kykKihon,
            kykSyouhnListSyu,
            kykSya,
            kykSonotaTkyk,
            kykDairiUkt,
            hhknDairiUkt,
            syoriYmd,
            hassouKbn,
            tyokusouTaisyouBeanList);

        exNumericEquals(ttdkKanResultList.size(), 3, "直送対象者Beanリスト");

        exStringEquals(ttdkKanResultList.get(0).getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKanResultList.get(0).getSyono(), "17806000035", "証券番号");
        exClassificationEquals(ttdkKanResultList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, "書類コード");
        exDateEquals(ttdkKanResultList.get(0).getTyouhyouymd(), BizDate.valueOf("20201111"), "帳票作成日");
        exClassificationEquals(ttdkKanResultList.get(0).getHassoukbn(), C_HassouKbn.BLNK, "発送区分");
        exClassificationEquals(ttdkKanResultList.get(0).getTantousitukbn(), C_TantousituKbn.KEIYAKUSINSA, "担当室区分");
        exStringEquals(ttdkKanResultList.get(0).getToiawasesosikinmkj(), "", "問合せ先組織名（漢字");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr3kj(), "", "問合せ先住所３（漢字");
        exStringEquals(ttdkKanResultList.get(0).getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawasetelno(), "", "問合せ先電話番号");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseteluktkkanou1(), "", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseteluktkkanou2(), "", "問合せ先電話受付可能時間２");
        exStringEquals(ttdkKanResultList.get(0).getKyknmkj(), "山本　一郎", "契約者名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getGyoumuKousinKinou(), "EditSkYouTtdkKanryouTblTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKanResultList.get(0).getGyoumuKousinsyaId(), "junit", "業務用更新者ＩＤ");
        assertNotNull(null, BizDate.getSysDateTimeMilli());
        exStringEquals(ttdkKanResultList.get(0).getKhmosno1(), "860000033", "（契約保全）申込番号１");

        exStringEquals(ttdkKanResultList.get(0).getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exStringEquals(ttdkKanResultList.get(0).getShskyno(), "12345674890", "送付先郵便番号");
        exStringEquals(ttdkKanResultList.get(0).getShsadr1kj(), "住所１（漢字）１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(0).getShsadr2kj(), "住所２（漢字）1", "送付先住所２（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(0).getShsadr3kj(), "住所３（漢字）１", "送付先住所３（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(0).getShsnmkj(), "山本　次郎", "送付先氏名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getShsnmkj2(), "", "送付先氏名（漢字）２");
        exClassificationEquals(ttdkKanResultList.get(0).getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK2, "登録家族区分１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzknmkj1(), "山本　次郎", "登録家族名（漢字）１");
        exDateEquals(ttdkKanResultList.get(0).getTrkkzkseiymd1(), BizDate.valueOf("20040101"), "登録家族生年月日１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkyno1(), "12345674890", "登録家族郵便番号１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkadr1kj1(), "住所１（漢字）１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkadr2kj1(), "住所２（漢字）1", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkadr3kj1(), "住所３（漢字）１", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzktelno1(), "12345678901234", "登録家族電話番号１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzktelnomtrkhyouji1(), "0", "登録家族電話番号未登録表示１");
        exStringEquals(ttdkKanResultList.get(0).getKzkomttutkbn1(), "06", "家族１用表通知区分");
        exStringEquals(ttdkKanResultList.get(0).getKzkaistmsgkbn1(), "73", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKanResultList.get(0).getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKanResultList.get(0).getKzkmoshnkniymsg21(), "73", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKanResultList.get(0).getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKanResultList.get(0).getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKanResultList.get(0).getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

        exStringEquals(ttdkKanResultList.get(1).getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKanResultList.get(1).getSyono(), "17806000035", "証券番号");
        exClassificationEquals(ttdkKanResultList.get(1).getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, "書類コード");
        exDateEquals(ttdkKanResultList.get(1).getTyouhyouymd(), BizDate.valueOf("20201111"), "帳票作成日");
        exClassificationEquals(ttdkKanResultList.get(1).getHassoukbn(), C_HassouKbn.BLNK, "発送区分");
        exClassificationEquals(ttdkKanResultList.get(1).getTantousitukbn(), C_TantousituKbn.KEIYAKUSINSA, "担当室区分");
        exStringEquals(ttdkKanResultList.get(1).getToiawasesosikinmkj(), "", "問合せ先組織名（漢字");
        exStringEquals(ttdkKanResultList.get(1).getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(ttdkKanResultList.get(1).getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKanResultList.get(1).getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKanResultList.get(1).getToiawaseadr3kj(), "", "問合せ先住所３（漢字");
        exStringEquals(ttdkKanResultList.get(1).getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKanResultList.get(1).getToiawasetelno(), "", "問合せ先電話番号");
        exStringEquals(ttdkKanResultList.get(1).getToiawaseteluktkkanou1(), "", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKanResultList.get(1).getToiawaseteluktkkanou2(), "", "問合せ先電話受付可能時間２");
        exStringEquals(ttdkKanResultList.get(1).getKyknmkj(), "山本　一郎", "契約者名（漢字）");
        exStringEquals(ttdkKanResultList.get(1).getGyoumuKousinKinou(), "EditSkYouTtdkKanryouTblTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKanResultList.get(1).getGyoumuKousinsyaId(), "junit", "業務用更新者ＩＤ");
        assertNotNull(null, BizDate.getSysDateTimeMilli());
        exStringEquals(ttdkKanResultList.get(1).getKhmosno1(), "860000033", "（契約保全）申込番号１");
        exStringEquals(ttdkKanResultList.get(1).getHenkousikibetukey(), "000000000000000011", "変更識別キー");
        exStringEquals(ttdkKanResultList.get(1).getShskyno(), "12345674891", "送付先郵便番号");
        exStringEquals(ttdkKanResultList.get(1).getShsadr1kj(), "住所１（漢字）２", "送付先住所１（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(1).getShsadr2kj(), "住所２（漢字）２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(1).getShsadr3kj(), "住所３（漢字）２", "送付先住所３（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(1).getShsnmkj(), "山本　三郎", "送付先氏名（漢字）");
        exStringEquals(ttdkKanResultList.get(1).getShsnmkj2(), "", "送付先氏名（漢字）２");
        exClassificationEquals(ttdkKanResultList.get(1).getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKanResultList.get(1).getTrkkzknmkj1(), "山本　三郎", "登録家族名（漢字）１");
        exDateEquals(ttdkKanResultList.get(1).getTrkkzkseiymd1(), BizDate.valueOf("20050101"), "登録家族生年月日１");
        exStringEquals(ttdkKanResultList.get(1).getTrkkzkyno1(), "12345674891", "登録家族郵便番号１");
        exStringEquals(ttdkKanResultList.get(1).getTrkkzkadr1kj1(), "住所１（漢字）２", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKanResultList.get(1).getTrkkzkadr2kj1(), "住所２（漢字）２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKanResultList.get(1).getTrkkzkadr3kj1(), "住所３（漢字）２", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKanResultList.get(1).getTrkkzktelno1(), "", "登録家族電話番号１");
        exStringEquals(ttdkKanResultList.get(1).getTrkkzktelnomtrkhyouji1(), "1", "登録家族電話番号未登録表示１");
        exStringEquals(ttdkKanResultList.get(1).getKzkomttutkbn1(), "06", "家族１用表通知区分");
        exStringEquals(ttdkKanResultList.get(1).getKzkaistmsgkbn1(), "70", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKanResultList.get(1).getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKanResultList.get(1).getKzkmoshnkniymsg21(), "70", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKanResultList.get(1).getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKanResultList.get(1).getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKanResultList.get(1).getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

        exStringEquals(ttdkKanResultList.get(2).getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKanResultList.get(2).getSyono(), "17806000035", "証券番号");
        exClassificationEquals(ttdkKanResultList.get(2).getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, "書類コード");
        exDateEquals(ttdkKanResultList.get(2).getTyouhyouymd(), BizDate.valueOf("20201111"), "帳票作成日");
        exClassificationEquals(ttdkKanResultList.get(2).getHassoukbn(), C_HassouKbn.BLNK, "発送区分");
        exClassificationEquals(ttdkKanResultList.get(2).getTantousitukbn(), C_TantousituKbn.KEIYAKUSINSA, "担当室区分");
        exStringEquals(ttdkKanResultList.get(2).getToiawasesosikinmkj(), "", "問合せ先組織名（漢字");
        exStringEquals(ttdkKanResultList.get(2).getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(ttdkKanResultList.get(2).getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKanResultList.get(2).getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKanResultList.get(2).getToiawaseadr3kj(), "", "問合せ先住所３（漢字");
        exStringEquals(ttdkKanResultList.get(2).getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKanResultList.get(2).getToiawasetelno(), "", "問合せ先電話番号");
        exStringEquals(ttdkKanResultList.get(2).getToiawaseteluktkkanou1(), "", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKanResultList.get(2).getToiawaseteluktkkanou2(), "", "問合せ先電話受付可能時間２");
        exStringEquals(ttdkKanResultList.get(2).getKyknmkj(), "山本　一郎", "契約者名（漢字）");
        exStringEquals(ttdkKanResultList.get(2).getGyoumuKousinKinou(), "EditSkYouTtdkKanryouTblTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKanResultList.get(2).getGyoumuKousinsyaId(), "junit", "業務用更新者ＩＤ");
        assertNotNull(null, BizDate.getSysDateTimeMilli());
        exStringEquals(ttdkKanResultList.get(2).getKhmosno1(), "860000033", "（契約保全）申込番号１");
        exStringEquals(ttdkKanResultList.get(2).getHenkousikibetukey(), "000000000000000012", "変更識別キー");
        exStringEquals(ttdkKanResultList.get(2).getShskyno(), "12345674892", "送付先郵便番号");
        exStringEquals(ttdkKanResultList.get(2).getShsadr1kj(), "住所１（漢字）３", "送付先住所１（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(2).getShsadr2kj(), "住所２（漢字）３", "送付先住所２（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(2).getShsadr3kj(), "住所３（漢字）３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(2).getShsnmkj(), "山本　四郎", "送付先氏名（漢字）");
        exStringEquals(ttdkKanResultList.get(2).getShsnmkj2(), "（親権者様）", "送付先氏名（漢字）２");
        exClassificationEquals(ttdkKanResultList.get(2).getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK2, "登録家族区分１");
        exStringEquals(ttdkKanResultList.get(2).getTrkkzknmkj1(), "山本　四郎", "登録家族名（漢字）１");
        exDateEquals(ttdkKanResultList.get(2).getTrkkzkseiymd1(), BizDate.valueOf("20060101"), "登録家族生年月日１");
        exStringEquals(ttdkKanResultList.get(2).getTrkkzkyno1(), "12345674892", "登録家族郵便番号１");
        exStringEquals(ttdkKanResultList.get(2).getTrkkzkadr1kj1(), "住所１（漢字）３", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKanResultList.get(2).getTrkkzkadr2kj1(), "住所２（漢字）３", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKanResultList.get(2).getTrkkzkadr3kj1(), "住所３（漢字）３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKanResultList.get(2).getTrkkzktelno1(), "12345678901234", "登録家族電話番号１");
        exStringEquals(ttdkKanResultList.get(2).getTrkkzktelnomtrkhyouji1(), "0", "登録家族電話番号未登録表示１");
        exStringEquals(ttdkKanResultList.get(2).getKzkomttutkbn1(), "06", "家族１用表通知区分");
        exStringEquals(ttdkKanResultList.get(2).getKzkaistmsgkbn1(), "73", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKanResultList.get(2).getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKanResultList.get(2).getKzkmoshnkniymsg21(), "73", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKanResultList.get(2).getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKanResultList.get(2).getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKanResultList.get(2).getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setSikibetuKey("10");
        khozenCommonParam.setFunctionId("EditSkYouTtdkKanryouTblTest_exec");

        AM_User user = new AM_User();
        user.setUserId("junit");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono("17806000046");
        kykKihon.setSkjmosno("860000041");
        kykKihon.setKbnkey("04");

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKykymd(BizDate.valueOf("20200101"));
        List<IT_KykSyouhn> kykSyouhnListSyu = new ArrayList<IT_KykSyouhn>();
        kykSyouhnListSyu.add(kykSyouhn);

        IT_KykSya kykSya = new IT_KykSya();
        kykSya.setKyknmkj("山本　一郎");

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.NONE);
        kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);

        IT_KykUkt kykDairiUkt = new IT_KykUkt();
        kykDairiUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);

        IT_KykUkt hhknDairiUkt = new IT_KykUkt();
        hhknDairiUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);

        BizDate syoriYmd = BizDate.valueOf("20201111");

        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;

        TyokusouTaisyouBean tyokusouTaisyouBean1 = new TyokusouTaisyouBean();

        tyokusouTaisyouBean1.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean1.setNmkj("山本　次郎");
        tyokusouTaisyouBean1.setSeiYmd(BizDate.valueOf("20040101"));
        tyokusouTaisyouBean1.setYno("12345674890");
        tyokusouTaisyouBean1.setAdr1kj("住所１（漢字）１");
        tyokusouTaisyouBean1.setAdr2kj("住所２（漢字）1");
        tyokusouTaisyouBean1.setAdr3kj("住所３（漢字）１");
        tyokusouTaisyouBean1.setTelno("12345678901234");

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanList = new ArrayList<TyokusouTaisyouBean>();
        tyokusouTaisyouBeanList.add(tyokusouTaisyouBean1);

        List<IT_TtdkKan> ttdkKanResultList = editSkYouTtdkKanryouTbl.exec(
            khozenCommonParam,
            kykKihon,
            kykSyouhnListSyu,
            kykSya,
            kykSonotaTkyk,
            kykDairiUkt,
            hhknDairiUkt,
            syoriYmd,
            hassouKbn,
            tyokusouTaisyouBeanList);

        exNumericEquals(ttdkKanResultList.size(), 1, "直送対象者Beanリスト");

        exStringEquals(ttdkKanResultList.get(0).getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKanResultList.get(0).getSyono(), "17806000046", "証券番号");
        exClassificationEquals(ttdkKanResultList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, "書類コード");
        exDateEquals(ttdkKanResultList.get(0).getTyouhyouymd(), BizDate.valueOf("20201111"), "帳票作成日");
        exClassificationEquals(ttdkKanResultList.get(0).getHassoukbn(), C_HassouKbn.BLNK, "発送区分");
        exClassificationEquals(ttdkKanResultList.get(0).getTantousitukbn(), C_TantousituKbn.KEIYAKUSINSA, "担当室区分");
        exStringEquals(ttdkKanResultList.get(0).getToiawasesosikinmkj(), "", "問合せ先組織名（漢字");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr3kj(), "", "問合せ先住所３（漢字");
        exStringEquals(ttdkKanResultList.get(0).getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawasetelno(), "", "問合せ先電話番号");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseteluktkkanou1(), "", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseteluktkkanou2(), "", "問合せ先電話受付可能時間２");
        exStringEquals(ttdkKanResultList.get(0).getKyknmkj(), "山本　一郎", "契約者名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getGyoumuKousinKinou(), "EditSkYouTtdkKanryouTblTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKanResultList.get(0).getGyoumuKousinsyaId(), "junit", "業務用更新者ＩＤ");
        assertNotNull(null, BizDate.getSysDateTimeMilli());
        exStringEquals(ttdkKanResultList.get(0).getKhmosno1(), "860000041", "（契約保全）申込番号１");
        exStringEquals(ttdkKanResultList.get(0).getHenkousikibetukey(), "10", "変更識別キー");
        exStringEquals(ttdkKanResultList.get(0).getShskyno(), "12345674890", "送付先郵便番号");
        exStringEquals(ttdkKanResultList.get(0).getShsadr1kj(), "住所１（漢字）１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(0).getShsadr2kj(), "住所２（漢字）1", "送付先住所２（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(0).getShsadr3kj(), "住所３（漢字）１", "送付先住所３（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(0).getShsnmkj(), "山本　次郎", "送付先氏名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getShsnmkj2(), "", "送付先氏名（漢字）２");
        exClassificationEquals(ttdkKanResultList.get(0).getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK2, "登録家族区分１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzknmkj1(), "山本　次郎", "登録家族名（漢字）１");
        exDateEquals(ttdkKanResultList.get(0).getTrkkzkseiymd1(), BizDate.valueOf("20040101"), "登録家族生年月日１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkyno1(), "12345674890", "登録家族郵便番号１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkadr1kj1(), "住所１（漢字）１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkadr2kj1(), "住所２（漢字）1", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkadr3kj1(), "住所３（漢字）１", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzktelno1(), "12345678901234", "登録家族電話番号１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzktelnomtrkhyouji1(), "0", "登録家族電話番号未登録表示１");
        exStringEquals(ttdkKanResultList.get(0).getKzkomttutkbn1(), "06", "家族１用表通知区分");
        exStringEquals(ttdkKanResultList.get(0).getKzkaistmsgkbn1(), "72", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKanResultList.get(0).getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKanResultList.get(0).getKzkmoshnkniymsg21(), "72", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKanResultList.get(0).getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKanResultList.get(0).getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKanResultList.get(0).getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setSikibetuKey("10");
        khozenCommonParam.setFunctionId("EditSkYouTtdkKanryouTblTest_exec");

        AM_User user = new AM_User();
        user.setUserId("junit");
        changeCurrentUser(baseUserInfo, user);

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono("17806000057");
        kykKihon.setSkjmosno("860000058");
        kykKihon.setKbnkey("05");

        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKykymd(BizDate.valueOf("20200101"));
        List<IT_KykSyouhn> kykSyouhnListSyu = new ArrayList<IT_KykSyouhn>();
        kykSyouhnListSyu.add(kykSyouhn);

        IT_KykSya kykSya = new IT_KykSya();
        kykSya.setKyknmkj("山本　一郎");

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setKykdrtkykhukaumu(C_UmuKbn.ARI);
        kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.NONE);

        IT_KykUkt kykDairiUkt = new IT_KykUkt();
        kykDairiUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);

        IT_KykUkt hhknDairiUkt = new IT_KykUkt();
        hhknDairiUkt.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);

        BizDate syoriYmd = BizDate.valueOf("20201111");

        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;

        TyokusouTaisyouBean tyokusouTaisyouBean1 = new TyokusouTaisyouBean();

        tyokusouTaisyouBean1.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean1.setNmkj("山本　次郎");
        tyokusouTaisyouBean1.setSeiYmd(BizDate.valueOf("20040101"));
        tyokusouTaisyouBean1.setYno("12345674890");
        tyokusouTaisyouBean1.setAdr1kj("住所１（漢字）１");
        tyokusouTaisyouBean1.setAdr2kj("住所２（漢字）1");
        tyokusouTaisyouBean1.setAdr3kj("住所３（漢字）１");
        tyokusouTaisyouBean1.setTelno("12345678901234");

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanList = new ArrayList<TyokusouTaisyouBean>();
        tyokusouTaisyouBeanList.add(tyokusouTaisyouBean1);

        List<IT_TtdkKan> ttdkKanResultList = editSkYouTtdkKanryouTbl.exec(
            khozenCommonParam,
            kykKihon,
            kykSyouhnListSyu,
            kykSya,
            kykSonotaTkyk,
            kykDairiUkt,
            hhknDairiUkt,
            syoriYmd,
            hassouKbn,
            tyokusouTaisyouBeanList);

        exNumericEquals(ttdkKanResultList.size(), 1, "直送対象者Beanリスト");

        exStringEquals(ttdkKanResultList.get(0).getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKanResultList.get(0).getSyono(), "17806000057", "証券番号");
        exClassificationEquals(ttdkKanResultList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, "書類コード");
        exDateEquals(ttdkKanResultList.get(0).getTyouhyouymd(), BizDate.valueOf("20201111"), "帳票作成日");
        exClassificationEquals(ttdkKanResultList.get(0).getHassoukbn(), C_HassouKbn.BLNK, "発送区分");
        exClassificationEquals(ttdkKanResultList.get(0).getTantousitukbn(), C_TantousituKbn.KEIYAKUSINSA, "担当室区分");
        exStringEquals(ttdkKanResultList.get(0).getToiawasesosikinmkj(), "", "問合せ先組織名（漢字");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseadr3kj(), "", "問合せ先住所３（漢字");
        exStringEquals(ttdkKanResultList.get(0).getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getToiawasetelno(), "", "問合せ先電話番号");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseteluktkkanou1(), "", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKanResultList.get(0).getToiawaseteluktkkanou2(), "", "問合せ先電話受付可能時間２");
        exStringEquals(ttdkKanResultList.get(0).getKyknmkj(), "山本　一郎", "契約者名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getGyoumuKousinKinou(), "EditSkYouTtdkKanryouTblTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKanResultList.get(0).getGyoumuKousinsyaId(), "junit", "業務用更新者ＩＤ");
        assertNotNull(null, BizDate.getSysDateTimeMilli());
        exStringEquals(ttdkKanResultList.get(0).getKhmosno1(), "860000058", "（契約保全）申込番号１");
        exStringEquals(ttdkKanResultList.get(0).getHenkousikibetukey(), "10", "変更識別キー");
        exStringEquals(ttdkKanResultList.get(0).getShskyno(), "12345674890", "送付先郵便番号");
        exStringEquals(ttdkKanResultList.get(0).getShsadr1kj(), "住所１（漢字）１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(0).getShsadr2kj(), "住所２（漢字）1", "送付先住所２（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(0).getShsadr3kj(), "住所３（漢字）１", "送付先住所３（漢字）（３０桁）");
        exStringEquals(ttdkKanResultList.get(0).getShsnmkj(), "山本　次郎", "送付先氏名（漢字）");
        exStringEquals(ttdkKanResultList.get(0).getShsnmkj2(), "", "送付先氏名（漢字）２");
        exClassificationEquals(ttdkKanResultList.get(0).getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK2, "登録家族区分１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzknmkj1(), "山本　次郎", "登録家族名（漢字）１");
        exDateEquals(ttdkKanResultList.get(0).getTrkkzkseiymd1(), BizDate.valueOf("20040101"), "登録家族生年月日１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkyno1(), "12345674890", "登録家族郵便番号１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkadr1kj1(), "住所１（漢字）１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkadr2kj1(), "住所２（漢字）1", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzkadr3kj1(), "住所３（漢字）１", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzktelno1(), "12345678901234", "登録家族電話番号１");
        exStringEquals(ttdkKanResultList.get(0).getTrkkzktelnomtrkhyouji1(), "0", "登録家族電話番号未登録表示１");
        exStringEquals(ttdkKanResultList.get(0).getKzkomttutkbn1(), "06", "家族１用表通知区分");
        exStringEquals(ttdkKanResultList.get(0).getKzkaistmsgkbn1(), "71", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKanResultList.get(0).getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKanResultList.get(0).getKzkmoshnkniymsg21(), "71", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKanResultList.get(0).getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKanResultList.get(0).getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKanResultList.get(0).getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");
    }
}
