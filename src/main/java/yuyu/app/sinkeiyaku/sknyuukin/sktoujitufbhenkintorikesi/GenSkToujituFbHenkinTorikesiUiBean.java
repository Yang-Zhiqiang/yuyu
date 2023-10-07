package yuyu.app.sinkeiyaku.sknyuukin.sktoujitufbhenkintorikesi;

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
 * 当日ＦＢ返金取消 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkToujituFbHenkinTorikesiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<HenkinJyouhouListDataSourceBean> henkinJyouhouListDataSource = new DataSource<>();
    public DataSource<HenkinJyouhouListDataSourceBean> getHenkinJyouhouListDataSource() {
        return henkinJyouhouListDataSource;
    }

    @Deprecated
    public List<HenkinJyouhouListDataSourceBean> getHenkinJyouhouList() {
        return henkinJyouhouListDataSource.getDatas();
    }

    public void setHenkinJyouhouList(List<HenkinJyouhouListDataSourceBean> pHenkinJyouhouList) {
        henkinJyouhouListDataSource.setDatas(pHenkinJyouhouList);
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
}
