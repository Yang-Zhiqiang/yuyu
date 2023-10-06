package yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 不備メッセージ : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkHubiMsgUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<KetteiHoryuuHubiDataSourceBean> ketteiHoryuuHubiDataSource = new DataSource<>();
    public DataSource<KetteiHoryuuHubiDataSourceBean> getKetteiHoryuuHubiDataSource() {
        return ketteiHoryuuHubiDataSource;
    }

    @Deprecated
    public List<KetteiHoryuuHubiDataSourceBean> getKetteiHoryuuHubi() {
        return ketteiHoryuuHubiDataSource.getDatas();
    }

    public void setKetteiHoryuuHubi(List<KetteiHoryuuHubiDataSourceBean> pKetteiHoryuuHubi) {
        ketteiHoryuuHubiDataSource.setDatas(pKetteiHoryuuHubi);
    }

    private DataSource<SeirituHoryuuHubiDataSourceBean> seirituHoryuuHubiDataSource = new DataSource<>();
    public DataSource<SeirituHoryuuHubiDataSourceBean> getSeirituHoryuuHubiDataSource() {
        return seirituHoryuuHubiDataSource;
    }

    @Deprecated
    public List<SeirituHoryuuHubiDataSourceBean> getSeirituHoryuuHubi() {
        return seirituHoryuuHubiDataSource.getDatas();
    }

    public void setSeirituHoryuuHubi(List<SeirituHoryuuHubiDataSourceBean> pSeirituHoryuuHubi) {
        seirituHoryuuHubiDataSource.setDatas(pSeirituHoryuuHubi);
    }

    private DataSource<WarningDataSourceBean> warningDataSource = new DataSource<>();
    public DataSource<WarningDataSourceBean> getWarningDataSource() {
        return warningDataSource;
    }

    @Deprecated
    public List<WarningDataSourceBean> getWarning() {
        return warningDataSource.getDatas();
    }

    public void setWarning(List<WarningDataSourceBean> pWarning) {
        warningDataSource.setDatas(pWarning);
    }

    private DataSource<KihonHubiDataSourceBean> kihonHubiDataSource = new DataSource<>();
    public DataSource<KihonHubiDataSourceBean> getKihonHubiDataSource() {
        return kihonHubiDataSource;
    }

    @Deprecated
    public List<KihonHubiDataSourceBean> getKihonHubi() {
        return kihonHubiDataSource.getDatas();
    }

    public void setKihonHubi(List<KihonHubiDataSourceBean> pKihonHubi) {
        kihonHubiDataSource.setDatas(pKihonHubi);
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

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknnmkj;

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }
}
