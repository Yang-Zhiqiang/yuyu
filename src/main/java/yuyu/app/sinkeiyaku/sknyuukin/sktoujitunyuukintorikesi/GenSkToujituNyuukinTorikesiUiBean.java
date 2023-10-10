package yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi;

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
 * 当日入金取消 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkToujituNyuukinTorikesiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<NyuukinJyouhouListDataSourceBean> nyuukinJyouhouListDataSource = new DataSource<>();
    public DataSource<NyuukinJyouhouListDataSourceBean> getNyuukinJyouhouListDataSource() {
        return nyuukinJyouhouListDataSource;
    }

    @Deprecated
    public List<NyuukinJyouhouListDataSourceBean> getNyuukinJyouhouList() {
        return nyuukinJyouhouListDataSource.getDatas();
    }

    public void setNyuukinJyouhouList(List<NyuukinJyouhouListDataSourceBean> pNyuukinJyouhouList) {
        nyuukinJyouhouListDataSource.setDatas(pNyuukinJyouhouList);
    }

    private String hubisyousaibtn;

    public String getHubisyousaibtn() {
        return hubisyousaibtn;
    }

    public void setHubisyousaibtn(String pHubisyousaibtn) {
        hubisyousaibtn = pHubisyousaibtn;
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
    private String kyknmkj;

    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
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
