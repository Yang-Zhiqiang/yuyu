package yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku;

import java.util.List;

import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;

/**
 * 保険金給付金不備内容検索 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiHubiNaiyouKensakuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<HubinaiyouListDataSourceBean> hubinaiyouListDataSource = new DataSource<>();
    public DataSource<HubinaiyouListDataSourceBean> getHubinaiyouListDataSource() {
        return hubinaiyouListDataSource;
    }

    @Deprecated
    public List<HubinaiyouListDataSourceBean> getHubinaiyouList() {
        return hubinaiyouListDataSource.getDatas();
    }

    public void setHubinaiyouList(List<HubinaiyouListDataSourceBean> pHubinaiyouList) {
        hubinaiyouListDataSource.setDatas(pHubinaiyouList);
    }

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }

    private String dispsyoruinmsntk;

    public String getDispsyoruinmsntk() {
        return dispsyoruinmsntk;
    }

    public void setDispsyoruinmsntk(String pDispsyoruinmsntk) {
        dispsyoruinmsntk = pDispsyoruinmsntk;
    }

    private LoopChain<UserDefsList> dispjimutetuzukinmOptionBeanList = new LoopChain<>();
    public UserDefsList getDispjimutetuzukinmOptionBeanList() {
        return dispjimutetuzukinmOptionBeanList.get();
    }

    public void setDispjimutetuzukinmOptionBeanList(UserDefsList pDispjimutetuzukinmOptionBeanList) {
        clearDispjimutetuzukinmOptionBeanList();
        dispjimutetuzukinmOptionBeanList.add(pDispjimutetuzukinmOptionBeanList);
    }

    public void clearDispjimutetuzukinmOptionBeanList() {
        dispjimutetuzukinmOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> dispsyoruinmsntkOptionBeanList = new LoopChain<>();
    public UserDefsList getDispsyoruinmsntkOptionBeanList() {
        return dispsyoruinmsntkOptionBeanList.get();
    }

    public void setDispsyoruinmsntkOptionBeanList(UserDefsList pDispsyoruinmsntkOptionBeanList) {
        clearDispsyoruinmsntkOptionBeanList();
        dispsyoruinmsntkOptionBeanList.add(pDispsyoruinmsntkOptionBeanList);
    }

    public void clearDispsyoruinmsntkOptionBeanList() {
        dispsyoruinmsntkOptionBeanList.clear();
    }
}
