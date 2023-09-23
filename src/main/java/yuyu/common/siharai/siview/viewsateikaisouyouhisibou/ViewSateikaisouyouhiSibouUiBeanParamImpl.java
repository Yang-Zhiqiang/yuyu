package yuyu.common.siharai.siview.viewsateikaisouyouhisibou;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 保険金給付金支払 支払画面部品 査定回送要否確認（死亡）クラス <br />
 */
public class ViewSateikaisouyouhiSibouUiBeanParamImpl implements ViewSateikaisouyouhiSibouUiBeanParam{

    private Boolean sateikaksaigaikanousei;

    private C_UmuKbn sateikaksaigaikanouseikbn;

    private Boolean sateikakmeigihnk;

    private C_YouhiKbn sateikakmeigihnkkbn;

    private Boolean sateikakkaigaisb;

    private C_UmuKbn sateikakkaigaisbkbn;

    private Boolean sateikakhusyousi;

    private C_UmuKbn sateikakhusyousikbn;

    private boolean viewSateikaisouyouhiSibouSeigyo;

    private boolean viewSateikaisouyouhiSibouDispFlg;

    @Override
    public Boolean getSateikaksaigaikanousei() {
        return (sateikaksaigaikanousei == null) ? Boolean.FALSE : sateikaksaigaikanousei;
    }

    @Override
    public void setSateikaksaigaikanousei(Boolean pSateikaksaigaikanousei) {
        sateikaksaigaikanousei = (pSateikaksaigaikanousei == null) ? Boolean.FALSE : pSateikaksaigaikanousei;
    }

    @Override
    public C_UmuKbn getSateikaksaigaikanouseikbn() {
        return sateikaksaigaikanouseikbn;
    }

    @Override
    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn) {

        boolean sateikaksaigaikanouseiFlg = false;

        if (C_UmuKbn.ARI.eq(pSateikaksaigaikanouseikbn)) {
            sateikaksaigaikanouseiFlg = true;
        }

        this.setSateikaksaigaikanousei(sateikaksaigaikanouseiFlg);

        sateikaksaigaikanouseikbn = pSateikaksaigaikanouseikbn;
    }

    @Override
    public Boolean getSateikakmeigihnk() {
        return (sateikakmeigihnk == null) ? Boolean.FALSE : sateikakmeigihnk;
    }

    @Override
    public void setSateikakmeigihnk(Boolean pSateikakmeigihnk) {
        sateikakmeigihnk = (pSateikakmeigihnk == null) ? Boolean.FALSE : pSateikakmeigihnk;
    }

    @Override
    public C_YouhiKbn getSateikakmeigihnkkbn() {
        return sateikakmeigihnkkbn;
    }

    @Override
    public void setSateikakmeigihnkkbn(C_YouhiKbn pSateikakmeigihnkkbn) {

        boolean sateikakmeigihnkFlg = false;

        if (C_YouhiKbn.YOU.eq(pSateikakmeigihnkkbn)) {
            sateikakmeigihnkFlg = true;
        }

        this.setSateikakmeigihnk(sateikakmeigihnkFlg);

        sateikakmeigihnkkbn = pSateikakmeigihnkkbn;
    }

    @Override
    public Boolean getSateikakkaigaisb() {
        return (sateikakkaigaisb == null) ? Boolean.FALSE : sateikakkaigaisb;
    }

    @Override
    public void setSateikakkaigaisb(Boolean pSateikakkaigaisb) {
        sateikakkaigaisb = (pSateikakkaigaisb == null) ? Boolean.FALSE : pSateikakkaigaisb;
    }

    @Override
    public C_UmuKbn getSateikakkaigaisbkbn() {
        return sateikakkaigaisbkbn;
    }

    @Override
    public void setSateikakkaigaisbkbn(C_UmuKbn pSateikakkaigaisbkbn) {

        boolean sateikakkaigaisbFlg = false;

        if (C_UmuKbn.ARI.eq(pSateikakkaigaisbkbn)) {
            sateikakkaigaisbFlg = true;
        }

        this.setSateikakkaigaisb(sateikakkaigaisbFlg);

        sateikakkaigaisbkbn = pSateikakkaigaisbkbn;
    }

    @Override
    public Boolean getSateikakhusyousi() {
        return (sateikakhusyousi == null) ? Boolean.FALSE : sateikakhusyousi;
    }

    @Override
    public void setSateikakhusyousi(Boolean pSateikakhusyousi) {
        sateikakhusyousi = (pSateikakhusyousi == null) ? Boolean.FALSE : pSateikakhusyousi;
    }

    @Override
    public C_UmuKbn getSateikakhusyousikbn() {
        return sateikakhusyousikbn;
    }

    @Override
    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn) {

        boolean sateikakhusyousiFlg = false;

        if (C_UmuKbn.ARI.eq(pSateikakhusyousikbn)) {
            sateikakhusyousiFlg = true;
        }

        this.setSateikakhusyousi(sateikakhusyousiFlg);

        sateikakhusyousikbn = pSateikakhusyousikbn;
    }

    @Override
    public boolean isViewSateikaisouyouhiSibouSeigyo() {
        return viewSateikaisouyouhiSibouSeigyo;
    }

    @Override
    public boolean isViewSateikaisouyouhiSibouDispFlg() {
        return viewSateikaisouyouhiSibouDispFlg;
    }
}
