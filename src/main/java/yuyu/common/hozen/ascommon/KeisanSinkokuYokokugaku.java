package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KeisanZennouKoujyogaku;
import yuyu.common.hozen.khcommon.KhWkgtZennouKoujyogakuBean;
import yuyu.common.hozen.khcommon.KhZennouKoujyogakuBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.sorter.SortIT_Zennou;

/**
 * 契約保全 案内収納共通 申告予告額計算
 */
public class KeisanSinkokuYokokugaku {

    private EditSinkokuYokokuTuutiParam editSinkokuYokokuTuutiParam;

    @Inject
    private static Logger logger;

    public KeisanSinkokuYokokugaku() {
        super();
    }

    public void exec(KhozenCommonParam pKhozenCommonParam,
        IT_KykSyouhn pKykSyouhn,
        BM_SyouhnZokusei pSyouhnZokusei,
        String pSyoumeiNendo,
        C_Kykjyoutai pKykjyoutai,
        String pSyono) {

        logger.debug("▽ 申告予告額計算 開始");


        editSinkokuYokokuTuutiParam = SWAKInjector.getInstance(EditSinkokuYokokuTuutiParam.class);
        editSinkokuYokokuTuutiParam.setSyoumeiNendo("");
        editSinkokuYokokuTuutiParam.setTekiyouseidokbn(C_TekiyouseidoKbn.BLNK);
        editSinkokuYokokuTuutiParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        editSinkokuYokokuTuutiParam.setPjyutoustartyoteiym(null);
        editSinkokuYokokuTuutiParam.setPjyutouendyoteiym(null);
        editSinkokuYokokuTuutiParam.setNewippanykkp(BizCurrency.valueOf(0));
        editSinkokuYokokuTuutiParam.setNewippanykkhaitoukin(BizCurrency.valueOf(0));
        editSinkokuYokokuTuutiParam.setNewippanykksyoumeigk(BizCurrency.valueOf(0));
        editSinkokuYokokuTuutiParam.setNewiryouykkp(BizCurrency.valueOf(0));
        editSinkokuYokokuTuutiParam.setNewiryouykkhaitoukin(BizCurrency.valueOf(0));
        editSinkokuYokokuTuutiParam.setNewiryouykksyoumeigk(BizCurrency.valueOf(0));
        editSinkokuYokokuTuutiParam.setNewnenkinykkp(BizCurrency.valueOf(0));
        editSinkokuYokokuTuutiParam.setNewnenkinykkhaitoukin(BizCurrency.valueOf(0));
        editSinkokuYokokuTuutiParam.setNewnenkinykksyoumeigk(BizCurrency.valueOf(0));

        IT_KykKihon kykKihon = pKhozenCommonParam.getKeiyakuKihon(pSyono);
        C_Hrkkaisuu hrkkaisuu = kykKihon.getHrkkaisuu();
        BizDateYM jkipjytym = pKhozenCommonParam.getAnsyuuKihon(pSyono).getJkipjytym();
        BizDateYM hkrjytStartym = jkipjytym;
        BizDateYM hkrjytEndym = jkipjytym.addMonths(Integer.valueOf(hrkkaisuu.getValue())).getPreviousMonth();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        if (kykSonotaTkyk == null) {

            throw new CommonBizAppException("契約その他特約テーブル  取得エラー  証券番号＝" + pSyono);
        }

        C_KoujyosyoumeipKbn syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.BLNK;

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

            syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.NENKIN;
        }
        else {

            syuKoujyosyoumeipKbn = pSyouhnZokusei.getKoujyosyoumeipkbn();
        }

        BizCurrency newippanykkp;
        BizCurrency newippanykksyoumeigk;
        BizCurrency newiryouykkp;
        BizCurrency newiryouykksyoumeigk;
        BizCurrency newnenkinykkp;
        BizCurrency newnenkinykksyoumeigk;

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhns();

