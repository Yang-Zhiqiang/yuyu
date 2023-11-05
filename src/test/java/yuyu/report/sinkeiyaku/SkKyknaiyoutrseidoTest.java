package yuyu.report.sinkeiyaku;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_LincSyoukaiSyubetuKbn;
import yuyu.def.classification.C_LinchhknseiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkKyknaiyoutrseidoBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約内容登録制度照会票  帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SkKyknaiyoutrseidoTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkKyknaiyoutrseidoBean skKyknaiyoutrseidoBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest",
                C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO);

        skKyknaiyoutrseidoBean.setIrTyouhyousakuseiymd(null);
        skKyknaiyoutrseidoBean.setIrSyoukaisaki1(null);
        skKyknaiyoutrseidoBean.setIrSyoukaisaki2(null);
        skKyknaiyoutrseidoBean.setIrSyoukaisaki3(null);
        skKyknaiyoutrseidoBean.setIrHasinmotokaisya(null);
        skKyknaiyoutrseidoBean.setIrHasinmotobumon(null);
        skKyknaiyoutrseidoBean.setIrHasinmotofax(null);
        skKyknaiyoutrseidoBean.setIrLincsyurui(null);
        skKyknaiyoutrseidoBean.setIrSyoukaisakikykkanrino(null);
        skKyknaiyoutrseidoBean.setIrHhknnmknlinc(null);
        skKyknaiyoutrseidoBean.setIrSeiymdlinc(null);
        skKyknaiyoutrseidoBean.setIrSeibetulinc(null);
        skKyknaiyoutrseidoBean.setIrAdrkn(null);
        skKyknaiyoutrseidoBean.setIrSyoukaisakykymd(null);
        skKyknaiyoutrseidoBean.setIrHhknnmkj(null);
        skKyknaiyoutrseidoBean.setIrAdrkj(null);
        skKyknaiyoutrseidoBean.setIrKyknmhurigana(null);
        skKyknaiyoutrseidoBean.setIrKyknmkj(null);
        skKyknaiyoutrseidoBean.setIrKykymdhyoujiumu(null);

        reportTestBean.addParamObjects(skKyknaiyoutrseidoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest",
                C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO);

        skKyknaiyoutrseidoBean.setIrTyouhyousakuseiymd("");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki1("");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki2("");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki3("");
        skKyknaiyoutrseidoBean.setIrHasinmotokaisya("");
        skKyknaiyoutrseidoBean.setIrHasinmotobumon("");
        skKyknaiyoutrseidoBean.setIrHasinmotofax("");
        skKyknaiyoutrseidoBean.setIrLincsyurui(null);
        skKyknaiyoutrseidoBean.setIrSyoukaisakikykkanrino("");
        skKyknaiyoutrseidoBean.setIrHhknnmknlinc("");
        skKyknaiyoutrseidoBean.setIrSeiymdlinc("");
        skKyknaiyoutrseidoBean.setIrSeibetulinc(null);
        skKyknaiyoutrseidoBean.setIrAdrkn("");
        skKyknaiyoutrseidoBean.setIrSyoukaisakykymd("");
        skKyknaiyoutrseidoBean.setIrHhknnmkj("");
        skKyknaiyoutrseidoBean.setIrAdrkj("");
        skKyknaiyoutrseidoBean.setIrKyknmhurigana("");
        skKyknaiyoutrseidoBean.setIrKyknmkj("");
        skKyknaiyoutrseidoBean.setIrKykymdhyoujiumu("");

        reportTestBean.addParamObjects(skKyknaiyoutrseidoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest",
                C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO);

        skKyknaiyoutrseidoBean.setIrTyouhyousakuseiymd("2018年 3月24日");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki1("新契約照会先会社名１　新契約照会先会社名２（送信元会社）");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki2("新契約部門");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki3("ＬＩＮＣ事務ご担当者殿");
        skKyknaiyoutrseidoBean.setIrHasinmotokaisya("住友生命（２０）");
        skKyknaiyoutrseidoBean.setIrHasinmotobumon("契約審査室");
        skKyknaiyoutrseidoBean.setIrHasinmotofax("06-6397-1110");
        skKyknaiyoutrseidoBean.setIrLincsyurui(C_LincSyoukaiSyubetuKbn.HOKENKIN);
        skKyknaiyoutrseidoBean.setIrSyoukaisakikykkanrino("1234567890123456789012345678901234567890");
        skKyknaiyoutrseidoBean.setIrHhknnmknlinc("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐ");
        skKyknaiyoutrseidoBean.setIrSeiymdlinc("H23.12.13");
        skKyknaiyoutrseidoBean.setIrSeibetulinc(C_LinchhknseiKbn.SYUSSEIMAE);
        skKyknaiyoutrseidoBean.setIrAdrkn("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎ");
        skKyknaiyoutrseidoBean.setIrSyoukaisakykymd("（貴社契約日　    年  月  日）");
        skKyknaiyoutrseidoBean.setIrHhknnmkj("吉田由紀子吉田由紀子吉田由紀子");
        skKyknaiyoutrseidoBean.setIrAdrkj("被保険者契約通信先の住所漢字１被保険者契約通信先の住所漢字２被保険者契約通信先の住所漢字３被保険者契約通信先の住所漢字４９８");
        skKyknaiyoutrseidoBean.setIrKyknmhurigana("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂ");
        skKyknaiyoutrseidoBean.setIrKyknmkj("新契約太郎新契約太郎新契約太郎");
        skKyknaiyoutrseidoBean.setIrKykymdhyoujiumu("1");

        reportTestBean.addParamObjects(skKyknaiyoutrseidoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest",
                C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO);

        skKyknaiyoutrseidoBean.setIrTyouhyousakuseiymd("9999年12月31日");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki2("ＷＷＷＷＷ");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki3("ＷＷＷＷＷＷＷＷＷＷＷ");
        skKyknaiyoutrseidoBean.setIrHasinmotokaisya("ＷＷＷＷＷＷＷＷ");
        skKyknaiyoutrseidoBean.setIrHasinmotobumon("ＷＷＷＷＷ");
        skKyknaiyoutrseidoBean.setIrHasinmotofax("XXXXXXXXXXXX");
        skKyknaiyoutrseidoBean.setIrLincsyurui(C_LincSyoukaiSyubetuKbn.HOKENKIN);
        skKyknaiyoutrseidoBean.setIrSyoukaisakikykkanrino("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        skKyknaiyoutrseidoBean.setIrHhknnmknlinc("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        skKyknaiyoutrseidoBean.setIrSeiymdlinc("R99.12.31");
        skKyknaiyoutrseidoBean.setIrSeibetulinc(C_LinchhknseiKbn.SYUSSEIMAE);
        skKyknaiyoutrseidoBean.setIrAdrkn("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        skKyknaiyoutrseidoBean.setIrSyoukaisakykymd("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKyknaiyoutrseidoBean.setIrHhknnmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKyknaiyoutrseidoBean.setIrAdrkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKyknaiyoutrseidoBean.setIrKyknmhurigana("XXXXXXXXXXXXXXXXXX");
        skKyknaiyoutrseidoBean.setIrKyknmkj("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skKyknaiyoutrseidoBean.setIrKykymdhyoujiumu("1");

        reportTestBean.addParamObjects(skKyknaiyoutrseidoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkHuriKominYuukinteiseiListTest",
                C_SyoruiCdKbn.SK_KEIYAKUNAIYOTOROKUSEIDOSYOKAIHYO);

        skKyknaiyoutrseidoBean.setIrTyouhyousakuseiymd("2018年 3月24日");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki1("照会先会社（送信元会社）");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki2("新契約部門");
        skKyknaiyoutrseidoBean.setIrSyoukaisaki3("ＬＩＮＣ事務ご担当者殿");
        skKyknaiyoutrseidoBean.setIrHasinmotokaisya("住友生命（２０）");
        skKyknaiyoutrseidoBean.setIrHasinmotobumon("契約審査室");
        skKyknaiyoutrseidoBean.setIrHasinmotofax("06-6397-1110");
        skKyknaiyoutrseidoBean.setIrLincsyurui(C_LincSyoukaiSyubetuKbn.TOKUYAKU);
        skKyknaiyoutrseidoBean.setIrSyoukaisakikykkanrino("12345678901234567890");
        skKyknaiyoutrseidoBean.setIrHhknnmknlinc("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀ");
        skKyknaiyoutrseidoBean.setIrSeiymdlinc("H23.12.13");
        skKyknaiyoutrseidoBean.setIrSeibetulinc(C_LinchhknseiKbn.FEMALE);
        skKyknaiyoutrseidoBean.setIrAdrkn("ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿ");
        skKyknaiyoutrseidoBean.setIrSyoukaisakykymd("（貴社契約日　    年  月  日）");
        skKyknaiyoutrseidoBean.setIrHhknnmkj("吉田由紀子");
        skKyknaiyoutrseidoBean.setIrAdrkj("大阪市中央区城見");
        skKyknaiyoutrseidoBean.setIrKyknmhurigana("ｱｲｳｴｵｶｷｸｹ");
        skKyknaiyoutrseidoBean.setIrKyknmkj("（被）と同一");
        skKyknaiyoutrseidoBean.setIrKykymdhyoujiumu("0");

        reportTestBean.addParamObjects(skKyknaiyoutrseidoBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


}
