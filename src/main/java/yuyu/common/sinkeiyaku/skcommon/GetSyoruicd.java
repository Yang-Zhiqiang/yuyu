package yuyu.common.sinkeiyaku.skcommon;

import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 新契約 新契約共通 書類コード取得
 */
public class GetSyoruicd {

    private C_SyoruiCdKbn[]     syoruiCds                   = null;

    private C_SyoruiCdKbn       syoruiCd                    = C_SyoruiCdKbn.BLNK;

    private int                 syoruiCdIndex               = 0;

    public GetSyoruicd(){
        super();
    }

    public C_SyoruiCdKbn getSyoruicd_Jmrnrkhyou() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_JIMURENRAKU;

        return syoruiCd;
    }

    public int getSyoruicd_Jmrnrkhyou_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Hubituuti() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_HUBITUUTI;

        return syoruiCd;
    }

    public int getSyoruicd_Hubituuti_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Kykkakkuniniraisyo() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO;

        return syoruiCd;
    }

    public int getSyoruicd_Kykkakkuniniraisyo_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Yuukoukknkeikaykk() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_YUUKOUKKNYOKOKULIST;

        return syoruiCd;
    }

    public int getSyoruicd_Yuukoukknkeikaykk_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Yuukoukknkeikatyouka() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_YUUKOUKKNTYOUKALIST;

        return syoruiCd;
    }

    public int getSyoruicd_Yuukoukknkeikatyouka_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Trksseikyu() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_TRKSSEIKYU;

        return syoruiCd;
    }

    public C_SyoruiCdKbn getSyoruicd_Trksseikyu_souhu() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU;

        return syoruiCd;
    }

    public C_SyoruiCdKbn[] getSyoruicd_Trksseikyu_set() {

        wkClear();

        syoruiCds = new C_SyoruiCdKbn[2];

        syoruiCds[0] = C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU;
        syoruiCds[1] = C_SyoruiCdKbn.SK_TRKSSEIKYU;

        return syoruiCds;
    }

    public int getSyoruicd_Trksseikyu_idx() {

        wkClear();

        syoruiCdIndex = 1;

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Kykhuseiritu() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_KYKHUSEIRITU;

        return syoruiCd;
    }

    public int getSyoruicd_Kykhuseiritu_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Sakujyokykmeisailist() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST;

        return syoruiCd;
    }

    public int getSyoruicd_Sakujyokykmeisailist_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Jnyknmeisailist() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST;

        return syoruiCd;
    }

    public int getSyoruicd_Jnyknmeisailist_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Dai1hknryittilist() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_1PNYKNITTILIST;

        return syoruiCd;
    }

    public int getSyoruicd_Dai1hknryittilist_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Nykninfohuittikakninsyo() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_NYKJYOUHOUHUITTIKAKSYO;

        return syoruiCd;
    }

    public int getSyoruicd_Nykninfohuittikakninsyo_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Mossouhujklst() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_MOSSOUHUJYOUKYOULIST;

        return syoruiCd;
    }

    public int getSyoruicd_Mossouhujklst_idx() {

        wkClear();

        syoruiCdIndex = 1;

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Mosmttkikankeikalist() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_MOSMITOUTYAKUKKNLIST;

        return syoruiCd;
    }

    public int getSyoruicd_Mosmttkikankeikalist_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Henkiniraisyo() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_HENKINIRAISYO;

        return syoruiCd;
    }

    public int getSyoruicd_Henkiniraisyo_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Henkintuuti() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_HENKINTUUTILIST;

        return syoruiCd;
    }

    public int getSyoruicd_Henkintuuti_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Handkarikanjyou () {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_HANDKARIKANJYOU;

        return syoruiCd;
    }

    public int getSyoruicd_Handkarikanjyou_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    public C_SyoruiCdKbn getSyoruicd_Henkinmisyorilist() {

        wkClear();

        syoruiCd = C_SyoruiCdKbn.SK_HENKINMISYORILIST;

        return syoruiCd;
    }

    public int getSyoruicd_Henkinmisyorilist_idx() {

        wkClear();

        return syoruiCdIndex;
    }

    private void wkClear() {

        syoruiCds = null;
        syoruiCd = C_SyoruiCdKbn.BLNK;
        syoruiCdIndex = 0;
    }
}