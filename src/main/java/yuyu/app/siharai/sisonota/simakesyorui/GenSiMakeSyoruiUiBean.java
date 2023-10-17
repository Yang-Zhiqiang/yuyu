package yuyu.app.siharai.sisonota.simakesyorui;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SiSyoruisakuseiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金書類作成 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiMakeSyoruiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<AnkenSearchResultListDataSourceBean> ankenSearchResultListDataSource = new DataSource<>();
    public DataSource<AnkenSearchResultListDataSourceBean> getAnkenSearchResultListDataSource() {
        return ankenSearchResultListDataSource;
    }

    @Deprecated
    public List<AnkenSearchResultListDataSourceBean> getAnkenSearchResultList() {
        return ankenSearchResultListDataSource.getDatas();
    }

    public void setAnkenSearchResultList(List<AnkenSearchResultListDataSourceBean> pAnkenSearchResultList) {
        ankenSearchResultListDataSource.setDatas(pAnkenSearchResultList);
    }

    private DataSource<SakuseiTaisyouAnkenListDataSourceBean> sakuseiTaisyouAnkenListDataSource = new DataSource<>();
    public DataSource<SakuseiTaisyouAnkenListDataSourceBean> getSakuseiTaisyouAnkenListDataSource() {
        return sakuseiTaisyouAnkenListDataSource;
    }

    @Deprecated
    public List<SakuseiTaisyouAnkenListDataSourceBean> getSakuseiTaisyouAnkenList() {
        return sakuseiTaisyouAnkenListDataSource.getDatas();
    }

    public void setSakuseiTaisyouAnkenList(List<SakuseiTaisyouAnkenListDataSourceBean> pSakuseiTaisyouAnkenList) {
        sakuseiTaisyouAnkenListDataSource.setDatas(pSakuseiTaisyouAnkenList);
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

    private C_SeikyuuSyubetu seikyuusyubetu;

    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private C_SiSyoruisakuseiKbn sisyoruisakuseikbn;

    public C_SiSyoruisakuseiKbn getSisyoruisakuseikbn() {
        return sisyoruisakuseikbn;
    }

    public void setSisyoruisakuseikbn(C_SiSyoruisakuseiKbn pSisyoruisakuseikbn) {
        sisyoruisakuseikbn = pSisyoruisakuseikbn;
    }
}
