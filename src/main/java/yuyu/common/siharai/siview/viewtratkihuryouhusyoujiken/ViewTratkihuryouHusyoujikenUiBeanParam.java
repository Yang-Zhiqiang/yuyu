package yuyu.common.siharai.siview.viewtratkihuryouhusyoujiken;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;

/**
 * 保険金給付金支払 支払画面部品 取扱不良・不詳事件等 <br />
 */
public interface ViewTratkihuryouHusyoujikenUiBeanParam extends CommonViewUiBeanParam {

    public C_NoinitUmuKbn getTratkihuryouumukbn();

    public void setTratkihuryouumukbn(C_NoinitUmuKbn pTratkihuryouumukbn);

    public C_NoinitYouhiKbn getGyousinkaisouyouhikbn();

    public void setGyousinkaisouyouhikbn(C_NoinitYouhiKbn pGyousinkaisouyouhikbn);

    public C_NoinitSyorizumiKbn getAireqdaityoukisaikbn();

    public void setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn pAireqdaityoukisaikbn);

    public String getTratkihuryoucomment();

    public void setTratkihuryoucomment(String pTratkihuryoucomment);

    public boolean isViewTratkihuryouHusyoujikenInputDispFlg();

    public boolean isViewTratkihuryouHusyoujikenFlg();

    public boolean isViewTratkihuryouHusyoujikenSeigyo();

    public boolean isViewTratkihuryouHusyoujikenDispFlg();
}
