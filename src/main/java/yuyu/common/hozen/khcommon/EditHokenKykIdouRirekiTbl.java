package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.khcommon.dba4edithokenkykidourirekitbl.EditHokenKykIdouRirekiTblDao;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HnkzengoKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KykIdouHaraikataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TumitatekinKbn;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.classification.C_ZfiIdoujiyuuKbn;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_Zennou;

/**
 * 契約保全 契約保全共通 保険契約異動情報履歴TBL編集
 */
public class EditHokenKykIdouRirekiTbl {

    @Inject
    private AS_Kinou kinou;

    @Inject
    private EditHokenKykIdouRirekiTblDao editHokenKykIdouRirekiTblDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private static Logger logger;

    public EditHokenKykIdouRirekiTbl() {
        super();
    }

    public void exec(EditHokenKykIdouRirekiTblBean pEditHokenKykIdouRirekiTblBean) {

        logger.debug("▽ 保険契約異動情報履歴TBL編集 開始");

        KhozenCommonParam khozenCommonParam = pEditHokenKykIdouRirekiTblBean.getKhozenCommonParam();
        String syoNo = pEditHokenKykIdouRirekiTblBean.getSyoNo();
        BizDate syoriYmd = pEditHokenKykIdouRirekiTblBean.getSyoriYmd();
        C_SyoriKbn syoriKbn = pEditHokenKykIdouRirekiTblBean.getSyoriKbn();
        String sysDateTime = pEditHokenKykIdouRirekiTblBean.getSysDateTime();
        BizCurrency mikeikaP = pEditHokenKykIdouRirekiTblBean.getMikeikaP();
        BizCurrency zennouseisanKin = pEditHokenKykIdouRirekiTblBean.getZennouseisanKin();
        BizCurrency mikeikaPGengkBfr = pEditHokenKykIdouRirekiTblBean.getMikeikaPGengkBf();
        BizCurrency zennouseisanKinGengkBfr = pEditHokenKykIdouRirekiTblBean.getZennouseisanKinGengkBf();
        IT_KykKihon kykKihon = null;
        IT_AnsyuKihon ansyuKihon = null;
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);


        C_KinouKbn kinouKbn = kinou.getKinouKbn();

        if (C_KinouKbn.ONLINE.eq(kinouKbn)) {

            kykKihon = hozenDomManager.getKykKihon(syoNo);

            ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
        }
        else {

            kykKihon = khozenCommonParam.getBatchKeiyakuKihon();
            ansyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(khozenCommonParam.getSikibetuKey(syoNo));

        CurrencyType kyktuukaType = henkanTuuka.henkanTuukaKbnToType(kykSyouhnList.get(0).getKyktuukasyu());

        BizCurrency kaiyakuhrKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency ptumitatekinKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency mikeikapKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency zennouseisankinKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kaiyakuhrgoukeiKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency hrkpKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency idouhokenkngkKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency idoupKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency idouptumitatekinKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency idoukiykhnriknKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmeKaiyakuhrKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmePtumitatekinKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmeMikeikapKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmeZennouseisankinKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmeKaiyakuhrgoukeiKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmeHrkpKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmeIdouhokenkngkKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmeIdoupKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmeIdouptumitatekinKytk = BizCurrency.valueOf(0, kyktuukaType);
        BizCurrency kusnmeIdoukiykhnriknKytk = BizCurrency.valueOf(0, kyktuukaType);
        C_ZfiIdoujiyuuKbn idoujiyuuKbn = null;
        C_ZfiIdoujiyuuKbn kusnmeIdoujiyuuKbn = null;
        C_KykIdouHaraikataKbn kykIdouHaraikataKbn = C_KykIdouHaraikataKbn.BLNK;
        List<IT_KykSyouhnRireki> kykSyouhnRirekiList = new ArrayList<>();
        int ttdkRenno = 0;
        BizDate calckijyunYmd = null;
        BizDateYM kijyunYm = null;
        IT_Zennou zennou = new IT_Zennou();
        C_ZougenKbn zougenKbn = null;
        C_ZougenKbn kusnmeZougenKbn = null;

        if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(khozenCommonParam.getFunctionId()) ||
            IKhozenCommonConstants.KINOUID_GENGAKU.equals(khozenCommonParam.getFunctionId())) {

            kykSyouhnRirekiList = hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(syoNo);
        }

        idoujiyuuKbn = editIdoujiyuuKbn(khozenCommonParam.getFunctionId(), syoriKbn);

        if (idoujiyuuKbn == null) {

            logger.debug("△ 保険契約異動情報履歴TBL編集 終了");

            return;
        }
        else if (C_ZfiIdoujiyuuKbn.GENGAKUNEW.eq(idoujiyuuKbn)) {

            kusnmeIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.GENGAKUBFR;
        }
        else if (C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW.eq(idoujiyuuKbn)) {

            kusnmeIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSBFR;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhnList.get(0).getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

        }
        else {

            logger.debug("△ 保険契約異動情報履歴TBL編集 終了");

            return;
        }

