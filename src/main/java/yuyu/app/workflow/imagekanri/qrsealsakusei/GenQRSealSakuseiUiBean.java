package yuyu.app.workflow.imagekanri.qrsealsakusei;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_OutkeisikiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyuturyokuKaisiGyouKbn;

/**
 * QRシール用紙作成 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenQRSealSakuseiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<InputContentsInfo2DataSourceBean> inputContentsInfo2DataSource = new DataSource<>();
    public DataSource<InputContentsInfo2DataSourceBean> getInputContentsInfo2DataSource() {
        return inputContentsInfo2DataSource;
    }

    @Deprecated
    public List<InputContentsInfo2DataSourceBean> getInputContentsInfo2() {
        return inputContentsInfo2DataSource.getDatas();
    }

    public void setInputContentsInfo2(List<InputContentsInfo2DataSourceBean> pInputContentsInfo2) {
        inputContentsInfo2DataSource.setDatas(pInputContentsInfo2);
    }

    private DataSource<InputContentsInfo3DataSourceBean> inputContentsInfo3DataSource = new DataSource<>();
    public DataSource<InputContentsInfo3DataSourceBean> getInputContentsInfo3DataSource() {
        return inputContentsInfo3DataSource;
    }

    @Deprecated
    public List<InputContentsInfo3DataSourceBean> getInputContentsInfo3() {
        return inputContentsInfo3DataSource.getDatas();
    }

    public void setInputContentsInfo3(List<InputContentsInfo3DataSourceBean> pInputContentsInfo3) {
        inputContentsInfo3DataSource.setDatas(pInputContentsInfo3);
    }

    private DataSource<InputContentsInfo4DataSourceBean> inputContentsInfo4DataSource = new DataSource<>();
    public DataSource<InputContentsInfo4DataSourceBean> getInputContentsInfo4DataSource() {
        return inputContentsInfo4DataSource;
    }

    @Deprecated
    public List<InputContentsInfo4DataSourceBean> getInputContentsInfo4() {
        return inputContentsInfo4DataSource.getDatas();
    }

    public void setInputContentsInfo4(List<InputContentsInfo4DataSourceBean> pInputContentsInfo4) {
        inputContentsInfo4DataSource.setDatas(pInputContentsInfo4);
    }

    private String dispsubsystemnm;

    public String getDispsubsystemnm() {
        return dispsubsystemnm;
    }

    public void setDispsubsystemnm(String pDispsubsystemnm) {
        dispsubsystemnm = pDispsubsystemnm;
    }

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }

    private C_OutkeisikiKbn outkeisikikbn;

    public C_OutkeisikiKbn getOutkeisikikbn() {
        return outkeisikikbn;
    }

    public void setOutkeisikikbn(C_OutkeisikiKbn pOutkeisikikbn) {
        outkeisikikbn = pOutkeisikikbn;
    }

    private C_SyuturyokuKaisiGyouKbn syuturyokukaisigyoukbn;

    public C_SyuturyokuKaisiGyouKbn getSyuturyokukaisigyoukbn() {
        return syuturyokukaisigyoukbn;
    }

    public void setSyuturyokukaisigyoukbn(C_SyuturyokuKaisiGyouKbn pSyuturyokukaisigyoukbn) {
        syuturyokukaisigyoukbn = pSyuturyokukaisigyoukbn;
    }

    private C_SkeijimuKbn skeijimukbn;

    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    private String disphknsyuruinoqrseal;

    public String getDisphknsyuruinoqrseal() {
        return disphknsyuruinoqrseal;
    }

    public void setDisphknsyuruinoqrseal(String pDisphknsyuruinoqrseal) {
        disphknsyuruinoqrseal = pDisphknsyuruinoqrseal;
    }

    @MaxLength(max=2)
    @Digit
    private String outkensuu;

    public String getOutkensuu() {
        return outkensuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOutkensuu(String pOutkensuu) {
        outkensuu = pOutkensuu;
    }

    private LoopChain<UserDefsList> disphknsyuruinoqrsealOptionBeanList = new LoopChain<>();
    public UserDefsList getDisphknsyuruinoqrsealOptionBeanList() {
        return disphknsyuruinoqrsealOptionBeanList.get();
    }

    public void setDisphknsyuruinoqrsealOptionBeanList(UserDefsList pDisphknsyuruinoqrsealOptionBeanList) {
        clearDisphknsyuruinoqrsealOptionBeanList();
        disphknsyuruinoqrsealOptionBeanList.add(pDisphknsyuruinoqrsealOptionBeanList);
    }

    public void clearDisphknsyuruinoqrsealOptionBeanList() {
        disphknsyuruinoqrsealOptionBeanList.clear();
    }
}
