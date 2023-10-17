package yuyu.app.workflow.processkanri.kouteijyoukyousyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_Kouteikanristatus;

/**
 * 工程状況照会 - taskuserInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTaskuserInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }


    private String dispGyoumuKey;

    public String getDispGyoumuKey() {
        return dispGyoumuKey;
    }

    public void setDispGyoumuKey(String pDispGyoumuKey) {
        dispGyoumuKey = pDispGyoumuKey;
    }


    @ValidDate
    private BizDate hyoujiYmdFrom;

    public BizDate getHyoujiYmdFrom() {
        return hyoujiYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHyoujiYmdFrom(BizDate pHyoujiYmdFrom) {
        hyoujiYmdFrom = pHyoujiYmdFrom;
    }


    private BizDate dispjimustartymd;

    public BizDate getDispjimustartymd() {
        return dispjimustartymd;
    }

    public void setDispjimustartymd(BizDate pDispjimustartymd) {
        dispjimustartymd = pDispjimustartymd;
    }


    @ValidDate
    private BizDate hyoujiYmdTo;

    public BizDate getHyoujiYmdTo() {
        return hyoujiYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHyoujiYmdTo(BizDate pHyoujiYmdTo) {
        hyoujiYmdTo = pHyoujiYmdTo;
    }


    private C_Kouteikanristatus dispkouteikanristatus;

    public C_Kouteikanristatus getDispkouteikanristatus() {
        return dispkouteikanristatus;
    }

    public void setDispkouteikanristatus(C_Kouteikanristatus pDispkouteikanristatus) {
        dispkouteikanristatus = pDispkouteikanristatus;
    }


    private String disptasknm;

    public String getDisptasknm() {
        return disptasknm;
    }

    public void setDisptasknm(String pDisptasknm) {
        disptasknm = pDisptasknm;
    }


    private String dispnowsyoritantounm;

    public String getDispnowsyoritantounm() {
        return dispnowsyoritantounm;
    }

    public void setDispnowsyoritantounm(String pDispnowsyoritantounm) {
        dispnowsyoritantounm = pDispnowsyoritantounm;
    }


    private String syousaiLink;

    public String getSyousaiLink() {
        return syousaiLink;
    }

    public void setSyousaiLink(String pSyousaiLink) {
        syousaiLink = pSyousaiLink;
    }

}
