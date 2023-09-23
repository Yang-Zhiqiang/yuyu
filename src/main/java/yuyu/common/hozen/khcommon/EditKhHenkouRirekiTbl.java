package yuyu.common.hozen.khcommon;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.inject.Inject;

import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.util.EntityUtil;

import org.apache.commons.beanutils.PropertyUtilsBean;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AeoiTaisyousyaKbn;
import yuyu.def.classification.C_AzukarikinsyuruiKbn;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AeoiInfo;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_BAK_AeoiInfo;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_Azukarikin;
import yuyu.def.db.entity.IT_BAK_CreditCardInfo;
import yuyu.def.db.entity.IT_BAK_DattaiUktk;
import yuyu.def.db.entity.IT_BAK_FatcaInfo;
import yuyu.def.db.entity.IT_BAK_HokenryouTmttkn;
import yuyu.def.db.entity.IT_BAK_Kariukekin;
import yuyu.def.db.entity.IT_BAK_KhHenreikin;
import yuyu.def.db.entity.IT_BAK_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_BAK_KhTtdkTyuui;
import yuyu.def.db.entity.IT_BAK_Kouza;
import yuyu.def.db.entity.IT_BAK_KykDairiten;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_BAK_KykSyouhn;
import yuyu.def.db.entity.IT_BAK_KykUkt;
import yuyu.def.db.entity.IT_BAK_SyuunouHenknRireki;
import yuyu.def.db.entity.IT_BAK_TeikikinKouza;
import yuyu.def.db.entity.IT_BAK_Tokusin;
import yuyu.def.db.entity.IT_BAK_TrkKzk;
import yuyu.def.db.entity.IT_BAK_YykIdouNaiyoHrhnk;
import yuyu.def.db.entity.IT_BAK_YykIdouUktk;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.db.entity.IT_TeikikinKouza;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;
import yuyu.def.db.entity.IT_YykIdouUktk;

/**
 * 契約保全 契約保全共通 契約保全変更履歴TBL編集<br />
 * 変更前と変更後のエンティティを比較し、契約保全変更履歴TBLを更新します。
 */
public class EditKhHenkouRirekiTbl {

    private  String syoNo;

    private  String sikibetuKey;

    private  int renNo;

    private  String kinouId;

    private  String userId;

    private  String sysTime;

    private  List<IT_KhHenkouRireki> henkouRirekiList;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo  userInfo;

    public EditKhHenkouRirekiTbl() {
        super();
    }

    public List<IT_KhHenkouRireki> exec(IT_KykKihon pKykKihon, IT_BAK_KykKihon pBakKykKihon, IT_AnsyuKihon pAnsyuKihon,
        IT_BAK_AnsyuKihon pBakAnsyuKihon, Integer pHenkouSikibetuKeyRenno) {
        return henkouRirekiList;
    }

    public List<IT_KhHenkouRireki> exec(IT_KykKihon pKykKihon, IT_BAK_KykKihon pBakKykKihon, IT_AnsyuKihon pAnsyuKihon,
        IT_BAK_AnsyuKihon pBakAnsyuKihon, IT_NyuukinKakusyouData pNyuukinKakusyouData, String pHenkouSikibetuKeyRenno) {

        syoNo = pKykKihon.getSyono();
        sikibetuKey = pHenkouSikibetuKeyRenno;
        renNo = 1;
        kinouId = kinou.getKinouId();
        userId = userInfo.getUserId();
        sysTime = BizDate.getSysDateTimeMilli();
        henkouRirekiList = new ArrayList<IT_KhHenkouRireki>();

        List<AbstractExDBEntity<?,?>> kihonMainTblList = new ArrayList<AbstractExDBEntity<?,?>>();
        List<String> hanbetuKoumokunmList = new ArrayList<String>();
        List<AbstractExDBEntity<?,?>> kihonBakupTblList = new ArrayList<AbstractExDBEntity<?,?>>();

        kihonMainTblList.add(pKykKihon);
        kihonMainTblList.add(pKykKihon.getKykSya());
        kihonMainTblList.add(pKykKihon.getHhknSya());
        kihonMainTblList.add(pAnsyuKihon);
        kihonMainTblList.add(pKykKihon.getKykSonotaTkyk());

        hanbetuKoumokunmList.add("契約基本情報");
        hanbetuKoumokunmList.add("契約基本情報");
        hanbetuKoumokunmList.add("契約基本情報");
        hanbetuKoumokunmList.add("契約基本情報");
        hanbetuKoumokunmList.add("その他特約情報");

        kihonBakupTblList.add(pBakKykKihon);
        kihonBakupTblList.add(null);
        kihonBakupTblList.add(null);
        kihonBakupTblList.add(pBakAnsyuKihon);
        kihonBakupTblList.add(null);

        if (pBakKykKihon != null) {
            kihonBakupTblList.set(1,pBakKykKihon.getBAKKykSya());
            kihonBakupTblList.set(2,pBakKykKihon.getBAKHhknSya());
            kihonBakupTblList.set(4,pBakKykKihon.getBAKKykSonotaTkyk());
        }

        for (int i=0; i < kihonMainTblList.size(); i++) {
            if (kihonBakupTblList.get(i) == null) {
                continue;
            }

            LinkedList<String[]> henkouList = editHenkouList(kihonBakupTblList.get(i), kihonMainTblList.get(i));

            if (henkouList.size() != 0) {
                editHenkouRrkTblEntityList(kihonMainTblList.get(i).getTableId(), kihonMainTblList.get(i).getViewName(),
                    C_HnkSyuruiKbn.HENKOU, hanbetuKoumokunmList.get(i), henkouList, pKykKihon);
            }
        }

        if (pNyuukinKakusyouData != null) {

            String hanbetuNm = "入金確証情報（入金確証番号：" + pNyuukinKakusyouData.getNyuukinkakusyouno() + "）";
            String nykkeiro = C_Nykkeiro.getContentByValue(C_Nykkeiro.PATTERN_DISP, pNyuukinKakusyouData.getNykkeiro().getValue());
            String[] henkouArray = {"","","","","",
                "入金伝票日付：" + pNyuukinKakusyouData.getNykdenymd() + "／" +
                    "束仮勘定番号：" + pNyuukinKakusyouData.getTabakarikanjyono() + "／" +
                    "入金経路：" + nykkeiro + "／" +
                    "充当年月：" + convertNullToBlank(pNyuukinKakusyouData.getJyuutouym()) + "／" +
                    "充当回数（年）：" + pNyuukinKakusyouData.getJyutoukaisuuy() + "／" +
                    "充当回数（月）：" + pNyuukinKakusyouData.getJyutoukaisuum() + "／" +
                    "領収日：" + pNyuukinKakusyouData.getRyosyuymd() };
            editHenkouRrkEntity(IT_NyuukinKakusyouData.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_NyuukinKakusyouData.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA, hanbetuNm, henkouArray, pKykKihon);
        }
        List<IT_BAK_KykSyouhn> bakKykSyouhnList = new ArrayList<IT_BAK_KykSyouhn>();
        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhns();
        if (pBakKykKihon != null) {
            bakKykSyouhnList = pBakKykKihon.getBAKKykSyouhns();
        }

        TreeMap<String, IT_BAK_KykSyouhn> beforeKykSyouhnMap = new TreeMap<String, IT_BAK_KykSyouhn>();
        for (IT_BAK_KykSyouhn bakKykSyouhn : bakKykSyouhnList) {
            String syutkkbn = bakKykSyouhn.getSyutkkbn().getValue();
            String syouhnCd = bakKykSyouhn.getSyouhncd();
            String syouhnsdNo = String.format("%02d",bakKykSyouhn.getSyouhnsdno());
            String kyksyouhnRenno = String.format("%02d",bakKykSyouhn.getKyksyouhnrenno());
            beforeKykSyouhnMap.put(syoNo + syutkkbn + syouhnCd + syouhnsdNo + kyksyouhnRenno, bakKykSyouhn);
        }
        Set<String> beforeKykSyouhnMapKeySet = beforeKykSyouhnMap.keySet();

        TreeMap<String, IT_KykSyouhn> afterKykSyouhnMap = new TreeMap<String, IT_KykSyouhn>();
        for (IT_KykSyouhn kykSyouhn : kykSyouhnList) {
            String syutkkbn = kykSyouhn.getSyutkkbn().getValue();
            String syouhnCd = kykSyouhn.getSyouhncd();
            String syouhnsdNo = String.format("%02d",kykSyouhn.getSyouhnsdno());
            String kyksyouhnRenno = String.format("%02d",kykSyouhn.getKyksyouhnrenno());
            afterKykSyouhnMap.put(syoNo + syutkkbn + syouhnCd + syouhnsdNo + kyksyouhnRenno, kykSyouhn);
        }
        Set<String> afterKykSyouhnMapKeySet = afterKykSyouhnMap.keySet();

        List<String> kykSyouhnHenkouKeySet = getContainsKeyList(beforeKykSyouhnMapKeySet,afterKykSyouhnMapKeySet);
        for (String mapKey : kykSyouhnHenkouKeySet) {
            IT_BAK_KykSyouhn bakKykSyouhn = beforeKykSyouhnMap.get(mapKey);
            IT_KykSyouhn kykSyouhn = afterKykSyouhnMap.get(mapKey);
            LinkedList<String[]> henkouList = editHenkouList(bakKykSyouhn, kykSyouhn);

            if (henkouList.size() != 0) {
                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());
                String hanbetuNm = syouhnZokusei.getSyouhnnmryaku();
                editHenkouRrkTblEntityList(IT_KykSyouhn.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_KykSyouhn.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU, hanbetuNm, henkouList, pKykKihon);
            }
        }

        List<String>  kykSyouhnDeleteKeySet = getNoContainsKeyList(beforeKykSyouhnMapKeySet,afterKykSyouhnMapKeySet);
        for (String mapKey : kykSyouhnDeleteKeySet) {
            IT_BAK_KykSyouhn bakKykSyouhn = beforeKykSyouhnMap.get(mapKey);
            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(bakKykSyouhn.getSyouhncd(), bakKykSyouhn.getSyouhnsdno());
            String hanbetuNm = syouhnZokusei.getSyouhnnmryaku();
            editHenkouRrkTblEntityList(IT_KykSyouhn.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_KykSyouhn.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO, hanbetuNm, null, pKykKihon);
        }

