package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 同時申込判定
 */
public class HanteiDoujiMos {

    private C_UmuKbn doujiMosUmu = C_UmuKbn.NONE;

    private  C_UmuKbn palDoujiMosUmu = C_UmuKbn.NONE;

    private  C_UmuKbn rayDoujiMosUmu = C_UmuKbn.NONE;

    List<String> mosNoLst = new ArrayList<>();

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public HanteiDoujiMos() {
        super();
    }

    public C_UmuKbn getDoujiMosUmu() {
        return doujiMosUmu;
    }

    public List<String> getMosnoList() {
        return mosNoLst;
    }

    public C_ErrorKbn hanteiDoujiMos(String pMosNo) {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosNo);
        if (syoriCTL == null) {
            return C_ErrorKbn.ERROR;
        }
        initMember();
        palDoujiMosUmu = syoriCTL.getPaldoujimosumu();
        rayDoujiMosUmu = syoriCTL.getRaydoujimosumu();
        HT_NayoseKekka nayoseKekka = syoriCTL.getNayoseKekkaBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, 1);

        if (nayoseKekka != null && !BizUtil.isBlank(nayoseKekka.getSakuinnmno()) &&
                (C_NayoseJyoutaiKbn.NAYOSEZUMI.eq(nayoseKekka.getNysjyoutaikbn()) ||
                 C_NayoseJissiKekkaKbn.DOUITUARI.eq(nayoseKekka.getNysjissikekkakbn()) ||
                 C_NayoseJissiKekkaKbn.DOUITUNONE.eq(nayoseKekka.getNysjissikekkakbn()))) {
            List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(nayoseKekka.getSakuinnmno(), pMosNo, C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
            if (syoriCTLLst != null && syoriCTLLst.size() > 0) {
                rayDoujiMosUmu = C_UmuKbn.ARI;
                int mosnoCounter = 0;
                for (HT_SyoriCTL syoriCTLTemp: syoriCTLLst) {
                    mosNoLst.add(syoriCTLTemp.getMosno());
                    mosnoCounter = mosnoCounter + 1;

                    if (mosnoCounter >= 10){
                        break;
                    }

                }
            }
            else {
                rayDoujiMosUmu = C_UmuKbn.NONE;
            }
        }
        else {
            rayDoujiMosUmu = C_UmuKbn.NONE;
        }
        if (C_UmuKbn.ARI.eq(rayDoujiMosUmu) || C_UmuKbn.ARI.eq(palDoujiMosUmu)) {
            doujiMosUmu = C_UmuKbn.ARI;
        }
        else {
            doujiMosUmu = C_UmuKbn.NONE;
        }


        return C_ErrorKbn.OK;
    }

    public String getMsgMosnoList() {
        String msgMosnoLst = "";
        boolean commaFlag = false;

        if (C_UmuKbn.ARI.eq(rayDoujiMosUmu)) {
            for (String monNo : mosNoLst) {
                if (!commaFlag) {
                    msgMosnoLst = monNo;
                    commaFlag = true;
                }
                else {
                    msgMosnoLst = msgMosnoLst + "、" + monNo;
                }
            }
            if (!BizUtil.isBlank(msgMosnoLst)) {

                msgMosnoLst = "（RAY：" + msgMosnoLst;

            }
        }

        if (C_UmuKbn.NONE.eq(rayDoujiMosUmu)) {
            msgMosnoLst = "（RAY：なし";
        }
        if (C_UmuKbn.ARI.eq(palDoujiMosUmu)) {
            msgMosnoLst = msgMosnoLst + "、PAL：あり）";
        }
        if (C_UmuKbn.NONE.eq(palDoujiMosUmu)) {
            msgMosnoLst = msgMosnoLst + "、PAL：なし）";
        }
        return msgMosnoLst;

    }

    private void initMember() {
        doujiMosUmu = C_UmuKbn.NONE;

        mosNoLst = new ArrayList<>();

        palDoujiMosUmu = C_UmuKbn.NONE;

        rayDoujiMosUmu = C_UmuKbn.NONE;
    }

}
