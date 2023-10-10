package yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_DsSpiralSequenceHsnSetKbn;

/**
 * ＤＳメール配信予約 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenDsMailHaisinYoyakuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SearchResultInfoDataSourceBean> searchResultInfoDataSource = new DataSource<>();
    public DataSource<SearchResultInfoDataSourceBean> getSearchResultInfoDataSource() {
        return searchResultInfoDataSource;
    }

    @Deprecated
    public List<SearchResultInfoDataSourceBean> getSearchResultInfo() {
        return searchResultInfoDataSource.getDatas();
    }

    public void setSearchResultInfo(List<SearchResultInfoDataSourceBean> pSearchResultInfo) {
        searchResultInfoDataSource.setDatas(pSearchResultInfo, 10);
    }

    private C_DsSousinMailSyubetuKbn srchdssousinmailsyubetukbn;

    public C_DsSousinMailSyubetuKbn getSrchdssousinmailsyubetukbn() {
        return srchdssousinmailsyubetukbn;
    }

    public void setSrchdssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pSrchdssousinmailsyubetukbn) {
        srchdssousinmailsyubetukbn = pSrchdssousinmailsyubetukbn;
    }

    @ValidDate
    private BizDate srchdshaisinyoteiymdfrom;

    public BizDate getSrchdshaisinyoteiymdfrom() {
        return srchdshaisinyoteiymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchdshaisinyoteiymdfrom(BizDate pSrchdshaisinyoteiymdfrom) {
        srchdshaisinyoteiymdfrom = pSrchdshaisinyoteiymdfrom;
    }

    @ValidDate
    private BizDate srchdshaisinyoteiymdto;

    public BizDate getSrchdshaisinyoteiymdto() {
        return srchdshaisinyoteiymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchdshaisinyoteiymdto(BizDate pSrchdshaisinyoteiymdto) {
        srchdshaisinyoteiymdto = pSrchdshaisinyoteiymdto;
    }

    private C_DsHaisinYoyakuStatusKbn[] srchdshaisinyoyakustatuskbn;

    public C_DsHaisinYoyakuStatusKbn[] getSrchdshaisinyoyakustatuskbn() {
        return srchdshaisinyoyakustatuskbn;
    }

    public void setSrchdshaisinyoyakustatuskbn(C_DsHaisinYoyakuStatusKbn[] pSrchdshaisinyoyakustatuskbn) {
        srchdshaisinyoyakustatuskbn = pSrchdshaisinyoyakustatuskbn;
    }

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

    private Boolean dsspiralsequencehsnset;

    public Boolean getDsspiralsequencehsnset() {
        return (dsspiralsequencehsnset == null) ? Boolean.FALSE : dsspiralsequencehsnset;
    }

    public void setDsspiralsequencehsnset(Boolean pDsspiralsequencehsnset) {
        dsspiralsequencehsnset = (pDsspiralsequencehsnset == null) ? Boolean.FALSE : pDsspiralsequencehsnset;
    }

    private C_DsSpiralSequenceHsnSetKbn dsspiralsequencehsnsetkbn;

    public C_DsSpiralSequenceHsnSetKbn getDsspiralsequencehsnsetkbn() {
        return dsspiralsequencehsnsetkbn;
    }

    public void setDsspiralsequencehsnsetkbn(C_DsSpiralSequenceHsnSetKbn pDsspiralsequencehsnsetkbn) {
        dsspiralsequencehsnsetkbn = pDsspiralsequencehsnsetkbn;
    }
}
