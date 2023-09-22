package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 差異データ取得
 */
public class SaiDataSyutoku {

    public static final int SYUTOKUDATA_ARI = 0;
    public static final int SYUTOKUDATA_NASI = -1;

    private List<String> nrksouikmLst = new ArrayList<>();
    private List<String> itijinrkLst = new ArrayList<>();
    private List<String> nijinrkLst = new ArrayList<>();

    @Inject
    private SinkeiyakuDomManager manager;

    public SaiDataSyutoku() {
        super();
    }

    public List<String> getNrksouikmList() {
        return nrksouikmLst;
    }

    public List<String> getItijinrkList() {
        return itijinrkLst;
    }

    public List<String> getNijinrkList() {
        return nijinrkLst;
    }

    public int findSaiData(String pMosno, String pVrfKinouId) {

        List<HT_NrkDif> nrkDifLst = manager.getSyoriCTL(pMosno).getNrkDifsByVrfkinouid(pVrfKinouId);

        if (nrkDifLst == null || nrkDifLst.size() == 0) {

            return SYUTOKUDATA_NASI;
        }

        for (HT_NrkDif nrkDif : nrkDifLst) {

            nrksouikmLst.add(nrkDif.getNrksouikm());
            itijinrkLst.add(nrkDif.getItijinyuuroku());
            nijinrkLst.add(nrkDif.getNijinyrk());
        }

        return SYUTOKUDATA_ARI;
    }
}