        if (kykSyouhnList == null || kykSyouhnList.size() == 0) {

            throw new CommonBizAppException("契約商品TBLにデータが存在しません。 証券番号＝" + pSyono);
        }

        if (!C_Kykjyoutai.ZENNOU.eq(pKykjyoutai)) {

            CurrencyType hokenryouType = kykSyouhnList.get(0).getHokenryou().getType();

            newippanykkp = BizCurrency.valueOf(0, hokenryouType);
            newippanykksyoumeigk = BizCurrency.valueOf(0, hokenryouType);
            newiryouykkp = BizCurrency.valueOf(0, hokenryouType);
            newiryouykksyoumeigk = BizCurrency.valueOf(0, hokenryouType);
            newnenkinykkp = BizCurrency.valueOf(0, hokenryouType);
            newnenkinykksyoumeigk = BizCurrency.valueOf(0, hokenryouType);

            for (IT_KykSyouhn kykSyouhn : kykSyouhnList) {

                BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

                if (syouhnZokusei == null) {

                    throw new CommonBizAppException("商品属性マスタにデータが存在しません。 証券番号＝" + pSyono);
                }

                C_KoujyosyoumeipKbn koujyosyoumeipKbn = C_KoujyosyoumeipKbn.BLNK;

                if (C_SyutkKbn.SYU.eq(kykSyouhn.getSyutkkbn())) {

                    koujyosyoumeipKbn = syuKoujyosyoumeipKbn;
                }
                else {
                    koujyosyoumeipKbn = syouhnZokusei.getKoujyosyoumeipkbn();
                }

                if (C_KoujyosyoumeipKbn.IPPAN.eq(koujyosyoumeipKbn)) {

                    newippanykkp = newippanykkp.add(kykSyouhn.getHokenryou());
                    newippanykksyoumeigk = newippanykksyoumeigk.add(kykSyouhn.getHokenryou());
                }
                else if (C_KoujyosyoumeipKbn.KAIGOIRYOU.eq(koujyosyoumeipKbn)) {

                    newiryouykkp = newiryouykkp.add(kykSyouhn.getHokenryou());
                    newiryouykksyoumeigk = newiryouykksyoumeigk.add(kykSyouhn.getHokenryou());
                }
                else if (C_KoujyosyoumeipKbn.NENKIN.eq(koujyosyoumeipKbn)) {

                    newnenkinykkp = newnenkinykkp.add(kykSyouhn.getHokenryou());
                    newnenkinykksyoumeigk = newnenkinykksyoumeigk.add(kykSyouhn.getHokenryou());
                }
            }
        }
        else {

            SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);

            List<IT_Zennou> zennouList = pKhozenCommonParam.getAnsyuuKihon(pSyono).getZennouMsisnsBySyono();
            zennouList = sortIT_Zennou.OrderIT_ZennouByPkDesc(zennouList);

            if (zennouList == null || zennouList.size() == 0) {

                throw new CommonBizAppException("前納テーブル  取得エラー  証券番号＝" + pSyono);
            }

            KeisanZennouKoujyogaku keisanZennouKoujyogaku = SWAKInjector.getInstance(KeisanZennouKoujyogaku.class);
            keisanZennouKoujyogaku.setKjsmyouYenKawaserate(zennouList.get(0).getKjsmyouyenkansankwsrate());

            BizCurrency koujyogaku = keisanZennouKoujyogaku.getZennouKoujyogaku(
                zennouList.get(0).getKjsmyouzennounyuukinkgk(),
                zennouList.get(0).getKjsmyouzennoukikanm(),
                zennouList.get(0).getKjsmyouzennoukaisiymd(),
                kykKihon.getHrkp(),
                kykKihon.getHrkkaisuu(),
                BizDateYM.valueOf(pSyoumeiNendo + "12"),
                1,
                0);

            List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<KykSyouhnCommonParam>();
            kykSyouhnCommonParamList.addAll(kykSyouhnList);

