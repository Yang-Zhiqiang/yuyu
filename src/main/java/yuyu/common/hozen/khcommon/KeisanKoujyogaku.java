package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.KeisanPRsTuukaKnsn;
import yuyu.common.hozen.khcommon.dba4keisankoujyogaku.KeisanKoujyogakuDao;
import yuyu.common.hozen.khcommon.dba4keisankoujyogaku.KoujyoSymNaiyouDsBean;
import yuyu.common.hozen.khcommon.dba4keisankoujyogaku.KoujyoSymNaiyouKihrkmpSeisanRirekisBean;
import yuyu.common.hozen.khcommon.dba4keisankoujyogaku.KoujyoSymNaiyouNyknJissekiRirekisBean;
import yuyu.common.hozen.khcommon.dba4keisankoujyogaku.SyuKykSyouhnRirekisBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_Zennou;

/**
 * 契約保全 契約保全共通 控除証明額計算
 */
public class KeisanKoujyogaku {

    private C_KoujyosyoumeimsgKbn koujyosyoumeimsgKbn;

    private EditKoujyoSyoumeiParam editKoujyoSyoumeiParam;

    private BizDateYM endSyoumeiEndYm;

    private C_ChkkekkaKbn chkkekkaKbn;

    private String message;

    private String messageCode;

    private TreeMap<String, EditKoujyoSyoumeiParam> paramMap;

    private KhozenCommonParam khozenCommonParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private KeisanKoujyogakuDao keisanKoujyogakuDao;

    public KeisanKoujyogaku() {
        super();
    }

    public EditKoujyoSyoumeiParam getParam() {
        return editKoujyoSyoumeiParam;
    }

    public BizDateYM getEndSyoumeiEndYm() {
        return endSyoumeiEndYm;
    }

    public C_ChkkekkaKbn getChkkekkaKbn() {
        return chkkekkaKbn;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setKhozenCommonParam(KhozenCommonParam pKhozenCommonParam) {
        khozenCommonParam = pKhozenCommonParam;
    }

    public void exec(String pSyono, String pSymNendo) {

        koujyosyoumeimsgKbn = C_KoujyosyoumeimsgKbn.BLANK;
        endSyoumeiEndYm = null;
        paramMap = new TreeMap<>();

        C_KinouKbn kinouKbn = asKinou.getKinouKbn();

        IT_KykKihon kykKihon = null;

        BizDateYM mkmgkKsnyoLastsyoumeiendYm = null;

        IT_AnsyuKihon ansyuKihon = null;

        if (C_KinouKbn.ONLINE.eq(kinouKbn)) {

            kykKihon = hozenDomManager.getKykKihon(pSyono);
            ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);
        }
        else {

            kykKihon = khozenCommonParam.getBatchKeiyakuKihon();

            ansyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        }

        if (kykKihon == null) {

            throw new CommonBizAppException("契約基本テーブル  取得エラー  証券番号＝" + pSyono);
        }

        List<IT_KykSyouhn> kykSyouhnsLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnsLst == null || kykSyouhnsLst.size() == 0) {

            throw new CommonBizAppException("契約商品テーブル  取得エラー  証券番号＝" + pSyono);
        }
        if (ansyuKihon == null) {

            throw new CommonBizAppException("案内収納基本テーブル  取得エラー  証券番号＝" + pSyono);
        }

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        if (kykSonotaTkyk == null) {

            throw new CommonBizAppException("契約その他特約テーブル  取得エラー  証券番号＝" + pSyono);
        }

        C_Hrkkaisuu hrkKaisuu = kykKihon.getHrkkaisuu();

        if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {

            setParamItijibarai(pSyono, kykKihon, kykSyouhnsLst);

            if (!IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(khozenCommonParam.getFunctionId())) {

                setParamSeisan(pSyono);
            }

            return;
        }

        setParamNenHan(kykKihon, pSymNendo);

        setParamTuki(kykKihon, pSymNendo, pSyono, kykSyouhnsLst, kykSonotaTkyk);

        if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