        List<String>  kykSyouhnAddKeySet = getNoContainsKeyList(afterKykSyouhnMapKeySet, beforeKykSyouhnMapKeySet);
        for (String mapKey : kykSyouhnAddKeySet) {
            IT_KykSyouhn kykSyouhn = afterKykSyouhnMap.get(mapKey);
            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());
            String hanbetuNm = syouhnZokusei.getSyouhnnmryaku();
            editHenkouRrkTblEntityList(IT_KykSyouhn.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_KykSyouhn.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA, hanbetuNm, null, pKykKihon);
        }

        List<IT_BAK_KykUkt> bakKykUktList = new ArrayList<IT_BAK_KykUkt>();
        List<IT_KykUkt> kykUktList = pKykKihon.getKykUkts();
        if (pBakKykKihon != null) {
            bakKykUktList = pBakKykKihon.getBAKKykUkts();
        }

        TreeMap<String, IT_BAK_KykUkt> beforeKykUktMap = new TreeMap<String, IT_BAK_KykUkt>();
        for (IT_BAK_KykUkt bakKykUkt : bakKykUktList) {
            String uktsyukbn = String.format("%02d",Integer.parseInt(bakKykUkt.getUktsyukbn().getValue()));
            String uktsyurenno = String.format("%02d",bakKykUkt.getUktsyurenno());
            beforeKykUktMap.put(syoNo + uktsyukbn + uktsyurenno, bakKykUkt);
        }
        Set<String> beforeKykUktMapKeySet = beforeKykUktMap.keySet();

        TreeMap<String, IT_KykUkt> afterKykUktMap = new TreeMap<String, IT_KykUkt>();
        for (IT_KykUkt kykUkt : kykUktList) {
            String uktsyukbn = String.format("%02d",Integer.parseInt(kykUkt.getUktsyukbn().getValue()));
            String uktsyurenno = String.format("%02d",kykUkt.getUktsyurenno());
            afterKykUktMap.put(syoNo + uktsyukbn + uktsyurenno, kykUkt);
        }
        Set<String> afterKykUktMapKeySet = afterKykUktMap.keySet();

        List<String> kykUktHenkouKeySet = getContainsKeyList(beforeKykUktMapKeySet,afterKykUktMapKeySet);
        for (String mapKey : kykUktHenkouKeySet) {
            IT_BAK_KykUkt bakKykUkt = beforeKykUktMap.get(mapKey);
            IT_KykUkt kykUkt = afterKykUktMap.get(mapKey);
            LinkedList<String[]> henkouList = editHenkouList(bakKykUkt, kykUkt);

            if (henkouList.size() != 0) {
                String uktsyukbn = C_UktsyuKbn.getContentByValue(C_UktsyuKbn.PATTERN_RRKGAMEN,bakKykUkt.getUktsyukbn().getValue());

                String uktKbn = C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT,bakKykUkt.getUktkbn().getValue());

                String hanbetuNm = "";

                if (C_UktKbn.TOKUTEIMEIGI.eq(bakKykUkt.getUktkbn())) {
                    hanbetuNm = uktsyukbn + "（受取人区分：" + uktKbn + "（" + bakKykUkt.getUktnmkj() + "））";
                }
                else {
                    hanbetuNm = uktsyukbn + "（受取人区分：" + uktKbn + "）";
                }

                editHenkouRrkTblEntityList(IT_KykUkt.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_KykUkt.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU, hanbetuNm, henkouList, pKykKihon);
            }
        }

        List<String>  kykUktDeleteKeySet = getNoContainsKeyList(beforeKykUktMapKeySet,afterKykUktMapKeySet);
        for (String mapKey : kykUktDeleteKeySet) {
            IT_BAK_KykUkt bakKykUkt = beforeKykUktMap.get(mapKey);
            String hanbetuNm = C_UktsyuKbn.getContentByValue(C_UktsyuKbn.PATTERN_RRKGAMEN,bakKykUkt.getUktsyukbn().getValue());

            String uktKbn = C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT,bakKykUkt.getUktkbn().getValue());

            String henkouItem3 = "";

            if (C_UktKbn.TOKUTEIMEIGI.eq(bakKykUkt.getUktkbn())) {
                henkouItem3 = "受取人区分："+ uktKbn + "（" + bakKykUkt.getUktnmkj() + "）／分割割合：" + bakKykUkt.getUktbnwari();
            }
            else {
                henkouItem3 = "受取人区分："+ uktKbn + "／分割割合：" + bakKykUkt.getUktbnwari();
            }

            String[] henkouArray = {"","","",henkouItem3,"",""};
            editHenkouRrkEntity(IT_KykUkt.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_KykUkt.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO, hanbetuNm, henkouArray, pKykKihon);
        }

        List<String>  kykUktAddKeySet = getNoContainsKeyList(afterKykUktMapKeySet, beforeKykUktMapKeySet);
        for (String mapKey : kykUktAddKeySet) {
            IT_KykUkt kykUkt = afterKykUktMap.get(mapKey);
            String hanbetuNm = C_UktsyuKbn.getContentByValue(C_UktsyuKbn.PATTERN_RRKGAMEN,kykUkt.getUktsyukbn().getValue());

            String uktKbn = C_UktKbn.getContentByValue(C_UktKbn.PATTERN_DEFAULT,kykUkt.getUktkbn().getValue());

            String henkouItem5 = "";

            if (C_UktKbn.TOKUTEIMEIGI.eq(kykUkt.getUktkbn())) {
                henkouItem5 = "受取人区分："+ uktKbn + "（" + kykUkt.getUktnmkj() + "）" + "／" + "分割割合：" + kykUkt.getUktbnwari();
            }
            else {
                henkouItem5 = "受取人区分："+ uktKbn + "／" + "分割割合：" + kykUkt.getUktbnwari();
            }

            String[] henkouArray = {"","","","","",henkouItem5};
            editHenkouRrkEntity(IT_KykUkt.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_KykUkt.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA, hanbetuNm, henkouArray, pKykKihon);
        }

        List<IT_BAK_Kariukekin> bakKariukekinList = new ArrayList<IT_BAK_Kariukekin>();
        List<IT_Kariukekin> kariukekinList = pKykKihon.getKariukekins();
        if (pBakKykKihon != null) {
            bakKariukekinList = pBakKykKihon.getBAKKariukekins();
        }

        TreeMap<String, IT_BAK_Kariukekin> beforeKariukekinMap = new TreeMap<String, IT_BAK_Kariukekin>();
        for (IT_BAK_Kariukekin bakKariukekin : bakKariukekinList) {
            String krkno = String.format("%05d",bakKariukekin.getKrkno());
            beforeKariukekinMap.put(syoNo + krkno, bakKariukekin);
        }
        Set<String> beforeKariukekinMapKeySet = beforeKariukekinMap.keySet();

        TreeMap<String, IT_Kariukekin> afterKariukekinMap = new TreeMap<String, IT_Kariukekin>();
        for (IT_Kariukekin kariukekin : kariukekinList) {
            String krkno = String.format("%05d",kariukekin.getKrkno());
            afterKariukekinMap.put(syoNo + krkno, kariukekin);
        }
        Set<String> afterKariukekinMapKeySet = afterKariukekinMap.keySet();

        List<String> kariukekinHenkouKeySet = getContainsKeyList(beforeKariukekinMapKeySet,afterKariukekinMapKeySet);
        for (String mapKey : kariukekinHenkouKeySet) {
            IT_BAK_Kariukekin bakKariukekin = beforeKariukekinMap.get(mapKey);
            IT_Kariukekin kariukekin = afterKariukekinMap.get(mapKey);
            LinkedList<String[]> henkouList = editHenkouList(bakKariukekin, kariukekin);

            if (henkouList.size() != 0) {
                String hanbetuNm = "仮受金情報（仮受番号：" + bakKariukekin.getKrkno() + "）";
                editHenkouRrkTblEntityList(IT_Kariukekin.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_Kariukekin.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU, hanbetuNm, henkouList, pKykKihon);
            }
        }

        List<String>  kariukekinDeleteKeySet = getNoContainsKeyList(beforeKariukekinMapKeySet,afterKariukekinMapKeySet);
        for (String mapKey : kariukekinDeleteKeySet) {
            IT_BAK_Kariukekin bakKariukekin = beforeKariukekinMap.get(mapKey);
            String hanbetuNm = "仮受金情報（仮受番号：" + bakKariukekin.getKrkno() + "）";
            String krkriyuukbn = C_KrkriyuuKbn.getContentByValue(bakKariukekin.getKrkriyuukbn().getValue());
            String nyknaiyouKbn = C_NyknaiyouKbn.getContentByValue(bakKariukekin.getNyknaiyoukbn().getValue());
            String nykkeiro = C_Nykkeiro.getContentByValue(C_Nykkeiro.PATTERN_DISP, bakKariukekin.getNykkeiro().getValue());
            String[] henkouArray = {"","","",
                "計上日：" + bakKariukekin.getKrkkeijyoymd() + "／" +
                    "金額：" + bakKariukekin.getKrkgk() + "／" +
                    "仮受理由：" + subString(krkriyuukbn, 6) + "／" + subString(nyknaiyouKbn, 10) + "／" +
                    "経路：" + subString(nykkeiro, 6) + "／" +
                    "充当年月：" + convertNullToBlank(bakKariukekin.getJyuutouym()) + "／" +
                    "年数：" + bakKariukekin.getJyutoukaisuuy() + "／" +
                    "月数：" + bakKariukekin.getJyutoukaisuum() + "／" +
                    "領収日：" + bakKariukekin.getRyosyuymd(),
                    "",""};
            editHenkouRrkEntity(IT_Kariukekin.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_Kariukekin.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO, hanbetuNm, henkouArray, pKykKihon);
        }

        List<String>  kariukekinAddKeySet = getNoContainsKeyList(afterKariukekinMapKeySet, beforeKariukekinMapKeySet);
        for (String mapKey : kariukekinAddKeySet) {
            IT_Kariukekin kariukekin = afterKariukekinMap.get(mapKey);
            String hanbetuNm = "仮受金情報（仮受番号：" + kariukekin.getKrkno() + "）";
            String krkriyuukbn = C_KrkriyuuKbn.getContentByValue(kariukekin.getKrkriyuukbn().getValue());
            String nyknaiyouKbn = C_NyknaiyouKbn.getContentByValue(kariukekin.getNyknaiyoukbn().getValue());
            String nykkeiro = C_Nykkeiro.getContentByValue(C_Nykkeiro.PATTERN_DISP, kariukekin.getNykkeiro().getValue());
            String[] henkouArray = {"","","","","",
                "計上日：" + kariukekin.getKrkkeijyoymd() + "／" +
                    "金額：" + kariukekin.getKrkgk() + "／" +
                    "仮受理由：" + subString(krkriyuukbn, 6) + "／" + subString(nyknaiyouKbn, 10) + "／" +
                    "経路：" + subString(nykkeiro, 6) + "／" +
                    "充当年月：" + convertNullToBlank(kariukekin.getJyuutouym()) + "／" +
                    "年数：" + kariukekin.getJyutoukaisuuy() + "／" +
                    "月数：" + kariukekin.getJyutoukaisuum() + "／" +
                    "領収日：" + kariukekin.getRyosyuymd() };
            editHenkouRrkEntity(IT_Kariukekin.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_Kariukekin.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA, hanbetuNm, henkouArray, pKykKihon);
        }

        List<IT_BAK_KykDairiten> bakKykDairitenList = new ArrayList<IT_BAK_KykDairiten>();
        List<IT_KykDairiten> kykDairitenList = pKykKihon.getKykDairitens();
        if (pBakKykKihon != null) {
            bakKykDairitenList = pBakKykKihon.getBAKKykDairitens();
        }

        TreeMap<String, IT_BAK_KykDairiten> beforeKykDairitenMap = new TreeMap<String, IT_BAK_KykDairiten>();
        for (IT_BAK_KykDairiten bakKykDairiten : bakKykDairitenList) {
            String drtenrenno = String.format("%02d",bakKykDairiten.getDrtenrenno());
            beforeKykDairitenMap.put(syoNo + drtenrenno, bakKykDairiten);
        }
        Set<String> beforeKykDairitenMapKeySet = beforeKykDairitenMap.keySet();

        TreeMap<String, IT_KykDairiten> afterKykDairitenMap = new TreeMap<String, IT_KykDairiten>();
        for (IT_KykDairiten kykDairiten : kykDairitenList) {
            String drtenrenno = String.format("%02d",kykDairiten.getDrtenrenno());
            afterKykDairitenMap.put(syoNo + drtenrenno, kykDairiten);
        }
        Set<String> afterKykDairitenMapKeySet = afterKykDairitenMap.keySet();

        List<String> kykDairitenHenkouKeySet = getContainsKeyList(beforeKykDairitenMapKeySet,afterKykDairitenMapKeySet);
        for (String mapKey : kykDairitenHenkouKeySet) {
            IT_BAK_KykDairiten bakKykDairiten = beforeKykDairitenMap.get(mapKey);
            IT_KykDairiten kykDairiten = afterKykDairitenMap.get(mapKey);
            LinkedList<String[]> henkouList = editHenkouList(bakKykDairiten, kykDairiten);

            if (henkouList.size() != 0) {
                String hanbetuNm = "契約代理店情報（代理店連番：" + bakKykDairiten.getDrtenrenno() + "）";
                editHenkouRrkTblEntityList(IT_KykDairiten.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_KykDairiten.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU, hanbetuNm, henkouList, pKykKihon);
            }
        }

        List<String> kykDairitenDeleteKeySet = getNoContainsKeyList(beforeKykDairitenMapKeySet,afterKykDairitenMapKeySet);
        for (String mapKey : kykDairitenDeleteKeySet) {
            IT_BAK_KykDairiten bakKykDairiten = beforeKykDairitenMap.get(mapKey);
            String hanbetuNm = "契約代理店情報（代理店連番：" + bakKykDairiten.getDrtenrenno() + "）";

            String henkouItem3 = "代理店コード：" + bakKykDairiten.getDrtencd() + "／" + "募集人コード：" + bakKykDairiten.getBosyuucd() + "／"
                + "分担割合：" + bakKykDairiten.getBunwari();

            String[] henkouArray = {"","","",henkouItem3,"",""};
            editHenkouRrkEntity(IT_KykDairiten.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_KykDairiten.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO, hanbetuNm, henkouArray, pKykKihon);
        }

        List<String>  kykDairitenAddKeySet = getNoContainsKeyList(afterKykDairitenMapKeySet, beforeKykDairitenMapKeySet);
        for (String mapKey : kykDairitenAddKeySet) {
            IT_KykDairiten kykDairiten = afterKykDairitenMap.get(mapKey);
            String hanbetuNm = "契約代理店情報（代理店連番：" + kykDairiten.getDrtenrenno() + "）";

            String henkouItem5 = "代理店コード：" + kykDairiten.getDrtencd() + "／" + "募集人コード：" + kykDairiten.getBosyuucd() + "／"
                + "分担割合：" + kykDairiten.getBunwari();

            String[] henkouArray = {"","","","","",henkouItem5};
            editHenkouRrkEntity(IT_KykDairiten.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_KykDairiten.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA, hanbetuNm, henkouArray, pKykKihon);
        }

        List<IT_BAK_FatcaInfo> bakFatcaInfoList = new ArrayList<IT_BAK_FatcaInfo>();
        List<IT_FatcaInfo> fatcaInfoList = pKykKihon.getFatcaInfos();
        if (pBakKykKihon != null) {
            bakFatcaInfoList = pBakKykKihon.getBAKFatcaInfos();
        }

        TreeMap<String, IT_BAK_FatcaInfo> beforeFatcaInfoMap = new TreeMap<String, IT_BAK_FatcaInfo>();
        for (IT_BAK_FatcaInfo bakFatcaInfo : bakFatcaInfoList) {
            String renno = String.format("%02d",bakFatcaInfo.getRenno());
            beforeFatcaInfoMap.put(syoNo + renno, bakFatcaInfo);
        }
        Set<String> beforeFatcaInfoMapKeySet = beforeFatcaInfoMap.keySet();

        TreeMap<String, IT_FatcaInfo> afterFatcaInfoMap = new TreeMap<String, IT_FatcaInfo>();
        for (IT_FatcaInfo fatcaInfo : fatcaInfoList) {
            String renno = String.format("%02d",fatcaInfo.getRenno());
            afterFatcaInfoMap.put(syoNo + renno, fatcaInfo);
        }
        Set<String> afterFatcaInfoMapKeySet = afterFatcaInfoMap.keySet();

        List<String> fatcaInfoHenkouKeySet = getContainsKeyList(beforeFatcaInfoMapKeySet,afterFatcaInfoMapKeySet);
        for (String mapKey : fatcaInfoHenkouKeySet) {
            IT_BAK_FatcaInfo bakFatcaInfo = beforeFatcaInfoMap.get(mapKey);
            IT_FatcaInfo fatcaInfo = afterFatcaInfoMap.get(mapKey);
            LinkedList<String[]> henkouList = editHenkouList(bakFatcaInfo, fatcaInfo);

            if (henkouList.size() != 0) {
                String hanbetuNm = "ＦＡＴＣＡ情報" + "（" + bakFatcaInfo.getNmkj() + "）";
                editHenkouRrkTblEntityList(IT_FatcaInfo.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_FatcaInfo.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU, hanbetuNm, henkouList, pKykKihon);
            }
        }

        List<String> fatcaInfoDeleteKeySet = getNoContainsKeyList(beforeFatcaInfoMapKeySet,afterFatcaInfoMapKeySet);
        for (String mapKey : fatcaInfoDeleteKeySet) {
            IT_BAK_FatcaInfo bakFatcaInfo = beforeFatcaInfoMap.get(mapKey);
            String hanbetuNm = "ＦＡＴＣＡ情報";
            String[] henkouArray = {"nmkj","氏名（漢字）","",bakFatcaInfo.getNmkj(),"",""};
            editHenkouRrkEntity(IT_FatcaInfo.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_FatcaInfo.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO, hanbetuNm, henkouArray, pKykKihon);
        }

        List<String>  fatcaInfoAddKeySet = getNoContainsKeyList(afterFatcaInfoMapKeySet, beforeFatcaInfoMapKeySet);
        for (String mapKey : fatcaInfoAddKeySet) {
            IT_FatcaInfo fatcaInfo = afterFatcaInfoMap.get(mapKey);
            String hanbetuNm = "ＦＡＴＣＡ情報";
            String[] henkouArray = {"nmkj","氏名（漢字）","","","",fatcaInfo.getNmkj()};
            editHenkouRrkEntity(IT_FatcaInfo.TABLE_NAME ,ResourceUtil.getApplicationResources().getString(IT_FatcaInfo.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA, hanbetuNm, henkouArray, pKykKihon);
        }


        List<IT_BAK_AeoiInfo> bakAeoiInfoLst = new ArrayList<IT_BAK_AeoiInfo>();
        List<IT_AeoiInfo> aeoiInfoLst = pKykKihon.getAeoiInfos();
        if (pBakKykKihon != null) {
            bakAeoiInfoLst = pBakKykKihon.getBAKAeoiInfos();
        }

        TreeMap<String, IT_BAK_AeoiInfo> beforeBakAeoiInfoMap = new TreeMap<String, IT_BAK_AeoiInfo>();
        for (IT_BAK_AeoiInfo bakAeoiInfo :bakAeoiInfoLst) {
            String renban = String.format("%02d", bakAeoiInfo.getRenno());
            beforeBakAeoiInfoMap.put(syoNo + renban, bakAeoiInfo);
        }
        Set<String> beforeKeyset = beforeBakAeoiInfoMap.keySet();

        TreeMap<String, IT_AeoiInfo> afterAeoiInfoMap = new TreeMap<String, IT_AeoiInfo>();
        for (IT_AeoiInfo aeoiInfo : aeoiInfoLst) {
            String renban = String.format("%02d", aeoiInfo.getRenno());
            afterAeoiInfoMap.put(syoNo + renban, aeoiInfo);
        }
        Set<String> afterKeyset = afterAeoiInfoMap.keySet();

        List<String> henkouKeyLst = getContainsKeyList(beforeKeyset, afterKeyset);
        for (String henkouKey : henkouKeyLst) {
            IT_BAK_AeoiInfo bakAeoiInfo = beforeBakAeoiInfoMap.get(henkouKey);
            IT_AeoiInfo aeoiInfo = afterAeoiInfoMap.get(henkouKey);
            LinkedList<String[]> henkouKoumokuList = editHenkouList(bakAeoiInfo, aeoiInfo);
            if (henkouKoumokuList.size() != 0) {
                String hanbetuKoumokunm = "ＡＥＯＩ情報" + "（" + bakAeoiInfo.getRenno() + "）";
                editHenkouRrkTblEntityList(IT_AeoiInfo.TABLE_NAME,
                    ResourceUtil.getApplicationResources().getString(IT_AeoiInfo.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuKoumokunm,
                    henkouKoumokuList,
                    pKykKihon);
            }
        }

        List<String> deleteKeyLst = getNoContainsKeyList(beforeKeyset, afterKeyset);
        for (String deleteKey : deleteKeyLst) {
            IT_BAK_AeoiInfo bakAeoiInfo = beforeBakAeoiInfoMap.get(deleteKey);
            String aeoiTaisyousyakbn = C_AeoiTaisyousyaKbn.getContentByValue(bakAeoiInfo.getAeoitaisyousyakbn().getValue());
            String hanbetuKoumokunm = "ＡＥＯＩ情報" + "（" + bakAeoiInfo.getRenno() + "）";
            String henkouNaiyou = "";
            if (bakAeoiInfo.getAeoikouryokuendymd() != null) {
                henkouNaiyou = "対象者区分：" + aeoiTaisyousyakbn + "／" +  "効力開始年月日：" +  bakAeoiInfo.getAeoikouryokusttymd()
                    + "／" + "効力終了年月日：" + bakAeoiInfo.getAeoikouryokuendymd();
            }
            else {
                henkouNaiyou = "対象者区分：" + aeoiTaisyousyakbn + "／" +  "効力開始年月日：" +  bakAeoiInfo.getAeoikouryokusttymd();
            }

            String[] henkouArray = {
                "",
                "",
                "",
                henkouNaiyou,
                "",
            ""};
            editHenkouRrkEntity(IT_AeoiInfo.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_AeoiInfo.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<String> addKeyLst = getNoContainsKeyList(afterKeyset, beforeKeyset);
        for (String addKey : addKeyLst) {
            IT_AeoiInfo aeoiInfo = afterAeoiInfoMap.get(addKey);
            String aeoiTaisyousyakbn = C_AeoiTaisyousyaKbn.getContentByValue(aeoiInfo.getAeoitaisyousyakbn().getValue());
            String hanbetuKoumokunm = "ＡＥＯＩ情報" + "（" + aeoiInfo.getRenno() + "）";
            String henkouNaiyou = "";
            if (aeoiInfo.getAeoikouryokuendymd() != null) {
                henkouNaiyou = "対象者区分：" + aeoiTaisyousyakbn + "／" +  "効力開始年月日：" +  aeoiInfo.getAeoikouryokusttymd()
                    + "／" + "効力終了年月日：" + aeoiInfo.getAeoikouryokuendymd();
            }
            else {
                henkouNaiyou = "対象者区分：" + aeoiTaisyousyakbn + "／" +  "効力開始年月日：" +  aeoiInfo.getAeoikouryokusttymd();
            }

            String[] henkouArray = {
                "",
                "",
                "",
                "",
                "",
                henkouNaiyou};
            editHenkouRrkEntity(IT_AeoiInfo.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_AeoiInfo.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }


        List<IT_BAK_KhHenreikin> bakKhHenreikinLst = new ArrayList<IT_BAK_KhHenreikin>();
        List<IT_KhHenreikin> khHenreikinLst = pKykKihon.getKhHenreikins();
        if (pBakKykKihon != null) {
            bakKhHenreikinLst = pBakKykKihon.getBAKKhHenreikins();
        }

        TreeMap<String, IT_BAK_KhHenreikin> beforeBakKhHenreikinMap = new TreeMap<String, IT_BAK_KhHenreikin>();
        for (IT_BAK_KhHenreikin bakKhHenreikin : bakKhHenreikinLst) {
            String henkousikibetukey = bakKhHenreikin.getHenkousikibetukey();
            beforeBakKhHenreikinMap.put(syoNo + henkousikibetukey, bakKhHenreikin);
        }
        Set<String> beforeKhHenreikinKeyset = beforeBakKhHenreikinMap.keySet();

        TreeMap<String, IT_KhHenreikin> afterKhHenreikinMap = new TreeMap<String, IT_KhHenreikin>();
        for (IT_KhHenreikin khHenreikin : khHenreikinLst) {
            String henkousikibetukey = khHenreikin.getHenkousikibetukey();
            afterKhHenreikinMap.put(syoNo + henkousikibetukey, khHenreikin);
        }
        Set<String> afterKhHenreikinKeyset = afterKhHenreikinMap.keySet();

        List<String> khHenreikinHenkouKeySet = getContainsKeyList(beforeKhHenreikinKeyset, afterKhHenreikinKeyset);
        for (String henkouKey : khHenreikinHenkouKeySet) {
            IT_BAK_KhHenreikin bakKhHenreikin = beforeBakKhHenreikinMap.get(henkouKey);
            IT_KhHenreikin khHenreikin = afterKhHenreikinMap.get(henkouKey);
            LinkedList<String[]> henkouKoumokuList = editHenkouList(bakKhHenreikin, khHenreikin);
            if (henkouKoumokuList.size() != 0) {
                String hrsyuruikbn = C_HrsyuruiKbn.getContentByValue(bakKhHenreikin.getHrsyuruikbn().getValue());
                String hanbetuKoumokunm = "返戻金情報（返戻金種類区分：" + hrsyuruikbn + "）";
                editHenkouRrkTblEntityList(IT_KhHenreikin.TABLE_NAME,
                    ResourceUtil.getApplicationResources().getString(IT_KhHenreikin.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuKoumokunm,
                    henkouKoumokuList,
                    pKykKihon);
            }
        }

        List<String> khHenreikinDeleteKeyLst = getNoContainsKeyList(beforeKhHenreikinKeyset, afterKhHenreikinKeyset);
        for (String deleteKey : khHenreikinDeleteKeyLst) {
            IT_BAK_KhHenreikin bakKhHenreikin = beforeBakKhHenreikinMap.get(deleteKey);
            String hrsiharaijyoutaikbn = C_Siharaijyoutaikbn.getContentByValue(bakKhHenreikin.getHrsiharaijyoutaikbn()
                .getValue());
            String seg1cd = C_Segcd.getContentByValue(bakKhHenreikin.getSeg1cd().getValue());
            String seg2cd = C_Segcd.getContentByValue(bakKhHenreikin.getSeg2cd().getValue());
            String tantocd = C_TantouCdKbn.getContentByValue(bakKhHenreikin.getTantocd().getValue());
            String hrsyuruikbn = C_HrsyuruiKbn.getContentByValue(bakKhHenreikin.getHrsyuruikbn().getValue());

            String hanbetuKoumokunm = "返戻金情報（返戻金種類区分：" + hrsyuruikbn + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "返戻金発生日：" + bakKhHenreikin.getHrhsiymd() + "／" +
                    "返戻金発生処理日：" + bakKhHenreikin.getHrhsisyoriymd() + "／" +
                    "返戻金額：" + bakKhHenreikin.getHenreikingk() + "／" +
                    "返戻金支払状態区分：" + hrsiharaijyoutaikbn + "／" +
                    "セグメント１コード：" + seg1cd + "／" +
                    "セグメント２コード：" + seg2cd + "／" +
                    "担当コード：" + tantocd,
                    "",
                    ""
            };
            editHenkouRrkEntity(IT_KhHenreikin.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_KhHenreikin.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<String> khHenreikinAddKeyLst = getNoContainsKeyList(afterKhHenreikinKeyset, beforeKhHenreikinKeyset);
        for (String addKey : khHenreikinAddKeyLst) {
            IT_KhHenreikin khHenreikin = afterKhHenreikinMap.get(addKey);
            String hrsyuruikbn = C_HrsyuruiKbn.getContentByValue(khHenreikin.getHrsyuruikbn().getValue());

            String hanbetuKoumokunm = "返戻金情報（返戻金種類区分：" + hrsyuruikbn + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "",
                "",
                "返戻金発生日：" + khHenreikin.getHrhsiymd() + "／" +
                    "返戻金発生処理日：" + khHenreikin.getHrhsisyoriymd() + "／" +
                    "返戻金額：" + khHenreikin.getHenreikingk()
            };
            editHenkouRrkEntity(IT_KhHenreikin.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_KhHenreikin.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }


        List<IT_BAK_KhSisuurendoTmttkn> bakKhSisuurendoTmttknLst = new ArrayList<IT_BAK_KhSisuurendoTmttkn>();
        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = pKykKihon.getKhSisuurendoTmttkns();
        if (pBakKykKihon != null) {
            bakKhSisuurendoTmttknLst = pBakKykKihon.getBAKKhSisuurendoTmttkns();
        }

        TreeMap<String, IT_BAK_KhSisuurendoTmttkn> beforeBakKhSisuurendoTmttknMap = new TreeMap<String, IT_BAK_KhSisuurendoTmttkn>();
        for (IT_BAK_KhSisuurendoTmttkn bakKhSisuurendoTmttkn : bakKhSisuurendoTmttknLst) {
            BizDateYM tmttknTaisyouYm = bakKhSisuurendoTmttkn.getTmttkntaisyouym();
            String renno = String.format("%02d", bakKhSisuurendoTmttkn.getRenno());
            beforeBakKhSisuurendoTmttknMap.put(syoNo + tmttknTaisyouYm + renno, bakKhSisuurendoTmttkn);
        }
        Set<String> beforeKhSisuurendoTmttknKeyset = beforeBakKhSisuurendoTmttknMap.keySet();

        TreeMap<String, IT_KhSisuurendoTmttkn> afterKhSisuurendoTmttknMap = new TreeMap<String, IT_KhSisuurendoTmttkn>();
        for (IT_KhSisuurendoTmttkn khSisuurendoTmttkn : khSisuurendoTmttknLst) {
            BizDateYM tmttknTaisyouYm = khSisuurendoTmttkn.getTmttkntaisyouym();
            String renno = String.format("%02d", khSisuurendoTmttkn.getRenno());
            afterKhSisuurendoTmttknMap.put(syoNo + tmttknTaisyouYm + renno, khSisuurendoTmttkn);
        }
        Set<String> afterKhSisuurendoTmttknKeyset = afterKhSisuurendoTmttknMap.keySet();

        List<String> khSisuurendoTmttknKeySet = getContainsKeyList(beforeKhSisuurendoTmttknKeyset,
            afterKhSisuurendoTmttknKeyset);
        for (String henkouKey : khSisuurendoTmttknKeySet) {
            IT_BAK_KhSisuurendoTmttkn bakKhSisuurendoTmttkn = beforeBakKhSisuurendoTmttknMap.get(henkouKey);
            IT_KhSisuurendoTmttkn khSisuurendoTmttkn = afterKhSisuurendoTmttknMap.get(henkouKey);
            LinkedList<String[]> henkouKoumokuList = editHenkouList(bakKhSisuurendoTmttkn, khSisuurendoTmttkn);
            if (henkouKoumokuList.size() != 0) {
                String tmttkntaisyouym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate
                    .valueOf(bakKhSisuurendoTmttkn.getTmttkntaisyouym() + "01"));
                String hanbetuKoumokunm = "積立金情報（積立年月：" + tmttkntaisyouym + "　連番：" +
                    bakKhSisuurendoTmttkn.getRenno() + "）";
                editHenkouRrkTblEntityList(IT_KhSisuurendoTmttkn.TABLE_NAME,
                    ResourceUtil.getApplicationResources().getString(IT_KhSisuurendoTmttkn.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuKoumokunm,
                    henkouKoumokuList,
                    pKykKihon);
            }
        }

        List<String> khSisuurendoTmttknDeleteKeyLst = getNoContainsKeyList(beforeKhSisuurendoTmttknKeyset,
            afterKhSisuurendoTmttknKeyset);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        for (String deleteKey : khSisuurendoTmttknDeleteKeyLst) {
            IT_BAK_KhSisuurendoTmttkn bakKhSisuurendoTmttkn = beforeBakKhSisuurendoTmttknMap.get(deleteKey);
            String tmttkntaisyouym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate
                .valueOf(bakKhSisuurendoTmttkn.getTmttkntaisyouym() + "01"));
            String teiritutmttkngkType = henkanTuuka.henkanTuukaTypeToKbn(bakKhSisuurendoTmttkn.getTeiritutmttkngk().getType()).getValue();
            String hanbetuKoumokunm = "積立金情報（積立年月：" + tmttkntaisyouym + "　連番：" +
                bakKhSisuurendoTmttkn.getRenno() + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "積立金対象年月：" + bakKhSisuurendoTmttkn.getTmttkntaisyouym() + "／" +
                    "連番：" + bakKhSisuurendoTmttkn.getRenno() + "／" +
                    "積立金効力開始日：" + bakKhSisuurendoTmttkn.getTmttknkouryokukaisiymd() + "／" +
                    "定率積立金額：" + bakKhSisuurendoTmttkn.getTeiritutmttkngk() + "／" +
                    "指数連動積立金額：" + bakKhSisuurendoTmttkn.getSisuurendoutmttkngk() + "／" +
                    "指数上昇率：" + bakKhSisuurendoTmttkn.getSisuuupritu() + "／" +
                    "積立金増加率：" + bakKhSisuurendoTmttkn.getTmttknzoukaritu() + "／" +
                    "積立金反映時積増判定日：" + bakKhSisuurendoTmttkn.getTmttknhaneitmmshanteiymd() + "／" +
                    "積立金反映時指数：" + bakKhSisuurendoTmttkn.getTmttknhaneisisuu() + "／" +
                    "移転前定率積立金額：" + bakKhSisuurendoTmttkn.getItenmaeteiritutmttkngk() + "／" +
                    "移転前指数連動積立金額：" + bakKhSisuurendoTmttkn.getItenmaesisuurendoutmttkngk() + "／" +
                    "通貨種類：" + teiritutmttkngkType,
                    "",
                    ""
            };
            editHenkouRrkEntity(IT_KhSisuurendoTmttkn.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_KhSisuurendoTmttkn.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<String> khSisuurendoTmttknAddKeyLst = getNoContainsKeyList(afterKhSisuurendoTmttknKeyset,
            beforeKhSisuurendoTmttknKeyset);
        for (String addKey : khSisuurendoTmttknAddKeyLst) {
            IT_KhSisuurendoTmttkn khSisuurendoTmttkn = afterKhSisuurendoTmttknMap.get(addKey);
            String tmttkntaisyouym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(khSisuurendoTmttkn
                .getTmttkntaisyouym() + "01"));
            String hanbetuKoumokunm = "積立金情報（積立年月：" + tmttkntaisyouym + "　連番：" +
                khSisuurendoTmttkn.getRenno() + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "",
                "",
                "積立金効力開始日：" + khSisuurendoTmttkn.getTmttknkouryokukaisiymd() + "／" +
                    "定率積立金額：" + khSisuurendoTmttkn.getTeiritutmttkngk() + "／" +
                    "指数連動積立金額：" + khSisuurendoTmttkn.getSisuurendoutmttkngk() + "／" +
                    "指数上昇率：" + khSisuurendoTmttkn.getSisuuupritu()
            };
            editHenkouRrkEntity(IT_KhSisuurendoTmttkn.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_KhSisuurendoTmttkn.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }


        List<IT_BAK_Azukarikin> bakAzukarikinLst = new ArrayList<IT_BAK_Azukarikin>();
        List<IT_Azukarikin> azukarikinLst = pKykKihon.getAzukarikins();
        if (pBakKykKihon != null) {
            bakAzukarikinLst = pBakKykKihon.getBAKAzukarikins();
        }

        TreeMap<String, IT_BAK_Azukarikin> beforeBakAzukarikinMap = new TreeMap<String, IT_BAK_Azukarikin>();
        for (IT_BAK_Azukarikin bakAzukarikin : bakAzukarikinLst) {
            String henkousikibetukey = bakAzukarikin.getHenkousikibetukey();
            String tuukasyu = bakAzukarikin.getTuukasyu().getValue();
            beforeBakAzukarikinMap.put(syoNo + henkousikibetukey + tuukasyu, bakAzukarikin);
        }
        Set<String> beforeAzukarikinKeyset = beforeBakAzukarikinMap.keySet();

        TreeMap<String, IT_Azukarikin> afterAzukarikinMap = new TreeMap<String, IT_Azukarikin>();
        for (IT_Azukarikin azukarikin : azukarikinLst) {
            String henkousikibetukey = azukarikin.getHenkousikibetukey();
            String tuukasyu = azukarikin.getTuukasyu().getValue();
            afterAzukarikinMap.put(syoNo + henkousikibetukey + tuukasyu, azukarikin);
        }
        Set<String> afterAzukarikinKeyset = afterAzukarikinMap.keySet();

        List<String> azukarikinHenkouKeySet = getContainsKeyList(beforeAzukarikinKeyset, afterAzukarikinKeyset);
        for (String henkouKey : azukarikinHenkouKeySet) {
            IT_BAK_Azukarikin bakAzukarikin = beforeBakAzukarikinMap.get(henkouKey);
            IT_Azukarikin azukarikin = afterAzukarikinMap.get(henkouKey);
            LinkedList<String[]> henkouKoumokuList = editHenkouList(bakAzukarikin, azukarikin);
            if (henkouKoumokuList.size() != 0) {
                String azukarikinsyuruiKbn = C_AzukarikinsyuruiKbn.getContentByValue(bakAzukarikin.getAzukarikinsyuruikbn().getValue());
                String hanbetuKoumokunm = "預り金情報（預り金種類区分：" + azukarikinsyuruiKbn + "）";
                editHenkouRrkTblEntityList(IT_Azukarikin.TABLE_NAME,
                    ResourceUtil.getApplicationResources().getString(IT_Azukarikin.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuKoumokunm,
                    henkouKoumokuList,
                    pKykKihon);
            }
        }

        List<String> azukarikinDeleteKeyLst = getNoContainsKeyList(beforeAzukarikinKeyset, afterAzukarikinKeyset);
        for (String deleteKey : azukarikinDeleteKeyLst) {
            IT_BAK_Azukarikin bakAzukarikin = beforeBakAzukarikinMap.get(deleteKey);
            String azukarikinsyuruiKbn = C_AzukarikinsyuruiKbn.getContentByValue(bakAzukarikin.getAzukarikinsyuruikbn().getValue());

            String hanbetuKoumokunm = "預り金情報（預り金種類区分：" + azukarikinsyuruiKbn + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "預り金発生日：" + bakAzukarikin.getAzukarikinhsiymd() + "／" +
                    "預り金額：" + bakAzukarikin.getAzukarikingk(),
                    "",
                    ""
            };
            editHenkouRrkEntity(IT_Azukarikin.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_Azukarikin.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<String> azukarikinAddKeyLst = getNoContainsKeyList(afterAzukarikinKeyset, beforeAzukarikinKeyset);
        for (String addKey : azukarikinAddKeyLst) {
            IT_Azukarikin azukarikin = afterAzukarikinMap.get(addKey);
            String azukarikinsyuruiKbn = C_AzukarikinsyuruiKbn.getContentByValue(azukarikin.getAzukarikinsyuruikbn().getValue());

            String hanbetuKoumokunm = "預り金情報（預り金種類区分：" + azukarikinsyuruiKbn + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "",
                "",
                "預り金発生日：" + azukarikin.getAzukarikinhsiymd() + "／" +
                    "預り金額：" + azukarikin.getAzukarikingk()
            };
            editHenkouRrkEntity(IT_Azukarikin.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_Azukarikin.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }


        List<IT_BAK_HokenryouTmttkn> bakHokenryouTmttknLst = new ArrayList<IT_BAK_HokenryouTmttkn>();
        List<IT_HokenryouTmttkn> hokenryouTmttknLst = pKykKihon.getHokenryouTmttkns();
        if (pBakKykKihon != null) {
            bakHokenryouTmttknLst = pBakKykKihon.getBAKHokenryouTmttkns();
        }

        TreeMap<String, IT_BAK_HokenryouTmttkn> beforeBakHokenryouTmttknMap = new TreeMap<String, IT_BAK_HokenryouTmttkn>();
        for (IT_BAK_HokenryouTmttkn bakHokenryouTmttkn : bakHokenryouTmttknLst) {
            BizDateYM tmttknTaisyouYm = bakHokenryouTmttkn.getTmttkntaisyouym();
            String renno = String.format("%02d", bakHokenryouTmttkn.getRenno());
            beforeBakHokenryouTmttknMap.put(syoNo + tmttknTaisyouYm + renno, bakHokenryouTmttkn);
        }
        Set<String> beforeHokenryouTmttknKeyset = beforeBakHokenryouTmttknMap.keySet();

        TreeMap<String, IT_HokenryouTmttkn> afterHokenryouTmttknMap = new TreeMap<String, IT_HokenryouTmttkn>();
        for (IT_HokenryouTmttkn hokenryouTmttkn : hokenryouTmttknLst) {
            BizDateYM tmttknTaisyouYm = hokenryouTmttkn.getTmttkntaisyouym();
            String renno = String.format("%02d", hokenryouTmttkn.getRenno());
            afterHokenryouTmttknMap.put(syoNo + tmttknTaisyouYm + renno, hokenryouTmttkn);
        }
        Set<String> afterHokenryouTmttknKeyset = afterHokenryouTmttknMap.keySet();

        List<String> hokenryouTmttknHenkouKeySet = getContainsKeyList(beforeHokenryouTmttknKeyset, afterHokenryouTmttknKeyset);
        for (String henkouKey : hokenryouTmttknHenkouKeySet) {
            IT_BAK_HokenryouTmttkn bakHokenryouTmttkn = beforeBakHokenryouTmttknMap.get(henkouKey);
            IT_HokenryouTmttkn hokenryouTmttkn = afterHokenryouTmttknMap.get(henkouKey);
            LinkedList<String[]> henkouKoumokuList = editHenkouList(bakHokenryouTmttkn, hokenryouTmttkn);
            if (henkouKoumokuList.size() != 0) {
                String tmttkntaisyouym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate
                    .valueOf(bakHokenryouTmttkn.getTmttkntaisyouym() + "01"));
                String hanbetuKoumokunm = "積立金情報（積立年月：" + tmttkntaisyouym + "　連番：" +
                    bakHokenryouTmttkn.getRenno() + "）";
                editHenkouRrkTblEntityList(IT_HokenryouTmttkn.TABLE_NAME,
                    ResourceUtil.getApplicationResources().getString(IT_HokenryouTmttkn.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuKoumokunm,
                    henkouKoumokuList,
                    pKykKihon);
            }
        }

        List<String> hokenryouTmttknDeleteKeyLst = getNoContainsKeyList(beforeHokenryouTmttknKeyset, afterHokenryouTmttknKeyset);
        for (String deleteKey : hokenryouTmttknDeleteKeyLst) {
            IT_BAK_HokenryouTmttkn bakHokenryouTmttkn = beforeBakHokenryouTmttknMap.get(deleteKey);
            String tmttkntaisyouym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate
                .valueOf(bakHokenryouTmttkn.getTmttkntaisyouym() + "01"));

            String hanbetuKoumokunm = "積立金情報（積立年月：" + tmttkntaisyouym + "　連番：" +
                bakHokenryouTmttkn.getRenno() + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "積立金対象年月：" + bakHokenryouTmttkn.getTmttkntaisyouym() + "／" +
                    "連番：" + bakHokenryouTmttkn.getRenno() + "／" +
                    "保険料積立金額：" + bakHokenryouTmttkn.getPtmttkngk() + "／" +
                    "既払込保険料相当額：" + bakHokenryouTmttkn.getKihrkmpstgk() + "／" +
                    "調整前保険料積立金額：" + bakHokenryouTmttkn.getTyouseimaeptmttkngk(),
                    "",
                    ""
            };
            editHenkouRrkEntity(IT_HokenryouTmttkn.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_HokenryouTmttkn.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<String> HokenryouTmttknAddKeyLst = getNoContainsKeyList(afterHokenryouTmttknKeyset, beforeHokenryouTmttknKeyset);
        for (String addKey : HokenryouTmttknAddKeyLst) {
            IT_HokenryouTmttkn hokenryouTmttkn = afterHokenryouTmttknMap.get(addKey);
            String tmttkntaisyouym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate
                .valueOf(hokenryouTmttkn.getTmttkntaisyouym() + "01"));

            String hanbetuKoumokunm = "積立金情報（積立年月：" + tmttkntaisyouym + "　連番：" +
                hokenryouTmttkn.getRenno() + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "",
                "",
                "保険料積立金額：" + hokenryouTmttkn.getPtmttkngk() + "／" +
                    "既払込保険料相当額：" + hokenryouTmttkn.getKihrkmpstgk() + "／" +
                    "調整前保険料積立金額：" + hokenryouTmttkn.getTyouseimaeptmttkngk()
            };
            editHenkouRrkEntity(IT_HokenryouTmttkn.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_HokenryouTmttkn.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }


        List<IT_BAK_YykIdouUktk> bakYykIdouUktkLst = new ArrayList<IT_BAK_YykIdouUktk>();
        List<IT_YykIdouUktk> yykIdouUktkLst = pKykKihon.getYykIdouUktks();
        if (pBakKykKihon != null) {
            bakYykIdouUktkLst = pBakKykKihon.getBAKYykIdouUktks();
        }

        TreeMap<String, IT_BAK_YykIdouUktk> beforeBakYykIdouUktkMap = new TreeMap<String, IT_BAK_YykIdouUktk>();
        for (IT_BAK_YykIdouUktk bakYykIdouUktk : bakYykIdouUktkLst) {
            String henkousikibetukey = bakYykIdouUktk.getHenkousikibetukey();
            String kinouid = bakYykIdouUktk.getKinouId();
            beforeBakYykIdouUktkMap.put(syoNo + henkousikibetukey + kinouid, bakYykIdouUktk);
        }
        Set<String> beforeYykIdouUktkKeyset = beforeBakYykIdouUktkMap.keySet();

        TreeMap<String, IT_YykIdouUktk> afterYykIdouUktkMap = new TreeMap<String, IT_YykIdouUktk>();
        for (IT_YykIdouUktk yykIdouUktk : yykIdouUktkLst) {
            String henkousikibetukey = yykIdouUktk.getHenkousikibetukey();
            String kinouid = yykIdouUktk.getKinouId();
            afterYykIdouUktkMap.put(syoNo + henkousikibetukey + kinouid, yykIdouUktk);
        }
        Set<String> afterYykIdouUktkKeyset = afterYykIdouUktkMap.keySet();

        List<String> yykIdouUktkHenkouKeySet = getContainsKeyList(beforeYykIdouUktkKeyset, afterYykIdouUktkKeyset);
        for (String henkouKey : yykIdouUktkHenkouKeySet) {
            IT_BAK_YykIdouUktk bakYykIdouUktk = beforeBakYykIdouUktkMap.get(henkouKey);
            IT_YykIdouUktk yykIdouUktk = afterYykIdouUktkMap.get(henkouKey);
            LinkedList<String[]> henkouKoumokuList = editHenkouList(bakYykIdouUktk, yykIdouUktk);
            if (henkouKoumokuList.size() != 0) {
                String hanbetuKoumokunm = "予約異動受付情報";
                editHenkouRrkTblEntityList(IT_YykIdouUktk.TABLE_NAME,
                    ResourceUtil.getApplicationResources().getString(IT_YykIdouUktk.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuKoumokunm,
                    henkouKoumokuList,
                    pKykKihon);
            }
        }

        List<String> yykIdouUktkDeleteKeyLst = getNoContainsKeyList(beforeYykIdouUktkKeyset, afterYykIdouUktkKeyset);
        for (String deleteKey : yykIdouUktkDeleteKeyLst) {
            IT_BAK_YykIdouUktk bakYykIdouUktk = beforeBakYykIdouUktkMap.get(deleteKey);

            String hanbetuKoumokunm = "予約異動受付情報";
            String[] henkouArray = {
                "",
                "",
                "",
                "受付日：" + bakYykIdouUktk.getUktkymd(),
                "",
                ""
            };
            editHenkouRrkEntity(IT_YykIdouUktk.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_YykIdouUktk.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<String> yykIdouUktkAddKeyLst = getNoContainsKeyList(afterYykIdouUktkKeyset, beforeYykIdouUktkKeyset);
        for (String addKey : yykIdouUktkAddKeyLst) {
            IT_YykIdouUktk yykIdouUktk = afterYykIdouUktkMap.get(addKey);

            String hanbetuKoumokunm = "予約異動受付情報";
            String[] henkouArray = {
                "",
                "",
                "",
                "",
                "",
                "受付日：" + yykIdouUktk.getUktkymd()
            };
            editHenkouRrkEntity(IT_YykIdouUktk.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_YykIdouUktk.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }


        List<IT_BAK_YykIdouNaiyoHrhnk> bakYykIdouNaiyoHrhnkLst = new ArrayList<IT_BAK_YykIdouNaiyoHrhnk>();
        List<IT_YykIdouNaiyoHrhnk> yykIdouNaiyoHrhnkLst = pKykKihon.getYykIdouNaiyoHrhnks();
        if (pBakKykKihon != null) {
            bakYykIdouNaiyoHrhnkLst = pBakKykKihon.getBAKYykIdouNaiyoHrhnks();
        }

        TreeMap<String, IT_BAK_YykIdouNaiyoHrhnk> beforeBakYykIdouNaiyoHrhnkMap = new TreeMap<String, IT_BAK_YykIdouNaiyoHrhnk>();
        for (IT_BAK_YykIdouNaiyoHrhnk bakYykIdouNaiyoHrhnk : bakYykIdouNaiyoHrhnkLst) {
            String henkousikibetukey = bakYykIdouNaiyoHrhnk.getHenkousikibetukey();
            beforeBakYykIdouNaiyoHrhnkMap.put(syoNo + henkousikibetukey, bakYykIdouNaiyoHrhnk);
        }
        Set<String> beforeYykIdouNaiyoHrhnkKeyset = beforeBakYykIdouNaiyoHrhnkMap.keySet();

        TreeMap<String, IT_YykIdouNaiyoHrhnk> afterYykIdouNaiyoHrhnkMap = new TreeMap<String, IT_YykIdouNaiyoHrhnk>();
        for (IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk : yykIdouNaiyoHrhnkLst) {
            String henkousikibetukey = yykIdouNaiyoHrhnk.getHenkousikibetukey();
            afterYykIdouNaiyoHrhnkMap.put(syoNo + henkousikibetukey, yykIdouNaiyoHrhnk);
        }
        Set<String> afterYykIdouNaiyoHrhnkKeyset = afterYykIdouNaiyoHrhnkMap.keySet();

        List<String> yykIdouNaiyoHrhnkHenkouKeySet = getContainsKeyList(beforeYykIdouNaiyoHrhnkKeyset, afterYykIdouNaiyoHrhnkKeyset);
        for (String henkouKey : yykIdouNaiyoHrhnkHenkouKeySet) {
            IT_BAK_YykIdouNaiyoHrhnk bakYykIdouNaiyoHrhnk = beforeBakYykIdouNaiyoHrhnkMap.get(henkouKey);
            IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk = afterYykIdouNaiyoHrhnkMap.get(henkouKey);
            LinkedList<String[]> henkouKoumokuList = editHenkouList(bakYykIdouNaiyoHrhnk, yykIdouNaiyoHrhnk);
            if (henkouKoumokuList.size() != 0) {
                String hanbetuKoumokunm = "予約異動受付内容情報";
                editHenkouRrkTblEntityList(IT_YykIdouNaiyoHrhnk.TABLE_NAME,
                    ResourceUtil.getApplicationResources().getString(IT_YykIdouNaiyoHrhnk.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuKoumokunm,
                    henkouKoumokuList,
                    pKykKihon);
            }
        }

        List<String> yykIdouNaiyoHrhnkDeleteKeyLst = getNoContainsKeyList(beforeYykIdouNaiyoHrhnkKeyset, afterYykIdouNaiyoHrhnkKeyset);
        for (String deleteKey : yykIdouNaiyoHrhnkDeleteKeyLst) {
            IT_BAK_YykIdouNaiyoHrhnk bakYykIdouNaiyoHrhnk = beforeBakYykIdouNaiyoHrhnkMap.get(deleteKey);

            String hrkkaisuu = C_Hrkkaisuu.getContentByValue(bakYykIdouNaiyoHrhnk.getNewhrkkaisuu().getValue());
            String tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.getContentByValue(bakYykIdouNaiyoHrhnk.getNewtikiktbrisyuruikbn().getValue());

            String hanbetuKoumokunm = "予約異動受付内容情報";
            String[] henkouArray = {
                "",
                "",
                "",
                "効力発生日：" + bakYykIdouNaiyoHrhnk.getKouryokuhasseiymd() + "／" + hrkkaisuu + tkiktbrisyuruiKbn,
                "",
                ""
            };
            editHenkouRrkEntity(IT_YykIdouNaiyoHrhnk.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_YykIdouNaiyoHrhnk.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<String> yykIdouNaiyoHrhnkAddKeyLst = getNoContainsKeyList(afterYykIdouNaiyoHrhnkKeyset, beforeYykIdouNaiyoHrhnkKeyset);
        for (String addKey : yykIdouNaiyoHrhnkAddKeyLst) {
            IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk = afterYykIdouNaiyoHrhnkMap.get(addKey);

            String hrkkaisuu = C_Hrkkaisuu.getContentByValue(yykIdouNaiyoHrhnk.getNewhrkkaisuu().getValue());
            String tkiktbrisyuruiKbn = C_TkiktbrisyuruiKbn.getContentByValue(yykIdouNaiyoHrhnk.getNewtikiktbrisyuruikbn().getValue());

            String hanbetuKoumokunm = "予約異動受付内容情報";
            String newnaiyou = "";
            if (C_Hrkkeiro.BLNK.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {
                newnaiyou = "効力発生日：" + yykIdouNaiyoHrhnk.getKouryokuhasseiymd() + "／" +
                    hrkkaisuu + tkiktbrisyuruiKbn;
            }
            else if (C_Hrkkeiro.KOUHURI.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {
                String kzmeiginmkn = "";
                if (yykIdouNaiyoHrhnk.getKzmeiginmkn().length() > 18) {
                    kzmeiginmkn = yykIdouNaiyoHrhnk.getKzmeiginmkn().substring(18);
                }
                else {
                    kzmeiginmkn = yykIdouNaiyoHrhnk.getKzmeiginmkn();
                }

                newnaiyou = "効力発生日：" + yykIdouNaiyoHrhnk.getKouryokuhasseiymd() + "／" +
                    hrkkaisuu + tkiktbrisyuruiKbn + "／" + yykIdouNaiyoHrhnk.getNewhrkkeiro().getContent() + "／" +
                    yykIdouNaiyoHrhnk.getBankcd() + "／" + yykIdouNaiyoHrhnk.getSitencd() + "／" +
                    yykIdouNaiyoHrhnk.getYokinkbn().getContent() + "／" + yykIdouNaiyoHrhnk.getKouzano() + "／" +
                    kzmeiginmkn + "／" + yykIdouNaiyoHrhnk.getKzkykdoukbn().getContent();
            }
            else if (C_Hrkkeiro.CREDIT.eq(yykIdouNaiyoHrhnk.getNewhrkkeiro())) {
                newnaiyou = "効力発生日：" + yykIdouNaiyoHrhnk.getKouryokuhasseiymd() + "／" +
                    hrkkaisuu + tkiktbrisyuruiKbn + "／" + yykIdouNaiyoHrhnk.getNewhrkkeiro().getContent() + "／" +
                    yykIdouNaiyoHrhnk.getCreditkessaiyouno() + "／" + yykIdouNaiyoHrhnk.getCardbrandkbn().getContent() + "／" +
                    yykIdouNaiyoHrhnk.getCreditkaiinnosimo4keta();
            }
            String[] henkouArray = {
                "",
                "",
                "",
                "",
                "",
                newnaiyou
            };
            editHenkouRrkEntity(IT_YykIdouNaiyoHrhnk.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_YykIdouNaiyoHrhnk.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<IT_BAK_TrkKzk> itBakTrkkzkLst = new ArrayList<IT_BAK_TrkKzk>();
        List<IT_TrkKzk> trkKzkLst = pKykKihon.getTrkKzks();
        if (pBakKykKihon != null) {
            itBakTrkkzkLst = pBakKykKihon.getBAKTrkKzks();
        }

        TreeMap<String, IT_BAK_TrkKzk> beforeBakTrkKzkMap = new TreeMap<String, IT_BAK_TrkKzk>();
        for (IT_BAK_TrkKzk bakTrkKzk : itBakTrkkzkLst) {
            C_TrkKzkKbn trkKzkKbn = bakTrkKzk.getTrkkzkkbn();
            beforeBakTrkKzkMap.put(syoNo + trkKzkKbn, bakTrkKzk);
        }

        Set<String> beforeTrkKzkKeyset = beforeBakTrkKzkMap.keySet();

        TreeMap<String, IT_TrkKzk> afterTrkKzkMap = new TreeMap<String, IT_TrkKzk>();
        for (IT_TrkKzk trkKzk : trkKzkLst) {
            C_TrkKzkKbn trkKzkKbn = trkKzk.getTrkkzkkbn();
            afterTrkKzkMap.put(syoNo + trkKzkKbn, trkKzk);
        }

        Set<String> afterTrkKzkKeyset = afterTrkKzkMap.keySet();

        List<String> trkKzkKeySet = getContainsKeyList(beforeTrkKzkKeyset, afterTrkKzkKeyset);

        for (String henkouKey : trkKzkKeySet) {
            IT_BAK_TrkKzk bakTrkKzk = beforeBakTrkKzkMap.get(henkouKey);
            IT_TrkKzk trkKzk = afterTrkKzkMap.get(henkouKey);
            LinkedList<String[]> trkKzkList = editHenkouList(bakTrkKzk, trkKzk);

            if (trkKzkList.size() != 0) {
                String hanbetuKoumokunm = "登録家族情報（登録家族区分：" + bakTrkKzk.getTrkkzkkbn().getContent() + "）";
                editHenkouRrkTblEntityList(IT_TrkKzk.TABLE_NAME,
                    ResourceUtil.getApplicationResources().getString(IT_TrkKzk.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuKoumokunm,
                    trkKzkList,
                    pKykKihon);
            }
        }

        List<String> trkKzkDeleteKeyLst = getNoContainsKeyList(beforeTrkKzkKeyset, afterTrkKzkKeyset);
        for (String deleteKey : trkKzkDeleteKeyLst) {
            IT_BAK_TrkKzk bakTrkKzk = beforeBakTrkKzkMap.get(deleteKey);
            String hanbetuKoumokunm = "登録家族情報（登録家族区分：" + bakTrkKzk.getTrkkzkkbn().getContent() + "）";

            String trkkzkadrkj = bakTrkKzk.getTrkkzkadr1kj();
            if (!BizUtil.isBlank(bakTrkKzk.getTrkkzkadr2kj())) {
                trkkzkadrkj = trkkzkadrkj + "　" + bakTrkKzk.getTrkkzkadr2kj();
            }
            if (!BizUtil.isBlank(bakTrkKzk.getTrkkzkadr3kj())) {
                trkkzkadrkj = trkkzkadrkj + "　" + bakTrkKzk.getTrkkzkadr3kj();
            }

            String[] henkouArray = {
                "",
                "",
                "",
                "設定年月日：" + bakTrkKzk.getTrkkzksetteiymd() + "／" +
                    "氏名：" + bakTrkKzk.getTrkkzknmkj() +
                    "（契約者との関係：" + bakTrkKzk.getTrkkzktdk().getContent() + "）" + "／" +
                    "生年月日：" + bakTrkKzk.getTrkkzkseiymd() + "／" +
                    "性別：" + C_Seibetu.getContentByValue(C_Seibetu.PATTERN_NOHUMBLNK,
                        bakTrkKzk.getTrkkzksei().getValue()) + "／" +
                        "郵便番号：" + bakTrkKzk.getTrkkzkyno() + "／" +
                        "住所：" + trkkzkadrkj + "／" +
                        "電話番号：" + bakTrkKzk.getTrkkzktelno(),
                        "",
                        ""
            };

            editHenkouRrkEntity(IT_TrkKzk.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_TrkKzk.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<String> trkKzkAddKeyLst = getNoContainsKeyList(afterTrkKzkKeyset, beforeTrkKzkKeyset);
        for (String addKey : trkKzkAddKeyLst) {
            IT_TrkKzk trkKzk = afterTrkKzkMap.get(addKey);
            String hanbetuKoumokunm = "登録家族情報（登録家族区分：" + trkKzk.getTrkkzkkbn().getContent() + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "",
                "",
                "氏名：" + trkKzk.getTrkkzknmkj()
            };
            editHenkouRrkEntity(IT_TrkKzk.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_TrkKzk.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }


        List<IT_BAK_SyuunouHenknRireki> bakSyuunouHenknRirekiLst = new ArrayList<IT_BAK_SyuunouHenknRireki>();
        List<IT_SyuunouHenknRireki> syuunouHenknRirekiLst = pAnsyuKihon.getSyuunouHenknRirekis();
        if (pBakAnsyuKihon != null) {
            bakSyuunouHenknRirekiLst = pBakAnsyuKihon.getBAKSyuunouHenknRirekis();
        }

        TreeMap<String, IT_BAK_SyuunouHenknRireki> beforeBakSyuunouHenknRirekiMap = new TreeMap<String, IT_BAK_SyuunouHenknRireki>();
        for (IT_BAK_SyuunouHenknRireki bakSyuunouHenknRireki : bakSyuunouHenknRirekiLst) {
            String denrenno = bakSyuunouHenknRireki.getDenrenno();
            String edano = String.format("%02d", bakSyuunouHenknRireki.getEdano());
            beforeBakSyuunouHenknRirekiMap.put(syoNo + denrenno + edano, bakSyuunouHenknRireki);
        }
        Set<String> beforeSyuunouHenknRirekiKeyset = beforeBakSyuunouHenknRirekiMap.keySet();

        TreeMap<String, IT_SyuunouHenknRireki> afterSyuunouHenknRirekiMap = new TreeMap<String, IT_SyuunouHenknRireki>();
        for (IT_SyuunouHenknRireki syuunouHenknRireki : syuunouHenknRirekiLst) {
            String denrenno = syuunouHenknRireki.getDenrenno();
            String edano = String.format("%02d", syuunouHenknRireki.getEdano());
            afterSyuunouHenknRirekiMap.put(syoNo + denrenno + edano, syuunouHenknRireki);
        }
        Set<String> afterSyuunouHenknRirekiKeyset = afterSyuunouHenknRirekiMap.keySet();

        List<String> syuunouHenknRirekiHenkouKeySet = getContainsKeyList(beforeSyuunouHenknRirekiKeyset, afterSyuunouHenknRirekiKeyset);
        for (String henkouKey : syuunouHenknRirekiHenkouKeySet) {
            IT_BAK_SyuunouHenknRireki bakSyuunouHenknRireki = beforeBakSyuunouHenknRirekiMap.get(henkouKey);
            IT_SyuunouHenknRireki syuunouHenknRireki = afterSyuunouHenknRirekiMap.get(henkouKey);
            LinkedList<String[]> henkouKoumokuList = editHenkouList(bakSyuunouHenknRireki, syuunouHenknRireki);
            if (henkouKoumokuList.size() != 0) {
                String hanbetuKoumokunm = "収納返金履歴情報（伝票データ連番：" + bakSyuunouHenknRireki.getDenrenno() +
                    "　枝番号：" + bakSyuunouHenknRireki.getEdano() + "）";
                editHenkouRrkTblEntityList(IT_SyuunouHenknRireki.TABLE_NAME,
                    ResourceUtil.getApplicationResources().getString(IT_SyuunouHenknRireki.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuKoumokunm,
                    henkouKoumokuList,
                    pKykKihon);
            }
        }

        List<String> syuunouHenknRirekiDeleteKeyLst = getNoContainsKeyList(beforeSyuunouHenknRirekiKeyset, afterSyuunouHenknRirekiKeyset);
        for (String deleteKey : syuunouHenknRirekiDeleteKeyLst) {
            IT_BAK_SyuunouHenknRireki bakSyuunouHenknRireki = beforeBakSyuunouHenknRirekiMap.get(deleteKey);

            String shrriyuuKbn = C_ShrriyuuKbn.getContentByValue(bakSyuunouHenknRireki.getShrriyuukbn().getValue());
            String yokinKbn = C_YokinKbn.getContentByValue(bakSyuunouHenknRireki.getYokinkbn().getValue());

            String hanbetuKoumokunm = "収納返金履歴情報（伝票データ連番：" + bakSyuunouHenknRireki.getDenrenno() +
                "　枝番号：" + bakSyuunouHenknRireki.getEdano() + "）";
            String[] henkouArray = {
                "",
                "",
                "",
                "支払日：" + bakSyuunouHenknRireki.getShrymd() + "／" +
                    "返金額：" + bakSyuunouHenknRireki.getHnkngk() + "／" +
                    "理由：" + subString(shrriyuuKbn, 10) + "／" +
                    "銀行：" + bakSyuunouHenknRireki.getBankcd() + "／" +
                    "支店：" + bakSyuunouHenknRireki.getSitencd() + "／" +
                    subString(yokinKbn, 2) + "／" +
                    "口座番号：" + bakSyuunouHenknRireki.getKouzano() + "／" +
                    subString(bakSyuunouHenknRireki.getKzmeiginmkn(), 18),
                    "",
                    ""
            };
            editHenkouRrkEntity(IT_SyuunouHenknRireki.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_SyuunouHenknRireki.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        List<String> syuunouHenknRirekiAddKeyLst = getNoContainsKeyList(afterSyuunouHenknRirekiKeyset, beforeSyuunouHenknRirekiKeyset);
        for (String addKey : syuunouHenknRirekiAddKeyLst) {
            IT_SyuunouHenknRireki syuunouHenknRireki = afterSyuunouHenknRirekiMap.get(addKey);

            String shrriyuuKbn = C_ShrriyuuKbn.getContentByValue(syuunouHenknRireki.getShrriyuukbn().getValue());
            String yokinKbn = C_YokinKbn.getContentByValue(syuunouHenknRireki.getYokinkbn().getValue());

            String hanbetuKoumokunm = "収納返金履歴情報（伝票データ連番：" + syuunouHenknRireki.getDenrenno() +
                "　枝番号：" + syuunouHenknRireki.getEdano() + "）";
            String syuunouHenknRirekiHenkouNaiyou = "";
            if (BizUtil.isBlank(syuunouHenknRireki.getCreditkessaiyouno())) {
                syuunouHenknRirekiHenkouNaiyou = "支払日：" + syuunouHenknRireki.getShrymd() + "／" +
                    "返金額：" + syuunouHenknRireki.getHnkngk() + "／" +
                    "理由：" + subString(shrriyuuKbn, 10) + "／" +
                    "銀行：" + syuunouHenknRireki.getBankcd() + "／" +
                    "支店：" + syuunouHenknRireki.getSitencd() + "／" +
                    subString(yokinKbn, 2) + "／" +
                    "口座番号：" + syuunouHenknRireki.getKouzano() + "／" +
                    subString(syuunouHenknRireki.getKzmeiginmkn(), 18);
            }
            else {
                syuunouHenknRirekiHenkouNaiyou = "支払日：" + syuunouHenknRireki.getShrymd() + "／" +
                    "返金額：" + syuunouHenknRireki.getHnkngk() + "／" +
                    "理由：" + subString(shrriyuuKbn, 10) + "／" +
                    "クレカ決済用番号："+ syuunouHenknRireki.getCreditkessaiyouno();
            }
            String[] henkouArray = {"","","","","",syuunouHenknRirekiHenkouNaiyou};
            editHenkouRrkEntity(IT_SyuunouHenknRireki.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_SyuunouHenknRireki.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKykKihon);
        }

        IT_BAK_KhTtdkTyuui bakKhTtdkTyuui = null;
        IT_KhTtdkTyuui khTtdkTyuui = pKykKihon.getKhTtdkTyuui();
        if (pBakKykKihon != null) {
            bakKhTtdkTyuui = pBakKykKihon.getBAKKhTtdkTyuui();
        }
        String khTtdkTyuuiTblNm = ResourceUtil.getApplicationResources().getString(IT_KhTtdkTyuui.TABLE_NAME);
        String khTtdkTyuuiHanbetuNm = khTtdkTyuuiTblNm.replaceAll("テーブル", "情報");

        if (bakKhTtdkTyuui == null && khTtdkTyuui != null) {
            String kktyuitakbn = C_KktyuitaKbn.getContentByValue(C_KktyuitaKbn.PATTERN_SELECT, khTtdkTyuui.getKktyuitakbn().getValue());
            String[] henkouArray = {"","","","","",
                "手続注意設定日：" + khTtdkTyuui.getTtdktyuuisetymd() + "／" +
                    "手続注意設定者名：" + khTtdkTyuui.getTtdktyuuisetnm() + "／" +
                    "契約管理注意取扱区分：" + kktyuitakbn};
            editHenkouRrkEntity(IT_KhTtdkTyuui.TABLE_NAME ,khTtdkTyuuiTblNm, C_HnkSyuruiKbn.TUIKA,
                khTtdkTyuuiHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakKhTtdkTyuui != null && khTtdkTyuui == null) {
            String kktyuitakbn = C_KktyuitaKbn.getContentByValue(C_KktyuitaKbn.PATTERN_SELECT, bakKhTtdkTyuui.getKktyuitakbn().getValue());
            String ttdktyuuikbn1 = C_TtdktyuuiKbn.getContentByValue(bakKhTtdkTyuui.getTtdktyuuikbn1().getValue());
            String ttdktyuuikbn2 = C_TtdktyuuiKbn.getContentByValue(bakKhTtdkTyuui.getTtdktyuuikbn2().getValue());
            String ttdktyuuikbn3 = C_TtdktyuuiKbn.getContentByValue(bakKhTtdkTyuui.getTtdktyuuikbn3().getValue());
            String ttdktyuuikbn4 = C_TtdktyuuiKbn.getContentByValue(bakKhTtdkTyuui.getTtdktyuuikbn4().getValue());
            String ttdktyuuikbn5 = C_TtdktyuuiKbn.getContentByValue(bakKhTtdkTyuui.getTtdktyuuikbn5().getValue());

            String setSosikiCd1 = bakKhTtdkTyuui.getSetsosikicd1();

            String setSosikiCd2 = bakKhTtdkTyuui.getSetsosikicd2();

            String setSosikiCd3 = bakKhTtdkTyuui.getSetsosikicd3();

            String setSosikiCd4 = bakKhTtdkTyuui.getSetsosikicd4();

            String setSosikiCd5 = bakKhTtdkTyuui.getSetsosikicd5();

            String[] henkouArray = {"","","",
                "手続注意設定日：" + bakKhTtdkTyuui.getTtdktyuuisetymd() + "／" +
                    "手続注意設定者名：" + bakKhTtdkTyuui.getTtdktyuuisetnm() + "／" +
                    "契約管理注意取扱区分：" + kktyuitakbn + "／" +
                    "手続注意内容１：" + bakKhTtdkTyuui.getTtdktyuuinaiyou1() + "／" +
                    "手続注意内容２：" + bakKhTtdkTyuui.getTtdktyuuinaiyou2() + "／" +
                    "手続注意内容３：" + bakKhTtdkTyuui.getTtdktyuuinaiyou3() + "／" +
                    "手続注意区分１：" + ttdktyuuikbn1 +  "　" +
                    bakKhTtdkTyuui.getTtdktyuuikbnhsknaiyou1() + "　設定日：" +
                    bakKhTtdkTyuui.getTtdktyuuikbnsetymd1() + "　設定組織コード１：" +
                    setSosikiCd1 + "／" +
                    "手続注意区分２：" + ttdktyuuikbn2 +  "　" +
                    bakKhTtdkTyuui.getTtdktyuuikbnhsknaiyou2() + "　設定日：" +
                    bakKhTtdkTyuui.getTtdktyuuikbnsetymd2() + "　設定組織コード２：" +
                    setSosikiCd2 + "／" +
                    "手続注意区分３：" + ttdktyuuikbn3 +  "　" +
                    bakKhTtdkTyuui.getTtdktyuuikbnhsknaiyou3() + "　設定日：" +
                    bakKhTtdkTyuui.getTtdktyuuikbnsetymd3() + "　設定組織コード３：" +
                    setSosikiCd3 + "／" +
                    "手続注意区分４：" + ttdktyuuikbn4 +  "　" +
                    bakKhTtdkTyuui.getTtdktyuuikbnhsknaiyou4() + "　設定日：" +
                    bakKhTtdkTyuui.getTtdktyuuikbnsetymd4() + "　設定組織コード４：" +
                    setSosikiCd4 + "／" +
                    "手続注意区分５：" + ttdktyuuikbn5 +  "　" +
                    bakKhTtdkTyuui.getTtdktyuuikbnhsknaiyou5() + "　設定日：" +
                    bakKhTtdkTyuui.getTtdktyuuikbnsetymd5()+ "　設定組織コード５：" +
                    setSosikiCd5,
                    "",""};
            editHenkouRrkEntity(IT_KhTtdkTyuui.TABLE_NAME, khTtdkTyuuiTblNm, C_HnkSyuruiKbn.SAKUJYO,
                khTtdkTyuuiHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakKhTtdkTyuui != null && khTtdkTyuui != null) {
            LinkedList<String[]> henkouList = editHenkouList(bakKhTtdkTyuui, khTtdkTyuui);

            if (henkouList.size() != 0) {
                editHenkouRrkTblEntityList(IT_KhTtdkTyuui.TABLE_NAME, khTtdkTyuuiTblNm, C_HnkSyuruiKbn.HENKOU,
                    khTtdkTyuuiHanbetuNm, henkouList, pKykKihon);
            }
        }

        IT_BAK_Kouza bakKouza = null;
        IT_Kouza kouza = pKykKihon.getKouza();
        if (pBakKykKihon != null) {
            bakKouza = pBakKykKihon.getBAKKouza();
        }
        String kouzaTblNm = ResourceUtil.getApplicationResources().getString(IT_Kouza.TABLE_NAME);
        String kouzaHanbetuNm = kouzaTblNm.replaceAll("テーブル", "情報");

        if (bakKouza == null && kouza != null) {
            String yokinkbn = C_YokinKbn.getContentByValue(kouza.getYokinkbn().getValue());
            String kzkykdouKbn = C_KzkykdouKbn.getContentByValue(kouza.getKzkykdoukbn().getValue());
            String[] henkouArray = {"","","","","",
                "銀行コード：" + kouza.getBankcd() + "／" +
                    "支店コード：" + kouza.getSitencd() + "／" +
                    "預金種目区分：" + yokinkbn + "／" +
                    "口座番号：" + kouza.getKouzano() + "／" +
                    "口座名義人氏名（カナ）：" + subString(kouza.getKzmeiginmkn(), 18) + "／" +
                    "契約者同一区分：" + kzkykdouKbn};
            editHenkouRrkEntity(IT_Kouza.TABLE_NAME ,kouzaTblNm, C_HnkSyuruiKbn.TUIKA,
                kouzaHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakKouza != null && kouza == null) {
            String yokinkbn = C_YokinKbn.getContentByValue(bakKouza.getYokinkbn().getValue());
            String kzkykdouKbn = C_KzkykdouKbn.getContentByValue(bakKouza.getKzkykdoukbn().getValue());
            String[] henkouArray = {"","","",
                "銀行コード：" + bakKouza.getBankcd() + "／" +
                    "支店コード：" + bakKouza.getSitencd() + "／" +
                    "預金種目区分：" + yokinkbn + "／" +
                    "口座番号：" + bakKouza.getKouzano() + "／" +
                    "口座名義人氏名（カナ）：" + subString(bakKouza.getKzmeiginmkn(), 18) + "／" +
                    "契約者同一区分：" + kzkykdouKbn,
                    "",""};
            editHenkouRrkEntity(IT_Kouza.TABLE_NAME ,kouzaTblNm, C_HnkSyuruiKbn.SAKUJYO,
                kouzaHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakKouza != null && kouza != null) {
            LinkedList<String[]> henkouList = editHenkouList(bakKouza, kouza);

            if (henkouList.size() != 0) {
                editHenkouRrkTblEntityList(IT_Kouza.TABLE_NAME, kouzaTblNm, C_HnkSyuruiKbn.HENKOU,
                    kouzaHanbetuNm, henkouList, pKykKihon);
            }
        }

        IT_BAK_CreditCardInfo bakCreditCardInfo = null;
        IT_CreditCardInfo creditCardInfo = pKykKihon.getCreditCardInfo();
        if (pBakKykKihon != null) {
            bakCreditCardInfo = pBakKykKihon.getBAKCreditCardInfo();
        }
        String creditCardInfoTblNm = ResourceUtil.getApplicationResources().getString(IT_CreditCardInfo.TABLE_NAME);
        String creditCardInfoHanbetuNm = "クレジットカード情報";
        if (bakCreditCardInfo == null && creditCardInfo != null) {
            String newnaiyou = "決済用番号：" + creditCardInfo.getCreditkessaiyouno();
            String[] henkouArray = {"","","","","",newnaiyou};
            editHenkouRrkEntity(IT_CreditCardInfo.TABLE_NAME ,creditCardInfoTblNm, C_HnkSyuruiKbn.TUIKA,
                creditCardInfoHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakCreditCardInfo != null && creditCardInfo == null) {
            String bfrnaiyou = "決済用番号：" + bakCreditCardInfo.getCreditkessaiyouno() + "／" +
                "クレジット有効確認年月：" + bakCreditCardInfo.getCredityuukoukakym() + "／" +
                "クレジット有効確認結果：" + bakCreditCardInfo.getCredityuukoukakkekka().getContent();
            String[] henkouArray = {"","","",bfrnaiyou,"",""};
            editHenkouRrkEntity(IT_CreditCardInfo.TABLE_NAME ,creditCardInfoTblNm, C_HnkSyuruiKbn.SAKUJYO,
                creditCardInfoHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakCreditCardInfo != null && creditCardInfo != null) {
            LinkedList<String[]> henkouList = editHenkouList(bakCreditCardInfo, creditCardInfo);
            if (henkouList.size() != 0) {
                editHenkouRrkTblEntityList(IT_CreditCardInfo.TABLE_NAME, creditCardInfoTblNm, C_HnkSyuruiKbn.HENKOU,
                    creditCardInfoHanbetuNm, henkouList, pKykKihon);
            }
        }

        IT_BAK_Tokusin bakTokusin = null;
        IT_Tokusin tokusin = pAnsyuKihon.getTokusin();
        if (pBakAnsyuKihon != null) {
            bakTokusin = pBakAnsyuKihon.getBAKTokusin();
        }
        String tokusinTblNm = ResourceUtil.getApplicationResources().getString(IT_Tokusin.TABLE_NAME);
        String tokusinHanbetuNm = tokusinTblNm.replaceAll("テーブル", "情報");

        if (bakTokusin == null && tokusin != null) {
            String tokusinkbn = C_TokusinKbn.getContentByValue(tokusin.getTokusinkbn().getValue());
            String tokusinHenkouNaiyou = "";
            if (C_TokusinKbn.HISAIGAI.eq(tokusin.getTokusinkbn())) {
                tokusinHenkouNaiyou = "特伸区分：" + tokusinkbn + "／" +
                    "特伸処理年月日：" + tokusin.getTokusinsyoriymd() + "／" +
                    "特伸終了年月日：" + tokusin.getTokusinendymd() + "／" +
                    "被災害年月日：" + tokusin.getHsgymd();
            }
            else {
                tokusinHenkouNaiyou = "特伸区分：" + tokusinkbn + "／" +
                    "特伸処理年月日：" + tokusin.getTokusinsyoriymd() + "／" +
                    "特伸終了年月日：" + tokusin.getTokusinendymd();
            }

            String[] henkouArray = {"","","","","",tokusinHenkouNaiyou};
            editHenkouRrkEntity(IT_Tokusin.TABLE_NAME ,tokusinTblNm, C_HnkSyuruiKbn.TUIKA,
                tokusinHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakTokusin != null && tokusin == null) {
            String tokusinkbn = C_TokusinKbn.getContentByValue(bakTokusin.getTokusinkbn().getValue());
            String tokusinHenkouNaiyou = "";
            if (C_TokusinKbn.HISAIGAI.eq(bakTokusin.getTokusinkbn())) {
                tokusinHenkouNaiyou = "特伸区分：" + tokusinkbn + "／" +
                    "特伸処理年月日：" + bakTokusin.getTokusinsyoriymd() + "／" +
                    "特伸終了年月日：" + bakTokusin.getTokusinendymd() + "／" +
                    "被災害年月日：" + bakTokusin.getHsgymd();
            }
            else {
                tokusinHenkouNaiyou = "特伸区分：" + tokusinkbn + "／" +
                    "特伸処理年月日：" + bakTokusin.getTokusinsyoriymd() + "／" +
                    "特伸終了年月日：" + bakTokusin.getTokusinendymd();
            }

            String[] henkouArray = {"","","",tokusinHenkouNaiyou,"",""};
            editHenkouRrkEntity(IT_Tokusin.TABLE_NAME ,tokusinTblNm, C_HnkSyuruiKbn.SAKUJYO,
                tokusinHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakTokusin != null && tokusin != null) {
            LinkedList<String[]> henkouList = editHenkouList(bakTokusin, tokusin);
            if (henkouList.size() != 0) {
                editHenkouRrkTblEntityList(IT_Tokusin.TABLE_NAME, tokusinTblNm, C_HnkSyuruiKbn.HENKOU,
                    tokusinHanbetuNm, henkouList, pKykKihon);
            }
        }

        IT_BAK_TeikikinKouza bakTeikikinKouza = null;
        IT_TeikikinKouza teikikinKouza = pKykKihon.getTeikikinKouza();
        if (pBakKykKihon != null) {
            bakTeikikinKouza = pBakKykKihon.getBAKTeikikinKouza();
        }

        String teikikinKouzaTblNm = ResourceUtil.getApplicationResources().getString(IT_TeikikinKouza.TABLE_NAME);
        String teikikinKouzaHanbetuNm = teikikinKouzaTblNm.replaceAll("テーブル", "情報");

        if (bakTeikikinKouza == null && teikikinKouza != null) {
            String yokinKbn = C_YokinKbn.getContentByValue(teikikinKouza.getYokinkbn().getValue());

            String kouzaSyuruiKbn = C_KouzasyuruiKbn.getContentByValue(teikikinKouza.getKzsyuruikbn().getValue());

            String henkouItem5 = "口座種類区分：" + kouzaSyuruiKbn + "／" + "銀行コード：" + teikikinKouza.getBankcd() + "／"
                + "支店コード：" + teikikinKouza.getSitencd() + "／" + "預金種目区分：" + yokinKbn + "／"
                + "口座番号：" + teikikinKouza.getKouzano() + "／" + "口座名義人氏名（カナ）：" + teikikinKouza.getKzmeiginmkn();

            String[] henkouArray = {"","","","","",henkouItem5};

            editHenkouRrkEntity(IT_TeikikinKouza.TABLE_NAME ,teikikinKouzaTblNm, C_HnkSyuruiKbn.TUIKA,
                teikikinKouzaHanbetuNm, henkouArray, pKykKihon);
        }

        if (bakTeikikinKouza != null && teikikinKouza == null) {
            String yokinKbn = C_YokinKbn.getContentByValue(bakTeikikinKouza.getYokinkbn().getValue());

            String kouzaSyuruiKbn = C_KouzasyuruiKbn.getContentByValue(bakTeikikinKouza.getKzsyuruikbn().getValue());

            String henkouItem3 = "口座種類区分：" + kouzaSyuruiKbn + "／" + "銀行コード：" + bakTeikikinKouza.getBankcd() + "／"
                + "支店コード：" + bakTeikikinKouza.getSitencd() + "／" + "預金種目区分：" + yokinKbn + "／"
                + "口座番号：" + bakTeikikinKouza.getKouzano() + "／" + "口座名義人氏名（カナ）：" + bakTeikikinKouza.getKzmeiginmkn();

            String[] henkouArray = {"","","",henkouItem3,"",""};

            editHenkouRrkEntity(IT_TeikikinKouza.TABLE_NAME ,teikikinKouzaTblNm, C_HnkSyuruiKbn.SAKUJYO,
                teikikinKouzaHanbetuNm, henkouArray, pKykKihon);
        }

        if (bakTeikikinKouza != null && teikikinKouza != null) {
            LinkedList<String[]> henkouList = editHenkouList(bakTeikikinKouza, teikikinKouza);
            if (henkouList.size() != 0) {
                editHenkouRrkTblEntityList(IT_TeikikinKouza.TABLE_NAME, teikikinKouzaTblNm, C_HnkSyuruiKbn.HENKOU,
                    teikikinKouzaHanbetuNm, henkouList, pKykKihon);
            }
        }

        IT_BAK_DattaiUktk bakDattaiUktk = null;
        IT_DattaiUktk dattaiUktk = pAnsyuKihon.getDattaiUktk();
        if (pBakAnsyuKihon != null) {
            bakDattaiUktk = pBakAnsyuKihon.getBAKDattaiUktk();
        }
        String dattaiUktkTblNm = ResourceUtil.getApplicationResources().getString(IT_DattaiUktk.TABLE_NAME);
        String dattaiUktkHanbetuNm = dattaiUktkTblNm.replaceAll("テーブル", "情報");

        if (bakDattaiUktk == null && dattaiUktk != null) {
            String[] henkouArray = {"","","","","",""};
            editHenkouRrkEntity(IT_DattaiUktk.TABLE_NAME ,dattaiUktkTblNm, C_HnkSyuruiKbn.TUIKA,
                dattaiUktkHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakDattaiUktk != null && dattaiUktk == null) {
            String dattairiyuuKbn = C_DattairiyuuKbn.getContentByValue(bakDattaiUktk.getDattairiyuukbn().getValue());
            String[] henkouArray = {"","","",
                "脱退理由区分：" + dattairiyuuKbn + "／" + "コメント：" +
                    bakDattaiUktk.getComment124keta().replaceAll("\r\n", "／").replaceAll("\r", "／").replaceAll("\n", "／"),
                    "",""};
            editHenkouRrkEntity(IT_DattaiUktk.TABLE_NAME ,dattaiUktkTblNm, C_HnkSyuruiKbn.SAKUJYO,
                dattaiUktkHanbetuNm, henkouArray, pKykKihon);
        }
        if (bakDattaiUktk != null && dattaiUktk != null) {
            LinkedList<String[]> henkouList = editHenkouList(bakDattaiUktk, dattaiUktk);
            if (henkouList.size() != 0) {
                editHenkouRrkTblEntityList(IT_DattaiUktk.TABLE_NAME, dattaiUktkTblNm, C_HnkSyuruiKbn.HENKOU,
                    dattaiUktkHanbetuNm, henkouList, pKykKihon);
            }
        }
        return henkouRirekiList;
    }


    private LinkedList<String[]> editHenkouList(ExDBEntity<?,?> pBeforeEntity, ExDBEntity<?,?> pAfterEntity) {

        LinkedList<String[]> henkouKoumokuList = new LinkedList<String[]>();
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();

        try {
            ExDBEntity<?,?> deffEntity = pAfterEntity.getClass().newInstance();
            Set<String> deffKoumokuIdSet = EntityUtil.diffEntitys(pBeforeEntity, pAfterEntity, deffEntity);
            for (String deffKoumokuId:deffKoumokuIdSet ) {

                if (deffKoumokuId.equals(IT_KykKihon.SYONO) || deffKoumokuId.equals(IT_KykSyouhn.HENKOUSIKIBETUKEY) ||
                    deffKoumokuId.equals(IT_KykKihon.GYOUMUKOUSINKINOU) || deffKoumokuId.equals(IT_KykKihon.GYOUMUKOUSINSYAID) ||
                    deffKoumokuId.equals(IT_KykKihon.GYOUMUKOUSINTIME) || deffKoumokuId.equals(IT_KykKihon.KOUSINKINOU) ||
                    deffKoumokuId.equals(IT_KykKihon.KOUSINSYAID) || deffKoumokuId.equals(IT_KykKihon.KOUSINTIME) ||
                    deffKoumokuId.equals(IT_KykKihon.VERSION)) {
                    continue;
                }

                String koumokuName = ((AbstractExDBEntity<?,?>)pAfterEntity).getFieldViewName(deffKoumokuId);
                Object beforeObject = propertyUtilsBean.getSimpleProperty(pBeforeEntity,deffKoumokuId);
                Object afterObject = propertyUtilsBean.getSimpleProperty(pAfterEntity,deffKoumokuId);
                String beforeValue = "";
                String beforeKbnValue = "";
                String afterValue = "";
                String afterKbnValue = "";

                if (beforeObject != null) {
                    beforeValue = beforeObject.toString();
                    if (deffKoumokuId.equals(IT_KhTtdkTyuui.KKTYUITAKBN)) {
                        beforeKbnValue = ((Classification<?>)beforeObject).getContent(C_KktyuitaKbn.PATTERN_SELECT);
                    }
                    else if (deffKoumokuId.equals(IT_KhTtdkTyuui.KYKDRKNHATUDOUJYOUTAI)) {
                        beforeKbnValue = ((Classification<?>)beforeObject).getContent(C_KykdrknHtdjytKbn.PATTERN_SELECT);
                    }
                    else if (deffKoumokuId.equals(IT_KhTtdkTyuui.KYKDRDOUIYOUHI)) {
                        beforeKbnValue = ((Classification<?>)beforeObject).getContent(C_KykdrDouiYouhiKbn.PATTERN_SELECT);
                    }
                    else if (beforeObject instanceof Classification) {
                        beforeKbnValue = ((Classification<?>)beforeObject).getContent();
                    }
                    else {
                        beforeKbnValue = beforeObject.toString();
                    }
                }
                if (afterObject != null) {
                    afterValue = afterObject.toString();
                    if (deffKoumokuId.equals(IT_KhTtdkTyuui.KKTYUITAKBN)) {
                        afterKbnValue = ((Classification<?>)afterObject).getContent(C_KktyuitaKbn.PATTERN_SELECT);
                    }
                    else if (deffKoumokuId.equals(IT_KhTtdkTyuui.KYKDRKNHATUDOUJYOUTAI)) {
                        afterKbnValue = ((Classification<?>)afterObject).getContent(C_KykdrknHtdjytKbn.PATTERN_SELECT);
                    }
                    else if (deffKoumokuId.equals(IT_KhTtdkTyuui.KYKDRDOUIYOUHI)) {
                        afterKbnValue = ((Classification<?>)afterObject).getContent(C_KykdrDouiYouhiKbn.PATTERN_SELECT);
                    }
                    else if (afterObject instanceof Classification) {
                        afterKbnValue = ((Classification<?>)afterObject).getContent();
                    }
                    else {
                        afterKbnValue = afterObject.toString();
                    }
                }

                String[] henkouKoumoku = new String[]{deffKoumokuId, koumokuName, beforeValue, beforeKbnValue, afterValue, afterKbnValue};
                henkouKoumokuList.add(henkouKoumoku);
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return henkouKoumokuList;
    }

    private void editHenkouRrkTblEntityList(String pTableId, String pTableName, C_HnkSyuruiKbn pHnkSyuruiKbn,
        String pHanbetu, LinkedList<String[]> pHenkouList, IT_KykKihon pKykKihon) {

        if (pHenkouList == null) {
            editHenkouRrkEntity(pTableId, pTableName, pHnkSyuruiKbn, pHanbetu, null, pKykKihon);
        }
        else {
            for (String[] henkouArray : pHenkouList) {
                editHenkouRrkEntity(pTableId, pTableName, pHnkSyuruiKbn, pHanbetu, henkouArray, pKykKihon);
            }
        }
    }

    private void editHenkouRrkEntity(String pTableId, String pTableName, C_HnkSyuruiKbn pHnkSyuruiKbn,
        String pHanbetu, String[] pHenkouArray, IT_KykKihon pKykKihon) {

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey);

        IT_KhHenkouRireki khHenkouRireki = khTtdkRireki.createKhHenkouRireki();

        khHenkouRireki.setRenno3keta(renNo++);
        khHenkouRireki.setTablenm(pTableName);
        khHenkouRireki.setTableid(pTableId);
        khHenkouRireki.setHnksyuruikbn(pHnkSyuruiKbn);
        khHenkouRireki.setHanbetukoumokunm(pHanbetu);

        if (pHenkouArray != null) {
            khHenkouRireki.setHenkoukoumokuid(pHenkouArray[0]);
            khHenkouRireki.setHenkoukoumokunm(pHenkouArray[1]);
            khHenkouRireki.setBfrnaiyouoriginal(pHenkouArray[2]);
            khHenkouRireki.setBfrnaiyou(pHenkouArray[3]);
            khHenkouRireki.setNewnaiyouoriginal(pHenkouArray[4]);
            khHenkouRireki.setNewnaiyou(pHenkouArray[5]);
        }
        else {
            khHenkouRireki.setHenkoukoumokuid("");
            khHenkouRireki.setHenkoukoumokunm("");
            khHenkouRireki.setBfrnaiyouoriginal("");
            khHenkouRireki.setBfrnaiyou("");
            khHenkouRireki.setNewnaiyouoriginal("");
            khHenkouRireki.setNewnaiyou("");
        }

        khHenkouRireki.setGyoumuKousinKinou(kinouId);
        khHenkouRireki.setGyoumuKousinsyaId(userId);
        khHenkouRireki.setGyoumuKousinTime(sysTime);

        henkouRirekiList.add(khHenkouRireki);
    }

    private List<String> getContainsKeyList(Set<String> pKeySet1, Set<String> pKeySet2) {
        List<String> containsKeyList = new ArrayList<String>();
        for(String key : pKeySet1) {
            if(pKeySet2.contains(key)) {
                containsKeyList.add(key);
            }
        }
        return containsKeyList;
    }

    private List<String>  getNoContainsKeyList(Set<String> pKeySet1, Set<String> pKeySet2) {
        List<String> noContainsKeySet = new ArrayList<String>();
        for(String key : pKeySet1) {
            if(!pKeySet2.contains(key)) {
                noContainsKeySet.add(key);
            }
        }
        return noContainsKeySet;
    }
    private String subString(String pMojiretu, int pMaxIndex) {

        String mojiretu = pMojiretu;

        if(mojiretu.length() >= pMaxIndex){

            mojiretu = mojiretu.substring(0, pMaxIndex);
        }

        return mojiretu;
    }

    private String convertNullToBlank(Object pObj) {
        return Objects.toString(pObj, "");
    }

}
