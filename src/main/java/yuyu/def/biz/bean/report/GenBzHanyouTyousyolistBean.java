package yuyu.def.biz.bean.report;

import java.io.Serializable;
import yuyu.def.classification.C_SyoruiCdKbn;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）汎用支払調書帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHanyouTyousyolistBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHanyouTyousyolistBean() {
    }

    private String irSyoriymd;

    public String getIrSyoriymd() {
        return irSyoriymd;
    }

    public void setIrSyoriymd(String pIrSyoriymd) {
        irSyoriymd = pIrSyoriymd;
    }

    private String irTyouhyoutitle;

    public String getIrTyouhyoutitle() {
        return irTyouhyoutitle;
    }

    public void setIrTyouhyoutitle(String pIrTyouhyoutitle) {
        irTyouhyoutitle = pIrTyouhyoutitle;
    }

    private String irSakuseiym;

    public String getIrSakuseiym() {
        return irSakuseiym;
    }

    public void setIrSakuseiym(String pIrSakuseiym) {
        irSakuseiym = pIrSakuseiym;
    }

    private Integer irKensuu;

    public Integer getIrKensuu() {
        return irKensuu;
    }

    public void setIrKensuu(Integer pIrKensuu) {
        irKensuu = pIrKensuu;
    }

    private String irHozonkkn;

    public String getIrHozonkkn() {
        return irHozonkkn;
    }

    public void setIrHozonkkn(String pIrHozonkkn) {
        irHozonkkn = pIrHozonkkn;
    }

    private C_SyoruiCdKbn irSyoruicd;

    public C_SyoruiCdKbn getIrSyoruicd() {
        return irSyoruicd;
    }

    public void setIrSyoruicd(C_SyoruiCdKbn pIrSyoruicd) {
        irSyoruicd = pIrSyoruicd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
