package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）追加取込書類リストレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiTuikaTorikomiSyoruiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiTuikaTorikomiSyoruiLayoutFile() {
    }


    @Column(order = 1, label = "連番")
    @NotNull
    private Integer ifcRenno;


    public Integer getIfcRenno() {
        return ifcRenno;
    }


    public void setIfcRenno(Integer pIfcRenno) {
        ifcRenno = pIfcRenno;
    }


    @Column(order = 2, label = "請求状況")
    private String ifcSeikyuujk;


    public String getIfcSeikyuujk() {
        return ifcSeikyuujk;
    }


    public void setIfcSeikyuujk(String pIfcSeikyuujk) {
        ifcSeikyuujk = pIfcSeikyuujk;
    }


    @Column(order = 3, label = "証券番号")
    @NotNull
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 4, label = "請求番号")
    @NotNull
    private String ifcSkno;


    public String getIfcSkno() {
        return ifcSkno;
    }


    public void setIfcSkno(String pIfcSkno) {
        ifcSkno = pIfcSkno;
    }


    @Column(order = 5, label = "日付名称")
    private String ifcDaynm;


    public String getIfcDaynm() {
        return ifcDaynm;
    }


    public void setIfcDaynm(String pIfcDaynm) {
        ifcDaynm = pIfcDaynm;
    }


    @Column(order = 6, label = "日付")
    private BizDate ifcDay;


    public BizDate getIfcDay() {
        return ifcDay;
    }


    public void setIfcDay(BizDate pIfcDay) {
        ifcDay = pIfcDay;
    }


    @Column(order = 7, label = "書類名")
    private String ifcSyoruinm;


    public String getIfcSyoruinm() {
        return ifcSyoruinm;
    }


    public void setIfcSyoruinm(String pIfcSyoruinm) {
        ifcSyoruinm = pIfcSyoruinm;
    }


    @Column(order = 8, label = "チェック")
    private String ifcCheck;


    public String getIfcCheck() {
        return ifcCheck;
    }


    public void setIfcCheck(String pIfcCheck) {
        ifcCheck = pIfcCheck;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
