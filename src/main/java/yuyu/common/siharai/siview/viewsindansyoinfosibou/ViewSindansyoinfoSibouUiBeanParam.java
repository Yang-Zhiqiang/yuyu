package yuyu.common.siharai.siview.viewsindansyoinfosibou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SibouBasyoKbn;

/**
 * 保険金給付金支払 支払画面部品 診断書情報（死亡） <br />
 */
public interface ViewSindansyoinfoSibouUiBeanParam extends CommonViewUiBeanParam {

    public DataSource<?> getViewSindansyoinfoSibouInfo1DataSource();

    public C_GeninKbn getGeninkbn();

    public void setGeninkbn(C_GeninKbn pGeninkbn);

    public BizDate getSibouymd();

    public void setSibouymd(BizDate pSibouymd);

    public C_SibouBasyoKbn getSiboubasyokbn();

    public void setSiboubasyokbn(C_SibouBasyoKbn pSiboubasyokbn);

    public String getSiboubasyo();

    public void setSiboubasyo(String pSiboubasyo);

    public boolean isViewSindansyoinfoSibouInputDispFlg();

    public boolean isViewSindansyoinfoSibouSeigyo();

    public boolean isViewSindansyoinfoSibouDispFlg();
}
