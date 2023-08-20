package yuyu.def.suuri.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （数理）新契約追込保険料伝票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSrSkOikomiPDenpyouDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSrSkOikomiPDenpyouDataSourceBean() {
    }


    private String irHuridenatesakinm;


    public String getIrHuridenatesakinm() {
        return irHuridenatesakinm;
    }


    public void setIrHuridenatesakinm(String pIrHuridenatesakinm) {
        irHuridenatesakinm = pIrHuridenatesakinm;
    }


    private String irKanjyoukmkcdkasi;


    public String getIrKanjyoukmkcdkasi() {
        return irKanjyoukmkcdkasi;
    }


    public void setIrKanjyoukmkcdkasi(String pIrKanjyoukmkcdkasi) {
        irKanjyoukmkcdkasi = pIrKanjyoukmkcdkasi;
    }


    private String irKasikanjyoukmknm;


    public String getIrKasikanjyoukmknm() {
        return irKasikanjyoukmknm;
    }


    public void setIrKasikanjyoukmknm(String pIrKasikanjyoukmknm) {
        irKasikanjyoukmknm = pIrKasikanjyoukmknm;
    }


    private String irTekiyoucdkasi;


    public String getIrTekiyoucdkasi() {
        return irTekiyoucdkasi;
    }


    public void setIrTekiyoucdkasi(String pIrTekiyoucdkasi) {
        irTekiyoucdkasi = pIrTekiyoucdkasi;
    }


    private String irTekiyoukasi;


    public String getIrTekiyoukasi() {
        return irTekiyoukasi;
    }


    public void setIrTekiyoukasi(String pIrTekiyoukasi) {
        irTekiyoukasi = pIrTekiyoukasi;
    }


    private BizCurrency irKasikatagk;


    public BizCurrency getIrKasikatagk() {
        return irKasikatagk;
    }


    public void setIrKasikatagk(BizCurrency pIrKasikatagk) {
        irKasikatagk = pIrKasikatagk;
    }


    private BizNumber irGoukeikensuukasikata;


    public BizNumber getIrGoukeikensuukasikata() {
        return irGoukeikensuukasikata;
    }


    public void setIrGoukeikensuukasikata(BizNumber pIrGoukeikensuukasikata) {
        irGoukeikensuukasikata = pIrGoukeikensuukasikata;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
