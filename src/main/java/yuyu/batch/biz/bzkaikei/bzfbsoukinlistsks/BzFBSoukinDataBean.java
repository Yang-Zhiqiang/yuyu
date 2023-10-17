package yuyu.batch.biz.bzkaikei.bzfbsoukinlistsks;

import java.io.Serializable;

import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;

/**
 * ＦＢ送金リストソート用BEANクラスです<br />
 */
public class BzFBSoukinDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BT_FBSoukinData btFBSoukinData_;

    public BT_FBSoukinData getFBSoukinData() {
        return btFBSoukinData_;
    }

    public void setFBSoukinData(BT_FBSoukinData pbtFBSoukinData) {
        btFBSoukinData_ = pbtFBSoukinData;
    }

    private BT_FBSoukinHukaInfo btFBSoukinHukaInfo_;

    public BT_FBSoukinHukaInfo getFBSoukinHukaInfo() {
        return btFBSoukinHukaInfo_;
    }

    public void setFBSoukinHukaInfo(BT_FBSoukinHukaInfo pbtFBSoukinHukaInfo) {
        btFBSoukinHukaInfo_ = pbtFBSoukinHukaInfo;
    }

    private BM_FBSoukinListKanri bmFBSoukinListKanri_;

    public BM_FBSoukinListKanri getFBSoukinListKanri() {
        return bmFBSoukinListKanri_;
    }

    public void setFBSoukinListKanri(BM_FBSoukinListKanri pbmFBSoukinListKanri) {
        bmFBSoukinListKanri_ = pbmFBSoukinListKanri;
    }

    private BzFBSoukinDataBean bzFBSoukinDataBean;

    public BzFBSoukinDataBean getFBSoukinDataBean() {
        return bzFBSoukinDataBean;
    }

    public void setFBSoukinDataBean(BzFBSoukinDataBean pbzFBSoukinDataBean) {
        bzFBSoukinDataBean = pbzFBSoukinDataBean;
    }

    private String soukinHukaBank_;

    public String getSoukinHukaBank() {
        return soukinHukaBank_;
    }

    public void setSoukinHukaBank(String pSoukinHukaBank) {
        soukinHukaBank_ = pSoukinHukaBank;
    }

}