            KhZennouKoujyogakuBean khZennouKoujyogakuBean = keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(
                koujyogaku,
                syuKoujyosyoumeipKbn,
                kykSyouhnCommonParamList);

            List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList =
                khZennouKoujyogakuBean.getKhWkgtZennouKoujyogakuBeanList();

            CurrencyType hokenryouType = khWkgtZennouKoujyogakuBeanList.get(0).getKhWkgtZennouKoujyogaku().getType();

            newippanykkp = BizCurrency.valueOf(0, hokenryouType);
            newippanykksyoumeigk = BizCurrency.valueOf(0, hokenryouType);
            newiryouykkp = BizCurrency.valueOf(0, hokenryouType);
            newiryouykksyoumeigk = BizCurrency.valueOf(0, hokenryouType);
            newnenkinykkp = BizCurrency.valueOf(0, hokenryouType);
            newnenkinykksyoumeigk = BizCurrency.valueOf(0, hokenryouType);

            for (KhWkgtZennouKoujyogakuBean hhWkgtZennouKoujyogakuBean : khWkgtZennouKoujyogakuBeanList) {

                if (C_KoujyosyoumeipKbn.IPPAN.eq(hhWkgtZennouKoujyogakuBean.getKoujyosyoumeipKbn())) {

                    newippanykkp = newippanykkp.add(hhWkgtZennouKoujyogakuBean.getKhWkgtZennouKoujyogaku());
                    newippanykksyoumeigk = newippanykksyoumeigk.add(hhWkgtZennouKoujyogakuBean.getKhWkgtZennouKoujyogaku());

                }
                else if (C_KoujyosyoumeipKbn.KAIGOIRYOU.eq(hhWkgtZennouKoujyogakuBean.getKoujyosyoumeipKbn())) {

                    newiryouykkp = newiryouykkp.add(hhWkgtZennouKoujyogakuBean.getKhWkgtZennouKoujyogaku());
                    newiryouykksyoumeigk = newiryouykksyoumeigk.add(hhWkgtZennouKoujyogakuBean.getKhWkgtZennouKoujyogaku());

                }
                else if (C_KoujyosyoumeipKbn.NENKIN.eq(hhWkgtZennouKoujyogakuBean.getKoujyosyoumeipKbn())) {

                    newnenkinykkp = newnenkinykkp.add(hhWkgtZennouKoujyogakuBean.getKhWkgtZennouKoujyogaku());
                    newnenkinykksyoumeigk = newnenkinykksyoumeigk.add(hhWkgtZennouKoujyogakuBean.getKhWkgtZennouKoujyogaku());
                }
            }
        }

        editSinkokuYokokuTuutiParam.setSyoumeiNendo(pSyoumeiNendo);
        editSinkokuYokokuTuutiParam.setTekiyouseidokbn(C_TekiyouseidoKbn.NEWSD);
        editSinkokuYokokuTuutiParam.setHrkkaisuu(hrkkaisuu);
        editSinkokuYokokuTuutiParam.setPjyutoustartyoteiym(hkrjytStartym);
        editSinkokuYokokuTuutiParam.setPjyutouendyoteiym(hkrjytEndym);
        editSinkokuYokokuTuutiParam.setNewippanykkp(newippanykkp);
        editSinkokuYokokuTuutiParam.setNewippanykksyoumeigk(newippanykksyoumeigk);
        editSinkokuYokokuTuutiParam.setNewiryouykkp(newiryouykkp);
        editSinkokuYokokuTuutiParam.setNewiryouykksyoumeigk(newiryouykksyoumeigk);
        editSinkokuYokokuTuutiParam.setNewnenkinykkp(newnenkinykkp);
        editSinkokuYokokuTuutiParam.setNewnenkinykksyoumeigk(newnenkinykksyoumeigk);

        logger.debug("△ 申告予告額計算 終了");
    }

    public EditSinkokuYokokuTuutiParam getSkkYkkTuutiParam() {
        return editSinkokuYokokuTuutiParam;
    }
}
