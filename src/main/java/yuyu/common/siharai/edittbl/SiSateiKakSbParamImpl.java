package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定回送要否確認（死亡）Paramインターフェース実装クラス
 */
public class SiSateiKakSbParamImpl implements SiSateiKakSbParam {

    private C_UmuKbn sateikaksaigaikanouseikbn;

    private C_YouhiKbn sateikakmeigihnkkbn;

    private C_UmuKbn sateikakkaigaisbkbn;

    private C_UmuKbn sateikakhusyousikbn;

    @Override
    public C_UmuKbn getSateikaksaigaikanouseikbn() {
        return sateikaksaigaikanouseikbn;
    }

    @Override
    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn) {
        sateikaksaigaikanouseikbn = pSateikaksaigaikanouseikbn;
    }

    @Override
    public C_YouhiKbn getSateikakmeigihnkkbn() {
        return sateikakmeigihnkkbn;
    }

    @Override
    public void setSateikakmeigihnkkbn(C_YouhiKbn pSateikakmeigihnkkbn) {
        sateikakmeigihnkkbn = pSateikakmeigihnkkbn;
    }

    @Override
    public C_UmuKbn getSateikakkaigaisbkbn() {
        return sateikakkaigaisbkbn;
    }

    @Override
    public void setSateikakkaigaisbkbn(C_UmuKbn pSateikakkaigaisbkbn) {
        sateikakkaigaisbkbn = pSateikakkaigaisbkbn;
    }

    @Override
    public C_UmuKbn getSateikakhusyousikbn() {
        return sateikakhusyousikbn;
    }

    @Override
    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn) {
        sateikakhusyousikbn = pSateikakhusyousikbn;
    }
}
