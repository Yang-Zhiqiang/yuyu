package yuyu.common.siharai.siview.viewtratkihuryouhusyoujiken;

import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;

/**
 * 保険金給付金支払 支払画面部品 取扱不良・不詳事件等クラス <br />
 */
public class ViewTratkihuryouHusyoujikenUiBeanParamImpl implements ViewTratkihuryouHusyoujikenUiBeanParam{

    private C_NoinitUmuKbn tratkihuryouumukbn;

    private C_NoinitYouhiKbn gyousinkaisouyouhikbn;

    private C_NoinitSyorizumiKbn aireqdaityoukisaikbn;

    private String tratkihuryoucomment;

    private boolean viewTratkihuryouHusyoujikenInputDispFlg;

    private boolean viewTratkihuryouHusyoujikenFlg;

    private boolean viewTratkihuryouHusyoujikenSeigyo;

    private boolean viewTratkihuryouHusyoujikenDispFlg;


    @Override
    public C_NoinitUmuKbn getTratkihuryouumukbn() {
        return tratkihuryouumukbn;
    }

    @Override
    public void setTratkihuryouumukbn(C_NoinitUmuKbn pTratkihuryouumukbn) {
        tratkihuryouumukbn = pTratkihuryouumukbn;
    }

    @Override
    public C_NoinitYouhiKbn getGyousinkaisouyouhikbn() {
        return gyousinkaisouyouhikbn;
    }

    @Override
    public void setGyousinkaisouyouhikbn(C_NoinitYouhiKbn pGyousinkaisouyouhikbn) {
        gyousinkaisouyouhikbn = pGyousinkaisouyouhikbn;
    }

    @Override
    public C_NoinitSyorizumiKbn getAireqdaityoukisaikbn() {
        return aireqdaityoukisaikbn;
    }

    @Override
    public void setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn pAireqdaityoukisaikbn) {
        aireqdaityoukisaikbn = pAireqdaityoukisaikbn;
    }

    @Override
    public String getTratkihuryoucomment() {
        return tratkihuryoucomment;
    }

    @Override
    public void setTratkihuryoucomment(String pTratkihuryoucomment) {
        tratkihuryoucomment = pTratkihuryoucomment;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenInputDispFlg() {
        return viewTratkihuryouHusyoujikenInputDispFlg;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenFlg() {
        return viewTratkihuryouHusyoujikenFlg;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenSeigyo() {
        return viewTratkihuryouHusyoujikenSeigyo;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenDispFlg() {
        return viewTratkihuryouHusyoujikenDispFlg;
    }
}
