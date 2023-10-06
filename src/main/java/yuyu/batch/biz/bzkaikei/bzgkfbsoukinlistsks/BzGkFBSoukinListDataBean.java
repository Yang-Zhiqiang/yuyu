package yuyu.batch.biz.bzkaikei.bzgkfbsoukinlistsks;

import java.io.Serializable;

import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;

/**
 * 外貨ＦＢ送金リスト用データBEAN（宛先不明）クラスです。<br />
 */
public class BzGkFBSoukinListDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public BzGkFBSoukinListDataBean() {
    }

    private BT_GkFBSoukinData btGkFBSoukinData;

    public BT_GkFBSoukinData getBtGkFBSoukinData() {
        return btGkFBSoukinData;
    }

    public void setBtGkFBSoukinData(BT_GkFBSoukinData pBtGkFBSoukinData) {
        this.btGkFBSoukinData = pBtGkFBSoukinData;
    }

    private BT_GkFBSoukinHukaInfo btGkFBSoukinHukaInfo;

    public BT_GkFBSoukinHukaInfo getBtGkFBSoukinHukaInfo() {
        return btGkFBSoukinHukaInfo;
    }

    public void setBtGkFBSoukinHukaInfo(BT_GkFBSoukinHukaInfo pBtGkFBSoukinHukaInfo) {
        this.btGkFBSoukinHukaInfo = pBtGkFBSoukinHukaInfo;
    }

    private BM_FBSoukinListKanri bmFBSoukinListKanri;

    public BM_FBSoukinListKanri getBmFBSoukinListKanri() {
        return bmFBSoukinListKanri;
    }

    public void setBmFBSoukinListKanri(BM_FBSoukinListKanri pBmFBSoukinListKanri) {
        this.bmFBSoukinListKanri = pBmFBSoukinListKanri;
    }

    private String syorisosikiCd;

    public String getSyorisosikiCd() {
        return syorisosikiCd;
    }

    public void setSyorisosikiCd(String pSyorisosikiCd) {
        this.syorisosikiCd = pSyorisosikiCd;
    }

}
