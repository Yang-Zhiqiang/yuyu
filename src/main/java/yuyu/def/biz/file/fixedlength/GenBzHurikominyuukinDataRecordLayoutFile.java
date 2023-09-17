package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）振込入金ファイル（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHurikominyuukinDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHurikominyuukinDataRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffDatakbn;

    public String getIffDatakbn() {
        return iffDatakbn;
    }

    public void setIffDatakbn(String pIffDatakbn) {
        iffDatakbn = pIffDatakbn;
    }

    @Column(order = 2, length = 8)
    private String iffSyoukaino;

    public String getIffSyoukaino() {
        return iffSyoukaino;
    }

    public void setIffSyoukaino(String pIffSyoukaino) {
        iffSyoukaino = pIffSyoukaino;
    }

    @Column(order = 3, length = 6)
    private String iffKnjyymdwareki;

    public String getIffKnjyymdwareki() {
        return iffKnjyymdwareki;
    }

    public void setIffKnjyymdwareki(String pIffKnjyymdwareki) {
        iffKnjyymdwareki = pIffKnjyymdwareki;
    }

    @Column(order = 4, length = 6)
    private String iffAzkrhrdsymdwareki;

    public String getIffAzkrhrdsymdwareki() {
        return iffAzkrhrdsymdwareki;
    }

    public void setIffAzkrhrdsymdwareki(String pIffAzkrhrdsymdwareki) {
        iffAzkrhrdsymdwareki = pIffAzkrhrdsymdwareki;
    }

    @Column(order = 5, length = 1)
    private Integer iffIribaraikbn;

    public Integer getIffIribaraikbn() {
        return iffIribaraikbn;
    }

    public void setIffIribaraikbn(Integer pIffIribaraikbn) {
        iffIribaraikbn = pIffIribaraikbn;
    }

    @Column(order = 6, length = 2)
    private Integer iffTrhkkbn;

    public Integer getIffTrhkkbn() {
        return iffTrhkkbn;
    }

    public void setIffTrhkkbn(Integer pIffTrhkkbn) {
        iffTrhkkbn = pIffTrhkkbn;
    }

    @Column(order = 7, length = 12)
    private String iffTrhkkgk;

    public String getIffTrhkkgk() {
        return iffTrhkkgk;
    }

    public void setIffTrhkkgk(String pIffTrhkkgk) {
        iffTrhkkgk = pIffTrhkkgk;
    }

    @Column(order = 8, length = 12)
    private String iffTatenkengk;

    public String getIffTatenkengk() {
        return iffTatenkengk;
    }

    public void setIffTatenkengk(String pIffTatenkengk) {
        iffTatenkengk = pIffTatenkengk;
    }

    @Column(order = 9, length = 6)
    private String iffKknteijiymdwareki;

    public String getIffKknteijiymdwareki() {
        return iffKknteijiymdwareki;
    }

    public void setIffKknteijiymdwareki(String pIffKknteijiymdwareki) {
        iffKknteijiymdwareki = pIffKknteijiymdwareki;
    }

    @Column(order = 10, length = 6)
    private String iffHwtrhnknymdwareki;

    public String getIffHwtrhnknymdwareki() {
        return iffHwtrhnknymdwareki;
    }

    public void setIffHwtrhnknymdwareki(String pIffHwtrhnknymdwareki) {
        iffHwtrhnknymdwareki = pIffHwtrhnknymdwareki;
    }

    @Column(order = 11, length = 1)
    private String iffTgtkgtkbn;

    public String getIffTgtkgtkbn() {
        return iffTgtkgtkbn;
    }

    public void setIffTgtkgtkbn(String pIffTgtkgtkbn) {
        iffTgtkgtkbn = pIffTgtkgtkbn;
    }

    @Column(order = 12, length = 7)
    private String iffTgtkgtno;

    public String getIffTgtkgtno() {
        return iffTgtkgtno;
    }

    public void setIffTgtkgtno(String pIffTgtkgtno) {
        iffTgtkgtno = pIffTgtkgtno;
    }

    @Column(order = 13, length = 3)
    private String iffRyoutenno;

    public String getIffRyoutenno() {
        return iffRyoutenno;
    }

    public void setIffRyoutenno(String pIffRyoutenno) {
        iffRyoutenno = pIffRyoutenno;
    }

    @Column(order = 14, length = 10)
    private String iffHrkmirnincd;

    public String getIffHrkmirnincd() {
        return iffHrkmirnincd;
    }

    public void setIffHrkmirnincd(String pIffHrkmirnincd) {
        iffHrkmirnincd = pIffHrkmirnincd;
    }

    @Column(order = 15, length = 48)
    private String iffHrkmirninnm;

    public String getIffHrkmirninnm() {
        return iffHrkmirninnm;
    }

    public void setIffHrkmirninnm(String pIffHrkmirninnm) {
        iffHrkmirninnm = pIffHrkmirninnm;
    }

    @Column(order = 16, length = 15)
    private String iffSimukebanknmkn;

    public String getIffSimukebanknmkn() {
        return iffSimukebanknmkn;
    }

    public void setIffSimukebanknmkn(String pIffSimukebanknmkn) {
        iffSimukebanknmkn = pIffSimukebanknmkn;
    }

    @Column(order = 17, length = 15)
    private String iffSimuketennmkn;

    public String getIffSimuketennmkn() {
        return iffSimuketennmkn;
    }

    public void setIffSimuketennmkn(String pIffSimuketennmkn) {
        iffSimuketennmkn = pIffSimuketennmkn;
    }

    @Column(order = 18, length = 20)
    private String iffTekiyounaiyou;

    public String getIffTekiyounaiyou() {
        return iffTekiyounaiyou;
    }

    public void setIffTekiyounaiyou(String pIffTekiyounaiyou) {
        iffTekiyounaiyou = pIffTekiyounaiyou;
    }

    @Column(order = 19, length = 20)
    private String iffEdiinfo;

    public String getIffEdiinfo() {
        return iffEdiinfo;
    }

    public void setIffEdiinfo(String pIffEdiinfo) {
        iffEdiinfo = pIffEdiinfo;
    }

    @Column(order = 20, length = 1)
    private String iffDummy1;

    public String getIffDummy1() {
        return iffDummy1;
    }

    public void setIffDummy1(String pIffDummy1) {
        iffDummy1 = pIffDummy1;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
