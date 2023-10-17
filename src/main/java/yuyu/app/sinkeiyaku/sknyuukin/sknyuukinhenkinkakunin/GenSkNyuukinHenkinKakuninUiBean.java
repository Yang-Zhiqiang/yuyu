package yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_NyuukinHenkinSyoriKbn;

/**
 * 入金／返金状況確認 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkNyuukinHenkinKakuninUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<GoukeiInfoDataSourceBean> goukeiInfoDataSource = new DataSource<>();
    public DataSource<GoukeiInfoDataSourceBean> getGoukeiInfoDataSource() {
        return goukeiInfoDataSource;
    }

    @Deprecated
    public List<GoukeiInfoDataSourceBean> getGoukeiInfo() {
        return goukeiInfoDataSource.getDatas();
    }

    public void setGoukeiInfo(List<GoukeiInfoDataSourceBean> pGoukeiInfo) {
        goukeiInfoDataSource.setDatas(pGoukeiInfo);
    }

    private DataSource<NyuukinMeisaiDataSourceBean> nyuukinMeisaiDataSource = new DataSource<>();
    public DataSource<NyuukinMeisaiDataSourceBean> getNyuukinMeisaiDataSource() {
        return nyuukinMeisaiDataSource;
    }

    @Deprecated
    public List<NyuukinMeisaiDataSourceBean> getNyuukinMeisai() {
        return nyuukinMeisaiDataSource.getDatas();
    }

    public void setNyuukinMeisai(List<NyuukinMeisaiDataSourceBean> pNyuukinMeisai) {
        nyuukinMeisaiDataSource.setDatas(pNyuukinMeisai);
    }

    private DataSource<HenkinMeisaiDataSourceBean> henkinMeisaiDataSource = new DataSource<>();
    public DataSource<HenkinMeisaiDataSourceBean> getHenkinMeisaiDataSource() {
        return henkinMeisaiDataSource;
    }

    @Deprecated
    public List<HenkinMeisaiDataSourceBean> getHenkinMeisai() {
        return henkinMeisaiDataSource.getDatas();
    }

    public void setHenkinMeisai(List<HenkinMeisaiDataSourceBean> pHenkinMeisai) {
        henkinMeisaiDataSource.setDatas(pHenkinMeisai);
    }

    private C_NyuukinHenkinSyoriKbn nyuukinhenkinsyorikbn;

    public C_NyuukinHenkinSyoriKbn getNyuukinhenkinsyorikbn() {
        return nyuukinhenkinsyorikbn;
    }

    public void setNyuukinhenkinsyorikbn(C_NyuukinHenkinSyoriKbn pNyuukinhenkinsyorikbn) {
        nyuukinhenkinsyorikbn = pNyuukinhenkinsyorikbn;
    }

    @ValidDate
    private BizDate syoriYmd;

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
}
