package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 売上請求中止
 */
public class UriageTyuusi {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public UriageTyuusi() {
        super();
    }

    public C_ErrorKbn exec(String pSyoNo, String pUserID, String pKosTime) {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pSyoNo);
        if (syoriCTL == null) {
            return C_ErrorKbn.ERROR;
        }
        syoriCTL.setUriagesousinkbn(C_UriagesousinKbn.BLNK);
        syoriCTL.setGyoumuKousinsyaId(pUserID);
        syoriCTL.setGyoumuKousinTime(pKosTime);

        sinkeiyakuDomManager.update(syoriCTL);

        return C_ErrorKbn.OK;
    }
}
