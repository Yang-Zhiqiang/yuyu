package yuyu.common.sinkeiyaku.skcommon;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_DakuhiKettei;
import yuyu.def.sinkeiyaku.sorter.SortHT_Nyuukin;

/**
 * 新契約 新契約共通 SMBC進捗管理データ編集
 */
public class SmbcEditSintyokuData {

    private static final String BLANK = "";

    private BizDate seirituDate = null;

    private String syoNo = null;

    private String mosNo = null;

    private BizDate syoriDate = null;

    private HT_SyoriCTL syoriCTL = null;

    private HT_MosKihon mosKihon = null;

    private HashMap<String, Object> smbcStyKanriMp = null;

    private C_UmuKbn fstrndumuflg = C_UmuKbn.NONE;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SmbcEditSintyokuData() {
        super();
    }

    public void setFstrndumuflg(C_UmuKbn pFstrndumuflg) {
        fstrndumuflg = pFstrndumuflg;
    }

    public void exec(HT_SyoriCTL pSyoriCTL, BizDate pSyoriDate,
        HashMap<String, Object> pSmbcStyKanriMp) {

        syoriDate = pSyoriDate;
        syoriCTL = pSyoriCTL;
        smbcStyKanriMp = pSmbcStyKanriMp;
        syoNo = smbcStyKanriMp.get(HT_SyoriCTL.SYONO).toString();
        mosNo = smbcStyKanriMp.get(HT_SyoriCTL.MOSNO).toString();
        seirituDate = syoriCTL.getSrsyoriymd();
        mosKihon = syoriCTL.getMosKihon();

        editNyukinDate();

        editShHubiDate();

        editShHubiKaisyoDate();

        editShSyokenHkzumiDate();

        editShTorikesshiDate();

        editShHiketuDate();

        editSinsazumiDate();

        editShToutyakuDate();

        editShUkezumiDate();

        editJyoukentukiflg();

        editSeihosyurui();

    }

    private void editShUkezumiDate() {

        if (!BizUtil.isBlank((String) smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD))) {

            return;
        }

        BizDate mosNrkYmd = syoriCTL.getMosnrkymd();

