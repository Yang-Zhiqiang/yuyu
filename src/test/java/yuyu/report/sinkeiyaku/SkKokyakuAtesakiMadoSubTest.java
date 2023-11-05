package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkHenkinTuutiBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約顧客宛先（窓封）帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkKokyakuAtesakiMadoSubTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzKokyakuAtesakiBean bzKokyakuAtesakiBean;

    @Inject
    private SkHenkinTuutiBean skHenkinTuutiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_kokyakuatesaki_mado_sub", C_SyoruiCdKbn.SK_HENKINTUUTILIST);

        skHenkinTuutiBean.setIrHnkngk("9999999999.99 ＷＷＷ");
        skHenkinTuutiBean.setIrHnknymd("9999年99月99日");
        skHenkinTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MOS_TORIKESI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("9999年99月99日");
        bzKokyakuAtesakiBean.setIrShsyno("9999999");
        bzKokyakuAtesakiBean.setIrShadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShadr3kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrShsnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseyno("999-9999");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrHknkisynm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("ＷＷＷＷＷＷ");
        bzKokyakuAtesakiBean.setIrToiawasetelno("XXXXXXXXXXXXXX");

        reportTestBean.addParamObjects(skHenkinTuutiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_kokyakuatesaki_mado_sub", C_SyoruiCdKbn.SK_HENKINTUUTILIST);

        skHenkinTuutiBean.setIrHnkngk("9999999999.99 ＷＷＷ");
        skHenkinTuutiBean.setIrHnknymd("9999年99月99日");
        skHenkinTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MOS_TORIKESI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("2018年 8月10日");
        bzKokyakuAtesakiBean.setIrShsyno("1950000");
        bzKokyakuAtesakiBean.setIrShadr1kj("大阪市中央区");
        bzKokyakuAtesakiBean.setIrShadr2kj("新栄町１－４－３４");
        bzKokyakuAtesakiBean.setIrShadr3kj("ABCマンション");
        bzKokyakuAtesakiBean.setIrShsnmkj("新契約　太郎");
        bzKokyakuAtesakiBean.setIrToiawaseyno("540-8512");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("大阪市中央区城見");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("１－４－３５");
        bzKokyakuAtesakiBean.setIrHknkisynm("住友生命保険相互会社");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("代理店契約室");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("吉田由紀子");
        bzKokyakuAtesakiBean.setIrToiawasetelno("1206-6937-1136");

        reportTestBean.addParamObjects(skHenkinTuutiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_kokyakuatesaki_mado_sub", C_SyoruiCdKbn.SK_HENKINTUUTILIST);

        skHenkinTuutiBean.setIrHnkngk("9999999999.99 ＷＷＷ");
        skHenkinTuutiBean.setIrHnknymd("9999年99月99日");
        skHenkinTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MOS_TORIKESI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd("");
        bzKokyakuAtesakiBean.setIrShsyno("");
        bzKokyakuAtesakiBean.setIrShadr1kj("");
        bzKokyakuAtesakiBean.setIrShadr2kj("");
        bzKokyakuAtesakiBean.setIrShadr3kj("");
        bzKokyakuAtesakiBean.setIrShsnmkj("");
        bzKokyakuAtesakiBean.setIrToiawaseyno("");
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj("");
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj("");
        bzKokyakuAtesakiBean.setIrHknkisynm("");
        bzKokyakuAtesakiBean.setIrToiawasesosiki("");
        bzKokyakuAtesakiBean.setIrToiawasetantounm("");
        bzKokyakuAtesakiBean.setIrToiawasetelno("");

        reportTestBean.addParamObjects(skHenkinTuutiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "sk_kokyakuatesaki_mado_sub", C_SyoruiCdKbn.SK_HENKINTUUTILIST);

        skHenkinTuutiBean.setIrHnkngk("9999999999.99 ＷＷＷ");
        skHenkinTuutiBean.setIrHnknymd("9999年99月99日");
        skHenkinTuutiBean.setIrKetkekkacd(C_Ketkekkacd.MOS_TORIKESI);

        bzKokyakuAtesakiBean.setIrTyouhyousakuseiymd(null);
        bzKokyakuAtesakiBean.setIrShsyno(null);
        bzKokyakuAtesakiBean.setIrShadr1kj(null);
        bzKokyakuAtesakiBean.setIrShadr2kj(null);
        bzKokyakuAtesakiBean.setIrShadr3kj(null);
        bzKokyakuAtesakiBean.setIrShsnmkj(null);
        bzKokyakuAtesakiBean.setIrToiawaseyno(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr1kj(null);
        bzKokyakuAtesakiBean.setIrToiawaseadr2kj(null);
        bzKokyakuAtesakiBean.setIrHknkisynm(null);
        bzKokyakuAtesakiBean.setIrToiawasesosiki(null);
        bzKokyakuAtesakiBean.setIrToiawasetantounm(null);
        bzKokyakuAtesakiBean.setIrToiawasetelno(null);

        reportTestBean.addParamObjects(skHenkinTuutiBean, bzKokyakuAtesakiBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
