package yuyu.def.sinkeiyaku.bean.report;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * （新契約）手続完了通知帳票BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkTtdkkanryouTuutiBean implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkTtdkkanryouTuutiBean() {
    }


    private String irTyouhyoutitle;


    public String getIrTyouhyoutitle() {
        return irTyouhyoutitle;
    }


    public void setIrTyouhyoutitle(String pIrTyouhyoutitle) {
        irTyouhyoutitle = pIrTyouhyoutitle;
    }


    private String irKyknmkj;


    public String getIrKyknmkj() {
        return irKyknmkj;
    }


    public void setIrKyknmkj(String pIrKyknmkj) {
        irKyknmkj = pIrKyknmkj;
    }


    private String irMosno;


    public String getIrMosno() {
        return irMosno;
    }


    public void setIrMosno(String pIrMosno) {
        irMosno = pIrMosno;
    }


    private String irFstphrkgk;


    public String getIrFstphrkgk() {
        return irFstphrkgk;
    }


    public void setIrFstphrkgk(String pIrFstphrkgk) {
        irFstphrkgk = pIrFstphrkgk;
    }


    private String irHnknyoteiymd;


    public String getIrHnknyoteiymd() {
        return irHnknyoteiymd;
    }


    public void setIrHnknyoteiymd(String pIrHnknyoteiymd) {
        irHnknyoteiymd = pIrHnknyoteiymd;
    }


    private String irHknsyurui;


    public String getIrHknsyurui() {
        return irHknsyurui;
    }


    public void setIrHknsyurui(String pIrHknsyurui) {
        irHknsyurui = pIrHknsyurui;
    }


    private String irAisyoumei;


    public String getIrAisyoumei() {
        return irAisyoumei;
    }


    public void setIrAisyoumei(String pIrAisyoumei) {
        irAisyoumei = pIrAisyoumei;
    }


    private String irTratkisitennm;


    public String getIrTratkisitennm() {
        return irTratkisitennm;
    }


    public void setIrTratkisitennm(String pIrTratkisitennm) {
        irTratkisitennm = pIrTratkisitennm;
    }


    private String irTratkitantounmkj;


    public String getIrTratkitantounmkj() {
        return irTratkitantounmkj;
    }


    public void setIrTratkitantounmkj(String pIrTratkitantounmkj) {
        irTratkitantounmkj = pIrTratkitantounmkj;
    }


    private String irUktkid;


    public String getIrUktkid() {
        return irUktkid;
    }


    public void setIrUktkid(String pIrUktkid) {
        irUktkid = pIrUktkid;
    }


    private C_SkeijimuKbn irSkeijimukbn;


    public C_SkeijimuKbn getIrSkeijimukbn() {
        return irSkeijimukbn;
    }


    public void setIrSkeijimukbn(C_SkeijimuKbn pIrSkeijimukbn) {
        irSkeijimukbn = pIrSkeijimukbn;
    }


    private C_SeirituKbn irSeiritukbn;


    public C_SeirituKbn getIrSeiritukbn() {
        return irSeiritukbn;
    }


    public void setIrSeiritukbn(C_SeirituKbn pIrSeiritukbn) {
        irSeiritukbn = pIrSeiritukbn;
    }


    private C_Ketkekkacd irKetkekkacd;


    public C_Ketkekkacd getIrKetkekkacd() {
        return irKetkekkacd;
    }


    public void setIrKetkekkacd(C_Ketkekkacd pIrKetkekkacd) {
        irKetkekkacd = pIrKetkekkacd;
    }


    private C_UmuKbn irHenkinumu;


    public C_UmuKbn getIrHenkinumu() {
        return irHenkinumu;
    }


    public void setIrHenkinumu(C_UmuKbn pIrHenkinumu) {
        irHenkinumu = pIrHenkinumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