        if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(khozenCommonParam.getFunctionId())) {
            if (kykSyouhnList.get(0).getKihons().compareTo(kykSyouhnRirekiList.get(0).getKihons()) != 0 ||
                kykSyouhnList.get(0).getHokenryou().compareTo(kykSyouhnRirekiList.get(0).getHokenryou()) != 0) {

            }
            else {

                logger.debug("△ 保険契約異動情報履歴TBL編集 終了");

                return;
            }
        }
        else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(khozenCommonParam.getFunctionId())) {
            if (!C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(kykSyouhnList.get(0).getSyoumetujiyuu())) {

            }
            else {

                logger.debug("△ 保険契約異動情報履歴TBL編集 終了");

                return;
            }
        }

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList =
            editHokenKykIdouRirekiTblDao.getHokenKykIdouRirekiBySyoNoKykTuukasyuIdouymdIdoujiyuuKbn(
                syoNo, kykSyouhnList.get(0).getKyktuukasyu(), syoriYmd, idoujiyuuKbn);

        if (hokenKykIdouRirekiList.size() == 0) {

            ttdkRenno = 1;
        }
        else {

            ttdkRenno = hokenKykIdouRirekiList.get(0).getTtdkrenno() + 1;
        }

        if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(khozenCommonParam.getFunctionId()) ||
            IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(khozenCommonParam.getFunctionId())) {

            calckijyunYmd = kykSyouhnList.get(0).getSyoumetuymd();
        }
        else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(khozenCommonParam.getFunctionId())) {

            calckijyunYmd = kykSyouhnList.get(0).getKouryokuhasseiymd();
        }
        else if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
            C_SyoriKbn.KAIJO.eq(syoriKbn)) {

            IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
            calckijyunYmd = khShrRireki.getKouryokuhasseiymd();
        }
        else if ((IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
            C_SyoriKbn.CLGOFF.eq(syoriKbn)) ||
            (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                C_SyoriKbn.KYKTORIKESI.eq(syoriKbn)) ||
                (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                    C_SyoriKbn.MUKOU.eq(syoriKbn)) ||
                    (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                        C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(syoriKbn)) ||
                        (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                            C_SyoriKbn.SBMUKOU_SHRNASI.eq(syoriKbn)) ||
                            (IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(khozenCommonParam.getFunctionId()) &&
                                C_SyoriKbn.SBMUKOU.eq(syoriKbn)) ||
                                IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(khozenCommonParam.getFunctionId())) {

            if (BizDateUtil.compareYmd(syoriYmd, kykSyouhnList.get(0).getKykymd()) == BizDateUtil.COMPARE_GREATER) {

                calckijyunYmd = syoriYmd;
            }
            else {

                calckijyunYmd = kykSyouhnList.get(0).getKykymd();
            }
        }
        else if ((IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
            C_SyoriKbn.SBKAIJO.eq(syoriKbn)) ||
            (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                C_SyoriKbn.SBMENSEKI.eq(syoriKbn)) ||
                (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                    C_SyoriKbn.SBMENSEKI_SHRNASI.eq(syoriKbn)) ||
                    (IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(khozenCommonParam.getFunctionId()) &&
                        C_SyoriKbn.SIBOU.eq(syoriKbn))) {

            if (BizDateUtil.compareYmd(kykSyouhnList.get(0).getSyoumetuymd(),
                kykSyouhnList.get(0).getKykymd()) == BizDateUtil.COMPARE_GREATER) {

                calckijyunYmd = kykSyouhnList.get(0).getSyoumetuymd();
            }
            else {

                calckijyunYmd = kykSyouhnList.get(0).getKykymd();
            }
        }
        else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(khozenCommonParam.getFunctionId())) {

            calckijyunYmd = kykSyouhnList.get(0).getSyoumetuymd();
        }
        else if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(khozenCommonParam.getFunctionId())) {

            if (BizDateUtil.compareYmd(kykKihon.getSeirituymd(), kykSyouhnList.get(0).getKykymd()) == BizDateUtil.COMPARE_GREATER) {

                calckijyunYmd = kykKihon.getSeirituymd();
            }
            else {

                calckijyunYmd = kykSyouhnList.get(0).getKykymd();
            }
        }

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        kijyunYm = keisanWKijunYM.exec(kykSyouhnList.get(0).getKykymd(),
            calckijyunYmd,
            ansyuKihon.getJkipjytym(),
            kykKihon.getHrkkaisuu(),
            kykSyouhnList.get(0).getKykjyoutai(),
            "",
            null);

        if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(khozenCommonParam.getFunctionId()) ||
            IKhozenCommonConstants.KINOUID_GENGAKU.equals(khozenCommonParam.getFunctionId())) {

            KaiyakuHenreikinDataSksBean kaiyakuHenreikinDataSksBean = keisanWV(syoNo,
                calckijyunYmd,
                kijyunYm,
                kyktuukaType,
                kykKihon,
                kykSyouhnRirekiList.get(0),
                ansyuKihon);

            kusnmeKaiyakuhrKytk = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
            kusnmePtumitatekinKytk = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();

        }

        KaiyakuHenreikinDataSksBean kaiyakuHenreikinDataSksBean = keisanWV(syoNo,
            calckijyunYmd,
            kijyunYm,
            kyktuukaType,
            kykKihon,
            kykSyouhnList.get(0),
            ansyuKihon);

        kaiyakuhrKytk = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
        ptumitatekinKytk = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();

        if ((C_Kykjyoutai.HRKMTYUU.eq(kykSyouhnList.get(0).getKykjyoutai()) &&
            (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu()) ||
                C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu()))) ||
                C_Kykjyoutai.ZENNOU.eq(kykSyouhnList.get(0).getKykjyoutai())) {

            if ((IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                C_SyoriKbn.CLGOFF.eq(syoriKbn)) ||
                (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                    C_SyoriKbn.KYKTORIKESI.eq(syoriKbn)) ||
                    (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                        C_SyoriKbn.MUKOU.eq(syoriKbn)) ||
                        (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                            C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(syoriKbn)) ||
                            (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                                C_SyoriKbn.SBMUKOU_SHRNASI.eq(syoriKbn)) ||
                                (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                                    C_SyoriKbn.SBMENSEKI_SHRNASI.eq(syoriKbn)) ||
                                    IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(khozenCommonParam.getFunctionId())) {

                if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(khozenCommonParam.getFunctionId())) {

                    MikeikaPDataSksBean mikeikaPDataSksBean = keisanZnnusisnMikkP(syoNo,
                        calckijyunYmd,
                        kyktuukaType,
                        kykSyouhnRirekiList.get(0),
                        ansyuKihon,
                        C_HnkzengoKbn.ZEN);

                    kusnmeMikeikapKytk = mikeikaPDataSksBean.getSsyMikeikap();
                    kusnmeZennouseisankinKytk = mikeikaPDataSksBean.getSsyZennouseisankin();
                }

                MikeikaPDataSksBean mikeikaPDataSksBean = keisanZnnusisnMikkP(syoNo,
                    calckijyunYmd,
                    kyktuukaType,
                    kykSyouhnList.get(0),
                    ansyuKihon,
                    C_HnkzengoKbn.GO);

                mikeikapKytk = mikeikaPDataSksBean.getSsyMikeikap();
                zennouseisankinKytk = mikeikaPDataSksBean.getSsyZennouseisankin();

            }
            else if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(khozenCommonParam.getFunctionId())) {

                if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnList.get(0).getKykjyoutai())) {

                    SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);
                    List<IT_Zennou> zennouList = ansyuKihon.getZennouMsisnsBySyono();
                    zennouList = sortIT_Zennou.OrderIT_ZennouByPkDesc(zennouList);
                    zennou = zennouList.get(0);
                }

                MikeikaPDataSksBean mikeikaPDataSksBean = keisanZnnusisnMikkPKykInfo(calckijyunYmd,
                    kyktuukaType,
                    kykKihon,
                    kykSyouhnList.get(0),
                    ansyuKihon,
                    zennou);

                mikeikapKytk = mikeikaPDataSksBean.getSsyMikeikap();
                zennouseisankinKytk = mikeikaPDataSksBean.getSsyZennouseisankin();
            }
            else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(khozenCommonParam.getFunctionId()) ||
                IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(khozenCommonParam.getFunctionId()) ||
                (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                    C_SyoriKbn.KAIJO.eq(syoriKbn)) ||
                    (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                        C_SyoriKbn.SBKAIJO.eq(syoriKbn)) ||
                        (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(khozenCommonParam.getFunctionId()) &&
                            C_SyoriKbn.SBMENSEKI.eq(syoriKbn)) ||
                            IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(khozenCommonParam.getFunctionId())) {

                mikeikapKytk = mikeikaP;
                zennouseisankinKytk = zennouseisanKin;
            }
            else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(khozenCommonParam.getFunctionId())) {

                kusnmeMikeikapKytk = mikeikaPGengkBfr;
                kusnmeZennouseisankinKytk = zennouseisanKinGengkBfr;
                mikeikapKytk = mikeikaP;
                zennouseisankinKytk = zennouseisanKin;
            }
        }

        kykIdouHaraikataKbn = editHokenKykIdouHaraikataKbn(kykKihon.getHrkkaisuu(), kykSyouhnList.get(0).getKykjyoutai());

        if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(khozenCommonParam.getFunctionId())) {

            hrkpKytk = editSeiritujiHrkp(syoriYmd,
                kykKihon.getHrkkaisuu(),
                kykSyouhnList.get(0).getKykjyoutai(),
                kykSyouhnList.get(0).getKykymd(),
                kyktuukaType,
                kykSyouhnList.get(0).getHokenryou(),
                zennou.getZennoujihrkp(),
                zennou.getZennounyuukinkgk());

            zougenKbn = C_ZougenKbn.ZOU;
        }
        else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(khozenCommonParam.getFunctionId()) ||
            IKhozenCommonConstants.KINOUID_GENGAKU.equals(khozenCommonParam.getFunctionId())) {

            hrkpKytk = BizCurrency.valueOf(0, kyktuukaType);
            kusnmeHrkpKytk = BizCurrency.valueOf(0, kyktuukaType);
            kusnmeZougenKbn = C_ZougenKbn.GEN;
            zougenKbn = C_ZougenKbn.ZOU;
        }
        else {

            hrkpKytk = BizCurrency.valueOf(0, kyktuukaType);
            zougenKbn = C_ZougenKbn.GEN;
        }

        kaiyakuhrgoukeiKytk = kaiyakuhrKytk.add(mikeikapKytk).add(zennouseisankinKytk);
        kusnmeKaiyakuhrgoukeiKytk = kusnmeKaiyakuhrKytk.add(kusnmeMikeikapKytk).add(kusnmeZennouseisankinKytk);

        if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(khozenCommonParam.getFunctionId())) {

            if (kykSyouhnRirekiList.get(0).getKihons().compareTo(kykSyouhnList.get(0).getKihons()) > 0 ||
                kykSyouhnRirekiList.get(0).getHokenryou().compareTo(kykSyouhnList.get(0).getHokenryou()) > 0) {

                kusnmeIdouhokenkngkKytk = kykSyouhnRirekiList.get(0).getKihons().subtract(kykSyouhnList.get(0).getKihons());
                kusnmeIdoupKytk = kusnmeHrkpKytk.subtract(hrkpKytk);
                kusnmeIdouptumitatekinKytk = kusnmePtumitatekinKytk.subtract(ptumitatekinKytk);
                kusnmeIdoukiykhnriknKytk = kusnmeKaiyakuhrgoukeiKytk.subtract(kaiyakuhrgoukeiKytk);
                idouhokenkngkKytk = BizCurrency.valueOf(0, kyktuukaType);
                idoupKytk = BizCurrency.valueOf(0, kyktuukaType);
                idouptumitatekinKytk = BizCurrency.valueOf(0, kyktuukaType);
                idoukiykhnriknKytk = BizCurrency.valueOf(0, kyktuukaType);
            }
            if (kykSyouhnRirekiList.get(0).getKihons().compareTo(kykSyouhnList.get(0).getKihons()) < 0 ||
                kykSyouhnRirekiList.get(0).getHokenryou().compareTo(kykSyouhnList.get(0).getHokenryou()) < 0) {

                kusnmeIdouhokenkngkKytk =BizCurrency.valueOf(0, kyktuukaType);
                kusnmeIdoupKytk = BizCurrency.valueOf(0, kyktuukaType);
                kusnmeIdouptumitatekinKytk = BizCurrency.valueOf(0, kyktuukaType);
                kusnmeIdoukiykhnriknKytk = BizCurrency.valueOf(0, kyktuukaType);
                idouhokenkngkKytk = kykSyouhnList.get(0).getKihons().subtract(kykSyouhnRirekiList.get(0).getKihons());
                idoupKytk = hrkpKytk.subtract(kusnmeHrkpKytk);
                idouptumitatekinKytk = ptumitatekinKytk.subtract(kusnmePtumitatekinKytk);
                idoukiykhnriknKytk = kaiyakuhrgoukeiKytk.subtract(kusnmeKaiyakuhrgoukeiKytk);
            }
        }
        else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(khozenCommonParam.getFunctionId())) {

            kusnmeIdouhokenkngkKytk = kykSyouhnRirekiList.get(0).getKihons().subtract(kykSyouhnList.get(0).getKihons());
            kusnmeIdoupKytk = kusnmeHrkpKytk.subtract(hrkpKytk);
            kusnmeIdouptumitatekinKytk = kusnmePtumitatekinKytk.subtract(ptumitatekinKytk);
            kusnmeIdoukiykhnriknKytk = kusnmeKaiyakuhrgoukeiKytk.subtract(kaiyakuhrgoukeiKytk);
            idouhokenkngkKytk = BizCurrency.valueOf(0, kyktuukaType);
            idoupKytk = BizCurrency.valueOf(0, kyktuukaType);
            idouptumitatekinKytk = BizCurrency.valueOf(0, kyktuukaType);
            idoukiykhnriknKytk = BizCurrency.valueOf(0, kyktuukaType);
        }
        else {

            idouhokenkngkKytk = kykSyouhnList.get(0).getKihons();
            idoupKytk = hrkpKytk;
            idouptumitatekinKytk = ptumitatekinKytk;
            idoukiykhnriknKytk = kaiyakuhrgoukeiKytk;
        }

        if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(khozenCommonParam.getFunctionId()) ||
            IKhozenCommonConstants.KINOUID_GENGAKU.equals(khozenCommonParam.getFunctionId())) {

            IT_HokenKykIdouRireki hokenKykIdouRirekiBf = khTtdkRireki.createHokenKykIdouRireki();

            hokenKykIdouRirekiBf.setKyktuukasyu(kykSyouhnList.get(0).getKyktuukasyu());
            hokenKykIdouRirekiBf.setIdouymd(syoriYmd);
            hokenKykIdouRirekiBf.setIdoujiyuukbn(kusnmeIdoujiyuuKbn);
            hokenKykIdouRirekiBf.setTtdkrenno(ttdkRenno);
            hokenKykIdouRirekiBf.setKykymd(kykSyouhnList.get(0).getKykymd());
            hokenKykIdouRirekiBf.setHhknnen(kykSyouhnList.get(0).getHhknnen());
            hokenKykIdouRirekiBf.setHhknsei(kykSyouhnList.get(0).getHhknsei());
            hokenKykIdouRirekiBf.setHknsyukigou(kykSyouhnList.get(0).getSyouhncd().substring(0, 2));
            hokenKykIdouRirekiBf.setAisyoumeikbn(kykKihon.getAisyoumeikbn());
            hokenKykIdouRirekiBf.setZougenkbn(kusnmeZougenKbn);
            hokenKykIdouRirekiBf.setHokenkngk(kykSyouhnRirekiList.get(0).getKihons());
            hokenKykIdouRirekiBf.setHokenryou(kusnmeHrkpKytk);
            hokenKykIdouRirekiBf.setPtumitatekin(kusnmePtumitatekinKytk);
            hokenKykIdouRirekiBf.setKaiyakuhrgoukei(kusnmeKaiyakuhrgoukeiKytk);
            hokenKykIdouRirekiBf.setKaiyakuhr(kusnmeKaiyakuhrKytk);
            hokenKykIdouRirekiBf.setMikeikap(kusnmeMikeikapKytk);
            hokenKykIdouRirekiBf.setZennouseisankgk(kusnmeZennouseisankinKytk);
            hokenKykIdouRirekiBf.setIdouhokenkngk(kusnmeIdouhokenkngkKytk);
            hokenKykIdouRirekiBf.setIdoup(kusnmeIdoupKytk);
            hokenKykIdouRirekiBf.setIdouptumitatekin(kusnmeIdouptumitatekinKytk);
            hokenKykIdouRirekiBf.setIdoukiykhnrikn(kusnmeIdoukiykhnriknKytk);
            hokenKykIdouRirekiBf.setHknkkn(kykSyouhnList.get(0).getHknkkn());
            hokenKykIdouRirekiBf.setYoteiriritu(kykSyouhnList.get(0).getYoteiriritu());
            hokenKykIdouRirekiBf.setTumitatekinkbn(C_TumitatekinKbn.BLNK);
            hokenKykIdouRirekiBf.setKykidouharaikatakbn(kykIdouHaraikataKbn);
            hokenKykIdouRirekiBf.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            hokenKykIdouRirekiBf.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            hokenKykIdouRirekiBf.setGyoumuKousinTime(sysDateTime);
            BizPropertyInitializer.initialize(hokenKykIdouRirekiBf);
        }

        IT_HokenKykIdouRireki hokenKykIdouRirekiAf = khTtdkRireki.createHokenKykIdouRireki();

        hokenKykIdouRirekiAf.setKyktuukasyu(kykSyouhnList.get(0).getKyktuukasyu());
        hokenKykIdouRirekiAf.setIdouymd(syoriYmd);
        hokenKykIdouRirekiAf.setIdoujiyuukbn(idoujiyuuKbn);
        hokenKykIdouRirekiAf.setTtdkrenno(ttdkRenno);
        hokenKykIdouRirekiAf.setKykymd(kykSyouhnList.get(0).getKykymd());
        hokenKykIdouRirekiAf.setHhknnen(kykSyouhnList.get(0).getHhknnen());
        hokenKykIdouRirekiAf.setHhknsei(kykSyouhnList.get(0).getHhknsei());
        hokenKykIdouRirekiAf.setHknsyukigou(kykSyouhnList.get(0).getSyouhncd().substring(0, 2));
        hokenKykIdouRirekiAf.setAisyoumeikbn(kykKihon.getAisyoumeikbn());
        hokenKykIdouRirekiAf.setZougenkbn(zougenKbn);
        hokenKykIdouRirekiAf.setHokenkngk(kykSyouhnList.get(0).getKihons());
        hokenKykIdouRirekiAf.setHokenryou(hrkpKytk);
        hokenKykIdouRirekiAf.setPtumitatekin(ptumitatekinKytk);
        hokenKykIdouRirekiAf.setKaiyakuhrgoukei(kaiyakuhrgoukeiKytk);
        hokenKykIdouRirekiAf.setKaiyakuhr(kaiyakuhrKytk);
        hokenKykIdouRirekiAf.setMikeikap(mikeikapKytk);
        hokenKykIdouRirekiAf.setZennouseisankgk(zennouseisankinKytk);
        hokenKykIdouRirekiAf.setIdouhokenkngk(idouhokenkngkKytk);
        hokenKykIdouRirekiAf.setIdoup(idoupKytk);
        hokenKykIdouRirekiAf.setIdouptumitatekin(idouptumitatekinKytk);
        hokenKykIdouRirekiAf.setIdoukiykhnrikn(idoukiykhnriknKytk);
        hokenKykIdouRirekiAf.setHknkkn(kykSyouhnList.get(0).getHknkkn());
        hokenKykIdouRirekiAf.setYoteiriritu(kykSyouhnList.get(0).getYoteiriritu());
        hokenKykIdouRirekiAf.setTumitatekinkbn(C_TumitatekinKbn.BLNK);
        hokenKykIdouRirekiAf.setKykidouharaikatakbn(kykIdouHaraikataKbn);
        hokenKykIdouRirekiAf.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        hokenKykIdouRirekiAf.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        hokenKykIdouRirekiAf.setGyoumuKousinTime(sysDateTime);
        BizPropertyInitializer.initialize(hokenKykIdouRirekiAf);

        logger.debug("△ 保険契約異動情報履歴TBL編集 終了");
    }

    private KaiyakuHenreikinDataSksBean keisanWV(String pSyono,
        BizDate pCalcKijyunYmd,
        BizDateYM pKijyunYm,
        CurrencyType pKyktuukaType,
        IT_KykKihon pKykKihon,
        KykSyouhnCommonParam pKykSyouhnCommonParam,
        IT_AnsyuKihon pAnsyuKihon) {

        KaiyakuHenreikinDataSksBean kaiyakuHenreikinDataSksBean = SWAKInjector.getInstance(KaiyakuHenreikinDataSksBean.class);
        BizCurrency ssyPTumitatekinKytk = BizCurrency.valueOf(0, pKyktuukaType);
        BizCurrency ssyKaiyakuhrKytk = BizCurrency.valueOf(0, pKyktuukaType);
        int keikaNensuu = 0;
        int keikaMon = 0;

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        keisanWExtBean.setSyouhncd(pKykSyouhnCommonParam.getSyouhncd());
        keisanWExtBean.setSyouhnsdno(pKykSyouhnCommonParam.getSyouhnsdno());
        keisanWExtBean.setRyouritusdno(pKykSyouhnCommonParam.getRyouritusdno());
        keisanWExtBean.setYoteiriritu(pKykSyouhnCommonParam.getYoteiriritu());
        keisanWExtBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        keisanWExtBean.setHknkknsmnkbn(pKykSyouhnCommonParam.getHknkknsmnkbn());
        keisanWExtBean.setHknkkn(pKykSyouhnCommonParam.getHknkkn());
        keisanWExtBean.setHrkkkn(pKykSyouhnCommonParam.getHrkkkn());
        keisanWExtBean.setHrkkknsmnkbn(pKykSyouhnCommonParam.getHrkkknsmnkbn());
        keisanWExtBean.setHhknnen(pKykSyouhnCommonParam.getHhknnen());
        keisanWExtBean.setHhknsei(pKykSyouhnCommonParam.getHhknsei());
        keisanWExtBean.setKihons(pKykSyouhnCommonParam.getKihons());
        keisanWExtBean.setHokenryou(pKykSyouhnCommonParam.getHokenryou());
        keisanWExtBean.setKykymd(pKykSyouhnCommonParam.getKykymd());
        keisanWExtBean.setTuukasyu(pKykSyouhnCommonParam.getKyktuukasyu());
        keisanWExtBean.setJkipjytym(pAnsyuKihon.getJkipjytym());
        keisanWExtBean.setDai1hknkkn(pKykSyouhnCommonParam.getDai1hknkkn());
        keisanWExtBean.setKykJyoutai(pKykSyouhnCommonParam.getKykjyoutai());

        C_ErrorKbn keisanWErrorKbn = keisanW.exec(pCalcKijyunYmd, pKijyunYm, keisanWExtBean);

        if (C_ErrorKbn.ERROR.eq(keisanWErrorKbn)) {

            logger.warn("解約返戻金計算が実行できませんでした。");
            logger.warn("証券番号＝" + pSyono);
        }
        else {
            ssyKaiyakuhrKytk = keisanW.getW();
            keikaNensuu = keisanW.getKeikanensuu();
            keikaMon = keisanW.getKeikatukisuu();
        }

        KeisanV keisanV = SWAKInjector.getInstance(KeisanV.class);

        C_ErrorKbn keisanVErrorKbn = keisanV.exec(
            pCalcKijyunYmd,
            pKijyunYm,
            keisanWExtBean.getKykymd(),
            keisanWExtBean.getSyouhncd(),
            keisanWExtBean.getSyouhnsdno(),
            keisanWExtBean.getRyouritusdno(),
            keisanWExtBean.getYoteiriritu(),
            keisanWExtBean.getHrkkaisuu(),
            keisanWExtBean.getHhknsei(),
            keisanWExtBean.getHhknnen(),
            keisanWExtBean.getHknkknsmnkbn(),
            keisanWExtBean.getHknkkn(),
            keisanWExtBean.getHrkkknsmnkbn(),
            keisanWExtBean.getHrkkkn(),
            keisanWExtBean.getKihons(),
            keikaNensuu,
            keikaMon,
            keisanWExtBean.getTuukasyu(),
            keisanWExtBean.getHokenryou(),
            C_TyksenhokanhouKbn.RATE,
            keisanWExtBean.getKykJyoutai(),
            keisanWExtBean.getDai1hknkkn());

        if (C_ErrorKbn.ERROR.eq(keisanVErrorKbn)) {

            logger.warn("保険料積立金計算が実行できませんでした。");
            logger.warn("証券番号＝" + pSyono);
        }
        else {
            ssyPTumitatekinKytk = keisanV.getV();
        }

        kaiyakuHenreikinDataSksBean.setSsyPTumitatekin(ssyPTumitatekinKytk);
        kaiyakuHenreikinDataSksBean.setSsyKaiyakuhr(ssyKaiyakuhrKytk);

        return kaiyakuHenreikinDataSksBean;
    }

    private MikeikaPDataSksBean keisanZnnusisnMikkP(String pSyono,
        BizDate pCalcKijyunYmd,
        CurrencyType pKyktuukaType,
        KykSyouhnCommonParam pKykSyouhnCommonParam,
        IT_AnsyuKihon pAnsyuKihon,
        C_HnkzengoKbn pHnkzengoKbn) {

        MikeikaPDataSksBean mikeikaPDataSksBean = SWAKInjector.getInstance(MikeikaPDataSksBean.class);
        BizCurrency ssyMikeikapKytk = BizCurrency.valueOf(0, pKyktuukaType);
        BizCurrency ssyZennouseisankinKytk = BizCurrency.valueOf(0, pKyktuukaType);
        BizDateYM jkipjytYm = null;

        IT_Zennou zennoutbl = new IT_Zennou();


        if (C_Kykjyoutai.ZENNOU.eq(pKykSyouhnCommonParam.getKykjyoutai())) {

            if (BizDateUtil.compareYmd(pCalcKijyunYmd, BizDate.valueOf(pAnsyuKihon.getJkipjytym(),
                pKykSyouhnCommonParam.getKykymd().getDay()).getRekijyou()) == BizDateUtil.COMPARE_LESSER) {


                SortIT_Zennou sortIT_Zennoutbl = SWAKInjector.getInstance(SortIT_Zennou.class);
                List<IT_Zennou> zennoutblList = pAnsyuKihon.getZennous();
                zennoutblList = sortIT_Zennoutbl.OrderIT_ZennouByPkDesc(zennoutblList);
                zennoutbl = zennoutblList.get(0);

                KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

                C_ErrorKbn keisanZennouSeisanGkErrorKbn = keisanZennouSeisanGk2.exec(
                    pCalcKijyunYmd,
                    pKykSyouhnCommonParam.getKykymd(),
                    zennoutbl.getZennoujihrkp(),
                    zennoutbl.getZennoukaisiymd(),
                    zennoutbl.getRyosyuymd(),
                    zennoutbl.getZennounyuukinkgk());

                if (C_ErrorKbn.ERROR.eq(keisanZennouSeisanGkErrorKbn)) {

                    logger.warn("前納精算額計算２が実行できませんでした。");
                    logger.warn("証券番号＝" + pSyono);
                }
                else {
                    ssyZennouseisankinKytk = keisanZennouSeisanGk2.getZennouSeisanGk();
                    jkipjytYm = keisanZennouSeisanGk2.getLastPJyuutouYm().addYears(1);
                }
            }
            else {

                jkipjytYm = pAnsyuKihon.getJkipjytym();
            }
        }
        else {

            jkipjytYm = pAnsyuKihon.getJkipjytym();
        }

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);

        if (C_HnkzengoKbn.ZEN.eq(pHnkzengoKbn)) {

            keisanMsyMkeiP.execKyknaiyouSitei(pSyono, pCalcKijyunYmd, jkipjytYm, pKykSyouhnCommonParam.getHokenryou(), C_MisyuptsKbn.MITS,
                pKykSyouhnCommonParam.getKihons(), pKykSyouhnCommonParam.getHhknnen(), pKykSyouhnCommonParam.getHhknsei(), pKykSyouhnCommonParam.getHrkkkn());

            ssyMikeikapKytk = keisanMsyMkeiP.getMikeikaP();
        }
        else if (C_HnkzengoKbn.GO.eq(pHnkzengoKbn)) {

            keisanMsyMkeiP.exec(pSyono, pCalcKijyunYmd, jkipjytYm, pKykSyouhnCommonParam.getHokenryou(), C_MisyuptsKbn.MITS);

            ssyMikeikapKytk = keisanMsyMkeiP.getMikeikaP();
        }

        mikeikaPDataSksBean.setSsyMikeikap(ssyMikeikapKytk);
        mikeikaPDataSksBean.setSsyZennouseisankin(ssyZennouseisankinKytk);

        return mikeikaPDataSksBean;
    }

    private MikeikaPDataSksBean keisanZnnusisnMikkPKykInfo(BizDate pCalcKijyunYmd,
        CurrencyType pKyktuukaType,
        IT_KykKihon pKykKihon,
        IT_KykSyouhn pKykSyouhn,
        IT_AnsyuKihon pAnsyuKihon,
        IT_Zennou pZennou) {

        MikeikaPDataSksBean mikeikaPDataSksBean = SWAKInjector.getInstance(MikeikaPDataSksBean.class);
        BizCurrency ssyMikeikapKytk = BizCurrency.valueOf(0, pKyktuukaType);
        BizCurrency ssyZennouseisankinKytk = BizCurrency.valueOf(0, pKyktuukaType);

        if (C_Kykjyoutai.ZENNOU.eq(pKykSyouhn.getKykjyoutai())) {

            if (BizDateUtil.compareYmd(pCalcKijyunYmd, BizDate.valueOf(pAnsyuKihon.getJkipjytym(),
                pKykSyouhn.getKykymd().getDay()).getRekijyou()) == BizDateUtil.COMPARE_LESSER) {
                KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

                C_ErrorKbn keisanZennouSeisanGkErrorKbn = keisanZennouSeisanGk2.exec(
                    pCalcKijyunYmd,
                    pKykSyouhn.getKykymd(),
                    pZennou.getZennoujihrkp(),
                    pZennou.getZennoukaisiymd(),
                    pZennou.getRyosyuymd(),
                    pZennou.getZennounyuukinkgk());

                if (C_ErrorKbn.ERROR.eq(keisanZennouSeisanGkErrorKbn)) {

                    logger.warn("前納精算額計算２が実行できませんでした。");
                    logger.warn("証券番号＝" + pKykKihon.getSyono());
                }
                else {
                    ssyZennouseisankinKytk = keisanZennouSeisanGk2.getZennouSeisanGk();
                }
            }
        }

        int keikamon = 0;

        if (BizDateUtil.compareYmd(pCalcKijyunYmd, pKykSyouhn.getKykymd()) == BizDateUtil.COMPARE_GREATER) {

            keikamon = getKeikaYm(pCalcKijyunYmd, pKykSyouhn.getKykymd()).getKeikamon();
        }
        else {

            keikamon = 1;
        }

        KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
        KeisanIkkatuPGkBean keisanIkkatuPGkBean = SWAKInjector.getInstance(KeisanIkkatuPGkBean.class);

        keisanIkkatuPGkBean.setSyouhnCd(pKykSyouhn.getSyouhncd());
        keisanIkkatuPGkBean.setSyouhnsdNo(pKykSyouhn.getSyouhnsdno());
        keisanIkkatuPGkBean.setRyouritusdNo(pKykSyouhn.getRyouritusdno());
        keisanIkkatuPGkBean.setHokenryou(pKykSyouhn.getHokenryou());
        keisanIkkatuPGkBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        keisanIkkatuPGkBean.setKeikamon(keikamon);
        keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
        keisanIkkatuPGkBean.setYoteiRiritu(pKykSyouhn.getYoteiriritu());
        keisanIkkatuPGkBean.setHhknnen(pKykSyouhn.getHhknnen());
        keisanIkkatuPGkBean.setHhknsei(pKykSyouhn.getHhknsei());
        keisanIkkatuPGkBean.setHknkknsmnKbn(pKykSyouhn.getHknkknsmnkbn());
        keisanIkkatuPGkBean.setHknkkn(pKykSyouhn.getHknkkn());
        keisanIkkatuPGkBean.setHrkkkn(pKykSyouhn.getHrkkkn());
        keisanIkkatuPGkBean.setHokenkngk(pKykSyouhn.getKihons());
        keisanIkkatuPGkBean.setKykTuukasyu(pKykSyouhn.getKyktuukasyu());
        keisanIkkatuPGkBean.setKykjyoutai(pKykSyouhn.getKykjyoutai());
        keisanIkkatuPGkBean.setDai1hknkkn(pKykSyouhn.getDai1hknkkn());
        keisanIkkatuPGkBean.setHrkkeiro(pKykKihon.getHrkkeiro());

        C_ErrorKbn keisanIkkatuPGkErrorKbn = keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false);

        if (C_ErrorKbn.ERROR.eq(keisanIkkatuPGkErrorKbn)) {

            logger.warn("一括払Ｐ計算が実行できませんでした。");
            logger.warn("証券番号＝" + pKykKihon.getSyono());
        }
        else {
            BizCurrency keikabunP = keisanIkkatuPGk.getIkkatuP();
            ssyMikeikapKytk = pKykSyouhn.getHokenryou().subtract(keikabunP);
        }

        mikeikaPDataSksBean.setSsyMikeikap(ssyMikeikapKytk);
        mikeikaPDataSksBean.setSsyZennouseisankin(ssyZennouseisankinKytk);

        return mikeikaPDataSksBean;
    }

    private BizCurrency editSeiritujiHrkp(BizDate pSyoriymd,
        C_Hrkkaisuu pHrkkaisuu,
        C_Kykjyoutai pKykJyoutai,
        BizDate pKykymd,
        CurrencyType pKyktuukaType,
        BizCurrency pHokenryou,
        BizCurrency pZennoujiHrkp,
        BizCurrency pZnnunyukngk) {

        BizCurrency seiritujiHrkpKytk = BizCurrency.valueOf(0, pKyktuukaType);

        if (C_Kykjyoutai.ZENNOU.eq(pKykJyoutai)) {

            seiritujiHrkpKytk = pZennoujiHrkp.add(pZnnunyukngk);
        }
        else if (C_Kykjyoutai.HRKMTYUU.eq(pKykJyoutai)) {

            if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {

                if (BizDateUtil.compareYmd(pSyoriymd, pKykymd) == BizDateUtil.COMPARE_GREATER) {

                    int keikanensuu = getKeikaYm(pSyoriymd, pKykymd).getKeikanensuu();
                    int keikamon = getKeikaYm(pSyoriymd, pKykymd).getKeikamon();

                    JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);
                    jtKaisukeisan.exec(keikanensuu, keikamon, pHrkkaisuu);
                    int jyutouKaisuu = jtKaisukeisan.getJyutoukaisuu();

                    seiritujiHrkpKytk = pHokenryou.multiply(jyutouKaisuu);
                }
                else {

                    seiritujiHrkpKytk = pHokenryou;
                }
            }
            else if (C_Hrkkaisuu.NEN.eq(pHrkkaisuu) ||
                C_Hrkkaisuu.HALFY.eq(pHrkkaisuu)) {

                seiritujiHrkpKytk = pHokenryou;
            }
        }

        return seiritujiHrkpKytk;
    }

    private C_ZfiIdoujiyuuKbn editIdoujiyuuKbn(String pKinouIdo, C_SyoriKbn pSyoriKbn) {

        C_ZfiIdoujiyuuKbn idoujiyuuKbn = null;

        if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pKinouIdo)) {

            idoujiyuuKbn = C_ZfiIdoujiyuuKbn.SINKEIYAKU;
        }
        else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pKinouIdo) ||
            IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pKinouIdo)) {

            idoujiyuuKbn = C_ZfiIdoujiyuuKbn.KAIYAKU;
        }
        else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pKinouIdo)) {

            idoujiyuuKbn = C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU;
        }
        else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pKinouIdo)) {

            idoujiyuuKbn = C_ZfiIdoujiyuuKbn.GENGAKUNEW;
        }
        else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pKinouIdo)) {

            idoujiyuuKbn = C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW;
        }
        else if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(pKinouIdo)) {
            if (C_SyoriKbn.KYKTORIKESI.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.KEIYAKUTORIKESI;
            }
            else if (C_SyoriKbn.CLGOFF.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.COOLINGOFF;
            }
            else if (C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMUKOUKIBARAIPSHR;
            }
            else if (C_SyoriKbn.SBMUKOU_SHRNASI.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI;
            }
            else if (C_SyoriKbn.KAIJO.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.KAIJYO;
            }
            else if (C_SyoriKbn.MUKOU.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.MUKOU;
            }
            else if (C_SyoriKbn.SBKAIJO.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUKAIJYO;
            }
            else if (C_SyoriKbn.SBMENSEKI.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMENSEKI;
            }
            else if (C_SyoriKbn.SBMENSEKI_SHRNASI.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMENSEKISHRNASI;
            }
        }
        else if (IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(pKinouIdo)) {
            if (C_SyoriKbn.SIBOU.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOU;
            }
            else if (C_SyoriKbn.SBMUKOU.eq(pSyoriKbn)) {

                idoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI;
            }
        }

        return idoujiyuuKbn;
    }

    private C_KykIdouHaraikataKbn editHokenKykIdouHaraikataKbn(C_Hrkkaisuu pHrkkaisuu, C_Kykjyoutai pKykjyoutai) {

        C_KykIdouHaraikataKbn kykIdouHaraikataKbn = null;

        if (C_Kykjyoutai.ZENNOU.eq(pKykjyoutai)) {

            kykIdouHaraikataKbn = C_KykIdouHaraikataKbn.ZENNOU;
        }
        else if (C_Kykjyoutai.HRKMTYUU.eq(pKykjyoutai)) {

            if (C_Hrkkaisuu.NEN.eq(pHrkkaisuu)) {

                kykIdouHaraikataKbn = C_KykIdouHaraikataKbn.NEN;
            }
            else if (C_Hrkkaisuu.HALFY.eq(pHrkkaisuu)) {

                kykIdouHaraikataKbn = C_KykIdouHaraikataKbn.HALFY;
            }
            else if (C_Hrkkaisuu.TUKI.eq(pHrkkaisuu)) {

                kykIdouHaraikataKbn = C_KykIdouHaraikataKbn.TUKI;
            }
        }
        else if (C_Kykjyoutai.ITIJIBARAI.eq(pKykjyoutai)) {

            kykIdouHaraikataKbn = C_KykIdouHaraikataKbn.ITIJI;
        }

        return kykIdouHaraikataKbn;
    }

    private KeikaYmBean getKeikaYm(BizDate pSyoriYmd, BizDate pKykYmd) {

        int keikaYmTukikansan = 0;

        if (pSyoriYmd.getDay() >= pKykYmd.getDay()) {
            keikaYmTukikansan = BizDateUtil.calcDifferenceMonths(pSyoriYmd.getBizDateYM().getNextMonth(), pKykYmd.getBizDateYM());
        }
        else {
            keikaYmTukikansan = BizDateUtil.calcDifferenceMonths(pSyoriYmd.getBizDateYM(), pKykYmd.getBizDateYM());
        }
        int keikanensuuSeritutien = keikaYmTukikansan / 12;
        int keikamonSeritutien = 0;

        if (keikanensuuSeritutien > 0) {

            keikamonSeritutien = keikaYmTukikansan % 12;
        }
        else {

            keikamonSeritutien = keikaYmTukikansan;
        }

        KeikaYmBean keikaYmBean = SWAKInjector.getInstance(KeikaYmBean.class);

        keikaYmBean.setKeikanensuu(keikanensuuSeritutien);
        keikaYmBean.setKeikamon(keikamonSeritutien);

        return keikaYmBean;
    }
}
