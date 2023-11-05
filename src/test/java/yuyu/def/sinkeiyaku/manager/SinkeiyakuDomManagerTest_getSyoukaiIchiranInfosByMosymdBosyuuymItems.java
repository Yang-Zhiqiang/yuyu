package yuyu.def.sinkeiyaku.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.SyoukaiIchiranInfosByMosymdBosyuuymItemsBean;
import yuyu.testinfr.OrderedRunner;

/**
 * 照会一覧情報のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoukaiIchiranInfosByMosymdBosyuuymItems {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
            "dt0001", "kc01", true, true,null,null);

        Assert.assertEquals(0, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112519");
        syoriCTL1.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL1.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL1.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL1.setDaimosno("791112220");

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setMosymd(BizDate.valueOf(20150603));
        mosKihon1.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon1.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon1.setHhknnmkj("被保険者名（漢字）０１");

        HT_SkHubi skHubi1 = syoriCTL1.createSkHubi();
        skHubi1.setHubisikibetukey("20140102");

        HT_SkHubiDetail skHubiDetail1 = skHubi1.createSkHubiDetail();
        skHubiDetail1.setRenno3keta(1);
        HT_SkHubiDetail skHubiDetail111 = skHubi1.createSkHubiDetail();
        skHubiDetail111.setRenno3keta(2);

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(1);
        mosDairiten1.setTratkiagcd("dt0001");
        mosDairiten1.setOyadrtencd("kc01");

        HT_MosDairiten mosDairiten2 = syoriCTL1.createMosDairiten();
        mosDairiten2.setRenno(2);
        mosDairiten2.setTratkiagcd("dt0001");
        mosDairiten2.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112501");
        syoriCTL2.setKktnrkumu(C_UmuKbn.NONE);
        syoriCTL2.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL2.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL2.setKhnhbkbn(C_UmuKbn.NONE);
        syoriCTL2.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL2.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL2.setDaimosno("791112220");
        syoriCTL2.setJimusrhkbn(C_JimusrhKbn.HORYU);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setMosymd(BizDate.valueOf(20150604));
        mosKihon2.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon2.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon2.setHhknnmkj("被保険者名（漢字）０２");

        HT_SkHubi skHubi2 = syoriCTL2.createSkHubi();
        skHubi2.setHubisikibetukey("20140103");

        HT_SkHubiDetail skHubiDetail2 = skHubi2.createSkHubiDetail();
        skHubiDetail2.setRenno3keta(1);
        HT_SkHubiDetail skHubiDetail22 = skHubi2.createSkHubiDetail();
        skHubiDetail22.setRenno3keta(2);

        HT_MosDairiten mosDairiten3 = syoriCTL2.createMosDairiten();
        mosDairiten3.setRenno(1);
        mosDairiten3.setTratkiagcd("dt0001");
        mosDairiten3.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112493");
        syoriCTL3.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL3.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL3.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL3.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL3.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL3.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL3.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL3.setDaimosno("791112220");

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setMosymd(BizDate.valueOf(20150605));
        mosKihon3.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon3.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon3.setHhknnmkj("被保険者名（漢字）０３");

        HT_SkHubi skHubi3 = syoriCTL3.createSkHubi();
        skHubi3.setHubisikibetukey("20140104");

        HT_SkHubiDetail skHubiDetail3 = skHubi3.createSkHubiDetail();
        skHubiDetail3.setRenno3keta(1);
        HT_SkHubiDetail skHubiDetail33 = skHubi3.createSkHubiDetail();
        skHubiDetail33.setRenno3keta(2);

        HT_MosDairiten mosDairiten4 = syoriCTL3.createMosDairiten();
        mosDairiten4.setRenno(1);
        mosDairiten4.setTratkiagcd("dt0001");
        mosDairiten4.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112485");
        syoriCTL4.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL4.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL4.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL4.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL4.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL4.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL4.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL4.setDaimosno("791112220");

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setMosymd(BizDate.valueOf(20150606));
        mosKihon4.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon4.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon4.setHhknnmkj("被保険者名（漢字）０４");

        HT_SkHubi skHubi4 = syoriCTL4.createSkHubi();
        skHubi4.setHubisikibetukey("20140105");

        HT_SkHubiDetail skHubiDetail4 = skHubi4.createSkHubiDetail();
        skHubiDetail4.setRenno3keta(1);
        HT_SkHubiDetail skHubiDetail44 = skHubi4.createSkHubiDetail();
        skHubiDetail44.setRenno3keta(2);

        HT_MosDairiten mosDairiten5 = syoriCTL4.createMosDairiten();
        mosDairiten5.setRenno(1);
        mosDairiten5.setTratkiagcd("dt0001");
        mosDairiten5.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112477");
        syoriCTL5.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL5.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL5.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL5.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL5.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL5.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL5.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL5.setDaimosno("791112220");

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setMosymd(BizDate.valueOf(20150602));
        mosKihon5.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon5.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon5.setHhknnmkj("被保険者名（漢字）０５");

        HT_SkHubi skHubi5 = syoriCTL5.createSkHubi();
        skHubi5.setHubisikibetukey("20140106");

        HT_SkHubiDetail skHubiDetail5 = skHubi5.createSkHubiDetail();
        skHubiDetail5.setRenno3keta(1);
        HT_SkHubiDetail skHubiDetail55 = skHubi5.createSkHubiDetail();
        skHubiDetail55.setRenno3keta(2);

        HT_MosDairiten mosDairiten6 = syoriCTL5.createMosDairiten();
        mosDairiten6.setRenno(1);
        mosDairiten6.setTratkiagcd("dt0001");
        mosDairiten6.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112469");
        syoriCTL6.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL6.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL6.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL6.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL6.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL6.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL6.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL6.setDaimosno("791112246");

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setMosymd(BizDate.valueOf(20150603));
        mosKihon6.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon6.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon6.setHhknnmkj("被保険者名（漢字）０６");

        HT_SkHubi skHubi6 = syoriCTL6.createSkHubi();
        skHubi6.setHubisikibetukey("20140107");

        HT_SkHubiDetail skHubiDetail6 = skHubi6.createSkHubiDetail();
        skHubiDetail6.setRenno3keta(1);

        HT_MosDairiten mosDairiten7 = syoriCTL6.createMosDairiten();
        mosDairiten7.setRenno(1);
        mosDairiten7.setTratkiagcd("dt0001");
        mosDairiten7.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112451");
        syoriCTL7.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL7.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL7.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL7.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL7.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL7.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL7.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL7.setDaimosno("791112220");

        HT_MosKihon mosKihon7 = syoriCTL7.createMosKihon();
        mosKihon7.setMosymd(BizDate.valueOf(20150603));
        mosKihon7.setBosyuuym(BizDateYM.valueOf(201504));
        mosKihon7.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon7.setHhknnmkj("被保険者名（漢字）０７");

        HT_SkHubi skHubi7 = syoriCTL7.createSkHubi();
        skHubi7.setHubisikibetukey("20140108");

        HT_SkHubiDetail skHubiDetail7 = skHubi7.createSkHubiDetail();
        skHubiDetail7.setRenno3keta(1);

        HT_MosDairiten mosDairiten8 = syoriCTL7.createMosDairiten();
        mosDairiten8.setRenno(1);
        mosDairiten8.setTratkiagcd("dt0001");
        mosDairiten8.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112444");
        syoriCTL8.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL8.setNyknnrkumu(C_UmuKbn.NONE);
        syoriCTL8.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL8.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL8.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL8.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL8.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL8.setDaimosno("791112220");

        HT_MosKihon mosKihon8 = syoriCTL8.createMosKihon();
        mosKihon8.setMosymd(BizDate.valueOf(20150603));
        mosKihon8.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon8.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon8.setHhknnmkj("被保険者名（漢字）０８");

        HT_SkHubi skHubi8 = syoriCTL8.createSkHubi();
        skHubi8.setHubisikibetukey("20140109");

        HT_SkHubiDetail skHubiDetail8 = skHubi8.createSkHubiDetail();
        skHubiDetail8.setRenno3keta(1);

        HT_MosDairiten mosDairiten9 = syoriCTL8.createMosDairiten();
        mosDairiten9.setRenno(1);
        mosDairiten9.setTratkiagcd("dt0001");
        mosDairiten9.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL8);

        HT_SyoriCTL syoriCTL9 = new HT_SyoriCTL("791112436");
        syoriCTL9.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL9.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL9.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL9.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL9.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL9.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
        syoriCTL9.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL9.setDaimosno("791112220");

        HT_MosKihon mosKihon9 = syoriCTL9.createMosKihon();
        mosKihon9.setMosymd(BizDate.valueOf(20150603));
        mosKihon9.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon9.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon9.setHhknnmkj("被保険者名（漢字）０９");

        HT_SkHubi skHubi9 = syoriCTL9.createSkHubi();
        skHubi9.setHubisikibetukey("20140110");

        HT_SkHubiDetail skHubiDetail9 = skHubi9.createSkHubiDetail();
        skHubiDetail9.setRenno3keta(1);

        HT_MosDairiten mosDairiten10 = syoriCTL9.createMosDairiten();
        mosDairiten10.setRenno(1);
        mosDairiten10.setTratkiagcd("dt0001");
        mosDairiten10.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL9);

        HT_SyoriCTL syoriCTL10 = new HT_SyoriCTL("791112428");
        syoriCTL10.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL10.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL10.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL10.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL10.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL10.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL10.setSeiritukbn(C_SeirituKbn.ITIPMATI);
        syoriCTL10.setDaimosno("791112220");

        HT_MosKihon mosKihon10 = syoriCTL10.createMosKihon();
        mosKihon10.setMosymd(BizDate.valueOf(20150603));
        mosKihon10.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon10.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon10.setHhknnmkj("被保険者名（漢字）１０");

        HT_SkHubi skHubi10 = syoriCTL10.createSkHubi();
        skHubi10.setHubisikibetukey("20140111");

        HT_SkHubiDetail skHubiDetail10 = skHubi10.createSkHubiDetail();
        skHubiDetail10.setRenno3keta(1);

        HT_MosDairiten mosDairiten11 = syoriCTL10.createMosDairiten();
        mosDairiten11.setRenno(1);
        mosDairiten11.setTratkiagcd("dt0001");
        mosDairiten11.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL10);

        HT_SyoriCTL syoriCTL11 = new HT_SyoriCTL("791112410");
        syoriCTL11.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL11.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL11.setKthhbkbn(C_UmuKbn.NONE);
        syoriCTL11.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL11.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL11.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL11.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL11.setDaimosno("791112220");

        HT_MosKihon mosKihon11 = syoriCTL11.createMosKihon();
        mosKihon11.setMosymd(BizDate.valueOf(20150603));
        mosKihon11.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon11.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon11.setHhknnmkj("被保険者名（漢字）１１");

        HT_SkHubi skHubi11 = syoriCTL11.createSkHubi();
        skHubi11.setHubisikibetukey("20140112");

        HT_SkHubiDetail skHubiDetail11 = skHubi11.createSkHubiDetail();
        skHubiDetail11.setRenno3keta(1);

        HT_MosDairiten mosDairiten12 = syoriCTL11.createMosDairiten();
        mosDairiten12.setRenno(1);
        mosDairiten12.setTratkiagcd("dt0001");
        mosDairiten12.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL11);

        HT_SyoriCTL syoriCTL12 = new HT_SyoriCTL("791112402");
        syoriCTL12.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL12.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL12.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL12.setSrhhbkbn(C_UmuKbn.NONE);
        syoriCTL12.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL12.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL12.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL12.setDaimosno("791112220");

        HT_MosKihon mosKihon12 = syoriCTL12.createMosKihon();
        mosKihon12.setMosymd(BizDate.valueOf(20150603));
        mosKihon12.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon12.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon12.setHhknnmkj("被保険者名（漢字）１２");

        HT_SkHubi skHubi12 = syoriCTL12.createSkHubi();
        skHubi12.setHubisikibetukey("20140113");

        HT_SkHubiDetail skHubiDetail12 = skHubi12.createSkHubiDetail();
        skHubiDetail12.setRenno3keta(1);

        HT_MosDairiten mosDairiten13 = syoriCTL12.createMosDairiten();
        mosDairiten13.setRenno(1);
        mosDairiten13.setTratkiagcd("dt0001");
        mosDairiten13.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL12);

        HT_SyoriCTL syoriCTL13 = new HT_SyoriCTL("791112394");
        syoriCTL13.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL13.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL13.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL13.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL13.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL13.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL13.setDaimosno("791112220");
        syoriCTL13.setJimusrhkbn(C_JimusrhKbn.NONE);

        HT_MosKihon mosKihon13 = syoriCTL13.createMosKihon();
        mosKihon13.setMosymd(BizDate.valueOf(20150603));
        mosKihon13.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon13.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon13.setHhknnmkj("被保険者名（漢字）１３");

        HT_SkHubi skHubi13 = syoriCTL13.createSkHubi();
        skHubi13.setHubisikibetukey("20140114");

        HT_SkHubiDetail skHubiDetail13 = skHubi13.createSkHubiDetail();
        skHubiDetail13.setRenno3keta(1);

        HT_MosDairiten mosDairiten14 = syoriCTL13.createMosDairiten();
        mosDairiten14.setRenno(1);
        mosDairiten14.setTratkiagcd("dt0001");
        mosDairiten14.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL13);

        HT_SyoriCTL syoriCTL14 = new HT_SyoriCTL("791112386");
        syoriCTL14.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL14.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL14.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL14.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL14.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL14.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL14.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL14.setDaimosno("791112220");

        HT_MosKihon mosKihon14 = syoriCTL14.createMosKihon();
        mosKihon14.setMosymd(BizDate.valueOf(20150603));
        mosKihon14.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon14.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon14.setHhknnmkj("被保険者名（漢字）１４");

        HT_SkHubi skHubi14 = syoriCTL14.createSkHubi();
        skHubi14.setHubisikibetukey("20140115");

        HT_SkHubiDetail skHubiDetail14 = skHubi14.createSkHubiDetail();
        skHubiDetail14.setRenno3keta(1);

        HT_MosDairiten mosDairiten15 = syoriCTL14.createMosDairiten();
        mosDairiten15.setRenno(1);
        mosDairiten15.setTratkiagcd("dt0002");
        mosDairiten15.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL14);

        HT_SyoriCTL syoriCTL15 = new HT_SyoriCTL("791112378");
        syoriCTL15.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL15.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL15.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL15.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL15.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL15.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL15.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL15.setDaimosno("791112220");

        HT_MosKihon mosKihon15 = syoriCTL15.createMosKihon();
        mosKihon15.setMosymd(BizDate.valueOf(20150603));
        mosKihon15.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon15.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon15.setHhknnmkj("被保険者名（漢字）１５");

        HT_SkHubi skHubi15 = syoriCTL15.createSkHubi();
        skHubi15.setHubisikibetukey("20140116");

        HT_SkHubiDetail skHubiDetail15 = skHubi15.createSkHubiDetail();
        skHubiDetail15.setRenno3keta(1);

        HT_MosDairiten mosDairiten16 = syoriCTL15.createMosDairiten();
        mosDairiten16.setRenno(1);
        mosDairiten16.setTratkiagcd("dt0001");
        mosDairiten16.setOyadrtencd("kc02");

        sinkeiyakuDomManager.insert(syoriCTL15);

        HT_SyoriCTL syoriCTL16 = new HT_SyoriCTL("791112360");
        syoriCTL16.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL16.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL16.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL16.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL16.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL16.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL16.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL16.setDaimosno("791112220");

        HT_MosKihon mosKihon16 = syoriCTL16.createMosKihon();
        mosKihon16.setMosymd(BizDate.valueOf(20150603));
        mosKihon16.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon16.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT);
        mosKihon16.setHhknnmkj("被保険者名（漢字）１６");

        HT_SkHubi skHubi16 = syoriCTL16.createSkHubi();
        skHubi16.setHubisikibetukey("20140117");

        HT_SkHubiDetail skHubiDetail16 = skHubi16.createSkHubiDetail();
        skHubiDetail16.setRenno3keta(1);

        HT_MosDairiten mosDairiten17 = syoriCTL16.createMosDairiten();
        mosDairiten17.setRenno(1);
        mosDairiten17.setTratkiagcd("dt0001");
        mosDairiten17.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL16);

        HT_SyoriCTL syoriCTL17 = new HT_SyoriCTL("791112352");
        syoriCTL17.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL17.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL17.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL17.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL17.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL17.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL17.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL17.setDaimosno("791112220");

        HT_SkHubi skHubi17 = syoriCTL17.createSkHubi();
        skHubi17.setHubisikibetukey("20140118");

        HT_SkHubiDetail skHubiDetail17 = skHubi17.createSkHubiDetail();
        skHubiDetail17.setRenno3keta(1);

        HT_MosDairiten mosDairiten18 = syoriCTL17.createMosDairiten();
        mosDairiten18.setRenno(1);
        mosDairiten18.setTratkiagcd("dt0001");
        mosDairiten18.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL17);

        HT_SyoriCTL syoriCTL18 = new HT_SyoriCTL("791112345");
        syoriCTL18.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL18.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL18.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL18.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL18.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL18.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL18.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL18.setDaimosno("791112220");

        HT_MosKihon mosKihon17 = syoriCTL18.createMosKihon();
        mosKihon17.setMosymd(BizDate.valueOf(20150603));
        mosKihon17.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon17.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon17.setHhknnmkj("被保険者名（漢字）１７");

        HT_SkHubi skHubi18 = syoriCTL18.createSkHubi();
        skHubi18.setHubisikibetukey("20140119");

        HT_SkHubiDetail skHubiDetail18 = skHubi18.createSkHubiDetail();
        skHubiDetail18.setRenno3keta(1);

        sinkeiyakuDomManager.insert(syoriCTL18);

        HT_SyoriCTL syoriCTL19 = new HT_SyoriCTL("791112337");
        syoriCTL19.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL19.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL19.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL19.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL19.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL19.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL19.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL19.setDaimosno("791112220");

        HT_MosKihon mosKihon18 = syoriCTL19.createMosKihon();
        mosKihon18.setMosymd(BizDate.valueOf(20150603));
        mosKihon18.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon18.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon18.setHhknnmkj("被保険者名（漢字）１８");

        HT_MosDairiten mosDairiten19 = syoriCTL19.createMosDairiten();
        mosDairiten19.setRenno(1);
        mosDairiten19.setTratkiagcd("dt0001");
        mosDairiten19.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL19);

        HT_SyoriCTL syoriCTL20 = new HT_SyoriCTL("791112329");
        syoriCTL20.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL20.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL20.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL20.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL20.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL20.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL20.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL20.setDaimosno("791112220");

        HT_MosKihon mosKihon19 = syoriCTL20.createMosKihon();
        mosKihon19.setMosymd(BizDate.valueOf(20150603));
        mosKihon19.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon19.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon19.setHhknnmkj("被保険者名（漢字）１９");

        HT_SkHubi skHubi19 = syoriCTL20.createSkHubi();
        skHubi19.setHubisikibetukey("20140120");

        HT_MosDairiten mosDairiten20 = syoriCTL20.createMosDairiten();
        mosDairiten20.setRenno(1);
        mosDairiten20.setTratkiagcd("dt0001");
        mosDairiten20.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL20);

        HT_SyoriCTL syoriCTL21 = new HT_SyoriCTL("791112311");
        syoriCTL21.setKktnrkumu(C_UmuKbn.ARI);
        syoriCTL21.setNyknnrkumu(C_UmuKbn.ARI);
        syoriCTL21.setKthhbkbn(C_UmuKbn.ARI);
        syoriCTL21.setSrhhbkbn(C_UmuKbn.ARI);
        syoriCTL21.setKhnhbkbn(C_UmuKbn.ARI);
        syoriCTL21.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
        syoriCTL21.setSeiritukbn(C_SeirituKbn.SEIRITU);
        syoriCTL21.setDaimosno("791112220");

        HT_MosKihon mosKihon20 = syoriCTL21.createMosKihon();
        mosKihon20.setMosymd(BizDate.valueOf(20150603));
        mosKihon20.setBosyuuym(BizDateYM.valueOf(201505));
        mosKihon20.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        mosKihon20.setHhknnmkj("被保険者名（漢字）２０");

        HT_SkHubi skHubi20 = syoriCTL21.createSkHubi();
        skHubi20.setHubisikibetukey("20140121");

        HT_SkHubiDetail skHubiDetail19 = skHubi20.createSkHubiDetail();
        skHubiDetail19.setRenno3keta(1);
        skHubiDetail19.setKaisyouymd(BizDate.valueOf(20150603));

        HT_MosDairiten mosDairiten21 = syoriCTL21.createMosDairiten();
        mosDairiten21.setRenno(1);
        mosDairiten21.setTratkiagcd("dt0001");
        mosDairiten21.setOyadrtencd("kc01");

        sinkeiyakuDomManager.insert(syoriCTL21);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }
//
//    @Test
//    @TestOrder(10)
//    public void noResult1() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112238" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(0, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//    }
//
//    @Test
//    @TestOrder(20)
//    public void normal1() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112246" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(1, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112469", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０６", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(30)
//    public void normal2() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(3, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(40)
//    public void normal3() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", false, true);
//
//        Assert.assertEquals(5, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112394", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112402", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(50)
//    public void normal4() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, false);
//
//        Assert.assertEquals(6, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112311", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）２０", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112329", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１９", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112337", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１８", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(60)
//    public void normal5() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", false, false);
//
//        Assert.assertEquals(8, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112311", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）２０", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112329", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１９", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112337", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１８", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112394", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//
//        Assert.assertEquals("791112402", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getHknsyuruino());
//    }
//
//
//    @Test
//    @TestOrder(70)
//    public void blankCondition1() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112469", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０６", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(80)
//    public void blankCondition2() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112386", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１４", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(90)
//    public void blankCondition3() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112378", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１５", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(100)
//    public void blankCondition4() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "", "", true, true);
//
//        Assert.assertEquals(7, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112345", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１７", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112378", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１５", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112386", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１４", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112469", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０６", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(110)
//    public void blankCondition5() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.BLNK, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112436", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０９", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_SUMI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(120)
//    public void blankCondition6() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.BLNK, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112428", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１０", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.ITIPMATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(130)
//    public void blankCondition7() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.NONE, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112410", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(140)
//    public void nullCondition1() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            null, BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112477", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０５", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(150)
//    public void nullCondition2() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), null, "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112485", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０４", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(160)
//    public void nullCondition3() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), null ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112469", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０６", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(170)
//    public void nullCondition4() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,null, C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112451", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０７", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//
//    @Test
//    @TestOrder(180)
//    public void nullCondition5() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), null, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112444", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０８", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(190)
//    public void nullCondition6() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, null, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112436", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０９", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_SUMI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(200)
//    public void nullCondition7() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, null, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112428", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１０", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.ITIPMATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(210)
//    public void nullCondition8() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, null, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112410", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(220)
//    public void nullCondition9() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, null,
//            "dt0001", "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112360", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１６", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(230)
//    public void nullCondition10() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            null, "kc01", true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112386", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１４", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(240)
//    public void nullCondition11() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            BizDate.valueOf(20150603), BizDate.valueOf(20150605), "791112220" ,BizDateYM.valueOf(201505), C_UmuKbn.ARI, C_KetteiKbn.KETTEI_MATI, C_SeirituKbn.SEIRITU, C_UmuKbn.ARI, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,
//            "dt0001", null, true, true);
//
//        Assert.assertEquals(4, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112378", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１５", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//    }
//
//
//    @Test
//    @TestOrder(250)
//    public void nullCondition12() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            null, null, "" ,null, null, C_KetteiKbn.BLNK, C_SeirituKbn.BLNK, C_UmuKbn.NONE, null, "", "", true, true);
//
//
//        Assert.assertEquals(15, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112345", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１７", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112360", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１６", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112378", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１５", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112386", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１４", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//
//        Assert.assertEquals("791112410", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHknsyuruino());
//
//        Assert.assertEquals("791112428", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１０", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.ITIPMATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHknsyuruino());
//
//        Assert.assertEquals("791112436", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０９", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_SUMI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getHknsyuruino());
//
//        Assert.assertEquals("791112444", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０８", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getHknsyuruino());
//
//        Assert.assertEquals("791112451", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０７", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getHknsyuruino());
//
//        Assert.assertEquals("791112469", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０６", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getHknsyuruino());
//
//        Assert.assertEquals("791112477", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０５", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getHknsyuruino());
//
//        Assert.assertEquals("791112485", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０４", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getHknsyuruino());
//    }
//
//    @Test
//    @TestOrder(260)
//    public void nullCondition13() {
//
//        List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst = sinkeiyakuDomManager.getSyoukaiIchiranInfosByMosymdBosyuuymItems(
//            null, null, null ,null, null, null, null, null, null, null, null, true, true);
//
//        Assert.assertEquals(15, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.size());
//
//        Assert.assertEquals("791112345", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１７", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(0).getHknsyuruino());
//
//        Assert.assertEquals("791112360", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１６", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(1).getHknsyuruino());
//
//        Assert.assertEquals("791112378", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１５", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(2).getHknsyuruino());
//
//        Assert.assertEquals("791112386", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１４", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(3).getHknsyuruino());
//
//        Assert.assertEquals("791112410", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(4).getHknsyuruino());
//
//        Assert.assertEquals("791112428", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getMosno());
//        Assert.assertEquals("被保険者名（漢字）１０", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.ITIPMATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(5).getHknsyuruino());
//
//        Assert.assertEquals("791112436", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０９", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_SUMI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(6).getHknsyuruino());
//
//        Assert.assertEquals("791112444", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０８", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(7).getHknsyuruino());
//
//        Assert.assertEquals("791112451", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０７", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(8).getHknsyuruino());
//
//        Assert.assertEquals("791112469", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０６", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(9).getHknsyuruino());
//
//        Assert.assertEquals("791112477", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０５", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(10).getHknsyuruino());
//
//        Assert.assertEquals("791112485", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０４", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(11).getHknsyuruino());
//
//        Assert.assertEquals("791112493", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０３", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(12).getHknsyuruino());
//
//        Assert.assertEquals("791112501", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０２", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getKthhbkbn());
//        Assert.assertEquals(null, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.NONE, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(13).getHknsyuruino());
//
//        Assert.assertEquals("791112519", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getMosno());
//        Assert.assertEquals("被保険者名（漢字）０１", syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getHhknnmkj());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getKktnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getNyknnrkumu());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getKthhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getSrhhbkbn());
//        Assert.assertEquals(C_UmuKbn.ARI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getKhnhbkbn());
//        Assert.assertEquals(C_KetteiKbn.KETTEI_MATI, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getKetteikbn());
//        Assert.assertEquals(C_SeirituKbn.SEIRITU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getSeiritukbn());
//        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syoukaiIchiranInfosByMosymdBosyuuymItemsBeanLst.get(14).getHknsyuruino());
//    }
}
