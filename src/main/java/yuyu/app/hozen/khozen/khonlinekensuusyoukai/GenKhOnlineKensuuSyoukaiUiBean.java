package yuyu.app.hozen.khozen.khonlinekensuusyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;

/**
 * 契約保全オンライン処理件数照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhOnlineKensuuSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SyoriKensuuListDataSourceBean> syoriKensuuListDataSource = new DataSource<>();
    public DataSource<SyoriKensuuListDataSourceBean> getSyoriKensuuListDataSource() {
        return syoriKensuuListDataSource;
    }

    @Deprecated
    public List<SyoriKensuuListDataSourceBean> getSyoriKensuuList() {
        return syoriKensuuListDataSource.getDatas();
    }

    public void setSyoriKensuuList(List<SyoriKensuuListDataSourceBean> pSyoriKensuuList) {
        syoriKensuuListDataSource.setDatas(pSyoriKensuuList);
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

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
    }
}
