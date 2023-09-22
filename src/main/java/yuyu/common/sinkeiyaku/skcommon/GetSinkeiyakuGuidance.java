package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SekmossakuseiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.db.entity.HT_MosKihon;

/**
 * 新契約 新契約共通 新契約ガイダンス取得
 */
public class GetSinkeiyakuGuidance {

    @Inject
    private static Logger logger;

    private final String GUIDANSU_MESSAGE_1000 = "1000";

    private final String GUIDANSU_MESSAGE_2000 = "2000";

    private final String GUIDANSU_MESSAGE_2030 = "2030";

    private final String GUIDANSU_MESSAGE_2040 = "2040";

    private final String GUIDANSU_MESSAGE_2045 = "2045";

    private final String GUIDANSU_MESSAGE_2050 = "2050";

    private final String GUIDANSU_MESSAGE_2710 = "2710";

    private final String GUIDANSU_MESSAGE_3000 = "3000";

    private final String GUIDANSU_MESSAGE_3010 = "3010";

    private final String GUIDANSU_MESSAGE_3020 = "3020";

    private final String GUIDANSU_MESSAGE_3030 = "3030";

    private final String GUIDANSU_MESSAGE_5000 = "5000";

    private final String GUIDANSU_MESSAGE_6000 = "6000";

    private final String SAMAKATA = "様方";

    private final String KITUKE = "気付";

    private final String ZENNKAKUSPACE = "　";

    private final int SEIJINN_20 = 20;

    public GetSinkeiyakuGuidance() {
        super();
    }

    public GetSinkeiyakuGuidanceOutBean exec(MosnaiCheckParam pMP) {

        logger.debug("▽ 新契約ガイダンス取得 開始");

        GetSinkeiyakuGuidanceOutBean sinkeiyakuGuidanceBean = SWAKInjector
            .getInstance(GetSinkeiyakuGuidanceOutBean.class);

        List<String> guidansuMessageList = new ArrayList<>();

        if (C_SekmossakuseiKbn.MOUSIKOMISYO.equals(pMP.getSekmossakuseiKbn())
            || C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO.equals(pMP.getSekmossakuseiKbn())) {

            HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();

            guidansuMessageList.add(GUIDANSU_MESSAGE_1000);

            guidansuMessageList.add(GUIDANSU_MESSAGE_2000);

            if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                if (mosKihon.getHhknnen() < SEIJINN_20) {
                    guidansuMessageList.add(GUIDANSU_MESSAGE_2030);
                }
            }
            else if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())) {
                if (mosKihon.getKyknen() < SEIJINN_20) {
                    if (mosKihon.getHhknnen() < SEIJINN_20) {
                        guidansuMessageList.add(GUIDANSU_MESSAGE_2045);
                    }
                    else if (!(C_Tdk.HGU.eq(mosKihon.getKyktdk())
                        || C_Tdk.KO.eq(mosKihon.getKyktdk())
                        || C_Tdk.BLNK.eq(mosKihon.getKyktdk()))) {
                        guidansuMessageList.add(GUIDANSU_MESSAGE_2040);
                    }
                }
                else if (mosKihon.getHhknnen() < SEIJINN_20) {
                    if (!(C_Tdk.HGU.eq(mosKihon.getKyktdk())
                        || C_Tdk.OYA.eq(mosKihon.getKyktdk())
                        || C_Tdk.BLNK.eq(mosKihon.getKyktdk()))) {
                        guidansuMessageList.add(GUIDANSU_MESSAGE_2050);
                    }
                }
            }

            if(C_Tkhukaumu.HUKA.eq(mosKihon.getJyudkaigomehrtkhkkbn())){
                guidansuMessageList.add(GUIDANSU_MESSAGE_2710);
            }

            guidansuMessageList.add(GUIDANSU_MESSAGE_3000);

            String tsinadrkj = mosKihon.getTsinadr1kj().concat(
                mosKihon.getTsinadr2kj().concat(mosKihon.getTsinadr3kj()));
            String hhknadrkj = mosKihon.getHhknadr1kj().concat(
                mosKihon.getHhknadr2kj().concat(mosKihon.getHhknadr3kj()));
            if (tsinadrkj.contains(SAMAKATA) || tsinadrkj.contains(KITUKE)
                || hhknadrkj.contains(SAMAKATA) || hhknadrkj.contains(KITUKE)) {
                guidansuMessageList.add(GUIDANSU_MESSAGE_3010);
            }

            if (C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn())
                && !(mosKihon.getHhknnmkn().split(ZENNKAKUSPACE)[0])
                .equals(mosKihon.getKyknmkn().split(ZENNKAKUSPACE)[0])) {
                guidansuMessageList.add(GUIDANSU_MESSAGE_3020);
            }

            if ((C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn()) && mosKihon.getKyknen() < SEIJINN_20)
                || (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn()) && mosKihon.getHhknnen() < SEIJINN_20)) {
                guidansuMessageList.add(GUIDANSU_MESSAGE_3030);
            }

            guidansuMessageList.add(GUIDANSU_MESSAGE_5000);

            guidansuMessageList.add(GUIDANSU_MESSAGE_6000);
        }
        else if (C_SekmossakuseiKbn.SEKKEISYO.equals(pMP.getSekmossakuseiKbn())) {

            guidansuMessageList.add(GUIDANSU_MESSAGE_1000);

            guidansuMessageList.add(GUIDANSU_MESSAGE_3000);
        }

        sinkeiyakuGuidanceBean.setGuidansuMessageList(guidansuMessageList);

        logger.debug("△ 新契約ガイダンス取得 終了");

        return sinkeiyakuGuidanceBean;
    }
}
