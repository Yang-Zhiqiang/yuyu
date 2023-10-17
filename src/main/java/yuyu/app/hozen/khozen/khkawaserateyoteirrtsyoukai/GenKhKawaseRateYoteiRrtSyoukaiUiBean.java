package yuyu.app.hozen.khozen.khkawaserateyoteirrtsyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 為替レート予定利率推移照会（平準払） : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhKawaseRateYoteiRrtSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<ReferenceListDataSourceBean> referenceListDataSource = new DataSource<>();
    public DataSource<ReferenceListDataSourceBean> getReferenceListDataSource() {
        return referenceListDataSource;
    }

    @Deprecated
    public List<ReferenceListDataSourceBean> getReferenceList() {
        return referenceListDataSource.getDatas();
    }

    public void setReferenceList(List<ReferenceListDataSourceBean> pReferenceList) {
        referenceListDataSource.setDatas(pReferenceList, 12);
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

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
    }
}
