package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）契約内容ＬＩＮＣ送信Ｆ（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzLinckyknaiyousksDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzLinckyknaiyousksDataRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffDatakbn;

    public String getIffDatakbn() {
        return iffDatakbn;
    }

    public void setIffDatakbn(String pIffDatakbn) {
        iffDatakbn = pIffDatakbn;
    }

    @Column(order = 2, length = 2)
    private Integer iffLincrecordsyubetu;

    public Integer getIffLincrecordsyubetu() {
        return iffLincrecordsyubetu;
    }

    public void setIffLincrecordsyubetu(Integer pIffLincrecordsyubetu) {
        iffLincrecordsyubetu = pIffLincrecordsyubetu;
    }

    @Column(order = 3, length = 1)
    private String iffLinchenkoutype;

    public String getIffLinchenkoutype() {
        return iffLinchenkoutype;
    }

    public void setIffLinchenkoutype(String pIffLinchenkoutype) {
        iffLinchenkoutype = pIffLinchenkoutype;
    }

    @Column(order = 4, length = 1)
    private String iffLincsyorikekkacd;

    public String getIffLincsyorikekkacd() {
        return iffLincsyorikekkacd;
    }

    public void setIffLincsyorikekkacd(String pIffLincsyorikekkacd) {
        iffLincsyorikekkacd = pIffLincsyorikekkacd;
    }

    @Column(order = 5, length = 2)
    private String iffLinckekkajiyuu;

    public String getIffLinckekkajiyuu() {
        return iffLinckekkajiyuu;
    }

    public void setIffLinckekkajiyuu(String pIffLinckekkajiyuu) {
        iffLinckekkajiyuu = pIffLinckekkajiyuu;
    }

    @Column(order = 6, length = 3)
    private String iffLincerrno;

    public String getIffLincerrno() {
        return iffLincerrno;
    }

    public void setIffLincerrno(String pIffLincerrno) {
        iffLincerrno = pIffLincerrno;
    }

    @Column(order = 7, length = 3)
    private Integer iffLincnayoserecordsuu;

    public Integer getIffLincnayoserecordsuu() {
        return iffLincnayoserecordsuu;
    }

    public void setIffLincnayoserecordsuu(Integer pIffLincnayoserecordsuu) {
        iffLincnayoserecordsuu = pIffLincnayoserecordsuu;
    }

    @Column(order = 8, length = 10)
    private Long iffLinckanyuusyano;

    public Long getIffLinckanyuusyano() {
        return iffLinckanyuusyano;
    }

    public void setIffLinckanyuusyano(Long pIffLinckanyuusyano) {
        iffLinckanyuusyano = pIffLinckanyuusyano;
    }

    @Column(order = 9, length = 2)
    private String iffLinccheckdigit;

    public String getIffLinccheckdigit() {
        return iffLinccheckdigit;
    }

    public void setIffLinccheckdigit(String pIffLinccheckdigit) {
        iffLinccheckdigit = pIffLinccheckdigit;
    }

    @Column(order = 10, length = 32)
    private String iffLincnayoseyomiknnm;

    public String getIffLincnayoseyomiknnm() {
        return iffLincnayoseyomiknnm;
    }

    public void setIffLincnayoseyomiknnm(String pIffLincnayoseyomiknnm) {
        iffLincnayoseyomiknnm = pIffLincnayoseyomiknnm;
    }

    @Column(order = 11, length = 1)
    private Integer iffLinchhknsei;

    public Integer getIffLinchhknsei() {
        return iffLinchhknsei;
    }

    public void setIffLinchhknsei(Integer pIffLinchhknsei) {
        iffLinchhknsei = pIffLinchhknsei;
    }

    @Column(order = 12, length = 8)
    private Integer iffLinchhknseiymd;

    public Integer getIffLinchhknseiymd() {
        return iffLinchhknseiymd;
    }

    public void setIffLinchhknseiymd(Integer pIffLinchhknseiymd) {
        iffLinchhknseiymd = pIffLinchhknseiymd;
    }

    @Column(order = 13, length = 8)
    private Integer iffLinckykymd;

    public Integer getIffLinckykymd() {
        return iffLinckykymd;
    }

    public void setIffLinckykymd(Integer pIffLinckykymd) {
        iffLinckykymd = pIffLinckykymd;
    }

    @Column(order = 14, length = 1)
    private Integer iffLinckeihidjnhyouji;

    public Integer getIffLinckeihidjnhyouji() {
        return iffLinckeihidjnhyouji;
    }

    public void setIffLinckeihidjnhyouji(Integer pIffLinckeihidjnhyouji) {
        iffLinckeihidjnhyouji = pIffLinckeihidjnhyouji;
    }

    @Column(order = 15, length = 2)
    private String iffLincsousinmotokaisya;

    public String getIffLincsousinmotokaisya() {
        return iffLincsousinmotokaisya;
    }

    public void setIffLincsousinmotokaisya(String pIffLincsousinmotokaisya) {
        iffLincsousinmotokaisya = pIffLincsousinmotokaisya;
    }

    @Column(order = 16, length = 30)
    private String iffLinchhknadrkn;

    public String getIffLinchhknadrkn() {
        return iffLinchhknadrkn;
    }

    public void setIffLinchhknadrkn(String pIffLinchhknadrkn) {
        iffLinchhknadrkn = pIffLinchhknadrkn;
    }

    @Column(order = 17, length = 5)
    private String iffLincsgnyukyhng;

    public String getIffLincsgnyukyhng() {
        return iffLincsgnyukyhng;
    }

    public void setIffLincsgnyukyhng(String pIffLincsgnyukyhng) {
        iffLincsgnyukyhng = pIffLincsgnyukyhng;
    }

    @Column(order = 18, length = 5)
    private String iffLincsipnyukyhng;

    public String getIffLincsipnyukyhng() {
        return iffLincsipnyukyhng;
    }

    public void setIffLincsipnyukyhng(String pIffLincsipnyukyhng) {
        iffLincsipnyukyhng = pIffLincsipnyukyhng;
    }

    @Column(order = 19, length = 5)
    private String iffLincsjnyukyhng;

    public String getIffLincsjnyukyhng() {
        return iffLincsjnyukyhng;
    }

    public void setIffLincsjnyukyhng(String pIffLincsjnyukyhng) {
        iffLincsjnyukyhng = pIffLincsjnyukyhng;
    }

    @Column(order = 20, length = 5)
    private String iffLincsonotanyukyhng;

    public String getIffLincsonotanyukyhng() {
        return iffLincsonotanyukyhng;
    }

    public void setIffLincsonotanyukyhng(String pIffLincsonotanyukyhng) {
        iffLincsonotanyukyhng = pIffLincsonotanyukyhng;
    }

    @Column(order = 21, length = 8)
    private Integer iffLinctrkmousideymd;

    public Integer getIffLinctrkmousideymd() {
        return iffLinctrkmousideymd;
    }

    public void setIffLinctrkmousideymd(Integer pIffLinctrkmousideymd) {
        iffLinctrkmousideymd = pIffLinctrkmousideymd;
    }

    @Column(order = 22, length = 8)
    private String iffLincsyoriymd;

    public String getIffLincsyoriymd() {
        return iffLincsyoriymd;
    }

    public void setIffLincsyoriymd(String pIffLincsyoriymd) {
        iffLincsyoriymd = pIffLincsyoriymd;
    }

    @Column(order = 23, length = 32)
    private String iffLinchhknnmkn;

    public String getIffLinchhknnmkn() {
        return iffLinchhknnmkn;
    }

    public void setIffLinchhknnmkn(String pIffLinchhknnmkn) {
        iffLinchhknnmkn = pIffLinchhknnmkn;
    }

    @Column(order = 24, length = 40)
    private String iffLinckykkanrino;

    public String getIffLinckykkanrino() {
        return iffLinckykkanrino;
    }

    public void setIffLinckykkanrino(String pIffLinckykkanrino) {
        iffLinckykkanrino = pIffLinckykkanrino;
    }

    @Column(order = 25, length = 8)
    private Integer iffLinchozenymd;

    public Integer getIffLinchozenymd() {
        return iffLinchozenymd;
    }

    public void setIffLinchozenymd(Integer pIffLinchozenymd) {
        iffLinchozenymd = pIffLinchozenymd;
    }

    @Column(order = 26, length = 42)
    private String iffLinckyknmkn;

    public String getIffLinckyknmkn() {
        return iffLinckyknmkn;
    }

    public void setIffLinckyknmkn(String pIffLinckyknmkn) {
        iffLinckyknmkn = pIffLinckyknmkn;
    }

    @Column(order = 27, length = 10)
    private String iffLinchutuusbs;

    public String getIffLinchutuusbs() {
        return iffLinchutuusbs;
    }

    public void setIffLinchutuusbs(String pIffLinchutuusbs) {
        iffLinchutuusbs = pIffLinchutuusbs;
    }

    @Column(order = 28, length = 10)
    private String iffLincsgsbksns;

    public String getIffLincsgsbksns() {
        return iffLincsgsbksns;
    }

    public void setIffLincsgsbksns(String pIffLincsgsbksns) {
        iffLincsgsbksns = pIffLincsgsbksns;
    }

    @Column(order = 29, length = 40)
    private String iffLinckakusyasiyouran;

    public String getIffLinckakusyasiyouran() {
        return iffLinckakusyasiyouran;
    }

    public void setIffLinckakusyasiyouran(String pIffLinckakusyasiyouran) {
        iffLinckakusyasiyouran = pIffLinckakusyasiyouran;
    }

    @Column(order = 30, length = 1)
    private Integer iffLincmousideflg;

    public Integer getIffLincmousideflg() {
        return iffLincmousideflg;
    }

    public void setIffLincmousideflg(Integer pIffLincmousideflg) {
        iffLincmousideflg = pIffLincmousideflg;
    }

    @Column(order = 31, length = 8)
    private Integer iffLincmousideflgsetymd;

    public Integer getIffLincmousideflgsetymd() {
        return iffLincmousideflgsetymd;
    }

    public void setIffLincmousideflgsetymd(Integer pIffLincmousideflgsetymd) {
        iffLincmousideflgsetymd = pIffLincmousideflgsetymd;
    }

    @Column(order = 32, length = 8)
    private Integer iffLincmousideflgkaijyoymd;

    public Integer getIffLincmousideflgkaijyoymd() {
        return iffLincmousideflgkaijyoymd;
    }

    public void setIffLincmousideflgkaijyoymd(Integer pIffLincmousideflgkaijyoymd) {
        iffLincmousideflgkaijyoymd = pIffLincmousideflgkaijyoymd;
    }

    @Column(order = 33, length = 1)
    private Integer iffLincjgyhknflg;

    public Integer getIffLincjgyhknflg() {
        return iffLincjgyhknflg;
    }

    public void setIffLincjgyhknflg(Integer pIffLincjgyhknflg) {
        iffLincjgyhknflg = pIffLincjgyhknflg;
    }

    @Column(order = 34, length = 1)
    private Integer iffLinctenkanflg;

    public Integer getIffLinctenkanflg() {
        return iffLinctenkanflg;
    }

    public void setIffLinctenkanflg(Integer pIffLinctenkanflg) {
        iffLinctenkanflg = pIffLinctenkanflg;
    }

    @Column(order = 35, length = 1)
    private Integer iffLinckyksei;

    public Integer getIffLinckyksei() {
        return iffLinckyksei;
    }

    public void setIffLinckyksei(Integer pIffLinckyksei) {
        iffLinckyksei = pIffLinckyksei;
    }

    @Column(order = 36, length = 8)
    private Integer iffLinckykseiymd;

    public Integer getIffLinckykseiymd() {
        return iffLinckykseiymd;
    }

    public void setIffLinckykseiymd(Integer pIffLinckykseiymd) {
        iffLinckykseiymd = pIffLinckykseiymd;
    }

    @Column(order = 37, length = 30)
    private String iffLinckykadrkn;

    public String getIffLinckykadrkn() {
        return iffLinckykadrkn;
    }

    public void setIffLinckykadrkn(String pIffLinckykadrkn) {
        iffLinckykadrkn = pIffLinckykadrkn;
    }

    @Column(order = 38, length = 17)
    private String iffDummy17;

    public String getIffDummy17() {
        return iffDummy17;
    }

    public void setIffDummy17(String pIffDummy17) {
        iffDummy17 = pIffDummy17;
    }

    @Column(order = 39, length = 30)
    private String iffLinchhknnmkj;

    public String getIffLinchhknnmkj() {
        return iffLinchhknnmkj;
    }

    public void setIffLinchhknnmkj(String pIffLinchhknnmkj) {
        iffLinchhknnmkj = pIffLinchhknnmkj;
    }

    @Column(order = 40, length = 30)
    private String iffLinckyknmkj;

    public String getIffLinckyknmkj() {
        return iffLinckyknmkj;
    }

    public void setIffLinckyknmkj(String pIffLinckyknmkj) {
        iffLinckyknmkj = pIffLinckyknmkj;
    }

    @Column(order = 41, length = 1)
    private Integer iffLinc15sai1000manflg;

    public Integer getIffLinc15sai1000manflg() {
        return iffLinc15sai1000manflg;
    }

    public void setIffLinc15sai1000manflg(Integer pIffLinc15sai1000manflg) {
        iffLinc15sai1000manflg = pIffLinc15sai1000manflg;
    }

    @Column(order = 42, length = 1)
    private Integer iffLinckjhngflg;

    public Integer getIffLinckjhngflg() {
        return iffLinckjhngflg;
    }

    public void setIffLinckjhngflg(Integer pIffLinckjhngflg) {
        iffLinckjhngflg = pIffLinckjhngflg;
    }

    @Column(order = 43, length = 8)
    private Integer iffLinckykytymd;

    public Integer getIffLinckykytymd() {
        return iffLinckykytymd;
    }

    public void setIffLinckykytymd(Integer pIffLinckykytymd) {
        iffLinckykytymd = pIffLinckykytymd;
    }

    @Column(order = 44, length = 8)
    private Integer iffLinchozenytymd;

    public Integer getIffLinchozenytymd() {
        return iffLinchozenytymd;
    }

    public void setIffLinchozenytymd(Integer pIffLinchozenytymd) {
        iffLinchozenytymd = pIffLinchozenytymd;
    }

    @Column(order = 45, length = 62)
    private String iffDummytwo62;

    public String getIffDummytwo62() {
        return iffDummytwo62;
    }

    public void setIffDummytwo62(String pIffDummytwo62) {
        iffDummytwo62 = pIffDummytwo62;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
