package yuyu.common.siharai.siview.viewsinkensya;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_SkskknsyubetuKbn;

/**
 * 保険金給付金支払 支払画面部品 親権者後見人情報表示 <br />
 */
public interface ViewSinkensyaUiBeanParam extends CommonViewUiBeanParam{

    public String getSkskknnmkn();

    public void setSkskknnmkn(String pSkskknnmkn);

    public String getSkskknnmkj();

    public void setSkskknnmkj(String pSkskknnmkj);

    public C_SkskknsyubetuKbn getSkskknsyubetu();

    public void setSkskknsyubetu(C_SkskknsyubetuKbn pSkskknsyubetu);

    public boolean isViewSinkensyaSeigyo();

    public boolean isViewSinkensyaDispFlg();

    public boolean isViewSinkensyaHyouji();
}
