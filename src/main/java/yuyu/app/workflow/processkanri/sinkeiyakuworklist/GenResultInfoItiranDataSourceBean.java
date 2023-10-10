package yuyu.app.workflow.processkanri.sinkeiyakuworklist;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約工程ワークリスト - resultInfoItiran の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenResultInfoItiranDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispjimustartymdtime;

    public String getDispjimustartymdtime() {
        return dispjimustartymdtime;
    }

    public void setDispjimustartymdtime(String pDispjimustartymdtime) {
        dispjimustartymdtime = pDispjimustartymdtime;
    }


    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }


    private String disphknsyuruiworklist;

    public String getDisphknsyuruiworklist() {
        return disphknsyuruiworklist;
    }

    public void setDisphknsyuruiworklist(String pDisphknsyuruiworklist) {
        disphknsyuruiworklist = pDisphknsyuruiworklist;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String kyknmkj;

    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }


    private String dispzenkaisyoritask;

    public String getDispzenkaisyoritask() {
        return dispzenkaisyoritask;
    }

    public void setDispzenkaisyoritask(String pDispzenkaisyoritask) {
        dispzenkaisyoritask = pDispzenkaisyoritask;
    }


    private String dispzenkaisyoritantounm;

    public String getDispzenkaisyoritantounm() {
        return dispzenkaisyoritantounm;
    }

    public void setDispzenkaisyoritantounm(String pDispzenkaisyoritantounm) {
        dispzenkaisyoritantounm = pDispzenkaisyoritantounm;
    }


    private String nyuuryokuLink;

    public String getNyuuryokuLink() {
        return nyuuryokuLink;
    }

    public void setNyuuryokuLink(String pNyuuryokuLink) {
        nyuuryokuLink = pNyuuryokuLink;
    }

}
