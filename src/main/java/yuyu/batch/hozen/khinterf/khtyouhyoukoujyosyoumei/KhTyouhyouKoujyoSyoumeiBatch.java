package yuyu.batch.hozen.khinterf.khtyouhyoukoujyosyoumei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khtyouhyoukoujyosyoumei.dba.KhTyouhyouKoujyoSyoumeiDao;
import yuyu.batch.hozen.khinterf.khtyouhyoukoujyosyoumei.dba.KoujyoSymDataBean;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.hozen.khcommon.AnsyuKokTyouhyouHensyuu;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.ZT_KoujyoSyoumeiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_SaihkHyjKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス 控除証明書Ｆ作成
 */
public class KhTyouhyouKoujyoSyoumeiBatch implements Batch {

    private final String TABLE_ID = "IT_KoujyoSym";

    private final String FILTER_ID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhTyouhyouKoujyoSyoumeiBatchParam khTyouhyouKoujyoSyoumeiBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private KhTyouhyouKoujyoSyoumeiDao khTyouhyouKoujyoSyoumeiDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return khTyouhyouKoujyoSyoumeiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        long syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, khTyouhyouKoujyoSyoumeiBatchParam.getHeisoukbn()));

        try (ExDBResults<KoujyoSymDataBean> koujyoSymDataBeanLst = khTyouhyouKoujyoSyoumeiDao.getKoujyoSymsByKakutyoujobcdTyouhyouymdKbnkey(
            khTyouhyouKoujyoSyoumeiBatchParam.getIbKakutyoujobcd(),
            khTyouhyouKoujyoSyoumeiBatchParam.getSyoriYmd(),
            khTyouhyouKoujyoSyoumeiBatchParam.getHeisoukbn());

            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokanLst = new EntityInserter<>();
            EntityInserter<ZT_KoujyoSyoumeiTy> koujyoSyoumeiTyLst = new EntityInserter<>()) {

            for (KoujyoSymDataBean koujyoSymDataBean : koujyoSymDataBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(khTyouhyouKoujyoSyoumeiBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(koujyoSymDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(koujyoSymDataBean.getSyono());

                String prenno = koujyoSymDataBean.getKbnkey().substring(1, 2)
                    + BizUtil.zeroNum(String.valueOf(syoriKensuu + 1), 6, 0);

                String hnskariyuu = "000";

                AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(
                    AnsyuuSetTetudukityuuiInfo.class);

                AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu = SWAKInjector.getInstance(
                    AnsyuKokTyouhyouHensyuu.class);

                C_HassouKbn hassouKbn = koujyoSymDataBean.getHassoukbn();

                String uktmidasi = "";

                String midasisub = "";

                C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(koujyoSymDataBean.getSyono());

                if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    hnskariyuu = "Z01";
                }

                ansyuKokTyouhyouHensyuu.exec(
                    koujyoSymDataBean.getSyono(),
                    prenno,
                    C_AsTyouhyoukigouKbn.KK_KOUJYOSYOUMEIS_GAIBU,
                    hnskariyuu);

                String sakuseiNo = ansyuKokTyouhyouHensyuu.getSakuseino();

                String sclatoSyono = ansyuKokTyouhyouHensyuu.getSclatoSyono();

                if (!C_HassouKbn.HONSYAKAISOU.eq(hassouKbn) && C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                }

                if (C_UmuKbn.NONE.eq(koujyoSymDataBean.getKjnnkkoujyum())) {

                    uktmidasi = "保険金";
                }
                else {

                    uktmidasi = "　年金";
                }

                if (C_SaihkHyjKbn.HYOUJI.eq(koujyoSymDataBean.getSaihkhyjkbn())) {

                    midasisub = "－再発行－";
                }

                String ippanJissekiSyoumeigk = "";
                String newHknJytuKikan = "";
                String newIryouJissekiSymgk = "";
                String newIppanJissekiHaitoukin = "";
                String newIryouJissekip = "";
                String newIryouJissekiHaitoukin = "";
                String newNkJissekip = "";
                String newNkJissekiHaitoukin = "";
                String newNkJissekiSyoumeigk = "";
                String newIppanNenkanp = "";
                String newIppanNenkanHaitoukin = "";
                String newIppanNenkanSyoumeigk = "";
                String newIryouNenkanp = "";
                String newIryouNenkanHaitoukin = "";
                String newIryouNenkanSyoumeigk = "";
                String newNkNenkanp = "";
                String newNkNenkanHaitoukin = "";
                String newNkNenkanSyoumeigk = "";
                String newIppanJissekip = "";
                int maskinglength  = 0;

                if (C_UmuKbn.ARI.eq(koujyoSymDataBean.getNewsyoumeigkumukbn())) {

                    if (BizUtil.isZero(koujyoSymDataBean.getNewippanjissekisyoumeigk())) {

                        ippanJissekiSyoumeigk = "**********";
                    }
                    else {

                        if (koujyoSymDataBean.getNewippanjissekisyoumeigk().compareTo(
                            BizCurrency.valueOf(0, koujyoSymDataBean.getNewippanjissekisyoumeigk().getType())) > 0) {

                            maskinglength = 10 - koujyoSymDataBean.getNewippanjissekisyoumeigk().toString().length();

                            ippanJissekiSyoumeigk = BizUtil.editMask(
                                BizUtil.zeroNum(koujyoSymDataBean.getNewippanjissekisyoumeigk().toString(), 10, 0),
                                0,
                                maskinglength,
                                '*');
                        }
                        else {

                            ippanJissekiSyoumeigk = Strings.padStart(
                                koujyoSymDataBean.getNewippanjissekisyoumeigk().toString(),
                                10,
                                ' ');
                        }
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewiryoujissekisyoumeigk())) {

                        newIryouJissekiSymgk = "**********";
                    }
                    else {

                        if (koujyoSymDataBean.getNewiryoujissekisyoumeigk().compareTo(
                            BizCurrency.valueOf(0, koujyoSymDataBean.getNewiryoujissekisyoumeigk().getType())) > 0) {

                            maskinglength = 10 - koujyoSymDataBean.getNewiryoujissekisyoumeigk().toString().length();

                            newIryouJissekiSymgk = BizUtil.editMask(
                                BizUtil.zeroNum(koujyoSymDataBean.getNewiryoujissekisyoumeigk().toString(), 10, 0),
                                0,
                                maskinglength,
                                '*');
                        }
                        else {

                            newIryouJissekiSymgk = Strings.padStart(
                                koujyoSymDataBean.getNewiryoujissekisyoumeigk().toString(),
                                10,
                                ' ');
                        }
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewnkjissekisyoumeigk())) {

                        newNkJissekiSyoumeigk = "**********";
                    }
                    else {

                        if (koujyoSymDataBean.getNewnkjissekisyoumeigk().compareTo(
                            BizCurrency.valueOf(0, koujyoSymDataBean.getNewnkjissekisyoumeigk().getType())) > 0) {

                            maskinglength = 10 - koujyoSymDataBean.getNewnkjissekisyoumeigk().toString().length();

                            newNkJissekiSyoumeigk = BizUtil.editMask(
                                BizUtil.zeroNum(koujyoSymDataBean.getNewnkjissekisyoumeigk().toString(), 10, 0),
                                0,
                                maskinglength,
                                '*');
                        }
                        else {

                            newNkJissekiSyoumeigk = Strings.padStart(
                                koujyoSymDataBean.getNewnkjissekisyoumeigk().toString(),
                                10,
                                ' ');
                        }
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewippannenkansyoumeigk())) {

                        newIppanNenkanSyoumeigk = "**********";
                    }
                    else {

                        if (koujyoSymDataBean.getNewippannenkansyoumeigk().compareTo(
                            BizCurrency.valueOf(0, koujyoSymDataBean.getNewippannenkansyoumeigk().getType())) > 0) {

                            maskinglength = 10 - koujyoSymDataBean.getNewippannenkansyoumeigk().toString().length();

                            newIppanNenkanSyoumeigk = BizUtil.editMask(
                                BizUtil.zeroNum(koujyoSymDataBean.getNewippannenkansyoumeigk().toString(), 10, 0),
                                0,
                                maskinglength,
                                '*');
                        }
                        else {

                            newIppanNenkanSyoumeigk = Strings.padStart(
                                koujyoSymDataBean.getNewippannenkansyoumeigk().toString(),
                                10,
                                ' ');
                        }
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewiryounenkansyoumeigk())) {

                        newIryouNenkanSyoumeigk = "**********";
                    }
                    else {

                        if (koujyoSymDataBean.getNewiryounenkansyoumeigk().compareTo(
                            BizCurrency.valueOf(0, koujyoSymDataBean.getNewiryounenkansyoumeigk().getType())) > 0) {

                            maskinglength = 10 - koujyoSymDataBean.getNewiryounenkansyoumeigk().toString().length();

                            newIryouNenkanSyoumeigk = BizUtil.editMask(
                                BizUtil.zeroNum(koujyoSymDataBean.getNewiryounenkansyoumeigk().toString(), 10, 0),
                                0,
                                maskinglength,
                                '*');
                        }
                        else {

                            newIryouNenkanSyoumeigk = Strings.padStart(
                                koujyoSymDataBean.getNewiryounenkansyoumeigk().toString(),
                                10,
                                ' ');
                        }
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewnknenkansyoumeigk())) {

                        newNkNenkanSyoumeigk = "**********";
                    }
                    else {

                        if (koujyoSymDataBean.getNewnknenkansyoumeigk().compareTo(
                            BizCurrency.valueOf(0, koujyoSymDataBean.getNewnknenkansyoumeigk().getType())) > 0) {

                            maskinglength = 10 - koujyoSymDataBean.getNewnknenkansyoumeigk().toString().length();

                            newNkNenkanSyoumeigk = BizUtil.editMask(
                                BizUtil.zeroNum(koujyoSymDataBean.getNewnknenkansyoumeigk().toString(), 10, 0),
                                0,
                                maskinglength,
                                '*');
                        }
                        else {

                            newNkNenkanSyoumeigk = Strings.padStart(
                                koujyoSymDataBean.getNewnknenkansyoumeigk().toString(),
                                10,
                                ' ');
                        }
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewippanjissekip())) {

                        newIppanJissekip = "";
                    }
                    else {
                        newIppanJissekip = koujyoSymDataBean.getNewippanjissekip().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewippanjissekihaitoukin())) {

                        newIppanJissekiHaitoukin = "";
                    }
                    else {
                        newIppanJissekiHaitoukin = koujyoSymDataBean.getNewippanjissekihaitoukin().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewiryoujissekip())) {

                        newIryouJissekip = "";
                    }
                    else {
                        newIryouJissekip = koujyoSymDataBean.getNewiryoujissekip().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewiryoujissekihaitoukin())) {

                        newIryouJissekiHaitoukin = "";
                    }
                    else {
                        newIryouJissekiHaitoukin = koujyoSymDataBean.getNewiryoujissekihaitoukin().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewnkjissekip())) {

                        newNkJissekip = "";
                    }
                    else {
                        newNkJissekip = koujyoSymDataBean.getNewnkjissekip().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewnkjissekihaitoukin())) {

                        newNkJissekiHaitoukin = "";
                    }
                    else {
                        newNkJissekiHaitoukin = koujyoSymDataBean.getNewnkjissekihaitoukin().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewippannenkanp())) {

                        newIppanNenkanp = "";
                    }
                    else {
                        newIppanNenkanp = koujyoSymDataBean.getNewippannenkanp().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewippannenkanhaitoukin())) {

                        newIppanNenkanHaitoukin = "";
                    }
                    else {
                        newIppanNenkanHaitoukin = koujyoSymDataBean.getNewippannenkanhaitoukin().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewiryounenkanp())) {

                        newIryouNenkanp = "";
                    }
                    else {
                        newIryouNenkanp = koujyoSymDataBean.getNewiryounenkanp().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewiryounenkanhaitoukin())) {

                        newIryouNenkanHaitoukin = "";
                    }
                    else {
                        newIryouNenkanHaitoukin = koujyoSymDataBean.getNewiryounenkanhaitoukin().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewnknenkanp())) {

                        newNkNenkanp = "";
                    }
                    else {
                        newNkNenkanp = koujyoSymDataBean.getNewnknenkanp().toString();
                    }

                    if (BizUtil.isZero(koujyoSymDataBean.getNewnknenkanhaitoukin())) {

                        newNkNenkanHaitoukin = "";
                    }
                    else {
                        newNkNenkanHaitoukin = koujyoSymDataBean.getNewnknenkanhaitoukin().toString();
                    }

                    if (BizNumber.valueOf(99).compareTo(koujyoSymDataBean.getHknkknsyu()) == 0) {

                        newHknJytuKikan = "終身";
                    }
                    else if (C_Kykjyoutai.ITIJIBARAI.eq(koujyoSymDataBean.getKykjyoutai())) {

                        newHknJytuKikan = FixedDateFormatter.formatYMZenkakuSeirekiKanji(koujyoSymDataBean.getKykymd())
                            + "から" +
                            ConvertUtil.toZenAll(koujyoSymDataBean.getHknkknsyu().toString(), 0, 0) + "年分";
                    }
                    else if (koujyoSymDataBean.getSyoumeikknnensuu() == 0 && koujyoSymDataBean.getSyoumeikkntukisuu() == 0) {

                        if (C_UmuKbn.NONE.eq(koujyoSymDataBean.getKjnnkkoujyum())) {

                            newHknJytuKikan = "入金なし";
                        }
                        else {

                            newHknJytuKikan = FixedDateFormatter.formatYMZenkakuSeirekiKanji(koujyoSymDataBean
                                .getSyoumeistartym().getFirstDay()) + "から入金なし";
                        }
                    }
                    else {

                        newHknJytuKikan = FixedDateFormatter.formatYMZenkakuSeirekiKanji(koujyoSymDataBean
                            .getSyoumeistartym().getFirstDay()) + "から";

                        if (koujyoSymDataBean.getSyoumeikknnensuu() != 0) {

                            newHknJytuKikan = newHknJytuKikan + ConvertUtil.toZenAll(
                                koujyoSymDataBean.getSyoumeikknnensuu().toString(), 0, 0) + "年";
                        }
                        if (koujyoSymDataBean.getSyoumeikkntukisuu() % 12 != 0) {

                            newHknJytuKikan = newHknJytuKikan + ConvertUtil.toZenAll(
                                String.valueOf(koujyoSymDataBean.getSyoumeikkntukisuu() % 12), 0, 0) + "か月";
                        }

                        newHknJytuKikan = newHknJytuKikan + "分";
                    }
                }
                else {
                    ippanJissekiSyoumeigk = "**********";

                    newHknJytuKikan = "＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊";

                    newIryouJissekiSymgk = "**********";

                    newNkJissekiSyoumeigk = "**********";

                    newIppanNenkanSyoumeigk = "**********";

                    newIryouNenkanSyoumeigk = "**********";

                    newNkNenkanSyoumeigk = "**********";

                }

                String phrkkknJyoutai = "";

                if ( koujyoSymDataBean.getNenkanhrkkaisuu() == 12) {

                    if (C_Kykjyoutai.HARAIMAN.eq(koujyoSymDataBean.getKykjyoutai())) {

                        phrkkknJyoutai = "払込停止";
                    }
                    else if (C_YuukousyoumetuKbn.SYOUMETU.eq(koujyoSymDataBean.getYuukousyoumetukbn())) {

                        phrkkknJyoutai = "払込停止";
                    }
                    else if (C_Kykjyoutai.HRKMTYUU.eq(koujyoSymDataBean.getKykjyoutai())
                        || C_Kykjyoutai.IKKATUNK.eq(koujyoSymDataBean.getKykjyoutai())) {

                        phrkkknJyoutai = "払込中";
                    }
                    else {

                        phrkkknJyoutai = "払込停止";
                    }
                }
                else {

                    phrkkknJyoutai = "＊＊＊＊";
                }

                ZT_KoujyoSyoumeiTy koujyoSyoumeiTy = new ZT_KoujyoSyoumeiTy();
                koujyoSyoumeiTy.setZtysyoruicd(C_SyoruiCdKbn.KK_KOUJYOSYOUMEIS.toString().toUpperCase());
                if (koujyoSymDataBean.getTyouhyouymd() != null) {
                    koujyoSyoumeiTy.setZtytyouhyouymd(koujyoSymDataBean.getTyouhyouymd().toString());
                }
                koujyoSyoumeiTy.setZtysyono(koujyoSymDataBean.getSyono());
                koujyoSyoumeiTy.setZtyhassoukbn(hassouKbn.toString());
                koujyoSyoumeiTy.setZtykoujyosyoumeisentakukbn(koujyoSymDataBean.getKoujyosyoumeisentakukbn().toString());
                koujyoSyoumeiTy.setZtyshskyno(koujyoSymDataBean.getTsinyno());
                koujyoSyoumeiTy.setZtyshskadr1kj(koujyoSymDataBean.getTsinadr1kj());
                koujyoSyoumeiTy.setZtyshskadr2kj(koujyoSymDataBean.getTsinadr2kj());
                koujyoSyoumeiTy.setZtyshskadr3kj(koujyoSymDataBean.getTsinadr3kj());
                koujyoSyoumeiTy.setZtyshsnmkj(koujyoSymDataBean.getKyknmkj());
                koujyoSyoumeiTy.setZtykyknmkn(koujyoSymDataBean.getKyknmkn());
                koujyoSyoumeiTy.setZtyuktnmkn(koujyoSymDataBean.getUktnmkn());
                koujyoSyoumeiTy.setZtytawsosikikj(koujyoSymDataBean.getToiawasesosikinmkj());
                koujyoSyoumeiTy.setZtytawyno(koujyoSymDataBean.getToiawaseyno());
                koujyoSyoumeiTy.setZtytawadr1kj(koujyoSymDataBean.getToiawaseadr1kj());
                koujyoSyoumeiTy.setZtytawadr2kj(koujyoSymDataBean.getToiawaseadr2kj());
                koujyoSyoumeiTy.setZtytawadr3kj(koujyoSymDataBean.getToiawaseadr3kj());
                koujyoSyoumeiTy.setZtytawtelnov14(koujyoSymDataBean.getToiawasetelno());
                koujyoSyoumeiTy.setZtysclatosyono(sclatoSyono);
                koujyoSyoumeiTy.setZtysakunm15keta(sakuseiNo);
                koujyoSyoumeiTy.setZtykyknmkj(koujyoSymDataBean.getKyknmkj());
                if (!BizUtil.isBlank(koujyoSymDataBean.getNendo())) {

                    koujyoSyoumeiTy.setZtysyoumeinndseireki(
                        FixedDateFormatter.formatYZenkakuSeirekiKanji(
                            BizDate.valueOf(koujyoSymDataBean.getNendo().concat("0101"))));
                }
                koujyoSyoumeiTy.setZtyuktnmknmeikj(koujyoSymDataBean.getUktnmkjaddsama());
                if (koujyoSymDataBean.getNenkinuktseiymd() != null) {

                    koujyoSyoumeiTy.setZtynenkinuktseiymdseireki(
                        FixedDateFormatter.formatYMDZenkakuSeirekiKanji(koujyoSymDataBean.getNenkinuktseiymd()));
                }
                koujyoSyoumeiTy.setZtysyono3(koujyoSymDataBean.getSyono());
                koujyoSyoumeiTy.setZtyhknsyurui(koujyoSymDataBean.getHknsyuruinmrykkj());
                koujyoSyoumeiTy.setZtynknshrynnm(Strings.padStart(koujyoSymDataBean.getNknshry(), 2, ' '));
                if (koujyoSymDataBean.getKykymd() != null) {

                    koujyoSyoumeiTy.setZtykykymdseireki(
                        FixedDateFormatter.formatYMDZenkakuSeirekiKanji(koujyoSymDataBean.getKykymd()));
                }
                koujyoSyoumeiTy.setZtyhtkinuthoukbn(koujyoSymDataBean.getHaitoukinuketorihoukbn().toString());
                koujyoSyoumeiTy.setZtyhknkknnm(Strings.padStart(koujyoSymDataBean.getHknkknsyu().toString(), 2, ' '));
                if (koujyoSymDataBean.getNkshrstartymd() != null) {

                    koujyoSyoumeiTy.setZtynkshrstartymdseireki(
                        FixedDateFormatter.formatYMDZenkakuSeirekiKanji(koujyoSymDataBean.getNkshrstartymd()));
                }
                koujyoSyoumeiTy.setZtyphrkkkn(Strings.padStart(koujyoSymDataBean.getPhrkkkn().toString(), 2, ' '));
                koujyoSyoumeiTy.setZtyhrkkaisuunm(koujyoSymDataBean.getNenkanhrkkaisuu().toString());
                koujyoSyoumeiTy.setZtykjnnkkoujyum(String.valueOf(koujyoSymDataBean.getKjnnkkoujyum().getValue()));
                koujyoSyoumeiTy.setZtyuktmidasi(uktmidasi);
                koujyoSyoumeiTy.setZtymidasisub(midasisub);
                koujyoSyoumeiTy.setZtykoujyosyoumeimsgkbn(koujyoSymDataBean.getKoujyosyoumeimsgkbn().getValue());
                koujyoSyoumeiTy.setZtyippanseimeip(newIppanJissekip);
                koujyoSyoumeiTy.setZtyippanhaitoukin(newIppanJissekiHaitoukin);
                koujyoSyoumeiTy.setZtyippansyoumeigk(ippanJissekiSyoumeigk);
                koujyoSyoumeiTy.setZtykaigoiryoup(newIryouJissekip);
                koujyoSyoumeiTy.setZtykaigoiryoud(newIryouJissekiHaitoukin);
                koujyoSyoumeiTy.setZtykaigoiryousmgk(newIryouJissekiSymgk);
                koujyoSyoumeiTy.setZtynenkinp(newNkJissekip);
                koujyoSyoumeiTy.setZtynenkind(newNkJissekiHaitoukin);
                koujyoSyoumeiTy.setZtynenkinsmgk(newNkJissekiSyoumeigk);
                koujyoSyoumeiTy.setZtynewhknjytukikan(newHknJytuKikan);
                koujyoSyoumeiTy.setZtyphrkkknjyoutai(phrkkknJyoutai);
                if (koujyoSymDataBean.getSyoumeiymd() != null) {

                    koujyoSyoumeiTy.setZtysyoumeiymdseireki(
                        FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(koujyoSymDataBean.getSyoumeiymd())));
                }
                koujyoSyoumeiTy.setZtynenippanseimeip(newIppanNenkanp);
                koujyoSyoumeiTy.setZtynenippand(newIppanNenkanHaitoukin);
                koujyoSyoumeiTy.setZtynenippansymgk(newIppanNenkanSyoumeigk);
                koujyoSyoumeiTy.setZtynenkaigoiryoup(newIryouNenkanp);
                koujyoSyoumeiTy.setZtynenkaigoiryoud(newIryouNenkanHaitoukin);
                koujyoSyoumeiTy.setZtyneniryousymgk(newIryouNenkanSyoumeigk);
                koujyoSyoumeiTy.setZtynennenkinp(newNkNenkanp);
                koujyoSyoumeiTy.setZtynennenkind(newNkNenkanHaitoukin);
                koujyoSyoumeiTy.setZtynennenkinsmgk(newNkNenkanSyoumeigk);

                BizPropertyInitializer.initialize(koujyoSyoumeiTy);

                koujyoSyoumeiTyLst.add(koujyoSyoumeiTy);

                String saiban = RenbanUtil.getRenbanAsString(
                    Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));

                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                tuutirirekiMeisaiHokan.setTuutirirekirenno(saiban);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue()
                    + koujyoSymDataBean.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(khTyouhyouKoujyoSyoumeiBatchParam.getSyoriYmd());
                tuutirirekiMeisaiHokan.setTuutisakuseino(0);
                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(khTyouhyouKoujyoSyoumeiBatchParam.getSyoriYmd());
                tuutirirekiMeisaiHokanLst.add(tuutirirekiMeisaiHokan);
                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, khTyouhyouKoujyoSyoumeiBatchParam.getHeisoukbn()));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
