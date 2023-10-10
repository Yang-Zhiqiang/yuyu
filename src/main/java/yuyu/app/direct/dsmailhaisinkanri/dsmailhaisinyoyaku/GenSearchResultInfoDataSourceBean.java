package yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;

/**
 * ＤＳメール配信予約 - searchResultInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ValidDate
    private BizDate dsmailhaisinyoteiymd;

    public BizDate getDsmailhaisinyoteiymd() {
        return dsmailhaisinyoteiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsmailhaisinyoteiymd(BizDate pDsmailhaisinyoteiymd) {
        dsmailhaisinyoteiymd = pDsmailhaisinyoteiymd;
    }


    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return dssousinmailsyubetukbn;
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
    }


    private C_DsHaisinYoyakuStatusKbn dshaisinyoyakustatuskbn;

    public C_DsHaisinYoyakuStatusKbn getDshaisinyoyakustatuskbn() {
        return dshaisinyoyakustatuskbn;
    }

    public void setDshaisinyoyakustatuskbn(C_DsHaisinYoyakuStatusKbn pDshaisinyoyakustatuskbn) {
        dshaisinyoyakustatuskbn = pDshaisinyoyakustatuskbn;
    }


    private String syouninlink;

    public String getSyouninlink() {
        return syouninlink;
    }

    public void setSyouninlink(String pSyouninlink) {
        syouninlink = pSyouninlink;
    }


    private String sakujyoLink;

    public String getSakujyoLink() {
        return sakujyoLink;
    }

    public void setSakujyoLink(String pSakujyoLink) {
        sakujyoLink = pSakujyoLink;
    }


    private String gyoumuKousinTime;

    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }


    private String kostime;

    public String getKostime() {
        return kostime;
    }

    public void setKostime(String pKostime) {
        kostime = pKostime;
    }


    private BizDate dsmailhaisintourokuymd;

    public BizDate getDsmailhaisintourokuymd() {
        return dsmailhaisintourokuymd;
    }

    public void setDsmailhaisintourokuymd(BizDate pDsmailhaisintourokuymd) {
        dsmailhaisintourokuymd = pDsmailhaisintourokuymd;
    }


    private BizDate dsmailhaisinsyouninymd;

    public BizDate getDsmailhaisinsyouninymd() {
        return dsmailhaisinsyouninymd;
    }

    public void setDsmailhaisinsyouninymd(BizDate pDsmailhaisinsyouninymd) {
        dsmailhaisinsyouninymd = pDsmailhaisinsyouninymd;
    }

}
