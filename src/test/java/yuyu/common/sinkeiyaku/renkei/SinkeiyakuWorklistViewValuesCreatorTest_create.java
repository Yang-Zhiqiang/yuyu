package yuyu.common.sinkeiyaku.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.renkei.WorklistViewValuesBean;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHokenSyuruiNo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約ワークリスト用表示情報生成 {@link SkWorklistViewValuesCreator#create(List<WorklistViewValuesBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuWorklistViewValuesCreatorTest_create {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SinkeiyakuWorklistViewValuesCreator skWorklistViewValuesCreator;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSyono("11807111118");
        syoriCTL1.setNyknkwsrate(BizNumber.valueOf(0));
        syoriCTL1.setImusateijyoukbn(C_ImusateijyouKbn.valueOf("0"));
        syoriCTL1.setDoujimosumu(C_UmuKbn.valueOf("0"));
        syoriCTL1.setAnnaikaisuu(0);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSyono("11807111118");
        syoriCTL2.setNyknkwsrate(BizNumber.valueOf(0));
        syoriCTL2.setImusateijyoukbn(C_ImusateijyouKbn.valueOf("0"));
        syoriCTL2.setDoujimosumu(C_UmuKbn.valueOf("0"));
        syoriCTL2.setAnnaikaisuu(0);

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri1 = syoriCTL2.createSkTtdkTyuuiKanri();
        skTtdkTyuuiKanri1.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.valueOf("0"));
        skTtdkTyuuiKanri1.setSkeittdktyuuiyouhikbn(C_YouhiKbn.valueOf("0"));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSyono("11807111118");
        syoriCTL3.setNyknkwsrate(BizNumber.valueOf(0));
        syoriCTL3.setImusateijyoukbn(C_ImusateijyouKbn.valueOf("0"));
        syoriCTL3.setDoujimosumu(C_UmuKbn.valueOf("0"));
        syoriCTL3.setAnnaikaisuu(0);

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri2 = syoriCTL3.createSkTtdkTyuuiKanri();
        skTtdkTyuuiKanri2.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.valueOf("0"));
        skTtdkTyuuiKanri2.setSkeittdktyuuiyouhikbn(C_YouhiKbn.valueOf("0"));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSyono("11807111118");
        syoriCTL4.setNyknkwsrate(BizNumber.valueOf(0));
        syoriCTL4.setImusateijyoukbn(C_ImusateijyouKbn.valueOf("1"));
        syoriCTL4.setDoujimosumu(C_UmuKbn.valueOf("1"));
        syoriCTL4.setAnnaikaisuu(0);

        HT_MosKihon mosKihon1 = syoriCTL4.createMosKihon();
        mosKihon1.setKykkbn(C_KykKbn.valueOf("2"));
        mosKihon1.setHknsyuruino(C_HknsyuruiNo.valueOf("444"));
        mosKihon1.setHknsyuruinosd(0);
        mosKihon1.setNkgnshosyougk(BizCurrency.valueOf(0));
        mosKihon1.setZnnkai(0);
        mosKihon1.setZennoup(BizCurrency.valueOf(0));
        mosKihon1.setMosfstpkei(BizCurrency.valueOf(0));
        mosKihon1.setHyouteip(BizCurrency.valueOf(0));
        mosKihon1.setSeitoufstpkei(BizCurrency.valueOf(0));
        mosKihon1.setFstphrkgk(BizCurrency.valueOf(0));
        mosKihon1.setHhknnmkj("被保険者名");
        mosKihon1.setHhknnen(0);
        mosKihon1.setKyknmkj("契約者名");
        mosKihon1.setKyknen(0);
        mosKihon1.setNstkmnknsyu(0);
        mosKihon1.setNstkmnknkkn(0);
        mosKihon1.setNstksbnkkn(0);
        mosKihon1.setSbuktnin(0);

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri3 = syoriCTL4.createSkTtdkTyuuiKanri();
        skTtdkTyuuiKanri3.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.valueOf("1"));
        skTtdkTyuuiKanri3.setSkeittdktyuuiyouhikbn(C_YouhiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSyono("11807111118");
        syoriCTL5.setNyknkwsrate(BizNumber.valueOf(0));
        syoriCTL5.setImusateijyoukbn(C_ImusateijyouKbn.valueOf("2"));
        syoriCTL5.setDoujimosumu(C_UmuKbn.valueOf("1"));
        syoriCTL5.setAnnaikaisuu(0);

        HT_MosKihon mosKihon2 = syoriCTL5.createMosKihon();
        mosKihon2.setKykkbn(C_KykKbn.valueOf("1"));
        mosKihon2.setHknsyuruino(C_HknsyuruiNo.valueOf("444"));
        mosKihon2.setHknsyuruinosd(0);
        mosKihon2.setNkgnshosyougk(BizCurrency.valueOf(0));
        mosKihon2.setZnnkai(0);
        mosKihon2.setZennoup(BizCurrency.valueOf(0));
        mosKihon2.setMosfstpkei(BizCurrency.valueOf(0));
        mosKihon2.setHyouteip(BizCurrency.valueOf(0));
        mosKihon2.setSeitoufstpkei(BizCurrency.valueOf(0));
        mosKihon2.setFstphrkgk(BizCurrency.valueOf(0));
        mosKihon2.setHhknnmkj("被保険者名");
        mosKihon2.setHhknnen(0);
        mosKihon2.setKyknmkj("契約者名");
        mosKihon2.setKyknen(0);
        mosKihon2.setNstkmnknsyu(0);
        mosKihon2.setNstkmnknkkn(0);
        mosKihon2.setNstksbnkkn(0);
        mosKihon2.setSbuktnin(0);

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri4 = syoriCTL5.createSkTtdkTyuuiKanri();
        skTtdkTyuuiKanri4.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.valueOf("1"));
        skTtdkTyuuiKanri4.setSkeittdktyuuiyouhikbn(C_YouhiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSyono("11807111118");
        syoriCTL6.setNyknkwsrate(BizNumber.valueOf(0));
        syoriCTL6.setImusateijyoukbn(C_ImusateijyouKbn.valueOf("0"));
        syoriCTL6.setDoujimosumu(C_UmuKbn.valueOf("0"));
        syoriCTL6.setAnnaikaisuu(0);

        HT_MosKihon mosKihon3 = syoriCTL6.createMosKihon();
        mosKihon3.setKykkbn(C_KykKbn.valueOf("1"));
        mosKihon3.setHknsyuruino(C_HknsyuruiNo.valueOf("444"));
        mosKihon3.setHknsyuruinosd(0);
        mosKihon3.setNkgnshosyougk(BizCurrency.valueOf(0));
        mosKihon3.setZnnkai(0);
        mosKihon3.setZennoup(BizCurrency.valueOf(0));
        mosKihon3.setMosfstpkei(BizCurrency.valueOf(0));
        mosKihon3.setHyouteip(BizCurrency.valueOf(0));
        mosKihon3.setSeitoufstpkei(BizCurrency.valueOf(0));
        mosKihon3.setFstphrkgk(BizCurrency.valueOf(0));
        mosKihon3.setHhknnmkj("被保険者名３");
        mosKihon3.setHhknnen(0);
        mosKihon3.setKyknmkj("契約者名３");
        mosKihon3.setKyknen(0);
        mosKihon3.setNstkmnknsyu(0);
        mosKihon3.setNstkmnknkkn(0);
        mosKihon3.setNstksbnkkn(0);
        mosKihon3.setSbuktnin(0);

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri5 = syoriCTL6.createSkTtdkTyuuiKanri();
        skTtdkTyuuiKanri5.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.valueOf("0"));
        skTtdkTyuuiKanri5.setSkeittdktyuuiyouhikbn(C_YouhiKbn.valueOf("0"));

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setSyono("11807111118");
        syoriCTL7.setNyknkwsrate(BizNumber.valueOf(0));
        syoriCTL7.setImusateijyoukbn(C_ImusateijyouKbn.valueOf("0"));
        syoriCTL7.setDoujimosumu(C_UmuKbn.valueOf("0"));
        syoriCTL7.setAnnaikaisuu(0);

        HT_MosKihon mosKihon4 = syoriCTL7.createMosKihon();
        mosKihon4.setKykkbn(C_KykKbn.valueOf("1"));
        mosKihon4.setHknsyuruino(C_HknsyuruiNo.valueOf("444"));
        mosKihon4.setHknsyuruinosd(0);
        mosKihon4.setNkgnshosyougk(BizCurrency.valueOf(0));
        mosKihon4.setZnnkai(0);
        mosKihon4.setZennoup(BizCurrency.valueOf(0));
        mosKihon4.setMosfstpkei(BizCurrency.valueOf(0));
        mosKihon4.setHyouteip(BizCurrency.valueOf(0));
        mosKihon4.setSeitoufstpkei(BizCurrency.valueOf(0));
        mosKihon4.setFstphrkgk(BizCurrency.valueOf(0));
        mosKihon4.setHhknnmkj("被保険者名４");
        mosKihon4.setHhknnen(0);
        mosKihon4.setKyknmkj("契約者名４");
        mosKihon4.setKyknen(0);
        mosKihon4.setNstkmnknsyu(0);
        mosKihon4.setNstkmnknkkn(0);
        mosKihon4.setNstksbnkkn(0);
        mosKihon4.setSbuktnin(0);

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri6 = syoriCTL7.createSkTtdkTyuuiKanri();
        skTtdkTyuuiKanri6.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.valueOf("0"));
        skTtdkTyuuiKanri6.setSkeittdktyuuiyouhikbn(C_YouhiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112295");
        syoriCTL8.setSyono("11807111118");
        syoriCTL8.setNyknkwsrate(BizNumber.valueOf(0));
        syoriCTL8.setImusateijyoukbn(C_ImusateijyouKbn.valueOf("0"));
        syoriCTL8.setDoujimosumu(C_UmuKbn.valueOf("0"));
        syoriCTL8.setAnnaikaisuu(0);

        HT_MosKihon mosKihon5 = syoriCTL8.createMosKihon();
        mosKihon5.setKykkbn(C_KykKbn.valueOf("1"));
        mosKihon5.setHknsyuruino(C_HknsyuruiNo.valueOf("444"));
        mosKihon5.setHknsyuruinosd(0);
        mosKihon5.setNkgnshosyougk(BizCurrency.valueOf(0));
        mosKihon5.setZnnkai(0);
        mosKihon5.setZennoup(BizCurrency.valueOf(0));
        mosKihon5.setMosfstpkei(BizCurrency.valueOf(0));
        mosKihon5.setHyouteip(BizCurrency.valueOf(0));
        mosKihon5.setSeitoufstpkei(BizCurrency.valueOf(0));
        mosKihon5.setFstphrkgk(BizCurrency.valueOf(0));
        mosKihon5.setHhknnmkj("被保険者名５");
        mosKihon5.setHhknnen(0);
        mosKihon5.setKyknmkj("契約者名５");
        mosKihon5.setKyknen(0);
        mosKihon5.setNstkmnknsyu(0);
        mosKihon5.setNstkmnknkkn(0);
        mosKihon5.setNstksbnkkn(0);
        mosKihon5.setSbuktnin(0);

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri7 = syoriCTL8.createSkTtdkTyuuiKanri();
        skTtdkTyuuiKanri7.setSkeittdkkinkyuyouhikbn(C_YouhiKbn.valueOf("1"));
        skTtdkTyuuiKanri7.setSkeittdktyuuiyouhikbn(C_YouhiKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL8);

        HM_SkHokenSyuruiNo skHokenSyuruiNo1 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("000"), 0);
        skHokenSyuruiNo1.setHknsyuruiworklist("10001");
        skHokenSyuruiNo1.setInputctrlsyouhnsdno(0);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo1);

        HM_SkHokenSyuruiNo skHokenSyuruiNo2 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("441"), 0);
        skHokenSyuruiNo2.setHknsyuruiworklist("10001");
        skHokenSyuruiNo2.setInputctrlsyouhnsdno(0);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo2);

        HM_SkHokenSyuruiNo skHokenSyuruiNo3 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("441"), 1);
        skHokenSyuruiNo3.setHknsyuruiworklist("10001");
        skHokenSyuruiNo3.setInputctrlsyouhnsdno(0);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo3);

        HM_SkHokenSyuruiNo skHokenSyuruiNo4 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("441"), 2);
        skHokenSyuruiNo4.setHknsyuruiworklist("10001");
        skHokenSyuruiNo4.setInputctrlsyouhnsdno(0);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo4);

        HM_SkHokenSyuruiNo skHokenSyuruiNo5 = new HM_SkHokenSyuruiNo(C_HknsyuruiNo.valueOf("444"), 0);
        skHokenSyuruiNo5.setHknsyuruiworklist("10001");
        skHokenSyuruiNo5.setInputctrlsyouhnsdno(0);

        sinkeiyakuDomManager.insert(skHokenSyuruiNo5);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());
    }

    @Test
    @TestOrder(10)
    public void testCreate_A1() {

        List<WorklistViewValuesBean> worklistViewValuesBeanLst = new ArrayList<>();
        worklistViewValuesBeanLst = skWorklistViewValuesCreator.create(worklistViewValuesBeanLst);
        exNumericEquals(worklistViewValuesBeanLst.size(), 0, "ワークリスト用表示情報Beanリストのサイズ");

    }

    @Test
    @TestOrder(20)
    public void testCreate_A2() {

        List<WorklistViewValuesBean> worklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        worklistViewValuesBean.setHknsyuruiNo("443");
        worklistViewValuesBean.setMosno("791112519");
        worklistViewValuesBeanLst.add(worklistViewValuesBean);
        worklistViewValuesBeanLst = skWorklistViewValuesCreator.create(worklistViewValuesBeanLst);
        exNumericEquals(worklistViewValuesBeanLst.size(), 1, "ワークリスト用表示情報Beanリストのサイズ");
        exStringEquals(worklistViewValuesBeanLst.get(0).getHknsyuruiWorklist(), "", "保険種類（ワークリスト）");
        exStringEquals(worklistViewValuesBeanLst.get(0).getKyknmkj(), "", "契約者名（漢字）");
    }

    @Test
    @TestOrder(30)
    public void testCreate_A3() {

        List<WorklistViewValuesBean> worklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        worklistViewValuesBean.setHknsyuruiNo("443");
        worklistViewValuesBean.setMosno("791112220");
        worklistViewValuesBeanLst.add(worklistViewValuesBean);
        WorklistViewValuesBean worklistViewValuesBean1 = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        worklistViewValuesBean1.setHknsyuruiNo("000");
        worklistViewValuesBean1.setMosno("791112238");
        worklistViewValuesBeanLst.add(worklistViewValuesBean1);
        WorklistViewValuesBean worklistViewValuesBean2 = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        worklistViewValuesBean2.setHknsyuruiNo("441");
        worklistViewValuesBean2.setMosno("791112246");
        worklistViewValuesBeanLst.add(worklistViewValuesBean2);
        worklistViewValuesBeanLst = skWorklistViewValuesCreator.create(worklistViewValuesBeanLst);
        exNumericEquals(worklistViewValuesBeanLst.size(), 3, "ワークリスト用表示情報Beanリストのサイズ");
        exStringEquals(worklistViewValuesBeanLst.get(0).getHknsyuruiWorklist(), "", "保険種類（ワークリスト）");
        exStringEquals(worklistViewValuesBeanLst.get(0).getKyknmkj(), "", "契約者名（漢字）");
        exStringEquals(worklistViewValuesBeanLst.get(1).getHknsyuruiWorklist(), "10001", "保険種類（ワークリスト）");
        exStringEquals(worklistViewValuesBeanLst.get(1).getKyknmkj(), "", "契約者名（漢字）");
        exStringEquals(worklistViewValuesBeanLst.get(2).getHknsyuruiWorklist(), "10001", "保険種類（ワークリスト）");
        exStringEquals(worklistViewValuesBeanLst.get(2).getKyknmkj(), "", "契約者名（漢字）");


        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
            sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruino(
                C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        SortHM_SkHokenSyuruiNo sortHM_SkHokenSyuruiNo  = SWAKInjector.getInstance(SortHM_SkHokenSyuruiNo.class);
        skHokenSyuruiNoLst = sortHM_SkHokenSyuruiNo.OrderHM_SkHokenSyuruiNoByPkDesc(skHokenSyuruiNoLst);
        exClassificationEquals(skHokenSyuruiNoLst.get(0).getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exNumericEquals(skHokenSyuruiNoLst.get(0).getHknsyuruinosd(), 2, "保険種類番号世代");
        exClassificationEquals(skHokenSyuruiNoLst.get(1).getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exNumericEquals(skHokenSyuruiNoLst.get(1).getHknsyuruinosd(), 1, "保険種類番号世代");
        exClassificationEquals(skHokenSyuruiNoLst.get(2).getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exNumericEquals(skHokenSyuruiNoLst.get(2).getHknsyuruinosd(), 0, "保険種類番号世代");
    }

    @Test
    @TestOrder(40)
    public void testCreate_A4() {

        List<WorklistViewValuesBean> worklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        worklistViewValuesBean.setHknsyuruiNo("444");
        worklistViewValuesBean.setMosno("791112253");
        worklistViewValuesBeanLst.add(worklistViewValuesBean);

        worklistViewValuesBeanLst = skWorklistViewValuesCreator.create(worklistViewValuesBeanLst);
        exNumericEquals(worklistViewValuesBeanLst.size(), 1, "ワークリスト用表示情報Beanリストのサイズ");
        exStringEquals(worklistViewValuesBeanLst.get(0).getHknsyuruiWorklist(), "10001", "保険種類（ワークリスト）");
        exStringEquals(worklistViewValuesBeanLst.get(0).getKyknmkj(), "■◎●被保険者名", "契約者名（漢字）");

    }
    @Test
    @TestOrder(50)
    public void testCreate_A5() {

        List<WorklistViewValuesBean> worklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        worklistViewValuesBean.setHknsyuruiNo("444");
        worklistViewValuesBean.setMosno("791112261");
        worklistViewValuesBeanLst.add(worklistViewValuesBean);

        worklistViewValuesBeanLst = skWorklistViewValuesCreator.create(worklistViewValuesBeanLst);
        exNumericEquals(worklistViewValuesBeanLst.size(), 1, "ワークリスト用表示情報Beanリストのサイズ");
        exStringEquals(worklistViewValuesBeanLst.get(0).getHknsyuruiWorklist(), "10001", "保険種類（ワークリスト）");
        exStringEquals(worklistViewValuesBeanLst.get(0).getKyknmkj(), "△■◎●契約者名", "契約者名（漢字）");

    }

    @Test
    @TestOrder(60)
    public void testCreate_A6() {

        List<WorklistViewValuesBean> worklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        worklistViewValuesBean.setHknsyuruiNo("444");
        worklistViewValuesBean.setMosno("791112279");
        worklistViewValuesBeanLst.add(worklistViewValuesBean);

        worklistViewValuesBeanLst = skWorklistViewValuesCreator.create(worklistViewValuesBeanLst);
        exNumericEquals(worklistViewValuesBeanLst.size(), 1, "ワークリスト用表示情報Beanリストのサイズ");
        exStringEquals(worklistViewValuesBeanLst.get(0).getHknsyuruiWorklist(), "10001", "保険種類（ワークリスト）");
        exStringEquals(worklistViewValuesBeanLst.get(0).getKyknmkj(), "契約者名３", "契約者名（漢字）");

    }

    @Test
    @TestOrder(70)
    public void testCreate_A7() {

        List<WorklistViewValuesBean> worklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        worklistViewValuesBean.setHknsyuruiNo("444");
        worklistViewValuesBean.setMosno("791112287");
        worklistViewValuesBeanLst.add(worklistViewValuesBean);

        worklistViewValuesBeanLst = skWorklistViewValuesCreator.create(worklistViewValuesBeanLst);
        exNumericEquals(worklistViewValuesBeanLst.size(), 1, "ワークリスト用表示情報Beanリストのサイズ");
        exStringEquals(worklistViewValuesBeanLst.get(0).getHknsyuruiWorklist(), "10001", "保険種類（ワークリスト）");
        exStringEquals(worklistViewValuesBeanLst.get(0).getKyknmkj(), "●契約者名４", "契約者名（漢字）");

    }

    @Test
    @TestOrder(80)
    public void testCreate_A8() {

        List<WorklistViewValuesBean> worklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        worklistViewValuesBean.setHknsyuruiNo("444");
        worklistViewValuesBean.setMosno("791112295");
        worklistViewValuesBeanLst.add(worklistViewValuesBean);

        worklistViewValuesBeanLst = skWorklistViewValuesCreator.create(worklistViewValuesBeanLst);
        exNumericEquals(worklistViewValuesBeanLst.size(), 1, "ワークリスト用表示情報Beanリストのサイズ");
        exStringEquals(worklistViewValuesBeanLst.get(0).getHknsyuruiWorklist(), "10001", "保険種類（ワークリスト）");
        exStringEquals(worklistViewValuesBeanLst.get(0).getKyknmkj(), "◎●契約者名５", "契約者名（漢字）");

    }
}
