package yuyu.app.sinkeiyaku.sksonota.sktetudukityuui;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約手続注意設定 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkTetudukiTyuuiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<ToriatukaiTyuuiInfoDataSourceBean> toriatukaiTyuuiInfoDataSource = new DataSource<>();
    public DataSource<ToriatukaiTyuuiInfoDataSourceBean> getToriatukaiTyuuiInfoDataSource() {
        return toriatukaiTyuuiInfoDataSource;
    }

    @Deprecated
    public List<ToriatukaiTyuuiInfoDataSourceBean> getToriatukaiTyuuiInfo() {
        return toriatukaiTyuuiInfoDataSource.getDatas();
    }

    public void setToriatukaiTyuuiInfo(List<ToriatukaiTyuuiInfoDataSourceBean> pToriatukaiTyuuiInfo) {
        toriatukaiTyuuiInfoDataSource.setDatas(pToriatukaiTyuuiInfo);
    }

    private DataSource<SonotaTyuuiInfoDataSourceBean> sonotaTyuuiInfoDataSource = new DataSource<>();
    public DataSource<SonotaTyuuiInfoDataSourceBean> getSonotaTyuuiInfoDataSource() {
        return sonotaTyuuiInfoDataSource;
    }

    @Deprecated
    public List<SonotaTyuuiInfoDataSourceBean> getSonotaTyuuiInfo() {
        return sonotaTyuuiInfoDataSource.getDatas();
    }

    public void setSonotaTyuuiInfo(List<SonotaTyuuiInfoDataSourceBean> pSonotaTyuuiInfo) {
        sonotaTyuuiInfoDataSource.setDatas(pSonotaTyuuiInfo);
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

    private Boolean skeittdkkinkyuyouhi;

    public Boolean getSkeittdkkinkyuyouhi() {
        return (skeittdkkinkyuyouhi == null) ? Boolean.FALSE : skeittdkkinkyuyouhi;
    }

    public void setSkeittdkkinkyuyouhi(Boolean pSkeittdkkinkyuyouhi) {
        skeittdkkinkyuyouhi = (pSkeittdkkinkyuyouhi == null) ? Boolean.FALSE : pSkeittdkkinkyuyouhi;
    }

    private Boolean skeittdktyuuiyouhi;

    public Boolean getSkeittdktyuuiyouhi() {
        return (skeittdktyuuiyouhi == null) ? Boolean.FALSE : skeittdktyuuiyouhi;
    }

    public void setSkeittdktyuuiyouhi(Boolean pSkeittdktyuuiyouhi) {
        skeittdktyuuiyouhi = (pSkeittdktyuuiyouhi == null) ? Boolean.FALSE : pSkeittdktyuuiyouhi;
    }
}
