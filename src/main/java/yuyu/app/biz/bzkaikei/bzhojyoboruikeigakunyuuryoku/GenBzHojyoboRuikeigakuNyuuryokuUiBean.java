package yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku;

import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;

/**
 * 補助簿累計額入力 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzHojyoboRuikeigakuNyuuryokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<HojyoboRuikeigakuInfoListDataSourceBean> hojyoboRuikeigakuInfoListDataSource = new DataSource<>();
    public DataSource<HojyoboRuikeigakuInfoListDataSourceBean> getHojyoboRuikeigakuInfoListDataSource() {
        return hojyoboRuikeigakuInfoListDataSource;
    }

    @Deprecated
    public List<HojyoboRuikeigakuInfoListDataSourceBean> getHojyoboRuikeigakuInfoList() {
        return hojyoboRuikeigakuInfoListDataSource.getDatas();
    }

    public void setHojyoboRuikeigakuInfoList(List<HojyoboRuikeigakuInfoListDataSourceBean> pHojyoboRuikeigakuInfoList) {
        hojyoboRuikeigakuInfoListDataSource.setDatas(pHojyoboRuikeigakuInfoList);
    }

    private String dispkanjyoukamoku;

    public String getDispkanjyoukamoku() {
        return dispkanjyoukamoku;
    }

    public void setDispkanjyoukamoku(String pDispkanjyoukamoku) {
        dispkanjyoukamoku = pDispkanjyoukamoku;
    }

    @AlphaDigit
    @Length(length=5)
    private String inputkanjyoukamoku;

    public String getInputkanjyoukamoku() {
        return inputkanjyoukamoku;
    }

    public void setInputkanjyoukamoku(String pInputkanjyoukamoku) {
        inputkanjyoukamoku = pInputkanjyoukamoku;
    }

    private String dispkarikataruigk;

    public String getDispkarikataruigk() {
        return dispkarikataruigk;
    }

    public void setDispkarikataruigk(String pDispkarikataruigk) {
        dispkarikataruigk = pDispkarikataruigk;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency dispkasikataruigk;

    public BizCurrency getDispkasikataruigk() {
        return dispkasikataruigk;
    }

    public void setDispkasikataruigk(BizCurrency pDispkasikataruigk) {
        dispkasikataruigk = pDispkasikataruigk;
    }

    private String inputkarikatateiseigk;

    public String getInputkarikatateiseigk() {
        return inputkarikatateiseigk;
    }

    public void setInputkarikatateiseigk(String pInputkarikatateiseigk) {
        inputkarikatateiseigk = pInputkarikatateiseigk;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency inputkasikatateiseigk;

    public BizCurrency getInputkasikatateiseigk() {
        return inputkasikatateiseigk;
    }

    public void setInputkasikatateiseigk(BizCurrency pInputkasikatateiseigk) {
        inputkasikatateiseigk = pInputkasikatateiseigk;
    }
}
