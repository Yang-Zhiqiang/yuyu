package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定回送要否確認（死亡）Paramインターフェース
 */
public interface SiSateiKakSbParam {

    public C_UmuKbn getSateikaksaigaikanouseikbn();

    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn);

    public C_YouhiKbn getSateikakmeigihnkkbn();

    public void setSateikakmeigihnkkbn(C_YouhiKbn pSateikakmeigihnkkbn);

    public C_UmuKbn getSateikakkaigaisbkbn();

    public void setSateikakkaigaisbkbn(C_UmuKbn pSateikakkaigaisbkbn);

    public C_UmuKbn getSateikakhusyousikbn();

    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn);

}