            return;
        }

        if (paramMap.size() == 0) {

            Integer sakuNendo = new Integer(pSymNendo) - 1;

            mkmgkKsnyoLastsyoumeiendYm = keisanKoujyogakuDao.getJissekiMaxSyoumeiendym(pSyono, sakuNendo.toString());

        }
        else {

            Entry<String, EditKoujyoSyoumeiParam> lastEntry = paramMap.lastEntry();
            EditKoujyoSyoumeiParam param = lastEntry.getValue();

            endSyoumeiEndYm = param.getSyoumeiEndYm();
            mkmgkKsnyoLastsyoumeiendYm = endSyoumeiEndYm.clone();

        }

        setParamMikomiSyoumeigk(pSyono, pSymNendo, mkmgkKsnyoLastsyoumeiendYm, kykKihon, kykSyouhnsLst, ansyuKihon, kykSonotaTkyk);

        setParamSeisan(pSyono);

        if (C_ChkkekkaKbn.ERROR.eq(chkkekkaKbn)) {

            return;
        }

        mergeParam(pSyono, pSymNendo, kykKihon);
    }

    @SuppressWarnings("unchecked")
    private void setParamItijibarai(String pSyono, IT_KykKihon pKykKihon, List<IT_KykSyouhn> pKykSyouhnsLst) {

        List<Object[]> koujyoSymNaiyouLst = pKykKihon.getKoujyoSymNaiyouKoujyosyoumeipkbnSumKoujyosyoumeigks();

        if (koujyoSymNaiyouLst == null || koujyoSymNaiyouLst.size() == 0) {

            throw new CommonBizAppException("控除証明内容テーブル  取得エラー  証券番号＝" + pSyono);
        }

        BizDateYM kykYm = pKykSyouhnsLst.get(0).getKykymd().getBizDateYM();

        EditKoujyoSyoumeiParam param = new EditKoujyoSyoumeiParam();

        param.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        param.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        param.setSyoumeiStartYm(kykYm);
        param.setSyoumeiEndYm(kykYm);

        Map<CurrencyType, BizCurrency> mapSumKoujyosyoumeigk = null;

        for (Object[] items : koujyoSymNaiyouLst) {

            mapSumKoujyosyoumeigk = (Map<CurrencyType, BizCurrency>) items[1];

            BizCurrency koujyoSyoumeiGk = mapSumKoujyosyoumeigk.get(BizCurrencyTypes.YEN);

            C_KoujyosyoumeipKbn koujyosyoumeipKbn = (C_KoujyosyoumeipKbn) items[0];

            if (C_KoujyosyoumeipKbn.IPPAN.eq(koujyosyoumeipKbn)) {

                param.setNewIppanJissekiP(koujyoSyoumeiGk);
                param.setNewIppanNenkanP(BizCurrency.valueOf(0));
                param.setNewIppanJissekiSyoumeigk(koujyoSyoumeiGk);
                param.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(0));
            }
            else if (C_KoujyosyoumeipKbn.KAIGOIRYOU.eq(koujyosyoumeipKbn)) {

                param.setNewIryouJissekiP(koujyoSyoumeiGk);
                param.setNewIryouNenkanP(BizCurrency.valueOf(0));
                param.setNewIryouJissekiSyoumeigk(koujyoSyoumeiGk);
                param.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(0));
            }
            else if (C_KoujyosyoumeipKbn.NENKIN.eq(koujyosyoumeipKbn)) {

                param.setNewNenkinJissekiP(koujyoSyoumeiGk);
                param.setNewNenkinNenkanP(BizCurrency.valueOf(0));
                param.setNewNenkinJissekiSyoumeigk(koujyoSyoumeiGk);
                param.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(0));
            }
        }

        editKoujyoSyoumeiParam = param;
        endSyoumeiEndYm = kykYm;
    }

    private void setParamNenHan(IT_KykKihon pKykKihon, String pSymNendo) {

        List<KoujyoSymNaiyouNyknJissekiRirekisBean> koujyoSymNaiyouList =
            keisanKoujyogakuDao.getKoujyoSymNaiyouNyknJissekiRirekis(pKykKihon, pSymNendo, C_Hrkkaisuu.NEN);

        for (int index = 0; index < koujyoSymNaiyouList.size();) {

            C_TekiyouseidoKbn tekiyouSeidoKbn = C_TekiyouseidoKbn.NEWSD;
            BizDateYM symStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();
            BizDateYM symEndYm = koujyoSymNaiyouList.get(index).getSyoumeiendym();
            C_Hrkkaisuu hrkKaisuu = koujyoSymNaiyouList.get(index).getHrkkaisuu();
            BizCurrency newIppanKoujyoGk = BizCurrency.valueOf(0);
            BizCurrency newIryouKoujyoGk = BizCurrency.valueOf(0);
            BizCurrency newNenkinKoujyoGk = BizCurrency.valueOf(0);
            BizDateYM hikakuSymStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();

            for (; index < koujyoSymNaiyouList.size();) {

                if (BizDateUtil.compareYm(hikakuSymStartYm, symStartYm) == BizDateUtil.COMPARE_EQUAL) {

                    if (chkKeisanHuka(koujyoSymNaiyouList.get(index).getKeisanhukahyoujikbn(),
                        koujyoSymNaiyouList.get(index).getKeisanhukariyuucd())) {
                        return;
                    }

                    C_KoujyosyoumeipKbn koujyosyoumeipKbn = koujyoSymNaiyouList.get(index).getKoujyosyoumeipkbn();

                    BizCurrency koujyoGk = koujyoSymNaiyouList.get(index).getKoujyosyoumeigk();

                    if (C_KoujyosyoumeipKbn.IPPAN.eq(koujyosyoumeipKbn)) {

                        newIppanKoujyoGk = newIppanKoujyoGk.add(koujyoGk);
                    }
                    else if (C_KoujyosyoumeipKbn.KAIGOIRYOU.eq(koujyosyoumeipKbn)) {

                        newIryouKoujyoGk = newIryouKoujyoGk.add(koujyoGk);
                    }
                    else if (C_KoujyosyoumeipKbn.NENKIN.eq(koujyosyoumeipKbn)) {

                        newNenkinKoujyoGk = newNenkinKoujyoGk.add(koujyoGk);
                    }

                    index++;

                    if (index < koujyoSymNaiyouList.size()) {

                        hikakuSymStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();
                    }
                }
                else {

                    break;
                }
            }

            EditKoujyoSyoumeiParam param = new EditKoujyoSyoumeiParam();

            param.setHrkkaisuu(hrkKaisuu);
            param.setTekiyouSeidoKbn(tekiyouSeidoKbn);
            param.setNewIppanJissekiP(newIppanKoujyoGk);
            param.setNewIppanNenkanP(newIppanKoujyoGk);
            param.setNewIppanJissekiSyoumeigk(newIppanKoujyoGk);
            param.setNewIppanNenkanSyoumeigk(newIppanKoujyoGk);
            param.setNewIryouJissekiP(newIryouKoujyoGk);
            param.setNewIryouNenkanP(newIryouKoujyoGk);
            param.setNewIryouJissekiSyoumeigk(newIryouKoujyoGk);
            param.setNewIryouNenkanSyoumeigk(newIryouKoujyoGk);
            param.setNewNenkinJissekiP(newNenkinKoujyoGk);
            param.setNewNenkinNenkanP(newNenkinKoujyoGk);
            param.setNewNenkinJissekiSyoumeigk(newNenkinKoujyoGk);
            param.setNewNenkinNenkanSyoumeigk(newNenkinKoujyoGk);
            param.setSyoumeiStartYm(symStartYm);
            param.setSyoumeiEndYm(symEndYm);

            paramMap.put(String.valueOf(symStartYm), param);
        }
    }

    private void setParamTuki(IT_KykKihon pKykKihon, String pSymNendo, String pSyono,
        List<IT_KykSyouhn> pKykSyouhnsLst, IT_KykSonotaTkyk pKykSonotaTkyk) {

        List<KoujyoSymNaiyouNyknJissekiRirekisBean> koujyoSymNaiyouList =
            keisanKoujyogakuDao.getKoujyoSymNaiyouNyknJissekiRirekis(pKykKihon, pSymNendo, C_Hrkkaisuu.TUKI);

        GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(pKykSyouhnsLst.get(0).getKyktuukasyu(),
            pKykSonotaTkyk.getYennykntkhkumu(), pKykSonotaTkyk.getGaikanykntkhkumu());

        C_Tuukasyu hokenryouTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pKykSyouhnsLst.get(0).getHokenryou().getType());

        if (C_Tuukasyu.JPY.eq(getasPRsTuuka.getRstuukasyu()) && !C_Tuukasyu.JPY.eq(hokenryouTuukasyu)) {

            for (int index = 0; index < koujyoSymNaiyouList.size();) {

                BizDateYM symStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();
                BizDateYM symEndYm = koujyoSymNaiyouList.get(index).getSyoumeiendym();
                C_Hrkkaisuu hrkKaisuu = koujyoSymNaiyouList.get(index).getHrkkaisuu();
                C_TekiyouseidoKbn tekiyouseidoKbn = C_TekiyouseidoKbn.NEWSD;
                BizCurrency newIppanKoujyoGk = BizCurrency.valueOf(0);
                BizCurrency newIryouKoujyoGk = BizCurrency.valueOf(0);
                BizCurrency newNenkinKoujyoGk = BizCurrency.valueOf(0);
                BizDateYM hikakuSymStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();

                for (; index < koujyoSymNaiyouList.size();) {

                    if (BizDateUtil.compareYm(hikakuSymStartYm, symStartYm) == BizDateUtil.COMPARE_EQUAL) {

                        if (chkKeisanHuka(koujyoSymNaiyouList.get(index).getKeisanhukahyoujikbn(),
                            koujyoSymNaiyouList.get(index).getKeisanhukariyuucd())) {
                            return;
                        }

                        BizCurrency koujyoGk = koujyoSymNaiyouList.get(index).getKoujyosyoumeigk();
                        C_KoujyosyoumeipKbn koujyosyoumeipKbn = koujyoSymNaiyouList.get(index).getKoujyosyoumeipkbn();

                        if (C_KoujyosyoumeipKbn.IPPAN.eq(koujyosyoumeipKbn)) {

                            newIppanKoujyoGk = newIppanKoujyoGk.add(koujyoGk);
                        }
                        else if (C_KoujyosyoumeipKbn.KAIGOIRYOU.eq(koujyosyoumeipKbn)) {

                            newIryouKoujyoGk = newIryouKoujyoGk.add(koujyoGk);
                        }
                        else if (C_KoujyosyoumeipKbn.NENKIN.eq(koujyosyoumeipKbn)) {

                            newNenkinKoujyoGk = newNenkinKoujyoGk.add(koujyoGk);
                        }

                        index++;

                        if (index < koujyoSymNaiyouList.size()) {

                            hikakuSymStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();
                        }
                    }
                    else {
                        break;
                    }
                }

                EditKoujyoSyoumeiParam param = new EditKoujyoSyoumeiParam();

                param.setHrkkaisuu(hrkKaisuu);
                param.setTekiyouSeidoKbn(tekiyouseidoKbn);
                param.setNewIppanJissekiP(newIppanKoujyoGk);
                param.setNewIppanNenkanP(newIppanKoujyoGk);
                param.setNewIppanJissekiSyoumeigk(newIppanKoujyoGk);
                param.setNewIppanNenkanSyoumeigk(newIppanKoujyoGk);
                param.setNewIryouJissekiP(newIryouKoujyoGk);
                param.setNewIryouNenkanP(newIryouKoujyoGk);
                param.setNewIryouJissekiSyoumeigk(newIryouKoujyoGk);
                param.setNewIryouNenkanSyoumeigk(newIryouKoujyoGk);
                param.setNewNenkinJissekiP(newNenkinKoujyoGk);
                param.setNewNenkinNenkanP(newNenkinKoujyoGk);
                param.setNewNenkinJissekiSyoumeigk(newNenkinKoujyoGk);
                param.setNewNenkinNenkanSyoumeigk(newNenkinKoujyoGk);
                param.setSyoumeiStartYm(symStartYm);
                param.setSyoumeiEndYm(symEndYm);

                paramMap.put(String.valueOf(symStartYm), param);
            }
        }
        else {

            for (int index = 0; index < koujyoSymNaiyouList.size();) {

                C_TekiyouseidoKbn tekiyouseidoKbn = C_TekiyouseidoKbn.NEWSD;
                BizDateYM jkiSymStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();
                BizCurrency newIppanKoujyoGk = BizCurrency.valueOf(0);
                BizCurrency newIryouKoujyoGk = BizCurrency.valueOf(0);
                BizCurrency newNenkinKoujyoGk = BizCurrency.valueOf(0);
                BizDateYM symStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();
                BizDateYM symEndYm = null;
                BizDateYM hikakuSymStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();
                BizDateYM hikakuSymEndYm = koujyoSymNaiyouList.get(index).getSyoumeiendym();

                for (; index < koujyoSymNaiyouList.size();) {

                    if (BizDateUtil.compareYm(hikakuSymStartYm, jkiSymStartYm) == BizDateUtil.COMPARE_EQUAL) {

                        BizDateYM saveSymStartYm = hikakuSymStartYm;

                        symEndYm = hikakuSymEndYm;

                        for (; index < koujyoSymNaiyouList.size();) {

                            if (BizDateUtil.compareYm(hikakuSymStartYm, saveSymStartYm) == BizDateUtil.COMPARE_EQUAL) {

                                if (chkKeisanHuka(koujyoSymNaiyouList.get(index).getKeisanhukahyoujikbn(),
                                    koujyoSymNaiyouList.get(index).getKeisanhukariyuucd())) {
                                    return;
                                }

                                C_KoujyosyoumeipKbn koujyosyoumeipKbn = koujyoSymNaiyouList.get(index).
                                    getKoujyosyoumeipkbn();

                                BizCurrency koujyoGk = koujyoSymNaiyouList.get(index).getKoujyosyoumeigk();

                                if (C_KoujyosyoumeipKbn.IPPAN.eq(koujyosyoumeipKbn)) {

                                    newIppanKoujyoGk = newIppanKoujyoGk.add(koujyoGk);
                                }
                                else if (C_KoujyosyoumeipKbn.KAIGOIRYOU.eq(koujyosyoumeipKbn)) {

                                    newIryouKoujyoGk = newIryouKoujyoGk.add(koujyoGk);
                                }
                                else if (C_KoujyosyoumeipKbn.NENKIN.eq(koujyosyoumeipKbn)) {

                                    newNenkinKoujyoGk = newNenkinKoujyoGk.add(koujyoGk);
                                }

                                index++;

                                if (index < koujyoSymNaiyouList.size()) {

                                    hikakuSymStartYm = koujyoSymNaiyouList.get(index).getSyoumeistartym();
                                    hikakuSymEndYm = koujyoSymNaiyouList.get(index).getSyoumeiendym();
                                }
                            }
                            else {
                                break;
                            }
                        }

                        jkiSymStartYm = symEndYm.getNextMonth();
                    }
                    else {
                        break;
                    }

                }

                EditKoujyoSyoumeiParam param = new EditKoujyoSyoumeiParam();

                param.setHrkkaisuu(C_Hrkkaisuu.TUKI);
                param.setTekiyouSeidoKbn(tekiyouseidoKbn);
                param.setNewIppanJissekiP(newIppanKoujyoGk);
                param.setNewIppanNenkanP(newIppanKoujyoGk);
                param.setNewIppanJissekiSyoumeigk(newIppanKoujyoGk);
                param.setNewIppanNenkanSyoumeigk(newIppanKoujyoGk);
                param.setNewIryouJissekiP(newIryouKoujyoGk);
                param.setNewIryouNenkanP(newIryouKoujyoGk);
                param.setNewIryouJissekiSyoumeigk(newIryouKoujyoGk);
                param.setNewIryouNenkanSyoumeigk(newIryouKoujyoGk);
                param.setNewNenkinJissekiP(newNenkinKoujyoGk);
                param.setNewNenkinNenkanP(newNenkinKoujyoGk);
                param.setNewNenkinJissekiSyoumeigk(newNenkinKoujyoGk);
                param.setNewNenkinNenkanSyoumeigk(newNenkinKoujyoGk);
                param.setSyoumeiStartYm(symStartYm);
                param.setSyoumeiEndYm(symEndYm);

                paramMap.put(String.valueOf(symStartYm), param);
            }
        }
    }

    private void setParamMikomiSyoumeigk(String pSyono, String pSymNendo, BizDateYM pMkmgkKsnyoLastsyoumeiendYm,
        IT_KykKihon pKykKihon, List<IT_KykSyouhn> pKykSyouhnsLst, IT_AnsyuKihon pAnsyuKihon, IT_KykSonotaTkyk pKykSonotaTkyk) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);
        KoujyoSyoumeiUtil koujyoSyoumeiUtil = SWAKInjector.getInstance(KoujyoSyoumeiUtil.class);

        BizDateYM symNendoEndYm = BizDateYM.valueOf(pSymNendo + "12");

        C_YuukousyoumetuKbn yuukouSyoumetuKbn = pKykSyouhnsLst.get(0).getYuukousyoumetukbn();
        C_Kykjyoutai kykJyoutai = pKykSyouhnsLst.get(0).getKykjyoutai();
        C_Hrkkaisuu hrkKaisuu = pKykKihon.getHrkkaisuu();
        BizDateYM zenJkipjytym = pAnsyuKihon.getJkipjytym().getPreviousMonth();

        if (!C_YuukousyoumetuKbn.YUUKOU.eq(yuukouSyoumetuKbn)
            || (!C_Kykjyoutai.HRKMTYUU.eq(kykJyoutai)
                && !C_Kykjyoutai.IKKATUNK.eq(kykJyoutai)
                && !C_Kykjyoutai.ZENNOU.eq(kykJyoutai))
                || !C_Hrkkaisuu.TUKI.eq(hrkKaisuu)
                || (BizDateUtil.compareYm(symNendoEndYm, pMkmgkKsnyoLastsyoumeiendYm) == BizDateUtil.COMPARE_LESSER
                || BizDateUtil.compareYm(symNendoEndYm, pMkmgkKsnyoLastsyoumeiendYm) == BizDateUtil.COMPARE_EQUAL)
                || BizDateUtil.compareYm(pMkmgkKsnyoLastsyoumeiendYm, zenJkipjytym) != BizDateUtil.COMPARE_EQUAL) {

            return;
        }

        BizDate symNendoNovMatuYmd = BizDateYM.valueOf(pSymNendo + "11").getLastDay();

        if (!symNendoNovMatuYmd.isBusinessDay()) {
            symNendoNovMatuYmd = symNendoNovMatuYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }

        getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(pKykSyouhnsLst.get(0).getKyktuukasyu(),
            pKykSonotaTkyk.getYennykntkhkumu(), pKykSonotaTkyk.getGaikanykntkhkumu());

        C_Tuukasyu rstuukasyu = getasPRsTuuka.getRstuukasyu();

        C_Tuukasyu hokenryouTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pKykSyouhnsLst.get(0).getHokenryou().getType());
        C_UmuKbn umuKbn = koujyoSyoumeiUtil.chkYenkanzanrateUmu(symNendoNovMatuYmd, hokenryouTuukasyu);

        if (!C_Tuukasyu.JPY.eq(hokenryouTuukasyu) &&
            C_Tuukasyu.JPY.eq(rstuukasyu) &&
            C_UmuKbn.NONE.eq(umuKbn)) {

            koujyosyoumeimsgKbn = C_KoujyosyoumeimsgKbn.YENHNDSNKKYTGKKSNHK;

            return;
        }

        BizDate startYmd = BizDate.valueOf(pMkmgkKsnyoLastsyoumeiendYm + "01");
        BizDate endYmd = null;

        BizDateYM haraimanYm = pKykSyouhnsLst.get(0).getHaraimanymd().getBizDateYM();
        if (BizDateUtil.compareYm(symNendoEndYm, haraimanYm) == BizDateUtil.COMPARE_LESSER) {

            endYmd = BizDate.valueOf(symNendoEndYm + "01");
        }
        else {

            endYmd = BizDate.valueOf(haraimanYm.getPreviousMonth() + "01");
        }

        BizDateSpan spanYmd = BizDateUtil.calcDifference(endYmd, startYmd);

        int mikomiTukisuu = spanYmd.getYears() * 12 + spanYmd.getMonths();

        endSyoumeiEndYm = endYmd.getBizDateYM();

        C_TekiyouseidoKbn tekiyouSeidoKbn = C_TekiyouseidoKbn.NEWSD;
        BizCurrency newIppanMikomiGk = BizCurrency.valueOf(0);
        BizCurrency newIryouMikomiGk = BizCurrency.valueOf(0);
        BizCurrency newNenkinMikomiGk = BizCurrency.valueOf(0);

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhns();

        if (kykSyouhnLst == null || kykSyouhnLst.size() == 0) {

            throw new CommonBizAppException("契約商品テーブル  取得エラー  証券番号＝" + pSyono);
        }

        BM_SyouhnZokusei syuSyouhnZokusei = pKykSyouhnsLst.get(0).getSyouhnZokusei();

        if (syuSyouhnZokusei == null) {

            throw new CommonBizAppException("商品属性マスタ  取得エラー  証券番号＝" + pSyono);
        }

        C_KoujyosyoumeipKbn syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.BLNK;

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

            syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.NENKIN;
        }
        else {
            syuKoujyosyoumeipKbn = syuSyouhnZokusei.getKoujyosyoumeipkbn();
        }

        if (!C_Kykjyoutai.ZENNOU.eq(pKykSyouhnsLst.get(0).getKykjyoutai())) {

            for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {

                C_KoujyosyoumeipKbn koujyoSyoumeiPKbn = C_KoujyosyoumeipKbn.BLNK;
                BizCurrency hokenryou = BizCurrency.valueOf(0);
                BizCurrency tkjyP = BizCurrency.valueOf(0);

                if (C_Tuukasyu.JPY.eq(rstuukasyu)) {

                    C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(kykSyouhn.getHokenryou().getType());

                    if (C_Tuukasyu.JPY.eq(tuukasyu)) {

                        hokenryou = kykSyouhn.getHokenryou();
                    }
                    else {

                        KeisanPRsTuukaKnsn keisanPRsTuukaKnsn = SWAKInjector.getInstance(KeisanPRsTuukaKnsn.class);

                        C_ErrorKbn errorKbn = keisanPRsTuukaKnsn.exec(symNendoNovMatuYmd, kykSyouhn.getHokenryou(),
                            tuukasyu, C_Tuukasyu.JPY);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            throw new CommonBizAppException("円換算保険料  取得エラー  証券番号＝" + pSyono);
                        }

                        hokenryou = keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsngop();
                    }
                }
                else {
                    throw new CommonBizAppException("保険料を通貨換算できません。 証券番号 ＝ " + pSyono);
                }

                //                IT_SyouhnTokujou syouhnTokujou = pKykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                //                    kykSyouhn.getSyutkkbn(), kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno(),
                //                    kykSyouhn.getKyksyouhnrenno());
                //
                //                if (syouhnTokujou != null) {
                //
                //                    tkjyP = syouhnTokujou.getTkjyp();
                //                }

                BizCurrency mikomiGk = hokenryou.add(tkjyP).multiply(mikomiTukisuu);

                BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

                if (syouhnZokusei == null) {

                    throw new CommonBizAppException("商品属性マスタ  取得エラー  証券番号＝" + pSyono);
                }

                if (C_SyutkKbn.SYU.eq(kykSyouhn.getSyutkkbn())) {

                    koujyoSyoumeiPKbn = syuKoujyosyoumeipKbn;
                }
                else {
                    koujyoSyoumeiPKbn = syouhnZokusei.getKoujyosyoumeipkbn();
                }

                if (C_KoujyosyoumeipKbn.IPPAN.eq(koujyoSyoumeiPKbn)) {

                    newIppanMikomiGk = mikomiGk;
                }
                else if (C_KoujyosyoumeipKbn.KAIGOIRYOU.eq(koujyoSyoumeiPKbn)) {

                    newIryouMikomiGk = mikomiGk;
                }
                else if (C_KoujyosyoumeipKbn.NENKIN.eq(koujyoSyoumeiPKbn)) {

                    newNenkinMikomiGk = mikomiGk;
                }
            }
        }
        else {

            List<IT_Zennou> zennouLst = pAnsyuKihon.getZennouMsisnsBySyono();

            if (zennouLst.size() == 0) {

                throw new CommonBizAppException("前納テーブル  取得エラー  証券番号＝" + pSyono);
            }

            SortIT_Zennou sortZennou = SWAKInjector.getInstance(SortIT_Zennou.class);
            KeisanZennouKoujyogaku keisanZennouKoujyogaku = SWAKInjector.getInstance(KeisanZennouKoujyogaku.class);

            zennouLst = sortZennou.OrderIT_ZennouByPkDesc(zennouLst);

            keisanZennouKoujyogaku.setKjsmyouYenKawaserate(zennouLst.get(0).getKjsmyouyenkansankwsrate());

            BizCurrency koujyosyoumeiGk = keisanZennouKoujyogaku.getZennouKoujyogaku(
                zennouLst.get(0).getKjsmyouzennounyuukinkgk(),
                zennouLst.get(0).getKjsmyouzennoukikanm(),
                zennouLst.get(0).getKjsmyouzennoukaisiymd(),
                pKykKihon.getHrkp(),
                C_Hrkkaisuu.TUKI,
                pMkmgkKsnyoLastsyoumeiendYm.getNextMonth(),
                0,
                mikomiTukisuu);

            List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = new ArrayList<>();

            kykSyouhnCommonParamLst.addAll(kykSyouhnLst);

            KhZennouKoujyogakuBean khZennouKoujyogakuBean = keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(
                koujyosyoumeiGk, syuKoujyosyoumeipKbn, kykSyouhnCommonParamLst);

            List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanLst = khZennouKoujyogakuBean
                .getKhWkgtZennouKoujyogakuBeanList();

            for (KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean : khWkgtZennouKoujyogakuBeanLst) {

                if (C_KoujyosyoumeipKbn.IPPAN.eq(khWkgtZennouKoujyogakuBean.getKoujyosyoumeipKbn())) {

                    newIppanMikomiGk = khWkgtZennouKoujyogakuBean.getKhWkgtZennouKoujyogaku();
                }
                else if (C_KoujyosyoumeipKbn.KAIGOIRYOU.eq(khWkgtZennouKoujyogakuBean.getKoujyosyoumeipKbn())) {

                    newIryouMikomiGk = khWkgtZennouKoujyogakuBean.getKhWkgtZennouKoujyogaku();
                }
                else if (C_KoujyosyoumeipKbn.NENKIN.eq(khWkgtZennouKoujyogakuBean.getKoujyosyoumeipKbn())) {

                    newNenkinMikomiGk = khWkgtZennouKoujyogakuBean.getKhWkgtZennouKoujyogaku();
                }
            }
        }

        BizDateYM symStartYm = null;
        EditKoujyoSyoumeiParam param;

        if (paramMap.size() == 0) {

            symStartYm = pMkmgkKsnyoLastsyoumeiendYm.getNextMonth();

            param = new EditKoujyoSyoumeiParam();

            param.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            param.setTekiyouSeidoKbn(tekiyouSeidoKbn);
            param.setSyoumeiStartYm(symStartYm);
        }
        else {

            Entry<String, EditKoujyoSyoumeiParam> lastEntry = paramMap.lastEntry();
            param = lastEntry.getValue();

            if ((C_Hrkkaisuu.TUKI.eq(param.getHrkkaisuu()))
                && (param.getTekiyouSeidoKbn().eq(tekiyouSeidoKbn))) {

                symStartYm = param.getSyoumeiStartYm();
            }
            else {

                symStartYm = pMkmgkKsnyoLastsyoumeiendYm.getNextMonth();

                param = new EditKoujyoSyoumeiParam();

                param.setHrkkaisuu(C_Hrkkaisuu.TUKI);
                param.setTekiyouSeidoKbn(tekiyouSeidoKbn);
                param.setSyoumeiStartYm(symStartYm);
            }
        }

        param.setNewIppanNenkanP(param.getNewIppanNenkanP().add(newIppanMikomiGk));
        param.setNewIppanNenkanSyoumeigk(param.getNewIppanNenkanSyoumeigk().add(newIppanMikomiGk));
        param.setNewIryouNenkanP(param.getNewIryouNenkanP().add(newIryouMikomiGk));
        param.setNewIryouNenkanSyoumeigk(param.getNewIryouNenkanSyoumeigk().add(newIryouMikomiGk));
        param.setNewNenkinNenkanP(param.getNewNenkinNenkanP().add(newNenkinMikomiGk));
        param.setNewNenkinNenkanSyoumeigk(param.getNewNenkinNenkanSyoumeigk().add(newNenkinMikomiGk));

        paramMap.put(String.valueOf(symStartYm), param);
    }

    private void setParamSeisan(String pSyono) {

        List<KoujyoSymNaiyouKihrkmpSeisanRirekisBean> koujyoSymNaiyouList = keisanKoujyogakuDao
            .getKoujyoSymNaiyouKihrkmpSeisanRirekis(pSyono);

        if (koujyoSymNaiyouList == null || koujyoSymNaiyouList.size() == 0) {


            return;
        }

        C_YuukousyoumetuKbn syoriYuukousyoumetuKbn = C_YuukousyoumetuKbn.BLNK;
        C_Kykjyoutai syoriKykjyoutai = C_Kykjyoutai.BLNK;
        String syoriHenkousikibetukey = "";
        List<String> syoumeiTsgkeyLst = new ArrayList<>();
        SimpleEntry<String,BizDateYM> seisanHaneiEntry = null;

        for (KoujyoSymNaiyouKihrkmpSeisanRirekisBean koujyoSymNaiyouBean : koujyoSymNaiyouList) {

            C_KoujyosyoumeipKbn koujyoSyoumeiPKbn = koujyoSymNaiyouBean.getKoujyosyoumeipkbn();
            C_KoujyosymnaiyourecKbn seisanRrkKyjSymRecKbn = koujyoSymNaiyouBean.getKoujyosymnaiyoureckbn();
            BizCurrency seisanRrkKjySymGk = koujyoSymNaiyouBean.getKoujyosyoumeigk();
            String kosKinouId = koujyoSymNaiyouBean.getGyoumuKousinKinou();
            C_YuukousyoumetuKbn yuukouSyoumetuKbn = koujyoSymNaiyouBean.getYuukousyoumetukbn();
            C_Kykjyoutai kykjyoutai = koujyoSymNaiyouBean.getKykjyoutai();
            String henkouSikibetuKey = koujyoSymNaiyouBean.getHenkousikibetukey();
            BizDateYM seisanSyoumeistartym = koujyoSymNaiyouBean.getSyoumeistartym();
            BizDateYM seisanSyoumeiendym = koujyoSymNaiyouBean.getSyoumeiendym();

            if (!syoriHenkousikibetukey.equals(henkouSikibetuKey)) {
                List<SyuKykSyouhnRirekisBean> syuKykSyouhnRirekisBeanLst = keisanKoujyogakuDao.getSyuKykSyouhnRirekis(
                    pSyono, henkouSikibetuKey);

                if (syuKykSyouhnRirekisBeanLst.size() == 0) {

                    throw new CommonBizAppException("契約商品テーブル、契約商品履歴テーブル  取得エラー  証券番号＝"
                        + pSyono + "  変更識別キー＝" + henkouSikibetuKey);
                }

                syoriYuukousyoumetuKbn = syuKykSyouhnRirekisBeanLst.get(0).getYuukousyoumetukbn();
                syoriKykjyoutai = syuKykSyouhnRirekisBeanLst.get(0).getKykjyoutai();
                syoriHenkousikibetukey = henkouSikibetuKey;
            }

            for (Entry<String, EditKoujyoSyoumeiParam> paramEntry : paramMap.entrySet()) {

                BizCurrency seisanGk = BizCurrency.valueOf(0);

                String mapKey = paramEntry.getKey();

                EditKoujyoSyoumeiParam param = paramEntry.getValue();

                if ((IKhozenCommonConstants.KINOUID_KAIYAKU.equals(kosKinouId)
                    || IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(kosKinouId)
                    || IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(kosKinouId)
                    || IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(kosKinouId))
                    && (C_YuukousyoumetuKbn.SYOUMETU.eq(yuukouSyoumetuKbn)
                        || C_Kykjyoutai.PMEN.eq(kykjyoutai))) {

                    if (BizDateUtil.compareYm(seisanSyoumeistartym, param.getSyoumeiStartYm())
                        == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYm(seisanSyoumeistartym, param.getSyoumeiStartYm())
                        == BizDateUtil.COMPARE_EQUAL) {

                        if (chkKeisanHuka(koujyoSymNaiyouBean.getKeisanhukahyoujikbn(),
                            koujyoSymNaiyouBean.getKeisanhukariyuucd())) {
                            return;
                        }

                        syoumeiTsgkeyLst.add(mapKey);

                        continue;
                    }
                }

                if (BizDateUtil.compareYm(param.getSyoumeiEndYm(), seisanSyoumeistartym) == BizDateUtil.COMPARE_LESSER) {

                    continue;
                }
                else if (BizDateUtil.compareYm(seisanSyoumeiendym, param.getSyoumeiStartYm()) == BizDateUtil.COMPARE_LESSER) {

                    break;
                }
                else if ((BizDateUtil.compareYm(param.getSyoumeiStartYm(), seisanSyoumeistartym) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYm(param.getSyoumeiStartYm(), seisanSyoumeistartym) == BizDateUtil.COMPARE_EQUAL)
                    && (BizDateUtil.compareYm(seisanSyoumeiendym, param.getSyoumeiEndYm()) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYm(seisanSyoumeiendym, param.getSyoumeiEndYm()) == BizDateUtil.COMPARE_EQUAL)) {

                    if (chkKeisanHuka(koujyoSymNaiyouBean.getKeisanhukahyoujikbn(),
                        koujyoSymNaiyouBean.getKeisanhukariyuucd())) {
                        return;
                    }

                    seisanGk = seisanRrkKjySymGk;
                }

                if (!C_KoujyosymnaiyourecKbn.TUITYOUKIN.eq(seisanRrkKyjSymRecKbn)) {

                    seisanGk = seisanGk.multiply(BizNumber.valueOf(-1));
                }

                if (C_KoujyosyoumeipKbn.IPPAN.eq(koujyoSyoumeiPKbn)) {

                    param.setNewIppanJissekiP(param.getNewIppanJissekiP().add(seisanGk));
                    param.setNewIppanNenkanP(param.getNewIppanNenkanP().add(seisanGk));
                    param.setNewIppanJissekiSyoumeigk(param.getNewIppanJissekiSyoumeigk().add(seisanGk));
                    param.setNewIppanNenkanSyoumeigk(param.getNewIppanNenkanSyoumeigk().add(seisanGk));
                }
                else if (C_KoujyosyoumeipKbn.KAIGOIRYOU.eq(koujyoSyoumeiPKbn)) {

                    param.setNewIryouJissekiP(param.getNewIryouJissekiP().add(seisanGk));
                    param.setNewIryouNenkanP(param.getNewIryouNenkanP().add(seisanGk));
                    param.setNewIryouJissekiSyoumeigk(param.getNewIryouJissekiSyoumeigk().add(seisanGk));
                    param.setNewIryouNenkanSyoumeigk(param.getNewIryouNenkanSyoumeigk().add(seisanGk));
                }
                else if (C_KoujyosyoumeipKbn.NENKIN.eq(koujyoSyoumeiPKbn)) {

                    param.setNewNenkinJissekiP(param.getNewNenkinJissekiP().add(seisanGk));
                    param.setNewNenkinNenkanP(param.getNewNenkinNenkanP().add(seisanGk));
                    param.setNewNenkinJissekiSyoumeigk(param.getNewNenkinJissekiSyoumeigk().add(seisanGk));
                    param.setNewNenkinNenkanSyoumeigk(param.getNewNenkinNenkanSyoumeigk().add(seisanGk));
                }

                if (((C_YuukousyoumetuKbn.YUUKOU.eq(syoriYuukousyoumetuKbn) && C_Kykjyoutai.PMEN.eq(syoriKykjyoutai)) ||
                    C_YuukousyoumetuKbn.SYOUMETU.eq(syoriYuukousyoumetuKbn)) && seisanHaneiEntry == null) {

                    seisanHaneiEntry = new SimpleEntry<>(mapKey, seisanSyoumeistartym);
                }

                paramMap.put(mapKey, param);
            }
        }

        if (seisanHaneiEntry != null) {
            String seisanHaneiKey = seisanHaneiEntry.getKey();
            BizDateYM seisanHaneiSyoumeiEndYm = seisanHaneiEntry.getValue().addMonths(-1);
            EditKoujyoSyoumeiParam param = paramMap.get(seisanHaneiKey);
            param.setSyoumeiEndYm(seisanHaneiSyoumeiEndYm);
            paramMap.put(seisanHaneiKey, param);
        }

        for (String syoumeiTsgkey : syoumeiTsgkeyLst) {

            paramMap.remove(syoumeiTsgkey);
        }

    }

    private void mergeParam(String pSyono, String pSymNendo, IT_KykKihon pKykKihon) {

        editKoujyoSyoumeiParam = SWAKInjector.getInstance(EditKoujyoSyoumeiParam.class);

        BizCurrency newIppanJissekiP = BizCurrency.valueOf(0);
        BizCurrency newIppanNenkanP = BizCurrency.valueOf(0);
        BizCurrency newIppanJissekiHaitoukin = BizCurrency.valueOf(0);
        BizCurrency newIppanNenkanHaitoukin = BizCurrency.valueOf(0);
        BizCurrency newIppanJissekiSyoumeigk = BizCurrency.valueOf(0);
        BizCurrency newIppanNenkanSyoumeigk = BizCurrency.valueOf(0);

        BizCurrency newIryouJissekiP = BizCurrency.valueOf(0);
        BizCurrency newIryouNenkanP = BizCurrency.valueOf(0);
        BizCurrency newIryouJissekiSyoumeigk = BizCurrency.valueOf(0);
        BizCurrency newIryouNenkanSyoumeigk = BizCurrency.valueOf(0);

        BizCurrency newNenkinJissekiP = BizCurrency.valueOf(0);
        BizCurrency newNenkinNenkanP = BizCurrency.valueOf(0);
        BizCurrency newNenkinJissekiSyoumeigk = BizCurrency.valueOf(0);
        BizCurrency newNenkinNenkanSyoumeigk = BizCurrency.valueOf(0);
        C_Hrkkaisuu hrkkaisuu = pKykKihon.getHrkkaisuu();
        BizDateYM syoumeiEndYm = null;
        BizDateYM syoumeiStartYm = null;
        BizCurrency jissekiHaitoukin = BizCurrency.valueOf(0);
        int index = 0;

        for (Entry<String, EditKoujyoSyoumeiParam> paramEntry : paramMap.entrySet()) {

            EditKoujyoSyoumeiParam param = paramEntry.getValue();

            newIppanJissekiP = newIppanJissekiP.add(param.getNewIppanJissekiP()).round(0, RoundingMode.HALF_UP);
            newIppanNenkanP = newIppanNenkanP.add(param.getNewIppanNenkanP()).round(0, RoundingMode.HALF_UP);
            newIppanJissekiSyoumeigk = newIppanJissekiSyoumeigk.add(param.getNewIppanJissekiSyoumeigk()).round(0,
                RoundingMode.HALF_UP);
            newIppanNenkanSyoumeigk = newIppanNenkanSyoumeigk.add(param.getNewIppanNenkanSyoumeigk()).round(0,
                RoundingMode.HALF_UP);

            newIryouJissekiP = newIryouJissekiP.add(param.getNewIryouJissekiP()).round(0, RoundingMode.HALF_UP);
            newIryouNenkanP = newIryouNenkanP.add(param.getNewIryouNenkanP()).round(0, RoundingMode.HALF_UP);
            newIryouJissekiSyoumeigk = newIryouJissekiSyoumeigk.add(param.getNewIryouJissekiSyoumeigk()).round(0,
                RoundingMode.HALF_UP);
            newIryouNenkanSyoumeigk = newIryouNenkanSyoumeigk.add(param.getNewIryouNenkanSyoumeigk()).round(0,
                RoundingMode.HALF_UP);

            newNenkinJissekiP = newNenkinJissekiP.add(param.getNewNenkinJissekiP()).round(0, RoundingMode.HALF_UP);
            newNenkinNenkanP = newNenkinNenkanP.add(param.getNewNenkinNenkanP()).round(0, RoundingMode.HALF_UP);
            newNenkinJissekiSyoumeigk = newNenkinJissekiSyoumeigk.add(param.getNewNenkinJissekiSyoumeigk()).round(
                0, RoundingMode.HALF_UP);
            newNenkinNenkanSyoumeigk = newNenkinNenkanSyoumeigk.add(param.getNewNenkinNenkanSyoumeigk()).round(0,
                RoundingMode.HALF_UP);
            if (param.getSyoumeiEndYm() != null) {
                syoumeiEndYm = param.getSyoumeiEndYm();
            }
            if (index == 0) {
                syoumeiStartYm = param.getSyoumeiStartYm();
                index++;
            }

        }

        List<KoujyoSymNaiyouDsBean> koujyoSymNaiyouDsBeanLst = keisanKoujyogakuDao.getKoujyoSymNaiyouDs(pSyono, pSymNendo);

        BizCurrency kakJissekiHaitoukin = BizCurrency.valueOf(0);
        BizCurrency naiJissekiHaitoukin = BizCurrency.valueOf(0);
        boolean kakJissekiHaitoukinUmuFlg = false;
        boolean naiJissekiHaitoukinUmuFlg = false;

        for (KoujyoSymNaiyouDsBean koujyoSymNaiyouDsBean : koujyoSymNaiyouDsBeanLst) {

            if (C_NaiteiKakuteiKbn.KAKUTEI.eq(koujyoSymNaiyouDsBean.getNaiteikakuteikbn())) {

                kakJissekiHaitoukin = kakJissekiHaitoukin.add(koujyoSymNaiyouDsBean.getKoujyosyoumeid());
                kakJissekiHaitoukinUmuFlg = true;

            }
            else if (C_NaiteiKakuteiKbn.NAITEI.eq(koujyoSymNaiyouDsBean.getNaiteikakuteikbn())) {

                naiJissekiHaitoukin = naiJissekiHaitoukin.add(koujyoSymNaiyouDsBean.getKoujyosyoumeid());
                naiJissekiHaitoukinUmuFlg = true;
            }
        }

        if (kakJissekiHaitoukinUmuFlg) {
            jissekiHaitoukin = kakJissekiHaitoukin;
        }
        else if (naiJissekiHaitoukinUmuFlg) {
            jissekiHaitoukin = naiJissekiHaitoukin;
        }

        newIppanJissekiHaitoukin = jissekiHaitoukin;
        newIppanNenkanHaitoukin = jissekiHaitoukin;
        newIppanJissekiSyoumeigk = newIppanJissekiSyoumeigk.subtract(newIppanJissekiHaitoukin);
        newIppanNenkanSyoumeigk = newIppanNenkanSyoumeigk.subtract(newIppanNenkanHaitoukin);

        if (C_KoujyosyoumeimsgKbn.YENHNDSNKKYTGKKSNHK.eq(koujyosyoumeimsgKbn)) {

            newIppanNenkanP = BizCurrency.valueOf(0);
            newIppanNenkanHaitoukin = BizCurrency.valueOf(0);
            newIppanNenkanSyoumeigk = BizCurrency.valueOf(0);
            newIryouNenkanP = BizCurrency.valueOf(0);
            newIryouNenkanSyoumeigk = BizCurrency.valueOf(0);
            newNenkinNenkanP = BizCurrency.valueOf(0);
            newNenkinNenkanSyoumeigk = BizCurrency.valueOf(0);
        }

        editKoujyoSyoumeiParam.setHrkkaisuu(hrkkaisuu);
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(syoumeiStartYm);
        editKoujyoSyoumeiParam.setSyoumeiEndYm(syoumeiEndYm);

        editKoujyoSyoumeiParam.setNewIppanJissekiP(newIppanJissekiP);
        editKoujyoSyoumeiParam.setNewIppanNenkanP(newIppanNenkanP);
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(newIppanJissekiHaitoukin);
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(newIppanNenkanHaitoukin);
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(newIppanJissekiSyoumeigk);
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(newIppanNenkanSyoumeigk);

        editKoujyoSyoumeiParam.setNewIryouJissekiP(newIryouJissekiP);
        editKoujyoSyoumeiParam.setNewIryouNenkanP(newIryouNenkanP);
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(newIryouJissekiSyoumeigk);
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(newIryouNenkanSyoumeigk);

        editKoujyoSyoumeiParam.setNewNenkinJissekiP(newNenkinJissekiP);
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(newNenkinNenkanP);
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(newNenkinJissekiSyoumeigk);
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(newNenkinNenkanSyoumeigk);
        editKoujyoSyoumeiParam.setKoujyosyoumeimsgKbn(koujyosyoumeimsgKbn);
    }

    private String getKeisanHukariyuuMsg(String pKeisanhukariyuucd) {

        String keisanhukariyuuMsg = "";

        if (KeisanKoujyogakuConstants.KEISANHUKARIYUUCD_TKBRIZENHUKUSUUKAISEISAN.equals(pKeisanhukariyuucd)) {

            keisanhukariyuuMsg = MessageUtil.getMessage(MessageId.EIA3011);
        }

        else if (KeisanKoujyogakuConstants.KEISANHUKARIYUUCD_SIBOUMISYUUPNYKN.equals(pKeisanhukariyuucd)) {

            keisanhukariyuuMsg = "死亡に伴う未収Ｐの入金が行われているため計算できません。";
        }

        return keisanhukariyuuMsg;
    }
    private boolean chkKeisanHuka(C_DispKbn pKeisanhukahyoujikbn,String pKeisanhukariyuucd) {

        if (C_DispKbn.HYOUJI.eq(pKeisanhukahyoujikbn)) {

            String keisanHukariyuuMsg = getKeisanHukariyuuMsg(pKeisanhukariyuucd);

            chkkekkaKbn = C_ChkkekkaKbn.ERROR;
            message = keisanHukariyuuMsg;
            messageCode = pKeisanhukariyuucd;

            return true;
        }
        return false;
    }
}
