package yuyu.common.siharai.siview.viewsateikaisouyouhisibou;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 保険金給付金支払 支払画面部品 査定回送要否確認（死亡） <br />
 */
public interface ViewSateikaisouyouhiSibouUiBeanParam extends CommonViewUiBeanParam {

    public Boolean getSateikaksaigaikanousei();

    public void setSateikaksaigaikanousei(Boolean pSateikaksaigaikanousei);

    public C_UmuKbn getSateikaksaigaikanouseikbn();

    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn);

    public Boolean getSateikakmeigihnk();

    public void setSateikakmeigihnk(Boolean pSateikakmeigihnk);

    public C_YouhiKbn getSateikakmeigihnkkbn();

    public void setSateikakmeigihnkkbn(C_YouhiKbn pSateikakmeigihnkkbn);

    public Boolean getSateikakkaigaisb();

    public void setSateikakkaigaisb(Boolean pSateikakkaigaisb);

    public C_UmuKbn getSateikakkaigaisbkbn();

    public void setSateikakkaigaisbkbn(C_UmuKbn pSateikakkaigaisbkbn);

    public Boolean getSateikakhusyousi();

    public void setSateikakhusyousi(Boolean pSateikakhusyousi);

    public C_UmuKbn getSateikakhusyousikbn();

    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn);

    public boolean isViewSateikaisouyouhiSibouSeigyo();

    public boolean isViewSateikaisouyouhiSibouDispFlg();
}
