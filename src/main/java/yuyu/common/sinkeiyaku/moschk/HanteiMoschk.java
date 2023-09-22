package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteirirituhendouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;

/**
 * 新契約 申込内容チェック 申込内容チェック実施要否判定
 */
public class HanteiMoschk {

    public HanteiMoschk() {
        super();
    }

    public C_BlnktkumuKbn hanteiSpCheckKingakuSouiJissiyouhi(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList, HT_MosKihon pMosKihon) {

        if (pSyouhnZokuseiSyu == null) {
            return C_BlnktkumuKbn.BLNK;
        }
        else if (pMosKihon == null) {
            return C_BlnktkumuKbn.BLNK;
        }
        return C_BlnktkumuKbn.ARI;
    }

    public C_YouhiKbn hanteiKykNenreiUpSekininkaisiNasiTyuui(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList, HT_MosKihon pMosKihon) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            return C_YouhiKbn.YOU;
        }

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            return C_YouhiKbn.YOU;
        }

        if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            return C_YouhiKbn.YOU;
        }

        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            if (C_Hrkkaisuu.TUKI.eq(pMosKihon.getHrkkaisuu())) {
                return C_YouhiKbn.YOU;
            }
            return C_YouhiKbn.HUYOU;
        }
        return C_YouhiKbn.HUYOU;
    }

    public C_YouhiKbn hanteiKykNenreiUpSekininkaisiNasiKeikoku(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList, HT_MosKihon pMosKihon) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            return C_YouhiKbn.YOU;
        }

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            return C_YouhiKbn.YOU;
        }

        if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            return C_YouhiKbn.YOU;
        }

        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            if (C_Hrkkaisuu.TUKI.eq(pMosKihon.getHrkkaisuu())) {
                return C_YouhiKbn.YOU;
            }
            return C_YouhiKbn.HUYOU;
        }

        return C_YouhiKbn.HUYOU;
    }

    public C_YouhiKbn hanteiYoteirirituHendouGetYoteiriritu(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        return hanteiYoteirirituHendouYoteirirituUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);

    }

    public C_YouhiKbn hanteiYoteirirituHendouGetTumitateriritu(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        C_YouhiKbn youhiKbn = hanteiYoteirirituHendouTumitaterirituUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);

        if (C_YouhiKbn.YOU.eq(youhiKbn)) {
            return C_YouhiKbn.YOU;
        }

        youhiKbn = hanteiYoteirirituHendouTumitatekinZoukarituJyougenUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);

        if (C_YouhiKbn.YOU.eq(youhiKbn)) {
            return C_YouhiKbn.YOU;
        }

        youhiKbn = hanteiYoteirirituHendouSetteibairituUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);

        if (C_YouhiKbn.YOU.eq(youhiKbn)) {
            return C_YouhiKbn.YOU;
        }

        youhiKbn = hanteiYoteirirituHendouRendourituUpDown(pSyouhnZokuseiSyu, pSyouhnZokuseiTkList);

        return youhiKbn;

    }

    public C_YouhiKbn hanteiYoteirirituHendouYoteirirituUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        if (!C_YoteirirituhendouKbn.NONE.eq(pSyouhnZokuseiSyu.getYoteirirituhendoukbn())) {

            int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
                return C_YouhiKbn.YOU;
            }

            if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                return C_YouhiKbn.YOU;
            }

            if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                return C_YouhiKbn.YOU;
            }
        }

        return C_YouhiKbn.HUYOU;

    }

    public C_YouhiKbn hanteiYoteirirituHendouTumitaterirituUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        if (!C_YoteirirituhendouKbn.NONE.eq(pSyouhnZokuseiSyu.getYoteirirituhendoukbn())) {

            int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                return C_YouhiKbn.YOU;
            }
        }

        return C_YouhiKbn.HUYOU;

    }

    public C_YouhiKbn hanteiYoteirirituHendouTumitatekinZoukarituJyougenUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        if (!C_YoteirirituhendouKbn.NONE.eq(pSyouhnZokuseiSyu.getYoteirirituhendoukbn())) {

            int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                return C_YouhiKbn.YOU;
            }
        }

        return C_YouhiKbn.HUYOU;

    }

    public C_YouhiKbn hanteiYoteirirituHendouSetteibairituUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        if (!C_YoteirirituhendouKbn.NONE.eq(pSyouhnZokuseiSyu.getYoteirirituhendoukbn())) {

            int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                return C_YouhiKbn.YOU;
            }
        }

        return C_YouhiKbn.HUYOU;

    }

    public C_YouhiKbn hanteiYoteirirituHendouRendourituUpDown(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        if (!C_YoteirirituhendouKbn.NONE.eq(pSyouhnZokuseiSyu.getYoteirirituhendoukbn())) {

            int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                return C_YouhiKbn.YOU;
            }
        }

        return C_YouhiKbn.HUYOU;
    }

    public C_YouhiKbn hanteiSueokiKikan(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        if (C_UmuKbn.ARI.eq(pSyouhnZokuseiSyu.getNkhknumu())) {
            return C_YouhiKbn.YOU;
        }

        return C_YouhiKbn.HUYOU;

    }

    public C_YouhiKbn hanteiItijiSaikouP(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());
        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
            return C_YouhiKbn.YOU;
        }
        return C_YouhiKbn.HUYOU;
    }

    public C_YouhiKbn hanteiMosSyouhnSaiteiP(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            return C_YouhiKbn.HUYOU;
        }

        return C_YouhiKbn.YOU;
    }

    public C_YouhiKbn hanteiSpSaikouS(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        if (C_UmuKbn.ARI.eq(pSyouhnZokuseiSyu.getPdumu())) {

            int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                return C_YouhiKbn.YOU;
            }

            if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                return C_YouhiKbn.YOU;
            }
        }

        return C_YouhiKbn.HUYOU;
    }

    public C_YouhiKbn hanteiSpSaiteiS(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        if (C_UmuKbn.ARI.eq(pSyouhnZokuseiSyu.getPdumu())) {

            int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokuseiSyu.getSyouhncd());

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                return C_YouhiKbn.YOU;
            }
        }

        return C_YouhiKbn.HUYOU;
    }

    public C_YouhiKbn hanteiSpSaikouNenkinGensiGendo(BM_SyouhnZokusei pSyouhnZokuseiSyu,
        List<BM_SyouhnZokusei> pSyouhnZokuseiTkList) {

        if (pSyouhnZokuseiSyu == null) {
            return C_YouhiKbn.HUYOU;
        }

        if (C_UmuKbn.ARI.eq(pSyouhnZokuseiSyu.getNkhknumu()) &&
            C_UmuKbn.ARI.eq(pSyouhnZokuseiSyu.getNkgnstuusanumu())) {
            return C_YouhiKbn.YOU;
        }

        return C_YouhiKbn.HUYOU;

    }
}
