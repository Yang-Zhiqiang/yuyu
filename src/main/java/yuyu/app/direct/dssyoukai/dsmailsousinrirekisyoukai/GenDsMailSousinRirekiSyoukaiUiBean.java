package yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳメール送信履歴照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenDsMailSousinRirekiSyoukaiUiBean extends AbstractUiBean {

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

    @Length(length=10)
    @SingleByteStrings
    @Digit
    private String srchdskokno;

    public String getSrchdskokno() {
        return srchdskokno;
    }

    public void setSrchdskokno(String pSrchdskokno) {
        srchdskokno = pSrchdskokno;
    }

    @SyoukenNo
    private String srchsyono;

    public String getSrchsyono() {
        return srchsyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSrchsyono(String pSrchsyono) {
        srchsyono = pSrchsyono;
    }

    private Boolean dsgaitoukokyakukensaku;

    public Boolean getDsgaitoukokyakukensaku() {
        return (dsgaitoukokyakukensaku == null) ? Boolean.FALSE : dsgaitoukokyakukensaku;
    }

    public void setDsgaitoukokyakukensaku(Boolean pDsgaitoukokyakukensaku) {
        dsgaitoukokyakukensaku = (pDsgaitoukokyakukensaku == null) ? Boolean.FALSE : pDsgaitoukokyakukensaku;
    }

    @Length(length=21)
    @AlphaDigit
    private String srchdssousinno;

    public String getSrchdssousinno() {
        return srchdssousinno;
    }

    @DataConvert("toSingleByte")
    public void setSrchdssousinno(String pSrchdssousinno) {
        srchdssousinno = pSrchdssousinno;
    }

    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return dssousinmailsyubetukbn;
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
    }

    @ValidDate
    private BizDate sousinymdfrom;

    public BizDate getSousinymdfrom() {
        return sousinymdfrom;
    }

    @DataConvert("toSingleByte")
    public void setSousinymdfrom(BizDate pSousinymdfrom) {
        sousinymdfrom = pSousinymdfrom;
    }

    @ValidDate
    private BizDate sousinymdto;

    public BizDate getSousinymdto() {
        return sousinymdto;
    }

    @DataConvert("toSingleByte")
    public void setSousinymdto(BizDate pSousinymdto) {
        sousinymdto = pSousinymdto;
    }
}
