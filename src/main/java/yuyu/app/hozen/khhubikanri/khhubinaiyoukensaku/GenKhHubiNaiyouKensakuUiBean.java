package yuyu.app.hozen.khhubikanri.khhubinaiyoukensaku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_KensakuyouGenponHnkykumu;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 契約保全不備内容検索 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhHubiNaiyouKensakuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<FubinaiyouListDataSourceBean> fubinaiyouListDataSource = new DataSource<>();
    public DataSource<FubinaiyouListDataSourceBean> getFubinaiyouListDataSource() {
        return fubinaiyouListDataSource;
    }

    @Deprecated
    public List<FubinaiyouListDataSourceBean> getFubinaiyouList() {
        return fubinaiyouListDataSource.getDatas();
    }

    public void setFubinaiyouList(List<FubinaiyouListDataSourceBean> pFubinaiyouList) {
        fubinaiyouListDataSource.setDatas(pFubinaiyouList);
    }

    private String jimuttdknm;

    public String getJimuttdknm() {
        return jimuttdknm;
    }

    public void setJimuttdknm(String pJimuttdknm) {
        jimuttdknm = pJimuttdknm;
    }

    private String dispsyoruinmsntk;

    public String getDispsyoruinmsntk() {
        return dispsyoruinmsntk;
    }

    public void setDispsyoruinmsntk(String pDispsyoruinmsntk) {
        dispsyoruinmsntk = pDispsyoruinmsntk;
    }

    private C_HassinsakiKbn hassinsakikbn;

    public C_HassinsakiKbn getHassinsakikbn() {
        return hassinsakikbn;
    }

    public void setHassinsakikbn(C_HassinsakiKbn pHassinsakikbn) {
        hassinsakikbn = pHassinsakikbn;
    }

    private C_KensakuyouGenponHnkykumu kensakuyougenponhnkykumu;

    public C_KensakuyouGenponHnkykumu getKensakuyougenponhnkykumu() {
        return kensakuyougenponhnkykumu;
    }

    public void setKensakuyougenponhnkykumu(C_KensakuyouGenponHnkykumu pKensakuyougenponhnkykumu) {
        kensakuyougenponhnkykumu = pKensakuyougenponhnkykumu;
    }

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String khhubinaiyou;

    public String getKhhubinaiyou() {
        return khhubinaiyou;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKhhubinaiyou(String pKhhubinaiyou) {
        khhubinaiyou = pKhhubinaiyou;
    }

    private LoopChain<UserDefsList> jimuttdknmOptionBeanList = new LoopChain<>();
    public UserDefsList getJimuttdknmOptionBeanList() {
        return jimuttdknmOptionBeanList.get();
    }

    public void setJimuttdknmOptionBeanList(UserDefsList pJimuttdknmOptionBeanList) {
        clearJimuttdknmOptionBeanList();
        jimuttdknmOptionBeanList.add(pJimuttdknmOptionBeanList);
    }

    public void clearJimuttdknmOptionBeanList() {
        jimuttdknmOptionBeanList.clear();
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
