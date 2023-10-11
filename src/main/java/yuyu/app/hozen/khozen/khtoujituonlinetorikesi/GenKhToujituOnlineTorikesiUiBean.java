package yuyu.app.hozen.khozen.khtoujituonlinetorikesi;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全当日オンライン取消 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhToujituOnlineTorikesiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

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

    private String trkskinouid;

    public String getTrkskinouid() {
        return trkskinouid;
    }

    public void setTrkskinouid(String pTrkskinouid) {
        trkskinouid = pTrkskinouid;
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
    }

    private LoopChain<UserDefsList> trkskinouidOptionBeanList = new LoopChain<>();
    public UserDefsList getTrkskinouidOptionBeanList() {
        return trkskinouidOptionBeanList.get();
    }

    public void setTrkskinouidOptionBeanList(UserDefsList pTrkskinouidOptionBeanList) {
        clearTrkskinouidOptionBeanList();
        trkskinouidOptionBeanList.add(pTrkskinouidOptionBeanList);
    }

    public void clearTrkskinouidOptionBeanList() {
        trkskinouidOptionBeanList.clear();
    }
}
