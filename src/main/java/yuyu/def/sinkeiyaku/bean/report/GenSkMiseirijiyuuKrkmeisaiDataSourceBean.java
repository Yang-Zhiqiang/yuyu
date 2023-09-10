package yuyu.def.sinkeiyaku.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）未整理事由別仮受金明細リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkMiseirijiyuuKrkmeisaiDataSourceBean implements IReportDataSouceBean {


    private static final long serialVersionUID = 1L;


    public GenSkMiseirijiyuuKrkmeisaiDataSourceBean() {
    }


    private String irMiseirijiyuukbn;


    public String getIrMiseirijiyuukbn() {
        return irMiseirijiyuukbn;
    }


    public void setIrMiseirijiyuukbn(String pIrMiseirijiyuukbn) {
        irMiseirijiyuukbn = pIrMiseirijiyuukbn;
    }


    private String irNyukintuuka;


    public String getIrNyukintuuka() {
        return irNyukintuuka;
    }


    public void setIrNyukintuuka(String pIrNyukintuuka) {
        irNyukintuuka = pIrNyukintuuka;
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private String irKyknmkn;


    public String getIrKyknmkn() {
        return irKyknmkn;
    }


    public void setIrKyknmkn(String pIrKyknmkn) {
        irKyknmkn = pIrKyknmkn;
    }


    private BizCurrency irKrkhuho2syoukai;


    public BizCurrency getIrKrkhuho2syoukai() {
        return irKrkhuho2syoukai;
    }


    public void setIrKrkhuho2syoukai(BizCurrency pIrKrkhuho2syoukai) {
        irKrkhuho2syoukai = pIrKrkhuho2syoukai;
    }


    private BizCurrency irKrkhuho2kobetu;


    public BizCurrency getIrKrkhuho2kobetu() {
        return irKrkhuho2kobetu;
    }


    public void setIrKrkhuho2kobetu(BizCurrency pIrKrkhuho2kobetu) {
        irKrkhuho2kobetu = pIrKrkhuho2kobetu;
    }


    private BizCurrency irKrkhuho2kobetusyoukei;


    public BizCurrency getIrKrkhuho2kobetusyoukei() {
        return irKrkhuho2kobetusyoukei;
    }


    public void setIrKrkhuho2kobetusyoukei(BizCurrency pIrKrkhuho2kobetusyoukei) {
        irKrkhuho2kobetusyoukei = pIrKrkhuho2kobetusyoukei;
    }


    private BizCurrency irKrkhuho2syoukaisyoukei;


    public BizCurrency getIrKrkhuho2syoukaisyoukei() {
        return irKrkhuho2syoukaisyoukei;
    }


    public void setIrKrkhuho2syoukaisyoukei(BizCurrency pIrKrkhuho2syoukaisyoukei) {
        irKrkhuho2syoukaisyoukei = pIrKrkhuho2syoukaisyoukei;
    }


    private BizCurrency irKrkhuho2kobetugoukei;


    public BizCurrency getIrKrkhuho2kobetugoukei() {
        return irKrkhuho2kobetugoukei;
    }


    public void setIrKrkhuho2kobetugoukei(BizCurrency pIrKrkhuho2kobetugoukei) {
        irKrkhuho2kobetugoukei = pIrKrkhuho2kobetugoukei;
    }


    private BizCurrency irKrkhuho2syoukaigoukei;


    public BizCurrency getIrKrkhuho2syoukaigoukei() {
        return irKrkhuho2syoukaigoukei;
    }


    public void setIrKrkhuho2syoukaigoukei(BizCurrency pIrKrkhuho2syoukaigoukei) {
        irKrkhuho2syoukaigoukei = pIrKrkhuho2syoukaigoukei;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
