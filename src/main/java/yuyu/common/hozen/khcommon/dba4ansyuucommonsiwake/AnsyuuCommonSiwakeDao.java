package yuyu.common.hozen.khcommon.dba4ansyuucommonsiwake;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 案内収納用仕訳共通処理Daoクラス
 */
public class AnsyuuCommonSiwakeDao {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public BM_TantouCd getTantouCd(C_TantouCdKbn pTantocd) {
        return bizDomManager.getTantouCd(pTantocd);
    }

    public List<IT_KykSyouhn> getKykSyouhn(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        List<IT_KykSyouhn> itKykSyouhnLst = null;

        if (kykKihon != null) {
            itKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        }

        return itKykSyouhnLst;
    }

}