        if (mosNrkYmd != null) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD, mosNrkYmd.toString());
        }
    }

    private void editShToutyakuDate() {
        if (C_SntkhouKbn.BLNK.eq(mosKihon.getSntkhoukbn())
            || C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn())
            || C_SntkhouKbn.SYOKUGYOU.eq(mosKihon.getSntkhoukbn()) ) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, BLANK);

            return;
        }

        if (!C_UmuKbn.ARI.eq(syoriCTL.getKktnrkumu()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getKktnrkhbumu()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getHjynrkumu()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getHjynrkhbumu())) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, BLANK);

            return;
        }

        if (!BizUtil.isBlank((String) smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD))) {

            return;
        }

        if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn()) &&
            (C_UmuKbn.ARI.eq(syoriCTL.getKktnrkumu()) ||
                C_UmuKbn.ARI.eq(syoriCTL.getKktnrkhbumu()))) {

            HT_Kokutisyo kokutiSyo = syoriCTL.getKokutisyo();

            if (kokutiSyo == null) {

                throw new CommonBizAppException("申込番号=" + mosNo);
            }
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, kokutiSyo.getGyoumuKousinTime().substring(0, 8));

        }

        else if (C_SntkhouKbn.HJY.eq(mosKihon.getSntkhoukbn()) &&
            (C_UmuKbn.ARI.eq(syoriCTL.getHjynrkumu()) ||
                C_UmuKbn.ARI.eq(syoriCTL.getHjynrkhbumu()))) {

            HT_Houjyou houjyou = syoriCTL.getHoujyouBySyosaikbn(C_SyosaiKbn.SOYSIN);

            if (houjyou == null) {

                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, houjyou.getGyoumuKousinTime().substring(0, 8));
        }

        else if (C_SntkhouKbn.HJY.eq(mosKihon.getSntkhoukbn()) &&
            (C_UmuKbn.ARI.eq(syoriCTL.getKktnrkumu()) ||
                C_UmuKbn.ARI.eq(syoriCTL.getKktnrkhbumu()))) {

            HT_Kokutisyo kokutiSyo = syoriCTL.getKokutisyo();

            if (kokutiSyo == null) {

                throw new CommonBizAppException("申込番号=" + mosNo);
            }
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD, kokutiSyo.getGyoumuKousinTime().substring(0, 8));
        }

    }

    private void editShHubiDate() {

        if (!BizUtil.isBlank((String) smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD))) {

            return;
        }
        if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getKktnrkumu()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getKktnrkhbumu())) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, syoriDate.toString());

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, BLANK);

            return;
        }

        int hjyTyouka = YuyuSinkeiyakuConfig.getInstance().getHjyTyoukaNissu();

        BizDate hjyIdougoSyoriYmd = syoriCTL.getMosnrkymd();

        if (hjyIdougoSyoriYmd.isHoliday()) {

            hjyIdougoSyoriYmd = hjyIdougoSyoriYmd.getBusinessDay(CHolidayAdjustingMode.NEXT);
        }

        hjyIdougoSyoriYmd = hjyIdougoSyoriYmd.addBusinessDays(hjyTyouka);

        if (C_SntkhouKbn.HJY.eq(mosKihon.getSntkhoukbn()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getHjynrkumu()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getHjynrkhbumu()) &&
            syoriDate.compareTo(hjyIdougoSyoriYmd) >= 0) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, syoriDate.toString());
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, BLANK);

            return;
        }

        if (C_KetteiKbn.KETTEI_SUMI.eq(syoriCTL.getKetteikbn()) &&
            C_UmuKbn.NONE.eq(syoriCTL.getNyknnrkumu())) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, syoriDate.toString());
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, BLANK);

            return;
        }

        if (C_KetteiKbn.TKJYSYDK_MATI.eq(syoriCTL.getKetteikbn())) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, syoriDate.toString());
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, BLANK);

            return;
        }

        List<HT_SkHubi> skHubiLst = syoriCTL.getSkHubisByHasinymdNotNullKaisyouymdNull();

        if (skHubiLst != null && skHubiLst.size() != 0) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, syoriDate.toString());
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, BLANK);
        }
    }

    private void editShHubiKaisyoDate() {

        if (!BizUtil.isBlank((String) smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD))) {

            return;
        }

        if (BizUtil.isBlank((String) smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBYMD))) {

            return;
        }

        if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) ||
            C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

            if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
                if (C_UmuKbn.ARI.eq(fstrndumuflg)) {

                    smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, BLANK);

                    return;
                }

                HT_SmbcStyKanriSsRireki smbcStyKanriSsRirek =
                    sinkeiyakuDomManager.getSmbcStyKanriSsRireki(syoNo);

                if (smbcStyKanriSsRirek != null &&
                    BizUtil.isBlank(smbcStyKanriSsRirek.getSmbcseihohbymd()) &&
                    BizUtil.isBlank(smbcStyKanriSsRirek.getSmbcseihohbksyymd())) {

                    smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, BLANK);

                    return;
                }

                String seihoHubiKaisyoDate = (String) smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD + "RRK");

                if (!BizUtil.isBlank(seihoHubiKaisyoDate)) {

                    smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, seihoHubiKaisyoDate);
                }
                else {

                    smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, syoriDate.toString());
                }
                smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, BLANK);

                return;

            }

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, syoriDate.toString());
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, BLANK);

            return;
        }

        List<HT_SkHubi> skHubiLst = syoriCTL.getSkHubisByHasinymdNotNullKaisyouymdNull();

        if (skHubiLst != null && skHubiLst.size() != 0) {

            return;
        }

        if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getKktnrkumu()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getKktnrkhbumu())) {

            return;
        }
        if (C_SntkhouKbn.HJY.eq(mosKihon.getSntkhoukbn()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getHjynrkumu()) &&
            !C_UmuKbn.ARI.eq(syoriCTL.getHjynrkhbumu())) {

            return;
        }

        if (C_KetteiKbn.KETTEI_SUMI.eq(syoriCTL.getKetteikbn()) &&
            C_UmuKbn.NONE.eq(syoriCTL.getNyknnrkumu())) {

            return;
        }

        if (C_KetteiKbn.TKJYSYDK_MATI.eq(syoriCTL.getKetteikbn())) {

            return;
        }

        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBKSYYMD, syoriDate.toString());
        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHBYMD, BLANK);
    }


    private void editNyukinDate() {

        if (C_UmuKbn.NONE.eq(syoriCTL.getNyknnrkumu())) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHONYKNZMYMD, BLANK);
        }
        else {

            List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();

            if (nyuukinLst == null || nyuukinLst.size() == 0) {

                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            SortHT_Nyuukin nyuukinSort = SWAKInjector.getInstance(SortHT_Nyuukin.class);

            nyuukinLst = nyuukinSort.OrderHT_NyuukinByRyosyuymdDesc(nyuukinLst);

            BizDate tyakkinYmd = nyuukinLst.get(0).getTyakkinymd();

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHONYKNZMYMD, tyakkinYmd.toString());
        }
    }

    private void editSinsazumiDate() {

        if (!C_KetteiKbn.KETTEI_SUMI.eq(syoriCTL.getKetteikbn())) {
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD, BLANK);

            return;
        }

        if (!C_UmuKbn.NONE.eq(syoriCTL.getSrhhbkbn())) {
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD, BLANK);

            return;
        }

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteisByKetkekkacds();

        if (dakuhiKetteiLst == null || dakuhiKetteiLst.size() == 0) {

            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        SortHT_DakuhiKettei dakuhiKetteiSort = SWAKInjector.getInstance(SortHT_DakuhiKettei.class);

        dakuhiKetteiLst = dakuhiKetteiSort.OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        BizDate tkjysydkYmd = dakuhiKettei.getTkjysydkymd();

        if (tkjysydkYmd != null) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD, tkjysydkYmd.toString());
        }
        else {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSNSZMYMD, dakuhiKettei.getKetymd().toString());
        }
    }

    private void editShSyokenHkzumiDate() {

        if (!C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {

            return;
        }

        if (!BizUtil.isBlank((String) smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD))) {

            return;
        }

        BizDate syoHakkoubi = seirituDate;

        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD, syoHakkoubi.toString());
    }

    private void editShHiketuDate() {

        if (!C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

            return;
        }

        if (!BizUtil.isBlank((String) smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOHKTYMD))) {

            return;
        }

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

        if (dakuhiKetteiLst == null || dakuhiKetteiLst.size() == 0) {

            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        SortHT_DakuhiKettei dakuhiKetteiSort = SWAKInjector.getInstance(SortHT_DakuhiKettei.class);

        dakuhiKetteiLst = dakuhiKetteiSort.OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        C_Ketkekkacd ketKekkaCd = dakuhiKettei.getKetkekkacd();

        if (C_Ketkekkacd.ENKI_SIJINASI.eq(ketKekkaCd) ||
            C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(ketKekkaCd) ||
            C_Ketkekkacd.MIAWASE.eq(ketKekkaCd) ||
            C_Ketkekkacd.YUUKOUKKNKKA.eq(ketKekkaCd)) {
            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOHKTYMD, seirituDate.toString());
        }
    }

    private void editShTorikesshiDate() {

        if (!C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

            return;
        }

        if (!BizUtil.isBlank((String) smbcStyKanriMp.get(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD))) {

            return;
        }

        List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteisByKetkekkacd(C_Ketkekkacd.KYOUSEIHAND_KETTEI);

        if (dakuhiKetteiLst == null || dakuhiKetteiLst.size() == 0)  {

            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        SortHT_DakuhiKettei dakuhiKetteiSort = SWAKInjector.getInstance(SortHT_DakuhiKettei.class);

        dakuhiKetteiLst = dakuhiKetteiSort.OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);

        HT_DakuhiKettei dakuhiKettei = dakuhiKetteiLst.get(0);

        C_Ketkekkacd ketKekkaCd = dakuhiKettei.getKetkekkacd();

        if (C_Ketkekkacd.MOS_TORIKESI.eq(ketKekkaCd) ||
            C_Ketkekkacd.COOLINGOFF.eq(ketKekkaCd)) {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOTRKSYMD, seirituDate.toString());
        }
    }

    private void editJyoukentukiflg() {

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnLst == null || mosSyouhnLst.size() == 0) {

            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        BM_SyouhnZokusei syouhnZokusei = mosSyouhnLst.get(0).getSyouhnZokusei();

        if (syouhnZokusei == null) {

            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getTkjyrmtekiumu()) ||
            C_UmuKbn.ARI.eq(syouhnZokusei.getTkjyskgntekiumu()) ||
            C_UmuKbn.ARI.eq(syouhnZokusei.getHtnpbuitekiumu()) ||
            C_UmuKbn.ARI.eq(syouhnZokusei.getTokkoudosghtnptekiumu()) ||
            C_UmuKbn.ARI.eq(syouhnZokusei.getJkntekiumu())) {

            if (!C_KetteiKbn.KETTEI_SUMI.eq(syoriCTL.getKetteikbn())) {

                smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCJKTKFLG, BLANK);

                return;
            }

            List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteisByKetkekkacd(C_Ketkekkacd.KYOUSEIHAND_KETTEI);

            if (dakuhiKetteiLst == null || dakuhiKetteiLst.size() == 0) {

                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            SortHT_DakuhiKettei dakuhiKetteiSort = SWAKInjector.getInstance(SortHT_DakuhiKettei.class);

            dakuhiKetteiLst = dakuhiKetteiSort.OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);

            C_Ketkekkacd ketKekkaCd = dakuhiKetteiLst.get(0).getKetkekkacd();

            if (C_Ketkekkacd.TOKUBETUJYOUKEN.eq(ketKekkaCd) ||
                C_Ketkekkacd.JYOUKENTUKI.eq(ketKekkaCd) ||
                C_Ketkekkacd.TKJY_JYOUKENTUKI_HEI.eq(ketKekkaCd)) {

                smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCJKTKFLG, "1");

                return;
            }

            boolean jyoukentukiKetteiUmu = false;

            for (HT_DakuhiKettei dakuhiKettei : dakuhiKetteiLst) {

                C_Ketkekkacd ketKekkaCdItiji = dakuhiKettei.getKetkekkacd();

                if (C_Ketkekkacd.TOKUBETUJYOUKEN.eq(ketKekkaCdItiji) ||
                    C_Ketkekkacd.JYOUKENTUKI.eq(ketKekkaCdItiji) ||
                    C_Ketkekkacd.TKJY_JYOUKENTUKI_HEI.eq(ketKekkaCdItiji)) {

                    jyoukentukiKetteiUmu = true;

                    break;
                }
            }

            if (jyoukentukiKetteiUmu &&
                !(C_Ketkekkacd.MUJYOUKEN.eq(ketKekkaCd) ||
                    C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(ketKekkaCd) ||
                    C_Ketkekkacd.ENKI_SIJINASI.eq(ketKekkaCd) ||
                    C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(ketKekkaCd) ||
                    C_Ketkekkacd.MIAWASE.eq(ketKekkaCd) ||
                    C_Ketkekkacd.YUUKOUKKNKKA.eq(ketKekkaCd))) {

                smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCJKTKFLG, "1");

                return;
            }

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCJKTKFLG, "0");
        }
        else {

            smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCJKTKFLG, "0");
        }
    }

    private void editSeihosyurui() {

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnLst == null || mosSyouhnLst.size() == 0) {

            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        BM_SyouhnZokusei syouhnZokusei = mosSyouhnLst.get(0).getSyouhnZokusei();

        if (syouhnZokusei == null) {

            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        smbcStyKanriMp.put(HT_SmbcStyKanri.SMBCSEIHOSYURUI, syouhnZokusei.getGwhknsyurui());
    }
}
