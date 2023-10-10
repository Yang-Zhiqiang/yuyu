package yuyu.app.direct.dssyoukai.dssousarirekisyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.TimeHM;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_SousaRirekiJkKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 操作履歴照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenDsSousaRirekiSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<KensakukekkaDataSourceBean> kensakukekkaDataSource = new DataSource<>();
    public DataSource<KensakukekkaDataSourceBean> getKensakukekkaDataSource() {
        return kensakukekkaDataSource;
    }

    @Deprecated
    public List<KensakukekkaDataSourceBean> getKensakukekka() {
        return kensakukekkaDataSource.getDatas();
    }

    public void setKensakukekka(List<KensakukekkaDataSourceBean> pKensakukekka) {
        kensakukekkaDataSource.setDatas(pKensakukekka, 10);
    }

    private DataSource<SousarirekisyousaiInfoDataSourceBean> sousarirekisyousaiInfoDataSource = new DataSource<>();
    public DataSource<SousarirekisyousaiInfoDataSourceBean> getSousarirekisyousaiInfoDataSource() {
        return sousarirekisyousaiInfoDataSource;
    }

    @Deprecated
    public List<SousarirekisyousaiInfoDataSourceBean> getSousarirekisyousaiInfo() {
        return sousarirekisyousaiInfoDataSource.getDatas();
    }

    public void setSousarirekisyousaiInfo(List<SousarirekisyousaiInfoDataSourceBean> pSousarirekisyousaiInfo) {
        sousarirekisyousaiInfoDataSource.setDatas(pSousarirekisyousaiInfo);
    }

    @ValidDate
    private BizDate ttdkymdfrom;

    public BizDate getTtdkymdfrom() {
        return ttdkymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkymdfrom(BizDate pTtdkymdfrom) {
        ttdkymdfrom = pTtdkymdfrom;
    }

    @ValidDate
    private BizDate ttdkymdto;

    public BizDate getTtdkymdto() {
        return ttdkymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkymdto(BizDate pTtdkymdto) {
        ttdkymdto = pTtdkymdto;
    }

    @TimeHM
    private String ttdkstarttimefrom;

    public String getTtdkstarttimefrom() {
        return ttdkstarttimefrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkstarttimefrom(String pTtdkstarttimefrom) {
        ttdkstarttimefrom = pTtdkstarttimefrom;
    }

    @TimeHM
    private String ttdkstarttimeto;

    public String getTtdkstarttimeto() {
        return ttdkstarttimeto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdkstarttimeto(String pTtdkstarttimeto) {
        ttdkstarttimeto = pTtdkstarttimeto;
    }

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private Boolean syonomisetteikensaku;

    public Boolean getSyonomisetteikensaku() {
        return (syonomisetteikensaku == null) ? Boolean.FALSE : syonomisetteikensaku;
    }

    public void setSyonomisetteikensaku(Boolean pSyonomisetteikensaku) {
        syonomisetteikensaku = (pSyonomisetteikensaku == null) ? Boolean.FALSE : pSyonomisetteikensaku;
    }

    private C_SousaRirekiJkKbn sousarirekijkkbn;

    public C_SousaRirekiJkKbn getSousarirekijkkbn() {
        return sousarirekijkkbn;
    }

    public void setSousarirekijkkbn(C_SousaRirekiJkKbn pSousarirekijkkbn) {
        sousarirekijkkbn = pSousarirekijkkbn;
    }

    private C_TtdkKekkaKbn sousarirekikekkakbn;

    public C_TtdkKekkaKbn getSousarirekikekkakbn() {
        return sousarirekikekkakbn;
    }

    public void setSousarirekikekkakbn(C_TtdkKekkaKbn pSousarirekikekkakbn) {
        sousarirekikekkakbn = pSousarirekikekkakbn;
    }
}
