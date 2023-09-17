package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （共通）事業費勘定確証リスト帳票DSBEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzJigyouhiKnjyKakusyouListDataSourceBean implements IReportDataSouceBean {

    private static final long serialVersionUID = 1L;

    public GenBzJigyouhiKnjyKakusyouListDataSourceBean() {
    }

    private String irAtesakikacd;

    public String getIrAtesakikacd() {
        return irAtesakikacd;
    }

    public void setIrAtesakikacd(String pIrAtesakikacd) {
        irAtesakikacd = pIrAtesakikacd;
    }

    private String irAtesakibukanm;

    public String getIrAtesakibukanm() {
        return irAtesakibukanm;
    }

    public void setIrAtesakibukanm(String pIrAtesakibukanm) {
        irAtesakibukanm = pIrAtesakibukanm;
    }

    private BizDate irTorihikiymd;

    public BizDate getIrTorihikiymd() {
        return irTorihikiymd;
    }

    public void setIrTorihikiymd(BizDate pIrTorihikiymd) {
        irTorihikiymd = pIrTorihikiymd;
    }

    private String irTorihikino;

    public String getIrTorihikino() {
        return irTorihikino;
    }

    public void setIrTorihikino(String pIrTorihikino) {
        irTorihikino = pIrTorihikino;
    }

    private C_TaisyakuKbn irTaisyakukbn;

    public C_TaisyakuKbn getIrTaisyakukbn() {
        return irTaisyakukbn;
    }

    public void setIrTaisyakukbn(C_TaisyakuKbn pIrTaisyakukbn) {
        irTaisyakukbn = pIrTaisyakukbn;
    }

    private String irKanjihimokunm;

    public String getIrKanjihimokunm() {
        return irKanjihimokunm;
    }

    public void setIrKanjihimokunm(String pIrKanjihimokunm) {
        irKanjihimokunm = pIrKanjihimokunm;
    }

    private String irJigyouhiutiwakecd;

    public String getIrJigyouhiutiwakecd() {
        return irJigyouhiutiwakecd;
    }

    public void setIrJigyouhiutiwakecd(String pIrJigyouhiutiwakecd) {
        irJigyouhiutiwakecd = pIrJigyouhiutiwakecd;
    }

    private BizCurrency irJigyouhikingaku;

    public BizCurrency getIrJigyouhikingaku() {
        return irJigyouhikingaku;
    }

    public void setIrJigyouhikingaku(BizCurrency pIrJigyouhikingaku) {
        irJigyouhikingaku = pIrJigyouhikingaku;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
