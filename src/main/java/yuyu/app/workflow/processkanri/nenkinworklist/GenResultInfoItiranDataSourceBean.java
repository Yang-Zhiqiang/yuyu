package yuyu.app.workflow.processkanri.nenkinworklist;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.NenkinSyousyoNo;

/**
 * 年金支払工程ワークリスト - resultInfoItiran の 行データBean ベースクラスです。<br />
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


    @NenkinSyousyoNo
    private String nksysyno;

    public String getNksysyno() {
        return nksysyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNksysyno(String pNksysyno) {
        nksysyno = pNksysyno;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String nenkinuktnmkanji;

    public String getNenkinuktnmkanji() {
        return nenkinuktnmkanji;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNenkinuktnmkanji(String pNenkinuktnmkanji) {
        nenkinuktnmkanji = pNenkinuktnmkanji;
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
