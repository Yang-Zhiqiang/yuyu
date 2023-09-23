package yuyu.common.siharai.siview.viewsknaiyou;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;

/**
 * 保険金給付金支払 支払画面部品 請求内容表示 <br />
 */
public interface ViewSknaiyouUiBeanParam extends CommonViewUiBeanParam{

    public C_SUketoriHouhouKbn getSuketorihouhoukbn();

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn);

    public C_SiharaiTuukaKbn getSiharaituukakbn();

    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn);

    public boolean isViewSknaiyouSeigyo();

    public boolean isViewSknaiyouDispFlg();
}
