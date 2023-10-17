package yuyu.app.sinkeiyaku.skmousikomi.skmosqrsksyoyaku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * 申込書類用QR作成予約 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkMosQRSksYoyakuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<YoyakuInfoListDataSourceBean> yoyakuInfoListDataSource = new DataSource<>();
    public DataSource<YoyakuInfoListDataSourceBean> getYoyakuInfoListDataSource() {
        return yoyakuInfoListDataSource;
    }

    @Deprecated
    public List<YoyakuInfoListDataSourceBean> getYoyakuInfoList() {
        return yoyakuInfoListDataSource.getDatas();
    }

    public void setYoyakuInfoList(List<YoyakuInfoListDataSourceBean> pYoyakuInfoList) {
        yoyakuInfoListDataSource.setDatas(pYoyakuInfoList);
    }

    private C_SkeijimuKbn skeijimukbn;

    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    private String hknsyuruinm;

    public String getHknsyuruinm() {
        return hknsyuruinm;
    }

    public void setHknsyuruinm(String pHknsyuruinm) {
        hknsyuruinm = pHknsyuruinm;
    }

    private C_MosnoSaibanKbn mosnosaibankbn;

    public C_MosnoSaibanKbn getMosnosaibankbn() {
        return mosnosaibankbn;
    }

    public void setMosnosaibankbn(C_MosnoSaibanKbn pMosnosaibankbn) {
        mosnosaibankbn = pMosnosaibankbn;
    }

    @Range(min="0", max="99999")
    private Integer sakuseikensuu;

    public Integer getSakuseikensuu() {
        return sakuseikensuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakuseikensuu(Integer pSakuseikensuu) {
        sakuseikensuu = pSakuseikensuu;
    }

    private LoopChain<UserDefsList> hknsyuruinmOptionBeanList = new LoopChain<>();
    public UserDefsList getHknsyuruinmOptionBeanList() {
        return hknsyuruinmOptionBeanList.get();
    }

    public void setHknsyuruinmOptionBeanList(UserDefsList pHknsyuruinmOptionBeanList) {
        clearHknsyuruinmOptionBeanList();
        hknsyuruinmOptionBeanList.add(pHknsyuruinmOptionBeanList);
    }

    public void clearHknsyuruinmOptionBeanList() {
        hknsyuruinmOptionBeanList.clear();
    }
}
