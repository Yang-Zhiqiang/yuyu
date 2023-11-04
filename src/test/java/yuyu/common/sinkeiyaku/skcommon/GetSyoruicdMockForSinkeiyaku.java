package yuyu.common.sinkeiyaku.skcommon;

import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * {@link GetSyoruicd}のモッククラスです。<br />
 */
public class GetSyoruicdMockForSinkeiyaku extends GetSyoruicd {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_SyoruiCdKbn getSyoruicd_Jmrnrkhyou() {

        return super.getSyoruicd_Jmrnrkhyou();
    }

    @Override
    public int getSyoruicd_Jmrnrkhyou_idx() {

        return super.getSyoruicd_Jmrnrkhyou_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Hubituuti() {

        return super.getSyoruicd_Hubituuti();
    }

    @Override
    public int getSyoruicd_Hubituuti_idx() {

        return super.getSyoruicd_Hubituuti_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Kykkakkuniniraisyo() {

        return super.getSyoruicd_Kykkakkuniniraisyo();
    }

    @Override
    public int getSyoruicd_Kykkakkuniniraisyo_idx() {

        return super.getSyoruicd_Kykkakkuniniraisyo_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Yuukoukknkeikaykk() {

        return super.getSyoruicd_Yuukoukknkeikaykk();
    }

    @Override
    public int getSyoruicd_Yuukoukknkeikaykk_idx() {

        return super.getSyoruicd_Yuukoukknkeikaykk_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Yuukoukknkeikatyouka() {

        return super.getSyoruicd_Yuukoukknkeikatyouka();
    }

    @Override
    public int getSyoruicd_Yuukoukknkeikatyouka_idx() {

        return super.getSyoruicd_Yuukoukknkeikatyouka_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Trksseikyu() {

        return super.getSyoruicd_Trksseikyu();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Trksseikyu_souhu() {

        if (caller == EditPdfTrksseikyuTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_SyoruiCdKbn.BLNK;
            }
        }

        return super.getSyoruicd_Trksseikyu_souhu();
    }

    @Override
    public C_SyoruiCdKbn[] getSyoruicd_Trksseikyu_set() {

        return super.getSyoruicd_Trksseikyu_set();
    }

    @Override
    public int getSyoruicd_Trksseikyu_idx() {

        return super.getSyoruicd_Trksseikyu_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Kykhuseiritu() {

        return super.getSyoruicd_Kykhuseiritu();
    }

    @Override
    public int getSyoruicd_Kykhuseiritu_idx() {

        return super.getSyoruicd_Kykhuseiritu_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Sakujyokykmeisailist() {

        return super.getSyoruicd_Sakujyokykmeisailist();
    }

    @Override
    public int getSyoruicd_Sakujyokykmeisailist_idx() {

        return super.getSyoruicd_Sakujyokykmeisailist_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Jnyknmeisailist() {

        return super.getSyoruicd_Jnyknmeisailist();
    }

    @Override
    public int getSyoruicd_Jnyknmeisailist_idx() {

        return super.getSyoruicd_Jnyknmeisailist_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Dai1hknryittilist() {

        return super.getSyoruicd_Dai1hknryittilist();
    }

    @Override
    public int getSyoruicd_Dai1hknryittilist_idx() {

        return super.getSyoruicd_Dai1hknryittilist_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Nykninfohuittikakninsyo() {

        return super.getSyoruicd_Nykninfohuittikakninsyo();
    }

    @Override
    public int getSyoruicd_Nykninfohuittikakninsyo_idx() {

        return super.getSyoruicd_Nykninfohuittikakninsyo_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Mossouhujklst() {

        return super.getSyoruicd_Mossouhujklst();
    }

    @Override
    public int getSyoruicd_Mossouhujklst_idx() {

        return super.getSyoruicd_Mossouhujklst_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Mosmttkikankeikalist() {

        return super.getSyoruicd_Mosmttkikankeikalist();
    }

    @Override
    public int getSyoruicd_Mosmttkikankeikalist_idx() {

        return super.getSyoruicd_Mosmttkikankeikalist_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Henkiniraisyo() {

        return super.getSyoruicd_Henkiniraisyo();
    }

    @Override
    public int getSyoruicd_Henkiniraisyo_idx() {

        return super.getSyoruicd_Henkiniraisyo_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Henkintuuti() {

        return super.getSyoruicd_Henkintuuti();
    }

    @Override
    public int getSyoruicd_Henkintuuti_idx() {

        return super.getSyoruicd_Henkintuuti_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Handkarikanjyou() {

        return super.getSyoruicd_Handkarikanjyou();
    }

    @Override
    public int getSyoruicd_Handkarikanjyou_idx() {

        return super.getSyoruicd_Handkarikanjyou_idx();
    }

    @Override
    public C_SyoruiCdKbn getSyoruicd_Henkinmisyorilist() {

        return super.getSyoruicd_Henkinmisyorilist();
    }

    @Override
    public int getSyoruicd_Henkinmisyorilist_idx() {

        return super.getSyoruicd_Henkinmisyorilist_idx();
    }

}
